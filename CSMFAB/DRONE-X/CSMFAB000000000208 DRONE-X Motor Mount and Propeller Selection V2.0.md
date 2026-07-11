# CSMFAB000000000208 — DRONE-X Motor Mount and Propeller Selection
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Mechanical & Propulsion Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — 16×19mm mount spec, motor options matrix, propeller selection, thrust-to-weight 4.26:1 |

---

## 1. Motor Mount Specification

Each arm terminates in a BFRP motor mount pad with a standard 16 mm × 19 mm bolt pattern (M3 × 8 mm). The mount is integrated into the arm print as a monolithic structure — no separate motor mount part. The pad thickness is 6 mm with a central 8 mm clearance hole for the motor shaft and C-clip.

| Mount Parameter | Value |
|----------------|-------|
| Bolt pattern | 16 mm × 19 mm (standard 22XX/23XX stator) |
| Bolt size | M3 × 8 mm, stainless A2-70 |
| Bolt torque | 1.0 N·m |
| Pad thickness | 6 mm |
| Shaft clearance hole | Ø 8 mm |
| Motor wire exit slot | 10 mm × 5 mm, downward-facing |
| Cooling airflow gap | 3 mm (between motor base and pad) |

## 2. Primary Motor Specification

| Parameter | T-Motor F2306 1900KV |
|-----------|---------------------|
| Stator size | 2306 |
| KV rating | 1900 RPM/V |
| Configuration | 12N14P |
| Weight | 29.5 g |
| Shaft diameter | 5 mm (hollow titanium) |
| Max continuous current | 25 A |
| Max burst current (10 s) | 35 A |
| Internal resistance | 78 mΩ |
| Recommended ESC | 30A BLHeli_32 |
| Propeller range | 5"–6" |
| Bearing | NSK 685ZZ (2×) |
| Magnet | N52SH curved (rated 150°C) |

## 3. Motor Alternatives Matrix

| Motor | KV | Weight (g) | Max Thrust (g, 3S/6040) | Efficiency (g/W) | Cost | Status |
|-------|-----|-----------|-------------------------|-----------------|------|--------|
| T-Motor F2306 1900KV | 1900 | 29.5 | 1,120 | 6.8 | $17.90 | Primary |
| EMAX RS2306 2400KV | 2400 | 31.0 | 1,250 | 6.2 | $14.50 | Alt (hotter) |
| BrotherHobby R3 2207 | 1750 | 32.0 | 1,080 | 7.2 | $19.90 | Alt (efficient) |
| iFlight XING 2306 | 1700 | 33.0 | 1,050 | 7.5 | $18.50 | Alt (torque) |
| DYS Samguk 2207 | 2000 | 30.0 | 1,100 | 6.5 | $10.90 | Budget alt |

## 4. Propeller Selection Matrix

| Propeller | Pitch | Blades | Thrust/Prop (g, 3S) | Current/Prop (A) | Efficiency (g/W) | Noise (dB @ 3m) |
|-----------|-------|--------|---------------------|------------------|-----------------|-----------------|
| Gemfan 6040-3 | 4.0" | 3 | 1,120 | 21.6 | 6.8 | 72 |
| HQProp 6045-3 | 4.5" | 3 | 1,250 | 25.8 | 6.3 | 75 |
| Gemfan 6030-2 | 3.0" | 2 | 950 | 16.2 | 7.7 | 66 |
| DALProp 6040-3 | 4.0" | 3 | 1,150 | 22.5 | 6.7 | 73 |
| HQProp 5146-3 | 4.6" | 3 | 980 | 19.8 | 6.5 | 70 |

**Primary selection: Gemfan 6040-3** (Nylon+Glass fiber) — optimal balance of thrust, efficiency, and noise.

## 5. Thrust-to-Weight Calculation

| Component | Mass (g) |
|-----------|----------|
| Frame (fully assembled) | 385 |
| Motors (4×) | 118 |
| ESCs (4×) | 32 |
| PDB + wiring | 35 |
| MCU bridge + BT | 22 |
| Battery (GNB 3S 1800) | 148 |
| Phone (iPhone 15 Pro) | 187 |
| Misc hardware | 35 |
| **Total AUW** | **962 g** |

| Condition | Total Thrust (g) | T:W Ratio |
|-----------|-----------------|-----------|
| 100% throttle, fresh battery | 4,480 | 4.66:1 |
| 100% throttle, nominal voltage (11.1 V) | 3,920 | 4.07:1 |
| Hover (50% throttle, nominal) | 1,960 | 2.04:1 |
| **Design T:W (nominal, 100% throttle)** | **4,100** | **4.26:1** |

The 4.26:1 thrust-to-weight ratio exceeds the FAA-recommended minimum of 2:1 for multirotor operations and provides adequate authority for recovery from unusual attitudes within 0.5 seconds.

---

*"Thrust is promise. Weight is reality. The ratio between them is the only number that matters when gravity votes."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Propulsion Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
