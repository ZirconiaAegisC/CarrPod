# Unisys: Product Architecture & NOR Flash Comparison

## Unisys Product Family Overview

The Unisys family is Everspin's next-generation STT-MRAM product line
specifically designed to displace NOR flash in embedded systems. The
family name "Unisys" reflects its unified memory architecture: a
single memory device that combines the persistence and density of NOR
flash with the fast random-access read/write performance and byte
addressability of SRAM. Unisys devices use the xSPI (JESD251)
interface protocol, making them pin-compatible with many existing NOR
flash sockets and enabling evaluation without hardware redesign.

Unisys represents Everspin's most ambitious product initiative: a
direct assault on the $3 billion NOR flash market that has been
dominated for decades by incumbent suppliers including Micron,
Winbond, Macronix, GigaDevice, and Infineon (Cypress).

## Density Range and Roadmap

The Unisys family targets the mainstream and high-density segments
of the NOR flash market:

| Density | Part Name       | xSPI Mode     | Status                 |
|---------|----------------|---------------|------------------------|
| 128Mb   | Unisys 128Mb    | Octal         | Sampling (2026)         |
| 256Mb   | Unisys 256Mb    | Octal         | Sampling (2026)         |
| 512Mb   | Unisys 512Mb    | Octal         | Development             |
| 1Gb     | Unisys 1Gb      | Octal         | Roadmap                 |
| 2Gb     | Unisys 2Gb      | Octal         | Roadmap                 |

The sampling milestone in 2026 marks the first availability of MRAM-
based NOR flash replacements at densities above 256Mb. The 2Gb
roadmap target is particularly significant: it addresses the highest-
density segment of the discrete NOR flash market, where MRAM would
offer the most dramatic performance differentiation.

## NOR Flash: Technology Limitations

To understand the Unisys value proposition, it is useful to enumerate
the inherent limitations of NOR flash technology that MRAM overcomes:

### Erase-Before-Write Requirement

NOR flash can only program bits from 1 to 0. To change a 0 back to a
1, an entire erase block (typically 4KB, 32KB, or 64KB depending on
the device) must be erased — an operation that takes 50 to 200
milliseconds. During block erase, the entire block is unavailable
for read or write access. This constraint:

- Forces software to implement complex flash translation layers (FTLs)
  or file systems (JFFS2, YAFFS, SPIFFS) to manage erase operations
  and wear leveling.
- Creates unpredictable latency spikes when a block erase is required
  before a write can proceed.
- Consumes significant energy: a single 64KB block erase on NOR flash
  can require 15–30 mJ of energy, thousands of times more than writing
  the same number of bytes to MRAM.
- Prevents atomic write semantics: a power loss during block erase can
  leave data in an indeterminate state, requiring error recovery logic
  in the application.

### Limited Write Endurance

NOR flash cells tolerate approximately 10^4 to 10^5 program/erase
cycles before the tunnel oxide degrades and bit errors become
uncorrectable. This limits the use cases to applications with
relatively infrequent writes. Over-the-air (OTA) firmware updates,
configuration changes, and event logging must be carefully managed
to avoid exhausting the endurance budget, often requiring wear-
leveling algorithms that add software complexity and CPU overhead.

### Slow Write Performance

A NOR flash page program operation (writing 256 bytes) takes
approximately 10–20 µs plus the time to transfer the data over the
SPI bus. Writing a 4KB data block requires 16 page programs (plus
the prior block erase if the area has been previously written),
totaling roughly 50–200 ms. By contrast, Unisys MRAM can write 4KB
of data at full SPI bus speed (~50 µs in octal mode), a 1000×
improvement in effective write throughput.

### Read-While-Write Incompatibility

Most NOR flash devices cannot execute a read operation while an
internal program or erase operation is in progress. The host must
poll the device's status register to determine when the operation
completes, blocking all other memory access. MRAM has no such
restriction: reads and writes can be interleaved freely, limited
only by the SPI bus bandwidth.

## Unisys Architecture

The Unisys family builds on the Persist EMxxLX architecture with
several enhancements targeted specifically at NOR flash replacement:

### Density Optimization

While Persist devices prioritize reliability and extended temperature
operation, Unisys devices optimize cell density to achieve NOR flash-
competitive cost per bit. This involves larger array block sizes,
more aggressive sense amplifier multiplexing, and relaxed read
disturb margin (with correspondingly stronger ECC) to reduce the
effective cell area.

### Performance Optimization

Unisys parts are designed for maximum xSPI throughput, supporting
octal SPI at clock rates up to 133 MHz (266 MB/s in DDR mode),
matching or exceeding the fastest NOR flash xSPI implementations.
Read latency from address to first data is specified at under 20 ns,
competitive with the fastest NOR flash devices operating in burst
mode.

### Error Correction

Unisys incorporates on-die ECC with a stronger code than Persist
— likely a double-error-correct, triple-error-detect (DECTED)
BCH or LDPC code — to meet the reliability expectations of the NOR
flash replacement market while allowing more aggressive cell
scaling.

### Sector Architecture

To ease migration from NOR flash, Unisys devices present a logical
sector structure that follows NOR flash conventions (uniform 4KB or
32KB sectors) even though MRAM has no physical sector constraints.
This enables existing file systems and flash management software to
run unchanged, while also supporting direct byte-level writes that
NOR flash cannot perform.

### Security Features

Unisys incorporates the security features expected in modern NOR
flash devices:
- Unique device ID (64-bit or 128-bit)
- One-time-programmable (OTP) region for factory provisioning
- Non-volatile write-protection bits for individual sectors
- Secure silicon ID for cryptographic device authentication
- Support for authenticated write commands (per JEDEC JESD260)

## Software Migration Path

A critical barrier to MRAM adoption in NOR flash sockets is the
installed base of software that assumes NOR flash behavior — block
erase commands, status polling, and wear leveling. Everspin
addresses this with:

1. **NOR flash command compatibility**: The Unisys command set
   includes all standard NOR flash commands (block erase, sector
   erase, page program, read status register). These commands are
   accepted and acknowledged by the MRAM device but execute as
   no-operations or immediately complete, allowing existing driver
   code to function unchanged.

2. **Optimized MRAM driver**: For customers who want to exploit the
   full performance of the Unisys device, Everspin provides reference
   drivers that bypass the flash-compatible command layer and issue
   native MRAM read/write commands directly.

3. **Filesystem compatibility**: LittleFS, SPIFFS, and FAT file
   systems have been tested with Unisys engineering samples. The
   elimination of erase latency means that journaling file systems
   that write small metadata updates benefit disproportionately.

## Comparison Summary: Unisys MRAM vs. NOR Flash

| Characteristic           | Unisys MRAM       | NOR Flash           |
|--------------------------|-------------------|---------------------|
| Density (max)            | 2Gb (roadmap)     | 2Gb (production)    |
| Read latency             | <20 ns            | 10–15 ns            |
| Write throughput         | Up to 266 MB/s    | ~1–2 MB/s           |
| Erase required           | No                | Yes (50–200 ms/block)|
| Write endurance          | 10^6–10^8 cycles  | 10^4–10^5 cycles    |
| Byte-addressable write   | Yes               | No (page minimum)    |
| Read-while-write         | Yes               | No                   |
| Power consumption (write)| ~30 mA            | ~25–35 mA           |
| Active read current      | ~15 mA            | ~10–20 mA           |
| Deep power-down          | <5 µA             | <5 µA               |
