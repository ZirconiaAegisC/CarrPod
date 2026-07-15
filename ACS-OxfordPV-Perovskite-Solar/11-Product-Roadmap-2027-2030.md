# 11 — PRODUCT & TECHNOLOGY ROADMAP: 2027–2030

## Strategic Vision

Oxford PV's technology roadmap is organized around a sequence of product generations that deliver progressive improvements in module efficiency, lifetime, and cost. The roadmap is driven by parallel advances in perovskite material stability, cell processing, interconnection technology, and manufacturing scale. The company's public roadmap commitments represent minimum thresholds; internal targets are typically more aggressive, with the public figures reflecting a risk-adjusted projection that accounts for the technical and manufacturing uncertainties inherent in bringing a new photovoltaic technology to maturity.

## Generation Progression Summary

| Generation | Target Launch | Module Efficiency | Warranted Lifetime | Key Technology Advance | Production Scale |
|------------|--------------|-------------------|-------------------|----------------------|-----------------|
| Gen 1 (Pilot) | 2022–2023 | 23–24% | 5 years | Proof of manufacturability | Pilot line (Oxford) |
| Gen 2 (Pre-Production) | 2023–2024 | 24–25% | 10 years | Process stabilization, customer sampling | Pilot line (Brandenburg) |
| Gen 3 (Commercial) | Q4 2024 | 26.2–26.8% | 15 years | First commercial shipments | 100 MW (Brandenburg) |
| Gen 4 | 2027 | 27.0–27.5% | 20 years | Enhanced passivation, improved perovskite stability, shingled option | 600 MW (Brandenburg) |
| Gen 5 | 2030 | 28.5–30.0% | 30 years | All-perovskite tandem variant, advanced encapsulation, full bifacial | 2 GW+ (multi-site) |

## Gen 4 Development Program (2025–2027)

The Gen 4 platform, scheduled for commercial introduction in 2027, targets a module efficiency of 27.0–27.5% with a 20-year warranted lifetime. The key technical advances required to achieve these targets include:

### Enhanced Perovskite Passivation

The Gen 3 perovskite composition achieves a quasi-Fermi level splitting (QFLS) of approximately 1.22 eV, corresponding to an implied V_oc of 1.22 V for the top cell alone. The practical V_oc of the tandem device is approximately 1.90 V, implying a total V_oc loss (including the silicon bottom cell and recombination junction losses) of approximately 0.25 V relative to the radiative limit.

Gen 4 targets a reduction in V_oc loss to approximately 0.18 V through:

**Surface Passivation**: Application of low-dimensional perovskite capping layers (2D Ruddlesden-Popper phases) at the perovskite/ETL and perovskite/HTL interfaces. These layered perovskites, with organic spacer cations such as phenethylammonium (PEA) or butylammonium (BA), form self-assembled passivation layers that reduce interface recombination velocity by one to two orders of magnitude relative to the untreated interface.

**Grain Boundary Passivation**: Incorporation of potassium and rubidium additives that preferentially segregate to grain boundaries during solvent annealing, passivating dangling bonds and suppressing non-radiative recombination at grain boundary sites. Time-resolved photoluminescence measurements indicate that optimized alkali metal passivation increases bulk carrier lifetime from approximately 1.5 μs to over 3 μs.

**Interface Dipole Engineering**: Introduction of molecular dipoles at the perovskite/charge-transport-layer interfaces through self-assembled monolayers with tailored dipole moments. The interfacial dipole modifies the band alignment between the perovskite and the charge transport layers, reducing the energetic offset that drives interface recombination. Carbazole-based SAMs with fluorinated and non-fluorinated tail groups provide tunable dipole moments in the range of 0.5–2.0 Debye.

### Thermal Stability Enhancement

Gen 4 perovskite compositions incorporate increased cesium content (15–20% on the A-site) and reduced methylammonium content (eliminated or below 5%) to improve intrinsic thermal stability. Accelerated aging tests at 85°C show that cesium-dominant compositions exhibit degradation rates approximately 3–5 times slower than formulations with significant methylammonium content, as measured by the rate of P_max loss under continuous thermal stress.

### Encapsulation Advancements

The Gen 4 encapsulation system introduces:

**Multi-Layer Edge Seal**: A composite edge seal comprising an inner butyl rubber layer (low WVTR, high compliance) and an outer polyisobutylene (PIB) layer (UV-resistant, mechanically robust). The composite structure provides redundancy: the inner barrier provides the primary moisture seal, while the outer barrier protects the inner seal from direct UV exposure and mechanical damage.

**Gettering Interlayer**: A thin (<50 μm) interlayer containing dispersed metal-oxide gettering particles (calcium oxide, barium oxide) that irreversibly react with any water vapor permeating through the encapsulant or edge seal before it reaches the perovskite layer. Accelerated damp heat testing of modules incorporating gettering interlayers shows no detectable moisture-related degradation after 3000 hours at 85°C/85% RH.

## Gen 5 Vision (2030)

The Gen 5 platform, targeted for 2030, represents a step change in both efficiency and lifetime. Key technology elements include:

### All-Perovskite Tandem Variant

Building on the perovskite-silicon tandem architecture, Oxford PV's R&D program includes development of an all-perovskite tandem configuration in which both the wide-bandgap top cell (approximately 1.75 eV) and narrow-bandgap bottom cell (approximately 1.25 eV) are perovskite absorbers. This configuration eliminates the silicon bottom cell entirely, enabling:

- **Higher theoretical efficiency**: The all-perovskite tandem can approach 35% theoretical efficiency under AM1.5G, compared to approximately 32% for the perovskite-silicon tandem.
- **Lower materials cost**: Elimination of the silicon wafer, which constitutes 45–55% of the tandem module BOM.
- **Monolithic thin-film manufacturing**: Both sub-cells are deposited by vacuum or solution processes, enabling a fully integrated manufacturing line on a single substrate platform (glass or flexible metal foil).

The narrow-bandgap bottom cell is based on tin-lead mixed perovskite compositions (e.g., (FASnI₃)₀.₆(MAPbI₃)₀.₄), which achieve bandgaps in the 1.20–1.25 eV range. Tin-lead perovskites present unique stability challenges, particularly oxidation of Sn²⁺ to Sn⁴⁺, which introduces p-type doping and increases recombination. Oxford PV's approach to tin-lead stabilization includes:

- Reducing agents (tin fluoride, metallic tin powder) in the precursor solution to suppress Sn²⁺ oxidation.
- Compositional engineering to minimize the thermodynamic driving force for phase separation.
- Barrier encapsulation with oxygen transmission rates below 10⁻⁵ cm³/m²/day, approximately two orders of magnitude more stringent than the requirements for lead-only perovskites.

### 30-Year Lifetime

Achieving a 30-year warranted lifetime requires reducing the annual degradation rate to approximately 0.25% per year or below. This degradation rate falls within the range demonstrated by high-quality silicon modules over multi-decade field exposures, but extends beyond the current demonstrated capability of any perovskite-based photovoltaic product. The Gen 5 stability program includes:

- **Intrinsic stability**: Perovskite compositions engineered for thermodynamic stability at operating temperatures up to 85°C, with compositional phase diagrams mapped by high-throughput combinatorial synthesis and in-situ X-ray diffraction.
- **Barrier technology**: Thin-film inorganic diffusion barriers (alumina/silica nanolaminates deposited by atomic layer deposition) integrated directly into the cell stack, providing a primary moisture and oxygen barrier at the cell level as redundancy to the module-level encapsulation.
- **Accelerated testing**: Development of combined-stress accelerated test protocols that more accurately reproduce field-relevant degradation modes, including simultaneous application of illumination, temperature, humidity, and electrical bias.

## References

- Oxford PV. "Technology Roadmap: 2025–2035." Investor Presentation, Q1 2025.
- Jiang, Q. et al. "Compositional texture engineering for highly stable wide-bandgap perovskite solar cells." *Science* 378, 1295–1300 (2022).
- Lin, R. et al. "All-perovskite tandem solar cells with 3D/3D bilayer perovskite heterojunction." *Nature* 620, 994–1000 (2023).
- Prasanna, R. et al. "Design of low bandgap tin–lead halide perovskite solar cells to achieve thermal, atmospheric, and operational stability." *Nature Energy* 4, 939–947 (2019).
