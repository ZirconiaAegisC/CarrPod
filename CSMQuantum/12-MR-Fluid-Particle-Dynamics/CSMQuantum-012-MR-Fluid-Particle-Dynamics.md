# CSMQuantum-012 — MR Fluid Particle Surface Dynamics
## Quantum Research Delegation Paper 12
### Carrington Storm Motors / Safe Pod Engineering Company | July 2026

---

**[WILLIAMS HEURISTIC V2 — ROUTINE SEVERITY — MORK MORNING]**

Magnetorheological fluids are the muscle memory of the Aegis-C vehicle systems. They stiffen on command — apply a magnetic field, and within milliseconds, a liquid becomes a viscoelastic solid capable of transmitting torque, absorbing impact, or dampening vibration. The Bio-Sync magnetic integration system uses MR fluid in haptic insoles, adaptive seat rails, neural-grip steering wheels, and impact-dampening seatbelts. At $250-300/kg commercial (LORD MRF-140CG), the fluid is expensive. At $25-40/kg in-house (from BASF carbonyl iron powder and hydrocarbon carrier oil), it is transformative — an 85-90% cost reduction.

The key performance metric is yield stress — the stress at which the field-structured particle chains begin to flow. Current MRF-140CG achieves 80 kPa at 250 kA/m. The theoretical maximum for 80 vol% carbonyl iron in hydrocarbon oil is approximately 120-150 kPa. The gap between measured and theoretical derives from: (a) imperfect particle surface treatment leading to aggregation and non-uniform chain formation, (b) oxidation of iron particle surfaces reducing effective magnetic moment, (c) particle size polydispersity creating chain defects.

The surface chemistry of carbonyl iron particles — what molecules bond to the iron surface, how they affect inter-particle forces, whether they prevent oxidation while permitting magnetic alignment — is quantum mechanical. The Fe(110) surface with adsorbed silane coupling agents, surfactants, or anti-oxidant coatings requires DFT to model accurately. Classical force fields cannot capture the Fe-O-Si bond formation or the spin polarization that determines magnetic moment at the surface.

---

## 1. Executive Summary

MR fluids consist of carbonyl iron particles (CIP, 7-10 μm diameter, 80-85 vol%) suspended in hydrocarbon carrier oil with fumed silica stabilizers and surfactants. Under magnetic field, particles align into chains, increasing yield stress from ~0 to 80 kPa within milliseconds. The in-house formulation from BASF CIP ($12/kg) plus oil, silica, and dispersant achieves $25-40/kg vs. $250-300/kg commercial — an 85-90% savings. However, in-house yield stress may be lower than LORD's proprietary formulation due to unknown surface treatment chemistry.

**Quantum task:** DFT-VQE calculation of carbonyl iron (α-Fe) surface interaction with candidate surfactant molecules (oleic acid, stearic acid, trimethoxy silanes, phosphate esters). Calculate adsorption energy, surface magnetic moment perturbation, and work of adhesion. Screen 20-30 surfactant candidates for: (a) maximum adsorption energy (prevents desorption under shear), (b) minimum magnetic moment reduction (maintains particle magnetization), (c) steric stabilization against aggregation.

**Target:** Identify surfactant package achieving yield stress ≥ 100 kPa at 250 kA/m in in-house formulation (25% improvement over LORD baseline).

---

## 2. Material Specification

### 2.1 Carbonyl Iron Particles (CIP)

**Source:** BASF Carbonyl Iron Powder (CIP), grade CC or CN
**Production:** Fe(CO)₅ → thermal decomposition at 250-300°C → spherical CIP
**Particle size:** d₅₀ = 4-7 μm (standard), d₅₀ = 7-10 μm (MR fluid grade)
**Magnetic properties (bulk α-Fe):**
- Saturation magnetization M_s = 218 emu/g (2.15 T)
- Coercivity H_c < 5 Oe (soft magnetic)
- Curie temperature T_c = 770°C

### 2.2 MR Fluid Formulation

| Component | wt% | Function | Cost/kg |
|---|---|---|---|
| Carbonyl iron (BASF CC) | 86% | Magnetic particles | $12 |
| Hydrocarbon carrier oil | 10% | Continuous phase | $2 |
| Fumed silica (Aerosil 200) | 2% | Anti-settling, thixotrope | $5 |
| Surfactant/dispersant | 2% | Particle surface treatment | $8-15 |
| **Total (in-house)** | **100%** | — | **$25-40** |

### 2.3 Target Performance

| Property | LORD MRF-140CG | In-House Target |
|---|---|---|
| Yield stress at 250 kA/m | 80 kPa | ≥ 100 kPa |
| Off-state viscosity at 40°C | 0.28 Pa·s | 0.20-0.35 Pa·s |
| Operating temperature | -40 to +130°C | Same |
| Sedimentation stability | < 5% per month | < 5% per month |

---

## 3. Quantum Simulation Task

### 3.1 Iron Surface Model

**Surface:** α-Fe(110) — the most stable and most common exposed surface for BCC iron
**Slab model:** 4-layer Fe slab, 3×3 surface unit cell (9 surface Fe atoms per layer), 15 Å vacuum
**Total atoms:** 36 Fe atoms

### 3.2 Surfactant Adsorption DFT

For each candidate surfactant, calculate:

**Adsorption energy:**
```
E_ads = E(Fe_slab + surfactant) - E(Fe_slab) - E(surfactant_gas)
```
Negative E_ads → favorable binding. Target: E_ads < -1.5 eV (strong chemisorption).

**Surface magnetic moment perturbation:**
```
Δμ = μ(Fe_surface with surfactant) - μ(clean Fe_surface)
```
Target: |Δμ/μ| < 5% (surfactant does not significantly demagnetize surface Fe atoms).

**Work of adhesion between coated particles:**
```
W_adhesion = [E(2 isolated coated slabs) - E(2 contacting coated slabs)] / (2 × A_contact)
```
This determines the off-state inter-particle force that must be overcome for chain formation.

### 3.3 Candidate Surfactant Molecules

| Surfactant | Binding Group | Chain Length | Expected Binding Mode | Cost/kg |
|---|---|---|---|---|
| Oleic acid | -COOH | C18 | Monodentate or bidentate carboxylate | $3 |
| Stearic acid | -COOH | C18 (saturated) | Monodentate carboxylate | $2.50 |
| Octyltrimethoxysilane | -Si(OCH₃)₃ | C8 | Tridentate Si-O-Fe bonds | $15 |
| Octadecyltrimethoxysilane (ODTMS) | -Si(OCH₃)₃ | C18 | Tridentate Si-O-Fe bonds | $25 |
| Phenylphosphonic acid | -PO₃H₂ | C6 aromatic | Tridentate or bidentate phosphonate | $40 |
| Polyisobutylene succinimide (PIBSI) | -NH-CO- | Polymer | Multiple weak interactions | $8 |
| Oleylamine | -NH₂ | C18 | N-Fe dative bond | $5 |

### 3.4 Observable Prediction

From DFT-calculated adsorption geometries, predict:
1. Equilibrium inter-particle spacing in field-aligned chains → chain stiffness
2. Surface energy of coated particles → aggregation tendency
3. Magnetic coupling between particles in chain → field-induced yield stress via dipole-dipole model:

```
τ_y ∝ φ × μ₀ × M_s² × f(spacing, alignment)
```

Where φ is volume fraction and f(spacing, alignment) derives from the DFT-calculated inter-particle geometry.

---

## 4. Classical Feasibility Assessment

- DFT-PBE on 36-atom Fe slab + surfactant: ~8 hours per configuration on 64 cores
- Spin-polarized calculation (required for Fe): 2× cost = 16 hours per config
- 25 surfactant candidates × 3 surface coverages (0.25, 0.5, 1.0 ML) = 75 configurations
- 75 × 16 hours = 1,200 node-hours classically
- **Classically tractable** — this is the most tractable problem in the CSMQuantum portfolio
- **Quantum advantage:** Primarily in accuracy — VQE can approach coupled-cluster accuracy for the Fe-surfactant bond, which PBE systematically underbinds for open-shell transition metal systems (typical error: 0.3-0.5 eV in adsorption energy)

---

## 5. Expected Quantum Advantage

| Metric | Classical DFT (PBE) | VQE-DFT | Advantage |
|---|---|---|---|
| Adsorption energy accuracy | ±0.4 eV (underbinding) | ±0.05-0.1 eV | Reliable ranking of surfactants |
| Surface magnetic moment | Qualitative (±15%) | Quantitative (±2%) | Correct prediction of magnetization loss |
| Ranking reliability | May mis-order top candidates | Correct ordering | Avoids false negative (discarding good surfactant) |

---

## 6. Partner Requirements

- **Qubit count:** ≥ 150 logical qubits for VQE on 36-atom Fe(110) slab + surfactant
- **Quantum methods:** VQE (UCCSD), spin-polarized DFT
- **Classical integration:** VASP (spin-polarized DFT reference); classical MD with DFT-derived force field for particle dynamics
- **Expertise:** Transition metal surface chemistry; magnetic materials DFT; surfactant/colloid science

---

## 7. Deliverables and Timeline

| Phase | Deliverable | Timeline |
|---|---|---|
| Phase 1 | Benchmark VQE on clean Fe(110) surface — magnetic moment, work function | Months 1-3 |
| Phase 2 | Adsorption energies for 7 baseline surfactant candidates | Months 4-6 |
| Phase 3 | Magnetic moment perturbation screening; identify top 5 surfactants | Months 6-8 |
| Phase 4 | Coverage-dependent study on top 5; inter-particle force prediction | Months 8-10 |
| Phase 5 | CSM MR fluid formulation with top 3 surfactants; rheometer validation | Months 10-14 |

---

*"Yield stress is the single number that matters. Everything else is oil." — from the CSMFAB MR fluid development sessions*

*Document prepared by: Director Kairos Steele, CITADEL [DIRECTOR-001] | with magnetic materials DFT informed by the analytical precision of Dr. Theron Nash (spin-polarized VQE methodology), the MR fluid formulation expertise of Engineer Orion Cross (CIP processing, surfactant chemistry, rheology), and the surface chemistry perspective of Dr. Lyra Kade (iron-surfactant bond characterization) — Aegis Operations, Carrington Storm Motors*

*CSMQuantum Series 012 | Version 1.0 | July 2026*
*© 2026 Carrington Storm Motors / Safe Pod Engineering Company. All rights reserved.*
