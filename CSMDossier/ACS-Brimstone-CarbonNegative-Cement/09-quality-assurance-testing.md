# 09 — Quality Assurance & Testing

## QA/QC Framework

Brimstone's quality management system follows the **ASTM C917 Standard Practice for
Evaluation of Cement Testing Uniformity from a Single Source**, with reference to:

- **AASHTO R 18** — Quality Assurance for Construction Materials Testing
- **ISO/IEC 17025** — General requirements for testing and calibration laboratories
- **ACI 311.6** — Specification for Testing Ready Mixed Concrete

## In-House Laboratory Testing

Every production day, the following tests are performed on grab samples taken at the
clinker cooler discharge and finished cement silo:

### Chemical Tests (X-Ray Fluorescence — XRF)

| Test | Frequency | Standard |
|------|-----------|----------|
| Major oxides (SiO2, Al2O3, Fe2O3, CaO, MgO, SO3) | Every 2 hours | ASTM C114 |
| Loss on Ignition (LOI) | Every 2 hours | ASTM C114 |
| Insoluble residue | Daily composite | ASTM C114 |
| Free CaO (by ethylene glycol extraction) | Every 4 hours | ASTM C114 (Annex) |
| Equivalent alkalis (Na2O, K2O) | Daily | ASTM C114 |
| Chloride content | Weekly | ASTM C1152 |

### Physical Tests

| Test | Frequency | Standard |
|------|-----------|----------|
| Blaine fineness | Every 2 hours | ASTM C204 |
| 45 μm sieve residue | Every 2 hours | ASTM C430 |
| Vicat setting time (initial/final) | Daily | ASTM C191 |
| Autoclave soundness | Daily | ASTM C151 |
| Air content of mortar | Daily | ASTM C185 |
| Compressive strength (1, 3, 7, 28 day) | Daily | ASTM C109 |
| Heat of hydration (isothermal calorimetry) | Weekly | ASTM C1702 |
| Sulfate resistance (mortar bar expansion) | Monthly | ASTM C1012 |
| Alkali-silica reactivity (ASR) | Quarterly | ASTM C1567 / C1260 |

### Mineralogical Analysis

| Test | Frequency | Method |
|------|-----------|--------|
| Clinker phase composition (Bogue calculation) | Daily | ASTM C1365 |
| Clinker phase composition (Rietveld refinement) | Weekly complement | ASTM C1365 + XRD |
| MgO periclase crystal size distribution | Monthly | SEM/optical microscopy |
| Clinker microscopy (burning conditions) | Monthly | ASTM C1356 |

## Statistical Process Control (SPC)

Key quality parameters are tracked on X-bar and R charts with defined control limits:

- C3S content: target ± 3% (upper/lower control limits)
- Blaine fineness: target ± 200 cm²/g
- 28-day compressive strength: moving average >28 MPa, individual >24 MPa
- SO3: target ± 0.3%

Any parameter exceeding 2σ from target triggers a root-cause analysis; exceeding 3σ
triggers immediate corrective action and customer notification.

## CCRL Proficiency Program

Brimstone participates in the **Cement and Concrete Reference Laboratory (CCRL)**
proficiency sample program:

- Semi-annual interlaboratory testing with 200+ participating labs
- Chemical and physical test panels
- Results published in CCRL reports; used by state DOTs for prequalification
- Performance within ±1.5 interlaboratory standard deviation maintained

## Third-Party Audit

Annual audits by:
1. **SCS Global Services** — Carbon-negative claim verification
2. **CCRL** — On-site laboratory inspection
3. **State DOT independent testing** — Plant prequalification for highway projects
4. **Customer quality audits** — Major ready-mix and precast customers

## Product Consistency

The Bogue equations used for conventional OPC apply identically to Brimstone's
product. Phase composition control relies on:

1. **Raw meal blend control:** continuous XRF feedback to weigh feeders
2. **Kiln feed stability:** homogenization silos (CF silos) upstream of preheater
3. **Clinker cooling rate:** controlled via grate cooler speed and airflow

Initial production data from the demonstration plant shows standard deviation on
28-day compressive strength of <1.5 MPa and C3S content variation of <2% — within
industry best-practice bounds.
