# F2-004 — Fleet Architecture: The Dielectric Citadel Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Mandatory Material Classes

The Dielectric Citadel specification requires that every component in a structural or
occupant-facing role satisfy ALL of the following simultaneously:

| Criterion | Threshold | Test Method |
|---|---|---|
| Electrical Resistivity | ρ ≥ 10¹⁰ Ω·m, DC to 40 GHz | ASTM D257, 1 kV/60s |
| Ferromagnetic Content | Zero iron, nickel, cobalt in structure | XRF + SQUID magnetometry |
| Thermal Stability | Service temperature ≥ 300°C minimum | TGA/DSC per ASTM E1131 |
| Saltwater Immunity | Zero galvanic corrosion in σ=5.5 S/m | ASTM B117, 500-hour salt spray |
| Impact Resistance | Structural survivability at 50 J/cm² | ASTM D256, Charpy notch |

### Master Materials Table

| Component Class | Primary Material | ρ (Ω·m) | T_melt/service (°C) | Mass density (g/cm³) | Fleet Reference |
|---|---|---|---|---|---|
| Main structural shell | BFRP/Elium® | >10¹² | Tg=110°C shell, blade 3245°C | 1.85 | F2-014 |
| Battery vault | ZrB₂–SiC (12 vol%) | >10¹⁰ | 3245 | 6.09 | F2-015 |
| Cockpit dome | ALON (Al₂₃O₂₇N₅) | >10¹² | 2150 | 3.69 | F2-009 |
| Hub motor bearings | Si₃N₄ (β-phase) | >10¹² | 1850 decomp. | 3.21 | F2-016 |
| AAJ bellows | PEEK/polyimide | >10¹⁵ | 260°C cont. PEEK | 1.30 | F2-008 |
| Fasteners (all) | 3Y-TZP ZrO₂ | >10¹² | 2716 | 6.05 | F2-007 |
| Hub motor housing | PEEK CF40 | >10¹⁰ | 260°C | 1.62 | F2-007 |
| Signal wiring | PMMA optical fiber | n/a (photons) | 85°C service | 1.19 | F2-019 |
| Power wiring jacket | PTFE + PEEK LSZH | >10¹⁵ | 260°C PEEK | 2.10 | F2-007 |
| EMI layer | MXene Ti₃C₂Tₓ 50 µm | — (SE=92 dB) | 150°C safe | <0.01 added | F2-017 |
| Thermal break | Polyimide-silica aerogel | >10¹⁴ | 650°C | 0.18 | F2-007 |
| Exterior coating | YInMn Blue + CsPbBr₃ QD | >10¹² | 1200°C glaze cure | — | F2-018 |

## 2. Geometric Scaling Architecture

The BERYL (4-seat) is the **reference platform** at scale factor sf=1.0. All other vessels
are geometrically derived by multiplying reference dimensions by their sf:

```
dimension_vessel = dimension_BERYL × sf
area_vessel = area_BERYL × sf²
volume_vessel = volume_BERYL × sf³
```

**Mechanical property scaling** (key relationships per Vol F2-005):
- AAJ off-state stiffness: k_off(sf) = 280 kN/m × sf²
- AAJ max stiffness: k_max(sf) = 2,800 kN/m × sf²
- Piezo elements per AAJ: n(sf) = round(96 × sf^1.5)
- AAJ bellows wall thickness (minimum): t_wall = max(3 mm, 8 mm × sf)
- Hub motor power each: P(sf) = 12 kW × sf^2.3 (empirical power-weight law)

**Fleet-level derived specifications:**

| Parameter | TOURMALINE sf=0.35 | OBSIDIAN sf=0.55 | BERYL sf=1.0 | AMETHYST sf=1.5 | RHODONITE sf=3.2 |
|---|---|---|---|---|---|
| Length | 1.12 m | 1.76 m | 3.20 m | 4.80 m | 10.24 m |
| Width | 0.74 m | 1.16 m | 2.10 m | 3.15 m | 6.72 m |
| Height | 0.63 m | 0.99 m | 1.80 m | 2.70 m | 5.76 m |
| Vehicle mass | 42 kg | 150 kg | 780 kg | 1,900 kg | 9,200 kg |
| Hub count | 6 | 6 | 6 | 8 | 10 |
| Hub power ea. | 150 W | 650 W | 12 kW | 22 kW | 95 kW |
| Battery (kWh) | 1.92 | 8.5 | 28 | 58 | 185 |
| Battery voltage | 48 V | 96 V | 400 V | 400 V | 800 V |
| AAJ k_off | 34 kN/m | 85 kN/m | 280 kN/m | 630 kN/m | 2,867 kN/m |
| AAJ n_piezo | 20 ea | 39 ea | 96 ea | 177 ea | 570 ea |
| ALON dome r | 350 mm | 550 mm | 1,000 mm | 1,500 mm | 3,200 mm |

## 3. 60% Common Platform Parts

The following components are **identical** (not scaled) across all five vessels:

| Part Number | Description | Standard Ref |
|---|---|---|
| PN-CC-001 | LoRa RAK3172, 915 MHz, ceramic pkg | F2-024 |
| PN-CC-002 | PMMA POF ZrO₂ ferrule connector IP68 | F2-019 |
| PN-CC-003 | Viton CMBC vault seal quad-ring set | F2-022 |
| PN-CC-004 | YInMn Blue + QD coating, 1-L compound | F2-018 |
| PN-CC-005 | CoAl₂O₄ node coating, 1-L compound | F2-018 |
| PN-CC-006 | Schumann PEMF fractal antenna, BFRP | F2-021 |
| PN-CC-007 | FBG optical strain sensor, 50 mm gauge | F2-028 |
| PN-CC-008 | MXene Ti₃C₂Tₓ spray suspension, 1 L | F2-017 |
| PN-CC-009 | Elium® 175 resin, 20-kg drum | F2-014 |
| PN-CC-010 | ZrO₂ 3Y-TZP bolt M10×50mm | F2-007 |
| PN-CC-011 | ZrO₂ 3Y-TZP bolt M6×25mm | F2-007 |
| PN-CC-012 | PEEK CF40 nut, M10 | F2-007 |
| PN-CC-013 | Viton V-ring backup seal, 30mm ID | F2-022 |
| PN-CC-014 | FBG humidity sensor in PEEK housing | F2-022 |
| PN-CC-015 | KNbO₃–BaTiO₃ disc 20mm×2mm bimorph | F2-013 |
| PN-CC-016 | PVDF-TrFE film, 50mm×50mm×0.5mm | F2-028 |
| PN-CC-017 | Aerosil-silicone dome joint sealant | F2-009 |
| PN-CC-018 | ALD ZrO₂ 100nm coated KNbO₃ bimorph | F2-013 |
| PN-CC-019 | EPIRB 406 MHz ceramic patch, COSPAS | F2-027 |
| PN-CC-020 | Sorbothane A20 isolation mount, 50mm | F2-040 |

**Scaled-family parts** (same design, different sf-dependent size):
- PN-AAJ-SF: AAJ bellows assembly
- PN-HUB-SF: Hub motor assembly (with Si₃N₄ bearings)
- PN-CMBC-SF: ZrB₂–SiC CMBC vault body
- PN-ALON-SF: ALON dome subassembly (or panel set)

The 20 common parts plus 4 scaled-family types represent ~60% of all distinct part numbers
in any given vessel, dramatically reducing tooling NRE and supply-chain complexity.

## 4. Fleet Electromagnetic Immunity Specification

| Threat Scenario | Required Survivability | Verification Standard |
|---|---|---|
| G5 GIC (E_geo = 20–43 V/km) | Zero structural heating, full systems operational | IEC 61000-4-8; custom chassis scan |
| EMP (HEMP burst, 50 kV/m) | Full function post-pulse | MIL-STD-461G RS105 |
| HIRF (200 V/m, 1 MHz–18 GHz) | Operational | RTCA DO-160G Section 20 |
| DEW microwave (2.45 GHz, 1 MW/m²) | Structural integrity, electronics functional | Custom test program |
| SPE radiation (Van Allen transit) | Battery and electronics functional | IEEE 1010 radiation hardness |

The fleet achieves GIC immunity through material physics, not through active shielding:
- ZrB₂–SiC: ρ > 10¹⁰ Ω·m → R_chassis >> 10¹² Ω → I_GIC < 10⁻¹¹ A → P ≈ 0 W
- "The GIC cannot heat what carries no electrons." — CSM Design Directive DD-001

Cross-reference: F2-006 (common parts), F2-047 (NDT tests), F2-049 (FMEA).


---
*End F2-004 | CSMVessel-Charlemagne-FleetV2 | June 2026*
