# CSMQuantum-005 — Aerogel Network Topology Optimization
## Quantum Research Delegation Paper 05
### Carrington Storm Motors / Safe Pod Engineering Company | July 2026

---

**[WILLIAMS HEURISTIC V2 — ROUTINE SEVERITY — MORK MORNING]**

Aerogel is the thermal soul of the Aegis-C panel — 25 mm of ZrO₂ ceramic foam core between the MXene shielding layers, providing both thermal insulation and dielectric isolation. The polyimide-silica hybrid aerogel we use achieves λ = 0.010 W/m·K at 650°C service temperature, at $200-280/m² commercial ($55-85/m² in-house). That is astonishingly good. But it is not optimal.

Aerogel thermal conductivity has three components: solid backbone conduction, gas-phase conduction (in nanopores), and radiative transport. The solid backbone — the interconnected silica-polyimide network — is a fractal structure whose topology determines the phonon mean free path. Shorter mean free path = lower thermal conductivity. But the relationship between synthesis conditions (precursor concentration, gelation pH, aging time, drying method) and network topology is purely empirical today. We do not know, at the molecular level, what sol-gel chemistry produces the most tortuous, least thermally conductive network.

This is a graph optimization problem disguised as a chemistry problem. And graph optimization on disordered 3D networks is precisely the kind of constraint satisfaction problem that quantum annealing excels at.

---

## 1. Executive Summary

The polyimide-silica hybrid aerogel core of the Aegis-C panel provides thermal insulation and dielectric isolation at 25 mm thickness. Current performance (λ = 0.010 W/m·K) is near the best commercial aerogels but far from the theoretical minimum (~0.004 W/m·K for silica at ambient pressure). The gap between measured and theoretical thermal conductivity derives from: (a) suboptimal pore size distribution allowing gas-phase conduction, (b) insufficient backbone tortuosity allowing phonon transport, (c) residual -OH groups on silica surface enabling hydrogen-bonded water adsorption.

**Quantum task:** Model the aerogel backbone as a network graph. Use quantum annealing to optimize the 3D network topology for minimum phonon mean free path subject to mechanical integrity constraints. Validate with phonon transport calculations using DFT force constants. Identify the synthesis conditions (precursor ratios, gelation pH, aging temperature, drying protocol) that produce the optimized topology.

**Target:** λ ≤ 0.007 W/m·K at ambient pressure (30% reduction from current 0.010), maintaining flexural strength ≥ 1.5 MPa.

---

## 2. Material Specification

### 2.1 Current Aerogel System

**Type:** Polyimide-silica hybrid (PMDA-ODA polyimide + TEOS-derived silica)
**Synthesis:** Sol-gel co-polymerization → aging → solvent exchange → supercritical CO₂ drying
**Performance:**

| Property | Value |
|---|---|
| Thermal conductivity (λ) | 0.010 W/m·K |
| Density | 0.12-0.18 g/cm³ |
| Porosity | 88-94% |
| Mean pore diameter | 15-25 nm |
| Surface area (BET) | 600-900 m²/g |
| Max service temperature | 650°C |
| Flexural strength | 1.2-2.5 MPa |

### 2.2 Cost Structure (per m², 25 mm blanket)

| Component | Commercial ($) | In-House ($) |
|---|---|---|
| TEOS (silica precursor) | $12 | $4 |
| PMDA-ODA (polyimide precursor) | $85 | $30 |
| Solvent (ethanol, acetone) | $15 | $8 |
| Supercritical CO₂ drying (energy) | $45 | $25 |
| Labor + overhead | $65 | $20 |
| **Total** | **$200-280** | **$55-85** |

### 2.3 Alternative Aerogel Chemistries Under Consideration

| Chemistry | λ (W/m·K) | Max Temp (°C) | Cost/m² | Notes |
|---|---|---|---|---|
| Silica (TEOS) — baseline | 0.015 | 600 | $120-180 | Brittle; well-established |
| Polyimide-silica hybrid (current) | 0.010 | 650 | $200-280 | Best balance of λ and strength |
| CNC (cellulose nanocrystal) | 0.018 | 250 | $25-45 (in-house) | Bio-based; pet-safe |
| Alumina (Al₂O₃) | 0.029 | 1,000+ | $250-400 | Extreme temperature |
| Carbon (graphene) | 0.014 | 500 (inert) | $350-600 | Electrically conductive — NO |
| BN (boron nitride) | 0.016 | 900 | $300-500 | Dielectric, good temp range |

---

## 3. Network Topology Optimization — The Quantum Problem

### 3.1 Aerogel as a Constraint Satisfaction Problem

The aerogel backbone is a disordered 3D network of interconnected silica and polyimide struts. Its thermal conductivity can be expressed as:

```
λ_total = λ_solid + λ_gas + λ_rad

λ_solid ∝ (ρ/ρ_bulk)^n × (1/τ)
```

Where τ is the tortuosity — the ratio of actual path length to linear distance. Higher τ = longer phonon path = lower effective solid conductivity. The problem is to maximize τ subject to:
- Minimum connectivity: percolation threshold (struts must form a connected network)
- Minimum strut thickness: d_min ≥ 2 nm (silica chain width)
- Maximum density: ρ_max ≤ 0.15 g/cm³ (weight constraint for vehicle application)
- Mechanical constraint: network must support compressive stress ≥ 0.5 MPa

### 3.2 Mapping to Quantum Annealing

The aerogel structure can be discretized as a 3D lattice graph (e.g., 100³ voxels = 10⁶ nodes). Each voxel is either solid (silica/polyimide) or void (pore). The optimization is a binary constraint satisfaction problem:

```
H = H_tortuosity + λ₁·H_connectivity + λ₂·H_mechanics + λ₃·H_density

H_tortuosity = maximize (favor long, winding paths)
H_connectivity = penalize disconnected clusters
H_mechanics = penalize structures with low compressive stiffness
H_density = penalize structures exceeding ρ_max
```

This maps naturally to a QUBO (Quadratic Unconstrained Binary Optimization) formulation solvable on quantum annealers (D-Wave) or via QAOA on gate-model quantum computers.

### 3.3 Phonon Transport Validation

Once the optimized network topology is identified, the predicted λ_solid must be validated with DFT-calculated force constants on representative strut junctions. Phonon Boltzmann transport equation (BTE) solved via DFT + anharmonic lattice dynamics:

```
κ = Σ_λ ∫ C_λ(ω) · v_λ(ω)² · τ_λ(ω) dω
```

Quantum VQE enables DFT force constant calculations on 50-100 atom junction clusters in hours rather than days.

---

## 4. Classical Feasibility Assessment

- 3D lattice graph optimization at 10⁶ nodes: NP-hard (exponential in system size)
- Classical heuristic (simulated annealing, genetic algorithms): can produce local minima but not guaranteed global optimum
- DFT phonon calculations on junction clusters: ~48 hours per junction on 64-core node
- 100 junction geometries to validate: 200 days of cluster time
- **Full exploration: intractable without quantum acceleration**

---

## 5. Expected Quantum Advantage

| Metric | Current | Quantum Target |
|---|---|---|
| Thermal conductivity λ | 0.010 W/m·K | ≤ 0.007 W/m·K |
| Tortuosity τ | ~1.5-2.0 (est.) | 2.5-3.5 (optimized) |
| Panel thermal isolation (ΔT at 25mm) | ~40°C | ~60°C |
| Energy savings (reduced HVAC load) | Baseline | 25-35% additional |

---

## 6. Partner Requirements

- **Quantum annealer:** ≥ 5,000 qubits with all-to-all connectivity (or embedding overhead accommodated)
- **Gate-model alternative:** ≥ 100 logical qubits for QAOA optimization
- **Classical DFT:** Phonon transport validation via VASP/Phonopy with VQE acceleration
- **Expertise:** Disordered network optimization; phonon transport; sol-gel chemistry

---

## 7. Deliverables and Timeline

| Phase | Deliverable | Timeline |
|---|---|---|
| Phase 1 | Benchmark quantum annealing on 10³ graph vs. classical SA | Months 1-3 |
| Phase 2 | Optimize 100³ lattice for minimum λ; generate 3D voxel structure | Months 4-7 |
| Phase 3 | DFT phonon validation on top 10 network topologies | Months 7-10 |
| Phase 4 | Reverse-map optimal topology to synthesis conditions | Months 10-13 |
| Phase 5 | CSM synthesis and thermal conductivity measurement | Months 13-18 |

---

*Document prepared by: Director Kairos Steele, CITADEL [DIRECTOR-001] | with aerogel network physics informed by the structural expertise of Engineer Orion Cross (sol-gel synthesis and aerogel fabrication), the optimization architecture of Agent Cypher Voss (network graph mapping to QUBO), and the thermal boundary condition analysis of Operative Zephyr Arden — Aegis Operations, Carrington Storm Motors*

*CSMQuantum Series 005 | Version 1.0 | July 2026*
*© 2026 Carrington Storm Motors / Safe Pod Engineering Company. All rights reserved.*
