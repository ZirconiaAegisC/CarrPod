# B-VAULT Battery Energy Storage Systems

## Product Overview

B-VAULT is Energy Vault's integrated battery energy storage system (BESS) platform, delivering turnkey DC-block and AC-coupled storage solutions for short-to-medium duration applications spanning 1–8 hours. The platform encompasses hardware integration, power conversion systems (PCS), balance-of-plant (BOP), and the VaultOS™ Energy Management System — a unified software stack controlling dispatch, optimization, and asset lifecycle management.

## Architecture and Integration

### DC-Block Architecture

The B-VAULT DC-block is a containerized or modular-enclosure battery system integrating:

| Subsystem                 | Specification                                                       |
|---------------------------|---------------------------------------------------------------------|
| Battery Cells             | LFP (lithium iron phosphate) prismatic, sourced from Tier-1 OEMs     |
| Cell Configuration        | 1PxxS module architecture; rack-level integration                   |
| Nominal DC Voltage        | 1,000–1,500 VDC                                                     |
| Energy per Container      | 3.5–5.0 MWh (20-ft ISO container)                                   |
| Cooling System            | Liquid cooling (glycol loop) with integrated heat rejection          |
| Fire Suppression          | Novec 1230 or FK-5-1-12 gas-based suppression; VESDA detection       |
| BMS Architecture          | 3-tier BMS (cell, module, rack) with redundant communication paths    |
| Operational Temperature   | -20°C to +50°C ambient (with derating above 40°C)                    |
| Cycle Life (80% DoD)      | 6,000–8,000 cycles (cell-level); 15–20 year system design life       |
| Round-Trip Efficiency     | 86–90% (DC-DC); 82–87% (AC-AC with PCS losses)                       |

### PCS and Grid Interconnection

Energy Vault integrates PCS from global Tier-1 suppliers (SMA, TMEIC, Power Electronics) in a flexible architecture supporting:

- 1,500 VDC input bus
- 480–690 VAC output (LV) or 13.8–34.5 kV (MV) with step-up transformer
- Grid-forming and grid-following modes
- IEEE 1547-2018 compliant; NERC CIP-ready
- Reactive power capability: ±0.95 power factor

### VaultOS™ EMS Integration

B-VAULT assets are controlled and optimized through VaultOS™, Energy Vault's proprietary EMS platform. The system continuously optimizes dispatch against multiple value streams:

- **Day-Ahead and Real-Time Energy Arbitrage**: Price-based charge/discharge optimization.
- **Frequency Regulation**: PJM RegD, ERCOT Fast Frequency Response (FFR), NEM FCAS.
- **Spinning and Non-Spinning Reserve**: Capacity reservation with availability guarantees.
- **Resource Adequacy (RA)**: CAISO, ERCOT, and other capacity market obligations.
- **Voltage Support and Reactive Power**: Dynamic VAR injection.
- **Black Start Capability**: Grid-forming mode for system restoration.

VaultOS employs machine-learning-based price forecasting, degradation-aware cycling optimization, and automated bidding into wholesale markets. The platform also enables hybrid G-VAULT + B-VAULT co-optimization for sites deploying both technologies.

## Deployment Portfolio

### Operational

| Project                  | Location      | Capacity          | Status       | Offtake Structure            |
|--------------------------|--------------|--------------------|--------------|------------------------------|
| Calistoga                | California   | 100 MW / 400 MWh   | Operational  | RA contract, CAISO           |
| Cross Trails             | Texas        | 80 MW / 160 MWh    | Operational  | ERCOT merchant + ancillary   |
| Additional US sites      | Various      | ~200 MW (est.)     | Operational  | Various                      |
| **Subtotal**             |              | **~380 MW**        |              |                              |

### Development and Construction

| Project                  | Location      | Capacity              | Status            | Target COD  |
|--------------------------|--------------|------------------------|--------------------|-------------|
| EBOR                     | Australia    | 100 MW / 870 MWh       | Late development   | 2027        |
| SOSA                     | Texas        | 150 MW (BESS portion)  | Development        | 2027        |
| EU Green Energy Program  | Multiple EU  | 1,800 MWh (4 years)    | Framework signed   | 2026–2030   |
| BayWa Japan Pipeline     | Japan        | 850 MW (BESS + solar)  | Acquired           | 2027–2030   |
| **Subtotal**             |              | **>1 GW pipeline**     |                    |             |

## Competitive Positioning in BESS

The BESS market is highly competitive, dominated by Tesla Megapack (horizontal integration), Fluence (utility-scale integration specialist), and a growing field of Chinese integrators (Sungrow, BYD, CATL). Energy Vault's competitive differentiation rests on four pillars:

1. **Integrated G-VAULT + B-VAULT Offering**: No competitor offers a single-vendor hybrid LDES + BESS solution with unified EMS dispatch. This enables project developers and utilities to contract with a single counterparty for their full storage duration stack.

2. **Asset Vault Offtake**: Energy Vault's own Asset Vault platform serves as an anchor off-taker for B-VAULT equipment, providing a captive demand channel that reduces customer acquisition cost and sales cycle duration.

3. **VaultOS Optimization**: The EMS platform's machine-learning optimization capabilities provide measurable revenue uplift (2–5% estimated) versus generic third-party EMS, directly improving project IRR for asset owners.

4. **Technology-Agnostic Supply Chain**: By remaining cell-agnostic and PCS-agnostic, Energy Vault avoids lock-in to any single manufacturer and can arbitrage supply-chain pricing and technology improvements across vendors.

## Supply Chain Strategy

Energy Vault's BESS supply chain strategy emphasizes:

- **Multi-Sourcing**: LFP cells procured from at least three qualified suppliers (CATL, BYD, EVE, Gotion, or equivalent), with regional sourcing preferences to manage tariff and logistics risk.
- **Domestic Content**: IRA §45X and §48C incentives create a compelling economic case for US-based module assembly and PCS manufacturing. Energy Vault is evaluating US assembly partnerships to qualify for the 10% domestic content adder under ITC rules.
- **Inventory Management**: Strategic buffer inventory of 500–800 MWh of cells maintained to de-risk project delivery schedules.
- **Sodium-Ion Pathway**: The Peak Energy partnership (1.5 GWh manufacturing commitment) provides a path toward sodium-ion BESS integration — targeting a 30% reduction in cell cost versus LFP at scale, with improved safety and wider operating temperature range.

## Performance and Degradation

| Parameter                     | B-VAULT LFP Specification        |
|-------------------------------|----------------------------------|
| Warranted Capacity Retention  | >85% at Year 10; >80% at Year 15  |
| Augmentation Strategy         | DC-block augmentation at Year 8–10 |
| Augmentation Cost             | ~$50–70/kWh (cell-only, projected) |
| Availability Guarantee        | 98% (excluding planned maintenance)|
| Response Time                 | <100 ms (PCS-level)               |
| Ramp Rate                     | 100% per second                   |

## Safety Architecture

B-VAULT employs a defense-in-depth safety architecture:

1. **Cell Level**: LFP chemistry inherently resists thermal runaway (no oxygen release at decomposition temperature).
2. **Module Level**: Inter-cell thermal barriers; pressure-relief venting; temperature monitoring at every cell junction.
3. **Rack Level**: Arc-fault detection; smoke detection (VESDA); rack-level DC disconnects.
4. **Container Level**: Gas-based fire suppression (Novec 1230 / FK-5-1-12); explosion vent panels (NFPA 855 compliant); 3-hour fire-rated separation between containers.
5. **Site Level**: Defensible space per NFPA 855; remote monitoring with automated emergency shutdown; UL 9540 and UL 9540A certified.

## Market Segments

| Segment                       | Duration    | B-VAULT Value Proposition                             |
|-------------------------------|-------------|-------------------------------------------------------|
| Frequency Regulation          | <30 min     | Fast response; high cycle tolerance                    |
| Energy Arbitrage              | 2–4 hours   | LFP cost-optimal for daily cycling                    |
| Resource Adequacy             | 4 hours     | CAISO/ERCOT RA compliance with duration requirement    |
| Transmission Deferral         | 4–6 hours   | Siting flexibility; modular scalability                |
| C&I Peak Shaving              | 2–4 hours   | Demand charge management; behind-the-meter integration |
| Renewable Firming             | 4–8 hours   | Paired with solar/wind; time-shifting generation       |
