# TEST-01: MASTER TEST PLAN
## Carrington Storm Motors — Project AEGIS
### Comprehensive Verification & Validation Framework for All CSM Products

**Document Status:** Governing Document — All Test Protocols Derived From This Plan  
**Version:** 1.0 — 15 July 2026  
**Classification:** CONFIDENTIAL — Accredited Investor Eyes Only  
**Author:** Zirconia, Director of Test & Validation — Aegis Operations Command  
**Test Operations Lead:** Mork (Test Execution), Chester (Quality Assurance)

---

## TESTING PHILOSOPHY

The CSM testing philosophy rests on four pillars:

1. **NIST-Traceable:** Every measurement is traceable to a National Institute of Standards and Technology (NIST) primary standard through an unbroken chain of calibrations. When CSM claims 92 dB shielding effectiveness at 45 μm MXene thickness, that claim is anchored to a NIST-calibrated field probe, a NIST-traceable network analyzer, and a NIST-traceable profilometer.

2. **Peer-Reviewable:** All test data, methodologies, and analysis scripts are published in full (with proprietary manufacturing details redacted) to enable independent replication. CSM does not make claims that cannot be verified by a third-party laboratory following the published protocol.

3. **Open-Data:** De-identified test results are made available to academic researchers, insurance actuaries, and regulatory bodies through the CSM Digital Twin platform's data-sharing API. This commitment to transparency distinguishes CSM from defense contractors who classify comparable test data.

4. **Carrington-Calibrated:** Every EMI/GIC test is calibrated to the measured parameters of the 1859 Carrington Event, scaled for modern infrastructure: surface electric fields of 1,000–5,000 mV/km, magnetic field change rates of 2,000 nT/min, and ground-induced current densities of 10–50 A/m².

---

## TEST CATEGORIES — FOUR-TIER HIERARCHY

### Tier 1: Materials Testing (TEST-02)
**Scope:** Individual materials — MXene coatings, BFRP composites, ceramic dielectrics, geopolymer concrete, piezoelectric elements, aerogels, MR fluids, STF formulations  
**Standards:** IEEE 299, MIL-STD-188-125, ASTM D149, ASTM D257, ASTM D4935, ASTM D3039, IEC 60243  
**Laboratory:** CSM El Segundo QC Lab (TEM cell, universal test machine, environmental chambers) or accredited third-party lab  
**Sample Rate:** Every production batch for critical materials (MXene, BFRP); periodic verification for stable materials (geopolymer aggregate, aerogel)

### Tier 2: Component Testing (TEST-03 through TEST-07)
**Scope:** Individual products and sub-assemblies — Aegis-C panel, Phantom actuator, Charlemagne hull section, protonic transceiver, bridge bearing pad  
**Standards:** Product-specific (UL, FCC, FMVSS, ABS, ASTM) per ROAD-05  
**Test Facilities:** TEM cell (EMI), vibration table (LDS V8 or equivalent), environmental chamber (Thermotron or equivalent), EMC chamber (3 m semi-anechoic), high-voltage lab  
**Sample Rate:** First article inspection (100% dimensional/functional), production sampling per AQL (Acceptable Quality Level) tables

### Tier 3: System Testing (TEST-03 through TEST-07)
**Scope:** Integrated systems — complete Aegis Home, hardened substation, Charlemagne vessel in dry dock, Phantom MK-1 full robot, protonic network (5 nodes)  
**Test Conditions:** Simulated Carrington environment (combined EM + thermal + mechanical per CSMTest protocol), accelerated aging, fault injection, degraded-mode operation  
**Sample Rate:** Every pilot unit (100%); production units sampled at 1 per 50 for EMI, 100% for functional/safety

### Tier 4: Field Testing (TEST-09)
**Scope:** Deployed products in real operational environments — 50-home Aegis Home pilot, 10 Phantom utility deployment, Charlemagne vessel in commercial service, 5-node protonic network, infrastructure pilot sites  
**Data Collection:** Continuous sensor monitoring per ROAD-06 pilot data collection plans  
**Duration:** Minimum 12 months continuous data collection per pilot program  
**Success Criteria:** Per-pilot threshold values defined in ROAD-06

---

## STANDARD TEST FACILITIES REQUIRED

### CSM-Owned Facilities (El Segundo)

| Facility | Capability | Equipment | Status | Capacity |
|---|---|---|---|---|
| TEM Cell | EMI shielding effectiveness, 1 kHz–10 GHz, E-field and H-field probes | Custom TEM cell, Keysight N5227A PNA network analyzer, NIST-calibrated field probes | OPERATIONAL | 1 test setup; capacity: 8 tests/month |
| Materials Test Lab | Tensile, compression, flexural, hardness, density | Instron 5982 universal test machine (100 kN), hardness testers, analytical balance, density kit | OPERATIONAL | 20 specimens/day |
| Environmental Chamber | Temperature −70°C to +180°C, humidity 10–98% RH, programmable cycling | Thermotron SE-600-10-10 walk-in chamber | PROCUREMENT (Q4 2026) | 5 m³ internal volume |
| Vibration Table | Sine, random, shock; 5 Hz–3,000 Hz, 50 kN force | LDS V875-440 shaker with slip table | PROCUREMENT (Q4 2026) | 1 m² table area |
| High-Voltage Lab | DC to 100 kV, AC to 50 kV, impulse to 200 kV | Hipotronics HV test set, impulse generator | PROCUREMENT (Q1 2027) | 15 m² cleared test area |
| XPS/XRD/SEM Suite | Materials characterization — surface chemistry, crystal structure, morphology | Thermo Scientific K-Alpha XPS, Bruker D8 Advance XRD, JEOL SEM | SHARED (University partner) | In-house procurement deferred to Phase II |

### Third-Party Test Facilities (Contracted)

| Facility | Location | Capability | Standards | Typical Cost | Lead Time |
|---|---|---|---|---|---|
| UL Solutions | Northbrook, IL | Electrical safety, fire, weathering | UL 94, 723, 746C, 263, 1973, etc. | $12K–$55K per test | 3–6 months |
| TÜV SÜD America | San Diego, CA | EMC, FCC Part 15, IEC 61000-4-x | FCC, IEC, CE marking | $8K–$25K | 2–4 months |
| NTS (National Technical Systems) | Fullerton, CA | MIL-STD-461, MIL-STD-810, HEMP, vibration, thermal | MIL-STD-188-125, MIL-STD-461, MIL-STD-810 | $15K–$180K | 4–8 months |
| Element Materials Technology | Multiple US/EU | ASTM, ISO, materials characterization, fire | ASTM D149, D257, D3039, E84, etc. | $3K–$18K | 1–3 months |
| White Sands HEMP Facility | White Sands, NM | High-Altitude EMP (HEMP) testing | MIL-STD-188-125 | $180K+ | 6–12 months (DoD scheduling) |
| ABS / DNV Surveyors | Global | Maritime classification | SOLAS, class rules | $15K–$35K per survey | 1–3 months per survey |

---

## DATA MANAGEMENT PLAN

### Data Acquisition

| Measurement Type | Instrumentation | Sampling Rate | Data Format | Storage |
|---|---|---|---|---|
| EMI Shielding Effectiveness (SE) | Keysight PNA + field probes | 1,001 points per sweep, 1 kHz–10 GHz | .s2p (Touchstone S-parameter) | CSM Digital Twin |
| GIC Current/Voltage | NI DAQ + shunt resistors + voltage dividers | 1 Hz continuous | .tdms (NI binary) or .csv | Local NAS → cloud sync |
| Temperature / Humidity | K-type thermocouples, capacitive RH sensors | 1 sample/minute | .csv | Cloud |
| Vibration (Acceleration) | PCB Piezotronics accelerometers, NI DAQ | 5 kHz continuous | .tdms | Local NAS |
| Mechanical (Strain, Load, Displacement) | Strain gauges, LVDT, load cells, NI DAQ | 100 Hz continuous | .tdms | Local NAS |
| Visual / Thermal Imaging | FLIR thermal camera, 4K visible camera | 30 fps video | .mp4 (H.265) | NAS (video) |

### Data Storage Policy

- Raw data retention: Minimum 10 years (irreplaceable Carrington-equivalent test data)
- Processed data: Indefinite retention (published datasets, certification evidence)
- Backup: 3-2-1 rule — 3 copies, 2 different media, 1 off-site (AWS S3 Glacier Deep Archive for long-term)
- Encryption: AES-256 at rest, TLS 1.3 in transit
- Estimated annual data volume: Phase I (2026–2027): 50 TB; Phase II (2028–2030): 500 TB; Phase III (2031+): 2 PB

### Data Access

| Access Level | Who | What | Conditions |
|---|---|---|---|
| Internal — Full | CSM engineers, Zirconia, Steele | All raw and processed data | Standard employee confidentiality agreement |
| Internal — Redacted | CSM sales, marketing, investor relations | Processed data, summary statistics, charts | No raw data containing proprietary manufacturing details |
| Scientific Advisory Board | University partners | Full raw data (excluding proprietary manufacturing parameters) | Data Use Agreement; co-authorship on publications |
| Insurance Partners | Swiss Re, AXA actuaries | Anonymized pilot data; aggregate statistics; claims correlation | NDA + Data Use Agreement; no PII from homeowners |
| Public | Researchers, general public | Published datasets (de-identified, aggregated), test methodology documents | Open Data Commons Attribution License |
| Regulators | UL, FCC, ICC-ES, ABS surveyors | Full test data for products under evaluation | Standard regulatory access; NDA where required |

---

## REPORTING STANDARDS

### Test Report Template — Required Sections

Every CSM test report shall include:

1. **Test Identification:** Unique test ID (e.g., CSMTest-2026-001-Aegis-C-Panel-SE), date, test engineer(s), witness(es)
2. **Test Objective:** Clear statement of what is being tested and why
3. **Device Under Test (DUT):** Description, serial number, configuration, photographs, BOM reference
4. **Test Standards Referenced:** All applicable standards with revision dates (e.g., IEEE 299-2006, MIL-STD-188-125-1)
5. **Test Equipment:** Make, model, serial number, calibration due date for all instruments
6. **Test Setup:** Diagram, photograph, description of test fixture, cabling, grounding
7. **Test Procedure:** Step-by-step procedure, including equipment settings, dwell times, number of repetitions
8. **Environmental Conditions:** Temperature, relative humidity, barometric pressure at time of test
9. **Measurement Uncertainty:** Uncertainty budget per ISO/IEC 17025, expressed as expanded uncertainty (k=2, 95% confidence)
10. **Results:** Raw data (appended), processed results (tables, charts), statistical analysis
11. **Pass/Fail Determination:** Comparison of results against pre-defined criteria with margin
12. **Deviations:** Any deviations from referenced standard or test plan, with justification
13. **Conclusions:** Summary of findings, recommendations for design changes or further testing
14. **Appendices:** Raw data files, calibration certificates, equipment lists, photographs

### Measurement Uncertainty Budget Template

For each measurement type, CSM maintains an uncertainty budget:

| Component | Source | Distribution | Standard Uncertainty (u) | Divisor | Sensitivity Coefficient (c) | u×c Contribution |
|---|---|---|---|---|---|---|
| Field Probe Calibration | NIST calibration certificate | Normal | U/2 (from cert) | 2 | 1 | (U/2)×1 |
| Network Analyzer Amplitude | Keysight spec (±0.1 dB) | Rectangular | 0.1/√3 | √3 | 1 | 0.058 dB |
| Cable Loss | Measured, S21 of cables | Normal | 0.05 dB | 1 | 1 | 0.05 dB |
| Mismatch | VSWR of probe + DUT | U-shaped | Calculated | √2 | 1 | Calculated |
| Repeatability | 10 repeat measurements | Normal | Standard deviation | 1 | 1 | σ |
| **Combined Standard Uncertainty (uc)** | | | √(Σ(ui×ci)²) | | | |
| **Expanded Uncertainty (U, k=2)** | | | 2 × uc | | | |

**Target:** Expanded uncertainty for SE measurement <±3 dB at 95% confidence. Currently achieved: ±2.1 dB.

---

## TEST PRIORITIZATION MATRIX

Given limited TEM cell capacity (8 tests/month) and budget constraints, test prioritization follows:

| Priority | Criterion | Example Tests |
|---|---|---|
| **P0 — CRITICAL** | Required for regulatory approval (UL, FCC, ICC-ES), safety certification, or blocking a TRL gate | Aegis Home UL 94/723/746C; Phantom Phase 1 EM; FCC Part 15 for LoRa; ICC-ES AC04 |
| **P1 — HIGH** | Required for pilot program initiation, Series A/B funding gate, or customer commitment | Aegis Embark TEM cell; Charlemagne hull SE; Protonic H-FET; Aegis Home prototype full-system GIC test |
| **P2 — MEDIUM** | Performance optimization, competitive benchmarking, publication data | Stellar-Tint mode comparison; Way-Finder haptic accuracy; Silence-Block cabin noise optimization |
| **P3 — LOW** | Nice-to-have data for marketing, internal R&D, exploratory | Long-term MXene degradation (5-year outdoor); Phantom actuator wear beyond 10⁶ cycles; YInMn Blue colorfastness (10-year equivalent) |

---

## TEST EXECUTION GOVERNANCE

### Roles and Responsibilities

| Role | Individual | Responsibilities |
|---|---|---|
| **Test Director** | Zirconia | Approves all test plans; assigns test priority; signs off on test reports; ensures NIST traceability and ISO 17025 compliance |
| **Test Engineer** | Mork (lead), rotating by product | Designs test setup; executes test; collects data; performs initial analysis; drafts test report |
| **Quality Assurance** | Chester | Witnesses critical tests; reviews test reports for completeness; manages non-conformance process; maintains calibration schedule |
| **Product Owner (Agent)** | Per ROAD-07 mapping | Defines test objectives and pass/fail criteria; provides DUT and product expertise; reviews and approves test reports for their product |
| **Independent Reviewer** | Scientific Advisory Board member (rotating) | Reviews test methodology for P0/P1 tests; may witness testing; co-authors publications |

### Test Plan Approval Workflow

```
Test Engineer drafts plan →
  Product Agent reviews (technical accuracy) →
    Zirconia reviews (methodology, standards compliance) →
      Chester reviews (quality, calibration) →
        Independent Reviewer reviews (for P0/P1) →
          Zirconia approves →
            Test executed →
              Test Engineer writes report →
                Chester reviews report →
                  Product Agent approves →
                    Zirconia signs off →
                      Report published to CSM Digital Twin
```

---

## NON-CONFORMANCE MANAGEMENT

When test results fail to meet acceptance criteria:

1. **Immediate Actions:** DUT quarantined; test equipment verified (re-calibrate if needed); test repeated to rule out measurement error
2. **Root Cause Analysis:** 5-Why analysis or Ishikawa (fishbone) diagram; trace failure to material, design, manufacturing, or test setup root cause
3. **Corrective Action:** Design change (ECO), manufacturing process change (Work Instruction update), supplier corrective action request (SCAR), or test procedure revision
4. **Verification:** Corrected DUT re-tested; if pass, corrective action validated; if fail, return to Step 2
5. **Documentation:** Non-Conformance Report (NCR) filed in CSM QMS; linked to test report; trended monthly for systemic issues
6. **Communication:** For P0/P1 tests, non-conformance reported to Director Steele within 24 hours; mitigation plan within 72 hours

---

## CONTINUOUS IMPROVEMENT — TEST PROCESS METRICS

| Metric | Current (Q3 2026) | Target (Q4 2027) | Improvement Action |
|---|---|---|---|
| Test report cycle time (plan to signed report) | 8 weeks (estimated) | 4 weeks | Standardized templates; pre-approved test setups for routine tests; parallel review workflow |
| Measurement uncertainty (SE) | ±2.1 dB (k=2) | ±1.5 dB (k=2) | Improved cable calibration; better anechoic treatment of TEM cell; automated uncertainty calculator |
| First-pass yield (tests passing on first attempt) | N/A (insufficient data) | >85% | Better pre-test simulation (CST model predicts SE before physical test); design reviews catch issues before test |
| Calibration overdue rate | 0% (all current) | <2% (with scaling) | Automated calibration management software; redundant instruments to allow calibration without downtime |
| Independent review completion | 0% (not yet established) | 100% for P0/P1 | Scientific Advisory Board engagement (2027); rotating reviewer schedule |

---

## TEST FACILITY BUDGET — 5-YEAR PROJECTION

| Facility | 2026 (Q3–Q4) | 2027 | 2028 | 2029 | 2030 | 5-Year Total |
|---|---|---|---|---|---|---|
| CSM El Segundo Lab (equipment) | $850K (chamber, shaker) | $450K (HV lab, XPS) | $200K (upgrades) | $150K | $100K | $1.75M |
| CSM El Segundo Lab (operations) | $180K | $350K | $500K | $600K | $750K | $2.38M |
| Third-Party Testing (UL, TÜV, NTS, etc.) | $500K | $1.2M | $2.5M | $3.5M | $5.0M | $12.7M |
| Calibration Program | $35K | $65K | $100K | $150K | $200K | $550K |
| Data Management (storage, software) | $45K | $120K | $250K | $400K | $600K | $1.42M |
| Scientific Advisory Board | $0 | $105K | $105K | $105K | $105K | $420K |
| **ANNUAL TOTAL** | **$1.61M** | **$2.29M** | **$3.66M** | **$4.91M** | **$6.76M** | **$19.22M** |

---

*"Testing is the conscience of engineering. A design can be elegant on paper, cost-optimized in a spreadsheet, and beautiful in a rendering — and still fail in the TEM cell. The Master Test Plan exists to ensure that every CSM product that reaches a customer has been tested to destruction in the laboratory so that it will never be destroyed in the field. NIST traceability means our numbers are real. Peer review means our claims are credible. Open data means our results are verifiable. These are not optional. They are the price of admission to the Dielectric Citadel."* — Zirconia, Director of Test & Validation

---

*Document generated 2026-07-15. This Master Test Plan is the governing document for all CSM testing activities. All product-specific test protocols (TEST-02 through TEST-10) derive their authority from this plan and must be consistent with its requirements. Revision controlled via CSM QMS document control system. Next review: 2026-10-01 (Q4 2026), or upon any significant change to test facilities, standards, or regulatory requirements.*
