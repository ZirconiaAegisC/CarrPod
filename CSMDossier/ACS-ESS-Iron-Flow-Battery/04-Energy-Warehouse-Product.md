# Energy Warehouse Product Line

## Product Overview

The Energy Warehouse is ESS Inc's commercial-scale, modular iron flow battery product. It is packaged as a standard 40-foot ISO shipping container, fully assembled and factory-tested, designed for rapid deployment at commercial, industrial, and small utility sites.

## Technical Specifications

| Parameter | Specification |
|-----------|--------------|
| Rated Power | 75 kW (AC output at point of interconnection) |
| Energy Capacity | 500 kWh (nameplate, usable) |
| Duration at Rated Power | 6.7 hours |
| Round-Trip Efficiency | 70–75% (AC-to-AC, including PCS losses) |
| Nominal DC Voltage | 48 V per stack; system voltage stepped up by PCS |
| Enclosure | 40-ft ISO shipping container, NEMA 3R weatherproof |
| Footprint | Approximately 300 sq ft (container) + clearance zone |
| Weight | ~35,000 kg (fully filled) |
| Operating Temperature | −20°C to +50°C ambient |
| Cycle Life | 20,000+ cycles at 100% depth of discharge |
| Warranted Life | 25 years |

## Operating Performance

The Energy Warehouse operates at relatively modest round-trip efficiency compared to lithium-ion systems (which typically achieve 85–92% RTE). This lower efficiency is offset by three critical advantages for long-duration applications:

1. **Zero capacity degradation over time:** Unlike lithium-ion cells that lose 20–30% of capacity after 3,000–5,000 cycles, the Energy Warehouse maintains nameplate energy capacity throughout its 20,000+ cycle life
2. **Unlimited cycling depth:** The system can be discharged to 0% state of charge repeatedly without any damage or accelerated degradation, unlike lithium-ion which degrades faster at deep depths of discharge
3. **No augmentation required:** Lithium-ion systems at the 10+ year mark often require costly cell module replacements; the Energy Warehouse requires only routine pump and seal maintenance

## Charge/Discharge Characteristics

- **Ramp rate:** Can transition from 0 to 100% rated power in under 500 milliseconds, making it suitable for fast frequency response applications
- **Turndown ratio:** Can operate continuously at any power level from 5% to 100% of rated capacity without efficiency penalty
- **Standby losses:** Self-discharge is negligible (< 0.1% per day) when pumps are off; when circulating, pump power consumption is approximately 1–2 kW
- **Overload capability:** Can sustain 110% of rated power for up to 2 hours and 150% for up to 5 minutes

## Installation and Commissioning

The Energy Warehouse arrives on-site as a fully tested, pre-commissioned unit. Site preparation requirements include:

- Level concrete pad or compacted gravel base
- Utility interconnection (typically 480 V three-phase or medium-voltage via step-up transformer)
- Communication link (Ethernet or cellular modem)
- Fencing and security as required by local codes

Commissioning takes approximately 2–3 weeks from container delivery to grid-connected operation, including:
1. Mechanical checks (pump rotation, leak testing, electrolyte verification)
2. Electrical checks (insulation resistance, ground fault detection, PCS synchronization)
3. Functional testing (charge/discharge cycling at incremental power levels)
4. Grid integration testing per IEEE 1547.1

## Control and Monitoring

Each Energy Warehouse includes an integrated Site Controller (SC) that manages:

- **Real-time operations:** Charge/discharge scheduling based on site load, solar generation, time-of-use rates, or external dispatch signals
- **Safety interlocks:** Continuous monitoring of hydrogen concentration, electrolyte levels, temperature, pump status, and ground fault
- **Remote monitoring:** ESS provides a cloud-based fleet monitoring platform accessible via web browser and API
- **Dispatch modes:** Peak shaving, solar self-consumption, demand response, time-of-use arbitrage, backup power, frequency regulation

The SC supports standard communication protocols including Modbus TCP, DNP3, and IEEE 2030.5 (California Rule 21), enabling integration with utility SCADA systems and third-party aggregators.

## Target Applications

The Energy Warehouse is designed for behind-the-meter (BTM) and front-of-meter (FTM) applications in the 75 kW to multi-MW range, including:

- **Commercial & Industrial:** Peak demand charge reduction for manufacturing facilities, data centers, cold storage warehouses
- **Solar + Storage:** Shifting midday solar generation to evening peak periods; increasing solar self-consumption from 40% to 90%+
- **Microgrids:** Islandable backup power for critical facilities such as hospitals, water treatment plants, and military installations
- **Utility Distribution:** Deferred distribution upgrade investments by shaving local peak loads on constrained feeders
- **EV Charging Support:** Buffering high-power EV fast-charging demand to avoid distribution transformer overload

## Product Pricing

ESS does not publicly disclose detailed pricing. Industry estimates place the Energy Warehouse at approximately $200–250/kWh at the system level (including container, electrolyte, PCS, and controls), with the potential to decline toward $100–150/kWh at scale, driven by:
- Manufacturing automation in Wilsonville
- IRA Section 45X production tax credits of $35/kWh
- Economies of scale in electrolyte chemical procurement
- Learning curve improvements in stack assembly yield