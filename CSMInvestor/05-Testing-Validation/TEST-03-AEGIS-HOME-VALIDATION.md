# TEST-03: AEGIS HOME VALIDATION PROTOCOL
## Carrington Storm Motors — Project AEGIS
### Whole-House GIC Susceptibility • Individual Product Validation • Installation QA • Durability • EMC

**Document Status:** Product Validation Protocol — NIST-Traceable  
**Version:** 1.0 — 15 July 2026  
**Classification:** CONFIDENTIAL — Accredited Investor Eyes Only  
**Author:** Zirconia + Operative Corvus Nyx (AEGIS HOME)  
**Test Engineers:** Mork (system-level), Chester (quality assurance)

---

## VALIDATION PHILOSOPHY

Aegis Home is an integrated system of 18 products — not a collection of individually validated components. The system-level validation protocol verifies that the products work together to achieve the target 94% GIC reduction. Individual product validation ensures each component meets its specification. Installation QA ensures the system is built correctly. Durability testing ensures it stays correct for decades.

---

## PHASE 1: INDIVIDUAL PRODUCT VALIDATION (18 Products)

### P1.1 Product Validation Matrix

| # | Product | Key Metrics | Test Standard | Pass/Fail | Test Duration | Cost |
|---|---|---|---|---|---|---|
| 1 | Aegis-C Wall Panel (1.2×2.4 m) | SE >148 dB 1 kHz–10 GHz; UL 94 V-0; E84 Flame Spread <25 | TEST-02 MXene + UL 94/723 | All metrics, all panels | 4 months | $180K |
| 2 | BFRP Rebar (8–32 mm) | Tensile >1,100 MPa; dielectric >15 kV/mm; bond strength with geopolymer >10 MPa | ASTM D7205, D7914, D149 | All metrics, all sizes | 4 months | $75K |
| 3 | Dielectric Door Hinge | Load capacity >200 kg; 100K cycle endurance; DC resistance hinge-to-panel >10⁸ Ω | Custom test fixture | All metrics | 2 months | $28K |
| 4 | Inductive-Proof Wiring (PMMA POF) | Gigabit optical data at 100 m; MXene SE >85 dB on fiber bundle; bend radius <30 mm without loss | TIA/EIA-455 (FOTP); TEST-02 MXene | All metrics | 3 months | $45K |
| 5 | Conductive-Safe Pipe (GFRP) | Pressure >150 psi sustained; dielectric joint >10⁸ Ω; UV resistance per ASTM G154 | ASTM D1598 (pressure); TEST-02 UV | All metrics | 3 months | $38K |
| 6 | Safe-Wave Microwave | SE >80 dB at 2.45 GHz; cooking performance equivalent to 800W conventional | FCC Part 18 (ISM); UL 923 | All metrics | 3 months | $42K |
| 7 | Stellar-Chill Refrigerator | Electrocaloric cooling ΔT >15°C; COP >3.0; zero compressor/vibration | Custom calorimeter test | All metrics | 3 months | $35K |
| 8 | Carrington-Proof Oven | Temperature uniformity ±10°C; energy consumption <1.5 kWh for standard bake cycle | UL 858 modified | All metrics | 3 months | $28K |
| 9 | Inflatable Ceramic Water Heater | Heat time <30 min to 60°C (40 gal); dielectric isolation >10⁸ Ω tank-to-water | UL 174 modified; custom elect. safety | All metrics | 3 months | $32K |
| 10 | Safe Cookware Set | Surface resistivity >10¹² Ω/sq; YInMn Blue thermal stability to 500°C; food safety (FDA 21 CFR) | Custom; FDA migration testing | All metrics | 2 months | $18K |
| 11 | EMF Detector | Sensitivity 0.1 μT–10 T; 0–1 kHz; piezo-powered (no battery); LoRa mesh | Custom calibration in TEM cell | All metrics | 2 months | $22K |
| 12 | Stealth-Lift Garage Door | BFRP frame load >500 kg; MXene mesh SE >80 dB at door seams; 10K cycle endurance | Custom structural + EMI | All metrics | 2 months | $35K |
| 13 | Conductive-Proof Spray Cans | Applied SE >80 dB at 45 μm dry film thickness; adhesion 5B per ASTM D3359 | TEST-02 MXene + adhesion | All metrics | 1 month | $8K |
| 14 | Dielectric Rope | Breaking strength >20 kN (12 mm dia); dielectric >20 kV/mm; UV resistance | ASTM D4268 (rope); TEST-02 dielectric/UV | All metrics | 2 months | $15K |
| 15 | Non-Conductive Motor (2 HP) | Efficiency >85%; torque ripple <5%; motor-to-chassis resistance >10⁸ Ω | IEEE 112 (motor efficiency); custom GIC | All metrics | 4 months | $48K |
| 16 | Conductive-Proof Tool Set | PEEK CF40 strength >220 MPa; ceramic blade hardness >HV 15 GPa; 100% non-sparking | ASTM D638 (tensile); ASTM E92 (Vickers) | All metrics | 1 month | $12K |
| 17 | Aerogel Thermal Breaks | λ <0.015 W/m·K; compressive >0.8 MPa; R-value >10 per inch | ASTM C518; ASTM C165 | All metrics | 2 months | $15K |
| 18 | Safe Stove Ventilation | Airflow >200 CFM; dielectric fan motor; duct GIC isolation >10⁸ Ω | Custom airflow + EMI | All metrics | 2 months | $18K |

**Phase 1 Total Cost: $689K; Total Duration: 12 months (parallelized across products)**

---

## PHASE 2: WHOLE-HOUSE GIC SUSCEPTIBILITY TESTING

### P2.1 Test Objectives

Verify that a complete Aegis Home (all 18 products installed) achieves >94% reduction in induced ground current compared to an unhardened control home of identical construction.

### P2.2 Test Setup

**Test Site:** CSM El Segundo outdoor test pad (or Aegis Home prototype per M2.4)  
**Test Homes:**
- **DUT (Device Under Test):** Full-scale 1,800 sq ft Aegis Home prototype, all 18 products installed per CSMFAB specifications, 48 GIC sensors embedded in foundation, walls, wiring, plumbing, and appliances
- **Control:** Identical floor plan constructed with conventional materials (steel rebar, copper wiring, metal plumbing, standard appliances), also with 48 sensors, located >50 m away (to prevent EM coupling between homes)

### P2.3 GIC Simulation Method

**Option A — Current Injection (Preferred):** Inject controlled current (0.1–50 A RMS, 0.001–1 Hz) into ground electrodes surrounding each home to simulate GIC. Measure induced currents in structural, wiring, and plumbing loops. Compare DUT vs. Control.

**Option B — TEM Cell Scaling:** Construct 1:10 scale models of DUT and Control homes; place in TEM cell; apply scaled EM fields. Extrapolate to full scale using EM scaling laws. Less accurate than Option A but useful for early-stage screening.

**Option C — Geomagnetic Storm Correlation:** Wait for actual geomagnetic storm (Kp ≥5) and compare real-time GIC measurements between DUT and Control during the event. Uncontrollable timing; used as supplementary validation.

**Selected: Option A (current injection) for primary validation; Option C for ongoing monitoring during pilot.**

### P2.4 Instrumentation (48 Sensors per Home)

| Sensor Type | Quantity | Location | Measurement | Sampling |
|---|---|---|---|---|
| Rogowski Coil (flexible CT) | 12 | Foundation rebar loops, wall panel edges, roof ridge | AC current (0.01–100 A, 0.1 Hz–1 kHz) | 1 Hz |
| Voltage Differential Probe | 8 | Between plumbing segments, across dielectric joints, panel-to-panel | AC/DC voltage (0.1 mV–600 V) | 1 Hz |
| Surface Electric Field Mill | 4 | N, S, E, W exterior walls at 1 m height | E-field (1 V/m–50 kV/m) | 1 Hz |
| Magnetometer (Fluxgate) | 2 | Interior center of home at floor and ceiling | B-field (0.1 nT–100 μT, DC–1 kHz) | 10 Hz |
| Fiber Optic Strain Gauge (FBG) | 10 | Foundation corners, wall midpoints, roof trusses | Microstrain (structural response to GIC-induced forces) | 100 Hz |
| Temperature (Thermocouple) | 6 | Panel interior surfaces, plumbing, appliance housings | Temperature (−40 to +125°C) | 0.017 Hz (1/min) |
| Humidity Sensor | 2 | Interior ambient, crawlspace | RH% | 0.017 Hz |
| Current Transformer (utility feed) | 2 | Main service entrance (DUT — dielectric isolated vs. Control — conventional bonded neutral) | Service current, neutral-to-ground current | 60 Hz (power quality) |
| Reference Ground Electrode | 2 | Remote earth reference, 100 m from test site | Earth potential reference | 1 Hz |

### P2.5 Test Procedure — Current Injection

1. Install ground electrode array: 4 electrodes at 10 m spacing in square pattern around each home
2. Connect controlled current source (programmable AC power supply + step-up transformer, 0–50 A, 0.001–1 Hz)
3. Baseline measurement: All sensors recording, zero injected current, 24 hours (characterize ambient GIC from natural geomagnetic activity)
4. Injection sweep: Inject current at 11 frequencies (0.001, 0.005, 0.01, 0.05, 0.1, 0.5, 1, 5, 10, 50, 100 Hz), at 5 amplitudes per frequency (0.5, 1, 5, 10, 50 A)
5. For each frequency/amplitude combination: record all sensors for 10 minutes (≥10 cycles at lowest frequency)
6. Between sweeps: 5-minute zero-current interval to allow transient decay
7. Total test duration: ~12 hours per home

### P2.6 Data Analysis — GIC Reduction Calculation

For each sensor location and each injected current frequency/amplitude:
1. Calculate transfer function: H(f) = I_induced(f) / I_injected(f) for DUT and Control
2. GIC Reduction Ratio = H_Control(f) / H_DUT(f) (unitless ratio)
3. Report as percent reduction: GIC_Reduction(%) = (1 − 1/Ratio) × 100
4. Aggregate across all sensor locations to compute mean reduction with 95% confidence interval
5. Primary metric: Mean GIC reduction across all 12 Rogowski coil locations

### P2.7 Pass/Fail Criteria

| Criterion | Threshold | Measurement |
|---|---|---|
| **PRIMARY: Whole-Home GIC Reduction** | >94% reduction (mean across all Rogowski coil locations at 0.01–1 Hz range — the geomagnetic band) | Current injection test |
| **PRIMARY: Zero Safety Events** | No measured current >5 mA through any human-touchable surface (door handles, faucets, appliance cases, light switches) at maximum injected current (50 A) | Voltage differential probes at touch points; calculate body current via IEC 60479 body impedance model |
| **SECONDARY: Panel SE** | Every Aegis-C wall panel maintains >140 dB SE when installed (vs. >148 dB at individual panel level — 8 dB degradation acceptable for joint losses) | Portable SE test fixture at 10 panel locations |
| **SECONDARY: Wiring GIC Isolation** | PMMA POF wiring carries zero measurable induced current (<1 μA) at any injected current level | Rogowski coils on POF bundles |
| **SECONDARY: Plumbing GIC Isolation** | Current across any dielectric pipe joint <10 μA at maximum injected current | Rogowski coils at all 16 dielectric joints |
| **SECONDARY: Structural Integrity** | Zero structural damage (cracking, delamination, displacement >1 mm) after maximum current injection | Pre/post visual inspection; FBG strain gauge data (Δmicrostrain <100 at any location) |

---

## PHASE 3: INSTALLATION QUALITY ASSURANCE

### P3.1 QA Checkpoints During Construction

| Construction Phase | QA Checkpoint | Instrument/Method | Acceptance Criteria |
|---|---|---|---|
| Foundation Pour | BFRP rebar placement per drawing; geopolymer mix verified (slump, density); no steel rebar present (metal detector) | Visual inspection; slump cone; nuclear density gauge; handheld metal detector | Rebar spacing ±10 mm; slump 150–200 mm; density 2,200–2,400 kg/m³; zero metal detected |
| Wall Panel Installation | Panel orientation correct (exterior face outward); MXene layer continuity at joints (no gaps >2 mm); gasket compression (torque wrench on bolts to 15 N·m) | Visual; feeler gauge at panel joints; torque wrench | All panels oriented correctly; gaps <2 mm everywhere; all bolts 15±2 N·m |
| PMMA POF Wiring | No copper wiring present (metal detector sweep of all walls); POF bend radius >30 mm everywhere; OTDR test on each fiber (insertion loss <0.3 dB/connector) | Metal detector; bend radius gauge; OTDR (EXFO or Viavi) | Zero metal detected; all bends >30 mm; all fibers <0.3 dB loss per connector, <3 dB total link loss |
| GFRP Plumbing | Dielectric joint gap >10 mm (verify no metal bridging); pressure test at 150 psi for 24 hours (zero pressure drop) | Feeler gauge; pressure gauge with chart recorder | All gaps >10 mm; pressure drop <1 psi over 24 hours |
| Appliance Installation | Ground resistance measurement (appliance chassis to earth >10⁸ Ω); functional test (all modes operational) | Megohmmeter (1,000 V test voltage); functional checklist | All R >10⁸ Ω; all functions operational |
| Final System Integration | Whole-home GIC susceptibility test (current injection at 5 A, 1 Hz — production screening test, not full characterization) | Portable GIC injection kit (5 A max); 6 Rogowski coils at key locations | Zero measurable GIC in wiring or plumbing; panel SE within 5 dB of individual panel spec |

### P3.2 Installation Defect Categories

| Defect Category | Definition | Action |
|---|---|---|
| **CRITICAL** | Creates conductive path where dielectric isolation is required; compromises GIC reduction target | Immediate rework; re-inspection before construction proceeds; root cause analysis |
| **MAJOR** | Reduces EMI shielding effectiveness by >3 dB at any frequency; creates safety hazard per NEC | Rework within 24 hours; re-inspection |
| **MINOR** | Cosmetic issue; dimensional tolerance out of spec but does not affect GIC/EMI/safety performance | Document in punch list; resolve before homeowner occupancy |
| **OBSERVATION** | Potential improvement identified; does not violate specification | Document for continuous improvement database |

---

## PHASE 4: LONG-TERM DURABILITY — ACCELERATED AGING

### P4.1 Environmental Exposure Testing

| Exposure | Method | Duration | Post-Exposure Verification |
|---|---|---|---|
| UV + Moisture (exterior panels) | ASTM G154 Cycle 1 (UVA-340, 8h UV 60°C / 4h condensation 50°C) | 2,000 hours (~5 years Florida equivalent) | SE within 5 dB of initial; YInMn Blue ΔE <3 (colorfastness); no delamination |
| Thermal Cycling (panels + structural) | −20°C to +60°C, 5°C/min, 1 hour dwell | 365 cycles (1 year diurnal equivalent) | SE within 3 dB; no cracking >0.1 mm; structural FBG Δstrain <50 μstrain from baseline |
| Freeze-Thaw (geopolymer foundation) | ASTM C666 Procedure A (rapid freezing and thawing in water) | 300 cycles | Mass loss <5%; dynamic modulus >80% of initial; resistivity >10⁷ Ω·m |
| High Humidity (interior products) | 40°C / 93% RH | 1,000 hours | Functional test pass; no mold/mildew; SE within 3 dB; electrical safety pass |
| Salt Spray (coastal homes) | ASTM B117 | 500 hours | SE within 5 dB; no corrosion on any surface (no metal to corrode — verify no unexpected degradation of MXene, BFRP, or ceramic components) |
| Wind-Driven Rain | ASTM E331 (static pressure 15% of design wind pressure) | 15 minutes per wall | No water penetration through panel joints; interior RH increase <5% |

### P4.2 Mechanical Endurance

| Product | Test | Cycles/Load | Acceptance |
|---|---|---|---|
| Dielectric Door Hinge | Open/close cycle — 100K cycles at 50 kg door weight | 100,000 | No play >1 mm; DC resistance hinge-to-panel >10⁸ Ω |
| Stealth-Lift Garage Door | Open/close cycle | 10,000 | No SE degradation >3 dB at seams; motor current within 10% of initial |
| Window Seals (aerogel thermal breaks) | Compression cycling (ASTM C864 for sealants) | 5,000 cycles, ±2 mm displacement | Air leakage <0.3 cfm/ft² at 75 Pa per ASTM E283 |

---

## PHASE 5: EMC COMPLIANCE — WHOLE-HOME

### P5.1 Radiated Emissions

| Test | Standard | Method | Limit |
|---|---|---|---|
| Radiated emissions (30 MHz–1 GHz) | FCC Part 15, Class B (residential) | CISPR 16-1-4, 3 m measurement distance | 40 dBμV/m at 3 m (30–88 MHz), 43.5 dBμV/m (88–216 MHz), 46 dBμV/m (216–960 MHz), 54 dBμV/m (above 960 MHz) |
| Conducted emissions (150 kHz–30 MHz) | FCC Part 15, Class B | LISN on mains | 66–56 dBμV (quasi-peak), 56–46 dBμV (average), decreasing with frequency |

**Expected Result:** Aegis Home with dielectric wiring and non-metallic construction is inherently quieter than conventional home. All products expected to pass with >10 dB margin.

### P5.2 Immunity

| Test | Standard | Level | Performance Criterion |
|---|---|---|---|
| IEC 61000-4-2 (ESD) | ±8 kV contact, ±15 kV air | Level 4 (highest) | Criterion A (normal performance during and after test) |
| IEC 61000-4-3 (Radiated RF) | 80 MHz–6 GHz, 10 V/m | Level 3 (residential) | Criterion A |
| IEC 61000-4-4 (EFT/Burst) | ±2 kV on power lines | Level 3 | Criterion B (temporary degradation, self-recoverable) |
| IEC 61000-4-5 (Surge) | ±2 kV line-to-earth | Level 3 | Criterion B |
| IEC 61000-4-6 (Conducted RF) | 150 kHz–80 MHz, 10 V | Level 3 | Criterion A |
| IEC 61000-4-8 (Power Frequency Magnetic Field) | 100 A/m continuous, 1,000 A/m for 3 s (special Carrington test level — standard only requires 30 A/m and 300 A/m) | Custom "Level X" | Criterion A at 1,000 A/m (confirms GIC immunity) |

---

## FIELD TRIAL PROTOCOL (REFERENCE TO ROAD-06)

The Aegis Home field trial (50 homes, 12 months) is defined in ROAD-06 (Pilot 1). Key validation data collected during field trial:

1. **Continuous GIC Monitoring:** 48 sensors per home, 1 Hz continuous, correlated with NOAA SWPC geomagnetic data
2. **Energy Performance:** HERS Index rating at 12 months; compare to control homes
3. **Occupant Satisfaction:** Validated POE survey at 3, 6, 12 months
4. **Maintenance Events:** All maintenance logged; categorize by product, severity
5. **Health Outcomes (Optional):** HRV, sleep quality, cortisol (pre/post comparison) — IRB-approved study

### Field Trial Success Criteria (from ROAD-06)

| Criterion | Threshold |
|---|---|
| GIC Reduction | >94% reduction vs. matched control homes |
| Zero Electrical Safety Events | Zero shock/fire incidents attributable to electrical system at 12 months |
| Occupant Satisfaction | >90% "satisfied" or "very satisfied" |
| Durability | <2% of components requiring repair/replacement at 12 months |
| Insurance Premium Impact | Documented premium reduction of >5% |

---

## PERFORMANCE METRICS — FINAL SYSTEM SPECIFICATION

| Metric | Target | Verification Method |
|---|---|---|
| Whole-Home GIC Reduction | >94% (mean across all current-carrying paths at 0.01–1 Hz) | Phase 2 current injection test |
| Aegis-C Panel SE (installed) | >140 dB (all panels, all locations, 1 kHz–10 GHz) | Portable SE test fixture |
| Wiring GIC Current | <1 μA (any PMMA POF bundle, maximum injection) | Rogowski coil |
| Plumbing GIC Current | <10 μA (any dielectric joint, maximum injection) | Rogowski coil |
| Structural GIC Current | <100 μA (any foundation rebar loop, maximum injection) | Rogowski coil |
| Touch-Point Body Current | <5 mA through 1 kΩ body impedance model (any human-touchable surface) | Voltage measurement + IEC 60479 model |
| Enclosure SE (appliances) | >40 dB at 2.45 GHz (microwave); >30 dB at 100 MHz–1 GHz (electronics) | Portable SE test fixture |
| DC Isolation (any conductive path) | >10⁸ Ω to earth or between any two points not intended to be connected | Megohmmeter at 1,000 V |
| Energy Performance | HERS Index <45 | RESNET HERS rater |
| Durability | All components functional within specification at 25-year equivalent accelerated aging | Phases 4a–4c |

---

*"Aegis Home is the flagship. When a homeowner asks 'will this house really protect my family from the next Carrington Event?' the answer is not in the brochure — it is in the 48-sensor GIC injection test, the 2,000-hour UV chamber, the 300-cycle freeze-thaw test, and the 12-month field trial data from 50 homes. This validation protocol converts hope into evidence."* — Operative Corvus Nyx (AEGIS HOME)

---

*Document generated 2026-07-15. Phase 1 (individual product validation) is in progress. Phase 2 (whole-home GIC test) requires completion of Aegis Home prototype (M2.4, Q1 2027). Phase 4 (accelerated aging) initiates upon prototype completion and runs concurrently with pilot. All test methods are NIST-traceable. Data published per open-data policy defined in TEST-01.*
