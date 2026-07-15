# ROAD-06: PILOT PROGRAM DESIGN
## Carrington Storm Motors — Project AEGIS
### Comprehensive Pilot Program Architecture for All Major Product Lines

**Document Status:** Investor-Grade Pilot Design  
**Version:** 1.0 — 15 July 2026  
**Classification:** CONFIDENTIAL — Accredited Investor Eyes Only  
**Author:** Specialist Aura Kind (EMBARK) — Pilot Program Director, with Zirconia (Validation Oversight)  
**Partner Liaisons:** All 18 Agents of Aegis (per product line)

---

## PILOT PROGRAM PHILOSOPHY

Pilot programs are not marketing exercises. They are rigorous scientific investigations designed to (1) validate product performance under real-world conditions, (2) generate the peer-reviewed data necessary for regulatory approval, insurance actuarial modeling, and customer trust, (3) identify failure modes that cannot be detected in laboratory testing, and (4) establish the reference installations that will anchor regional market expansion. Every CSM pilot follows a standardized architecture: 6-month preparation phase, 12-month active data collection, 3-month analysis and publication, with pre-defined success criteria, statistical analysis plans, and independent scientific oversight.

---

## PILOT 1: AEGIS HOME — RESIDENTIAL PILOT PROGRAM

### P1.1 Program Overview

**Scope:** Construction and monitoring of 50 Aegis Homes across three geographic regions  
**Timeline:** 6-month prep (Q3 2027–Q4 2027), 12-month data collection (Q1 2028–Q4 2028), 3-month analysis (Q1 2029)  
**Total Duration:** 21 months  
**Budget:** $6.2M  
**Lead Agent:** Operative Corvus Nyx (AEGIS HOME)  
**Scientific Oversight:** Independent research university (target: University of Washington — Cascadia Subduction Zone expertise; Georgia Tech — power systems; or UC San Diego — structural engineering)

### P1.2 Site Selection

| Region | Number of Homes | Rationale | GIC Risk Profile | Site Partners |
|---|---|---|---|---|
| **Pacific Northwest** (WA/OR) | 20 homes | Cascadia Subduction Zone — highest GIC risk in continental US; strong environmental consciousness; green building mandate alignment | HIGH — coastal proximity, igneous rock geology (high resistivity, channels GIC into power grid) | D.R. Horton (production builder), local electric utilities (Puget Sound Energy, Pacific Power) |
| **Upper Midwest** (MN/WI) | 15 homes | High GIC risk region (Precambrian shield geology); severe winter climate for thermal performance testing; strong utility engagement | HIGH — igneous/metamorphic rock, long EHV transmission lines | Pulte Homes, Xcel Energy, Dairyland Power Cooperative |
| **Gulf Coast** (TX/LA) | 15 homes | Hurricane + EMP dual threat market; high humidity for MXene durability testing; diverse demographic for equity analysis | MODERATE — sedimentary basin (lower GIC but increasing with grid expansion) | Lennar, Entergy, CenterPoint Energy |

**Site Selection Criteria:**
1. Within 5 km of geomagnetic observatory or utility-owned GIC monitor for reference data
2. Diverse housing types: 30 single-family detached, 10 townhouse/duplex, 10 multifamily (apartment retrofit)
3. Representative of US Census income distribution (30% low-income, 40% middle-income, 30% upper-income)
4. Accessible for public tours and media (community acceptance requirement)
5. Signed homeowner agreement for 12-month monitoring with privacy protections

### P1.3 Data Collection Plan

| Data Category | Sensors per Home | Measurement | Frequency | Method |
|---|---|---|---|---|
| Ground-Induced Current | 4 (N-S, E-W, vertical, reference) | Current density (A/m²), electric field (mV/km) | 1 Hz continuous | Magnetotelluric sensors + utility reference data |
| Panel Shielding Effectiveness | 2 (wall interior vs. exterior field probe) | SE in dB, 1 kHz–10 GHz spot checks quarterly | Monthly | Handheld spectrum analyzer + reference antenna |
| Indoor Environmental Quality | 6 (temperature, humidity, CO₂, VOCs, PM2.5, radon) | Per EPA Indoor airPLUS standards | 5-minute intervals | Commercial IAQ monitors (Awair, Airthings) |
| Energy Usage | Whole-home + 6 circuit-level | kWh | 15-minute intervals | Utility smart meter + Sense energy monitor |
| Structural Health | 12 fiber optic strain gauges (foundation + walls) | Microstrain | 1 Hz continuous | FBG interrogator (Luna Innovations) |
| Water Quality | 2 (incoming + outgoing from GFRP pipe system) | pH, conductivity, chlorine residual, heavy metals | Weekly grab sample + continuous conductivity | In-line sensors + lab analysis |
| Occupant Comfort / Satisfaction | Monthly survey + continuous wearable (optional) | Thermal comfort (ASHRAE 55), acoustic, visual, overall satisfaction | Monthly | Validated post-occupancy evaluation (POE) survey instruments |
| Health Outcomes | Optional: heart rate variability (HRV), sleep quality, stress biomarkers | RMSSD, sleep duration/efficiency, cortisol (hair sample) | Pre-installation baseline + quarterly | Wearable (Oura/Whoop) + lab analysis |
| Maintenance Events | Logging by homeowner | Date, component, description, resolution | Continuous | Mobile app (Marmalade maintenance module) |
| Cost Data | Utility bills, maintenance costs, insurance premiums | $ | Monthly | Utility portal API + homeowner self-report |

**Data Volume Estimate:** ~2.5 TB per home per year (primarily from fiber optic strain gauge and IAQ sensor streams). Total study data: ~125 TB.

### P1.4 Success Criteria

| Criterion | Threshold | Measurement Method | Statistical Analysis |
|---|---|---|---|
| **Primary: GIC Reduction** | >94% reduction in induced current vs. control home (conventional construction, matched location) | Magnetotelluric sensor comparison between Aegis Home and control home at same substation feeder | Paired t-test, α=0.05, β=0.20 (80% power), minimum detectable effect = 5% difference |
| **Secondary: No Electrical Safety Events** | Zero shock incidents, zero fire events attributable to the dielectric electrical system | Incident reporting + annual NEC inspection by licensed electrician | Descriptive — any event triggers root cause analysis and potential design change |
| **Secondary: Energy Performance** | HERS Index <45 (vs. US average 100) | RESNET HERS rater assessment | One-sample t-test against HERS 100 baseline |
| **Secondary: Indoor Air Quality** | EPA Indoor airPLUS certification achieved | Independent verification | Pass/fail per EPA criteria |
| **Secondary: Occupant Satisfaction** | >90% of occupants "satisfied" or "very satisfied" at 12 months | Validated POE survey (7-point Likert scale) | One-proportion z-test against 80% benchmark |
| **Secondary: Durability** | <2% of monitored components exhibiting degradation requiring repair/replacement at 12 months | Maintenance log analysis | Descriptive with 95% confidence interval |
| **Secondary: Insurance Premium Impact** | Documented premium reduction of >5% for Aegis Home vs. comparable conventional home | Insurance carrier premium data (anonymized) | Independent samples t-test |

### P1.5 Control Group Design

For each Aegis Home, a matched control home will be identified:
- Same geographic area (within 5 km, same substation feeder)
- Same construction type (single-family, townhouse, apartment)
- Same approximate age (±5 years), square footage (±15%), and number of occupants
- Conventional construction (no EM hardening)
- Control homes receive same sensor package, with homeowner compensation ($500/year + free energy audit)
- 25 control homes (matched to instrumented Aegis Homes; 25 Aegis Homes matched to control; remaining 25 Aegis Homes unmatched — used for internal variability analysis)

---

## PILOT 2: INFRASTRUCTURE HARDENING PILOT

### P2.1 Program Overview

**Scope:** 5 electrical substations, 3 highway/railway bridges, and 2 pipeline sections  
**Timeline:** 6-month prep (Q2 2027–Q4 2027), 12-month monitoring (Q1 2028–Q4 2028), 6-month analysis (Q1–Q2 2029)  
**Total Duration:** 24 months  
**Budget:** $8.5M  
**Lead Agent:** Engineer Orion Cross (SILENCE) — infrastructure engineering  
**Utility Partners:** To be identified (target 3 electric utilities, 2 state DOTs, 1 gas pipeline operator)

### P2.2 Infrastructure Pilot Sites

| Site Type | Number | Product Deployed | Location Rationale | Partner |
|---|---|---|---|---|
| **Electrical Substation** | 5 | Aegis Fencing (BFRP posts + MXene mesh canopy), Transformer dielectric isolation pads (Si₃N₄/PTFE), Bus bar insulation upgrade | GIC-prone regions (2 in Pacific NW, 2 in Upper Midwest, 1 in Northeast — Quebec border for Hydro-Québec learnings) | Electric utilities (TBD) |
| **Highway Bridge** | 2 | Bridge bearing dielectric pads (AASHTO compliant), BFRP-reinforced deck sections, Geopolymer concrete pier jackets | Seismically active + GIC-prone (Cascadia and New Madrid zones) | State DOTs (WSDOT, MoDOT) |
| **Railway Bridge** | 1 | Railway signal protection (PMMA POF signal cables), Track circuit isolation, BFRP bridge ties | Northeast Corridor (Amtrak) — highest consequence of signal failure | Amtrak / FRA |
| **Natural Gas Pipeline** | 2 (10 km each) | GFRP dielectric joints at 500 m intervals, Cathodic protection compatibility verification | Pipeline in GIC-prone region with cathodic protection system (required for GFRP/pipeline interface study) | Pipeline operator (Kinder Morgan, Enbridge, or similar) |

### P2.3 Infrastructure Success Criteria

| Criterion | Threshold | Method |
|---|---|---|
| Substation GIC Reduction | >90% reduction in transformer neutral current vs. pre-installation baseline | Utility SCADA data + dedicated GIC monitors (Neutral current transformers) |
| Bridge Bearing Dielectric | >50 kV/mm dielectric withstand sustained for 12 months; no measurable GIC current through bearing | In-situ hipot testing + embedded current sensors |
| Railway Signal Reliability | Zero signal anomalies attributable to GIC during 12-month monitoring | Signal event recorder data + GIC correlation analysis |
| Pipeline Cathodic Protection | CP system effectiveness maintained at NACE SP0169 criteria (off-potential −850 mV vs. Cu/CuSO₄) with GFRP joints installed | Close-interval survey pre- and post-installation |

---

## PILOT 3: CHARLEMAGNE FLEET PILOT

### P3.1 Program Overview

**Scope:** Complete electromagnetic hardening retrofit of ONE Charlemagne-class cruise vessel (100,000 GT class, ~3,000 passenger capacity)  
**Timeline:** 6-month prep (engineering + materials procurement; Q3 2027–Q4 2027), 18-month retrofit (Q1 2028–Q2 2029), 12-month operational monitoring (Q3 2029–Q2 2030)  
**Total Duration:** 36 months  
**Budget:** $47M (vessel retrofit) + $3.8M (monitoring and analysis) = $50.8M  
**Lead Agent:** Captain Meridia Vaun (CHARLEMAGNE)  
**Cruise Line Partner:** To be identified (target: Carnival Corporation [brands: Princess, Holland America, Carnival], Royal Caribbean Group, or Norwegian Cruise Line Holdings — all three have Alaska/Pacific NW itineraries in GIC-prone corridors)

### P3.2 Vessel Selection Criteria

1. Vessel scheduled for dry dock during Q1 2028–Q2 2029 (routine maintenance window — retrofit piggybacks on planned dry dock)
2. Vessel operating in GIC-prone latitudes (>45°N or high-resistivity seafloor regions)
3. Vessel with cooperative engineering team and committed executive sponsor
4. Insurance carrier for vessel willing to provide premium data for before/after comparison
5. Classification society (ABS, DNV, or Lloyd's) willing to engage in the new technology qualification process

### P3.3 Retrofit Scope per Vessel

| System | Component | Material | Installation Scope | Verification Method |
|---|---|---|---|---|
| Hull | MXene spray coating (92 dB SE at 45 μm) | Ti₃C₂Tₓ MXene, epoxy binder | Full underwater hull + topsides, ~25,000 m² | Post-coating SE measurement via portable test fixture (every 100 m²) |
| Structure | BFRP stiffener replacement at identified conductive paths | BFRP/Elium pultruded profiles | Replace all steel-to-steel conductive paths at 200+ identified locations | DC resistance measurement (>10⁸ Ω target) |
| Wiring | PMMA POF replacement for all communication cables | PMMA core, MXene-coated, 62 fibers/harness | 47.3 km of copper communication cable replaced | Optical time-domain reflectometer (OTDR) verification per cable |
| Power | LiFePO₄ battery architecture for hotel loads | LiFePO₄ cells, ZrO₂ enclosure, GIC-hardened BMS | 20 MWh battery installation in former ballast tank compartment | Full charge/discharge cycling, BMS fault injection testing |
| Propulsion (emergency) | Piezoelectric emergency propulsion | KNbO₃-BaTiO₃ motor (2,000 HP target — note: TRL 2, may not be ready for pilot; fallback = hybrid diesel-electric with dielectric isolation) | Emergency propulsion pod, deployable | Sea trial under simulated GIC |
| Navigation | Fiber optic gyroscope (FOG) + PMMA POF data network | Commercial FOG (KVH, Northrop Grumman) with GIC-hardened power supply | Bridge navigation suite | Dockside + sea trial accuracy verification |
| Safety | Dielectric fire suppression pumps, Protonic emergency communication | Ceramic impeller pumps, H-FET transceivers | 5 fire zones, 12 communication nodes | System operational test |
| Entertainment | PMMA POF backbone for passenger Wi-Fi, in-cabin entertainment | POF with MXene EMI shielding | 3,000+ cabins, 20 public spaces | Bandwidth + uptime testing |

### P3.4 Charlemagne Pilot Success Criteria

| Criterion | Threshold | Method |
|---|---|---|
| Hull-Induced Current | <0.03% of unprotected baseline (measured via hull voltage differential during geomagnetic storm) | Hull voltage sensors (bow-to-stern, port-to-starboard) correlated with geomagnetic observatory data |
| Passenger Safety | Zero electromagnetic safety incidents during 12 months of commercial operation | Incident reporting + passenger/crew survey |
| Insurance Premium Impact | >12% reduction in hull and P&I (Protection & Indemnity) insurance premium for hardened vessel | Before/after premium comparison from vessel's insurance carrier |
| Classification Society Approval | ABS/DNV/Lloyd's class certificate issued with EM hardening notation | Formal class certificate |
| Operational Availability | <1% additional downtime attributable to EM hardening systems (i.e., systems do not reduce vessel operational availability) | Voyage data recorder analysis |
| Crew/Passenger Acceptance | >85% crew and passenger satisfaction with no negative impact on cruise experience | Survey instrument |

---

## PILOT 4: ROBOTICS PILOT — PHANTOM MK-1

### P4.1 Program Overview

**Scope:** Deployment of 10 Phantom MK-1 robots in electric utility environments for post-storm inspection and maintenance  
**Timeline:** 3-month prep (Q3 2028–Q4 2028), 6-month field deployment (Q1 2029–Q2 2029), 3-month analysis (Q3 2029)  
**Total Duration:** 12 months  
**Budget:** $8.5M (10 Phantom units at $180K each = $1.8M; telemetry infrastructure $2.2M; utility partner coordination $1.5M; field support team $2.0M; data analysis and reporting $1.0M)  
**Lead Agent:** Agent Nyx Calder (PHANTOM)  
**Utility Partners:** 3 electric utilities in GIC-prone regions (Pacific NW, Upper Midwest, Northeast)

### P4.2 Phantom Pilot Deployment Scenarios

| Scenario | Number of Deployments | Environment | Success Criteria |
|---|---|---|---|
| Post-Storm Damage Assessment | 20 (across 3 utilities, ~7 per utility) | Downed power lines, flooded substations, debris fields | Autonomous navigation in EMI + physical damage environment; identification of 95% of damage conditions vs. human inspector |
| Substation Inspection (Routine) | 30 (monthly deployments at 3 substations per utility) | Operating substation, 60 Hz fields, partial discharge RF noise | Thermal imaging anomaly detection; >90% match with human inspector findings |
| Transmission Line Right-of-Way Survey | 15 | Forested, mountainous terrain, variable weather | Autonomous path planning; vegetation encroachment detection |
| Emergency Communication Relay | 10 simulated events | Wide-area EMI, GPS-denied | Maintain PMMA POF or protonic mesh communication relay; zero dropped data packets |
| Combined-Environment Stress Test | 5 simulated events | Simultaneous EMI + rain + night operations | Full mission completion without degraded-mode fallback |

### P4.3 Phantom Pilot Data Collection

| Data Category | Sensors | Data Volume per Robot per Day |
|---|---|---|
| Actuator Performance (32 joints) | Torque, position, temperature, current draw | 500 MB |
| EMI Environment | Onboard GIC sensors, spectrum analyzer | 200 MB |
| Camera/Imaging | Thermal (FLIR), visual (4K), LIDAR point cloud | 15 GB (raw), 2 GB (compressed) |
| Navigation | GPS, IMU, wheel odometry, SLAM map | 300 MB |
| Communication | POF data bus traffic, protonic radio link quality | 50 MB |
| Battery / Power | State of charge, temperature, cell voltages | 10 MB |
| **TOTAL per robot per day** | | **~18 GB raw / ~3 GB processed** |

**Total Pilot Data Volume:** ~5.4 TB for 10 robots over 6 months.

---

## PILOT 5: PROTONIC COMMUNICATIONS PILOT

### P5.1 Program Overview

**Scope:** Deployment of 5 protonic communication nodes in field environment  
**Timeline:** 6-month prep (Q3 2027–Q4 2027), 12-month operation (Q1 2028–Q4 2028), 3-month analysis (Q1 2029)  
**Total Duration:** 21 months  
**Budget:** $3.8M  
**Lead Agent:** Agent Solara Vance (PROTON)

### P5.2 Node Deployment Configuration

| Node | Location | Deployment Type | Coverage Target |
|---|---|---|---|
| Node 1 (Master) | CSM El Segundo facility | Rooftop, grid-connected for baseline, piezo backup | Reference node — continuous calibration |
| Node 2 | Utility substation (Pacific NW) | Co-located with Infrastructure Pilot substation | GIC monitoring communication relay |
| Node 3 | Rural community center (Cascadia region) | Standalone, 100% piezo-powered, no grid connection | Post-disaster community communication hub |
| Node 4 | Charlemagne Pilot Vessel | Shipboard, integrated with vessel Protonic network | Maritime mobile node — communication during GIC events at sea |
| Node 5 | Emergency operations center (FEMA Region X) | Co-located with EOC backup communications | Government emergency communication integration |

### P5.3 Protonic Pilot Success Criteria

| Criterion | Threshold | Method |
|---|---|---|
| Uptime | >99.5% over 12 months (excluding planned maintenance) | Automated ping/heartbeat monitoring |
| Voice Quality | MOS (Mean Opinion Score) >3.5 at 3.4 kHz bandwidth | Subjective listening tests with trained evaluators quarterly |
| Text Reliability | Bit error rate <10⁻⁶ at 50 baud | Automated BER tester over 10⁶ bits per test |
| Range | >5 km node-to-node | RSSI measurement at graduated distances |
| Piezo Power Sustainability | Zero battery replacement or external charging events over 12 months | Power system telemetry |
| Interoperability | Successful voice bridge between Protonic Network and conventional VHF radio (via gateway) | Quarterly interoperability drill |
| FCC Compliance | No regulatory enforcement actions; FCC petition progressed | FCC correspondence tracking |

---

## PILOT 6: AEGIS EMBARK — VEHICLE PILOT

### P6.1 Program Overview

**Scope:** Installation of all 8 Aegis Embark products in 50 fleet vehicles (25 electric, 25 internal combustion) and 25 consumer vehicles  
**Timeline:** 6-month prep (Q4 2027–Q1 2028), 12-month monitoring (Q2 2028–Q1 2029), 3-month analysis (Q2 2029)  
**Total Duration:** 21 months  
**Budget:** $2.8M  
**Lead Agents:** All 8 Aegis Embark Agents (Nash, Kade, Draven, Cross, Arden, Voss, Fen, Dorne) — each responsible for their product's pilot segment

### P6.2 Fleet Partners

| Fleet Type | Number of Vehicles | Vehicle Type | Partner Type |
|---|---|---|---|
| Electric Utility Fleet | 15 | Ford F-150 Lightning / Chevrolet Silverado EV | Utility partner fleet vehicles (field service trucks) |
| Rideshare Fleet | 15 | Tesla Model 3/Y, Toyota Camry Hybrid | Rideshare driver partners (Uber/Lyft) |
| Long-Haul Trucking | 10 | Freightliner eCascadia, Volvo VNR Electric | Commercial fleet operator |
| Consumer (Early Adopter) | 25 | Various EV + ICE vehicles | Consumer volunteers recruited via CSM marketing channels |
| Government Fleet | 10 | Various (city/county fleet vehicles) | Municipal fleet manager partnership |

### P6.3 Aegis Embark Success Criteria

| Product | Key Metric | Threshold | Agent |
|---|---|---|---|
| Neural-Grip MRE Steering Wrap | Vibration reduction at 125 Hz | >90% reduction vs. baseline (pre-installation) | Nash |
| Cervical-Guard Headrest | Driver heart rate variability (RMSSD) | >15% improvement vs. baseline during 2-hour drive | Kade |
| Mag-Float Seat Rail | Seat adjustment force | <5 N (vs. 15–25 N for mechanical rails) | Draven |
| Silence-Block LRAM Door Insert | Cabin noise at 80–100 Hz | >15 dB reduction vs. baseline | Cross |
| Thorax-Calm STF Seatbelt | Belt webbing load during 15 mph crash test (sled) | >50% increase in energy absorption vs. standard belt | Arden |
| Stellar-Tint EV Window Film | Cabin solar heat gain | >40% reduction vs. clear glass; >80% NIR rejection | Voss |
| Fluid-Damp Gear Shift | Shift feel quality (subjective rating) | >4.0/5.0 average driver rating | Fen |
| Ulnar-Rest CLD Armrest | Vibration at armrest surface (10–50 Hz) | >80% reduction vs. baseline | Dorne |

---

## PILOT PROGRAM BUDGET SUMMARY

| Pilot Program | Prep | Active Phase | Analysis | Total Budget | Primary Funding Source |
|---|---|---|---|---|---|
| P1: Aegis Home (50 homes) | $1.8M | $3.5M | $900K | $6.2M | Series A + utility partner co-funding |
| P2: Infrastructure (5 substations, 3 bridges, 2 pipelines) | $2.2M | $5.1M | $1.2M | $8.5M | Series A + DOE/state grants |
| P3: Charlemagne Fleet (1 vessel) | $3.5M retrofit prep + $47M vessel = $50.5M | $3.5M monitoring (included) | $800K | $50.8M | Series B/C + cruise line co-investment |
| P4: Phantom Robot (10 units) | $2.5M | $4.8M | $1.2M | $8.5M | Series A + utility partner co-funding |
| P5: Protonic Communications (5 nodes) | $1.2M | $2.1M | $500K | $3.8M | Series A + NSF/FCC grants |
| P6: Aegis Embark (100 vehicles) | $800K | $1.6M | $400K | $2.8M | Series A + fleet partner co-funding |
| **TOTAL PILOT PROGRAM** | | | | **$80.6M** | |

**Total Pilot Program: $80.6M over 21–36 months (staggered start dates)**

---

## PILOT PROGRAM — DATA MANAGEMENT AND PUBLICATION PLAN

### Data Management

1. All pilot data stored in CSM Digital Twin platform (cloud-hosted, encrypted)
2. Raw sensor data retained for 10 years minimum
3. Data accessible to independent researchers via Data Use Agreement (non-commercial research only)
4. Personally identifiable information (PII) from homeowner/occupant data never shared; aggregate statistics only in publications

### Publication Plan

| Publication | Target Journal / Venue | Data Source | Timeline |
|---|---|---|---|
| "Measured GIC Reduction in Aegis Home Residential Buildings: 50-Home Controlled Pilot Study" | IEEE Transactions on Electromagnetic Compatibility or Building and Environment | P1: Aegis Home data | Q2 2029 |
| "Carrington-Hardened Cruise Vessel: First-Year Operational Data from Charlemagne Pilot" | Marine Structures or Ocean Engineering | P3: Charlemagne data | Q3 2030 |
| "Field Validation of a GIC-Immune Humanoid Robot for Post-Storm Utility Inspection" | IEEE Robotics and Automation Letters | P4: Phantom data | Q4 2029 |
| "Protonic Communication Network: 12-Month Field Trial of a Non-Electromagnetic Disaster Communication System" | Nature Communications or IEEE Communications Magazine | P5: Protonic data | Q2 2029 |
| "Human Factors of Carrington-Hardened Vehicle Interiors: Driver Physiological Response to Aegis Embark Products" | Ergonomics or Applied Ergonomics | P6: Aegis Embark data | Q3 2029 |
| "Geomagnetically Induced Current Reduction via Dielectric Infrastructure Retrofits: Substation, Bridge, and Pipeline Results" | IEEE Transactions on Power Delivery | P2: Infrastructure data | Q3 2029 |

### Independent Scientific Advisory Board

To ensure credibility of pilot results, CSM will establish an independent Scientific Advisory Board of 5–7 researchers in geomagnetism, power systems, building science, and statistics. Board members will:
- Review and approve study designs before pilot initiation
- Have unrestricted access to raw data (under confidentiality agreement)
- Be co-authors on all publications
- Receive honoraria ($15K/year) and travel support
- Have no financial interest in CSM (no equity, no consulting fees beyond honoraria)

---

## PILOT PROGRAM — RISK REGISTER

| Risk | Probability | Impact | Mitigation |
|---|---|---|---|
| Utility partner withdrawal | MEDIUM (25%) | Loss of pilot site; schedule delay | Over-recruit: 5 utilities for 3 slots; contingency sites identified |
| Homeowner dissatisfaction / withdrawal | MEDIUM (20%) | Data gap; negative publicity | Generous compensation ($500/year + free energy audit); responsive maintenance hotline; clear exit option (equipment removal at CSM cost) |
| Pilot product performance below specification | MEDIUM (30%) | Failure to meet success criteria; investor confidence | Pre-pilot laboratory testing gate (TRL 6 minimum before pilot); real-time monitoring to detect issues early; design iteration during pilot (acceptable if documented) |
| Cruise line partner not secured for Charlemagne pilot | HIGH (40%) | Schedule delay for entire Fleet program | Engage 3 cruise lines in parallel; consider government vessel (US Navy, USCG, NOAA) as alternative pilot platform |
| Data quality issues (sensor failure, data gaps) | MEDIUM (25%) | Reduced statistical power; publication delays | Redundant sensors on critical measurements; weekly data quality audits; 20% over-instrumentation budget |
| Regulatory / permitting delays for construction | MEDIUM (30%) | Schedule slip | Early engagement with building departments; pre-permitted prototype design; use of existing home retrofit (not new construction) for Phase 1 to reduce permitting complexity |

---

*"A pilot program is a promise made in data. Every sensor, every homeowner consent form, every peer-reviewed publication is a brick in the wall of credibility that separates a real company from a science project. When an insurance actuary asks for evidence that Aegis Home reduces GIC by 94%, we will not hand them a simulation. We will hand them 125 terabytes of peer-reviewed, independently verified field data from 50 homes over 12 months. That is the difference between a product and a proof of concept."* — Specialist Aura Kind (EMBARK)

---

*Document generated 2026-07-15. All pilot budgets are ±25% at P50 confidence. Partner identification is preliminary — formal MOUs required before pilot initiation. Statistical analysis plans to be finalized with independent biostatistician/epidemiologist review prior to data collection start. All human subjects research components (homeowner surveys, health outcome monitoring) require IRB approval from partner university.*
