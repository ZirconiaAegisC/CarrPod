# ACS Group14 | Carbon Scaffold Engineering & Synthesis

## 1. Carbon Scaffold as Competitive Moat

The carbon scaffold is the core intellectual property differentiating Group14 from competing silicon anode approaches. While multiple companies deposit silicon into or onto carbon, Group14's proprietary carbon synthesis — the precursor chemistry, pore templating, and thermal processing — defines SCC55's performance characteristics and manufacturing economics.

### Why the Scaffold Matters
The carbon host determines:
- Maximum silicon loading without structural degradation
- Electronic conductivity pathways through the composite particle
- Electrolyte accessibility and lithium-ion transport rates
- SEI formation location and quality
- Composite particle mechanical integrity during cycling
- Material cost structure (precursor cost, process energy, yield)

## 2. Carbon Precursor Chemistry

### Polymer-Derived Carbon Approach
Group14 uses synthetic polymer precursors rather than natural carbon sources (biomass, pitch, etc.). This approach provides:

**Advantages of Synthetic Precursors**:
- Molecular-level control over carbon structure
- Reproducible pore architecture (natural precursors have batch variability)
- Tunable heteroatom doping (N, O, B) for conductivity and SEI chemistry
- Predictable thermal decomposition behavior

**Precursor Families**:
- Polyacrylonitrile (PAN): High carbon yield (~50%), nitrogen-doped carbon after pyrolysis
- Phenol-formaldehyde (resol/novolac): High cross-linking density, good pore templating
- Polyfurfuryl alcohol (PFA): High oxygen content, oxygen functional groups in final carbon
- Block copolymers: Self-assembling templates for uniform pore size distribution

### Template Selection
Pore architecture is created via sacrificial templating:
- **Hard templates**: Silica nanoparticles (removed by HF or NaOH etch), providing precise mesopore control
- **Soft templates**: Amphiphilic block copolymers (Pluronic F127, P123) that self-assemble and are removed during pyrolysis
- **Dual templating**: Combination of hard and soft templates for hierarchical porosity
- **Template removal**: Critical process step — residual template contaminates final product and impairs electrochemical performance

## 3. Thermal Processing

### Stabilization Stage (200-300°C, Air)
- Oxygen cross-links polymer chains, preventing melting during carbonization
- Critical for maintaining pore architecture — insufficient stabilization causes pore collapse
- Duration: 2-6 hours depending on precursor and part geometry

### Carbonization Stage (800-1,200°C, Inert)
- Polymer backbone converts to turbostratic carbon
- Non-carbon elements (H, O, N) are evolved as volatiles
- Graphitic domains nucleate and grow, but remain turbostratic (no long-range order)
- Pore structure partially contracts; final porosity determined by precursor-template ratio
- Carbon yield: 30-50% depending on precursor chemistry

### Activation Stage (Optional, 700-900°C, CO₂ or Steam)
- Controlled oxidation creates additional microporosity
- Increases BET surface area from ~5 m²/g to 10-50 m²/g
- Introduces oxygen functional groups that improve electrolyte wetting
- Trade-off: higher surface area reduces first-cycle efficiency due to increased SEI formation

### Graphitization (Optional, 2,000-3,000°C, Inert)
- Not typically used by Group14 — SCC55 relies on turbostratic carbon
- Graphitization would collapse mesopores needed for silicon hosting
- Competitors using graphite hosts (e.g., Sila's graphite-silicon composite) require high-purity graphite substrates

## 4. Pore Architecture Optimization

### Design Targets
| Parameter | Target | Rationale |
|-----------|--------|-----------|
| Total pore volume | 0.8-1.5 cm³/g | Accommodates 40-60 wt% silicon at full lithiation expansion |
| Mesopore fraction | 60-80% of total PV | Silicon preferentially deposits in mesopores |
| Average mesopore diameter | 8-25 nm | Large enough for silane diffusion, small enough to constrain silicon domain size |
| Micropore volume | <0.2 cm³/g | Micropores increase irreversible capacity without hosting silicon |
| Macropore volume | 0.1-0.3 cm³/g | Electrolyte reservoir and ion transport highways |

### Pore Size Distribution Engineering
The ideal pore size distribution for SCC55 is bimodal:
- **Primary population**: 10-20 nm mesopores — these host the bulk of deposited silicon
- **Secondary population**: 50-100 nm macropores — these provide electrolyte channels and expansion buffer

Controlling this distribution requires precise template-to-precursor ratio control and uniform template dispersion during precursor mixing.

## 5. Surface Chemistry Engineering

### Oxygen Functional Groups
Controlled oxidation introduces surface oxygen groups that influence SEI formation:
- **Carboxyl groups** (-COOH): Participate in SEI-forming reactions, consume lithium during first cycle
- **Hydroxyl/Phenol groups** (-OH): Improve electrolyte wetting, contribute to irreversible capacity
- **Carbonyl/Quinone groups** (>C=O): Reversible lithium storage, contribute to capacity beyond intercalation
- **Optimal oxygen content**: 2-5 wt% — balances SEI formation benefit against FCE penalty

### Heteroatom Doping
- **Nitrogen doping** (from PAN or post-treatment): N-5 (pyrrolic) and N-6 (pyridinic) configurations enhance electronic conductivity and lithium storage
- **Boron doping**: Substitutional boron in carbon lattice increases lithium intercalation capacity
- **Phosphorus doping**: Improves oxidation resistance and SEI stability at elevated temperatures

## 6. Scale-Up Considerations

### Precursor Cost and Availability
- Synthetic polymer precursors are more expensive than natural graphite ($15-30/kg vs. $5-10/kg)
- Cost is amortized over the composite — SCC55 targets $15-25/kg at scale (BAM-2)
- PAN is commodity-scale (acrylic fiber industry), providing supply security
- Silica template costs are minimal but template recovery/recycling economics are critical

### Thermal Process Economics
- Carbonization is energy-intensive: ~5-10 kWh/kg of carbon produced
- Moses Lake's hydroelectric power ($0.03-0.04/kWh) provides significant cost advantage
- Continuous rotary kiln or belt furnace processing is more economical than batch
- Process yield through all thermal steps: 25-40% (from raw precursor to finished carbon scaffold)

### Quality Control Metrics
| Parameter | Specification | Method |
|-----------|--------------|--------|
| Pore volume | ±5% of target | Nitrogen physisorption (BJH) |
| Surface area | ±10% of target | BET |
| Oxygen content | 2-5 wt% | XPS or elemental analysis |
| Particle size D50 | ±2 µm of target | Laser diffraction |
| Tap density | >0.85 g/cm³ | Standard tap density measurement |
| Electronic conductivity | >5 S/cm | Four-point probe on pressed pellet |
