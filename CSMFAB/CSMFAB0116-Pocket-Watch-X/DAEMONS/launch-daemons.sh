#!/usr/bin/env bash
# =============================================================================
# TRIPLE-DAEMON LAUNCHER — Pocket Watch X
# =============================================================================
set -euo pipefail

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
export CSMFAB_BUILD_DIR="$DIR"
export CSMFAB_LOG_DIR="${CSMFAB_LOG_DIR:-/tmp/pocket-watch-x-daemon-logs}"

mkdir -p "$CSMFAB_LOG_DIR"

echo "=== POCKET WATCH X — DAEMON LAUNCH ==="
echo "  MD  → watches CD2"
echo "  CD2 → watches CD1"
echo "  CD1 → verifies commands"

"$DIR/stop-daemons.sh" 2>/dev/null || true
sleep 1

nohup bash "$DIR/monitor-daemon.sh" > "$CSMFAB_LOG_DIR/md-stdout.log" 2>&1 &
echo "  Monitor Daemon:  $!"
sleep 1
nohup bash "$DIR/check-daemon-2.sh" > "$CSMFAB_LOG_DIR/cd2-stdout.log" 2>&1 &
echo "  Check Daemon 2:  $!"
sleep 1
nohup bash "$DIR/check-daemon-1.sh" > "$CSMFAB_LOG_DIR/cd1-stdout.log" 2>&1 &
echo "  Check Daemon 1:  $!"
sleep 2
echo "=== ALL DAEMONS RUNNING ==="
echo "  Health: cat $CSMFAB_LOG_DIR/master-health.log"
echo "  Stop:   bash $DIR/stop-daemons.sh"
