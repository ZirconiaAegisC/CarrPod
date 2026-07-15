# ACS OneD Battery Sciences | Technology Validation & Pilot Data

## 1. Pilot Validation Infrastructure

### Testing Hierarchy
OneD's technology validation follows a structured progression from fundamental materials characterization through full-size automotive cell testing:

**Level 1: Materials Characterization**
- Graphite powder with SINANODE silicon nanowires: SEM, TEM, XRD, BET, TGA
- Silicon loading verification by thermogravimetric analysis (TGA)
- Nanowire morphology by cross-sectional electron microscopy
- Silicon crystallinity by X-ray diffraction and Raman spectroscopy

**Level 2: Coin Cell Electrochemistry**
- Half-cell testing (vs. Li metal): specific capacity, first-cycle efficiency, rate capability
- Standardized test protocols: C/10 formation, C/5 cycling, EIS at 50% SOC
- Statistical sampling: every production batch; n=5 cells per condition

**Level 3: Single-Layer Pouch Cells**
- Representative electrode loadings (3-4 mAh/cm²)
- NMC811 cathode pairing
- Formation optimization: current, voltage limits, temperature
- Cycle life: C/3 charge, 1C discharge, 100% DOD, 25°C and 45°C

**Level 4: Multi-Layer Pouch Cells**
- 5-20 Ah format
- Stack pressure simulation (fixtured testing)
- Extended cycling: >500 cycles with periodic reference performance tests
- Differential capacity analysis (dQ/dV) to track degradation modes

**Level 5: Automotive-Scale Cells**
- >100 Ah format (production-representative)
- Full GM Ultium cell specifications
- Pack-level environmental testing
- Abuse testing: nail penetration, overcharge, crush, thermal runaway propagation

### Current Validation Status (2024)
| Test Level | Status | Key Results |
|-----------|--------|-------------|
| L1: Materials | Routinely performed | Silicon loading 15±2 wt%; nanowire diameter 20-40 nm |
| L2: Coin Cells | Routinely performed | 550-650 mAh/g; FCE 88-92% |
| L3: Single-Layer Pouch | Complete | >800 cycles at 80% retention (C/3 charge, 1C discharge) |
| L4: Multi-Layer Pouch | In progress | 500+ cycles achieved; EOL swelling within specification |
| L5: Automotive Cells | Initiated (GM pilot line) | Formation and early cycling data being collected |

## 2. Key Performance Data

### Energy Density Improvement
At 15 wt% silicon loading in the graphite anode:
- **Anode specific capacity**: 550-650 mAh/g (vs. 350 mAh/g for pure graphite)
- **Cell-level energy density improvement**: 20-30% vs. graphite baseline, depending on cathode pairing and cell design
- **Improvement mechanism**: Higher anode capacity allows thinner anode coating for same areal capacity, reducing inactive material fraction (current collector, separator) and increasing volumetric energy density

### Cycling Stability
SINANODE anodes at 15% silicon loading demonstrate:
- **Room temperature (25°C)**: >800 cycles to 80% capacity retention at C/3 charge, 1C discharge, 100% DOD
- **Elevated temperature (45°C)**: >500 cycles to 80% retention; accelerated SEI growth at higher temperature is the dominant degradation mode
- **Low temperature (0°C)**: Acceptable performance; lithium plating risk managed through charge rate derating, as with graphite anodes
- **Calendar aging (45°C, 100% SOC)**: <5% capacity loss at 6 months; comparable to high-quality graphite anodes

### Degradation Analysis
dQ/dV analysis of cycled SINANODE cells reveals:
1. **Primary degradation mode**: Loss of cyclable lithium inventory (consumed in SEI formation and repair), not loss of silicon active material
2. **Silicon utilization**: Silicon capacity contribution remains stable over cycling, indicating the nanowire-in-pore architecture effectively prevents silicon isolation
3. **Impedance growth**: Moderate and linear; consistent with SEI thickening on graphite surfaces; silicon nanowire conductivity remains adequate
4. **Graphite degradation**: Graphite capacity contribution declines similarly to pure graphite anodes; silicon does not accelerate graphite degradation

### Rate Capability
| Charge/Discharge Rate | Capacity Retention (vs. C/5) |
|----------------------|------------------------------|
| C/2 | 98% |
| 1C | 95% |
| 2C | 90% |
| 3C | 82% |
| 5C | 65% |

Rate capability is primarily limited by the graphite matrix, not the silicon nanowires. Silicon nanowires grown within pores maintain electrical contact with the graphite host throughout cycling.

## 3. Manufacturing Process Validation

### Slurry Rheology
SINANODE-processed graphite slurry maintains coating-compatible rheology:
- Viscosity within 10% of baseline graphite slurry at equivalent solids loading
- No thixotropic anomalies introduced by silicon nanowires
- Stable viscosity over 48-hour pot life (standard production window)

### Coating Quality
- Coating weight uniformity: ±2% across web width (equivalent to graphite baseline)
- No coating defects (streaks, agglomerates, pinholes) attributable to silicon nanowires
- Electrode adhesion strength: >95% of graphite baseline; meets automotive specification

### Calendaring Behavior
- Compressibility of SINANODE electrode similar to graphite baseline
- Target electrode density achieved at standard calendaring pressure
- No silicon nanowire protrusion through electrode surface after calendaring

## 4. Safety Validation

### Abuse Testing Results
Safety testing has been conducted on multi-layer pouch cells:

| Test | Standard | Result |
|------|---------|--------|
| Overcharge (1C to 200% SOC) | GB/T 31485 | Pass (no fire, no explosion) |
| Nail penetration | SAE J2464 | Pass (no thermal runaway) |
| Crush (150 kN) | SAE J2464 | Pass (no fire, no explosion) |
| External short circuit | UL 1642 | Pass |
| Thermal stability (ARC) | Internal | Onset of self-heating 10°C higher than pure silicon anodes |

### Thermal Runaway Comparison
Accelerating rate calorimetry (ARC) testing shows SINANODE cells have:
- Higher onset temperature for self-heating than cells with pure silicon or silicon oxide anodes
- Lower maximum self-heating rate
- Behavior dominated by cathode (NMC) thermal decomposition, not anode

The enhanced thermal safety is attributed to silicon nanowires being confined within graphite pores, limiting direct silicon-electrolyte contact area and reducing the reactivity of lithiated silicon.

## 5. Independent Validation

### Third-Party Testing
OneD has engaged independent battery testing laboratories to validate performance claims:
- **National laboratory partnerships**: Testing at US national laboratories provides third-party credibility for automotive OEM evaluation
- **Cell manufacturer internal testing**: GM's own battery laboratories independently validate SINANODE performance, providing the most rigorous and commercially relevant validation

### Academic Collaborations
OneD maintains research collaborations with academic institutions focused on:
- Advanced characterization of nanowire growth mechanisms (synchrotron XRD, in-situ TEM)
- Long-term degradation mechanism studies
- Next-generation silicon loading approaches (30-50% Si targets)

These collaborations provide independent validation of fundamental technology claims and advance the scientific understanding required for continued process improvement.
