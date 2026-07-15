# G-VAULT Gravity Energy Storage Technology

## Technology Overview

G-VAULT is Energy Vault's proprietary gravity-based energy storage system (GESS), delivering long-duration, zero-degradation energy storage through the mechanical principle of raising and lowering composite blocks. The current generation — **EVx 2.0™** — represents the commercialized evolution of the crane-based EV1 and EVRC designs, optimized for modular deployment, constructability, and cost-efficiency at utility scale.

## First-Principles Technology Description

G-VAULT stores electrical energy as gravitational potential energy. During charging, grid electricity powers motor-generator sets that drive a multi-axis lifting system, raising 30-metric-ton composite blocks from ground level to an elevated storage position. During discharge, the blocks are lowered under controlled descent, with the motor-generators operating in reverse to convert gravitational potential energy back to electrical energy delivered to the grid.

The fundamental energy storage equation:

```
E_stored = m × g × h × η_rt
```

Where:
- `m` = aggregate mass of raised blocks (kg)
- `g` = gravitational acceleration (9.81 m/s²)
- `h` = average elevation change (m)
- `η_rt` = round-trip efficiency (target >80%)

## EVx 2.0™ — Technical Specifications

| Parameter                     | Specification                                               |
|-------------------------------|-------------------------------------------------------------|
| Nominal Power Rating          | 25 MW per modular block                                     |
| Nominal Energy Capacity       | 100 MWh per modular block                                   |
| Discharge Duration            | 4 hours at rated power; configurable to 8–24 hours          |
| Round-Trip Efficiency (RTE)   | >80% (grid-to-grid, AC-AC)                                  |
| Response Time                 | <5 seconds (0–100% rated power)                             |
| Ramp Rate                     | 100% per minute                                             |
| Design Life                   | 35+ years (mechanical structure); 50+ years (civil works)   |
| Degradation Rate              | <0.1% per annum (negligible, mechanical only)               |
| Block Mass                    | 30 metric tons per composite block                          |
| Block Composition             | Locally sourced soil, coal ash, mine tailings, or recycled construction waste + polymer binder |
| Storage Medium Cost           | <$5/kWh (composite blocks) vs. $150–300/kWh (Li-ion cells)  |
| Footprint                     | ~2.5 acres per 100 MWh module                               |
| Operating Temperature Range   | -30°C to +55°C (no thermal management required)             |
| Water Consumption             | Near-zero (closed-loop)                                     |

## Mechanical Architecture

The EVx 2.0™ structure is a steel-frame building — conceptually a "multi-story warehouse for blocks" — rather than the free-standing crane tower of the EV1 design. This architectural shift yields several advantages:

1. **Wind Immunity**: The enclosed structure eliminates the wind-induced operational downtime constraints of exposed-crane designs. Blocks are raised and lowered within a protected internal volume.

2. **Modular Deployment**: Each 25 MW / 100 MWh module can be deployed independently, with modules arrayed in parallel to achieve multi-GWh scale without linear cost escalation.

3. **Standardized Construction**: The steel-frame superstructure utilizes conventional commercial construction techniques and materials, enabling local sourcing and reducing specialized labor requirements.

4. **Seismic Resilience**: The building-type structure can be engineered to local seismic codes, unlike tower-crane architectures with high center-of-gravity vulnerability.

## Block Manufacturing and Supply Chain

The composite blocks — often termed "mobile masses" — are fabricated using a proprietary process that binds locally sourced aggregate material (excavation spoil, coal combustion residuals, mine tailings, recycled concrete) with a low-cement or cement-free polymer binder. Key characteristics:

- **Local Content**: >95% of block material can be sourced within 50 km of the project site, minimizing transportation cost and embodied carbon.
- **Circular Economy**: Blocks can incorporate industrial waste streams that would otherwise incur landfill costs, creating a negative cost-of-goods for the storage medium.
- **End-of-Life**: Blocks are inert and can be crushed for aggregate at decommissioning, with zero toxic materials or recycling challenges.
- **Manufacturing Throughput**: On-site block fabrication plant producing 10–20 blocks per day per production line.

## System-Level Performance Characteristics

### Degradation Advantage

Unlike electrochemical batteries, G-VAULT stores energy through a purely mechanical process. There is no chemical degradation mechanism. The only degradation pathway is mechanical wear on bearings, wire ropes, and gears — components that are inspected and replaced on scheduled maintenance intervals. This yields:

- **Capacity Retention**: >99% after 20 years
- **Cycle Life**: Unlimited (no cycle-count limitation)
- **Warranty**: 35-year structural; 10-year electromechanical drivetrain

### Levelized Cost of Storage (LCOS)

G-VAULT's LCOS advantage derives from three structural cost drivers:

| Cost Component                | G-VAULT EVx 2.0™           | Li-Ion BESS (4-hr)           | Flow Battery (Vanadium)      |
|-------------------------------|----------------------------|------------------------------|------------------------------|
| CAPEX ($/kW)                  | $1,200–1,800               | $250–400                     | $800–1,200                   |
| CAPEX ($/kWh)                 | $250–400                   | $250–400                     | $400–600                     |
| Storage Medium Cost ($/kWh)   | <$5                        | $150–300 (replaced Yr 10–15) | $150–250 (electrolyte)       |
| O&M ($/kW-yr)                 | $8–12                      | $4–8                         | $10–15                       |
| Design Life (Years)           | 35+                        | 15–20                        | 20–25                        |
| Replacement CAPEX (Yr 15)     | Negligible                 | $150–250/kWh                 | $80–120/kWh                  |
| **LCOS ($/MWh, 20-yr)**       | **$80–120**                | **$130–180**                 | **$150–220**                 |

Source: Company filings, Lazard LCOS 9.0, internal estimates.

At durations exceeding 8 hours, the LCOS crossover becomes highly favorable for G-VAULT, as the storage medium cost for lithium-ion scales linearly with energy capacity while G-VAULT's block cost remains negligible regardless of MWh rating.

## Eskom EVx 2.0™ — Reference Project

The Eskom project in South Africa represents the anchor commercial deployment of EVx 2.0™ technology:

| Parameter              | Phase 1                | Full SADC Framework        |
|------------------------|------------------------|----------------------------|
| Technology             | EVx 2.0™ GESS          | EVx 2.0™ GESS              |
| Power                  | 25 MW                  | Up to 4 GW                 |
| Energy                 | 100 MWh                | Up to 4 GWh                |
| Duration               | 4 hours                | 4–12 hours                 |
| Site                   | Eskom generation site  | Multiple across SADC        |
| Offtake                | Eskom PPA              | Various offtakers           |
| Status                 | Site mobilization H2 2026 | Framework agreement signed |

This project serves as a technology validation at the utility scale and a replicable reference design for the broader SADC region and other emerging markets with grid stability challenges.

## G-VAULT in Hybrid Configurations

Energy Vault's VaultOS EMS enables hybrid G-VAULT + B-VAULT configurations where:
- **B-VAULT** provides sub-second frequency response, synthetic inertia, and short-duration (1–2 hour) energy shifting.
- **G-VAULT** provides long-duration (8–24 hour) bulk energy time-shifting, capacity firming, and seasonal storage capability.

This hybrid architecture captures the full value stack across ancillary services, energy arbitrage, and capacity markets — optimizing revenue per MW of interconnection capacity.

## Technology Roadmap

| Horizon   | Development Focus                                                            |
|-----------|------------------------------------------------------------------------------|
| 2026–2027 | EVx 2.0™ first commercial units; Eskom COD; block manufacturing automation   |
| 2027–2028 | EVx 2.0™ cost optimization (target $200/kWh CAPEX); Stoney Creek deployment  |
| 2028–2030 | EVx 3.0 concept: underground shaft-based GESS for urban/constrained siting    |
| 2030+     | Ultra-long-duration (100+ hour) GESS for seasonal storage and renewable firming |
