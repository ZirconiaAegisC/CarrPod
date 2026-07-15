# ALIA A250 VTOL — DEVELOPMENT ROADMAP
## Beta Technologies Corporation — ACS Dossier File 03

---

### CONFIGURATION

The ALIA A250 is the Vertical Takeoff and Landing (VTOL) variant of the ALIA platform, retaining the CX300 airframe, composite fuselage, wing geometry, avionics suite, and energy storage architecture while adding a distributed electric lift system. The A250 is designed to operate from vertiports, hospital helipads, rooftop pads, and constrained urban sites without runway infrastructure.

The lift system comprises eight lift rotors (four forward, four aft) mounted on tandem boom structures extending from the wing, plus a single aft-mounted pusher propeller for forward cruise flight. Transition between vertical and horizontal flight occurs via progressive lift-rotor tilt authority, managed by the flight control system with triple-redundant fly-by-wire architecture.

### SPECIFICATIONS (TARGET)

| Parameter | Specification |
|---|---|
| Passenger capacity | 5-6 passengers + 1 pilot |
| Cargo configuration | Convertible for medical equipment or freight |
| Range (VTOL) | 150-175 nautical miles (with reserves) |
| Cruise speed | 130-140 knots |
| Hover power | ~4x cruise power for vertical segments |
| Battery architecture | Identical module type as CX300; increased module count |
| Charge time | ~50-60 minutes (320 kW DC) |
| Noise | Targeting 62 dBA at 500 ft overflight |

### DEVELOPMENT PHASING

The A250 follows a deliberate, derisked development strategy that prioritizes CX300 certification first, then leverages the validated certification basis, loads data, systems validation, and manufacturing processes for the VTOL variant. This sequential approach acknowledges the additional complexity of distributed electric propulsion certification while capitalizing on the ~85% airframe commonality.

**Phase I — CX300 Derivative Validation (2025-2027)**
- Structural loads database generation from CX300 flight test
- H500A motor qualification and Type Certificate
- Battery module certification to DO-311A standards
- Avionics suite validation per DO-178C/DO-254

**Phase II — Lift System Ground Testing (2026-2027)**
- Eight-rotor lift system rig testing at Plattsburgh facility
- Transition control law development and simulation
- Redundant power distribution architecture validation
- Electric propulsion unit endurance testing

**Phase III — Prototype Flight Test (2027-2028)**
- Hover and low-speed handling qualities
- Full transition envelope expansion
- Icing, hot-day, and high-altitude testing
- FAA conformity inspection and TIA issuance

**Phase IV — Certification (2028)**
- Part 23 powered-lift certification basis
- Means of compliance demonstration
- Function and Reliability (F&R) flight testing
- Production conformity and PC issuance

### VERTICAL LIFT SYSTEM ARCHITECTURE

| Component | Detail |
|---|---|
| Forward lift rotors | 4x fixed-pitch, variable-speed electric rotors |
| Aft lift rotors | 4x fixed-pitch, variable-speed electric rotors |
| Cruise propulsor | 1x aft pusher propeller (H500A motor) |
| Power distribution | Solid-state contactors, per-channel isolation |
| Redundancy | N-1 lift rotor capability; dual battery busses |
| Transition logic | Automatic, speed- and altitude-triggered |

### REGULATORY PATHWAY

The A250 will be certified under 14 CFR Part 23 (powered-lift) via FAA AC 21.17-4, the same tailored pathway established for the CX300. Beta will leverage the existing issue papers, means of compliance, and certification artifacts from the CX300 program as the foundation for the A250 certification basis. Novel aspects for VTOL — specifically the distributed lift system and transition control laws — will require additional issue papers and special conditions addressing powered-lift-specific requirements.

### COMPETITIVE POSITIONING

The sequential CTOL-then-VTOL strategy differentiates Beta from competitors pursuing VTOL-first certification. By entering revenue service with the CX300 first, Beta generates operational data, customer validation, and cash flow while continuing VTOL development. The common-core architecture minimizes incremental VTOL development risk and cost.

---

*This document is an analytical assessment prepared from publicly available information. Last updated July 2026.*
