# ACS OneD Battery Sciences | SINANODE Nanowire Growth Mechanism

## 1. Fundamental Principle

### Core Concept
SINANODE technology grows silicon nanowires directly inside the existing internal pore structure of standard battery-grade graphite particles. Rather than manufacturing a separate silicon-carbon composite material in a dedicated factory, OneD's process introduces a silane-based precursor gas into the anode slurry mixing vessel. Under controlled temperature and pressure conditions, silicon atoms nucleate on the graphite pore walls and grow as nanowires that fill the pore volume.

### Why Nanowires Inside Pores
Graphite particles used in lithium-ion battery anodes are inherently porous, with internal void volumes of 15-30% depending on the graphite grade. These pores provide the ideal confined environment for silicon nanowire growth:
- Pore walls constrain nanowire diameter to sub-50 nanometer dimensions, the critical threshold below which silicon avoids pulverization during lithiation
- Pore volume buffers the 300% volume expansion during lithiation — the nanowire expands into pre-existing void space
- Graphite walls provide built-in electronic conductivity pathways
- Existing SEI on graphite surface is undisturbed by internal nanowire growth

## 2. Growth Process Chemistry

### Precursor Selection
OneD uses silane (SiH₄) as the primary silicon precursor, selected for:
- Thermal decomposition temperature compatible with slurry processing conditions (350-500°C)
- Gaseous state enables penetration into graphite pore network
- Hydrogen byproduct is non-contaminating in battery chemistry
- Well-characterized decomposition kinetics from semiconductor industry

### Nucleation Mechanism
Silicon nanowire growth proceeds through a vapor-liquid-solid (VLS) or vapor-solid (VS) mechanism depending on the presence of catalyst particles. OneD's patent filings indicate both catalyzed and non-catalyzed approaches:

**Catalyzed Growth (VLS)**:
1. Metal catalyst nanoparticles (Au, Ni, or Sn) pre-deposited on graphite pore surfaces
2. At elevated temperature, catalyst forms liquid eutectic droplets with silicon
3. Silane decomposes at catalyst surface, silicon dissolves into liquid droplet
4. Upon supersaturation, silicon precipitates at liquid-solid interface as crystalline nanowire
5. Nanowire grows axially, lifting catalyst droplet at tip

**Non-Catalyzed Growth (VS)**:
1. Graphite pore surfaces provide heterogeneous nucleation sites
2. Silane decomposes directly on graphite surfaces
3. Silicon adatoms diffuse to lowest-energy growth facets
4. Anisotropic growth produces nanowire morphology
5. Critical advantage: no metal contamination of battery chemistry

### Growth Parameters
| Parameter | Typical Range | Effect |
|-----------|--------------|--------|
| Temperature | 350-500°C | Controls decomposition rate and nanowire crystallinity |
| Silane partial pressure | 0.1-10 torr | Controls growth rate and nanowire density |
| Growth time | 30-180 minutes | Controls nanowire length and silicon loading |
| Carrier gas | N₂, Ar, or H₂ | Affects mass transport and decomposition kinetics |

## 3. Nanowire Morphology Control

### Diameter Control
Nanowire diameter is primarily controlled by:
- Pore size distribution of the graphite feedstock
- Catalyst particle size (for catalyzed process)
- Growth temperature (higher temperature favors thicker nanowires)
- Silane concentration (higher concentration increases radial growth rate)

Optimal nanowire diameter range: 10-50 nanometers. Below 10 nm, electronic conductivity through the nanowire decreases and surface oxidation becomes significant. Above 50 nm, the nanowire exceeds the critical fracture threshold during lithiation and undergoes pulverization.

### Length Control
Nanowire length is a function of growth time and is ultimately limited by the pore dimensions of the graphite host. Typical pore depths in battery-grade graphite range from 2-20 microns, setting the maximum possible nanowire length. OneD targets nanowire lengths of 1-10 microns, sufficient to achieve 15-30 wt% silicon loading.

### Crystallinity
OneD's process produces silicon nanowires with controlled crystallinity:
- Single-crystalline nanowires (VLS growth): Superior electronic conductivity and lithiation homogeneity
- Polycrystalline nanowires (VS growth): Faster growth rates, more tolerant to graphite surface chemistry variations
- Amorphous silicon shell: Thin outer layer formed during cooldown improves first-cycle efficiency

## 4. Silicon Loading Optimization

### Target Loading Range
OneD targets 15 wt% silicon loading in the graphite anode for the initial commercial product, with a roadmap to 30 wt%. This loading level is selected based on:
- Electrochemical cycling stability: 15% Si/graphite blend demonstrates >800 cycles at 80% capacity retention
- Expansion management: Pore volume of typical graphite accommodates 15-20% Si without external expansion
- First-cycle efficiency: Maintains >88% FCE at 15% loading, competitive with pure graphite

### Loading Uniformity
Achieving uniform silicon distribution across the graphite powder is critical:
- Gas-phase silane penetration ensures nanowire growth in all accessible pores
- Uniform temperature field in the slurry vessel prevents localized hot spots
- Post-growth characterization via TGA confirms batch-to-batch loading consistency within ±2%

## 5. Electrochemical Performance

### Half-Cell Performance (vs. Li/Li⁺)
- **Specific Capacity**: 550-650 mAh/g at 15% Si loading (vs. ~350 mAh/g for graphite)
- **First-Cycle Efficiency**: 88-92%
- **Rate Capability**: 90% capacity retention at 2C vs. C/5

### Full-Cell Performance (vs. NMC811)
- **Energy Density Improvement**: 20-30% at cell level vs. graphite baseline
- **Cycle Life**: >800 cycles to 80% capacity retention at C/3 charge, 1C discharge
- **Calendar Life**: <5% capacity loss over 6 months at 45°C, 100% SOC

### Expansion Behavior
- **Cell-Level Thickness Swelling**: <8% at end of life vs. >12% for silicon oxide approaches
- Volume expansion confined to graphite pore volume preserves electrode mechanical integrity
