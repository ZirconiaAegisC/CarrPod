# CSMFAB000000000212 — DRONE-X Battery Selection and Power Budget
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Power Systems Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — GNB 3S 1800mAh recommendation, 6.3min hover, LiFePO4 alternative, power budget |

---

## 1. Primary Battery Specification

| Parameter | GNB 3S 1800mAh 120C | Alternative: CNHL 3S 1500mAh 100C |
|-----------|---------------------|----------------------------------|
| Chemistry | LiPo (LiNiMnCoO₂) | LiPo |
| Cells | 3S (11.1V nominal) | 3S |
| Capacity | 1800 mAh | 1500 mAh |
| Continuous discharge | 120C (216 A) | 100C (150 A) |
| Burst discharge | 240C (432 A) | 200C (300 A) |
| Weight | 148 g | 135 g |
| Dimensions | 82 × 35 × 28 mm | 76 × 34 × 26 mm |
| Connector | XT60 | XT60 |
| Internal resistance | 2–4 mΩ per cell | 3–5 mΩ per cell |
| Cost per unit | $16.99 (pairs: $14.50 ea.) | $12.99 |
| Cycle life to 80% | ~150 cycles | ~120 cycles |

## 2. Complete Power Budget

| Subsystem | Voltage | Current (avg) | Current (peak) | Power (avg) |
|-----------|---------|---------------|----------------|-------------|
| Motors (4×, hover) | 11.1 V | 14.6 A | — | 162 W |
| Motors (4×, full throttle) | 11.1 V | — | 86.4 A | 959 W |
| ESCs (4×, quiescent) | 11.1 V | 0.12 A | — | 1.3 W |
| MCU bridge (STM32) | 5 V | 0.08 A | 0.15 A | 0.4 W |
| Bluetooth (HC-05) | 5 V | 0.03 A | 0.05 A | 0.15 W |
| GPS module | 5 V | 0.04 A | 0.06 A | 0.2 W |
| LoRa module (RX) | 3.3 V | 0.015 A | 0.12 A (TX) | 0.05 W |
| Buck converter loss (8%) | — | — | — | 0.5 W |
| **Avionics total** | | **~0.2 A @ 5V** | | **~1.3 W** |

## 3. Flight Time Estimates

| Flight Mode | Avg Current | Usable Capacity (80%) | Flight Time |
|-------------|-------------|----------------------|-------------|
| Hover (no wind) | 15 A | 1440 mAh | **6.3 min** |
| Slow cruise (5 m/s) | 18 A | 1440 mAh | 5.2 min |
| Fast cruise (12 m/s) | 22 A | 1440 mAh | 4.3 min |
| Aggressive (mixed) | 28 A | 1440 mAh | 3.4 min |
| Loiter with phone charging | 17 A | 1440 mAh | 5.5 min |
| Emergency reserve (RTL) | 15 A | 360 mAh (20%) | 1.6 min |

Usable capacity: 80% of rated (to avoid discharging below 3.5V/cell resting). Emergency reserve: 20% reserved for RTL and landing.

## 4. Voltage Thresholds

| Threshold | Voltage (3S) | Action |
|-----------|-------------|--------|
| Full charged | 12.60 V | Normal operation |
| Nominal | 11.10 V | Normal operation |
| Warning | 10.80 V | HUD alert "BATTERY LOW" |
| Low battery | 10.50 V | Auto-RTL triggered, phone charging disabled |
| Critical | 10.20 V | Forced landing at current position |
| Cutoff | 9.60 V | ESCs fold (BLHeli_32 low-voltage protection) |
| Storage | 11.40 V (3.80V/cell) | Post-flight storage charge |

## 5. LiFePO4 Alternative

For applications requiring enhanced thermal stability or cycle life (e.g., agricultural survey, infrastructure inspection):

| Parameter | LiFePO4 (A123 3S2P 2300mAh) |
|-----------|------------------------------|
| Nominal voltage | 9.9 V (3S) |
| Capacity | 2300 mAh |
| Weight | 195 g (+47 g vs LiPo) |
| Continuous discharge | 30C (69 A) |
| Cycle life to 80% | > 1000 cycles |
| Thermal runaway threshold | 270°C (vs 150°C for LiPo) |
| Flight time impact | -15% vs LiPo (lower voltage reduces motor RPM) |

LiFePO4 is recommended for BVLOS operations or missions where battery failure risk must be minimized (see CSMFAB-223 for BVLOS requirements).

---

*"A battery doesn't store energy — it stores time. Budget it carefully, and always carry a reserve."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon battery technology refresh
- Distribution: Engineering Team, Flight Operations
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
