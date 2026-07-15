# Stargate Printer Technology — World's Largest Metal 3D Printers

## Printer Architecture

Stargate is Relativity Space's proprietary large-scale metal additive manufacturing platform.
Each Stargate printer is a robotic directed energy deposition (DED) system that builds parts
by feeding metal wire into a laser or plasma arc melting pool, depositing material layer by
layer onto a build platform. Unlike powder-bed metal printing, which is limited to build
volumes measurable in centimeters, DED-based Stargate systems operate at meter scale and
represent the largest metal 3D printers ever deployed in industrial production.

The Stargate platform consists of multiple robotic arms positioned around a central build
volume, each capable of independent operation. The arms carry deposition heads that
simultaneously feed wire, deliver energy to melt it, and shape the deposited bead. By
coordinating multiple arms, Stargate can print at multiple points on a single part
simultaneously, dramatically increasing build speed for large structures.

The build envelope of a Stargate printer measures roughly 30 feet in length and 12 feet in
diameter, sufficient to print an entire rocket stage dome, barrel section, or fairing half
in a single continuous operation. The build platform can rotate and tilt, allowing the
deposition heads to maintain optimal orientation relative to the part surface as geometry
changes throughout the print.

## Control and Quality

The printing process is governed by a closed-loop control system that monitors dozens of
parameters in real time: melt pool temperature, bead geometry, deposition rate, layer height,
and interpass temperature. Machine vision systems compare the as-printed geometry against the
CAD model at each layer, automatically adjusting parameters to maintain dimensional accuracy
within thousandths of an inch over meter-scale parts. This real-time correction capability
is what enables Stargate to produce aerospace-grade structures without the post-machining
steps required by less controlled DED systems.

Relativity has developed proprietary sensor fusion algorithms that combine thermal imaging,
laser profilometry, and acoustic monitoring to detect and characterize any printing anomalies
as they occur. If a defect is detected, the system can autonomously pause the print, execute
a localized repair pass, and resume without scrapping the entire part — a capability that
would be impossible with powder-bed processes where defects are hidden within the powder
volume.

## Multi-Material Capability

While current production focuses on aluminum alloys developed by Relativity's materials
science team, Stargate is designed to print multiple materials within a single build. This
enables the printing of bi-metallic structures — for example, a copper alloy heat exchanger
interface integrally bonded to an aluminum structural member — in a single continuous
operation. The multi-material capability is particularly relevant for engine components,
where thermal management requirements demand different materials in different zones of a
single part.

## Throughput and Scalability

The fourth-generation Stargate system, introduced alongside the Terran R production ramp,
achieves a 7x improvement in deposition rate compared to the third-generation systems used
to print the Terran 1 vehicle. This generational improvement comes from larger wire diameter
feedstock, higher laser power, optimized scan path algorithms that minimize non-printing
travel time, and the addition of more simultaneous robotic arms per printer.

Relativity's factory layout is designed to accommodate dozens of Stargate printers operating
in parallel, fed by an automated material handling system that delivers aluminum wire spools
to each printer without human intervention. The goal is to achieve a production rate
comparable to automotive manufacturing, where a new vehicle rolls off the line at
intervals measured in hours rather than the weeks or months typical of aerospace production.
