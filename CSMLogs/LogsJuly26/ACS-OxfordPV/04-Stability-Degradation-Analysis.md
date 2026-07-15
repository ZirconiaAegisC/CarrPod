# 04 — STABILITY ENGINEERING & DEGRADATION ANALYSIS

## Fundamental Stability Challenges

The commercialization of perovskite photovoltaics has been gated historically by stability concerns. Metal-halide perovskites are susceptible to degradation from moisture, oxygen, thermal stress, illumination, and electric fields — often in synergistic combinations. Oxford PV's achievement of a 15-year product lifetime on its Gen 3 platform represents a breakthrough in translating laboratory stability advances into industrially relevant durability.

## Intrinsic Degradation Pathways

### Thermal Degradation

At elevated temperatures (above approximately 85°C for extended durations), the perovskite crystal lattice undergoes several competing degradation processes:

**Phase Segregation**: Mixed-halide perovskites containing both iodide and bromide can undergo light-induced halide segregation, wherein iodide-rich and bromide-rich domains form under illumination. This process, driven by polaron-induced strain gradients, creates low-bandgap iodide-rich regions that act as recombination sinks and voltage-degrading current pathways. Oxford PV addresses this through:

- Cesium alloying at the A-site, which increases the activation energy for halide migration by stiffening the lattice.
- Potassium and rubidium passivation at grain boundaries, reducing vacancy-mediated halide diffusion pathways.
- Optimized Br:I ratios that minimize the thermodynamic driving force for segregation.

**Decomposition to Precursor Phases**: At temperatures exceeding 150°C, FAPbI₃ can decompose into PbI₂ and FAI, with the volatile FAI component desorbing from the film. The multi-cation formulation employed by Oxford PV raises the decomposition onset temperature to approximately 180°C, well above the thermal budget of module lamination (typically 140–150°C peak temperature).

### Moisture-Induced Degradation

Water ingress initiates a cascade of degradation processes beginning with hydration of the perovskite surface, progressing to bulk hydration, and ultimately resulting in irreversible decomposition to PbI₂, volatile organic halides, and hydrated lead species. Oxford PV addresses this through:

- **Edge seal technology**: A butyl-rubber-based edge seal with WVTR below 10⁻⁴ g/m²/day, applied at the module perimeter with a width of 12–15 mm.
- **Desiccant-loaded encapsulant**: Thermoplastic polyolefin encapsulant with integrated zeolite desiccant fillers that scavenge any water vapor permeating through the front and back glass or edge seal.
- **Intrinsic moisture resistance**: The cesium-rich perovskite composition exhibits slower hydration kinetics than methylammonium-rich formulations, providing an additional intrinsic defense.

### Photo-Induced Degradation

Under continuous illumination, perovskites can undergo:

**Photo-demethylation**: UV-driven cleavage of the methylammonium cation at the C-N bond, releasing methylamine and leaving an iodide vacancy. The formamidinium-rich and cesium-rich composition reduces the density of vulnerable C-N bonds.

**Ion Migration**: Mobile halide ions drift under the built-in electric field of the junction, accumulating at interfaces and creating compensating space-charge regions that reduce the effective built-in field and increase recombination. Oxford PV's perovskite composition engineering targets a reduction in halide vacancy concentration through stoichiometric control (slight PbI₂ excess) and grain boundary passivation.

**Defect Generation**: Continuous illumination can generate metastable defect states through photochemical reactions at grain boundaries and interfaces. These defects are partially annealable through diurnal dark recovery, providing a self-healing mechanism that contributes to long-term operational stability.

## Accelerated Lifetime Testing Regime

Oxford PV's qualification and lifetime testing program exceeds standard IEC 61215 requirements:

| Test | Standard | Oxford PV Protocol | Pass Criterion |
|------|----------|-------------------|----------------|
| Damp heat | 1000h, 85°C/85% RH | 2000h | <5% P_max degradation |
| Thermal cycling | 200 cycles, -40°C to +85°C | 400 cycles | <5% P_max degradation |
| Humidity freeze | 10 cycles, -40°C to +85°C/85% RH | 20 cycles | <5% P_max degradation |
| UV preconditioning | 15 kWh/m² (UV range) | 60 kWh/m² | <3% P_max degradation |
| Light soaking | Not specified | 1000h, 1 sun, MPP tracking | <3% P_max degradation |
| Combined stress | Not specified | 85°C, MPP, 1000h | <5% P_max degradation |

## Lifetime Modeling

Oxford PV has developed a physics-based degradation model that maps accelerated test results to field lifetimes. The model incorporates:

- **Arrhenius thermal acceleration**: Activation energies of 0.8–1.2 eV for the dominant degradation modes, derived from temperature-dependent degradation rate measurements across the range 25–95°C.
- **Peck moisture model**: Humidity acceleration factor with an exponent of 2.0–3.0, calibrated from damp heat tests at multiple RH levels.
- **Spectral acceleration**: UV dose accumulation modeled from site-specific spectral irradiance data (SMARTS2 model).
- **Dark recovery**: Time-dependent partial recovery of photo-degradation during nocturnal periods, modeled as a first-order annealing process.

The model projects a median lifetime of 15–18 years for Gen 3 modules deployed in temperate climates, consistent with the 15-year warranted lifetime announced in late 2024. Projected Gen 4 modules incorporate enhanced passivation and barrier layers that extend the modeled median lifetime to 22–25 years, in line with the 2027 target of 20-year warranted lifetime.

## Field Validation Program

As of Q2 2025, Oxford PV operates field test installations at five locations:

1. **Oxfordshire, UK** — Temperate maritime climate; 18 months operational data; no significant degradation observed.
2. **Brandenburg, Germany** — Continental climate; 12 months operational data; seasonal temperature extremes provide accelerated thermal cycling data.
3. **Arizona, USA** — Hot-dry desert climate; 9 months operational data; UV and thermal stress testing.
4. **Singapore** — Hot-humid tropical climate; 6 months operational data; moisture ingress stress testing (commissioned Q4 2024).
5. **Negev Desert, Israel** — Arid high-irradiance climate; 6 months operational data; combined UV/thermal stress.

Preliminary field data from the Oxfordshire and Brandenburg sites indicate degradation rates below 0.5% per year for the majority population, consistent with model projections. A small sub-population (<2% of installed modules) has exhibited accelerated degradation linked to delamination at the encapsulant/perovskite interface, attributable to a known manufacturing process deviation that has since been corrected.

## References

- Boyd, C.C. et al. "Understanding Degradation Mechanisms and Improving Stability of Perovskite Photovoltaics." *Chemical Reviews* 120, 775–835 (2020).
- Oxford PV. "Accelerated Lifetime Testing Report: Gen 3 Platform." Confidential, Q3 2024.
- Khenkin, M.V. et al. "Consensus statement for stability assessment and reporting for perovskite photovoltaics based on ISOS procedures." *Nature Energy* 5, 35–49 (2020).
- IEC 61215-2:2021. "Terrestrial photovoltaic (PV) modules — Design qualification and type approval."
