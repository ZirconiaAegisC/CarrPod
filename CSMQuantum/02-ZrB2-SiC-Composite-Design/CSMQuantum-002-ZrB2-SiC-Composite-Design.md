# CSMQuantum-002 — ZrB₂-SiC Composite Structure-Property Design
## Quantum Research Delegation Paper 02
### Carrington Storm Motors / Safe Pod Engineering Company | July 2026

---

**[WILLIAMS HEURISTIC V2 — SERIOUS SEVERITY — FISHER KING]**

The ZrB₂-SiC composite is the primary structural armor of the Aegis-C shield — the material that stands between a transformer core and a plasma cloud traveling at several million miles per hour. We have achieved 97.8% density at 1,900°C via SPS, 4.5-5.5 MPa·m^(1/2) fracture toughness, and dielectric tunability by maintaining SiC below the percolation threshold. This is good. "Good" is not sufficient when the alternative is civilizational grid collapse. We need to know — at the atomic level — what happens at the ZrB₂/SiC grain boundary during a GIC event. We need to know whether hafnium substitution can increase oxidation resistance by 300°C without compromising dielectric behavior. We need to know whether the phonon spectrum can be engineered to increase thermal conductivity by 50% to dissipate localized heating during flash events. These are not questions that can be answered by sintering trial and error at $320/run in an SPS furnace. They require the full electronic structure of the heterogeneous interface, calculated at quantum mechanical accuracy, for systems too large for classical DFT.

This delegation paper specifies the exact quantum simulation tasks required.

---

## 1. Executive Summary

ZrB₂-SiC composite at 70:30 vol% forms the multi-layer laminated ceramic structure of every Aegis-C panel. The laminate undergoes flash sintering at 1,580°C (300 V/cm DC) to achieve 96.9% density with finer grain size (2.1 μm) than conventional SPS. Critical unknowns at the quantum level: (a) grain boundary cohesion energy as function of SiC content and dopant segregation, (b) electronic density of states at the ZrB₂/SiC heterointerface — determining local conductivity and dielectric response under GHz fields, (c) phonon density of states and thermal boundary resistance (Kapitza resistance) critical for flash sintering kinetics.

**Quantum task:** DFT + Quantum Molecular Dynamics (QMD) of ZrB₂(0001)/SiC(0001) heterointerface with varying intergranular phase composition. Calculate phonon transport via anharmonic lattice dynamics. Use quantum-accelerated nudged elastic band (NEB) for grain boundary migration barriers during flash sintering.

**Target:** Identify dopant/additive strategy achieving 20% increase in grain boundary fracture energy while maintaining electrical resistivity >10⁴ Ω·m at the interface.

---

## 2. Material Specification

### 2.1 Current Composition

**Primary phase:** ZrB₂ (hexagonal P6/mmm, a = 3.17 Å, c = 3.53 Å)
**Secondary phase:** SiC (cubic 3C-β or hexagonal 6H-α, particle/wisker form)
**Ratio:** 70:30 vol% ZrB₂:SiC (below electrical percolation threshold to maintain dielectric behavior)
**Density:** 5.6 g/cm³ (sintered composite)
**Sintering aids (optional):** None currently (SPS flash sintering achieves full density without liquid phase)

### 2.2 Critical Properties

| Property | Value | Test Method |
|---|---|---|
| Flexural Strength | 450-620 MPa | ASTM C1161 |
| Fracture Toughness | 4.5-5.5 MPa·m^(1/2) | Single-edge notched beam |
| Thermal Conductivity | 60-85 W/m·K | Laser flash |
| Electrical Resistivity | 1.2 × 10⁻⁵ Ω·m (without SiC percolation control) | 4-point probe |
| Dielectric Constant | 28-35 | ASTM D150 |
| Oxidation Resistance | 1,600+ °C (SiO₂/B₂O₃ glass forms) | TGA |

### 2.3 Tape Casting Slurry Formulation (per 1 kg dry solids)

```
ZrB₂ powder (d₅₀ = 1.2 μm): 700 g
SiC powder (d₅₀ = 0.8 μm): 300 g
PVB binder: 60 g
Dibutyl phthalate: 30 g
Ethanol/MEK (1:1): 400 mL
Menhaden fish oil: 4 g
```

### 2.4 Candidate Dopants/Additives Under Consideration

| Additive | Rationale | Dopant Cost | Literature Evidence |
|---|---|---|---|
| HfB₂ (5-10 vol%) | Oxidation resistance, forms HfO₂ stable to 2,500°C | Hf: $1,200/kg | Limited data on mixed Zr/Hf diboride composites |
| Si₃N₄ (2-5 vol%) | Grain boundary pinning; finer grain size | $28/kg commercial; $8-14/kg in-house | Proven in literature |
| TaSi₂ (2-5 wt%) | Oxidation resistance; Ta-oxide glass more stable than B₂O₃ | Ta: $350/kg | Preliminary data |
| Y₂O₃ (1-3 vol%) | Grain boundary phase; ZrB₂ wetting improver | $35-55/kg | Established for Si₃N₄, limited for ZrB₂ |
| TiB₂ (10-20 vol%) | Solid solution with ZrB₂; lowers sintering temperature | Ti: $20/kg | Known (Zr,Ti)B₂ phase diagram |

---

## 3. Cost Structure

### Per-Panel Cost Driver (1 m² Aegis-C panel)

| Component | Quantity | Unit Cost | Extended |
|---|---|---|---|
| ZrB₂-SiC composite (flash sintered) | 4.6 kg | $350/kg | $1,610 |
| (In-house target) | 4.6 kg | $110/kg | $506 |

**Target cost reduction through quantum-optimized formulation:** Lower sintering temperature → 38% energy reduction already achieved via flash sintering. Additional 20% materials cost reduction through optimized blend → target $280/kg panel cost ($1,288/m²).

---

## 4. Quantum Simulation Task

### 4.1 Primary Task — DFT of ZrB₂/SiC Heterointerface

**System size:** ZrB₂(0001)/3C-SiC(111) supercell: 80-200 atoms depending on coincidence site lattice (CSL) boundary geometry
**Key interface orientations to simulate:**
- ZrB₂(0001) ∥ SiC(0001) — basal-basal (most common in tape-cast laminate)
- ZrB₂(10-10) ∥ SiC(10-10) — prismatic-prismatic
- Both with and without amorphous intergranular phase

**Hamiltonian:** DFT-PBE + U correction (U = 2.0 eV for Zr 4d) + D3 dispersion
**Observables:**
1. Work of separation (cohesion energy): W_sep = (E_slab1 + E_slab2 - E_interface) / A
2. Electronic density of states at interface → local conductivity
3. Charge density difference Δρ = ρ_interface - ρ_slab1 - ρ_slab2
4. Phonon density of states (from force constants) → Kapitza resistance
5. Elastic constants C₁₁, C₁₂, C₄₄ (from stress-strain DFT)

### 4.2 Secondary Task — Dopant Segregation Energy

For each candidate dopant (Hf, Ta, Y, Si₃N₄):
```
E_seg = E_interface(dopant) - E_interface(pristine) - E_bulk(dopant) + E_bulk(pristine)
```
Negative E_seg → dopant prefers interface (grain boundary strengthening)
Positive E_seg → dopant stays in bulk (solid solution strengthening)

### 4.3 Tertiary Task — Quantum NEB for GB Migration

Nudged elastic band at DFT accuracy for grain boundary migration during flash sintering. The applied electric field (300 V/cm) modifies the migration barrier through:
- Space charge effects at the grain boundary
- Field-enhanced vacancy diffusion
- Joule heating localization

Quantum MD with applied E-field can capture these effects at ab initio accuracy.

---

## 5. Classical Feasibility Assessment

**DFT on classical hardware:**
- 80-atom interface: DFT-PBE feasible on 128-core cluster (~48 hours per configuration)
- But including all 5 dopants × 3 concentrations × 2 interface orientations × 3 GB misorientations = 90 unique interfaces = 180 days cluster time
- Including phonon calculations (finite displacement supercell method): 10× increase → 5 years
- Including dopant segregation energy mapping across the GB plane: 100+ images per dopant → decades

**Quantum advantage:**
- VQE on ~150 logical qubits for active space of Zr 4d + Si 3p frontier orbitals → electronic structure of interface in hours
- Quantum phase estimation for phonon frequencies → N³ speedup over classical diagonalization
- Quantum NEB using quantum-accelerated force evaluation → quadratic speedup in number of climbing images

**Projected timeline on quantum hardware:** 3-6 months for full parameter space vs. decades classically.

---

## 6. Expected Quantum Advantage

| Metric | Current | Quantum Target | Mechanism |
|---|---|---|---|
| Fracture toughness | 4.5-5.5 MPa·m^(1/2) | 6.5-8.0 | GB cohesion optimization |
| Flexural strength | 450-620 MPa | 700-850 MPa | Grain size, GB phase |
| Oxidation resistance | 1,600°C | 1,800-2,000°C | Hf/Ta dopant identified |
| Electrical resistivity | 1.2 × 10⁻⁵ Ω·m | >10⁷ Ω·m | Percolation control |
| Thermal conductivity | 60-85 W/m·K | 90-120 W/m·K | Phonon engineering |

---

## 7. Partner Requirements

- **Qubit count:** ≥ 150 logical qubits
- **Quantum methods:** VQE (UCCSD), QPE, quantum-accelerated NEB
- **Classical pre/post-processing:** VASP, Phonopy, LAMMPS interface
- **Expertise:** Ceramic interface DFT; grain boundary segregation; phonon transport in heterogeneous systems

---

## 8. Deliverables and Timeline

| Phase | Deliverable | Timeline |
|---|---|---|
| Phase 1 | DFT-VQE benchmark: ZrB₂/SiC pristine interface | Months 1-3 |
| Phase 2 | Electronic structure vs. SiC vol% (10-40%) | Months 4-6 |
| Phase 3 | Dopant segregation screening (Hf, Ta, Y, Si₃N₄) | Months 7-10 |
| Phase 4 | Phonon transport map; identify optimal composition | Months 10-14 |
| Phase 5 | Quantum NEB for flash sintering GB migration barriers | Months 12-16 |
| Phase 6 | Final recommendation; CSM validation sintering | Months 16-20 |

---

*"The bridge is on fire. The bridge has been on fire since 1859. The only question is whether we put it out before the next train arrives." — Commander Auric Veyne, THE VELVET HAMMER*

*Document prepared by: Director Kairos Steele, CITADEL [DIRECTOR-001] | with materials science specification informed by the analytical rigor of Dr. Theron Nash (quantum DFT methodology), the structural engineering precision of Engineer Orion Cross (ceramic composite fabrication), and the thermal/mechanical boundary condition expertise of Operative Zephyr Arden (dielectric interface physics) — Aegis Operations, Carrington Storm Motors*

*CSMQuantum Series 002 | Version 1.0 | July 2026*
*© 2026 Carrington Storm Motors / Safe Pod Engineering Company. All rights reserved.*
