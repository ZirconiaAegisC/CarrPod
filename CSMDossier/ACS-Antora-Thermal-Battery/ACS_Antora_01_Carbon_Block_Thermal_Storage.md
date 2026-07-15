# ACS Antora Energy | Carbon Block Thermal Storage Architecture

## 1. Storage Medium Design

### Why Carbon (Graphite) Blocks
Antora selected solid carbon (graphite) as the thermal storage medium after evaluating multiple candidate materials. The selection criteria and tradeoffs:

| Material | Max Temperature | Heat Capacity (kJ/kg·K) | Density (g/cm³) | Cost ($/kg) | Oxidation Risk |
|----------|----------------|------------------------|-----------------|-------------|----------------|
| Graphite (carbon) | 3,000°C+ (sublimation) | 0.71 | 2.2 | $1-5 | High above 400°C in air |
| Alumina (Al₂O₃) | 2,050°C (melting) | 0.88 | 3.9 | $2-10 | None |
| Magnesia (MgO) | 2,850°C (melting) | 1.0 | 3.6 | $1-5 | None |
| Silicon carbide (SiC) | 2,730°C (decomposition) | 0.67 | 3.2 | $5-20 | Low |
| Firebrick (clay) | 1,200-1,600°C | 0.8-1.0 | 2.0-2.5 | $0.5-2 | None |

**Carbon's advantages:**
1. **Cost**: Graphite at $1-5/kg is among the cheapest high-temperature materials available at scale
2. **Temperature capability**: Carbon sublimates at ~3,650°C (in inert atmosphere), far above Antora's 1,800°C operating temperature; no melting concerns
3. **Supply chain maturity**: Graphite is produced globally at millions of tons per year for electrodes, refractories, and lubricants
4. **Thermal conductivity**: Graphite's high thermal conductivity (100-200 W/m·K) enables rapid heat distribution within blocks
5. **Thermal stability**: No phase changes between ambient and operating temperature; stable thermal cycling characteristics
6. **Heat capacity per dollar**: Despite moderate specific heat capacity, the combination of low cost and high temperature swing provides excellent energy storage density on a cost basis

**Carbon's challenges and mitigations:**
1. **Oxidation**: Carbon burns in air above ~400°C. Mitigated by sealed containers with inert argon atmosphere.
2. **Thermal expansion**: Anisotropic expansion of graphite must be accommodated in block and container design.
3. **Electrical conductivity**: Graphite is electrically conductive; resistive heating elements must be electrically isolated from blocks.

### Block Design
Antora's thermal storage medium consists of large solid graphite blocks with the following characteristics:

- **Dimensions**: Individual blocks approximately 1 meter on each side, weighing 1,500-2,000 kg each
- **Geometry**: Rectangular blocks with machined channels for resistive heating elements and thermal radiation pathways
- **Purity**: Industrial-grade graphite (>99% carbon); electrode-grade or similar specification
- **Porosity**: Moderate porosity (10-20%) to accommodate thermal expansion without cracking
- **Lifetime**: Solid carbon blocks have effectively unlimited cycle life; no degradation mechanism comparable to electrochemical battery degradation

### Alternative Carbon Forms
Antora's patent filings indicate exploration of alternative carbon block forms:
- **Compressed graphite powder**: Lower cost but lower thermal conductivity
- **Carbon-carbon composites**: Higher strength and thermal shock resistance but significantly higher cost
- **Recycled graphite**: Electrode scrap from steel electric arc furnaces as a low-cost, circular-economy feedstock

## 2. Thermal Architecture

### Container Design
The Antora thermal battery is housed in a standard ISO shipping container form factor (20-foot or 40-foot) modified for high-temperature operation:

- **Outer shell**: Standard steel container structure, modified with reinforced lifting points and foundation interface
- **Insulation layer**: Multi-layer insulation system capable of maintaining exterior surface temperature at safe levels (<60°C) while interior operates at 1,800°C
- **Atmosphere control**: Sealed container with argon purge system to maintain inert atmosphere; oxygen sensors continuously monitor for air infiltration
- **Electrical penetrations**: High-temperature feedthroughs for resistive heating elements and instrumentation
- **Radiation shielding**: Internal reflective shielding to direct thermal radiation toward TPV panels (when integrated)

### Thermal Insulation System
The insulation system is critical to Antora's economics — thermal losses directly determine the effective storage duration:

**Insulation Materials**:
| Layer | Material | Function | Thickness |
|-------|----------|----------|-----------|
| Hot face | Carbon fiber board | High-temperature stability (2,000°C+) | 50-100 mm |
| Intermediate | Microporous silica | Low thermal conductivity at moderate temperatures | 100-200 mm |
| Cold face | Mineral wool or fiberglass | Cost-effective insulation at lower temperatures | 100-200 mm |

**Thermal Performance**:
- **Standby heat loss**: <1% of stored energy per hour at full charge (1,800°C), declining as temperature drops
- **Effective storage duration**: 24-100+ hours, depending on insulation thickness and acceptable temperature drop
- **Thermal efficiency**: >90% round-trip thermal efficiency (heat in → heat out) for 24-hour storage

### Temperature Range and Operating Parameters
- **Maximum operating temperature**: 1,800°C (limited by insulation and container materials, not the carbon blocks)
- **Minimum useful temperature**: ~500°C (below this, radiative heat transfer to TPV cells drops significantly; still useful for direct heat applications)
- **Typical operating range**: 500-1,800°C
- **Usable temperature swing**: ~1,300°C
- **Heating rate**: Configurable; typical 4-6 hours for full recharge

## 3. Thermal Storage Capacity

### Energy Storage Density
- **Gravimetric energy density**: ~250 Wh/kg (thermal) based on 1,300°C usable temperature swing
- **Volumetric energy density**: ~500-600 kWh/m³ (thermal)
- **Per-container capacity**: 10-25 MWh-thermal per 40-foot container, depending on insulation fraction

### Comparison to Competing Storage Technologies
| Technology | Energy Density (kWh/m³) | Max Temperature | Heat Output | Electricity Output | Cost ($/kWh) |
|-----------|------------------------|----------------|-------------|-------------------|---------------|
| Antora Thermal Battery | 500-600 (thermal) | 1,800°C | Yes (direct) | Yes (TPV) | $20-50 (projected at scale) |
| Lithium-Ion Battery | 200-400 (electrical) | N/A (ambient) | No | Yes | $100-150 |
| Molten Salt Thermal | 200-300 (thermal) | 565°C | Yes (limited temp) | Yes (steam turbine) | $30-60 |
| Green Hydrogen Storage | 300-500 (chemical) | >1,000°C (combustion) | Yes | Yes (fuel cell/turbine) | $200-500+ |
| Pumped Hydro | 0.5-1.5 (potential) | N/A | No | Yes | $100-200 |

Antora's unique value proposition is the combination of very high temperature heat delivery (1,800°C vs. 565°C for molten salt) and electricity generation capability in a single integrated system.

## 4. Thermal Management and Control

### Charging (Heating)
1. Renewable electricity (from grid or dedicated solar/wind) passed through resistive heating elements
2. Elements embedded in channels within carbon blocks
3. Heating rate controlled to manage thermal gradients and prevent thermal shock
4. Uniform heating achieved through distributed element placement and graphite's high thermal conductivity
5. Target temperature (up to 1,800°C) reached in 4-6 hours

### Discharging (Heat Extraction)
1. For direct heat applications: Process air or other heat transfer fluid passed through heat exchanger channels adjacent to carbon blocks; temperature regulated by flow rate control
2. For TPV electricity generation: Thermal radiation from glowing carbon blocks directed toward TPV panels via reflective optical cavity
3. Discharge rate: Configurable from hours to days depending on application requirements
4. Isothermal discharge is possible (constant output temperature) by controlling heat extraction rate

### Thermal Cycling Durability
- Carbon blocks: No degradation mechanism identified; graphite is used in steel electric arc furnaces that cycle from ambient to 3,000°C daily
- Insulation: Thermal cycling can cause settling and degradation at hot face; design life of 10-20 years with replaceable hot face insulation
- Container: Thermal expansion joints and flexible seals accommodate dimensional changes during cycling
- Heaters: Resistive heating elements are the primary wear component; designed for replacement at 3-5 year intervals
