# INS-02: Carrington Storm Motors — Actuarial Validation Framework

**Document ID:** CSM/INS/02
**Version:** 1.0 — Investor-Grade
**Classification:** Confidential — For Qualified Investors and Insurance Partner Actuaries
**Heuristic Foundation:** Accountant (mathematical rigor), Chester (probability economics), Williams (transparent assumptions)
**Agents Consulted:** Insurance domain agent, Accountant, Chester, Zirconia (failure mode data)
**Date:** July 2026

---

## 1.0 EXECUTIVE SUMMARY

The actuarial validation of Carrington Storm Motors' loss reduction claims is the single most important gating item for the insurance integration business model. Before any insurer will reduce premiums for CSM-hardened assets, the insurer's actuary must be convinced that the expected loss reduction is real, quantifiable, and durable.

This document presents CSM's actuarial framework: the GIC-induced loss probability curves, transformer failure rate models with and without hardening, geographic correlation modeling, tail risk analysis, and capital relief calculations. It also outlines the 20 CSMinsurance dossiers (the subset of CSM's 6,302 documents focused on insurance-specific actuarial analysis) and the external actuary engagement plan.

As the Accountant Heuristic demands: "The actuarial model is the bridge between materials science and insurance pricing. If the bridge collapses, the insurance model collapses with it. Build it strong."

---

## 2.0 GIC-INDUCED LOSS PROBABILITY CURVES

### 2.1 Baseline GMD Frequency

| Event Magnitude | Return Period | Probability per Year | Probability per Decade |
|----------------|--------------|---------------------|----------------------|
| G5 (Extreme) | ~40-60 years | 1.7-2.5% | 17-25% |
| Carrington-class | ~100-150 years | 0.7-1.0% | 7-10% |
| Carrington+ ("Black Swan") | ~500 years | 0.2% | 2% |
| **Any G5 or greater** | **~40-60 years** | **~2%** | **~18-20%** |

Source: NOAA SWPC, National Academy of Sciences (2008), Lloyd's of London (2013), JASON defense advisory group.

### 2.2 Transformer Failure Probability Curves (Without Hardening)

| GMD Intensity (nT/min — dB/dt) | Transformer Failure Probability | Notes |
|-------------------------------|-------------------------------|-------|
| <100 nT/min | <0.1% | Normal geomagnetic activity |
| 100-300 | 0.1-1% | Minor storm — aging transformers at risk |
| 300-1,000 | 1-5% | Moderate storm — multiple transformer heating events |
| 1,000-3,000 | 5-20% | Major storm — significant GIC heating |
| 3,000-5,000 | 20-50% | Severe storm — widespread transformer damage |
| >5,000 (Carrington-level) | 30-80% | Extreme — cascading transformer failure likely |

### 2.3 Transformer Failure Probability Curves (With CSM Charlemagne Hardening)

| GMD Intensity (dB/dt) | Failure Probability (Hardened) | GIC Reduction | Failure Reduction |
|----------------------|-------------------------------|-------------|-------------------|
| <100 | <0.001% | N/A (no significant GIC) | N/A |
| 100-300 | <0.001% | 99.97% | >99% reduction |
| 300-1,000 | <0.005% | 99.97% | >99% reduction |
| 1,000-3,000 | <0.01% | 99.97% | >99.5% reduction |
| 3,000-5,000 | <0.05% | 99.97% | >99% reduction |
| >5,000 | <0.1% | 99.97% (beginning to saturate at extreme levels) | >98% reduction |

**Key Assumption:** The 99.97% GIC reduction figure is based on TEM cell measurements with simulated GIC waveforms (see DD-01). At extreme GMD intensities (>5,000 nT/min), the shielding effectiveness may begin to compress (saturation effects in MXene). CSM's enhanced Charlemagne configuration (99.998% reduction) extends the effective range by approximately 20 dB.

### 2.4 Correlation Modeling Across Geographic Regions

GMD events are spatially correlated — a Carrington Event affects the entire planet simultaneously. However, GIC intensity varies by:

| Factor | Correlation | Impact on Loss Modeling |
|--------|-----------|------------------------|
| Magnetic latitude | HIGH — GIC intensity increases with latitude | Northern US, Canada, Nordics, UK highest risk; equatorial regions lower risk |
| Ground conductivity | MODERATE — igneous rock regions (shield areas) experience higher GICs | Quebec, Scandinavia, Western Australia at elevated risk |
| Grid topology | MODERATE — long transmission lines in east-west orientation collect more GIC | US East-West interconnects; Canadian shield lines |
| Transformer design | LOW-MODERATE — older, single-phase, shell-form transformers more vulnerable | Asset-level risk varies |

**Implication for Insurance:** GMD loss is highly correlated across large geographic regions. This is the opposite of what insurers prefer (uncorrelated risks). A single GMD event triggers claims across entire continents simultaneously — the classic "uninsurable" risk profile. CSM's hardening decouples this correlation: hardened assets survive regardless of geography.

---

## 3.0 TAIL RISK ANALYSIS

### 3.1 The Insurance "Tail" Problem

The insurance industry models risk using probability distributions. "Tail risk" refers to the extreme end of the distribution — low-probability, high-consequence events. Carrington Events are the extreme tail: 1% annual probability, $2-6 trillion consequence.

Traditional insurance pricing fails for extreme tail risks because:
1. Historical data is inadequate (one Carrington-level event in recorded history — 1859, pre-electric grid)
2. Premiums required to cover the tail would be unaffordable ($20-60B annual expected loss → $2,000-6,000/year per US household to fully price the risk)
3. Correlation destroys diversification benefits (every policyholder claims simultaneously)

### 3.2 How CSM Reshapes the Tail

| Metric | Without CSM | With CSM (Hardened Grid) |
|--------|-----------|--------------------------|
| Expected annual loss (US) | $2-6B | $0.02-0.6B (99% reduction) |
| 99.5th percentile (1-in-200 year) | ~$2 trillion | ~$50-200B (90-97.5% reduction) |
| Tail fatness (kurtosis) | Very high (fat tail) | Significantly reduced (thinner tail) |
| Insurability | Borderline uninsurable (private market) | Insurable with CSM hardening requirements |

**CSM transforms GMD risk from an uninsurable tail risk into an insurable, manageable risk.** This is the fundamental actuarial value proposition.

---

## 4.0 CAPITAL RELIEF CALCULATION

### 4.1 Solvency II — Standard Formula Impact

Under Solvency II (EU insurance regulation), insurers must hold capital against catastrophe risk. The Natural Catastrophe risk sub-module includes "other" perils, under which GMD would fall.

| Scenario | Capital Requirement (per €1B of insured GMD exposure) |
|----------|------------------------------------------------------|
| Without CSM hardening | €100-250M (10-25% capital charge — conservative, given fat tail) |
| With CSM hardening (loss reduction verified) | €10-50M (1-5% capital charge) |
| Capital relief | €90-200M per €1B exposure |

### 4.2 NAIC RBC (US) — Risk-Based Capital Impact

Under the NAIC Risk-Based Capital framework for US insurers:

| Scenario | R4 (Asset/Underwriting Risk) Charge |
|----------|------------------------------------|
| Without CSM hardening | Higher risk charge for concentrated GMD exposure |
| With CSM hardening | Reduced risk charge; potential for separate risk category ("hardened electrical infrastructure") |

**Capital relief creates a direct financial incentive for insurers to require CSM hardening.** The saved capital can be deployed to underwrite additional business, generating returns that far exceed the cost of the premium reduction offered to CSM-hardened policyholders.

---

## 5.0 THE 20 CSMINSURANCE DOSSIERS — SUMMARY

### 5.1 Dossier Framework

Each CSMinsurance dossier covers a specific insurance line or exposure:

| Dossier # | Topic | Key Analysis |
|-----------|-------|-------------|
| CSMINS-01 | Homeowners Insurance — Aegis Home integration | Residential GMD loss model; premium reduction calculation |
| CSMINS-02 | Commercial Property — Aegis Business integration | Commercial GMD loss model; business interruption |
| CSMINS-03 | Equipment Breakdown — Charlemagne integration | Transformer failure model; replacement cost analysis |
| CSMINS-04 | Business Interruption — time-element coverage | Grid-down business interruption duration model |
| CSMINS-05 | Parametric GMD — trigger design | NOAA G5 alert trigger; payout structure; basis risk |
| CSMINS-06 | Marine Insurance — CSM fleet integration | Vessel GMD navigation/communication loss model |
| CSMINS-07 | Aviation Insurance — ground systems hardening | Airport equipment GMD vulnerability model |
| CSMINS-08 | Energy Insurance — utility property | Substation and transmission line GMD loss model |
| CSMINS-09 | Reinsurance — GMD catastrophe treaty design | Aggregate GMD loss model; reinsurance layer attachment points |
| CSMINS-10 | Reinsurance — capital relief analysis | Solvency II/NAIC RBC capital reduction |
| CSMINS-11 | ILS / Cat Bond — CSM-triggered bonds | Insurance-linked security design; parametric trigger |
| CSMINS-12 | Life Insurance — mortality impact | Excess mortality from prolonged grid failure (see ESG-02) |
| CSMINS-13 | Health Insurance — medical system impact | Healthcare collapse impact on health claims |
| CSMINS-14 | Workers' Compensation — workforce impact | Occupational injury during grid recovery |
| CSMINS-15 | Auto Insurance — vehicle electronics | Auto electronics damage from EMP; claims modeling |
| CSMINS-16 | Agriculture Insurance — food system impact | Crop/livestock loss from grid-dependent agriculture |
| CSMINS-17 | Municipal Insurance — local government | Municipal service disruption claims |
| CSMINS-18 | Cyber Insurance — electronic damage | Distinction between cyber attack and EMP damage |
| CSMINS-19 | Supply Chain Insurance — contingent BI | Contingent business interruption from supplier grid failure |
| CSMINS-20 | Political Risk Insurance — sovereign grid failure | Sovereign grid failure as political risk event |

### 5.2 Dossier Maturity Levels

| Maturity | Dossiers | Status |
|----------|----------|--------|
| Level 1 — Framework Complete | CSMINS-01 through 05 | Internal model; ready for actuary review |
| Level 2 — Data Populated | CSMINS-01, 02, 03, 05, 08, 09 | Preliminary data from TEM cell testing |
| Level 3 — Pilot-Validated | None yet | Will require pilot program data (Year 2-3) |
| Level 4 — Industry-Standard | Target: CSMINS-01 through 05, 08, 09 | Post-independent actuarial validation |

---

## 6.0 EXTERNAL ACTUARY ENGAGEMENT PLAN

### 6.1 Why External Actuary?

Insurers will not accept CSM's actuarial models at face value. Independent actuarial validation is required from a firm with credibility in the insurance industry.

### 6.2 Target Actuarial Firms

| Firm | Credibility | GMD/Climate Expertise |
|------|-----------|--------------------|
| Milliman | HIGH — one of the largest actuarial consulting firms globally | Natural catastrophe modeling practice |
| Oliver Wyman (Actuarial) | HIGH | Catastrophe risk modeling; climate resilience |
| Willis Towers Watson (WTW) | HIGH | Catastrophe modeling; reinsurance broking; climate |
| Aon (Actuarial / Reinsurance Solutions) | HIGH | Cat modeling; impact forecasting |
| Guy Carpenter (Marsh McLennan) | HIGH | Reinsurance broking; cat modeling |
| RMS (Risk Management Solutions) | HIGH — cat modeling specialist | Physical risk modeling; acquired by Moody's |
| AIR Worldwide (Verisk) | HIGH — cat modeling specialist | Natural catastrophe models |

### 6.3 Engagement Plan

| Phase | Timing | Activity | Cost Estimate |
|-------|--------|----------|---------------|
| Phase 1 | Year 1 | RFP to 3-5 actuarial firms; proposal review | $50K-100K |
| Phase 2 | Year 1-2 | Model review engagement: actuarial firm reviews CSM's loss models, assumptions, and data; issues opinion letter | $250K-500K |
| Phase 3 | Year 2-4 | Pilot validation: actuarial firm validates models against pilot program data | $200K-500K |
| Phase 4 | Year 4+ | Ongoing model maintenance and recalibration | $100K-250K/year |

### 6.4 Deliverables

| Deliverable | Description | Use |
|-----------|-------------|-----|
| Actuarial Opinion Letter | Formal opinion on reasonableness of CSM's loss reduction estimates | Regulatory filings with state insurance departments |
| Model Validation Report | Detailed review of model assumptions, data quality, methodology | Insurer partner due diligence |
| Pilot Validation Report | Comparison of model predictions to pilot program actual data | Model refinement; regulatory confidence |
| Rate Filing Support | Actuarial justification for premium reduction in rate filings | State insurance department engagement |

---

## 7.0 AGENT VOICES

**Insurance Domain Agent:**
"The insurance industry's relationship with catastrophe models is complicated. They trust models that have been validated by actual events (hurricane models after Katrina, earthquake models after Northridge). GMD models have never been validated — because the validation event hasn't happened yet. CSM's challenge is to build actuarial credibility without an actual Carrington Event. The path: transparent assumptions, conservative estimates, independent validation, and — critically — continuous monitoring data from hardened assets that shows GIC levels during minor storms are consistent with the model's predictions."

**The Accountant (Precision):**
"The actuarial model is a financial model with lives on the line. An error in the model doesn't just misprice insurance — it could leave transformers unprotected because the model underestimated the risk, or make protection unaffordable because the model overestimated the risk. The model must be conservative in its protection estimates (under-promise) but aggressive in its deployment (over-deliver). That's the Accountant Heuristic applied to actuarial science."

**Mork (Probability Reality):**
"A 12% probability per decade is not a 'low probability.' It means that if you live to 80, there's roughly a 65% chance you'll experience a Carrington-level event in your lifetime. That's not a black swan. That's not a tail risk. That's a reasonable expectation. The insurance industry should be pricing GMD risk like they price hurricane risk in Florida — as an inevitability, not a possibility. CSM's actuarial models should force that conversation."

---

*Document prepared for qualified investors and insurance partner actuaries. All actuarial models are based on available space weather data, transformer failure studies, and CSM's materials testing data. Models are subject to refinement as additional data becomes available. Independent actuarial validation is required before models can be used for insurance rate-making purposes.*
