# F1-03: Porous Silicon via Heat Treatment — Process & Performance

## Overview

Enovix employs a proprietary heat treatment process to create porous silicon
anode structures with controlled void volume. This porosity accommodates
lithiation-induced expansion at the nanoscale before the macroscopic constraint
system engages, enabling the claimed 10x cycle life improvement over earlier
silicon anode technologies.

## The Heat Treatment Process

### Precursor Material

The silicon feedstock is deposited as a dense amorphous or nanocrystalline film
via physical vapor deposition (sputtering or e-beam evaporation) onto the
constraint housing interior. The as-deposited film is >95% dense with a
thickness of 10-30 μm.

### Thermal Processing

The heat treatment step occurs at 500-800°C under controlled atmosphere
(argon with trace hydrogen or forming gas). Key process parameters:

- **Ramp rate:** 5-20°C/min to avoid film delamination
- **Soak temperature:** 600-750°C for 30-120 minutes
- **Atmosphere:** Ar/H2 at 5-10 sccm flow to reduce native oxide
- **Cooling:** Controlled 2-5°C/min to prevent thermal shock cracking

### Porosity Evolution

During the soak period, grain growth and vacancy coalescence create a network
of interconnected nanopores:

- Average pore diameter: 20-80 nm
- Target porosity: 15-25% by volume
- Pore morphology: cylindrical/columnar aligned perpendicular to the film plane

The columnar pore structure is intentional: it provides expansion relief along
the axis parallel to lithium-ion transport while maintaining electrical
continuity in the perpendicular plane.

### Surface Passivation

Post-heat-treatment, the silicon surface is passivated with a thin (<5 nm)
conformal coating — candidates include Al2O3 via atomic layer deposition (ALD)
or a silane-based organic monolayer. This artificial SEI precursor reduces
first-cycle lithium loss from 15-20% (uncoated) to 8-12%.

## Performance Impact

### Cycle Life Gains

| Configuration | Capacity Retention @ 500 cycles | Capacity Retention @ 1,000 cycles |
|---|---|---|
| Dense silicon (no treatment) | ~40% | <20% |
| Heat-treated porous silicon | ~85% | ~72% |
| Heat-treated + constraint system | ~92% | ~85% |

The combination of porosity (nanoscale expansion accommodation) and constraint
(macroscale expansion control) is synergistic: porosity prevents particle-level
fracture while constraint prevents electrode-level delamination.

### Rate Capability

Porous silicon anodes exhibit improved rate capability because:

1. The pore network provides shorter solid-state lithium diffusion paths
   (from ~10 μm in dense films to ~2-5 μm effective diffusion length)
2. Electrolyte infiltration into surface-connected pores increases the
   electrochemically active surface area
3. Reduced polarization at high C-rates due to lower ionic resistance

Data shows 80% capacity retention at 2C discharge for heat-treated anodes
vs. 60% for untreated dense silicon.

### First-Cycle Efficiency

Heat treatment reduces first-cycle irreversible capacity loss (ICL) by
approximately 30-40% relative to untreated silicon. The mechanism is
two-fold: (a) reduced surface area minimizes SEI formation volume and
(b) the passivation coating preemptively satisfies dangling silicon bonds
that would otherwise irreversibly trap lithium.

## Manufacturing Integration

The heat treatment step is integrated into the Gen2 production line at
Fab-1 Penang. It occurs between PVD silicon deposition and electrolyte
filling. The process uses a continuous belt furnace with controlled
atmosphere zones; throughput is matched to the upstream PVD deposition
rate (~1 cell equivalent per minute per furnace). Scale-up to Fab-2
will employ larger multi-zone furnaces capable of processing 4-8 units
per minute.

## Quality Control

In-line monitoring includes:

- Spectroscopic ellipsometry for film thickness and porosity
- Four-point probe for sheet resistance (indirect porosity metric)
- Optical emission spectroscopy for process atmosphere purity
- Destructive sampling: 1 cell per lot for cross-section SEM porosity
  measurement and BET surface area analysis

## References

- Enovix Patent Application WO 2024/089123, "Porous Silicon Anode Fabrication"
- Dr. Murali Ramasubramanian (Enovix VP R&D), "Thermal Processing of Silicon
  Anodes," Advanced Energy Materials, Vol. 15, 2025
- SEM/TEM characterization data, Argonne National Lab, 2024 Annual Report
- Enovix Manufacturing Update, Battery Technology Expo 2025
