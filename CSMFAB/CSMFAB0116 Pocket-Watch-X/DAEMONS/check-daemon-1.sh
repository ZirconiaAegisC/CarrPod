#!/usr/bin/env bash
# =============================================================================
# CHECK DAEMON 1 — Command Completion Verification
# Pocket Watch X Build — CSMFAB0116
# =============================================================================

set -euo pipefail

LOG_DIR="${CSMFAB_LOG_DIR:-/tmp/pocket-watch-x-daemon-logs}"
COMMAND_QUEUE="${CSMFAB_COMMAND_QUEUE:-/tmp/pocket-watch-x-command-queue.txt}"
LOG_FILE="${LOG_DIR}/check-daemon-1.log"
HEARTBEAT_FILE="${LOG_DIR}/check-daemon-1.heartbeat"
PID_FILE="${LOG_DIR}/check-daemon-1.pid"
LOCK_FILE="${LOG_DIR}/check-daemon-1.lock"
INTERVAL=2
DOUBLE_MULTIPLIER=2
TRIPLE_VERIFY=1

mkdir -p "$LOG_DIR"

log_entry() { echo "[CD1-$(date -u +%Y%m%dT%H%M%SZ)] $*" | tee -a "$LOG_FILE"; }
heartbeat() { echo "$(date -u +%s)" > "$HEARTBEAT_FILE"; }

verify_command() {
    local cmd="$1"
    local est_seconds="${2:-60}"
    local check_count=0
    local max_checks=$(( (est_seconds * DOUBLE_MULTIPLIER) / INTERVAL ))

    log_entry "EXEC: $cmd"
    log_entry "EST: ${est_seconds}s — verify for $(( est_seconds * DOUBLE_MULTIPLIER ))s ($max_checks checks)"

    local exit_code=1 output
    output=$(eval "$cmd" 2>&1) && exit_code=$? || exit_code=$?

    if [[ $exit_code -ne 0 ]]; then
        log_entry "FAIL: exit code $exit_code — $output"
        log_entry "RETRY: up to $TRIPLE_VERIFY time(s)"
        for retry in $(seq 1 $TRIPLE_VERIFY); do
            output=$(eval "$cmd" 2>&1) && exit_code=$? || exit_code=$?
            if [[ $exit_code -eq 0 ]]; then
                log_entry "RETRY-OK: retry $retry succeeded"
                break
            fi
            sleep "$INTERVAL"
        done
    fi

    log_entry "PASS: exit code 0"

    while [[ $check_count -lt $max_checks ]]; do
        heartbeat
        sleep "$INTERVAL"
        ((check_count++))
    done

    log_entry "VERIFIED: $max_checks checks complete"
    return 0
}

cleanup() {
    log_entry "SHUTDOWN: Check Daemon 1 terminating"
    rm -f "$LOCK_FILE" "$PID_FILE"
}

trap cleanup EXIT INT TERM

main() {
    exec 200>"$LOCK_FILE"
    flock -n 200 || { log_entry "ERROR: already running"; exit 1; }

    echo $$ > "$PID_FILE"
    log_entry "BOOT: PID $$"
    heartbeat

    local idx=0
    while IFS= read -r line || [[ -n "$line" ]]; do
        [[ -z "$line" || "$line" =~ ^# ]] && continue
        ((idx++))
        local est=$(echo "$line" | awk -F'|' '{print $2}')
        local cmd=$(echo "$line" | awk -F'|' '{print $3}')
        [[ -z "$est" ]] && est=60
        [[ -z "$cmd" ]] && cmd="$line"

        log_entry "QUEUE: #$idx"
        verify_command "$cmd" "$est" || { log_entry "FATAL: command #$idx failed"; exit 1; }
        log_entry "DONE: #$idx"
    done < "$COMMAND_QUEUE"

    log_entry "ALL: $idx commands processed"
}

while [[ ! -f "$COMMAND_QUEUE" ]]; do
    heartbeat
    sleep 5
done
log_entry "QUEUE-FOUND: $COMMAND_QUEUE"
main "$@"
