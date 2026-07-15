# Ampaire Core Technology — Hybrid-Electric Propulsion Architecture

## System Philosophy

Ampaire's hybrid-electric propulsion system represents a pragmatic approach
to decarbonizing aviation: rather than designing a clean-sheet electric
aircraft, the company converts existing certified airframes to hybrid-electric
power. This conversion-based strategy leverages the massive installed base of
proven airframes while reducing fuel consumption, emissions, and operating
costs through electrification of the propulsion system.

## Hybrid Architecture Overview

The Ampaire hybrid-electric architecture operates on a series-parallel
configuration optimized for regional aviation missions of 50 to 500 nautical
miles. The system comprises four primary subsystems:

### Electric Propulsion Motor

An electric motor, typically in the 200 to 350 kW power class, provides
primary propulsion during takeoff, climb, and cruise phases. The motor is
mounted in the nose of the aircraft, replacing or supplementing the
conventional piston or turbine engine. Power electronics convert DC battery
power to variable-frequency AC for motor control, enabling precise thrust
modulation independent of engine RPM.

### Battery Energy Storage

Lithium-ion battery packs, installed in the fuselage or wing nacelles, store
energy for electric-only and hybrid-electric flight phases. Battery capacity
is sized for the electric-only range requirement — typically 30 to 60 minutes
of flight at cruise power — with the combustion engine providing range
extension beyond the battery-only endurance.

### Combustion Engine Range Extender

A modified piston or turbine engine, operating at its most efficient RPM
and power setting, drives a generator that either charges the batteries or
supplements the electric motor during high-power phases. By decoupling the
engine from direct mechanical propulsion demand, the engine can be optimized
for a single operating point rather than the wide power range required for
direct-drive propulsion. This increases engine thermal efficiency by 10 to
25 percent compared with the same engine in conventional direct-drive
configuration.

### Power Management System

A centralized power management controller orchestrates power flow between
the battery, motor, and range extender. The controller implements:

- Takeoff power strategy: Battery and range extender both supply the motor
  for maximum power — typically 110 to 130 percent of the motor's continuous
  rating is available for 5 minutes for takeoff
- Climb power profile: Battery provides boost power while range extender runs
  at maximum continuous, tapering battery contribution as altitude increases
- Cruise power optimization: Range extender runs at peak efficiency point,
  supplying motor demand plus battery charging. Battery state of charge is
  managed to arrive at destination with reserve energy for go-around and
  diversion
- Descent and approach: Motor operates in regenerative mode where possible,
  recovering kinetic energy to recharge batteries while providing the drag
  needed for the descent profile

## Fuel Consumption Reduction

The hybrid architecture achieves fuel savings through multiple mechanisms:

1. **Electric boost**: The electric motor provides additional power during
   high-demand phases, allowing the combustion engine to be downsized — a
   300 kW turbine can be replaced with a 180 kW turbine plus a 150 kW electric
   motor, with the smaller turbine operating closer to its peak efficiency
2. **Load leveling**: The battery absorbs transient power demands, allowing
   the combustion engine to operate at steady-state optimal conditions rather
   than following the highly variable power profile of direct-drive propulsion
3. **Regenerative energy recovery**: During descent, the motor operates as a
   generator, recovering energy that would otherwise be dissipated as drag
4. **Engine-off taxi and hold**: Electric-only ground operations eliminate
   fuel consumption and emissions during taxi, hold, and ground idle — phases
   that account for 5 to 15 percent of total mission fuel consumption

Ampaire reports that the Eco Caravan hybrid-electric conversion achieves 50
to 70 percent fuel consumption reduction compared with the baseline
conventionally powered Cessna 208B Grand Caravan on missions under 200
nautical miles. For longer missions requiring greater range extender
contribution, fuel savings moderate to approximately 30 to 50 percent.

## Emissions Reduction

Beyond fuel savings, the hybrid architecture provides emissions benefits:

- **CO2**: Directly proportional to fuel consumption reduction — 50 to 70
  percent reduction on typical regional missions
- **Noise**: Electric-only phases (taxi, takeoff roll, initial climb) reduce
  community noise exposure around airports by 15 to 25 dBA compared with
  conventional turboprop operations
- **Particulates**: Reduced combustion engine operation, particularly during
  ground operations and low-altitude flight, reduces particulate emissions
  in the airport vicinity

## Redundancy and Safety

The hybrid architecture provides propulsion redundancy not available in
single-engine conventionally powered aircraft:

- **Dual power sources**: Either the battery-electric system or the combustion
  engine can independently sustain level flight — the Cessna 208B requires
  approximately 350 to 400 kW for takeoff but only 250 to 300 kW for cruise,
  meaning either the 200 kW electric motor or the range extender alone can
  maintain safe flight
- **Engine failure capability**: In the event of combustion engine failure,
  the battery provides 30 to 60 minutes of electric flight — sufficient to
  reach a diversion airport from any point on typical regional routes
- **Battery failure management**: Multiple independent battery modules with
  isolated management systems prevent single-point electrical failures from
  affecting the entire propulsion system
