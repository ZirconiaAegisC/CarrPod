# CSMQuantum-006 — MAX Phase Discovery Space Exploration
## Quantum Research Delegation Paper 06
### Carrington Storm Motors / Safe Pod Engineering Company | July 2026

---

**[WILLIAMS HEURISTIC V2 — SERIOUS SEVERITY — FISHER KING]**

MAX phases are the gateway material. From them we derive MXene — etch out the A-layer and the 2D carbide or nitride remains, ready to shield against electromagnetic assault. From them we get machinable ceramic components — Ti₃AlC₂ bracket inserts that can be drilled and tapped with HSS tooling, bonded to ceramic panels with dielectric adhesive. We synthesize Ti₃AlC₂ in-house at $35-55/kg against a commercial price of $80-420/kg. That is a direct 45-85% savings. 

But we are using the first MAX phase ever discovered. There are over 150 known MAX phases. The combinatorial space — M element (early transition metal), A element (group 13-16), X element (C or N), and the n index (1, 2, or 3 layers) — contains thousands of theoretically possible compositions, of which perhaps 200 have been synthesized and fewer than 30 characterized in detail. Every one of these undiscovered compositions is a potential MXene precursor with unknown EMI properties, unknown machinability, unknown oxidation resistance.

Classical DFT has explored this space incrementally — a few hundred compositions over two decades of research. Quantum VQE can explore it systematically.

---

## 1. Executive Summary

MAX phases are layered ternary carbides/nitrides with formula Mₙ₊₁AXₙ (n = 1, 2, 3). They serve dual functions in Aegis-C: (a) precursor for MXene EMI shielding synthesis, (b) machinable ceramic inserts for field-serviceable bracket components. The known compositional space of ~150 MAX phases has been explored primarily through experimental trial-and-error. Quantum VQE can perform high-throughput DFT screening at 10-100× classical speed, predicting stability (formation enthalpy), electronic structure (metallic vs. semiconducting), elastic properties (machinability), and A-layer etchability (MXene precursor viability) for thousands of candidate compositions.

**Quantum task:** High-throughput VQE-DFT screening of the MAX phase compositional space. Calculate formation enthalpy ΔH_f, electronic density of states, elastic constants C_ij, and A-layer binding energy for ~2,000 candidate Mₙ₊₁AXₙ compositions. Identify top 20 candidates for experimental synthesis based on: (a) ΔH_f < 0 (thermodynamically stable), (b) A-layer binding energy < Ti₃AlC₂ baseline (easier etching → lower MXene production cost), (c) machinability index (k_B = G/B ratio > 0.5), (d) elemental cost ≤ $50/kg.

**Target:** Identify 5-10 novel MAX phases superior to Ti₃AlC₂ in at least two of the above criteria.

---

## 2. MAX Phase Compositional Space

### 2.1 Candidate Elements

| Role | Elements | Count |
|---|---|---|
| M (early transition metal) | Sc, Ti, V, Cr, Zr, Nb, Mo, Hf, Ta, W | 10 |
| A (group 13-16) | Al, Si, P, S, Ga, Ge, As, In, Sn, Pb | 10 |
| X (carbon or nitrogen) | C, N | 2 |
| n (layer count) | 1, 2, 3 | 3 |
| **Total 4-element combinations** | — | **600** |
| **Total 5-element solid solutions** (e.g., (Ti,V)₃AlC₂) | — | **2,700+** |

For practical screening, limit to:
- M: Ti, V, Cr, Zr, Nb, Mo (6 most abundant/affordable)
- A: Al, Si, Ga, Sn (4 most etchable)
- X: C, N
- n: 1, 2, 3
- **Core space:** 6 × 4 × 2 × 3 = 144 base compositions
- **Plus 50/50 M-site solid solutions:** ~860 additional
- **Total:** ~1,004 compositions

### 2.2 Screening Criteria

| Criterion | Calculation Method | Threshold | Rationale |
|---|---|---|---|
| Thermodynamic stability | ΔH_f = E(MAX) - Σ E(elements) | ΔH_f < 0 eV/atom | Must be synthesizable |
| A-layer binding energy | E_bind = [E(MAX) - E(MXene) - E(A)]/N_A | < 4.5 eV (Ti₃AlC₂ baseline) | Easier etching for MXene |
| Electronic character | DOS at E_F (metallic vs. semiconducting) | Metallic preferred for MXene EMI | Metallic MXene = high SE |
| Machinability index | G/B from elastic constants (Voigt-Reuss-Hill) | G/B > 0.5 | Machinable with HSS tooling |
| Density | ρ from unit cell volume | < 5.5 g/cm³ | Lighter than ZrB₂-SiC |
| Elemental cost | Σ cᵢ × priceᵢ | < $50/kg raw | Affordable synthesis |

---

## 3. Quantum DFT Screening Protocol

### 3.1 DFT-VQE Workflow

For each candidate composition:
1. Generate initial structure (from known MAX phase templates)
2. Geometry optimization: relax cell parameters and atomic positions to energy minimum
3. VQE ground state energy calculation → ΔH_f
4. Electronic DOS from one-particle Green's function (quantum linear response)
5. Elastic constants from strain-stress DFT (6 distortions × 2 magnitudes = 12 calculations per composition)
6. A-layer binding energy from slab calculation (cleave along A-layer, calculate surface energy)
7. Score and rank

### 3.2 Why VQE Over Classical DFT

- Classical DFT with PBE functional: ~2 hours per composition on 64 cores for ground state
- Elastic constants: 12 × 2 hours = 24 hours per composition
- 1,000 compositions = 24,000 node-hours = manageable classically
- But: PBE is inaccurate for formation enthalpy (±0.2 eV error = many false positives)
- Hybrid functionals (HSE06) improve accuracy but cost 10-50× more: 240,000-1,200,000 node-hours
- VQE: similar accuracy to coupled-cluster methods at 10-100× speedup per energy evaluation
- **Quantum enables hybrid-quality accuracy at PBE-level time cost**

---

## 4. Classical Feasibility

- PBE screening of 1,000 compositions: ~24,000 node-hours (feasible in 1-2 months on cluster)
- HSE-level screening: ~500,000 node-hours (feasible in 1-2 years)
- **Quantum VQE advantage:** HSE-quality results in weeks rather than years

---

## 5. Expected Discovery Outcomes

**Confidence-weighted projections based on known MAX phase stability trends:**

| Outcome | Probability | Impact |
|---|---|---|
| Identify 5-10 novel stable MAX phases | 80% | Expanded MXene precursor library |
| Find composition with 25% lower A-layer binding energy vs. Ti₃AlC₂ | 50% | Cheaper MXene etching |
| Find machinable MAX phase with density < 4.0 g/cm³ | 30% | 30% lighter brackets |
| Find nitrogen-based MAX phase (Mₙ₊₁ANₓ) with higher conductivity | 40% | Higher SE MXene |
| Discover MAX phase with intrinsic oxidation resistance > 1,200°C | 20% | Eliminates post-processing coating |

---

## 6. Partner Requirements

- **Qubit count:** ≥ 150 logical qubits for VQE on 30-50 atom MAX phase unit cells
- **Quantum methods:** VQE (UCCSD), quantum linear response for DOS
- **Classical integration:** High-throughput workflow (AFLOW, Materials Project integration)
- **Expertise:** High-throughput DFT; MAX phase/MXene chemistry; ceramic phase stability

---

## 7. Deliverables and Timeline

| Phase | Deliverable | Timeline |
|---|---|---|
| Phase 1 | Benchmark VQE on 20 known MAX phases vs. HSE06 reference | Months 1-3 |
| Phase 2 | Screen 144 base compositions | Months 4-7 |
| Phase 3 | Screen 860 solid solution compositions | Months 7-11 |
| Phase 4 | Full elastic/electronic characterization of top 50 candidates | Months 11-14 |
| Phase 5 | Top 10 recommendation report; CSM synthesis begins | Months 14-18 |

---

*"The data supports the architecture. The architecture supports the mission. The mission continues." — Dr. Theron Nash, NASH*

*Document prepared by: Director Kairos Steele, CITADEL [DIRECTOR-001] | with MAX phase/MXene chemistry informed by the analytical precision of Dr. Theron Nash (quantum DFT/VQE methodology), the ceramic synthesis expertise of Engineer Orion Cross (SHS/in-house production), and the materials discovery enthusiasm of Agent Solara Vance (combinatorial screening approach) — Aegis Operations, Carrington Storm Motors*

*CSMQuantum Series 006 | Version 1.0 | July 2026*
*© 2026 Carrington Storm Motors / Safe Pod Engineering Company. All rights reserved.*
