#!/bin/bash
# =============================================================================
# vl_watchdog.sh — Volt-Link Parallel Fabrication Process Watchdog
# Monitors background processes, detects hung tasks, logs status to CSMLogs
# Carrington Storm Motors — CSMFAB051/052 Daemon Suite
# Version 1.0 — July 2026
# =============================================================================

LOG_DIR="../../CSMLogs"
PID_DIR="/tmp/voltlink_daemons"
CHECK_INTERVAL=30  # seconds between health checks
STALL_THRESHOLD=300  # seconds before a process is considered stalled

mkdir -p "$LOG_DIR" "$PID_DIR"

log() {
    echo "[$(date '+%Y-%m-%d %H:%M:%S')] [WATCHDOG] $1" | tee -a "$LOG_DIR/vl_watchdog.log"
}

check_process() {
    local pid=$1
    local label=$2
    
    if [ ! -f "/proc/$pid/status" ]; then
        log "DEAD: Process '$label' (PID $pid) has terminated"
        return 2
    fi
    
    local state=$(awk '/^State:/ {print $2}' /proc/$pid/status 2>/dev/null)
    local cpu_time=$(awk '/^se.sum_exec_runtime/ {print int($2/1000000000)}' /proc/$pid/sched 2>/dev/null)
    
    if [ -n "$cpu_time" ] && [ -f "$PID_DIR/${label}.last_cpu" ]; then
        local last_cpu=$(cat "$PID_DIR/${label}.last_cpu")
        if [ "$cpu_time" -eq "$last_cpu" ]; then
            local stall_count=$(cat "$PID_DIR/${label}.stall_count" 2>/dev/null || echo 0)
            stall_count=$((stall_count + 1))
            echo "$stall_count" > "$PID_DIR/${label}.stall_count"
            
            local stall_seconds=$((stall_count * CHECK_INTERVAL))
            if [ "$stall_seconds" -ge "$STALL_THRESHOLD" ]; then
                log "STALLED: Process '$label' (PID $pid) — no CPU progress for ${stall_seconds}s"
                return 3
            fi
        else
            echo "0" > "$PID_DIR/${label}.stall_count"
        fi
    fi
    
    echo "$cpu_time" > "$PID_DIR/${label}.last_cpu"
    return 0
}

log "Volt-Link Watchdog Daemon started — PID $$"
log "Monitoring interval: ${CHECK_INTERVAL}s | Stall threshold: ${STALL_THRESHOLD}s"

while true; do
    active_count=0
    dead_count=0
    stall_count=0
    
    for pidfile in "$PID_DIR"/*.pid; do
        [ -f "$pidfile" ] || continue
        label=$(basename "$pidfile" .pid)
        pid=$(cat "$pidfile")
        
        check_process "$pid" "$label"
        local result=$?
        
        case $result in
            0) active_count=$((active_count + 1)) ;;
            2) dead_count=$((dead_count + 1)) ;;
            3) stall_count=$((stall_count + 1)) ;;
        esac
    done
    
    log "HEARTBEAT: Active=$active_count Dead=$dead_count Stalled=$stall_count"
    
    sleep "$CHECK_INTERVAL"
done
