# e-Zinc — Cost Economics & <$100/kWh Target

## The Levelized Cost of Storage Framework

The levelized cost of storage provides a standardized metric for comparing the
all-in cost of stored electricity across technologies, accounting for capital
costs, operating expenses, efficiency, and lifetime. The framework:

```
LCOS = (CAPEX × CRF + Fixed O&M) / (Annual Cycles × Discharge Duration × ηRT)
       + (Variable O&M + Charging Cost / ηRT)
```

where LCOS is expressed in $/kWh discharged, CAPEX is the installed system cost,
CRF is the capital recovery factor, and ηRT is round-trip efficiency.

## Capital Cost Structure

The installed capital cost of a zinc-air storage system can be decomposed into
power-related costs (determined by the MW rating) and energy-related costs
(determined by the MWh capacity):

| Cost Category | Type | Typical Contribution | Key Driver |
|--------------|------|---------------------|-----------|
| Cells and stacks | Power | 20-30% of CAPEX | Electrode manufacturing cost |
| Power conversion system | Power | 15-20% | Standard industrial inverters |
| Zinc inventory | Energy | 10-15% | Zinc commodity price ($3/kg) |
| Electrolyte | Energy | 5-8% | KOH commodity price |
| Container and racking | Mixed | 10-15% | Steel and fabrication cost |
| Air management | Power | 3-5% | Blowers, filters, ducting |
| Thermal management | Power | 3-5% | Heat exchangers, fans |
| Controls and BMS | Fixed | 5-8% | Electronics, software |
| Installation and commissioning | Mixed | 8-12% | Site labor, civil works |
| Contingency and soft costs | Fixed | 10-15% | Engineering, permitting, financing |

## The Power-Energy Decoupling Cost Advantage

The cost structure above reveals the fundamental economic advantage of e-Zinc's
architecture for long-duration applications:

- At 4-hour duration, power-related costs (cells, PCS) dominate
- At 12-hour duration, energy-related costs (zinc, electrolyte) become significant
  but are still outweighed by power costs
- At 24-hour duration, energy costs approach parity with power costs
- At 100-hour duration, energy costs dominate, but they are intrinsically low
  because zinc and KOH are commodity materials

This creates a system whose cost per kWh is a declining function of storage
duration — exactly the opposite of lithium-ion, whose cost per kWh is
approximately constant because the cell cost determines both power and energy
capacity.

## Path to <$100/kWh

| Cost Reduction Lever | Current Estimate | Target | Mechanism |
|---------------------|-----------------|--------|-----------|
| Cell manufacturing scale | High unit cost | 60-70% reduction | Volume production, automation |
| Electrode material optimization | Baseline | 20-30% reduction | Improved catalysts, thinner layers |
| Power electronics | Standard industrial | 15-25% reduction | Volume procurement, integrated design |
| Zinc inventory | ~$15-20/kWh | ~$10-15/kWh | Bulk procurement, supply agreements |
| System integration | Labor-intensive assembly | 50-60% reduction | Automated assembly line |
| Balance of plant | Custom engineering | 30-40% reduction | Standardized modular design |

Achieving the <$100/kWh installed cost target requires execution across all of
these levers simultaneously, with the largest contributions coming from
manufacturing scale (which reduces both labor and material costs through volume
procurement) and automated assembly (which reduces the labor content of system
integration).

## DOE Long Duration Storage Shot Alignment

The U.S. Department of Energy's Long Duration Storage Shot, announced in 2021,
targets a 90% reduction in the cost of grid-scale energy storage for systems
providing 10+ hours of duration, aiming for a levelized cost of storage of
$0.05/kWh by 2030. e-Zinc's <$100/kWh capital cost target, combined with its
>70% round-trip efficiency and >20-year lifetime, is designed to achieve LCOS
values consistent with this goal when deployed at commercial scale with high
utilization rates.

## Comparison to Lithium-Ion Economics

| Duration | Li-ion CAPEX ($/kWh) | e-Zinc Target ($/kWh) | e-Zinc LCOS ($/kWh) | Li-ion LCOS ($/kWh) |
|----------|---------------------|-----------------------|--------------------|--------------------|
| 4 hours | $350 | $300 | $0.12-0.15 | $0.10-0.14 |
| 12 hours | $350 | $150 | $0.06-0.08 | $0.10-0.14 |
| 24 hours | $350 | $125 | $0.05-0.07 | $0.10-0.14 |
| 100 hours | $350 | $80 | $0.04-0.06 | $0.10-0.14 |

At durations beyond approximately 8 hours, the e-Zinc system achieves lower
levelized cost than lithium-ion, with the advantage growing as duration increases.
This crossover point defines e-Zinc's competitive beachhead in the storage market.