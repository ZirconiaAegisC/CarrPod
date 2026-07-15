# Cost Economics — Green Hydrogen at <$2/kg

## The $2/kg Threshold
The U.S. Department of Energy's Hydrogen Shot targets $1/kg clean hydrogen
by 2031, but the critical commercial threshold is $2/kg — the point at which
green hydrogen becomes cost-competitive with gray hydrogen produced from
natural gas at current US gas prices (~$3-5/MMBtu). At $2/kg, green hydrogen
can compete without subsidies in many industrial applications, creating an
economically self-sustaining market.

## Levelized Cost of Hydrogen (LCOH) Model

### Cost Components
The levelized cost of green hydrogen from PEM electrolysis is determined by:

```
LCOH = (Capex × CRF + Fixed O&M) / (CF × 8760 × η) + (Electricity Price × η⁻¹) + Variable O&M + Water Cost
```

Where:
- **Capex**: Installed electrolyzer system cost ($/kW)
- **CRF**: Capital recovery factor, function of discount rate and system life
- **CF**: Capacity factor (fraction of hours operating per year)
- **η⁻¹**: System efficiency (kWh/kg H₂)
- **Electricity Price**: Delivered cost of renewable power ($/kWh)

### Base Case Assumptions (2026, US)
| Parameter                     | Value           | Source / Notes              |
|-------------------------------|-----------------|-----------------------------|
| Electrolyzer Installed Cost   | $700/kW         | EH2 target at Devens scale  |
| System Life                   | 20 years        | Stack replacement at ~60k hrs |
| Discount Rate (WACC)          | 8%              | Project finance benchmark   |
| Capacity Factor               | 60% (~5,256 hrs/yr)| Solar + wind hybrid       |
| System Efficiency             | 54 kWh/kg       | EH2 PEM target              |
| Electricity Price             | $25/MWh         | US utility-scale solar PPA  |
| Fixed O&M                     | $15/kW-year     | Industry benchmark           |
| Variable O&M                  | $0.05/kg        | Minimal for PEM             |
| Water Cost                    | $0.01/kg        | ~$1/m³ water, 9 kg/kg H₂    |

### Cost Breakdown at $25/MWh Power
| Component                  | Cost ($/kg H₂) | % of Total |
|----------------------------|----------------|------------|
| Electricity                | $1.35           | 66.5%      |
| Capital Recovery           | $0.42           | 20.7%      |
| Fixed O&M                  | $0.21           | 10.3%      |
| Variable O&M + Water       | $0.06           | 3.0%       |
| **Total (Unsubsidized)**   | **$2.04**       | **100%**   |

Electricity dominates the cost stack, representing two-thirds of production
cost. This makes site selection — proximity to low-cost renewable generation —
the single most important driver of green hydrogen economics.

## Sensitivity Analysis

### LCOH vs. Electricity Price (at $700/kW, 60% CF)
| Electricity Price ($/MWh) | LCOH ($/kg) |
|---------------------------|-------------|
| $15                        | $1.50       |
| $20                        | $1.77       |
| $25                        | $2.04       |
| $30                        | $2.31       |
| $40                        | $2.85       |
| $50                        | $3.39       |

At $15/MWh (achievable with best-in-class solar + IRA PTC), green hydrogen
approaches $1.50/kg without the hydrogen 45V credit.

### LCOH vs. Electrolyzer Capex (at $25/MWh, 60% CF)
| Installed Cost ($/kW) | LCOH ($/kg) |
|-----------------------|-------------|
| $400                   | $1.85       |
| $500                   | $1.92       |
| $700                   | $2.04       |
| $1,000                 | $2.22       |
| $1,400                 | $2.47       |

Electrolyzer capex reduction from $700 to $400/kW reduces LCOH by ~$0.19/kg —
meaningful but secondary to electricity cost. Manufacturing scale and
automation at Devens are the primary capex reduction levers.

### LCOH vs. Capacity Factor (at $700/kW, $25/MWh)
| Capacity Factor | LCOH ($/kg) | Notes                         |
|-----------------|-------------|-------------------------------|
| 30%             | $2.72       | Solar-only, no storage        |
| 50%             | $2.18       | Solar + some wind or battery  |
| 60%             | $2.04       | Solar + wind hybrid           |
| 80%             | $1.85       | Wind-dominated or grid firming|
| 95%             | $1.76       | Baseload equivalent           |

Higher capacity factor reduces per-kg capex amortization but requires either
firming (battery/grid) or wind-dominated generation portfolios. PEM's dynamic
response is critical for achieving high capacity factors with intermittent
renewables — alkaline electrolyzers cannot follow rapid solar output
fluctuations.

## Path to <$2/kg Without Subsidies
Achieving unsubsidized green hydrogen at <$2/kg requires simultaneous
improvement in multiple cost drivers:

### Near-Term (2026-2028): $1.80-2.00/kg
- Electrolyzer capex: $600-700/kW (Devens scale)
- Electricity: $20-25/MWh (solar PPA + wind)
- Capacity factor: 55-65% (hybrid renewable + limited battery)
- System efficiency: 52-54 kWh/kg

### Medium-Term (2028-2031): $1.40-1.60/kg
- Electrolyzer capex: $400-500/kW (learning + scale)
- Electricity: $15-20/MWh (continued renewable cost declines)
- Capacity factor: 65-75% (improved hybrid + storage)
- System efficiency: 50-52 kWh/kg

### Long-Term (2031+): $1.00-1.30/kg
- Electrolyzer capex: $250-350/kW (mature manufacturing)
- Electricity: $10-15/MWh (advanced solar/wind)
- Capacity factor: 70-80%
- System efficiency: 48-50 kWh/kg

## Comparison: Green vs. Gray Hydrogen
| Hydrogen Type | Production Cost ($/kg) | CO₂ Emissions (kg/kg H₂) |
|---------------|------------------------|--------------------------|
| Gray (SMR, $3.50/MMBtu gas) | $1.00-1.80      | 9-12                      |
| Gray (SMR, $5.00/MMBtu gas) | $1.40-2.20      | 9-12                      |
| Blue (SMR + CCS)            | $1.50-2.50      | 1-3                       |
| Green (with $3/kg 45V)     | ~$0.00           | <0.45                     |
| Green (unsubsidized, 2026) | $2.00-2.50       | <0.45                     |
| Green (unsubsidized, 2030) | $1.40-1.80       | <0.45                     |

With IRA 45V, green hydrogen is cheaper than gray hydrogen today. Without
subsidies, green hydrogen is expected to approach parity with gray hydrogen
by ~2028-2030 and become cheaper thereafter — the crossover point depends
primarily on natural gas prices and renewable power costs.

## The Role of Manufacturing Scale
Electric Hydrogen's Devens gigafactory directly addresses the electrolyzer
capex component of the LCOH equation. At 1.2 GW/year, the factory achieves
manufacturing economies that reduce system costs by approximately 30-40%
compared to low-volume production. Key drivers:

- **Automated assembly**: Reduced direct labor per MW
- **Volume procurement**: Discounted material pricing at scale
- **Fixed cost amortization**: Design, engineering, and tooling spread
  over larger production volumes
- **Learning curve**: Continuous improvement as cumulative production
  increases (estimated 10-15% cost reduction per doubling of cumulative
  output)

## References
- NREL H2A Production Analysis models
- BNEF Levelized Cost of Hydrogen methodology
- DOE Hydrogen Shot cost targets
- Lazard Levelized Cost of Energy and Levelized Cost of Hydrogen
- IRENA Green Hydrogen Cost Reduction (2023 update)
