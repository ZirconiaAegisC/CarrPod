# CSMFAB000000000113-Vol-13
## Scale 4 — Medium Amateur (50–500 kg): Complete Analysis
**Series:** CSMFAB000000000113 | **Volume:** Vol 13 of 29 | **June 2026**
**Notes:** Institutional; sub-orbital science; significant SRM needed

---

## 1. Configuration Summary

| Parameter | Value |
|---|---|
| Spear mass range | 50–500 kg |
| Representative mass (m_rep) | 275.0 kg |
| Launch depth | 40 m |
| Vessel radius (R = 0.2d) | 8 m |
| Rope length (L_rope) | 40.8 m |
| Rope angle (alpha) | 11.3 deg |
| Geometric efficiency | 98.1% |
| Number of vessels (n) | 8–10 |
| Representative n | 9 |

---

## 2. Velocity and Energy Budget

**Stage 1 — Underwater Archimedean screw exit velocity:**
```
v_screw = 22 m/s  (saturated exit for spear at depth 40 m)
```

**Stage 2 — Smart Rope delta-v:**
```
delta_v = n * J_rope * eta_v / m_rep
        = 9 * 1001 * 0.981 / 275.0
        = 32 m/s
```

**Total exit velocity:**
```
v_exit = v_screw + delta_v = 22 + 32 = 54 m/s
```
= **Mach 0.16** at sea level (343 m/s sound speed)

**Kinetic energy at exit:**
```
KE = 0.5 * 275.0 * 54^2 = 403.0 kJ
```

---

## 3. Trajectory Analysis

### 3.1 Vacuum Ballistic (theoretical max, no atmosphere)
```
H_vacuum = v_exit^2 * sin^2(42 deg) / (2g)
         = 54^2 * 0.447 / 19.62
         = 0.1 km
```

### 3.2 Atmospheric Trajectory (realistic, with drag)
```
H_atmosphere = H_vacuum * 0.65 (empirical correction for atmospheric drag losses)
             = 0.0 km
```

### 3.3 Maximum Range (flat Earth, optimal angle ~42 deg)
```
R_range = v_exit^2 * sin(2*42 deg) / g = 0.3 km
```

---

## 4. Orbital Velocity Gap Analysis

LEO orbital velocity: 7,800 m/s
Exit velocity achieved: 54 m/s
**Delta-V gap: 7746 m/s = 99.3% of orbital velocity remaining**

**Second stage required for orbital attempt**

For orbital attempt from 0.0 km apogee:
Required second stage delta-v:
```
dv_2 = sqrt(v_orbital^2 + 2*mu*(1/r_apogee - 1/R_earth)) - v_apogee
     = 7789 m/s  (approximate; see Vol 17 for full analysis)
```

---

## 5. Vessel Specifications

**Minimum vessel length:** 12 m (must carry 41 m rope + crew + power)
**Minimum vessel tonnage:** 13.8 tonnes (reaction during rope release)
**Vessel displacement during launch:** 0.514 cm (acceptable)
**Required sea state:** Beaufort 3 or below

---

## 6. Rope Specifications

| Parameter | Value |
|---|---|
| Rope type | Smart Rope (CSMFAB000000000022 marine grade) |
| Segment size | 25 mm cube |
| Segments per rope | 1631 |
| Mass per rope | 14.03 kg |
| Total rope system mass (n=9) | 126.24 kg |
| Pre-tension force | 137500 N |
| Release force (max, per rope) | 50,040 N |

---

## 7. Safety Margins

| Component | Design Load | Material Limit | Safety Factor |
|---|---|---|---|
| Spear body (ZrB2-SiC) | 14888 N·s / 0.7535 s | 850 MPa | >50 |
| UHMWPE rope fibers | 50,040 N (max) | 4250 MPa * 7.85e-7 m² = 3,336 N/strand | 2.0 (30 strands) |
| Rope attachment to spear | 450360 N total | ZrO2 joint: 1300 MPa | >100 |

---

## 8. Practical Build Notes

Institutional; sub-orbital science; significant SRM needed

**Materials sourcing:**
- ZrB2-SiC spear: Treibacher Industrie AG (Austria), $280-320/kg powder; flash-sinter in-house
- UHMWPE fiber: DSM Dyneema SK99, $35-55/kg; available in 100-500m spools
- KNbO3-BaTiO3: TDK 2025 lead-free catalog, $180/kg in actuator form
- Vessels: charter or own BFRP-hull vessels (available for offshore research)

---

## Citations (Vol-13)

- CSMFAB000000000022 V2.0, Smart Rope specs, CSM 2026
- CSMFAB000000000109 V2.0, Archimedes screw exit velocity data, CSM 2026
- Vol 02 (this series), Smart Rope energy analysis
- Vol 05 (this series), Multi-vessel geometry
- Vol 06 (this series), Depth optimization data
- Bate, R.R., Mueller, D.D., White, J.E., Fundamentals of Astrodynamics, Dover 2020
- Anderson, J.D., Introduction to Flight, McGraw-Hill 2017
- SpinLaunch technical publications, 2024-2025

*End Vol-13 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
