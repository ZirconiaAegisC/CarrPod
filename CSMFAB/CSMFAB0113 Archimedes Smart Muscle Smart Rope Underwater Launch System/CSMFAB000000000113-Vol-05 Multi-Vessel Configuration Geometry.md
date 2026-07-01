# CSMFAB000000000113-Vol-05
## Multi-Vessel Configuration Geometry and Optimization
**Series:** CSMFAB000000000113 | **Volume:** 05 of 29 | **June 2026**

---

## 1. The n-Vessel Circle: Geometric Framework

n vessels are positioned at the vertices of a regular n-gon inscribed in a circle of radius R on the ocean surface. The launch point is at the center of this circle, at depth d below the surface.

Each vessel holds one Smart Rope connected to the base of the spear, creating a symmetric tensor array.

### 1.1 Complete Force Analysis

For n vessels at radius R, depth d:

**Rope length:**
```
L_rope = sqrt(R^2 + d^2)
```

**Rope angle from vertical (alpha):**
```
alpha = arctan(R/d)
```

**Vertical efficiency factor:**
```
eta_v = cos(alpha) = d / sqrt(R^2 + d^2)
```

**Lateral cancellation check:** The horizontal components from n symmetric ropes cancel completely:
```
Sum(F_h) = F_rope * sin(alpha) * Sum(cos(2*pi*k/n)) for k=0..n-1 = 0  [always, for any n>=2]
```

### 1.2 Configuration Table: Practical n Values

| n | Min Vessel Spacing (m) at R=6m | Rope Angle | Vert Efficiency | Notes |
|---|---|---|---|---|
| 2 | 12.0 m | 11.3° | 98.1% | Minimum viable; poor stability |
| 3 | 10.4 m | 11.3° | 98.1% | Triangular — simplest practical |
| 4 | 8.5 m | 11.3° | 98.1% | Square — quadrupled force |
| 6 | 6.0 m | 11.3° | 98.1% | Hexagonal — recommended |
| 8 | 4.6 m | 11.3° | 98.1% | Close packing limit at R=6m |
| 10 | 3.7 m | 11.3° | 98.1% | Requires careful coordination |
| 12 | 3.1 m | 11.3° | 98.1% | High force; tight vessel spacing |

**Recommended starting configuration: n=6 hexagonal** — balance of force multiplication, vessel spacing, coordination complexity, and practical sea state maneuverability.

### 1.3 Force Scaling with n

Total vertical impulse (from Vol 02):
```
J_total = n * J_rope * eta_v
```

For J_rope=1001 N·s, eta_v=0.981:
- n=3: J_total = 2,944 N·s → delta_v = 1,472 m/s for 2 kg spear
- n=6: J_total = 5,888 N·s → delta_v = 2,944 m/s
- n=9: J_total = 8,832 N·s → delta_v = 4,416 m/s
- n=12: J_total = 11,776 N·s → delta_v = 5,888 m/s

Note: These are theoretical maxima. Rope contraction speed limits effective impulse (see Vol 02 correction).

---

## 2. Optimal R/d Ratio Study

Varying R while keeping n=6 and d=30m:

| R (m) | L_rope (m) | alpha | eta_v | Notes |
|---|---|---|---|---|
| 1 | 30.02 | 1.9° | 99.9% | Vessels nearly over launch point |
| 3 | 30.15 | 5.7° | 99.5% | Tight but achievable |
| 6 | 30.60 | 11.3° | 98.1% | **Recommended** |
| 10 | 31.62 | 18.4° | 94.9% | Acceptable |
| 20 | 36.06 | 33.7° | 83.2% | Significant loss |
| 30 | 42.43 | 45.0° | 70.7% | Poor efficiency |
| 50 | 58.31 | 59.0° | 51.5% | Not viable |

**Optimal R = 0.1 to 0.2 * d** (99.5% to 98.1% efficiency)

For d=30 m: **R = 3 to 6 m** is optimal.
Practical constraint: vessel length ~10-15 m → vessels cannot be closer than ~5 m edge-to-edge
At n=6, R=6 m: inter-vessel arc spacing = 2*R*sin(pi/n) = 6 m — just sufficient for small vessels.

---

## 3. Three-Dimensional Vector Analysis

When sea state causes vessel displacement from ideal position:

If vessel k is displaced by error vector (dx_k, dy_k):
```
dF_vertical_k = -F_rope * (dx_k * R_x + dy_k * R_y) / (L_rope^2)
```

**Acceptable position error for < 5% force deviation:**
```
delta_r_max = 0.05 * L_rope^2 / (F_rope * R) = 0.05 * 936 / (50000 * 6) = 0.00016 m
```

This is extremely tight (0.16 mm)! In practice, position errors are 1-5 m at sea.

**Mitigation:** The Smart Rope has elastic compliance that compensates for position errors.
The rope acts as a spring-damper — at 10% strain, a 1 m position error in 30 m rope = 3.3% strain variation = 3.3% force variation. **Acceptable.**

---

## 4. Sea Anchor Configuration for Vessel Stability

Each vessel must be anchored to maintain position during the brief (0.04 s) maximum-tension event.

**Impulse force on each vessel (n=6):**
```
F_vessel_peak = F_rope_peak = 50,000 N (toward center, downward component)
```

For a 5-tonne vessel: acceleration = F/m = 50000/5000 = 10 m/s2 = 1g
Over t=0.04 s: displacement = 0.5 * 10 * 0.04^2 = 0.008 m = 8 mm

**8 mm vessel displacement during launch is acceptable** — no anchoring required for short launches.
For repeated launches, a BFRP anchor chain (non-conductive) is recommended.

---

## Citations (Vol 05)

- Niedzwecki, J.M., Huston, J.R., "Wave Interaction with Tension Leg Platforms," Ocean Eng. 1992
- Faltinsen, O.M., Sea Loads on Ships and Offshore Structures, Cambridge UP 1990
- CSMFAB000000000022 V2.0, rope geometry from Vol 02 above
- Tahar, A., Hann, D.B., "Multi-Point Mooring Systems in Current," JOM 2016
- DNV-OS-E301, "Position Mooring," Det Norske Veritas, 2021

*End Vol 05 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
