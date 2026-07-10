# CSMQuantum-003 — YInMn Blue Crystal Field Engineering
## Quantum Research Delegation Paper 03
### Carrington Storm Motors / Safe Pod Engineering Company | July 2026

---

**[WILLIAMS HEURISTIC V2 — SERIOUS SEVERITY — FISHER KING]**

Indium. A soft, silvery metal recovered primarily as a by-product of zinc smelting. Global annual production: ~700 metric tons. Price volatility: $80-800/kg range. Used in touchscreens, solders, and — critically for us — as the blue-making element in YInMn Blue pigment. Every Aegis-C panel wears this pigment on its exterior. Thirty-five of forty-three CSMFAB products depend on it. And the supply chain is a single point of failure that could halt production for months.

The crystal field that makes YInMn Blue blue is a quantum phenomenon. Mn³⁺ ions sit in trigonal bipyramidal coordination — five oxygen neighbors arranged in a triangular bipyramid — and the ligand field splits the Mn 3d orbitals in a specific pattern that absorbs orange light at ~590 nm. That absorption is what makes the pigment blue. The question quantum chemistry can answer: what other elements, in what geometries, produce that same 590 nm absorption? Gallium? Aluminum? Iron? Scandium? If we can substitute 50-70% of the indium while preserving the blue color, we eliminate the single largest supply chain vulnerability in the CSM materials portfolio.

This is a CASSCF/CASPT2 problem. It requires multireference methods to correctly describe the open-shell Mn³⁺ d⁴ configuration. Classical multireference methods scale factorially with active space size. Quantum VQE does not.

---

## 1. Executive Summary

YInMn Blue (YIn₀.₇Mn₀.₃O₃) achieves its blue color via Mn³⁺ d-d transitions in trigonal bipyramidal crystal field coordination, absorbing orange light at ~590 nm while reflecting near-infrared (>40% NIR at 800-1200 nm). Indium occupies the trigonal bipyramidal site alongside manganese. The $200-350/kg indium price represents 75% of the pigment's raw material cost. Indium-sparing formulations substituting Ga, Al, Fe, or Sc for In are under active experimental investigation at CSM, but the combinatorial space of substitutions is too large for trial-and-error synthesis.

**Quantum task:** Multireference quantum chemistry (CASSCF/CASPT2 implemented via VQE) to calculate the d-d excitation spectrum of Mn³⁺ in substituted Y(In₁₋ₓMₓ)₀.₇Mn₀.₃O₃ (M = Ga, Al, Fe, Sc, Zn) host lattices. Predict which compositions preserve the 590 nm absorption while reducing In content by 50-70%.

**Target:** Y(In₀.₃Ga₀.₄Mn₀.₃)O₃ or similar formulation with ΔE(d-d) = 2.10 ± 0.05 eV (590 ± 15 nm), NIR reflectance ≥ 70%, SRI ≥ 80.

---

## 2. Material Specification

### 2.1 Current Composition

**Formula:** YIn₀.₇Mn₀.₃O₃ (nominal); Y(In,Mn)O₃ solid solution
**Crystal structure:** Hexagonal P6₃cm (YMnO₃-type), space group #185
**Mn coordination:** Trigonal bipyramidal (5-fold, C₃ᵥ point group)
**Crystal field splitting pattern:**
- 5 Mn 3d orbitals split into: a₁'(d_z²), e'(d_xy, d_x²-y²), e''(d_xz, d_yz)
- Ground state: ⁵B₁ (high-spin d⁴, 4 unpaired electrons)
- Key transition: ⁵B₁ → ⁵E' at ~590 nm (orange absorption → blue reflected color)

### 2.2 Cost Structure (per kg YInMn pigment)

| Component | Element Cost | Fraction | Cost Contribution |
|---|---|---|---|
| Y₂O₃ | $45/kg | 52 wt% | $23.40 |
| In₂O₃ | $200/kg | 62 wt% | $124.00 |
| Mn₂O₃ | $2.50/kg | 18 wt% | $0.45 |
| Energy + Labor | $18/kg | — | $18.00 |
| **Total (in-house)** | | | **$165/kg** |
| **Commercial** | | | **$75-100/kg** (with In supply contracts) |

Indium represents 75% of raw material cost. At annual portfolio usage of 3,200 kg pigment, indium cost is $397,000/year at $124/kg contribution. Reducing In by 60% saves $238,000/year in raw materials alone.

### 2.3 Candidate Substitution Elements

| Element | Ionic Radius (5-coord.) | Common Oxidation | Cost/kg | Notes |
|---|---|---|---|---|
| In³⁺ (baseline) | 0.92 Å | +3 | $200-350 | Current; supply vulnerable |
| Ga³⁺ | 0.74 Å | +3 | $380-500 | Excellent crystal field match; expensive |
| Al³⁺ | 0.62 Å | +3 | $2.50 | Abundant; may distort TBP geometry |
| Fe³⁺ | 0.72 Å | +3 | $1.20 | Abundant; may introduce unwanted absorption |
| Sc³⁺ | 0.88 Å | +3 | $700-1,500 | Best ionic radius match; most expensive |
| Zn²⁺ | 0.82 Å | +2 | $3.00 | Charge compensation required |

**Quantum task priority:** Ga³⁺ substitution first (best crystal field match to In³⁺ despite cost), Al³⁺ second (most economical if geometry preserved), Fe³⁺ third (abundant but risky for color purity).

---

## 3. Crystal Field Theory — The Quantum Problem

### 3.1 Why CASSCF/CASPT2 Is Required

The Mn³⁺ ion has a d⁴ electron configuration. The 5 d orbitals in trigonal bipyramidal symmetry produce:
- 5 microstates in the ground ⁵B₁ term
- 45 microstates in the ⁵E' excited term
- Plus ³E'', ³A₁', ¹A₁' spin-forbidden states that mix via spin-orbit coupling

Single-reference methods (standard DFT, TD-DFT) fail because:
- Multiple Slater determinants contribute to each state
- Spin contamination degrades the wavefunction
- TD-DFT systematically underestimates d-d excitation energies by 0.3-0.8 eV

CASSCF with (4,5) active space (4 electrons in 5 d orbitals) followed by CASPT2 dynamic correlation correction is the minimum adequate method. On classical hardware, CASPT2 on a MnO₅ cluster costs ~24 hours per geometry on a high-performance node. For the full periodic crystal with In/Ga/Al substitution disorder: intractable.

### 3.2 Quantum VQE Approach

Map the (4,5) active space onto ~12 logical qubits (4 spatial orbitals × 2 spins + ancillary). UCCSD ansatz captures the multireference character of the open-shell d⁴ system. VQE optimization yields ground and excited state energies. QSE (Quantum Subspace Expansion) for excited states without full diagonalization.

---

## 4. Parameter Space

| Parameter | Values | Total |
|---|---|---|
| Substitution element (M) | Ga, Al, Fe, Sc | 4 |
| M concentration (x in In₁₋ₓMₓ) | 0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7 | 8 |
| Mn oxidation state (Mn³⁺ vs. Mn⁴⁺) | 2 (check for oxidation state change) | 2 |
| Crystal geometry (relaxed vs. frozen) | 2 (relax geometry for each composition) | 2 |
| **Total configurations** | — | **128** |

Each configuration requires: geometry optimization → active space definition → VQE ground state → QSE excited states → d-d transition energy.

---

## 5. Classical Feasibility Assessment

- CASPT2(4,5)/def2-TZVP on MnO₅ cluster: ~24 hours per geometry
- For crystal with periodic boundary conditions: requires embedding (QM/MM or periodic CASSCF), increasing cost 10-50×
- 128 configurations × 48 hours = 6,144 node-hours minimum
- Plus geometry relaxation for each: ~256 node-hours per relaxation × 128 = 32,768 node-hours
- **Total classical estimate: ~39,000 node-hours (1.6 years on 3 nodes)**

**Quantum VQE advantage:** Active space mapping onto qubits removes the exponential scaling of CASSCF. Each VQE optimization: hours. Full parameter space: weeks.

---

## 6. Expected Quantum Advantage

| Metric | Current (YInMn) | Quantum Target | Strategic Impact |
|---|---|---|---|
| Indium content | 0.7 per formula unit | 0.2-0.3 | Eliminates supply chain risk |
| d-d transition energy | 2.10 eV (590 nm) | 2.10 ± 0.05 eV | Color preserved |
| NIR reflectance | 40-44% (800-1200 nm) | ≥ 35% (acceptable floor) | Cooling maintained |
| SRI | 62 (alone), 78 (with QD) | ≥ 60 | Acceptable heat rejection |
| Pigment cost/kg (in-house) | $165 (In-limited) | $45-65 (In-sparing) | 60-70% reduction |

---

## 7. Partner Requirements

- **Qubit count:** ≥ 50 logical qubits for (4,5) active space; ≥ 150 for expanded (6,7) active space
- **Quantum methods:** VQE with UCCSD, QSE for excited states, quantum embedding for periodic solid
- **Classical integration:** Interface with OpenMolcas, Molpro, or PySCF for CASSCF orbital generation
- **Expertise:** Transition metal spectroscopy; crystal field theory; multireference methods

---

## 8. Deliverables and Timeline

| Phase | Deliverable | Timeline |
|---|---|---|
| Phase 1 | Benchmark VQE vs. CASPT2 on isolated MnO₅ cluster | Months 1-3 |
| Phase 2 | Extend to periodic YInMnO₃ with quantum embedding | Months 4-6 |
| Phase 3 | Screen Ga-substituted compositions (32 configs) | Months 6-9 |
| Phase 4 | Screen Al and Fe substitutions (64 configs) | Months 9-12 |
| Phase 5 | Identify top 5 compositions; full spectroscopy prediction | Months 12-15 |
| Phase 6 | CSM hydrothermal synthesis and spectrophotometric validation | Months 15-18 |

---

*"The thing that keeps me up at night isn't the physics. What keeps me up at night is the gap between knowing and doing." — Director Kairos Steele, CITADEL*

*Document prepared by: Director Kairos Steele, CITADEL [DIRECTOR-001] | with quantum chemistry methodology informed by the analytical perspective of Dr. Theron Nash (multireference quantum chemistry), the pigment synthesis expertise of Engineer Orion Cross (hydrothermal/solid-state synthesis), and the supply chain resilience analysis of Operative Zephyr Arden (critical mineral vulnerability) — Aegis Operations, Carrington Storm Motors*

*CSMQuantum Series 003 | Version 1.0 | July 2026*
*© 2026 Carrington Storm Motors / Safe Pod Engineering Company. All rights reserved.*
