# ACS Antora Energy | Industrial Heat Applications: Steel & Cement

## 1. Industrial Heat Decarbonization Context

### The Scale of the Challenge
Industrial process heat — the energy used to raise the temperature of materials in manufacturing — accounts for approximately 20% of global CO₂ emissions. This exceeds emissions from all passenger vehicles (~10%), aviation (~2%), and shipping (~3%). Within industrial heat:

- **Low-temperature heat (<150°C)**: ~30% of industrial heat demand. Used in food processing, paper, textiles. Can be electrified with heat pumps.
- **Medium-temperature heat (150-500°C)**: ~30% of demand. Used in chemical processing, refining, some metals. Challenging for heat pumps; requires advanced thermal storage or electric resistance heating.
- **High-temperature heat (>500°C)**: ~40% of demand. Used in steel, cement, glass, ceramics. Extremely difficult to electrify directly; Antora's target market.

### Why Thermal Batteries for High-Temperature Heat
Current approaches to decarbonizing high-temperature industrial heat have fundamental limitations:

| Approach | Limitations | Antora's Advantage |
|----------|------------|-------------------|
| Direct electrification (resistance heating) | Requires continuous grid connection; peak power demand is enormous; grid may not supply 24/7 renewable power | Thermal battery decouples energy generation (when sun/wind available) from heat use (when production runs) |
| Green hydrogen combustion | <40% round-trip efficiency; hydrogen infrastructure not yet built; high cost | 90%+ thermal round-trip efficiency; uses existing electricity infrastructure |
| Biomass combustion | Limited sustainable biomass supply; competition with aviation biofuels and other uses; particulate emissions | Zero combustion; no fuel supply chain |
| Carbon capture on existing fossil burners | Adds cost and energy penalty; does not address upstream methane leakage; carbon storage infrastructure not built | Eliminates combustion entirely |
| Nuclear (small modular reactors) | 10+ years to deployment; public acceptance challenges; cost uncertainty | Deployable now; modular; no regulatory or safety constraints beyond standard industrial codes |

## 2. Steel Industry Application

### Steel Manufacturing Heat Requirements
Steel production requires high-temperature heat at multiple stages:

| Process Step | Temperature Required | Current Heat Source | CO₂ Intensity |
|-------------|---------------------|--------------------|---------------|
| Iron ore reduction (blast furnace) | 1,200-1,600°C | Metallurgical coke (carbon) | ~1.8 tons CO₂/ton steel |
| Electric arc furnace (EAF) steelmaking | 1,600-1,800°C | Electric arcs (grid electricity) | ~0.3 tons CO₂/ton steel (depending on grid mix) |
| Reheating furnaces (rolling, forging) | 1,100-1,300°C | Natural gas burners | ~0.2 tons CO₂/ton steel |
| Heat treatment (annealing, tempering) | 500-900°C | Natural gas burners | ~0.1 tons CO₂/ton steel |
| Ladle preheating | 800-1,100°C | Natural gas burners | ~0.05 tons CO₂/ton steel |

### Antora Integration Points in Steel
Antora's 1,800°C thermal battery can directly replace natural gas burners in all post-melting steel heating operations:

**Reheating Furnaces**: Steel slabs or billets reheated to 1,100-1,300°C before hot rolling. Currently accomplished with natural gas-fired walking beam or pusher furnaces. Antora's thermal battery provides:
- Hot air at 1,100-1,300°C delivered via heat exchanger to the furnace
- Eliminates natural gas combustion (and associated CO₂, NOx emissions)
- TPV-generated electricity can power furnace auxiliaries (fans, conveyors, controls)
- Estimated CO₂ reduction: 150-250 kg CO₂/ton of steel processed

**Heat Treatment Furnaces**: Annealing, normalizing, tempering at 500-900°C. Antora thermal battery provides:
- Precise temperature control (±5°C) via modulated heat extraction
- Temperature uniformity across the furnace zone
- Combined heat and power for furnace operation

**Ladle Preheating**: Refractory-lined ladles must be preheated to 800-1,100°C before receiving molten steel. Antora provides:
- High-temperature air for ladle preheating stations
- Continuous availability regardless of renewable generation conditions

### Economic Analysis for Steel (Illustrative)
For a steel minimill with 1 million tons/year capacity:

| Parameter | Value |
|-----------|-------|
| Annual reheating furnace energy consumption | ~200,000 MWh-thermal |
| Current energy cost (natural gas at $5/MMBTU) | ~$3.4M/year |
| Antora system required (nameplate) | ~50 MW-thermal (25 modules) |
| Antora capital cost (projected) | $15-25M |
| Electricity cost for charging (at $20/MWh daytime solar) | ~$4M/year |
| Carbon cost avoidance (at $50/ton CO₂) | ~$1M/year |
| **Simple payback** | **4-7 years** (without incentives) |

With IRA investment tax credits (30% ITC) and industrial decarbonization incentives:
- **Simple payback**: 3-5 years
- **Net present value (10-year)**: Positive at discount rates below 15%

## 3. Cement Industry Application

### Cement Manufacturing Heat Requirements
Cement production is one of the most carbon-intensive industrial processes, with approximately 40% of emissions from fuel combustion (heating the kiln) and 60% from the chemical reaction of limestone calcination (process emissions):

| Process Step | Temperature Required | Current Heat Source | CO₂ Intensity |
|-------------|---------------------|--------------------|---------------|
| Raw meal preheating | 300-800°C | Kiln exhaust gas (waste heat recovery) | Low (waste heat) |
| Calcination (CaCO₃ → CaO + CO₂) | 850-950°C | Kiln burner flame (coal, petcoke, natural gas, waste fuels) | ~0.4 tons CO₂/ton cement (fuel) + 0.5 tons CO₂/ton cement (process) |
| Clinkerization (sintering) | 1,400-1,500°C | Kiln burner flame | Fuel CO₂ included above |
| Clinker cooling | 1,400°C → 100°C | Ambient air (cooling) | Low (electricity for fans) |

### Antora Integration Points in Cement
The cement kiln presents unique challenges and opportunities for thermal battery integration:

**Electric Calcination**: The calcination reaction (CaCO₃ → CaO + CO₂) requires heat at 850-950°C. Antora's thermal battery can provide this heat:
- Hot gas (air or recycled CO₂) at 900-1,000°C injected into the calciner vessel
- Eliminates fuel combustion in the calciner (the largest fuel consumer in the kiln system)
- Enables capture of the pure CO₂ stream released from limestone decomposition (not diluted by combustion flue gas)
- Combined calcination heat + TPV electricity for kiln drive motor and auxiliaries

**Full Electrification Pathway**: A fully electrified cement kiln using Antora thermal batteries would:
1. Use thermal battery heat for calcination (replaces combustion fuel)
2. Use thermal battery heat for clinkerization at 1,400-1,500°C (requires Antora's maximum temperature output)
3. Use TPV-generated electricity for kiln rotation, grinding mills, fans, and conveyors
4. Capture pure CO₂ from calcination for sequestration or utilization (the process emissions cannot be eliminated by fuel switching)

### Process CO₂ Advantage
The cement industry's unique challenge is that approximately 60% of emissions are "process emissions" — CO₂ released from the limestone chemical reaction, not from fuel combustion. Fuel switching (from fossil fuels to thermal battery heat) addresses only the combustion emissions. However, Antora's electrified calcination approach produces a pure, undiluted CO₂ stream from calcination, which is vastly cheaper to capture than CO₂ mixed with combustion flue gases.

### Economic Analysis for Cement (Illustrative)
For a 1 million ton/year cement plant:

| Parameter | Value |
|-----------|-------|
| Annual calciner fuel consumption | ~900,000 MWh-thermal |
| Current energy cost (coal at $3/MMBTU) | ~$9.2M/year |
| Antora system required (nameplate) | ~200 MW-thermal (100 modules) |
| Antora capital cost (projected) | $60-100M |
| Electricity cost for charging (at $20/MWh) | ~$18M/year |
| Carbon cost avoidance (at $50/ton CO₂, fuel portion) | ~$3.5M/year |
| **Simple payback** | **12-20 years** (without incentives) |

The cement industry case is more challenging than steel due to the very high energy intensity of cement kilns. With industrial decarbonization incentives (DOE OCED grants, IRA 48C ITC, carbon contracts for differences), payback can improve to 5-8 years. However, the cement sector will likely require stronger policy support (carbon pricing, procurement standards for low-carbon cement) to drive thermal battery adoption.

## 4. Cross-Cutting Benefits for Heavy Industry

### Grid Independence
Industrial facilities with on-site thermal batteries gain operational flexibility:
- Charge during low-price renewable hours (midday solar, overnight wind)
- Discharge during high-price peak hours for both heat and power
- Participate in demand response and ancillary services markets via TPV-generated electricity
- Reduced exposure to natural gas price volatility

### Combined Heat and Power Efficiency
Antora's unique "dual output" capability provides both heat and electricity:
- Heat at the temperature required by the process (configurable from 500-1,800°C)
- Electricity from TPV conversion of thermal radiation that would otherwise be lost
- Overall system efficiency (useful energy out / energy in) can exceed 90% when both heat and power outputs are utilized

### Emissions Reduction
- Eliminates Scope 1 emissions from on-site fuel combustion
- Can reduce Scope 2 emissions when TPV-generated electricity is used on-site
- Enables 24/7 carbon-free industrial operations when paired with renewable energy procurement
