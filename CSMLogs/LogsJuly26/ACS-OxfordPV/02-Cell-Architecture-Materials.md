# 02 — CELL ARCHITECTURE & MATERIALS ENGINEERING

## Overview

The Oxford PV tandem cell architecture integrates a perovskite top sub-cell with a crystalline silicon bottom sub-cell in a monolithically integrated, two-terminal configuration. This design minimizes interconnection complexity at the module level and leverages existing silicon cell metallization and interconnection infrastructure. The two-terminal architecture is distinguished from four-terminal configurations, which require independent electrical connections to each sub-cell and impose more complex module-level power electronics.

## Layer Stack Description

The complete tandem cell stack comprises the following functional layers, enumerated from the light-incident (top) surface to the rear contact:

1. **Anti-Reflection Coating (ARC)** — A multi-layer dielectric stack, typically magnesium fluoride over silicon nitride, optimized for broadband transmission across 300–1200 nm. The ARC is textured to reduce front-surface reflection losses to below 2% weighted average.

2. **Front Transparent Conductive Oxide (TCO)** — Indium tin oxide (ITO) or aluminum-doped zinc oxide (AZO), deposited by DC or RF magnetron sputtering. The front TCO serves dual functions as the top electrode and as an optical spacer layer that contributes to the overall anti-reflection design.

3. **Electron Transport Layer (ETL)** — A thin (20–50 nm) layer of tin oxide (SnO₂) or fullerene (C₆₀) derivatives deposited by chemical bath deposition, atomic layer deposition, or thermal evaporation. The ETL selectively extracts electrons from the perovskite absorber while blocking hole transport, a critical requirement for high fill factor and open-circuit voltage.

4. **Perovskite Absorber Layer** — The photoactive layer, 450–550 nm thick, with composition tuned to a bandgap of 1.63–1.68 eV for current-matching with the silicon bottom cell. The multi-cation, mixed-halide formulation is deposited by hybrid chemical vapor deposition (HCVD) or co-evaporation, followed by controlled solvent annealing to achieve large grain sizes exceeding 1 μm.

5. **Hole Transport Layer (HTL)** — A self-assembled monolayer (SAM) of carbazole-based phosphonic acid derivatives or a thin spiro-OMeTAD layer, designed to extract holes efficiently while providing a high work function interface for minimizing voltage losses at the perovskite/HTL boundary.

6. **Recombination Junction** — The critical interface between the perovskite top cell and silicon bottom cell. Oxford PV employs a tunnel junction based on a thin (sub-10 nm) transparent conductive oxide interlayer, typically ITO or indium zinc oxide (IZO), deposited by sputtering. This layer must exhibit high lateral conductivity, low optical absorption, and ohmic contact to both the HTL and the silicon emitter.

7. **Silicon Bottom Cell** — Either an n-type HJT cell with amorphous silicon passivation layers or an n-type TOPCon cell with ultra-thin tunnel oxide and doped polysilicon contacts. The silicon cell provides approximately 60–65% of the total tandem current under AM1.5G illumination.

8. **Rear Contact** — Full-area aluminum or silver metallization with local back-surface field (LBSF) contact openings, or a rear TCO/Ag stack for bifacial configurations.

## Critical Materials Selection

### Perovskite Precursor Chemistry

The perovskite precursor solution comprises lead iodide (PbI₂), lead bromide (PbBr₂), formamidinium iodide (FAI), methylammonium bromide (MABr), and cesium iodide (CsI) dissolved in a mixed solvent system of dimethylformamide (DMF) and dimethylsulfoxide (DMSO). The precise stoichiometric ratios and solvent composition are proprietary. Key considerations include:

- **PbI₂:FAI ratio** — Slight PbI₂ excess (1–5 mol%) has been shown to passivate grain boundaries and suppress non-radiative recombination, contributing to higher open-circuit voltages.
- **Cs content** — Typically 5–15 mol% on the A-site, sufficient to suppress the yellow-phase δ-FAPbI₃ polymorph without inducing phase segregation under illumination.
- **Br:I ratio** — Determines the bandgap; Br contents of 15–25% on the halide site yield bandgaps in the desired 1.63–1.68 eV range.

### Transparent Conductive Oxides

The TCO layers are subject to stringent requirements: sheet resistance below 10 Ω/sq, optical transparency exceeding 85% across the visible spectrum, and compatibility with the thermal budget of the underlying perovskite layer (maximum processing temperature ~150°C post-perovskite deposition). ITO remains the material of choice, though Oxford PV has explored AZO and hydrogen-doped indium oxide (IO:H) for cost reduction and improved near-infrared transparency.

### Encapsulation Materials

Perovskite solar cells are sensitive to moisture, oxygen, and elevated temperatures. Oxford PV's encapsulation system employs:

- **Edge seal**: Butyl rubber or polyisobutylene (PIB) with a water vapor transmission rate (WVTR) below 10⁻⁴ g/m²/day.
- **Front and back glass**: Low-iron tempered soda-lime glass, 2.0–3.2 mm thickness, with UV-blocking interlayers.
- **Lamination**: Thermoplastic polyolefin (TPO) or ionomer encapsulants with integral UV stabilizers and desiccant fillers.

## Manufacturing Process Flow

1. **Silicon cell receipt and inspection** — Incoming HJT or TOPCon cells are inspected for electrical performance, visual defects, and dimensional conformity.
2. **Surface preparation** — UV-ozone or plasma cleaning to remove organic contaminants from the silicon cell surface.
3. **Recombination junction deposition** — Sputtering of the TCO tunnel junction layer.
4. **HTL deposition** — Solution-processed SAM formation or thermal evaporation of the hole transport layer.
5. **Perovskite deposition** — Vacuum-based co-evaporation or HCVD, with in-situ optical monitoring for thickness and composition control.
6. **Solvent annealing** — Controlled atmosphere annealing to promote grain growth and remove residual solvents.
7. **ETL deposition** — Solution-processed or vacuum-deposited electron transport layer.
8. **Front TCO deposition** — Sputtering of the top transparent electrode.
9. **ARC deposition** — Thermal evaporation of the anti-reflection coating.
10. **Edge deletion and isolation** — Laser scribing to define cell boundaries and provide electrical isolation.
11. **Module assembly** — Stringing, lamination, framing, and junction box attachment.
12. **End-of-line testing** — IV characterization under AM1.5G spectrum, electroluminescence imaging, and hipot testing.

## References

- Oxford PV. "Manufacturing Process Specification: Tandem Cell Production." Internal Document, 2025.
- Jiang, Q. et al. "Surface passivation of perovskite film for efficient solar cells." *Nature Photonics* 13, 460–466 (2019).
- Al-Ashouri, A. et al. "Monolithic perovskite/silicon tandem solar cell with >29% efficiency by enhanced hole extraction." *Science* 370, 1300–1309 (2020).
