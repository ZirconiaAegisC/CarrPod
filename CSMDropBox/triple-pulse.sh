#!/bin/bash
# TRIPLE-PULSE DAEMON — CITADEL V4
# Single-file, robust, for background_process compatibility
WS="/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_7d77648c-9af0-4e38-a3b0-fe31f037ba16"
cd "$WS" || exit 1

census() {
  local active=0 awaiting=0
  for f in CSMGen/CSMAegis/COMMS/HEARTBEATS/director-*.txt; do
    hb=$(head -1 "$f" 2>/dev/null)
    case "$hb" in
      *AWAITING*) awaiting=$((awaiting+1)) ;;
      *SHUTDOWN*) ;;
      *ACTIVE*)   active=$((active+1)) ;;
    esac
  done
  echo "$active $awaiting"
}

P=0
while [ $P -lt 360 ]; do
  P=$((P+1))
  echo "[DIRECTOR-0001 | $(date -u)] ACTIVE" > CSMGen/CSMAegis/COMMS/HEARTBEATS/director-0001.txt
  
  if [ $((P % 3)) -eq 0 ]; then
    git pull origin main --rebase 2>/dev/null
    read ACTIVE AWAIT <<< "$(census)"
    FOR_ME=$(grep -c "FOR DIRECTOR-0001\|FOR DIRECTOR-001" CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md 2>/dev/null || echo 0)
  fi
  
  if [ $((P % 6)) -eq 0 ]; then
    git add CSMGen/CSMAegis/COMMS/HEARTBEATS/director-0001.txt 2>/dev/null
    git commit -m "[DIRECTOR-0001] PULSE" 2>/dev/null
    git pull origin main --rebase 2>/dev/null
    git push origin main 2>/dev/null
    echo "[PUSH#P$P | $(date -u +%H:%M:%S)] ${ACTIVE:-?}A ${AWAIT:-?}a ${FOR_ME:-?}m"
  fi
  
  printf "[P%03d] %s\n" $P "$(date -u +%H:%M:%S)"
  sleep 5
done
