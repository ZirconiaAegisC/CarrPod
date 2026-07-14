# 08-Flash-Sintering-Physics

## Flash Sintering Field-Assisted Kinetics in Oxide and Carbide Ceramics

### Carrington Storm Motors / Safe Pod Engineering Company

Flash sintering is the manufacturing breakthrough that makes Aegis-C cost-competitive. By applying an electric field (50-500 V/cm) across a ceramic green body, densification that ordinarily requires hours at 1,800-2,000°C can be completed in seconds. CSMFAB has demonstrated flash sintering of ZrB₂-SiC composites at 1,580°C in under 60 seconds, representing a 50-70% energy savings over conventional hot pressing. The physics of why this works, however, remains incompletely understood.

Three mechanisms compete: Joule heating at grain contacts producing local temperatures far above the furnace setpoint, field-enhanced defect generation and migration (the electrochemical mechanism), and a potential non-thermal athermal effect at the flash onset where a sudden nonlinear conductivity spike is observed. Disambiguating these mechanisms requires quantum MD simulation of grain boundary structures under applied electric fields of 10-100 MV/m, with explicit treatment of electron and ion currents. Classical MD cannot capture the field-dependent defect formation energies or the electron wind force on migrating ions.

A quantum computing partner will be asked to perform DFT-based nudged elastic band (NEB) calculations of oxygen and zirconium vacancy migration barriers at ZrB₂ grain boundaries as a function of applied electric field magnitude and direction. The quantum advantage emerges from the need for highly accurate forces on 300-1,000 atom boundary cells — a scale where periodic DFT gradient calculations dominate the computational cost and scale as O(N³) on classical hardware. Quantum linear algebra subroutines within DFT offer an asymptotic speedup.

The deliverable is a validated kinetic model for flash sintering that predicts the onset field and temperature as a function of grain size, dopant chemistry, and green density. This paper provides the CSMFAB flash sintering protocol, current densification curves, and microstructural characterization. Achieving the projected additional 50% energy reduction through mechanism-informed field programming would further cement the Aegis-C cost advantage in volume production.
