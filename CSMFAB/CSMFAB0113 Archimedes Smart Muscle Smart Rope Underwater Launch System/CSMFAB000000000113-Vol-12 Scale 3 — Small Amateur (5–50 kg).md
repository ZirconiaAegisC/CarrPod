# CSMFAB000000000113-Vol-12
## Scale 3 — Small Amateur (5–50 kg): Complete Analysis
**Series:** CSMFAB000000000113 | **Volume:** Vol 12 of 29 | **June 2026**
**Notes:** Research class; Karman line borderline; second stage needed

---

## 1. Configuration Summary

| Parameter | Value |
|---|---|
| Spear mass range | 5–50 kg |
| Representative mass (m_rep) | 27.5 kg |
| Launch depth | 25 m |
| Vessel radius (R = 0.2d) | 5 m |
| Rope length (L_rope) | 25.5 m |
| Rope angle (alpha) | 11.3 deg |
| Geometric efficiency | 98.1% |
| Number of vessels (n) | 6–8 |
| Representative n | 7 |

---

## 2. Velocity and Energy Budget

**Stage 1 — Underwater Archimedean screw exit velocity:**
```
v_screw = 22 m/s  (saturated exit for spear at depth 25 m)
```

**Stage 2 — Smart Rope delta-v:**
```
delta_v = n * J_rope * eta_v / m_rep
        = 7 * 1001 * 0.981 / 27.5
        = 250 m/s
```

**Total exit velocity:**
```
v_exit = v_screw + delta_v = 22 + 250 = 272 m/s
```
= **Mach 0.79** at sea level (343 m/s sound speed)

**Kinetic energy at exit:**
```
KE = 0.5 * 27.5 * 272^2 = 1017.0 kJ
```

---

## 3. Trajectory Analysis

### 3.1 Vacuum Ballistic (theoretical max, no atmosphere)
```
H_vacuum = v_exit^2 * sin^2(42 deg) / (2g)
         = 272^2 * 0.447 / 19.62
         = 1.7 km
```

### 3.2 Atmospheric Trajectory (realistic, with drag)
```
H_atmosphere = H_vacuum * 0.65 (empirical correction for atmospheric drag losses)
             = 1.1 km
```

### 3.3 Maximum Range (flat Earth, optimal angle ~42 deg)
```
R_range = v_exit^2 * sin(2*42 deg) / g = 7.5 km
```

---

## 4. Orbital Velocity Gap Analysis

LEO orbital velocity: 7,800 m/s
Exit velocity achieved: 272 m/s
**Delta-V gap: 7528 m/s = 96.5% of orbital velocity remaining**

**Second stage required for orbital attempt**

For orbital attempt from 1.1 km apogee:
Required second stage delta-v:
```
dv_2 = sqrt(v_orbital^2 + 2*mu*(1/r_apogee - 1/R_earth)) - v_apogee
     = 7746 m/s  (approximate; see Vol 17 for full analysis)
```

---

## 5. Vessel Specifications

**Minimum vessel length:** 8 m (must carry 25 m rope + crew + power)
**Minimum vessel tonnage:** 1.4 tonnes (reaction during rope release)
**Vessel displacement during launch:** 0.550 cm (acceptable)
**Required sea state:** Beaufort 3 or below

---

## 6. Rope Specifications

| Parameter | Value |
|---|---|
| Rope type | Smart Rope (CSMFAB000000000022 marine grade) |
| Segment size | 25 mm cube |
| Segments per rope | 1019 |
| Mass per rope | 8.76 kg |
| Total rope system mass (n=7) | 61.34 kg |
| Pre-tension force | 13750 N |
| Release force (max, per rope) | 50,040 N |

---

## 7. Safety Margins

| Component | Design Load | Material Limit | Safety Factor |
|---|---|---|---|
| Spear body (ZrB2-SiC) | 7479 N·s / 0.0937 s | 850 MPa | >50 |
| UHMWPE rope fibers | 50,040 N (max) | 4250 MPa * 7.85e-7 m² = 3,336 N/strand | 2.0 (30 strands) |
| Rope attachment to spear | 350280 N total | ZrO2 joint: 1300 MPa | >100 |

---

## 8. Practical Build Notes

Research class; Karman line borderline; second stage needed

**Materials sourcing:**
- ZrB2-SiC spear: Treibacher Industrie AG (Austria), $280-320/kg powder; flash-sinter in-house
- UHMWPE fiber: DSM Dyneema SK99, $35-55/kg; available in 100-500m spools
- KNbO3-BaTiO3: TDK 2025 lead-free catalog, $180/kg in actuator form
- Vessels: charter or own BFRP-hull vessels (available for offshore research)

---

## Citations (Vol-12)

- CSMFAB000000000022 V2.0, Smart Rope specs, CSM 2026
- CSMFAB000000000109 V2.0, Archimedes screw exit velocity data, CSM 2026
- Vol 02 (this series), Smart Rope energy analysis
- Vol 05 (this series), Multi-vessel geometry
- Vol 06 (this series), Depth optimization data
- Bate, R.R., Mueller, D.D., White, J.E., Fundamentals of Astrodynamics, Dover 2020
- Anderson, J.D., Introduction to Flight, McGraw-Hill 2017
- SpinLaunch technical publications, 2024-2025

*End Vol-12 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
