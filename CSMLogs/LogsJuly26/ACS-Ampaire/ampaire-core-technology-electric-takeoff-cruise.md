# Ampaire Core Technology — Electric Takeoff and Cruise Optimization

## The Takeoff Challenge

Takeoff is the most power-intensive phase of flight, demanding 150 to 200
percent of cruise power for 60 to 120 seconds. In conventionally powered
aircraft, the engine must be sized for this peak demand, resulting in an
engine that operates at suboptimal efficiency during the 90-plus percent of
flight time spent in cruise. Ampaire's hybrid architecture fundamentally
changes this equation by separating peak power provision (batteries) from
sustained power provision (range extender).

## Takeoff Power Strategy

### Boost Configuration

During takeoff, the electric motor draws power simultaneously from:

- **Battery**: Discharging at maximum rated current, providing 200 to 250 kW
- **Range extender**: Operating at maximum continuous power, contributing
  170 to 180 kW through the generator

Total available shaft power exceeds 370 kW for the takeoff roll and initial
climb — matching or exceeding the 500-plus shaft horsepower of the baseline
PT6A installation. The battery boost duration is limited to approximately 5
minutes at maximum power, sufficient for takeoff and climb through 3000 to
5000 feet where power demand decreases to levels sustainable by the range
extender alone.

### Battery Power Density Requirements

The takeoff boost function drives battery power density requirements. For the
Eco Caravan's 250 kW electric motor, the battery must deliver approximately
350 to 400 kW of DC power (accounting for motor and inverter losses).
Achieving this from a 200 to 250 kWh battery pack requires a discharge rate
of 1.5 to 2.0 C — well within the capability of automotive-grade NMC cells
rated for 3 to 5 C continuous discharge.

### Thermal Management During Boost

Sustained high-power discharge generates significant resistive heating in the
battery cells — approximately 5 to 8 kW of waste heat during takeoff at 2C
discharge. The liquid cooling system must absorb this transient without
allowing cell temperatures to exceed 50C, above which accelerated degradation
occurs. Ampaire's thermal management system uses a phase-change material
buffer — a paraffin wax heat sink integrated into the battery module cooling
plates — that absorbs peak thermal loads during takeoff and gradually releases
the stored heat to the liquid cooling loop during lower-power cruise flight.
This approach reduces the required cooling system capacity by approximately
40 percent compared with sizing for the peak thermal load.

## Electric-Only Operations

### Airport Noise Sensitive Phases

The ability to operate on electric power alone — with the combustion engine
shut down — provides immediate community noise benefits:

- **Taxi**: Electric taxi from gate to runway eliminates engine noise during
  ground movements. A PT6A at ground idle produces approximately 75 to 80 dBA
  at 50 meters; the electric motor produces less than 55 dBA at the same
  distance.
- **Takeoff roll**: The electric motor produces less noise than a turbine
  engine at takeoff power — approximately 65 dBA at the sideline measurement
  point versus 85 to 90 dBA for the PT6A.
- **Initial climb**: Noise footprint at communities within 1 to 2 km of the
  airport is reduced by 15 to 20 dBA through electric climb.

These noise reductions are particularly valuable for regional airlines
operating from airports with noise curfews or community noise sensitivity.

### Zero-Emission Terminal Operations

For airports with emissions reduction goals, the ability to conduct all
ground operations and departure through 3000 feet on electric power eliminates
local emissions of CO2, NOx, and particulates during the phases of flight that
most directly affect airport-adjacent air quality.

## Cruise Optimization

### Engine Operating Point Optimization

In conventional direct-drive configuration, the PT6A turbine operates across
a wide power range during cruise as the pilot adjusts power to maintain
airspeed and altitude. Turbine efficiency varies significantly across this
range — a PT6A at 60 percent power may consume only 15 percent less fuel than
at 85 percent power, representing poor part-load efficiency.

In the hybrid configuration, the range extender operates at a single optimal
power setting during cruise — typically 75 to 85 percent of maximum continuous
power — where specific fuel consumption is minimized. The battery buffers the
difference between range extender output and motor demand:

- When motor demand is less than range extender output, excess power charges
  the battery
- When motor demand exceeds range extender output (climb, turbulence
  penetration), the battery supplements

This load-leveling function alone provides approximately 10 to 15 percent
fuel consumption reduction compared with direct-drive operation of the same
engine, independent of the benefits from electric boost and regenerative
braking.

### Battery State of Charge Management

The power management system optimizes cruise battery state of charge to
minimize total mission energy consumption:

- **Departure**: Battery at 90 to 95 percent state of charge for takeoff boost
- **Top of climb**: Battery at 40 to 60 percent after providing climb boost
- **Cruise**: Range extender charges battery to 70 to 80 percent — sufficient
  for descent regeneration, approach, go-around, and diversion reserve
- **Descent**: Regenerative braking recovers 5 to 10 percent of battery
  capacity, arriving at destination with approximately 80 percent state of
  charge

The state of charge target at each phase is calculated by the power management
system based on route length, weather (headwinds increase energy consumption),
and destination availability (alternate airport distance determines required
reserve energy).

### Cruise Efficiency Outcome

Ampaire reports that the hybrid-electric Eco Caravan achieves 0.55 to 0.70
pounds of fuel per available seat mile on a 150 nautical mile mission,
compared with approximately 1.2 to 1.5 pounds per available seat mile for a
conventionally powered Caravan — a 50 to 60 percent efficiency improvement
on a per-passenger basis.
