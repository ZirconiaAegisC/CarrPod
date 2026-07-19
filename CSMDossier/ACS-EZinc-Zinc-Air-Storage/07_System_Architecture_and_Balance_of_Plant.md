# e-Zinc — System Architecture & Balance of Plant

## From Cell to System

Individual zinc-air cells, while interesting from a scientific perspective,
produce only modest voltages (~1.65 V open circuit, ~1.0-1.2 V under load)
and limited current. Practical grid-scale energy storage requires integrating
thousands of cells into a complete system with power conversion, thermal
management, controls, and safety subsystems. e-Zinc's system architecture
is designed to maximize the inherent advantages of zinc-air chemistry while
minimizing the balance-of-plant costs that can dominate system-level economics.

## Cell Stack Configuration

Cells are arranged in series-parallel configurations to achieve the target
system voltage and power rating:

- **Series connection** — cells connected in series to achieve the DC bus
  voltage required by the power conversion system, typically in the range of
  600-1500 VDC to match standard industrial inverter inputs
- **Parallel connection** — multiple series strings connected in parallel to
  achieve the target energy capacity (kWh) by scaling total active material
  inventory
- **Modular sub-racks** — cells organized into field-replaceable modules that
  can be swapped without disassembling the entire system, enabling maintenance
  and end-of-life servicing without system downtime

## Power Conversion System

The power conversion system serves as the interface between the DC battery and
the AC grid:

| Component | Function | Specification |
|-----------|----------|--------------|
| DC-DC converter | Matches variable battery voltage to stable DC bus | Bidirectional, >97% efficiency |
| Inverter/charger | Converts DC to AC (discharge) and AC to DC (charge) | Grid-forming or grid-following capable |
| Transformer | Steps voltage to grid interconnection level | Utility-grade, pad-mounted |
| Switchgear | Protection, isolation, grid interconnection | Compliant with IEEE 1547, UL 1741 |

## Air Management System

Unlike sealed batteries, zinc-air systems require a managed flow of atmospheric
air to the cathode. The air management subsystem includes:

- **Blowers or fans** — provide forced air circulation through the cathode
  compartments, sized to deliver the stoichiometric oxygen requirement plus
  excess air for thermal management
- **Air filtration** — removes particulate matter that could foul the air
  cathode or degrade performance over time; in dusty or polluted environments,
  multi-stage filtration with automated filter monitoring
- **CO₂ scrubbing** — optionally, removal of atmospheric carbon dioxide to
  prevent carbonate formation in the alkaline electrolyte, which would reduce
  ionic conductivity over time. The need for scrubbing depends on ambient
  conditions and the design of the air cathode's carbonate tolerance
- **Humidity management** — in arid environments, humidification of incoming
  air to prevent excessive electrolyte water loss; in humid environments,
  potential dehumidification to prevent water accumulation

## Thermal Management

While zinc-air chemistry does not present the thermal runaway risks of lithium-ion
systems, thermal management remains important for:

- **Performance optimization** — electrochemical reaction kinetics are temperature-
  dependent; maintaining optimal temperature maximizes round-trip efficiency
- **Electrolyte stability** — extreme temperatures can cause electrolyte freezing
  (below approximately -20°C for typical KOH concentrations) or accelerated
  water loss (above approximately 50°C)
- **Component longevity** — electronics, polymers, and seals all have temperature-
  dependent degradation rates

e-Zinc's thermal management system uses forced air cooling (leveraging the air
management system) as the primary heat rejection mechanism, with liquid cooling
available for higher-power or extreme-environment configurations.

## Control & Monitoring System

| Subsystem | Function |
|-----------|----------|
| Battery Management System | Cell-level voltage, current, and temperature monitoring; state-of-charge estimation; charge/discharge control |
| Energy Management System | System-level dispatch optimization; grid signal response; market participation logic |
| SCADA | Supervisory control and data acquisition; remote monitoring and diagnostics |
| Safety System | Hydrogen detection (for any parasitic H₂ evolution), electrolyte leak detection, fire detection (for balance-of-plant electronics, not the cells), emergency shutdown |

## Containerized Deployment

For grid-scale applications, e-Zinc's system is packaged in standardized shipping
container formats (20-foot and 40-foot ISO containers), providing:

- **Factory integration** — systems assembled and tested at the factory, reducing
  site installation time and quality risk
- **Transportability** — shipped via standard intermodal logistics to any site
  with container access
- **Scalability** — capacity added incrementally by deploying additional containers
- **Weather protection** — standard containers provide NEMA 3R or equivalent
  environmental protection for outdoor installation