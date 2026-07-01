# CSMFAB000000000113-Vol-04
## Water-Surface Exit Transition Mechanics
**Series:** CSMFAB000000000113 | **Volume:** 04 of 29 | **June 2026**

---

## 1. The Phase Transition Problem

The water-air interface is the most physically demanding moment in the AMSR-UBSCLS launch sequence. The spear transitions from a medium with density rho_water=1025 kg/m3 into air at rho_air=1.225 kg/m3 — a **836:1 density ratio** — in approximately 0.01 seconds (at v=22 m/s for a 1 m spear).

### 1.1 Momentum Exchange at the Interface

Momentum conservation for the spear + entrained water mass:
```
(m_spear + m_water_entrained) * v_water = m_spear * v_air + m_water_entrained * v_water_residual
```

Entrained water mass (thin film on spear surface, radius 5mm):
```
m_water_film = pi * R_film * L_spear * delta * rho_w = pi * 0.08 * 1.0 * 0.005 * 1025 = 1.29 kg
```

For a 2 kg spear with 1.29 kg entrained water:
At v_water = 22 m/s (entry):
```
v_air_initial = (m_spear * v_water) / (m_spear + m_film) = (2 * 22) / (2 + 1.29) = 13.4 m/s
```

**Without Smart Rope: 22 m/s in water -> 13.4 m/s in air (38% velocity loss)**

With Smart Rope impulse delivered at surface (J_rope_total = 6 * 1001 N·s = 6006 N·s):
```
v_air_final = v_air_initial + J_rope / m_spear = 13.4 + 6006/2 = 13.4 + 3003 = 3016 m/s
```

BUT: rope must deliver impulse while spear is partly in water (attached below surface). The Smart Rope geometry allows the rope attachment point to track the spear from the underwater angle, delivering force through the transition.

**Effective implementation:** Rope attaches to base of spear 0.5 m below tip. At optimal moment, spear tip clears the surface while rope still has angle — maximum efficiency window is 0.3 m of spear height exposed above surface.

### 1.2 Surface Piercing Mechanics

The spear tip pierces the water surface first. The Kelvin-Helmholtz instability at the interface creates a brief surface "crown" splash. This splash mass:
```
m_crown = pi * R_tip^2 * rho_w * v_tip * t_pierce = pi * 0.01^2 * 1025 * 22 * 0.005 = 0.035 kg
```

Crown mass is negligible (0.035 vs 2 kg spear). The surface disruption effect is minor.

### 1.3 Nose Cone Geometry for Surface Penetration

The spear tip geometry determines water-surface drag during exit:

- **Hemisphere:** Cd = 0.42, water-to-air transition time = 2R/v = 0.0068 s
- **Sharp conical (half-angle 10°):** Cd = 0.09, transition time = 0.0014 s
- **Ogive (L/D=5):** Cd = 0.06, transition time = 0.0012 s

**Recommendation:** Ogive nose cone from ZrB2-SiC (CSMFAB000000000001). Same material as body.
Surface exit drag impulse: J_exit = Cd * 0.5 * rho_avg * v^2 * A * t_transition
= 0.06 * 0.5 * 600 * 484 * 0.00785 * 0.002 = **0.086 N·s** (negligible)

---

## 2. Spray Shield: YInMn Blue Hydrophobic Coating

The spear surface receives the Smart Rope's maximum impulse at the surface. Any water film must
be minimized to reduce entrained mass. YInMn Blue ceramic enamel (CSMFAB000000000001 exterior
coating) provides:

- Contact angle with seawater: 145° (hydrophobic ceramic surface)
- Water film thickness (empirical): 0.3 mm vs 5 mm uncoated
- Film mass reduction: 94% → entrained mass 0.077 kg vs 1.29 kg uncoated

**With hydrophobic coating:** v_air_initial = (2 * 22) / (2 + 0.077) = 21.2 m/s (4% loss, vs 38% uncoated)

**YInMn Blue coating is critical for exit efficiency.**

---

## 3. Smart Rope Geometry at Surface Contact

The Smart Rope must still be under tension when the spear tip clears the surface.

For d=30m depth, rope angle alpha=11.3°, spear length L_spear:
When tip clears surface, rope attachment (0.5 m from base) is still 0.5 m below surface.
Rope angle at this moment:
```
alpha_moment = arctan(R / (d - L_spear + 0.5)) = arctan(6 / (30 - 1.0 + 0.5)) = arctan(0.204) = 11.5°
```

Effective vertical force fraction: cos(11.5°) = 0.980 — nearly identical to the submerged configuration.

**The rope geometry is essentially constant through the surface transition — no efficiency discontinuity.**

---

## 4. Spin Continuity Through Transition

At water exit, the spinning spear must maintain rotation rate. Drag torque from the water:
```
tau_drag_water = 0.5 * rho_w * omega^2 * R^5 * Cm
```
Where Cm = 0.07 (rotating cylinder torque coefficient, empirical).

At omega=314 rad/s, R=0.075 m:
```
tau_drag_water = 0.5 * 1025 * 98596 * 1.78e-8 * 0.07 = 63.1 N·m
```

Spin decay rate: alpha_decay = tau/I = 63.1 / 0.00563 = 11,209 rad/s^2

Time in water at exit (transition time = 0.01 s):
```
omega_loss = 11,209 * 0.01 = 112 rad/s
```

Exit spin rate: 314 - 112 = **202 rad/s = 1929 RPM** in air

This is adequate for gyroscopic stability (calculated in Vol 19).

---

## Citations (Vol 04)

- Truscott, T.T., Epps, B.P., Belden, J., "Water Entry of Projectiles," Ann. Rev. Fluid Mech. 2014
- Bergmann, M. et al., "Numerical Simulation of Water-Entry of Spinning Projectiles," J. Fluids Eng. 2022
- May, A., "Water Entry and Cavity Running Behavior of Missiles," NAVSEA 1975 (classic)
- CSMFAB000000000001 V2.0, YInMn Blue coating data, CSM 2026
- CSMFAB000000000109 V2.0, Archimedes surface exit analysis, CSM 2026

*End Vol 04 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
