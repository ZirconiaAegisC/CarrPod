# CSMFAB000000000114 — Vol-03
# Archimedes Spiral Aerodynamics Fundamentals
## The Science of How the ASB-1 Flies
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

*References: CSMFAB000000000109 V2.0 | CSMFAB000000000102 V2.0 | Nature Scientific Reports (March 2026) | arXiv:2506.10223 (June 2026)*

---

## Introduction: A Machine as Old as the Earth

Before there were drones, before there were helicopters, before there were airplanes, nature had already solved the problem of aerial transport with a spinning wing. The maple tree creates a **samara** — a seed with a single curved wing that spins as it falls, slowing its descent and carrying the seed on the wind for hundreds of meters. The dandelion uses a parachute. The ash tree uses a spinning flat paddle. These are millions of years of aerodynamic optimization made physical.

The Archimedes spiral takes a different and more powerful approach. Where the maple samara has a single flat wing that spins around its center, the Archimedes spiral is a **continuous helical surface that threads itself through the air like a screw threads through wood**. This geometry has profound aerodynamic consequences that we will explore in this volume. Understanding these consequences is not optional — it is the foundation upon which every design decision in the ASB-1 rests.

---

## Part 1: What Is an Archimedes Spiral (in 3D)?

In 2D, an Archimedes spiral is a curve that moves outward from a center point at a constant rate as it rotates. Draw a clock hand that also moves outward as it rotates, and you have it. In 3D, if you extend this into the vertical dimension simultaneously, you get a **helix** — a screw thread. The Archimedes screw is the 3D implementation of this principle.

**Key geometric parameters of the ASB-1 spiral body:**

| Parameter | Symbol | ASB-1 Value | What It Controls |
|---|---|---|---|
| Outer radius | R | 75 mm (150mm diameter) | Total swept area for lift |
| Inner (hub) radius | r | 15 mm | Central structural core size |
| Number of turns | N | 3 | Total blade area; lift capacity |
| Pitch (rise per revolution) | p | 67 mm | How aggressively it "bites" the air |
| Pitch angle | θ | Variable 10°-35° from root to tip | Efficiency vs. wind speed |
| Chord width | c | 20 mm at midspan | Blade area per unit span |
| Total blade span | b | R − r = 60 mm per arm | Effective lifting surface |

The pitch angle θ is the most critical design parameter. It is the angle between the blade surface and the plane of rotation. Too shallow, and the blade has no "bite" on the air — it just spins in place. Too steep, and it stalls — the airflow separates from the blade surface and lift collapses. The optimum varies with wind speed.

---

## Part 2: The Physics of Autorotation

### 2.1 What Is Autorotation?

Autorotation is the condition where a spinning wing generates enough aerodynamic force to sustain or increase its own rotation **without an external motor**. The energy comes entirely from the airflow — wind passing over the spiral surface. A helicopter in autorotation after engine failure uses this principle to land safely. The maple samara autorotates all the way from tree to ground. The ASB-1 is designed to autorotate in **upward** wind — a thermal or updraft.

The physics are based on the relationship between the components of lift and drag on a spinning blade. When the wind speed and blade rotation speed reach the correct ratio (the "tip speed ratio"), the blade is at its optimum angle of attack, and the resultant aerodynamic force has a component that drives the rotation forward rather than braking it. This is the autorotation sweet spot.

### 2.2 Tip Speed Ratio (TSR)

The Tip Speed Ratio is the ratio of the blade tip rotational speed to the incoming wind speed:

```
TSR = (ω × R) / V_wind
```

Where:
- ω = angular velocity of the spiral body (radians per second)
- R = outer radius (0.075 m)
- V_wind = wind speed component relative to the blade

**For the ASB-1 3-blade Archimedes spiral geometry:**
- Optimal TSR ≈ 1.88 (from 2026 Nature Scientific Reports study on 3-blade ASWT)
- At 10 m/s (22 mph) wind: optimal ω = (1.88 × 10) / 0.075 = **250 rad/s = 2,390 RPM**
- At 15 m/s (34 mph) wind: optimal ω = (1.88 × 15) / 0.075 = **376 rad/s = 3,590 RPM**

This tells you: the faster the wind, the faster the spiral will spin. At 3,590 RPM in a 34 mph wind, the spiral tip is moving at about 28 m/s — faster than the wind itself, which is how lift is generated.

### 2.3 Power Coefficient (Cp)

The Power Coefficient is the fraction of the available wind energy that the spiral captures and converts to rotation. It is bounded by the **Betz limit** of 0.593 (the theoretical maximum for any wind energy device). Real devices are far below this.

For the 3-turn Archimedes spiral geometry:
- **Cp = 0.264** at TSR 1.88 (2026 research confirmation)
- This is comparable to small horizontal-axis wind turbines (Cp ≈ 0.25-0.35)
- Better than flat disk propeller autorotation (Cp ≈ 0.15-0.20) by 30-40%
- The spiral's advantage: **continuous blade surface** suppresses blade-vortex interaction (BVI) noise and tip losses

**Why 3 turns instead of 2 or 4?**
- 2 turns: lower Cp, lighter but insufficient lift in light winds
- 3 turns: optimal balance of Cp, mass, and structural leverage (confirmed by sensitivity analysis)
- 4 turns: diminishing returns on Cp, 33% more mass than 3 turns, higher drag

---

## Part 3: Lift Generation — The Spiral in Upward Wind

### 3.1 The Fundamental Lift Equation

For any wing-like surface moving through air, lift (L) is:

```
L = ½ × ρ × A × CL × V²
```

Where:
- ρ = air density (1.225 kg/m³ at sea level, 15°C)
- A = total blade planform area (m²)
- CL = lift coefficient (dimensionless) — depends on angle of attack
- V = effective velocity of airflow over the blade (m/s)

For the ASB-1 spiral body at 15 m/s wind with N=3 turns, chord c=20mm:
- Total blade area A = N × c × (R-r) × 2π/1 ≈ 3 × 0.020 × 0.060 × 6.28 = **0.0226 m²**
- At optimal TSR, effective blade velocity V_blade ≈ 28 m/s
- With CL ≈ 0.8 (moderate angle of attack, NACA-equivalent thin airfoil):

```
L = ½ × 1.225 × 0.0226 × 0.8 × 28² = 0.5 × 1.225 × 0.0226 × 0.8 × 784
L ≈ 8.7 Newtons = 887 grams-force
```

The ASB-1 weighs 177g = 1.74 Newtons. **An 8.7 N lift force is 5× the device weight.** In 15 m/s wind with 3-turn optimal geometry, this device will climb strongly. The gyroscopic precession stabilizes it upright (Vol-04).

### 3.2 Updraft vs. Headwind Lift

The spiral works in both updrafts and headwinds, but the physics differ:

**Updraft operation (cliff thermal, sea breeze front):**
- Wind is vertical or near-vertical (upward)
- The spiral horizontal face presents full disk area perpendicular to wind
- This is the highest efficiency orientation
- ASB-1 climbs straight upward while rotating
- Like a helicopter in hover with its rotor disk horizontal

**Headwind operation (wind blowing horizontally into spiral):**
- Wind is horizontal or angled
- The spiral tilts into the wind (gyroscopic effect assists with this — Vol-04)
- The spiral acts more like an autogyro rotor (tilted disk)
- ASB-1 moves upwind and upward simultaneously
- Slower altitude gain but better range coverage for sensor sweeping

---

## Part 4: Why the Spiral Is Better Than Flat Blades

This is the fundamental question underlying the entire CSM Archimedes drone lineage. Here is the definitive physics answer from 2025-2026 research:

### 4.1 Lower Noise (da Vinci Aerial Screw, arXiv 2026)

A June 2026 paper using Direct Numerical Simulations (DNS) compared the da Vinci aerial screw (which is an Archimedes spiral) to a conventional two-bladed rotor producing identical lift. Results:

| Property | Two-Blade Rotor | Archimedes Spiral | Advantage |
|---|---|---|---|
| Mechanical power per unit lift | Baseline | **−40% lower** | Spiral is more efficient |
| Acoustic intensity per unit lift | Baseline | **Significantly lower** | Spiral is quieter |
| Blade-vortex interaction (BVI) noise | Present | **Absent (continuous blade)** | No chopping sound |
| Rotational speed for same lift | Higher | Lower | Lower tip speed = less noise |

The continuous spiral surface **prevents the blade from periodically slicing through the vortex shed by the previous blade**, which is the primary source of the characteristic "chop" sound in helicopters and multirotor drones. The ASB-1 will sound more like a quiet whistling than a buzzing or chopping.

### 4.2 Higher Efficiency (CSMFAB000000000102 CFD, 2025)

From the existing CSM research in CSMFAB000000000102 V2.0 (CFD analysis, ANSYS Fluent 2025):

```
η_screw = T × v_axial / P_motor = 0.68
η_flat_blade = 0.58
```

The Archimedes screw rotor is **17% more thrust-efficient** per unit of power input compared to equivalent flat-blade rotors. This means a smaller motor can achieve equivalent lift, which directly benefits the weight budget.

### 4.3 Multi-Directional Wind Acceptance

Because the Archimedes spiral is a helical surface, it generates lift from wind arriving from a wider range of angles compared to a flat rotor disk. Research on Archimedes Spiral Wind Turbine (ASWT) geometry confirms **omnidirectional operation without yaw control** (no need to point into wind). This is critical for the ASB-1 in turbulent cliff-top wind environments where gusts come from multiple directions rapidly.

---

## Part 5: The Spiral Pitch Optimization for the ASB-1

CSMFAB000000000109 V2.0 establishes the optimal pitch angle formula:

```
tan(θ_opt) = V_wind / (ω × R)
```

At optimal TSR = 1.88 (note: ω × R = V_wind × TSR = V_wind × 1.88), so:

```
tan(θ_opt) = V_wind / (V_wind × 1.88) = 1/1.88 = 0.532
θ_opt = arctan(0.532) = 28.0°
```

**The optimal fixed pitch angle for the ASB-1 spiral at cruise wind speed is 28 degrees.**

However, since wind speeds vary, we use a **variable pitch** approach along the blade span:
- Root (inner, r=15mm): 35° pitch — high pitch angle at slow tangential speed
- Mid-span (r=45mm): 28° pitch — optimal for most conditions
- Tip (outer, r=75mm): 18° pitch — flatter pitch at faster tip tangential speed

This twisted blade profile is automatically generated by the 3D model in CSMFAB000000000114-3D-03 and is printed as a single integrated piece.

---

## Part 6: Wind Speed Operating Envelope

| Wind Speed | Condition | ASB-1 Behavior |
|---|---|---|
| 0-5 m/s (0-11 mph) | Calm | Motor-assisted hover only; autorotation insufficient for lift |
| 5-10 m/s (11-22 mph) | Light wind | Autorotation begins; device rises slowly at 0.5-2 m/s climb rate |
| 10-15 m/s (22-34 mph) | Moderate wind | **Optimal range**; 2-5 m/s climb rate; full research capability |
| 15-20 m/s (34-45 mph) | Strong wind | Fast climb 5-10 m/s; speed governor activating; excellent data collection |
| 20-25 m/s (45-56 mph) | Near gale | Speed governor fully active; tether essential; max climb possible |
| >25 m/s (>56 mph) | Gale | Do not launch without enhanced tether protocol; risk of governor failure |

> ⚠️ **SAFETY:** Do not launch ASB-1 units in winds exceeding 25 m/s without explicit operational planning for that wind speed. The tether and FTS are the primary safety systems above 20 m/s.

---

## Part 7: The Samara Analogy — What Nature Teaches

The maple samara achieves a stable autorotating descent at about 1 m/s by converting potential energy (height) to sustained, controlled rotation. Its Reynolds number (a dimensionless measure of airflow regime) is approximately Re = 10,000-100,000 — very similar to the ASB-1's operating condition.

What nature tells engineers:
1. **Single continuous surface** is optimal at low Reynolds numbers — the samara has no separate leading and trailing edges in the helicopter sense
2. **Twisting along the span** is natural — maple seeds have a built-in pitch gradient
3. **Mass concentration at the wing tip** (the heavy seed end) creates gyroscopic stability — the ASB-1 replicates this with the electronics bay positioned mid-body
4. **Autorotation is self-regulating** — as the samara speeds up, drag increases, finding an equilibrium

The ASB-1 adds to the samara concept:
- Three-turn continuous helix (vs. single flat curved wing) for 5× more lift surface
- Active tether control (vs. passive descent)
- Electronic sensors and radio (vs. genetic payload)
- Speed governor (vs. terminal velocity through drag alone)

---

## CHECKPOINT — Vol-03 Complete

Before moving to Vol-04, confirm:
- [ ] You understand why Archimedes spiral geometry outperforms flat blades (efficiency, noise, omnidirectionality)
- [ ] You know the optimal pitch angle is 28° at cruise, graduating from 35° (root) to 18° (tip)
- [ ] You know the optimal tip speed ratio is 1.88 for the 3-turn geometry
- [ ] You understand that in 15 m/s wind, the ASB-1 generates 8.7 N lift against its 1.74 N weight — substantial climb capability
- [ ] You understand the operating envelope (5-25 m/s operational wind range)
- [ ] You have noted all equations are applied directly in the 3D models (Vol-16, Vol-17)

**Proceed to:** Vol-04 (Gyroscopic Stability — The Spinning Bird Effect)

---

*CSMFAB000000000114-Vol-03 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
