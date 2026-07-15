# FAA Certification Strategy

## Certification Philosophy

Beta Technologies' certification strategy is built on a sequenced, platform-leveraging approach
that prioritizes the simplest configuration first (CTOL) to establish a certification basis and
regulatory precedent before pursuing more complex configurations (VTOL, military variants, hybrid
systems). This strategy maximizes learning transfer and minimizes concurrent regulatory uncertainty.

## Certification Pathway Overview

```
H500A Electric Engine         ALIA CX300 CTOL (Part 23)       ALIA A250 VTOL (~2028)
(FAA Certified H1 2026)  →    (Type Certificate H2 2027)  →    (Type Certificate)
                                         ↓
                               MV250 Military Variant
                               (Leverages CX300 cert basis)
```

## H500A Electric Engine Certification (H1 2026)

### Certification Approach
The H500A is certified as a standalone propulsion article — analogous to a turbine engine
under Part 33 — establishing the first FAA-approved aviation electric engine. Key elements:

- **Novel Certification Basis:** Since no existing FAA standards cover aviation electric
  engines, Beta worked with the FAA to develop a custom certification basis through the
  issue paper and special condition processes.
- **85,000+ Hour Test Program:** Extensive ground and flight testing exceeding standard
  durability and reliability requirements for conventional propulsion articles.
- **Key Certification Areas:** High-voltage electrical safety, battery integration interfaces,
  electromagnetic compatibility (EMC/EMI), thermal runaway containment, lightning protection
  (direct and indirect effects), software certification (DO-178C DAL A/B).

### Strategic Value
- Creates a reusable certification package for all subsequent Beta aircraft programs
- Establishes H500A as an FAA-certified component for third-party airframe OEMs (Eve Air Mobility)
- Provides regulatory precedent for future electric engine certification programs industry-wide
- De-risks CX300 and A250 certification by resolving propulsion certification independent of airframe

## ALIA CX300 CTOL Certification — Part 23 (H2 2027)

### Regulatory Framework
| Element | Detail |
|---------|--------|
| Certification Basis | 14 CFR Part 23, Amendment 64 (performance-based standards) |
| FAA Advisory Circular | AC 21.17-4 (accelerated certification for novel aircraft types) |
| Special Conditions | Electric propulsion, high-voltage systems, battery safety |
| Equivalent Level of Safety (ELOS) | Findings for areas where electric aircraft differ from conventional |
| Issue Papers | Resolving novel certification questions with FAA policy offices |

### AC 21.17-4 Accelerated Pathway

FAA Advisory Circular 21.17-4 provides a framework for type certification of aircraft with
novel or unusual design features — precisely the category electric aircraft occupy. Key
elements Beta leverages:

- **Performance-Based Standards:** Part 23 Amendment 64 uses performance-based rather than
  prescriptive standards, allowing Beta to demonstrate compliance through analysis, ground
  test, and flight test rather than meeting fixed design specifications.
- **Issue Paper Process:** Formal mechanism for resolving certification questions where existing
  regulations do not adequately address novel technology — Beta has worked through issue papers
  covering battery thermal runaway, high-voltage electrical system safety, electric propulsion
  reliability, and noise certification for electric aircraft.
- **Project-Specific Certification Plan (PSCP):** Customized certification plan tailored to
  the CX300's specific design features, agreed with the FAA Aircraft Certification Office (ACO).
- **Streamlined Conformity:** Risk-based conformity inspection approach that focuses FAA
  resources on novel or safety-critical items while accepting Beta's showing of compliance
  for conventional elements (airframe structure, flight controls, etc.).

### Certification Phases
| Phase | Activity | Timeline |
|-------|----------|----------|
| Phase 1: Certification Basis | G-1 Issue Paper, special conditions, ELOS | 2024 |
| Phase 2: Means of Compliance | Define how each regulation is met (test, analysis, inspection) | 2024–2025 |
| Phase 3: Compliance Data Generation | Ground tests, flight tests, analysis reports | 2025–2027 |
| Phase 4: Conformity Inspections | FAA verification that test articles conform to type design | 2025–2027 |
| Phase 5: Flight Test (TIA) | FAA flight test for type inspection authorization | 2026–2027 |
| Phase 6: Final Compliance | Submission of all compliance data; FAA review | H2 2027 |
| Phase 7: Type Certificate | FAA issues Part 23 Type Certificate | H2 2027 |

### Unique Certification Challenges
| Challenge | Beta Approach |
|-----------|---------------|
| Battery Thermal Runaway | Containment design, detection systems, emergency procedures, special conditions |
| High-Voltage System Safety | Insulation, isolation monitoring, automatic disconnect, crew protection |
| Electric Propulsion Reliability | H500A test program (85K+ hrs), system redundancy, fail-operational design |
| EMI/EMC with Composite Airframe | DO-160 testing, shielding, bonding, lightning protection integration |
| Noise Certification | Community noise measurement (<65 dBA), new noise standards adaptation |
| Energy Reserve Rules | Equivalent to fuel reserve requirements; battery reserve at destination |
| Maintenance Program | MSG-3 analysis for electric aircraft; new inspection intervals and tasks |

## ALIA A250 VTOL Certification (~2028)

### Additional Complexity vs. CX300
The A250 VTOL adds certification challenges beyond the CX300 baseline:

- **Powered-Lift Category:** The A250 may be certified under existing Part 23 (if amended),
  Part 27 (rotorcraft), a new powered-lift special class, or the emerging SFAR for powered-lift
- **Transition Flight Regime:** Certification must address the transition between vertical and
  wing-borne flight — a regime with no existing civilian certification standards
- **Distributed Propulsion Redundancy:** Safety analysis must demonstrate continued safe flight
  and landing after failure of any lift or cruise motor
- **VTOL-Specific Flight Envelope:** Hover performance, VTOL climb/descent, balked landing,
  autorotation equivalent for electric VTOL

### Leveraging CX300 Certification
| Area | CX300 Credit Applicable to A250 |
|------|-------------------------------|
| H500A Engine | Directly applicable (same certified engine) |
| Basic Airframe Structure | Largely applicable (same blended-wing-body design) |
| Fly-by-Wire Architecture | Partially applicable (additional VTOL control laws) |
| Avionics | Largely applicable (VTOL-specific displays and warnings added) |
| Battery System | Partially applicable (VTOL energy demands are higher/different) |
| High-Voltage Electrical System | Largely applicable |
| EMI/EMC | Partially applicable (additional motor configurations) |
| Software (DO-178C) | Partially applicable (additional VTOL control software) |

## MV250 Military Certification

The MV250 military variant may pursue:
- Military airworthiness certification (MIL-HDBK-516) leveraging FAA Part 23 data
- FAA special airworthiness certificate (experimental or restricted category)
- Dual certification (FAA + military) for civil-registered military operations

## Certification Resources

Beta maintains a dedicated certification and airworthiness organization including:
- Designated Engineering Representatives (DERs) — company and consultant
- FAA Organization Designation Authorization (ODA) — in development or delegated
- Certification engineers with FAA, EASA, and military airworthiness experience
- Flight test pilots and engineers with certification flight test backgrounds
- Continued airworthiness and maintenance program development staff
