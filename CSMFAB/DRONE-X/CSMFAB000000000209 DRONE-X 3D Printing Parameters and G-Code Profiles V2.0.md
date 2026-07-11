# CSMFAB000000000209 — DRONE-X 3D Printing Parameters and G-Code Profiles
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Manufacturing Process Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — BFRP-Elium profiles, component-specific settings, 20h20m total print time |

---

## 1. Printer Requirements

| Parameter | Requirement |
|-----------|-------------|
| Printer type | FDM (fused deposition modeling) |
| Build volume (min) | 220 × 220 × 250 mm |
| Nozzle temperature (max) | ≥ 260°C |
| Bed temperature (max) | ≥ 110°C |
| Heated chamber | Recommended (≥ 45°C) |
| Nozzle material | Hardened steel (basalt fiber abrasive) |
| Nozzle diameter | 0.4 mm (standard), 0.6 mm (structural parts) |
| Firmware | Marlin 2.0+ or Klipper |

## 2. BFRP-Elium Filament Profile

| Parameter | Value |
|-----------|-------|
| Filament | BFRP-Elium (basalt fiber, ELIUM acrylic matrix) |
| Filament diameter | 1.75 ± 0.05 mm |
| Nozzle temperature | 250°C |
| Bed temperature | 100°C (first layer), 90°C (subsequent) |
| Chamber temperature | 50°C |
| Print speed | 45 mm/s (perimeters), 60 mm/s (infill) |
| First layer speed | 20 mm/s |
| Retraction | 2.0 mm @ 40 mm/s |
| Cooling fan | 0% first 3 layers, 30% thereafter |
| Bed adhesion | PEI sheet + Magigoo PA (or PVA glue stick) |
| Drying requirement | 60°C for 6h before printing |

## 3. Component-Specific Print Settings

| Component | Layer Ht (mm) | Perimeters | Infill % | Infill Pattern | Support | Print Time |
|-----------|---------------|------------|----------|---------------|---------|------------|
| Center hub top | 0.15 | 4 | 45% | Gyroid | No | 2h 40m |
| Center hub mid | 0.15 | 4 | 45% | Gyroid | No | 2h 20m |
| Center hub bottom | 0.15 | 4 | 45% | Gyroid | No | 2h 20m |
| Arm (×4) | 0.15 | 5 | 35% | Triangular | No | 1h 45m ea. |
| Motor mount pad | 0.10 | 6 | 60% | Rectilinear | No | 0h 25m ea. |
| Landing skid (×2) | 0.20 | 3 | 30% | Gyroid | No | 1h 00m ea. |
| Phone clamp body | 0.15 | 4 | 45% | Gyroid | No | 3h 10m |
| Phone clamp jaw | 0.15 | 4 | 55% | Rectilinear | No | 0h 45m |
| Dovetail insert | 0.10 | 6 | 70% | Rectilinear | No | 0h 30m |
| **Total** | | | | | | **20h 20m** |

## 4. G-Code Start and End Scripts

**Start G-Code:**
```
G28 ; Home all axes
M190 S100 ; Wait for bed temp
M104 S250 ; Set nozzle temp
M109 S250 ; Wait for nozzle temp
G1 Z5 F3000 ; Raise nozzle
G1 X5 Y5 F6000 ; Prime position
G92 E0 ; Reset extruder
G1 F200 E15 ; Prime 15mm
G92 E0 ; Reset extruder
```

**End G-Code:**
```
G91 ; Relative positioning
G1 E-3 F1800 ; Retract
G1 Z10 F600 ; Raise nozzle
G90 ; Absolute positioning
G1 X0 Y220 F6000 ; Present part
M104 S0 ; Turn off nozzle
M140 S0 ; Turn off bed
M106 S0 ; Turn off fan
M84 ; Disable motors
```

## 5. Post-Processing Requirements

| Step | Component | Method | Time |
|------|-----------|--------|------|
| Support removal | All | Manual break + flush cutters | 10 min |
| Thread tapping | Hub, mount pads | M3 × 0.5 tap, hand | 5 min |
| Thread insert install | Hub plates | M3 brass heat-set, soldering iron 230°C | 10 min |
| Surface sanding | Arms | 400 grit wet sand (NACA profile) | 15 min |
| Dovetail fitting | Arm-to-hub | Light sand for slip fit, < 0.1 mm clearance | 10 min |
| Annealing (optional) | Structural parts | 110°C oven, 2h ramp, 2h dwell, slow cool | 5 h |

## 6. Quality Control Checks

| Check | Method | Pass Criteria |
|-------|--------|---------------|
| Layer adhesion | Visual inspection, flex test coupon | No delamination |
| Dimensional accuracy | Caliper verification | ±0.2 mm on critical features |
| Dovetail fit | Dry fit before bolt install | Slip fit, < 0.1 mm play |
| Weight | Scale | Within ±5% of spec |
| Surface finish | Visual | No stringing, no burnt filament, no layer shift |

---

*"A printer is a sculptor that builds from nothing. Treat its settings as you would a chisel — with precision and respect."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon filament supplier change
- Distribution: Engineering Team, Manufacturing Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
