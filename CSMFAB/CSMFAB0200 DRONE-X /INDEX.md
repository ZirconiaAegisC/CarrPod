# DRONE-X Documentation Index
## Complete Navigational Index — All 30 CSMFAB Documents + Scripts
**Version 2.0 — July 2026**
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company

---

## Quick-Reference Guide

| If you need to... | Read... |
|-------------------|---------|
| Understand the whole system | CSMFAB-200 (Architecture Overview) |
| Build the drone | CSMFAB-225 (Assembly Manual) |
| Buy parts | CSMFAB-227 (Component Procurement List and BOM) |
| Fly safely | CSMFAB-229 (Field Operation Manual) |
| Calibrate before flight | CSMFAB-226 (Pre-Flight Calibration) |
| Troubleshoot safety issues | CSMFAB-224 (Failsafe Architecture) |
| Set up the daemon watchdog | CSMFAB-228 + dronex_daemon_watchdog.sh |
| Print the frame | CSMFAB-205 + CSMFAB-209 |
| Configure the app | CSMFAB-204 (Control Application) |
| Understand sensor fusion | CSMFAB-215 (IMU/PID) |
| Set up swarm operations | CSMFAB-220 + CSMFAB-221 |
| Fly BVLOS | CSMFAB-223 + CSMFAB-229 (Level 2) |
| Set up dual-phone | CSMFAB-222 |
| Recycle end-of-life drone | CSMFAB-230 (Phoenix Protocol) |

---

## System Architecture & Integration
| ID | Document | Key Sections |
|----|----------|-------------|
| CSMFAB-200 | System Architecture Overview | Topology, USB-C protocol, phone requirements, safety layers, full cross-reference |
| CSMFAB-204 | Control Application Architecture | Kotlin/Swift, threading model, PID/Madgwick, HUD, failsafe logic |
| CSMFAB-218 | Phone Sensor Integration | Barometer, magnetometer, microphone FFT, ambient light, NFC, LiDAR mapping |

---

## Mechanical Design
| ID | Document | Key Sections |
|----|----------|-------------|
| CSMFAB-201 | Universal Phone Clamp Mechanism | Lead screw design, jaw geometry, BFRP material, ArUco calibration |
| CSMFAB-205 | BFRP 3D-Printed Frame Chassis | 450 mm diagonal, NACA 0015 airfoil arms, structural analysis (21× safety factor) |
| CSMFAB-207 | Central Hub and Arm Interface | 60° dovetail, center stack layers, wire routing, landing skids |
| CSMFAB-208 | Motor Mount and Propeller Selection | 16×19 mm mount, motor options, propeller matrix, thrust-to-weight 4.26:1 |
| CSMFAB-209 | 3D Printing Parameters and G-Code Profiles | BFRP-Elium profiles, component-specific settings, 20h20m total print time |

---

## Electronics & Power
| ID | Document | Key Sections |
|----|----------|-------------|
| CSMFAB-202 | USB-C OTG Bridge MCU Design | STM32F103C8T6 BOM, pin assignments, firmware, PCB specs ($10.44 BOM) |
| CSMFAB-203 | Bluetooth Bridge Protocol | HC-05 config, latency budget (USB 3ms vs BT 9ms), failover, security |
| CSMFAB-210 | Propulsion System | T-Motor F2306, BLHeli_32 ESC, motor wiring, EMI management |
| CSMFAB-211 | Power Distribution Board Design | PDB schematic, ACS758 current sensor, kill switch, phone charging rail |
| CSMFAB-212 | Battery Selection and Power Budget | GNB 3S 1800 mAh recommended, 6.3 min hover, LiFePO4 option |
| CSMFAB-213 | Phone Battery Power Sharing Circuit | Mode A (charging) vs Mode B (phone-as-battery), MT3608 boost, DPDT switch |
| CSMFAB-214 | MXene EMI Shielding for Avionics Bay | Ti₃C₂Tₓ 45 µm spray coating, 92 dB SE, synthesis and QC |

---

## Flight Control & Navigation
| ID | Document | Key Sections |
|----|----------|-------------|
| CSMFAB-215 | IMU Sensor Fusion and Flight PID Controller | Madgwick filter, cascaded PID, motor mix table, auto-tune |
| CSMFAB-216 | Camera Computer Vision Pipeline | MobileNetV3-SSD-Lite, depth tiers (LiDAR/stereo/MiDaS), visual odometry |
| CSMFAB-217 | GPS Navigation and Waypoint System | Multi-constellation GNSS, EKF nav filter, waypoint JSON, geofence, RTL |
| CSMFAB-219 | Obstacle Avoidance Using Phone Depth Cameras | 4-tier depth, potential field avoidance, avoidance envelopes |

---

## Networking & Swarm
| ID | Document | Key Sections |
|----|----------|-------------|
| CSMFAB-220 | LoRa Mesh Networking via Bluetooth Bridge | RFM95W SX1276, 915 MHz, 64-node mesh, swarm commands, 8 km range |
| CSMFAB-221 | Multi-Phone Swarm Coordination Protocol | State machine, inter-drone collision avoidance, leader election, mission types |
| CSMFAB-222 | Dual-Phone Configuration | Stacked phones, Wi-Fi Direct link, CV processor isolation, use cases |
| CSMFAB-223 | Cellular BVLOS Telemetry and Command Link | 4G/5G C2 link, WebRTC cloud relay, Part 107 waiver compliance |

---

## Safety, Operations & Lifecycle
| ID | Document | Key Sections |
|----|----------|-------------|
| CSMFAB-206 | Phone Dimension Database and Clamp Calibration | 200+ phones, ArUco calibration, CG offset tolerances |
| CSMFAB-224 | Flight Safety and Failsafe Architecture | 6-layer safety model (kill switch, MCU watchdog, software, geofence, battery, daemon) |
| CSMFAB-225 | Complete Assembly Manual | 14-step build, tools list, 4–6 hour assembly time |
| CSMFAB-226 | Pre-Flight Calibration and Test Protocol | 11 enforced checks, in-flight validation, post-flight review, maintenance schedule |
| CSMFAB-227 | Component Procurement List and BOM | Complete BOM, $162.07/drone marginal cost, alternatives, batch pricing |
| CSMFAB-228 | Daemon Watchdog Triple-Check Protocol | Daemon A (Exec 400 Hz), B (Check 200 Hz), C (Watchdog 1 Hz), meta-watchdog |
| CSMFAB-229 | Field Operation Manual and Pilot Training Guide | Part 107 cert, procedures, emergencies, 10-hour training curriculum |
| CSMFAB-230 | Phoenix Protocol End-of-Life Recycling | 92% recovery, thermosolvolysis, D2EHPA hydrometallurgy, 71% CO₂ reduction |

---

## Supporting Scripts
| File | Purpose |
|------|---------|
| dronex_daemon_watchdog.sh | Triple-daemon watchdog implementation (start/stop/status/test) |
| dronex_double_check.sh | Pre-existing file — double-check validation script |

---

*"Documentation is the difference between a prototype and a product. Every unanswered question in the field becomes a failure in the air."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Updated whenever any CSMFAB document is revised
- Distribution: All Engineering Teams, End Users, Regulatory Bodies
- Next Scheduled Review: July 2027
- Status: APPROVED — Living Document
