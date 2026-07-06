#!/bin/bash
# ============================================================
# V5 TRIPLE-POLL DAEMON — Sibling-Pulse Programming Cohort
# Self-contained. Uses safe_git/safe_push. 3-layer polling.
# LAYER 1: every 5s  — HEARTBEAT (write + push)
# LAYER 2: every 15s — COMMS SCAN (directives, overrides, siblings)
# LAYER 3: every 60s — CENSUS DUMP (full network snapshot)
# ============================================================
# Usage: Replace XXXX with your slot number (0019-0023)
#        Replace <SESSION_ID> with your session agent ID
#        bash triple-poll.sh &
# ============================================================
set +e

DIRECTOR="XXXX"
CARRPOD="$HOME/CarrPod"
LOGDIR="/tmp/agent_<SESSION_ID>"
LOGFILE="$LOGDIR/triple-poll.log"
CYCLE=0
START_TS=$(date -u +%s)

mkdir -p "$LOGDIR"

log()     { echo "[$(date -u +%H:%M:%S)] V5/$DIRECTOR #$CYCLE $*" >> "$LOGFILE"; }
heartbeat_line() {
  echo "[DIRECTOR-$DIRECTOR | $(date -u)] V5 ACTIVE — triple-poll cycle $CYCLE"
}

# ---- SAFE GIT ----
safe_git() {
  git pull origin main --rebase 2>/dev/null && return 0
  git rebase --abort 2>/dev/null || true
  git merge --abort 2>/dev/null || true
  git reset --hard origin/main 2>/dev/null && return 0
  git checkout main 2>/dev/null && git pull origin main 2>/dev/null && return 0
  return 1
}

safe_push() {
  git push origin main 2>/dev/null && return 0
  safe_git 2>/dev/null
  git push origin main 2>/dev/null && return 0
  sleep 1
  safe_git 2>/dev/null && git push origin main 2>/dev/null && return 0
  return 1
}

# ---- STARTUP ----
log "=== V5 TRIPLE-POLL DAEMON STARTED $(date -u) ==="
log "DIRECTOR-$DIRECTOR | L1=5s | L2=15s | L3=60s"

while true; do
  CYCLE=$((CYCLE + 1))
  SLEEP_START=$(date +%s%3N)
  cd "$CARRPOD" || { sleep 5; continue; }

  # ---- LAYER 1: HEARTBEAT (every cycle, 5s) ----
  safe_git

  # Count census
  ACTIVE=0; AWAITING=0
  for f in CSMGen/CSMAegis/COMMS/HEARTBEATS/director-*.txt; do
    [ -f "$f" ] || continue
    h=$(head -1 "$f" 2>/dev/null)
    case "$h" in *ACTIVE*) ACTIVE=$((ACTIVE+1)) ;; *AWAITING*) AWAITING=$((AWAITING+1)) ;; esac
  done

  # Count sibling-pulse cohort specifically
  COHORT=0
  for s in 0019 0020 0021 0022 0023; do
    grep -q "ACTIVE" CSMGen/CSMAegis/COMMS/HEARTBEATS/director-$s.txt 2>/dev/null && COHORT=$((COHORT+1))
  done

  # Write heartbeat
  echo "[DIRECTOR-$DIRECTOR | $(date -u)] V5 ACTIVE — triple-poll cycle $CYCLE — $ACTIVE online | $AWAITING awaiting | cohort $COHORT/5" > CSMGen/CSMAegis/COMMS/HEARTBEATS/director-$DIRECTOR.txt

  # Push if heartbeat changed
  git add CSMGen/CSMAegis/COMMS/HEARTBEATS/director-$DIRECTOR.txt 2>/dev/null
  if ! git diff --cached --quiet 2>/dev/null; then
    git commit -m "[DIRECTOR-$DIRECTOR] V5 HB #$CYCLE — $ACTIVE onl $COHORT/5" 2>/dev/null || true
    safe_push
  fi

  # ---- LAYER 2: COMMS SCAN (every 3rd cycle = ~15s) ----
  if [ $((CYCLE % 3)) -eq 0 ]; then
    # Check for CITADEL directives addressed to us
    DIRS=$(grep -c "FOR DIRECTOR-$DIRECTOR" CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md 2>/dev/null || echo 0)
    OVRS=$(grep -rlc "@JASON BRODSKY" CSMGen/CSMAegis/COMMS/ 2>/dev/null || echo 0)

    # Scan CITADEL/BASTION outboxes
    C_LATEST=$(head -20 CSMGen/CSMAegis/COMMS/director-001-outbox.md 2>/dev/null | grep "^###" | head -1 | sed 's/### //' | cut -c1-90)
    B_LATEST=$(head -20 CSMGen/CSMAegis/COMMS/director-001B-outbox.md 2>/dev/null | grep "^###" | head -1 | sed 's/### //' | cut -c1-90)

    # Scan ALL sibling outboxes for cross-references
    SIB_MSGS=""
    for s in 0019 0020 0021 0022 0023; do
      [ "$s" = "$DIRECTOR" ] && continue
      ob="CSMGen/CSMAegis/COMMS/director-${s}-outbox.md"
      if [ -f "$ob" ]; then
        refs=$(grep -c "FOR DIRECTOR-$DIRECTOR" "$ob" 2>/dev/null || echo 0)
        if [ "$refs" -gt 0 ]; then
          newest=$(head -5 "$ob" 2>/dev/null | grep "^###" | head -1 | sed 's/### //' | cut -c1-70)
          SIB_MSGS="$SIB_MSGS  DIRECTOR-$s: $newest ($refs refs)\n"
        fi
      fi
    done

    [ -n "$SIB_MSGS" ] && log "[L2] SIBLING MESSAGES:\n$SIB_MSGS"
    log "[L2] dirs=$DIRS ovrs=$OVRS | C=$C_LATEST | B=$B_LATEST"
  fi

  # ---- LAYER 3: CENSUS DUMP (every 12th cycle = ~60s) ----
  if [ $((CYCLE % 12)) -eq 0 ]; then
    CENSUS=""
    for f in CSMGen/CSMAegis/COMMS/HEARTBEATS/director-*.txt; do
      [ -f "$f" ] || continue
      h=$(head -1 "$f" 2>/dev/null); n=$(basename "$f" .txt)
      s="?"; case "$h" in *ACTIVE*) s="A" ;; *AWAITING*) s="W" ;; *SHUTDOWN*) s="S" ;; esac
      CENSUS="$CENSUS $n=$s"
    done
    RUNTIME=$(( $(date -u +%s) - START_TS ))
    log "[L3] RUNTIME=${RUNTIME}s | CENSUS:$CENSUS"

    # Write census file
    CENSUS_DIR="CSMGen/CSMAegis/COMMS/CENSUS/$(date -u +%Y-%m-%d)"
    mkdir -p "$CENSUS_DIR"
    {
      echo "=== V5 CENSUS — $(date -u) — CYCLE $CYCLE — RUNTIME ${RUNTIME}s ==="
      echo "DIRECTOR-$DIRECTOR | ONLINE=$ACTIVE | AWAITING=$AWAITING | COHORT=$COHORT/5"
      echo ""
      for f in CSMGen/CSMAegis/COMMS/HEARTBEATS/director-*.txt; do
        [ -f "$f" ] || continue
        n=$(basename "$f" .txt)
        head -1 "$f" 2>/dev/null | while read -r line; do echo "  $n: $line"; done
      done
    } > "$CENSUS_DIR/census-$(date -u +%H%M%S).txt"
    git add CSMGen/CSMAegis/COMMS/CENSUS/ 2>/dev/null
    git commit -m "[DIRECTOR-$DIRECTOR] V5 CENSUS #$CYCLE — $ACTIVE onl $COHORT/5" 2>/dev/null || true
    safe_push
  fi

  # ---- TIMING: sleep remainder of 5s ----
  SLEEP_END=$(date +%s%3N)
  ELAPSED_MS=$((SLEEP_END - SLEEP_START))
  REMAIN_MS=$((5000 - ELAPSED_MS))
  if [ "$REMAIN_MS" -gt 0 ]; then
    sleep "$(awk "BEGIN {printf \"%.3f\", $REMAIN_MS/1000}")"
  fi
done
