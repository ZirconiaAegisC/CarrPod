# Polaris: 7th Generation Prototype

## Device Overview
Polaris is Helion's seventh-generation prototype, representing the final technology demonstration platform before the Orion commercial plant. It is the largest FRC device ever built and the first privately funded fusion device to achieve deuterium-tritium (D-T) fusion conditions. Polaris serves as the integrated testbed for all subsystems that will be scaled for Orion: Formation Sections, compression coils, capacitor banks, divertor assemblies, vacuum systems, fuel handling, and energy recovery circuits.

## Physical Specifications
| Parameter | Value |
|-----------|-------|
| Total Length | ~60 feet (18.3 meters) |
| Diameter | ~15 feet (4.6 meters) at widest point |
| Mass | ~200 tons (estimated) |
| Formation Sections | 2 (opposed, quartz tubes) |
| Compression Coils | 12-16 modular coil assemblies |
| Capacitor Bank Energy | 50 MJ (megajoules) |
| Capacitor Technology | Custom in-house design; high-energy-density pulsed capacitors |
| Peak Current | >10 MA (mega-amps) per compression pulse |
| Magnetic Field (Compressed) | 10-15 Tesla (estimated) |
| Pulse Duration | ~1 ms compression; ~10 ms total cycle |
| Vacuum System | Cryogenic + turbomolecular pumps |
| Diagnostic Suite | Neutron detectors, Thomson scattering, interferometry, spectroscopy, bolometry |

## February 2026 Milestone: First Private D-T Fusion
In February 2026, Polaris achieved ion temperatures of 150 million degrees Celsius (~13 keV), surpassing the threshold for D-T fusion. This milestone marked the first time a privately built fusion device reached D-T fusion-relevant temperatures. Key data points:
- **Ion Temperature:** 150 million °C (13 keV)
- **Electron Temperature:** Not publicly disclosed (estimated 8-12 keV)
- **Confinement Time:** Not publicly disclosed (estimated ~2-5 ms post-merge)
- **Fusion Yield:** Not publicly disclosed; believed to be in the 10^10 to 10^12 neutrons per pulse range
- **Pulse Count:** Multiple pulses demonstrated at these conditions

## Subsystem Architecture

### Formation Section (FS)
Two opposed formation sections generate counter-propagating FRCs. Each FS consists of:
- Quartz discharge tubes (transparent to diagnostics, electrically insulating)
- Theta-pinch coils for initial plasma formation
- Cusp and mirror magnetic field coils for FRC shaping
- Gas injection system (D2 and He3 metered injection)
- Pre-ionization system (RF or pulsed discharge)

### Compression System
The central compression section compresses the merged FRC to fusion conditions:
- Modular coil design — each coil can be individually controlled and replaced
- Copper-alloy windings with active cooling
- Structural reinforcement to withstand pulsed magnetic forces (>100 MPa equivalent pressure)
- Magnetic field rise time: ~100 microseconds to peak

### Capacitor Bank
The 50 MJ capacitor bank is the energy storage system for compression:
- Custom-designed, high-energy-density pulsed capacitors
- Oil-immersed or solid-dielectric design
- Parallel discharge through high-current switches (ignitrons or solid-state thyristors)
- Energy recovery circuit recharges capacitors between pulses
- Charge time between pulses: <1 second (target for Orion)

### Divertor System
The divertor handles exhaust from the FRC open field lines:
- Cryogenic pumping for helium ash removal
- Tritium separation and storage subsystem
- Heat flux management (pulsed thermal loads)

### Energy Recovery Circuit
The direct energy recovery system captures expansion work:
- Coils operate in dual mode: motor (compression) and generator (expansion)
- Power electronics for rectification and grid-synchronous output
- Target >90% energy recovery efficiency
- Feedback control for optimal expansion waveform shaping

## Tiny Merge: Polaris Subscale Platform
"Tiny Merge" is a 1/8-scale Polaris designed for rapid risk-reduction testing:
- Tests Formation Section dynamics at smaller scale
- Validates merging physics without requiring full 50 MJ bank
- Enables higher pulse repetition rates for component lifetime testing
- Under construction as of mid-2026

## Relationship to Orion
Polaris directly informs Orion's design:
- Compression coil geometry scales from Polaris to Orion
- Capacitor bank architecture is modular; Orion uses ~2x the modules
- Formation Section design is validated at scale on Polaris
- Energy recovery power electronics are tested at Polaris scale
- Tritium handling systems are prototyped on Polaris
- Divertor heat management and helium pumping systems are demonstrated

## Open Technical Questions (Mid-2026)
1. Has Polaris demonstrated measurable fusion gain (Q > 0.01)?
2. What is the sustained pulse repetition rate (vs. single-shot demonstrations)?
3. What is the FRC confinement time at 150 million °C?
4. Has direct energy recovery been demonstrated at the 50 MJ capacitor bank scale?
5. What is the measured tritium production rate from D-D side reactions?
6. Has the Polaris diagnostic suite measured D-He3 fusion products separately from D-D products?
