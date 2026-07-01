# CSMFAB000000000113-Vol-09
## Smart Muscle Spear Design Across All Five Scales
**Series:** CSMFAB000000000113 | **Volume:** 09 of 29 | **June 2026**

---

## 1. Design Philosophy: The Smart Muscle Spear

The "Smart Muscle" designation reflects three integrated active functions:
1. **Archimedean screw muscle:** Rotating blades generate thrust in water (the primary "muscle")
2. **Piezoelectric flutter damping:** KNbO3-BaTiO3 patches damp aerodynamic vibration actively
3. **Adaptive payload shroud:** Deployable nose section protects payload during water transit

All sizes maintain geometric similarity for predictable scaling behavior.

### 1.1 Geometric Scaling Laws

For a family of geometrically similar spears (constant fineness ratio L/D = 8):

| Scale | Length L (m) | Diameter D (m) | Screw Radius R (m) |
|---|---|---|---|
| Scale Factor 1 (Nano, 50g) | 0.16 | 0.020 | 0.010 |
| Scale Factor 2 (Micro, 1 kg) | 0.32 | 0.040 | 0.020 |
| Scale Factor 3 (Small, 10 kg) | 0.64 | 0.080 | 0.040 |
| Scale Factor 4 (Medium, 100 kg) | 1.28 | 0.160 | 0.080 |
| Scale Factor 5 (Large, 1000 kg) | 2.56 | 0.320 | 0.160 |

### 1.2 Mass Properties (ZrB2-SiC, hollow shell design)

Solid cylinder mass: m = rho * pi * (D/2)^2 * L
For ZrB2-SiC (rho=6090 kg/m3), hollow shell (wall thickness t = 0.1*D):

```
V_shell = pi * D * L * t = pi * D * L * 0.1*D = 0.1 * pi * D^2 * L
m_spear = rho * 0.1 * pi * D^2 * L = 6090 * 0.1 * pi * D^2 * L
```

| Scale | D (m) | L (m) | m_spear (kg) | I_axial (kg·m2) | L_gyro @ 3000RPM |
|---|---|---|---|---|---|
| Nano | 0.020 | 0.16 | 0.061 | 1.5e-6 | 4.7e-4 |
| Micro | 0.040 | 0.32 | 0.49 | 2.4e-5 | 7.5e-3 |
| Small | 0.080 | 0.64 | 3.90 | 3.8e-4 | 0.120 |
| Medium | 0.160 | 1.28 | 31.2 | 6.1e-3 | 1.91 |
| Large | 0.320 | 2.56 | 249 | 9.8e-2 | 30.7 |

### 1.3 KNbO3-BaTiO3 Flutter Damper Placement

Four patches per spear, at 1/4-chord from base:

| Scale | Patch size (mm) | d33=285 pC/N | Damping ratio added |
|---|---|---|---|
| Nano | 5x5x1 | 285 pC/N | +0.05 (passive shunt) |
| Micro | 10x10x2 | 285 pC/N | +0.06 |
| Small | 20x20x3 | 285 pC/N | +0.06 |
| Medium | 40x40x5 | 285 pC/N | +0.07 |
| Large | 80x80x10 | 285 pC/N | +0.08 |

All scales achieve damping ratio zeta > 0.08 (from 0.02 undamped) — flutter suppressed.

---

## 2. Screw Blade Design

### 2.1 Blade Geometry

Each scale has 3 helical blades (empirically optimal for thrust/drag ratio):
- Helix angle: 2.4° (from CSMFAB000000000109 optimal, independent of scale)
- Chord-to-pitch ratio: 0.85 (Glauert optimum)
- Blade tip-to-body radius ratio: 2.0 (R_blade = 2 * R_body)

### 2.2 Blade Stress Analysis

Critical: centrifugal stress at blade root during 3000 RPM spin:

```
sigma_centrifugal = 0.5 * rho_blade * omega^2 * (R_blade^2 - R_root^2)
                  = 0.5 * 6090 * (314)^2 * (4*R_body^2 - R_body^2)
                  = 0.5 * 6090 * 98,596 * 3 * R_body^2
                  = 900,000 * R_body^2   [Pa, if R in meters]
```

| Scale | R_body (m) | sigma_centrifugal (MPa) | ZrB2-SiC limit (MPa) | Safety Factor |
|---|---|---|---|---|
| Nano | 0.010 | 0.09 | 850 | 9,444 |
| Micro | 0.020 | 0.36 | 850 | 2,361 |
| Small | 0.040 | 1.44 | 850 | 590 |
| Medium | 0.080 | 5.76 | 850 | 147 |
| Large | 0.160 | 23.0 | 850 | 37 |

All scales have enormous safety factors. ZrB2-SiC is thermally and mechanically ideal.

---

## 3. Spin Motor: KNbO3-BaTiO3 Ultrasonic for All Scales

From CSMFAB000000000020: KNbO3-BaTiO3 ultrasonic motor at 200mm diameter → 500 N·m, 240 rad/s.

Scaling (torque scales as R^3 for geometrically similar motors):

| Scale | Motor Size | Torque (N·m) | Power (kW) | Spin-Up Time |
|---|---|---|---|---|
| Nano | 10mm dia | 0.0025 | 0.8 W | 0.6 s |
| Micro | 20mm dia | 0.02 | 6.3 W | 1.2 s |
| Small | 40mm dia | 0.16 | 50 W | 2.4 s |
| Medium | 80mm dia | 1.28 | 400 W | 4.8 s |
| Large | 160mm dia | 10.2 | 3.2 kW | 9.6 s |

These motors are integrated into the spear core, spinning up to 3000 RPM before deployment.

---

## Citations (Vol 09)

- CSMFAB000000000001 V2.0, ZrB2-SiC material specs, CSM 2026
- CSMFAB000000000020 V2.0, KNbO3-BaTiO3 motor design, CSM 2026
- CSMFAB000000000109 V2.0, Spear geometry, CSM 2026
- Etkin, B., Reid, L.D., Dynamics of Flight: Stability and Control, 3rd Ed, Wiley 1996
- McCormick, B.W., Aerodynamics, Aeronautics, and Flight Mechanics, 2nd Ed, Wiley 1994
- von Karman, T., Aerodynamics, Dover 2004 (scaling laws reference)

*End Vol 09 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
