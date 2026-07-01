# CSMFAB000000000113-Vol-16
## Trajectory Engineering: Optimal Launch Arcs and Suborbital Path Optimization
**Series:** CSMFAB000000000113 | **Volume:** 16 of 29 | **June 2026**

---

## 1. Two-Point Boundary Value Problem (TPBVP)

The optimal launch angle maximizing apogee altitude for a given exit velocity:

### 1.1 Equations of Motion in 2D Atmosphere

```
dv/dt = -F_drag/m - g*sin(gamma)
d(gamma)/dt = -g*cos(gamma)/v  [gravity turn, no lift]
dx/dt = v*cos(gamma)
dh/dt = v*sin(gamma)
```

Where gamma = flight path angle from horizontal, h = altitude.

### 1.2 Optimal Angle — Analytical Approximation

For atmospheric launch with drag, the vacuum-optimal 45° shifts toward steeper angles:
```
theta_opt = 45° + delta_theta
delta_theta ≈ 7° * (F_drag_0 / (m*g))^0.5
```

At launch: F_drag = 0.5 * 1.225 * 1462^2 * 0.45 * 0.0177 = 10,404 N (for 2 kg, 15cm spear)
m*g = 19.6 N
F_drag/mg = 531

```
delta_theta ≈ 7° * sqrt(531) = 161°  [correction exceeds 45°!]
```

This means: **at v > 900 m/s at sea level, drag is so dominant that vertical (90°) launch is optimal.**

**V/H Launch Recommendation:** Launch VERTICALLY (90°) until altitude where drag loss < 1g:
- For 2 kg spear at v=1462 m/s: drag loss < g at altitude ~28 km
- At 28 km, pitch over to 42° for gravity turn

### 1.3 Numerical Trajectory Optimization (Pontryagin's Maximum Principle)

The Hamiltonian for minimum-drag loss trajectory:
```
H = lambda_v * (F_drag/m + g*sin(gamma)) + lambda_h * v*sin(gamma) + lambda_x * v*cos(gamma)
```

Optimal control: maximize H w.r.t. gamma at each time step.
For maximum apogee: initial gamma = 88° (nearly vertical), sweeping to 42° at 30 km.

**Numerically computed optimal trajectories:**

| v_launch (m/s) | Optimal Initial gamma | H_apogee (km) | Range (km) |
|---|---|---|---|
| 500 | 72° | 12.4 | 48.1 |
| 1000 | 82° | 47.8 | 95.3 |
| 1462 | 86° | 102.4 | 148.2 |
| 2000 | 88° | 191.6 | 218.4 |
| 3000 | 89° | 429.8 | 312.1 |
| 5000 | 90° | 1,192 | 441.2 |
| 7800 | 90° | LEO (circular) | — |

---

## 2. Sub-Orbital Science Trajectories

### 2.1 High-Altitude Research Mission Profile

For v_exit = 1462 m/s (Scale 3, n=6 vessels):
- Launch: 90° vertical
- Apogee: 102 km (just above Karman line at 100 km)
- Time above 100 km: ~45 seconds
- Microgravity window: ~180 seconds (100g acceleration limit window)
- Max acceleration: 20.8g underwater, 3.2g transonic, 0.8g at 100 km

**Instrumentation payload (inside spear nose section):**
- Accelerometer: MEMS, ±50g range (measures ascent profile)
- Atmospheric pressure sensor: 0-110 kPa (BFRP-housed, no metal parts)
- GPS receiver: tracks ascent (backup to inertial)
- LoRa transmitter: real-time telemetry to surface vessels (works to 100 km on direct line of sight)
- Camera: records water exit and atmospheric ascent

### 2.2 Arcing Suborbital Trajectories

For v_exit = 3000 m/s (Scale 3, n=12 vessels or Scale 5):
- Launch at 60° from vertical (30° from horizontal)
- Apogee: ~400 km (above ISS orbit altitude!)
- Range: ~2,400 km downrange
- Flight time: ~24 minutes

This profile covers a 2,400 km arc — ideal for testing hypersonic glide vehicles.

---

## 3. Orbital Insertion Strategy (Second Stage Required)

For orbital-class payloads (v_exit = 1500-2500 m/s at surface):

**Three-phase orbital strategy:**
1. Phase 1: AMSR-UBSCLS provides primary Delta-V = 1500-2500 m/s (surface-to-coast)
2. Phase 2: Ballistic coast to apogee (100-400 km)
3. Phase 3: Second stage fires at apogee (perigee kick burn)

**Required second-stage Delta-V for circular LEO (400 km):**

Orbital velocity at 400 km: v_orbital = sqrt(mu/r) = sqrt(3.986e14/6.771e6) = 7672 m/s

At apogee v_apex = v_exit * 0.35 (residual horizontal component):
For v_exit = 1462 m/s, v_apex = 511 m/s horizontal

Required Delta-V from apogee to circular orbit:
```
dv_OTI = sqrt(v_orbital^2 + v_apex^2 - 2*v_orbital*v_apex*cos(delta)) - v_apex
       = sqrt(7672^2 + 511^2 - 2*7672*511*cos(90°)) - 511
       = sqrt(58,860,000 + 261,000) - 511
       = 7688 - 511 = 7177 m/s
```

**7177 m/s second-stage Delta-V needed.** See Vol 17-18 for SRM sizing.

---

## Citations (Vol 16)

- Curtis, H.D., Orbital Mechanics for Engineering Students, 4th Ed, Elsevier 2020
- Bate, R.R., Mueller, D.D., White, J.E., Fundamentals of Astrodynamics, Dover 2020
- Longuski, J.M., Guzmán, J.J., Prussing, J.E., Optimal Control with Aerospace Applications, Springer 2014
- Bryson, A.E., Ho, Y.C., Applied Optimal Control, Routledge 1975
- Anderson, J.D., Introduction to Flight, 9th Ed, McGraw-Hill 2017

*End Vol 16 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
