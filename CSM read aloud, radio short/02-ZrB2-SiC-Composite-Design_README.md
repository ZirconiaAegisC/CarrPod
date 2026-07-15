# 02-ZrB2-SiC-Composite-Design

## ZrB₂-SiC Ultra-High-Temperature Ceramic Composite Structure-Property Design

### Carrington Storm Motors / Safe Pod Engineering Company

The ZrB₂-SiC composite is the structural backbone of every Aegis-C shielding panel. It must withstand simultaneous demands: electromagnetic attenuation across 1 kHz to 10 GHz, thermal stability to 1,800°C (the flash sintering regime and beyond), mechanical integrity against impact, and dielectric behavior that does not short the shielding layers. Current formulations achieve flexural strength of ~500 MPa, fracture toughness of ~4 MPa√m, and density of ~5.5 g/cm³ — values that are adequate but leave no margin for weight reduction or panel thinning.

The most pressing engineering unknowns reside at the grain boundaries. SiC segregates to ZrB₂ grain boundaries as an intergranular phase, influencing cohesion, oxidation resistance, and phonon scattering that controls thermal conductivity. The quantum problem is a DFT-level calculation of grain boundary energies and segregation enthalpies for candidate ternary additions (HfB₂, TaB₂, NbB₂, and rare-earth oxides) across multiple coincident-site lattice orientations. Classical interatomic potentials for these five-component systems simply do not exist at the accuracy required.

A quantum computing partner should expect to tackle DFT calculations on 200-1,000 atom grain boundary supercells, resolving the electron density redistribution that governs SiC wetting behavior and the cohesive energy of the interface. The phonon transport calculations require force constants from DFT-level energy surfaces — again, a problem that scales poorly on classical hardware for large cells. The projected quantum advantage is a 20-40% improvement in strength-to-density ratio through precise control of the intergranular phase chemistry and volume fraction.

This paper documents the current ZrB₂-SiC synthesis route (batching, ball milling, hot pressing, flash sintering), measured mechanical and dielectric properties, and the specific grain boundary types (Σ5, Σ7, Σ13) that dominate the microstructure. The deliverable is a recommended ternary dopant composition and SiC vol% that optimizes the Pareto frontier of strength, density, oxidation resistance, and dielectric permittivity.
