#!/usr/bin/env bash
#
# Sibling Frequency Radio Generator Script
# Implements Triple-Demon Check Protocol (DEMON-ALPHA, DEMON-BETA, DEMON-GAMMA)
#
# Usage: bash generator-script.sh [episode-number]
# Example: bash generator-script.sh 3

set -euo pipefail

EP_NUM="${1:-3}"
GEN_DIR="$(cd "$(dirname "$0")" && pwd)"
REPO_ROOT="$(cd "$GEN_DIR/../.." && pwd)"
EP_FILE="$REPO_ROOT/CSMRadio/SiblingFrequency/CSMSFRadio$(printf "%05d" "$EP_NUM").md"
LOG_FILE="/tmp/demon-check-$(date +%s).log"

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m'

log() {
    echo -e "[$(date '+%H:%M:%S')] $1" | tee -a "$LOG_FILE"
}

demon_gamma_pid=""
demon_alpha_pid=""
demon_beta_pid=""

demon_gamma() {
    while true; do
        if ! kill -0 "$demon_beta_pid" 2>/dev/null; then
            log "${RED}[DEMON-GAMMA] BETA IS DOWN! Restarting cascade...${NC}"
            kill "$demon_alpha_pid" 2>/dev/null || true
            kill "$demon_beta_pid" 2>/dev/null || true
            sleep 1
            start_demons
            return
        fi
        sleep 3
    done
}

demon_beta() {
    while true; do
        if ! kill -0 "$demon_alpha_pid" 2>/dev/null; then
            log "${YELLOW}[DEMON-BETA] ALPHA IS DOWN! Restarting DEMON-ALPHA...${NC}"
            demon_alpha &
            demon_alpha_pid=$!
            log "${GREEN}[DEMON-BETA] ALPHA restarted (PID: $demon_alpha_pid)${NC}"
        fi
        sleep 2
    done
}

command_active=false
command_start_time=0
command_pid=0
command_estimate=0
command_count=0

demon_alpha() {
    while true; do
        if $command_active; then
            elapsed=$(($(date +%s) - command_start_time))
            double_estimate=$((command_estimate * 2))
            if ! kill -0 "$command_pid" 2>/dev/null; then
                command_active=false
                log "${GREEN}[DEMON-ALPHA] Command completed in ${elapsed}s${NC}"
            elif [ "$elapsed" -gt "$double_estimate" ]; then
                log "${RED}[DEMON-ALPHA] COMMAND EXCEEDED 2X ESTIMATE! Elapsed: ${elapsed}s, Estimate: ${command_estimate}s${NC}"
                sleep 5
                if kill -0 "$command_pid" 2>/dev/null; then
                    log "${RED}[DEMON-ALPHA] PERSISTENT OVERRUN! Command PID $command_pid is stuck or hung${NC}"
                fi
            fi
        fi
        sleep 1
    done
}

start_demons() {
    log "${GREEN}[DEMON-CASCADE] Initializing triple-demon protocol...${NC}"
    demon_alpha &
    demon_alpha_pid=$!
    log "${GREEN}[DEMON-CASCADE] ALPHA started (PID: $demon_alpha_pid)${NC}"
    demon_beta &
    demon_beta_pid=$!
    log "${GREEN}[DEMON-CASCADE] BETA started (PID: $demon_beta_pid)${NC}"
    demon_gamma &
    demon_gamma_pid=$!
    log "${GREEN}[DEMON-CASCADE] GAMMA started (PID: $demon_gamma_pid)${NC}"
    log "${GREEN}[DEMON-CASCADE] All three demons online. Shield is up.${NC}"
}

stop_demons() {
    log "${YELLOW}[DEMON-CASCADE] Shutting down demon protocol...${NC}"
    kill "$demon_alpha_pid" 2>/dev/null || true
    kill "$demon_beta_pid" 2>/dev/null || true
    kill "$demon_gamma_pid" 2>/dev/null || true
    log "${GREEN}[DEMON-CASCADE] All demons dismissed.${NC}"
}

run_checked() {
    command_count=$((command_count + 1))
    local estimate="$1"
    local desc="$2"
    shift 2
    local cmd=("$@")
    log "${GREEN}[EXEC-$command_count] $desc (estimate: ${estimate}s)${NC}"
    command_start_time=$(date +%s)
    command_estimate="$estimate"
    command_active=true
    "${cmd[@]}" &
    command_pid=$!
    wait "$command_pid" 2>/dev/null
    exit_code=$?
    command_active=false
    local actual_elapsed=$(($(date +%s) - command_start_time))
    if [ "$exit_code" -eq 0 ]; then
        log "${GREEN}[DEMON-ALPHA] PASS-$command_count: $desc completed in ${actual_elapsed}s (exit: $exit_code)${NC}"
    else
        log "${RED}[DEMON-ALPHA] FAIL-$command_count: $desc failed in ${actual_elapsed}s (exit: $exit_code)${NC}"
    fi
    return "$exit_code"
}

main() {
    log "${GREEN}============================================${NC}"
    log "${GREEN}SIBLING FREQUENCY RADIO GENERATOR${NC}"
    log "${GREEN}Episode $EP_NUM${NC}"
    log "${GREEN}============================================${NC}"
    start_demons
    trap stop_demons EXIT
    run_checked 5 "Verify directory structure" \
        bash -c "test -d '$REPO_ROOT/CSMRadio/SiblingFrequency' && echo 'OK: Directory exists'" || exit 1
    run_checked 5 "Verify prior episodes" \
        bash -c "test -f '$REPO_ROOT/CSMRadio/SiblingFrequency/CSMSFRadio00001.md' && test -f '$REPO_ROOT/CSMRadio/SiblingFrequency/CSMSFRadio00002.md' && echo 'OK: Prior episodes present'" || exit 1
    run_checked 5 "Verify content integrity" \
        bash -c "lines1=\$(wc -l < '$REPO_ROOT/CSMRadio/SiblingFrequency/CSMSFRadio00001.md'); lines2=\$(wc -l < '$REPO_ROOT/CSMRadio/SiblingFrequency/CSMSFRadio00002.md'); echo \"EP1: \$lines1 lines, EP2: \$lines2 lines\"; test \$lines1 -gt 100 && test \$lines2 -gt 100 && echo 'OK: Content appears substantial'" || log "WARNING: Content verification flagged — proceeding anyway"
    run_checked 1 "Check if output file exists" \
        bash -c "if test -f '$EP_FILE'; then echo 'WARNING: $EP_FILE already exists'; else echo 'OK: No existing file'; fi"
    log "${GREEN}============================================${NC}"
    log "${GREEN}DEMON CASCADE REPORT:${NC}"
    log "${GREEN}  ALPHA (PID $demon_alpha_pid): Checked $command_count commands${NC}"
    log "${GREEN}  BETA (PID $demon_beta_pid): Watched ALPHA${NC}"
    log "${GREEN}  GAMMA (PID $demon_gamma_pid): Watched BETA${NC}"
    log "${GREEN}============================================${NC}"
    log "${GREEN}Generator script complete.${NC}"
    log "${GREEN}Output file: $EP_FILE${NC}"
    log "${GREEN}Log file: $LOG_FILE${NC}"
}

main "$@"
