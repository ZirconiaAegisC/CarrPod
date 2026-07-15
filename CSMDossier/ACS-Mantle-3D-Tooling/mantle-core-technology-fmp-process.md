# Mantle Core Technology — Flowable Metal Paste (FMP) Process

## Overview

Mantle's foundational innovation is the Flowable Metal Paste (FMP) process, a proprietary
metal-polymer slurry that enables precision additive manufacturing of tool steel components.
Unlike conventional metal powder bed fusion systems, FMP extrudes a room-temperature paste
composed of fine metal powder suspended in a thermoplastic binder. The paste is deposited
layer by layer onto a heated build platform where the binder softens and the layers fuse.

## Process Stages

### Extrusion and Green Part Formation

The FMP material is loaded into sealed cartridges and fed through a heated nozzle assembly.
Layer heights range from 25 to 100 microns depending on the tooling application. Each layer
is deposited with positional accuracy measured in single-digit microns, enabled by Mantle's
closed-loop servo control system running at kilohertz update rates. The green part retains
the exact geometry programmed from the tooling CAD model.

### Debinding

After the build phase, green parts enter a thermal debinding cycle. The thermoplastic
binder is removed through a controlled atmosphere furnace process operating at temperatures
between 200C and 500C. Binder components vaporize and exit through a solvent recovery
system, leaving behind a porous metal skeleton — the brown part. Mantle's debinding
chemistry minimizes part shrinkage and distortion, a key challenge in metal AM.

### Sintering

The brown part undergoes high-temperature sintering in a reducing atmosphere furnace at
temperatures approaching 1300C. During this stage, metal powder particles fuse through
diffusion bonding, reducing porosity from roughly 40 percent to less than 2 percent.
The result is a near-fully-dense tool steel insert with mechanical properties comparable
to conventionally manufactured H13 and P20 tool steels.

### Integrated CNC Finishing

Critically, sintered parts maintain a machinable surface condition. The P-200 printer
incorporates precision CNC milling within the same machine envelope, allowing inserts
to be finished to micron-level tolerances without removing the workpiece from the
machine. This additive-then-subtractive sequence eliminates registration errors from
part transfer between separate systems.

## Material Properties

FMP-derived H13 tool steel achieves hardness values of 48-52 HRC after heat treatment.
Tensile strength exceeds 1500 MPa. Thermal conductivity and wear resistance are
equivalent to wrought H13, making FMP parts suitable for injection molding cycles
exceeding one million shots. P20 tool steel printed via FMP maintains its machinability
advantage for mold base applications requiring post-sintering modifications.

## Distinction from Competing Processes

FMP differs fundamentally from laser powder bed fusion (LPBF) and binder jetting:

- LPBF requires expensive spherical powders, inert gas atmospheres, and extensive
  support structures. Mantle's paste extrusion needs no supports for most geometries
  because the binder provides green-state structural integrity.
- Binder jetting produces high-porosity green parts requiring infiltration with a
  secondary metal. FMP produces self-sintering parts with no infiltration step.
- Both competing processes demand separate CNC finishing operations, adding days
  of setup and programming time. Mantle's integrated approach eliminates the
  programming bottleneck.

## Patent Portfolio

Mantle holds multiple patents covering the FMP formulation, extrusion head design,
temperature-controlled build chamber, and integrated CNC toolpath generation. The
company's intellectual property moat around the paste chemistry and process control
algorithms represents a significant barrier to entry.
