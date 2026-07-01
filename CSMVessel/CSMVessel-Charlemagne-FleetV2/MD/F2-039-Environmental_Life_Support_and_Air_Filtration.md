# F2-039 — Environmental Life Support and Air Filtration
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Life Support Philosophy

The Charlemagne Fleet is designed to support occupants in fully sealed operation for:
- **Amphibious submersion:** up to 30 m depth capability
- **CBRN event (wildfire):** toxic smoke, particulates, chemical agents
- **Carrington event:** potential atmospheric chemistry changes during severe storms
- **Emergency:**  general utility (not specifically threat-designed)

## 2. Air Processing System

### O₂ Supply
- BFRP composite cylinder, 300 bar working pressure (same BFRP as leg tubes)
- Fill valve: ZrO₂ ceramic + PEEK housings
- Pressure regulator: PEEK + ceramic internals, no metallic valve bodies where avoidable
- O₂ capacity: See table in F2-027

### CO₂ Scrubbing
- LiOH (lithium hydroxide monohydrate): 2LiOH + CO₂ → Li₂CO₃ + H₂O
- Absorption capacity: ~0.9 g CO₂ per g LiOH
- Cartridge format: BFRP cylinder, pull-to-activate
- No electronics required: purely chemical passive reaction

### HEPA Filtration (for powered/non-submerged operation)
- Filter media: Basalt ceramic fiber (service temperature 800°C — survives external fires)
- Efficiency: HEPA grade (>99.97% at 0.3 µm particle)
- From CSMFAB000000000014 range hood design: same material, scaled for BERYL cabin
- Particulate protection: wildfire smoke (2.5 µm PM2.5), industrial particulates

### Thermal Comfort
- Cooling: PVDF-TrFE-CFE electrocaloric film (from CSMFAB000000000004 refrigerator)
  - COP > 4 at 10°C differential (vs Peltier COP 0.3–0.5)
  - Zero refrigerant, no compressor, no plumbing
- Heating: KNbO₃–BaTiO₃ ceramic resistive panel (same as F2-013, operating as load)
  - Safe at any voltage, no open element, ceramic surface
- Fan: KNbO₃–BaTiO₃ bimorph piezo fan (from CSMFAB000000000014)
  - Zero EMI output (no AC induction motor)
  - Zero GIC coupling (no copper windings)


---
*End F2-039 | CSMVessel-Charlemagne-FleetV2 | June 2026*
