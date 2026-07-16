#!/bin/bash
# =============================================================================
# vl_stop_daemons.sh — Gracefully Stop All Volt-Link Monitoring Daemons
# Carrington Storm Motors — CSMFAB051/052 Daemon Suite
# Version 1.0 — July 2026
# =============================================================================

PID_DIR="/tmp/voltlink_daemons"
LOG_DIR="../../CSMLogs"

log() {
    echo "[$(date '+%Y-%m-%d %H:%M:%S')] [STOPPER] $1" | tee -a "$LOG_DIR/vl_stopper.log"
}

log "============================================="
log "Volt-Link Daemon Stopper — Shutting down"
log "============================================="

stopped=0
still_alive=0

for pidfile in "$PID_DIR"/*.pid; do
    [ -f "$pidfile" ] || continue
    label=$(basename "$pidfile" .pid)
    pid=$(cat "$pidfile")
    
    if kill -0 "$pid" 2>/dev/null; then
        log "Stopping $label (PID $pid)..."
        kill -TERM "$pid" 2>/dev/null
        
        # Wait up to 5 seconds for graceful shutdown
        for i in {1..10}; do
            kill -0 "$pid" 2>/dev/null || break
            sleep 0.5
        done
        
        if kill -0 "$pid" 2>/dev/null; then
            log "FORCE KILL: $label (PID $pid) did not respond to TERM"
            kill -KILL "$pid" 2>/dev/null
            still_alive=$((still_alive + 1))
        else
            log "STOPPED: $label"
            stopped=$((stopped + 1))
        fi
    else
        log "ALREADY DEAD: $label (PID $pid)"
    fi
    
    rm -f "$pidfile" "${PID_DIR}/${label}.last_cpu" "${PID_DIR}/${label}.stall_count"
done

log "============================================="
log "Shutdown complete: $stopped stopped, $still_alive force-killed"
log "============================================="
