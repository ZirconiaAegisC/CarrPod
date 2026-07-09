#!/bin/bash
# CITADEL Watchdog Daemon V2 — Land O Lil v7b
# Waits 2x the estimated execution time, checks if build completed
# If not, re-executes the build command
set -euo pipefail

COMMAND="${1:-python3 /workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_bd9c3afd-d3d1-4c53-8888-d25c5232fcd8/CSMApps/landolil/v7b/build-apk.py}"
ESTIMATED_SECS="${2:-30}"
MAX_RETRIES="${3:-3}"
TIMEOUT_SECS=$((ESTIMATED_SECS * 2))

VERSION="7b"
V7B_DIR="/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_bd9c3afd-d3d1-4c53-8888-d25c5232fcd8/CSMApps/landolil/v7b"
VERIFY_DIR="$V7B_DIR/verification"
EXPECTED_APK="$V7B_DIR/out/LandOLil-v${VERSION}.apk"

mkdir -p "$VERIFY_DIR"

GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m'

log() {
    local timestamp
    timestamp=$(date -u +"%Y-%m-%dT%H:%M:%SZ")
    echo "[${timestamp}] $1"
    echo "[${timestamp}] $1" >> "$VERIFY_DIR/watchdog.log"
}

execute() {
    local cmd="$1"
    local timeout_secs="$2"
    local retry="$3"
    
    log "============================================"
    log "EXECUTION (retry ${retry}/${MAX_RETRIES}) | TIMEOUT: ${timeout_secs}s"
    log "COMMAND: ${cmd:0:120}..."
    log "============================================"
    
    local output_file="$VERIFY_DIR/output_$(date -u +%s).log"
    local start_time
    start_time=$(date +%s)
    
    if timeout "${timeout_secs}" bash -c "$cmd" > "$output_file" 2>&1; then
        local end_time
        end_time=$(date +%s)
        local actual=$((end_time - start_time))
        
        if [ -f "$EXPECTED_APK" ]; then
            local apk_size
            apk_size=$(stat --printf="%s" "$EXPECTED_APK" 2>/dev/null || echo "0")
            echo -e "${GREEN}[PASS]${NC} APK built: ${apk_size} bytes in ${actual}s"
            log "PASS | APK: ${apk_size}B | Time: ${actual}s | Retry: ${retry}/${MAX_RETRIES}"
            tail -5 "$output_file" 2>/dev/null | sed 's/^/  /'
            return 0
        else
            echo -e "${YELLOW}[WARN]${NC} Command exited 0 but APK not found"
            log "WARN | APK missing despite exit 0 | Retry: ${retry}/${MAX_RETRIES}"
            if [ "$retry" -lt "$MAX_RETRIES" ]; then
                sleep 2
                execute "$cmd" "$timeout_secs" $((retry + 1))
                return $?
            else
                return 1
            fi
        fi
    else
        local exit_code=$?
        local end_time
        end_time=$(date +%s)
        local actual=$((end_time - start_time))
        
        if [ $exit_code -eq 124 ]; then
            echo -e "${RED}[TIMEOUT]${NC} Command exceeded ${timeout_secs}s limit"
            log "TIMEOUT | Limit: ${timeout_secs}s | Actual: ${actual}s | Retry: ${retry}/${MAX_RETRIES}"
        else
            echo -e "${RED}[ERROR]${NC} Command failed with exit code ${exit_code}"
            log "ERROR($exit_code) | Retry: ${retry}/${MAX_RETRIES}"
        fi
        
        if [ "$retry" -lt "$MAX_RETRIES" ]; then
            echo -e "${YELLOW}[RETRY]${NC} Attempt $((retry + 1))/$MAX_RETRIES in 3s..."
            sleep 3
            execute "$cmd" "$timeout_secs" $((retry + 1))
            return $?
        else
            echo -e "${RED}[FAIL]${NC} Exhausted all ${MAX_RETRIES} retries"
            log "FAIL | Max retries ($MAX_RETRIES) exhausted"
            tail -20 "$output_file" 2>/dev/null | sed 's/^/  /'
            return 1
        fi
    fi
}

log "WATCHDOG DAEMON V2 — Land O Lil v7b"
log "Expected time: ${ESTIMATED_SECS}s | Timeout: ${TIMEOUT_SECS}s | Retries: ${MAX_RETRIES}"
log "APK target: ${EXPECTED_APK}"

# Main execution
execute "$COMMAND" "$TIMEOUT_SECS" 1
EXIT_CODE=$?

exit $EXIT_CODE
