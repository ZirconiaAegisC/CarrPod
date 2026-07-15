# Proprietary MEA Technology — Membrane Electrode Assembly

## Overview
The membrane electrode assembly (MEA) is the heart of Electric Hydrogen's PEM
electrolyzer technology. It is where water is split into hydrogen and oxygen through
electrochemical reactions, and it largely determines system efficiency, durability,
and cost. EH2's MEA technology represents the company's primary intellectual property
and competitive moat.

## MEA Structure
A PEM electrolyzer MEA consists of three primary layers bonded together:

1. **Proton Exchange Membrane (PEM)**: A perfluorosulfonic acid (PFSA) membrane
   (typically Nafion™ or similar chemistry) that conducts protons from the anode to
   the cathode while blocking gas crossover.

2. **Anode Catalyst Layer**: Iridium-based catalyst where the oxygen evolution
   reaction (OER) occurs. This is the primary cost driver due to iridium scarcity.

3. **Cathode Catalyst Layer**: Platinum-based catalyst where the hydrogen evolution
   reaction (HER) occurs. Platinum loading is typically lower than iridium loading.

Additional components include porous transport layers (PTLs) — typically titanium
on the anode side and carbon paper on the cathode side — that distribute water,
remove gases, and conduct electrons.

## Iridium Reduction Strategy
Iridium is one of the rarest elements in the Earth's crust, with annual global
production of approximately 7-8 tonnes. At traditional loading levels of 1-2 mg/cm²,
a single 100MW electrolyzer system would consume a prohibitive fraction of global
iridium supply.

Electric Hydrogen's approach to iridium reduction includes:

### Catalyst Design
- **Core-shell nanoparticles**: Iridium shells over non-precious metal cores maximize
  surface area utilization while minimizing total iridium mass.
- **Mixed metal oxides**: Iridium oxide combined with stabilizing oxides (e.g., Ta₂O₅,
  TiO₂) to improve dispersion and durability.
- **Support materials**: High-surface-area conductive supports that enable lower
  catalyst loading without sacrificing performance.

### Manufacturing Process
- **Direct membrane deposition**: Catalyst layers deposited directly onto the membrane
  rather than onto the PTL, improving interfacial contact and reducing catalyst waste.
- **Slot-die coating**: Continuous roll-to-roll manufacturing compatible with high-
  volume production at the Devens gigafactory.
- **Quality control**: In-line optical inspection and electrochemical testing at
  multiple process steps.

### Performance Targets
| Parameter                  | Legacy PEM | EH2 Target |
|----------------------------|------------|------------|
| Ir loading (anode)         | 1.5-2.0    | <0.3       |
| Ir loading (cathode)       | 0.3-0.5    | <0.1       |
| Current density @ 1.8V     | 1.5-2.0    | >2.5       |
| Degradation rate           | 5-10 µV/hr | <3 µV/hr   |
| Operating temperature      | 50-70°C    | 60-80°C    |

*Loading units: mg/cm²; current density: A/cm²*

## Durability Considerations
MEAs degrade through several mechanisms:

- **Membrane thinning**: Chemical and mechanical degradation of the PFSA membrane
  leading to increased gas crossover and potential safety issues.
- **Catalyst dissolution**: Iridium and platinum dissolution and migration, accelerated
  by potential cycling during intermittent renewable operation.
- **PTL passivation**: Titanium oxidation at the anode PTL increasing contact
  resistance over time.

EH2's MEA design addresses these through membrane reinforcement, stabilized catalyst
formulations, and protective coatings on titanium components.

## Manufacturing Economies
The Devens gigafactory is designed to produce MEAs at a rate sufficient for over 1.2 GW
of electrolyzer capacity annually. Continuous roll-to-roll manufacturing, automated
quality control, and vertical integration of catalyst synthesis are key cost drivers
that differentiate EH2 from competitors who purchase MEAs from third-party suppliers.

## Intellectual Property
Electric Hydrogen holds multiple patents and trade secrets covering catalyst
compositions, MEA architecture, and manufacturing processes. The company's IP
strategy combines defensive patent filings with carefully guarded trade secrets
for manufacturing know-how and catalyst recipes.

## References
- U.S. Department of Energy, Hydrogen and Fuel Cell Technologies Office
- Carmo, M. et al. "A comprehensive review on PEM water electrolysis." Int. J.
  Hydrogen Energy (2013)
- Electric Hydrogen patent filings and technical presentations
