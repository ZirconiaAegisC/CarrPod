# 09 — GEN 3 PRODUCT PLATFORM: SPECIFICATIONS & PERFORMANCE

## Product Overview

The Gen 3 product platform, designated by Oxford PV as the "OXPV-TDM-72-G3" family, represents the company's first commercially shipped tandem module product. The platform is a 72-cell, glass-glass construction based on M6-format (166 mm × 166 mm) perovskite-silicon tandem cells. First commercial shipments commenced in December 2024, with volume production ramping through 2025.

## Electrical Specifications

| Parameter | OXPV-TDM-72-G3-440 | OXPV-TDM-72-G3-450 | Unit |
|-----------|---------------------|---------------------|------|
| Nominal power (P_max) | 440 | 450 | W |
| Power tolerance | 0 / +5 | 0 / +5 | W |
| Module efficiency (STC) | 26.2 | 26.8 | % |
| Open-circuit voltage (V_oc) | 1.88 | 1.90 | V |
| Short-circuit current (I_sc) | 11.8 | 12.0 | A |
| Voltage at P_max (V_mp) | 1.58 | 1.60 | V |
| Current at P_max (I_mp) | 11.1 | 11.3 | A |
| Maximum system voltage | 1500 | 1500 | V DC |
| Maximum series fuse rating | 20 | 20 | A |
| Bifaciality factor (φ) | 75 ± 5 | 75 ± 5 | % |

## Mechanical Specifications

| Parameter | Value |
|-----------|-------|
| Cell technology | Monolithic perovskite-silicon tandem |
| Cell format | M6 (166 mm × 166 mm), pseudo-square |
| Cell count | 72 (6 × 12 matrix) |
| Module dimensions | 2094 mm × 1038 mm × 35 mm |
| Module area | 2.17 m² |
| Weight | 26.5 kg |
| Front glass | 2.0 mm low-iron tempered solar glass, ARC |
| Rear glass | 2.0 mm tempered solar glass (transparent for bifacial variant) |
| Encapsulant | Thermoplastic polyolefin (TPO), UV-stabilized, desiccant-loaded |
| Edge seal | Butyl rubber / PIB, 14 mm width |
| Frame | Anodized aluminum alloy 6063-T5, silver or black |
| Junction box | IP68, 3 bypass diodes, with factory-installed cable (4 mm², 1.2 m) and MC4-compatible connectors |
| Mechanical load rating | 5400 Pa (snow, design load), 2400 Pa (wind, design load) per IEC 61215 |

## Thermal and Operating Characteristics

| Parameter | Value | Unit |
|-----------|-------|------|
| Temperature coefficient of P_max (γ) | -0.26 ± 0.02 | %/K |
| Temperature coefficient of V_oc (β) | -0.22 ± 0.02 | %/K |
| Temperature coefficient of I_sc (α) | +0.04 ± 0.01 | %/K |
| Nominal operating cell temperature (NOCT) | 42 ± 2 | °C |
| Operating temperature range | -40 to +85 | °C |

The temperature coefficient of -0.26%/K for P_max represents a significant improvement over conventional PERC modules (typically -0.34 to -0.36%/K) and is comparable to HJT modules. This improvement arises from the high V_oc of the tandem architecture, which reduces the relative impact of the negative temperature coefficient of voltage.

## Certified Test Results

| Certification | Standard | Status |
|--------------|----------|--------|
| Design qualification and type approval | IEC 61215-1:2021, IEC 61215-2:2021 | Passed (TÜV Rheinland, Q3 2024) |
| Safety qualification | IEC 61730-1:2023, IEC 61730-2:2023 | Passed (TÜV Rheinland, Q3 2024) |
| Potential-induced degradation | IEC 62804:2015 | Passed (-1000V, 96h) |
| Salt mist corrosion | IEC 61701:2020 | Passed (Severity 6) |
| Ammonia corrosion | IEC 62716:2013 | Passed |
| Fire performance | IEC 61730-2, Class C | Passed |
| Module efficiency calibration | Fraunhofer ISE CalLab | Certified (26.8% median) |

## Warranty Terms

Oxford PV offers a tiered warranty structure for the Gen 3 product platform:

**Product Warranty**: 15 years against defects in materials and workmanship.

**Performance Warranty**:
- Year 1: Minimum 97.5% of labeled power output.
- Years 2–15: Maximum annual degradation of 0.45% per year, resulting in minimum 91.2% of labeled power output at year 15.
- This performance warranty represents the first commercial tandem module warranty in the solar industry and sets a benchmark against which future perovskite-based products will be measured.

## Bifacial Variant

A bifacial variant of the Gen 3 platform (OXPV-TDM-72-G3-B) is in pre-production qualification, targeting Q3 2025 availability. The bifacial variant replaces the standard rear glass with a transparent rear glass and transparent rear encapsulant, enabling light collection from the module rear side. Key specifications:

- Bifaciality factor: 75 ± 5% (measured per IEC TS 60904-1-2).
- Bifacial power gain: 10–20% depending on albedo and mounting configuration (modeled for typical ground-mount systems with 0.25 albedo).
- Bifacial-specific warranty: 15-year product, 15-year performance (same degradation schedule as monofacial variant).

## Production Variability and Sorting

Module power output exhibits a production distribution with a median value that has increased from approximately 430 W at initial production (November 2024) to 450 W at steady-state production (Q2 2025). The standard deviation of the production distribution is approximately 8 W, yielding a tight power binning scheme:

| Power Bin | Label (W) | P_min (W) | P_max (W) | Typical Percentage |
|-----------|-----------|-----------|-----------|-------------------|
| B445 | 445 | 445.0 | 449.9 | 25% |
| B450 | 450 | 450.0 | 454.9 | 40% |
| B455 | 455 | 455.0 | 459.9 | 25% |
| B460 | 460 | 460.0 | 464.9 | 10% |

Modules are labeled at the lower bound of each bin. As the production distribution shifts to higher medians, the proportion of higher-power bins increases, improving revenue per module for a given manufacturing cost.

## Field Deployment Data (Provisional)

As of Q2 2025, approximately 10 MW of Gen 3 modules have been deployed across 15 customer sites in Europe. Preliminary performance data from monitored installations indicate:

- **Performance ratio (monthly)**: 84 ± 3%, consistent with pre-deployment modeling.
- **Degradation rate (preliminary)**: Less than 0.3% over the first 6 months of operation for the monitored population. This observation must be interpreted with caution due to the short observation period; long-term degradation trends are not yet established at statistically significant confidence levels.
- **No catastrophic failure events** (delamination, insulation failure, bypass diode failure) have been reported in the field-deployed population.

## References

- Oxford PV. "OXPV-TDM-72-G3 Product Datasheet." Revision B, January 2025.
- TÜV Rheinland. "Test Report 21270512.001: IEC 61215 Qualification of Oxford PV Tandem Module." September 2024.
- Fraunhofer ISE CalLab. "PV Modules — Calibration Certificate for Oxford PV TDM-72." November 2024.
- IEC 61215-1:2021. "Terrestrial photovoltaic (PV) modules — Design qualification and type approval — Part 1: Test requirements."
