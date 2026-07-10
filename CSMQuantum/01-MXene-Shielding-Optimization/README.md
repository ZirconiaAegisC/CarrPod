# 01-MXene-Shielding-Optimization

## MXene Ti₃C₂Tₓ EMI Shielding Optimization

### Carrington Storm Motors / Safe Pod Engineering Company

MXene (Ti₃C₂Tₓ) is the single most transformative material in the Aegis-C portfolio. It achieves extraordinary EMI shielding effectiveness — 92-98 dB at 45 μm thickness — yet commercial MXene costs approximately $2,000 per kilogram. The CSMFAB in-house synthesis route has already reduced that to $55-75/kg through microwave-assisted etching of Ti₃AlC₂ MAX phase precursors. The remaining scientific obstacle is understanding how the surface termination chemistry (-O, -OH, -F) controls the electronic conductivity and dielectric loss that produce SE values.

Classical DFT cannot fully capture the mixed-valence character of Ti at the MXene surface, nor the dynamic hydrogen bonding network of intercalated water and hydroxyl groups that evolves under operational temperature and humidity. A quantum computing partner is needed to perform high-accuracy DFT on 500-2,000 atom supercells of functionalized MXene, resolving the density of states at the Fermi level as a function of termination composition. The ultimate goal is to predict a termination recipe, realizable in the CSMFAB wet chemistry line, that delivers 92+ dB SE at 10 μm instead of the current 45 μm — a 4.5× material thickness reduction and corresponding cost and weight savings.

This paper specifies exact Ti₃AlC₂ MAX phase precursor parameters, the etch chemistry and delamination protocol, the current SE measurement data from 1 kHz to 10 GHz, and the target Hamiltonian for DFT-VQE simulation. The quantum advantage lies in the exponential scaling of the active space for correlated Ti 3d electrons, which classical CCSD(T) cannot handle beyond ~50 atoms. A partner with demonstrated VQE or quantum embedding capability on 100+ logical qubits, and experience with periodic boundary conditions, should find this paper immediately actionable.

Expected outcome: a computational prediction of optimal -O/-OH/-F surface termination ratio, validated by CSMFAB synthesis and ASTM D4935 SE measurement within 12 months of simulation completion. This is the highest-priority paper in the CSMQuantum series.
