# 02 — Magneto-Inertial Fusion Theory

## Classification: Proprietary — ACS Internal Use Only

---

## 1. Overview

The Helicity Drive propulsion concept belongs to the magneto-inertial fusion (MIF) class
of approaches. MIF occupies the parameter space between magnetic confinement fusion (MCF)
and inertial confinement fusion (ICF). In MCF, a low-density plasma is confined by
externally applied magnetic fields for long durations (seconds to steady-state). In ICF, a
high-density fuel capsule is compressed by laser or ion beams for nanoseconds. MIF
operates at intermediate density and intermediate confinement time (microseconds to tens
of microseconds), using magnetic fields to reduce thermal transport losses during inertial
compression.

The defining characteristic of the Helicity Space MIF architecture is its simultaneous
deployment of three plasma physics mechanisms — compression, confinement, and heating —
rather than relying on a single mechanism as in most competing approaches.

---

## 2. Lawson Criterion Context

The Lawson criterion establishes the product of density (n), confinement time (τ), and
temperature (T) required for fusion energy breakeven:

```
n · τ · T > 3 × 10^21 keV · s/m³    (D-T fuel, ignition)
```

Chemical rockets operate near zero on this scale. Magnetic confinement operates at n ≈
10^20 m⁻³, τ ≈ 1–10 s. Inertial confinement operates at n ≈ 10^31 m⁻³, τ ≈ 10⁻¹⁰ s.
MIF targets n ≈ 10^24–10^27 m⁻³ and τ ≈ 10⁻⁶–10⁻⁴ s, a regime where compression provides
the density and magnetic insulation provides the confinement time.

Helicity Space's critical insight is that propulsion-grade thrust does not require
breakeven. Because the Helicity Drive operates as an open magnetic nozzle, ionized
plasma can be exhausted for propulsive effect at gains well below unity. The company
projects thrust production at Q ≈ 0.1 to 0.5, where Q is the ratio of fusion power
output to input power.

---

## 3. Fusion Fuel Cycle

| Parameter | D-T (Baseline) | D-He³ (Advanced) |
|---|---|---|
| Reaction | D + T → ⁴He (3.5 MeV) + n (14.1 MeV) | D + ³He → ⁴He (3.6 MeV) + p (14.7 MeV) |
| Ignition Temperature | ~4.4 keV | ~30 keV |
| Neutron Fraction | 80% of energy in neutrons | < 5% of energy in neutrons |
| Propulsion Suitability | Requires thick shielding | Direct charged-particle exhaust |

The near-term ECLAIR experiment focuses on D-T plasmas for diagnostic clarity. The
operational propulsion system targets D-He³ fuel to maximize the fraction of fusion
energy released as charged particles suitable for magnetic nozzle extraction.

---

## 4. Plasma Regime

The Helicity Drive plasma regime is characterized by:

- **Beta (β ≈ 0.1–1.0)** — ratio of plasma pressure to magnetic pressure. High-beta
  operation maximizes thrust density but requires active stabilization via plectonemic
  topology.
- **Lundquist Number (S ≈ 10³–10⁵)** — ratio of resistive diffusion time to Alfvén
  transit time. Intermediate S-values enable controlled magnetic reconnection without
  the explosive instability seen at higher S.
- **Ion Larmor Radius (ρ_i ≈ mm–cm)** — small relative to plasma radius, validating
  the fluid treatment underlying the LA-COMPASS 3D MHD code.
- **Alfvén Mach Number (M_A ≈ 0.5–2)** — trans-Alfvénic jet injection at the
  peristaltic nozzle inlet drives plectonemic braiding.

---

## 5. Three-Mechanism Coupling

The novelty of the Helicity approach lies not in any individual mechanism but in the
temporal synchronization of all three. The coupling sequence is:

1. Plasma guns inject high-density jets with embedded poloidal and toroidal magnetic
   flux (t = 0–10 μs)
2. Peristaltic magnetic nozzle geometry drives three-dimensional compression (t =
   5–30 μs), increasing density and temperature simultaneously
3. Plectonemic braiding of the compressed flux tubes provides wall-free confinement
   during the fusion burn phase (t = 10–100 μs)
4. Magnetic reconnection at flux tube contact points deposits energy directly into
   the ion population (t = 15–80 μs), raising temperature toward fusion-relevant values
5. Exhaust phase: remnant plasma and fusion products expand through the magnetic
   nozzle, converting thermal energy to directed thrust (t > 100 μs)

The per-pulse timescale is sub-millisecond, allowing repetition rates of 10–100 Hz
for quasi-steady thrust.
