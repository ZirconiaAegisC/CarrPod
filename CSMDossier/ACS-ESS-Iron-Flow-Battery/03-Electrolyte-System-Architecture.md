# Electrolyte System & Flow Architecture

## System-Level Architecture

An ESS iron flow battery system consists of four primary subsystems: (1) the electrochemical cell stack where charge/discharge reactions occur, (2) the electrolyte storage tanks that hold the liquid energy-bearing medium, (3) the pumping and fluid handling system that circulates electrolyte, and (4) the power conversion system (PCS) that interfaces the DC battery with the AC grid.

## Electrochemical Cell Stack Design

The cell stack is the heart of the system, analogous to the engine block in a conventional power plant. Each individual cell contains:

- **Positive electrode:** A carbon-based electrode optimized for the Fe²⁺/Fe³⁺ redox couple
- **Negative electrode:** A carbon-based electrode with proprietary surface treatments optimized for iron plating/stripping
- **Membrane/separator:** A proton-exchange membrane that allows H⁺ ions to pass while preventing electrolyte mixing
- **Bipolar plates:** Graphite composite plates that conduct current between adjacent cells and separate electrolyte flow channels
- **Flow frames:** Polymer frames that distribute electrolyte uniformly across the electrode surface area

## Stack Scaling

Individual cells produce approximately 1.2 volts. To achieve practical system voltages (typically 48 V to 800 V DC), multiple cells are connected in series within a stack. The Energy Warehouse product uses stacks of approximately 40 cells each, producing a nominal stack voltage of roughly 48 V. Multiple stacks can be connected in series-parallel configurations to meet specific power and voltage requirements.

## Electrolyte Tank Design

The electrolyte storage subsystem consists of two large polyethylene or fiberglass-reinforced plastic (FRP) tanks:

- **Positive electrolyte tank:** Stores the iron chloride solution serving the positive electrode (Fe²⁺/Fe³⁺ couple)
- **Negative electrolyte tank:** Stores the solution serving the negative electrode (Fe²⁺/Fe⁰ couple)

Tank sizing is determined by the desired energy capacity. In flow batteries, energy capacity (kWh) is decoupled from power capacity (kW): power scales with the electrode surface area in the stack, while energy scales with the volume of electrolyte in the tanks. This is the defining architectural advantage of flow batteries over conventional solid-state batteries.

For the Energy Warehouse (75 kW / 500 kWh), each tank holds approximately 8,000–10,000 liters of electrolyte solution. For the Energy Center (multi-MW configuration), tanks can be scaled to hold hundreds of thousands of liters, enabling durations of 10 hours or more at rated power.

## Pumping and Fluid Handling

Electrolyte circulation is driven by centrifugal pumps constructed from chemically resistant materials (polypropylene or PVDF). The flow rate is modulated based on the instantaneous power demand:

- **High power demand:** Increased flow rate delivers fresh electrolyte to the electrodes faster, supporting higher current densities
- **Low power demand:** Reduced flow rate minimizes pumping losses, improving round-trip efficiency at partial load
- **Idle/standby:** Electrolyte flow is reduced to a trickle to prevent stagnation while minimizing self-discharge

Pumping power represents approximately 2–4% of system rated power at full load, decreasing as a percentage at partial load. ESS has developed variable-speed pump controllers that optimize the tradeoff between pumping energy consumption and electrochemical efficiency.

## Thermal Management

The electrolyte solution has substantial thermal mass, which provides inherent thermal stability. Temperature is maintained within a 25–50°C operating window using passive cooling (natural convection from tank surfaces) supplemented by active cooling (air-cooled heat exchangers) for high-ambient-temperature or high-power operation scenarios. In cold climates, trace heating elements prevent electrolyte freezing during extended idle periods.

Key thermal advantages:

- No risk of thermal runaway — the aqueous electrolyte cannot combust
- Thermal mass of tanks provides natural damping against temperature fluctuations
- Operating temperature range aligns with ambient conditions in most deployment locations without requiring energy-intensive HVAC systems

## Balance of Plant

The balance-of-plant includes:

- **Power Conversion System:** Bidirectional inverters that convert DC to AC (discharge) and AC to DC (charge), complying with IEEE 1547 grid interconnection standards
- **Battery Management System (BMS):** Monitors cell voltages, temperatures, electrolyte levels, flow rates, and state of charge; communicates with the site controller via Modbus TCP/IP
- **Fire Suppression:** Although the electrolyte is non-flammable, standard fire suppression equipment is included for the balance-of-plant electrical equipment
- **Containment:** Secondary containment basins beneath electrolyte tanks capture any potential leaks, sized to hold 110% of the largest tank's volume per EPA SPCC regulations

## Modularity and Scalability

The decoupling of power and energy allows system sizing to be tailored to the application:

- **Power-limited applications** (frequency regulation, fast ramping) require larger stacks relative to tank size
- **Energy-limited applications** (solar shifting, peak shaving, microgrid resilience) require larger tanks relative to stack size
- **Mixed applications** can be served by intermediate sizing

This architectural flexibility is not available with lithium-ion batteries, where adding more batteries increases both power and energy proportionally.