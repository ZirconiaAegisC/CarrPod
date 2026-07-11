# CSMFAB000000000211 — DRONE-X Power Distribution Board Design
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Electronics Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — PDB schematic, ACS758 current sensor, kill switch circuit, phone charging rail |

---

## 1. PDB Topology

The Power Distribution Board is a 50 × 40 mm 2-layer PCB (2 oz copper) providing regulated power rails to all subsystems:

```
BATTERY (3S LiPo, 11.1V nom)
  │
  ├──[DPDT Kill Switch]──┬──[ACS758 Current Sensor]── MOTOR RAIL (11.1V, 4× ESC pads)
  │                      │
  │                      ├──[5V Buck Converter]── 5V RAIL (MCU, BT, GPS, RX)
  │                      │
  │                      └──[MT3608 Boost]──[Power Sharing Circuit]── PHONE CHARGING (5V/1.5A)
```

## 2. Component Specifications

| Component | Part Number | Spec | Purpose |
|-----------|-------------|------|---------|
| Current sensor | ACS758LCB-050U | 0–50 A, 60 mV/A, 3.3V compatible | Motor current telemetry |
| Buck converter | Mini-360 (MP1584) | 5V, 3A max, 92% efficiency | 5V rail for avionics |
| Boost converter | MT3608 module | Input 2–24V, Output 5V/2A | Phone charging rail |
| Kill switch | DPDT toggle (rated 10A @ 16V) | MTS-202 | Main power disconnect |
| Bulk capacitor | 1000 µF, 25V, low-ESR | Panasonic FR series | Input filtering |
| ESC capacitors | 330 µF, 25V (×4) | Low-ESR electrolytic | Per-ESC decoupling |
| XT60 connector | Amass XT60U-F | 60A rating | Battery input |
| ESC pads | 3.5 mm gold-plated pad | Solder connection | ESC power leads |
| PCB | 2-layer, 2 oz copper | 50 × 40 mm | Power distribution |

## 3. ACS758 Current Sensor Integration

| Parameter | Value |
|-----------|-------|
| Sensor | Allegro ACS758LCB-050U-PFF-T |
| Range | 0–50 A (unidirectional) |
| Sensitivity | 60 mV/A |
| Output at 0 A | 0.6 V (VCC × 0.12) |
| Output at 25 A | 2.1 V |
| Output at 50 A | 3.6 V |
| ADC input | STM32F103 PA1 (12-bit, 3.3V ref) |
| Resolution | 12.2 mA/LSB |
| Sampling rate | 200 Hz (synchronized with flight loop) |
| Filter | 2nd-order Butterworth, fc = 20 Hz |

Current telemetry is reported in the telemetry packet at 50 Hz and displayed on the HUD battery gauge. Real-time integration of current × time provides mAh consumed (coulomb counter).

## 4. Kill Switch Circuit

The kill switch is a DPDT toggle switch (MTS-202) that disconnects BOTH the positive and negative battery leads when in the OFF position. This provides true galvanic isolation — no semiconductor in the power path can fail closed.

```
BATT+ ────[DPDT SW]───── BATT+_SWITCHED
BATT- ────[DPDT SW]───── BATT-_SWITCHED
```

**Critical requirement:** The kill switch must be physically accessible without removing hands from the transmitter or phone. Mounting: right-rear landing skid, facing outward.

An auxiliary SPST switch provides a "soft arm" signal to the STM32 MCU (PB0) — the MCU reports kill switch state and prevents DSHOT output when the line is LOW.

## 5. Phone Charging Rail

The MT3608 boost converter provides a regulated 5V/1.5A output to the phone via the USB-C power sharing circuit (CSMFAB-213). This rail is enabled only when the main battery voltage exceeds 11.5V (indicating > 60% state of charge), preventing phone charging from draining flight battery below safe thresholds.

| Parameter | Value |
|-----------|-------|
| Boost converter | MT3608 module |
| Input voltage range | 2–24 V |
| Output | 5.0 V ± 0.25 V |
| Max output current | 2 A (derated to 1.5 A) |
| Efficiency at 1A load | 89% |
| Enable threshold | 11.5V (via MCU GPIO + NPN transistor) |
| Ripple | < 50 mVpp |

---

*"Power is the first thing you need and the last thing you think about — until it's gone."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Electronics Assembly Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
