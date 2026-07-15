# Toggle MRAM: Technology Foundations

## Physical Operating Principle

Toggle MRAM (also referred to as field-switched MRAM) is the original
commercial MRAM architecture and the technology on which Everspin was
founded. It stores data using the magnetic orientation of a free layer
within a Magnetic Tunnel Junction (MTJ) cell. Each MTJ consists of two
ferromagnetic layers separated by a thin dielectric tunnel barrier
(typically magnesium oxide, MgO). One magnetic layer is "pinned" with
a fixed orientation; the other (the "free layer") can be switched.

In Toggle MRAM, writing is accomplished by passing current through
orthogonal write lines that generate magnetic fields. The combined
field rotates the magnetization of the free layer by a controlled
toggle mechanism, switching the cell between parallel (low resistance,
typically logic "1") and anti-parallel (high resistance, logic "0")
states. The read operation uses a small sense current through the MTJ
to measure the tunneling magnetoresistance (TMR) ratio.

The toggle mechanism provides inherent immunity to half-select
disturbances — a critical advantage for defense and radiation
environments where single-event upsets (SEUs) can corrupt data in
volatile memories.

## Key Technology Characteristics

- **Non-volatile**: Data is retained without power, with retention
  exceeding 20 years at 125°C ambient temperature.
- **Unlimited endurance**: Toggle MRAM cells have demonstrated endurance
  exceeding 10^15 write cycles, effectively unlimited for all practical
  applications. This contrasts sharply with flash memory (typically
  10^4–10^5 write/erase cycles).
- **Symmetrical read/write speeds**: Access times in the 35–45 ns range
  for read and write operations, comparable to fast SRAM.
- **Radiation tolerance**: The magnetic storage mechanism is inherently
  immune to total ionizing dose (TID) effects up to 200+ krad(Si) and
  single-event latchup (SEL). Heavy-ion testing has demonstrated SEU
  immunity for the MTJ storage element itself.
- **Wide temperature range**: Qualified for operation from -55°C to
  +125°C (military temperature range), with some parts tested to 150°C.

## Manufacturing Process

Everspin's Toggle MRAM is fabricated on a proprietary 200mm wafer
process at the Chandler, Arizona facility. The process adds
approximately three mask layers to a standard CMOS logic flow,
embedding the magnetic layers between Metal-2 and Metal-3 of the
back-end-of-line (BEOL) interconnect stack. This "magnetic BEOL"
approach allows MRAM to be integrated without disrupting the
underlying CMOS transistor characteristics.

The MTJ stack consists of:
1. Bottom electrode and seed layer
2. Antiferromagnetic pinning layer (typically PtMn or IrMn)
3. Synthetic antiferromagnet (SAF) pinned layer
4. MgO tunnel barrier (deposited by RF sputtering, ~1 nm thickness)
5. NiFe free layer
6. Top electrode and capping layer

The MgO tunnel barrier quality is the single most critical process
parameter. Sub-angstrom thickness uniformity must be maintained across
the 200mm wafer to ensure tight resistance distribution and high TMR
values (typically 100–180% for Toggle cells).

## Cell Architecture

The Toggle MRAM bit cell uses a 1T-1MTJ (one transistor, one MTJ)
architecture. The transistor serves as the access device, selecting
individual cells during read operations. Write operations use the
orthogonal digit line and bit line to generate the switching field,
with the transistor typically turned off — the write current flows
through the metal lines, not through the MTJ itself.

Cell sizes for the mature product line are relatively large compared to
STT-MRAM or advanced DRAM, typically in the range of 20–30 F² where F
is the minimum feature size. This makes Toggle MRAM best suited for
lower-density applications (up to 32Mb in Everspin's current portfolio)
where its reliability and radiation tolerance are the primary value
propositions.

## Scaling Limits

Toggle MRAM scaling beyond approximately 32Mb faces two fundamental
challenges. First, as cell dimensions shrink, the write currents
required to generate the switching magnetic field do not scale
proportionally, leading to excessive write energy per bit. Second,
thermal stability — the energy barrier against spontaneous magnetization
reversal — decreases with cell volume, limiting how small the free layer
can be made before data retention degrades at elevated temperatures.

These scaling limits motivated Everspin's strategic pivot to STT-MRAM,
which addresses both issues: write current scales with cell area
(because current flows through the MTJ), and perpendicular magnetic
anisotropy (PMA) provides a stronger energy barrier at small dimensions.

## Technology Relevance

Despite scaling limits, Toggle MRAM remains a strategically critical
product line for Everspin. It is the only MRAM technology with
multi-decade flight heritage in defense and space applications.
Production orders from defense primes, qualification to MIL-PRF-38535
and similar standards, and the installed base of sockets in avionics,
missile guidance, and satellite bus electronics ensure sustained demand
for the foreseeable future. The $40 million defense subcontract
awarded for continued Toggle MRAM process development underscores the
enduring importance of this technology to U.S. defense systems.
