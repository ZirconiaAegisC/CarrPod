# CSMFAB000000000114 — Vol-25
# Test Protocol, Checkpoints, and Flight Readiness Review
## Phase-Gate Testing: Bench → Tether → Free Flight → Swarm
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: Never Skip a Phase

Testing follows a strict phase-gate sequence. You must complete and pass every item in Phase N before beginning Phase N+1. Skipping phases is how devices crash, people get hurt, and programs end prematurely. Each phase is progressively riskier; the earlier phases exist to catch failures cheaply at the bench rather than expensively in the field.

---

## Phase 1: Bench Test (Zero Risk)

Complete these before ever powering the device outdoors:

- [ ] T1.1 — Weight ≤ 249g (scale check)
- [ ] T1.2 — Battery voltage ≥ 7.0V at charging complete
- [ ] T1.3 — LoRa telemetry received by ground station within 10m (indoor)
- [ ] T1.4 — GPS fix acquired within 60 seconds (outdoors, or near window)
- [ ] T1.5 — FTS servo actuates on SwarmView test command
- [ ] T1.6 — All 4 SMA actuators respond to individual channel commands (feel for arm flex)
- [ ] T1.7 — Speed governor arms flush at < 2,000 RPM (drill test at low speed)
- [ ] T1.8 — Speed governor arms rise at 3,800-4,200 RPM (drill test at target speed)
- [ ] T1.9 — No visible damage to spiral body, nose cone, tail fins
- [ ] T1.10 — No electrical shorts (multimeter continuity check: GND to all rails)

**Phase 1 pass criterion:** All 10 items checked. Zero failures allowed.

---

## Phase 2: Outdoor Tether Test (Low Risk)

Complete in a clear outdoor area with 10m minimum clearance, calm wind preferred (< 3 m/s):

- [ ] T2.1 — Tether attached and swivel free-spinning
- [ ] T2.2 — Tether reel anchor secure
- [ ] T2.3 — Hand-throw at < 5 mph with 5m tether only (SHORT tether for first test)
- [ ] T2.4 — Device achieves stable autorotation within 5 seconds (in any wind > 5 m/s)
- [ ] T2.5 — Device responds to tether brake (clamp brake → device stops climbing or descends slowly)
- [ ] T2.6 — FTS deployment test (LIVE): trigger from ground station at 5m altitude → parachute deploys → device descends to ground safely. Inspect device: no damage.
- [ ] T2.7 — Replace parachute pack. Re-arm FTS. Repeat launch.
- [ ] T2.8 — Data recorded: SwarmView shows altitude profile of test flight in log file

**Phase 2 pass criterion:** T2.1-T2.8 all pass. FTS deployment must succeed cleanly once before proceeding. If FTS jams or fails: return to bench, diagnose, fix, restart Phase 1.

---

## Phase 3: Single-Unit Free Flight (Moderate Risk)

Requires: confirmed 10+ m/s wind, Class G airspace, clear area, VO present.

- [ ] T3.1 — Full pre-flight checklist (Vol-20) complete
- [ ] T3.2 — Launch with 50m standard tether
- [ ] T3.3 — Device climbs to 50+ ft AGL and maintains stable autorotation for 10+ minutes
- [ ] T3.4 — Ground station receives valid wind data throughout (check Vol-06 CSV output)
- [ ] T3.5 — FTS command test at altitude (not deployment — just confirm command received)
- [ ] T3.6 — Tether retrieval: successfully reel in device to within 5m of ground
- [ ] T3.7 — No structural damage on landing/net recovery
- [ ] T3.8 — Post-flight weight check (confirm no component loss in-flight)

**Phase 3 pass criterion:** All pass. Two successful Phase 3 flights required before Phase 4.

---

## Phase 4: Multi-Unit Swarm Test (Requires §107.35 Waiver)

- [ ] T4.1 — 5 units assembled and individually Phase 3 qualified
- [ ] T4.2 — §107.35 waiver (or educational activity exemption) in hand
- [ ] T4.3 — Ground station shows all 5 units simultaneously with GPS fix
- [ ] T4.4 — 5-unit simultaneous launch (per Vol-13 protocol)
- [ ] T4.5 — All 5 units climb to common altitude without tether entanglement
- [ ] T4.6 — 3D wind map data collected for 15+ minutes
- [ ] T4.7 — All 5 units recovered safely
- [ ] T4.8 — Data quality check: >90% of 1 Hz packets received per unit - verify in CSV

**Phase 4 pass criterion:** T4.1-T4.8 all pass. This is the full operational capability milestone.

---

## CHECKPOINT — Vol-25 Complete

- [ ] You understand the 4-phase gate structure and why no phase can be skipped
- [ ] You know Phase 2 requires a LIVE FTS deployment test before Phase 3
- [ ] You know Phase 4 requires the §107.35 waiver (see Vol-02)
- [ ] You have your test log notebook ready (record date, pass/fail, notes for each item)

---

*CSMFAB000000000114-Vol-25 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
