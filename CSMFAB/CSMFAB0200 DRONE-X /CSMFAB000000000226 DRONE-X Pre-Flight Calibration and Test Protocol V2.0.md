# CSMFAB000000000226 — DRONE-X Pre-Flight Calibration and Test Protocol
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Quality Assurance & Flight Operations Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — 11 enforced pre-flight checks, in-flight validation, post-flight review, maintenance schedule |

---

## 1. Pre-Flight Checklist (11 Enforced Checks)

The DRONE-X app enforces all 11 checks before arming is permitted. Any failed check shows a red indicator and descriptive error message. All checks must pass within a single session (no stale passes).

| # | Check | Method | Pass Criteria | Fail Action |
|---|-------|--------|---------------|-------------|
| 1 | Battery voltage | MCU ADC via telemetry | 3S: 11.1–12.6V; LiFePO4: 9.6–10.8V | Block arm |
| 2 | Kill switch | MCU GPIO PB0 | HIGH (switch in FLIGHT position) | Block arm |
| 3 | GPS fix | UBX-NAV-STATUS | 3D fix, HDOP < 2.0 | Block autonomous modes, allow manual |
| 4 | Home position | GPS position at arm time | Lat/Lon recorded, altitude ≤ 120 m | Block arm if no fix |
| 5 | IMU calibration | Accelerometer variance | < 0.05 m/s² static noise (3000 samples) | Prompt recalibration |
| 6 | Magnetometer calibration | Heading comparison to GPS course | < 5° error during 10 m walk test | Prompt recalibration |
| 7 | Barometer calibration | Altitude comparison to GPS | < 2 m difference | Block altitude hold |
| 8 | USB-C link quality | 100-ping test, CRC error rate | CRC errors < 1%, latency < 5 ms P99 | Fallback to BT, warn pilot |
| 9 | MCU watchdog | IWDG kick confirmation | 10 consecutive kicks acknowledged | Block arm |
| 10 | Motor direction | DSHOT idle spin test (props OFF) | M1/M3 CW, M2/M4 CCW | Prompt ESC re-wiring |
| 11 | Firmware/App version | Version hash comparison | MCU fw = app-expected, App version ≥ min | Block arm, prompt update |

## 2. Calibration Procedures

### 2.1 Accelerometer Six-Point Calibration
1. Place drone on level surface (phone display up) — hold 3 s → capture +Z
2. Rotate drone (phone display down) — hold 3 s → capture -Z
3. Drone on right side — hold 3 s → capture +X
4. Drone on left side — hold 3 s → capture -X
5. Drone nose up — hold 3 s → capture +Y
6. Drone nose down — hold 3 s → capture -Y
7. Compute: scale = (2G) / (max-min), bias = (max+min)/2

### 2.2 Gyroscope Bias Capture
- Place drone stationary on vibration-free surface
- Capture 3000 gyroscope samples at 400 Hz (7.5 seconds)
- Compute mean bias per axis, store in calibration profile
- Requirement: bias stability < 0.05 dps (standard deviation)

### 2.3 Magnetometer Ellipsoid Calibration
- Rotate drone through all orientations (360° roll, 360° pitch, 360° yaw)
- Collect 5,000+ magnetometer samples
- Fit ellipsoid using least-squares method
- Transform to sphere (hard iron = center offset, soft iron = ellipsoid axes)
- Requirement: residual < 0.5 µT RMS

## 3. In-Flight Validation (First Flight After Build/Maintenance)

| Test | Altitude | Duration | Pass Criteria |
|------|----------|----------|---------------|
| Hover stability | 2 m | 30 s | Position hold within ±0.5 m horizontal, ±0.3 m vertical |
| Attitude response | 5 m | 30 s | Follows stick input without oscillation, settle < 0.5 s |
| GPS position hold | 10 m | 60 s | Drift < 2 m over 60 s |
| RTL test | — | Full cycle | Lands within 2 m of takeoff point |
| Motor temperature | Post-landing | — | All motors < 55°C (ambient 25°C) |
| Battery consumption | Full flight | — | mAh consumed within ±10% of power budget prediction |

## 4. Post-Flight Review

| Item | Action |
|------|--------|
| Flight log | Auto-upload to cloud, review for anomalies (vibration spikes, GPS dropouts) |
| Motor temperature | Measure with IR thermometer, record in log |
| Propeller inspection | Visual check for nicks, cracks, imbalance |
| Frame inspection | Visual check for delamination, cracks at dovetail joints |
| Battery storage | Charge/discharge to 3.80V/cell if not flying within 24h |
| Calibration drift | Compare pre- and post-flight gyro bias — flag if > 0.1 dps shift |

## 5. Maintenance Schedule

| Interval | Action | Reference |
|----------|--------|-----------|
| Every flight | Pre-flight checks 1–11 | This document |
| Every 10 flights | Propeller balance check, motor bearing inspection | Visual + audio FFT |
| Every 50 flights | Full IMU recalibration, MXene coating inspection | CSMFAB-214, CSMFAB-215 |
| Every 100 flights | Motor bearing replacement, ESC capacitor replacement | CSMFAB-210, CSMFAB-211 |
| Every 200 flights | Full frame inspection including dovetail wear measurement | CSMFAB-205, CSMFAB-207 |
| Annually | Complete teardown, inspection, re-assembly | CSMFAB-225 |

---

*"The most dangerous flight is the one you didn't check before you took off."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Flight Operations, Maintenance Team
- Next Scheduled Review: July 2027
- Status: APPROVED — Operations Baseline
