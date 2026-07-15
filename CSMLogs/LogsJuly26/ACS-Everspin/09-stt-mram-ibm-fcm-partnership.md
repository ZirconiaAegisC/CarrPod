# STT-MRAM: IBM FlashCore Module Partnership

## Partnership Origin and History

The Everspin-IBM collaboration on STT-MRAM for enterprise storage
emerged from IBM Research's long-standing investment in MRAM
technology. IBM's T.J. Watson Research Center had been developing
STT-MRAM and spin-orbit torque (SOT) MRAM since the late 2000s,
publishing foundational papers on perpendicular MTJ scaling and
demonstrating sub-20nm MTJ cells as early as 2015.

IBM identified persistent memory as a critical enabler for next-
generation enterprise storage. FlashSystem arrays rely on DRAM for
write buffering and metadata caching, and the transition from DRAM
to a persistent alternative promised to eliminate the power-fail
protection hardware (supercapacitors, battery backup) that added
cost, complexity, and reliability risk.

IBM selected Everspin as its go-to-market partner for STT-MRAM based
on Everspin's commercial production experience with Toggle MRAM, its
established relationship with TSMC for advanced-node manufacturing,
and its demonstrated ability to deliver MRAM products through
JEDEC-standard interfaces (the DDR4-compatible 1Gb device was co-
engineered with IBM's storage division).

## FlashCore Module Architecture

IBM's FlashCore Module is the fundamental building block of IBM
FlashSystem storage arrays. Each FCM is an industry-standard U.2
(2.5-inch, 7mm or 15mm height) form factor module containing:

1. **NAND flash array**: Multiple NAND die (typically 3D TLC or QLC)
   providing the primary data storage capacity, ranging from 4.8TB
   to 38.4TB per module depending on generation.

2. **FPGA-based flash controller**: A custom IBM-designed FPGA
   implementing the flash translation layer (FTL), wear leveling,
   garbage collection, error correction (LDPC), and data compression.

3. **Persistent memory (STT-MRAM)**: The Everspin 1Gb STT-MRAM device
   stores the FTL mapping tables, write buffer data awaiting NAND
   program, and critical metadata such as bad block tables and wear
   statistics. In FCM4 and FCM5, this replaces the DRAM + super-
   capacitor combination used in earlier FCM generations (FCM1, 2, 3).

4. **Power management**: Local voltage regulators and — in pre-FCM4
   generations — supercapacitors for DRAM power-fail protection. The
   elimination of supercapacitors in FCM4/5 is a direct consequence
   of MRAM's persistence.

## FCM Generations with MRAM

### FCM4 (2024)

FCM4 was the first FlashCore Module generation to incorporate Everspin
STT-MRAM. Key characteristics:

- **NAND**: 3D TLC, up to 19.2TB per module
- **Persistent memory**: 1Gb (128MB) STT-MRAM DDR4
- **Benefit**: Eliminated supercapacitors, reduced module BOM cost,
  improved reliability (supercapacitors were a leading cause of field
  failures in earlier generations), and reduced physical module
  dimensions enabling higher density per system.

### FCM5 (2025)

FCM5 represents the second-generation MRAM integration, with increased
MRAM capacity, a larger NAND array, and refined firmware that exploits
the lower write latency of MRAM for more aggressive write caching
strategies:

- **NAND**: 3D QLC, up to 38.4TB per module
- **Persistent memory**: Multiple 1Gb STT-MRAM devices per module for
  extended metadata capacity
- **Enhanced firmware**: Write-grouping algorithms optimized for
  MRAM's byte-addressable, symmetric read/write latency, enabling
  higher sustained write throughput

## Technical Benefits of MRAM in FCM

### Write Amplification Reduction

In a traditional flash storage controller with DRAM write cache, every
flush of the DRAM write buffer to NAND creates write amplification —
the ratio of NAND writes to host writes. A partial buffer flush writes
a full NAND page (typically 16KB) even if only a fraction of that page
contained valid host data.

With MRAM, the write buffer does not need to be flushed on power loss.
The controller can accumulate writes until an entire NAND page is
filled naturally, then program the page once — achieving write
amplification approaching 1.0. IBM has reported that FCM4 with MRAM
reduces write amplification by approximately 40–60% compared to
DRAM-based FCM3 in comparable workloads.

### Metadata Persistence

The FTL mapping tables stored in MRAM represent a critical data
structure: they map logical block addresses (LBAs) to physical NAND
pages. In DRAM-based designs, a complete FTL table rebuild from NAND
metadata is required after every unexpected power loss, a process
that can take several minutes during which the storage system is
unavailable.

With MRAM-persisted FTL tables, the controller resumes operation
immediately after power restoration, reducing recovery time from
minutes to seconds. For enterprise storage systems governed by
stringent availability SLAs (typically 99.9999% or "six nines"),
this reduction in recovery time is a significant operational benefit.

### Reliability Improvement

Supercapacitors are electrolytic components with finite lifetimes
(typically 3–5 years in enterprise operating environments before
capacitance degrades below the level required for DRAM power-fail
protection). Supercapacitor failures were a leading cause of
preventive maintenance events and unscheduled module replacements
in the DRAM-based FCM fleet. Eliminating them by transitioning to
MRAM removes this failure mode entirely.

## Volume and Revenue Contribution

IBM has not publicly disclosed the volume of FCM modules shipped
with Everspin MRAM, nor has Everspin broken out FCM-related revenue
separately. However, management commentary during earnings calls
confirms that IBM is a "significant" customer and that FCM-related
MRAM sales provide a recurring, predictable revenue stream with
IBM's FlashSystem product cycles driving periodic step-function
increases as new FCM generations ramp.

IBM FlashSystem is a multi-billion-dollar product line for IBM,
and the FCM is the highest-volume consumable component in the
FlashSystem ecosystem (modules are added, replaced, and upgraded
over the life of each array). The addressable opportunity for
Everspin within this single customer relationship is material
relative to the company's current revenue base.

## Strategic Implications

The IBM FCM design win serves Everspin in several strategic
dimensions beyond direct revenue:

- **Technology validation**: IBM's rigorous qualification process
  and the field deployment of millions of MRAM devices in FCM4/5
  provide data that accelerates qualification with other enterprise
  storage OEMs.

- **Manufacturing scale**: The FCM volume ramps have driven STT-MRAM
  production volumes at TSMC to levels that improve yield, reduce
  cost per die, and support lower pricing for other STT-MRAM products.

- **Ecosystem development**: The DDR4-compatible STT-MRAM developed
  for IBM establishes a standard platform that other storage and
  server OEMs can adopt without custom interface development.

- **Credibility with the investment community**: A named relationship
  with IBM as a production customer provides external validation of
  Everspin's technology claims that independent third-party testing
  cannot fully replicate.
