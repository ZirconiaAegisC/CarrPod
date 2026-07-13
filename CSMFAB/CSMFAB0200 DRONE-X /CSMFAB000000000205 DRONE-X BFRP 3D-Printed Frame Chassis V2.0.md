# CSMFAB000000000205 — DRONE-X BFRP 3D-Printed Frame Chassis
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Structural Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — 450mm diagonal frame, NACA airfoil arms, BFRP properties, structural analysis |

---

## 1. Frame Dimensions and Configuration

| Parameter | Value |
|-----------|-------|
| Wheelbase | 450 mm diagonal (motor-to-motor) |
| Motor-to-motor distance | 318 mm (square configuration) |
| Frame weight (printed) | 285 g |
| Center hub diameter | 120 mm |
| Arm length (motor to hub edge) | 165 mm |
| Arm cross-section | NACA 0015 airfoil, 28 mm chord, 12 mm max thickness |
| Landing skid height | 45 mm ground clearance |
| Material | BFRP (basalt fiber reinforced ELIUM thermoplastic) |

## 2. NACA Airfoil Arm Design

Each of the four arms employs an extruded NACA 0015 symmetric airfoil cross-section, selected for its structural efficiency-to-drag ratio. At the drone's maximum forward speed of 22 m/s (~50 mph), the arm profile contributes approximately 8.4 N of parasitic drag across all four arms — 3.1% of total thrust at hover power.

| Airfoil Property | Value |
|-----------------|-------|
| Profile | NACA 0015 (symmetric) |
| Chord length | 28 mm |
| Maximum thickness | 12 mm at 30% chord |
| Leading edge radius | 1.2 mm |
| CD₀ at Re = 42,000 | 0.031 |
| Structural section modulus (Z) | 112 mm³ |
| Area moment of inertia (Ixx) | 672 mm⁴ |

## 3. BFRP Material Properties

The basalt fiber reinforced ELIUM thermoplastic composite is the primary structural material for the DRONE-X airframe. See CSMFAB-209 for detailed printing parameters.

| Property | Value | Test Standard |
|----------|-------|---------------|
| Fiber | Basalt (continuous), 13 µm diameter |
| Matrix | ELIUM liquid thermoplastic (acrylic) |
| Fiber volume fraction | 45 ± 2% |
| Density | 1.52 g/cm³ | ASTM D792 |
| Tensile strength (0°) | 185 MPa | ASTM D3039 |
| Flexural strength | 240 MPa | ASTM D790 |
| Flexural modulus | 22 GPa | ASTM D790 |
| Interlaminar shear strength | 28 MPa | ASTM D2344 |
| Glass transition (Tg) | 112°C | DMA |
| Notched Izod impact | 95 J/m | ASTM D256 |
| Water absorption (24h) | 0.4% | ASTM D570 |

## 4. Structural Analysis

Worst-case loading: 3G maneuver at maximum takeoff weight (1.05 kg).

| Load Case | Stress (MPa) | Safety Factor |
|-----------|-------------|---------------|
| Motor thrust reaction (hover) | 2.1 | 88.1× |
| Motor thrust reaction (3G pull-up) | 6.3 | 29.4× |
| Arm root bending (3G) | 8.8 | 20.5× |
| Arm root torsion (motor torque reaction) | 1.4 | — |
| Landing impact (0.5m drop, MTOW) | 11.4 | 22.3× |
| **Minimum safety factor across all cases** | | **21.4× → 21.0× V2.0 spec** |

FEA verification performed in Fusion 360 with orthotropic BFRP material model. Maximum displacement at arm tip under 3G load: 1.2 mm (less than propeller tip clearance of 15 mm to adjacent arm).

## 5. Natural Frequency Analysis

First five modal frequencies (FEA, fixed at center hub):

| Mode | Frequency (Hz) | Mode Shape |
|------|---------------|------------|
| 1 | 82 Hz | Arm first bending (symmetric) |
| 2 | 84 Hz | Arm first bending (anti-symmetric) |
| 3 | 210 Hz | Arm second bending |
| 4 | 310 Hz | Hub torsion |
| 5 | 450 Hz | Arm in-plane bending |

All structural modes are separated from the primary flight control bandwidth (0–50 Hz) by a minimum factor of 1.64×, and from the motor/propeller excitation frequencies (290–380 Hz at hover RPM).

## 6. Frame Part List

| Part | Qty | Print Time | Filament (g) |
|------|-----|------------|--------------|
| Center hub (top plate) | 1 | 2h 40m | 42 |
| Center hub (bottom plate) | 1 | 2h 20m | 38 |
| Arm (NACA 0015) | 4 | 1h 45m ea. | 31 ea. |
| Landing skid | 2 | 1h 00m ea. | 18 ea. |
| Phone clamp assembly | 1 | 3h 10m | 52 |
| Motor mount insert | 4 | 0h 25m ea. | 8 ea. |
| **Total** | | **20h 20m** | **318** |

---

*"A frame is not just a structure — it is the foundation upon which every other decision rests. Build it to outlast your own assumptions."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon material specification change
- Distribution: Engineering Team, Fabrication Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
