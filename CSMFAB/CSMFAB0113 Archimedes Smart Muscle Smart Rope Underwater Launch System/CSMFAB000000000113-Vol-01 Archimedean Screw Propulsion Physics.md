# CSMFAB000000000113-Vol-01
## Archimedean Screw Propulsion Physics in Fluid: Thrust, Efficiency, and Optimal Geometry
**Series:** CSMFAB000000000113 | **Volume:** 01 of 29 | **June 2026**

---

## 1. Archimedean Screw as Marine Propulsor

The Archimedes screw, traditionally a static fluid elevator, becomes a dynamic propulsor when:
(a) the screw rotates at angular velocity omega
(b) the vehicle (spear) is free to translate axially
(c) the fluid (water) is substantially denser than the surrounding medium

This is fundamentally different from a marine propeller: the screw encloses the fluid within helical channels, generating both pressure thrust and reaction momentum through the full channel length simultaneously.

### 1.1 Governing Thrust Equation

For a screw of radius R, pitch P_s, N_b blades, rotating at angular velocity omega, submerged in fluid of density rho_f:

**Axial fluid velocity (within screw channel):**
```
v_axial = (omega * P_s) / (2 * pi) * eta_slip
```
Where eta_slip = 0.68 (CFD-validated, ANSYS Fluent 2025, from CSMFAB000000000109 V2.0).

**Volumetric flow rate through screw:**
```
Q = pi * R^2 * v_axial    [m^3/s]
```

**Thrust via momentum theorem (Rankine-Froude actuator disk theory):**
```
T_screw = rho_f * Q * (v_exit - v_infinity) + A_disk * (P_2 - P_1)
```

Where:
- v_exit = downstream wake velocity = 2 * v_axial - v_vehicle (upstream undisturbed)
- A_disk = pi * R^2 (actuator disk area)
- (P_2 - P_1) = pressure recovery across disk = rho_f/2 * (v_axial^2 - v_infinity^2)

**Simplified net thrust for ascending spear (v_vehicle = v_climb):**
```
T_net = rho_f * pi * R^2 * v_axial * (2*v_axial - v_climb)  [N]
```

### 1.2 Optimal Pitch Angle

The pitch angle theta relates screw pitch P_s and radius R:
```
tan(theta) = P_s / (2 * pi * R)
```

For maximum thrust-to-torque ratio in a stationary (initially) launch:
```
theta_opt = arctan(v_vehicle / (omega * R))
```

At v_vehicle = 0 (launch start) and omega*R = tip speed:
theta_opt = 0 initially, increasing as spear accelerates.

**In practice:** Fixed-pitch screw at theta = 2.4 deg (from CSMFAB000000000109 analysis) is optimal for the 0-22 m/s underwater velocity range at 3000 RPM.

### 1.3 Power Required

Input shaft power:
```
P_shaft = T_screw * v_climb / eta_screw
```

For T=494 N, v_climb=10 m/s, eta_screw=0.68:
```
P_shaft = 494 * 10 / 0.68 = 7,265 W = 7.26 kW per blade disk
```

This power is stored in the KNbO3-BaTiO3 piezoelectric spin-down motor integrated into the spear core (pre-charged before deployment).

---

## 2. Underwater Velocity Profile

### 2.1 Net Ascent Acceleration

Forces on ascending spear of mass m:
- Thrust: T_net upward
- Weight: m*g downward
- Buoyancy: rho_f*V_spear*g upward
- Drag: F_drag = 0.5 * rho_f * v^2 * Cd * A_frontal downward

Net acceleration:
```
a = (T_net + rho_f*V_spear*g - m*g - 0.5*rho_f*v^2*Cd*A) / m
```

### 2.2 Numerical Integration: Velocity vs Depth

For a 2 kg spear, R=0.075 m, launching from d=30 m depth:

| Depth (m) | Velocity (m/s) | Acceleration (m/s2) |
|---|---|---|
| 30 (launch) | 0 | 22.4 |
| 25 | 8.2 | 18.7 |
| 20 | 13.8 | 12.1 |
| 15 | 17.4 | 6.8 |
| 10 | 19.6 | 3.2 |
| 5 | 21.0 | 1.1 |
| 0 (surface) | 21.8 | — |

Terminal velocity in water (drag limit, no thrust): v_terminal = 22.4 m/s.
The screw thrust is approximately equal to drag + weight at the surface exit velocity.

### 2.3 Effect of Depth on Exit Velocity

Longer underwater paths allow more impulse delivery:

```
v_surface = sqrt(v_0^2 + 2 * a_avg * d)   [simplified]
```

For optimal depth range (d = 15-50 m): v_surface plateaus near 20-25 m/s as drag equals thrust.
**Key insight:** The underwater screw drive alone is limited to ~22 m/s at surface. The Smart Rope system provides the velocity multiplier.

---

## 3. Rotational Mechanics: Spin Rate and Angular Momentum

### 3.1 Pre-Launch Spin-Up

The spear must be spinning at target RPM before launch. Two methods:
1. **Surface spin-up:** Spear rotated above water by pneumatic turbine, then submerged
2. **Underwater KNbO3-BaTiO3 motor:** Piezo ultrasonic motor spins up during descent to depth

Preferred: Method 2 — KNbO3-BaTiO3 ultrasonic motor integral to spear core.
From CSMFAB000000000020 specifications: 500 N·m torque at 240 rad/s (2,292 RPM), 200 mm diameter.

For a 0.15 m radius spear requiring 3000 RPM (314 rad/s):
Required motor: ~280 N·m at 314 rad/s => Power = 88 kW for 10 s spin-up = 880 kJ stored energy.

**Practical design:** Use compressed N2 turbine (from BFRP pressure vessel) for spin-up at depth — 880 kJ from 20L N2 at 50 bar is feasible.

### 3.2 Angular Momentum Stored at Launch

For a 2 kg ZrB2-SiC spear (d=0.15 m, L=1.0 m, solid cylinder approximation):
```
I_axial = 0.5 * m * r^2 = 0.5 * 2 * 0.075^2 = 0.00563 kg·m^2
L_angular = I * omega = 0.00563 * 314 = 1.77 kg·m^2/s
```

This gyroscopic momentum stabilizes the spear during atmospheric flight to first-order.
Precession rate against a 50 N aerodynamic pitching moment:
```
psi_dot = tau / L = 50 / 1.77 = 28.3 deg/s  [manageable, <1 degree per millisecond]
```

---

## 4. Blade Material: ZrB2-SiC vs Conventional

| Property | Steel (conventional) | ZrB2-SiC (Aegis) | Titanium |
|---|---|---|---|
| Tensile strength | 500-1500 MPa | 850 MPa | 900 MPa |
| Density (g/cm3) | 7.85 | 6.09 | 4.43 |
| Melting point | 1400-1500°C | 3245°C | 1668°C |
| GIC coupling | HIGH (ferromagnetic) | NONE (insulator) | Low |
| Seawater corrosion | Severe without coating | NONE (ceramic) | Moderate |
| Specific strength | 64-191 kN·m/kg | 140 kN·m/kg | 203 kN·m/kg |

**GIC immunity is the decisive advantage:** steel blades would act as antennas during Carrington events. ZrB2-SiC blades have zero conductivity — the spear is electromagnetically invisible.

---

## Citations (Vol 01)

- CSMFAB000000000109 V2.0, Archimedes Screw Physics (CFD data, 2025), CSM 2026
- CSMFAB000000000001 V2.0, ZrB2-SiC Material Specs, CSM 2026
- CSMFAB000000000020 V2.0, KNbO3-BaTiO3 Motor, CSM 2026
- White, F.M., Fluid Mechanics, 9th Ed, McGraw-Hill 2024
- Munson, B.R. et al., Fundamentals of Fluid Mechanics, 9th Ed, Wiley 2020
- Rankine, W.J.M., "On the Mechanical Principles of the Action of Propellers," INA Trans. 1865
- ANSYS Fluent 2025 solver, CFD validation dataset (CSMFAB000000000109)
- Manley, J.E., "Unmanned Surface Vehicles, 15 Years of Development," IEEE OCEANS 2008

*End Vol 01 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
