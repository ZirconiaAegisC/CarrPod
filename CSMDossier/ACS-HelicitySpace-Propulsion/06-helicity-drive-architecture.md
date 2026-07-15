# 06 — Helicity Drive Architecture

## Classification: Proprietary — ACS Internal Use Only

---

## 1. System Overview

The Helicity Drive is a pulsed magneto-inertial fusion propulsion engine. Its
architecture is modular, with the fundamental building block being a plasma gun
assembly that injects a magnetized jet into a common peristaltic magnetic nozzle.
Multiple guns fire in synchronized volleys, and the number of guns determines the
total engine power and thrust class.

The architecture spans a power range from approximately 100 kW (small satellite or
upper-stage applications) to 1 GW (crewed interplanetary spacecraft).

---

## 2. Subsystem Decomposition

### 2.1 Plasma Gun Array

Each plasma gun is a coaxial electromagnetic accelerator that ionizes a puff of
fusion fuel (D-T or D-He³ gas) and accelerates the resulting plasma to velocities
of 50–200 km/s. Key parameters per gun:

| Parameter | Value |
|---|---|
| Gun type | Coaxial (Marshall-type) electromagnetic accelerator |
| Plasma jet velocity | 50–200 km/s |
| Jet density at muzzle | 10^21–10^22 m⁻³ |
| Jet diameter at nozzle inlet | 1–5 cm |
| Repetition rate | 1–100 Hz |
| Fuel mass per pulse | 10⁻⁶–10⁻⁴ kg |
| Embedded magnetic field | Poloidal + toroidal components, 0.1–1 T |

The gun array is arranged radially around the nozzle inlet axis. The 4-gun prototype
configuration places guns at 90° azimuthal intervals. Production engines scale to 6,
8, 12, or 16 guns depending on thrust requirements.

### 2.2 Peristaltic Magnetic Nozzle

The magnetic nozzle assembly consists of a series of toroidal and poloidal field
coils arranged in a convergent-divergent geometry. The coils are superconducting
(NbTi or REBCO, depending on operating temperature) and operate at DC or low-
frequency AC. The nozzle converts:

- Thermal plasma energy → directed kinetic energy (via adiabatic expansion in the
  divergent section)
- Magnetic energy → thrust (via the J × B force on the expanding plasma)
- Fusion product energy (charged particles) → thrust (via magnetic deflection into
  the exhaust stream)

### 2.3 Pulsed Power Subsystem

| Component | Technology | Rating |
|---|---|---|
| Gun capacitor banks | Low-inductance film/ceramic capacitors | 1–10 kJ per gun per pulse |
| Coil power supplies | DC superconducting supply | 10–100 kW steady-state |
| Trigger and timing | FPGA-based synchronized firing | < 1 ns jitter |
| Thermal management | Cryogenic (coils) + radiative (nozzle) | — |

### 2.4 Fuel Handling Subsystem

Fusion fuel is stored as cryogenic liquid (D-T) or high-pressure gas (D-He³).
Each pulse consumes a measured fuel mass injected into the gun breech via fast-
acting piezoelectric valves. Fuel consumption rate for a 10-gun, 100 Hz engine
operating on D-He³ is approximately 0.1–1 gram per second.

---

## 3. Operational Cycle

```
Phase 0 (t = -100 μs): Fuel injection into gun breeches
Phase 1 (t = 0 μs):    Capacitor discharge — plasma formation and acceleration
Phase 2 (t = 5–10 μs): Jets enter nozzle inlet, begin peristaltic compression
Phase 3 (t = 10–30 μs): Plectonemic braiding of flux tubes
Phase 4 (t = 20–50 μs): Magnetic reconnection heating at current sheets
Phase 5 (t = 30–80 μs): Peak compression at nozzle throat — fusion burn
Phase 6 (t = 80–200 μs): Plasma expansion through divergent nozzle — thrust
Phase 7 (t > 200 μs):    Capacitor recharge, thermal recovery
```

The duty cycle is limited by capacitor recharge time and nozzle thermal recovery.
With active cooling, repetition rates up to 100 Hz are achievable.

---

## 4. Scaling Law

```
Thrust (F) ∝ N_guns × ṁ_per_gun × I_sp × g₀
Power (P_in) ∝ N_guns × E_pulse × f_rep
I_sp ∝ √T_i ∝ √(reconnection heating efficiency × η_compression)
```

Where:
- N_guns = number of plasma guns
- ṁ_per_gun = mass flow rate per gun per pulse
- E_pulse = electrical energy per pulse
- f_rep = pulse repetition frequency
- η_compression = ratio of compressed density to inlet density

---

## 5. Power Classes

| Class | Guns | Power (MW) | Thrust (kN) | I_sp (s) | Application |
|---|---|---|---|---|---|
| Micro | 2–4 | 0.1–1 | 0.01–0.1 | 3,000–5,000 | Small satellite, tech demo |
| Mid | 4–8 | 1–100 | 0.1–10 | 5,000–15,000 | Cargo tug, orbital transfer |
| Heavy | 8–16 | 100–1,000 | 10–100 | 10,000–30,000 | Crewed Mars, outer planets |

---

## 6. Mass Power Density Advantage

Helicity Space claims a factor of 10 improvement in both mass power density (kW/kg)
and volumetric power density (kW/m³) relative to conventional nuclear fission,
fission-fusion hybrid, and continuous-wave magnetic confinement fusion systems. This
advantage arises from:

1. **No steam cycle** — direct conversion of plasma thermal energy to thrust
2. **No neutron shielding mass** — for D-He³ operation, the charged-particle
   fraction reduces shielding requirements
3. **No massive reactor vessel** — the wall-free plectonemic confinement eliminates
   the structural mass of a vacuum vessel rated for high neutron flux
4. **Modular scaling** — the gun-and-nozzle architecture avoids the cubic mass
   scaling of scaled-up single-chamber designs
