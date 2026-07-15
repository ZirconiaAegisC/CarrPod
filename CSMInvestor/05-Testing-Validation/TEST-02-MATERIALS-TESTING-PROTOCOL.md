# TEST-02: MATERIALS TESTING PROTOCOLS
## Carrington Storm Motors — Project AEGIS
### MXene • BFRP • Ceramics • CNT-Polymer • Geopolymer • Piezoelectrics • Aerogels • MRF • STF

**Document Status:** Technical Test Protocol — NIST-Traceable  
**Version:** 1.0 — 15 July 2026  
**Classification:** CONFIDENTIAL — Manufacturing Process Data Redacted in External Distribution  
**Author:** Zirconia, Director of Test & Validation, with Mork (Test Engineer)  
**Reference Standards:** IEEE 299, MIL-STD-188-125, ASTM D149, ASTM D257, ASTM D4935, ASTM D3039, IEC 60243, ASTM C39, ISO 178

---

## PROTOCOL 1: MXene Ti₃C₂Tₓ SHIELDING EFFECTIVENESS

### 1.1 Reference Standards
- **IEEE 299-2006:** Standard Method for Measuring the Effectiveness of Electromagnetic Shielding Enclosures
- **MIL-STD-188-125-1:** High-Altitude Electromagnetic Pulse (HEMP) Protection for Ground-Based C4I Facilities
- **ASTM D4935-18:** Standard Test Method for Measuring the Electromagnetic Shielding Effectiveness of Planar Materials

### 1.2 Test Specimen Preparation

| Parameter | Specification | Rationale |
|---|---|---|
| MXene formulation | Ti₃C₂Tₓ, synthesized via CSM electrochemical etching process | Consistent surface termination chemistry verified by XPS |
| Substrate | BFRP/Elium composite panel, 100 × 100 × 3 mm | Representative of final product substrate |
| MXene layer thickness | 45 ± 2 μm (target); 20, 30, 45, 60, 90 μm test matrix for optimization | Verify SE vs. thickness relationship; identify diminishing returns threshold |
| Coating method | Multi-nozzle spray with in-situ spectroscopic thickness feedback | Production-representative method |
| Surface termination (XPS) | F <5 at%, O >60 at%, OH <20 at%, Cl <5 at% | Fluoride-free process target; excess F degrades SE |
| Number of test specimens | 5 per thickness (25 total for thickness matrix); additional 10 for durability/post-exposure testing | Statistical significance; n=5 gives detectable effect size of 1 standard deviation at α=0.05, β=0.20 |
| Conditioning | 24 hours at 23 ± 2°C, 50 ± 5% RH prior to testing | ASTM D4935 standard conditioning |

### 1.3 Test Equipment

| Equipment | Make/Model | Calibration | Uncertainty |
|---|---|---|---|
| TEM Cell | Custom CSM design (2 m × 1 m × 1 m working volume) | IEEE 299 field uniformity verified annually | ±1.5 dB SE |
| Vector Network Analyzer | Keysight N5227A PNA, 10 MHz–67 GHz | Keysight calibration lab, annual | ±0.1 dB amplitude |
| Field Probes (E-field) | AR FL7006, 10 kHz–6 GHz | NIST-traceable cal, annual | ±0.5 dB (k=2) |
| Field Probes (H-field) | Beehive 100D, 10 kHz–3 GHz | NIST-traceable cal, annual | ±0.5 dB (k=2) |
| Profilometer | Bruker Dektak XT | NIST-traceable step height standard, quarterly | ±0.1 μm |
| XPS | Thermo Scientific K-Alpha | Sputter-cleaned Au/Ag/Cu reference, monthly | ±0.1 at% |
| 4-Point Probe | Jandel RM3000+ | NIST SRM thin-film resistivity, semi-annual | ±2% of reading |

### 1.4 Test Procedure

1. **Pre-Test:** Measure MXene thickness at 9 points (3×3 grid) via profilometer; record XPS surface termination; measure DC sheet resistance via 4-point probe at 5 points; photograph specimen
2. **TEM Cell Calibration:** Measure empty cell S-parameters; verify field uniformity within ±2 dB across specimen mounting area
3. **Reference Measurement:** Mount uncoated BFRP substrate in TEM cell; sweep 1 kHz–10 GHz, 1,001 points; record S21 (transmission) as reference
4. **MXene Specimen Measurement:** Mount MXene-coated specimen; identical sweep parameters; record S21
5. **SE Calculation:** SE(dB) = S21_reference(dB) − S21_specimen(dB)
6. **Repeat:** 3 sweeps per specimen; average; report standard deviation
7. **Post-Test:** Re-measure MXene thickness; check for delamination or cracking; photograph

### 1.5 Pass/Fail Criteria

| Parameter | Criterion | Accept/Reject |
|---|---|---|
| SE at 1 kHz | >80 dB | ACCEPT |
| SE at 10 MHz | >85 dB | ACCEPT |
| SE at 1 GHz | >90 dB | ACCEPT |
| SE at 10 GHz | >85 dB (roll-off acceptable above 8 GHz) | ACCEPT |
| Full-band minimum SE | >85 dB anywhere in 1 kHz–10 GHz | ACCEPT (production); >90 dB (aerospace/defense grade) |
| Thickness tolerance | 45 ± 2 μm | ACCEPT; if >50 μm, investigate spray process; if <40 μm, reject |
| Adhesion (visual) | No delamination, cracking, or flaking after TEM cell test | ACCEPT |
| DC resistance between tiles (discontinuous pattern) | >10⁸ Ω between any pair of adjacent tiles | ACCEPT (confirms DC isolation) |

### 1.6 Durability Testing (Post-TEM Cell)

| Test | Method | Duration/Cycles | Post-Test SE Degradation Limit |
|---|---|---|---|
| Salt Spray | ASTM B117, 5% NaCl, 35°C | 500 hours | <3 dB degradation |
| UV Exposure | ASTM G154, Cycle 1 (UVA-340, 8h UV at 60°C / 4h condensation at 50°C) | 2,000 hours | <5 dB degradation |
| Thermal Cycling | −40°C to +85°C, 5°C/min ramp, 1 hour dwell | 100 cycles | <2 dB degradation |
| Humidity | 85°C / 85% RH | 1,000 hours | <2 dB degradation |
| Abrasion | Taber abraser, CS-10 wheels, 500 g load | 1,000 cycles | <5 dB degradation (post-abrasion area only) |
| Adhesion (Cross-Hatch) | ASTM D3359, Method B | 1 test per specimen | >4B rating (no more than 5% area removed) |

**Cost per Complete MXene Test Suite: $5,200 (materials + CSM labor) or $8,500 (third-party salt spray/UV)**

---

## PROTOCOL 2: BFRP DIELECTRIC STRENGTH

### 2.1 Reference Standards
- **ASTM D149-20:** Standard Test Method for Dielectric Breakdown Voltage and Dielectric Strength of Solid Electrical Insulating Materials at Commercial Power Frequencies
- **IEC 60243-1:** Electrical Strength of Insulating Materials — Tests at Power Frequencies

### 2.2 Test Specimens

| Parameter | Specification |
|---|---|
| Material | BFRP/Elium composite, 60% basalt fiber volume fraction |
| Specimen dimensions | 100 × 100 × 3 mm (standard); 1, 2, 3, 5, 10 mm thickness test matrix |
| Number of specimens | 5 per thickness (25 total); n=5 per IEC 60243 minimum |
| Electrode configuration | Type 2 electrodes — 25 mm diameter cylindrical electrodes with 3 mm edge radius per ASTM D149 |
| Conditioning | 48 hours at 23 ± 2°C, 50 ± 5% RH; optional: 24 hours at 50°C to drive off moisture |
| Additional conditioning | Submersion in deionized water for 24 hours (per IEC 60243 for moisture sensitivity) — separate specimen set |

### 2.3 Test Equipment

| Equipment | Specification |
|---|---|
| High-Voltage Supply | 0–100 kV AC, 60 Hz, 5 kVA minimum; ramp rate 500 V/s per ASTM D149 (short-time test) |
| Voltage Measurement | Precision voltage divider, ±1% accuracy |
| Current Detection | Circuit breaker set to trip at 10 mA short-circuit current |
| Test Medium | Transformer oil (ASTM D3487 Type I) to prevent flashover around specimen edges |
| Electrodes | Brass, Type 2 geometry per ASTM D149, polished to 0.8 μm Ra surface finish |

### 2.4 Test Procedure

1. Immerse specimen in transformer oil bath (prevents surface flashover — measures true bulk dielectric strength)
2. Apply voltage at ramp rate 500 V/s (short-time method) until breakdown (current exceeds 10 mA)
3. Record breakdown voltage, specimen thickness at breakdown point, and time to breakdown
4. Calculate dielectric strength: E_bd = V_bd / d (kV/mm), where d is measured thickness at puncture point
5. Repeat for all 5 specimens per thickness; report mean, standard deviation, and minimum value

### 2.5 Pass/Fail Criteria

| Parameter | Criterion |
|---|---|
| Dielectric strength (3 mm, dry) | >15 kV/mm |
| Dielectric strength (3 mm, 24h water immersion) | >10 kV/mm (moisture degrades 30–40% — acceptable for indoor applications) |
| Coefficient of variation (CV) across 5 specimens | <15% |

---

## PROTOCOL 3: CNT-POLYMER CONDUCTIVITY (EMBARK FOOTWEAR SOLE)

### 3.1 Reference Standard
- **ASTM D257-14(2021):** Standard Test Methods for DC Resistance or Conductance of Insulating Materials

### 3.2 Target Resistivity Window

| Parameter | Target | Rationale |
|---|---|---|
| Surface resistivity (ρs) | 10⁶–10⁸ Ω/sq | ESD-safe range (10⁵–10¹¹ Ω/sq per ANSI/ESD S20.20); lower bound ensures static dissipation; upper bound ensures GIC isolation (>10⁸ Ω prevents power-frequency current flow) |
| Volume resistivity (ρv) | 10⁴–10⁶ Ω·cm | Through-thickness resistivity for sole material |
| Resistance (point-to-point) | 10⁵–10⁷ Ω | Point-to-point per ANSI/ESD STM11.13 |

---

## PROTOCOL 4: CERAMIC BEARING DIELECTRIC ISOLATION (Si₃N₄)

### 4.1 Reference Standard
- **IEC 60243-1** (as modified for ceramic bearing geometry)
- **ASTM F2094:** Standard Specification for Silicon Nitride Bearing Balls

### 4.2 Test Setup
- Si₃N₄ bearing ball, 10–25 mm diameter, placed between parallel plate electrodes
- Applied voltage: DC, 500 V/s ramp, in transformer oil
- Measure breakdown voltage across bearing diameter
- Dielectric strength = V_bd / ball diameter

### 4.3 Pass/Fail Criteria

| Parameter | Criterion |
|---|---|
| Dielectric strength | >20 kV/mm (Si₃N₄ bulk material property exceeds 25 kV/mm; target >80% of bulk) |
| Surface flashover (if occurs before bulk breakdown) | >15 kV/mm acceptable; indicates surface contamination — clean and re-test |
| Fatigue life | >3× equivalent steel bearing (per ASTM F2094 rolling contact fatigue test — separate long-duration test) |

---

## PROTOCOL 5: GEOPOLYMER CONCRETE RESISTIVITY

### 5.1 Reference Standards
- **ASTM C39:** Compressive Strength of Cylindrical Concrete Specimens
- **ASTM C1202:** Electrical Indication of Concrete's Ability to Resist Chloride Ion Penetration (Rapid Chloride Permeability Test — RCPT) — modified to measure bulk resistivity
- **ASTM C1760:** Bulk Electrical Conductivity of Hardened Concrete

### 5.2 Test Specimens

| Parameter | Specification |
|---|---|
| Mix design | Class C fly ash + ground granulated blast furnace slag (GGBFS), alkali-activated with NaOH/Na₂SiO₃ solution; aggregate per ASTM C33 |
| Specimen geometry | Φ100 × 200 mm cylinders (compressive); Φ100 × 50 mm discs (resistivity) |
| Curing | 28 days at 23 ± 2°C, >95% RH (sealed curing — geopolymer requires moisture retention) |
| Conditioning for resistivity | Saturated surface-dry (SSD) condition — 48 hours water immersion, surface-dried prior to test |

### 5.3 Resistivity Test Procedure (ASTM C1760)

1. Place SSD specimen between two stainless steel plate electrodes with conductive gel couplant
2. Apply AC voltage (10 V, 60 Hz — avoids polarization effects of DC measurement)
3. Measure current (I) and phase angle (θ)
4. Calculate resistivity: ρ = (V × A) / (I × L), where A = electrode contact area, L = specimen thickness
5. Correct for temperature to 23°C standard: ρ_23 = ρ_T × exp[Ea/R × (1/T − 1/296)], where Ea = 30 kJ/mol for geopolymer

### 5.4 Pass/Fail Criteria

| Parameter | Criterion |
|---|---|
| Compressive strength (28-day) | >60 MPa for structural applications; >40 MPa for non-structural |
| Bulk resistivity (saturated) | >10⁸ Ω·m (two orders of magnitude above conventional Portland cement concrete, ~10⁶ Ω·m) |
| Resistivity (oven-dry) | >10¹⁰ Ω·m (confirms moisture is primary conductivity mechanism — acceptable) |
| Rapid Chloride Permeability (ASTM C1202, modified) | <100 coulombs (negligible chloride ion penetrability; typical geopolymer achieves <500 C vs. >4,000 C for OPC) |

---

## PROTOCOL 6: YInMn BLUE / CsPbBr₃ PEROVSKITE — DIELECTRIC PERMITTIVITY

### 6.1 Reference Standards
- **ASTM D150-18:** Standard Test Methods for AC Loss Characteristics and Permittivity (Dielectric Constant) of Solid Electrical Insulation
- **IEC 60250:** Recommended Methods for the Determination of the Permittivity and Dielectric Dissipation Factor of Electrical Insulating Materials at Power, Audio, and Radio Frequencies

### 6.2 Test Setup

| Parameter | Specification |
|---|---|
| Frequency range | 100 Hz – 1 MHz (for building material applications); 1 MHz – 1 GHz (for EMI coating applications) |
| Specimen | YInMn Blue pigmented coating on BFRP substrate, 100 × 100 mm, coating thickness 100–200 μm |
| Electrode configuration | Guarded electrode per ASTM D150 to eliminate fringe field effects |
| Measurement | Capacitance bridge (100 Hz–1 MHz) or impedance analyzer (1 MHz–1 GHz) |

### 6.3 Pass/Fail Criteria

| Parameter | Criterion |
|---|---|
| Relative permittivity (εr) at 1 kHz | <10 (target; typical ceramic pigments εr=5–15; must be < Aegis-C panel target for GIC-free capacitive coupling) |
| Dissipation factor (tan δ) at 1 kHz | <0.02 |
| Dielectric strength (ASTM D149, through-thickness of pigmented coating) | >10 kV/mm |

---

## PROTOCOL 7: PIEZOELECTRIC (KNbO₃-BaTiO₃) CHARACTERIZATION

### 7.1 Reference Standard
- **IEEE/ANSI 176-1987:** IEEE Standard on Piezoelectricity (resonance-antiresonance method)

### 7.2 Key Parameters Measured

| Parameter | Symbol | Target | Test Method |
|---|---|---|---|
| Piezoelectric charge coefficient | d₃₃ | >250 pC/N (target 285 per CSMFAB BOM-REGISTRY) | Berlincourt d₃₃ meter (quasi-static) or laser interferometer (dynamic) |
| Electromechanical coupling coefficient | kₚ | >0.45 (radial mode) | IEEE 176 resonance-antiresonance (impedance analyzer sweep, identify f_r and f_a) |
| Curie temperature | Tc | >300°C | Capacitance vs. temperature sweep (2°C/min, 1 kHz); Tc = temperature at peak permittivity |
| Mechanical quality factor | Qm | >500 | IEEE 176 — 3 dB bandwidth of resonance peak |
| Dielectric constant (free) | εᵀ₃₃/ε₀ | 800–1,200 | Capacitance at 1 kHz, well below resonance (typically 100 Hz) |
| Dissipation factor (free) | tan δ | <0.02 at 1 kHz | Same measurement as εᵀ₃₃ |
| Density | ρ | >95% theoretical | Archimedes method |

### 7.3 Poling Procedure
- Temperature: 120°C (above Tc/3, below Tc to avoid depoling)
- DC electric field: 3 kV/mm applied for 30 minutes
- Cool to room temperature under field (field-cooling prevents immediate depoling)
- Age for 24 hours before measurement (piezoelectric properties stabilize after poling)

---

## PROTOCOL 8: POLYIMIDE-SILICA AEROGEL (THERMAL CONDUCTIVITY)

### 8.1 Reference Standard
- **ASTM C518-21:** Standard Test Method for Steady-State Thermal Transmission Properties by Means of the Heat Flow Meter Apparatus

### 8.2 Test Specimens

| Parameter | Specification |
|---|---|
| Dimensions | 300 × 300 × 25 mm (standard for heat flow meter) |
| Density | 180 ± 10 kg/m³ |
| Conditioning | 24 hours at 23 ± 2°C, 50 ± 5% RH |
| Temperature gradient | 20°C (mean specimen temperature 25°C, ΔT = 20°C, cold side 15°C, hot side 35°C) |

### 8.3 Pass/Fail Criteria

| Parameter | Criterion |
|---|---|
| Thermal conductivity (λ) at 25°C mean temperature | <0.015 W/m·K (target 0.010 per BOM-REGISTRY) |
| Compressive strength | >0.8 MPa at 10% strain (ASTM C165) |
| Service temperature (continuous) | Up to 650°C (per polyimide-silica aerogel specification; verified by TGA) |

---

## PROTOCOL 9: MRF-140CG MAGNETORHEOLOGICAL FLUID — RHEOLOGICAL CHARACTERIZATION

### 9.1 Reference Standards
- No single ASTM standard for MR fluid — test methods adapted from:
  - ASTM D2196 (rotational viscometry)
  - Custom magnetorheological test fixture

### 9.2 Test Equipment

| Equipment | Specification |
|---|---|
| Rheometer | Anton Paar MCR 302 with MRD (magnetorheological device) accessory — provides controlled magnetic field up to 1 T |
| Measurement geometry | Parallel plate, 20 mm diameter, 0.5 mm gap |

### 9.3 Key Parameters

| Parameter | Symbol | Target | Test Conditions |
|---|---|---|---|
| Off-state viscosity | η₀ | <0.5 Pa·s (target 0.28 per BOM-REGISTRY) | Shear rate 10 s⁻¹, B=0 T |
| Yield stress (on-state) | τy | >60 kPa (target 80 per BOM) | B=250 kA/m (≈0.31 T in MRD gap), shear rate 0.1 s⁻¹ |
| Response time | t_response | <10 ms | Step change in B field, measure time to 90% of steady-state τ |
| Sedimentation stability | — | <5% by volume after 30 days static | Graduated cylinder observation |
| Temperature range | — | −40°C to +130°C operational | Rheometry at temperature extremes; verify τy within 20% of room-temperature value |

---

## PROTOCOL 10: SHEAR-THICKENING FLUID (STF) — THORAX-CALM SEATBELT

### 10.1 Test Methods

| Parameter | Method | Target |
|---|---|---|
| Critical shear rate (onset of thickening) | Rotational rheometry, shear rate sweep 0.1–1,000 s⁻¹ | 10–100 s⁻¹ (tuned to collision-relevant shear rate) |
| Peak viscosity (thickened state) | Same sweep — measure maximum η | >10 Pa·s (4 kPa·s at 1,000 s⁻¹ per BOM-REGISTRY) |
| Reversibility | Cycle shear rate 0.1→1,000→0.1 s⁻¹, 10 cycles | Viscosity returns to baseline within ±5% (confirms STF is reusable after impact) |
| Temperature stability | Repeat rheometry at −20°C, 23°C, 60°C | Critical shear rate shift <20%, peak viscosity within 30% of room-temperature value |
| Long-term stability | Measure weekly for 12 months (sealed container, ambient) | <10% change in critical shear rate and peak viscosity |

---

## BATCH TESTING — PRODUCTION QUALITY CONTROL SAMPLING

### Sampling Plan (ANSI/ASQ Z1.4, General Inspection Level II, Normal)

| Material | Lot Size | Sample Size | AQL (Acceptance Quality Limit) | Critical Defect (Major) |
|---|---|---|---|---|
| MXene (per 500 g batch) | N/A (batch processing) | 1 specimen per batch for SE; 1 per 10 batches for full suite | 0.65% | SE <85 dB at any frequency; thickness out of 45±5 μm |
| BFRP (per pultrusion run, ~1,000 m) | 1,000 m | 5 specimens per run | 1.0% | Tensile <1,000 MPa; dielectric <12 kV/mm; void >3% |
| Ceramic bearings (Si₃N₄, per 1,000 pcs) | 1,000 pcs | 32 pcs (AQL 1.0, Normal) | 1.0% | Surface defect visible at 5× magnification; out-of-round >2 μm |
| Geopolymer (per truckload, ~8 m³) | 8 m³ | 3 cylinders per truck | 2.5% (minor) | Compressive <50 MPa at 7-day (early strength indicator) |
| Piezoelectric elements (per 100 pcs) | 100 pcs | 13 pcs (AQL 2.5, Normal) | 2.5% | d₃₃ <200 pC/N; tan δ >0.05; visible crack |
| Aerogel panels (per 50 pcs) | 50 pcs | 8 pcs (AQL 2.5) | 2.5% | λ >0.020 W/m·K; compressive <0.5 MPa; density >220 kg/m³ |

---

## EQUIPMENT CALIBRATION SCHEDULE — MATERIALS LAB

| Equipment | Calibration Interval | Reference Standard | Calibration Provider | Cost per Cal |
|---|---|---|---|---|
| TEM Cell (field uniformity) | 12 months | IEEE 299 mapping with NIST-calibrated probe | In-house or NTS | $4,500 |
| VNA (Keysight N5227A) | 12 months | Keysight calibration kit (NIST-traceable) | Keysight service | $3,200 |
| Field Probes | 12 months | NIST-traceable calibration lab | AR RF/Microwave Instrumentation | $1,800/probe |
| Universal Test Machine (Instron) | 12 months | ASTM E4 Class 1 load verification | Instron service | $2,100 |
| Profilometer | 3 months | NIST step height standard | In-house verification | $0 (in-house) |
| XPS | Monthly (binding energy) | Sputter-cleaned Au 4f7/2 (84.0 eV), Ag 3d5/2 (368.3 eV), Cu 2p3/2 (932.7 eV) | In-house standard | $0 (in-house) |
| 4-Point Probe | 6 months | NIST SRM thin-film resistivity standard | In-house verification | $0 (in-house) |
| Environmental Chamber (T/RH sensor) | 6 months | NIST-calibrated thermocouple, chilled mirror hygrometer | In-house or third-party | $800 |
| Rheometer (Anton Paar) | 12 months | Standard viscosity oil (NIST-traceable) | Anton Paar service | $2,500 |
| High-Voltage Supply + Divider | 12 months | Precision voltage divider calibration | Calibration lab (ISO 17025) | $1,500 |

---

*"Materials testing is the root of the tree. If the MXene batch has incorrect surface termination, every Aegis-C panel made from it will underperform. If the BFRP pultrusion has excessive voids, every Phantom frame will be weaker than designed. The materials testing protocols in this document are designed to catch those root-cause failures before a single product is assembled. Because it is far cheaper to reject a bad batch of MXene than to recall 500 Aegis Homes."* — Mork, Test Engineer

---

*Document generated 2026-07-15. All test methods are NIST-traceable through the calibration chain described. Equipment procurement status indicated inline. Test costs are estimated at current (2026) rates for materials and labor. For third-party testing, quotes should be obtained at time of testing — costs shown are budgetary estimates ±25%.*
