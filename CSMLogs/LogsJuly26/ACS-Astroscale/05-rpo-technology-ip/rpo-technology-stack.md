# Astroscale RPO Technology Stack

> Rendezvous and Proximity Operations (RPO) is the foundational capability
> enabling all of Astroscale's servicing missions. This document describes
> the core technology layers.

## RPO Architecture Overview

Astroscale's RPO system is organized in four layers:

```
┌─────────────────────────────────────────┐
│ L4: Mission Autonomy & Ground Control    │
├─────────────────────────────────────────┤
│ L3: Guidance, Navigation & Control (GNC) │
├─────────────────────────────────────────┤
│ L2: Sensor Fusion & Perception           │
├─────────────────────────────────────────┤
│ L1: Sensor Suite (Cameras, Lidar, Radar) │
└─────────────────────────────────────────┘
```

## L1 — Sensor Suite

### Visible-Spectrum Cameras
- **Narrow-Field Camera (NFC):** 2° FOV, 16-megapixel CMOS. Long-range
  target acquisition at 50–100 km. Mounted on a 2-axis gimbal.
- **Medium-Field Camera (MFC):** 20° FOV, 8-megapixel CMOS. Navigation-
  grade imagery at 500 m – 5 km range.
- **Wide-Field Camera (WFC):** 120° FOV, 4-megapixel CMOS. Situational
  awareness during terminal approach. Used for collision avoidance when the
  target drifts out of the primary sensor cone.

### Scanning Lidar
- Wavelength: 1,550 nm (eye-safe, fiber-laser).
- Range resolution: ±2 cm at 100 m, ±15 cm at 1 km.
- Point cloud rate: 50,000 points/sec.
- Provides 3D point-cloud of the target for attitude determination and
  capture-point selection.

### Thermal Infrared Camera
- 8–14 μm microbolometer, 640×480 resolution.
- Used during eclipse phases when visible cameras lack illumination.
- Enables detection of thermal signatures from thruster plumes, confirming
  target passivity.

## L2 — Sensor Fusion & Perception

### Multi-Sensor Kalman Filter
An Extended Kalman Filter (EKF) fuses measurements from all sensors to
produce a real-time estimate of:
- Relative position (x, y, z) and velocity (ẋ, ẏ, ż).
- Target attitude (roll, pitch, yaw) and angular rates.
- Sensor biases (camera alignment, lidar boresight).

### Machine Learning Target Recognition
A convolutional neural network (CNN) running on a radiation-tolerant FPGA
(Xilinx Kintex UltraScale, space-qualified) provides:
- Target type classification from camera images.
- Segmentation of target structural features (nozzle, payload adapter ring,
  solar panels).
- Anomaly detection: identifying damage, missing components, or unexpected
  debris fragments.

### Debris Environment Monitor
Ancillary sensor processing tracks small debris objects (<10 cm) in the
vicinity of the target, using a combination of optical tracking and
conjunction analysis. Provides an autonomous collision-avoidance trigger.

## L3 — Guidance, Navigation & Control (GNC)

### Approach Modes
| Mode | Range | Sensor Primary | Control Law |
|------|-------|---------------|-------------|
| Far-Range | 50–100 km | GPS + NFC | Absolute orbit phasing |
| Mid-Range | 1–50 km | MFC + Lidar | Linear covariance guidance |
| Close-Range | 100 m–1 km | MFC + WFC + Lidar | Glideslope approach |
| Terminal | 0–100 m | Lidar + WFC | Closed-loop visual servoing |
| Capture | 0–2 m | Lidar + Force sensor | Impedance control |

### Key Algorithms
- **Glideslope Guidance:** Range-rate proportional to range, ensuring a
  controlled, zero-velocity arrival at the capture point.
- **Passive Abort:** Continuous monitoring of approach corridor; any
  violation triggers an autonomous retreat burn to a safe hold point.
- **Tumble Synchronization:** For targets with high angular rates, the GNC
  can match the target's tumble rate to reduce relative motion at capture.

## L4 — Mission Autonomy & Ground Control

### Ground Segment
- Mission Control Center (MCC) at Astroscale Tokyo.
- Redundant TT&C via JAXA ground stations (Uchinoura, Santiago) and
  commercial network (KSAT, SSC).
- Typical command latency: 2–4 seconds (S-band relay via GEO relay
  satellite).

### Autonomy Layers
- **Fully Autonomous:** Collision avoidance, safe-mode transitions, routine
  station-keeping.
- **Supervised Autonomous:** Approach corridor selection, sensor mode
  transitions, capture abort decisions — executed autonomously with
  ground-operator override capability.
- **Ground-Directed:** Capture initiation, deorbit burn authorization,
  anomaly investigation — requires explicit ground command.
