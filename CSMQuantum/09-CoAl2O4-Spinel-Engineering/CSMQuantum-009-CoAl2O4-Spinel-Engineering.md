# CSMQuantum-009 — CoAl₂O₄ Spinel Dopant Engineering
## Quantum Research Delegation Paper 09
### Carrington Storm Motors / Safe Pod Engineering Company | July 2026

---

**[WILLIAMS HEURISTIC V2 — ROUTINE SEVERITY — MORK MORNING]**

Not every material in the Aegis-C portfolio needs to bear the structural and electromagnetic load of the external shield. Some materials serve interior roles — the CoAl₂O₄ cobalt aluminate spinel that coats interior walls, the Schumann resonance absorption surfaces, the deep-blue glaze that complements YInMn Blue on the outside of non-structural panels. Cobalt aluminate is our cost-accessible blue — no indium, no rare earths (except the aluminum, which is everywhere), synthesis as simple as co-precipitation at room temperature followed by calcination at 800-1000°C. In-house cost: $22-38/kg vs. $55-100/kg commercial. It absorbs 1060 nm (Nd:YAG wavelength) selectively, making it a natural laser countermeasure coating for military-adjacent applications.

But its Solar Reflectance Index (SRI) is 98 versus YInMn's 115. Its NIR reflectance is 70-80% versus YInMn's 85-92%. Its blue is slightly different — deeper, leaning indigo — which limits its use as a direct YInMn substitute. Can we dope the spinel to improve these metrics? Chromium for deeper green-blue? Iron for brown-tinted absorption? Nickel for a different crystal field altogether? This is crystal field engineering again — the same quantum problem as Paper 003, but on a simpler lattice (spinel, not hexagonal perovskite), with a simpler electronic configuration (Co²⁺ d⁷, not Mn³⁺ d⁴), and with a more forgiving cost structure ($22-38/kg means we can afford some trial and error).

---

## 1. Executive Summary

CoAl₂O₄ (cobalt aluminate spinel) serves as a secondary blue pigment and Nd:YAG laser countermeasure coating across 8 CSMFAB products. Its lower cost and simpler synthesis relative to YInMn Blue make it attractive for interior and non-critical applications. However, its SRI (98) and NIR reflectance (70-80%) fall short of YInMn's performance (SRI 115, NIR 85-92%). Dopant engineering via transition metal substitution on the tetrahedral (A) and octahedral (B) spinel sites could enhance NIR reflectance while preserving or tuning the blue color.

**Quantum task:** DFT-VQE calculation of the electronic structure of Co₁₋ₓMₓAl₂₋ᵧNᵧO₄ (M = Zn, Mg, Ni, Fe, Mn; N = Cr, Fe, Ga) doped spinels. Calculate d-d excitation energies using quantum subspace expansion (QSE) to predict color shifts. Calculate phonon-assisted NIR absorption to predict SRI changes.

**Target:** Identify dopant combination achieving SRI ≥ 110 (from current 98) and NIR reflectance ≥ 80% (from current 70-80%), while maintaining blue color (peak absorption 580-620 nm).

---

## 2. Material Specification

### 2.1 Spinel Structure

**Formula:** AB₂O₄, where:
- A site: tetrahedral coordination (8a Wyckoff, T_d symmetry) — blue color from Co²⁺ in T_d
- B site: octahedral coordination (16d Wyckoff, O_h symmetry) — primarily Al³⁺

**Normal spinel structure:** Co²⁺ on A sites, Al³⁺ on B sites
**Crystal structure:** Cubic Fd-3m, a = 8.104 Å (CoAl₂O₄)

### 2.2 Color Mechanism

Co²⁺ in tetrahedral coordination (T_d point group):
- d⁷ configuration: ⁴A₂(F) ground state
- Main transition: ⁴A₂(F) → ⁴T₁(P) at ~16,200 cm⁻¹ (617 nm, red-orange absorption → blue color)
- Secondary: ⁴A₂(F) → ⁴T₁(F) at ~7,500 cm⁻¹ (1,333 nm, NIR absorption — contributes to solar heat gain)

The NIR absorption at 1,333 nm is the primary reason CoAl₂O₄ has lower SRI than YInMn. Suppressing this transition while preserving the 617 nm absorption would improve SRI without changing color.

### 2.3 Current Performance and Cost

| Property | CoAl₂O₄ | YInMn Blue (reference) |
|---|---|---|
| Primary absorption | 617 nm (red-orange) | 590 nm (orange) |
| NIR absorption | 1,333 nm (d-d) | Minimal d-d in NIR |
| SRI | 98 | 115 |
| NIR reflectance (800-1200 nm) | 70-80% | 85-92% |
| Cost/kg (in-house) | $22-38 | $165 (In-limited) |
| Max service temp | >1,400°C | ~1,200°C |

### 2.4 Candidate Dopants

| Dopant | Site Preference | d-electron Count | Expected Effect | Cost/kg |
|---|---|---|---|---|
| Zn²⁺ | Tetrahedral (A) | d¹⁰ (closed shell) | Dilutes Co → lighter blue, eliminates NIR d-d | $3 |
| Mg²⁺ | Tetrahedral (A) | — (no d) | Dilutes Co; no color | $2.50 |
| Ni²⁺ | Octahedral (B) | d⁸ | Adds green-yellow absorption | $18 |
| Fe³⁺ | Octahedral (B) | d⁵ (HS) | Broad NIR absorption (unwanted) | $1.20 |
| Cr³⁺ | Octahedral (B) | d³ | Red-pink tint; tunable | $12 |
| Ga³⁺ | Octahedral (B) | d¹⁰ | Lattice expansion; indirect band gap shift | $400 |

---

## 3. Quantum Simulation Task

### 3.1 DFT-VQE for Electronic Structure

**System size:** CoAl₂O₄ primitive cell = 14 atoms; 2×2×2 supercell = 112 atoms
**For doped systems:** Co₁₋ₓZnₓAl₂O₄ at x = 0, 0.125, 0.25, 0.5 (Zn on A site) = 4 compositions
**With B-site co-doping:** Co₀.₇₅Zn₀.₂₅(Al₁.₈₇₅Cr₀.₁₂₅)O₄
**Total compositions to screen:** ~200

### 3.2 Quantum Subspace Expansion (QSE) for d-d Excitations

The d-d excitation energy requires multireference treatment for Co²⁺ d⁷ (similar to Mn³⁺ d⁴ in Paper 003 but less complex — only 3 spin states vs. 5). Map the (7,5) active space (7 electrons in 5 Co d orbitals) onto ~10-14 qubits. Use QSE on the VQE ground state to extract excitation energies:

```
ΔE(d-d) = E_VQE(excited) - E_VQE(ground)
```

### 3.3 Observable Targets

| Observable | Method | Target |
|---|---|---|
| ⁴A₂ → ⁴T₁(P) energy | QSE | 16,200 ± 500 cm⁻¹ (blue preserved) |
| ⁴A₂ → ⁴T₁(F) oscillator strength | Transition dipole from VQE | Minimize (reduce NIR absorption) |
| Band gap (host) | VQE-DFT | > 3.0 eV (no visible bandgap absorption) |
| SRI prediction | Transfer matrix from optical constants | ≥ 110 |

---

## 4. Classical Feasibility Assessment

- DFT-PBE on 112-atom cell: ~8 hours per composition on 64 cores
- 200 compositions × 8 hours = 1,600 node-hours (feasible in weeks)
- CASPT2 for d-d excitations: ~48 hours per composition on single node
- 200 compositions × 48 hours = 9,600 node-hours (feasible in months)
- **Classically tractable but slow** — quantum acceleration delivers results in weeks rather than months, enabling faster iteration with experimental synthesis feedback

---

## 5. Expected Quantum Advantage

| Metric | Current | Target |
|---|---|---|
| SRI | 98 | ≥ 110 |
| NIR reflectance | 70-80% | ≥ 80% |
| NIR d-d absorption (1,333 nm) | Present | Suppressed by ≥ 50% |
| Blue color (617 nm) | Present | Preserved |
| Cost/kg | $22-38 | $25-40 (modest increase from dopants) |

---

## 6. Partner Requirements

- **Qubit count:** ≥ 100 logical qubits for (7,5) active space QSE
- **Quantum methods:** VQE with UCCSD, QSE for excited states
- **Classical integration:** VASP + OpenMolcas for reference CASPT2 benchmarks
- **Expertise:** Spinel crystal chemistry; transition metal spectroscopy; d-d excitation theory

---

## 7. Deliverables and Timeline

| Phase | Deliverable | Timeline |
|---|---|---|
| Phase 1 | Benchmark QSE d-d excitations on pure CoAl₂O₄ vs. CASPT2 | Months 1-3 |
| Phase 2 | Screen 50 Zn/Mg-doped compositions (A-site dilution) | Months 4-6 |
| Phase 3 | Screen 50 Cr/Ni-doped compositions (B-site co-doping) | Months 6-8 |
| Phase 4 | Screen 100 combined A+B site doped compositions | Months 8-11 |
| Phase 5 | Top 5 recommendations; CSM co-precipitation synthesis and spectrophotometry | Months 11-15 |

---

*"The woad-dark interior surfaces were the Schumann absorption reference we built the vehicle around. Quietly." — from the Aegis-C design sessions*

*Document prepared by: Director Kairos Steele, CITADEL [DIRECTOR-001] | with spinel crystal chemistry informed by the analytical precision of Dr. Theron Nash (multireference quantum methods), the pigment synthesis expertise of Engineer Orion Cross (co-precipitation and calcination), the color science of Dr. Lyra Kade (human perception and aesthetic requirements), and the supply chain pragmatism of Commander Auric Veyne (cost-benefit and strategic cobalt sourcing) — Aegis Operations, Carrington Storm Motors*

*CSMQuantum Series 009 | Version 1.0 | July 2026*
*© 2026 Carrington Storm Motors / Safe Pod Engineering Company. All rights reserved.*
