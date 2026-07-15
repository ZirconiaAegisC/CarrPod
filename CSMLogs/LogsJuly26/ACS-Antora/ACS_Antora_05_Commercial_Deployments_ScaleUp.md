# ACS Antora Energy | Commercial Deployments & Manufacturing Scale-Up

## 1. First Commercial Installation (California, 2024)

### Installation Overview
Antora's first commercial thermal battery installation represents the world's first industrial-scale TPV-equipped thermal battery. Key parameters (publicly available):

- **Location**: California (specific facility not publicly named; described as a manufacturing facility)
- **Application**: Industrial process heat and on-site power generation
- **System configuration**: Multiple 40-foot containerized thermal battery modules
- **Storage capacity**: Not publicly disclosed; estimated 10-25 MWh-thermal per container, total system capacity likely in the 50-100 MWh-thermal range
- **TPV power output**: Not publicly disclosed; estimated 1-5 MW electrical based on system size and TPV efficiency

### Significance as a First-of-Its-Kind Deployment
This installation validates several critical assumptions:

1. **Engineering at scale**: Thermal battery components (carbon blocks, insulation, heaters, TPV panels) can be integrated into a functional, containerized system operating at 1,800°C
2. **Manufacturing capability**: Antora can produce complete thermal battery systems, not just laboratory prototypes
3. **Customer acceptance**: An industrial customer has committed capital and facility integration to a novel thermal storage technology
4. **Regulatory pathway**: Permitting, safety approvals, and grid interconnection have been successfully navigated
5. **Operational data**: Real-world performance data (thermal efficiency, TPV output, reliability, maintenance requirements) is being accumulated

### Learnings and Iteration
First-of-its-kind deployments invariably reveal design issues and optimization opportunities:
- Thermal cycling behavior of full-scale carbon blocks and insulation under daily charge/discharge
- TPV cell performance and degradation over extended operation in industrial environments
- Balance-of-system reliability (argon atmosphere maintenance, heater element life, power electronics)
- Customer integration challenges (thermal interfaces to existing process equipment, control system integration, operational workflow changes)

Data from this first installation will inform the second-generation product design, expected to incorporate learnings into a more cost-optimized and reliable system.

## 2. Manufacturing Strategy

### Make-vs-Buy Analysis
Antora's manufacturing strategy involves a mix of in-house production and outsourced components:

**In-House (Core IP)**:
- TPV cell design and epitaxial growth specifications (actual manufacturing may be outsourced to III-V semiconductor foundries)
- Optical cavity and reflector design
- System integration and testing
- Control system software

**Outsourced (Commodity/Standard Components)**:
- Carbon (graphite) blocks: Sourced from graphite electrode manufacturers (e.g., GrafTech, SGL Carbon, Tokai Carbon)
- Insulation materials: High-temperature insulation suppliers (e.g., Unifrax, Morgan Advanced Materials, Promat)
- ISO containers: Standard intermodal container manufacturers
- Resistive heating elements: Industrial heating element manufacturers (e.g., Kanthal, Watlow)
- Power electronics (inverters, DC-DC converters): Standard industrial power electronics (e.g., ABB, Siemens, Schneider Electric)
- Argon gas supply: Industrial gas companies (e.g., Linde, Air Liquide, Air Products)

### Production Scaling Strategy
Antora's production is expected to follow a phased ramp:

**Phase 1: Pilot Production (2023-2024)**
- In-house assembly of first commercial units at Sunnyvale facility
- Low volume: 5-10 containers/year
- Labor-intensive assembly with significant engineering involvement
- Focus: First deployment and operational validation

**Phase 2: Initial Manufacturing (2025-2026)**
- Dedicated assembly facility (location TBD; likely California or Nevada for proximity to initial customers)
- Volume: 50-100 containers/year
- Semi-automated assembly; standardized work instructions; quality management system
- Focus: Cost reduction, supply chain qualification, process repeatability

**Phase 3: Volume Manufacturing (2027-2030)**
- Full-scale production facility (location influenced by customer geography and incentives)
- Volume: 500-1,000+ containers/year (500 MW-thermal to 2 GW-thermal annual capacity)
- Automated assembly lines; just-in-time supply chain; statistical process control
- Target cost: <$30/kWh-thermal capital cost (corresponds to ~$500K-750K per container)

### Manufacturing Workforce Requirements
Thermal battery manufacturing draws from multiple skilled trades:
- **Mechanical assembly**: Container modification, insulation installation, structural assembly
- **Electrical assembly**: Heater element installation, power wiring, control system integration
- **TPV panel assembly**: Clean-room or controlled-environment assembly of semiconductor panels
- **Testing and commissioning**: Factory acceptance testing of complete thermal battery modules
- **Welding and fabrication**: Container modifications, piping (argon, cooling water), structural supports

## 3. Supply Chain Development

### Critical Supply Chain Elements

**Graphite Blocks**:
- Annual demand at scale (1,000 containers/year): ~5,000-10,000 metric tons of graphite
- Total global graphite electrode market: ~750,000 metric tons/year (for steel EAF)
- Antora's demand is a small fraction of existing graphite production; supply is not a constraint
- Quality requirements: Moderate (industrial-grade; porosity and impurity specifications; no ultra-high-purity requirement)
- Preferred suppliers: US or FTA-country producers for IRA compliance

**III-V Semiconductor Wafers (for TPV cells)**:
- Annual demand at scale: ~50,000-200,000 wafers (6-inch equivalent) per 100 MW-thermal
- Current III-V wafer production: Dominated by optoelectronics (LEDs, laser diodes, photodetectors); capacity exists but at higher cost than silicon
- Cost reduction pathway: Volume manufacturing, larger wafer sizes, reduced purity specifications relative to optoelectronics
- Strategic importance: TPV cell cost is a major driver of system capital cost; semiconductor supply chain development is critical

**High-Temperature Insulation**:
- Mature supply chain serving steel, glass, ceramics, and petrochemical industries
- Multiple qualified suppliers
- Antora's demand at scale is manageable within existing industry capacity

### IRA and Domestic Content Considerations
The Inflation Reduction Act includes domestic content requirements for clean energy tax credits:
- Antora systems that use US-manufactured components (containers, graphite, insulation, steel structures) qualify for higher incentive rates
- TPV cell manufacturing location is critical: cells manufactured in the US or FTA countries maximize IRA benefit
- Antora's initial strategy is likely US-based assembly with a mix of domestic and imported components, trending toward higher domestic content as US suppliers qualify

## 4. Project Deployment Economics

### Capital Cost Breakdown (Illustrative, 40-foot Container Module)
| Component | Estimated Cost | % of Total |
|-----------|---------------|-----------|
| Graphite blocks | $50-100K | 10-20% |
| High-temperature insulation | $50-100K | 10-20% |
| Container and structural steel | $20-40K | 5-10% |
| Resistive heating elements | $50-80K | 10-15% |
| TPV panels (cells, cooling, mounting) | $100-200K | 25-35% |
| Power electronics (inverter, DC-DC, controls) | $50-80K | 10-15% |
| Assembly labor and testing | $30-60K | 5-10% |
| Argon system and auxiliaries | $20-40K | 5-10% |
| **Total per container** | **$370-700K** | |
| **Cost per kWh-thermal** | **$20-40/kWh** | |

### Installed System Cost
The installed cost to a customer includes:
- Equipment cost (Antora modules): $20-40/kWh-thermal
- Site preparation and foundations: 10-20% of equipment
- Installation (electrical, thermal connections): 10-20% of equipment
- Integration with existing facility systems: 10-30% of equipment (varies by facility)
- **Total installed cost**: $30-60/kWh-thermal

### Levelized Cost of Storage (LCOS)
For a 100 MWh-thermal system with TPV electricity generation:

| Parameter | Value |
|-----------|-------|
| Capital cost (installed) | $4-6M |
| Annual O&M | 1-2% of capital cost |
| Charging electricity cost | $20/MWh (daytime solar) |
| Thermal efficiency | 90% |
| TPV electrical efficiency | 30% |
| Usable energy per cycle (thermal) | 80% of capacity (500-1,800°C range) |
| Cycles per year | 365 |
| System life | 20 years |
| **LCOS (thermal output)** | **$25-45/MWh-thermal** |
| **LCOS (electrical output)** | **$80-150/MWh-electrical** |

### Competitiveness Assessment
- **Thermal output**: $25-45/MWh-thermal is competitive with US natural gas ($15-25/MWh) only with incentives; competitive with EU natural gas ($40-60/MWh with carbon pricing) without additional incentives
- **Electrical output**: $80-150/MWh-electrical is competitive with gas peaker plants ($100-200/MWh) and approaches baseload competitiveness in high-cost markets
- **Combined heat and power**: When both heat and power outputs are valued, Antora's economics are strongly favorable vs. separate heat and power systems

## 5. Project Pipeline and Customer Acquisition

### Target Customer Profile
Antora's initial target customers share these characteristics:
1. Large industrial facility (>50 MW-thermal continuous heat demand)
2. Located in regions with high renewable penetration and daytime electricity price troughs (California, Southwest, Texas)
3. Strong corporate decarbonization commitments (Fortune 500 industrials with net-zero targets)
4. Existing natural gas infrastructure that Antora can displace
5. Facility with space for containerized thermal battery installation (typically 0.5-2 acres per system)

### Sales Cycle
Industrial capital equipment sales involve extended cycles:
- Initial engagement to signed letter of intent: 6-12 months
- Engineering and design: 6-12 months
- Permitting and approvals: 6-12 months
- Equipment manufacturing: 6-12 months
- Installation and commissioning: 3-6 months
- **Total sales cycle**: 21-48 months

This extended cycle means Antora's 2026-2027 revenue will be determined by customer engagements already underway. The 2024 first installation serves as the critical reference site that unlocks subsequent customer commitments.

### Competitive Positioning in Customer Decisions
| Selection Criterion | Antora | Natural Gas (BAU) | Green Hydrogen | Electric Boiler + Battery |
|--------------------|--------|-------------------|---------------|--------------------------|
| Carbon emissions | Zero (scope 1) | High | Zero (scope 1, if green H₂) | Zero (scope 1) |
| Capital cost | Moderate-high | Low (existing) | Very high | Low (boiler) + moderate (battery) |
| Operating cost | Moderate | Low-moderate | Very high | Low-moderate |
| Technology risk | High (first-of-kind) | None | Moderate | Low |
| Reliability | To be demonstrated | Proven | To be demonstrated | Proven |
| 24/7 carbon-free capable | Yes | No | Yes (with storage) | Yes (with battery) |
