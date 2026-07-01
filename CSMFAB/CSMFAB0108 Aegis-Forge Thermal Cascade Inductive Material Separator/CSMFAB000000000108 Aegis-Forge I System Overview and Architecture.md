# CSMFAB000000000108
## Aegis-Forge I: Planetary Centrifugal Inductive Material Separation and Reclamation System
### System Overview, Design Philosophy, and All-Aegis Construction Architecture
**Document Number:** CSMFAB000000000108 (Volume 1 of 5)
**Series:** Aegis-Forge Thermal Cascade Inductive Material Separator (TCIMS)
**Prepared by:** Carrington Storm Motors, Safe Pod Engineering Company, Fabrication Division
**Date:** June 2026 | **Classification:** Foundation Technology — Seed Material Production

---

## 1. Purpose and Design Mandate

The Aegis-Forge I is the **zeroth-stage machine** of the entire CSM fabrication ecosystem.
Every product in the CSMFAB portfolio — from BFRP rebar to ZrB₂ ceramics to YInMn Blue — requires
raw or semi-refined material inputs. The Aegis-Forge I is designed to generate these inputs from:

1. **Post-consumer recycled material streams** — electronics, appliances, vehicles, building debris
2. **Geological mineral concentrates** — rocks, ore slag, beach sands, mine tailings
3. **CSM Phoenix Protocol returns** — end-of-life Aegis products re-entering the material cycle

The machine achieves **thermal cascade separation**: as temperature rises incrementally inside a
spinning pressurized ceramic drum, successive material classes reach their melting, vaporization, or
decomposition points and are centrifugally driven outward through grade-specific ports, exiting as
solid **slugs** or condensed pellets for downstream refining.

This is simultaneously: a rotary kiln, an induction furnace, a centrifuge, an acoustic mineral
liberator, a closed-atmosphere gas processor, and a programmable sequential material sorter.

**It is the most important machine in the CSMFAB portfolio because everything else depends on it.**

---

## 2. Operating Principle: Thermophysical Cascade Separation

### 2.1 The Foundational Physics

Every material has a characteristic melting point (Tm), decomposition temperature (Td), or boiling
point (Tb). At any given temperature T, all materials with Tm < T are liquid; all with Tm > T remain solid.

In a rotating drum:

**Centrifugal separation force:**
$$F_c = m \omega^2 r$$

A 5 kg mass at radius r = 0.25 m and rotational speed omega = 100 rpm (10.47 rad/s):
$$F_c = 5 \times (10.47)^2 \times 0.25 = 137 \text{ N}$$

At higher speed (300 rpm, omega = 31.4 rad/s):
$$F_c = 5 \times (31.4)^2 \times 0.25 = 1234 \text{ N}$$

The centrifugal acceleration ratio (G): G = omega²r/g
At 300 rpm, r = 0.25 m: G = (31.4)² × 0.25 / 9.81 = **25.1 G**

Liquids with density rho_l > rho_solid phase migrate outward under centrifugal force.
Liquids at 25 G cannot remain centrally mixed — they stratify by density and pool at the drum wall.

**When T rises past Tm(Al) = 660°C:** Aluminum liquefies, spins out to drum perimeter, exits through
an aluminum-specific circumferential port (positioned at the 660-700°C thermal zone), and collects
outside as a slug.

This selective ejection is the core mechanism of the Aegis-Forge I.

### 2.2 Eight Thermal Processing Stages

The drum operates across eight consecutive temperature bands. Each band is held for a programmed
dwell time before incrementing, allowing complete separation of each material class:

| Stage | Temperature Band | Duration | Target Materials | Output Form |
|---|---|---|---|---|
| 0 — Acoustic Pre-liberation | Ambient | 15-30 min | Mineral grain liberation from rock matrix | Liberated powder |
| 1 — Drying / Moisture | 80–150°C | 20 min | Free water, hydrations, volatile organics | Vapor → condensed water |
| 2 — Polymer Flow | 150–450°C | 30 min | Thermoplastics (PE, PP, PVC, ABS, PEEK offcuts) | Plastic slugs |
| 3 — Pyrolysis / Char | 450–700°C | 30 min | Thermosets, rubber, organics → CO₂ + char | Carbon char pellets + CO₂ captured |
| 4 — Zinc/Lead/Tin | 420–900°C | 25 min | Zn (420°C), Pb (327°C), Tin (232°C), Solder | Metal slugs |
| 5 — Aluminum | 660–720°C | 25 min | Al alloys (6061, 2024, die-cast) | Al ingot slugs |
| 6 — Copper/Bronze | 1085–1200°C | 30 min | Cu wire, bronze fittings, PCB traces | Cu slug billets |
| 7 — Iron/Steel/Nickel | 1200–1600°C | 35 min | Fe, Ni, Cr, stainless (induction-selective) | Ferrous casting slugs |
| 8 — Mineral Residue | 1600–2200°C | 20 min | Silicates, oxides, rare earth concentrates | High-temp mineral slag |

### 2.3 Selective Induction Heating — The Invisible Sorter

Induction heating selectively couples to materials based on:
- **Electrical conductivity (eddy current heating):** Copper, aluminum, steel, gold, silver all heat inductively
- **Magnetic permeability (hysteresis heating):** Ferrous materials (iron, steel, nickel) heat 2-4× more intensely
- **Non-conductive materials:** Ceramics, organics, glass, BFRP — NOT heated inductively; only heated by conduction from surrounding hot materials

This creates a **natural sorting bias**: at any temperature stage, conductive metals heat faster and
more thoroughly than surrounding insulating material. Metals liquefy while ceramics and organics remain
solid longer, making them easier to separate centrifugally.

$$P_{induction} = \frac{\pi^2 B_{peak}^2 d^2 f^2}{6 \rho D}$$

For copper (rho = 1.7 × 10^-8 Ohm·m): heating power 15× that of aluminum at same geometry, frequency.
For steel (ferromagnetic): heating power 25-50× that of aluminum.

---

## 3. Machine Architecture — Full System Description

### 3.1 Primary Components

```
AEGIS-FORGE I — TOP-LEVEL ARCHITECTURE

   [ACOUSTIC PRE-PROCESSOR] --- Stage 0: Ultrasonic + LF mineral liberation
          |
          v
   [FEED HOPPER & SHREDDER] --- Input: recycled material, rock, ore, PCBs...
          |
          v
   [ZrB2-SiC DRUM ASSEMBLY] --- Primary thermal processing vessel
   |  Rotating UHTC ceramic drum (inner)                      |
   |  Induction coil bank (8 independently controlled zones)  |
   |  BFRP pressure vessel (outer)                            |
   |  8 × Circumferential material exit ports (temper-locked) |
   |  Argon/N2 atmosphere; 0.5-3 bar operating pressure       |
          |
          |--- Port 1 (150°C): Condensed water vapor ---> [Water Recovery Tank]
          |--- Port 2 (450°C): Plastic melt centrifuge exit -> [Plastic Slug Mold]
          |--- Port 3 (700°C): Carbon char exhaust --------> [Char Capture Chamber]
          |--- Port 4 (900°C): Zn/Pb/Sn centrifuge exit ---> [Low-Temp Metal Slugs]
          |--- Port 5 (720°C): Aluminum centrifuge exit ----> [Al Ingot Slugs]
          |--- Port 6 (1200°C): Copper centrifuge exit -----> [Cu Billet Slugs]
          |--- Port 7 (1600°C): Ferrous centrifuge exit ----> [Fe/Steel Slugs]
          |--- Port 8 (2200°C): Mineral/oxide residue ------> [Mineral Concentrate]
          |
          v
   [GAS CAPTURE SYSTEM] --- All combustion gases captured, processed, classified
   |  CO2 capture (carbon sequestration or re-use as inert atmosphere)
   |  SO2, HCl scrubber (from toxic fume materials)
   |  Condensation stages: organics, metals vapor, water
   |  Plasma torch for final trace treatment
          |
          v
   [SLUG COOLING STATION] --- All material slugs solidified, stamped, catalogued
   |  Ceramic mold carousel (ZrO2 molds, 8-position rotary)
   |  Rapid quench N2 spray for microstructure control
   |  Automated mass spectrometry slug spot-check
          |
          v
   [CONVEYOR HANDOFF] --- Feeds downstream Assembly Line machines (CSMFAB 113+)
```

### 3.2 Drum Assembly — The Heart of the Machine

**ZrB₂-SiC Ceramic Inner Drum (Flash-Sintered per CSMFAB000000000001 V2.0):**

Dimensions: 600 mm diameter × 800 mm length (internal working volume: ~226 liters)
Wall thickness: 35 mm ZrB₂-SiC composite (12 vol% ZrB₂, 88 vol% SiC matrix)
Maximum operating temperature: 2400°C (safe to 85% of ZrB₂ melting point 3245°C)
Pressure rating: 5 bar (validated by FEA — compressive loading favorable in ceramics)
Rotational speed range: 0–500 RPM (variable via piezoelectric linear drive motor)
Centrifugal G-force at 500 RPM (r=0.3m): 84.5 G — sufficient for all metal-liquid separation

**Port valve system:**
Eight circumferential circumferential discharge ports spaced 44.2° apart around the outer
drum diameter. Each port is:
- Normally CLOSED by a spring-loaded ZrO₂ ceramic piston (no metal springs — PEEK CF40 wave springs)
- Temperature-activated: a bimetal-equivalent ceramic thermal actuator (Ti₃AlC₂ MAX Phase strip)
  expands differentially to open the port when the stage temperature is reached
- Centrifugal force then drives collected liquid material outward through the open port
- Port aperture: 12 mm diameter (sufficient for liquid metal flow at G-force)

**Drum liner material zones:**
The inner drum surface is NOT uniform — three material zones:
1. **Zone A (low-temp stages 1-3):** Si₃N₄ ceramic scratch coat — prevents plastic adhesion
2. **Zone B (mid-temp stages 4-6):** ZrB₂-SiC working surface — primary structural zone
3. **Zone C (high-temp stages 7-8):** Pure ZrO₂ thermal barrier coat — maximum temp stage

### 3.3 Induction Coil Bank

Eight independently controlled induction coil zones, each heating a 100 mm axial length of drum:

**Coil construction (using CSMFAB materials only):**
- Conductor: Copper tube (25mm OD) — the ONLY copper used in the machine
  (justified as winding — not a structural GIC-coupling element; isolated from drum)
- Insulation: Alumina ceramic sleeve (Al₂O₃ wrapped) over copper — same as CSMMECH motor insulation
- Water cooling: PEX-a water circuit through copper tube bore (CSMFAB000000000012)
- Coil housing: BFRP composite casing (Elium® matrix)
- Coil-to-drum gap: 15 mm (clearance for drum expansion + rotation)

**Induction frequency zones:**

| Stage/Temperature | Coil Frequency | Primary Material Being Heated | Power Level |
|---|---|---|---|
| Stages 1-2 (80-450°C) | 100 kHz | Plastic, light organics (indirect via air/N2) | 0-50 kW |
| Stage 3 (450-700°C) | 50 kHz | Zinc, lead (conductors begin coupling) | 50-80 kW |
| Stage 4-5 (660-900°C) | 10 kHz | Aluminum (optimal frequency for Al eddy coupling) | 80-150 kW |
| Stage 6 (1085-1200°C) | 5 kHz | Copper (deep penetration at low freq) | 100-200 kW |
| Stage 7 (1200-1600°C) | 2 kHz | Iron/steel (ferromagnetic — most efficient) | 150-350 kW |
| Stage 8 (1600-2200°C) | 1 kHz | Refractory mineral oxides | 200-500 kW |

Total installed induction power: **500 kW** (3-phase, 480V industrial supply)

**Induction power control:**
- Each zone uses a GaN-based variable frequency resonant inverter (CSMFAB materials: same GaN tech as Safe-Wave microwave 005, scaled to industrial power)
- PMMA optical fiber temperature feedback from FBG sensors embedded in drum wall (no metallic thermocouple touches process materials)
- PID control maintains each zone within ±5°C of target

---

## 4. Outer Pressure Vessel and Safety System

**BFRP pressure shell (Elium® matrix, CSMFAB000000000011-spec):**
- Filament-wound BFRP outer pressure vessel: 900 mm internal diameter × 1200 mm length
- Design pressure: 10 bar (2× operating pressure)
- Hydrostatic test: 15 bar with N₂ (non-flammable test fluid)
- Wall: 18 mm basalt fiber/Elium® [±18°/90°]₄ layup (filament wound for hoop strength)
- Thickness validated by Barlow: P = 2σt/D → σ_hoop at 10 bar = 12.5 MPa (well within BFRP 1100 MPa tensile)
- Fire protection: YInMn Blue + CoAl₂O₄ exterior glaze (SRI=115; protects BFRP Tg=80°C from radiated heat)
- Drum-to-vessel gap filled with polyimide-silica aerogel (λ=0.010 W/m·K) — thermal insulation layer

**PEEK CF40 end flanges:**
- Both drum ends (motor/feed side and slug discharge side) sealed by PEEK CF40 flanges
- Dynamic rotary seal: ZrO₂ ceramic face seal + PEEK CF40 spring — rated 2000 RPM, 10 bar, 800°C

---

## 5. All-Aegis Material Bill of Construction

The Aegis-Forge I is built **exclusively from CSMFAB-certified materials**. No structural steel, no aluminum
framing, no copper electrical paths touching the process chamber.

| Component | Material | CSMFAB Reference |
|---|---|---|
| Inner drum | ZrB₂-SiC composite, flash-sintered | CSMFAB000000000001 |
| Drum liner Zones A-B | Si₃N₄ scratch coat / ZrB₂-SiC | CSMFAB000000000002 |
| Drum liner Zone C | 3Y-TZP ZrO₂ thermal barrier | Part I Material Study |
| Material exit port valves | Ti₃AlC₂ MAX Phase actuator | Materials Study Part I |
| Port valve seat | ZrO₂ 3Y-TZP ceramic piston | Materials Study Part I |
| Outer pressure vessel | BFRP/Elium® filament wound | CSMFAB000000000011 |
| Thermal insulation gap | Polyimide-silica aerogel 50mm | CSMFAB000000000003 |
| Induction coil housing | BFRP/Elium® composite | CSMFAB000000000001 |
| Coil insulation sleeve | Al₂O₃ ceramic tube | Materials Study Part I |
| Drive motor | KNbO₃-BaTiO₃ ultrasonic motor | CSMFAB000000000020 |
| Drive shaft bearing | Si₃N₄ ceramic roller bearing | CSMMECH000000001 |
| End flange | PEEK CF40 composite | Materials Study Part IV |
| Dynamic shaft seal | ZrO₂ face seal + PEEK spring | CSMFAB000000000016 |
| Cooling water circuit | PEX-a pipe + ZrO₂ fittings | CSMFAB000000000012 |
| Gas collection ducting | BFRP + ZrO₂ lined bends | CSMFAB000000000014 |
| Control wiring | PMMA optical fiber + FBG sensors | CSMFAB000000000013 |
| Exterior coating | YInMn Blue + CoAl₂O₄ glaze | Materials Study Part III |
| Frame structure | BFRP pultruded sections | CSMFAB000000000010 |
| Leg mounts | 3Y-TZP ZrO₂ isolation pads | CSMFAB000000000010 |
| Acoustic transducers | KNbO₃-BaTiO₃ piezo array | CSMFAB000000000020 |
| Output slug molds | ZrO₂ 3Y-TZP ceramic molds | Part I Material Study |
| Slug cooling N₂ nozzles | PEEK CF40 manifold | Materials Study Part IV |

**Zero metals in structural roles.** Zero ferromagnetic materials. Zero conductive paths to earth ground.
The machine is itself a Dielectric Citadel — Carrington-immune, fireproof, and structurally ceramic.

---

## 6. Feedstock Specifications

### 6.1 Acceptable Input Materials

**Category A — Electronics and PCBs:**
- Printed circuit boards (FR4 glass-epoxy base → SiO₂ + char + Cu + Sn/Pb solder + precious metals)
- Smartphones, tablets, laptops (Al chassis, Cu, rare earths in magnets)
- Motors and drives (Cu windings, Fe stators, rare earth magnets)

**Category B — Structural Metals and Alloys:**
- Aluminum extrusions, castings (wheels, frames, engine blocks)
- Copper pipe, wire, scrap
- Steel and iron scrap (ferrous most efficiently heated by induction)
- Zinc die-cast components

**Category C — Rock, Ore, and Mineral Concentrates:**
- Basalt rock aggregate (for in-house basalt fiber supply chain)
- Zircon sand concentrate (ZrSiO₄ → ZrO₂ extraction)
- Rare earth oxide concentrate (monazite, bastnäsite — for Y, La, Ce, Nd recovery)
- Ilmenite sand (FeTiO₃ → TiO₂ extraction)
- Borax ore (Na₂B₄O₇ → B₂O₃ → for ZrB₂ synthesis)

**Category D — Phoenix Protocol Returns (Aegis Product EOL):**
- Retired Aegis-C panels (ZrB₂-SiC + aerogel + YInMn glaze)
- End-of-life BFRP structural components
- Spent MR fluid (iron carbonyl suspension)
- Old KNbO₃-BaTiO₃ piezo elements

**Maximum feed particle size:** 150 mm (pre-shredded); input shredder processes larger pieces

### 6.2 Pre-processing Requirements

Before entering the drum:
1. Ferrous separation (simple permanent-magnet belt) → removes bulk steel for direct slug collection
2. Shredder (BFRP-blade, PEEK lined): reduces to <150 mm average dimension
3. Coarse acoustic cleaner (Stage 0 pre-chamber): 1-minute ultrasonic mineral liberation at ambient conditions
4. Moisture check: if >25% moisture, pre-dry at 80°C in entry chamber first

---

*End of CSMFAB000000000108 Volume 1 | Aegis-Forge I System Overview and Architecture*
*Continued in Volume 2: Thermal Cascade Process Engineering*
