# Turbogenerator Integration

## Role in the Propulsion System

The two rear-fuselage turbogenerators are the defining feature of the
ES-30's hybrid-electric architecture. They convert jet fuel (Jet-A or
sustainable aviation fuel) into electrical power that supplements the
batteries during extended missions. The turbogenerators are not propulsion
engines in the conventional sense; they do not produce thrust directly.
Instead, they function as airborne power stations, driving high-speed
generators that feed the common electrical bus.

## Turbogenerator Architecture

Each turbogenerator comprises:

1. **Gas turbine core:** A single-spool or two-spool gas turbine optimized
   for thermal efficiency at a single design-point rotational speed. The
   turbine is likely derived from an existing auxiliary power unit or
   helicopter engine core, adapted for continuous-duty generator operation
   rather than propulsion.

2. **High-speed generator:** Directly coupled to the turbine shaft, operating
   at turbine speeds (possibly 20,000–40,000 RPM). The generator produces
   variable-frequency AC that is rectified to DC for the electrical bus.
   Permanent-magnet generator technology eliminates the need for exciter
   windings and slip rings.

3. **Power electronics module:** A silicon-carbide-based active rectifier
   that converts the generator's variable-frequency AC to regulated DC,
   synchronized with the battery bus voltage.

4. **Intake and exhaust system:** NACA-style flush inlets or dorsal scoops
   on the upper rear fuselage supply intake air. Exhaust is routed through
   the tail cone or through shielded outlets on the upper aft fuselage to
   minimize infrared signature and noise.

## Design-Point Optimization

A conventional turboprop engine must operate efficiently across a wide
range of power settings: ground idle, taxi, takeoff (maximum power), climb
(high power at reducing density), cruise (moderate power at altitude), and
descent (low power, possibly flight idle). This forces compromises in
compressor design, turbine blade aerodynamics, and combustor sizing.

The ES-30 turbogenerator, by contrast, operates at essentially one design
point: cruise power at 10,000–20,000 feet. It is not required to deliver
takeoff power or to respond to rapid throttle movements. This single-point
optimization allows:

- Higher compressor and turbine efficiencies.
- Leaner combustor design for reduced NOx and improved specific fuel
  consumption.
- Tighter tip clearances for reduced secondary losses.
- Elimination of variable-geometry inlet guide vanes and bleed valves.

The result is a turbogenerator with brake-specific fuel consumption
significantly better than a conventional turboprop engine of equivalent
shaft power, translating to lower fuel consumption per kilowatt-hour
delivered to the propellers.

## Fuel System

The turbogenerators burn Jet-A or sustainable aviation fuel from wing or
fuselage fuel tanks. The fuel system is conventional in design but
substantially smaller than a turboprop installation because:

- Fuel is carried only for the hybrid portion of the mission, not for
  takeoff and climb.
- The generators consume fuel at a steady rate rather than the highly
  variable rate of a propulsion engine.
- Reserve fuel is required only for the generator operation during
  diversion, not for full propulsion.

Fuel tank capacity is estimated at approximately 500–800 liters, sufficient
for a 400-kilometer hybrid mission with reserves. This compares to
approximately 2,500–3,000 liters for a conventional turboprop of similar
capacity (such as the ATR 42), illustrating the fuel-efficiency gain of
the hybrid architecture.

## Noise and Emissions

The turbogenerators are acoustically isolated within the rear fuselage,
with vibration-isolation mounts, internal acoustic blankets, and noise-
attenuating intake and exhaust ducting. Because they operate at a constant
RPM, their noise signature is a steady tone rather than the varying
frequency spectrum of a propulsion engine cycling through climb, cruise,
and descent power. This steady tone can be more effectively attenuated
by tuned acoustic treatments.

Emissions are reduced compared to conventional turboprops because:

- The turbogenerators operate at a single, thermally efficient point.
- Approximately half of the mission energy (on a 400-kilometer flight)
  comes from batteries, eliminating emissions for that portion.
- When burning sustainable aviation fuel, net lifecycle CO2 emissions are
  further reduced by 70–80% compared to fossil Jet-A.

## Certification Approach

The turbogenerators are certified as an aircraft system rather than as
propulsion engines, since they do not contribute directly to thrust.
This places them under the powerplant installation requirements of CS-23
Subpart E, but the specific certification path for non-propulsive turbine
generators is an area where EASA and FAA are developing special conditions
and issue papers in collaboration with Heart Aerospace.

Key certification demonstrations include:

- Turbogenerator containment: Blade-out and rotor-burst testing to show
  that turbine failure does not compromise the airframe or flight controls.
- Fire protection: Engine fire detection and extinguishing in the enclosed
  aft-fuselage installation.
- Exhaust gas re-ingestion testing: Demonstrating that exhaust does not
  enter the cabin pressurization intakes or the turbogenerator inlets.
