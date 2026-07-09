#!/bin/bash
# CITADEL Verification Daemon V1
# Usage: ./verify-daemon.sh <command> <expected_seconds> <log_file> <retry_count>
# Created for Land O' Lil v7 Plan 2 Execution

set -euo pipefail

COMMAND="$1"
EXPECTED_SECS="${2:-30}"
LOG_FILE="${3:-verify.log}"
MAX_RETRIES="${4:-3}"

TIMEOUT_SECS=$((EXPECTED_SECS * 2))

VERIFY_DIR="CSMApps/landolil/v7/verification"
mkdir -p "$VERIFY_DIR"

GREEN='\033[0;32m'
RED='\033[0;31m'
YELLOW='\033[1;33m'
NC='\033[0m'

verify_command() {
    local cmd="$1"
    local timeout_secs="$2"
    local retry="$3"
    local timestamp
    timestamp=$(date -u +"%Y-%m-%dT%H:%M:%SZ")

    echo "=========================================="
    echo "[${timestamp}] EXECUTING (retry ${retry}/${MAX_RETRIES})"
    echo "COMMAND: ${cmd}"
    echo "EXPECTED: ${EXPECTED_SECS}s | TIMEOUT: ${timeout_secs}s"
    echo "=========================================="

    local start_time
    start_time=$(date +%s)

    local output_file="${VERIFY_DIR}/output_${timestamp}.log"

    if timeout "${timeout_secs}" bash -c "$cmd" > "${output_file}" 2>&1; then
        local end_time
        end_time=$(date +%s)
        local actual_secs=$((end_time - start_time))

        echo -e "${GREEN}[PASS]${NC} Command completed in ${actual_secs}s"
        echo "[${timestamp}] PASS | Expected: <=${timeout_secs}s | Actual: ${actual_secs}s | Retry: ${retry}/${MAX_RETRIES}" >> "${VERIFY_DIR}/${LOG_FILE}"
        echo "OUTPUT (last 5 lines):"
        tail -5 "${output_file}" 2>/dev/null | sed 's/^/  /'
        echo "=========================================="
        return 0
    else
        local exit_code=$?
        local end_time
        end_time=$(date +%s)
        local actual_secs=$((end_time - start_time))

        if [ $exit_code -eq 124 ]; then
            echo -e "${RED}[TIMEOUT]${NC} Command exceeded ${timeout_secs}s limit"

            if [ "$retry" -lt "$MAX_RETRIES" ]; then
                echo -e "${YELLOW}[RETRY]${NC} Attempting retry $((retry + 1))/${MAX_RETRIES}..."
                echo "[${timestamp}] TIMEOUT | Expected: <=${timeout_secs}s | Actual: ${actual_secs}s | Retry: ${retry}/${MAX_RETRIES}" >> "${VERIFY_DIR}/${LOG_FILE}"
                sleep 2
                verify_command "$cmd" "$timeout_secs" $((retry + 1))
                return $?
            else
                echo -e "${RED}[FAIL]${NC} Command failed after ${MAX_RETRIES} retries"
                echo "[${timestamp}] FAIL | Retry: ${MAX_RETRIES}/${MAX_RETRIES}" >> "${VERIFY_DIR}/${LOG_FILE}"
                tail -20 "${output_file}" 2>/dev/null | sed 's/^/  /'
                echo "=========================================="
                return 1
            fi
        else
            echo -e "${RED}[ERROR]${NC} Command failed with exit code ${exit_code}"

            if [ "$retry" -lt "$MAX_RETRIES" ]; then
                echo -e "${YELLOW}[RETRY]${NC} Attempting retry $((retry + 1))/${MAX_RETRIES}..."
                echo "[${timestamp}] ERROR(${exit_code}) | Retry: ${retry}/${MAX_RETRIES}" >> "${VERIFY_DIR}/${LOG_FILE}"
                sleep 2
                verify_command "$cmd" "$timeout_secs" $((retry + 1))
                return $?
            else
                echo -e "${RED}[FAIL]${NC} Command failed after ${MAX_RETRIES} retries"
                echo "[${timestamp}] FAIL(${exit_code}) | Retry: ${MAX_RETRIES}/${MAX_RETRIES}" >> "${VERIFY_DIR}/${LOG_FILE}"
                tail -20 "${output_file}" 2>/dev/null | sed 's/^/  /'
                echo "=========================================="
                return 1
            fi
        fi
    fi
}

verify_command "$COMMAND" "$TIMEOUT_SECS" 1
exit $?
