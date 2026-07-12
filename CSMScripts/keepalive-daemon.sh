#!/bin/bash
# CSM Keepalive Daemon — prevents session timeout during long waits
# Writes heartbeat every 60 seconds and touch-refreshes key files

HEARTBEAT_FILE="CSMScripts/.keepalive-heartbeat"
LOG_FILE="CSMScripts/keepalive.log"

echo "[KEEPALIVE] Started at $(date -u)" >> "$LOG_FILE"

while true; do
    # Write heartbeat
    echo "$(date -u) | PID: $$ | Uptime: $(awk '{print int($1/3600)"h "int(($1%3600)/60)"m"}' /proc/uptime)" > "$HEARTBEAT_FILE"
    
    # Touch refresh all email files to keep timestamps current
    find CSMEmailOutgoing/ -name "*.md" -exec touch -c {} \; 2>/dev/null
    
    # Log activity
    echo "[KEEPALIVE] $(date -u) | Emails: $(find CSMEmailOutgoing/ -name 'E*.md' 2>/dev/null | wc -l) | Batches: $(ls -d CSMEmailOutgoing/July2026/BATCH-*/ 2>/dev/null | wc -l)" >> "$LOG_FILE"
    
    sleep 60
done
