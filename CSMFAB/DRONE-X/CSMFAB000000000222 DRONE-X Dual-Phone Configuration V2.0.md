# CSMFAB000000000222 — DRONE-X Dual-Phone Configuration
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** System Configuration Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — stacked phone mount, Wi-Fi Direct link, CV processor isolation, dual-phone use cases |

---

## 1. Dual-Phone Architecture

The DRONE-X frame and clamp assembly support a stacked dual-phone configuration. The lower phone ("Phone A") serves as the flight controller; the upper phone ("Phone B") serves as a dedicated computer vision processor.

```
[Phone B — CV Processor]  ← Wi-Fi Direct (5 GHz)
      ↑ (above, facing forward or downward)
[Phone A — Flight Controller]  ← USB-C → MCU Bridge
      ↑ (below, clamped to frame)
[MCU Bridge + PDB + Avionics]
```

| Role | Phone A (Flight Controller) | Phone B (CV Processor) |
|------|---------------------------|----------------------|
| Sensors used | IMU, barometer, GPS, microphone | Camera(s), LiDAR/ToF |
| Compute load | PID, Madgwick, telemetry, HUD | Object detection, depth, VIO, SLAM |
| Connectivity | USB-C to MCU bridge | Wi-Fi Direct to Phone A |
| UI | Active pilot HUD + telemetry | Optional debug/confidence overlay |
| Criticality | Flight-critical | Mission-enhancing (graceful degredation) |

## 2. Mechanical Configuration

| Parameter | Value |
|-----------|-------|
| Phone A position | Lower clamp slot, facing upward (pilot-visible screen) |
| Phone B position | Upper clamp slot, facing forward or downward |
| Phone-to-phone gap | 12 mm (airflow cooling) |
| Additional weight | Phone mass (typically 170–230 g) |
| CG shift | +15 mm upward (accommodated by PID authority) |
| Heat management | Gap airflow from propeller downwash |
| Total AUW with dual phones | ~1,200 g (still within 4:1 T:W at nominal voltage) |

The dual-phone clamp is an extended version of the standard clamp (CSMFAB-201), adding a second set of jaws 35 mm above the primary jaws. The extension is a bolt-on BFRP bracket (22 g, print time 1h 15m).

## 3. Wi-Fi Direct Communication Link

| Parameter | Value |
|-----------|-------|
| Protocol | Wi-Fi Direct (P2P) |
| Frequency | 5 GHz (802.11ac) |
| Effective throughput | 50–80 Mbps |
| Latency (RTT) | 3–5 ms |
| Data exchanged | Phone A → B: attitude, GPS, flight mode | Phone B → A: obstacle detections, depth grid, SLAM pose |

**Protocol format:** Protobuf over TCP (port 8888). Messages serialized as `[length: 4B uint32 LE] [protobuf payload]`.

Key messages:
- `Heartbeat` (10 Hz) — link alive + sequence
- `DroneState` (50 Hz) — attitude, position, velocity, battery
- `ObstacleReport` (15 Hz) — array of detected obstacles with position, class, confidence
- `DepthGrid` (5 Hz) — compressed occupancy grid
- `SLAMPose` (10 Hz) — visual SLAM position estimate in local frame

## 4. CV Processor Isolation

Phone B runs ONLY the computer vision pipeline and optional SLAM. It does NOT:
- Send motor commands (only Phone A can arm/command)
- Connect to the MCU bridge
- Run GPS/IMU fusion
- Control the flight mode state machine

This isolation ensures that a crash or performance degradation on Phone B cannot compromise flight safety. If Phone B disconnects, Phone A degrades to single-camera CV (its own rear camera) or Tier 4 bounding-box avoidance.

## 5. Dual-Phone Use Cases

| Use Case | Phone B Role | Benefit |
|----------|-------------|---------|
| Mapping/Survey | Downward camera for nadir imagery + photogrammetry | Orthomosaic generation without gimbal |
| BVLOS Inspection | Forward camera + telephoto for infrastructure inspection | Higher-res imagery, independent capture |
| Search & Rescue | Thermal camera (via external FLIR One attachment) | Heat signature detection while Phone A flies |
| Agricultural Survey | Multispectral camera (via USB attachment) | NDVI computation on dedicated processor |
| AI Research | Custom ML model inference on Phone B | Experimental models without flight safety risk |
| Delivery Confirmation | Downward camera for package drop verification | Photo confirmation without interrupting flight |

## 6. Limitations

| Limitation | Impact |
|------------|--------|
| Increased AUW | Reduced flight time by ~15% (from 6.3 to 5.4 min hover) |
| CG shift | Reduced pitch authority margin from 82% to 74% (still above 70% threshold) |
| Heat accumulation | Both phones in close proximity may thermally throttle under direct sun |
| Wi-Fi interference | 5 GHz Wi-Fi Direct coexists with 2.4 GHz Bluetooth; no interference observed in testing |
| Phone battery drain | Phone B not charged by drone PDB (only Phone A via power sharing circuit) |

---

*"Two phones aren't twice the phone — they're a division of labor that makes each phone better at what it does."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Advanced Mission Planning Team
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
