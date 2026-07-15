# Ampaire Core Technology — AMP-H570 Powertrain System

## Powertrain Architecture

The AMP-H570 is Ampaire's production-intent hybrid-electric powertrain
designed for the Eco Caravan conversion program and scalable to other
aircraft in the 6 to 19 passenger regional category. The designation
"H570" refers to the system's continuous power rating of 570 shaft horsepower
(425 kW), matching the power class of the Pratt and Whitney PT6A-114A turbine
that powers the baseline Cessna 208B Grand Caravan.

## Electric Motor Subsystem

### Motor Specifications

The electric propulsion motor is a permanent magnet synchronous machine with:

- Continuous power rating: 250 kW (335 hp)
- Peak power (5 minutes): 320 kW (430 hp)
- Operating voltage: 540 to 750 VDC (nominal)
- Maximum RPM: 2400 (direct drive, no reduction gearbox)
- Efficiency: 94 to 96 percent across the operating range
- Cooling: Liquid-cooled stator with integrated oil-to-air heat exchanger
- Weight: Approximately 85 kg including cooling system
- Diameter: 380 mm; length: 420 mm

### Motor Controller

The motor controller is a silicon carbide (SiC) based inverter providing:

- Peak current: 600 A at 750 VDC
- Switching frequency: 20 to 40 kHz (variable based on operating point)
- Efficiency: 98.5 percent at rated power
- Cooling: Liquid-cooled with shared cooling loop with the motor
- Redundancy: Dual independent inverter channels with automatic failover
- Weight: Approximately 35 kg

The use of silicon carbide power semiconductors, rather than conventional
silicon IGBTs, reduces switching losses by approximately 60 percent, enabling
higher efficiency and smaller cooling system requirements. SiC also enables
higher switching frequencies that reduce motor harmonic losses and audible
noise.

## Range Extender: Modified Combustion Engine

### Engine Selection

For the Eco Caravan, Ampaire selected a modified automotive-derived V8 spark-
ignition engine as the range extender, replacing the PT6A turboprop. The
automotive engine offers several advantages:

- Lower acquisition cost: 40000 to 60000 USD versus 500000-plus USD for a
  new PT6A
- Lower overhaul cost: 15000 to 25000 USD versus 200000-plus USD for a PT6A
  hot section inspection and overhaul
- Fuel flexibility: Compatible with 100LL avgas and automotive gasoline,
  with pathways to sustainable aviation fuel (SAF) compatibility
- Maintenance infrastructure: Automotive engine maintenance skills are widely
  available, reducing the specialized training burden for operator maintenance
  organizations

### Generator Integration

The engine is coupled to a 180 kW generator through a torsionally compliant
coupling. The generator operates at the engine's optimal efficiency RPM of
3500 to 4000 RPM, producing 540 to 750 VDC output through an integrated
rectifier. The engine-generator combination is sized to provide:

- Cruise power for the electric motor plus battery charging at 50 to 80 kW
- Independent cruise capability in the event of battery system failure
- Ground power for battery charging when connected to ground support equipment

### Engine Optimization for Range Extension

The automotive engine is modified for aviation range extension duty:

- **Dry sump lubrication**: Enables sustained operation at climb and descent
  attitudes without oil starvation
- **Dual ignition**: Redundant spark ignition system meeting aviation
  reliability requirements
- **Electronic engine control**: Full-authority digital engine control
  (FADEC) with aviation-specific fault detection and accommodation logic
- **Vibration isolation**: Engine mounts designed to isolate airframe from
  engine vibration across the operating RPM range
- **Fire suppression**: Integrated fire detection and suppression system
  meeting FAA Part 23 standards for engine compartment fire protection

## Battery System

### Battery Architecture

The battery system comprises multiple independent modules, each containing:

- Lithium nickel manganese cobalt oxide (NMC) cells in a series-parallel
  configuration providing 10 to 15 kWh per module
- Integrated battery management system (BMS) monitoring cell voltage,
  temperature, and state of charge at the individual cell level
- Liquid thermal management maintaining cell temperature within 15 to 35C
  during all operating conditions
- Mechanical containment structure designed to contain cell thermal runaway
  within a single module without propagation to adjacent modules

### Total Energy Capacity

The Eco Caravan battery system provides approximately 200 to 250 kWh of
total energy capacity, enabling:

- 30 to 45 minutes of all-electric flight at cruise power
- Takeoff and climb to 5000 feet on battery power with engine assist
- Reserve energy for go-around and 30-minute diversion at the end of mission

### Charging Infrastructure

Battery charging is accomplished through:

- **In-flight charging**: Range extender generator supplies charging power
  during cruise, typically 50 to 80 kW
- **Ground charging**: External DC fast charger at 150 to 350 kW, achieving
  20 to 80 percent state of charge in 30 to 45 minutes
- **Opportunity charging**: Lower-power AC charging at 22 kW overnight between
  operating days

The battery system is designed for 3000 to 5000 full-equivalent charge-discharge
cycles before reaching 80 percent of initial capacity, corresponding to
approximately 5 to 8 years of regional airline operations at 600 to 1000
flight hours annually.

## Power Management Integration

The AMP-H570 power management system integrates the motor, generator, battery,
and cockpit interfaces through a dual-redundant CAN bus architecture. The
system provides:

- Automatic power source selection and load sharing based on phase of flight
- Pilot interface displaying power flow, battery state of charge, range
  extender status, and estimated remaining endurance in each operating mode
- Fault detection and automatic reconfiguration to maintain propulsion
  capability following single-point failures
- Data recording of all power system parameters for maintenance trending and
  incident investigation

The power management software is developed to DO-178C Level B standards,
reflecting the safety-critical nature of the propulsion control function.
