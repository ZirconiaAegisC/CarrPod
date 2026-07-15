# ROAD-08: SOFTWARE & DIGITAL PRODUCT ROADMAP
## Carrington Storm Motors — Project AEGIS
### LandOLil • Marmalade • SiblingFrequency • Digital Twin • Education • Installer • B2B

**Document Status:** Investor-Grade Software Roadmap  
**Version:** 1.0 — 15 July 2026  
**Classification:** CONFIDENTIAL — Accredited Investor Eyes Only  
**Author:** Zirconia, Director of Software Engineering — Aegis Operations Command  
**Technology Lead:** CSMApps division (El Segundo)

---

## SOFTWARE PHILOSOPHY

CSM software is built on one architectural principle: offline-first. Every CSM application assumes that the internet will not be available when it is needed most. The apps cache everything locally, encrypt everything at rest, sync opportunistically when networks are available, and gracefully degrade to peer-to-peer mesh communication when infrastructure fails. This is not a feature. This is the Dielectric Citadel Protocol applied to software — design for the worst case, because the worst case is why the product exists.

---

## PRODUCT 1: LANDOLIL — PROFESSIONAL INFRASTRUCTURE MONITORING PLATFORM

### S1.1 Product Overview

**Target User:** Electric utility engineers, infrastructure inspectors, insurance risk assessors, government emergency managers, certified CSM installers  
**Platform:** React Native (iOS, Android, tablet), Rust backend (sensor data processing, encryption), PostgreSQL cloud sync, SQLite local cache  
**Offline Mode:** Full functionality without internet; syncs via LoRa mesh or opportunistic Wi-Fi when available  
**Pricing:** Freemium (basic GIC monitoring free), Professional ($299/month per utility seat), Enterprise ($4,900/month for unlimited seats + API access)

### S1.2 Version History (10 Versions Built)

| Version | Release | Key Features | Status |
|---|---|---|---|
| v1.0 — "AEGIS" | Q4 2025 | GIC sensor data ingestion, real-time dashboard, basic alerting (threshold-based) | DEPLOYED |
| v2.0 — "CITADEL" | Q4 2025 | Multi-site management, role-based access control, PDF report generation | DEPLOYED |
| v3.0 — "PHANTOM" | Q1 2026 | Automated site survey, QR-coded equipment tagging, photo documentation with EXIF geotagging | DEPLOYED |
| v4.0 — "PROTON" | Q1 2026 | LoRa mesh network integration, offline sensor data relay, 256-node protocol support | DEPLOYED |
| v5.0 — "NEURAL" | Q2 2026 | Machine learning anomaly detection (isolation forest for GIC events), predictive alerting | DEPLOYED |
| v6.0 — "CERVICAL" | Q2 2026 | Dielectric installation logging with BOM verification, installation quality score (0–100), installer certification tracking | DEPLOYED |
| v7.0 — "MAG-FLOAT" | Q3 2026 | Premium credit reporting engine (insurance actuarial integration API), automated premium reduction calculation per hardened asset | DEPLOYED |
| v8.0 — "SILENCE" | Q3 2026 | Regulatory compliance dashboard (UL, FCC, ICC-ES, IATF status tracking per installation), automated compliance report generation | DEPLOYED |
| v9.0 — "THORAX" | Q3 2026 | Supply chain traceability (MXene batch → panel → home), environmental product declaration (EPD) generation, carbon accounting per installation | DEPLOYED |
| v10.0 — "STELLAR" | Q3 2026 | Digital twin integration API, real-time 3D visualization of hardened infrastructure, AR inspection overlay (iOS ARKit / Android ARCore) | DEPLOYED |

### S1.3 LandOLil Roadmap — Next Versions

| Version | Codename | Release | Key Features | Development Cost |
|---|---|---|---|---|
| v11.0 — "WAY-FINDER" | Q4 2026 | Evacuation route planning engine (GIC risk-weighted path finding), integration with Marmalade app for consumer-facing evacuation guidance | $120K |
| v12.0 — "PET-SAFE" | Q1 2027 | Multi-hazard risk overlay (GIC + seismic + flood + wildfire), FEMA IPAWS integration for automatic public alerting | $85K |
| v13.0 — "CLOUD-NEST" | Q2 2027 | Child/senior/vulnerable population registry for targeted evacuation, medical device EMI vulnerability database | $95K |
| v14.0 — "ASCENSION" | Q3 2027 | Drone fleet management integration (Ascension Seraphim swarm coordination), aerial GIC survey via drone-mounted magnetometers | $180K |
| v15.0 — "ULNAR" | Q4 2027 | Precision GIC modeling (down to individual building level using LIDAR + known material properties), risk scoring per building | $150K |
| v16.0 — "FLUID-DAMP" | Q1 2028 | Dynamic insurance pricing engine (real-time premium adjustment based on hardening level + current geomagnetic activity), blockchain-based smart contract integration for parametric insurance | $220K |
| v17.0 — "CHARLEMAGNE" | Q2 2028 | Maritime GIC monitoring (vessel-specific models, hull current tracking, port risk assessment), integration with ABS/DNV digital class platforms | $250K |
| v18.0 — "AEGIS-HOME" | Q3 2028 | Consumer-facing homeowner dashboard (pulled from Marmalade data with permission), community-level GIC risk heatmaps, neighborhood hardening leaderboard | $180K |
| v19.0 — "EMBARK" | Q4 2028 | Open API for third-party developers, SDK for GIC sensor manufacturers, data marketplace (anonymized GIC event data for researchers, insurers, governments) | $300K |

**LandOLil 5-Year Development Cost: $1.58M (v11–v19)**

### S1.4 LandOLil Technology Stack

| Layer | Technology | Rationale |
|---|---|---|
| Mobile Client | React Native 0.76+ | Cross-platform (iOS, Android) from single codebase; large developer ecosystem |
| Backend Services | Rust (Actix-web) | Memory safety, performance, suitable for embedded/edge deployment as well as cloud |
| Database (Cloud) | PostgreSQL 16 + PostGIS | Mature, open-source; PostGIS extension for geospatial queries (GIC risk mapping) |
| Database (Local) | SQLite via rusqlite | Embedded database for offline operation; identical schema to cloud for seamless sync |
| Message Queue | NATS | Lightweight, high-performance messaging for sensor data ingestion and real-time alerts |
| API Gateway | REST + WebSocket | REST for CRUD, WebSocket for real-time GIC data streams |
| Authentication | OAuth 2.0 + JWT | Industry standard; supports SSO for enterprise customers |
| Encryption | AES-256-GCM (at rest), TLS 1.3 (in transit) | FIPS 140-2 compliant; required for government and utility customers |
| Mesh Networking | LoRa (915 MHz ISM band) via Semtech SX1276 | Long-range, low-power, license-free; 256-node swarm protocol per FEATHER specification |
| ML Pipeline | Python (scikit-learn, PyTorch) → ONNX → Rust inference | Train in Python, export to ONNX, run inference in Rust for edge deployment |
| CI/CD | GitHub Actions → Docker → Kubernetes (AWS EKS) | Industry standard; blue/green deployments for zero-downtime updates |

---

## PRODUCT 2: MARMALADE — CONSUMER EMERGENCY PREPAREDNESS PLATFORM

### S2.1 Product Overview

**Target User:** Homeowners with Aegis Home systems, CarrPod owners, general public interested in Carrington preparedness  
**Platform:** React Native (iOS, Android), identical stack to LandOLil for component sharing  
**Offline Mode:** FULL offline-first — app designed to function for weeks without internet during an actual Carrington Event  
**Pricing:** Free (basic preparedness), Premium ($4.99/month — "What If" simulator, family mesh, advanced inventory), Homeowner ($9.99/month — Aegis Home monitoring + insurance premium credit dashboard)

### S2.2 Marmalade Development Stages

| Stage | Release | Features | Status |
|---|---|---|---|
| **Stage 1 — "PREPARE"** | Q4 2025 | Environmental controls (HVAC, lighting, water via Aegis Home API), basic system status dashboard, push notifications for GIC alerts | COMPLETE |
| **Stage 2 — "STOCK"** | Q4 2025 | Emergency preparation checklist (FEMA-based, customized for Carrington scenario), inventory tracker (food, water, medicine, batteries) with expiration date alerts, supplier links for CSM products | COMPLETE |
| **Stage 3 — "CONNECT"** | Q1 2026 | Family mesh communication (LoRa-based, text messaging between Marmalade devices within 10 km range), cached reference library (first aid, survival skills, water purification, food preservation), offline maps with GIC risk overlay | COMPLETE |
| **Stage 4 — "SIMULATE"** | Q3 2026 | "What If" Carrington Event Simulator — interactive branching scenario engine (player makes decisions during simulated Event, sees consequences), Monte Carlo simulation of 10,000 scenarios personalized to user's location and home hardening level, skill-building mini-games (radio operation, water purification, basic first aid) | IN DEVELOPMENT |
| **Stage 5 — "MONITOR"** | Q1 2027 | Real-time GIC monitoring via homeowner-installed EMF detector (CSMFAB021), whole-home energy monitoring, water quality monitoring via GFRP pipe sensors | DESIGN |
| **Stage 6 — "SHIELD"** | Q3 2027 | Aegis Home system control dashboard (per-room GIC status, panel health, wiring integrity), automated diagnostic routines, installer service request scheduling | DESIGN |
| **Stage 7 — "COMMUNITY"** | Q1 2028 | Neighborhood GIC resilience network — shares anonymized hardening data with neighbors to create community resilience map, mutual aid coordination tools, community drill scheduler | PLANNED |
| **Stage 8 — "LEARN"** | Q3 2028 | Gamified Carrington education (progressive learning path from basic science to advanced preparedness), "Dielectric Score" home assessment (AI-driven analysis of home photos to estimate GIC vulnerability), certification badges (shared to social media for community norm-building) | PLANNED |

**Marmalade 3-Year Development Cost: $1.65M (Stages 4–8)**

### S2.3 Marmalade — "What If" Simulator Architecture

The "What If" Simulator (Stage 4) is the centerpiece of Marmalade's consumer value proposition:

**Inputs:**
- User's geographic location (from device GPS or manual entry)
- Home hardening level (user-selected: None, Basic, Aegis Home Partial, Aegis Home Complete)
- Household composition (number of people, ages, medical needs)
- Season (affects heating/cooling needs)
- Preparedness level (from user's inventory tracker)

**Simulation Engine:**
- 10,000 Monte Carlo runs per scenario
- GIC model: surface electric field from 100 mV/km (minor storm) to 5,000 mV/km (Carrington-class)
- Grid failure model: probability of transformer failure based on GIC magnitude, cascading failure via topology model
- Consequence model: water pump failure → municipal water loss in 24–72 hours; refrigeration loss → food spoilage in 4–48 hours; communications loss → cellular/internet down immediately; fuel pumps → gasoline unavailable in 48 hours
- Survival model: temperature exposure, water availability, food availability, medical supply availability, communication ability, security

**Outputs:**
- Probability distribution of outcomes (days without power, water, communications)
- Recommended preparedness actions prioritized by impact
- "Before/After" comparison: user's current preparedness vs. Aegis Home Complete
- Shareable report (PDF) for family, employer, insurance carrier

**Development Cost:** $380K (Stage 4 alone — most complex Marmalade module)

---

## PRODUCT 3: SIBLINGFREQUENCY — RADIO SHOW & EDUCATIONAL CONTENT

### S3.1 Program Overview

**Format:** Narrative radio drama + educational companion pieces  
**Distribution:** CSMRadio.com, Apple Podcasts, Spotify, YouTube, emergency preparedness channels (FEMA, Red Cross distribution partnerships)  
**Cadence:** 4 episodes per season, 4 seasons planned (16 episodes total initial production, expandable to 20+)  

### S3.2 Episode Production Plan

| Season | Episode | Title | Theme | Products Featured | Agent Focus | Status |
|---|---|---|---|---|---|---|
| **S1 — THE STORM** | E1 | "The Star That Could Kill Us" | Carrington Event science primer — what it is, why it will happen again, what it does to modern infrastructure | MXene, Aegis-C, general materials science | Steele (CITADEL) | COMPLETE |
| | E2 | "Grid Fall" | Civilian experience during a Carrington Event — a family in their CarrPod/Aegis Home | Aegis Home, Marmalade app, EMF detector | Nyx (AEGIS HOME) | COMPLETE |
| | E3 | "The Fleet Sails" | Maritime perspective — crew and passengers on a Charlemagne-hardened vessel during the Event | Charlemagne Fleet, Protonic communications, LiFePO₄ power | Vaun (CHARLEMAGNE) | COMPLETE |
| | E4 | "Proton's Light" | Discovery narrative — the scientist who invents the protonic transceiver and activates the first post-Event communication network | Protonic Network, PMMA POF, piezo energy harvesting | Vance (PROTON) | COMPLETE |
| **S2 — THE SHIELD** | E5 | "Dielectric Citadel" | Construction narrative — building the first Aegis Home, challenges and triumphs | Aegis-C panel, BFRP rebar, geopolymer | Steele, Nyx | WRITING (Q4 2026) |
| | E6 | "The Cavalry Walks" | Phantom MK-1 first deployment — rescue mission in post-Event fire zone | Phantom MK-1, SiC/SiC actuators, VO₂ camouflage | Calder (PHANTOM) | WRITING (Q4 2026) |
| | E7 | "Silence and Thunder" | Aegis Embark product integration — a family's drive through the aftermath | All 8 Aegis Embark products | Nash, Kade, Draven, Cross, Arden, Voss, Fen, Dorne | WRITING (Q4 2026) |
| | E8 | "The Children of CarrPod" | Cloud-Nest, Pet-Safe, Way-Finder — protecting the most vulnerable | Cloud-Nest, Pet-Safe, Way-Finder, Embark | Rook, Solara, Solven, Kind | WRITING (Q4 2026) |
| **S3 — THE ASCENSION** | E9–E12 | (Titles TBD) | Global expansion — Aegis Home in Japan, Charlemagne Fleet in Mediterranean, Phantom in Australian outback, Protonic Network in Arctic research station | All products, international focus | All agents | PLANNING (2027) |
| **S4 — THE LEGACY** | E13–E16 | (Titles TBD) | 20 years later — the world after the Carrington Event, saved by the Dielectric Citadel | All products, retrospective | All agents, next generation | PLANNING (2028) |

### S3.3 Educational Companion Content

Each SiblingFrequency episode is accompanied by:
- 15-minute educational deep-dive (factual science behind the narrative)
- Downloadable preparedness checklist (PDF, localized per episode theme)
- Social media clip package (TikTok, Instagram Reels, YouTube Shorts — 60-second highlights)
- Teacher's guide (for high school/college earth science and physics curricula)
- "Ask an Agent" Q&A segment (featuring the actual CSM engineer behind the featured product)

### S3.4 SiblingFrequency Budget

| Category | Per Episode | Season (4 episodes) | Full Production (16 episodes) |
|---|---|---|---|
| Scriptwriting | $3,500 | $14,000 | $56,000 |
| Voice talent | $5,000 | $20,000 | $80,000 |
| Sound design + music | $6,000 | $24,000 | $96,000 |
| Post-production + mastering | $2,500 | $10,000 | $40,000 |
| Educational companion content | $2,000 | $8,000 | $32,000 |
| Marketing + distribution | $3,000 | $12,000 | $48,000 |
| **TOTAL per episode** | **$22,000** | **$88,000/season** | **$352,000 (16 episodes)** |

---

## PRODUCT 4: CSM DIGITAL TWIN PLATFORM

### S4.1 Platform Overview

**Purpose:** Comprehensive digital twin of all CSM products — physics-based simulation of electromagnetic, thermal, and structural behavior integrated with real-time sensor data from deployed products.

**Architecture:**
- **Simulation Engines:** CST Studio Suite (EM), Ansys Mechanical (structural), Ansys Fluent (thermal/CFD), custom Python models for GIC grid interaction
- **Data Integration:** Real-time GIC sensor data from LandOLil deployment → automatically updates twin boundary conditions; compares predicted vs. measured performance
- **User Interfaces:**
  - Engineer Dashboard: Full physics simulation access, parameter sweeps, design optimization
  - Customer Dashboard (LandOLil v10+): Simplified 3D visualization of their hardened assets with real-time GIC risk overlay
  - Insurance Dashboard (B2B Portal): Actuarial risk modeling based on actual product performance data
- **API:** REST + WebSocket for third-party integration; GraphQL for complex queries

### S4.2 Development Phases

| Phase | Timeline | Features | Cost |
|---|---|---|---|
| Phase 1 — Foundation | Q3 2027–Q4 2027 | CST/Ansys model library for all CSM products; single-asset digital twin (Aegis Home prototype); batch simulation capability | $1.2M |
| Phase 2 — Real-Time | Q1 2028–Q2 2028 | Sensor data ingestion pipeline; real-time twin updating (latency <5 minutes from sensor to twin); anomaly detection (twin predicts nominal, sensor reports actual → difference = anomaly) | $1.5M |
| Phase 3 — Multi-Asset | Q3 2028–Q4 2028 | Multi-asset digital twin (50 Aegis Homes, 5 substations, 1 Charlemagne vessel, 10 Phantom robots simultaneously); portfolio-level risk visualization | $900K |
| Phase 4 — Predictive | Q1 2029–Q2 2029 | Predictive maintenance (twin forecasts component degradation based on environmental exposure + operational data); automated design optimization (twin explores design space to suggest improvements for MK-2 products) | $600K |

**CSM Digital Twin Total Development Cost: $4.2M**

---

## PRODUCT 5: CONSUMER EDUCATION PLATFORM

### S5.1 Platform Overview

**Target Users:** General public, homeowners, students, journalists  
**Goal:** Educate 10 million people about Carrington Event risk and CSM solutions by 2030  
**Platforms:** Web (responsive), mobile (integrated into Marmalade), social media micro-content

### S5.2 Content Architecture

| Module | Content | Format | Development Cost |
|---|---|---|---|
| "Carrington 101" | What is a CME? What is GIC? Why should I care? | Animated explainer video (5 min) + interactive infographic | $45K |
| "Is Your Home Ready?" | Self-assessment tool — 10 questions → GIC vulnerability score | Interactive web app with Marmalade integration | $85K |
| "Dielectric Score" | AI-powered photo analysis — user uploads photos of their home's electrical panel, foundation, wiring, and appliances → AI estimates GIC vulnerability and recommends specific CSM products | Computer vision model trained on CSM product catalog + construction material database | $180K |
| "The 72-Hour Challenge" | Gamified preparedness challenge — users complete one preparedness task per day for 72 days → earn "Dielectric Ready" certification badge | Mobile-first progressive web app | $120K |
| "Community Resilience Map" | Crowdsourced map of neighborhood hardening status (opt-in, anonymized) — motivates community norm-building ("my neighbors are hardening, I should too") | Web + mobile, integrated with Marmalade Stage 7 | $150K |
| "School Curriculum" | 10-lesson Carrington Event curriculum for grades 6–12 (earth science, physics, engineering) — aligned with NGSS standards | Downloadable lesson plans, videos, hands-on activities (build a simple Faraday cage, measure EMI with smartphone magnetometer) | $95K |

**Consumer Education Platform Development Cost: $675K**

---

## PRODUCT 6: INSTALLER TRAINING PLATFORM

### S6.1 Platform Overview

**Target Users:** Licensed electricians, general contractors, home builders seeking AEGIS CERTIFIED Installer designation  
**Goal:** Certify 500 installers by 2029, 2,000 by 2031  
**Pricing:** $1,495 per installer for certification program (3-day in-person + online assessments + annual recertification)

### S6.2 Training Platform Architecture

| Module | Content | Format | Development Cost |
|---|---|---|---|
| Theory | Carrington Event science, GIC physics, dielectric principles, MXene properties, BFRP handling, geopolymer concrete mixing | 8 hours video + interactive quizzes | $65K |
| Aegis Home Installation | Step-by-step for all 18 Aegis Home products — panel mounting, BFRP rebar placement, PMMA POF wiring termination, GFRP pipe joining, appliance installation | 16 hours video + VR simulation (Meta Quest) for hands-on practice without material waste | $220K |
| Testing & Commissioning | Post-installation testing procedures — GIC measurement, SE verification, insulation resistance, ground fault testing | 8 hours video + in-person practical exam | $85K |
| Safety | Electrical safety with dielectric systems, working at heights, confined space entry (geopolymer pour) | 4 hours video + OSHA 10 certification bundle | $35K |
| Sales & Customer Education | How to explain Carrington risk to homeowners, how to position Aegis Home value proposition, financing and insurance premium reduction explanation | 4 hours video + role-play scenarios | $45K |
| Certification Exam | 100-question written exam + practical demonstration (install one Aegis-C panel, terminate one PMMA POF connector, mix one batch of geopolymer) | In-person at CSM training center or authorized regional center | Included in platform cost |

**Installer Training Platform Development Cost: $450K**

---

## PRODUCT 7: B2B INSURANCE PORTAL

### S7.1 Platform Overview

**Target Users:** Insurance carrier actuaries, underwriters, and risk managers at Swiss Re, AXA, Chubb, and regional carriers  
**Purpose:** Provide insurance carriers with the actuarial data needed to price premium reductions for CSM-hardened assets  
**Data Provided:** GIC risk maps, hardening effectiveness data (from pilots), claims experience comparison (hardened vs. unhardened), parametric insurance trigger design

### S7.2 B2B Portal Features

| Feature | Description | Development Cost |
|---|---|---|
| Actuarial Data API | REST API providing GIC event probability, hardening effectiveness data, and claims impact projections per ZIP code, building type, and hardening level | $380K |
| Parametric Insurance Designer | Tool for insurance carriers to design parametric insurance products triggered by GIC magnitude (NOAA Space Weather Prediction Center Kp index or Dst index) | $250K |
| Portfolio Risk Dashboard | Carrier-specific dashboard showing aggregate GIC risk across their book of business, highlighting policies with highest GIC exposure for targeted hardening recommendations | $320K |
| Premium Credit Calculator | Automated calculation of premium reduction justified by CSM hardening — inputs: building type, location, hardening level → output: recommended premium credit (%) with actuarial justification | $180K |
| Claims Correlation Engine | Statistical analysis linking geomagnetic storm events to actual insurance claims (property, business interruption, equipment breakdown) using NOAA SWPC data + carrier claims data (anonymized) | $420K |
| Regulatory Filing Support | Document generation for state insurance department filings justifying GIC-hardening premium credits as "actuarially sound" per state rate regulations | $150K |

**B2B Insurance Portal Development Cost: $1.7M**

---

## SOFTWARE DEVELOPMENT BUDGET — 5-YEAR CONSOLIDATED

| Product | 2026 (Q3–Q4) | 2027 | 2028 | 2029 | 2030 | 5-Year Total |
|---|---|---|---|---|---|---|
| LandOLil (v11–v19) | $120K | $510K | $630K | $300K | — | $1.56M |
| Marmalade (Stages 4–8) | $380K | $520K | $450K | $300K | — | $1.65M |
| SiblingFrequency (16 episodes) | $88K | $88K | $88K | $88K | — | $352K |
| Digital Twin Platform | — | $1.2M | $2.4M | $600K | — | $4.2M |
| Consumer Education | — | $370K | $305K | — | — | $675K |
| Installer Training | — | $250K | $200K | — | — | $450K |
| B2B Insurance Portal | — | $420K | $580K | $700K | — | $1.7M |
| **ANNUAL TOTAL** | **$588K** | **$3.36M** | **$4.65M** | **$1.99M** | **$0** | **$10.58M** |

Note: Post-2029 software development transitions from build phase to maintenance + enhancement phase. Ongoing maintenance budget: ~$1.2M/year for all platforms combined (hosting, DevSecOps, customer support, minor enhancements).

---

## SOFTWARE TEAM GROWTH PLAN

| Role | 2026 (Current) | 2027 | 2028 | 2029 |
|---|---|---|---|---|
| Software Engineers (React Native) | 3 | 8 | 12 | 8 |
| Backend Engineers (Rust) | 2 | 5 | 8 | 6 |
| ML/Data Engineers | 1 | 3 | 5 | 4 |
| DevOps/Cloud Engineers | 1 | 2 | 3 | 3 |
| UX/UI Designers | 1 | 3 | 4 | 3 |
| QA Engineers | 1 | 3 | 4 | 3 |
| Technical Writers | 1 | 2 | 3 | 2 |
| Product Managers | 1 (Zirconia) | 3 | 4 | 4 |
| **TOTAL** | **11** | **29** | **43** | **33** |

**Annual Software Team Cost:** $1.5M (2026) → $4.2M (2027) → $6.5M (2028) → $5.1M (2029)

---

*"Software is the nervous system of the Dielectric Citadel. The physical panels block the current. The sensors measure the field. The apps tell you what is happening and what to do about it. LandOLil is the professional interface — the tool that proves to an insurance actuary that a substation is hardened. Marmalade is the human interface — the app that tells a mother that her children are safe in their Cloud-Nest seats and her Aegis Home is holding. SiblingFrequency is the cultural interface — the stories that make Carrington preparedness feel not like paranoia but like wisdom. If the hardware is the body of Project AEGIS, the software is the soul."* — Zirconia, Director of Software Engineering

---

*Document generated 2026-07-15. Software development cost estimates are ±20% at P75 confidence (well-understood technology stack, experienced team). Timelines assume full-stack internal team with selective contractor augmentation for specialized work (VR training content, animation, voice talent). All software products are designed for AWS cloud deployment with edge computing capability (AWS Wavelength for utility substation deployments, AWS Outposts for sensitive government customers).*
