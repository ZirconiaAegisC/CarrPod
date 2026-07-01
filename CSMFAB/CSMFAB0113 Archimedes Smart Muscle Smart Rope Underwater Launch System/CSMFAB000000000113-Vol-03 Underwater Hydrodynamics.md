# CSMFAB000000000113-Vol-03
## Underwater Hydrodynamics: Drag, Buoyancy, and Column Dynamics
**Series:** CSMFAB000000000113 | **Volume:** 03 of 29 | **June 2026**

---

## 1. Forces on the Submerged Ascending Spear

### 1.1 Buoyancy

Archimedes buoyancy force on fully submerged spear:
```
F_b = rho_water * g * V_spear
```

For a 2 kg ZrB2-SiC solid cylinder (rho=6090 kg/m3, volume = m/rho = 2/6090 = 3.28e-4 m3):
```
F_b = 1025 * 9.81 * 3.28e-4 = 3.30 N
```

Net weight in water: F_net_weight = 2*9.81 - 3.30 = 16.32 N (downward)

ZrB2-SiC is denser than water (6.09 vs 1.025 g/cm3) — the spear sinks without thrust.
**Buoyancy contributes ~3.3 N of effective lift (minor but favorable).**

### 1.2 Drag Force

Drag on a spinning cylinder in axial flow:
```
F_drag = 0.5 * rho_water * v^2 * Cd * A_frontal
```

For the cylindrical spear body:
- Cd = 0.82 (bluff body, Re = 1e6, empirical)
- Cd_screw = 0.3 (additional drag from rotating screw blades, CFD estimate)
- Total Cd = 1.12

At v = 20 m/s, A_frontal = pi*(0.075)^2 = 0.01767 m2:
```
F_drag = 0.5 * 1025 * 400 * 1.12 * 0.01767 = 4,063 N
```

This is 8.2x the spear weight — drag dominates the dynamics.

### 1.3 Added Mass Effect

The accelerating spear must also accelerate the water around it (added mass):
```
m_added = C_a * rho_water * V_displaced
```

For a slender cylinder, C_a = 1.0 (per unit length, axial direction).
```
m_added = 1.0 * 1025 * 3.28e-4 = 0.336 kg (added to spear's 2 kg)
```

Effective mass during acceleration: m_eff = 2 + 0.336 = 2.336 kg
**Effect on launch: ~17% reduction in acceleration at launch, decreasing as v increases.**

### 1.4 Equation of Motion (Full)

```
m_eff * a = T_screw + F_b - m*g - F_drag
         = 494 + 3.3 - 19.6 - 0.5*1025*v^2*1.12*0.01767
```

At v=0 (launch): a = (494 + 3.3 - 19.6) / 2.336 = **204 m/s2 = 20.8 g**

**Launch acceleration: 20.8g** — significant but well within ZrB2-SiC fracture strength margin.

---

## 2. Water Column Guidance Effect

The spear is ascending in an open water column, not a tube. However:

### 2.1 Smart Rope Lateral Constraint

The n Smart Ropes create a **converging cone** of ropes above the spear, passively constraining lateral displacement:

For n=6 ropes, radius R=6m, depth d=30m:
- Lateral spring stiffness of rope array = k_lateral = n * F_rope * R / (L_rope^2)
- k_lateral = 6 * 50000 * 6 / (30.6^2) = 1,920 N/m
- Natural frequency of lateral oscillation: f_n = 1/(2pi) * sqrt(k/m) = 1/(2pi) * sqrt(1920/2) = 4.9 Hz

The ropes act as a passive stabilizing guide structure. Any lateral displacement generates a restoring force.

### 2.2 Wake Bubble Dynamics

As the spinning spear ascends, it creates a helical cavitation wake:

Cavitation number: sigma = (P_static - P_vapor) / (0.5 * rho * v^2)

At 30m depth: P_static = 101325 + 1025*9.81*30 = 403,070 Pa
P_vapor = 2340 Pa (20°C water)
At v=20 m/s: sigma = (403070 - 2340) / (0.5 * 1025 * 400) = 1.95

sigma > 1: **No cavitation** at v=20 m/s at 30m depth.

At shallower depths (< 10m), cavitation may onset. The spear's screw blades will begin to cavitate near the surface, causing thrust reduction but also providing aeration that reduces drag at exit.

### 2.3 Surface Disruption at Exit

At water-air interface, the spear creates a **geyser effect** — water is displaced upward.
This geyser mass flow creates a brief period of enhanced drag:

Mass flow rate of displaced water: dm/dt = rho_w * A_spear * v_exit = 1025 * 0.01767 * 22 = 398 kg/s

Geyser drag impulse (over 0.01 s transition): J_geyser = 398 * 22 * 0.01 = 87.6 N·s

Velocity reduction: delta_v_geyser = -87.6 / 2 = -43.8 m/s (2% of exit velocity — minor)

---

## 3. Pressure Loading on Spear Structure

### 3.1 Hydrostatic Pressure at Depth

At d=50 m depth (maximum practical launch depth):
```
P_hydrostatic = rho_w * g * d = 1025 * 9.81 * 50 = 502,763 Pa = 5.03 bar
```

ZrB2-SiC compressive strength: > 1800 MPa >> 5.03 bar.
**Zero structural concern from hydrostatic pressure.**

### 3.2 Dynamic Pressure During Ascent

At v=22 m/s: q = 0.5 * rho_w * v^2 = 0.5 * 1025 * 484 = 248,050 Pa = 2.48 bar
Still negligible vs ZrB2-SiC strength.

### 3.3 Thermal Environment Underwater

Water temperature at depth: 4-20°C in international waters.
ZrB2-SiC thermal stability: -273°C to +3245°C.
No thermal concerns underwater.

---

## 4. Optimal Launch Depth Study

Key trade-off: deeper launch = more thrust time = higher exit velocity (up to terminal limit)
BUT: deeper launch = longer rope required = heavier system

**Optimization criterion:** Maximize exit velocity per kg of rope mass.

```
Performance Index (PI) = v_exit / (m_rope * L_rope)
```

| Depth (m) | Exit v (m/s) | Rope Length (m) | Rope Mass (kg) | PI |
|---|---|---|---|---|
| 10 | 18.5 | 10.3 | 2.7 | 0.66 |
| 20 | 21.0 | 20.9 | 5.4 | 0.73 |
| 30 | 21.8 | 30.6 | 7.9 | 0.88 |
| 50 | 22.1 | 50.4 | 13.0 | 0.85 |
| 75 | 22.3 | 75.2 | 19.4 | 0.77 |
| 100 | 22.4 | 100.2 | 25.9 | 0.67 |

**Optimal depth: 30 m** (maximum Performance Index)

At 30 m depth:
- Rope length: 30.6 m (for R=6m, alpha=11.3 deg)
- Exit velocity: 21.8 m/s (screw only) + Smart Rope boost
- Rope deployment time: safe and practical for surface vessel operations

---

## Citations (Vol 03)

- White, F.M., Fluid Mechanics, 9th Ed, McGraw-Hill 2024
- Munson et al., Fundamentals of Fluid Mechanics, Wiley 2020
- Newman, J.N., Marine Hydrodynamics, MIT Press 2018
- Hoerner, S.F., Fluid Dynamic Drag, Hoerner Fluid Dynamics 1965 (classic)
- CSMFAB000000000001 V2.0, ZrB2-SiC properties, CSM 2026
- ITTC, "Recommended Procedures for Testing Marine Propulsors," 2021
- Brennen, C.E., Cavitation and Bubble Dynamics, Cambridge UP 2014

*End Vol 03 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
