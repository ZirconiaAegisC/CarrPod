#!/bin/bash
# =============================================================================
# vl_launch_daemons.sh — Launch All Volt-Link Monitoring Daemons
# Starts watchdog, double-check, and cost tracker with process isolation
# Carrington Storm Motors — CSMFAB051/052 Daemon Suite
# Version 1.0 — July 2026
# =============================================================================

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PID_DIR="/tmp/voltlink_daemons"
LOG_DIR="../../CSMLogs"

mkdir -p "$PID_DIR" "$LOG_DIR"

log() {
    echo "[$(date '+%Y-%m-%d %H:%M:%S')] [LAUNCHER] $1" | tee -a "$LOG_DIR/vl_launcher.log"
}

launch_daemon() {
    local script=$1
    local label=$2
    
    if [ ! -f "$SCRIPT_DIR/$script" ]; then
        log "ERROR: Script $script not found"
        return 1
    fi
    
    chmod +x "$SCRIPT_DIR/$script"
    
    nohup bash "$SCRIPT_DIR/$script" > "$LOG_DIR/${label}.stdout" 2> "$LOG_DIR/${label}.stderr" &
    local pid=$!
    
    echo "$pid" > "$PID_DIR/${label}.pid"
    
    sleep 0.5
    if kill -0 "$pid" 2>/dev/null; then
        log "STARTED: $label (PID $pid) — $script"
    else
        log "FAILED: $label — $script exited immediately"
        cat "$LOG_DIR/${label}.stderr" 2>/dev/null
        return 1
    fi
}

log "============================================="
log "Volt-Link Daemon Launcher — Initializing"
log "PID Directory: $PID_DIR"
log "============================================="

launch_daemon "vl_watchdog.sh" "watchdog"
launch_daemon "vl_cost_tracker.sh" "cost_tracker"

# Double-check runs once, not as daemon
log "Running double-check (one-shot)..."
bash "$SCRIPT_DIR/vl_double_check.sh"

log "============================================="
log "All daemons launched"
log "Active daemons:"
for pidfile in "$PID_DIR"/*.pid; do
    [ -f "$pidfile" ] || continue
    label=$(basename "$pidfile" .pid)
    pid=$(cat "$pidfile")
    status=$(kill -0 "$pid" 2>/dev/null && echo "RUNNING" || echo "DEAD")
    log "  $label (PID $pid): $status"
done
log "============================================="
