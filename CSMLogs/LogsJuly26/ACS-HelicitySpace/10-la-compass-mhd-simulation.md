# 10 — LA-COMPASS 3D MHD Simulation

## Classification: Proprietary — ACS Internal Use Only

---

## 1. Collaboration Identity

LA-COMPASS (Los Alamos Computational MHD Plasma And Space Science) is a three-
dimensional magnetohydrodynamic simulation code developed and maintained at Los
Alamos National Laboratory (LANL). Helicity Space collaborates with LANL under a
cooperative research and development agreement (CRADA) or equivalent institutional
framework to apply LA-COMPASS to the Helicity Drive plasma physics.

The collaboration leverages LANL's decades of institutional expertise in MHD
simulation, magnetic reconnection physics, and plasma diagnostics — areas directly
relevant to the DOE's national security mission and to fusion energy research.

---

## 2. Code Capabilities

LA-COMPASS is a fully three-dimensional, time-dependent resistive MHD code with the
following capabilities relevant to the Helicity Drive simulation:

| Feature | Implementation |
|---|---|
| Spatial discretization | Finite-difference on a structured Cartesian or cylindrical grid |
| Time integration | Explicit or semi-implicit, adaptive time-step |
| Magnetic field treatment | Vector potential formulation preserving ∇ · B = 0 |
| Resistivity model | Spatially uniform or temperature-dependent (Spitzer) |
| Hall term | Optional (extended MHD / Hall-MHD for reconnection studies) |
| Equation of state | Ideal gas, single-fluid, with separate ion and electron temperature tracking |
| Boundary conditions | Conducting wall, free-stream, periodic, or user-specified |
| Initial conditions | User-specified density, velocity, and magnetic field distributions |

---

## 3. Simulation Domain

The LA-COMPASS simulation domain for the Helicity Drive models a cylindrical volume
encompassing the nozzle inlet, convergent section, throat, and divergent section.

| Parameter | Value |
|---|---|
| Axial extent (z) | 0 to ~1 m |
| Radial extent (r) | 0 to ~0.3 m |
| Grid resolution | 200–400 cells axially, 100–200 cells radially |
| Azimuthal resolution | Full 360° with 64–128 cells (required for non-axisymmetric braiding) |
| Total cell count | ~5–20 million |
| Time step | ~10⁻¹⁰–10⁻⁹ s (CFL-limited) |
| Simulated duration | 200–500 μs (full pulse) |
| Wall-clock time per simulation | 24–72 hours on 256–512 CPU cores |

---

## 4. Physics Modeled

### Initial Conditions

Four discrete plasma jets are initialized at the inlet plane with specified density,
velocity, temperature, and magnetic field (poloidal + toroidal) profiles. The
peristaltic coil field is specified as a background magnetic field at t = 0.

### Plasma Dynamics

The code solves the resistive MHD equations:

```
∂ρ/∂t + ∇ · (ρv) = 0                      (mass continuity)
ρ(∂v/∂t + v · ∇v) = J × B - ∇p           (momentum, neglecting viscosity)
∂B/∂t = -∇ × E                            (Faraday's law)
E + v × B = ηJ                             (Ohm's law, resistive MHD)
∂p/∂t + v · ∇p + γp∇ · v = (γ-1)ηJ²      (energy equation with Ohmic heating)
```

When running in Hall-MHD mode, the generalized Ohm's law includes the Hall term:

```
E + v × B = ηJ + (1/ne) J × B             (Hall-MHD)
```

The Hall term is critical for resolving the fast reconnection physics at current
sheets thinner than the ion inertial length.

---

## 5. Validation Against ECLAIR Data

The simulation campaign runs in parallel with the experimental campaign. The
validation loop is:

1. **Pre-shot prediction**: LA-COMPASS is run with the planned experimental
   parameters to predict plasma behavior
2. **Shot execution**: ECLAIR data is acquired
3. **Post-shot comparison**: simulated and measured magnetic field topology,
   density, and temperature are compared
4. **Model refinement**: discrepancies exceeding a factor of 2 in any quantity
   trigger a review of the simulation inputs (initial conditions, resistivity
   model, boundary conditions)
5. **Iteration**: the refined model is used for the next pre-shot prediction

The goal is convergence to within a factor of 2 on all primary plasma parameters
(density, temperature, field topology) across the full parameter space.

---

## 6. Predictive Capability

Once validated, LA-COMPASS serves as the primary design tool for scaling the
Helicity Drive from the ECLAIR sub-scale to production engine sizes. Key
predictions include:

- **Gun count scaling**: how do density, temperature, and confinement time scale
  with N_guns?
- **Fuel parameter space**: what are the optimal initial conditions (jet velocity,
  density, magnetic field) for D-T and D-He³?
- **Pulse energy optimization**: what is the minimum capacitor bank energy per
  gun to achieve a given I_sp?
- **Nozzle geometry optimization**: what convergent and divergent angles maximize
  thrust efficiency for a given coil set?

---

## 7. Institutional Context

Los Alamos National Laboratory's involvement provides Helicity Space with access
to capabilities — petascale computing, multi-decade MHD code development, and
expertise in magnetic reconnection and fusion plasma physics — that would be
prohibitively expensive for an early-stage startup to develop independently. The
collaboration is consistent with LANL's technology transfer mission and with DOE
interest in advanced propulsion concepts relevant to national security space
applications.
