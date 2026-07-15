# TEST-09: FIELD TRIAL DESIGN
## Carrington Storm Motors — Project AEGIS
### Statistical Design • Site Selection • Data Collection • Analysis Plan • Publication Strategy

**Document Status:** Scientific Field Trial Protocol — IRB-Ready  
**Version:** 1.0 — 15 July 2026  
**Classification:** CONFIDENTIAL — Accredited Investor Eyes Only (Pre-Publication)  
**Author:** Zirconia (Scientific Design) + Specialist Aura Kind (EMBARK — Field Operations)  
**Statistical Consultant:** To be engaged (university partner — target University of Washington Biostatistics)  
**IRB:** To be submitted via partner university

---

## FIELD TRIAL PHILOSOPHY

Laboratory tests prove that a product works under controlled conditions. Field trials prove that it works in the chaos of the real world — with variable installation quality, unpredictable weather, evolving geomagnetic conditions, and the infinite complexity of human behavior. CSM's field trial program is designed to the standard of a clinical trial in medicine: pre-registered hypotheses, pre-specified analysis plans, independent data monitoring, and publication in peer-reviewed journals regardless of outcome. We publish positive results to prove our products work. We publish negative results to prove our scientific integrity. There are no failed field trials — only field trials that generate data.

---

## PART 1: STATISTICAL DESIGN PRINCIPLES

### 1.1 Study Design Types by Product

| Product | Design | Rationale |
|---|---|---|
| Aegis Home | Prospective matched cohort study — 50 Aegis Homes, 25 matched control homes | Cannot randomize (homeowners choose to buy Aegis Home or not); matched controls minimize confounding |
| Infrastructure (Substations, Bridges) | Before-after study with matched control sites | Cannot build two identical substations — compare each site to its own pre-installation baseline AND to a matched control site that did not receive hardening |
| Charlemagne Fleet | Single-arm prospective study (1 hardened vessel compared to fleet-wide claims database) | Only 1 vessel hardened — compare its claims/incident experience to the unhardened fleet over same time period |
| Phantom Robot | Prospective observational study — 10 robots deployed, task completion and reliability measured | Single-arm (no "unhardened robot" exists for comparison — Phantom is the only GIC-hardened robot) |
| Protonic Network | Single-arm deployment study — 5 nodes, uptime and performance measured | Compare to baseline (conventional radio performance during GIC events from historical data) |

### 1.2 Sample Size Calculations

| Study | Primary Endpoint | Expected Effect Size | α (Type I Error) | β (Type II Error / Power) | Required Sample Size | Actual Sample Size | Margin |
|---|---|---|---|---|---|---|---|
| Aegis Home — GIC Reduction | Mean GIC current reduction (%) vs. matched control | 94% reduction (expected), minimum detectable 80% (conservative) | 0.05 (two-sided) | 0.20 (80% power) | 12 homes per group | 50 Aegis + 25 control | 4× margin — very well-powered |
| Aegis Home — Occupant Satisfaction | Proportion "satisfied" or "very satisfied" vs. 80% benchmark | 90% (expected) | 0.05 (one-sided) | 0.20 (80% power) | 35 homes | 50 homes | Adequate |
| Infrastructure — GIC Reduction | Mean GIC current reduction (%) vs. pre-installation baseline | 90% reduction (expected) | 0.05 (two-sided) | 0.20 (80% power) | 8 sites | 10 sites (5 substations + 3 bridges + 2 pipelines) | Adequate |
| Phantom — Mission Completion Rate | Proportion of missions completed without degradation | 95% (expected) vs. 80% benchmark | 0.05 (one-sided) | 0.20 (80% power) | 50 missions | 100+ missions (20+ per robot over 6 months) | Adequate |
| Charlemagne — Insurance Claims Reduction | Rate ratio (claims/vessel-year for hardened vs. fleet baseline) | 0.50 (50% reduction) | 0.05 (two-sided) | 0.20 (80% power) | 3 vessel-years (requires multi-year data from 1 vessel or shorter data from multiple vessels) | 1 vessel-year from pilot | Underpowered — will report with wide confidence intervals; fleet expansion provides additional vessel-years |
| Protonic — Uptime | Proportion of time network is operational | 99.5% (expected) | 0.05 (one-sided) | 0.20 (80% power) | 8,760 hours (1 year from 1 node) | 43,800 node-hours (5 nodes × 8,760 hours) | Well-powered |

### 1.3 Confounding Variable Control

| Confounding Variable | Control Method |
|---|---|
| Geographic GIC Variability | Match control homes/sites within 5 km; same substation feeder; adjust for local geology (conductivity model) |
| Homeowner Behavior | Standardized instructions; usage logged via Marmalade app; sensitivity analysis excluding non-compliant homes |
| Seasonal Effects | 12-month data collection captures all seasons; analyze by season as secondary endpoint |
| Installation Quality Variability | Standardized installer training (see ROAD-08 — Installer Training Platform); installation QA checklist (TEST-03 Phase 3) |
| Measurement Drift | Sensors calibrated pre- and post-study; redundant sensors on critical measurements; data quality flags for suspected sensor failure |
| Geomagnetic Storm Frequency | Storm occurrence is random — include at least 12 months to capture seasonal and solar cycle variability; supplement with controlled current injection testing (TEST-03 through TEST-07) |

---

## PART 2: SITE SELECTION AND PARTNER IDENTIFICATION

### 2.1 Site Selection Criteria (All Pilots)

| Criterion | Weight | Scoring Method |
|---|---|---|
| GIC Risk (proximity to geomagnetically active region) | HIGH | K-index frequency analysis; Earth resistivity model; proximity to geomagnetic observatory |
| Partner Willingness (utility, builder, cruise line) | HIGH | Signed MOU or letter of intent; executive sponsor identified; budget commitment |
| Regulatory Pathway (permitting feasibility) | HIGH | Pre-application meeting with building department or regulatory body; no known environmental/legal blockers |
| Data Quality (existing monitoring infrastructure) | MEDIUM | Existing GIC monitoring, weather station, air quality monitoring at or near site |
| Demographic Representatives | MEDIUM | Match to target market demographics (income, housing type, urban/suburban/rural) |
| Public Visibility (for marketing/publication) | LOW | Media interest; community engagement potential; educational institution proximity |
| Logistics (CSM team travel, equipment shipping) | LOW | Within 4-hour travel of CSM El Segundo office or partner university; commercial shipping feasible |

### 2.2 Partner Identification Process

1. Long-list (20–30 potential partners) from industry databases, conferences, personal networks
2. Screen against criteria → short-list (5–8)
3. Introductory meeting (Steele + Kind) → assess willingness + capability
4. Technical deep-dive (Zirconia + product Agent) → site visit, data review, MOU draft
5. MOU signed → partner officially enrolled in pilot program

**Current Partner Identification Status:** See ROAD-09 (Partnership Strategy) for detailed pipeline per partner category. Key gap: cruise line partner for Charlemagne pilot is highest priority outstanding partner identification.

---

## PART 3: BASELINE DATA COLLECTION METHODOLOGY

### 3.1 Pre-Installation Baseline Duration

| Study | Baseline Duration | Rationale |
|---|---|---|
| Aegis Home | 3 months (control homes continue monitoring for full 12 months) | Capture at least one moderate geomagnetic storm (Kp≥5 occurs ~50 days/year at solar maximum) |
| Infrastructure | 3 months | Same as above; pre-installation data also provides GIC characterization for product design refinement |
| Charlemagne | 12 months (vessel claims/incident data from prior 3 years — retrospective baseline) | Insurance claims are rare events — need multi-year retrospective baseline for statistical power |
| Phantom | 1 month (bench testing at CSM facility) | Phantom is new-build — no field baseline exists; bench testing establishes performance baseline for field comparison |
| Protonic | None (protonic is novel — no baseline exists) | Compare to conventional radio performance during GIC events from historical utility records |

### 3.2 Baseline Data Collected

| Study | Data | Source | Duration |
|---|---|---|---|
| Aegis Home | GIC currents, energy usage, IAQ, structural strain, homeowner satisfaction (control homes) | Installed sensors + surveys | 3 months pre + 12 months concurrent |
| Infrastructure | GIC currents, transformer neutral current, pipeline CP data, railway signal events | Utility SCADA + installed sensors | 3 months pre + 12 months concurrent |
| Charlemagne | Hull and machinery insurance claims (date, cause, cost), passenger injury claims, voyage delays due to technical issues | Insurance carrier data (anonymized) + cruise line operational data | 3 years retrospective |
| Phantom | Actuator performance, sensor accuracy, navigation accuracy, battery performance, EMI susceptibility | CSM bench test data | 1 month (bench) + 6 months (field) |
| Protonic | Weather data, geomagnetic activity, conventional radio uptime in test regions (from utility records) | NOAA SWPC + utility records | 12 months concurrent |

---

## PART 4: INTERVENTION DEPLOYMENT PROTOCOL

### 4.1 Installation Quality Control
All pilot installations follow the QA protocols defined in TEST-03 (Phase 3) for Aegis Home, TEST-04 for Charlemagne, TEST-06 for infrastructure. Field trial data is segregated between correctly-installed products and those with installation defects (identified during QA) for sensitivity analysis.

### 4.2 Blinding
- **Single-blind:** Homeowners in control homes do not know their home's GIC measurements (no real-time display)
- **Open-label:** Aegis Home owners know their home is hardened (impossible to blind — the products are physically visible)
- **Blinded analysis:** Statistician analyzing data is blinded to home assignment (Aegis vs. control) until analysis is complete

---

## PART 5: MONITORING AND DATA COLLECTION PLAN

### 5.1 Data Collection Infrastructure

| Component | Technology | Notes |
|---|---|---|
| Sensors | Per TEST-03 (Aegis Home), TEST-04 (Charlemagne), TEST-06 (Infrastructure) | All NIST-traceable calibration |
| Data Aggregation | On-site NI CompactDAQ or Raspberry Pi with ADC hat → local NAS → cloud sync (AWS S3) | Store-and-forward architecture tolerates internet outages |
| Cloud Platform | AWS S3 → PostgreSQL + PostGIS → CSM Digital Twin API | Encrypted at rest (AES-256) and in transit (TLS 1.3) |
| Monitoring Dashboard | LandOLil v10+ with real-time streaming for CSM engineers; Grafana for detailed technical dashboards | Alert thresholds set for sensor failure, data gap >1 hour, GIC event detection |
| Mobile App | Marmalade (homeowners), LandOLil (utility/installer partners) | Offline-first architecture; sync when internet available |

### 5.2 Data Quality Assurance

| Check | Frequency | Action if Failed |
|---|---|---|
| Sensor Calibration Verification | Pre-installation, post-installation, quarterly during study | Recalibrate sensor; flag data between last good calibration and recalibration |
| Data Completeness | Daily automated check (expect >95% completeness) | Investigate missing data; dispatch technician if hardware failure |
| Sensor Drift Detection | Weekly: compare redundant sensor pairs; flag if divergence >3σ of expected variation | Investigate; recalibrate or replace sensor |
| Outlier Detection | Automated: z-score >5 triggers alert | Manual review; if confirmed physical event (actual GIC event), retain; if sensor artifact, flag/exclude |
| Timestamp Accuracy | NTP sync all data loggers; verify hourly | Correct clock drift; flag data if timestamp uncertainty >1 second |

### 5.3 Adverse Event Reporting

| Event Type | Reporting Timeline | Action |
|---|---|---|
| **Serious Adverse Event (SAE)** — Electrical shock, fire, structural failure, injury, death | Within 24 hours to Zirconia + Steele + IRB (if human subjects involved) | Immediate investigation; root cause analysis; product recall/field modification if indicated |
| **Product Malfunction** — Any CSM product failing to meet specification | Within 72 hours to product Agent + Chester | Diagnostic investigation; repair/replace; trend analysis |
| **Data Loss** — Sensor failure, data gap >24 hours | Within 48 hours to Zirconia | Restore from backup; repair sensor; document gap in final report |
| **Protocol Deviation** — Any departure from field trial protocol | Within 1 week to Zirconia + IRB | Document deviation; assess impact on data validity |

---

## PART 6: STATISTICAL ANALYSIS PLAN

### 6.1 Primary Analysis (Intent-to-Treat)

All enrolled homes/sites are included in analysis regardless of protocol deviations, product malfunctions, or homeowner withdrawal. This is the "real world" estimate — it includes the effect of installation quality variability, homeowner behavior, and product reliability. Pre-specified before any data is collected.

### 6.2 Secondary Analysis (Per-Protocol)

Excluding homes/sites with protocol deviations (installation defects identified during QA, homeowner non-compliance with sensor maintenance, early withdrawal). This estimates product efficacy under "ideal" conditions.

### 6.3 Subgroup Analyses (Exploratory)

| Subgroup | Hypothesis | Pre-Specified? |
|---|---|---|
| Geographic Region | GIC reduction varies by region (geology, grid configuration) | Yes |
| Housing Type | GIC reduction differs between single-family and multifamily | Yes |
| Season | GIC reduction varies by season (frozen ground affects GIC) | Yes |
| Homeowner Income | Satisfaction, health outcomes differ by income (equity analysis) | Yes |
| Geomagnetic Storm Intensity | GIC reduction is consistent across storm magnitudes (Kp 5–9) | Yes |
| Installation Quality (QA Score) | Higher QA score → better GIC reduction | Yes (exploratory) |

**All subgroup analyses reported with interaction p-values and 95% confidence intervals. No post-hoc "p-hacking" — exploratory analyses clearly labeled as such.**

### 6.4 Missing Data Handling

| Missing Data Mechanism | Handling Method |
|---|---|
| Missing Completely at Random (MCAR) — sensor randomly fails | Complete case analysis (primary); multiple imputation (sensitivity analysis) |
| Missing at Random (MAR) — sensor fails more often in winter (battery drain) | Multiple imputation using weather, season, and operational variables as predictors |
| Missing Not at Random (MNAR) — homeowner withdraws because they're dissatisfied | Worst-case imputation (assume dissatisfied homeowners would have had poor outcomes); report both optimistic and conservative estimates |

---

## PART 7: REPORTING AND PUBLICATION PLAN

### 7.1 Pre-Registration
All field trials pre-registered on Open Science Framework (osf.io) or ClinicalTrials.gov (for trials with human health outcomes — e.g., Aegis Home health monitoring, Cervical-Guard driver study) before data collection begins. Pre-registration includes: hypotheses, primary/secondary endpoints, sample size justification, analysis plan, and subgroup analyses.

### 7.2 Publication Timeline

| Study | Data Collection Complete | Analysis Complete | Manuscript Submitted | Target Journal |
|---|---|---|---|---|
| Aegis Home Pilot | Q4 2028 | Q1 2029 | Q2 2029 | Building and Environment or IEEE Trans. EMC |
| Infrastructure Pilot | Q4 2028 | Q2 2029 | Q3 2029 | IEEE Trans. Power Delivery |
| Charlemagne Pilot | Q2 2030 | Q3 2030 | Q4 2030 | Marine Structures or Ocean Engineering |
| Phantom Pilot | Q2 2029 | Q3 2029 | Q4 2029 | IEEE Robotics and Automation Letters |
| Protonic Pilot | Q4 2028 | Q1 2029 | Q2 2029 | Nature Communications or IEEE Comm. Mag |

### 7.3 Data Sharing

After primary publication, de-identified data deposited in:
- **Dryad** (general scientific data repository)
- **CSM Digital Twin public API** (real-time GIC monitoring data for researchers)
- **NOAA SWPC** (GIC event data contributed to space weather database)
- Embargo period: Data available to journal reviewers during peer review; public release upon publication

---

## FIELD TRIAL BUDGET SUMMARY (from ROAD-06)

| Study | Total Budget | Notes |
|---|---|---|
| Aegis Home (50 homes) | $6.2M | Largest study; includes home construction cost |
| Infrastructure (10 sites) | $8.5M | Includes partner co-funding from utilities/DOTs |
| Charlemagne (1 vessel) | $50.8M | Vessel retrofit ($47M) is capex; trial monitoring ($3.8M) is opex |
| Phantom (10 robots) | $8.5M | Includes robot build cost |
| Protonic (5 nodes) | $3.8M | Lowest-cost pilot |
| Aegis Embark (100 vehicles) | $2.8M | Consumer product pilot — largest N, lowest per-unit cost |
| **TOTAL** | **$80.6M** | |

---

*"A field trial is a promise of transparency. We will tell the world what we are going to measure before we measure it. We will publish the results regardless of what they show. We will share the data with anyone who wants to verify our analysis. This commitment costs us nothing in competitive advantage — because our competitive advantage is not in keeping secrets, it is in making products that work. If our products work, the data will show it. If they do not, we deserve to know, and our customers deserve to know, before they buy."* — Zirconia, Director of Test & Validation

---

*Document generated 2026-07-15. All statistical analysis plans are preliminary and will be finalized with independent biostatistician review before data collection begins. IRB applications to be submitted through partner university (University of Washington target) for all studies involving human subjects data collection (homeowner surveys, health outcome monitoring, Phantom human-robot interaction). Pre-registration on Open Science Framework to be completed before first baseline data is collected for each study.*
