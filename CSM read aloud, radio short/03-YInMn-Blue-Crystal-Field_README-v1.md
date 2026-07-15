# 03-YInMn-Blue-Crystal-Field

## YInMn Blue Crystal Field Engineering for Indium-Sparing Pigment Formulations

### Carrington Storm Motors / Safe Pod Engineering Company

YInMn Blue (YIn₁₋ₓMnₓO₃) is the aesthetic and thermal-management pigment for Aegis-C panels. Its near-infrared reflectance keeps surface temperatures manageable under direct solar load, and its intense cobalt-blue color provides the visual signature of the CarrPod brand. The problem: indium is scarce. Global annual production is approximately 700 metric tons, the price ranges from $150 to $350/kg, and it is geopolitically concentrated in a small number of producer nations. The Aegis-C pigment formulation currently requires roughly 30-40 at% indium on the B-site.

The color arises from Mn³⁺ ions in trigonal bipyramidal coordination with D₃ₕ symmetry, producing a strong absorption band near 590 nm via the ⁵E'' → ⁵A₁' transition. The quantum challenge is to compute the crystal field splitting and d-d transition energies when indium is partially or fully replaced by substitute B-site cations — Ga³⁺, Al³⁺, Fe³⁺, Sc³⁺, or combinations thereof — while preserving the trigonal bipyramidal site geometry that produces the blue absorption. This requires CASSCF/CASPT2-level multireference calculations on embedded clusters of 50-150 atoms, including spin-orbit coupling. Classical DFT fails here because it cannot correctly describe the multiplet structure of open-shell d⁴ Mn³⁺.

A quantum computing partner should be prepared to execute VQE or quantum subspace expansion methods on the Mn³⁺ active space (5 d-electrons across 5 orbitals, ~252 configuration state functions), expanded to include charge-transfer states from the oxygen ligands. The deliverable is a predicted set of indium-sparing compositions — e.g., Y(In₀.₃Ga₀.₄Mn₀.₃)O₃ — with computed absorption spectra that match YInMn Blue within Δλ < 20 nm of the 590 nm band, verified by CSMFAB synthesis and diffuse reflectance spectroscopy. Successful indium reduction of 50-70% eliminates a critical supply chain vulnerability while maintaining the thermal and aesthetic performance of Aegis-C panels.
