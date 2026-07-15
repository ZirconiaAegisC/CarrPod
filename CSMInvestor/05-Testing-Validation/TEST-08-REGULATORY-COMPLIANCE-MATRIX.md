# TEST-08: REGULATORY COMPLIANCE TESTING MATRIX
## Carrington Storm Motors — Project AEGIS
### Complete Standards-to-Product Mapping — UL • FCC • NIST • MIL-STD • IEC • ISO • ASTM • AASHTO • ABS • DNV

**Document Status:** Regulatory Compliance Dashboard — Updated Quarterly  
**Version:** 1.0 — 15 July 2026  
**Classification:** CONFIDENTIAL — Accredited Investor Eyes Only  
**Author:** Chester, Director of Quality Assurance, with Zirconia (Test & Validation)  
**Reference:** ROAD-05 (Certification & Regulatory Pathway) — this matrix operationalizes ROAD-05 into specific test requirements per product

---

## COLOR CODING

| Color | Meaning |
|---|---|
| 🟢 GREEN | Standard applicable; testing complete; certificate issued |
| 🟡 AMBER | Standard applicable; testing in progress |
| 🔴 RED | Standard applicable; testing not yet initiated — URGENT (blocking regulatory approval or customer requirement) |
| ⚪ WHITE | Standard applicable; testing scheduled in future quarter |
| ⬜ GRAY | Standard not applicable to this product |

---

## SECTION 1: ELECTRICAL SAFETY (UL)

| Product / Product Group | UL 94 (Flammability) | UL 723/E84 (Surface Burning) | UL 746C (Weathering) | UL 263/E119 (Fire Resist) | UL Product-Specific |
|---|---|---|---|---|---|
| Aegis-C Wall Panel | 🟡 AMBER | 🟡 AMBER | 🟡 AMBER | 🔴 RED (Q1 2027) | — |
| BFRP Rebar | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | 🟡 AMBER (with geopolymer system) | — |
| Safe-Wave Microwave | ⚪ WHITE (Q3 2027) | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 923: ⚪ Q3 2027 |
| Stellar-Chill Refrigerator | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 250: ⚪ Q3 2027 |
| Carrington-Proof Oven | ⚪ WHITE (Q3 2027) | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 858: ⚪ Q3 2027 |
| Ceramic Water Heater | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 174: ⚪ Q3 2027 |
| Inductive-Proof Wiring (PMMA POF) | ⚪ WHITE (Q1 2027) | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 83 (custom OoI): ⚪ Q2 2027 |
| Non-Conductive Motor | ⚪ WHITE (Q2 2027) | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 1004: ⚪ Q3 2027 |
| Aegis Home Energy Panel | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 508A: ⚪ Q1 2028 |
| Phantom MK-1 Battery | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 1973: ⚪ Q3 2028 |
| Phantom MK-1 Complete Robot | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 1740: ⚪ Q1 2029 |
| Ascension Drone Battery | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 1642: ⚪ Q3 2028 |
| Protonic Transceiver | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 62368-1: ⚪ Q2 2029 |
| Aegis Embark Products (8) | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | UL 2089 (modified): ⚪ Q3 2028 |

---

## SECTION 2: COMMUNICATIONS (FCC)

| Product | FCC Part 15.247 (Intentional Radiator) | FCC Part 15, Class A/B (Unintentional) | FCC Petition / Exemption | Status |
|---|---|---|---|---|
| LoRa Mesh Radio (EMF Detector, FEATHER) | 🔴 RED — Q1 2027 scheduled | ⬜ GRAY | ⬜ GRAY | FEATHER module uses pre-certified Semtech SX1276 — integration testing Q1 2027 |
| Protonic Transceiver | ⬜ GRAY | ⬜ GRAY | 🟡 AMBER — Petition filed Q4 2026 (target); ruling expected Q4 2027 | Exemption based on "no RF radiation" physics argument |
| PMMA POF Data Network | ⬜ GRAY | ⚪ WHITE — Q2 2027 | ⬜ GRAY | Minimal RF from optoelectronic transceivers |
| Phantom MK-1 Onboard Electronics | ⬜ GRAY | ⚪ WHITE — Q4 2027 | ⬜ GRAY | Industrial unintentional radiator |
| Ascension Drone Telemetry | 🔴 RED — Q2 2027 (Part 15.247 or Part 87) | ⬜ GRAY | ⬜ GRAY | May require FAA coordination if Part 87 |

---

## SECTION 3: ELECTROMAGNETIC RESILIENCE (NIST / MIL-STD)

| Product | MIL-STD-188-125 (HEMP) | MIL-STD-461 (EMI) | MIL-STD-810 (Environmental) | MIL-STD-882 (Safety) | NIST SP 800-53 (Cyber) |
|---|---|---|---|---|---|
| Phantom MK-1 Military Variant | 🔴 RED — 2029 (White Sands) | ⚪ WHITE — 2028 | ⚪ WHITE — 2028 | ⚪ WHITE — 2028 | ⚪ WHITE — 2028 |
| Phantom MK-1 Civilian | ⬜ GRAY (not pursuing) | ⚪ WHITE — 2027 (reference data) | ⚪ WHITE — 2027 (reference data) | ⚪ WHITE — 2028 | ⬜ GRAY |
| Protonic Network (Military) | ⬜ GRAY (protonic immune by physics) | ⬜ GRAY | ⚪ WHITE — 2028 | ⚪ WHITE — 2029 | ⚪ WHITE — 2029 |
| Aegis Home (Military Family Housing) | ⬜ GRAY (not pursuing) | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY |
| Infrastructure Products (DoD Bases) | 🔴 RED — 2029 | ⚪ WHITE — 2028 | ⚪ WHITE — 2028 | ⚪ WHITE — 2028 | ⚪ WHITE — 2028 |
| Ascension Drone Military Variant | ⬜ GRAY | ⚪ WHITE — 2029 | ⚪ WHITE — 2029 | ⚪ WHITE — 2029 | ⚪ WHITE — 2029 |

---

## SECTION 4: INTERNATIONAL ELECTROTECHNICAL (IEC)

| Product Group | IEC 61000-4-2 (ESD) | IEC 61000-4-8 (Mag Field) — CRITICAL | IEC 61000-4-3 (RF Immunity) | IEC 60243 (Dielectric) | IEC 62368-1 (Safety) |
|---|---|---|---|---|---|
| Aegis Home Electronics | ⚪ Q2 2027 | 🔴 RED — Q3 2027 | ⚪ Q2 2027 | ⚪ Q2 2027 | ⚪ Q3 2028 |
| Aegis Embark Products | ⚪ Q3 2027 | 🔴 RED — Q4 2027 | ⚪ Q3 2027 | ⚪ Q2 2027 | ⚪ Q1 2029 |
| Phantom MK-1 | ⚪ Q4 2027 | 🔴 RED — Q1 2028 | ⚪ Q4 2027 | ⚪ Q3 2027 | ⚪ Q3 2029 |
| Protonic Transceiver | ⬜ GRAY (protonic immune) | 🟡 AMBER — special test at 1,000 A/m | ⬜ GRAY | ⚪ Q3 2027 | ⚪ Q2 2029 |
| Infrastructure Electronics | ⚪ Q3 2028 | 🔴 RED — Q4 2028 | ⚪ Q3 2028 | ⚪ Q2 2028 | ⚪ Q4 2029 |
| Charlemagne Vessel Systems | ⚪ Q1 2028 | 🔴 RED — Q2 2028 | ⚪ Q1 2028 | ⚪ Q4 2027 | ⚪ Q2 2030 |

**IEC 61000-4-8 (Power Frequency Magnetic Field Immunity) is flagged RED for all products because this is THE certification that validates Carrington hardening. It must be prioritized.**

---

## SECTION 5: QUALITY MANAGEMENT (ISO)

| Standard | Scope | Timeline | Cost | Status |
|---|---|---|---|---|
| ISO 9001:2015 | CSM Enterprise — Quality Management | Q1 2028 | $85K | 🟡 AMBER — Gap analysis complete; QMS documentation in draft |
| ISO 14001:2015 | Environmental Management | Q4 2028 | $65K | ⚪ WHITE |
| ISO 45001:2018 | Occupational Health & Safety | Q4 2028 | $55K | ⚪ WHITE |
| ISO 27001:2022 | Information Security (LandOLil cloud) | Q3 2027 | $48K | ⚪ WHITE |
| ISO 17025:2017 | Testing Lab Competence | Q4 2029 | $120K | ⚪ WHITE |
| IATF 16949:2016 | Automotive Quality (Aegis Embark) | Q2 2029 | $95K | ⚪ WHITE |
| AS9100D | Aerospace Quality (Ascension drone) | Q2 2029 | $85K | ⚪ WHITE |

---

## SECTION 6: BUILDING CODE (ICC / IAPMO / International)

| Product | ICC-ES AC04 (Panels) | ICC-ES AC454 (BFRP Rebar) | ICC-ES AC470 (Geopolymer) | IAPMO (Plumbing) | California Title 24 | EU ETA | Status Summary |
|---|---|---|---|---|---|---|---|
| Aegis-C Wall Panel | 🔴 RED — Submit Q1 2027 | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⚪ Q3 2027 | ⚪ Q1 2028 | CRITICAL PATH |
| BFRP Rebar | ⬜ GRAY | 🔴 RED — Submit Q1 2027 | ⬜ GRAY | ⬜ GRAY | ⚪ Q3 2027 | ⚪ Q1 2028 | CRITICAL PATH |
| Geopolymer Concrete | ⬜ GRAY | ⬜ GRAY | 🔴 RED — Submit Q1 2027 | ⬜ GRAY | ⚪ Q2 2027 | ⚪ Q1 2028 | CRITICAL PATH |
| GFRP Pipe System | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | 🔴 RED — Q3 2027 | ⬜ GRAY | ⚪ Q2 2028 | |
| Complete Aegis Home | ⚪ Q4 2027 (AC481) | ⬜ GRAY | ⬜ GRAY | ⬜ GRAY | ⚪ Q3 2027 | ⚪ Q2 2028 | |

---

## SECTION 7: MARITIME CLASSIFICATION (ABS / DNV / LR)

| Product / System | ABS (Steel Vessel Rules) | DNV (Class Rules) | Lloyd's Register | IMO SOLAS | IMO FTP Code (Fire) | Status |
|---|---|---|---|---|---|---|
| Charlemagne Hull Coating (MXene) | 🔴 RED — Q2 2028 | 🔴 RED — Q2 2028 | 🔴 RED — Q3 2028 | ⚪ Q3 2028 | 🟡 AMBER — component testing in progress | New tech qualification required |
| BFRP Structural Elements | 🔴 RED — Q2 2028 | 🔴 RED — Q2 2028 | 🔴 RED — Q3 2028 | ⚪ Q3 2028 | 🟡 AMBER | Alternative material approval |
| PMMA POF Data Network | 🔴 RED — Q3 2028 | 🔴 RED — Q3 2028 | 🔴 RED — Q4 2028 | ⚪ Q4 2028 | 🔴 RED — cable fire testing | |
| LiFePO₄ Battery System | 🔴 RED — Q3 2028 | 🔴 RED — Q3 2028 | 🔴 RED — Q4 2028 | ⚪ Q4 2028 | ⚪ Q1 2029 | Battery propulsion guide |
| FOG Navigation | ⚪ Q1 2029 | ⚪ Q1 2029 | ⚪ Q2 2029 | ⚪ Q4 2028 | ⬜ GRAY | Type approval |
| Dielectric Fire Suppression | 🔴 RED — Q4 2028 | 🔴 RED — Q4 2028 | 🔴 RED — Q1 2029 | 🔴 RED — Q1 2029 | ⚪ Q1 2029 | Critical safety system |
| Protonic Emergency Comms | ⚪ Q2 2029 | ⚪ Q2 2029 | ⚪ Q3 2029 | ⚪ Q2 2028 (life-saving) | ⬜ GRAY | GMDSS supplementary |

---

## SECTION 8: AUTOMOTIVE (IATF / AEC / FMVSS)

| Aegis Embark Product | IATF 16949 (QMS) | AEC-Q200 (Components) | FMVSS Applicable | Status |
|---|---|---|---|---|
| Neural-Grip MRE Steering Wrap | 🔴 RED — Q2 2028 | 🔴 RED — Q2 2028 | FMVSS 124: 🔴 RED — Q3 2028 | |
| Cervical-Guard Headrest | 🔴 RED — Q2 2028 | 🔴 RED — Q2 2028 | FMVSS 202a: 🔴 RED — Q3 2028 | |
| Mag-Float Seat Rail | 🔴 RED — Q2 2028 | 🔴 RED — Q2 2028 | FMVSS 207: 🔴 RED — Q3 2028 | |
| Thorax-Calm Seatbelt | 🔴 RED — Q2 2028 | 🔴 RED — Q2 2028 | FMVSS 209: 🔴 RED — Q3 2028 | |
| Stellar-Tint Window Film | 🔴 RED — Q2 2028 | 🔴 RED — Q2 2028 | FMVSS 205: 🔴 RED — Q2 2028 | |
| All 8 Products (Aftermarket) | ⬜ GRAY | ⬜ GRAY | NHTSA "Make Inoperative" (49 USC 30122): ⚪ Q1 2028 — Letter of Interpretation | |

---

## SECTION 9: MATERIALS (ASTM)

| Material | ASTM Standards Applicable | Status |
|---|---|---|
| MXene Coating | D257, D4935, D3359, B117, G154 | 🟢 GREEN — baseline testing complete; durability in progress |
| BFRP Composite | D3039, D7264, D2344, D570 | 🟢 GREEN — baseline complete |
| BFRP Rebar | D7205, D7914, D7957 | 🟡 AMBER — D7914 long-term creep in progress (6-month test) |
| Geopolymer Concrete | C39, C496, C1202, C1760 | 🟢 GREEN — baseline complete |
| Si₃N₄ Ceramic Bearings | F2094 | 🟢 GREEN — specification verified |
| Polyimide-Silica Aerogel | C518, C165 | 🟢 GREEN — baseline complete |
| YInMn Blue Coating | G154, B117, D3359 | 🟡 AMBER — UV and salt spray in progress |
| PMMA POF Cable | D6577 (adapted), IEC 60794 series | 🟡 AMBER — fiber characterization in progress |
| MRF-140CG Fluid | D2196 (adapted) | 🟢 GREEN — rheological characterization complete |

---

## SECTION 10: PRIORITY BY URGENCY — TOP 10 ACTIONS

| # | Product | Standard | Urgency | Target Date | Owner |
|---|---|---|---|---|---|
| 1 | Aegis-C Wall Panel | ICC-ES AC04 | 🔴 CRITICAL — blocks all Aegis Home commercial sales | Submit Q1 2027 | Nyx + Chester |
| 2 | BFRP Rebar | ICC-ES AC454 | 🔴 CRITICAL — blocks structural use | Submit Q1 2027 | Nyx + Chester |
| 3 | Geopolymer Concrete | ICC-ES AC470 | 🔴 CRITICAL — blocks foundation use | Submit Q1 2027 | Nyx + Chester |
| 4 | All Electronic Products | IEC 61000-4-8 | 🔴 CRITICAL — core Carrington immunity certification | Q3 2027 (staggered by product) | Zirconia + all Agents |
| 5 | Protonic Transceiver | FCC Petition | 🟡 HIGH — regulatory uncertainty | File Q4 2026 | Vance + FCC counsel |
| 6 | Charlemagne Hull Coating | ABS/DNV NTA | 🔴 CRITICAL — blocks vessel retrofit | Q2 2028 | Vaun + class surveyors |
| 7 | Aegis Embark (8) | AEC-Q200 | 🔴 CRITICAL — blocks automotive supply | Q2 2028 | All Embark Agents |
| 8 | Aegis Embark (8) | IATF 16949 | 🔴 CRITICAL — prerequisite for AEC-Q200 and OEM supply | Q2 2028 | Nash (lead) + Chester |
| 9 | Aegis Home Wall Panel | UL 94/723/746C | 🟡 HIGH — prerequisite for ICC-ES and builder acceptance | Results Q2 2027 | Nyx + Chester |
| 10 | ISO 9001:2015 | Enterprise QMS | 🟡 HIGH — prerequisite for IATF, AS9100, ISO 17025 | Q1 2028 | Chester |

---

## REGULATORY COMPLIANCE BUDGET BY YEAR (from ROAD-05)

| Year | Total Compliance Cost |
|---|---|
| 2026 (Q3–Q4) | $588K |
| 2027 | $1.42M |
| 2028 | $2.08M |
| 2029 | $798K |
| 2030 | $216K |
| **5-Year Total** | **$5.10M** |

---

*"This matrix is the heartbeat of regulatory compliance. Every red cell is a blocker between a CSM product and its market. Every green cell is evidence that the Dielectric Citadel meets the standards of the civilization it protects. The priority is clear: building code approval unlocks Aegis Home; maritime classification unlocks Charlemagne; automotive certification unlocks Aegis Embark; IEC 61000-4-8 immunity unlocks the claim of Carrington hardening across all products. Clear the red cells. Earn the green cells. Ship the products."* — Chester, Director of Quality Assurance

---

*Document generated 2026-07-15. Updated quarterly. Next update: 2026-10-01 (Q4 2026 gate review). All RAG statuses to be re-evaluated based on progress against ROAD-01 and ROAD-10 milestones. New standards may be added as regulatory landscape evolves (e.g., potential NERC GIC reliability standard, EU Cyber Resilience Act applicability to Protonic/IoT products).*
