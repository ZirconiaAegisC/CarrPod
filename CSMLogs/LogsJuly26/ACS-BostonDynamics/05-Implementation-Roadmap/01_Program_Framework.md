# Program Framework — ACS Engagement Roadmap

**Classification:** ACS Internal — Confidential  
**Date:** 15 July 2026  
**Version:** 1.0

---

## 1. Engagement Architecture

This section defines the structured approach for ACS advisory services across the Boston Dynamics robotics portfolio, organized into three sequential phases with defined deliverables, resource requirements, and decision gates.

### 1.1 Guiding Principles

1. **Data-Driven Diligence.** All recommendations are anchored in primary-source operational data (deployment metrics, TCO models, competitive benchmarking) rather than vendor-provided marketing claims.
2. **Client-Specific Relevance.** Deliverables are tailored to the client's sector (automotive manufacturing, warehouse logistics, industrial inspection, financial investment) rather than presented as generic robotics market analysis.
3. **Independent Verification.** Where feasible, ACS will conduct independent on-site observation at BD deployment facilities (Hyundai Georgia Metaplant, DHL/Maersk logistics centers) rather than relying solely on BD-provided data.
4. **Competitive Context.** Every BD-specific analysis includes competitive benchmarking against Figure AI, Tesla Optimus, Apptronik Apollo, Agility Robotics Digit, and relevant non-humanoid automation alternatives.

## 2. Phase I — Technical Due Diligence & Baseline Assessment (Q3 2026)

### 2.1 Objectives

Establish a verified fact base for BD's technical capabilities, operational metrics, unit economics, and competitive position prior to initiating Phase II deep-dive workstreams.

### 2.2 Workstreams

| Workstream | Activities | Deliverables | Duration |
|-----------|-----------|-------------|----------|
| **Atlas Unit Economics Deep-Dive** | Bill-of-materials estimation; actuator cost analysis (Mobis supply chain); assembly labor estimation; margin modeling at 500/2,000/6,000 unit annual volumes | Atlas BOM & Margin Model | 6 weeks |
| **Orbit Platform Extensibility Assessment** | Technical evaluation of Orbit API for third-party robot integration; competitive comparison with Siemens Insights Hub, PTC ThingWorx, and AWS IoT FleetWise | Orbit Platform Assessment Report | 4 weeks |
| **Actuator Supply Chain Resilience** | Hyundai Mobis actuator supply-chain mapping; rare-earth magnet dependency analysis; geopolitical risk assessment (China processing concentration); dual-sourcing feasibility | Supply Chain Risk Assessment | 5 weeks |
| **Competitive Benchmarking — Humanoids** | Detailed technical and commercial comparison of Atlas, Figure 02, Tesla Optimus, Apptronik Apollo, Agility Robotics Digit | Competitive Benchmarking Report | 6 weeks |
| **Regulatory Landscape Assessment** | Analysis of OSHA, EU Machinery Directive, ISO 10218/13849 applicability to bipedal humanoids in manufacturing; union collective-bargaining implications; municipal procurement restrictions on robotic public safety deployments | Regulatory & Labor Relations Report | 4 weeks |

### 2.3 Phase I Decision Gate

Proceed to Phase II only if:
- Atlas bill-of-materials and margin analysis indicate a credible path to gross-margin-positive unit economics at volumes ≤2,000 units/year.
- Actuator supply-chain assessment confirms Mobis's capacity to support Hyundai's 30,000 robots/year by 2028 target without compromising automotive component production.
- Competitive benchmarking confirms BD's maintainable differentiation (Orbit ecosystem, Mobis actuator integration, Gemini Robotics-ER cognitive partnership) against the most credible humanoid competitor.

## 3. Phase II — Client-Specific Deep-Dive & Deployment Planning (Q4 2026–Q1 2027)

### 3.1 Objectives

Develop client-specific business cases, TCO models, and deployment roadmaps for BD platform adoption. Phase II deliverables are sector-specific; a given client engagement may encompass one or multiple workstreams.

### 3.2 Workstreams

**For Automotive Manufacturing Clients:**

| Workstream | Activities | Deliverables |
|-----------|-----------|-------------|
| Atlas Manufacturing TCO Model | Client-specific TCO modeling incorporating local wage rates, shift patterns, union contract provisions, and facility-specific task profiles | Client-Specific Atlas TCO Model |
| Atlas Deployment Roadmap | Task-prioritization framework; phased deployment sequence (kitting → sub-assembly → quality inspection → heavy-lift assist); workstation integration planning | Deployment Roadmap & Milestone Schedule |
| Workforce Impact Assessment | Labor displacement analysis; retraining program design; union engagement strategy (where applicable); community impact mitigation planning | Workforce Transition Plan |
| On-Site Observation | Facilitated visit to Hyundai Georgia Metaplant for direct observation of Atlas production-floor deployment | Site Visit Report |

**For Warehouse Logistics Clients:**

| Workstream | Activities | Deliverables |
|-----------|-----------|-------------|
| Stretch TCO vs. Manual Labor | Client-specific TCO modeling incorporating local wage rates, trailer/container mix, parcel profile, and shift structure | Client-Specific Stretch TCO Model |
| WMS Integration Assessment | Evaluate client's WMS platform compatibility with Stretch API; integration complexity scoring; timeline estimation | WMS Integration Assessment |
| Multi-Site Rollout Plan | Staged deployment plan across multiple facilities; shared-spares inventory optimization; operator training program design | Multi-Site Deployment Plan |

**For Financial Investor Clients:**

| Workstream | Activities | Deliverables |
|-----------|-----------|-------------|
| BD IPO Readiness Assessment | Evaluation of financial reporting readiness, governance structure, intercompany transaction hygiene, auditor preparedness | IPO Readiness Scorecard |
| Valuation Model | DCF and comparable-company valuation incorporating Phase I unit-economics findings; scenario analysis (conservative/base/aggressive) | BD Valuation Model |
| Post-IPO Risk Assessment | Analysis of Hyundai control dynamics, related-party transaction risk, public-market quarterly earnings pressure, and competitive dilution timeline | Post-IPO Risk Report |

**For Public Safety Agency Clients:**

| Workstream | Activities | Deliverables |
|-----------|-----------|-------------|
| Spot Public Safety TCO & Grant Strategy | TCO modeling for EOD/hazmat/SWAT deployment; DHS UASI and other federal grant alignment; multi-agency shared-asset models | Public Safety Deployment & Funding Plan |
| Policy & Community Engagement | Civil-liberties impact assessment; community transparency framework; municipal procurement compliance; use-of-force policy integration | Policy & Community Engagement Framework |

### 3.3 Phase II Decision Gate

Proceed to Phase III only if:
- Client-specific TCO models demonstrate positive ROI within the client's investment horizon.
- Deployment roadmap is endorsed by client's operational leadership.
- Workforce transition plan (where applicable) is reviewed by client's HR, legal, and labor relations functions.

## 4. Phase III — Implementation Support & IPO Advisory (Q2 2027+)

### 4.1 Objectives

Support active client deployments of BD platforms and provide IPO readiness advisory services for pre-IPO institutional investors and for BD itself (if retained).

### 4.2 Workstreams

| Workstream | Activities | Deliverables |
|-----------|-----------|-------------|
| Deployment Oversight | Monitoring of client Atlas/Stretch/Spot deployments against Phase II roadmap; deviation reporting; corrective-action facilitation with BD | Monthly Deployment Status Reports |
| TCO Validation | Actual-vs.-projected TCO tracking; unit-economics model refinement based on real-world operational data | Quarterly TCO Validation Reports |
| IPO Positioning Advisory | Development of BD equity story elements for institutional investors; competitive differentiation articulation; risk-factor transparency framework | IPO Positioning Document |
| Post-IPO Governance Advisory | Ongoing governance recommendations for institutional investors; Hyundai intercompany transaction monitoring; quarterly earnings model maintenance | Quarterly Governance & Earnings Review |

## 5. Resource Requirements

| Role | Phase I | Phase II | Phase III |
|------|---------|----------|-----------|
| Robotics Engineering Lead | 1 FTE | 1–2 FTE (sector-dependent) | 0.5–1 FTE |
| Financial Analyst (Hardware/Manufacturing) | 1 FTE | 1 FTE | 0.5 FTE |
| Supply Chain / Manufacturing Specialist | 0.5 FTE | 1 FTE (automotive clients) | 0.25 FTE |
| Labor Relations / Workforce Specialist | 0.25 FTE | 0.5–1 FTE (automotive/logistics clients) | 0.25 FTE |
| Public Policy / Regulatory Specialist | 0.25 FTE | 0.25 FTE (public safety clients) | 0.1 FTE |
| Engagement Manager | 1 FTE | 1–2 FTE | 1 FTE |

**Estimated Total Engagement Value (Full Program, All Workstreams):** $3.5M–$6M across 12–18 months, client- and scope-dependent.

## 6. Key External Dependencies

| Dependency | Impact if Delayed |
|-----------|-------------------|
| BD cooperation on unit-economics disclosure | Phase I Atlas BOM & Margin Model requires BD-provided or BD-verified data; without cooperation, estimates carry wider error bands |
| Hyundai Metaplant Georgia access for on-site observation | Phase II Site Visit Report is contingent on Hyundai/BD granting facility access to ACS and client personnel |
| Atlas third-party commercial pilot announcement (non-Hyundai) | Without an independent customer reference, Atlas deployment recommendations carry higher deployment-risk weighting |
| CEO appointment (permanent) | Governance and strategy stability assessment for IPO advisory is contingent on clarity of permanent leadership |
