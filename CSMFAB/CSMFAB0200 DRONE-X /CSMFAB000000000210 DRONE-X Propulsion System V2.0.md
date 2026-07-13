# CSMFAB000000000210 — DRONE-X Propulsion System
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Propulsion Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — T-Motor F2306, BLHeli_32 ESC spec, motor wiring, EMI management |

---

## 1. Motor Specification (T-Motor F2306 1900KV)

| Parameter | Value |
|-----------|-------|
| Stator diameter/height | 23 mm / 6 mm |
| KV rating | 1900 RPM/V |
| Configuration | 12N14P |
| Weight (bare motor) | 29.5 g |
| Shaft | Hollow titanium, Ø 5 mm |
| Bearings | NSK 685ZZ (×2) |
| Magnets | N52SH curved, rated 150°C |
| Phase resistance | 78 mΩ |
| Max continuous current | 25 A |
| Max burst current (10 s) | 35 A |
| Max continuous power | 277 W (at 11.1 V) |
| Prop adapter | M5 nyloc nut |
| Motor wire | 20 AWG silicone, 150 mm |

## 2. ESC Specification (BLHeli_32 30A)

| Parameter | Value |
|-----------|-------|
| MCU | STM32F051 (or EFM8BB2) |
| Firmware | BLHeli_32 (rev 32.9+) |
| Protocol | DSHOT300 (primary), DSHOT600 (optional) |
| Continuous current | 30 A |
| Burst current (10 s) | 40 A |
| Input voltage | 2S–4S (7.4–16.8 V) |
| BEC output | None (opto) |
| Weight | 8 g (without wires) |
| Dimensions | 25 × 13 × 6 mm |
| Telemetry | ESC telemetry via separate UART (RPM, temp, current, V) |
| PWM frequency | 24–48 kHz (configurable) |
| Timing | Auto (default) / 15°–30° manual |

## 3. Motor Wiring and Rotation Convention

```
       M1 (CW)          M2 (CCW)
         \               /
          \             /
           \   FRONT   /
            +---------+
            |  PHONE  |
            |  CLAMP  |
            +---------+
           /           \
          /             \
         /               \
       M3 (CCW)        M4 (CW)
```

| Motor | Position | Rotation | ESC ID | Signal Wire Color |
|-------|----------|----------|--------|-------------------|
| M1 | Front-right | CW | ESC1 | Red |
| M2 | Front-left | CCW | ESC2 | Blue |
| M3 | Rear-left | CW | ESC3 | Green |
| M4 | Rear-right | CCW | ESC4 | Yellow |

DSHOT300 ESC signal protocol: digital 300 kbps, 16-bit throttle value (48–2047), bidirectional DSHOT telemetry enabled on ESC telemetry line.

## 4. Motor Mix Table

Normalized throttle outputs from PID controller are transformed to per-motor commands via the canonical quadcopter mix matrix:

```
M1 = throttle + roll - pitch + yaw
M2 = throttle - roll - pitch - yaw
M3 = throttle - roll + pitch + yaw
M4 = throttle + roll + pitch - yaw
```

Outputs clamped to [MOTOR_IDLE, MOTOR_MAX] where MOTOR_IDLE = 0.05 (5% throttle) when armed, MOTOR_MAX = 1.0.

## 5. EMI Management

The propulsion system is the primary EMI source on the airframe. Mitigation strategy:

| Source | Emission Type | Mitigation |
|--------|---------------|------------|
| Motor phase wires | Radiated EMI 8–50 kHz (PWM harmonics) | Twisted triplet, ferrite bead at ESC output |
| ESC switching | Conducted EMI on power rail | Low-ESR capacitor (330 µF/25V) per ESC, 1000 µF bulk on PDB |
| ESC signal wires | Crosstalk into LoRa antenna | Physical separation ≥ 50 mm, shielded twisted pair |
| Motor magnets | Static magnetic field | ≥ 40 mm separation from magnetometer (phone) |
| Propeller | Triboelectric charging | Conductive coating on prop tips (optional grounding through motor bearings) |

Avionics bay MXene shielding (CSMFAB-214) provides an additional 92 dB SE from 1 kHz to 10 GHz, effectively isolating the MCU and LoRa radio from propulsion system EMI.

---

*"The motor turns voltage into motion. The ESC turns code into voltage. Neither cares about your intentions — only your commands."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Propulsion Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
