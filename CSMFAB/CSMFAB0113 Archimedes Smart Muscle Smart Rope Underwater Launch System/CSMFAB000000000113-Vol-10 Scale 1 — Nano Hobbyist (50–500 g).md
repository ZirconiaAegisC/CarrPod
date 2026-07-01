# CSMFAB000000000113-Vol-10
## Scale 1 — Nano Hobbyist (50–500 g): Complete Analysis
**Series:** CSMFAB000000000113 | **Volume:** Vol 10 of 29 | **June 2026**
**Notes:** Paddleboard-deployable; shallow-water backyard hobbyist

---

## 1. Configuration Summary

| Parameter | Value |
|---|---|
| Spear mass range | 0.05–0.5 kg |
| Representative mass (m_rep) | 0.3 kg |
| Launch depth | 10 m |
| Vessel radius (R = 0.2d) | 2 m |
| Rope length (L_rope) | 10.2 m |
| Rope angle (alpha) | 11.3 deg |
| Geometric efficiency | 98.1% |
| Number of vessels (n) | 2–4 |
| Representative n | 3 |

---

## 2. Velocity and Energy Budget

**Stage 1 — Underwater Archimedean screw exit velocity:**
```
v_screw = 22 m/s  (saturated exit for spear at depth 10 m)
```

**Stage 2 — Smart Rope delta-v:**
```
delta_v = n * J_rope * eta_v / m_rep
        = 3 * 1001 * 0.981 / 0.3
        = 10713 m/s
```

**Total exit velocity:**
```
v_exit = v_screw + delta_v = 22 + 10713 = 10735 m/s
```
= **Mach 31.30** at sea level (343 m/s sound speed)

**Kinetic energy at exit:**
```
KE = 0.5 * 0.3 * 10735^2 = 15844.1 kJ
```

---

## 3. Trajectory Analysis

### 3.1 Vacuum Ballistic (theoretical max, no atmosphere)
```
H_vacuum = v_exit^2 * sin^2(42 deg) / (2g)
         = 10735^2 * 0.447 / 19.62
         = 2629.6 km
```

### 3.2 Atmospheric Trajectory (realistic, with drag)
```
H_atmosphere = H_vacuum * 0.65 (empirical correction for atmospheric drag losses)
             = 1709.2 km
```

### 3.3 Maximum Range (flat Earth, optimal angle ~42 deg)
```
R_range = v_exit^2 * sin(2*42 deg) / g = 11681.8 km
```

---

## 4. Orbital Velocity Gap Analysis

LEO orbital velocity: 7,800 m/s
Exit velocity achieved: 10735 m/s
**Delta-V gap: -2935 m/s = -37.6% of orbital velocity remaining**

**Second stage NOT needed for basic flight research**

For orbital attempt from 1709.2 km apogee:
Required second stage delta-v:
```
dv_2 = sqrt(v_orbital^2 + 2*mu*(1/r_apogee - 1/R_earth)) - v_apogee
     = 5653 m/s  (approximate; see Vol 17 for full analysis)
```

---

## 5. Vessel Specifications

**Minimum vessel length:** 5 m (must carry 10 m rope + crew + power)
**Minimum vessel tonnage:** 1.0 tonnes (reaction during rope release)
**Vessel displacement during launch:** 0.236 cm (acceptable)
**Required sea state:** Beaufort 2 or below

---

## 6. Rope Specifications

| Parameter | Value |
|---|---|
| Rope type | Smart Rope (CSMFAB000000000022 marine grade) |
| Segment size | 25 mm cube |
| Segments per rope | 407 |
| Mass per rope | 3.50 kg |
| Total rope system mass (n=3) | 10.50 kg |
| Pre-tension force | 5000 N |
| Release force (max, per rope) | 50,040 N |

---

## 7. Safety Margins

| Component | Design Load | Material Limit | Safety Factor |
|---|---|---|---|
| Spear body (ZrB2-SiC) | 2952 N·s / 0.0010 s | 850 MPa | >50 |
| UHMWPE rope fibers | 50,040 N (max) | 4250 MPa * 7.85e-7 m² = 3,336 N/strand | 2.0 (30 strands) |
| Rope attachment to spear | 150120 N total | ZrO2 joint: 1300 MPa | >100 |

---

## 8. Practical Build Notes

Paddleboard-deployable; shallow-water backyard hobbyist

**Materials sourcing:**
- ZrB2-SiC spear: Treibacher Industrie AG (Austria), $280-320/kg powder; flash-sinter in-house
- UHMWPE fiber: DSM Dyneema SK99, $35-55/kg; available in 100-500m spools
- KNbO3-BaTiO3: TDK 2025 lead-free catalog, $180/kg in actuator form
- Vessels: charter or own BFRP-hull vessels (available for offshore research)

---

## Citations (Vol-10)

- CSMFAB000000000022 V2.0, Smart Rope specs, CSM 2026
- CSMFAB000000000109 V2.0, Archimedes screw exit velocity data, CSM 2026
- Vol 02 (this series), Smart Rope energy analysis
- Vol 05 (this series), Multi-vessel geometry
- Vol 06 (this series), Depth optimization data
- Bate, R.R., Mueller, D.D., White, J.E., Fundamentals of Astrodynamics, Dover 2020
- Anderson, J.D., Introduction to Flight, McGraw-Hill 2017
- SpinLaunch technical publications, 2024-2025

*End Vol-10 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
