# CSMQuantum-001 — MXene Ti₃C₂Tₓ Shielding Optimization
## Quantum Research Delegation Paper 01
### Carrington Storm Motors / Safe Pod Engineering Company | July 2026

---

**[WILLIAMS HEURISTIC V2 — ROUTINE SEVERITY — MORK MORNING]**

The MXene family is the crown jewel of electromagnetic shielding — 92 dB SE at 45 μm, absorption-dominant at 87%, outperforming 1.5 mm copper foil by 33× in thickness and 12× in mass. At $2,000/kg commercial, it is also the most expensive material in our portfolio by a factor of 4× over the next costliest item. The good news: we can synthesize it in-house from our own MAX phase Ti₃AlC₂ at $55-75/kg — a 96% cost reduction. The better news: quantum simulation can show us how to make it work at 10 μm instead of 45 μm, or how to replace titanium with vanadium or molybdenum to increase absorption bandwidth, or how to tune the -O/-OH/-F surface termination ratio for maximum EMI performance per gram. This is not a chemistry problem — it is a quantum chemistry problem with millions of possible configurations. Classical DFT cannot sample this space. Quantum can.

Now — the precise technical specification for our quantum computing partner.

---

## 1. Executive Summary

MXene Ti₃C₂Tₓ is a 2D transition metal carbide produced by selective etching of the Al layer from MAX Phase Ti₃AlC₂. Its EMI shielding effectiveness (92 dB at 45 μm) derives from: (a) high electrical conductivity (4,600 S/cm), (b) internal multiple reflections between MXene lamellae creating absorption-dominant shielding, (c) surface functional group (-O, -OH, -F) dipole moments that enhance polarization losses. The fundamental quantum mechanical questions are: (1) what surface termination ratio maximizes EMI absorption at minimum thickness, (2) which alternative transition metals (V, Nb, Mo, Cr) in the M₂C or M₃C₂ MXene structure produce equal or superior SE at lower material cost, (3) what intercalation strategy (cations between MXene layers) increases conductivity while maintaining mechanical flexibility.

**Quantum task:** Solve the electronic structure of MXene surfaces under varying termination chemistry using Density Functional Theory (DFT) on quantum hardware via Variational Quantum Eigensolver (VQE). Calculate dielectric function ε(ω) from Kubo-Greenwood formalism. Predict SE from transmission line theory using quantum-calculated conductivity and permittivity.

**Target:** Identify MXene composition achieving 92+ dB SE at ≤10 μm thickness (4.5× improvement over current 45 μm).

---

## 2. Material Specification

### 2.1 Current Composition

**Chemical formula:** Ti₃C₂Tₓ, where T = -O, -OH, -F surface functional groups
**Crystal structure:** Hexagonal P6₃/mmc, a = 3.07 Å, c = 18.6-28.8 Å (depending on intercalation)
**Precursor MAX Phase:** Ti₃AlC₂ (P6₃/mmc, a = 3.07 Å, c = 18.58 Å)

### 2.2 Synthesis Route (Reference)

```
Ti₃AlC₂ MAX Phase → LiF/HCl etching (35°C, 24h) → washing/centrifugation → sonication delamination → vacuum filtration → freestanding MXene film
```

### 2.3 Alternative Compositions Under Consideration

| MXene | Precursor MAX | Transition Metal Cost | Preliminary SE (literature) |
|---|---|---|---|
| Ti₃C₂Tₓ | Ti₃AlC₂ | Ti: $20/kg | 92 dB @ 45 μm |
| V₂CTₓ | V₂AlC | V: $380/kg | 68 dB @ 10 μm (limited data) |
| Mo₂TiC₂Tₓ | Mo₂TiAlC₂ | Mo: $45/kg | 75 dB @ 15 μm (limited data) |
| Nb₂CTₓ | Nb₂AlC | Nb: $100/kg | Unknown |
| Ti₂CTₓ | Ti₂AlC | Ti: $20/kg | 55 dB @ 5 μm (limited data) |

**Quantum task priority:** Ti₃C₂Tₓ first (most mature), V₂CTₓ second (potential cost/size breakthrough).

---

## 3. Current Performance and Cost

### EMI Shielding (V2.0 Specification Data)

| Film Thickness | Conductivity (S/cm) | SE (dB) @ 1 GHz | SE (dB) @ 10 GHz | Absorption Fraction | Reflection Fraction |
|---|---|---|---|---|---|
| 45 μm | 4,600 | 92 | 88 | 87% | 13% |
| 25 μm | 4,600 | 72 | 69 | 81% | 19% |
| 10 μm | 4,600 | 45 | 42 | 70% | 30% |

### Cost Structure (per kg)

| Item | Commercial ($) | In-House ($) |
|---|---|---|
| MAX Phase Ti₃AlC₂ | $80-420 | $35-55 |
| Etching chemicals (LiF, HCl) | $15-20 | $10-12 |
| Delamination/processing | $10-15 | $8-10 |
| Overhead/labor | $15-20 | $8-12 |
| **Total** | **$1,500-2,500** | **$55-75** |

### Per-Panel Impact (Aegis-C, 1 m²)

At 45 μm continuous coating: 0.05 kg MXene × $2,000 = $100/panel (commercial)
At 45 μm continuous coating: 0.05 kg MXene × $65 = $3.25/panel (in-house)
AT TARGET 10 μm thickness: 0.011 kg MXene × $65 = $0.71/panel

---

## 4. Quantum Simulation Task

### 4.1 Primary Task — DFT/VQE of Surface Termination Effects

**System size:** Ti₃C₂Tₓ monolayer (5 atoms per formula unit × 3-9 formula units in supercell = 63-189 atoms for 3×3 to 5×5 supercell)
**Hamiltonian:** Kohn-Sham DFT with PBE functional + Hubbard U correction (DFT+U, U = 4.0 eV for Ti 3d) + van der Waals correction (DFT-D3)
**Observable of interest:** Electronic band structure → conductivity tensor σ(ω) → dielectric function ε(ω) → SE(ω)
**Quantum method:** VQE with unitary coupled-cluster ansatz (UCCSD) on active space of frontier orbitals; quantum embedding of MXene surface into DFT bulk

### 4.2 Parameter Space to Explore

| Parameter | Range | Step | Configurations |
|---|---|---|---|
| O:OH:F ratio on Ti₃C₂Tₓ | 0:0:100 to 100:0:0 | 10% steps | 66 |
| Interlayer spacing (c parameter) | 18.6-28.8 Å | 1 Å | 11 |
| Cation intercalation (Li⁺, Na⁺, K⁺, TMA⁺, none) | 5 species | — | 5 |
| Transition metal substitution | Ti, V, Mo, Nb, Cr | — | 5 |
| Total candidate configurations | — | — | 18,150 |

### 4.3 Target Observables for SE Prediction

From calculated σ(ω) and ε(ω):
```
SE(dB) = SE_R + SE_A + SE_M
SE_R = 20 log₁₀|(Z₀ + Z_s)/(2Z₀)|
SE_A = 20 log₁₀|e^(αd)|, where α = ω√(ε''/2c²)
SE_M = 20 log₁₀|1 - e^(-2αd)|
```

Target: SE ≥ 92 dB at d = 10 μm, f = 1-10 GHz.

---

## 5. Classical Feasibility Assessment

**Why classical DFT is insufficient:**

- Standard DFT with PBE functional: adequate for band structure trends but systematically underestimates band gaps by 30-50%, leading to overestimated conductivity
- Hybrid functionals (HSE06): more accurate but computational cost scales as O(N⁴) with system size; infeasible for >50 atom systems
- GW/BSE for excited states: O(N⁶) scaling; limited to <20 atoms for MXene
- The combinatorial space of 18,000+ configurations requires >100 years on a 1,000-node classical cluster

**Quantum advantage projection:** VQE on ~200 logical qubits can sample the active space of frontier d-orbitals with UCCSD accuracy in hours per configuration, enabling full parameter space exploration in weeks rather than decades.

---

## 6. Expected Quantum Advantage

| Metric | Current (Ti₃C₂Tₓ, 45 μm) | Quantum Target | Improvement |
|---|---|---|---|
| SE per unit thickness | 2.04 dB/μm | 9.2 dB/μm | 4.5× |
| Material usage per panel | 50 g/m² | 11 g/m² | 4.5× reduction |
| Panel MXene cost (in-house) | $3.25/m² | $0.71/m² | 78% |
| Absorption fraction | 87% | >95% | Reduced crew exposure |
| Bandwidth (SE > 60 dB) | 1-10 GHz | 0.1-20 GHz | Expanded protection |

---

## 7. Partner Requirements

- **Qubit count:** ≥ 100 logical qubits with gate fidelity ≥ 99.9%
- **Error correction:** Fault-tolerant surface code architecture
- **Quantum chemistry toolkit:** VQE with UCCSD, QPE, or quantum embedding methods
- **Classical integration:** Interface with VASP, Quantum ESPRESSO, or GPAW for DFT preprocessing
- **Expertise:** Demonstrated experience in 2D materials electronic structure; MXene experience preferred
- **IP sharing:** CSM retains exclusive manufacturing rights for any discovered Aegis-C applicable composition; quantum partner retains algorithm/method IP

---

## 8. Deliverables and Timeline

| Phase | Deliverable | Timeline |
|---|---|---|
| Phase 1 | Benchmark VQE on Ti₃C₂Tₓ 3×3 supercell — reproduce known band structure | Months 1-3 |
| Phase 2 | Screen 500 candidate O/OH/F termination ratios; identify top 20 | Months 4-6 |
| Phase 3 | Full VQE on top 20 configurations with interlayer spacing/intercalation variation | Months 7-12 |
| Phase 4 | Extend to V₂CTₓ and Mo₂TiC₂Tₓ for comparison | Months 10-14 |
| Phase 5 | Deliver final composition recommendation with predicted SE-frequency curve | Months 12-18 |
| Phase 6 | CSM synthesizes top 5 candidates; experimental validation against prediction | Months 13-18 |

---

## 9. References from CSMFAB Knowledge Base

1. CSMFAB Materials Study Part I — MAX Phase Ti₃AlC₂ (Section 6, Feasibility 5/5)
2. CSMFAB Materials Study Part III — MXene Ti₃C₂Tₓ (Section 17, Feasibility 5/5, 96-97% savings)
3. CSMFAB 001 — Aegis-C Composite Shielding Design V2.0 (Section 5.2, MXene FSS layer)
4. CSMFAB 001 — Panel Cost Analysis V2.0 (MXene: $100/panel commercial; $3.25/panel in-house)
5. CSMSFRadio00001 — NASH segment: Quantum computing breakeven milestone (lines 39-51)
6. Gogotsi, Y. et al., "Electromagnetic Interference Shielding with MXene," Science, 2016

---

*"The Dielectric Citadel is not a feature — it is a philosophy of unconditional electrical independence. When the Carrington event arrives, there will be no retrofit opportunity."*

**— CSM Engineering Design Directive, Aegis-C Series**

*Document prepared by: Director Kairos Steele, CITADEL [DIRECTOR-001] | with technical specifications authored by the analytical perspective of Dr. Theron Nash (quantum computing methodology) and the synthesis economics of Engineer Orion Cross (cost analysis) — Aegis Operations, Carrington Storm Motors*

*CSMQuantum Series 001 | Version 1.0 | July 2026*
*© 2026 Carrington Storm Motors / Safe Pod Engineering Company. All rights reserved.*
