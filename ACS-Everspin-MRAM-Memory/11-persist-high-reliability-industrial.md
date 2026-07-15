# Persist: High-Reliability & Industrial Applications

## Target Market Definition

The Persist EMxxLX family addresses industrial and embedded
applications where the memory subsystem must meet three simultaneous
requirements: high reliability over extended operating lifetimes,
non-volatility with fast write capability, and compatibility with
standard microcontroller and FPGA SPI/xSPI interfaces. No single
competing memory technology satisfies all three requirements at
equivalent density and cost.

The industrial market verticals served by Persist include:

1. **Factory automation**: Programmable logic controllers, motor
   drives, distributed I/O modules, and industrial robots
2. **Energy infrastructure**: Smart grid controllers, solar inverter
   data loggers, wind turbine condition monitoring
3. **Transportation**: Railway signaling, traffic management, marine
   navigation systems
4. **Medical devices**: Patient monitors, infusion pumps, diagnostic
   imaging subsystems
5. **Test and measurement**: Data acquisition systems, spectrum
   analyzers, protocol analyzers

## Industrial Application Requirements

Industrial memory subsystems impose demands that consumer-grade
memory products cannot reliably meet:

### Data Integrity

Industrial controllers frequently operate in electrically noisy
environments with high levels of conducted and radiated
electromagnetic interference (EMI). MRAM's magnetic storage
mechanism is inherently more resistant to EMI-induced corruption
than charge-storage technologies. The MTJ switching threshold is
determined by current density through the barrier, not by stored
charge, making it difficult for external fields to accidentally
flip the magnetic state.

Additionally, industrial safety standards (IEC 61508, ISO 13849)
require that safety-critical data stored in non-volatile memory
remain uncorrupted across power cycles, brownouts, and unexpected
resets. Persist MRAM's byte-level write atomicity — each byte write
completes or does not occur; there is no intermediate state where a
write is partially complete — simplifies safety certification
compared to flash memory where a power loss during a page program
operation can leave a page in an indeterminate state.

### Long Product Lifecycles

Industrial equipment typically remains in service for 10–20 years.
The memory components must remain available (not discontinued),
reliable, and functionally compatible over this period. Everspin's
commitment to extended product lifecycles for the Persist family
aligns with these requirements. The use of a mature 28nm process
node at TSMC, which TSMC has committed to support for extended
duration given the large industrial and automotive customer base
on this node, further reduces the risk of process discontinuation.

### Extended Temperature Operation

Factory floor environments routinely exceed 70°C ambient, with
local temperatures inside sealed control cabinets reaching 85–105°C.
Persist devices qualified at -40°C to +105°C cover the majority of
industrial operating environments without requiring active cooling
of the memory subsystem.

### High Write Duty Cycle

Industrial data logging applications — for example, recording
vibration sensor data at 1 kHz sample rates for predictive
maintenance — can generate gigabytes of writes per day. A NOR flash
device with 100K write cycle endurance per sector would exhaust its
rated lifetime in weeks under such a workload, even with wear
leveling. Persist MRAM with 10^6 to 10^8 write cycle endurance can
sustain these workloads for the full equipment lifetime.

## Factory Automation Case Study

A typical factory automation application involves a PLC that must:

- Read a ladder-logic control program from non-volatile memory at
  boot time (~2–8 MB typical program size)
- Continuously log process data (temperature, pressure, motor current)
  at intervals of 100 ms to 1000 ms
- Retain the last known-good machine state across power cycles for
  rapid recovery after power restoration
- Preserve event logs (fault records, operator actions) for regulatory
  compliance

With Persist MRAM replacing NOR flash for both program storage and
data logging, the PLC achieves:

- Near-instantaneous boot (no shadow-copy from flash to SRAM; the
  processor can execute code directly from MRAM via xSPI in XIP
  mode, or alternatively, fast copy from MRAM to SRAM)
- Elimination of periodic logging pauses for block erase operations
- Guaranteed data integrity through unpredictable power events on
  the factory floor
- Simplified firmware architecture: no wear-leveling or bad-block
  management layer required

## Energy Infrastructure

In smart grid and renewable energy applications, Persist MRAM
addresses data integrity requirements for:

- **Event and fault recorders**: Power grid disturbance recorders
  must capture pre-fault, fault, and post-fault waveform data with
  microsecond timestamp accuracy, and must retain this data through
  the power disturbance that triggered the recording. MRAM's
  persistence and fast write speed enable this without battery
  backup.

- **Metering data**: Smart meters accumulate consumption data in
  non-volatile memory. Regulators increasingly require that this
  data survive extended power outages (days to weeks) without
  corruption, a requirement that eliminates DRAM and battery-backed
  SRAM alternatives.

- **Inverter configuration**: Solar and wind inverters store operating
  parameters (MPPT calibration tables, grid code compliance settings)
  that must be retained through prolonged off-grid periods.

## Competitive Positioning vs. FRAM

Within the industrial embedded memory market, Everspin's primary
technology competitor is ferroelectric RAM (FRAM), supplied
primarily by Infineon Technologies (Cypress FRAM products) and
Fujitsu. FRAM is a well-established technology with similar
endurance and persistence characteristics to MRAM, but with
important differences:

| Characteristic        | Persist STT-MRAM   | FRAM              |
|-----------------------|--------------------|--------------------|
| Max density (commercial)| 256Mb (qual.)    | 16Mb               |
| Write endurance       | 10^6–10^8 cycles   | 10^12–10^14 cycles |
| Radiation tolerance   | Excellent (inherent)| Moderate           |
| Temperature range     | -40 to +105°C       | -40 to +85°C       |
| Magnetic field immunity| Depends on shielding| Immune             |
| Process node           | 28nm               | 130nm              |

FRAM's advantage is its extremely high write endurance (effectively
unlimited for most applications). MRAM's advantages are density (an
order of magnitude higher), process node scaling path (FRAM is
stalled at 130nm due to ferroelectric material scaling challenges),
and radiation tolerance.

For applications that require capacities above 16Mb, MRAM is the only
viable high-endurance, persistent memory option on the market. The
128Mb and 256Mb Persist parts in qualification will further widen
this density gap.
