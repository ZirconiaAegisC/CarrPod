# CSMFAB000000000113-Vol-19
## Gyroscopic Stability and Attitude Control During Atmospheric Ascent
**Series:** CSMFAB000000000113 | **Volume:** 19 of 29 | **June 2026**

---

## 1. Gyroscopic Stability Fundamentals

A spinning body resists angular perturbation via gyroscopic stiffness. The precession equation:
```
Omega_precession = tau / L_gyro
```
Where tau = applied torque, L_gyro = I_axial * omega_spin (angular momentum).

### 1.1 Required Spin Rate for Stability

Condition for gyroscopic stability: precession rate << angular velocity of trajectory change

For the AMSR-UBSCLS spear, the dominant perturbing torque is aerodynamic:
```
tau_aero = 0.5 * rho * v^2 * A * D * Cm_alpha * alpha
```

Where Cm_alpha = 0.2/rad (aerodynamic pitching moment coefficient for finned cylinder, empirical),
and alpha = angle of attack (max 2° in turbulent launch environment).

At worst case (Mach 3, h=15 km): rho=0.195 kg/m3, v=900 m/s, A=0.00503 m2, D=0.08m, alpha=0.035 rad:
```
tau_aero = 0.5 * 0.195 * 810000 * 0.00503 * 0.08 * 0.2 * 0.035 = 1.11 N·m
```

Required omega_spin for precession rate < 1 deg/s:
```
omega_min = tau / (I_axial * 0.0175) = 1.11 / (3.8e-4 * 0.0175) = 167 rad/s = 1596 RPM
```

**Required spin rate: > 1600 RPM.** Our 2000 RPM exit spin (from Vol 01) provides adequate margin.

### 1.2 Spin Decay During Atmospheric Ascent

Air friction decays spin rate. From aerodynamic torque on spinning body:
```
tau_spin_decay = 0.5 * rho * omega * v * R^3 * Cm_q * pi
```

Numerically integrating from surface to 100 km:
- Surface (dense air, high drag): omega decreases from 2000 RPM to ~1600 RPM in first 5 km
- Above 15 km: negligible spin decay (air density too low)
- At 100 km: omega still ~1580 RPM — **adequate throughout trajectory**

---

## 2. Fin Stabilization — Passive Backup

Even with gyroscopic stabilization, passive aerodynamic stability is beneficial.

### 2.1 Fin Design

Four cruciform fins at spear base, from same ZrB2-SiC as body:
- Fin span: s = 0.5 * D = 0.04 m
- Fin chord: c = 0.3 * L = 0.192 m
- Fin planform area per fin: S_fin = 0.04 * 0.192 = 0.00768 m2
- Fin material: ZrB2-SiC thin sheet, 2mm thick

**Static margin analysis:**
Center of pressure (Cp) location (finned rocket formula, Barrowman method):
```
X_cp = X_body_cp + 4*N_fin*S_fin*(X_fin_mid - X_cp_body) / (A_body * Cn_alpha_body)
```

Simplified: X_cp ≈ 0.65 * L from nose (finned configuration)
Center of gravity: X_cg ≈ 0.45 * L from nose (front-heavy: screw + SRM forward)

Static margin = (X_cp - X_cg) / D = (0.65 - 0.45) * L / D = 0.20 * 0.64 / 0.08 = **1.6 calibers**

**Static margin 1.6 cal > 1.0 cal minimum: STABLE.**

### 2.2 Fin Thermal Analysis

At Mach 8+ (Scale 4-5), fin leading edges experience severe heating:
```
T_leading_edge = T_stag * (1 - 0.05 * M^2)^-1 ≈ T_stag * 1.4  [at M=8]
```

At Mach 8, h=20 km: T_stag = 4557 K → T_leading_edge ≈ 6380 K

ZrB2-SiC melting: 3245°C = 3518 K — insufficient!

**Solution for Scale 4-5:** Replace fin leading edges with HfB2 tiles (T_melt=3660 K):
Still marginal at M=8. Use thermal ablation as protective mechanism:
- HfB2 ablation rate: 0.1 mm/s at 3600 K (1 mm ablated per 10 seconds at max heating)
- For 5-second maximum high-speed phase: 0.5 mm ablated — acceptable single-use design

---

## 3. Attitude Control Active System (Scale 4-5 Only)

For orbital-class payloads, passive fins may not provide sufficient control.
Active attitude control using KNbO3-BaTiO3 piezo-driven control vanes:

Vane deflection: ±5° provides ~120 N sideforce at Mach 4
Required torque for 1°/s pitch rate on 100 kg spear:
tau = I_transverse * alpha_dot = 0.8 * 0.017 = 0.014 N·m (tiny)

**Conclusion: KNbO3-BaTiO3 vane actuation is more than adequate for attitude control.**

---

## Citations (Vol 19)

- Etkin, B., Reid, L.D., Dynamics of Flight: Stability and Control, 3rd Ed, Wiley 1996
- Barrowman, J.S., "The Practical Calculation of the Aerodynamic Characteristics of Slender Finned Vehicles," NASA TMX-68199, 1966
- Murphy, C.H., "Free Flight Motion of Symmetric Missiles," BRL Rept 1216, 1963
- CSMFAB000000000109 V2.0, gyroscopic analysis, CSM 2026

*End Vol 19 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
