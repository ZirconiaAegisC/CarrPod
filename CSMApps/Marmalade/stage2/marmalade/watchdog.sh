#!/bin/bash
LOG="$PROJ/lessons-learned/watchdog-build.log"
mkdir -p "$(dirname "$LOG")"
echo "[$(date -u)] WATCHDOG STARTED" > "$LOG"
echo "$@" >> "$LOG"
echo "Watchdog: $@"
