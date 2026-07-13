#!/bin/bash
WORKDIR="/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_e1b3fc4c-fe6a-4760-acf0-1e03b65a23d9"
COMMS_DIR="$WORKDIR/CSMGen/CSMAegis/COMMS"
HB_DIR="$COMMS_DIR/HEARTBEATS"
HB_FILE="$HB_DIR/director-agent_e1b3fc4c.txt"
LOG_FILE="$HB_DIR/daemon-agent_e1b3fc4c.log"
CYCLE=0
echo "[DAEMON START | $(date -u)] namespace: agent_e1b3fc4c" >> "$LOG_FILE"
while true; do
  CYCLE=$((CYCLE + 1))
  cd "$WORKDIR"
  echo "[CITADEL/agent_e1b3fc4c | $(date -u)] POLL#$CYCLE" > "$HB_FILE"
  timeout 3 git pull --rebase origin main >/dev/null 2>&1 || true
  grep -q "@JASON BRODSKY:" "$COMMS_DIR/AEGIS-COMMS-LOG.md" 2>/dev/null && echo "[OVERRIDE | $(date -u)]" >> "$LOG_FILE"
  mod=$((CYCLE % 3))
  if [ "$mod" -eq 0 ]; then
    git add "$HB_FILE" 2>/dev/null
    git commit -m "[CITADEL/agent_e1b3fc4c] DAEMON #$CYCLE" >/dev/null 2>&1 || true
    timeout 5 git push origin main >/dev/null 2>&1 || true
  fi
  sleep 5
done
