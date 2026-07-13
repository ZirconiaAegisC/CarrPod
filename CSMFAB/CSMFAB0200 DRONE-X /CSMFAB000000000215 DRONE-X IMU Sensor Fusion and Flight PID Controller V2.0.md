# CSMFAB000000000215 — DRONE-X IMU Sensor Fusion and Flight PID Controller
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Control Systems Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — Madgwick AHRS filter, cascaded PID, motor mix table, auto-tune specification |

---

## 1. Sensor Fusion: Madgwick AHRS Filter

The Madgwick filter fuses 9-DOF IMU data (accelerometer + gyroscope + magnetometer) at 400 Hz to produce a quaternion orientation estimate. The filter uses a gradient descent algorithm with configurable gain β:

| Parameter | Value |
|-----------|-------|
| Filter type | Madgwick AHRS (open-source, validated) |
| Update rate | 400 Hz |
| Gyroscope full scale | ±2000 dps |
| Accelerometer full scale | ±16 g |
| Magnetometer full scale | ±4900 µT |
| Filter gain (β) | 0.041 (√(3/4) * gyro measurement error in rad/s) |
| Convergence time | < 0.5 s from arbitrary initial attitude |
| Static accuracy | ±0.5° pitch/roll, ±2° yaw |
| Dynamic accuracy | ±1.5° pitch/roll, ±5° yaw (under 2G maneuver) |
| Computation cost | ~450 µs per update (on phone ARM Cortex-A) |

**Sensor calibration requirements (pre-flight):**
- Accelerometer: 6-point tumble calibration (scale + bias)
- Gyroscope: Static bias capture (3000 samples, averaged)
- Magnetometer: Ellipsoid fit (hard iron + soft iron compensation)
- All calibrations stored in phone profile, validated on each arming attempt

## 2. Cascaded PID Architecture

```
Pilot Input → [Angle PID 400Hz] → [Rate PID 400Hz] → [Motor Mix] → ESCs
             ↑ Attitude Estimate (Madgwick)
             ↑ Rate Estimate (Gyro, low-pass filtered)
```

### 2.1 Rate PID (Inner Loop — 400 Hz)

| Axis | Kp | Ki | Kd | I-Limit | D-LPF (Hz) |
|------|-----|-----|-----|---------|------------|
| Roll | 0.12 | 0.025 | 0.008 | 0.15 | 50 |
| Pitch | 0.12 | 0.025 | 0.008 | 0.15 | 50 |
| Yaw | 0.18 | 0.030 | 0.005 | 0.20 | 40 |

Anti-windup: Back-calculation method (Kb = 0.5 × Ki). D-term computed from gyroscope directly (not from derivative of angle error) to avoid noise amplification.

### 2.2 Angle PID (Outer Loop — 400 Hz)

| Axis | Kp | Ki | I-Limit | Max Angle |
|------|-----|-----|---------|-----------|
| Roll | 5.5 | 0.08 | 0.12 | 45° |
| Pitch | 5.5 | 0.08 | 0.12 | 45° |
| Yaw | 3.0 | 0.05 | 0.10 | — (rate-only in angle mode) |

## 3. Altitude and Position Control

Barometer + GPS EKF provides altitude and position estimates:

| Loop | Rate | Kp | Ki | Kd | I-Limit |
|------|------|-----|-----|-----|---------|
| Altitude hold | 50 Hz | 2.0 | 0.15 | 0.5 | 0.3 |
| Vertical velocity | 100 Hz | 8.0 | 0.20 | 0.3 | 0.4 |
| Horizontal position | 20 Hz | 0.8 | 0.05 | 0.2 | 0.2 |
| Horizontal velocity | 50 Hz | 1.5 | 0.10 | 0.15 | 0.3 |

Altitude estimate fusion: Barometer (10 Hz) + accelerometer Z integration (400 Hz) + GPS altitude (5 Hz). Complementary filter: τ = 2.0 s for barometer, τ = 0.5 s for accelerometer.

## 4. Motor Mix Matrix

Normalized PID output → motor commands:

```
M1 = T + Rp - Pp + Yw   // Front Right (CW)
M2 = T - Rp - Pp - Yw   // Front Left (CCW)
M3 = T - Rp + Pp + Yw   // Rear Left (CW)
M4 = T + Rp + Pp - Yw   // Rear Right (CCW)

Where: T = throttle, Rp = roll PID, Pp = pitch PID, Yw = yaw PID
```

Output clamped to [MOTOR_IDLE (0.05), 1.0]. Air-mode enabled: PID authority maintained down to MOTOR_IDLE.

Throttle curve: third-order polynomial compensation for propeller thrust nonlinearity (thrust ∝ RPM²).

## 5. Auto-Tune Specification

Automated PID tuning using Ziegler-Nichols ultimate gain method with fly-and-perturb approach:

| Phase | Duration | Action |
|-------|----------|--------|
| 1. Baseline | 5 s | Hover, log noise floor |
| 2. Roll excite | 10 s | Step impulses (±10°), measure oscillation period Pu |
| 3. Pitch excite | 10 s | Step impulses (±10°), measure Pu |
| 4. Yaw excite | 10 s | Step impulses (±30°/s), measure Pu |
| 5. Compute | — | Kp = 0.6 × Ku, Ki = 2Kp/Pu, Kd = Kp × Pu/8 |
| 6. Validate | 15 s | Hover with new gains, verify phase margin > 45° |

Auto-tune results are verified by pilot acceptance test before permanent storage.

---

*"A filter doesn't know truth from noise. It only knows what you told it to expect."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon flight dynamics change
- Distribution: Engineering Team, Flight Software Team
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
