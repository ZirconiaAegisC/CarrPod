# CSMFAB000000000216 — DRONE-X Camera Computer Vision Pipeline
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Computer Vision Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — MobileNetV3-SSD-Lite detection, depth estimation tiers (LiDAR/stereo/MiDaS), visual odometry |

---

## 1. Object Detection Pipeline

| Parameter | Value |
|-----------|-------|
| Model | MobileNetV3-SSD-Lite (COCO pre-trained + fine-tuned) |
| Framework | TensorFlow Lite (Android), Core ML (iOS) |
| Input resolution | 320 × 320 px |
| Inference time | 12 ms (iPhone 15 Pro, ANE), 22 ms (Snapdragon 8 Gen 2) |
| Frame rate | 30 Hz (dedicated VisionThread) |
| Classes detected | Person, car, bicycle, motorcycle, bus, truck, bird, drone (custom fine-tuned) |
| Confidence threshold | 0.55 (display), 0.75 (avoidance trigger) |
| NMS IoU threshold | 0.45 |

The model is quantized to INT8 (TensorFlow Lite) or FP16 (Core ML) for on-device inference. A custom "drone" class was fine-tuned on 15,000 annotated UAV images across 12 drone models.

## 2. Depth Estimation Tiers

DRONE-X supports four depth estimation tiers based on phone capability:

| Tier | Phone Requirement | Method | Range | Accuracy | Update Rate |
|------|-------------------|--------|-------|----------|-------------|
| 1 — LiDAR | iPhone 12 Pro+ | Apple LiDAR dToF | 0.2–5.0 m | ±1 cm | 30 Hz |
| 2 — Stereo | Dual cameras, ≥ 50 mm baseline | Semi-global matching (SGM) | 0.3–10.0 m | ±5 cm at 3 m | 15 Hz |
| 3 — Monocular | Any phone with camera | MiDaS v3.1 (TensorFlow Lite) | 0.5–20.0 m | ±15% relative | 10 Hz |
| 4 — Bounding Box | Any phone with camera | Object width × focal length heuristic | 2.0–50.0 m | ±30% | 30 Hz |

Tier is auto-selected during app initialization based on detected phone hardware. Tier 4 is always available as a fallback.

## 3. Obstacle Detection Pipeline (Per Frame)

1. **Grab frame** from rear camera at 320×320 (YUV → RGB)
2. **Run MobileNetV3-SSD-Lite** inference → bounding boxes + class + confidence
3. **Estimate depth** for each detection box center using active depth tier
4. **Project to world coordinates** using drone attitude (Madgwick quaternion) + camera calibration matrix
5. **Update obstacle map** (grid-based, 20m × 20m, 0.5m resolution)
6. **Compute avoidance vector** using potential field method (CSMFAB-219)

## 4. Visual Odometry

Visual-inertial odometry (VIO) fuses camera feature tracking with IMU data for GPS-denied position estimation:

| Parameter | Value |
|-----------|-------|
| Algorithm | VINS-Mono (tightly-coupled VIO) |
| Features | FAST corner detector, KLT optical flow tracking |
| Feature count | 100–200 features per frame |
| IMU rate | 400 Hz |
| Camera rate | 30 Hz |
| Position drift | < 2% of distance traveled (indoors) |
| Integration | Fused with GPS EKF when GPS available (CSMFAB-217) |

VIO provides position hold in GPS-denied environments (indoors, urban canyons) for up to 30 seconds with < 1 m drift accumulation.

## 5. Computational Budget

| Pipeline Stage | Time (ms, iPhone 15 Pro) | Time (ms, Snapdragon 8 Gen 2) |
|---------------|--------------------------|-------------------------------|
| Frame grab + prep | 1.5 | 2.0 |
| Object detection inference | 12.0 | 22.0 |
| Depth estimation (LiDAR) | 3.0 | N/A |
| Depth estimation (MiDaS) | N/A | 18.0 (fallback) |
| Obstacle projection | 1.0 | 1.5 |
| Visual odometry (VIO) | 8.0 | 12.0 |
| **Total per frame (LiDAR)** | **25.5 ms** | — |
| **Total per frame (MiDaS)** | — | **55.5 ms** |
| **Achievable frame rate** | **30 Hz** | **18 Hz** |

---

*"A camera sees pixels. A vision pipeline sees consequences. Train it to recognize both."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon model update
- Distribution: Engineering Team, ML/CV Team
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
