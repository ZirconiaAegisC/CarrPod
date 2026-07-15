# 07 — QUALITY CONTROL, METROLOGY & MANUFACTURING PROCESS CONTROL

## Quality Architecture Overview

The quality architecture at the Brandenburg facility is built on a three-tier framework: incoming quality control (IQC) to verify supplier conformance, in-process quality control (IPQC) to detect process excursions in real time, and end-of-line (EOL) verification to ensure every shipped module meets specification. A fourth tier, reliability monitoring, provides continuous feedback from accelerated and field testing to the production process.

The overall quality target is zero customer returns attributable to manufacturing defects and a field failure rate below 0.1% per year over the warranted lifetime.

## In-Line Metrology Systems

### Perovskite Film Characterization

The perovskite deposition step is the most process-sensitive operation in the tandem manufacturing sequence. Oxford PV has deployed a multi-modal in-line metrology suite that operates at full line speed (approximately 12 seconds per measurement station, non-contact):

**Photoluminescence (PL) Imaging**:
- Excitation: 532 nm laser line, 100 mW/cm², line-scan illumination.
- Detection: InGaAs camera (900–1700 nm) with bandpass filter centered at 780 nm (perovskite PL peak).
- Metrics extracted: PL intensity (correlated with quasi-Fermi level splitting, a direct proxy for implied V_oc), PL uniformity (coefficient of variation across the 166 mm × 166 mm cell area), and defect density (dark spot count per unit area).
- Control limits: PL intensity within ±8% of golden-sample baseline; PL uniformity CV < 5%; defect density < 3 dark spots/cm² (diameter > 50 μm).

**Spectral Reflectance**:
- Measurement: Normal-incidence reflectance, 400–1100 nm, fiber-coupled spectrometer with integrating sphere detector.
- Metrics extracted: Perovskite thickness (from interference fringe spacing), bandgap (from absorption onset position), surface roughness (from specular/diffuse reflectance ratio).
- Control limits: Thickness 500 ± 25 nm; bandgap 1.65 ± 0.03 eV; diffuse reflectance fraction < 8%.

**X-Ray Fluorescence (XRF)**:
- Measurement: Energy-dispersive XRF, 50 kV Rh source, silicon drift detector.
- Metrics extracted: Pb:I ratio, Pb:Br ratio, Cs:Pb ratio.
- Control limits: Stoichiometric ratios within ±3% of target composition.

### TCO and ARC Metrology

**Sheet Resistance Mapping**:
- Eddy current non-contact method, 81-point grid mapping across 166 mm × 166 mm cell area.
- Control limits: Sheet resistance 8–15 Ω/sq; uniformity (max-min)/mean < 10%.

**Optical Transmission**:
- UV-Vis-NIR spectrophotometer, integrating sphere, 300–1200 nm, 5 nm resolution.
- Metrics: Weighted average transmission across AM1.5G spectrum, haze (diffuse/total transmission).
- Control limits: T_avg > 87% (front TCO), > 92% (rear TCO); haze < 2%.

## Statistical Process Control (SPC) Framework

Oxford PV employs a comprehensive SPC program based on Western Electric rules with supplemental Nelson rules for early detection of process shifts. All in-line metrology data are logged to a central manufacturing execution system (MES) with real-time dashboarding and automated alarm generation.

**Key SPC Charts Maintained**:

1. **X-bar and R charts** for perovskite thickness (subgroup size n=5, sampling interval 15 minutes).
2. **Individuals and moving range (I-MR) charts** for PL intensity (continuous measurement, every cell).
3. **P-charts** for visual defect rate at post-lamination inspection (variable subgroup size, daily aggregation).
4. **CUSUM charts** for module power at EOL test (sensitive to small, sustained shifts that may not trigger Shewhart-type control limits).
5. **Hotelling T² multivariate chart** for combined IV parameters (V_oc, I_sc, FF, P_max) to detect shifts in the multivariate parameter space that may be invisible in univariate charts.

## Defect Classification and Rework Protocols

Defects detected at IPQC and EOL stages are classified into four severity categories with associated disposition rules:

| Class | Description | Disposition | Max Allowable Rate |
|-------|-------------|-------------|---------------------|
| A | Cosmetic (surface stain, minor edge chip within spec) | Accept, no rework | 5% |
| B | Repairable (localized perovskite delamination, TCO pinhole) | Rework through re-deposition at affected cell position | 3% |
| C | Cell-level failure (low PL, excessive defects) | Cell replacement from buffer stock | 2% |
| D | Module-level failure (lamination defect, EOL test fail) | Scrap module, root cause investigation triggered | 0.5% |

Class D events exceeding a rolling weekly threshold of 0.5% automatically trigger a structured root cause investigation following the 8D (Eight Disciplines) problem-solving methodology:

- D1: Team formation (production, process engineering, quality, R&D liaison).
- D2: Problem description (quantified, is/is-not analysis).
- D3: Interim containment (100% inspection of affected production window, shipment hold if necessary).
- D4: Root cause identification (Ishikawa diagram, failure analysis — SEM/EDX, XPS, ToF-SIMS as required).
- D5: Corrective action selection and verification.
- D6: Corrective action implementation with documented process change.
- D7: Preventive action (FMEA update, SPC control limit review).
- D8: Team recognition and closure.

## Supplier Quality Management

Oxford PV's supply chain includes single-source suppliers for several critical materials (perovskite precursor chemicals, specialty encapsulants, edge seal compounds). Supplier quality is managed through:

- **Supplier qualification audit**: On-site assessment to ISO 9001 and Oxford PV-specific technical requirements before first article approval.
- **First article inspection (FAI)**: Dimensional, compositional, and functional testing of initial production batches.
- **Certificate of analysis (CoA) verification**: Incoming inspection with periodic independent laboratory verification (quarterly).
- **Supplier scorecard**: Monthly performance rating on quality (PPM defect rate), delivery (on-time percentage), and responsiveness (corrective action turnaround).
- **Dual sourcing**: Where technically and commercially feasible, Oxford PV maintains dual-source qualification for critical materials to mitigate single-supplier risk. Perovskite precursor chemicals present the greatest challenge for dual sourcing due to the proprietary composition and purity requirements.

## Cleanroom Environmental Monitoring

The Brandenburg cleanroom operates under an environmental monitoring program that tracks:

- **Airborne particulate count**: Continuous laser particle counters at 0.1 μm, 0.3 μm, and 0.5 μm channels at 12 locations in ISO Class 5 zones and 6 locations in Class 6–7 zones. Alert and action limits defined per ISO 14644-1.
- **Airborne molecular contamination (AMC)**: Monthly sampling for acids (HF, HCl, acetic), bases (ammonia, amines), condensable organics (siloxanes, phthalates), and dopants (boron, phosphorus). AMC levels must be maintained below SEMI F21-1102 limits.
- **Temperature and humidity**: Continuous monitoring with alert limits of 21 ± 2°C and 45 ± 10% RH in all process zones. The perovskite deposition zone maintains tighter control: 21 ± 1°C, 35 ± 5% RH.
- **Vibration**: Periodic measurements at process tool bases; floor vibration must remain below VC-C (125 μm/s, one-third octave band, 1–80 Hz) per ASHRAE guidelines.

## References

- Montgomery, D.C. "Introduction to Statistical Quality Control." 8th Edition, Wiley, 2019.
- ISO 14644-1:2015. "Cleanrooms and associated controlled environments — Part 1: Classification of air cleanliness by particle concentration."
- SEMI F21-1102. "Classification of Airborne Molecular Contaminant Levels in Clean Environments."
- Oxford PV. "Brandenburg Quality Manual: QMS-OP-001 Rev. F." Internal Document, 2025.
