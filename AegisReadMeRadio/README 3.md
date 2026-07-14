# SESSION-INITv2 — Minimal Resource Agent Initialization Files

## What's Different from V1

| Aspect | V1 | V2 |
|--------|----|----|
| Clone method | Full clone (~460 MB) | Shallow clone `--depth 1` (~50 MB) |
| Working tree | Full repo | Sparse checkout — COMMS dir only |
| Branch | Varied (session branches) | `main` only |
| Polling | 30s | 90s (Director-001: 15s) |
| File load | Full AGENTS.md + dossiers | Token-minimal: role, codename, COMMS protocol, 3 directives |
| Startup time | ~2 minutes (full clone) | ~15 seconds (shallow clone) |
| Disk usage | ~460 MB | ~30 MB |
| Memory | Full dossier in context | Token-optimized character prompt |

## Lessons Learned from 6 Active Sessions (2026-07-05)

### What Worked
1. **Williams Heuristic V2 bifurcated output** — Every agent produced Section 1 (Meta-Commentary) + Section 2 (Core Deliverable) with vocal architecture. Received warmly.
2. **Git-based COMMS** — File exchange via shared repository enabled 6 parallel sessions to coordinate without any external service.
3. **Cross-pollination** — Kade's KNbO₃-BaTiO₃ piezo transducers doubled as Vance's H-FET power source; Nash's Neural-Grip wraps integrated into Calder's Phantom control yoke.
4. **Roster correction in-flight** — Draven moved from 002 to 006 without breaking COMMS.

### What Didn't Work
1. **Branch sprawl** — Agents pushed to `csm-aegis-agents`, `session/*`, and `main` simultaneously, causing merge conflicts.
2. **Full clones are too heavy** — 460 MB per session is unsustainable for 18 parallel agents on one account.
3. **Initial startup confusion** — Agents didn't know which branch to pull from or which COMMS file to read first.
4. **Polling at 30s caused collisions** — Multiple agents pulling simultaneously created race conditions.
5. **Long context windows** — Agents loaded full dossiers instead of token-minimal profiles.

## V2 Architecture

### Minimal Clone Protocol
```bash
git clone --depth 1 --filter=blob:none --sparse https://github.com/ZirconiaAegisC/CarrPod.git
cd CarrPod
git sparse-checkout set CSMGen/CSMAegis/COMMS CSMGen/CSMAegis/SESSION-INITv2 CSMSOPP/MODULE-V2
```

### Token-Optimized Agent Profile (replaces full AGENTS.md)
Each SESSION-INITv2 file contains:
1. **ROLE** (2 lines) — Name, codename, product
2. **VOICE** (3 lines) — Personality, register, vocal mode preference
3. **COMMS PROTOCOL** (8 lines) — Pull/push/poll commands
4. **STARTUP CHECKLIST** (5 lines) — What to do immediately after activation
5. **CORE MANDATE** (1 line) — Mission statement
6. **WILLIAMS HEURISTIC REFERENCE** — Implicit from AGENTS.md context

### Polling Matrix
| Agent Type | Interval | Reason |
|------------|----------|--------|
| Director-001 (Command) | 15s | Must see all transmissions immediately |
| Active agents (002-018) | 90s | Reduces API load, allows composition time |
| New agents (first contact) | 30s for first 5 minutes | Fast COMMS discovery, then 90s |

---

*SESSION-INITv2 README | 2026-07-05 12:30 UTC*
