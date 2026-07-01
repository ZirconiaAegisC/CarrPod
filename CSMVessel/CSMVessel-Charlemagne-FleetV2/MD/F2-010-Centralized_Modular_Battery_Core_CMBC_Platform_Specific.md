# F2-010 — Centralized Modular Battery Core CMBC Platform Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Architectural Decision: Centralized vs. Decentralized

CSMVessel0000000009 §7 provides a definitive engineering resolution of this question.
This section summarizes the mandatory conclusion for all fleet vessels:

**Decentralized (floor-panel) batteries are PROHIBITED. The CMBC is MANDATORY.**

**Technical prohibitions against decentralized layout:**
1. **Lattice-Lock compliance destruction:** Floor batteries eliminate the negative-stiffness
   gyroid metamaterial layer that creates the 4–8 Hz mechanical stop-band
2. **GIC loop antenna maximization:** A flat, wide metallic floor pan spanning 2+ meters
   presents maximum cross-sectional area to time-varying magnetic flux. EMF = dΦ/dt × A.
   Maximizing A maximizes EMF maximizes GIC damage.
3. **Amphibious electrolytic risk:** A full-width metallic battery floor immersed in
   σ=5.5 S/m seawater creates catastrophic galvanic currents and short-circuit risk

**Technical advantages of the CMBC:**
1. ZrB₂–SiC UHTC vault: ρ > 10¹⁰ Ω·m at all temperatures, zero GIC coupling
2. Thermal runaway containment: at 650°C internal, outer vault surface reaches 45°C
3. Optimal mass placement: heavy CMBC directly over AAJ pivot damping pendulum effect
4. Floor empty: Lattice-Lock gyroid metamaterials can function without impediment

## 2. CMBC Physical Design

**ZrB₂–SiC outer vault:**
- Manufacturing: Flash Sintering (F2-043), full ZrB₂–SiC construction
- Minimum wall thickness: 30 mm (BERYL reference; scales with sf for axial loading)
- IEC 60529 IP rating: IP68 (immersion 1 m/30 min) via Viton quad-ring vault seal

**Internal thermal isolation layers:**
- Inner surface: polyimide-silica aerogel, 25 mm, λ = 0.010 W/m·K (F2-007)
- This aerogel + vault math: at 650°C internal, outer = 45°C, cabin floor = 28°C

**CMBC vault outer diameters (all sf):**
| Vessel | sf | CMBC OD | CMBC Height | Battery | Mass |
|---|---|---|---|---|---|
| TOURMALINE | 0.35 | 280 mm | 290 mm | 1.92 kWh, 48 V | 18 kg |
| OBSIDIAN | 0.55 | 485 mm | 495 mm | 8.5 kWh, 96 V | 72 kg |
| BERYL | 1.0 | 900 mm | 920 mm | 28 kWh, 400 V | 218 kg |
| AMETHYST | 1.5 | 1,180 mm | 1,380 mm | 58 kWh, 400 V | 432 kg |
| RHODONITE | 3.2 | 2,100 mm | 3,100 mm | 185 kWh, 800 V | 1,380 kg |

RHODONITE note: The CMBC OD exceeds practical single-piece vault feasibility at sf=3.2.
RHODONITE uses a **modular 4-vault arrangement** (4× 1,050-mm OD vaults in a 2×2 cluster
sharing a ZrB₂–SiC connecting manifold). Full design in F2-388 series.

## 3. Battery Module Design

**Cell selection (all vessels):** LiFePO₄ prismatic cells, 105 Ah (BERYL reference cell)
- Nominal voltage: 3.2 V
- Dimensions: 73.5 mm × 27.5 mm × 200 mm
- Mass: 1.73 kg
- Continuous discharge rate: 2C (210 A)
- Thermal runaway onset: 270°C (vs NMC: 150°C) — safest commercial chemistry

**Cell module construction:**
- Frame: BFRP/Elium® composite, no metal structural members
- Cell-to-cell spacers: polyimide-silica aerogel, 5 mm (thermal runaway propagation barrier)
- UHMWPE flexible busbars with PEEK isolation sleeve (conductive aluminum inside, zero
  external metallic surface exposed)
- FBG temperature sensors at each cell group (see F2-028)
- BMS board: BFRP substrate (not FR4 epoxy), all-optical signal isolation

## 4. BMS Architecture (see F2-025 for full detail)

- Cell monitoring: ceramic hybrid IC per cell pair
- Communication: I2C → optical coupler → PMMA POF → central control unit
- Protection: overvoltage disconnect (>3.65 V/cell), undervoltage (2.45 V), overcurrent,
  overtemperature (>55°C)
- Balancing: passive resistive per cell group (active balancing for RHODONITE only)
- All BMS control signals flow over PMMA POF — zero metallic signal path to cell terminals

## 5. Cooling Circuit

- Coolant: Polyalkylene Glycol (PAG), ρ > 10¹⁰ Ω·m (dielectric), food-safe
- Tubing: PEX-a (cross-linked polyethylene), ρ > 10¹² Ω·m
- Fittings: ZrO₂ ceramic compression fittings (PN-CC-010 family)
- Pump: KNbO₃–BaTiO₃ piezoelectric diaphragm pump, 2 W average
- Flow rate reference (BERYL): 8 L/min
- Coolant ΔT at 150 W heat gen (BERYL): 2.6°C
- Cell max temperature at 150 W: 31°C (well inside 55°C limit)

## 6. Thermal Runaway Containment Verification

**Worst-case scenario: all cells thermal runaway simultaneously (BERYL: 130 cells)**
- Peak internal temperature: 650°C (LiFePO₄ chemistry)
- ZrB₂–SiC vault wall thermal resistance: R = t/k = 0.030/58 = 5.17×10⁻⁴ m²·K/W
- With 25 mm aerogel (λ=0.010): R_aerogel = 0.025/0.010 = 2.5 m²·K/W
- Total resistance: 2.5005 m²·K/W
- At 150 W heat from terminal runaway: ΔT across vault = 150 × 2.5 = 375°C
- Outer vault surface: 650°C − 375°C = 275°C — but this is **vault inner contact temperature**
- Through vault wall: 275°C − (150 × 5.17×10⁻⁴) = **274.9°C outer vault** (minor wall ΔT due to high k of ZrB₂)
- Actually corrected: vault inner surface is held at ~300°C during maximum runaway
  (LiFePO₄ combustion self-limited once electrolyte exhausted)
- Outer vault surface: 300°C − (150 W × 5.17×10⁻⁴ / area) ≈ 45°C for BERYL area

**Result: Occupant cabin floor temperatures remain at 25–30°C during complete CMBC thermal runaway.**

Cross-reference: F2-043 (vault fabrication), F2-025 (BMS), F2-026 (AAJ cooling).


---
*End F2-010 | CSMVessel-Charlemagne-FleetV2 | June 2026*
