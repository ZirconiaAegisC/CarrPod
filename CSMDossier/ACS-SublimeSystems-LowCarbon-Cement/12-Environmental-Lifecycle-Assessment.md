# Sublime Systems — Environmental Lifecycle Assessment

## Scope and Methodology

This document presents a comparative lifecycle assessment of greenhouse gas emissions associated with cement production via Sublime Systems' electrochemical process versus conventional Portland cement production. The assessment follows ISO 14040/14044 standards to the extent possible given publicly available data.

## System Boundaries

The assessment considers cradle-to-gate emissions:
- **Upstream**: Mining, processing, and transport of raw materials (limestone, calcium silicates, sand, clay, supplementary cementitious materials); production and transport of electricity; production of consumables (electrolyte chemicals, membranes)
- **Core process**: Operation of the electrochemical cement process, including electrolysis, precipitation, filtration, drying, and blending
- **Excluded**: Downstream concrete production (batching, mixing, transport, placement) and end-of-life (demolition, recycling, carbonation) — these are largely common across cement types

## Conventional Portland Cement Baseline

### Process Description
Conventional Portland cement production proceeds through:
1. Raw material extraction (limestone quarrying, clay mining)
2. Raw meal preparation (grinding, blending, homogenization)
3. Preheating and precalcination (800–1000°C)
4. Clinkering in rotary kiln (1450°C)
5. Clinker cooling
6. Cement grinding with gypsum and supplementary cementitious materials

### Emissions Inventory (per tonne of Portland cement, global average)

| Emission Source | kg CO₂ equivalent |
|----------------|-------------------|
| Limestone decomposition (process CO₂) | 520–560 |
| Fuel combustion (coal, petcoke, gas, waste fuels) | 250–350 |
| Electricity (grinding, fans, conveying) | 30–80 |
| Raw material transport | 10–30 |
| **Total (range)** | **810–1,020** |
| **Typical value** | **~900** |

Best-in-class plants with high alternative fuel substitution, waste heat recovery, and low-carbon electricity achieve approximately 600–700 kg CO₂/t. Worst-in-class older plants can exceed 1,000 kg CO₂/t.

## Sublime Electrochemical Process

### Scenario A: Limestone Feedstock with CO₂ Capture

When limestone is used as the calcium source, CO₂ is released in the anode compartment as a concentrated stream. If this CO₂ is captured and permanently stored:

| Emission Source | kg CO₂ equivalent |
|----------------|-------------------|
| Electricity (3 MWh/t × 30 g CO₂/MWh, renewable) | 90 |
| Electricity (3 MWh/t × 70 g CO₂/MWh, renewable/hydro) | 210 |
| Limestone quarrying and transport | 10–20 |
| Electrolyte chemicals and membrane manufacturing | 5–15 |
| CO₂ capture (compression, dehydration) | 5–20 |
| Drying and blending (electrical or hydrogen) | 10–30 |
| Plant construction (amortized) | 5–15 |
| **Total (100% renewable electricity)** | **125–190** |
| **CO₂ captured and stored** | **(400–500)** (negative) |
| **Net (carbon-negative)** | **(275)–(210)** |

Note: The process can be carbon-negative when limestone feedstock is paired with CO₂ capture and storage, because more CO₂ is captured from the calcium carbonate decomposition than is emitted by the process energy consumption.

### Scenario B: Calcium Silicate Feedstock (No Process CO₂)

When calcium silicate minerals (wollastonite, basalt-derived) are used, no CO₂ is released from chemistry:

| Emission Source | kg CO₂ equivalent |
|----------------|-------------------|
| Electricity (3 MWh/t × 30 g CO₂/MWh) | 90 |
| Feedstock mining and transport | 15–30 |
| Electrolyte chemicals and membrane manufacturing | 5–15 |
| Drying and blending | 10–30 |
| Plant construction (amortized) | 5–15 |
| **Total** | **125–180** |

### Emissions Reduction Summary

| Scenario | kg CO₂e/t cement | Reduction vs. Portland (900 kg) |
|----------|-----------------|--------------------------------|
| Portland cement (global average) | 900 | — |
| Portland cement (best-in-class) | 600 | 33% |
| Sublime — limestone + CCS (renewable electricity) | (−275)–(−210) | 123–131% (net carbon-negative) |
| Sublime — calcium silicate feedstock | 125–180 | 80–86% |
| Sublime — limestone + CCS (grid-average, EU) | 150–250 | 72–83% |
| Sublime — calcium silicate (grid-average, US) | 400–550 | 39–56% |

### Key Finding

Like Boston Metal's MOE technology, the carbon intensity of Sublime cement is directly proportional to the carbon intensity of the grid electricity used. Deployment in regions with clean electricity maximizes emissions reduction, while deployment in coal-intensive grids can erode or eliminate the emissions advantage relative to conventional cement.

## Sensitivity to Electricity Carbon Intensity

| Grid Carbon Intensity | Grid Example | Sublime CO₂e (silicate) | Reduction vs. Portland |
|----------------------|-------------|------------------------|------------------------|
| 10 g CO₂/kWh | Norway, Iceland | 30 | 97% |
| 50 g CO₂/kWh | France (nuclear) | 150 | 83% |
| 70 g CO₂/kWh | Brazil (hydro) | 210 | 77% |
| 250 g CO₂/kWh | EU average | 750 | 17% |
| 380 g CO₂/kWh | US average | 1,140 | −27% (worse than Portland!) |
| 550 g CO₂/kWh | China average | 1,650 | −83% (far worse than Portland!) |

This sensitivity analysis yields a critical deployment principle: Sublime cement must be produced in regions with electricity carbon intensity below approximately 200 g CO₂/kWh to achieve meaningful emissions reductions relative to conventional Portland cement. This constrains initial deployment to regions with clean grids (hydro, nuclear, wind/solar-dominant) or to facilities with dedicated renewable electricity supply.

## Other Environmental Impacts

### Air Quality
- **Portland cement**: SO₂, NOₓ, particulate matter, mercury, volatile organic compounds from kiln combustion; significant local air quality impacts in communities near cement plants
- **Sublime**: Minimal air emissions (oxygen, hydrogen). No combustion-related emissions. Local air quality benefits compared to conventional cement plants.

### Water Consumption
- **Portland cement**: Moderate water consumption for cooling, gas conditioning, and dust suppression
- **Sublime**: Potentially higher water consumption due to aqueous process. Closed-loop water recycling minimizes net consumption but requires water treatment systems.

### Land Use and Quarrying
- Both technologies require mineral extraction (limestone quarrying). Sublime's ability to use calcium silicate minerals creates the potential for alternative quarrying sources, but these would have their own land use impacts.

### Byproducts and Circular Economy
- **Portland cement**: Cement kiln dust (CKD), which can be recycled to the kiln or used as a soil amendment
- **Sublime**: Hydrogen byproduct (valuable), oxygen byproduct (if limestone feedstock), and a residual silicate stream that may have value as a supplementary cementitious material or aggregate

---

*Disclosure: Lifecycle assessment data is based on published literature, International Energy Agency cement technology roadmaps, Global Cement and Concrete Association data, Sublime Systems patent filings and presentations, and electrochemical engineering principles. Specific project-level LCAs would require site-specific data on feedstock characteristics, electricity sources, and process parameters.*
