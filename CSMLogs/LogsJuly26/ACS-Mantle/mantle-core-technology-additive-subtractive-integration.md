# Mantle Core Technology — Integrated Additive-Subtractive Architecture

## The Two-in-One Paradigm

Mantle's most significant engineering achievement is the tight integration of
additive and subtractive manufacturing processes within a single machine
architecture. This integration eliminates the single largest bottleneck in
traditional toolmaking: the weeks of CNC programming, setup, and machining
that follow any additive metal process. By combining both functions in one
enclosure, Mantle achieves the "ready to mold" outcome that defines its value
proposition to tooling departments.

## Why Integration Matters

### The Registration Problem

In conventional metal additive manufacturing, printed parts must be removed
from the printer, inspected, heat treated, and then fixtured into a separate
CNC machine for finishing. Each transfer introduces registration errors.
For tooling inserts requiring 10-micron positional tolerances across parting
line features, even a 50-micron misalignment during re-fixturing can scrap
a part representing 24 to 48 hours of print time. Mantle eliminates this
problem entirely — the part never leaves the machine's coordinate system
between printing and finishing.

### The Programming Bottleneck

A typical injection mold insert requires 20 to 80 hours of CAM programming
by a skilled CNC programmer who must understand tooling geometry, cooling
channel layouts, and ejection pin clearances. Mantle's TrueShape software
automates the majority of this programming. Because the system knows the
exact as-printed geometry, it can generate finish toolpaths that remove
precisely the required stock allowance — typically 0.2 to 0.5 mm — without
programmer intervention.

### Thermal Stability

When a printed metal part cools from sintering temperature (approximately
1300C) to room temperature, it undergoes thermal contraction. If the part is
then moved to a different machine for finishing, the new machine's thermal
environment may differ from the printer's, introducing additional dimensional
uncertainty. By performing all operations at a stabilized ambient temperature
within the same machine enclosure, Mantle ensures that thermal expansion
effects are consistent and compensable throughout the workflow.

## Machine State Management

The P-200 maintains a unified coordinate system that persists across build
and machining phases. After sintering, the part returns to the P-200 for
finishing. The machine uses fiducial marks printed into the part during the
build phase to re-establish the coordinate system with sub-micron repeatability.
An automated probing cycle maps the actual sintered surface to the CAD model,
generating an adaptive toolpath that compensates for any non-uniform shrinkage.

## Advantages Over the Two-Machine Approach

| Factor | Two-Machine Approach | Mantle Integrated |
|--------|---------------------|-------------------|
| Registration error | 25-100 microns | Less than 5 microns |
| Programming time | 20-80 hours | 1-3 hours |
| Floor space | 15-25 square meters | 5 square meters |
| Operator skill requirement | Senior toolmaker | Training in 2 weeks |
| Total lead time | 4-10 weeks | 2-4 days per insert |
| Scrap rate | 10-25 percent | Under 5 percent |

## Software Integration

TrueShape serves as the digital thread connecting CAD to finished part.
The software ingests standard tooling CAD formats including Parasolid, STEP,
and native SolidWorks files. It automatically identifies parting surfaces,
cooling channel geometries, ejector pin bores, and gate locations. The
toolpath generation engine respects these features, applying tighter
tolerances to functional surfaces (parting lines, shutoffs) and relaxed
tolerances to non-critical surfaces (mold base mounting faces).

## Future Development

Mantle's technology roadmap includes extending the integrated approach to
larger build volumes suitable for automotive bumper tooling, integrating
laser texturing for in-machine graining of cosmetic surfaces, and developing
closed-loop thermal compensation that adjusts toolpaths in real time based
on in-situ temperature measurements of the workpiece during finishing.
