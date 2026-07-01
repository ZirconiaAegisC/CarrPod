# F2-017 — MXene Ti3C2Tx EMI Shielding Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Material Properties

MXene Ti₃C₂Tₓ (where Tₓ = surface functional groups OH, O, F):
- EMI SE at 1 GHz (50 µm thickness): **92 dB** (ACS Appl. Mater. Interfaces 2025)
- Comparison: copper foil 50 µm → ~45 dB; silver nanowire mesh → ~35 dB
- Solution-processable: spray, dip-coat, or vacuum filter deposition
- Flexibility: survives 1,000 bend cycles at 3 mm radius without SE degradation
- Oxidation susceptibility: must protect with PVDF-TrFE topcoat within 48h of deposition

## 2. Tile Pattern (Critical for GIC Immunity)

MXene is electrically conductive (σ ≈ 10,000 S/cm in-plane).
If applied as a continuous film, it would form a conducting loop → GIC coupling.

**Solution: Discontinuous 5×5 cm tile pattern with 1 mm gaps.**

Physics explanation:
- At GHz frequencies: each tile acts as an isolated resonant absorber → SE = 92 dB ✓
- At DC (GIC frequencies): no macroscopic conducting path → zero induced current ✓
- The 1 mm gap prevents macroscopic currents while tiles are sub-wavelength at GHz

This is the critical innovation enabling MXene use in a GIC-immune vehicle.

## 3. Application Protocol

1. Prepare surface: solvent wipe (isopropanol), light mechanical abrasion (P400)
2. Apply PEEK CF40 stencil mask (5×5 cm openings, 1 mm gaps)
3. Spray Ti₃C₂Tₓ colloidal suspension (1.5 wt% in 50:50 water/DMF)
4. Three spray passes, 120 µm wet each → ~50 µm dry total
5. Remove stencil while still wet
6. Anneal at 80°C / 2 h to improve conductivity and adhesion
7. Apply PVDF-TrFE protective topcoat (100 µm) within 24 h to prevent oxidation
8. SE verification (GR/IEC 61000-4-3): target ≥85 dB at 1 GHz

## 4. In-House Synthesis Route (see F2-048)

Ti₃AlC₂ MAX Phase → LiF/HCl selective etching → multilayer Ti₃C₂Tₓ → bath sonication → delamination
Cost comparison: commercial $1,500–2,500/kg vs in-house $55–75/kg (96–97% savings)

Investment: ~$75,000 for etching reactor, sonication bath, filtration (see F2-033).


---
*End F2-017 | CSMVessel-Charlemagne-FleetV2 | June 2026*
