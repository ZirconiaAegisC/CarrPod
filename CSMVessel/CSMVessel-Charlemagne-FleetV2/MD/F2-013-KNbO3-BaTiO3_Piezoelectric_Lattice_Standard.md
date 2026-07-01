# F2-013 — KNbO3-BaTiO3 Piezoelectric Lattice Standard
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Material Specification

All fleet piezoelectric applications use KNbO₃–BaTiO₃ solid solution:

| Property | KNbO₃–BaTiO₃ | PZT-5H (prohibited) | KNbO₃–BaTiO₃ Advantage |
|---|---|---|---|
| d₃₃ (pC/N) | 285 | 289 | Equivalent performance |
| Curie temperature | 310°C | 193°C | +60% thermal margin |
| Density (g/cm³) | 4.85 | 7.75 | 38% lighter |
| RoHS/REACH | Compliant | RESTRICTED (Pb) | Fully compliant |
| In-house cost | $28–40/kg | $180–250/kg | 85% savings |

## 2. Bimorph Disc Design (Standard Element)

BERYL-reference AAJ element:
- Outer diameter: 50 mm
- Per-layer thickness: 3 mm × 2 layers = 6 mm total bimorph
- Electrode: ITO (indium tin oxide) sputtered, 200 nm
- ALD protective coating: ZrO₂ 100 nm (seawater hermeticity)
- Blocking force: F_b = d₃₃ × E × V = 285×10⁻¹² × 70×10⁹ × 150 V = 3.0 N
- Free deflection: δ = d₃₁ × V/t = 285×10⁻¹² × 150 / 0.003 = 14.25 µm
- Harvest power per element at 150 Hz: E_cycle × f = 1.1 mJ × 150 = 165 mW

## 3. In-House Synthesis (see F2-048)

Step 1: K₂CO₃ + Nb₂O₅ → 2KNbO₃ (solid-state, 1,000°C, 4 h, air)
Step 2: Cool, grind to <2 µm, blend with BaTiO₃ (target composition: 70% KNbO₃ + 30% BaTiO₃)
Step 3: Tape cast at 0.4 mm per layer, punch to 50 mm discs
Step 4: Stack 2 layers, laminate, co-fire at 1,250°C / 2 h
Step 5: Electrode sputtering (ITO): in-house PVD required or commercial service
Step 6: ALD ZrO₂ 100 nm on all exposed surfaces
Step 7: Polarization (poling): 3 kV/mm at 130°C for 30 min in silicone oil
Step 8: Incoming test: d₃₃ meter measurement, target 270–300 pC/N


---
*End F2-013 | CSMVessel-Charlemagne-FleetV2 | June 2026*
