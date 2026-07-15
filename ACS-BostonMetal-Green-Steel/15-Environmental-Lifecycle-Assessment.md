# Boston Metal — Environmental Lifecycle Assessment

## Scope and Methodology

This document presents a comparative lifecycle assessment of greenhouse gas emissions associated with iron production via Boston Metal's Molten Oxide Electrolysis technology versus conventional blast furnace ironmaking. The assessment follows ISO 14040/14044 standards to the extent possible given publicly available data.

## System Boundaries

The assessment considers cradle-to-gate emissions for the ironmaking step, defined as:
- **Upstream**: Mining, beneficiation, and transport of iron ore and other raw materials; production and transport of electricity; production of consumables (electrolyte materials, refractory linings)
- **Core process**: Operation of the MOE cell or blast furnace, including all direct process emissions
- **Excluded**: Downstream steelmaking (BOF, EAF), casting, rolling, and finishing — these steps are common to both pathways and their emissions are determined by the choice of downstream process rather than the ironmaking technology

## Conventional Blast Furnace Baseline

### Process Description
The conventional blast furnace reduces iron ore to liquid hot metal using coke (derived from coal) as both the reducing agent and the structural support for the burden column. Pulverized coal injection and natural gas injection supplement coke as fuel and reductant.

### Emissions Inventory (per tonne of hot metal)
| Emission Source | kg CO₂ equivalent |
|----------------|-------------------|
| Coke production (coal mining, coking) | 300–400 |
| Blast furnace direct emissions (combustion, reduction) | 1,200–1,400 |
| Sintering/pelletizing of iron ore | 150–250 |
| Ancillary processes (oxygen plant, power plant) | 100–200 |
| **Total (range)** | **1,750–2,250** |
| **Typical value** | **~1,900** |

### Key Observations
- Approximately 60–70% of emissions derive from the chemical reduction of iron oxide by carbon — a fundamental characteristic of the process that cannot be eliminated without changing the reducing agent
- Coke production (including coal mining methane emissions) contributes 15–20% of total emissions
- Carbon capture can reduce emissions by 50–70% but adds energy consumption of 2–4 GJ per tonne of CO₂ captured, equivalent to approximately 150–300 kWh per tonne of hot metal

## Boston Metal MOE Process

### Process Description
MOE reduces iron ore to liquid iron using electricity as the energy source and reducing agent, with no carbon involved in the reduction chemistry. The only gaseous product is oxygen.

### Emissions Inventory (per tonne of liquid iron)

#### Scenario A: Grid-Average Electricity (Brazil, ~85% renewable)
| Emission Source | kg CO₂ equivalent |
|----------------|-------------------|
| Electricity (3.75 MWh/t × 70 kg CO₂/MWh) | 260 |
| Ore mining and transport | 40–60 |
| Electrolyte materials production | 20–40 |
| Anode and refractory manufacturing | 10–30 |
| Cell construction (amortized over lifetime) | 10–20 |
| Ancillary systems | 10–20 |
| **Total** | **350–430** |

#### Scenario B: 100% Renewable Electricity (wind, solar, hydro)
| Emission Source | kg CO₂ equivalent |
|----------------|-------------------|
| Electricity (3.75 MWh/t × 10–30 kg CO₂/MWh) | 40–110 |
| Ore mining and transport | 40–60 |
| Electrolyte materials production | 20–40 |
| Anode and refractory manufacturing | 10–30 |
| Cell construction (amortized) | 10–20 |
| Ancillary systems | 10–20 |
| **Total** | **130–280** |

### Emissions Reduction Summary
| Scenario | Conventional BF | MOE (Grid) | MOE (100% Renewable) |
|----------|----------------|-----------|----------------------|
| Emissions (kg CO₂e/t iron) | ~1,900 | ~400 | ~200 |
| Reduction vs. BF | — | ~79% | ~89% |
| With $100/tCO₂ carbon price | +$190/t | +$40/t | +$20/t |

## Other Environmental Impacts

### Air Quality
- **Blast furnace**: SO₂, NOₓ, particulate matter, volatile organic compounds, polycyclic aromatic hydrocarbons from coal combustion and coking
- **MOE**: Negligible air emissions during operation (only oxygen byproduct). Upstream emissions depend on electricity generation mix.

### Water Consumption
- **Blast furnace**: Significant water consumption for cooling, gas cleaning, and slag granulation (typically 10–30 m³ per tonne of steel)
- **MOE**: Moderate water consumption for cooling systems (closed-loop where feasible). Lower water consumption than conventional steelmaking due to the absence of gas cleaning requirements and slag granulation.

### Solid Waste
- **Blast furnace**: Blast furnace slag (250–350 kg per tonne of hot metal), which is largely valorized as a cementitious material; coke breeze and flue dust
- **MOE**: Electrolyte slag, which may have cementitious properties and could provide an additional revenue stream if proven suitable as a supplementary cementitious material

### Land Use
- **Blast furnace**: Integrated steel mill requires 200–500 hectares; coal mining land disturbance upstream
- **MOE**: Smaller footprint per unit of production due to modular design; no coal mining requirement

## Sensitivity to Electricity Carbon Intensity

The carbon intensity of MOE iron is directly proportional to the carbon intensity of the electricity supply, moderated by the ~80% reduction in emissions that is achieved even with grid-average electricity in relatively clean grids such as Brazil's. The following table illustrates the sensitivity:

| Electricity Source | Grid Carbon Intensity (g CO₂/kWh) | MOE Emissions (kg CO₂e/t Fe) | Reduction vs. BF |
|-------------------|----------------------------------|------------------------------|-------------------|
| Norway (hydro) | 20 | 115 | 94% |
| Brazil (hydro/wind/solar) | 70 | 300 | 84% |
| France (nuclear) | 55 | 250 | 87% |
| EU average | 250 | 980 | 48% |
| US average | 380 | 1,465 | 23% |
| China average | 550 | 2,100 | -10% |
| India average | 700 | 2,640 | -39% |

This analysis demonstrates that MOE's emissions advantage is maximized when deployed in regions with low-carbon electricity grids and that deployment in regions with coal-intensive grids would actually increase emissions relative to conventional blast furnace ironmaking. This finding reinforces Boston Metal's strategy of targeting initial deployment in regions with clean, low-cost electricity.

## Comparison with Hydrogen-Based DRI

| Metric | BF-BOF | H₂-DRI + EAF | MOE (100% renewable) |
|--------|--------|-------------|----------------------|
| CO₂ emissions (kg/t steel) | 1,800–2,200 | 300–600 | 150–300 |
| Electricity consumption (MWh/t) | 0.5–1.0 | 3.0–4.5 | 3.5–4.0 (iron only) |
| Ore quality requirement | All grades | Premium pellets only | All grades |
| Hydrogen requirement | None | 50–60 kg/t DRI | None |
| Technology maturity | Mature | Pilot-commercial | Pilot-commercial |
| Capital intensity | High | Very high | Moderate (modular) |

Both MOE and hydrogen-DRI can achieve >90% emissions reduction relative to conventional blast furnace ironmaking when powered by clean electricity. The choice between them in any given deployment context will depend primarily on ore quality availability, electricity costs, and hydrogen infrastructure.

---

*Disclosure: Lifecycle assessment is based on publicly available data, published literature on conventional steelmaking emissions (World Steel Association, IEA), and company disclosures. Grid carbon intensity data is sourced from the International Energy Agency and national statistical agencies. Results are indicative and specific project-level LCAs would require site-specific data.*
