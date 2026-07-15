# Robot Economics — Total Cost of Ownership Models

**Classification:** ACS Internal — Confidential  
**Date:** 15 July 2026  
**Version:** 1.0

---

## 1. Analytical Framework

This section presents total cost of ownership (TCO) models for each Boston Dynamics platform, enabling direct comparison against manual labor, fixed automation, and competitive robotic alternatives. All models use a 5-year operating horizon with 7% discount rate. Labor cost assumptions reflect US Gulf Coast / Southeast manufacturing economics (Georgia base case).

## 2. Spot — Inspection Robot TCO

### 2.1 Model Assumptions

| Parameter | Value |
|-----------|-------|
| **Acquisition Cost (Base + Payloads)** | $130,000 |
| **Annual Orbit License** | $10,000 |
| **Annual Maintenance** | $7,500 |
| **Annual Operator Labor (0.25 FTE allocation)** | $22,500 (0.25 × $90K fully loaded) |
| **Battery Replacement (Year 3)** | $8,000 |
| **Useful Life** | 5 years |
| **Annual Operating Hours** | 2,000 (single shift) |
| **Discount Rate** | 7% |

### 2.2 5-Year TCO

| Cost Element | Year 1 | Year 2 | Year 3 | Year 4 | Year 5 | 5-Year Total |
|-------------|--------|--------|--------|--------|--------|-------------|
| **Acquisition** | $130,000 | — | — | — | — | $130,000 |
| **Orbit License** | $10,000 | $10,000 | $10,000 | $10,000 | $10,000 | $50,000 |
| **Maintenance** | $7,500 | $7,500 | $7,500 | $7,500 | $7,500 | $37,500 |
| **Operator Labor** | $22,500 | $22,500 | $22,500 | $22,500 | $22,500 | $112,500 |
| **Battery Replacement** | — | — | $8,000 | — | — | $8,000 |
| **Annual Total** | $170,000 | $40,000 | $48,000 | $40,000 | $40,000 | **$338,000** |

**5-Year NPV (7%):** $308,491  
**Cost per Operating Hour:** $33.80  
**Cost per Inspection Round (2-hour round):** $67.60

### 2.3 Manual Alternative Comparison

| Cost Element | Annual |
|-------------|--------|
| Fully Loaded Inspector Labor (1 FTE, $90K) | $90,000 |
| Confined-Space Entry Permits, PPE, Monitoring (annual) | $15,000 |
| Scaffolding / Rope Access for Elevated Inspection (annual) | $25,000 |
| **Annual Manual Inspection Cost** | **$130,000** |

**5-Year Manual TCO:** $650,000  
**Spot 5-Year TCO:** $338,000  
**5-Year Savings:** $312,000 (48% reduction)

### 2.4 Breakeven Analysis

Spot reaches cash-flow breakeven at 14 months, accounting for acquisition cost and first-year operating expenses versus avoided manual inspection costs.

## 3. Stretch — Warehouse Unloading TCO

### 3.1 Model Assumptions

| Parameter | Value |
|-----------|-------|
| **Acquisition Cost (System + Integration)** | $1,125,000 |
| **Annual WMS License** | $60,000 |
| **Annual Maintenance** | $45,000 |
| **Annual Operator Labor (0.5 FTE per shift, 2 shifts)** | $90,000 (1.0 × $90K fully loaded) |
| **End-Effector Replacement (Annual)** | $15,000 |
| **Useful Life** | 7 years (industrial automation depreciation schedule) |
| **Annual Operating Hours** | 4,000 (two-shift operation) |
| **Discount Rate** | 7% |

### 3.2 5-Year TCO

| Cost Element | Year 1 | Year 2–5 (Annual) | 5-Year Total |
|-------------|--------|-------------------|-------------|
| **Acquisition** | $1,125,000 | — | $1,125,000 |
| **WMS License** | $60,000 | $60,000 | $300,000 |
| **Maintenance** | $45,000 | $45,000 | $225,000 |
| **Operator Labor** | $90,000 | $90,000 | $450,000 |
| **End-Effector** | $15,000 | $15,000 | $75,000 |
| **Annual Total (avg)** | $1,335,000 | $210,000 | **$2,175,000** |

**5-Year NPV (7%):** $1,925,614  
**Cost per Operating Hour:** $108.75  
**Cost per Parcel (500 parcels/hr):** $0.2175

### 3.3 Manual Alternative Comparison

| Cost Element | Annual (2-Shift) |
|-------------|-----------------|
| Trailer Unload Labor (3 workers × 2 shifts × $45K fully loaded) | $270,000 |
| Workers' Compensation Insurance (warehouse unload classification, 8% of wages) | $21,600 |
| Injury-Related Costs (OSHA recordable rate × average claim; warehouse unload is top-3 injury category) | $35,000 |
| Recruitment & Training (warehouse turnover ~40%) | $18,000 |
| **Annual Manual Cost per Dock Door** | **$344,600** |

**5-Year Manual TCO:** $1,723,000  
**Stretch 5-Year TCO:** $2,175,000  
**Manual Cost Advantage (5-Year):** $452,000

### 3.4 Breakeven and Sensitivity

At current pricing, Stretch is slightly more expensive than manual labor over a 5-year horizon at US Southeast labor rates. Breakeven versus manual labor occurs at:

- **Wage Inflation Scenario:** 5% annual warehouse wage growth (plausible given ongoing labor shortages) → Stretch achieves breakeven at Year 4.
- **Throughput Improvement:** 600 parcels/hour (20% improvement) → Stretch achieves breakeven at Year 3.
- **Higher Labor Cost Geography:** Northeast US or Western Europe labor rates ($55K+ fully loaded vs. $45K) → Stretch achieves breakeven at Year 2.

**Key Insight:** Stretch's economic competitiveness is highly sensitive to local labor costs and throughput. It is most competitive in high-wage logistics markets and least competitive in the US Southeast, where warehouse wages remain moderate. The primary Stretch ROI argument in the Southeast is injury cost avoidance and throughput consistency, not direct labor savings.

## 4. Atlas — Humanoid Manufacturing TCO (Projected)

### 4.1 Model Assumptions (Base Case)

| Parameter | Value |
|-----------|-------|
| **Acquisition / Annual RaaS Fee** | $120,000 (base-case unit price, 5-year depreciation) |
| **Annual Maintenance & Software** | $25,000 |
| **Annual Operator Labor (0.1 FTE; 1 operator per 10 Atlas units)** | $9,000 |
| **Actuator Replacement Reserve (Annual)** | $15,000 |
| **End-Effector / Tooling (Annual)** | $8,000 |
| **Useful Life** | 5 years |
| **Annual Operating Hours** | 4,000 (two-shift) |
| **Discount Rate** | 7% |

### 4.2 5-Year TCO (Base Case)

| Cost Element | Year 1 | Year 2–5 (Annual) | 5-Year Total |
|-------------|--------|-------------------|-------------|
| **Acquisition / RaaS** | $120,000 | $120,000 | $600,000 |
| **Maintenance & Software** | $25,000 | $25,000 | $125,000 |
| **Operator Labor** | $9,000 | $9,000 | $45,000 |
| **Actuator Replacement** | $15,000 | $15,000 | $75,000 |
| **End-Effector / Tooling** | $8,000 | $8,000 | $40,000 |
| **Annual Total** | $177,000 | $177,000 | **$885,000** |

**5-Year NPV (7%):** $754,686  
**Cost per Operating Hour:** $44.25  
**Annualized TCO:** $177,000

### 4.3 Manual Labor Comparison (Manufacturing)

| Cost Element | Annual (2-Shift) |
|-------------|-----------------|
| Manufacturing Worker (1 FTE, fully loaded) | $65,000 |
| Workers' Compensation (manufacturing classification) | $6,500 |
| Benefits (health, retirement, PTO; 30% of base) | $15,000 |
| Training & Onboarding | $3,500 |
| **Annual Manual Worker Cost** | **$90,000** |

**Manual Annual:** $90,000  
**Atlas Annualized TCO:** $177,000  
**Manual Cost Advantage:** $87,000/year

### 4.4 Sensitivity Analysis — Atlas Breakeven Scenarios

Atlas is not cost-competitive with a single human manufacturing worker at the base-case $120,000 unit price. Breakeven requires:

| Scenario | Required Unit Price | Plausibility |
|----------|-------------------|-------------|
| 1:1 Labor Replacement (2-shift, single worker) | $70,000 | Low at initial production volumes; possible at 10,000+ units/year |
| 1.5:1 Labor Replacement (Atlas replaces 1.5 workers) | $120,000 (base case breakeven) | Plausible if Atlas operates at higher duty cycle than human workers |
| 2:1 Labor Replacement (Atlas replaces 2 workers across 3 shifts) | $165,000 | Plausible if 3-shift operation (6,000 hrs/year) and high-ergonomic-stress task substitution |

**Key Insight:** Atlas's economic proposition in manufacturing is not 1:1 labor replacement. It is: (a) 3-shift continuous operation (human workers cannot sustain 3-shift duty cycles without fatigue, injury, and quality degradation); (b) ergonomics cost avoidance (shoulder, back, repetitive-strain injuries — the highest-cost manufacturing injury categories); and (c) production-line uptime (Atlas does not take breaks, does not call in sick, does not quit). The TCO argument is throughput consistency and injury cost avoidance, not hourly wage arbitrage.

### 4.5 Cross-Platform TCO Comparison (Annualized)

| Platform | Annualized TCO | Primary Cost Competitor | Annualized Competitor Cost | TCO Advantage |
|----------|---------------|------------------------|---------------------------|---------------|
| Spot | $67,600 | Manual Inspector (1 FTE) | $130,000 | +48% (Spot cheaper) |
| Stretch | $435,000 | Manual Unload Workers (6 FTE across 2 shifts) | $344,600 | -26% (Stretch more expensive; wage-sensitive) |
| Atlas (Base) | $177,000 | Manufacturing Worker (2-shift) | $90,000 | -97% (Atlas more expensive; multi-shift-dependent) |
| Atlas (3-Shift) | $190,000 (est.) | Manufacturing Workers (2 FTE across 3 shifts) | $180,000 | -6% (approximately breakeven) |

## 5. Non-Financial TCO Factors

### 5.1 Reliability & Uptime

| Metric | Spot | Stretch | Atlas |
|--------|------|---------|-------|
| Reported Uptime | ~95% | 97%+ | Not established |
| MTBF (Mean Time Between Failures) | Not disclosed | Not disclosed | Not disclosed |
| MTTR (Mean Time to Repair) | <4 hours (actuator swap) | <8 hours | <15 minutes target (actuator swap) |

### 5.2 Safety & Regulatory Compliance Cost

Deploying robots in shared human workspaces requires safety system integration (lidar safety zones, speed and separation monitoring, E-stop circuits, safety PLC integration). These costs are included in the Stretch and Atlas integration estimates above but should be validated on a per-facility basis during ACS due diligence.

### 5.3 Workforce Transition Cost

Costs associated with labor displacement — severance, retraining, union work-rule renegotiation, community impact mitigation — are not captured in the TCO models above but represent material costs for enterprise adopters, particularly in unionized automotive and logistics environments.
