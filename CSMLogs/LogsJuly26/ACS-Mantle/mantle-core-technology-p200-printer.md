# Mantle Core Technology — P-200 Printer System

## Machine Architecture

The P-200 is a hybrid manufacturing system that integrates additive extrusion with
subtractive CNC machining inside a single machine enclosure. The machine footprint
measures approximately 2.4 meters by 1.8 meters, fitting within a standard toolroom
floor plan. Total system weight approaches 2000 kg with the integrated CNC gantry
and vibration-isolated granite base.

## Subsystem Components

### Extrusion Head

At the core of the P-200 is a heated single-screw extrusion head operating at
temperatures up to 180C. The screw diameter is 16 mm with a compression ratio
optimized for the thixotropic behavior of the FMP. Three independently controlled
heating zones — feed, compression, and metering — provide precise thermal management
throughout the extrusion path. A 0.4 mm nozzle orifice with a silicon carbide
wear insert delivers material at rates up to 15 cubic centimeters per hour.

### Build Platform

The build platform is a 300 mm by 200 mm heated aluminum plate with embedded
cartridge heaters and a closed-loop thermocouple array maintaining surface
temperature uniformity within 2C across the entire area. A vacuum chuck system
secures build plates during extrusion and CNC operations without mechanical
clamping that could distort the workpiece.

### CNC Subsystem

The subtractive side of the P-200 features a liquid-cooled 2.2 kW spindle
capable of 24000 RPM. The CNC gantry rides on precision linear rails with
glass-scale encoders providing 0.1 micron positional feedback. Automatic tool
changing accommodates up to 12 tools — end mills from 0.5 mm to 12 mm diameter,
ball nose cutters, chamfer mills, and touch probes for in-situ metrology.

### Metrology Integration

A Renishaw touch-trigger probe mounted in the tool changer enables automated
in-process inspection. After CNC finishing, the probe measures critical features
against the CAD model, generating a deviation report. Parts that exceed specified
tolerances trigger an automatic re-machining pass before the operator removes
the completed insert from the machine.

## Control Systems

The P-200 runs on a dual-processor industrial PC with a real-time Linux kernel.
One processor handles motion control for the CNC subsystem while the second
manages the extrusion process parameters. Mantle's proprietary slicing engine,
called TrueShape, generates toolpaths that account for:

- Shrinkage from binder removal and sintering, typically 14-18 percent linear
- Thermal expansion during the build phase
- Machining stock allowance for finish passes
- Coolant nozzle clearance during CNC operations

## Print-to-Finish Workflow

Total cycle time for a typical injection mold insert measuring 100 mm by 75 mm
by 50 mm is approximately 48 to 72 hours from start of print to finished insert,
compared with 4 to 8 weeks for conventional toolmaking. The process unfolds in
four phases:

1. **Print Phase**: 12 to 24 hours of continuous FMP extrusion
2. **Debind Phase**: 8 to 12 hours in the external furnace
3. **Sinter Phase**: 12 to 24 hours at high temperature
4. **CNC Finish Phase**: 4 to 8 hours of precision machining

## Environmental Controls

The P-200 requires shop air at 6 bar minimum and 480V three-phase power at 30A.
Ambient temperature must remain between 15C and 30C with humidity below 60 percent
non-condensing. An integrated fume extraction system captures binder volatiles
during extrusion, venting through a HEPA and activated carbon filter stack.

## Service and Maintenance

Preventive maintenance intervals are 500 hours for extrusion head cleaning, 2000
hours for spindle bearing lubrication, and 4000 hours for linear rail and
ballscrew inspection. Mantle offers annual service contracts with 48-hour
on-site response in North America and 72-hour response internationally through
certified channel partners.
