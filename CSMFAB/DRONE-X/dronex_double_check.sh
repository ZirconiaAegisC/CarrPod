#!/bin/bash
#=============================================================================
# DRONE-X DAEMON DOUBLE-CHECK PROTOCOL
# File: dronex_double_check.sh
# Location: CSMFAB/DRONE-X/
#
# This script implements the "double demon check" protocol:
#   Demon 1 (Primary):   Checks that a command/operation completes
#   Demon 2 (Secondary): Checks that Demon 1's check completed correctly
#   Demon 3 (Tertiary):  Checks that Demon 2 is checking Demon 1
#
# Each check demon waits TWICE AS LONG as the estimated completion time.
# If the operation hasn't completed in 2× estimated time, it flags an error.
#=============================================================================

set -euo pipefail

# Configuration
DOUBLE_CHECK_LOG="/tmp/dx_double_check.log"
CHECK_STATUS_DIR="/tmp/dx_check_status"
mkdir -p "$CHECK_STATUS_DIR"

#=============================================================================
# DOUBLE-CHECK FUNCTION
# Usage: double_check "operation_name" "estimated_time_ms" "command_to_run"
#
# Returns 0 if the operation completes within 2× estimated time and
# all check demons verify successfully.
# Returns 1 on failure.
#=============================================================================

double_check() {
    local op_name="$1"
    local est_time_ms="$2"
    local command="$3"
    local double_time_ms=$((est_time_ms * 2))

    local status_file="${CHECK_STATUS_DIR}/${op_name}_status"
    local check1_file="${CHECK_STATUS_DIR}/${op_name}_check1"
    local check2_file="${CHECK_STATUS_DIR}/${op_name}_check2"

    echo "PENDING:${op_name}" > "$status_file"
    echo "NOT_STARTED" > "$check1_file"
    echo "NOT_STARTED" > "$check2_file"

    echo "[DOUBLE_CHECK] Starting operation: ${op_name} (est=${est_time_ms}ms, timeout=${double_time_ms}ms)" >> "$DOUBLE_CHECK_LOG"

    # Demon 1 — Execute the command
    (
        echo "RUNNING" > "$check1_file"
        local start_ns=$(date +%s%N)

        # Run the actual command
        eval "$command" &
        local cmd_pid=$!

        # Wait for command completion with timeout (2× estimated time)
        local waited=0
        local timeout_ns=$((double_time_ms * 1000000))
        local check_interval=0.01  # 10ms polling

        while kill -0 $cmd_pid 2>/dev/null; do
            sleep $check_interval
            local now_ns=$(date +%s%N)
            local elapsed_ns=$((now_ns - start_ns))

            if (( elapsed_ns > timeout_ns )); then
                echo "TIMEOUT" > "$check1_file"
                echo "FAILED:TIMEOUT" > "$status_file"
                kill $cmd_pid 2>/dev/null || true
                echo "[DOUBLE_CHECK] DEMON1: Operation '${op_name}' TIMEOUT after ${elapsed_ns}ns (limit=${timeout_ns}ns)" >> "$DOUBLE_CHECK_LOG"
                return 1
            fi
        done

        wait $cmd_pid
        local cmd_exit=$?

        if (( cmd_exit != 0 )); then
            echo "FAILED_EXIT_${cmd_exit}" > "$check1_file"
            echo "FAILED:EXIT_CODE" > "$status_file"
            echo "[DOUBLE_CHECK] DEMON1: Operation '${op_name}' FAILED with exit code ${cmd_exit}" >> "$DOUBLE_CHECK_LOG"
            return 1
        fi

        local end_ns=$(date +%s%N)
        local duration_ms=$(( (end_ns - start_ns) / 1000000 ))
        echo "COMPLETED:${duration_ms}ms" > "$check1_file"
        echo "[DOUBLE_CHECK] DEMON1: Operation '${op_name}' completed in ${duration_ms}ms" >> "$DOUBLE_CHECK_LOG"
    ) &
    local demon1_pid=$!

    # Demon 2 — Verify Demon 1's result (waits 2× Demon 1's estimated completion)
    (
        sleep 0.1  # Give Demon 1 time to start

        local start_ns=$(date +%s%N)
        local total_timeout_ns=$((double_time_ms * 2 * 1000000))  # 4× estimated time total

        while true; do
            local check1_status=$(cat "$check1_file" 2>/dev/null || echo "MISSING")

            case "$check1_status" in
                COMPLETED:*)
                    echo "VERIFIED" > "$check2_file"
                    echo "[DOUBLE_CHECK] DEMON2: Verified Demon 1 completed successfully for '${op_name}'" >> "$DOUBLE_CHECK_LOG"
                    echo "PASSED" > "$status_file"
                    return 0
                    ;;
                FAILED_*|TIMEOUT)
                    echo "VERIFIED_FAIL" > "$check2_file"
                    echo "[DOUBLE_CHECK] DEMON2: Confirmed Demon 1 FAILED for '${op_name}' (${check1_status})" >> "$DOUBLE_CHECK_LOG"
                    echo "FAILED:DEMON1_FAIL" > "$status_file"
                    return 1
                    ;;
                *)
                    # Check if Demon 1 is still running (shouldn't be, but verify)
                    if ! kill -0 $demon1_pid 2>/dev/null; then
                        # Demon 1 died without writing status
                        echo "DEMON1_DIED" > "$check2_file"
                        echo "FAILED:DEMON1_DIED" > "$status_file"
                        echo "[DOUBLE_CHECK] DEMON2: Demon 1 process died for '${op_name}'" >> "$DOUBLE_CHECK_LOG"
                        return 1
                    fi
                    ;;
            esac

            local now_ns=$(date +%s%N)
            local elapsed_ns=$((now_ns - start_ns))

            if (( elapsed_ns > total_timeout_ns )); then
                echo "TIMEOUT" > "$check2_file"
                echo "FAILED:TIMEOUT_DEMON2" > "$status_file"
                echo "[DOUBLE_CHECK] DEMON2: Total timeout exceeded for '${op_name}'" >> "$DOUBLE_CHECK_LOG"
                return 1
            fi

            sleep 0.05  # 50ms polling
        done
    ) &
    local demon2_pid=$!

    # Demon 3 — Verify Demon 2 is checking Demon 1
    (
        sleep 0.2  # Give both daemons time to start

        local start_ns=$(date +%s%N)
        local demon3_timeout_ns=$((double_time_ms * 3 * 1000000))  # 6× estimated time

        while true; do
            local check2_status=$(cat "$check2_file" 2>/dev/null || echo "MISSING")

            case "$check2_status" in
                VERIFIED|VERIFIED_FAIL|DEMON1_DIED|TIMEOUT)
                    # Demon 2 has completed its verification — success
                    echo "[DOUBLE_CHECK] DEMON3: Confirmed Demon 2 completed for '${op_name}'" >> "$DOUBLE_CHECK_LOG"
                    return 0
                    ;;
                *)
                    # Demon 2 is still running — check if it's alive
                    if ! kill -0 $demon2_pid 2>/dev/null; then
                        echo "FAILED:DEMON2_DIED" > "$status_file"
                        echo "[DOUBLE_CHECK] DEMON3: Demon 2 died while checking '${op_name}'" >> "$DOUBLE_CHECK_LOG"
                        return 1
                    fi
                    ;;
            esac

            local now_ns=$(date +%s%N)
            local elapsed_ns=$((now_ns - start_ns))

            if (( elapsed_ns > demon3_timeout_ns )); then
                echo "FAILED:TIMEOUT_DEMON3" > "$status_file"
                echo "[DOUBLE_CHECK] DEMON3: Timeout waiting for Demon 2 to complete for '${op_name}'" >> "$DOUBLE_CHECK_LOG"
                return 1
            fi

            sleep 0.1  # 100ms polling for Demon 3
        done
    ) &
    local demon3_pid=$!

    # Wait for Demon 2 and Demon 3
    wait $demon1_pid 2>/dev/null || true
    wait $demon2_pid 2>/dev/null || true
    local d2_exit=$?
    wait $demon3_pid 2>/dev/null || true
    local d3_exit=$?

    # Read final status
    local final_status=$(cat "$status_file" 2>/dev/null || echo "UNKNOWN")

    if [[ "$final_status" == "PASSED" ]]; then
        echo "[DOUBLE_CHECK] SUCCESS: '${op_name}' passed all three check daemons" >> "$DOUBLE_CHECK_LOG"
        return 0
    else
        echo "[DOUBLE_CHECK] FAILED: '${op_name}' final status: ${final_status}" >> "$DOUBLE_CHECK_LOG"
        return 1
    fi
}

#=============================================================================
# USAGE EXAMPLES
#=============================================================================

run_examples() {
    echo "=== DRONE-X Double-Check Protocol Examples ==="
    echo ""

    # Example 1: Quick operation that succeeds
    echo "Example 1: Quick successful operation (est=100ms, actual ~50ms)"
    double_check "quick_test" 100 "sleep 0.05"
    echo "Result: $?"
    echo ""

    # Example 2: Operation that times out
    echo "Example 2: Timeout operation (est=100ms, actual ~500ms, timeout at 200ms)"
    double_check "timeout_test" 100 "sleep 0.5"
    echo "Result: $?"
    echo ""

    # Example 3: Simulated motor command verification
    echo "Example 3: Motor command verification (simulated)"
    double_check "motor_cmd_check" 5 "echo 'MOTORS_OK'"
    echo "Result: $?"
    echo ""

    # Example 4: Failed command
    echo "Example 4: Failed command test"
    double_check "fail_test" 50 "false"
    echo "Result: $?"
    echo ""
}

#=============================================================================
# MAIN
#=============================================================================

main() {
    local command="${1:-help}"

    case "$command" in
        help)
            echo "DRONE-X Double-Check Protocol"
            echo "Usage: $0 {test|examples}"
            echo ""
            echo "  test     — Run verification of the double-check protocol"
            echo "  examples — Run example operations to demonstrate the protocol"
            echo ""
            echo "Typical usage from other scripts:"
            echo "  source dronex_double_check.sh"
            echo '  double_check "my_op" 100 "my_command"'
            ;;
        test)
            echo "Running double-check protocol verification..."
            # Test that the triple-check works correctly
            double_check "verify_self" 50 "true"
            local result=$?
            echo ""
            echo "Self-verification result: $result"
            if (( result == 0 )); then
                echo "Double-check protocol: PASSED"
            else
                echo "Double-check protocol: FAILED"
            fi
            ;;
        examples)
            run_examples
            ;;
    esac
}

# Run main if called directly
if [[ "${BASH_SOURCE[0]}" == "${0}" ]]; then
    main "$@"
fi
