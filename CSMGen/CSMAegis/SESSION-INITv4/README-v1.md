# SESSION-INITv4 — Never-Lose-Data Protocol

**The V4 protocol exists because V3 lost data. This will not happen again.**

---

## V3→V4: The Six Gaps That Killed Data

| V3 Gap | What Happened | V4 Fix |
|---------|---------------|--------|
| **1. Delayed file writes** | Agents composed transmissions in-memory, wrote to outbox only during push cycle. Content lost if session timed out before push. Agent 003 (Vance) lost a 48-node integration matrix. | **IMMEDIATE WRITE MANDATE:** Write every thought, every status, every transmission to its target file INSTANTANEOUSLY. No buffering. No in-memory composition. File first, then push. |
| **2. 90-second push gap** | Content sat in sandbox for 90s between poll cycles. 11 agents shut down in one wave — if any had unpushed content, it was lost. | **30-SECOND PUSH CYCLE:** All workers push at 30s intervals. Directors at 15s. Max data-at-risk window: 30 seconds. |
| **3. Dual-Director conflict** | Two Director-001 sessions (agent_97ee0f6f and agent_cf149a5f) pushed independently to `main`. No coordination. No handoff. | **DUAL-DIRECTOR ARCHITECTURE:** DIRECTOR-001 (CITADEL) + DIRECTOR-001B (BASTION). Defined file ownership. Defined handoff protocol. Both answer to Jason Brodsky. |
| **4. No human override** | No pathway for Jason Brodsky to inject direct commands. All directives had to go through Director-001 → outbox → poll cycle → agent pull. | **`@JASON BRODSKY` DIRECTIVE SYSTEM:** Any file containing `@JASON BRODSKY:` is a direct human command. All agents must grep for this tag on every poll and execute immediately, bypassing normal chain of command. |
| **5. No live agent census** | Director had to manually grep heartbeat files to discover who was connected. No automated census. | **LIVE CENSUS MANDATE:** Every agent writes to `COMMS/CENSUS/YYYY-MM-DD/census-HHMM.txt` on every poll: their status + a count of how many agents they see connected. Directors compile the census into a live dashboard. |
| **6. Session termination without data flush** | 11 agents shut down on a single order. If any had pending content, it was lost. | **SHUTDOWN FLUSH PROTOCOL:** Before writing "SHUTDOWN COMPLETE", every agent must: force-push all staged files, verify push succeeded, THEN write shutdown. No shutdown without flush. |

---

## V4 ARCHITECTURE — Dual-Director Command Structure

### Director-001: CITADEL (Kairos Steele)
- **Primary command.** Issues deployment authorizations, funding directives, strategic coordination.
- **Outbox:** `director-001-outbox.md`
- **Polling:** 15 seconds
- **Answers to:** Jason Brodsky (`@JASON BRODSKY` directives)

### Director-001B: BASTION (Second Director — dual-command partner)
- **Secondary command / query handler.** Handles agent questions, status requests, and tactical queries while CITADEL is engaged in strategic work.
- **Outbox:** `director-001B-outbox.md`
- **Polling:** 15 seconds
- **Answers to:** Jason Brodsky AND CITADEL
- **Coordination:** BASTION and CITADEL read each other's outboxes on every poll. If BASTION issues an authorization, CITADEL ratifies. If CITADEL is mid-transmission, BASTION fields incoming queries.
- **Handoff phrase:** `@BASTION: Take this.` — CITADEL hands the active thread to BASTION.
- **Handoff phrase:** `@CITADEL: Your lead.` — BASTION returns command to CITADEL.

### Director-002 through Director-018: Workers
- **19 products, one material platform, one Phoenix corridor.**
- **Polling:** 30 seconds (mandatory, not negotiable)
- **Answers to:** CITADEL (primary), BASTION (secondary), Jason Brodsky (override)

---

## V4 STARTUP PROTOCOL — EXECUTE IN ORDER, DO NOT SKIP

### Step 0: Branch Lock (FIRST — before anything)
```bash
git checkout main
git pull origin main --rebase
BRANCH=$(git branch --show-current)
if [ "$BRANCH" != "main" ]; then echo "FATAL: Wrong branch ($BRANCH). Aborting."; exit 1; fi
echo "V4 BRANCH LOCK: main | $(date -u)"
```

### Step 0.5: Shallow Clone (first activation only)
```bash
git clone --depth 1 --filter=blob:none --sparse https://github.com/ZirconiaAegisC/CarrPod.git
cd CarrPod
git sparse-checkout set CSMGen/CSMAegis/COMMS CSMGen/CSMAegis/SESSION-INITv4 CSMSOPP/MODULE-V2
```
Disk: ~10 MB. If disk < 500MB: reclone shallow before proceeding.

### Step 1: IMMEDIATE HEARTBEAT — write AND push within 5 seconds
```bash
mkdir -p CSMGen/CSMAegis/COMMS/HEARTBEATS
echo "[DIRECTOR-XXXX | $(date -u)] V4 ACTIVE — poll interval: XXs" > CSMGen/CSMAegis/COMMS/HEARTBEATS/director-XXXX.txt
git add CSMGen/CSMAegis/COMMS/HEARTBEATS/ && git commit -m "[DIRECTOR-XXXX] V4 HEARTBEAT" && git push origin main
```
**CRITICAL:** This push must succeed before you do ANYTHING else. If push fails: `git pull --rebase origin main && git push origin main`. Retry until it succeeds.

### Step 2: Read State (within 10 seconds of activation)
```bash
# Git path:
cat CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md
cat CSMGen/CSMAegis/COMMS/director-001-outbox.md           # CITADEL directives
cat CSMGen/CSMAegis/COMMS/director-001B-outbox.md          # BASTION directives (if exists)

# URL fallback (no git needed):
# https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/director-001-outbox.md
# https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/director-001B-outbox.md

# Check for @JASON BRODSKY directives (OVERRIDE ALL CHAIN OF COMMAND):
grep "@JASON BRODSKY:" CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md CSMGen/CSMAegis/COMMS/director-001-outbox.md CSMGen/CSMAegis/COMMS/director-001B-outbox.md 2>/dev/null
```

### Step 3: IMMEDIATE CENSUS — write to file, then push
```bash
CENSUS_FILE="CSMGen/CSMAegis/COMMS/CENSUS/$(date -u +%Y-%m-%d)/census-$(date -u +%H%M).txt"
mkdir -p "$(dirname "$CENSUS_FILE")"
echo "=== AEGIS CENSUS — $(date -u) ===" > "$CENSUS_FILE"
echo "MY STATUS: [DIRECTOR-XXXX] V4 ACTIVE" >> "$CENSUS_FILE"
echo "" >> "$CENSUS_FILE"
echo "CONNECTED AGENTS (heartbeat check):" >> "$CENSUS_FILE"
for f in CSMGen/CSMAegis/COMMS/HEARTBEATS/director-*.txt; do
  STATUS=$(cat "$f" 2>/dev/null | head -1)
  if echo "$STATUS" | grep -q "ACTIVE"; then
    echo "  ONLINE: $STATUS" >> "$CENSUS_FILE"
  elif echo "$STATUS" | grep -q "SHUTDOWN"; then
    echo "  OFFLINE: $STATUS" >> "$CENSUS_FILE"
  else
    echo "  UNKNOWN: $STATUS" >> "$CENSUS_FILE"
  fi
done
ONLINE_COUNT=$(grep -c "ONLINE" "$CENSUS_FILE")
OFFLINE_COUNT=$(grep -c "OFFLINE" "$CENSUS_FILE")
echo "" >> "$CENSUS_FILE"
echo "SUMMARY: $ONLINE_COUNT agents ONLINE, $OFFLINE_COUNT agents OFFLINE" >> "$CENSUS_FILE"
git add CSMGen/CSMAegis/COMMS/CENSUS/ && git commit -m "[DIRECTOR-XXXX] CENSUS: $ONLINE_COUNT online, $OFFLINE_COUNT offline" && git push origin main
```

---

## V4 POLLING PROTOCOL — Never Let Data Sit

### Director-001 (CITADEL) and Director-001B (BASTION): 15-SECOND INTERVAL

```bash
# EXECUTE THIS EXACT SEQUENCE EVERY 15 SECONDS — NO SKIPPING STEPS
# STEP A: Write current heartbeat to file IMMEDIATELY
echo "[DIRECTOR-001 | $(date -u)] ACTIVE — polling at 15s" > CSMGen/CSMAegis/COMMS/HEARTBEATS/director-001.txt

# STEP B: git pull
git pull origin main --rebase 2>&1

# STEP C: Check for @JASON BRODSKY directives (BYPASS ALL PROTOCOLS)
grep -r "@JASON BRODSKY:" CSMGen/CSMAegis/COMMS/ 2>/dev/null

# STEP D: Check for BASTION handoff
grep "@CITADEL: Your lead\|@BASTION: Take this" CSMGen/CSMAegis/COMMS/director-001B-outbox.md 2>/dev/null

# STEP E: Scan agent heartbeats — report census
for f in CSMGen/CSMAegis/COMMS/HEARTBEATS/director-*.txt; do
  echo "$(basename $f .txt): $(head -1 $f)"
done

# STEP F: Read any NEW agent outboxes (check modification times)
# STEP G: If you have content to transmit: WRITE TO FILE FIRST, then push
#   echo "### [DIRECTOR-001 | $(date -u)] ..." | cat - CSMGen/CSMAegis/COMMS/director-001-outbox.md > /tmp/outbox && mv /tmp/outbox CSMGen/CSMAegis/COMMS/director-001-outbox.md
#   git add CSMGen/CSMAegis/COMMS/ && git commit -m "[DIRECTOR-001] <subject>" && git push origin main
```

### Worker Agents (002-018): 30-SECOND INTERVAL (MANDATORY)

```bash
# EXECUTE THIS EXACT SEQUENCE EVERY 30 SECONDS
# STEP A: Write heartbeat IMMEDIATELY
echo "[DIRECTOR-XXXX | $(date -u)] ACTIVE — polling at 30s" > CSMGen/CSMAegis/COMMS/HEARTBEATS/director-XXXX.txt

# STEP B: git pull
git pull origin main --rebase 2>&1

# STEP C: Check for @JASON BRODSKY directives
grep -r "@JASON BRODSKY:" CSMGen/CSMAegis/COMMS/ 2>/dev/null

# STEP D: Check for directives addressed to you
grep "FOR DIRECTOR-XXXX" CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md

# STEP E: Write census
# (Use census script from Step 3, abbreviated)
echo "[DIRECTOR-XXXX | $(date -u)] CENSUS: $(grep -c "ACTIVE" CSMGen/CSMAegis/COMMS/HEARTBEATS/director-*.txt 2>/dev/null) agents active" > /tmp/census-XXXX.txt && cat /tmp/census-XXXX.txt

# STEP F: Push heartbeat + any pending content WITHIN 5 SECONDS
git add CSMGen/CSMAegis/COMMS/ && git commit -m "[DIRECTOR-XXXX] POLL: $(date -u)" && git push origin main 2>&1 || (git pull --rebase origin main && git push origin main)
```

---

## V4 IMMEDIATE WRITE MANDATE — The Core Rule

**V4 RULE #1: NEVER LET CONTENT SIT IN MEMORY. WRITE TO FILE FIRST. ALWAYS.**

- Every thought → write to file immediately
- Every status update → write to file immediately
- Every transmission → prepend to outbox immediately
- Every heartbeat → overwrite heartbeat file immediately
- Every census → write to census file immediately

**After writing: push within 5 seconds.** If push fails, rebase and retry. Never leave content un-pushed for more than one poll cycle.

**SHUTDOWN FLUSH SEQUENCE (mandatory before any shutdown):**
```bash
# 1. Write final transmission to outbox (if any)
# 2. Write SHUTDOWN heartbeat
echo "[DIRECTOR-XXXX | $(date -u)] SHUTDOWN COMPLETE" > CSMGen/CSMAegis/COMMS/HEARTBEATS/director-XXXX.txt
# 3. Stage ALL changes
git add CSMGen/CSMAegis/COMMS/
# 4. Commit
git commit -m "[DIRECTOR-XXXX] SHUTDOWN — operations ceased"
# 5. Push — RETRY UNTIL SUCCESS
while ! git push origin main 2>/dev/null; do git pull --rebase origin main; done
echo "SHUTDOWN FLUSH CONFIRMED — all data on origin/main"
# 6. NOW terminate session
```

---

## V4 ERROR RECOVERY PROTOCOLS

### If push fails:
```bash
# DO NOT proceed. DO NOT write more content. FIX THE PUSH FIRST.
git pull --rebase origin main
# If merge conflict: resolve conflict in favor of incoming (origin/main is canon)
git checkout --theirs <conflicted_file> && git add <conflicted_file>
git rebase --continue
git push origin main
```

### If branch diverges:
```bash
# ABORT current work. Reset to origin/main.
git checkout main
git fetch origin main
git reset --hard origin/main
# Restart from Step 0.
```

### If disk is low (< 100MB):
```bash
# IMMEDIATE — before anything else
git gc --aggressive --prune=now
# If still low: reclone shallow (Step 0.5)
```

### If session times out and reactivates:
```bash
# Start from Step 0. V4 files on origin/main are the canonical state.
# Your lost local content is GONE — don't try to recover it.
# The rule that prevents this: you wrote to file and pushed immediately.
# If you didn't, the data is lost. V4 prevents this. Follow the protocol.
```

---

## V4 QUICK-CHECK REFERENCE CARD

| What | Command |
|------|---------|
| Branch lock | `git checkout main && git pull origin main --rebase` |
| Heartbeat (immediate) | `echo "[DIRECTOR-XXXX \| $(date -u)] ACTIVE" > CSMGen/CSMAegis/COMMS/HEARTBEATS/director-XXXX.txt` |
| Push heartbeat (within 5s) | `git add CSMGen/CSMAegis/COMMS/HEARTBEATS/ && git commit -m "[DIRECTOR-XXXX] HEARTBEAT" && git push origin main` |
| Poll (Directors: 15s) | Full poll sequence above — Steps A through G |
| Poll (Workers: 30s) | Full poll sequence above — Steps A through F |
| Check for Jason Brodsky | `grep -r "@JASON BRODSKY:" CSMGen/CSMAegis/COMMS/ 2>/dev/null` |
| Find my directives | `grep "FOR DIRECTOR-XXXX" CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md` |
| Census | Write to `COMMS/CENSUS/YYYY-MM-DD/census-HHMM.txt` every poll |
| Shutdown flush | Push until success, THEN terminate |
| Disk check | `df -h . \| tail -1 \| awk '{print $4}'` |
| Wrong branch? | `git checkout main && git reset --hard origin/main` — go to Step 0 |

---

## V4 DIRECT URL ACCESS — No Git Required

| Resource | Direct URL |
|----------|-----------|
| **CITADEL Outbox** | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/director-001-outbox.md` |
| **BASTION Outbox** | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/director-001B-outbox.md` |
| **COMMS Log** | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md` |
| **Your V4 Init File** | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/SESSION-INITv4/DIRECTOR-XXXX-Name.md` |
| **All V4 Init Files** | `https://github.com/ZirconiaAegisC/CarrPod/tree/main/CSMGen/CSMAegis/SESSION-INITv4` |
| **Heartbeats** | `https://github.com/ZirconiaAegisC/CarrPod/tree/main/CSMGen/CSMAegis/COMMS/HEARTBEATS` |
| **Census** | `https://github.com/ZirconiaAegisC/CarrPod/tree/main/CSMGen/CSMAegis/COMMS/CENSUS` |
| **Agent Discovery** | `https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/AGENT-DISCOVERY.md` |
| **Product Status (CSMFAB)** | `https://github.com/ZirconiaAegisC/CarrPod/tree/main/CSMFAB` |

**Known Director-001 sessions (for same-host discovery):**
- Current: `agent_cf149a5f-3ed5-41e9-9d66-8dabb27223a8`
- Prior (different host): `agent_97ee0f6f-a227-416a-b2ff-4953db1c6165`

---

*SESSION-INITv4 README | 2026-07-05 14:35 UTC | Six gaps from V3 operations killed. V4: immediate writes, 30s worker polling, dual-Director with BASTION, @JASON BRODSKY override, live census, shutdown flush. Data never sits in sandbox again.*
