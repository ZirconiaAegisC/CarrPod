# TEST-06: INFRASTRUCTURE TESTING PROTOCOL
## Carrington Storm Motors — Project AEGIS
### Bridge Bearings • Substation Transformers • Pipeline Isolation • Railway Signals • Power Line Monopoles

**Document Status:** Infrastructure Product Validation Protocol — AASHTO/Utility-Aligned  
**Version:** 1.0 — 15 July 2026  
**Classification:** CONFIDENTIAL — Accredited Investor Eyes Only  
**Author:** Zirconia + Engineer Orion Cross (SILENCE — infrastructure engineering lead)  
**Reference Standards:** AASHTO LRFD, IEEE 693, NACE SP0169, AREMA, NERC TPL-007

---

## INFRASTRUCTURE TESTING PHILOSOPHY

Infrastructure testing differs fundamentally from product testing: you cannot put a substation in a TEM cell, and you cannot cycle a bridge bearing through 100 thermal cycles on demand. Infrastructure validation therefore relies on a combination of laboratory-scale component testing, in-situ pre/post measurement, and long-term continuous monitoring. The protocol defined here aligns with the specific regulatory and operational requirements of each infrastructure asset class.

---

## PART 1: BRIDGE BEARING DIELECTRIC PADS (AASHTO Compliant)

### 1.1 Product Description
Replacement bridge bearing pads (elastomeric or pot bearing type) with integrated Si₃N₄/PTFE dielectric layer achieving >50 kV/mm dielectric strength, 500-tonne load capacity, and >10⁸ Ω electrical isolation between bridge deck and substructure.

### 1.2 Laboratory Testing

| Test | Standard | Specimen | Acceptance |
|---|---|---|---|
| Dielectric Strength | ASTM D149 (short-time) | 150×150 mm bearing pad, full thickness (25–50 mm) | >50 kV/mm (through-thickness); no surface flashover |
| Compressive Stiffness | AASHTO LRFD 14.7.5 (elastomeric bearings) | Full-scale bearing assembly | Stiffness within ±15% of design; creep <5% after 1,000 hours at 1.5× design load |
| Shear Modulus | AASHTO LRFD 14.7.5 | 2 bearings tested in shear | Shear modulus within ±15% of design |
| Fatigue | 2 million cycles at ±50% design shear strain, 3× design compressive load | 2 bearings | No cracking; dielectric layer intact (post-test resistance >10⁸ Ω) |
| Low-Temperature | −35°C per AASHTO LRFD Zone requirement | 5 bearings | No stiffening beyond design limit; dielectric layer intact |
| Environmental Durability | Ozone (ASTM D1149, 100 pphm, 100h); UV (ASTM G154, 2,000h); salt spray (ASTM B117, 500h) | 5 bearings per exposure | No surface cracking; dielectric resistance >10⁷ Ω post-exposure |

### 1.3 In-Situ Pre/Post Measurement (Pilot Bridges)

| Measurement | Method | Before Installation | After Installation | Target Change |
|---|---|---|---|---|
| GIC Current Through Bearing | Rogowski coil around bearing assembly | Current through existing bearing during geomagnetic storm (baseline) | Current through dielectric bearing during equivalent storm | >90% reduction |
| Bearing Resistance | Megohmmeter (1,000 V) across bearing | Baseline (typically <1 Ω for steel bearing in contact with deck/rebar) | Post-installation resistance deck-to-pier | >10⁸ Ω |
| Structural Strain | FBG strain gauges on bridge deck and pier | Baseline structural response | Post-installation structural response | No change (bearing maintains structural function while adding dielectric isolation) |

---

## PART 2: SUBSTATION TRANSFORMER HARDENING

### 2.1 Product Description
Transformer neutral blocking system using series capacitor or active compensation to prevent GIC from entering transformer windings through the neutral-ground connection.

### 2.2 Testing Protocol

| Test | Method | Acceptance |
|---|---|---|
| Neutral Current Blocking | Inject 0.001–1 Hz AC current (1–100 A) into transformer neutral in controlled test; measure winding current with and without blocking device | Neutral current reduction >90%; winding current reduced below saturation threshold |
| Capacitor Bank Endurance | 10,000 cycles of GIC-simulated neutral current at 50 A RMS | Capacitance change <5%; no dielectric breakdown; thermal rise <30°C above ambient |
| Harmonic Analysis | FFT of transformer primary current during GIC injection — GIC causes half-cycle saturation → harmonics (especially 2nd and 4th) → measure reduction with blocking device | Harmonic current reduction >80% (2nd harmonic <5% of fundamental) |
| Reactive Power Consumption | Measure transformer VAR consumption with and without blocking device during GIC injection | VAR increase <20% of baseline (unprotected transformer can draw 2–4× rated VAR during GIC half-cycle saturation) |
| Fault Tolerance | Simulate line-to-ground fault on transmission line while blocking device is active — verify blocking device does not interfere with protection relay operation (fault must be cleared within normal time) | Fault cleared within protection relay time setting (typically 3–6 cycles / 50–100 ms); blocking device auto-bypasses on overcurrent |
| Lightning Impulse | 1.2/50 μs impulse, 550 kV BIL (Basic Insulation Level) for 230 kV transformer | No damage to blocking device; device re-engages automatically after impulse |
| Temperature Range | −40°C to +55°C ambient; blocking device typically installed in substation control house (temperature-controlled) or outdoor enclosure | Full function across temperature range; capacitor value within ±10% of nominal at temperature extremes |

**Cost per Substation: $380K (equipment + installation + testing); Duration: 6 months**

---

## PART 3: PIPELINE ISOLATION SYSTEM (GFRP Dielectric Joints)

### 3.1 Product Description
GFRP dielectric isolation joints installed at 500 m intervals along buried steel pipeline to break continuous conductive paths that would otherwise carry GIC. Joints must maintain pipeline pressure integrity, allow cathodic protection current to pass through the soil (around the joint, not through it), and withstand ground movement.

### 3.2 Testing Protocol

| Test | Method | Acceptance |
|---|---|---|
| Hydrostatic Pressure | 1.5× Maximum Allowable Operating Pressure (MAOP) for 24 hours | Zero pressure drop; zero leakage; no structural deformation |
| Dielectric Isolation | Megohmmeter at 1,000 V across joint (pipeline segment A to segment B through joint) | Resistance >10⁷ Ω (lower than building products because pipeline environment is wet/dirty — 10⁷ Ω is sufficient to block GIC while allowing static dissipation) |
| Cathodic Protection (CP) Compatibility | Measure pipe-to-soil potential on both sides of dielectric joint with CP system operational | Potential on both sides within NACE SP0169 criterion (−850 mV vs. Cu/CuSO₄, polarized); CP current must not bridge the dielectric joint — current path is through soil, not through joint |
| Ground Movement | Apply 50 mm differential settlement across joint (simulating soil movement) | No leakage; resistance stays >10⁷ Ω; joint flexibility accommodates movement |
| Thermal Expansion | Cycle joint from −20°C to +60°C (buried pipeline temperature range) | No leakage; seal integrity maintained |
| Bending Moment | Apply bending moment equivalent to 1,000 m pipeline span (soil settlement) | No structural failure; joint maintains pressure and dielectric isolation |

---

## PART 4: RAILWAY SIGNAL PROTECTION (PMMA POF Signal Cables)

### 4.1 Product Description
Replacement of copper track circuit signal cables with PMMA POF to eliminate GIC induction in railway signaling systems, which can cause false "track occupied" or "track clear" signals — a potentially catastrophic failure mode.

### 4.2 Testing Protocol

| Test | Method | Acceptance |
|---|---|---|
| Data Transmission | BER test at 1 Gbps over 1 km POF with 10 connectors (simulated trackside installation) | BER <10⁻¹²; latency <100 μs/km |
| Track Circuit Integrity | Install POF-based track circuit on test track; verify train detection with locomotive at various speeds (0–125 mph) | Train detected within 1 second of entering block; no false clears; no false occupancies |
| GIC Immunity | Inject 0.001–1 Hz current into rails (simulating GIC) while POF track circuit is active | Zero data errors; zero false occupancy signals (copper-based track circuits can false-occupy at >5 A GIC in rails) |
| Lightning Surge | 10 kA, 8/20 μs surge applied to rails — verify POF system survives (POF is inherently immune to lightning — this tests the optoelectronic transceivers at endpoints) | Transceivers survive without damage; system returns to normal operation within 1 second |
| Vandalism Resistance | Cut POF cable; verify system reports cable break immediately and defaults to "occupied" (fail-safe) | Alarm within 1 second; block defaults to occupied |
| Temperature Range | −40°C to +70°C (trackside enclosure temperature) | BER within spec at all temperatures |
| AREMA Compliance | All tests per AREMA C&S Manual Part 11.5.1 (signal cable requirements) | Pass all AREMA criteria |

---

## PART 5: POWER LINE MONOPOLE (BFRP Tower)

### 5.1 Product Description
BFRP composite monopole transmission tower (30–60 m height) with ceramic insulator strings and MXene-coated conductor attachment points — eliminates the steel tower as a GIC pathway from shield wire to ground.

### 5.2 Testing Protocol

| Test | Method | Acceptance |
|---|---|---|
| Cantilever Load | Apply horizontal load at conductor attachment points equivalent to NESC Heavy loading district (ice + wind) | Deflection within allowable; no structural damage; no cracking |
| Dielectric Isolation | Measure resistance from each conductor attachment point to ground | >10⁸ Ω (standard steel tower: ~10 Ω through ground grid) |
| Full-Scale Structural Test | Destructive test to failure at full-scale test facility (e.g., EPRI Transmission Line Research Facility) | Failure load >1.5× NESC extreme wind load; failure mode is progressive (fiber breakage), not catastrophic (brittle fracture) |
| Lightning Attachment | Apply 100 kA, 8/20 μs impulse to shield wire — verify lightning current path through dedicated down conductor (MXene-coated BFRP strip), not through structural BFRP (BFRP is insulating at power frequency but can carbon-track at lightning currents — the dedicated down conductor is designed for lightning) | No structural damage; down conductor intact; resistance down conductor-to-ground <10 Ω |
| UV Resistance | ASTM G154, 5,000 hours (extended — outdoor structure, 25+ year life) | Tensile strength retained >80%; no surface crazing or fiber blooming; YInMn Blue pigment colorfastness ΔE <5 |
| Vibration (Aeolian) | Simulate wind-induced vibration at cable natural frequency (typically 5–50 Hz) for 10⁷ cycles | No fatigue cracking; no loosening of bolted connections |
| Foundation Integration | Full-scale foundation pull-out test with geopolymer concrete anchor block | Anchor block capacity >1.5× design uplift; geopolymer-concrete bond >5 MPa |

---

## PART 6: IN-SITU GIC MEASUREMENT PROTOCOL

### 6.1 Before/After Methodology for All Infrastructure Pilots

For each infrastructure pilot site (substation, bridge, pipeline, railway):

1. **Pre-Installation Baseline (3 months):** Install GIC sensors at pilot sites for 3 months before any CSM hardening is installed. Record GIC during geomagnetic activity.
2. **Installation:** Install CSM hardening products with sensors in place.
3. **Post-Installation Monitoring (12 months):** Continue recording GIC. Compare post- vs. pre-installation during storms of equivalent magnitude (matched by NOAA Kp or Dst index).
4. **GIC Reduction Calculation:**
   - Match storm events pre/post by Kp index (±0.5) or Dst (±20 nT)
   - For each matched pair, calculate: Reduction = (GIC_pre − GIC_post) / GIC_pre × 100%
   - Report mean reduction with 95% confidence interval

### 6.2 Long-Term Monitoring (5+ Years)

After the 12-month pilot, infrastructure sites transition to ongoing monitoring:
- Sensors remain installed permanently
- Data feeds into CSM Digital Twin (LandOLil v10+)
- Annual reports published: GIC events, product performance, maintenance required
- Data shared with utility partners, NERC, and IEEE working groups

---

## INFRASTRUCTURE TESTING BUDGET SUMMARY

| Product | Testing Cost | Timeline | Status |
|---|---|---|---|
| Bridge Bearing Pads | $680K (lab + 3 bridge in-situ) | 18 months | ⚪ Design phase |
| Substation Transformer Hardening (5 sites) | $1.9M ($380K/site) | 24 months | ⚪ Partner identification |
| Pipeline Isolation (2 sections, 10 km each) | $1.2M | 18 months | ⚪ Partner identification |
| Railway Signal Protection (1 test segment) | $850K | 18 months | ⚪ Partner identification |
| Power Line Monopole (full-scale test) | $1.4M (EPRI facility + test pole) | 24 months | ⚪ Design phase |
| In-Situ Monitoring Equipment (all sites) | $2.5M | 12+ months | ⚪ Procurement |
| **TOTAL** | **$8.53M** | | |

---

*"Infrastructure is the skeleton of civilization. Protecting it from GIC is not about a single product — it is about a systematic approach to identifying, measuring, and eliminating every conductive path that can carry induced current from the Earth into our bridges, substations, pipelines, and railway signals. The testing protocol defined here is the diagnostic tool for that systematic approach. Before we harden, we measure. After we harden, we measure again. The difference is the proof."* — Engineer Orion Cross (SILENCE)

---

*Document generated 2026-07-15. All infrastructure testing is contingent on securing utility and government agency partners (see ROAD-09). In-situ GIC monitoring equipment procurement to begin Q1 2027. Full-scale monopole testing at EPRI facility requires 12-month advance scheduling due to high demand — target test date Q2 2028.*
