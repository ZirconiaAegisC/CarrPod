# TEST-10: QUALITY MANAGEMENT SYSTEM
## Carrington Storm Motors — Project AEGIS
### ISO 9001:2015 Framework • Document Control • CAPA • Supplier Quality • Inspection • Calibration • Metrics

**Document Status:** QMS Design Document — ISO 9001:2015 Aligned  
**Version:** 1.0 — 15 July 2026  
**Classification:** CONFIDENTIAL — Quality System Documentation  
**Author:** Chester, Director of Quality Assurance — Aegis Operations Command  
**Approved By:** Director Kairos Steele, CITADEL  
**Target Certification Date:** Q1 2028 (ISO 9001:2015)

---

## QMS SCOPE STATEMENT

The Carrington Storm Motors Quality Management System encompasses the design, development, testing, manufacturing, installation, and servicing of electromagnetic hardening products for residential, infrastructure, maritime, robotic, automotive, and communications applications. The QMS applies to CSM's El Segundo, California facility and any satellite manufacturing, testing, or installation sites. Exclusions: None — all ISO 9001:2015 clauses are applicable to CSM operations.

---

## SECTION 1: CONTEXT OF THE ORGANIZATION (ISO 9001 Clause 4)

### 1.1 Interested Parties and Their Requirements

| Interested Party | Relevant Requirements | QMS Response |
|---|---|---|
| Customers (homeowners, utilities, cruise lines, automotive OEMs) | Products that meet specified GIC reduction performance; safety (electrical, fire, structural); reliability; warranty support | Product validation (TEST-03 through TEST-09); customer feedback system; warranty tracking |
| Regulatory Bodies (UL, FCC, ICC-ES, ABS, IATF) | Products certified to applicable standards; documented compliance | Regulatory compliance matrix (TEST-08); certification project management (ROAD-05) |
| Investors / Board | Return on investment; risk management; governance | Financial controls; milestone tracking (ROAD-10); risk register (ROAD-01, ROAD-03) |
| Employees | Safe workplace; fair compensation; career development | ISO 45001 (target Q4 2028); training records; performance management |
| Suppliers | Clear specifications; fair payment terms; long-term relationships | Supplier quality manual; purchase order terms; supplier development program |
| Society / Community | Environmental responsibility; public benefit | ISO 14001 (target Q4 2028); sustainability commitments (ROAD-03); open data policy (TEST-01) |

### 1.2 QMS Processes and Their Interactions

```
CUSTOMER REQUIREMENTS
        ↓
[SALES & CONTRACT REVIEW] → Quote, order, specification agreement (Sales + Agent)
        ↓
[DESIGN & DEVELOPMENT] → Product design, BOM, test plan (Agent + Zirconia — per ROAD-02/07)
        ↓
[PURCHASING & SUPPLIER MANAGEMENT] → Raw materials, components, services (Mork + Cross)
        ↓
[MANUFACTURING & ASSEMBLY] → Production per work instructions (Mork — per ROAD-03)
        ↓
[INSPECTION & TESTING] → Incoming, in-process, final inspection (Chester + Mork — per TEST-01 through TEST-09)
        ↓
[STORAGE & DELIVERY] → Warehouse, shipping, installation, commissioning (Mork + Kind)
        ↓
[CUSTOMER FEEDBACK & POST-DELIVERY] → Warranty, maintenance, customer satisfaction (Kind + Agent)
        ↓
[MANAGEMENT REVIEW] → Quarterly review of QMS performance (Steele + all Agents)
        ↓
[CONTINUAL IMPROVEMENT] → CAPA, lessons learned, preventive action (Chester)
```

---

## SECTION 2: LEADERSHIP (ISO 9001 Clause 5)

### 2.1 Quality Policy (Draft — Subject to Board Approval)

> **Carrington Storm Motors Quality Policy**
>
> Carrington Storm Motors designs, manufactures, and installs electromagnetic hardening products that protect human life and critical infrastructure from the existential threat of geomagnetic storms. Our quality commitment is absolute:
>
> 1. Every product shall meet or exceed its published specification for GIC reduction, EMI shielding effectiveness, and dielectric isolation.
> 2. Every measurement shall be NIST-traceable, independently verifiable, and publicly documented to the maximum extent consistent with the protection of trade secrets.
> 3. Every non-conformance shall be investigated to root cause, corrected, and trended to prevent recurrence.
> 4. Every employee is empowered and expected to stop production, halt testing, or quarantine product when quality is at risk.
> 5. Continuous improvement is not a program — it is the daily practice of finding and eliminating the gap between what we promised and what we delivered.
>
> This policy is communicated to all employees during onboarding and reviewed annually at the Management Review. It is posted at every CSM facility.

### 2.2 Organizational Roles and Responsibilities for Quality

| Role | Quality Responsibility |
|---|---|
| Director Steele | Ultimate authority for QMS; chairs Management Review; approves Quality Policy; allocates quality resources |
| Zirconia (Test Director) | Technical authority for test methods, specifications, pass/fail criteria, calibration program, ISO 17025 |
| Chester (QA Director) | Day-to-day QMS operation; document control; internal audit; CAPA; supplier quality; management representative for ISO 9001 certification |
| Mork (Fabrication Director) | Incoming inspection; in-process quality control; final inspection; production non-conformance management |
| Product Agents (18) | Product specifications; design reviews; first article approval; customer feedback analysis for their product |
| All Employees | Follow documented procedures; report quality issues; participate in corrective actions |

---

## SECTION 3: DOCUMENT CONTROL (ISO 9001 Clause 7.5)

### 3.1 Document Hierarchy

```
LEVEL 1: Quality Manual (this document — TEST-10) — QMS overview, scope, policy, process map
LEVEL 2: Procedures (TEST-01 through TEST-09, ROAD documents, work instructions) — How to perform processes
LEVEL 3: Work Instructions — Step-by-step instructions for specific tasks (manufacturing, testing, installation)
LEVEL 4: Records — Evidence of conformity (test reports, inspection records, calibration certificates, training records)
```

### 3.2 Document Control Requirements

| Requirement | Implementation |
|---|---|
| Unique Identification | Format: [TYPE]-[NUMBER]-[REV] (e.g., TEST-02-REV-B for Materials Testing Protocol, Revision B) |
| Approval Before Use | Reviewed by: Author → Product Agent → Zirconia (technical) or Chester (quality) → Steele (policy documents) |
| Version Control | All documents in Git repository (CSM GitHub organization) with commit history; PDF copies for external distribution |
| Availability at Point of Use | Digital: CSM intranet (Notion or Confluence); Printed: Controlled copy stamp, master copy log |
| Obsolete Document Control | Retained for audit trail; stamped "OBSOLETE — FOR REFERENCE ONLY"; removed from point of use |
| External Document Control | Standards (UL, ASTM, ISO, etc.) maintained in CSM Standards Library with subscription renewal tracking |

### 3.3 Records Control

| Record Type | Retention Period | Storage | Disposal |
|---|---|---|---|
| Test Reports | 10 years minimum (product life + warranty + potential litigation) | CSM Digital Twin + AWS S3 Glacier | Secure deletion after retention period |
| Calibration Certificates | Life of instrument + 3 years | QMS document system | Shred / secure delete |
| Training Records | Duration of employment + 3 years | HR system | Shred / secure delete |
| Customer Contracts | Life of contract + 7 years | Legal document system | Shred / secure delete |
| Non-Conformance Reports (NCR) | 5 years | QMS system | Shred / secure delete |
| Management Review Minutes | 5 years | QMS system | Shred / secure delete |
| Internal Audit Reports | 5 years | QMS system | Shred / secure delete |

---

## SECTION 4: CORRECTIVE ACTION PROCESS (ISO 9001 Clause 10.2)

### 4.1 CAPA Workflow

```
ISSUE IDENTIFIED → Non-conformance (NCR), customer complaint, audit finding, or employee observation
        ↓
IMMEDIATE CONTAINMENT → Quarantine affected product; notify customer if product shipped; stop process
        ↓
ROOT CAUSE ANALYSIS → 5-Why, Ishikawa (fishbone), or fault tree analysis; >80% of CAPAs require RCA within 30 days
        ↓
CORRECTIVE ACTION PLAN → Define action, owner, deadline; actions may include: design change (ECO), process change (WII), supplier action (SCAR), training
        ↓
IMPLEMENTATION → Execute corrective action; verify effectiveness (re-test, re-inspect, monitor)
        ↓
CLOSURE → Chester reviews and closes CAPA; recorded in CAPA log for trending
        ↓
EFFECTIVENESS CHECK → 3-month follow-up: has the issue recurred? If yes, re-open CAPA
```

### 4.2 CAPA Priority Matrix

| Priority | Definition | Response Time |
|---|---|---|
| P0 — CRITICAL | Safety issue; product recall required; regulatory non-compliance that could result in enforcement action | <24 hours containment; <72 hours RCA; <7 days corrective action |
| P1 — HIGH | Product does not meet critical specification (GIC reduction, SE, dielectric); >10% of production batch affected | <72 hours containment; <14 days RCA; <30 days corrective action |
| P2 — MEDIUM | Product meets specification but with reduced margin; isolated non-conformance (<1% of batch) | <1 week containment; <30 days RCA; <60 days corrective action |
| P3 — LOW | Cosmetic issue; documentation error; improvement opportunity | Next Management Review; continuous improvement backlog |

---

## SECTION 5: SUPPLIER QUALITY MANAGEMENT (ISO 9001 Clause 8.4)

### 5.1 Supplier Classification

| Classification | Definition | Requirements |
|---|---|---|
| **CRITICAL** | Single-source supplier; material with no substitute; failure would stop CSM production (e.g., Arkema Elium resin, Chemours Nafion, LORD MRF-140CG) | Annual on-site audit (or virtual with live video); quarterly business review; mandatory SCAR process; 6-month safety stock required |
| **MAJOR** | Supplier of key material with qualified alternatives (e.g., basalt fiber roving, ceramic powders, PEEK CF40) | Biennial audit; annual business review; incoming inspection per sampling plan; 3-month safety stock |
| **MINOR** | Supplier of commodity material with many alternatives (e.g., fly ash, sand/aggregate, packaging materials) | Certificate of conformance per shipment; incoming inspection reduced (skip-lot); no safety stock requirement (just-in-time acceptable) |

### 5.2 Supplier Audit Schedule

| Supplier | Classification | Last Audit | Next Audit | Auditor |
|---|---|---|---|---|
| Drexel Nanomaterials (MAX Phase) | CRITICAL | Not yet audited | Q4 2026 | Nash + Chester |
| Arkema (Elium resin) | CRITICAL | Not yet audited | Q1 2027 | Cross + Chester |
| LORD / Parker Hannifin (MRF-140CG) | CRITICAL | Not yet audited | Q1 2027 | Fen + Chester |
| Chemours (Nafion 115) | CRITICAL | Not yet audited | Q2 2027 | Vance + Chester |
| Technobasalt (basalt roving) | MAJOR | Not yet audited | Q4 2026 | Cross |
| CoorsTek (ceramic powders) | MAJOR | Not yet audited | Q1 2027 | Nash |
| Mitsubishi Chemical (PMMA POF) | MAJOR | Not yet audited | Q2 2027 | Cross |
| CATL / BYD (LiFePO₄ cells) | MAJOR | Not yet audited | Q3 2027 | Calder + Chester |

### 5.3 Supplier Corrective Action Request (SCAR)

When incoming inspection rejects a supplier lot or when a supplier-related non-conformance is identified:
1. Issue SCAR within 48 hours of identification
2. Supplier responds with containment plan within 5 business days
3. Supplier submits root cause analysis within 20 business days
4. Supplier implements corrective action within 40 business days
5. CSM verifies effectiveness via next 3 incoming lots (all must pass tightened inspection, AQL reduced by 50%)
6. If 3 consecutive SCARs from same supplier → supplier probation; CSM initiates alternative supplier qualification

---

## SECTION 6: INSPECTION AND TESTING (ISO 9001 Clause 8.6)

### 6.1 Incoming Inspection

| Material | Inspection | Method | Frequency | AQL | Equipment |
|---|---|---|---|---|---|
| MAX Phase Ti₃AlC₂ | Phase purity (XRD), particle size | XRD, Malvern Mastersizer | Every lot | 1.0% | XRD (shared), laser diffraction |
| Basalt Fiber Roving | Tensile, tex, sizing content | ASTM D2343, analytical balance | Every spool (for critical applications); every 10th spool (routine) | 1.0% | Instron, balance |
| Elium Resin | Viscosity, reactivity (DSC), water content | Rheometer, DSC, Karl Fischer | Every drum | 2.5% | Rheometer, DSC, titrator |
| MXene (in-process after etching) | XRD peak shift, XPS surface termination, 4-point probe R_sheet | XRD, XPS, 4-point probe | Every batch | 0.65% | XRD, XPS, 4-pt probe |
| Si₃N₄ Bearing Balls | Diameter, roundness, surface finish | CMM, profilometer, visual (5× mag) | 32 pc per 1,000 | 1.0% | CMM, profilometer, microscope |
| LiFePO₄ Cells | Capacity, internal resistance, visual | Cell cycler, milliohmmeter | 13 cells per lot (AQL 2.5) | 2.5% | Battery analyzer |

### 6.2 In-Process Inspection

| Process | Inspection | Frequency | Target |
|---|---|---|---|
| MXene Spray Coating | Thickness (profilometer), adhesion (cross-hatch), SE (portable test fixture) | Every 10th panel | 45±2 μm, 5B, SE >90 dB at 10 GHz |
| BFRP Pultrusion | Ultrasonic C-scan (voids), dimensional (laser micrometer), burn-off (fiber volume fraction) | Continuous (C-scan every 10 m) | Voids <2%, dim ±0.2 mm, Vf 58–62% |
| Flash Sintering (ZrB₂-SiC) | Density (Archimedes), hardness (Vickers), XRD (phase) | Every furnace run (20 plates) | Density >98% theoretical, HV10 >22 GPa, phase >99% |
| Aegis-C Panel Layer Stack | Layer registration (vision), thickness per layer (laser), SE per layer (probe) | Every panel | Reg ±0.5 mm, thickness per spec, SE per spec |
| Phantom Actuator Assembly | Torque, backlash, motor-to-chassis R | Every actuator | Torque ±5%, backlash <0.05°, R >10⁸ Ω |

### 6.3 Final Inspection

| Product | Test | Equipment | Acceptance | Sample Rate |
|---|---|---|---|---|
| Aegis-C Panel | Full-band SE, visual (AOI), dimensional (CMM) | TEM cell (sample), AOI, CMM | SE >148 dB, no defects, dim ±2 mm | 1/100 (SE), 100% (visual, dimensional) |
| Phantom MK-1 | 5-Phase CSMTest | TEM cell, shaker, thermal chamber | All 5 phases passed | 100% |
| Aegis Embark Product | Vibration attenuation, functional test | Vibration rig, function test | >90% of spec | 1/500 (vib), 100% (functional) |
| Protonic Transceiver | BER, voice quality, range | Test range, BER tester | BER <10⁻⁶, MOS >3.5, range >1 km | 100% |
| Infrastructure Component | Dielectric withstand (ASTM D149) | Hipot tester | >50 kV/mm | 100% |

---

## SECTION 7: CALIBRATION PROGRAM (ISO 9001 Clause 7.1.5)

### 7.1 Calibration Master Schedule

| Equipment | ID | Interval | Calibration Standard | Provider | Next Due |
|---|---|---|---|---|---|
| TEM Cell Field Uniformity | TEM-001 | 12 months | IEEE 299 | NTS or in-house | 2027-03 |
| VNA (Keysight N5227A) | VNA-001 | 12 months | NIST-traceable cal kit | Keysight | 2027-04 |
| Field Probes (E-field, ×4) | FP-E01 to E04 | 12 months | NIST-traceable | AR RF/Microwave | 2027-05 |
| Field Probes (H-field, ×2) | FP-H01 to H02 | 12 months | NIST-traceable | Beehive | 2027-05 |
| Universal Test Machine (Instron) | UTM-001 | 12 months | ASTM E4 Class 1 | Instron | 2027-02 |
| Environmental Chamber (T/RH) | EC-001 | 6 months | NIST thermocouple, RH std | In-house | 2027-01 |
| Profilometer (Bruker Dektak) | PROF-001 | 3 months | NIST step height | In-house | 2026-10 |
| XPS (Thermo K-Alpha) | XPS-001 | Monthly (BE) | Au, Ag, Cu reference | In-house | 2026-08 |
| 4-Point Probe (Jandel) | 4PP-001 | 6 months | NIST SRM | In-house | 2027-01 |
| High-Voltage Supply (Hipotronics) | HV-001 | 12 months | Precision divider | Cal lab | 2027-04 (upon procurement) |
| Rheometer (Anton Paar MCR302) | RHEO-001 | 12 months | Viscosity standard | Anton Paar | 2027-05 |
| CMM (Coordinate Measuring) | CMM-001 | 12 months | ISO 10360-2 | OEM service | 2027-05 |

### 7.2 Out-of-Calibration Procedure

If equipment is found out of calibration (failed calibration, overdue calibration, or suspected damage):
1. Quarantine equipment — tag "OUT OF CALIBRATION — DO NOT USE"
2. Assess impact: what products were tested with this equipment since last good calibration?
3. If impact assessment indicates potential product quality risk → recall affected products for re-test with calibrated equipment
4. Calibrate or repair equipment; return to service only after passing calibration

---

## SECTION 8: NON-CONFORMANCE TRACKING AND TRENDING

### 8.1 NCR Log Fields

| Field | Description |
|---|---|
| NCR Number | Sequential, year-prefix (e.g., NCR-2026-001) |
| Date | Date non-conformance identified |
| Source | Internal inspection, customer complaint, audit finding, supplier issue, employee observation |
| Product / Process | Affected product, BOM reference, or process step |
| Description | Detailed description of the non-conformance |
| Severity | P0 (Critical) / P1 (High) / P2 (Medium) / P3 (Low) |
| Disposition | Rework, Repair, Use-As-Is (with concession), Scrap, Return to Supplier |
| Root Cause | Determined by RCA process |
| Corrective Action | Description, owner, due date |
| Status | Open, In Progress, Closed, Re-opened |
| Closure Date | Date CAPA verified effective |

### 8.2 Quality Metrics — Monthly Dashboard

| Metric | Current (Q3 2026 Estimate) | Target | Trend |
|---|---|---|---|
| First-Pass Yield (products passing final inspection on first test) | N/A (insufficient data) | >90% | — |
| Customer Complaint Rate (per 100 units shipped) | 0 (pre-shipment phase) | <2.0 | — |
| Supplier Lot Rejection Rate | N/A (limited purchasing to date) | <3% | — |
| CAPA Closure Rate (closed within target timeframe) | N/A (QMS not yet operational) | >85% | — |
| Calibration Overdue Rate | 0% (all current) | <5% | 🟢 |
| On-Time Delivery | N/A (pre-delivery phase) | >95% | — |
| Warranty Claim Rate (at 24 months) | N/A (no products in field yet) | <2% | — |
| NCR Trend (open NCRs, new NCRs per month) | N/A | Decreasing over time | — |

---

## SECTION 9: INTERNAL AUDIT SCHEDULE

### 9.1 First-Year Audit Schedule (2027)

| Quarter | Audit Focus | Auditor | Standard Clause |
|---|---|---|---|
| Q1 2027 | Document Control + Records | Cross (trained internal auditor) | 7.5 |
| Q1 2027 | Purchasing + Supplier Management | Kind | 8.4 |
| Q2 2027 | Design & Development (Aegis Home) | Nash (peer audit) | 8.3 |
| Q2 2027 | Manufacturing Process Control | Dorne (peer audit) | 8.5 |
| Q3 2027 | Inspection & Testing + Calibration | Kade (peer audit) | 7.1.5, 8.6 |
| Q3 2027 | Non-Conformance + CAPA + Customer Feedback | Draven (peer audit) | 10.2, 9.1.2 |
| Q4 2027 | Full QMS — Stage 1 Certification Audit | External CB (TÜV SÜD or BSI) | All |
| Q1 2028 | Full QMS — Stage 2 Certification Audit (recommendation for ISO 9001) | External CB | All |

### 9.2 Internal Auditor Training

All 18 Agents of Aegis will complete ISO 9001 internal auditor training (2-day course, ~$950/person). Minimum 4 trained internal auditors (Chester + 3 rotating agents) to ensure audit independence (no one audits their own work).

---

## SECTION 10: MANAGEMENT REVIEW (ISO 9001 Clause 9.3)

### 10.1 Management Review Agenda — Quarterly

| Agenda Item | Inputs | Owner |
|---|---|---|
| Status of actions from previous Management Review | Previous meeting minutes | Chester |
| Changes in external and internal issues (context) | Market analysis, regulatory updates, technology trends | Steele |
| Customer satisfaction and feedback | Customer survey results, complaint data, warranty claims | Kind |
| Product conformity (quality performance) | First-pass yield, scrap rate, test data trends | Zirconia + Chester |
| Supplier performance | Supplier scorecards, SCAR log, on-time delivery | Mork |
| Non-conformance and corrective actions | NCR log trends, CAPA aging, effectiveness checks | Chester |
| Audit results | Internal and external audit findings, closure status | Chester |
| Resource adequacy | Staffing, equipment, budget vs. actual | Steele |
| Risks and opportunities | Risk register update; new opportunities identified | Steele + all Agents |
| Improvement recommendations | Employee suggestions, lessons learned, best practices | All |
| Quality Policy and Objectives Review | Are policy and objectives still appropriate? Need revision? | Steele + all |

### 10.2 Management Review Outputs

- Meeting minutes with action items, owners, and due dates
- Updated Quality Objectives for next quarter
- Resource allocation decisions
- Continuous improvement projects authorized
- Management Review report signed by Director Steele

---

## CONTINUOUS IMPROVEMENT — KAIZEN APPROACH

CSM adopts a Kaizen (continuous improvement) approach: every employee is empowered and expected to identify improvement opportunities. Formal Kaizen events (1-day focused improvement workshops) will be held quarterly starting Q1 2027, targeting one specific process per event (e.g., "Reduce MXene spray coating thickness variation from ±5 μm to ±2 μm").

### CI Metrics — 2027 Targets

| Metric | Baseline (Q4 2026 target) | 2027 Q4 Target |
|---|---|---|
| MXene SE variation (production batch CV) | <5% | <3% |
| BFRP pultrusion line yield | 85% | 95% |
| Aegis-C panel first-pass yield | 75% (estimate for new line) | 90% |
| Test report cycle time (plan → signed report) | 8 weeks | 4 weeks |
| Supplier lot acceptance rate | 97% | 99% |
| Employee quality suggestions per quarter | 0 (program not yet launched) | 20+ |

---

## QMS IMPLEMENTATION TIMELINE

| Phase | Activities | Timeline | Status |
|---|---|---|---|
| **Phase 0 — Foundation** | QMS design (this document); quality policy drafted; document control system procured; internal auditor training | Q3 2026 | 🟢 IN PROGRESS |
| **Phase 1 — Build** | Procedures and work instructions drafted; CAPA system deployed; calibration program launched; supplier evaluation begins; first internal audit round | Q4 2026–Q2 2027 | ⚪ |
| **Phase 2 — Stabilize** | 3 months of QMS operation with records; 2 internal audit cycles; Management Review #1; CAPA trending established | Q2–Q3 2027 | ⚪ |
| **Phase 3 — Certify** | Stage 1 audit (Q4 2027); Stage 2 audit (Q1 2028); ISO 9001:2015 certification issued | Q4 2027–Q1 2028 | ⚪ |
| **Phase 4 — Expand** | IATF 16949 (automotive), AS9100D (aerospace), ISO 17025 (lab), ISO 14001 (environmental), ISO 45001 (safety) per ROAD-05 timeline | 2028–2029 | ⚪ |

---

*"Quality is not a department. It is not a checklist. It is not the thing Chester does while everyone else builds products. Quality is the aggregate of every decision made by every person at Carrington Storm Motors — from Director Steele choosing to fund a second TEM cell instead of a marketing campaign, to Mork rejecting a batch of MXene that is 'almost' in spec, to Zirconia requiring 1,001 frequency points instead of 101 because the extra resolution might reveal a resonance that could kill someone. The QMS is the system that makes those good decisions easy and bad decisions visible. When ISO 9001 certification is awarded in Q1 2028, it will not be because we filled out the paperwork. It will be because we built a company where quality is the only acceptable outcome."* — Chester, Director of Quality Assurance

---

*Document generated 2026-07-15. QMS design phase complete — transition to Phase 1 (build) begins Q4 2026. External certification body selection to be completed Q3 2026 (TÜV SÜD America, BSI Group, or DNV GL Business Assurance preferred). ISO 9001:2015 certification target Q1 2028 as prerequisite for IATF 16949 (automotive) and AS9100D (aerospace) certifications.*
