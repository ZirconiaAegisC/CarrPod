# Toggle MRAM: Product Line & Interface Variants

## Product Portfolio Overview

Everspin's Toggle MRAM product family spans densities from 128Kb to
32Mb, all fabricated on the Chandler, Arizona 200mm line. These
products have been in continuous commercial production since 2008,
representing one of the longest-running non-volatile memory product
lines in the semiconductor industry. The product family serves
applications where data integrity, write endurance, and radiation
tolerance are paramount.

The product naming convention uses the MR prefix followed by density
and interface type. For example, MR256A08B is a 256Kb (32K × 8)
parallel-interface Toggle MRAM part.

## Density Range and Organization

| Density | Organization | Interface   | Part number family |
|---------|-------------|-------------|--------------------|
| 128Kb   | 16K × 8     | Parallel    | MR0A08B            |
| 256Kb   | 32K × 8     | Parallel    | MR256A08B          |
| 1Mb     | 128K × 8    | Parallel    | MR1A08B            |
| 4Mb     | 512K × 8    | Parallel    | MR4A08B            |
| 4Mb     | 512K × 8    | SPI         | MR25H40            |
| 16Mb    | 2M × 8      | Parallel    | MR2A16A            |
| 16Mb    | 2M × 8      | SPI/QSPI    | MR25H256A          |
| 32Mb    | 4M × 8      | Parallel    | Various            |

## Interface Variants

### Parallel Interface Parts

Parallel Toggle MRAM devices present a standard asynchronous SRAM-like
interface to the host system: address bus, bidirectional data bus, and
control signals (Chip Enable, Output Enable, Write Enable). The timing
protocol mirrors standard asynchronous SRAM, allowing these parts to
serve as drop-in replacements for battery-backed SRAM (BB-SRAM) and
low-power SRAM in industrial and military systems.

Access times range from 35 ns to 45 ns depending on density and
temperature grade. The parallel interface enables access rates
approaching 100 MHz for sequential reads when paired with a
sufficiently fast memory controller.

A key benefit of the SRAM-compatible interface is elimination of the
block-erase and page-program complexity of NOR flash. The host can write
a single byte or any arbitrary sequence without pre-erase operations,
simplifying both hardware and software design.

### SPI and QSPI (Quad SPI) Interface Parts

For lower-pin-count applications, Everspin offers Toggle MRAM in
standard SPI (Serial Peripheral Interface) and QSPI (Quad SPI)
configurations. These parts use the standard SPI command set
familiar to embedded systems developers, with operational codes
for read, write, status register access, and device identification.

QSPI variants support dual and quad I/O modes, increasing data
throughput to approximately 40–54 MB/s on read operations, which
rivals or exceeds flash SPI throughput while offering faster writes
(byte-level, no page buffer delay).

SPI/QSPI Toggle MRAM devices at 1Mb to 16Mb densities are commonly
used in:
- Programmable logic controllers (PLCs) for configuration data
- Industrial sensor hubs for data logging
- Automotive event data recorders
- Satellite telemetry subsystems
- Medical device parameter storage

## Temperature and Reliability Grades

Everspin qualifies Toggle MRAM parts across three temperature ranges:

- **Commercial (0°C to +70°C)**: For general embedded and office
  equipment applications.
- **Industrial (-40°C to +85°C)**: Extended temperature range for
  factory automation, outdoor infrastructure, and automotive cabin
  electronics.
- **Military / Aerospace (-55°C to +125°C)**: Full military temperature
  range, with additional screening per MIL-PRF-38535 and MIL-STD-883
  requirements for defense and space applications.

High-reliability screening options include:
- Burn-in at 125°C for 48–160 hours
- Temperature cycling per MIL-STD-883 Method 1010
- Particle impact noise detection (PIND) testing
- Fine and gross leak testing per MIL-STD-883
- Single-event effects (SEE) characterization data provided

## Packaging

Toggle MRAM products are available in standard JEDEC packages including:

- 44-pin TSOP-II (Thin Small Outline Package, Type II)
- 48-pin FBGA (Fine-pitch Ball Grid Array), 6×8 mm
- 8-pin SOIC (Small Outline Integrated Circuit) for SPI parts
- 8-pin DFN (Dual Flat No-lead), 5×6 mm

Ceramic packaging (Ceramic Dual Inline Package, CERDIP, and Ceramic
Flat Pack) is available for military and space-grade parts requiring
hermetic sealing.

## Product Longevity and Lifecycle Management

Everspin commits to long product lifecycles for Toggle MRAM products
targeting industrial and defense sockets, typically 15+ years from
product introduction. This is significantly longer than the 3–5 year
lifecycle typical of consumer semiconductor products and aligns with
the qualification and design-in timelines for aerospace and defense
systems, which often require 2–4 years from initial qualification to
volume production.

## Competitive Alternatives

In the sockets addressed by Toggle MRAM, the primary competitive
technologies are:

- **Battery-Backed SRAM (BB-SRAM)**: Requires a battery or supercapacitor
  for data retention; battery replacement creates a maintenance burden;
  battery failure results in data loss.
- **Ferroelectric RAM (FRAM)**: Competitive endurance, limited to lower
  densities; radiation performance inferior to MRAM.
- **NOR Flash with SRAM cache**: Complex software management; limited
  write endurance; long erase times stall the host.

Toggle MRAM eliminates each of these limitations, providing the
non-volatility of flash, the speed and byte-write capability of
SRAM, and the endurance and radiation tolerance that no single
competing technology can match at comparable densities.
