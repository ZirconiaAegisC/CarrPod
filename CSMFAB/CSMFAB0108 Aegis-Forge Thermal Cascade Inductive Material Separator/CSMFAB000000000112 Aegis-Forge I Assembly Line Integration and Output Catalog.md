# CSMFAB000000000112
## Aegis-Forge I: Assembly Line Integration, Output Slug Catalog, and Material Handoff
### Downstream Processing, Output Classification, and Seed Material Generation for CSMFAB Portfolio
**Document Number:** CSMFAB000000000112 (Volume 5 of 5)
**Series:** Aegis-Forge Thermal Cascade Inductive Material Separator (TCIMS)
**Date:** June 2026

---

## 1. The Output Slug Catalog: Every Exit Stream has a Destination

The Aegis-Forge I produces 12 distinct output streams per full thermal cascade cycle.
Each is classified, sampled, stamped, and routed to its specific downstream use.
None are waste. All are value.

### 1.1 Output Stream Registry

| Stream # | Port | Name | Phase at Exit | Temperature | Downstream Use |
|---|---|---|---|---|---|
| S-01 | 1 | Process Water | Liquid | 80-100°C | AMLS recirculation |
| S-02 | 2 | Mixed Polymer Slug | Solid (cooled) | 25°C | Polymer reprocessing / Elium® feedstock |
| S-03 | 3 | Carbon Char Pellets | Solid granule | 25°C | Activated carbon / carburizing agent |
| S-04 | 4a | Indium-Rich Fraction | Liquid → Solid | 157-200°C | Ionic liquid In refining → YInMn Blue |
| S-05 | 4b | Zn/Pb/Sn Slug | Solid ingot | 25°C | Low-temp metal recovery / solder remanufacture |
| S-06 | 5 | Aluminum Slug | Solid ingot | 25°C | Al casting / secondary market sale |
| S-07 | 6 | Copper Billet | Solid ingot | 25°C | Cu wire remanufacture / electrical market |
| S-08 | 6-PM | Precious Metal Fraction | Included in S-07 | — | Electrolytic Au/Ag/Pd refining |
| S-09 | 7 | Ferrous Slug | Solid ingot | 25°C | Fe casting / RE magnet leach (from NdFeB) |
| S-10 | 7-RE | Rare Earth Concentrate | Included in S-09 | — | Hydromet RE extraction → magnets, catalysts |
| S-11 | 8 | Mineral Concentrate | Mixed solid | 25°C | Hydromet refinery → Zr, Ti, REE recovery |
| S-12 | Gas | Pyrolysis Fuel Gas | Gas | 25°C | Combustion for Stage 7-8 auxiliary heat |
| S-13 | Gas | CO2 Stream | Gas | 25°C | Drum purge gas / geopolymer curing atmosphere |
| S-14 | Gas | NaCl / CaSO4 Solids | Solid | 25°C | Construction material additive |

---

## 2. Slug Cooling Station

All liquid-metal slugs exit their respective ports into a carousel of ZrO2 ceramic molds:

**Carousel slug mold system:**
- 16-position rotary carousel (BFRP/Elium® disc, PEEK CF40 bushing)
- Mold material: 3Y-TZP ZrO2 ceramic — withstands all metal temperatures; negligible reaction
- Mold release: none needed — ZrO2 does not wet with molten metals (contact angle >120°)
- Cooling: N2 gas quench nozzles (PEEK CF40 manifold, CSMFAB000000000014-type ducting)
  Controlled cooling rate: 20-100°C/min (fast for fine grain Al; slow for ceramic-melts to reduce stress)
- Mold capacity: 2 kg per slug mold (standard size is 100×50×25mm brick)
- Cycle time per position: 8 minutes (fill + cool enough for demolding)
- Automated demolding: PEEK CF40 ejector pins, KNbO3-BaTiO3 piezo actuated

**Slug stamp-and-barcode system:**
Before cooling sets, a ZrO2 ceramic stamp head presses an alphanumeric code into each slug:
- Batch number, port of origin, stage temperature, date/time
- This traceability is essential for Phoenix Protocol — knowing the full provenance of recycled material

---

## 3. Slag Analysis and Auto-Sorting

Each slug emerging from the carousel is analyzed by an inline spectrometer:

**Laser-Induced Breakdown Spectroscopy (LIBS):**
- Nd:YAG pulsed laser (1064 nm, 5 mJ pulses) focused on slug surface
- KNbO3-BaTiO3 detector vibrates synchronously (lock-in amplification of plasma emission)
- PMMA POF fiber carries emission to spectrometer
- Analysis time: 2 seconds per slug
- Elements detectable: all metals, C, Si, S, Cu, Fe, Al, Zn, Pb, Ni, REE signatures
- Result: automatic grade assignment and routing to appropriate downstream conveyor

**Routing conveyors:**
Three output classifications per slug:
1. **Direct use:** Meets specification for known downstream CSMFAB process → immediately conveyed to that machine
2. **Refinement needed:** Good material but needs purity improvement → routed to refinery queue
3. **Secondary sale:** Not directly usable by CSM → weighed, logged, routed to commercial sale

---

## 4. The CSM Seed Material Generation Map

This is the Aegis-Forge I's ultimate purpose: **converting raw Earth and recycled matter
directly into the seed materials required for every CSMFAB product.**

### 4.1 Seed Material → CSMFAB Product Direct Linkage

| Aegis-Forge Output | Intermediate Step | Final CSMFAB Seed Material | Used In |
|---|---|---|---|
| S-04 In-rich fraction | Ionic liquid refining (Phoenix Protocol) | Indium metal 99.9% | YInMn Blue (35 products) |
| S-10 RE Concentrate | Hydromet leach → Cyanex 272 extraction | Y2O3, Nd2O3, La2O3 | YSZ, YInMn, RE magnets |
| S-11 Mineral Concentrate | Leach + ZrO2 precip + Y2O3 addition | 3Y-TZP ZrO2 powder | ZrO2 fasteners, parts |
| S-11 (ZrSiO4 dissociation) | Carbothermal + SHS program | ZrB2 powder | CSMFAB000000000001 |
| S-11 (TiO2 concentrate) | Chloride-thermal extraction | TiO2 → TiCl4 → Ti3AlC2 | MXene, MAX Phase |
| S-03 Carbon Char | Activation (steam, 900°C) | Activated carbon | Air/gas filtration |
| S-03 Carbon Char | Graphitization (2800°C) | Graphite | Electrode material |
| S-07 Copper Billet | Melt + draw | Cu wire | Motor windings (isolated) |
| S-09 Ferrous Slug | RE extraction first, then melt | Clean iron + RE separated | Iron castings (tooling) |
| S-06 Aluminum Slug | Melt + refine | Casting alloy or scrap sale | Commercial (CSM uses no Al in Aegis products) |
| S-12 Pyrolysis gas | Steam reform (Option B) | H2 fuel | Engine CSMFAB000000000105 |
| S-08 Precious metals | Electrolytic refining | Au, Ag, Pd | Sale → Funds operations |
| S-05 Zn/Pb/Sn | Fractional distillation | Separated Zn/Pb/Sn | Sale or solder remanufacture |
| S-02 Polymer slug | Extrusion → filament or sheet | Polymer blend stock | Injection-moldable polymer |

### 4.2 Critical Path: Rock → ZrB2 Powder in 48 Hours

This is the most important operational sequence showing the Aegis-Forge I as a true
cradle-to-material system for the portfolio's most critical ceramic:

```
Hour 0:   Zircon sand (ZrSiO4) loaded into Aegis-Forge I AMLS
          [20 min acoustic: >80% zircon grain liberation from silica matrix]

Hour 0.3: AMLS magnetic separation removes ilmenite fraction (Fe, Ti separate stream)

Hour 0.5: Liberated zircon sand fed to Forge drum
          Stage 8 temperature: 1700°C
          ZrSiO4 dissociation: ZrSiO4 → ZrO2 + SiO2 (liquid SiO2 exits Port 8 first)

Hour 3:   Stage 8 mineral concentrate (ZrO2-rich) exits as Slug S-11

Hour 3.5: S-11 transferred to Phoenix Protocol hydromet circuit:
          BFRP reactor vessel; H2SO4 leach → ZrO2 dissolves as Zr4+
          YCl3 added (Yttrium from REE stream S-10)
          NH4OH co-precipitation → Zr-Y hydroxide gel

Hour 6:   Gel filtered, washed, dried at 120°C

Hour 8:   Calcination furnace (1200°C, 4h) → 3Y-TZP ZrO2 crystalline powder

Hour 12:  3Y-TZP ZrO2 powder available for:
          → Direct: use as ZrO2 fastener/part powder (sintered at 1400°C)
          → Alternative: add to B2O3 + carbon → ZrB2 via carbothermal synthesis

Hour 36:  ZrB2 carbothermal reaction complete (1700°C, 16h)
          OR: ZrB2 SHS reaction (1h from Zr metal + B precursors)

Hour 48:  ZrB2 powder available for Flash Sintering into Aegis-C panels, stove burners, etc.
```

**48 hours from raw zircon sand to ready-to-sinter ZrB2 powder. No metals, no exotic chemistry, no supply chain vulnerabilities.**

---

## 5. Downstream Assembly Line Integration

### 5.1 Aegis-Forge I as Machine No. 1

The Aegis-Forge I is explicitly the **first machine** in a modular assembly line.
Output slugs flow via gravity-conveyor (BFRP belt conveyor on ZrO2 ceramic rollers)
to adjacent downstream machines. The complete line, when built, comprises:

| Machine | CSMFAB Number | Function | Input from Forge |
|---|---|---|---|
| Aegis-Forge I | 108-112 | Thermal cascade separation | Raw feedstock |
| Hydro-Refinery I | 113 (future) | Hydrometallurgical critical mineral extraction | S-11 mineral concentrate |
| Powder Synthesis I | 114 (future) | ZrB2 SHS, Si3N4, MAX Phase synthesis | Zr, B, Si precursors |
| Aerogel Line I | 115 (future) | Polyimide-silica aerogel production | SiO2 from S-11 |
| Basalt Fiber Furnace | 116 (future) | In-house basalt fiber drawing | Basalt rock (direct from AMLS) |
| BFRP Pultrusion Line | 117 (future) | Rebar, profiles, structural shapes | Basalt fiber + Elium® |
| MXene Reactor | 118 (future) | Ti3C2Tx synthesis from MAX Phase | Ti3AlC2 (powder 114) |
| YInMn Kiln | 119 (future) | YInMn Blue pigment synthesis | In (S-04), Y (S-10) |

### 5.2 Single Machine Startup (Phase 1 Self-Sufficiency)

In Phase 1, only the Aegis-Forge I is operational. All outputs except direct-use slugs go to:
- Commercial sale (Al, Cu, Fe, Zn/Pb/Sn slugs → immediate revenue)
- Stockpile for Phase 2 machines (ZrO2, RE concentrates → await hydromet reactor)
- Activated carbon internal use → ad immediately into gas treatment Train C

**Phase 1 commercial slug revenue estimate (per 50 kg mixed electronics input):**

Material balance for 50 kg input (typical PCB-rich e-waste):
- Polymers (35%): 17.5 kg → S-02 polymer slug → $0.15/kg scrap = $2.63
- Carbon char (8%): 4 kg → S-03 char → $0.10/kg = $0.40
- Zn/Pb/Sn (6%): 3 kg → S-05 slug → $2.00/kg blended = $6.00
- Aluminum (12%): 6 kg → S-06 slug → $1.80/kg secondary = $10.80
- Copper (23%): 11.5 kg → S-07 billet → $9.00/kg = $103.50
- Precious metals (trace): in S-07 → Au 15g = $1,548; Ag: 115g = $130; Pd: 5g = $185 = $1,863
- Iron (14%): 7 kg → S-09 slug → $0.45/kg = $3.15
- Mineral residue (2%): 1 kg → S-11 → retain for CSMFAB
- Gas streams → energy credit → 18.5 MJ = ~5 kWh electricity equivalent = $0.85

**Revenue per 50 kg batch: $1,990 (dominated by precious metals)**
**Operating cost per 50 kg batch: electricity ($45) + N2 ($2) + consumables ($15) = $62**
**Net per batch: $1,928**

**At 8 batches/day (3.5 hr cycle, 12-hr operating day): $15,424/day gross revenue from e-waste only**
**Annual (250 operating days): $3.86M/year from Aegis-Forge I alone — exclusively from waste streams!**

This revenue directly funds Phase 2 machine construction.

---

## 6. Full Machine Specifications — Summary

### 6.1 Aegis-Forge I Technical Specifications

| Parameter | Value |
|---|---|
| Drum working diameter | 600 mm |
| Drum working length | 800 mm |
| Drum working volume | 226 liters |
| Maximum batch size | 80 kg (assumes ~65% fill factor) |
| Typical batch size | 50 kg |
| Cycle time (full thermal cascade) | 3.5-5 hours |
| Daily throughput (8 batches) | 400 kg/day |
| Annual throughput (250 days) | 100 metric tons/year |
| Maximum drum temperature | 2400°C |
| Maximum drum pressure | 5 bar (design); 2.5 bar (operating) |
| Drum rotational speed | 0-500 RPM variable |
| Maximum centrifugal force | 84.5 G at 500 RPM |
| Induction total installed power | 500 kW (8 × 62.5 kW zones) |
| Acoustic pre-processor power | 8 kW LF + 4 kW ultrasonic |
| Gas treatment N2 loop | Closed-loop, 2-3 kg/cycle makeup |
| Machine external dimensions | 2.2 m (L) × 1.4 m (W) × 1.8 m (H) |
| Total machine mass | ~850 kg |
| Operating electrical supply | 3-phase 480V, 600 A service |
| Cooling water requirement | 15 L/min, 10°C supply |
| Control system | PMMA POF + FBG + KNbO3-BaTiO3 DSP |

### 6.2 Production Cost Per Machine (Small Batch Production: 5-unit run)

| Assembly Group | Material Cost | Labor Cost | Total |
|---|---|---|---|
| ZrB2-SiC Drum (flash sintered) | $18,500 | $6,200 | $24,700 |
| BFRP Pressure Vessel (filament wound) | $4,200 | $3,800 | $8,000 |
| Aerogel Insulation Gap Fill | $1,800 | $400 | $2,200 |
| 8-Zone Induction Coil Bank | $28,000 | $8,500 | $36,500 |
| GaN Induction Inverter Electronics | $35,000 | $4,200 | $39,200 |
| AMLS Acoustic Pre-Processor | $8,500 | $2,800 | $11,300 |
| Gas Capture System (Trains A-E) | $22,000 | $9,500 | $31,500 |
| Slug Carousel Mold System | $6,500 | $3,200 | $9,700 |
| PEEK CF40 Drive Assembly | $12,000 | $4,800 | $16,800 |
| ZrO2 Bearing and Seal Package | $5,500 | $2,000 | $7,500 |
| PMMA POF Control System | $4,800 | $3,500 | $8,300 |
| BFRP Frame and Conveyor | $3,500 | $2,800 | $6,300 |
| Plasma Torch Unit | $8,000 | $2,200 | $10,200 |
| Assembly, Testing, Commissioning | $0 | $18,000 | $18,000 |
| **TOTAL** | **$158,300** | **$71,900** | **$230,200** |

**Prototype (1 unit):** ~$385,000 (3× multiplier for NRE + tooling)
**Small batch (5 units):** ~$230,200 each
**Production volume (50+ units):** ~$148,000 each
**MSRP (production volume):** $220,000–$280,000 each

**Payback at $15,424/day revenue:** **15-18 days of operation per machine**

---

## 7. Conclusion: The First Machine Is the Seed

The Aegis-Forge I is not merely a recycling machine. It is an in-situ mining device,
a hazardous waste handler, a precious metal recovery system, a raw mineral processor,
and a seed material generator simultaneously. By design, it uses exclusively CSMFAB
materials — so the first Aegis-Forge I can be assembled using materials already in production.

It produces the materials needed to build the next machine in the assembly line.
That machine produces more refined materials needed for the next. And so on —
until the full CSMFAB portfolio is self-sustaining from Earth's own raw materials
and the circular return of expired Aegis products.

This is the Phoenix Protocol made physical.

---

*End of CSMFAB000000000112 Volume 5 | Assembly Line Integration and Output Slug Catalog*
*End of CSMFAB000000000108-112 Aegis-Forge I Series*
*Carrington Storm Motors | Safe Pod Engineering Company | June 2026*
