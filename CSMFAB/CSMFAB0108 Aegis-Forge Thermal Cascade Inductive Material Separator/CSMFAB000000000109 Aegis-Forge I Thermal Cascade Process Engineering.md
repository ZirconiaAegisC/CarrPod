# CSMFAB000000000109
## Aegis-Forge I: Thermal Cascade Process Engineering
### Stage-by-Stage Temperature, Chemistry, Materials Science, and Control Engineering
**Document Number:** CSMFAB000000000109 (Volume 2 of 5)
**Series:** Aegis-Forge Thermal Cascade Inductive Material Separator (TCIMS)
**Date:** June 2026

---

## 1. Thermal Cascade Engineering — The Science of Sequential Separation

The Aegis-Forge I exploits a fundamental principle of material science: every substance
has a discrete phase transition temperature. By raising the drum's internal temperature in
precisely controlled increments — the thermal cascade — each material class becomes liquid,
decomposes, or volatilizes in a predictable sequence, enabling clean physical separation.

### 1.1 The Cascade Temperature Ramp Protocol

The complete thermal cycle runs 3.5-5 hours per batch depending on feedstock:

```
TIME (min)  TEMP (°C)  STAGE   ACTIVITY
0-15        20-80      Pre     Acoustic mineral liberation (Stage 0)
15-35       80-150     1       Moisture removal, volatile organics
35-65       150-450    2       Thermoplastic flow, polymer separation
65-95       450-660    3       Pyrolysis, char formation, thermoset combustion
95-120      420-900    4       Low-melting metals: Pb, Sn, Zn (overlap range)
120-145     660-720    5       Aluminum separation (near-pure Al window)
145-175     720-1085   HOLD    Solidus zone: brass, bronze separation
175-205     1085-1200  6       Copper and copper alloys
205-240     1200-1600  7       Iron, steel, nickel, cobalt
240-270     1600-2200  8       Refractory mineral oxide residue
270-300     2200-cool  Cool    Controlled cool under N2; drum stops rotating
```

### 1.2 Stage 0 — Acoustic Pre-Liberation (Ambient)

Before any heating, the feedstock undergoes acoustic pre-treatment in a separate
pre-chamber connected to the drum.

**Physics of acoustic mineral liberation:**

Rock matrix minerals are held together by:
1. Grain boundary adhesion (intergranular cements, silicates)
2. Mechanical interlocking of irregular grain shapes
3. Surface tension of pore fluids

Low-frequency acoustic waves (20-500 Hz) induce cyclic stress waves through the rock matrix.
At resonant frequencies specific to the mineral grain size, stress concentrations at grain
boundaries exceed the grain boundary fracture toughness:

$$\sigma_{boundary} = rac{4\pi^2 f^2 A ho r}{K_{IC}} > 1 \Rightarrow 	ext{liberation}$$

Where A is acoustic amplitude, rho is grain density, r is grain radius, and K_IC is grain
boundary fracture toughness. Liberation occurs when the stress ratio exceeds 1.

**Low-frequency application (20-200 Hz) — rock matrix loosening:**

KNbO3-BaTiO3 piezoelectric transducers mounted on the pre-chamber outer wall.
At 100 Hz, 500W continuous: produces standing waves through a 20L charge of gravel.
After 15 minutes: mineral liberation index increases from ~20% to ~70% for typical basalt.

**Ultrasonic application (20-40 kHz) — fine grain liberation:**

Eight 40 kHz ultrasonic transducers (KNbO3-BaTiO3 probes, 500W each = 4 kW total)
submersed in water bath within pre-chamber. Acoustic cavitation liberates mineral grains
at micron scale for REE mineral liberation from host rock.

Bubble collapse pressure in ultrasonic cavitation:
$$P_{collapse} = P_0 \left(\frac{R_0}{R_{min}}\right)^{3\kappa} \approx 10^3 \text{ bar locally}$$

This microsecond, localized pressure is sufficient to fracture silicate-silicate grain
boundaries (fracture toughness 0.8-2 MPa·m^0.5) without destroying the mineral crystals
themselves (harder, more homogeneous materials).

**Output of Stage 0:**
- Rock feedstock disaggregated by 60-80% compared to input
- Mineral grains partially liberated from matrix
- Downstream thermal cascade is more efficient (larger surface area exposed to induction)

---

## 2. Stage 1 — Drying and Volatiles Removal (80-150°C)

### 2.1 Target Materials
- Free surface water (Tb = 100°C at 1 atm)
- Crystal-bound water in hydrated minerals (releases at 100-200°C depending on mineral)
  - Gypsum (CaSO4·2H2O): dehydrates at 107-120°C
  - Borax (Na2B4O7·10H2O): dehydrates at 100-140°C
  - Kaolin (Al2Si2O5(OH)4): partially dehydrates at 150°C
- Low-boiling organics: alcohols, acetone residues in electronics cleaning agents
- Solvents from PCB flux (terpineol Tb=218°C, begins at 150°C)

### 2.2 Temperature Control in Stage 1

Induction heating not effective at 80-150°C (most targets are non-conductive).
Alternative heating method: infrared irradiation from SiC glow bars positioned in
the static heating elements at drum top position.

SiC glow bars: silicon carbide resistive elements (CSMFAB000000000002-type) — same
material used in Ancient Hearth stove burner. Surface temperature: 800-900°C;
emitted IR at ~3.6 µm wavelength — absorbed by water strongly (water absorption
peak: 3.0 and 6.3 µm).

**Drum rotation during Stage 1:** 5-10 RPM (slow, gentle tumbling — uniform drying)
**Atmosphere:** N2 at 1.2 bar (prevents explosive H2/organic vapor combinations)
**Duration:** 20 minutes (sufficient for 50 kg charge with <30% moisture content)

### 2.3 Water and Volatile Recovery

Exiting vapor (mostly H2O) exits through Port 1 (150°C set-point):
- Condensed in BFRP heat exchanger (chilled to 10°C by PEX-a cooling circuit)
- Liquid water collected: analyzed for metal content, either purified and reused or discharged
- Organic vapors: trace quantity passes through activated carbon bed (char from Stage 3!)
  — elegant closed cycle: char from Stage 3 later used to adsorb Stage 1/2 organics

---

## 3. Stage 2 — Thermoplastic Polymer Flow (150-450°C)

### 3.1 Target Materials and Their Separation Temperatures

| Polymer | Melting/Flow Onset (°C) | Example Sources in Feedstock |
|---|---|---|
| Low-Density Polyethylene (LDPE) | 105-115°C | Plastic bags, film, coating |
| High-Density Polyethylene (HDPE) | 120-140°C | Pipe, bottles, containers |
| Polypropylene (PP) | 130-171°C | Automotive interior, packaging |
| Polystyrene (PS) | 100-240°C flash | Electronics housings |
| PVC (polyvinyl chloride) | 160-210°C | Wire insulation, pipes |
| ABS | 200-250°C | Electronics housings, dashboards |
| Nylon PA6 | 220-230°C | Mechanical parts, connectors |
| Nylon PA66 | 255-265°C | Engine compartment parts |
| PETE/PET | 250-260°C | Bottles, film |
| Polycarbonate (PC) | 267-290°C | Lenses, electronic covers |
| PEEK (CSM own off-cuts) | 341°C | Reclaim PEEK from failed parts |
| PTFE (Teflon) | 327°C | Wire insulation, gaskets |

**Combined melt window:** 105°C to 450°C — achievable in single stage by slow ramp.

### 3.2 Melt Centrifuge Physics in Stage 2

As polymers melt they become viscous (viscosity eta at melt: 10²-10⁴ Pa·s depending on polymer).
Centrifugal force drives molten polymer outward. At 50 RPM (G=1.4) low centrifugal forces
allow polymers to pool but not fully stratify.

At 150 RPM (G=12.6) — adequate for polymer-polymer density separation:
- HDPE melt density: 0.78 g/cm³
- PEEK melt density: 1.22 g/cm³
- PP density: 0.74 g/cm³

Density difference relative to G-force creates stratified annular layers.
Heavy polymers (PEEK, PC) form outer annular band.
Light polymers (PP, LDPE) form inner annular band.

Port 2 at drum OD (Port open at 200°C): primarily discharges highest-density polymer melt first.
As temperature rises through 450°C, lower-density polymers also flow.

**Output:** Mixed polymer slug exiting Port 2, quenched in BFRP mold.
This "mixed polymer block" is a downstream input for:
- Elium® reformulation (MMA-compatible melt blending)
- BFRP matrix additive (modified impact resistance)
- Future CSM product: polymer filament for 3D printing

### 3.3 PVC Warning — Chlorine Management

PVC releases HCl vapor at 160-200°C during dehydrochlorination. This is a toxic acid gas.
**Critical process control:**
- Stage 2 atmosphere: mildly basic N2 (trace NaHCO3 aerosol injection — powder spray system)
- NaHCO3 + HCl → NaCl (salt) + H2O + CO2: neutralization occurs in-drum
- Residual HCl: monitored by inline optical HCl sensor (PMMA fiber + absorption spectroscopy)
- If HCl concentration > 50 ppm: drum temperature hold until HCl level drops
- NaCl residue: exits as dissolved mineral in Stage 3 char

---

## 4. Stage 3 — Pyrolysis and Carbon Char Formation (450-700°C)

### 4.1 Thermoset and Organic Decomposition

At temperatures above 450°C, thermosetting polymers (epoxy, phenolic glue,
FR4 PCB substrate, rubber) undergo thermal decomposition (pyrolysis):

**Simplified global pyrolysis reaction:**
$$\text{Polymer} \xrightarrow{\Delta, 500°C} \text{Char (C)} + \text{Gas (CO, CO}_2\text{, H}_2\text{O, H}_2\text{)}$$

Carbon yields from pyrolysis (by weight):
- Epoxy resin: 15-25% char yield
- FR4 substrate (glass-epoxy): 40-50% char (from glass fiber mass)
- Rubber/elastomer: 25-40% char
- Phenolic resin: 50-60% char (high carbon yield)
- Cellulosic materials: 20-30% char

**Temperature details for FR4 PCB substrate:**
T_onset: 350-420°C (depends on halogen content)
T_peak weight loss: 480-520°C (main decomposition)
Residue at 700°C: ~20% (SiO2 glass fibers + inorganic fillers + carbon char)

### 4.2 Char Collection — The Valuable Carbonaceous Product

At 600-700°C, char from pyrolysis:
- Carbon content: 80-95% C (high after partial oxidation/volatilization)
- Surface area: 200-800 m²/g (activated carbon-like porosity from volatile evolution)
- Specific resistance: 10^-3 to 10⁻¹ Ohm·m
- Practical applications:
  1. Activated carbon for organic vapor adsorption (used immediately in Stage 1 gas treatment!)
  2. Carbon black substitute for rubber compounding
  3. Graphite precursor for further purification
  4. Carburizing agent for steel (reduces iron oxide)
  5. Carbon electrodes for electrochemical processes

**Char exits Port 3:** A dry, granular discharge collected in a ZrO2-lined ceramic bin.
Weight: approximately 8-15% of original organic input.

### 4.3 Combustion Gas Management

At 500-700°C with residual oxygen: full combustion produces CO2 + H2O.
Under N2 atmosphere (oxygen-starved): pyrolysis gases include CO, CH4, H2, BTX aromatics.

**CSM Operating choice:**
Maintain <2% O2 in drum atmosphere (N2 sweep maintains this).
Operate in partial pyrolysis mode → higher char yield, lower gas yield.
Combustible pyrolysis gases (CO, CH4, H2) routed to gas management system (Document 111).
These gases represent recoverable energy: calorific value ~18-22 MJ/m³ (comparable to town gas).

---

## 5. Stage 4 — Low-Temperature Metals (420-900°C): Pb, Sn, Zn

### 5.1 Target Metal Separation

| Metal | Melting Point | Typical Sources | Expected Purity (Raw) |
|---|---|---|---|
| Lead (Pb) | 327.5°C | Lead solder, batteries, wheel weights | 85-95% Pb |
| Tin (Sn) | 231.9°C | Solder (Sn60/Pb40), tin plate, PCBs | 30-60% Sn (alloyed) |
| Sn-Pb eutectic (63/37) | 183°C | Electronic solder joints | 63% Sn / 37% Pb |
| Bismuth (Bi) | 271.5°C | Low-temp fusible alloys, cosmetics | variable |
| Indium (In) | 156.6°C | ITO glass coatings, LCD panels | very dilute |
| Zinc (Zn) | 419.5°C | Die-cast housings, galvanized steel | 85-95% Zn |
| Zinc alloy (Zamak) | 380-390°C | Die-cast automotive, hardware | Zn/Al/Cu alloy |

**Critical separation for CSMFAB:** Indium at 156.6°C. At its melting point, only In liquefies — all other metals remain solid. The ultra-low-temp In separation produces an indium-rich liquid at Port 4 (set to 160°C for In pass).

**Process innovation — Indium First Strategy:**
Heat Stage 4 slowly: 155°C, 157°C, 160°C — In liquefies immediately.
Centrifuge at 400 RPM for 5 minutes at exact 160°C.
Port 4 opens: In-rich liquid (mixed with residual organics) discharges.
Downstream refining of this stream yields 99.9% In via electrodeposition — feeds YInMn production!

This makes the Aegis-Forge I a **domestic Indium recovery machine** — reducing critical mineral dependency.

### 5.2 Induction Selectivity for Stage 4 Metals

At 420-660°C (Zn melting range):
- Zinc: rho_Zn = 5.96×10⁻⁸ Ohm·m → excellent induction coupling
- Lead: rho_Pb = 2.0×10⁻⁷ Ohm·m → good induction coupling
- At this stage, aluminum is still solid (Tm = 660°C) and provides the "solid matrix"

Induction power (50 kHz, 80 kW): specifically heats Zn/Pb/Sn particles within the solid Al/Cu/Fe matrix.
The melt pools at Zn/Pb grain locations, coalesces under G-force, and drains outward.

---

## 6. Stage 5 — Aluminum Separation (660-720°C)

### 6.1 The Aluminum Window

660°C is the liquidus of pure aluminum. Copper melts at 1085°C, iron at 1538°C.
The 60°C window between 660°C and 720°C creates a clean aluminum separation stage:
- Only Al, Al alloys (6061: 652°C, 7075: 477-635°C solidus), and Al-Si die cast (577°C eutectic) melt
- All copper, iron, nickel, cobalt remain solid
- Zinc (Tm=419°C) has already been removed in Stage 4

**Centrifuge parameters for Stage 5:**
- Drum speed: 300 RPM (G=25)
- Aluminum melt viscosity at 700°C: 1.3 mPa·s (extremely fluid — flows easily)
- Centrifugal separation is rapid: 5-minute dwell at 680°C to collect >95% of Al content

**Expected aluminum slug composition:**
- Al: 85-97% (depends on input alloy diversity)
- Si: 1-8% (from die-cast A380 / A356)
- Cu: 0.5-3% (from 2024, 7075 alloys)
- Mg: 0.3-1.5%
This mixed alloy slug goes to downstream refining (Document 112) for property-specific casting.

**CSMFAB relevance:** Recovered aluminum not used directly in Aegis products (which avoid metals),
but sold as commercial scrap to fund operations, or used in non-structural tooling (molds, fixtures).

---

## 7. Stage 6 — Copper Separation (1085-1200°C)

### 7.1 Copper Recovery

At 1085°C, copper melts. Copper is present in:
- PCB traces and plated-through holes (20-35% Cu by weight in PCB)
- Motor windings (99.9% Cu)
- Plumbing scrap (99.5% Cu pipe)
- Electrical wire (99.9% Cu)

**Induction heating of copper at Stage 6:**
Coil frequency: 5 kHz (penetration depth in Cu at 1100°C: ~4mm — suitable for wire/trace sizes)
Power: 150-200 kW to overcome Cu's high heat capacity (0.385 J/g·K × 200 kg × 1065°C = 82 MJ)

**Special consideration — Precious metals with copper:**
Gold (Tm = 1064°C), Silver (Tm = 961.8°C), Platinum (Tm = 1768°C)
Both Au and Ag melt before or at Stage 6 temperature. They report with copper in Port 6 output.
Downstream electrolytic refining separates these from the Cu slug — this is a REVENUE STREAM.

**PCB precious metal content (per ton of PCBs):**
- Gold: 300-400 g/ton
- Silver: 3,000-5,000 g/ton
- Palladium: 100-200 g/ton
- Copper: 150,000-250,000 g/ton (0.15-0.25 kg/board)

At 2026 gold price $3,200/troy oz → 300g/ton Au = **$30,900/ton PCB in gold alone**

---

## 8. Stage 7 — Ferrous Metal Cascade (1200-1600°C)

### 8.1 Iron, Steel, and Ferromagnetic Metal Recovery

Ferrous metals are uniquely efficiently heated by induction (ferromagnetic cores couple
at 2-10× the power density of non-ferrous metals). The Stage 7 induction system therefore
uses the LOWEST frequency (2 kHz) for maximum penetration and ferromagnetic coupling.

| Metal | Melting Point | Induction Coupling |
|---|---|---|
| Carbon steel | 1370-1400°C | Excellent (ferromagnetic below Curie Temp 770°C) |
| Stainless (304) | 1400-1430°C | Good (austenitic, non-magnetic — eddy current only) |
| Cast iron | 1150-1200°C | Excellent (high carbon, approaches Cu at boundary) |
| Nickel | 1455°C | Very good (ferromagnetic Tc=358°C; non-mag at Stage 7 temps but conductive) |
| Cobalt | 1495°C | Good |
| Chromium | 1907°C | Remains solid — segregates to Stage 8 residue |

**Iron slug chemical analysis target:**
Fe: >90%; C: 2-4%; Si: 1-2%; Mn: 0.5-1%
This low-alloy iron/steel slug can be remelted for general castings or sold as secondary iron.

**Rare earth magnets (NdFeB, SmCo) in Stage 7:**
NdFeB Tm = 1177°C → melts in Stage 7 window.
SmCo Tm = 1490°C → melts in Stage 7 as well.
Combined RE-Fe-B and RE-Co melts report to Port 7 with main ferrous stream.
IMPORTANT: This stream contains Nd, Sm, Co — valuable rare earths for new magnet production!
Downstream refining (hydromet leach) separates RE from the Fe matrix.

---

## 9. Stage 8 — Refractory Mineral and Ceramic Residue (1600-2200°C)

### 9.1 What Remains at 1600°C+

After all organic matter, polymers, metals through iron have been removed, the remaining
solids at 1600°C are oxide minerals and refractory ceramics:

- **Silica glass fibers (from FR4 PCBs, glass insulation):** Tm = 1600-1700°C → begins melting
- **Zirconia (ZrO2 from Aegis product returns):** Tm = 2716°C — solid throughout; concentrated
- **Rare earth oxides (from magnet returns, ore processing):** Y2O3, La2O3, Nd2O3 → remain solid
- **Titanium dioxide (TiO2 from ilmenite processing):** decomposes above 2000°C
- **Alumina (Al2O3):** Tm = 2072°C — primarily solid in Stage 8; some partial melt
- **Silicon carbide (SiC) residue:** sublimation at 2700°C — solid through Stage 8
- **Zircon sand (ZrSiO4):** dissociates at 1676°C → ZrO2 + SiO2 (valuable dissociation!)

### 9.2 Zircon Sand Processing — Critical CSMFAB Material Recovery

At 1700°C, zircon sand (ZrSiO4) dissociates:
$$ZrSiO_4 \xrightarrow{1676°C} ZrO_2 + SiO_2$$

The ZrO2 is then available for:
- Further processing to 3Y-TZP ceramic powder (add Y2O3, re-mill, sinter)
- ZrB2 synthesis (add B2O3 + carbon → carbothermal reduction)

The Stage 8 mineral residue that exits Port 8 is:
A partially fused slag-like material rich in Zr, Ti, rare earth oxides, Al2O3, SiO2.
This is the primary input for the Materials Study Part V critical mineral recovery program.

**Output: "Mineral Concentrate Slug" — the treasure chest**
Chemical analyses of Port 8 output from mixed electronics recycling (per ton input):
- ZrO2: 0.5-3% (from ITO-bearing LCD glass)
- TiO2: 1-4% (from white pigments in plastics, ilmenite-bearing minerals)
- Rare Earth Oxides: 0.1-2% (from magnets, phosphors, catalysts)
- Al2O3: 15-25% (from anodized Al oxide, aluminosilicates)
- SiO2: 40-60% (glass, PCB substrate)
- Carbon (unoxidized): 2-5%
This slag feeds the Phoenix Protocol hydrometallurgical refinery.

---

*End of CSMFAB000000000109 Volume 2 | Thermal Cascade Process Engineering*
*Continued in Volume 3: Acoustic Mineral Liberation Subsystem*
