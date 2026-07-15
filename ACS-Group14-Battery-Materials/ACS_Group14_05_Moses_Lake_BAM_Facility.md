# ACS Group14 | Moses Lake BAM Manufacturing Facility

## 1. Facility Overview

### BAM (Battery Active Materials) Factory 1
The Moses Lake BAM facility is Group14's first commercial-scale production plant for SCC55. Located in central Washington State, the facility represents the company's transition from laboratory and pilot-scale production to commercial manufacturing.

### Facility Specifications
| Parameter | Detail |
|-----------|--------|
| Location | Moses Lake, Grant County, Washington |
| Site Area | 2,000 square meters (manufacturing floor) |
| Groundbreaking | 2022 |
| Inauguration | Q2 2023 |
| Annual Nameplate Capacity | 100 metric tons SCC55 |
| Construction Cost | Approximately $40M |
| Employment | ~50 direct manufacturing jobs |

### Strategic Location Rationale
Moses Lake was selected for multiple strategic reasons:
1. **Low-cost hydroelectric power**: Grant County PUD provides electricity at $0.03-0.04/kWh, critical for energy-intensive carbon pyrolysis and CVD silicon deposition processes. This is among the lowest industrial electricity rates in the United States.
2. **Existing industrial infrastructure**: Moses Lake hosts silicon and carbon industries including REC Silicon (polysilicon) manufacturing, creating a skilled workforce familiar with silane chemistry and high-temperature processing.
3. **Proximity to silane supply**: REC Silicon's Moses Lake facility produces silane (SiH₄), the key silicon precursor for SCC55's CVI process. Co-location reduces transportation costs and supply chain risk.
4. **Available industrial land**: Large parcels of affordable industrial-zoned land for future expansion (BAM-2, BAM-3).
5. **State incentives**: Washington State tax incentives for clean energy manufacturing, including reduced B&O tax rates for renewable energy technology manufacturing.

## 2. Manufacturing Process Flow

### Stage 1: Carbon Scaffold Production
1. **Precursor mixing**: Polymer precursor blended with pore-forming template agents in solvent
2. **Casting/drying**: Solution cast into thin sheets or extruded into pellets; solvent recovered
3. **Stabilization**: Controlled heating in air at 200-300°C; polymer chains cross-link via oxygen
4. **Carbonization**: Pyrolysis in nitrogen atmosphere at 800-1,200°C in continuous belt furnace
5. **Template removal**: Chemical etching to remove silica templates (if used); acid waste neutralized on-site
6. **Milling and classification**: Carbon scaffold ground to target particle size distribution; classified by air jet sieving

### Stage 2: Silicon Infiltration (CVI Process)
1. **Carbon loading**: Carbon scaffold charged into CVD reactor vessels
2. **Precursor introduction**: Silane gas (SiH₄) diluted in inert carrier (N₂ or Ar) introduced to reactor
3. **Thermal decomposition**: Reactor heated to 400-600°C; SiH₄ decomposes on carbon pore surfaces
4. **Deposition control**: Gas flow rate, temperature, and residence time precisely controlled to achieve target silicon loading (40-60 wt%)
5. **Cooldown and passivation**: Reactor cooled under inert atmosphere; controlled air exposure forms protective native oxide
6. **Product discharge**: SCC55 powder discharged from reactors into sealed containers under dry room conditions

### Stage 3: Post-Processing
1. **De-agglomeration**: Gentle milling to break up any soft agglomerates formed during CVI
2. **Final classification**: Air classification to ensure particle size specification
3. **Quality testing**: BET surface area, silicon content (TGA), particle size distribution, tap density, electrochemical performance (coin cell cycling)
4. **Packaging**: Vacuum-sealed in moisture-barrier packaging under dry room conditions (<1% RH, dew point <-40°C)

## 3. Scale-Up Philosophy

### Modular Scale-Up Approach
Group14 employs a modular manufacturing strategy rather than building a single monolithic plant:
- BAM-1 (100 tons/yr) serves as the commercial validation module
- Process learnings from BAM-1 directly inform BAM-2 design
- Each subsequent module replicates proven unit operations at larger scale
- This approach reduces technology risk compared to a single leap to 10,000 ton scale

### Critical Scale-Up Parameters
The transition from lab to BAM-1 involved solving:
1. **Thermal uniformity**: Maintaining ±5°C temperature uniformity across large carbonization and CVI reactor volumes
2. **Gas distribution**: Ensuring uniform silane concentration across the entire carbon bed for consistent silicon loading
3. **Residence time distribution**: Preventing localized over-deposition causing silicon crystallite formation (>50 nm)
4. **Material handling**: Moving fine carbon and SCC55 powders without contamination or moisture exposure
5. **Silane safety**: Managing silane's pyrophoric nature at industrial scale — silane ignites spontaneously in air

## 4. Quality Control Infrastructure

### In-Process Testing
- **At-line particle size analysis**: Laser diffraction every 2 hours during milling
- **On-line TGA**: Silicon content measured in near-real-time via automated thermogravimetric analysis
- **BET surface area**: Every production lot (nitrogen physisorption, 5-point method)
- **Trace metals**: ICP-MS analysis for Fe, Cr, Ni, Cu (cathode poisons) — must be <50 ppm total

### Electrochemical Quality Assurance
Every production lot undergoes electrochemical validation:
- **Coin cell testing** (half-cell vs. lithium): Measures specific capacity, first-cycle efficiency, rate capability
- **Pouch cell testing** (full cell vs. NMC811): 50-cycle screening for capacity retention
- **Statistical process control**: Capacity and FCE tracked on control charts; out-of-specification lots quarantined

### Customer Qualification Batches
- **Key customer qualification lots**: 10-50 kg produced under enhanced quality oversight
- **Full characterization package**: XRD (silicon crystallinity), SEM/TEM (morphology), XPS (surface chemistry), electrochemical impedance spectroscopy
- **Traceability**: Full batch genealogy from precursor lot to finished product

## 5. Environmental and Safety Systems

### Silane Safety
Silane (SiH₄) is pyrophoric and requires extensive safety systems:
- Double-walled gas piping with interstitial nitrogen purge
- Continuous gas detection with automatic shutoff valves
- Burn-off stacks for emergency venting
- Dedicated silane sensor network throughout CVI area
- Emergency response training specific to silane fires

### Emissions Control
- **Carbonization off-gases**: Volatile organic compounds (VOCs) from polymer decomposition captured and thermally oxidized
- **CVD off-gases**: Unreacted silane and hydrogen byproduct captured and combusted
- **Acid neutralization**: Template etching generates acidic wastewater; neutralized to pH 6-8 before discharge
- **Particulate control**: HEPA filtration on all powder handling areas; baghouse dust collection on milling and classification

### Water Usage
- Moses Lake is in a semi-arid region; water conservation is critical
- Closed-loop cooling water systems for thermal processes
- Water recycling from acid neutralization and scrubber systems
- Total water usage: estimated 50,000-100,000 gallons per day for BAM-1
