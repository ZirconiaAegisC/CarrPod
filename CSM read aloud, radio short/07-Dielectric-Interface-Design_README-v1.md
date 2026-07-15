# 07-Dielectric-Interface-Design

## Dielectric Interface and Grain Boundary Design for Panel Joint Shielding Integrity

### Carrington Storm Motors / Safe Pod Engineering Company

No Aegis-C panel exists in isolation. A CarrPod safe room or vehicle compartment is assembled from multiple shielding panels joined at seams, corners, and feedthrough penetrations. Every joint is a shield discontinuity — an impedance mismatch where electromagnetic waves can diffract, reflect constructively, or leak through capacitive coupling. Current measurements show that panel joints impose an SE penalty of approximately 12 dB relative to the bulk panel material, meaning the joint, not the shield, is the weak link.

The interface architecture consists of a ZrO₂ dielectric gasket compressed between ZrB₂-SiC panel edges, optionally filled with a PEEK or PTFE interlayer to manage galvanic corrosion. The quantum problem is to compute the electron transport across this metal-oxide-polymer-oxide-metal stack using the non-equilibrium Green's function (NEGF) formalism with DFT-level Hamiltonians. The transmission function T(E) across the interface determines both the DC contact resistance (which must exceed 10¹² Ω to prevent galvanic current) and the AC impedance as a function of frequency (which governs SE loss).

Classical drift-diffusion and even semiclassical tunneling models are inadequate because the oxide layers are 10-50 nm thick — firmly in the quantum tunneling regime where band alignment, interface dipole formation, and defect-assisted hopping through oxygen vacancies dominate transport. The quantum simulation must resolve the electrostatic potential profile self-consistently across the heterojunction, including image charge effects at the metal-oxide boundaries.

A quantum computing partner should expect to build NEGF-DFT models of the ZrB₂/ZrO₂/PEEK/ZrO₂/ZrB₂ stack, compute the frequency-dependent transmission, and identify the maximum tolerable oxide thickness and doping density that achieve SE penalty ≤ 6 dB at 10 GHz. This paper documents the current joint design, SE measurement data across joint configurations, and material property targets. The deliverable is a computational specification for the dielectric gasket that closes the joint SE gap.
