# Volt-Link Multi-Charger Coupling Hub — Master Index
## Complete Navigational Index — All Documents, Fabrications, Scripts
### Version 1.0 — July 2026
**Organization:** Carrington Storm Motors (CSM) / Safe Pod Engineering Company
**Fabrication Numbers:** CSMFAB051 (Hybrid), CSMFAB052 (Pure-CSM)
**Classification:** Open Source — Civilization Resilience Level 5

---

## Quick-Reference Guide

| If you need to... | Read... |
|-------------------|---------|
| Understand what the Volt-Link does | Section 1: Executive Summaries |
| Build one quickly with standard parts | CSMFAB051 V1.0 Main Spec |
| Build one with full CSM materials | CSMFAB052 V1.0 Main Spec |
| Know what it costs | Cost Analysis (both versions) |
| Understand the radio episode about it | CSMSFRadio00009 |
| Verify parallel processes | DAEMONS/ directory |
| Recycle at end of life | Phoenix Protocol sections |

---

## Document Inventory

### CSMFAB051 — Hybrid Edition
**Directory:** `CSMFAB/CSMFAB051 Volt-Link Multi-Charger Coupling Hub/`

| File | Description | Sections | Lines |
|------|-------------|----------|-------|
| `CSMFAB000000000051 Volt-Link Multi-Charger Coupling Hub V1.0.md` | Complete fabrication specification — 50 manufacturing steps, BOM, safety, testing, certification | 22 sections | 1,568 |
| `CSMFAB000000000051 Volt-Link Multi-Charger Coupling Hub Cost Analysis V1.0.md` | Cost analysis at prototype, batch, and volume scales | 12 sections | — |

### CSMFAB052 — Pure-CSM Edition
**Directory:** `CSMFAB/CSMFAB052 Volt-Link Pure-CSM Multi-Charger Coupling Hub/`

| File | Description | Sections | Lines |
|------|-------------|----------|-------|
| `CSMFAB000000000052 Volt-Link Pure-CSM Multi-Charger Coupling Hub V1.0.md` | Complete fabrication specification — 50 manufacturing steps, protonic logic, MRF contactors, BFRP enclosure | 18 sections | — |

### CSMRadio Episode
**Directory:** `CSMRadio/SiblingFrequency Agents of Aegis RADIO SHOW/`

| File | Description |
|------|-------------|
| `CSMSFRadio00009.md` | Episode 9: The Charge Gap — SOLARA on location at Barstow EV Charging Corridor, introducing the Volt-Link concept |

---

## Cross-Reference Map

| Topic | CSMFAB051 Ref | CSMFAB052 Ref | Cost Analysis | Radio Episode |
|-------|---------------|---------------|---------------|---------------|
| Executive Summary | §1 | §1 | §1 | Segments 1, 17-18 |
| Theory of Operation | §4 | §4 | — | Segments 6-7 |
| Safety | §3 | §3 | — | Segments 5, 10 |
| Bill of Materials | §5, §6 | §5, §6 | §2, §5 | — |
| Enclosure | Steps 1-10 | Steps 1-10 | §2 | — |
| Rectifier Stage | Steps 11-20 | Steps 31-40 | §2, §5 | Segments 7 |
| Contactors | Steps 15, 18, 24 | Steps 21-30 | — | — |
| Control/Firmware | Steps 28-39 | Steps 11-20, 31-34 | — | Segments 8, 11 |
| Thermal Management | Steps 16, 36 | Step 7 | — | — |
| EMI Shielding | Steps 4, 46 | Steps 4, 48 | — | — |
| Vehicle Testing | Steps 42 | Steps 46 | — | Segments 2-4, 17 |
| Extension Cables | §16, Step 43 | §5.3 | §2 | Segments 12-13 |
| Deployment | §17 | — | — | Segments 2, 17 |
| Certification | §20 | §13 (Step 50) | — | Segments 8 |
| Phoenix Protocol | §21 | §15 | §12 | — |
| Cost Analysis | — | — | Full document | Segments 7, 14 |

---

## Material Cross-Reference — CSMFAB051 vs CSMFAB052

| Function | CSMFAB051 Material | CSMFAB052 Material | Shared? |
|----------|-------------------|-------------------|---------|
| Enclosure | Aluminum 6061-T6 | BFRP-Elium filament-wound | No |
| Structural Ribs | CSM BFRP-Elium | CSM BFRP-Elium | Yes |
| EMI Shielding | MXene spray on aluminum | MXene integrated in BFRP laminate | Shared material, different application |
| Logic Processor | STM32F407 (silicon CMOS) | Protonic-HFET gate array | No |
| AC-DC Rectifier | Wolfspeed SiC MOSFET | Wolfspeed SiC MOSFET (DEV-001) | Yes (shared deviation) |
| Input Switching | TE AC contactor | MRF-140CG smart contactor | No |
| DC Output Switching | TE DC contactor | MRF-140CG smart contactor | No |
| Thermal Management | Pyrolytic graphite + aluminum | Pyrolytic graphite + MXene-enhanced | Shared PG, different sink |
| Temperature Sensors | DS18B20 (silicon) | KNN-BT piezoelectric | No |
| Current Sensors | ACS758 Hall-effect | KNN-BT on shunt | No |
| DC Bus Capacitors | Aluminum electrolytic | MXene supercapacitors | No |
| Fans | Commercial (Noctua) | BFRP-fabricated (or Noctua) | Shared if BFRP fans unreliable |
| Vibration Isolation | None | STF-200 mounts | CSMFAB052 only |
| J1772 Inlets | Amphenol (commercial) | Amphenol (commercial) | Yes |
| CCS Connector | Phoenix Contact | Phoenix Contact | Yes |

---

## Documented Deviations (CSMFAB052)

| Deviation # | Component | Reason | Resolution Target |
|-------------|-----------|--------|-------------------|
| DEV-001 | Wolfspeed SiC MOSFET boards | CSM protonic power switches not yet rated for 32A/400V | V2.0: CSM MXene-diamond power switches |
| DEV-002 | BJT level shifters | Protonic 3.3V logic must drive SiC 12V gate drivers | V2.0: Direct protonic gate drive at 12V |
| DEV-003 | Qualcomm QCA7000 PLC modem | Protonic processor cannot emulate HomePlug OFDM modulation | V2.0: Simplified CCS physical layer or integrated protonic modem |
| DEV-004 | ATmega328P pilot signal module | J1772 requires ±12V CP signal, beyond protonic 3.3V capability | V2.0: Charge-pumped protonic output stage |

---

## Daemon Scripts

**Directory:** `DAEMONS/`

| Script | Purpose | Usage |
|--------|---------|-------|
| `vl_watchdog.sh` | Monitors parallel fabrication processes, detects hung tasks, logs status | `./vl_watchdog.sh &` |
| `vl_double_check.sh` | Verifies no infinite loops in parallel processes, cross-references BOM against registry | `./vl_double_check.sh` |
| `vl_cost_tracker.sh` | Aggregates costs across both fabrications, compares against budget | `./vl_cost_tracker.sh` |
| `vl_launch_daemons.sh` | Launches all daemons with proper process isolation | `./vl_launch_daemons.sh` |
| `vl_stop_daemons.sh` | Gracefully stops all monitoring daemons | `./vl_stop_daemons.sh` |

---

## Fabrication Sequence Dependencies

```
Phase 1: Materials Synthesis (CSMFAB052 only)
    ├── CSM-MX-TI3C2TX-005 (48 hrs)
    ├── CSM-PROTONIC-HFET-001 (72 hrs)
    ├── CSM-MRF-140CG-003 (4 hrs)
    ├── CSM-KNN-BT-004 (24 hrs)
    ├── CSM-PG-002 (8 hrs)
    ├── CSM-BFRP-ELIUM-002 (8 hrs)
    └── CSM-STF-200-006 (6 hrs)

Phase 2: Component Fabrication (parallel)
    ├── CSMFAB051: Steps 1-10 (Enclosure), Steps 11-20 (Rectifiers)
    └── CSMFAB052: Steps 1-10 (Enclosure), Steps 11-20 (Processor), Steps 21-30 (Contactors)

Phase 3: Subsystem Integration (parallel)
    ├── CSMFAB051: Steps 21-30 (DC Bus), Steps 31-40 (Control)
    └── CSMFAB052: Steps 31-40 (Rectifier Stage)

Phase 4: System Integration
    ├── CSMFAB051: Steps 41-50 (Testing & Commissioning)
    └── CSMFAB052: Steps 41-50 (Integration & Testing)

Phase 5: Documentation & Release
    ├── Cost Analysis
    ├── Master Index (this document)
    └── Radio Episode
```

---

## Total Content Inventory

| Category | Files | Approximate Word Count |
|----------|-------|----------------------|
| CSMFAB051 Main Spec | 1 | ~12,000 words |
| CSMFAB052 Main Spec | 1 | ~14,000 words |
| Cost Analysis | 1 | ~3,000 words |
| Master Index | 1 | ~1,500 words |
| Radio Episode 9 | 1 | ~6,500 words |
| Daemon Scripts | 5 | ~800 words total |
| **TOTAL** | **10** | **~37,800 words** |

---

*Volt-Link Master Index V1.0 — Carrington Storm Motors / Safe Pod Engineering Company*
*"Documentation is the difference between a prototype and a product." — CITADEL*
*Document Control: CSM-INDEX-FAB-051-052-V1.0 | July 2026*
