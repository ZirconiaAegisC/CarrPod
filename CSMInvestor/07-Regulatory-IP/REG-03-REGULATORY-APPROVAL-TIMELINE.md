# REG-03: MASTER REGULATORY APPROVAL TIMELINE

**Document Classification:** Investor Confidential — For Due Diligence Purposes
**Date:** July 15, 2026
**Prepared by:** Viktor Kael (Regulatory Affairs Director) and Kairos Steele (Director)
**Document Ref:** CSM-REG-03-v1.2

---

## I. EXECUTIVE SUMMARY

This document presents the complete regulatory approval timeline for Carrington Storm Motors' product portfolio. Certification, qualification, and approval requirements are mapped across 9 regulatory domains, 14 standards bodies, and all 50-plus product designs. The critical path to first commercial revenue runs through UL certification (electrical safety) and ICC-ES evaluation (building code approval) for the ShieldCore EHV Transformer Housing — our lead product. The total regulatory cost is estimated at $6.5M over 3 years, allocated within the Series A budget.

The Williams Heuristic reminder: this type of timeline is inherently subject to revision. We have mapped every known dependency and estimated durations conservatively. The actual timeline will be affected by testing outcomes, standards committee decisions, and regulatory agency workloads that are outside our control. When we encounter delays, we will communicate them.

---

## II. REGULATORY DOMAINS AND APPLICABLE STANDARDS

### Domain 1: Electrical Safety — UL Certification

**Applicable Standards:**
- UL 1449 (Surge Protective Devices, 5th Edition): Applicable to SurgeGate GIC Blocker. Covers transient voltage surge suppressors for AC power circuits. Testing includes surge life, overvoltage, short-circuit current, and thermal runaway.
- UL 508 (Industrial Control Equipment): Applicable to GridFabric Distribution Station Shield (control module components). Covers industrial control panels and devices rated 1500 volts or less.
- UL 508A (Industrial Control Panels): Applicable to any assembled control panel within our products.
- UL 489 (Molded-Case Circuit Breakers): Applicable to any integrated circuit protection devices.
- UL 1446 (Systems of Insulating Materials — General): Applicable to transformer insulation systems incorporating our ceramic composite materials.

**Certification Body:** UL LLC (Underwriters Laboratories) — North American market. Alternative: Intertek (ETL Listed mark) or CSA Group for Canadian market.

**Timeline by Product:**
| Product | Applicable UL Standards | Pre-Test Duration | UL Submission to Certification | Total Duration |
|---------|------------------------|-------------------|------------------------------|----------------|
| ShieldCore EHV Transformer Housing | UL 1446, UL 508 (partial) | 4 months (at NIST, in-house) | 8-12 months | 12-16 months |
| SurgeGate GIC Blocker | UL 1449 | 3 months | 6-10 months | 9-13 months |
| GridFabric Distribution Shield | UL 508, UL 508A | 3 months | 8-12 months | 11-15 months |
| DriveShield Vehicle Kit | UL 1449 (low voltage variant) | 2 months | 4-8 months | 6-10 months |
| HomeShield Residential Panel | UL 1449, UL 489 (partial) | 3 months | 6-10 months | 9-13 months |

**UL Certification Strategy:**
- Pre-testing at NIST Boulder and in-house laboratory before formal UL submission reduces formal test-failure risk
- Engaging UL engineering staff early (initial meeting Q1 2027) to discuss novel material aspects before formal submission avoids surprises
- Parallel submission of related standards (e.g., UL 1449 and UL 1446 for products that require both) reduces calendar time

---

### Domain 2: Electromagnetic Compatibility — FCC Compliance

**Applicable Standards:**
- FCC Part 15 (Radio Frequency Devices): Applicable to any product containing digital electronics that may emit RF energy (protonic transceivers, digital control systems, communications modules).
- FCC Part 18 (Industrial, Scientific, and Medical Equipment): Applicable if any manufacturing equipment generates RF energy.

**Timeline:**
| Product Category | FCC Rule Part | Pre-Compliance Testing | Formal Testing to Grant | Total Duration |
|-----------------|--------------|----------------------|------------------------|----------------|
| Protonic Transceiver Network | Part 15 (Intentional Radiator) | 4 months (unique technology; FCC OET consultation required) | 6-10 months | 10-14 months |
| RelayDrone Communications Module | Part 15 (Intentional Radiator) | 3 months | 4-8 months | 7-11 months |
| GridFabric Control Module | Part 15 (Unintentional Radiator) | 2 months | 3-6 months | 5-8 months |
| HomeShield Smart Panel | Part 15 (Unintentional Radiator) | 2 months | 3-6 months | 5-8 months |

**FCC Compliance Strategy:**
- In-house pre-compliance testing using rented EMI test equipment reduces cost and identifies issues before formal testing
- FCC Office of Engineering and Technology (OET) consultation for protonic transceiver — this technology may not fit neatly into existing Part 15 categories, requiring guidance from FCC staff before testing can be properly scoped
- For products that do not contain intentional radiators (most of the terrestrial grid protection line), FCC compliance is straightforward (verification or Declaration of Conformity rather than Certification)

---

### Domain 3: National Standards — NIST Testing

**Applicable Standards and Programs:**
- NIST Special Publication 800-53 (Security and Privacy Controls): Cybersecurity requirements for products with digital interfaces
- NIST SP 1800 Series (Cybersecurity Practice Guides): Emerging standards for critical infrastructure cybersecurity
- NIST Materials Reference Data: Reference material characterization for MXene composites (not a certification, but essential for regulatory submissions that reference our materials data)
- NIST MEP (Manufacturing Extension Partnership): Technical assistance for pilot plant setup

**Timeline:**
- Materials characterization at NIST (independent verification of our EMI shielding data): Q1-Q3 2027
- Cybersecurity assessment for digital control products: Q2-Q4 2027 (dependent on product firmware maturity)
- Participation in NIST space-weather risk assessment workshops (ongoing): Positions CSM within the expert community and provides early awareness of emerging standards

**NIST Engagement Strategy:**
- NIST is not a certification body; it provides reference data, standards, and testing frameworks that inform mandatory certifications by other bodies
- CSM's engagement with NIST is primarily collaborative and reputational — establishing our materials data as NIST-verified reference data gives it authority in UL, ICC, and MIL-STD contexts
- Budget: $300,000 for NIST testing and collaborative R&D agreements over 3 years

---

### Domain 4: Building Code Approval — ICC-ES

**Applicable Standards:**
- International Building Code (IBC) — adopted by all 50 U.S. states
- International Residential Code (IRC) — residential applications
- ICC-ES AC156 (Acceptance Criteria for Seismic Certification by Shake-Table Testing): For products in seismic zones
- ICC-ES AC58 (Acceptance Criteria for Structural Insulated Panels): Potentially applicable to GridFabric panels if considered structural
- ICC-ES AC386 (Acceptance Criteria for Fiber-Reinforced Polymer Composite Systems): Applicable to MXene-polymer composite structural components

**Timeline:**
| Product | ICC-ES Evaluation Path | Submission to Report Issued | Seismic Testing (if required) | Total Duration |
|---------|----------------------|---------------------------|------------------------------|----------------|
| ShieldCore Transformer Housing | AC386 (FRP composite) — Innovation path | 12-18 months | 6-12 months (parallel) | 18-30 months |
| SubShield Foundation Package | AC58 / Innovation path | 12-18 months | May not require seismic | 12-18 months |
| GridFabric Distribution Shield | AC386 — Innovation path | 10-16 months | 6 months (parallel) | 16-22 months |
| Geopolymer Concrete (general) | Innovation path (no existing AC for dielectric concrete) | 18-24 months | 6-12 months (parallel) | 18-36 months |

**ICC-ES Strategy:**
- ICC-ES Evaluation Service is the most widely accepted evaluation agency for innovative building products in the U.S. An ICC-ES Evaluation Report (ESR) is accepted by building officials in all 50 states.
- Because many of CSM's products do not fit neatly into existing Acceptance Criteria, we will need to pursue evaluation under alternative paths — specifically, the "Innovation" path requiring more extensive testing and engineering analysis.
- For geopolymer concrete, we anticipate needing AC386 or a new AC to be developed. We have begun discussions with ICC-ES staff about developing a new Acceptance Criteria for dielectric concrete — a process that takes 12-18 months itself.
- We will engage an experienced ICC-ES consultant (identified: former ICC-ES senior staff engineer, available for engagement) to prepare our evaluation submittals.

---

### Domain 5: Maritime Classification — ABS/DNV/Lloyd's

**Applicable Standards:**
- American Bureau of Shipping (ABS) Rules for Building and Classing — applicable to Resilience-Class and Sentinel-Class vessels
- ABS Guide for Building and Classing Naval Vessels (if pursuing military contracts)
- DNV GL Rules for Classification — if built to European classification standards
- Lloyd's Register Rules and Regulations — for UK/international market

**Timeline:**
| Vessel Class | Classification Society | Design Review | Construction Survey | Sea Trials | Total Duration |
|-------------|----------------------|--------------|-------------------|-----------|----------------|
| Sentinel-Class Amphibious Walker | ABS (novel craft — special consideration required) | 8-12 months | 12-18 months | 4-6 months | 24-36 months |
| Resilience-Class Command Vessel | ABS / DNV (standard catamaran with novel materials) | 6-10 months | 10-14 months | 3-4 months | 19-28 months |
| Current-Class Submersible | ABS Underwater Vehicles Guide | 6-8 months | 8-12 months | 3-4 months | 17-24 months |

**Maritime Classification Strategy:**
- Engage ABS early (preliminary design review meeting in Q2 2027) to identify novel aspects requiring special consideration
- The Sentinel-Class amphibious walker presents unique classification challenges: it is not a conventional vessel, a submersible, or a land vehicle. ABS's "Novel Craft" classification pathway is the appropriate route, but it requires more extensive review.
- Ceramic-matrix composite hull materials are novel in maritime classification. ABS will require extensive material testing data and may require witnessed testing at ABS-approved laboratories.
- Estimated classification cost: $1.2M per vessel class (design review, survey, and testing fees). Budget $3.6M for three vessel classes over 5 years (not fully allocated in Series A; Series B covers maritime classification).

---

### Domain 6: Military Standards — MIL-STD Qualification

**Applicable Standards:**
- MIL-STD-188-125-1 (High-Altitude Electromagnetic Pulse (HEMP) Protection for Ground-Based C4I Facilities): The definitive U.S. military standard for EMP protection. Applicable to any product we sell to DoD or to contractors building DoD facilities.
- MIL-STD-461 (Electromagnetic Interference Characteristics): Subsystems and equipment EMI requirements.
- MIL-STD-810 (Environmental Engineering Considerations and Laboratory Tests): Temperature, humidity, vibration, shock, salt fog.
- MIL-STD-882 (System Safety): Safety requirements for defense systems.
- MIL-DTL-38999 (Connectors, Electrical, Circular, Miniature): If our products incorporate military-standard connectors.

**Timeline:**
| Product | MIL-STD Testing | Qualification Facility | Test Duration | Total Duration (incl. facility scheduling) |
|---------|----------------|----------------------|--------------|------------------------------------------|
| ShieldCore HEMP Protection (military variant) | MIL-STD-188-125-1 | White Sands Missile Range, NM or NAS Patuxent River, MD | 6-8 months of testing | 18-24 months |
| DriveShield (military vehicle variant) | MIL-STD-461, MIL-STD-810 | Various DoD-approved labs | 4-6 months | 12-18 months |
| FieldPak (military variant) | MIL-STD-188-125-1 (scaled) | White Sands / Pax River | 3-5 months | 12-18 months |

**MIL-STD Qualification Strategy:**
- Identify a DoD sponsor (program office or service branch) for each qualification effort. Qualification without a sponsor is significantly more difficult and expensive.
- The U.S. Army Corps of Engineers and Defense Critical Infrastructure Program are potential sponsors for grid protection products.
- Budget: $1.2M for MIL-STD-188-125 qualification (testing facility fees, engineering support, documentation). Allocated in Series A.
- The military qualification pathway is long but high-value: a MIL-STD-188-125 qualification is the gold standard for EMP protection and carries weight with civilian customers and international buyers.

---

### Domain 7: International Standards — IEC/ISO

**Applicable Standards:**
- IEC 61000 Series (Electromagnetic Compatibility): International equivalent of FCC Part 15, applicable in EU, UK, AU, JP, KR, and most other markets
- IEC 60076 Series (Power Transformers): International transformer standards; our ShieldCore housing would be assessed under these standards
- IEC 62305 Series (Protection Against Lightning): Adjacent standard; GIC protection is not lightning protection, but many of the test methodologies are transferable
- IEC 62443 Series (Industrial Network and System Security): Cybersecurity for industrial automation and control systems
- ISO 9001 (Quality Management Systems): Not a product certification, but an organizational certification required by many utility and government customers
- ISO 14001 (Environmental Management Systems): Required by some international customers and increasingly a utility procurement requirement

**Timeline:**
| Standard | Application | Development/Revision Cycle | CSM Engagement |
|---------|------------|---------------------------|---------------|
| IEC 61000-2-10 (GIC environment description) | New Work Item Proposal (NWIP) in development | 36-48 months to publication | Participate in working group (WG) |
| IEC 61000-5 (Installation and mitigation guidelines) | Existing standard; GIC-specific annex proposed | 24-36 months for revision | Propose GIC annex via U.S. National Committee (ANSI) |
| IEC 60076 (Transformer standard with GIC provisions) | Existing standard; GIC test methodology under development | 24-36 months | Participate in IEC TC 14 (Power Transformers) |
| ISO 9001 certification | Organizational | 12-18 months to initial certification | Engage registrar Q1 2027 |

**IEC/ISO Engagement Strategy:**
- CSM will pursue membership in relevant IEC Technical Committees (TCs) and ISO committees through the U.S. National Committee (administered by ANSI)
- Priority committees: IEC TC 14 (Power Transformers), IEC TC 77 (Electromagnetic Compatibility), IEC SC 77A (EMC — Low Frequency Phenomena), ISO TC 71 (Concrete, Reinforced Concrete and Pre-Stressed Concrete)
- Committee participation serves two purposes: (1) influence standards development to include provisions favorable to CSM's technology, and (2) early awareness of standards changes that could affect our products
- Budget: $85,000/year for committee membership dues, travel, and staff time

---

### Domain 8: Environmental and Safety — EPA/OSHA

**Applicable Standards:**
- EPA TSCA (Toxic Substances Control Act): Manufacturing of MXene nanosheets may require PMN (Pre-Manufacture Notice) or exemption determination. Nanoscale materials are subject to specific TSCA reporting requirements.
- OSHA PEL (Permissible Exposure Limits): Worker exposure limits for MXene precursor materials (HF, Ti compounds) during manufacturing.
- EPA RCRA (Resource Conservation and Recovery Act): Hazardous waste management for etching byproducts.
- EPA NPDES (National Pollutant Discharge Elimination System): Wastewater discharge permits for manufacturing facility.

**Timeline:**
- TSCA PMN determination: 3-6 months (begin Q1 2027, before pilot plant operation)
- OSHA compliance program development: 4-6 months (Q1-Q2 2027)
- RCRA waste determination: 2-4 months (Q1 2027)
- NPDES permit (if required): 6-12 months

---

### Domain 9: Export Controls — ITAR/EAR

**Applicable Standards:**
- International Traffic in Arms Regulations (ITAR — 22 CFR 120-130): Administered by DDTC. Applicable if our materials or products are determined to be defense articles.
- Export Administration Regulations (EAR — 15 CFR 730-774): Administered by BIS. Applicable to dual-use items. MXene materials and EMP protection technology may be controlled under EAR Category 3 (Electronics) or Category 1 (Materials).
- OFAC Sanctions (31 CFR 500-599): Country-level sanctions that may restrict sales to certain nations.

**Timeline:**
- Commodity Jurisdiction Request (ITAR vs. EAR classification): 3-6 months (submit Q3 2027)
- EAR Classification Request (ECCN): 2-4 months (submit Q3 2027 if not ITAR)
- Export license (if required for specific controlled items): 2-6 months per application

---

## III. CRITICAL PATH ANALYSIS

The critical path to first commercial revenue is the sequence of activities with zero float:

**Critical Path: ShieldCore EHV Transformer Housing → First Revenue**
1. Complete materials characterization for UL submission (4 months — Q1-Q2 2027)
2. UL 1446 certification (8-12 months — Q2 2027 to Q1 2028)
3. ICC-ES evaluation (18-30 months — Q3 2027 to Q1 2029)
4. Utility pilot installation contract (must be signed in parallel with certification — target Q3 2027)
5. First commercial installation with full certification: Q2 2029 (earliest) to Q1 2030 (conservative)

Total critical path duration: 30-36 months from Series A close.

**Near-Critical Paths (small float, monitor closely):**
- SurgeGate GIC Blocker UL certification: 9-13 months → revenue in Q3 2028
- SubShield Foundation ICC-ES evaluation: 12-18 months → revenue in Q1 2029
- DriveShield Vehicle Kit UL/FCC certification: 6-10 months → revenue in Q2 2028 (earliest revenue opportunity due to simpler certification pathway)

**Acceleration Opportunities:**
- Parallel testing: Where products share materials (e.g., MXene composite used in ShieldCore, DriveShield, and HomeShield), materials test data can be shared across certification applications, reducing per-product testing time by 2-4 months
- Pre-submission meetings: Formal pre-submission meetings with UL and ICC-ES staff identify testing requirements and potential issues before formal submission, reducing the risk of re-test cycles
- NIST collaboration: Joint testing programs at NIST may produce data that is accepted by UL and ICC-ES as equivalent to their own testing, accelerating the timeline
- Military qualification sponsorship: A DoD sponsor can prioritize testing at military facilities, potentially reducing scheduling delays from 6-12 months to 3-6 months

---

## IV. TOTAL REGULATORY COST ESTIMATE

| Domain | Year 1 (2027, $K) | Year 2 (2028, $K) | Year 3 (2029, $K) | Total ($K) |
|--------|-------------------|-------------------|-------------------|------------|
| Electrical Safety — UL | 450 | 820 | 520 | 1,790 |
| Electromagnetic — FCC | 180 | 280 | 150 | 610 |
| National Standards — NIST | 250 | 180 | 120 | 550 |
| Building Code — ICC-ES | 320 | 580 | 410 | 1,310 |
| Maritime — ABS/DNV | 80 | 180 | 220 | 480 |
| Military — MIL-STD | 300 | 450 | 450 | 1,200 |
| International — IEC/ISO | 120 | 180 | 200 | 500 |
| Environmental — EPA/OSHA | 100 | 80 | 50 | 230 |
| Export Controls — ITAR/EAR | 60 | 80 | 60 | 200 |
| Testing Equipment & Facilities | 280 | 180 | 80 | 540 |
| Consultants & Legal | 300 | 280 | 180 | 760 |
| Committee Memberships & Travel | 60 | 80 | 80 | 220 |
| Contingency (15%) | 375 | 495 | 378 | 1,248 |
| **Total** | **2,875** | **3,795** | **2,898** | **9,568** |

**Series A Allocation: $6.5M covers Years 1-2 plus initial Year 3 costs. Remaining $3.1M to be funded from initial product revenue (late Year 2/Year 3) and Series B proceeds.**

---

## V. GANTT-STYLE NARRATIVE TIMELINE

**Q1 2027 (Jan-Mar):**
- Initiate NIST materials characterization program
- File TSCA PMN for MXene manufacturing
- Begin UL pre-submission engagement (meetings with UL engineering staff)
- Engage ICC-ES consultant and begin evaluation scope definition
- Begin ISO 9001 pre-audit readiness assessment
- Initiate OSHA compliance program
- File I-129 petition for any H-1B specialized personnel

**Q2 2027 (Apr-Jun):**
- Submit first UL certification application (ShieldCore, UL 1446)
- Submit first FCC pre-compliance testing report (DriveShield)
- Begin ICC-ES evaluation submittal preparation (ShieldCore)
- ABS preliminary design review meeting for Sentinel-Class
- Initiate IEC TC membership applications via ANSI
- Begin export control classification (ITAR vs. EAR)

**Q3 2027 (Jul-Sep):**
- Submit ICC-ES evaluation package (ShieldCore)
- UL 1446 testing in progress
- MIL-STD-188-125 pre-qualification testing at in-house lab
- NIST EMI shielding reference data collection complete
- Export classification requests submitted (DDTC and BIS)
- Begin pilot utility NDA negotiations (3 utilities)

**Q4 2027 (Oct-Dec):**
- UL 1446 certification expected (optimistic) / testing continues (conservative)
- ICC-ES initial review comments received; respond to questions
- FCC Part 15 testing for DriveShield begins
- ISO 9001 Stage 1 audit
- EPA compliance confirmation for pilot plant

**Q1 2028 (Jan-Mar):**
- UL 1446 certification achieved (conservative date)
- Submit SurgeGate UL 1449 application
- Submit GridFabric UL 508 application
- FCC DriveShield testing complete; Declaration of Conformity issued
- MIL-STD-188-125 formal qualification testing scheduled at White Sands
- ISO 9001 Stage 2 audit

**Q2 2028 (Apr-Jun):**
- First commercial product certified: DriveShield Vehicle Kit (UL + FCC)
- DriveShield available for sale (earliest revenue product)
- ICC-ES structural testing for ShieldCore begins
- Pilot utility installation contracts signed (target: 3 utilities)
- Build first pilot ShieldCore unit at pilot plant

**Q3 2028 (Jul-Sep):**
- DriveShield first commercial sales
- First ShieldCore pilot installation (utility site)
- SurgeGate UL 1449 certification expected
- ICC-ES evaluation report for ShieldCore in final review
- MIL-STD-188-125 testing at White Sands (3-4 weeks of testing)

**Q4 2028 (Oct-Dec):**
- SurgeGate available for sale
- ICC-ES evaluation report for ShieldCore expected (optimistic)
- MIL-STD-188-125 qualification report received
- Begin Sentinel-Class ABS design review submission
- HomeShield UL 1449 submission

**Q1 2029 (Jan-Mar):**
- ShieldCore available for sale with ICC-ES evaluation report
- SubShield Foundation ICC-ES evaluation report expected
- HomeShield UL certification expected
- Sentinel-Class detailed design review with ABS
- IEC 61000-2-10 NWIP ballot (CSM to influence via USNC/IEC membership)

**Q2 2029 (Apr-Jun):**
- All 5 pilot utility installations complete and operational
- HomeShield available for retail sale
- GridFabric ICC-ES evaluation report expected
- Begin international certification process (CE marking, first products) via IEC standards compliance

**Q3-Q4 2029:**
- Full product line certification substantially complete for 12 priority products
- First international sales (Canada, UK) via mutual recognition of UL/ICC-ES certifications
- Sentinel-Class construction begins
- CE marking for first EU products (via IEC 61000 compliance)

**2030-2031:**
- Remaining product certifications completed
- International certifications for JP, KR, AU markets
- ISO 14001 certification
- IEC/ISO standards influence efforts begin producing results (new or revised standards incorporating GIC protection)
- Full product portfolio commercially available, certified, and insurable

---

## VI. REGULATORY RISK REGISTER (See RISK-04 for Detailed Treatment)

| Risk | Probability | Impact | Mitigation |
|------|-----------|--------|------------|
| UL certification delayed due to novel material | Medium | High | Early engagement with UL; pre-testing at NIST; budget contingency for re-testing |
| ICC-ES requires new Acceptance Criteria (12-18 month process) | Medium-High | High | Begin ICC-ES engagement in Q1 2027; pursue Innovation path as alternative |
| MIL-STD qualification without DoD sponsor | Medium | Medium-High | Identify DoD sponsor through military engagement pipeline |
| FCC OET delay for novel technology (protonic transceiver) | Medium | Medium | Early OET consultation; alternative: operate under experimental license until certification achieved |
| Export control classification restricts international sales | Low-Medium | Medium | Early classification requests; structure products to minimize controlled content |
| Insufficient testing capacity at qualified labs | Medium | Medium-High | Book test slots 6-12 months in advance; qualify multiple labs |
| Standards committee politics delays favorable standard | Medium | Medium | Active committee participation from Year 1; build relationships with committee chairs and key voting members |

---

**END OF DOCUMENT — CSM-REG-03-v1.2**
