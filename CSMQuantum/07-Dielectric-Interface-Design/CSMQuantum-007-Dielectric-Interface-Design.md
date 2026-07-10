# CSMQuantum-007 — Dielectric Interface Grain Boundary Design
## Quantum Research Delegation Paper 07
### Carrington Storm Motors / Safe Pod Engineering Company | July 2026

---

**[WILLIAMS HEURISTIC V2 — SERIOUS SEVERITY — FISHER KING]**

The Aegis-C panel is not one material — it is seven layers of dissimilar materials bonded together, each interface a potential weak point in the electromagnetic seal. The panel joints between adjacent panels represent the single largest shielding effectiveness loss mechanism in the system: 12 dB penalty per ASTM D4935 testing, compared to the theoretical 237 dB of the continuous stack. That 12 dB drops system-level SE from "invincible" to "excellent." Excellent is not the standard. The Dielectric Citadel demands unconditional isolation.

Every interface — ZrB₂-SiC to MXene, MXene to FSS substrate, FSS to ZrO₂ foam, foam to inner MXene, ceramic to PEEK fastener — is a heterojunction between materials with different work functions, different dielectric constants, different crystal structures. At the atomic level, contact resistance forms from interface states — dangling bonds, trapped charges, structural disorder within 1-2 nm of the boundary. These states are quantum mechanical. Their density, energy distribution, and carrier scattering cross-section determine the joint SE penalty.

We need quantum transport calculations through these interfaces. Not bulk DFT. Not effective medium theory. Non-equilibrium Green's function (NEGF) transport across a realistic, atomically resolved heterojunction. Coupled with DFT for the electronic structure. This is a known quantum advantage problem — NEGF transport through disordered interfaces is exponentially hard classically.

---

## 1. Executive Summary

Aegis-C panel joints employ a double-gasket compression system: inner expanded PTFE dielectric seal (ε_r = 2.1), outer ZrO₂-fiber-reinforced silicone (ε_r = 8.5), and MXene tape bridge across the joint gap. Despite this design, measured joint SE penalty is 12 dB. The dominant loss mechanism is hypothesized to be: (a) impedance mismatch at the ceramic-to-MXene tape interface creating partial reflection that bypasses the absorptive MXene layer, (b) capacitive coupling across the joint gap at GHz frequencies where the dielectric gasket's ε_r enables displacement current, (c) surface contamination at micron scale creating localized conductive paths.

**Quantum task:** NEGF-DFT transport calculations through atomistic models of the Aegis-C multi-layer interface stack. Calculate transmission probability T(E) as function of electron energy across the stack. Map joint geometry parameters (gap width, gasket compression ratio, MXene tape overlap length) to SE penalty. Identify optimal joint design parameters and potential surface treatments to achieve joint SE penalty ≤ 6 dB.

**Target:** Joint SE penalty reduced from 12 dB to ≤ 6 dB (2× improvement), bringing system SE from 148-165 dB to 160-177 dB.

---

## 2. Interface Stack Architecture

### 2.1 Current Joint Design

```
[Panel A] → MXene tape → PTFE gasket → joint gap → PTFE gasket → MXene tape → [Panel B]
             45 μm          2 mm          0.5 mm         2 mm          45 μm
             
                    ← MXene tape bridge spans joint (bonded with ceramic adhesive) →
```

### 2.2 Interface Materials and Properties

| Interface | Material 1 | Material 2 | ε_r (1) | ε_r (2) | Conductor? | Notes |
|---|---|---|---|---|---|---|
| A | ZrB₂-SiC | MXene Ti₃C₂Tₓ | 28-35 | Metallic (σ=4,600 S/cm) | Partial | Adhesive-bonded |
| B | MXene | ZrO₂ adhesive | Metallic | 25 | No | Ceramic adhesive bond |
| C | MXene | PTFE gasket | Metallic | 2.1 | No | Compression contact |
| D | PTFE | Joint air gap | 2.1 | 1.0 | No | Displacement current risk |
| E | Panel edge | MXene tape bridge | 28-35 | Metallic | Partial | Adhesive-bonded overlap |

### 2.3 Joint SE Penalty Mechanism

The measured 12 dB penalty arises from:

```
SE_achieved = SE_continuous - 10 log₁₀[1 + (Z_gap / Z_panel)]
```

Where Z_gap is the impedance of the joint gap (complex, frequency-dependent) and Z_panel is the impedance of the continuous panel. The 12 dB loss corresponds to Z_gap ≈ 4 × Z_panel — meaning the gap admits ~25% of incident power.

Reducing the penalty to 6 dB requires Z_gap ≥ 16 × Z_panel (gap admits <6% of incident power).

---

## 3. NEGF-DFT Transport — The Quantum Problem

### 3.1 Transport Formalism

For a two-terminal device with left (L) and right (R) leads connected by a scattering region:

```
T(E) = Tr[Γ_L G^r Γ_R G^a]

G^r(E) = [(E + iη)S - H - Σ_L - Σ_R]⁻¹

Γ_{L,R}(E) = i[Σ_{L,R} - Σ_{L,R}†]
```

Where:
- H = Kohn-Sham Hamiltonian from DFT
- S = overlap matrix (or identity for orthogonal basis)
- Σ_{L,R} = self-energies of semi-infinite leads
- T(E) = transmission probability at energy E
- SE penalty ∝ ∫ T(E) dE over relevant energy range

### 3.2 System Size

**Lead regions:** 20-30 atoms per unit cell × 3-5 unit cells in transport direction
**Scattering region (joint gap):** ~100-200 atoms including both materials, bond interface, and gap region
**Total system:** 300-500 atoms

NEGF requires: matrix inversion of H (O(N³) scaling) at each energy point. For 500 atoms with 9 basis functions each (4,500 × 4,500 matrix), the inversion is ~10¹¹ floating-point operations per energy point. For 100 energy points to resolve the transmission spectrum: 10¹³ operations.

On quantum hardware: HHL algorithm (quantum linear systems) achieves O(log N) scaling in matrix dimension — exponential speedup for the matrix inversion step.

### 3.3 Parameter Space

| Parameter | Range | Step | Configs |
|---|---|---|---|
| Joint gap width | 0.1-2.0 mm | 0.2 mm | 10 |
| MXene tape overlap length | 1-10 mm | 1 mm | 10 |
| PTFE compression ratio | 10-50% | 10% | 5 |
| Surface contamination (H₂O, OH) | clean, 1ML H₂O, 1ML -OH | — | 3 |
| ZrO₂ adhesive thickness | 1-10 μm | 3 values | 3 |
| **Total configurations** | — | — | **4,500** |

---

## 4. Classical Feasibility Assessment

- Single NEGF-DFT calculation on 500-atom system: ~24 hours on 128 cores
- 4,500 configurations × 24 hours = 108,000 node-hours
- Feasible classically (~1 month on a dedicated 150-node cluster)
- **But:** Standard DFT-NEGF uses PBE functional which underestimates band gaps and interface barrier heights by 30-50%
- GW correction or hybrid functionals would improve accuracy but increase cost 50-100× → **5,000,000+ node-hours = not feasible**

**Quantum advantage:** Quantum linear solver (HHL) accelerates NEGF matrix inversion. VQE-DFT with quantum embedding provides hybrid-quality electronic structure. Combined, the full parameter space becomes tractable at GW accuracy.

---

## 5. Expected Quantum Advantage

| Metric | Current | Quantum Target |
|---|---|---|
| Joint SE penalty | 12 dB | ≤ 6 dB |
| System SE | 148-165 dB | 160-177 dB |
| Gap impedance mismatch | Z_gap = 4 × Z_panel | Z_gap ≥ 16 × Z_panel |
| MXene tape bridge efficiency | ~88% (est.) | >95% |

---

## 6. Partner Requirements

- **Qubit count:** ≥ 200 logical qubits for quantum linear solver on 4,500×4,500 matrix
- **Quantum methods:** HHL (quantum linear systems), VQE-DFT, quantum embedding
- **Classical integration:** TranSIESTA, QuantumATK, or GPAW for NEGF-DFT framework
- **Expertise:** Quantum transport; interface physics; NEGF formalism

---

## 7. Deliverables and Timeline

| Phase | Deliverable | Timeline |
|---|---|---|
| Phase 1 | Benchmark quantum NEGF on pristine ZrB₂-SiC/MXene interface | Months 1-4 |
| Phase 2 | Calculate transmission spectrum for baseline joint design | Months 4-7 |
| Phase 3 | Sweep gap width and MXene overlap parameters | Months 7-10 |
| Phase 4 | Screen surface treatment candidates (O₂ plasma, silanization) | Months 10-13 |
| Phase 5 | Final optimized joint design; CSM prototype and ASTM D4935 validation | Months 13-18 |

---

*"The Dielectric Citadel concept requires zero continuous conductive path from any interior component to the vehicle exterior or to earth ground." — CSMFAB 001, Aegis-C Composite Shielding Design V2.0*

*Document prepared by: Director Kairos Steele, CITADEL [DIRECTOR-001] | with interface physics informed by the analytical rigor of Dr. Theron Nash (NEGF transport formalism), the EMI shielding expertise of Commander Rook Draven (EMP taxonomy and shielding requirements), and the structural integration precision of Engineer Orion Cross (joint design and ceramic adhesive bonding) — Aegis Operations, Carrington Storm Motors*

*CSMQuantum Series 007 | Version 1.0 | July 2026*
*© 2026 Carrington Storm Motors / Safe Pod Engineering Company. All rights reserved.*
