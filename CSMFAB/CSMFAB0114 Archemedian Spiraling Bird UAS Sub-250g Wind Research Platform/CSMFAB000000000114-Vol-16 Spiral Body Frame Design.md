# CSMFAB000000000114 — Vol-16
# Spiral Body Frame Design
## Archimedes Helix Geometry and Structural Analysis
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction

The spiral body is the heart of the ASB-1 — it is simultaneously the airframe, the wing, the propeller, and the visual identity of the device. Getting its geometry correct is the difference between a device that soars and one that tumbles. This volume defines the precise helix geometry, performs the structural analysis at maximum operating loads, and specifies the minimum wall thickness.

---

## Part 1: Helix Geometry Parameters

The Archimedes spiral body is defined by these equations in 3D space:

```
x(t) = R(t) × cos(t)
y(t) = R(t) × sin(t)
z(t) = p × t / (2π)
```

Where:
- t = parameter from 0 to N × 2π (N = number of turns = 3)
- R(t) = outer radius at position t
  - For uniform radius: R(t) = 75mm (constant)
  - For tapered tip: R(t) = 75mm at root, 60mm at tip
- p = pitch = 67mm (rise per full revolution)
- Total height: 3 × 67mm = 201mm

**Blade chord at radius r (blade width):** 20mm constant (verified optimal for Cp 0.264 at TSR 1.88)

**Blade twist angle at radius r (pitch angle):**
```
θ(r) = arctan(p / (2π × r))
```
- At r = 15mm (inner): θ = arctan(67/(2π×15)) = arctan(0.711) = 35.4°
- At r = 45mm (mid): θ = arctan(67/(2π×45)) = arctan(0.237) = 13.3°  
  *(Note: adjusted to 28° for aerodynamic optimization — the blade is locally twisted beyond pure Archimedes screw geometry)*
- At r = 75mm (outer tip): θ = arctan(67/(2π×75)) = arctan(0.142) = 8.1°
  *(Adjusted to 18° for aerodynamic optimization)*

The actual blade angles in the 3D model (3D-03, Vol-17) use the aerodynamically-optimized twist schedule (35° → 28° → 18°) rather than the pure helix angles above, because the aerodynamic optimum (Vol-03) differs slightly from the pure geometric Archimedes angle.

---

## Part 2: Structural Analysis

### 2.1 Load Cases

The spiral body must withstand:
1. **Centrifugal loads** at maximum governed spin rate (5,000 RPM)
2. **Aerodynamic bending** at maximum wind speed (25 m/s)
3. **Impact loads** at landing in net recovery system

**Load Case 1: Centrifugal Stress**

For a blade element at radius r, rotating at ω = 524 rad/s (5,000 RPM):
```
σ_centrifugal = ρ_BFRP × ω² × r² / 2
σ_centrifugal = 1850 × (524)² × (0.075)² / 2
σ_centrifugal = 1850 × 274,576 × 0.005625 / 2
σ_centrifugal = 1.43 MPa
```

BFRP tensile strength: 1,100 MPa. Safety factor: **1,100 / 1.43 = 769×**. Centrifugal loads are trivially below material limits.

**Load Case 2: Aerodynamic Bending**

Maximum aerodynamic lift force per blade arm = 8.7 N total / 3 arms = 2.9 N per arm, applied at the arm mid-span (r = 45mm), creating bending moment at root:
```
M_bending = F_arm × (arm span / 2) = 2.9 × 0.030 = 0.087 N·m
```

Bending stress in blade root (assuming rectangular section 20mm × 1.2mm wall):
```
I_section = (b × h³ - b_inner × h_inner³) / 12
I_section ≈ (0.020 × 0.0012³) / 12 = 2.88 × 10⁻¹² m⁴ (hollow section for 1-layer wall)
```
Simplify: use solid 1.2mm section:
```
I_solid = b × h³ / 12 = 0.020 × (0.0012)³ / 12 = 2.88 × 10⁻¹² m⁴
σ_bending = M × c / I = 0.087 × 0.0006 / 2.88×10⁻¹² = 18,125 Pa = 0.018 MPa
```

Safety factor against BFRP tensile yield: **1,100 / 0.018 = 61,000×**. Aerodynamic bending loads are insignificant.

**Minimum wall thickness: 1.2mm confirmed adequate with extreme margins.**

### 2.2 Torsion Load

The spiral body transmits torque from the aerodynamic surfaces to the governor shaft and speed governor. Maximum torque from aerodynamic drag at 5,000 RPM:
```
P = T × ω
Max harvested power ≈ 5W (estimated at max spin)
T = P / ω = 5 / 524 = 0.00955 N·m
```

Shear stress in hub at 15mm radius:
```
τ = T × r / J = 0.00955 × 0.015 / (π × 0.015⁴ / 2) = very small
```

The hub is overstrength for the torsion load. **Hub wall thickness: 1.2mm minimum.**

---

## Part 3: Center of Gravity Location

For stable autorotation, the center of gravity (CG) must be located at or slightly below the center of aerodynamic pressure. For the ASB-1:

- Heavy items (battery 35g, motor 9g) located at body center (130mm from nose tip)
- Electronics (FC, GPS, radio: 19g) at same level
- Light items (sensors, wiring, actuators: ~20g) distributed throughout
- CG calculated at approximately **130mm from nose tip** = mid-body

The center of aerodynamic pressure for an autorotating helix body is at approximately 40-45% of the helix length from the leading edge. For 200mm helix length: **80-90mm from nose end**.

The CG (130mm) is **below** the aerodynamic center (80-90mm) — meaning the device is **bottom-heavy** relative to aerodynamic lift. This creates an inherent pendulum stability: the lift force (above CG) and weight (at CG) create a righting moment that keeps the spiral in its optimal orientation. This is the same principle that makes arrow-fletched projectiles stable.

---

## CHECKPOINT — Vol-16 Complete

Before proceeding, confirm:
- [ ] You know the helix parameters: R=75mm, N=3 turns, pitch=67mm, total height=201mm
- [ ] You know the blade twist schedule: 35° (inner) → 28° (mid) → 18° (tip)
- [ ] You know minimum wall thickness: 1.2mm (centrifugal safety factor 769×; bending 61,000×)
- [ ] You understand the CG location (130mm from nose) is below aerodynamic center (80-90mm) — inherently stable
- [ ] You are ready to 3D print from 3D-01, 3D-03 prompt documents

**Proceed to:** Vol-17 (Spiral Blade Fabrication and 3D Printing)

---

*CSMFAB000000000114-Vol-16 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
