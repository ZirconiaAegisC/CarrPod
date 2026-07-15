# Persist: LEO Satellite & Aerospace Demand

## The LEO Satellite Revolution

Low Earth Orbit (LEO) satellite constellations represent the fastest-
growing segment of the global space economy. Unlike traditional
geostationary (GEO) satellites, which are large, expensive, and
designed for 15–20 year lifetimes, LEO satellites are small, mass-
produced, and designed for 5–7 year operating lives. The dominant
constellation operators — SpaceX (Starlink), Amazon (Project Kuiper),
OneWeb/Eutelsat, and Telesat (Lightspeed) — have collectively deployed
thousands of satellites and plan tens of thousands more.

Each LEO satellite requires non-volatile memory for configuration
storage, telemetry buffering, firmware storage, and payload data
handling. The unique operating environment — radiation exposure, wide
temperature swings, and inaccessibility for repair — makes memory
selection a mission-critical engineering decision. Persist MRAM has
emerged as a preferred memory technology for LEO satellite subsystems
due to its combination of radiation tolerance, persistence, and
availability in the densities and interfaces embedded satellite
designers require.

## Radiation Environment in LEO

LEO satellites (orbits typically 300–2,000 km altitude) operate
within the inner Van Allen radiation belt and are exposed to:

- **Trapped protons** (energies 1–100 MeV): High flux in the South
  Atlantic Anomaly (SAA) region where the inner radiation belt dips
  closer to Earth.
- **Galactic cosmic rays (GCRs)**: High-energy heavy ions (up to
  GeV/nucleon) with low flux but high linear energy transfer (LET),
  capable of causing single-event effects in semiconductor devices.
- **Solar particle events**: Sporadic but intense bursts of protons
  and heavier ions associated with solar flares and coronal mass
  ejections.

For memory devices, the primary radiation effects of concern are:

1. **Total Ionizing Dose (TID)**: Cumulative ionization damage in
   gate oxides and isolation oxides, leading to threshold voltage
   shifts in CMOS transistors and increased leakage current.
2. **Single-Event Upset (SEU)**: A single ion strike flips the
   stored state of a memory cell.
3. **Single-Event Latchup (SEL)**: A single ion triggers a parasitic
   thyristor in the CMOS structure, causing a high-current latchup
   condition that can destroy the device.

## MRAM Radiation Tolerance

The magnetic storage mechanism of MRAM provides inherent immunity to
several radiation effects that plague charge-based memory technologies
(DRAM, SRAM, flash):

### SEU Immunity of the MTJ Cell

The energy required to flip a magnetic domain is many orders of
magnitude greater than the energy deposited by a single ion track.
While heavy ions can deposit 10–100 MeV-cm²/mg of energy along a
track roughly 50 nm in diameter, the energy barrier for magnetization
reversal in a PMA MTJ is on the order of 40–60 kT at operating
temperature (~1.6 × 10^-19 J, or approximately 1 eV for the entire
cell volume). The fraction of an ion's deposited energy that couples
into the magnetic system is vanishingly small, making intrinsic SEU
of the MTJ storage element negligible for all practical LEO
environments.

### TID Tolerance

The MTJ cell is inherently immune to TID because the magnetic
tunnel junction does not depend on stored charge for data retention.
The CMOS peripheral circuits (sense amplifiers, decoders, charge
pumps, I/O drivers) are subject to TID-induced degradation, but the
28nm CMOS node used for Persist devices has relatively good TID
tolerance (typically 100–200 krad(Si) without special hardening).
For applications requiring higher TID tolerance, radiation-hardened-
by-design (RHBD) techniques — enclosed-layout transistors (ELT),
guard rings, and TID-aware biasing — can be applied without changing
the MRAM cell itself.

### SEL Immunity

The MRAM cell in the Persist family is fabricated in the BEOL,
isolated from the silicon substrate by several microns of inter-
layer dielectric. There is no parasitic bipolar junction transistor
(BJT) structure in the MRAM cell that could sustain latchup. The
CMOS access transistor in the 1T-1MTJ cell is a standard NMOS
device, and latchup immunity for the peripheral circuits depends on
the standard CMOS latchup protection techniques (guard rings,
substrate ties) implemented in the TSMC 28nm process.

## Satellite Subsystem Applications

### On-Board Computer (OBC) and Flight Computer

The satellite's primary computer stores the flight software image,
configuration tables, and operational parameters in non-volatile
memory. Persist MRAM provides:
- Fast boot without requiring a separate boot flash + shadow SRAM
  architecture
- Immunity to single-event functional interrupts (SEFI) that affect
  flash memory controllers
- In-flight reprogrammability without slow block-erase cycles

### Telemetry and Housekeeping Data

Satellites continuously monitor their own health — temperatures,
voltages, currents, attitude, orbit position — and store this
housekeeping data for downlink to ground stations. A typical
telemetry recording rate is 1–100 records per second, each record
typically 64–256 bytes. Persist MRAM's byte-write capability is
natural for this use case; NOR flash would require accumulating
records until a full page is ready to program, introducing latency
and data-at-risk during the accumulation period.

### Payload Data Buffering

Communications satellites (Starlink, Kuiper) and Earth observation
satellites generate high-rate payload data. MRAM serves as a
buffer or staging memory for this data between the payload
processor and the downlink transmitter. The combination of high
write speed and radiation tolerance makes MRAM suitable for this
role, particularly in satellites that traverse the SAA where
radiation-induced errors in DRAM or SRAM buffers would be
frequent.

### Cryptographic Key Storage

Secure satellite communications require storage of cryptographic
keys, authentication tokens, and secure boot measurements. MRAM's
non-volatility combined with the ability to perform fast, byte-
level writes enables efficient key update procedures and rapid
zeroization (overwriting all key material) if a satellite's
security is compromised.

## Qualification and Testing

Satellite programs require extensive qualification data before a
component is approved for flight, even for non-human-rated
missions. Everspin supports aerospace customers with:

- Radiation lot acceptance testing (RLAT) per MIL-STD-883 TM 1019
- Heavy-ion single-event effects (SEE) characterization at cyclotron
  facilities (Texas A&M, LBNL, RADEF)
- Proton SEE characterization at energies representative of trapped
  proton spectra
- TID characterization using Co-60 gamma source
- Outgassing screening per ASTM E595 for materials used in vacuum
  environments
- Construction analysis and destructive physical analysis (DPA)

For Class D missions (low criticality, short duration, expendable
launch) the commercial Persist devices, possibly with additional
screening, may be acceptable. For Class B and Class C missions
(higher criticality), die-level procurement with additional screening
and traceability is typical.

## Competitive Landscape in Space Memory

In the space-grade memory market, Persist MRAM competes with:

- **Radiation-hardened SRAM** (BAE Systems, Honeywell, Cobham/CAES):
  Very expensive (100–1000× commercial SRAM), limited densities
  (typically up to 16Mb), volatile (requires continuous power).
- **Radiation-hardened flash** (3D Plus, Mercury Systems): Lower cost
  than rad-hard SRAM, higher density (up to multiple Gb), but slow
  write and limited endurance.
- **FRAM** (Infineon/Cypress): Similar persistence and endurance to
  MRAM, but density limited to 16Mb and radiation tolerance less
  well-characterized for space environments.

Persist MRAM occupies a unique position: it offers radiation tolerance
approaching rad-hard SRAM at densities and costs closer to commercial
memory, with the additional benefit of non-volatility.

## Revenue Contribution from Aerospace

Everspin does not separately report aerospace revenue, but management
has indicated that aerospace and defense collectively represented
approximately 20% of revenue in recent periods, with the aerospace
(primarily satellite) component growing faster than the defense
component. The catalyst for satellite demand is the rapid expansion
of LEO constellations, which creates an unusually large volume
opportunity in a market that has historically been characterized by
low-volume, high-value individual satellite programs.
