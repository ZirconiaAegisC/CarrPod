# Thermodynamic Cycle — Brayton Heat Pump & Heat Engine

## Cycle Architecture

Malta Inc's Pumped Heat Energy Storage system is based on a reversible closed-loop Brayton cycle, operating as a heat pump during charging and as a heat engine during discharging. The Brayton cycle is the thermodynamic cycle underlying gas turbine engines and has been extensively studied, modeled, and deployed in power generation and aviation for over 80 years. Malta's innovation lies in applying this well-understood cycle to energy storage through reversible operation.

## The Reversible Brayton Cycle

### Charging Mode (Heat Pump)

In charging mode, the system operates as a reversed Brayton cycle — a Brayton heat pump. The working fluid (argon) follows this path:

1. **Compression (1→2):** The argon enters the compressor at low pressure and low temperature (near the cold reservoir temperature, approximately −60°C). The motor-driven compressor raises the argon pressure, typically by a ratio of 2:1 to 5:1, causing the temperature to rise to approximately 600°C (depending on compressor isentropic efficiency and pressure ratio)

2. **Hot-Side Heat Rejection (2→3):** The hot, high-pressure argon passes through a counterflow heat exchanger where it transfers thermal energy to the molten salt stream. The argon exits at reduced temperature (approximately 250–300°C) while the salt temperature increases from ~250°C to ~565°C. This heat exchanger operates with a pinch-point temperature difference of typically 5–15°C

3. **Expansion (3→4):** The cooled argon, still at high pressure, is expanded through a turbine. The expansion extracts work that can partially offset the compressor power requirement (the turbine and compressor are often on a common shaft, with the net power drawn from the grid being the difference between compressor power input and turbine power output). During expansion, the argon temperature drops to approximately −60°C

4. **Cold-Side Heat Absorption (4→1):** The cold, low-pressure argon passes through a counterflow heat exchanger on the cold side, absorbing heat from the chilled antifreeze stream. The antifreeze is cooled from approximately −10°C to −60°C, and the argon is warmed back to the compressor inlet conditions, completing the cycle

The Coefficient of Performance (COP) of the heat pump — defined as the ratio of thermal energy stored to electrical energy consumed — is targeted at 1.5–2.0 for Malta's design, meaning that for each 1 MWh of electricity consumed, 1.5–2.0 MWh of thermal energy is stored. This apparent COP > 1 does not violate thermodynamics because the heat pump moves existing heat rather than creating it; the electricity input provides the work to "pump" heat from the cold reservoir to the hot reservoir against the temperature gradient.

### Discharging Mode (Heat Engine)

In discharging mode, the argon flow reverses direction (or the system uses a separate turbomachinery train optimized for power generation). The cycle follows:

1. **Compression (1→2):** Argon is compressed, raising its temperature moderately

2. **Hot-Side Heat Absorption (2→3):** The compressed argon passes through the hot-side heat exchanger, absorbing heat from the stored molten salt. The argon temperature approaches the salt delivery temperature (~565°C). The salt is cooled in the process, returning to its cold tank at ~250°C

3. **Expansion (3→4):** The hot, high-pressure argon expands through the power turbine, driving the generator. The turbine extracts work from the expanding gas, and the argon temperature and pressure both decrease substantially

4. **Cold-Side Heat Rejection (4→1):** The expanded argon (still warm relative to the cold reservoir) passes through the cold-side heat exchanger, rejecting waste heat to the chilled antifreeze. The antifreeze warms from −60°C to approximately −10°C. The argon returns to compressor inlet conditions

The thermal efficiency of the heat engine cycle — the ratio of electrical energy output to thermal energy extracted from the hot salt — is targeted at 35–45%. Combined with the heat pump COP, the overall round-trip efficiency is:
RTE = COP_charge × η_discharge ≈ 1.7 × 0.38 ≈ 65% (target)
In practice, additional losses (turbomachinery inefficiencies, heat exchanger pressure drops, thermal losses from storage tanks, pump and auxiliary loads) reduce the realized RTE to approximately 55–65%.

## Key Thermodynamic Parameters

### Pressure Ratio
The compressor pressure ratio (PR) is a fundamental design parameter:

- **Higher PR:** Increases the maximum cycle temperature (beneficial for efficiency) but increases compressor work (detrimental for COP) and requires more expensive turbomachinery capable of higher pressure differentials
- **Lower PR:** Reduces compressor work but also reduces the temperature lift, limiting the amount of thermal energy that can be stored per unit of working fluid circulated

Malta's design likely uses a pressure ratio in the range of 2.5–4.0, optimizing the trade-off between cycle efficiency and equipment cost/complexity.

### Temperature Spread
The temperature spread across the hot and cold reservoirs determines the energy storage density per unit volume of storage fluid:

- **Hot reservoir:** 250°C (cold tank) to 565°C (hot tank) = ΔT of 315°C
- **Cold reservoir:** −10°C (warm tank) to −60°C (cold tank) = ΔT of 50°C

The larger ΔT on the hot side reflects the higher specific heat of nitrate salts relative to hydrocarbon antifreeze, and the thermodynamic fact that extracting useful work from a temperature difference is more effective at high absolute temperatures (per Carnot's theorem).

### Pinch Point Analysis
The heat exchangers' performance is dominated by the "pinch point" — the location within the heat exchanger where the temperature difference between the working fluid and the storage fluid is at a minimum. A smaller pinch point increases heat exchanger effectiveness (good for RTE) but requires more heat exchange surface area (bad for capital cost). Malta targets pinch point differences of 5–15°C, representing a design optimization informed by detailed techno-economic analysis.

## Part-Load Operation

Unlike simple-cycle gas turbines that suffer significant efficiency degradation at part load, the reversible Brayton cycle can maintain relatively high efficiency across a wide power range through:

- Variable-speed operation of the compressor and turbine (enabled by power electronics)
- Variable-pressure-ratio operation (adjusting the cycle to match available temperature differentials)
- Inventory control (adding or removing working fluid mass from the closed loop to adjust power output for a given turbomachinery speed)

These capabilities are important for grid applications where the storage system must frequently operate at partial power output (e.g., ramping to follow net load, providing ancillary services, or responding to dispatch signals that do not always call for full-rated power).

## Cycle Modeling and Validation

Malta's thermodynamic cycle design has been validated through:

- **Computational fluid dynamics (CFD) modeling:** Detailed 3D simulations of the turbomachinery flow paths, heat exchanger temperature distributions, and working fluid behavior across the full operating envelope
- **Component testing:** Subscale turbomachinery and heat exchanger testing at partner facilities (Siemens Energy, Alfa Laval)
- **System-level modeling:** Integrated cycle models using tools such as Aspen Plus, Thermoflow, or custom MATLAB/Simulink models that account for off-design performance, transient behavior, and control system response
- **Third-party review:** Technical due diligence by DOE, ISO-NE, and strategic investors (Siemens Energy, Alfa Laval) who have deep expertise in turbomachinery and thermal systems