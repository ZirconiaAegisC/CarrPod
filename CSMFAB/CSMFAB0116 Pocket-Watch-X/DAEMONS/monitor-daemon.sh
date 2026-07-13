#!/usr/bin/env bash
# =============================================================================
# MONITOR DAEMON — Oversees Check Daemon 2
# =============================================================================

set -euo pipefail

LOG_DIR="${CSMFAB_LOG_DIR:-/tmp/pocket-watch-x-daemon-logs}"
LOG_FILE="${LOG_DIR}/monitor-daemon.log"
MASTER_LOG="${LOG_DIR}/master-health.log"
CD2_PID_FILE="${LOG_DIR}/check-daemon-2.pid"
CD2_HEARTBEAT_FILE="${LOG_DIR}/check-daemon-2.heartbeat"
MD_HEARTBEAT_FILE="${LOG_DIR}/monitor-daemon.heartbeat"
MD_PID_FILE="${LOG_DIR}/monitor-daemon.pid"
LOCK_FILE="${LOG_DIR}/monitor-daemon.lock"
INTERVAL=5
HB_TIMEOUT=20
MAX_RESTARTS=3
CD2_SCRIPT="${CSMFAB_BUILD_DIR:-$(dirname "$0")}/check-daemon-2.sh"

mkdir -p "$LOG_DIR"

log_entry() { echo "[MD-$(date -u +%Y%m%dT%H%M%SZ)] $*" | tee -a "$LOG_FILE"; }
heartbeat() { echo "$(date -u +%s)" > "$MD_HEARTBEAT_FILE"; }
master() { echo "[$(date -u +%Y%m%dT%H%M%SZ)] STATUS=$1 DETAIL=${2:-}" >> "$MASTER_LOG"; }

check_cd2() {
    if [[ -f "$CD2_HEARTBEAT_FILE" ]]; then
        local last=$(cat "$CD2_HEARTBEAT_FILE")
        local now=$(date -u +%s)
        local elapsed=$(( now - last ))
        if [[ $elapsed -gt $HB_TIMEOUT ]]; then
            log_entry "WARN: CD2 heartbeat stale ${elapsed}s"
            master "DEGRADED" "CD2 HB timeout"
            return 1
        fi
    else
        log_entry "WARN: CD2 heartbeat file missing"
        master "DEGRADED" "CD2 HB missing"
        return 1
    fi
    if [[ -f "$CD2_PID_FILE" ]]; then
        local pid=$(cat "$CD2_PID_FILE")
        kill -0 "$pid" 2>/dev/null || { log_entry "WARN: CD2 PID $pid dead"; master "DEGRADED" "CD2 pid dead"; return 1; }
    else
        log_entry "WARN: CD2 PID file missing"
        master "DEGRADED" "CD2 pid missing"
        return 1
    fi
    return 0
}

restart_cd2() {
    local attempt="$1"
    log_entry "RESTART: CD2 attempt $attempt/$MAX_RESTARTS"
    [[ -f "$CD2_PID_FILE" ]] && kill $(cat "$CD2_PID_FILE") 2>/dev/null || true
    rm -f "$CD2_PID_FILE"
    bash "$CD2_SCRIPT" & disown
    sleep 3
    check_cd2 && { log_entry "RECOVERED: CD2"; master "HEALTHY" "CD2 recovered $attempt"; return 0; }
    master "CRITICAL" "CD2 restart fail $attempt"
    return 1
}

cleanup() {
    log_entry "SHUTDOWN: MD terminating"
    master "SHUTDOWN" "MD stopped"
    rm -f "$LOCK_FILE" "$MD_PID_FILE"
}

trap cleanup EXIT INT TERM

main() {
    exec 202>"$LOCK_FILE"
    flock -n 202 || { log_entry "ERROR: MD already running"; exit 1; }
    echo $$ > "$MD_PID_FILE"
    log_entry "BOOT: PID $$"
    master "BOOT" "MD PID $$"
    heartbeat
    local restarts=0 cycle=0
    while true; do
        ((cycle++))
        heartbeat
        if ! check_cd2; then
            if [[ $restarts -lt $MAX_RESTARTS ]]; then
                ((restarts++))
                restart_cd2 "$restarts" && restarts=0
            else
                log_entry "FATAL: CD2 failed $MAX_RESTARTS"
                master "FATAL" "CD2 unrecoverable"
                exit 1
            fi
        fi
        (( cycle % 12 == 0 )) && master "REPORT" "cycle=$cycle"
        sleep "$INTERVAL"
    done
}

main "$@"
