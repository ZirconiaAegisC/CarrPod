# CSMFAB000000000201 — DRONE-X Universal Phone Clamp Mechanism
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Mechanical Engineering Design Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — lead screw clamp design, jaw geometry, BFRP material spec, 200+ phone database |

---

## 1. Lead Screw Mechanism Design

The clamp employs a dual-opposed M6×1.0 lead screw driven by a central thumbwheel. One left-hand and one right-hand threaded rod couple to sliding jaws, converting rotary thumbwheel motion into opposing linear translation. Total jaw travel: 40 mm — accommodating phones from 61.0 mm (iPhone SE) to 88.0 mm (Samsung Galaxy S24 Ultra) in width.

| Parameter | Value |
|-----------|-------|
| Screw thread | M6 × 1.0 mm pitch |
| Drive mechanism | Central knurled thumbwheel, Ø 40 mm |
| Jaw travel | 40 mm (20 mm per jaw) |
| Linear force | 12 N clamping force at 0.5 N·m torque |
| Material | BFRP (Elium matrix, basalt fiber 45% vol) |
| Lubrication | PTFE dry film, applied once at assembly |
| Locking | Self-locking by thread friction angle (φ = 8.5° < arctan μ_s) |

## 2. Jaw Geometry

Each jaw features a V-groove contact profile lined with Shore A40 silicone rubber pads (3 mm thickness). The V-angle of 120° self-centers phones of varying thicknesses (6.5–12.0 mm). Pad dimensions: 40 mm × 12 mm × 3 mm with 1.5 mm radius edges to prevent phone case damage.

```
Jaw cross-section (end view):
        _________
       / 120°    \
      /           \
     |   [phone]   |
      \           /
       \_________/
```

| Contact Parameter | Value |
|-------------------|-------|
| V-groove angle | 120° |
| Pad material | Silicone Shore A40 |
| Pad contact area | 480 mm² per jaw |
| Contact pressure | 25 kPa (safe below 80 kPa display limit) |
| CG offset tolerance | ±3 mm lateral, ±5 mm vertical |

## 3. Material Specification

The clamp assembly is BFRP printed using the parameters defined in CSMFAB-209. Critical mechanical properties:

| Property | Value | Test Standard |
|----------|-------|---------------|
| Tensile strength | 180 MPa | ASTM D3039 |
| Flexural modulus | 22 GPa | ASTM D790 |
| Density | 1.52 g/cm³ | ASTM D792 |
| Clamp weight (total) | 47 g | — |
| Operating temperature | -20°C to +80°C | — |
| UV resistance | Excellent (Elium UV stabilizers) | ASTM G154 |

## 4. 3D Print Parameters

| Parameter | Value |
|-----------|-------|
| Nozzle diameter | 0.4 mm |
| Layer height | 0.15 mm |
| Wall perimeters | 4 |
| Infill | 45% gyroid |
| Print orientation | Z-axis vertical (lead screw aligned) |
| Support | None (self-supporting geometry) |
| Print time | 3h 10m |
| Filament used | 52 g BFRP-Elium |

## 5. Phone Compatibility Database

The full database (CSMFAB-206) covers 200+ devices. Key compatibility metrics:

| Phone Model | Width (mm) | Thickness (mm) | Mass (g) | Compatible |
|-------------|------------|----------------|----------|------------|
| iPhone SE (2022) | 67.3 | 7.3 | 144 | Yes |
| iPhone 15 Pro | 70.6 | 8.3 | 187 | Yes |
| iPhone 15 Pro Max | 76.7 | 8.3 | 221 | Yes |
| Samsung S24 | 70.6 | 7.6 | 167 | Yes |
| Samsung S24 Ultra | 79.0 | 8.6 | 232 | Yes |
| Google Pixel 8 Pro | 76.5 | 8.8 | 213 | Yes |
| OnePlus 12 | 75.8 | 9.2 | 220 | Yes |
| Xiaomi 14 Ultra | 75.3 | 9.2 | 224 | Yes |

## 6. Calibration Protocol

ArUco marker (ID=0, 40 mm) is laser-etched onto the clamp base plate. The app detects the marker through the phone's rear camera during initial setup to compute the 3D offset between the marker center and the phone's IMU origin. This offset is stored in the calibration profile and applied as a fixed-body transform in the sensor fusion pipeline (CSMFAB-215).

Calibration tolerance: ±1.0 mm lateral, ±1.5 mm vertical. Verified by known-pattern test flight with ±0.5° attitude error budget.

---

*"A clamp is a handshake between machine and pilot — make it firm but never crushing."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Fabrication Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
