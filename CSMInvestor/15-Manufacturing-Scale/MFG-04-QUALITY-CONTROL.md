# MFG-04: Carrington Storm Motors — Quality Control and Assurance

**Document ID:** CSM/MFG/04
**Version:** 1.0 — Investor-Grade
**Classification:** Confidential
**Heuristic Foundation:** Accountant (quality metrics discipline), Zirconia (materials testing rigor), El Segundo (zero-failure imperative)
**Agents Consulted:** Manufacturing domain agent, Zirconia, Quality domain agent, Accountant
**Date:** July 2026

---

## 1.0 EXECUTIVE SUMMARY

For Carrington Storm Motors, quality is not a cost center — it is the product. A transformer protection system that fails during a Carrington Event doesn't just lose a customer — it potentially causes a cascading grid failure that could have been prevented. The consequences of quality failure are measured in billions of dollars and thousands of lives.

This document outlines CSM's quality control and quality assurance framework: incoming material inspection, in-process quality checks, final product testing, statistical process control, Six Sigma program, ISO 9001/AS9100 certification timeline, warranty/returns policy, and continuous improvement program.

As Zirconia frames it: "When the Sun throws its worst at the grid, your quality control program is the only thing between a surviving transformer and a burning one. Quality is not a department. Quality is the mission."

---

## 2.0 INCOMING MATERIAL INSPECTION

### 2.1 Critical Material Inspection Protocols

| Material | Key Properties Tested | Test Method | Frequency | Acceptance Criteria |
|----------|----------------------|------------|-----------|--------------------|
| MAX phase (Ti3AlC2) | Phase purity (>95% MAX phase); particle size distribution; elemental composition | XRD; SEM/EDS; laser diffraction | Every lot | Per CSM-MAT-001 specification |
| LiF | Purity (>99%); moisture content | Titration; Karl Fischer | Every lot | Per ACS reagent grade |
| Basalt fiber roving | Tensile strength; tex (linear density); sizing compatibility | Single-filament tensile test (ASTM D2101); gravimetric | Every lot | Per CSM-MAT-004 |
| CNTs (MWCNT) | Diameter distribution; length; purity (TGA residue); conductivity | TEM; TGA/DSC; four-point probe | Every lot | Per CSM-MAT-007 |
| Epoxy resin | Viscosity; epoxy equivalent weight; gel time | Rheometer; titration; DSC | Every lot | Per manufacturer CoA + CSM verification |
| BaTiO3 powder | Particle size; tetragonality (c/a ratio); purity | Laser diffraction; XRD; XRF | Every lot | Per CSM-MAT-009 |
| Metakaolin | Reactive alumina/silica content; particle size; LOI | XRF; laser diffraction; TGA | Every lot | Per CSM-MAT-011 |

### 2.2 Supplier Certificate of Analysis (CoA) Requirements

Every material shipment must be accompanied by a CoA documenting:
- Batch/lot number for traceability
- Test results for all specified properties
- Test methods used
- Acceptance criteria
- Date of manufacture
- Expiration date (if applicable)
- Signature of supplier's quality representative

CSM verifies CoA results through its own incoming inspection on a statistical sampling basis (ANSI/ASQ Z1.4, AQL 1.0 for critical properties, AQL 2.5 for non-critical).

---

## 3.0 IN-PROCESS QUALITY CHECKS

### 3.1 MXene Processing In-Process Controls

| Process Step | In-Process Check | Method | Frequency | Specification |
|-------------|-----------------|--------|-----------|------------|
| Etching — MAX phase to MXene | Etch completion (Al removal >95%) | XRD (disappearance of MAX phase peaks) | Every batch | 104 peak absent in XRD |
| Delamination | Delamination yield; sheet size distribution | Centrifugation yield; dynamic light scattering (DLS) | Every batch | >80% delamination yield; median flake size 2-5 μm |
| MXene ink formulation | Viscosity; solid content; sedimentation stability | Rheometer; gravimetric; settling test | Every batch | Per CSM-PROC-001 |
| Film casting/drying | Wet film thickness; dry film thickness; visual defects | Thickness gauge; automated optical inspection (AOI) | Continuous (in-line) | Thickness ±10% of target; <1 defect/cm² |
| Sheet resistance | Four-point probe measurement | In-line or off-line | Every panel | <10 Ω/sq (for standard shielding grade) |

### 3.2 BFRP Processing In-Process Controls

| Process Step | In-Process Check | Method | Frequency | Specification |
|-------------|-----------------|--------|-----------|------------|
| Fiber tension | Roving tension | Tensiometer | Continuous | Per CSM-PROC-004 |
| Resin bath | Resin viscosity; temperature; pot life | Rheometer; thermocouple; timer | Every 4 hours | Within manufacturer's process window |
| Die temperature | Multiple zone temperatures | Thermocouples (PLC-monitored) | Continuous | Per CSM-PROC-004 (profile-specific) |
| Pull speed | Line speed | Tachometer | Continuous | Per product specification |
| Profile dimensions | Cross-section dimensions; straightness | Calipers; straightness gauge | Every 10 meters | Per CSM-SPEC-010 |

### 3.3 General In-Process Controls

| Control | All Products | Method |
|---------|-------------|--------|
| Environmental monitoring | MXene processing area: temperature 20±2°C, humidity <30% RH | Environmental sensors; data-logged |
| Clean room particle count | ISO 7 (Class 10,000): <352,000 particles/m³ at 0.5μm | Particle counter; daily |
| Equipment calibration | All measurement equipment | Per calibration schedule (ISO 17025 traceable) |
| Tooling condition | Molds, dies, cutting tools | Visual inspection; dimensional check; replacement per life count |

---

## 4.0 FINAL PRODUCT TESTING

### 4.1 Aegis Home — Final Acceptance Test

| Test | Method | Acceptance Criteria | Sampling |
|------|--------|--------------------|----------|
| Visual inspection | AOI + human inspector | No visible defects; labels correct; packaging intact | 100% |
| Shielding effectiveness | Custom TEM cell (production-qualified) | SE >90 dB at 10 GHz (production spec; >92 dB design target) | 100% |
| GIC blocking | Simulated GIC injection | >94% GIC reduction (standard); >98% (enhanced) | 100% |
| Dielectric withstand (HiPot) | High-potential test per UL 1449 | No breakdown at 1.5x rated voltage | 100% |
| Ground continuity | Resistance measurement | <0.1 Ω between grounding terminals | 100% |
| Functional test — indicators | All status LEDs, audio, tactile indicators verified | All operational | 100% |
| Functional test — connectivity | WiFi/Bluetooth connectivity test (monitoring version) | Connects to test network; data transmission verified | Per monitoring-equipped units: 100% |
| Packaging integrity | Drop test; vibration test | Per ISTA 3A (packaging performance) | Per lot (statistical) |

### 4.2 Charlemagne Fleet — Final Acceptance Test

| Test | Method | Acceptance Criteria | Sampling |
|------|--------|--------------------|----------|
| Component-level shielding test | TEM cell (large-format) | SE >90 dB | 100% of shielding panels |
| GIC blocking device test | Full-current GIC simulation (up to 500A) | >99.9% GIC reduction at rated current | 100% |
| High-voltage test | Per IEEE C57 (transformer testing) | No breakdown at test voltage | 100% |
| System integration test | Connected system test with simulated transformer | All components function as integrated system | Each installation kit |
| Documentation review | Installation manual; test certificate; warranty registration | Complete and accurate | 100% |

### 4.3 Product Life Testing (Accelerated Aging)

| Test | Conditions | Duration (Accelerated) | Equivalent Service Life | Sampling |
|------|-----------|----------------------|------------------------|----------|
| Temperature cycling | -40°C to +85°C, 4-hour cycles | 1,000 cycles (~6 months) | 20 years | Per product family; initial lot |
| Humidity exposure | 85°C / 85% RH | 1,000 hours | 10-15 years | Per product family |
| UV exposure | Xenon arc (ASTM G155) | 2,000 hours | 20 years outdoor equivalent | BFRP components |
| Salt fog (corrosion) | ASTM B117 | 1,000 hours | 20 years coastal exposure | External components |
| Vibration | Random vibration per MIL-STD-810 | Per test standard | 20 year transportation/operational | Per product |
| Mechanical shock | Drop test; impact test | Per ISTA standards | Transportation lifetime | Per product |
| Electrical endurance | Repeated GIC injection (1,000 cycles) | 1,000 cycles at rated current | 100+ Carrington-level events | Per GIC blocking device design |

---

## 5.0 STATISTICAL PROCESS CONTROL (SPC)

### 5.1 SPC Implementation

| Process | Key Characteristic (SPC Chart) | Control Chart Type | Monitoring |
|---------|------------------------------|--------------------|------------|
| MXene film thickness | Dry thickness (μm) | X-bar and R chart | Per production run |
| MXene sheet resistance | Ω/sq | X-bar and R chart | Per production run |
| BFRP profile dimension | Width, thickness (mm) | X-bar and R chart | Continuous (in-line measurement) |
| BFRP tensile strength | MPa | X-bar and R chart | Per lot |
| Ceramic density | g/cm³ | X-bar and R chart | Per sintering batch |
| Geopolymer compressive strength | MPa (7-day and 28-day) | X-bar and R chart | Per mix batch |
| Assembly cycle time | Minutes per unit | X-bar and R chart | Daily |
| First-pass yield | % pass | p-chart (fraction nonconforming) | Daily |
| Customer complaints | Count per month | c-chart | Monthly |

### 5.2 Process Capability Targets

| Process | Capability Target (Cpk) | Notes |
|---------|------------------------|-------|
| Critical safety characteristics (shielding SE, GIC reduction, HiPot) | Cpk > 1.67 | Six Sigma — safety-critical |
| Key performance characteristics (sheet resistance, mechanical strength) | Cpk > 1.33 | Four Sigma |
| Non-critical characteristics (cosmetic, packaging) | Cpk > 1.0 | Three Sigma |

---

## 6.0 SIX SIGMA PROGRAM

### 6.1 Six Sigma Deployment

| Belt Level | Headcount (Phase 2) | Headcount (Phase 3) | Role |
|-----------|--------------------|--------------------|------|
| Master Black Belt | 1 (external consultant initially) | 1-2 (internal) | Program leadership; training; strategic projects |
| Black Belt | 1-2 | 3-5 | Full-time improvement project leaders |
| Green Belt | 5-10 | 20-50 | Part-time project leaders (in addition to regular role) |
| Yellow Belt | 20-50 | 100-300 | Basic problem-solving training (all engineers and supervisors) |

### 6.2 Six Sigma Project Selection

Priority projects are selected based on:
- **Safety impact:** Projects reducing risk of product failure during GMD events
- **Quality impact:** Projects improving first-pass yield and reducing customer complaints
- **Cost impact:** Projects reducing manufacturing cost (waste, rework, efficiency)
- **Customer impact:** Projects improving customer experience (installation ease, monitoring reliability)

Target: 2-4 Black Belt projects and 10-20 Green Belt projects active at any time (Phase 2).

---

## 7.0 ISO CERTIFICATION TIMELINE

### 7.1 ISO 9001:2015 — Quality Management Systems

| Phase | Activity | Timeline |
|-------|----------|----------|
| 1. Gap Analysis | Assess current state against ISO 9001 requirements | Year 1, Month 6 |
| 2. Documentation | Develop quality manual, procedures, work instructions, forms | Year 1, Months 6-12 |
| 3. Implementation | Implement QMS across pilot facility | Year 1, Month 12 — Year 2, Month 6 |
| 4. Internal Audit | Train internal auditors; conduct first internal audit | Year 2, Month 6 |
| 5. Management Review | First management review of QMS | Year 2, Month 9 |
| 6. Certification Audit | Stage 1 audit (documentation review) | Year 2, Month 9-10 |
| 7. Certification Audit | Stage 2 audit (implementation verification) | Year 2, Month 11-12 |
| 8. Certification | ISO 9001:2015 certificate issued | Year 2, Month 12 — Year 3, Month 3 |

### 7.2 AS9100D — Aerospace/Defense Quality Management

AS9100 adds ISO 9001 requirements for aerospace and defense: risk management, configuration management, foreign object debris (FOD) prevention, and additional design/development controls. Required for DOD contracts.

| Phase | Timeline |
|-------|----------|
| AS9100 implementation | Year 3-4 (after ISO 9001 achieved) |
| AS9100 certification | Year 4-5 |

### 7.3 ISO 14001 and ISO 45001

| Standard | Timeline |
|----------|----------|
| ISO 14001 (Environmental Management) | Year 2-3 |
| ISO 45001 (Occupational Health and Safety) | Year 3-4 |

---

## 8.0 WARRANTY AND RETURNS POLICY

### 8.1 Warranty Terms

| Product | Warranty Period | Coverage |
|---------|--------------|----------|
| Aegis Home | 10 years (standard); lifetime (enhanced) | Defects in materials and workmanship; failure to meet published performance specifications |
| Aegis Business | 10 years | Defects in materials and workmanship |
| Charlemagne Fleet | 20 years | Defects in materials and workmanship; GIC reduction performance guarantee |
| CSM Maritime/Fleet | 10 years | Defects in materials and workmanship |

### 8.2 Warranty Reserve Accounting

CSM accrues a warranty reserve based on estimated future warranty costs as products are sold (per ASC 450 / FAS 5). Initial reserve rate: 2-3% of product revenue (to be adjusted based on actual experience).

### 8.3 Returns and RMA Process

| Step | Timeline | Activity |
|------|----------|----------|
| 1. Claim Initiation | Day 0 | Customer contacts CSM; RMA (Return Material Authorization) number issued |
| 2. Triage | Day 1-2 | CSM technical support assesses issue; remote diagnostics (monitoring-equipped units) |
| 3. Return (if needed) | Day 3-7 | Prepaid return shipping label; unit returned to CSM |
| 4. Analysis | Day 8-21 | Root cause analysis; failure mode determination |
| 5. Resolution | Day 22-30 | Repair, replacement, or refund; customer communication |
| 6. CAPA (Corrective Action) | Day 31-60 | If significant failure: CAPA initiated; root cause addressed in manufacturing |

---

## 9.0 CONTINUOUS IMPROVEMENT (KAIZEN)

### 9.1 Kaizen Program Structure

| Element | Description | Frequency |
|---------|-----------|-----------|
| Daily stand-up (cell level) | 10-minute team meeting: yesterday's issues, today's priorities, improvement ideas | Daily |
| Kaizen event | 3-5 day focused improvement workshop on specific process | Monthly (rotating across production lines) |
| Gemba walk | Leadership walks the production floor, observes, asks questions | Weekly (plant manager); monthly (CEO/COO) |
| Suggestion system | All employees submit improvement ideas; review committee evaluates; implemented ideas rewarded | Ongoing (monthly review) |
| A3 problem solving | Structured problem-solving methodology for complex issues | As needed |

### 9.2 Continuous Improvement Metrics

| Metric | Phase 1 Baseline | Phase 2 Target | Phase 3 Target |
|--------|-----------------|---------------|---------------|
| Kaizen events per year | 0 (not yet) | 12+ | 50+ |
| Employee suggestions per year | N/A | 1 per employee | 2+ per employee |
| % suggestions implemented | N/A | >40% | >50% |
| Cost savings from improvement (annual) | N/A | 3-5% of manufacturing cost | 5-8% |
| First-pass yield improvement (year-over-year) | N/A | +5-10 percentage points | +2-5 percentage points |
| Customer complaint reduction (YoY) | N/A | -30% | -20% |

---

## 10.0 NON-CONFORMANCE AND CAPA

### 10.1 Non-Conformance Process

| Step | Description |
|------|-------------|
| Identification | Any employee can identify a non-conformance (product, process, system) |
| Documentation | NCR (Non-Conformance Report) created in QMS |
| Containment | Immediate action to isolate non-conforming product; prevent further production |
| Disposition | Decision: rework, scrap, accept with concession (customer approval required), return to supplier |
| Root Cause Analysis | 5 Why, Fishbone (Ishikawa), or FMEA methodology |
| Corrective Action | Action to eliminate root cause |
| Preventive Action | Action to prevent recurrence in similar products/processes |
| Verification | Verify corrective action is effective (audit, data review) |
| Closure | NCR closed when all actions complete and verified |

### 10.2 CAPA (Corrective and Preventive Action) System

CAPA is the systematic approach to investigating and correcting quality issues:
- **Level 1 CAPA:** Minor issue; resolved at production cell level within 48 hours
- **Level 2 CAPA:** Significant issue; cross-functional team; 30-day resolution target
- **Level 3 CAPA:** Critical issue (safety, regulatory, major customer impact); executive escalation; 72-hour initial containment; 60-day full resolution

---

## 11.0 AGENT VOICES

**Zirconia (Testing Rigor):**
"Every Aegis Home that leaves the factory must be tested for shielding effectiveness. Not a sample — every unit. The cost of 100% testing is a few dollars per unit in amortized equipment and cycle time. The cost of one untested unit failing during a Carrington Event is a destroyed home, a destroyed reputation, and a class-action lawsuit. 100% testing is the cheapest insurance CSM will ever buy."

**Quality Domain Agent:**
"The accelerated life testing program is the most important quality investment CSM will make. We need to simulate 20 years of service in 6 months of testing — temperature cycling, humidity, UV, vibration, electrical cycling. If MXene oxidizes, if BFRP delaminates, if ceramics crack — we need to find out in the lab, not in the field. The testing results will determine the warranty terms, the product design iterations, and the customer confidence."

**The Accountant (Quality Economics):**
"Quality costs money — prevention costs (training, SPC, calibration), appraisal costs (inspection, testing), and failure costs (internal — scrap/rework; external — warranty/liability). The goal is not zero quality cost — it's optimizing total quality cost. Investing $1 in prevention typically saves $10 in appraisal and $100 in failure cost. The Accountant Heuristic says: measure all three categories of quality cost. Optimize the total. The right answer is not 'spend as little as possible on quality' — it's 'spend the right amount so that total quality cost is minimized.' For CSM, given the consequences of failure, 'the right amount' is substantially higher than for most manufacturers."

**Mork (Quality Reality):**
"Quality programs are paperwork exercises until something goes wrong. Then they're either the thing that caught the problem before it reached the customer — or the thing that should have caught it and didn't. CSM's quality culture must be obsessed with finding problems internally, before customers find them externally. Celebrate people who find defects, don't punish them. Reward the person who shut down the production line because something looked wrong. That person just saved the company millions and maybe saved lives. That's the culture we need."

---

*Document prepared for investor and operational planning purposes. All quality control specifications, testing protocols, and certification timelines are targets that will be refined through implementation experience. Quality management system development should be led by an experienced Quality Director hired in Year 1.*
