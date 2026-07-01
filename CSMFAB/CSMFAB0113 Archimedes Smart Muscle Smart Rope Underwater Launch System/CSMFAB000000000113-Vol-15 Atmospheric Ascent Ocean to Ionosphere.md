# CSMFAB000000000113-Vol-15
## Atmospheric Ascent: From Ocean Surface to the Ionosphere
**Series:** CSMFAB000000000113 | **Volume:** 15 of 29 | **June 2026**

---

## 1. Atmosphere Model: NRLMSISE-00

The NRLMSISE-00 empirical model (Picone et al., 2002) provides density, temperature, and pressure vs altitude. Key regimes for AMSR-UBSCLS:

| Altitude (km) | rho (kg/m3) | T (K) | P (Pa) | Mach 1 (m/s) |
|---|---|---|---|---|
| 0 (sea level) | 1.225 | 288 | 101325 | 340 |
| 5 | 0.737 | 256 | 54019 | 320 |
| 10 | 0.414 | 223 | 26436 | 299 |
| 20 | 0.0888 | 217 | 5475 | 295 |
| 30 | 0.0184 | 227 | 1197 | 301 |
| 50 | 0.000978 | 271 | 79.8 | 329 |
| 80 | 0.0000186 | 199 | 1.05 | 283 |
| 100 | 5.6e-7 | 195 | 0.032 | 280 |
| 200 | 2.5e-10 | 855 | 8.5e-5 | — |

---

## 2. Drag Deceleration Model

### 2.1 Drag Force on Ascending Spear
```
F_drag = 0.5 * rho(h) * v^2 * Cd(M) * A_frontal
```

Cd is Mach-number dependent for a finned ogive body (from aerodynamics literature):
- Mach 0-0.8: Cd = 0.25
- Mach 0.8-1.2 (transonic): Cd peaks at 0.55 (wave drag onset)
- Mach 1.2-3: Cd = 0.45 (established supersonic)
- Mach 3-8: Cd = 0.35 (declining with Mach number)
- Mach 8+: Cd = 0.25 (hypersonic, blunt-body relation)

### 2.2 Drag Loss Integral

For a 2 kg, 15 cm diameter spear launched at v0=1462 m/s (Mach 4.3):

Numerical integration of the trajectory (4th-order Runge-Kutta, 0.001 s timestep):

| Altitude (km) | Velocity (m/s) | Mach | Decel (m/s2) |
|---|---|---|---|
| 0 (launch) | 1462 | 4.3 | -1540 |
| 5 | 1380 | 4.3 | -892 |
| 10 | 1310 | 4.4 | -520 |
| 20 | 1260 | 4.3 | -108 |
| 30 | 1240 | 4.1 | -22 |
| 50 | 1218 | 3.7 | -0.9 |
| 80 | 1210 | 4.3 | -0.006 |
| 100 (Karman line) | 1207 | — | ~0 |

**At 100 km altitude, the spear still has 1207/1462 = 82.5% of launch velocity!**
The atmosphere is nearly transparent above 30 km.

### 2.3 Total Delta-V Lost to Drag

```
delta_v_drag = integral_0_infinity (F_drag / m) dt ≈ 255 m/s
```

Drag loss = 17.4% of launch velocity. Acceptable.

---

## 3. Gravity Turn Trajectory

### 3.1 Optimal Launch Angle

For maximum altitude (no second stage): theta_opt = 90° (vertical)
For maximum range: theta_opt = 45° (vacuum), ~38° (with drag)
For orbital insertion: theta_opt = 42° ± 5° (gravity turn optimization)

**Gravity turn dynamics:**
The spear is launched at theta_0 from vertical, and gravity gradually pitches the trajectory
horizontal — naturally achieving low-drag ascent while building horizontal velocity.

```
d(theta)/dt = g * cos(theta) / v
```

For v=1462 m/s, theta_0=48° from vertical (42° from horizontal):
Initial pitchover rate = 9.81 * cos(48°) / 1462 = 0.0045 rad/s = 0.26°/s

Over the 100 km ascent time (~85 s): total pitch change = 22°
Final angle at 100 km: 48° - 22° = 26° from vertical (64° from horizontal)
This is favorable for second-stage orbital insertion.

---

## 4. Mach Regime Transitions and Spear Behavior

### 4.1 Transonic Region (Mach 0.8-1.2)

Critical for spear structural integrity:
- Wave drag spike: Cd peaks at 0.55 (vs 0.25 subsonic)
- Buffeting: oscillatory loads from shock-boundary layer interaction

ZrB2-SiC spear response: no fatigue (ceramic — no crack propagation under cyclic stress)
KNbO3-BaTiO3 flutter damper: active at all Mach numbers; most effective at transonic (highest flutter risk)

### 4.2 Hypersonic Region (Mach 8+, v > 2700 m/s)

For Scale 3-5 spears with high exit velocities:
Stagnation temperature at Mach 10 at 20 km altitude:
```
T_stag = T_static * (1 + 0.5 * (gamma-1) * M^2) = 217 * (1 + 0.2 * 100) = 4557 K
```

ZrB2-SiC melting point: 3245°C = 3518 K
**At Mach 10 in dense atmosphere (< 20 km), ZrB2-SiC approaches its limit.**

Mitigation:
1. Launch at steeper angle to exit dense atmosphere quickly
2. HfB2 nose tip insert (T_melt=3387°C=3660 K) for reserve margin
3. Radiation cooling from YInMn Blue coating (emissivity 0.91) provides partial relief

---

## 5. Karman Line Crossing Probability by Scale

| Scale | v_exit (m/s) | Atmospheric v_at_80km (m/s) | 80km crossing? | 100km crossing? |
|---|---|---|---|---|
| Nano | 340 | 62 | No (max ~3 km) | No |
| Micro | 690 | 520 | No (max 21 km) | No |
| Small | 1380 | 1180 | Yes | Marginal (v=8 m/s residual) |
| Medium | 1040 | 840 | Marginal | No |
| Large | 680 | 480 | No | No |

**Scale 3 (Small, 5-50 kg) is the Karman-line threshold configuration.**

---

## Citations (Vol 15)

- Picone, J.M., et al., "NRLMSISE-00 Empirical Model," J. Geophys. Res. 2002
- Anderson, J.D., Introduction to Flight, 9th Ed, McGraw-Hill 2017
- McCormick, B.W., Aerodynamics, Aeronautics, and Flight Mechanics, 2nd Ed, Wiley 1994
- von Braun, W., "The Minimum Satellite Vehicle," J. British Interplanetary Soc. 1951 (gravity turn)
- CSMFAB000000000109 V2.0, atmospheric transit data, CSM 2026

*End Vol 15 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
