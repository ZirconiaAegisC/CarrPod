# F2-02: Gen2 Manufacturing Process Scale-Up

## From Lab to Production

Enovix's Gen2 manufacturing represents the transition from prototype-scale
production at the Fremont R&D facility to high-volume commercial manufacturing
at Fab-1 Penang, Malaysia. The Gen2 process is designed for 11.5 million units
per year per line, targeting the smartphone battery market.

## Process Flow Overview

The Gen2 production line consists of nine sequential stations:

### Station 1: Housing Preparation

Precision-stamped stainless steel housing components are cleaned via ultrasonic
degreasing and plasma treatment. Critical dimensions (wall thickness, cavity
depth, parallelism) are verified via in-line laser profilometry with ±5 μm
tolerance. Reject rate at this station: <0.5%.

### Station 2: Cathode Electrode Fabrication

NMC cathode material (NMC 811 or equivalent) is slurry-cast onto aluminum foil
using a slot-die coater. The coated foil is calendered to target porosity
(~25-30%), slit to width, and dried in a continuous convection oven. This
station largely mirrors conventional Li-ion cathode manufacturing, leveraging
established equipment supply chains.

### Station 3: Silicon Anode Deposition (PVD)

The silicon anode is deposited via magnetron sputtering directly onto the
interior walls of the housing. This is the most technically demanding station:

- Base pressure: <10^-6 Torr
- Deposition rate: 5-15 nm/s
- Target film thickness: 15-30 μm (depends on cell design)
- Substrate temperature: 200-300°C (promotes columnar grain growth)
- Throughput: ~1 unit per 2-3 minutes per chamber

The PVD tool is a custom-modified cluster system with 4-6 deposition chambers
operating in parallel to match the line takt time.

### Station 4: Heat Treatment

As described in F1-03: belt furnace at 600-750°C under Ar/H2 atmosphere.
Process time: 60-90 minutes including ramp and cool. The furnace uses multiple
controlled zones to maintain temperature uniformity within ±5°C.

### Station 5: Separator Insertion

A pre-cut polyolefin separator (12-16 μm thickness) is robotically inserted
into the housing cavity with alignment tolerances of <50 μm. The separator
must conform to the 3D cavity geometry without wrinkling. A vacuum-assisted
placement fixture is used.

### Station 6: Electrolyte Filling

Proprietary electrolyte formulation containing FEC additive (5-10 wt%) is
dispensed via precision micropump into the sealed cell. Fill volume accuracy
is ±1%. The cell is then subjected to a vacuum cycling process to ensure
complete wetting of the porous electrode and separator.

### Station 7: Formation Cycling

Cells undergo 1-3 charge/discharge cycles at low C-rate (0.1-0.2C) under
controlled temperature (25-45°C) to form the SEI layer. Formation data
(first-cycle efficiency, capacity, impedance) is recorded for every cell and
used for grading.

### Station 8: Aging & Grading

Cells are aged at elevated temperature (45°C) for 24-72 hours at partial state
of charge (~50%) to stabilize the SEI. Post-aging, each cell undergoes a
capacity test, internal resistance measurement, and self-discharge screening
(K-value). Cells are graded A/B/C based on performance spread.

### Station 9: Final Assembly & Test

Graded cells receive terminal welding, protective coating, and visual
inspection. End-of-line testing includes HiPot (dielectric withstand),
AC impedance spectroscopy, and a final capacity check. Cells are serialized
with QR codes for full traceability back to wafer lot and process parameters.

## Key Process Metrics (Fab-1, Q4 2025)

| Metric | Target | Actual (Q4 2025) |
|---|---|---|
| Overall equipment effectiveness (OEE) | 85% | 72% |
| First-pass yield (formation to grade A) | 90% | 78% |
| Capacity distribution (CpK) | 1.33 | 0.95 |
| Line throughput (units/day) | 31,500 | 18,000 |
| Scrap rate (materials cost) | 5% | 12% |

The gap between target and actual reflects the ongoing ramp: PVD deposition
uniformity and formation cycle optimization are the primary yield limiters.

## Cost Structure (at Target Volume)

| Cost Element | $/Cell | % of Total |
|---|---|---|
| Cathode materials (NMC) | $1.20 | 17% |
| Silicon (target + deposition) | $0.85 | 12% |
| Housing (stainless steel) | $0.70 | 10% |
| Electrolyte | $0.45 | 6% |
| Separator | $0.25 | 4% |
| Direct labor | $0.65 | 9% |
| Equipment depreciation | $1.10 | 16% |
| Factory overhead | $0.80 | 11% |
| Total COGS | $6.00 | 85% |
| Gross margin (at $8-10 ASP) | $2.00-4.00 | 15-40% |

Target gross margins of 30-40% at scale are consistent with premium battery
manufacturing economics once yields stabilize.

## References

- Enovix Manufacturing Day Presentation, October 2025
- Fab-1 Penang Inauguration Press Release, Enovix Corp, March 2025
- Dr. Ajay Marathe (COO), "Scaling 3D Silicon Battery Manufacturing,"
  SEMICON West 2025 Keynote
- Internal Enovix process documentation, Q4 2025 Operations Review
