# CSMFAB000000000200 — DRONE-X System Architecture Overview
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Engineering System Architecture Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — complete DRONE-X architecture definition, 30-doc cross-reference, topology specification |

---

## 1. System Topology

DRONE-X is a 450 mm diagonal quadcopter utilizing a smartphone as the primary flight controller, sensor suite, and compute platform. The system is organized into seven functional domains:

| Domain | Components | Critical Path |
|--------|------------|---------------|
| Airframe | BFRP 3D-printed frame (450 mm), NACA airfoil arms, central hub | CSMFAB-205, 207, 209 |
| Propulsion | T-Motor F2306 1900KV ×4, 6040 3-blade props, BLHeli_32 ESCs ×4 | CSMFAB-208, 210 |
| Power | GNB 3S 1800 mAh LiPo, PDB, phone power sharing circuit, MXene EMI shield | CSMFAB-211, 212, 213, 214 |
| Compute Bridge | STM32F103C8T6 USB-C OTG MCU (primary), HC-05 Bluetooth (fallback) | CSMFAB-202, 203 |
| Phone Compute | Android/iOS app, Kotlin/Swift, PID/Madgwick, CV pipeline | CSMFAB-204, 215, 216 |
| Navigation | Multi-GNSS, EKF filter, phone IMU/barometer/magnetometer fusion | CSMFAB-215, 217, 218 |
| Safety | 6-layer failsafe architecture, triple-daemon watchdog, kill switch | CSMFAB-211, 224, 228 |

## 2. USB-C Protocol Architecture

The STM32F103C8T6 USB-C OTG MCU operates in USB Host mode, establishing a CDC ACM (virtual COM) bridge to the phone at 12 Mbps Full Speed. The MCU exposes a unified serial protocol at 921600 baud with the following frame structure:

```
[SYNC 0xAA] [CMD 1B] [LEN 1B] [PAYLOAD 0-32B] [CRC16 2B] [SYNC 0x55]
```

Command categories: 0x00-0x1F (flight control), 0x20-0x3F (telemetry), 0x40-0x5F (configuration), 0x60-0x7F (diagnostics), 0x80-0x9F (LoRa bridge pass-through), 0xA0-0xBF (safety).

## 3. Phone Requirements

| Parameter | Minimum | Recommended |
|-----------|---------|--------------|
| Android | ≥ 8.0 (API 26) | ≥ 12 (API 31) |
| iOS | ≥ 14.0 | ≥ 16.0 |
| USB-C | Required (OTG host) | USB 3.1+ for speed |
| Sensors | Accelerometer, gyro, magnetometer, barometer | + LiDAR/ToF, dual cameras |
| Processor | Quad-core ≥ 1.6 GHz | Octa-core ≥ 2.4 GHz |
| RAM | 3 GB | 6 GB+ |
| GPU | Adreno 506 / Apple A10 | Adreno 650 / Apple A14+ |

## 4. Safety Architecture

Six-layer safety model (detailed in CSMFAB-224):
1. **Physical Kill Switch** — DPDT arm switch on PDB, zero-power disconnect
2. **MCU Watchdog** — STM32F103 independent watchdog (IWDG), 500 ms timeout
3. **Software Failsafe** — App-side loss-of-signal detection, auto-RTL after 2.0 s
4. **Geofence** — Hard radius 500 m, altitude ceiling 120 m (FAA Part 107)
5. **Battery Failsafe** — Voltage threshold 10.5V (3S LiPo), forced landing at 10.2V
6. **Daemon Watchdog** — Triple-daemon architecture (CSMFAB-228, dronex_daemon_watchdog.sh)

## 5. Document Cross-Reference

| CSMFAB ID | Title |
|-----------|-------|
| 200 | System Architecture Overview (this document) |
| 201 | Universal Phone Clamp Mechanism |
| 202 | USB-C OTG Bridge MCU Design |
| 203 | Bluetooth Bridge Protocol |
| 204 | Control Application Architecture |
| 205 | BFRP 3D-Printed Frame Chassis |
| 206 | Phone Dimension Database and Clamp Calibration |
| 207 | Central Hub and Arm Interface |
| 208 | Motor Mount and Propeller Selection |
| 209 | 3D Printing Parameters and G-Code Profiles |
| 210 | Propulsion System |
| 211 | Power Distribution Board Design |
| 212 | Battery Selection and Power Budget |
| 213 | Phone Battery Power Sharing Circuit |
| 214 | MXene EMI Shielding for Avionics Bay |
| 215 | IMU Sensor Fusion and Flight PID Controller |
| 216 | Camera Computer Vision Pipeline |
| 217 | GPS Navigation and Waypoint System |
| 218 | Phone Sensor Integration |
| 219 | Obstacle Avoidance Using Phone Depth Cameras |
| 220 | LoRa Mesh Networking via Bluetooth Bridge |
| 221 | Multi-Phone Swarm Coordination Protocol |
| 222 | Dual-Phone Configuration |
| 223 | Cellular BVLOS Telemetry and Command Link |
| 224 | Flight Safety and Failsafe Architecture |
| 225 | Complete Assembly Manual |
| 226 | Pre-Flight Calibration and Test Protocol |
| 227 | Component Procurement List and BOM |
| 228 | Daemon Watchdog Triple-Check Protocol |
| 229 | Field Operation Manual and Pilot Training Guide |
| 230 | Phoenix Protocol End-of-Life Recycling |

---

*"A system is only as strong as its weakest link — design every link to exceed the maximum expected stress by a factor of five."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon major revision trigger
- Distribution: Engineering Team, Fabrication Partners, Regulatory Compliance
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
