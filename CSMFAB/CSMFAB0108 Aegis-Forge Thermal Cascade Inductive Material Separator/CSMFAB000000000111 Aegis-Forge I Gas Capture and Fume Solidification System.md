# CSMFAB000000000111
## Aegis-Forge I: Gas Capture, Condensation, and Fume Solidification System
### Zero-Emission Closed-Loop Atmospheric Processing Architecture
**Document Number:** CSMFAB000000000111 (Volume 4 of 5)
**Series:** Aegis-Forge Thermal Cascade Inductive Material Separator (TCIMS)
**Date:** June 2026

---

## 1. The Zero-Release Mandate

The Aegis-Forge I is designed as a **hermetically sealed system**. At no point during any
thermal cascade stage are process gases, vapors, or particulates released to the environment.
This is achieved through a cascading condensation and capture system that treats all gas streams
as recoverable material — because they are.

**Every gas stream is a material:**

| Gas Stream | Source Stage | Recovered As | Value |
|---|---|---|---|
| Water vapor | Stage 1 | Process water for AMLS reuse | Zero cost |
| Polymer vapors | Stage 2 | Organic solvent condensate | Minor revenue |
| HCl vapor | Stage 2 (PVC) | NaCl brine (neutralized) | Disposal free |
| CO + CH4 + H2 | Stage 3 pyrolysis | Fuel gas: 18-22 MJ/m³ | Recovered energy |
| CO2 | Stage 3 combustion | Inert atmosphere supply → purge drum | Process gas savings |
| SO2 | Stage 3 (sulfur-bearing inputs) | CaSO4 (dry scrubber) | Disposal solid |
| Metal vapors (Zn, Pb) | Stages 4-5 | Metal oxide/condensate | Metal recovery |
| Tar/PAH vapors | Stage 3 | Activated carbon adsorption | Carbon product |
| N2 carrier gas | All stages | Recirculated continuously | Zero consumption |

---

## 2. Atmospheric System Architecture

### 2.1 Closed-Loop N2 Atmosphere

The entire drum + gas handling system operates as a sealed N2 atmosphere loop:

```
N2 Supply Tank (BFRP-lined, 350 bar)
        |
        v
N2 purifier (KFG getter trap — ZrO2 ceramic bed)
        |
        v
N2 pre-heater (SiC resistive element)
        |
        v
DRUM (gas sweeps from exhaust port → gas capture header)
        |
        v
Particle separator (ZrO2 ceramic cyclone — captures fine char/metal
                    particulate before gas stream reaches condenser)
        |
        v
Stage-specific condenser cascade
        |
        v
Gas scrubber bank
        |
        v
Final CO2 capture / combustible gas recovery
        |
        v
N2 recycle compressor (PEEK-valved, ZrO2 piston)
        |
        back to ---->>

```

**N2 consumption:** Minimal — only make-up gas for small leakage. Initial fill: 2-3 kg N2 per cycle.
N2 bulk cost: $0.09/kg (industrial nitrogen) → $0.27 per cycle running cost.

### 2.2 System Operating Pressure: 1.2-2.5 bar gauge

The positive pressure in the drum serves multiple functions:
1. Prevents air ingress (oxygen would cause uncontrolled combustion in thermoplastic stage)
2. Raises boiling points of water and volatile materials (reduces premature evaporation)
3. Allows pressure-differential management for gas stream direction to capture systems

**Pressure control:**
- Pressure transducer: FBG optical — no metallic element process-side
- Relief valve: PEEK CF40 spring-loaded valve with ZrO2 seat
- Bypass to N2 scrubber loop: automatically opens if pressure exceeds 3 bar

---

## 3. Stage-Specific Gas Treatment Trains

### 3.1 Train A — Moisture Condenser (Stage 1 outlet)

**Inlet conditions:** N2 + water vapor at 120°C, 1.2 bar

**Condenser construction:**
- Tube-and-shell heat exchanger: BFRP shell (Elium®), ZrO2-lined ceramic tubes
- Coolant: PEX-a water circuit (CSMFAB000000000012), 10°C supply
- No metal tubes touching the process gas stream
- Drop-out: condensed water collects in PEEK CF40-bottomed collection vessel

**Water quality:**
- Stage 1 water: light contamination (dust, trace organics)
- pH adjustment (add Ca(OH)2 if acidic from HCl): neutralize to pH 6.5-8
- Clarity: passes through 5 µm ceramic filter membrane (ZrO2 tubular)
- Reuse: returned to AMLS Stage 0 water circuit for acoustic coupling

### 3.2 Train B — Organic Vapor Condensation (Stage 2 outlet)

**Inlet conditions:** N2 + polymer vapors (styrene, butadiene, methyl methacrylate, etc.) at 300-450°C

**Multi-stage condensation:**
1. Primary condenser (80°C): heavy fraction — wax-like polymer condensate collects
2. Secondary condenser (25°C): medium fraction — liquid organics (solvent-range)
3. Tertiary cooler (5°C): trace light organics + water remaining

**Condensate composition:**
- Heavy fraction (wax, C20+ organics): can be used as mold release agent; or further cracking
- Medium fraction (oils, C6-C20): combustible liquid → heat recovery value = 35-42 MJ/kg
- Light fraction: minimal, absorbed in Stage 3 char activated carbon polishing

**CSMFAB material MMA recovery opportunity:**
If Elium® BFRP cuttings and off-cuts are included in feedstock, the Stage 2 organic vapor
stream contains **methyl methacrylate (MMA)** vapor (Tb = 100.5°C) from thermal depolymerization.
MMA is the base monomer for in-house Elium® production (Materials Study Part II).
By targeting the 100-105°C fraction in the secondary condenser:
In-house MMA recovery: 60-80% yield from degraded Elium® → feeds Elium® synthesis.

### 3.3 Train C — Pyrolysis Gas Recovery (Stage 3 outlet)

**Gas composition (N2-diluted):**

For 50 kg mixed organic feedstock, Stage 3 produces approximately:

| Gas species | Volume % (N2-free basis) | Calorific value |
|---|---|---|
| CO | 25-35% | 12.6 MJ/m³ |
| CH4 | 15-25% | 35.8 MJ/m³ |
| H2 | 20-35% | 10.8 MJ/m³ |
| CO2 | 15-20% | 0 (diluent) |
| BTX (benzene, toluene, xylene) | 3-8% liquid at 25°C | 42 MJ/kg |

Weighted average calorific value: **18.5 MJ/m³ (comparable to natural gas at 37 MJ/m³,
but 50% concentration from N2 dilution)**

**Pyrolysis gas processing path:**

Option A (preferred): Combustion in auxiliary burner (SiC-tipped ceramic burner,
CSMFAB000000000002 design) → heat recovery → Stage 7-8 supplemental thermal input.
This makes Stage 7-8 induction power requirements lower and reduces electricity cost.

Option B (future): Reform to H2 via steam reforming (CO + H2O → CO2 + H2).
H2 then stored in CFRP high-pressure vessel → fuel for hydrogen-compatible engine
(CSMFAB000000000105 Carrington-proof engine) → closes energy loop.

**Tar and PAH removal (critical before combustion):**
BTX and heavier aromatic tars would foul combustion equipment.
Solution: activated carbon trap (the char from Stage 3 output!):
Stage 3 char packed into a BFRP-hollow cylinder → gas passes through → tar adsorbs.
The char-tar composite is then re-fed to Stage 8 in next batch → tar is pyrolyzed to more char.
**Perfect closed-loop: Stage 3 output captures Stage 3 contaminants.**

### 3.4 Train D — Acid Gas Scrubber (HCl, SO2, HF)

**Targets:**
- HCl (from PVC dehydrochlorination, Stage 2): 200-1500 ppm in N2 stream
- SO2 (from sulfur in rubber, solder flux): 50-500 ppm
- HF (from fluoropolymers, electronics): rare but possible

**Dry Scrubber using Ca(OH)2 (lime) injection:**
Ca(OH)2 + 2HCl → CaCl2 + 2H2O (neutralizes HCl completely)
Ca(OH)2 + SO2 → CaSO3 + H2O (then oxidized: CaSO4 — gypsum)

Scrubber body: BFRP cylinder (Elium®) packed with Ca(OH)2 pellets on ZrO2 grid supports.
Ca(OH)2: $0.15/kg lime — cheapest reagent in the system.
Change-out when pH of downstream gas falls below 7.0 (monitored by optical pH sensor).
Spent CaSO4 (gypsum): useful construction material; can be added to geopolymer mixes.
Spent CaCl2: sold as de-icing salt.

### 3.5 Train E — Metal Vapor Condenser (Stages 4-5 outlet)

**Target: Zinc and lead vapors**

Zinc boiling point: 907°C. At Stage 4-5 temperatures (420-900°C), zinc vapor pressure is
significant above the melt. Some Zn exists as vapor in gas stream alongside liquid Zn in drum.

Lead boiling point: 1749°C. At Stage 4-5 temperatures, Pb vapor pressure is low but non-zero.

**Two-stage metal vapor condenser:**
1. High-temperature condenser (300-400°C): Zn condenses as liquid metal droplets
   → BFRP-shelled, ZrO2-lined condenser column at 360°C
   Collected Zn: flows to Zn collection vessel (ZrO2 ceramic)
2. Low-temperature condenser (100-150°C): final metal condensation + water washdown
   Collected: mixed metal oxides and hydroxides → fed to Stage 8 mineral residue for hydromet

**Lead oxide (PbO) in gas stream:**
If Pb is oxidized before reaching condenser: PbO forms as fine particulate.
PbO particles: captured in ZrO2 ceramic cyclone separator (99.5% efficiency for >0.5 µm particles).
PbO collected: hazardous material — sealed in PEEK CF40 containers per EPA/RCRA protocol.
Note: Lead is a RCRA hazardous waste when reclaimed — proper manifesting required.

---

## 4. Final Gas Treatment — CO2 Capture and N2 Recovery

### 4.1 CO2 Separation

After Stage 3 pyrolysis combustion, gas stream is primarily N2 + CO2.
CO2 should be separated and reused (as inert atmosphere supplement for drum purging).

**Pressure Swing Adsorption (PSA) with zeolite:**
Zeolite 13X adsorbs CO2 preferentially at 3-5 bar; desorbs (regenerates) at 1 bar.
- Zeolite 13X: $4-8/kg (commodity adsorbent)
- PSA cycle: 60 second adsorption + 30 second desorption
- CO2 purity output: 95-99%
- N2 purity output: 97-99.5% (reused as drum atmosphere)

PSA column body: BFRP (Elium®) with PEEK CF40 valve manifold.
No metal valve seats (ZrO2 ceramic check valves).

**Recovered CO2 uses:**
1. Primary: drum purge gas (supplement to N2 — both are inert at operating temperatures)
2. Secondary: CBPC geopolymer curing atmosphere (CO2 curing of geopolymer concrete, Part I)
3. Future: CO2-to-CO via plasma arc → feedstock for carbon synthesis

### 4.2 Plasma Torch Polisher — Final Gas Treatment

For any trace organics or halogens that escape all prior trains, a final plasma torch at
the gas outlet burns everything to CO2, H2O, HF, HCl — all then captured by the acid scrubber.

**Plasma torch construction:**
- Electrodes: ZrO2-coated tungsten (tungsten for high-temp resistance; ZrO2 coating for corrosion)
- Housing: ZrB2-SiC ceramic (CSMFAB000000000001 material — withstands 3000°C plasma temperatures)
- Power: 15 kW DC (plasma arc temperature: 3000-8000°C)
- Residence time at >1000°C: 0.5 seconds (sufficient to destroy all organic compounds)
- Dioxin/furan threshold: PCDD/PCDF destruction efficiency > 99.9999% at 1200°C, 2 seconds

The plasma torch is the system's regulatory safety net — ensuring zero toxic organic emissions.

---

## 5. Emergency Safety Systems

### 5.1 Pressure Relief

Three independent pressure relief paths:
1. Primary: PEEK CF40 spring-loaded relief valve → BFRP expansion vessel (500L buffer)
2. Secondary: rupture disk (ZrO2 ceramic disc rated at 8 bar burst pressure)
3. Emergency: manual ball valve (ZrO2 ceramic body, PEEK stem) → atmosphere (outdoor vent only initiated if all other systems fail + human authorization required)

### 5.2 Temperature Runaway Prevention

If induction coil fails in ON state:
- PMMA fiber FBG temp sensors detect >50°C over-temperature
- All induction inverters trigger isolated IGBT off-state via optical signal (no metallic control path that could GIC-corrupt)
- N2 quench valve opens: floods drum at 5 bar N2 (thermal ballast)
- Automatic drum speed reduction to 10 RPM (convective cooling)

### 5.3 Acoustic Overpressure Alert

AMLS Stage 0:
- Acoustic power limited by structural resonance of BFRP pre-chamber
- FBG sensors continuously monitor strain in chamber wall
- If strain > 60% of failure threshold: power reduced proportionally (PID control)

---

## 6. GFGS Construction Materials

Gas capture, fume, and gas solidification subsystem all-Aegis materials:

| Component | Material | Reference |
|---|---|---|
| N2 storage vessel (internal lining) | BFRP/Elium® | CSMFAB000000000011 |
| Gas header ducting | BFRP + ZrO2 ceramic elbows | CSMFAB000000000014 |
| Heat exchangers (ALL tube sides) | ZrO2-lined Al2O3 tubes | Materials Study Part I |
| Heat exchanger shells | BFRP/Elium® | CSMFAB000000000011 |
| PSA zeolite columns | BFRP/Elium® | CSMFAB000000000011 |
| PSA valve manifold | PEEK CF40 | Materials Study Part IV |
| PSA check valves | ZrO2 ceramic | CSMFAB000000000016 |
| Activated carbon beds | Stage 3 char (self-supplied!) | Process output |
| Lime scrubber bodies | BFRP/Elium® + ZrO2 grid | CSMFAB000000000011 |
| Cyclone separator | ZrO2 ceramic body | Materials Study Part I |
| Plasma torch housing | ZrB2-SiC | CSMFAB000000000001 |
| Plasma electrodes | ZrO2-coated W | Materials Study Part III (W) |
| Metal condensate collectors | ZrO2 ceramic vessels | Materials Study Part I |
| All valves (process side) | ZrO2 ceramic body + PEEK stem | CSMFAB000000000016 |
| Pressure relief discs | ZrO2 ceramic rupture disc | CSMFAB000000000010 |
| Control fiber | PMMA POF + FBG | CSMFAB000000000013 |

---

*End of CSMFAB000000000111 Volume 4 | Gas Capture, Condensation, and Fume Solidification*
*Continued in Volume 5: Assembly Line Integration and Output Slug Catalog*
