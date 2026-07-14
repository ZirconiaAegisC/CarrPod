# 04-Perovskite-Quantum-Dot-Stability

## CsPbBr₃ Perovskite Quantum Dot Stability and Degradation Mechanisms

### Carrington Storm Motors / Safe Pod Engineering Company

Cesium lead bromide (CsPbBr₃) perovskite quantum dots are the active fluorophore layer in Aegis-C's embedded optical warning and status indicator subsystem. They provide narrow-band green emission (FWHM ~20 nm, PLQY > 90%) with tunability across the visible spectrum — properties that are unmatched by any competing phosphor technology at equivalent cost. The critical flaw: they degrade catastrophically under humidity and UV exposure, with current encapsulant-protected lifetimes of approximately 1,000 hours, falling far short of the 10-year outdoor operational requirement.

The degradation mechanism is complex and coupled. Water molecules adsorb preferentially at surface Pb²⁺ sites, initiating a sequence of hydration, halide migration, and eventual amorphization that quenches photoluminescence. Simultaneously, UV-generated hot carriers drive photo-oxidation of surface bromide and lead to non-radiative recombination center formation. Classical MD with empirical force fields cannot capture the bond-breaking and charge-transfer events at the heart of this degradation. Quantum MD with on-the-fly DFT or high-level wavefunction methods is essential.

A quantum computing partner will be asked to simulate water and oxygen interaction with CsPbBr₃ (001) and (110) surfaces at the quantum MD level, resolving the minimum energy pathways for Pb-Br bond scission and the free energy barriers for hydration. The excited-state calculations require time-dependent DFT with spin-orbit coupling — or, ideally, equation-of-motion coupled-cluster methods — to identify surface trap states that mediate non-radiative recombination. The goal is to computationally screen candidate capping ligands (oleic acid variants, zwitterionic molecules, atomic-layer encapsulation architectures) for their ability to raise the hydration barrier above 1.2 eV, sufficient for multi-year stability.

The deliverable is a predicted optimal ligand or atomic-layer coating that the CSMFAB colloidal synthesis line can implement directly, targeting a 5-10× lifetime extension while maintaining PLQY above 80%. This paper supplies the specific synthesis protocol, degradation characterization data, and the computational target.
