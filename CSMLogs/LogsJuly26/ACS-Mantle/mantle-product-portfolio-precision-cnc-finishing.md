# Mantle Product Portfolio — Precision CNC Finishing Capability

## The Finishing Imperative

Injection mold tooling demands surface finishes and dimensional accuracy that
no additive manufacturing process alone can deliver. Mold cavities require
SPI A-1 to A-3 finishes on cosmetic surfaces and positional tolerances of
5 to 15 microns across parting lines and shutoffs. Mantle's integrated CNC
subsystem bridges the gap between the 25 to 50 micron surface roughness of
as-sintered parts and the sub-micron finishes required for production molding.

## CNC Subsystem Specifications

The P-200 CNC subsystem features:

- **Spindle**: Liquid-cooled 2.2 kW synchronous motor, 24000 RPM maximum,
  HSK-E32 tool holder interface with 1-micron runout specification
- **Axis drives**: Direct-drive linear motors on X and Y axes with 0.1 micron
  resolution glass scale encoders; precision ballscrew on Z axis with 0.5
  micron encoder resolution
- **Acceleration**: 1.0 g on X and Y axes, 0.5 g on Z axis
- **Positional accuracy**: 3 microns over the full 300 mm by 200 mm work
  envelope, verified to ISO 230-2
- **Tool changer**: 12-position automatic tool changer with tool length
  measurement via laser break-beam sensor
- **Coolant system**: High-pressure through-spindle coolant at 70 bar with
  200-liter tank and 10-micron filtration

## Finishing Strategies

### Roughing Pass

Removes 80 to 90 percent of the 0.3 to 0.5 mm stock allowance left on the
as-sintered part. Uses 6 to 12 mm carbide end mills at 12000 to 18000 RPM
with 0.5 to 1.0 mm depth of cut. Feed rates range from 2000 to 4000 mm per
minute depending on material — P20 allows faster cutting than H13.

### Semi-Finishing Pass

Brings the part to within 0.05 to 0.10 mm of final dimensions. Uses 3 to 6 mm
ball nose cutters at 18000 to 24000 RPM with 0.1 to 0.2 mm stepover. This
pass establishes the geometric accuracy that the finishing pass refines.

### Finishing Pass

Achieves final dimensions and surface finish. Uses 1 to 3 mm ball nose and
flat end mills at 20000 to 24000 RPM with 0.03 to 0.08 mm stepover. Coolant
delivery through the spindle ensures chip evacuation from deep cavities.
Surface finishes of Ra 0.2 to 0.4 micron are achieved directly from the
machine for most tool steel grades.

### Benching and Polishing

For SPI A-1 and A-2 cosmetic finishes, a brief manual polishing step follows
CNC finishing. Mantle's finishing strategy leaves surfaces at Ra 0.3 micron
or better, reducing manual bench time from 8 to 40 hours on a conventional
mold to 1 to 3 hours. The system generates a polishing roadmap that identifies
areas requiring manual attention and specifies the appropriate diamond paste
grit sequence.

## Conformal Cooling Channel Finishing

Conformal cooling channels printed into the insert body require internal
finishing to remove the slightly rougher as-sintered surface. Mantle employs
abrasive flow machining (AFM) as a post-process step for channels, pumping
a diamond-impregnated viscoelastic polymer through the channel network to
achieve a smooth internal surface. This reduces flow restriction and
minimizes the risk of coolant contamination entering the mold cavity.

## Metrology and Inspection

After finishing, the P-200 performs an automated inspection cycle:

1. Touch-trigger probe measures 30 to 100 reference points on critical features
2. TrueShape software compares measured points to the CAD model
3. A deviation report highlights any feature exceeding tolerance
4. If deviations exceed a configurable threshold, the system automatically
   generates a re-machining toolpath targeting only the out-of-tolerance areas
5. After re-machining, the probe cycle repeats to verify conformance

This closed-loop finishing approach ensures that every insert leaves the
machine within specification without requiring a separate CMM inspection step.

## Tool Life Management

The TrueShape software tracks cumulative tool usage and predicts remaining
tool life based on historical wear data from similar materials and geometries.
When a tool approaches its predicted end of life, the software schedules a
tool change at a safe point in the program — typically after completing a
feature rather than mid-pass. This prevents the scrap and rework that results
from tool breakage during finishing operations on high-value sintered inserts.
