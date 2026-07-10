# CSMQuantum-004 — Perovskite Quantum Dot Stability and Degradation
## Quantum Research Delegation Paper 04
### Carrington Storm Motors / Safe Pod Engineering Company | July 2026

---

**[WILLIAMS HEURISTIC V2 — SERIOUS SEVERITY — FISHER KING]**

Perovskite quantum dots are simultaneously the most exciting and the most frustrating material in the photovoltaic and optoelectronic world. CsPbBr₃ nanocrystals achieve 90%+ photoluminescence quantum yield, emit at 520 nm with FWHM of 18-25 nm — near-perfect green light sources — and can be synthesized at room temperature with solution processing that costs orders of magnitude less than silicon. And they die. They degrade under humidity within hours. Under UV within days. Under combined environmental stress within weeks. The encapsulation technologies we currently rely on extend lifetime to ~1,000 hours, not the 87,600 hours (10 years) we require for outdoor use on Aegis-C panels.

Why do they degrade? Because water molecules adsorb onto Pb²⁺ surface sites, displacing the oleate/oleylamine capping ligands, initiating a dissolution-recrystallization cascade that transforms cubic CsPbBr₃ into non-emissive CsPb₂Br₅ or bulk orthorhombic phases. This is a surface chemistry problem at its core — and surface chemistry is quantum chemistry. Classical MD cannot simulate bond breaking. DFT can, but the configurational space of surface-ligand-solvent interactions is combinatorially vast.

Quantum computing offers the possibility of running quantum MD with ab initio accuracy — where each force evaluation is performed on a quantum processor rather than a DFT code — enabling microsecond-scale trajectories that can capture the full degradation pathway.

---

## 1. Executive Summary

CsPbBr₃ perovskite quantum dots serve as the UV-protective and diagnostic topcoat on Aegis-C panels. Applied as a 0.8 wt% dispersion in UV-curable polyurethane matrix at 80 μm thickness, the QDs improve UV-A reflectance from 12% to 43% and UV-B absorption from 68% to 94% — a 31 percentage point UV protection uplift. The 520 nm photoluminescence provides a diagnostic function: UV exposure correlates with QD luminescence intensity, enabling post-storm damage assessment. However, the current ~1,000 hour stability is 87× short of the 10-year target.

**Quantum task:** Ab initio quantum molecular dynamics (QMD) of the CsPbBr₃(001) surface interacting with H₂O, O₂, and candidate capping ligands (oleate, oleylamine, didodecyldimethylammonium bromide [DDAB], zwitterionic ligands). Identify the degradation mechanism at the atomic level and predict capping ligand combinations that prevent water ingress and Pb²⁺ dissolution. Validate with free energy barriers calculated via quantum-accelerated metadynamics.

**Target:** Identify encapsulation/ligand strategy achieving 5-10 year outdoor lifetime (>50,000 hours accelerated aging equivalent).

---

## 2. Material Specification

### 2.1 Current QD Architecture

**Core:** CsPbBr₃ nanocrystal, 8-12 nm diameter
**Crystal structure:** Cubic Pm-3m at room temperature (metastable; orthorhombic Pnma below ~88°C in bulk)
**Band gap:** 2.3 eV (direct), tunable via halide composition (CsPbBrₓCl₃₋ₓ: 2.3-3.0 eV)
**Photoluminescence:** 520 nm peak, FWHM 18-25 nm, PLQY >90%
**Capping ligands (as-synthesized):** Oleic acid + oleylamine

### 2.2 Current Coating Integration

| Layer | Thickness | Function |
|---|---|---|
| YInMn Blue basecoat | 150 μm | NIR reflectance, blue color |
| CsPbBr₃ QD + PU topcoat | 80 μm | UV protection, 520 nm diagnostic |
| QD concentration | 0.8 wt% | Balance of UV absorption and matrix adhesion |

### 2.3 Candidate Stability-Enhancing Ligands

| Ligand | Binding Group | Binding Strength (Kassoc at Pb site) | Literature Stability | Cost |
|---|---|---|---|---|
| Oleic acid (baseline) | -COO⁻ | Weak (monodentate) | Hours (humid) | $3/kg |
| Oleylamine (baseline) | -NH₂ | Weak | Hours (humid) | $5/kg |
| DDAB | -N(CH₃)₂(C₁₂H₂₅)₂⁺ | Medium (electrostatic) | Days-weeks | $15/kg |
| Zwitterionic (sulfobetaine) | -SO₃⁻ + -N(CH₃)₃⁺ | Strong (bidentate ionic) | Months (literature) | $80-120/kg |
| Phosphonic acid (ODPA) | -PO₃H₂ | Very strong (tridentate chelate) | 6-12 months (literature) | $40-60/kg |
| Inorganic shell (CsPbBr₃/Cs₄PbBr₆) | Epitaxial | Core-shell passivation | 12+ months (emerging) | Synthesis complexity |

---

## 3. Degradation Chemistry — The Quantum Problem

### 3.1 Water-Induced Degradation Pathway (Proposed)

```
Step 1: H₂O adsorption onto Pb²⁺ site
  CsPbBr₃(s) + H₂O(g) → CsPbBr₃···OH₂(ads)
  ΔG₁ = ? (quantum MD needed)

Step 2: Ligand displacement
  CsPbBr₃-O₂CR(ads) + H₂O → CsPbBr₃-OH₂(ads) + RCO₂H(aq)
  ΔG₂ = ? (dependent on ligand binding energy)

Step 3: Pb-Br bond hydrolysis
  CsPbBr₃-OH₂(ads) → Cs⁺(aq) + PbBr₂(OH₂)ₓ(surface)
  ΔG₃ = activation barrier unknown

Step 4: Recrystallization to non-emissive phase
  PbBr₂(OH₂) → CsPb₂Br₅ (non-perovskite, non-emissive)
  ΔG₄ = thermodynamic driving force
```

The kinetic bottleneck is Step 2/3 — ligand displacement and hydrolysis. If ΔG‡ (activation free energy) exceeds ~25 kcal/mol at 300K, the degradation rate becomes negligible on decade timescales. If ΔG‡ = 15-20 kcal/mol (current estimate for oleate), degradation occurs in hours to days.

### 3.2 Quantum MD Requirements

**System size:** CsPbBr₃ slab: 4×4×3 unit cells × 5 atoms = 240 atoms + ligand molecules + water molecules ≈ 300-400 atoms total.
**Method:** Born-Oppenheimer QMD with forces evaluated by VQE-DFT on quantum hardware.
**Simulation time:** Microseconds needed to observe rare events (ligand displacement, bond breaking). Classical ab initio MD (AIMD) limited to ~10 ps per day on 1,000 cores — 10⁸× too slow.
**Quantum speedup:** If each energy/force evaluation runs in milliseconds on quantum hardware (vs. seconds on classical DFT), QMD trajectories extend from picoseconds to nanoseconds per day. With enhanced sampling (metadynamics), free energy surfaces become accessible.

---

## 4. Parameter Space

| Parameter | Values | Configs |
|---|---|---|
| Capping ligand | Oleate, oleylamine, DDAB, sulfobetaine, ODPA, mixed | 15 combinations |
| Surface termination | CsBr, PbBr₂, mixed | 4 |
| Defect density (Br vacancies) | 0%, 2%, 5%, 10% | 4 |
| Water coverage | 0-2 ML | 5 |
| Temperature | 300K, 350K (accelerated aging) | 2 |
| **Total configurations** | — | **2,400** |

---

## 5. Classical Feasibility Assessment

- AIMD on 300-atom system with PBE functional: ~2 ps/day on 500 cores
- 2,400 configurations × 1 ns each = 2.4 μs total
- Classical time to 2.4 μs: **3,300,000 node-years — intractable**

**Quantum advantage:** Even 100× speedup from quantum-accelerated force evaluation makes nanosecond trajectories routine. With metadynamics, free energy barriers can be mapped in weeks.

---

## 6. Expected Quantum Advantage

| Metric | Current | Quantum Target |
|---|---|---|
| Ligand binding free energy ΔG_bind | Unknown (qualitative) | Quantitative ± 1 kcal/mol |
| Hydrolysis barrier ΔG‡ | 15-20 kcal/mol (est.) | >25 kcal/mol (target) |
| Degradation lifetime (85°C/85%RH) | ~1,000 hours | >50,000 hours |
| Ligand cost per m² coating | $0.02 (oleate) | $0.05-0.15 (optimized ligand) |

---

## 7. Partner Requirements

- **Qubit count:** ≥ 200 logical qubits for DFT-VQE on 300-400 atom systems
- **Quantum methods:** DFT-VQE, quantum-accelerated MD, quantum metadynamics
- **Classical integration:** CP2K/Quantum ESPRESSO interface; PLUMED for enhanced sampling
- **Expertise:** Perovskite surface chemistry; ligand binding DFT; metadynamics/free energy methods

---

## 8. Deliverables and Timeline

| Phase | Deliverable | Timeline |
|---|---|---|
| Phase 1 | Benchmark QMD water/CsPbBr₃ interface vs. classical AIMD | Months 1-4 |
| Phase 2 | Calculate ΔG‡ for water-induced degradation with oleate ligands | Months 4-7 |
| Phase 3 | Screen 15 candidate ligand combinations; identify top 5 | Months 7-11 |
| Phase 4 | Full free energy profile for top candidates; predict lifetime | Months 11-15 |
| Phase 5 | CSM synthesis and accelerated aging (85°C/85%RH) validation | Months 15-18 |

---

*Document prepared by: Director Kairos Steele, CITADEL [DIRECTOR-001] | with QD photophysics informed by the enthusiastic precision of Agent Solara Vance (perovskite solar/QD expertise), the quantum MD methodology of Dr. Theron Nash, and the encapsulation chemistry of Engineer Orion Cross — Aegis Operations, Carrington Storm Motors*

*CSMQuantum Series 004 | Version 1.0 | July 2026*
*© 2026 Carrington Storm Motors / Safe Pod Engineering Company. All rights reserved.*
