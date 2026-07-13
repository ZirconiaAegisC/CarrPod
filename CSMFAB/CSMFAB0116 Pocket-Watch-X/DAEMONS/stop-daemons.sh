#!/usr/bin/env bash
# =============================================================================
# STOP ALL DAEMONS
# =============================================================================
LOG_DIR="${CSMFAB_LOG_DIR:-/tmp/pocket-watch-x-daemon-logs}"

stop() {
    local pf="$LOG_DIR/$1.pid" nm="$2"
    if [[ -f "$pf" ]]; then
        local pid=$(cat "$pf")
        kill -0 "$pid" 2>/dev/null && kill "$pid" && echo "[STOP] $nm (PID $pid)"
        rm -f "$pf"
    fi
}

stop "monitor-daemon" "Monitor Daemon"
stop "check-daemon-2" "Check Daemon 2"
stop "check-daemon-1" "Check Daemon 1"

pkill -f "monitor-daemon.sh" 2>/dev/null || true
pkill -f "check-daemon-2.sh" 2>/dev/null || true
pkill -f "check-daemon-1.sh" 2>/dev/null || true

rm -f "$LOG_DIR"/*.lock
echo "[STOP] All daemons stopped"
