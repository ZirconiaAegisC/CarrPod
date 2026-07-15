# ACS Antora Energy | TPV Cell Manufacturing & Supply Chain

## 1. III-V Semiconductor Manufacturing Landscape

### TPV Cell Supply Chain Architecture
Antora's TPV cells are based on III-V compound semiconductors (InGaAs, InGaAsSb on InP or GaAs substrates). The supply chain for these materials is fundamentally different from the silicon semiconductor supply chain that dominates solar photovoltaics:

| Supply Chain Element | Silicon PV | III-V TPV (Antora) |
|---------------------|-----------|---------------------|
| Substrate | Silicon wafer (Czochralski process) | InP or GaAs wafer (Czochralski or VGF process) |
| Active layer deposition | Diffusion or thin-film deposition | Epitaxial growth (MOCVD, MBE) |
| Manufacturing scale | >300 GW/year globally | <1 GW/year (optoelectronics industry) |
| Wafer size | 210 mm (mainstream) | 100-150 mm (typical III-V) |
| Cost per wafer | $2-5 (210 mm Si) | $100-500 (100 mm InP) |
| Cost per watt (cell) | $0.10-0.20/W | $1-5/W (current); $0.50-1.00/W (volume target) |

### III-V Manufacturing Infrastructure
The existing III-V semiconductor industry serves optoelectronics applications (LEDs, laser diodes, photodetectors, RF amplifiers) and is concentrated in:
- **United States**: Multiple foundries (IQE, IntelliEPI, various defense contractors)
- **Taiwan**: WIN Semiconductors, Advanced Wireless Semiconductor Company (AWSC)
- **Japan**: Sumitomo Electric, Mitsubishi Chemical
- **Europe**: IQE (UK), OMMIC (France)

Total global III-V epitaxial wafer production is estimated at 5-10 million wafers (100 mm equivalent) per year, representing ~100-200 MW of annual production capacity if used entirely for TPV cells. Scaling TPV production to meet industrial thermal battery deployment at the GW scale would require significant III-V manufacturing capacity expansion.

## 2. TPV Cell Cost Reduction Pathway

### Current Cost Structure (Illustrative)
| Cost Element | % of Total Cell Cost | Cost Reduction Lever |
|-------------|----------------------|---------------------|
| Substrate (InP or GaAs wafer) | 30-40% | Larger wafers, recycled substrates, alternative substrates |
| Epitaxial growth (MOCVD) | 25-35% | Higher throughput reactors, larger wafer capacity, reduced layer complexity |
| Device fabrication (patterning, contacts, AR coating) | 15-20% | Standardization, automation, wafer-scale processing |
| Testing and binning | 5-10% | Improved yield, reduced testing requirements |
| Packaging and integration | 10-15% | Automated assembly, standardized panel designs |

### Cost Reduction Levers

**Lever 1: Wafer Size Scale-Up**
- Current: 100 mm (4-inch) InP wafers
- Target: 150 mm (6-inch) InP wafers
- Impact: 2.25x more cells per wafer; processing cost per unit area decreases ~30%
- Status: 150 mm InP substrates are commercially available but not widely used; epitaxial growth uniformity at 150 mm requires reactor qualification

**Lever 2: Epitaxial Growth Throughput**
- Current: MOCVD reactors processing 10-20 wafers per growth run
- Target: Higher-capacity reactors (50-100 wafers per run) and shorter growth cycles
- Impact: 2-5x reduction in epitaxial cost per wafer
- Status: MOCVD equipment manufacturers (Aixtron, Veeco) offer high-throughput platforms designed for LED manufacturing; adapting for TPV layer structures requires development

**Lever 3: Substrate Reuse**
- III-V substrates are expensive because the crystal growth process is slow and energy-intensive
- Substrate reuse techniques (epitaxial lift-off, spalling) can separate the active epitaxial layers from the substrate, allowing the substrate to be reused multiple times
- Impact: 50-80% reduction in substrate cost per cell
- Status: Demonstrated in research; not yet deployed at commercial scale; requires development of reliable, high-yield lift-off processes

**Lever 4: Alternative Substrates**
- Silicon substrates with III-V epitaxial layers (heteroepitaxy) would dramatically reduce substrate cost
- Challenge: Lattice mismatch between silicon and III-V materials causes defects that reduce efficiency
- Impact: Potential 10x substrate cost reduction IF defect challenges can be solved
- Status: Active research area; not yet commercially viable for high-efficiency devices

**Lever 5: Manufacturing Scale Economics**
- Production volume increase from pilot (MW/year) to commercial (GW/year)
- Impact: Learning curve effects across all cost elements; 15-20% cost reduction per doubling of cumulative production
- Status: Requires demand certainty — customer commitments that justify capacity investment

### Cost Trajectory Projections
| Year | Annual TPV Production | Cell Cost ($/W) | Key Enabler |
|------|----------------------|-----------------|-------------|
| 2024 | <1 MW | $3-5/W | Pilot production, existing foundry |
| 2026 | 10-50 MW | $1-3/W | Dedicated production line, 150 mm wafers |
| 2028 | 100-500 MW | $0.50-1.50/W | Manufacturing scale, substrate reuse |
| 2030 | 1-5 GW | $0.30-0.80/W | Volume manufacturing, learning curve |
| 2035 | 10-50 GW | $0.15-0.50/W | Fully scaled supply chain, alternative substrates |

## 3. Manufacturing Location Strategy

### Near-Term: Outsourced Foundry Model (2024-2026)
- Antora designs TPV cell structure; manufacturing outsourced to existing III-V semiconductor foundries
- Advantages: Leverages existing capital equipment; faster time to market; variable cost structure
- Disadvantages: Higher per-unit cost; limited control over process optimization; capacity constrained by foundry availability outside of optoelectronics market cycles

### Medium-Term: Dedicated Contract Manufacturing (2026-2030)
- Antora qualifies a dedicated production line at a contract manufacturer
- Antora specifies equipment, process parameters, and quality control; manufacturer operates the line
- Advantages: Antora-specific process optimization; cost reduction from dedicated capacity; balance of control and capital efficiency
- Disadvantages: Requires volume commitments to justify dedicated capacity; still a margin paid to the manufacturer

### Long-Term: Owned Manufacturing (2030+, if scale justifies)
- Antora builds and operates its own TPV cell manufacturing facility
- Advantages: Full control over cost, quality, and technology roadmap; captures manufacturing margin; protects trade secrets
- Disadvantages: Capital intensive ($200-500M for GW-scale III-V facility); manufacturing operations are different from Antora's core engineering competencies

The IRA Section 45X advanced manufacturing production credit for US-manufactured solar and energy components could apply to TPV cells manufactured in the US, significantly improving the economics of domestic manufacturing.

## 4. Materials Supply Chain

### Critical Materials Assessment
| Material | Function | Supply Chain Risk | Notes |
|----------|----------|------------------|-------|
| Indium (In) | InGaAs absorber layer constituent | Moderate | Byproduct of zinc refining; supply limited by zinc production; ITO demand (displays, solar) competes |
| Gallium (Ga) | InGaAs, GaAs substrate | Low | Abundant; byproduct of aluminum refining; current supply exceeds demand |
| Arsenic (As) | InGaAs, GaAs | Low | Byproduct of copper, lead, zinc smelting; adequate supply |
| Antimony (Sb) | InGaAsSb absorber | Moderate | Limited production concentrated in China, Russia, Tajikistan; supply chain diversity concern |
| Indium Phosphide (InP) | Substrate | Moderate | Specialized crystal growth; limited number of substrate suppliers (Sumitomo, AXT, JX Nippon) |
| Germanium (Ge) | Alternative substrate | Moderate | Byproduct of zinc refining; limited production; used in multi-junction space solar cells |

### Supply Chain Concentration Risks
- **China dominance**: China controls significant portions of gallium, germanium, and antimony refining capacity. Export controls on gallium and germanium imposed in 2023 highlight geopolitical supply chain risk.
- **Mitigation**: Antora can specify alternative semiconductor compositions that reduce or eliminate reliance on geopolitically concentrated materials. Silicon-based TPV cells (lower efficiency but lower cost and supply chain risk) are a potential long-term alternative for less demanding applications.

## 5. Quality and Reliability

### TPV Cell Degradation Modes
TPV cells operating in a thermal battery environment face unique degradation challenges:

1. **Thermal cycling stress**: Cells may experience temperature variations as thermal battery cycles, though active cooling maintains cell temperature within specified range
2. **High photon flux**: TPV cells operate at much higher illumination intensity (>10 W/cm²) than solar cells (0.1 W/cm²), accelerating any photo-induced degradation mechanisms
3. **Infrared-specific degradation**: Infrared photon absorption may cause different degradation modes than visible-light (solar) operation
4. **Contamination from thermal battery environment**: Despite the sealed optical cavity, trace contaminants from the hot carbon blocks could deposit on TPV cell surfaces over time

### Reliability Testing Program
Antora's TPV reliability qualification likely includes:
- **Accelerated life testing**: Elevated temperature, elevated illumination, and thermal cycling at accelerated rates to project 20-year field life
- **Damp heat testing**: 85°C/85% relative humidity to assess moisture sensitivity
- **Thermal cycling**: -40°C to +85°C cycling to simulate outdoor ambient conditions
- **Long-duration operational testing**: Continuous operation at design conditions to validate degradation rates

### Warranty and Performance Guarantees
Antora's commercial offering must include performance warranties on TPV electricity output:
- **Initial capacity**: Guaranteed electrical output at commissioning
- **Annual degradation**: Estimated 0.5-1.0% per year (comparable to silicon solar panels; actual rate to be validated through field data)
- **Warranty period**: 10-20 years, matching the carbon block and insulation system life
- **Performance guarantee**: If TPV output falls below warranty threshold, Antora replaces or supplements TPV panels
