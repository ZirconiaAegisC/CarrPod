# 06 — 100MW PRODUCTION LINE: CAPACITY, YIELD & SCALE-UP

## Production Capacity and Ramp-Up

Oxford PV's Brandenburg production line is designed with a nameplate capacity of 100 MW per annum, measured at the module level under standard test conditions. The line achieved first commercial production in Q4 2024, with shipments of tandem modules to initial customers commencing in December 2024. Production ramp-up followed a staged commissioning approach:

| Quarter | Cumulative Production (MW) | Module Yield (%) | Throughput (modules/day) |
|---------|---------------------------|------------------|--------------------------|
| Q4 2024 | 2.5 | 72 | 45 |
| Q1 2025 | 12 | 78 | 95 |
| Q2 2025 | 28 | 84 | 140 |
| Q3 2025 (projected) | 52 | 88 | 195 |
| Q4 2025 (projected) | 85 | 90+ | 250 |

The yield ramp from 72% to a projected 90%+ over 12 months reflects the maturation of the manufacturing process, including optimization of perovskite deposition uniformity, reduction of edge defects, improved lamination yield, and refinement of end-of-line test pass criteria. Module yields in high-volume silicon manufacturing typically stabilize at 98–99%; Oxford PV's target of 90%+ by end-2025 reflects the early-stage nature of the tandem manufacturing process and the additional complexity introduced by the perovskite deposition and integration steps.

## Throughput Analysis

At nameplate capacity (100 MW/year), the production line is sized to produce approximately 220,000 modules per year, assuming an average module power of 455 W. This translates to approximately 730 modules per day on a 300-operating-day calendar, or 30 modules per hour across a three-shift, 24-hour operation.

The throughput is constrained by three bottleneck processes:

1. **Perovskite deposition**: The vacuum co-evaporation system has a takt time of approximately 95 seconds per cell for a batch size of 24 cells, yielding approximately 910 cells per hour. At 72 cells per module, this supports approximately 12.6 modules per hour. Multi-tool deployment (three deposition chambers operating in parallel) raises system throughput to approximately 38 modules per hour.

2. **Solvent annealing**: Post-deposition annealing requires a controlled-atmosphere dwell time of 25–40 minutes per batch, depending on the specific perovskite composition and targeted grain size. The annealing section comprises six parallel ovens, each with a 24-cell capacity, providing a combined throughput matching the deposition system.

3. **Module lamination**: The lamination cycle time (heat-up, dwell, cool-down) is approximately 16 minutes per cycle. The lamination section comprises three multi-daylight laminators, each capable of processing eight modules per cycle, for a combined throughput of approximately 90 modules per hour — well in excess of the upstream bottleneck.

## Expansion Roadmap: 600MW by 2027

Oxford PV has announced plans to expand the Brandenburg facility from 100 MW to 600 MW annual capacity by 2027. The expansion is predicated on:

- **Proven market demand**: A 250 MW order backlog as of Q1 2025 provides revenue visibility supporting the capital investment case.
- **Process maturity**: The yield ramp to 90%+ and demonstrated process stability provide confidence that additional production lines can be commissioned predictably.
- **Partner co-investment**: Discussions with strategic partners, including silicon cell suppliers and project developers, for co-investment in capacity expansion.

The 600 MW expansion will require:

- **Additional cleanroom space**: Approximately 8,000 m² of new or reconfigured cleanroom area, primarily to house additional perovskite deposition tools and back-end processing equipment.
- **Capital expenditure**: An estimated EUR 150–200 million, with approximately 60% allocated to process equipment and 40% to facility infrastructure.
- **Workforce expansion**: An additional 300–350 personnel, bringing total Brandenburg employment to approximately 600–630.
- **Silicon cell supply**: Approximately 1.3 million HJT or TOPCon cells per year at 600 MW module output, requiring secure, multi-year supply agreements with tier-1 cell manufacturers.

## Equipment Suppliers and Technology Partners

Oxford PV has developed a supplier ecosystem that combines custom-designed proprietary equipment with adapted commercial tools from established photovoltaic equipment manufacturers:

| Process Step | Equipment Supplier | Notes |
|-------------|-------------------|-------|
| Silicon cell metrology | HALM, Wavelabs | Standard commercial tools |
| Surface preparation | Siconnex, Singulus | Adapted from HJT cleaning |
| Perovskite deposition | Oxford PV (proprietary) | Custom co-evaporation and HCVD systems, built to Oxford PV specification by German vacuum engineering firm |
| TCO sputtering | Von Ardenne, Singulus | Adapted from HJT TCO deposition |
| Laser scribing | 3D-Micromac, InnoLas | Adapted with custom optics for perovskite ablation |
| Module stringing | Teamtechnik, Mondragon | Standard commercial tools |
| Lamination | Bürkle, NPC | Adapted cycle recipe for tandem modules |
| End-of-line testing | HALM, PASAN | Custom spectrum and IV range for tandem modules |

The vertical integration of perovskite deposition tool design is a critical element of Oxford PV's intellectual property strategy. By retaining control over the deposition equipment design, the company protects the detailed process parameters (precursor composition, deposition rate, substrate temperature, chamber atmosphere) that constitute its core manufacturing know-how. In licensing scenarios, Oxford PV supplies the deposition tools and process recipes as a bundled package, ensuring consistent product quality across licensed manufacturing sites.

## Quality Management System

The Brandenburg facility operates a quality management system certified to ISO 9001:2015. Key quality control gates include:

**Incoming Inspection (IQC)**:
- Silicon cells: 100% IV and EL testing, 5% sample for dimensional and visual inspection per incoming lot.
- Perovskite precursors: Certificate of analysis verification, ICP-MS purity testing per batch.
- Encapsulants and glass: Dimensional, optical, and mechanical testing per supplier lot.

**In-Process Control (IPQC)**:
- Post-deposition perovskite film: In-line photoluminescence imaging for uniformity and defect density; in-line spectral reflectance for thickness and composition.
- Post-TCO: Sheet resistance mapping (eddy current), optical transmission spectroscopy.
- Post-laser scribing: Machine vision inspection of scribe dimensions and edge quality.
- Post-lamination: Visual inspection (automated, machine vision), electroluminescence imaging.

**End-of-Line Testing (EOL)**:
- 100% IV testing under Class AAA AM1.5G solar simulator with spectral mismatch correction.
- 100% electroluminescence imaging for crack, finger interruption, and shunt detection.
- 100% hipot testing (IEC 61730-2).
- Sample-based (0.5% of production) damp heat and thermal cycling testing for ongoing reliability monitoring.

## References

- Oxford PV. "Production Ramp-Up Plan: Brandenburg Facility, 2024–2027." Internal Document, 2025.
- "Oxford PV Ships First Commercial Tandem Modules." *PV Magazine*, 12 December 2024.
- ISO 9001:2015. "Quality management systems — Requirements." International Organization for Standardization.
- Teamtechnik GmbH. "TT1600 Stringer: Technical Specification for HJT Cell Processing." 2023.
