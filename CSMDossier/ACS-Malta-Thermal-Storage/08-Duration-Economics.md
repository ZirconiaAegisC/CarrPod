# Duration Economics — Cost Structure & Competitive Position

## The Duration Advantage

The most significant economic advantage of Malta's Pumped Heat Energy Storage technology is that the capital cost does not scale linearly with energy storage duration. This decoupling of power cost and energy cost is the defining feature of PHES and the basis for its competitive position in long-duration applications.

## Cost Decomposition

### Power-Related Costs ($/kW)
These costs scale with the power rating (MW) of the plant and are independent of the storage duration:

| Component | Estimated Cost ($/kW) | Percentage of Total (10-hr) |
|-----------|-----------------------|---------------------------|
| Turbomachinery (compressor, turbine, motor, generator) | $600–800 | 30–40% |
| Heat exchangers (hot-side, cold-side, recuperator) | $200–300 | 10–15% |
| Power conversion (transformer, switchgear, VFD, controls) | $150–200 | 7–10% |
| Balance of plant (piping, valves, instruments, civil/structural for power block) | $200–300 | 10–15% |
| Engineering, procurement, construction (EPC) management | $150–250 | 7–12% |
| **Subtotal — Power-Related CAPEX** | **$1,300–1,850/kW** | **65–92%** |

### Energy-Related Costs ($/kWh)
These costs scale with the energy storage capacity (MWh) of the plant:

| Component | Estimated Cost ($/kWh) | Percentage of Total (10-hr) |
|-----------|-----------------------|----------------------------|
| Hot salt tanks (including salt inventory, insulation, foundation) | $15–25 | 30–45% |
| Cold antifreeze tanks (including fluid inventory, insulation, foundation) | $10–15 | 18–27% |
| Salt and antifreeze fluid fill (initial inventory) | $8–12 | 14–22% |
| Tank-related civil works (containment dikes, piping, electrical heat tracing) | $5–10 | 9–18% |
| **Subtotal — Energy-Related CAPEX** | **$38–62/kWh** | **8–35%** |

### Total Installed Cost for Various Durations

| Duration (hours) | Power CAPEX ($/kW) | Energy CAPEX ($/kWh) | Total CAPEX ($/kW) | Normalized ($/kWh) |
|-----------------|---------------------|----------------------|--------------------|--------------------|
| 4 hours | $1,500 | $50 | $1,500 + $200 = $1,700/kW | $425/kWh |
| 8 hours | $1,500 | $50 | $1,500 + $400 = $1,900/kW | $238/kWh |
| 10 hours | $1,500 | $50 | $1,500 + $500 = $2,000/kW | $200/kWh |
| 24 hours | $1,500 | $50 | $1,500 + $1,200 = $2,700/kW | $113/kWh |
| 100 hours | $1,500 | $50 | $1,500 + $5,000 = $6,500/kW | $65/kWh |
| 200 hours | $1,500 | $50 | $1,500 + $10,000 = $11,500/kW | $58/kWh |

The key insight: as duration increases, the normalized cost per kWh declines, asymptotically approaching the energy-only cost ($50/kWh in this example). This is the opposite of lithium-ion batteries, where cost per kWh is approximately constant regardless of duration.

## Comparison: PHES vs. Lithium-Ion

| Duration | PHES ($/kWh) | Li-Ion ($/kWh) | PHES Advantage |
|----------|-------------|----------------|----------------|
| 4 hours | $425 | $250–350 | Lithium-ion is lower cost |
| 8 hours | $238 | $250–350 | PHES near parity |
| 10 hours | $200 | $250–350 | PHES advantage emerges |
| 24 hours | $113 | $250–350 | PHES 2–3× lower cost |
| 100 hours | $65 | $250–350 (rarely deployed) | PHES 4–5× lower cost |
| 200 hours | $58 | Not commercially viable | PHES dominates |

## LCOS Analysis

### PHES 100 MW / 1,000 MWh (10-hour) System

| Parameter | Value |
|-----------|-------|
| Total CAPEX | $200 million ($2,000/kW, $200/kWh) |
| Annual O&M (fixed) | $10/kW-year = $1.0 million |
| Annual O&M (variable) | $3/MWh = $0.9 million (at 1 cycle/day) |
| Project life | 30 years |
| WACC (nominal, after-tax) | 7.0% (utility or IPP project finance) |
| ITC benefit (30%) | Reduces CAPEX to $140 million |
| Cycles per year | 330 (allowing for maintenance outages) |
| Annual energy discharged | 330,000 MWh |
| RTE | 60% |
| Charging cost (average wholesale) | $25/MWh |

**LCOS Components:**

| Component | $/MWh discharged |
|-----------|-----------------|
| Capital recovery (30-yr, 7% WACC, 30% ITC) | $45 |
| Fixed O&M | $3 |
| Variable O&M | $3 |
| Charging cost ($25/MWh ÷ 0.60 RTE) | $42 |
| **Total LCOS** | **$93/MWh** |

### At 100-hour Duration (100 MW / 10,000 MWh)

| Parameter | Value |
|-----------|-------|
| Total CAPEX | $650 million ($6,500/kW, $65/kWh) |
| Capital recovery (30-yr, 7% WACC, 30% ITC) | $14/MWh |
| Charging cost | $42/MWh |
| **Total LCOS** | **~$62/MWh** |

## Sensitivity Analysis

LCOS is most sensitive to:

1. **WACC (Cost of Capital):** A 1% change in WACC changes LCOS by approximately $5–8/MWh. First-of-a-kind projects face higher financing costs until operational data demonstrates reliability and performance
2. **ITC Rate:** The IRA's 30% base ITC reduces LCOS significantly. Qualification for bonus adders (domestic content, energy communities) could increase the ITC to 50–60%, further reducing LCOS
3. **Turbomachinery Cost:** As the dominant power-related cost, turbomachinery cost reductions from learning-by-doing are critical to improving PHES economics at shorter durations. Siemens Energy's commitment to volume manufacturing is the key enabler of this learning curve
4. **Heat Exchanger Effectiveness:** Each 1% improvement in heat exchanger effectiveness translates to approximately 0.3–0.5% improvement in RTE, directly reducing LCOS through reduced charging costs
5. **Cycles per Year:** Higher utilization (more cycles per year) amortizes fixed costs over more MWh, reducing LCOS. PHES economics are most favorable in markets with strong daily or multi-day price spreads that justify frequent cycling
6. **Charging Cost:** In markets with high renewable penetration and frequent negative or near-zero wholesale prices (CAISO, ERCOT during solar peaks), charging cost can approach $0/MWh, reducing LCOS by $30–40/MWh compared to the base case

## Cost Reduction Pathway

Malta's cost reduction roadmap includes:

| Cost Reduction Lever | Estimated Impact | Timeline |
|---------------------|------------------|----------|
| Nth-of-a-kind turbomachinery learning | 15–25% reduction | Units 3–10 |
| Heat exchanger design optimization | 5–10% reduction | Ongoing engineering |
| Tank cost optimization (standardized designs) | 10–15% reduction | Units 5+ |
| Salt and fluid volume procurement | 5–10% reduction | Scale-dependent |
| Automated plant control (reduced O&M labor) | O&M cost reduction, not CAPEX | Operational learning |
| Supply chain competition (multiple turbomachinery OEMs) | 10–20% reduction | Long-term (2030+) |

The combination of these levers could reduce total installed cost from ~$200/kWh (first-of-a-kind, 10-hour) to $100–140/kWh (mature technology, 10-hour), with corresponding LCOS reduction to $50–70/MWh — competitive with new combined-cycle gas turbines in many markets, without fuel costs or carbon emissions.