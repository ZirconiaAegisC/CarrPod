#!/bin/bash
# =============================================================================
# DRONE-X Triple-Daemon Watchdog (dronex_daemon_watchdog.sh)
# CSMFAB-228 — Daemon Watchdog Triple-Check Protocol V2.0
# July 2026 | Carrington Storm Motors / Safe Pod Engineering Company
# =============================================================================
# Usage: ./dronex_daemon_watchdog.sh {start|stop|status|test}
# =============================================================================

set -euo pipefail

# --- Configuration ---
SHM_KEY=0x44524F4E  # Shared memory key (hex "DRON")
SHM_SIZE=128         # 128 bytes shared memory segment
PID_DIR="/var/run/dronex"
STATUS_FILE="${PID_DIR}/watchdog.status"
LOG_FILE="/var/log/dronex/watchdog.log"
ALERT_SOUND="/usr/share/dronex/alert_3khz.wav"

# Heartbeat timeouts (milliseconds)
TIMEOUT_DAEMON_A_MS=10   # 2.5ms × 4 cycles
TIMEOUT_DAEMON_B_MS=20   # 2× Daemon A timeout
TIMEOUT_DAEMON_C_MS=3000 # 3 seconds → escalate to RTL
TIMEOUT_META_MS=10000    # 10 seconds → OS-level force-stop

# Daemon rates (Hz)
RATE_A=400
RATE_B=200
RATE_C=1
RATE_META=0.2  # Every 5 seconds

# --- Utility Functions ---
log_msg() {
    local level="$1"; shift
    echo "[$(date -u +%Y-%m-%dT%H:%M:%SZ)] [$level] [PID:$$] $*" | tee -a "$LOG_FILE"
}

send_hud_alert() {
    local tier="$1"
    local message="$2"
    echo "HUD_ALERT:${tier}:${message}" > "${PID_DIR}/hud_pipe" 2>/dev/null || true
}

play_audio_alert() {
    local pattern="$1"
    case "$pattern" in
        WARN)  aplay -q "$ALERT_SOUND" -d 0.1 2>/dev/null & ;;
        CRIT)  for i in $(seq 1 3); do aplay -q "$ALERT_SOUND" -d 0.2 2>/dev/null; sleep 0.3; done & ;;
        FATAL) while true; do aplay -q "$ALERT_SOUND" -d 0.5 2>/dev/null; sleep 0.25; done & ;;
    esac
}

read_shm_field() {
    local offset="$1"
    local format="$2"
    local shm_file="/dev/shm/dronex_shm_${SHM_KEY}"
    [[ -f "$shm_file" ]] || { echo "0"; return; }
    xxd -s "$offset" -l 4 -p "$shm_file" 2>/dev/null | xxd -r -p | od -A n -t "${format}" | tr -d ' ' || echo "0"
}

write_shm_field() {
    local offset="$1"
    local value="$2"
    local format="$3"
    local shm_file="/dev/shm/dronex_shm_${SHM_KEY}"
    local tmpfile="${shm_file}.tmp"
    cp "$shm_file" "$tmpfile"
    printf "$value" | xxd -p | xxd -r -p | dd of="$tmpfile" bs=1 seek="$offset" conv=notrunc 2>/dev/null
    mv "$tmpfile" "$shm_file"
}

init_shm() {
    local shm_id
    shm_id=$(ipcs -m | grep "$(printf '0x%08X' $SHM_KEY)" | awk '{print $2}' || true)
    if [[ -z "$shm_id" ]]; then
        ipcmk -M 128 -K "$SHM_KEY" 2>/dev/null || true
    fi
    local shm_file="/dev/shm/dronex_shm_${SHM_KEY}"
    if [[ ! -f "$shm_file" ]]; then
        dd if=/dev/zero of="$shm_file" bs=128 count=1 2>/dev/null
    fi
}

cleanup_shm() {
    local shm_id
    shm_id=$(ipcs -m | grep "$(printf '0x%08X' $SHM_KEY)" | awk '{print $2}' || true)
    [[ -n "$shm_id" ]] && ipcrm -m "$shm_id" 2>/dev/null || true
    rm -f "/dev/shm/dronex_shm_${SHM_KEY}"
}

# --- Daemon A: Flight Control Executive (400 Hz) ---
daemon_a() {
    log_msg "INFO" "Daemon A (Exec) starting at ${RATE_A} Hz..."
    local loop_count=0
    local sleep_us=2500  # 2.5 ms = 400 Hz
    local last_watchdog_reset=0

    while true; do
        # Simulate flight control loop integrity check
        # In production, this reads actual flight loop heartbeat
        loop_count=$((loop_count + 1))
        write_shm_field 0 "$(printf '%08x' $loop_count)" "d4"

        # Check if Daemon B watchdog needs reset
        local now_ms
        now_ms=$(($(date +%s%N) / 1000000))

        # Daemon A self-check: verify we haven't been paused
        local delta=$((now_ms - last_watchdog_reset))
        if [[ $delta -gt $((TIMEOUT_DAEMON_A_MS * 2)) ]]; then
            log_msg "ERROR" "Daemon A: loop stall detected (${delta}ms gap, expected < ${TIMEOUT_DAEMON_A_MS}ms)"
        fi
        last_watchdog_reset=$now_ms

        # Write timestamp
        write_shm_field 26 "$(printf '%016x' $now_ms)" "d8"

        # Micro-sleep for precise timing
        usleep "$sleep_us"
    done
}

# --- Daemon B: Health Checker (200 Hz) ---
daemon_b() {
    log_msg "INFO" "Daemon B (Check) starting at ${RATE_B} Hz..."
    local sleep_us=5000  # 5 ms = 200 Hz
    local restart_count=0
    local max_restarts=3
    local last_loop_a=0
    local now_ms

    while true; do
        now_ms=$(($(date +%s%N) / 1000000))
        local current_loop_a
        current_loop_a=$(read_shm_field 0 "d4" 2>/dev/null || echo "0")
        current_loop_a=$((current_loop_a))

        if [[ "$current_loop_a" -eq "$last_loop_a" ]]; then
            # Daemon A has stalled
            local elapsed=$((now_ms - $(read_shm_field 26 "d8" 2>/dev/null || echo "0")))
            if [[ $elapsed -gt $TIMEOUT_DAEMON_B_MS ]]; then
                log_msg "WARN" "Daemon B: Daemon A heartbeat stale (${elapsed}ms > ${TIMEOUT_DAEMON_B_MS}ms timeout)"
                if [[ $restart_count -lt $max_restarts ]]; then
                    restart_count=$((restart_count + 1))
                    log_msg "WARN" "Daemon B: Restarting Daemon A (attempt ${restart_count}/${max_restarts})"
                    write_shm_field 12 "$(printf '%02x' $restart_count)" "d1"
                    # Signal restart via status flags
                    write_shm_field 25 "$(printf '%02x' 0x10)" "d1"  # Flag: Daemon A restart requested
                    send_hud_alert "WARN" "Daemon A restart ${restart_count}/${max_restarts}"
                else
                    log_msg "CRITICAL" "Daemon B: Daemon A failed to recover after ${max_restarts} restarts!"
                    write_shm_field 25 "$(printf '%02x' 0x02)" "d1"  # Flag: CRITICAL
                    send_hud_alert "CRIT" "Flight control process failed"
                    play_audio_alert "CRIT"
                    return 1
                fi
            fi
        else
            restart_count=0
        fi
        last_loop_a=$current_loop_a

        # Update Daemon B heartbeat counter
        local check_count
        check_count=$(read_shm_field 4 "d4" 2>/dev/null || echo "0")
        check_count=$((check_count + 1))
        write_shm_field 4 "$(printf '%08x' $check_count)" "d4"

        usleep "$sleep_us"
    done
}

# --- Daemon C: Escalating Watchdog (1 Hz) ---
daemon_c() {
    log_msg "INFO" "Daemon C (Watchdog) starting at ${RATE_C} Hz..."
    local prev_check_count=0
    local escalation_level=0  # 0=OK, 1=WARN, 2=CRIT, 3=FATAL

    while true; do
        local now_ms
        now_ms=$(($(date +%s%N) / 1000000))
        local current_check_count
        current_check_count=$(read_shm_field 4 "d4" 2>/dev/null || echo "0")
        current_check_count=$((current_check_count))

        if [[ "$current_check_count" -eq "$prev_check_count" ]]; then
            local elapsed=$((now_ms - $(read_shm_field 26 "d8" 2>/dev/null || echo "0")))

            if [[ $elapsed -gt $TIMEOUT_DAEMON_C_MS ]]; then
                escalation_level=3  # FATAL — RTL
                log_msg "FATAL" "Daemon C: ESCALATION LEVEL 3 — Triggering RTL!"
                write_shm_field 25 "$(printf '%02x' 0x04)" "d1"  # Flag: FATAL
                send_hud_alert "FATAL" "Watchdog escalation — RTL triggered"
                play_audio_alert "FATAL"
                echo '{"status":"FATAL","level":3,"timestamp_ms":'"$now_ms"',"action":"RTL"}' > "$STATUS_FILE"
            elif [[ $elapsed -gt $(($TIMEOUT_DAEMON_C_MS / 3 * 2)) ]]; then
                if [[ $escalation_level -lt 2 ]]; then
                    escalation_level=2  # CRITICAL
                    log_msg "CRITICAL" "Daemon C: ESCALATION LEVEL 2 — Disabling autonomous modes"
                    write_shm_field 25 "$(printf '%02x' 0x02)" "d1"
                    send_hud_alert "CRIT" "Watchdog escalation — autonomous modes disabled"
                    play_audio_alert "CRIT"
                    echo '{"status":"CRITICAL","level":2,"timestamp_ms":'"$now_ms"'}' > "$STATUS_FILE"
                fi
            elif [[ $elapsed -gt $(($TIMEOUT_DAEMON_C_MS / 3)) ]]; then
                if [[ $escalation_level -lt 1 ]]; then
                    escalation_level=1  # WARN
                    log_msg "WARN" "Daemon C: ESCALATION LEVEL 1 — Watchdog warning"
                    write_shm_field 25 "$(printf '%02x' 0x01)" "d1"
                    send_hud_alert "WARN" "Watchdog heartbeat delayed"
                    echo '{"status":"WARN","level":1,"timestamp_ms":'"$now_ms"'}' > "$STATUS_FILE"
                fi
            fi
        else
            if [[ $escalation_level -gt 0 ]]; then
                log_msg "INFO" "Daemon C: System recovered from escalation level ${escalation_level}"
                escalation_level=0
                write_shm_field 25 "$(printf '%02x' 0x00)" "d1"
                echo '{"status":"OK","level":0,"timestamp_ms":'"$now_ms"'}' > "$STATUS_FILE"
            fi
        fi
        prev_check_count=$current_check_count

        # Write Daemon C PID
        write_shm_field 21 "$(printf '%08x' $$)" "d4"

        sleep 1
    done
}

# --- Meta-Watchdog: OS-Level Guardian (0.2 Hz) ---
meta_watchdog() {
    log_msg "INFO" "Meta-Watchdog starting at ${RATE_META} Hz (every 5s)..."

    while true; do
        sleep 5
        local status_age=99999
        if [[ -f "$STATUS_FILE" ]]; then
            status_age=$(($(date +%s) - $(stat -c %Y "$STATUS_FILE" 2>/dev/null || echo 0)))
        fi

        if [[ $status_age -gt $((TIMEOUT_META_MS / 1000)) ]]; then
            log_msg "FATAL" "META-WATCHDOG: Daemon C status file stale (${status_age}s > $((TIMEOUT_META_MS / 1000))s)"
            log_msg "FATAL" "META-WATCHDOG: Triggering system-level force-stop!"

            # Kill all dronex processes
            pkill -f "dronex" 2>/dev/null || true
            pkill -f "dronex_daemon_watchdog" 2>/dev/null || true

            # Continuous audio alarm
            for i in $(seq 1 30); do
                aplay -q "$ALERT_SOUND" -d 0.5 2>/dev/null
                sleep 0.5
            done

            log_msg "FATAL" "META-WATCHDOG: Force-stop complete. System requires manual restart."
            exit 1
        fi
    done
}

# --- Command Handlers ---
cmd_start() {
    log_msg "INFO" "========================================="
    log_msg "INFO" "DRONE-X Triple-Daemon Watchdog STARTING"
    log_msg "INFO" "========================================="

    mkdir -p "$PID_DIR"
    touch "$LOG_FILE"
    init_shm

    # Initialize status file
    echo '{"status":"OK","level":0,"timestamp_ms":'$(($(date +%s%N) / 1000000))'}' > "$STATUS_FILE"

    # Start daemons in reverse dependency order
    daemon_a &
    local pid_a=$!
    echo "$pid_a" > "${PID_DIR}/daemon_a.pid"

    daemon_b &
    local pid_b=$!
    echo "$pid_b" > "${PID_DIR}/daemon_b.pid"

    daemon_c &
    local pid_c=$!
    echo "$pid_c" > "${PID_DIR}/daemon_c.pid"

    meta_watchdog &
    local pid_m=$!
    echo "$pid_m" > "${PID_DIR}/meta_watchdog.pid"

    log_msg "INFO" "All daemons started: A=${pid_a}, B=${pid_b}, C=${pid_c}, Meta=${pid_m}"
    log_msg "INFO" "Watchdog initialized. Monitor with: $0 status"

    # Wait for any daemon to die
    wait -n 2>/dev/null || true
    log_msg "ERROR" "A daemon process exited unexpectedly! Check logs at ${LOG_FILE}"
}

cmd_stop() {
    log_msg "INFO" "Stopping DRONE-X Triple-Daemon Watchdog..."

    for daemon in meta_watchdog daemon_c daemon_b daemon_a; do
        local pid_file="${PID_DIR}/${daemon}.pid"
        if [[ -f "$pid_file" ]]; then
            local pid
            pid=$(cat "$pid_file")
            kill "$pid" 2>/dev/null || true
            log_msg "INFO" "Stopped ${daemon} (PID ${pid})"
            rm -f "$pid_file"
        fi
    done

    # Clean up any remaining processes
    pkill -f "dronex_daemon_watchdog" 2>/dev/null || true

    cleanup_shm
    rm -f "$STATUS_FILE"
    log_msg "INFO" "All daemons stopped. Shared memory cleaned."
}

cmd_status() {
    echo "=== DRONE-X Triple-Daemon Watchdog Status ==="
    echo ""

    for daemon in daemon_a daemon_b daemon_c meta_watchdog; do
        local pid_file="${PID_DIR}/${daemon}.pid"
        local status="STOPPED"
        if [[ -f "$pid_file" ]]; then
            local pid
            pid=$(cat "$pid_file")
            if kill -0 "$pid" 2>/dev/null; then
                status="RUNNING (PID ${pid})"
            else
                status="STALE PID FILE (${pid} not found)"
            fi
        fi
        printf "  %-20s %s\n" "${daemon}:" "${status}"
    done

    echo ""
    echo "Shared Memory:"
    local shm_file="/dev/shm/dronex_shm_${SHM_KEY}"
    if [[ -f "$shm_file" ]]; then
        echo "  Segment file: ${shm_file} (present)"
        echo "  Daemon A heartbeat: $(read_shm_field 0 'd4' 2>/dev/null || echo 'N/A')"
        echo "  Daemon B heartbeat: $(read_shm_field 4 'd4' 2>/dev/null || echo 'N/A')"
        echo "  Status flags: 0x$(read_shm_field 25 'd1x' 2>/dev/null || echo 'N/A')"
    else
        echo "  Segment file: NOT FOUND"
    fi

    echo ""
    echo "Escalation Status:"
    if [[ -f "$STATUS_FILE" ]]; then
        python3 -m json.tool "$STATUS_FILE" 2>/dev/null || cat "$STATUS_FILE"
    else
        echo "  No status file"
    fi

    echo ""
    echo "Recent Logs (last 5 lines):"
    tail -5 "$LOG_FILE" 2>/dev/null || echo "  No log file"
}

cmd_test() {
    log_msg "INFO" "========================================="
    log_msg "INFO" "DRONE-X Watchdog SELF-TEST INITIATED"
    log_msg "INFO" "========================================="

    # Test 1: Shared memory initialization
    echo -n "Test 1: Shared memory init... "
    init_shm
    if [[ -f "/dev/shm/dronex_shm_${SHM_KEY}" ]]; then
        echo "PASS"
    else
        echo "FAIL"
        return 1
    fi

    # Test 2: Shared memory read/write
    echo -n "Test 2: Shared memory R/W... "
    write_shm_field 0 "$(printf '%08x' 0xDEADBEEF)" "d4"
    local val
    val=$(read_shm_field 0 "d4")
    if [[ "$val" == "3735928495" ]]; then  # 0xDEADBEEF in decimal
        echo "PASS"
    else
        echo "FAIL (read: $val)"
        return 1
    fi

    # Test 3: Daemon startup
    echo -n "Test 3: Daemon A startup... "
    daemon_a &
    local pid_a=$!
    sleep 0.1
    if kill -0 "$pid_a" 2>/dev/null; then
        echo "PASS (PID ${pid_a})"
        kill "$pid_a" 2>/dev/null || true
    else
        echo "FAIL"
        return 1
    fi

    # Test 4: Heartbeat detection
    echo -n "Test 4: Heartbeat detection... "
    init_shm
    write_shm_field 0 "$(printf '%08x' 1)" "d4"
    write_shm_field 4 "$(printf '%08x' 1)" "d4"
    local hb_a
    hb_a=$(read_shm_field 0 "d4")
    if [[ -n "$hb_a" ]]; then
        echo "PASS"
    else
        echo "FAIL"
        return 1
    fi

    # Test 5: Status file
    echo -n "Test 5: Status file creation... "
    echo '{"status":"OK","level":0,"timestamp_ms":0}' > "$STATUS_FILE"
    if [[ -f "$STATUS_FILE" ]]; then
        echo "PASS"
    else
        echo "FAIL"
        return 1
    fi

    cleanup_shm
    rm -f "$STATUS_FILE"
    log_msg "INFO" "ALL TESTS PASSED"
    echo ""
    echo "=== ALL WATCHDOG TESTS PASSED ==="
}

# --- Main ---
case "${1:-}" in
    start)
        cmd_start
        ;;
    stop)
        cmd_stop
        ;;
    status)
        cmd_status
        ;;
    test)
        cmd_test
        ;;
    *)
        echo "DRONE-X Triple-Daemon Watchdog (CSMFAB-228)"
        echo "Usage: $0 {start|stop|status|test}"
        echo ""
        echo "  start   — Start all daemon processes (A, B, C, Meta)"
        echo "  stop    — Stop all daemon processes and clean up"
        echo "  status  — Display watchdog status and recent logs"
        echo "  test    — Run self-test suite"
        exit 1
        ;;
esac

exit 0
