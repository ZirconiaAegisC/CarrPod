# Persist EMxxLX: xSPI STT-MRAM Architecture & Design

## Product Family Overview

The Everspin Persist EMxxLX family is a line of STT-MRAM devices
targeting industrial, embedded, and aerospace applications that require
high-reliability non-volatile memory with a serial peripheral interface.
The family uses the xSPI (eXpanded Serial Peripheral Interface)
protocol, which is the JEDEC JESD251 standard for octal and quad SPI
non-volatile memory devices. The xSPI interface provides high
throughput while maintaining the low pin count essential for embedded
system designs.

The EMxxLX naming convention follows: EM = Everspin Memory, xx =
density code (e.g., 064 for 64Mb, 128 for 128Mb, 256 for 256Mb), L =
low-voltage, X = xSPI interface.

## Density Range and Current Status

The Persist family spans densities from 4Mb to 256Mb:

| Density | Part Name      | Status                    |
|---------|---------------|---------------------------|
| 4Mb     | EM004LX       | Full production            |
| 8Mb     | EM008LX       | Full production            |
| 16Mb    | EM016LX       | Full production            |
| 32Mb    | EM032LX       | Full production            |
| 64Mb    | EM064LX       | Full production            |
| 128Mb   | EM128LX       | Qualification (H2 2026)    |
| 256Mb   | EM256LX       | Qualification (H2 2026)    |

The 64Mb device reached full production status in 2025, representing
a critical milestone: it is the highest-density xSPI STT-MRAM in
volume production and positions Everspin as the density leader in the
embedded non-volatile memory market served by SPI/xSPI interfaces.

The 128Mb and 256Mb parts are in qualification during the second half
of 2026, with sampling to lead customers beginning earlier. These
higher densities expand the addressable market into applications
previously served exclusively by NOR flash or serial NAND flash.

## Process Technology

The Persist EMxxLX family is fabricated on TSMC's 28nm CMOS process
with Everspin's proprietary perpendicular STT-MRAM MTJ integrated
into the BEOL. The 28nm node provides an optimal balance of:

- **Transistor drive strength**: 28nm logic transistors can reliably
  supply the 40–80 µA write current required by STT-MRAM cells at
  the 60–80 nm MTJ pillar diameters used in this product family.

- **Cost**: 28nm is a mature, fully depreciated node at TSMC, offering
  competitive wafer cost relative to more advanced nodes.

- **Reliability**: The 28nm node has extensive characterization data
  for extended-temperature and high-reliability operation, reducing
  the qualification burden for industrial and aerospace customers.

- **Analog circuit performance**: The sense amplifiers, voltage
  regulators, and reference generators required by STT-MRAM benefit
  from the robust analog transistor characteristics at 28nm.

## xSPI Interface Protocol

The xSPI (JESD251) standard extends the classic SPI protocol to
support higher data rates and multiple I/O widths:

- **Single SPI**: 1-bit data, legacy mode compatible with standard
  SPI controllers, ~10 MB/s throughput
- **Dual SPI**: 2-bit data, ~20 MB/s
- **Quad SPI (QSPI)**: 4-bit data, ~40 MB/s
- **Octal SPI**: 8-bit data, ~80 MB/s at 80 MHz, higher at 133 MHz

The Persist EMxxLX family supports the full xSPI protocol including
octal mode. The protocol includes JEDEC-standard command opcodes for:

- Read operations (single, dual, quad, octal I/O)
- Program operations (single, dual, quad, octal)
- Status register read/write
- Device identification (JEDEC Manufacturer ID, Device ID)
- Security features (password protection, write protection per sector)

Crucially, unlike NOR flash xSPI devices, the Persist family does not
require block erase before write operations. The host can issue a
write command to any address at any time, and the device executes it
immediately. This eliminates the erase-before-write constraint that
complicates file system and database implementations on NOR flash.

## Write Performance Advantage

The absence of erase operations gives Persist xSPI STT-MRAM a
decisive write performance advantage over NOR flash:

| Metric              | Persist STT-MRAM | NOR Flash (typical) |
|---------------------|------------------|----------------------|
| Write granularity   | 1 byte           | 1 page (256 bytes)   |
| Write latency       | ~50 ns           | ~10 µs (page program)|
| Block erase time    | N/A              | ~50–200 ms           |
| Write endurance     | 10^6–10^8 cycles | 10^4–10^5 cycles     |
| Write energy/byte    | ~2 pJ            | ~50 nJ (incl. erase) |

For data logging applications that write small records at high
frequency (for example, an industrial sensor writing 64 bytes
every 1 ms), the Persist device can sustain this workload
indefinitely without the periodic block-erase stalls that would
cause a NOR flash device to fall behind the data stream.

## Power Management

Persist devices are designed for low-power operation, with:

- **Active read current**: 15–25 mA at 80 MHz (octal mode)
- **Active write current**: 25–40 mA
- **Standby current**: <100 µA
- **Deep power-down current**: <5 µA

The deep power-down mode is particularly important for battery-
operated systems (remote sensors, satellite subsystems, medical
implants) where the memory device may spend >99% of its operating
life in standby. The fast wake-up time from deep power-down (on
the order of 10 µs) allows the system to enter the lowest power
state without sacrificing responsiveness.

## Temperature Range and Qualification

All Persist EMxxLX devices are specified for the industrial
temperature range (-40°C to +85°C ambient) standard. Extended
temperature variants (-40°C to +105°C) are available for
automotive under-hood and aerospace applications.

The qualification process for each density includes:
- 1000 hours of high-temperature operating life (HTOL) at 125°C
- 1000 temperature cycles (-65°C to +150°C)
- High-temperature storage (HTS) at 150°C for 1000 hours
- Preconditioning per JEDEC JESD22-A113 (moisture sensitivity)
- Electrostatic discharge (ESD) testing: 2kV HBM, 500V CDM

## Package Options

The Persist family is offered in industry-standard packages:

- 8-pin SOIC (150 mil and 208 mil body widths)
- 8-pin DFN (5×6 mm and 4×4 mm)
- 24-ball BGA (5×5 ball array, 1.0 mm pitch)
- Known Good Die (KGD) for multi-chip module (MCM) and system-in-
  package (SiP) integration

KGD availability is particularly important for satellite applications,
where memory dice are often integrated into custom ceramic MCMs
alongside radiation-hardened FPGAs and processors, reducing overall
module mass and volume compared to discrete packaged parts.
