#!/bin/bash
# =============================================================================
# vl_cost_tracker.sh — Aggregates Costs Across Both Fabrications
# Compares against CSMFAB Master Cost Analysis budget projections
# Carrington Storm Motors — CSMFAB051/052 Daemon Suite
# Version 1.0 — July 2026
# =============================================================================

LOG_DIR="../../CSMLogs"
BUDGET_CSMFAB051=4500.00  # Prototype budget for CSMFAB051
BUDGET_CSMFAB052=7500.00  # Prototype budget for CSMFAB052 (includes synthesis labor)
COST_FILES=(
    "CSMFAB000000000051 Volt-Link Multi-Charger Coupling Hub Cost Analysis V1.0.md"
    "../CSMFAB052 Volt-Link Pure-CSM Multi-Charger Coupling Hub/CSMFAB000000000052 Volt-Link Multi-Charger Coupling Hub Cost Analysis V1.0.md"
)

mkdir -p "$LOG_DIR"

log() {
    echo "[$(date '+%Y-%m-%d %H:%M:%S')] [COST-TRACKER] $1" | tee -a "$LOG_DIR/vl_cost_tracker.log"
}

parse_cost() {
    local file=$1
    local label=$2
    
    if [ ! -f "$file" ]; then
        log "$label: File not found — skipping"
        return
    fi
    
    local material_cost=$(grep -i "TOTAL (hub only)\|TOTAL.*hub" "$file" | tail -1 | grep -oP '\$[\d,]+\.?\d*' | head -1 | tr -d '$,' )
    local labor_cost=$(grep -i "Total Labor" "$file" | tail -1 | grep -oP '\$[\d,]+\.?\d*' | head -1 | tr -d '$,' )
    local total_cost=$(grep -i "Total COGS" "$file" | tail -1 | grep -oP '\$[\d,]+\.?\d*' | head -1 | tr -d '$,' )
    local msrp=$(grep -i "MSRP Suggested" "$file" | tail -1 | grep -oP '\$[\d,]+\.?\d*' | head -1 | tr -d '$,' )
    
    log "$label Material Cost: \$${material_cost:-N/A}"
    log "$label Labor Cost: \$${labor_cost:-N/A}"
    log "$label Total COGS: \$${total_cost:-N/A}"
    log "$label MSRP: \$${msrp:-N/A}"
    
    case "$label" in
        *051*) budget=$BUDGET_CSMFAB051 ;;
        *052*) budget=$BUDGET_CSMFAB052 ;;
        *) budget=0 ;;
    esac
    
    if [ -n "$total_cost" ] && [ -n "$budget" ] && [ "$budget" != "0" ]; then
        local delta=$(echo "$total_cost - $budget" | bc -l)
        local pct=$(echo "scale=1; ($total_cost - $budget) / $budget * 100" | bc -l)
        
        if (( $(echo "$delta > 0" | bc -l) )); then
            log "BUDGET: $label OVER budget by \$$delta (${pct}%)"
        else
            local abs_delta=$(echo "$delta * -1" | bc)
            log "BUDGET: $label UNDER budget by \$$abs_delta (${pct}%)"
        fi
    fi
}

log "============================================="
log "Volt-Link Cost Tracker — Running"
log "============================================="

for cost_file in "${COST_FILES[@]}"; do
    if [[ "$cost_file" == *"051"* ]]; then
        parse_cost "$cost_file" "CSMFAB051"
    elif [[ "$cost_file" == *"052"* ]]; then
        parse_cost "$cost_file" "CSMFAB052"
    fi
    log "---"
done

log "============================================="
log "Cost tracking complete"
log "============================================="
