# Mantle Manufacturing and Scale-Up — Production Workflow

## End-to-End Process Flow

Mantle's production workflow transforms a customer CAD file into a finished
injection mold insert ready for production within 48 to 72 hours. The workflow
integrates software, additive manufacturing, thermal processing, CNC finishing,
and quality assurance into a continuous sequence with defined handoff criteria
at each stage.

## Phase 1: Digital Preparation (2-4 Hours)

### CAD Import and Analysis

The tooling engineer imports the insert CAD model into TrueShape. The software
performs automatic feature recognition, identifying parting surfaces, shutoffs,
gate and runner geometries, ejector pin holes, and cooling channel networks.
A design-for-manufacturing (DFM) check runs against Mantle's process capability
database, flagging features that may exceed print resolution or require design
modification.

### Shrinkage Compensation

TrueShape applies a non-uniform scaling transformation to the CAD model based
on empirical shrinkage data from thousands of builds. The compensation algorithm
accounts for:

- Anisotropic shrinkage: Z-axis (build direction) typically shrinks 15-18
  percent during sintering while X-Y dimensions shrink 14-16 percent
- Geometry-dependent effects: Thick sections shrink more than thin walls
- Material-specific parameters: H13 and P20 have slightly different shrinkage
  characteristics requiring separate compensation profiles

The compensated model is the "green part" target — the geometry the printer
aims to produce before debinding and sintering.

### Build Orientation Optimization

TrueShape evaluates multiple build orientations and recommends the optimal
orientation based on:

- Minimization of support structure requirements
- Maximization of surface finish quality on functional faces
- Optimization of build time
- Alignment of anisotropic properties with functional requirements

For most tooling inserts, the parting line plane is oriented parallel to the
build platform to ensure the best surface finish on mating surfaces.

### Toolpath Generation

The software generates both additive and subtractive toolpaths in a unified
process. The additive toolpath includes extrusion paths, layer transitions,
and temperature control instructions. The subtractive toolpath includes roughing,
semi-finishing, and finishing operations with automatic tool selection from the
standard 12-tool library.

## Phase 2: Additive Manufacturing (12-24 Hours)

### Build Setup

The operator installs a build plate on the P-200 platform, loads FMP cartridges,
and initiates the build. The machine performs automatic warmup and calibration
including bed leveling, nozzle height setting, and extrusion flow rate verification
using a purge-and-weigh cycle.

### Extrusion

The P-200 extrudes FMP material layer by layer. The extrusion head maintains
temperature within 1C of the setpoint and extrusion pressure within 0.5 bar.
Layer adhesion is monitored through a force sensor in the build platform that
detects anomalies indicating poor interlayer bonding — if detected, the machine
pauses and alerts the operator.

### Build Completion and Green Part Extraction

After the build completes, the operator removes the build plate with the
attached green part. The green part has the consistency of hard wax and
requires careful handling. It is transferred to a holding rack while the
build plate is cleaned and prepared for the next job.

## Phase 3: Thermal Processing (20-36 Hours)

### Debinding Cycle

The green part is placed in the debinding furnace on a ceramic setter plate.
The furnace executes a multi-stage temperature ramp under flowing nitrogen
atmosphere:

1. Room temperature to 150C at 1C per minute — initial solvent evaporation
2. Hold at 150C for 2 hours — plateau for uniform solvent removal
3. 150C to 350C at 0.5C per minute — primary binder decomposition
4. Hold at 350C for 4 hours — complete binder removal
5. 350C to 500C at 1C per minute — residual carbon burnout
6. Cool to room temperature under nitrogen — brown part ready for sintering

Solvent-laden exhaust gas passes through a condenser that recovers liquid
solvent for recycling, then through an activated carbon bed for final
treatment before atmospheric release.

### Sintering Cycle

The brown part transfers to the sintering furnace for densification:

1. Room temperature to 600C at 5C per minute under nitrogen
2. 600C to 1250C at 3C per minute under nitrogen-hydrogen mixture
3. Hold at 1250-1300C for 2 to 4 hours depending on part mass
4. Controlled cool to room temperature at 3C per minute under nitrogen

The hydrogen component in the atmosphere reduces residual oxides on the
metal powder surfaces, promoting strong diffusion bonding between particles.

## Phase 4: CNC Finishing (4-8 Hours)

The sintered part returns to the P-200 for finishing. As described in the
CNC finishing documentation, the machine probes fiducial marks to re-establish
the coordinate system, then executes roughing, semi-finishing, and finishing
passes followed by automated inspection.

## Phase 5: Quality Release (1-2 Hours)

After finishing, the insert undergoes a final quality review:

- CMM verification of critical dimensions against a customer-provided
  inspection plan (if required beyond the P-200's on-machine probing)
- Visual inspection of surface finish under standardized lighting
- Hardness testing on a witness coupon sintered alongside the insert
- Documentation package generation including build parameters, furnace
  cycle data, inspection results, and material certifications

The completed insert ships to the customer with the quality documentation
package. Total elapsed time from CAD file to ready-to-mold insert: 2 to 4
working days, compared with 4 to 8 weeks for conventional toolmaking.
