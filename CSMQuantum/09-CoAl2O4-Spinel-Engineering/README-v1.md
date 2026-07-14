# 09-CoAl2O4-Spinel-Engineering

## CoAl₂O₄ Spinel Dopant Engineering for Alternative Blue Pigments

### Carrington Storm Motors / Safe Pod Engineering Company

Cobalt aluminate (CoAl₂O₄) is the classic Thenard's Blue — a chemically robust, thermally stable spinel pigment that has been used for centuries. It is also the most direct alternative to YInMn Blue within the Aegis-C pigment portfolio. The advantage is supply chain simplicity: cobalt and aluminum are far more abundant and geopolitically distributed than indium. The disadvantage is color quality — CoAl₂O₄ exhibits a broader, weaker absorption band than YInMn Blue and a lower near-infrared solar reflectance index (SRI).

The blue color originates from Co²⁺ ions occupying tetrahedral sites in the normal spinel structure, with the ⁴A₂ → ⁴T₁(P) transition producing three absorption bands in the visible range. The relative intensities and positions of these bands are exquisitely sensitive to the tetrahedral crystal field strength, which is controlled by the second-nearest-neighbor cation distribution and any lattice strain from dopant substitution. Dopant engineering — introducing Zn²⁺, Mg²⁺, Ni²⁺, or Cu²⁺ on tetrahedral or octahedral sites — can tune both the color coordinates and the SRI.

This quantum task requires DFT+U or hybrid functional calculations of CoAl₂O₄ supercells with varying dopant concentrations and site distributions, followed by crystal field multiplet calculations to predict the d-d absorption spectrum. The key challenge is the strong on-site Coulomb repulsion (U ≈ 5-7 eV on Co 3d) and the need to correctly capture the Jahn-Teller coupling that splits the excited states. VQE with an active space encompassing the Co 3d⁷ manifold is well-suited to this problem.

A quantum computing partner should expect to compute the optical absorption spectra of doped CoAl₂O₄ formulations and identify compositions whose SRI approaches or matches YInMn Blue (SRI > 70 vs. current CoAl₂O₄ SRI of ~50). This paper documents the current CoAl₂O₄ synthesis and characterization data, the target color coordinates (L*a*b*), and the dopant search space. The deliverable is a predicted dopant recipe that the CSMFAB pigment line can validate through solid-state synthesis and UV-Vis-NIR spectrophotometry.
