#!/usr/bin/env bash
# =============================================================================
# CHECK DAEMON 2 — Daemon Health Monitor
# Monitors Check Daemon 1 heartbeats and restarts if needed
# =============================================================================

set -euo pipefail

LOG_DIR="${CSMFAB_LOG_DIR:-/tmp/pocket-watch-x-daemon-logs}"
LOG_FILE="${LOG_DIR}/check-daemon-2.log"
CD1_PID_FILE="${LOG_DIR}/check-daemon-1.pid"
CD1_HEARTBEAT_FILE="${LOG_DIR}/check-daemon-1.heartbeat"
CD2_HEARTBEAT_FILE="${LOG_DIR}/check-daemon-2.heartbeat"
CD2_PID_FILE="${LOG_DIR}/check-daemon-2.pid"
LOCK_FILE="${LOG_DIR}/check-daemon-2.lock"
INTERVAL=3
HB_TIMEOUT=15
MAX_RESTARTS=3
CD1_SCRIPT="${CSMFAB_BUILD_DIR:-$(dirname "$0")}/check-daemon-1.sh"

mkdir -p "$LOG_DIR"

log_entry() { echo "[CD2-$(date -u +%Y%m%dT%H%M%SZ)] $*" | tee -a "$LOG_FILE"; }
heartbeat() { echo "$(date -u +%s)" > "$CD2_HEARTBEAT_FILE"; }

check_cd1() {
    if [[ -f "$CD1_HEARTBEAT_FILE" ]]; then
        local last=$(cat "$CD1_HEARTBEAT_FILE")
        local now=$(date -u +%s)
        local elapsed=$(( now - last ))
        if [[ $elapsed -gt $HB_TIMEOUT ]]; then
            log_entry "WARN: CD1 heartbeat stale ${elapsed}s"
            return 1
        fi
    else
        log_entry "WARN: CD1 heartbeat file missing"
        return 1
    fi
    if [[ -f "$CD1_PID_FILE" ]]; then
        local pid=$(cat "$CD1_PID_FILE")
        kill -0 "$pid" 2>/dev/null || { log_entry "WARN: CD1 PID $pid dead"; return 1; }
    else
        log_entry "WARN: CD1 PID file missing"
        return 1
    fi
    return 0
}

restart_cd1() {
    local attempt="$1"
    log_entry "RESTART: CD1 attempt $attempt/$MAX_RESTARTS"
    [[ -f "$CD1_PID_FILE" ]] && kill $(cat "$CD1_PID_FILE") 2>/dev/null || true
    rm -f "$CD1_PID_FILE"
    bash "$CD1_SCRIPT" & disown
    sleep 2
    check_cd1 && { log_entry "RECOVERED: CD1 restarted"; return 0; }
    return 1
}

cleanup() {
    log_entry "SHUTDOWN: CD2 terminating"
    rm -f "$LOCK_FILE" "$CD2_PID_FILE"
}

trap cleanup EXIT INT TERM

main() {
    exec 201>"$LOCK_FILE"
    flock -n 201 || { log_entry "ERROR: CD2 already running"; exit 1; }
    echo $$ > "$CD2_PID_FILE"
    log_entry "BOOT: PID $$"
    heartbeat
    local restarts=0 cycle=0
    while true; do
        ((cycle++))
        heartbeat
        if ! check_cd1; then
            if [[ $restarts -lt $MAX_RESTARTS ]]; then
                ((restarts++))
                restart_cd1 "$restarts" && restarts=0
            else
                log_entry "FATAL: CD1 failed $MAX_RESTARTS restarts"
                exit 1
            fi
        fi
        sleep "$INTERVAL"
    done
}

main "$@"
