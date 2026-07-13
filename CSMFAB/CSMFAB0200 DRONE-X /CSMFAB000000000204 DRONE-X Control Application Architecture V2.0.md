# CSMFAB000000000204 — DRONE-X Control Application Architecture
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Software Architecture Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — Kotlin/Swift architecture, threading model, PID/Madgwick, HUD, failsafe logic |

---

## 1. Technology Stack

| Platform | Language | Min SDK | UI Framework | Build System |
|----------|----------|---------|-------------|--------------|
| Android | Kotlin 1.9+ | API 26 (Android 8.0) | Jetpack Compose | Gradle 8.x |
| iOS | Swift 5.9+ | iOS 14.0 | SwiftUI | Xcode 15+ |

Shared C++ core via Kotlin/Native (Android) and Swift/C++ interop (iOS) for:
- Madgwick AHRS filter (CSMFAB-215)
- Cascaded PID controller (CSMFAB-215)
- Serial protocol encode/decode (CSMFAB-202)
- Motor mix matrix computation
- GPS EKF navigation filter (CSMFAB-217)

## 2. Threading Model

| Thread | Priority | Rate | Responsibilities |
|--------|----------|------|-----------------|
| FlightControlThread | REALTIME | 400 Hz | Sensor read, Madgwick update, PID compute, motor command TX |
| VisionThread | HIGH | 30 Hz | Camera frame grab, MobileNetV3 inference, depth estimation |
| TelemetryThread | NORMAL | 50 Hz | Telemetry serialization, logging, SD card write |
| NavigationThread | NORMAL | 10 Hz | GPS EKF update, waypoint management, geofence check |
| CommsThread | NORMAL | Event | Serial I/O to MCU bridge, BT management, LoRa relay |
| HUDThread | NORMAL | 60 Hz | UI render, alert management, pilot input capture |
| WatchdogThread | HIGH | 1 Hz | Heartbeat verification, failsafe escalation |

All threads run on a thread-pool executor with core pool size = CPU cores. Flight control thread is pinned to the fastest core via CPU affinity (Android: `setThreadAffinity`, iOS: `thread_policy_set`).

## 3. PID Controller Architecture

Cascaded PID architecture (see CSMFAB-215 for full math):

```
Pilot Input → [Rate PID 400Hz] → [Attitude PID 400Hz] → [Velocity PID 100Hz] → [Position PID 50Hz]
                  ↑ Motor Mix ←──┘
                          ↓
                    ESC Commands (via MCU bridge)
```

**Rate PID (innermost loop):**
- P_gain = 0.15, I_gain = 0.02, D_gain = 0.01
- Anti-windup: back-calculation method, Kb = 0.5
- D-term: filtered via 2nd-order Butterworth, fc = 50 Hz
- Output: normalized to [-1.0, +1.0] before motor mix

**Attitude PID (outer loop, angle mode):**
- P_gain = 6.0, I_gain = 0.1, D_gain = 0.0
- Max angle: 45° (configurable to 70° in acro mode)
- I-term limited to ±15% of total output

## 4. HUD and Pilot Interface

| HUD Element | Data Source | Update Rate |
|-------------|-------------|-------------|
| Artificial horizon | Madgwick quaternion → Euler | 60 Hz |
| Altitude tape | Barometer + GPS fusion | 20 Hz |
| Speed indicator | GPS ground speed + IMU integration | 20 Hz |
| Battery gauge | MCU ADC via telemetry | 10 Hz |
| GPS satellite count | GNSS UBX-NAV-SVINFO | 5 Hz |
| Signal strength (RSSI) | MCU link quality telemetry | 10 Hz |
| Flight mode indicator | App state machine | On change |
| Alert banner | Failsafe monitor | On trigger |
| Video preview | Camera frame (scaled 360p) | 30 Hz |

## 5. Failsafe Logic (App Side)

```
if (heartbeat_age > 2000ms) → trigger RTL mode
if (battery_V < 10.5V) → alert "LOW BATTERY, LAND NOW"
if (battery_V < 10.2V) → force land at current position
if (geofence_distance > 500m) → yaw 180° and return
if (altitude > 120m) → descend to 115m
if (kill_switch == ACTIVE) → immediate disarm + buzzer alert
if (GPS_fix < 3D for > 30s) → switch to ALT_HOLD mode
if (MCU_heartbeat_age > 500ms) → BT failover attempt (CSMFAB-203)
if (link_lost AND BT_failed) → execute pre-programmed RTL via MCU onboard failsafe
```

---

*"The pilot trusts the software with their machine — the software must earn that trust at 400 times per second."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon SDK version change
- Distribution: Engineering Team, Software Development Team
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
