# CSMFAB000000000206 — DRONE-X Phone Dimension Database and Clamp Calibration
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Calibration and Reference Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — 200+ phone database, ArUco calibration protocol, CG offset tolerance matrix |

---

## 1. Phone Compatibility Data (Selected Entries)

Full database maintained in `dronex_phone_db.json` (200+ entries). Representative sample:

| Make | Model | Width (mm) | Height (mm) | Thick (mm) | Mass (g) | IMU Chip | USB-C | ToF/LiDAR |
|------|-------|------------|-------------|------------|----------|----------|-------|-----------|
| Apple | iPhone SE (2022) | 67.3 | 138.4 | 7.3 | 144 | ICM-20600 | No (Lightning) | No |
| Apple | iPhone 14 | 71.5 | 146.7 | 7.8 | 172 | Bosch BMI | No (Lightning) | No |
| Apple | iPhone 15 Pro | 70.6 | 146.6 | 8.3 | 187 | Bosch BMI | Yes | Yes (LiDAR) |
| Apple | iPhone 15 Pro Max | 76.7 | 159.9 | 8.3 | 221 | Bosch BMI | Yes | Yes (LiDAR) |
| Samsung | Galaxy S23 | 70.9 | 146.3 | 7.6 | 168 | LSM6DSO | Yes | No |
| Samsung | Galaxy S24 Ultra | 79.0 | 162.3 | 8.6 | 232 | LSM6DSV | Yes | No |
| Google | Pixel 7 | 73.2 | 155.6 | 8.7 | 197 | LSM6DSO | Yes | No |
| Google | Pixel 8 Pro | 76.5 | 162.6 | 8.8 | 213 | LSM6DSV | Yes | Yes (ToF) |
| OnePlus | 12 | 75.8 | 164.3 | 9.2 | 220 | ICM-4x | Yes | Yes (ToF) |
| Xiaomi | 14 Ultra | 75.3 | 161.4 | 9.2 | 224 | ICM-4x | Yes | Yes (ToF) |
| Motorola | Edge 40 Pro | 74.0 | 161.2 | 8.6 | 199 | LSM6DSO | Yes | No |
| ASUS | Zenfone 10 | 68.1 | 146.5 | 9.4 | 172 | ICM-4x | Yes | No |

## 2. ArUco Calibration Protocol

A laser-etched ArUco marker (DICT_4X4_50, ID=0, 40 mm square) is affixed to the clamp base plate. During initial phone-mount calibration:

1. Phone is clamped and powered on with DRONE-X app
2. App requests rear camera stream at 1080p
3. OpenCV ArUco detector locates marker, computes 6-DOF pose via solvePnP
4. Known marker dimensions (40 mm) plus known phone dimensions (database) produce IMU-to-marker transform
5. Transform is stored as quaternion + translation vector in phone profile

**Calibration Accuracy Requirements:**

| Axis | Tolerance | Verification Method |
|------|-----------|---------------------|
| X (lateral) | ±1.0 mm | Gauge block in frame |
| Y (vertical) | ±1.5 mm | Gauge block in frame |
| Z (fore-aft) | ±2.0 mm | Camera depth from ArUco |
| Roll | ±0.3° | Level surface test |
| Pitch | ±0.3° | Level surface test |
| Yaw | ±0.5° | Known-orientation fixture |

## 3. Center of Gravity Offset Tolerances

Phone CG offset from vehicle CG affects attitude control authority. The following tolerance matrix governs acceptable configurations:

| Phone Mass (g) | Max Lateral Offset (mm) | Max Fore-Aft Offset (mm) | Roll Authority Remaining |
|----------------|------------------------|--------------------------|-------------------------|
| < 150 | ±25 | ±30 | 92% |
| 150–180 | ±20 | ±25 | 87% |
| 180–210 | ±15 | ±20 | 82% |
| 210–240 | ±10 | ±15 | 76% |
| > 240 | ±8 | ±12 | 70% |

CG offset is computed by the app during calibration and must pass the authority threshold (> 70%) for arming to be permitted.

## 4. Incompatible Phones

| Phone | Reason |
|-------|--------|
| Phones > 88 mm width | Beyond jaw travel maximum |
| Phones > 250 g | Exceeds CG offset authority threshold at any offset |
| Phones without IMU | Cannot perform attitude estimation |
| Phones with foldable displays | Unpredictable CG shift during flight |
| Phones with mechanical stabilization cameras | Vibration damage risk |

---

*"Know your payload. A millimeter of unmeasured offset becomes a meter of uncorrected error at distance."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Quarterly (phone database updates)
- Distribution: Engineering Team, App Development Team
- Next Scheduled Review: October 2026
- Status: APPROVED — Production Baseline
