# AI & Digital Infrastructure — Energy Vault

## Thesis

The exponential growth in AI compute demand is the single largest structural driver of incremental electricity consumption in developed economies. Hyperscale data centers are projected to require 35–50 GW of new capacity in the United States alone by 2030, with 24/7 load factors that fundamentally challenge grid interconnection timelines and renewable penetration targets. Energy Vault has positioned itself at the convergence of AI infrastructure load and carbon-free energy delivery through a partnership-based model that combines long-duration storage, short-duration BESS, and powered-shell digital infrastructure in single-site, single-offtake configurations.

## Market Context

### Data Center Energy Demand Trajectory

| Metric                         | 2023 Actual    | 2026 Estimate     | 2030 Projection    |
|--------------------------------|----------------|-------------------|---------------------|
| US Data Center Load (GW)       | ~19            | ~28               | ~50–60              |
| Global Data Center Load (GW)   | ~40            | ~65               | ~100–120            |
| AI Share of DC Load             | ~10%           | ~30%              | ~50–60%             |
| Average DC PUE                  | 1.4            | 1.2               | 1.10–1.15           |
| 24/7 CFE Corporate Commitments  | <10 GW         | ~50 GW            | ~200 GW             |

Source: IEA Electricity 2024, McKinsey Global Institute, Goldman Sachs Research, company estimates.

The load profile of AI data centers — with training clusters drawing 50–200 MW continuously — creates an acute need for firm, dispatchable, carbon-free power. This need cannot be met by intermittent renewables alone; it requires energy storage at durations of 8–24 hours to bridge solar and wind generation gaps.

## Crusoe Energy Systems Partnership — Powered-Shell Infrastructure

Energy Vault and Crusoe Energy Systems are collaborating on integrated "powered-shell" AI infrastructure solutions that co-locate:

- **Compute**: Crusoe's modular, containerized GPU clusters (NVIDIA H100 / B200 generation), deployed in ISO-container form factors with integrated liquid cooling.
- **Power**: Behind-the-meter or front-of-meter energy supply via Energy Vault's G-VAULT + B-VAULT hybrid storage systems, delivering firm, schedulable power matched to GPU workload profiles.
- **Software**: VaultOS EMS integrated with Crusoe's orchestration layer to dynamically balance compute workload scheduling with energy storage state-of-charge and grid price signals.

### Commercial Model

The powered-shell model offers two primary go-to-market pathways:

1. **Developer-Owned**: Energy Vault and Crusoe jointly develop a site, securing land, interconnection, and environmental permits. The energy storage and compute assets are funded via the Asset Vault platform and Crusoe's project finance facilities, respectively. Offtake is structured as a PPA with a hyperscale or colocation customer.

2. **Customer-Sited**: A hyperscale customer provides the land and interconnection; Energy Vault and Crusoe design, build, and operate the integrated energy-plus-compute system under a long-term energy-as-a-service contract with fixed capacity charges and variable energy fees.

### Revenue Model

| Revenue Stream                          | Typical Value (per MW)       | Contract Duration      |
|-----------------------------------------|------------------------------|------------------------|
| Capacity Reservation Fee                | $120–180/kW-year             | 10–15 years            |
| Variable Energy Charge                  | $40–60/MWh                   | 10–15 years            |
| Grid Ancillary Services (excess cap.)   | Market-dependent             | Spot / short-term      |
| REC / Carbon Credit Stacking            | $5–15/MWh incremental        | Project life           |

## Peak Energy — Sodium-Ion Battery Partnership

In 2025, Energy Vault signed a strategic partnership with Peak Energy, a US-based sodium-ion battery manufacturer, encompassing:

- **Offtake Commitment**: 1.5 GWh of sodium-ion cells over a multi-year delivery schedule.
- **Technology Integration**: Peak Energy's sodium-ion cells integrated into the B-VAULT platform, targeting the 4–8 hour duration segment where LFP cost curves flatten.
- **Target Cost**: Sodium-ion cell pricing projected at $40–50/kWh at scale (vs. $70–90/kWh for LFP at comparable volume), translating to a 25–35% reduction in total installed BESS cost at the DC-block level.

### Sodium-Ion Value Proposition

| Parameter              | LFP (Current)          | Sodium-Ion (Projected)  |
|------------------------|------------------------|--------------------------|
| Cell Cost ($/kWh)      | $70–90                 | $40–50                   |
| Cycle Life (80% DoD)   | 6,000–8,000            | 4,000–6,000              |
| Operating Temp Range   | -20°C to +50°C         | -30°C to +55°C           |
| Safety (Thermal Runaway)| Low risk              | Very low risk            |
| Supply Chain Constraint| Lithium, cobalt, nickel| Abundant sodium          |
| Energy Density (Wh/kg) | 140–160                | 100–130                  |

The lower energy density of sodium-ion is not a material constraint for stationary storage applications, where footprint is governed by MWh/acre rather than Wh/kg. The safety and cost advantages make sodium-ion a compelling fit for the AI infrastructure use case, where 4–8 hour daily cycling is the dominant operating profile.

## VaultOS™ — Energy Management System for AI Infrastructure

VaultOS is Energy Vault's proprietary cloud-based EMS platform that provides:

### Core Functionality

- **Multi-Asset Optimization**: Simultaneously dispatches G-VAULT, B-VAULT, and hybrid configurations against market signals, offtake obligations, and asset constraints.
- **Revenue Stacking**: Automated bidding into wholesale energy, ancillary services, and capacity markets via API integrations with ISOs/RTOs (CAISO, ERCOT, PJM, NEM, and European exchanges).
- **Degradation Modeling**: Physics-informed battery degradation models that optimize cycling depth and frequency to maximize asset net present value across the design life.
- **24/7 Carbon Matching**: Hourly matching of load with carbon-free energy generation, enabling corporate offtakers to meet 24/7 CFE commitments (as distinct from annual REC matching).

### AI-Specific Modules

- **Workload-Aware Dispatch**: Integration with GPU cluster job schedulers to align energy storage dispatch with compute workload profiles (batch training jobs, inference serving, cluster idle periods).
- **Carbon Intensity Forecasting**: ML models predicting grid carbon intensity at 5-minute granularity, enabling load shifting to low-carbon intervals for emissions-constrained offtakers.
- **PUE Optimization**: Dynamic adjustment of cooling system load (chillers, CRAC units) in coordination with BESS state-of-charge to minimize total facility energy cost.

## Competitive Landscape — AI Infrastructure Energy

| Player                    | Approach                                            | Energy Vault Relative Position               |
|---------------------------|-----------------------------------------------------|-----------------------------------------------|
| Crusoe (partner)          | Stranded-gas-powered modular data centers           | Complementary — Energy Vault provides storage |
| Lancium                   | Flexible load data centers for grid balancing       | Competing — but lacks LDES integration        |
| Soluna                    | Co-located wind + compute                           | Competing — BESS-only, no gravity storage     |
| TerraPower / Natrium      | Advanced nuclear + storage                          | Adjacent — different primary generation tech  |
| Google / Microsoft        | Internal 24/7 CFE procurement                       | Potential offtaker — complementary            |

Energy Vault's unique positioning stems from providing the full stack — LDES (gravity), BESS (lithium-ion and sodium-ion), and software (VaultOS) — as a single-vendor, single-contract solution for firm, carbon-free power delivery to AI infrastructure. This vertical integration reduces interface complexity, contracting overhead, and performance risk for hyperscale and colocation customers.

## Financial Contribution Trajectory

The AI digital infrastructure segment is in its formative revenue stage, with initial powered-shell projects expected to contribute materially from 2027 onward. The company has guided that AI infrastructure could represent 15–25% of consolidated revenue by 2029, driven by:

- 1–2 GW of powered-shell capacity under contract by 2028
- Sodium-ion BESS integration reducing total system cost
- VaultOS licensing revenue as a standalone SaaS product for third-party storage + compute deployments

Capital requirements for AI infrastructure projects are expected to be funded primarily through the Asset Vault platform and project-level debt, limiting dilution and balance-sheet impact on Energy Vault Holdings.
