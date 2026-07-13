# CSMFAB000000000217 — DRONE-X GPS Navigation and Waypoint System
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Navigation Systems Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — multi-constellation GNSS spec, EKF nav filter, waypoint JSON format, geofence, RTL behavior |

---

## 1. GNSS Module Specification

| Parameter | Value |
|-----------|-------|
| Module | BN-880Q (u-blox M8030-KT) |
| Constellations | GPS L1, GLONASS L1, BeiDou B1, Galileo E1 (concurrent) |
| Update rate | 10 Hz (configurable to 18 Hz) |
| Horizontal accuracy | 2.0 m CEP (SBAS enabled) |
| Velocity accuracy | 0.1 m/s |
| TTFF cold start | 26 s |
| TTFF hot start | 1 s |
| Sensitivity (tracking) | -167 dBm |
| Sensitivity (acquisition) | -148 dBm |
| Antenna | 25 × 25 × 4 mm ceramic patch, 18 dBi LNA |
| Interface | UART (NMEA + UBX binary) |
| Weight | 11.5 g (module + antenna) |
| Power | 50 mW (continuous tracking) |

The BN-880Q communicates with the STM32F103 MCU via UART at 115200 baud. UBX binary protocol is used for configuration and high-rate navigation data; NMEA sentences are parsed for compatibility. The MCU forwards parsed GPS data to the phone over the serial bridge at 10 Hz.

## 2. EKF Navigation Filter

An Error-State Extended Kalman Filter (ES-EKF) fuses GPS, IMU, barometer, magnetometer, and visual odometry data:

| State Vector (15 states) | Update Source | Rate |
|--------------------------|---------------|------|
| Position (lat, lon, alt) | GPS | 10 Hz |
| Velocity (N, E, D) | GPS + IMU integration | 10 Hz / 400 Hz |
| Attitude (quaternion) | IMU (Madgwick) | 400 Hz |
| Gyro bias (3-axis) | GPS velocity / stationary detect | 1 Hz |
| Accel bias (3-axis) | GPS velocity | 1 Hz |

**EKF Parameters:**
- Process noise (position): 0.5 m/s² (random walk)
- Process noise (velocity): 0.1 m/s²/√Hz
- GPS measurement noise: 2.0 m horizontal, 3.0 m vertical
- Barometer measurement noise: 0.5 m
- Magnetometer measurement noise: 2° heading (after calibration)

## 3. Waypoint Mission Format

Missions are defined in JSON with the following schema:

```json
{
  "mission": {
    "id": "MISSION-001",
    "name": "Perimeter Survey",
    "takeoff_alt": 20.0,
    "cruise_speed": 8.0,
    "finish_action": "RTL",
    "waypoints": [
      {"id": 1, "lat": 34.0522, "lon": -118.2437, "alt": 30.0, "action": "PHOTO", "hold_s": 2.0},
      {"id": 2, "lat": 34.0528, "lon": -118.2431, "alt": 30.0, "action": "WAYPOINT", "hold_s": 0.0},
      {"id": 3, "lat": 34.0531, "lon": -118.2440, "alt": 40.0, "action": "LOITER", "hold_s": 10.0}
    ]
  }
}
```

| Action Type | Behavior |
|-------------|----------|
| WAYPOINT | Fly through at cruise speed, no stop |
| PHOTO | Hover at waypoint, capture photo, proceed |
| LOITER | Hover at waypoint for hold_s seconds |
| LAND | Descend and disarm at waypoint |
| RTL | Return to launch and land |

Max waypoints per mission: 100. Waypoint acceptance radius: 2.0 m (configurable).

## 4. Geofence Specification

| Parameter | Value |
|-----------|-------|
| Max horizontal radius | 500 m (FAA Part 107 VLOS) |
| Max altitude | 120 m AGL (FAA Part 107) |
| Min altitude | 1.0 m (prevents ground collision in auto modes) |
| Fence action (breach) | Immediate RTL, descend to 50 m en route |
| Fence action (critical) | Land immediately at current position |
| Cylinder geofence | Yes (home-centered) |
| Polygon geofence | Yes (user-defined exclusion zones) |
| Dynamic geofence | No (static loaded before flight) |

## 5. Return-to-Launch (RTL) Behavior

RTL sequence triggered by: pilot command, link loss > 2 s, geofence breach, low battery (10.5V):

1. **Climb to RTL altitude** (30 m, or current altitude if higher) — 3 m/s
2. **Yaw to home heading** — 90°/s
3. **Cruise to home** — 12 m/s horizontal, maintain RTL altitude
4. **Descend to 5 m** — 2 m/s above launch point
5. **Land** — 1 m/s descent, disarm 2 s after touchdown detect (barometer + accelerometer)

RTL timeout: 120 s. If home not reached within timeout, execute forced landing at current position.

---

*"A drone that knows where it is can always find its way back. A drone that doesn't is already lost."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Navigation Systems Team
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
