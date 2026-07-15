# ACS Group14 | SCC55 Silicon-Carbon Composite Architecture

## 1. Material Composition Overview

SCC55 is a silicon-carbon composite anode material engineered as a drop-in replacement for graphite in lithium-ion battery anode slurries. The designation "SCC" stands for Silicon-Carbon Composite, and "55" refers to the target specific capacity of ~550 mAh/g at the composite level, representing approximately 50% improvement over graphite (~360 mAh/g theoretical).

### Physical Form
- Fine black powder with controlled particle size distribution
- D10: ~5 µm, D50: ~15 µm, D90: ~30 µm
- Tap density: 0.8-1.1 g/cm³ (comparable to commercial graphite grades)
- BET surface area: 5-15 m²/g (optimized for first-cycle efficiency vs. capacity)

## 2. Carbon Scaffold Engineering

### Porous Carbon Matrix
The carbon scaffold is the foundational architecture of SCC55. Group14 synthesizes a hierarchically porous carbon material with:

- **Macropores** (>50 nm): Provide pathways for electrolyte infiltration and lithium-ion transport
- **Mesopores** (2-50 nm): Host the majority of silicon domains, sized to accommodate expansion without fracturing
- **Micropores** (<2 nm): Increase surface area for electrolyte interaction while too small for silicon infiltration

### Carbon Precursor and Synthesis
Group14 utilizes a polymer-derived carbon approach:
1. Carbon precursor polymer is templated against a sacrificial pore-forming agent
2. Controlled pyrolysis under inert atmosphere converts polymer to turbostratic carbon
3. Pore structure is tuned via precursor chemistry, template ratio, and thermal profile
4. Post-synthesis activation (controlled oxidation or chemical activation) further refines pore architecture

### Turbostratic Carbon Properties
The carbon scaffold exhibits turbostratic (disordered graphitic) structure rather than highly crystalline graphite:
- Interlayer spacing: 0.35-0.38 nm (vs. 0.335 nm for graphite)
- Enables lithium intercalation without the staging transitions that cause mechanical stress in graphite
- Provides isotropic electronic conductivity (~1-10 S/cm) unmatched by oriented graphite
- Surface oxygen functional groups (carboxyl, hydroxyl, carbonyl) enhance electrolyte wetting and SEI adhesion

## 3. Silicon Incorporation Methodology

### Chemical Vapor Infiltration (CVI)
Group14's core manufacturing IP centers on a chemical vapor infiltration process:

1. **Precursor Gas**: Silane (SiH₄) or chlorosilanes are flowed through the porous carbon bed
2. **Thermal Decomposition**: At elevated temperature (400-600°C), precursor decomposes, depositing amorphous silicon
3. **Capillary Condensation**: Silicon preferentially nucleates within mesopores via capillary condensation
4. **Controlled Loading**: Silicon content is precisely tuned (typically 40-60 wt% of composite) by controlling precursor concentration, residence time, and temperature

### Amorphous vs. Crystalline Silicon
The deposited silicon is engineered to remain in an amorphous state (a-Si), which is critical for performance:
- **Amorphous silicon** lithiates isotropically, with volume expansion distributed uniformly
- **Crystalline silicon** undergoes anisotropic expansion (~400% along <110>), causing particle fracture
- a-Si lithiation potential is ~0.2V vs Li/Li⁺, slightly higher than c-Si (~0.1V), providing a small overpotential buffer against lithium plating

### Silicon Domain Engineering
- Domain size: 5-50 nm (ensures nanoscale diffusion distances for lithium)
- Dopants: Trace nitrogen or boron incorporation from precursor chemistry modifies electronic conductivity
- Surface termination: Si-H bonds from silane decomposition are partially converted to Si-O via controlled air exposure, forming a native oxide that participates in SEI formation

## 4. Composite Particle Architecture

### Core-Shell vs. Dispersed Morphology
SCC55 particles exhibit a dispersed morphology rather than a strict core-shell structure:
- Silicon domains are distributed throughout the carbon particle volume
- The outer ~2-5 µm of each particle is intentionally silicon-depleted, forming a carbon-rich "rind"
- This rind serves as a mechanical constraint layer and provides a carbon-rich surface for SEI formation

### Inter-Particle Porosity
- Intraparticle porosity: 30-50% by volume (within carbon scaffold)
- Interparticle porosity: 25-35% in electrode after calendaring
- Total electrode porosity: 30-40%, comparable to graphite electrodes (28-35%)

## 5. Electrochemical Performance Characteristics

### Capacity and Voltage Profile
| Property | SCC55 | Graphite Benchmark |
|----------|-------|-------------------|
| Specific Capacity (mAh/g composite) | 500-600 | 340-360 |
| Volumetric Capacity (mAh/cm³ electrode) | 800-950 | 500-550 |
| Average Delithiation Voltage (V vs. Li/Li⁺) | 0.4 | 0.15 |
| First-Cycle Efficiency (%) | 88-92 | 92-95 |
| Areal Capacity (mAh/cm²) | 3.0-4.5 | 3.0-4.0 |

### Rate Capability
- 1C capacity retention: >90% of C/5 capacity
- 5C capacity retention: >70% of C/5 capacity
- Rate performance is limited primarily by solid-state lithium diffusion in silicon, not by carbon scaffold conductivity

### Cycling Stability
- >1,000 cycles to 80% capacity retention at C/2 charge, 1C discharge
- Calendar aging: <5% capacity loss over 6 months at 45°C, 100% SOC
- Gas generation comparable to graphite anodes in full-cell configuration with NMC811 cathode

## 6. Electrode Formulation

### Standard Formulation
- 90-94 wt% SCC55 active material
- 3-5 wt% CMC/SBR binder system (aqueous processing)
- 2-3 wt% conductive carbon additive (Super P or Ketjenblack)
- Coating thickness: 50-100 µm per side on copper foil (8-12 µm)
- Calendaring pressure: 10-20% lower than graphite to preserve interparticle porosity

### Compatibility with Existing Manufacturing
SCC55 is engineered to be a true drop-in replacement:
- Compatible with aqueous slurry processing (no solvent change required)
- Coat-able on standard reverse-comma or slot-die coating equipment
- Calendaring parameters similar to high-capacity graphite grades
- Electrolyte compatibility with standard LiPF₆ in carbonate solvents
