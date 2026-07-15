# 16 — Development Roadmap & Spacecraft Integration

## Classification: Proprietary — ACS Internal Use Only

---

## 1. Technology Development Pathway

The Helicity Drive development roadmap spans from the current ECLAIR single-shot
experiment to an operational flight-qualified propulsion system. The pathway is
organized into five phases, each defined by a technology readiness level (TRL)
advancement and a specific set of demonstrated capabilities.

---

## 2. Phase Structure

### Phase I: Plasma Physics Validation (Current — TRL 2–3)

**Timeline**: 2025–2027
**Facility**: Helicity Space laboratory, Pasadena, CA
**Key Milestones**:

| Milestone | Target Date | Status |
|---|---|---|
| Four-gun synchronized firing | Q2 2026 | Completed |
| Plasma jet demonstration | July 2026 | Completed |
| Plectonemic braiding observed | Q4 2026 | In progress |
| Reconnection heating measured (T_i > 200 eV) | Q1–Q2 2027 | Planned |
| D-T fusion neutron detection | Q3–Q4 2027 | Planning |
| NIAC Phase I final report | 2026 | In progress |

**Funding**: Seed capital, NASA NIAC, DOE INFUSE (in-kind)

### Phase II: Repetition-Rated Prototype (TRL 3–4)

**Timeline**: 2027–2029
**Facility**: Upgraded Helicity Space laboratory or leased test stand
**Key Milestones**:

| Milestone | Target |
|---|---|
| Capacitor bank upgrade for 1 Hz repetition | 2028 |
| Superconducting coil demonstration | 2028 |
| Thrust stand integration | 2028 |
| 10 Hz repetition rate achieved | 2029 |
| Sustained operation > 1,000 pulses | 2029 |
| D-He³ fuel handling validation | 2029 |

**Funding**: Series A venture capital, potential Department of Defense interest
(US Space Force propulsion technology portfolio)

### Phase III: Subscale Flight Demonstrator (TRL 4–5)

**Timeline**: 2029–2032
**Objective**: Orbit the propulsion system on a small satellite or hosted payload
to demonstrate ignition and pulsed operation in vacuum.

| Element | Specification |
|---|---|
| Spacecraft bus | ESPA-class small satellite or hosted payload |
| Orbit | LEO (400–600 km), possibly SSO |
| Engine configuration | 2-gun subscale system |
| Power source | Deployable solar arrays + battery buffer |
| Mission duration | 3–6 months |
| Key demonstration | In-space plasma pulse, thrust measurement, I_sp validation |
| Launch vehicle | Rideshare on Falcon 9 or equivalent |

### Phase IV: Operational Prototype (TRL 5–7)

**Timeline**: 2032–2036
**Objective**: Build and test a full-scale engineering model of the Helicity
Drive in a ground-based space environment simulation chamber, then transition
to a dedicated orbital demonstration mission.

| Milestone | Target |
|---|---|
| Full-scale (8–16 gun) ground test | 2033–2034 |
| 100+ hour accumulated runtime | 2034 |
| Dedicated orbital demonstrator mission | 2035–2036 |
| Cislunar cargo tug concept validation | 2036 |

### Phase V: Operational Deployment (TRL 8–9)

**Timeline**: 2036–2040+
**Objective**: Deploy operational Helicity Drive propulsion systems for government
and commercial missions.

| Application | Initial Operational Capability |
|---|---|
| Cislunar logistics (cargo) | ~2037 |
| Interplanetary cargo (Mars pre-deployment) | ~2038 |
| NASA science missions (heliosphere, outer planets) | ~2039 |
| Crewed Mars transit vehicle propulsion | ~2040+ |

---

## 3. Spacecraft Integration Architecture

Integrating a Helicity Drive with a spacecraft requires accommodation of several
unique subsystem interfaces:

### 3.1 Structural Interface

The peristaltic magnetic nozzle assembly mounts to the spacecraft via a thrust
structure that reacts the engine's thrust loads. The nozzle coils are
cryogenically cooled; the cryocooler rejects heat to space via dedicated
radiators. The structural interface must also accommodate the magnetic field
exclusion zone around the nozzle (typically 5–10 m radius for a 1 MW engine
to avoid interference with spacecraft electronics).

### 3.2 Power Subsystem Interface

| Engine Class | Electrical Power Required | Power Source Options |
|---|---|---|
| 100 kW | 100–200 kW | Solar arrays (ISS-scale, ~1,000 m²) + battery buffer |
| 1 MW | 1–2 MW | Dedicated nuclear fission reactor (e.g., kilopower-derived) |
| 100 MW+ | 100–200 MW | Large fission reactor or multiple reactor modules |

The pulsed-power architecture decouples capacitor bank charging (continuous)
from plasma gun discharge (pulsed), allowing the spacecraft power source to
operate at steady-state while the engine operates at high peak power.

### 3.3 Thermal Management

| Heat Source | Power (kW) | Rejection Method |
|---|---|---|
| Coil cryocooler | 10–100 | Radiators (300 K) |
| Capacitor bank ohmic losses | 1–10 | Conduction to spacecraft thermal bus |
| Nozzle radiant heating (plasma) | 10–100 | Refractory nozzle liner + radiator |
| Fusion neutron heating (D-T phase) | 10–100 | Shadow shield + structural cooling |

### 3.4 Radiation Shielding

For D-T operation, the 14.1 MeV neutron flux requires a shadow shield between
the nozzle throat and the payload/crew sections. The shield material options
include:

- **Lithium hydride (LiH)** — high hydrogen density for neutron moderation,
  low mass
- **Tungsten** — gamma attenuation
- **Layered composite** — optimized for the neutron energy spectrum

Shield mass scales approximately as:

```
M_shield ≈ k · P_fusion^(2/3)   (k ≈ 0.1–0.5 kg/kW^(2/3))
```

For a 500 kW_fusion engine, shield mass is estimated at 1–5 tons. For D-He³
operation, the neutron flux is reduced by a factor of 20–50, proportionally
reducing or eliminating the need for a dedicated neutron shield.

---

## 4. Mars Mission Integration Concept

A crewed Mars transit vehicle powered by Helicity Drive would consist of:

| Element | Mass (tons) | Description |
|---|---|---|
| Helicity Drive (8-gun) | 10–20 | Engine, coils, capacitor banks, cryocooler |
| Fusion fuel (D-He³) | 5–15 | For 30–90 day transit |
| Power reactor | 5–10 | 1 MW fission reactor |
| Radiation shield | 1–5 | Shadow shield (D-He³ case) |
| Crew habitat | 20–40 | Transit hab, life support, consumables |
| Mars entry vehicle | 10–30 | Crew lander or orbital transfer vehicle |
| **Total initial mass (LEO)** | **50–120** | Equivalent to 2–4 SLS Block 1B launches |

---

## 5. Competitive Timeline

| Year | Helicity Space | Competing Approaches |
|---|---|---|
| 2026 | ECLAIR plasma jet demo | VASIMR 200 kW ground test; NTP fuel element tests |
| 2028 | 1 Hz rep-rated prototype | PFRC fusion propulsion lab demo (Princeton) |
| 2030 | Subscale orbital demo | NTP flight demo (DRACO program) |
| 2035 | Full-scale orbital demo | Possible NTP operational; VASIMR operational? |
| 2040 | Operational Helicity Drive | — |
