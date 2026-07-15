# Hybrid-Electric Propulsion Architecture

## Independent Hybrid Propulsion Concept

Heart Aerospace's ES-30 uses what the company terms "independent hybrid
propulsion." Unlike a series hybrid where a single generator powers a single
motor, or a parallel hybrid where a combustion engine and electric motor
both contribute torque to a common shaft, the ES-30's architecture treats
the battery-electric and turbine-generator systems as independent power
sources feeding a common electrical bus.

This architecture comprises four primary elements:

1. **Battery energy storage system:** High-density lithium-based battery
   modules mounted in the wing and fuselage belly fairing.
2. **Four wing-mounted electric motors:** Each driving a variable-pitch
   propeller. All propulsion thrust is produced by these motors.
3. **Two rear-fuselage turbogenerators:** Small turbine engines driving
   high-speed generators that produce electrical power for the motors
   and battery charging in flight.
4. **Power management and distribution system:** Solid-state power
   electronics that manage power routing, DC bus regulation, and
   protection coordination between batteries, generators, and motors.

The key architectural decision is that the turbogenerators are not
mechanically connected to the propellers. This eliminates the gearbox
weight, complexity, and maintenance burden associated with conventional
turboprop drivetrains and allows the turbogenerators to operate at
their single most efficient rotational speed regardless of propeller RPM.

## Modes of Operation

### Battery-Only Mode

Power flows from battery to power distribution bus to motor inverters to
motors to propellers. The turbogenerators are shut down. This is the
mode for all-electric operations up to 200 kilometers. The power
management system monitors individual cell voltages and temperatures
and can selectively shed non-critical loads if battery limits are
approached.

### Hybrid Cruise Mode

Once at cruise altitude, the turbogenerators are started and synchronized
to the DC bus. They supply cruise power to the motors while simultaneously
providing a charge current to the batteries. The power management system
balances the load between the two generators to avoid asymmetric fuel
consumption. If one generator fails, the other automatically assumes
the full load.

### Takeoff and Climb Boost

During takeoff and initial climb, the batteries deliver maximum power.
The turbogenerators remain offline to reduce noise and because their
power output is sized for cruise rather than takeoff. This power split—
batteries for peak power, generators for sustained power—matches the
inherent strengths of each technology.

### Emergency Descent and Landing

If both turbogenerators fail in flight, the aircraft reverts to battery-only
operation. The batteries are maintained at a state of charge sufficient
for a 30-minute diversion plus approach and landing at any point in the
flight. This is the hybrid-electric equivalent of the fuel-reserve
requirement for conventional aircraft.

## Electrical Bus Architecture

The ES-30's electrical system uses a high-voltage DC bus architecture,
likely in the 500–800 volt range, consistent with modern electric vehicle
and aerospace DC power-distribution practice. DC was chosen over AC for
several reasons:

- **Battery output is DC:** Eliminating DC-to-AC conversion losses at
  the battery interface.
- **Motor inverter input is DC:** Most modern permanent-magnet motor
  drives rectify AC to DC internally; a native DC bus eliminates the
  upstream rectification stage.
- **Generator output can be rectified:** The turbogenerators produce
  variable-frequency AC, which is rectified to DC for the bus.

The bus is divided into isolated segments with contactors that can
separate a faulted section. This segmentation allows the system to
isolate a battery module fire, a motor-inverter short circuit, or a
generator fault without losing the entire propulsion system.

## Redundancy and Fault Tolerance

The hybrid-electric propulsion system is designed to a level of
redundancy meeting or exceeding CS-23 requirements:

- Any single motor or inverter failure allows continued safe flight
  and landing on the remaining three motors.
- Either turbogenerator can carry the full cruise electrical load.
- Battery modules are divided into independently protected strings;
  a single-cell thermal runaway event is contained within the module.
- Dual-redundant power management computers cross-check data and
  can transfer authority if one fails.
- The electrical bus has redundant feeder paths from each power source
  to each motor, so no single bus-segment fault can isolate a motor.

## Weight and Integration

The hybrid propulsion system represents approximately 40–50% of the
aircraft's empty weight. Battery modules are the single largest mass
component. Their placement low in the fuselage belly fairing and within
the wing spar box keeps the center of gravity stable as charge depletes.

The turbogenerators, while adding weight compared to a pure battery-
electric design, paradoxically reduce overall system weight for missions
beyond 200 kilometers because the weight of additional battery capacity
that would be required for pure-electric range extension exceeds the
weight of the generators plus fuel.
