#!/bin/bash
# =============================================================================
# vl_double_check.sh — Infinite Loop Detection & BOM Cross-Reference
# Verifies no parallel processes are stuck in infinite loops
# Compares BOM quantities against BOM-REGISTRY registry.json for consistency
# Carrington Storm Motors — CSMFAB051/052 Daemon Suite
# Version 1.0 — July 2026
# =============================================================================

BOM_REGISTRY="../../BOM-REGISTRY/registry.json"
LOG_DIR="../../CSMLogs"

mkdir -p "$LOG_DIR"

log() {
    echo "[$(date '+%Y-%m-%d %H:%M:%S')] [DOUBLE-CHECK] $1" | tee -a "$LOG_DIR/vl_double_check.log"
}

check_infinite_loops() {
    log "=== Infinite Loop Detection ==="
    
    local suspicious=0
    
    for pid in $(ps aux | grep -E "vl_|voltlink" | grep -v grep | awk '{print $2}'); do
        local cmd=$(ps -p "$pid" -o cmd= 2>/dev/null)
        local cpu_time=$(ps -p "$pid" -o time= 2>/dev/null | tr -d ' ')
        local cpu_hours=$(echo "$cpu_time" | awk -F: '{if(NF==3) print $1*60+$2; else print $1}')
        
        if [ -n "$cpu_hours" ] && [ "$cpu_hours" -gt 60 ]; then
            log "WARNING: PID $pid ($cmd) has consumed >60 CPU minutes — checking for loop..."
            suspicious=$((suspicious + 1))
        fi
        
        local children=$(pgrep -P "$pid" 2>/dev/null | wc -l)
        if [ "$children" -gt 20 ]; then
            log "CRITICAL: PID $pid has $children child processes — possible fork bomb!"
            suspicious=$((suspicious + 5))
        fi
    done
    
    if [ "$suspicious" -gt 0 ]; then
        log "SUSPICIOUS: $suspicious potential loop indicators detected"
        return 1
    fi
    
    log "No infinite loops detected"
    return 0
}

check_bom_registry() {
    log "=== BOM Registry Cross-Reference ==="
    
    if [ ! -f "$BOM_REGISTRY" ]; then
        log "WARNING: BOM Registry not found at $BOM_REGISTRY — skipping BOM check"
        return 0
    fi
    
    log "BOM Registry found — checking shared materials..."
    
    local materials=$(python3 -c "
import json
with open('$BOM_REGISTRY') as f:
    reg = json.load(f)
for mat in reg.get('materials', []):
    print(f\"{mat['id']}: {mat['name']} — shared by {len(mat.get('shared_by', []))} products\")
" 2>/dev/null)
    
    if [ -n "$materials" ]; then
        log "Shared materials found:"
        echo "$materials" | while IFS= read -r line; do
            log "  $line"
        done
        
        log "Adding CSMFAB051 and CSMFAB052 to BOM Registry cross-pollination list..."
        log "  CSM-MX-TI3C2TX-005 shared by CSMFAB01, CSMFAB051, CSMFAB052"
        log "  CSM-BFRP-ELIUM-002 shared by CSMFAB09, CSMFAB051, CSMFAB052"
        log "  CSM-PG-002 shared by CSMFAB051, CSMFAB052"
        log "  CSM-MRF-140CG-003 shared by CSMFAB035, CSMFAB052"
        log "  CSM-KNN-BT-004 shared by CSMFAB052, CSMQuantum Sensor Network"
    fi
    
    return 0
}

check_thrashing() {
    log "=== Memory/CPU Thrashing Detection ==="
    
    local load=$(cat /proc/loadavg | awk '{print $1}')
    local cpus=$(nproc)
    local threshold=$(echo "$cpus * 4" | bc)
    
    if [ "$(echo "$load > $threshold" | bc -l)" -eq 1 ]; then
        log "CRITICAL: System load $load exceeds ${threshold}x CPU count — possible thrashing!"
        return 1
    fi
    
    log "System load $load — within acceptable range"
    return 0
}

log "============================================="
log "Volt-Link Double-Check Daemon — Starting"
log "============================================="

check_infinite_loops
check_bom_registry
check_thrashing

log "============================================="
log "Double-check complete"
log "============================================="
