# Sublime Systems — Electrochemical pH-Swing Process: Technical Deep Dive

## Process Chemistry Fundamentals

The Sublime Systems process is an elegant application of well-established electrochemical engineering principles — pH-swing chemistry, ion-exchange membrane electrolysis, and aqueous precipitation — to the cement production challenge. This document examines the fundamental chemistry and engineering in detail.

## Electrochemical pH-Swing Concept

The core insight driving Sublime's technology is that calcium-bearing minerals are soluble in acidic solutions and calcium silicates precipitate from basic solutions. By using electrochemistry to generate acidity and basicity on demand in separate compartments of an electrolyzer, the process creates a continuous loop: dissolve calcium in acid, transport calcium ions across a membrane, precipitate calcium silicates in base.

### The Electrochemical Cell

The Sublime electrolyzer employs a three-compartment configuration:

**Anode Compartment (Acid Generation)**
- Anode reaction: 2 H₂O → O₂ + 4 H⁺ + 4 e⁻
- Protons generated acidify the compartment to pH 0–3
- Calcium-bearing feedstock is introduced into this acidic compartment
- Calcium dissolves: CaCO₃ + 2 H⁺ → Ca²⁺ + H₂O + CO₂ (limestone feedstock)
- or CaSiO₃ + 2 H⁺ + H₂O → Ca²⁺ + H₄SiO₄ (silicate feedstock)

**Central Compartment (Calcium Transport)**
- Calcium ions migrate from the anode compartment toward the cathode under the electric field
- A cation-exchange membrane (CEM) separating the anode and central compartments permits Ca²⁺ transport while blocking anions
- The central compartment accumulates calcium ions at near-neutral pH

**Cathode Compartment (Base Generation / Precipitation)**
- Cathode reaction: 2 H₂O + 2 e⁻ → H₂ + 2 OH⁻
- Hydroxide ions generated raise the pH to 10–13
- An anion-exchange membrane (AEM) or bipolar membrane may be used depending on configuration
- Dissolved silica introduced into the basic compartment reacts with calcium: x Ca²⁺ + y SiO₂(aq) + z OH⁻ → calcium silicate hydrate precipitate

### Electrolyte Chemistry

The electrolyte in Sublime's process is an aqueous solution containing:
- Dissolved salts to provide ionic conductivity (NaCl, KCl, or other supporting electrolytes)
- Dissolved calcium (Ca²⁺) in transit from the anode to cathode compartments
- Dissolved silica species (H₄SiO₄, H₃SiO₄⁻) in the cathode compartment for precipitation
- Buffer species to maintain pH control

The specific electrolyte composition is a critical trade secret, as it determines:
- Ionic conductivity (affects energy consumption)
- Calcium solubility limits (affects throughput)
- Membrane compatibility (affects lifetime)
- Precipitation kinetics and product morphology (affects cement quality)

## Membrane Technology

The ion-exchange membranes separating the electrolyzer compartments are critical components:

### Cation-Exchange Membrane (CEM)
- Selectively transports cations (Ca²⁺, Na⁺, K⁺, H⁺) while blocking anions (Cl⁻, SO₄²⁻, CO₃²⁻)
- Must withstand acidic conditions on the anode side
- Key performance parameters: ionic conductivity, calcium ion selectivity, chemical stability, mechanical durability

### Bipolar Membrane (BPM) Configuration
An alternative configuration uses bipolar membranes that split water into H⁺ and OH⁻ at an internal interface:
- Eliminates the need for separate acid and base generation at electrodes
- Reduces the thermodynamic voltage requirement
- Simplifies cell design but introduces challenges related to BPM durability and water transport

Sublime's patent filings describe both CEM/AEM and BPM configurations, suggesting ongoing optimization of the membrane architecture.

## Electrode Reactions and Catalysts

### Oxygen Evolution Reaction (Anode)
- 2 H₂O → O₂ + 4 H⁺ + 4 e⁻
- Thermodynamic potential: 1.23 V at standard conditions
- In acidic solution, requires catalysts stable under oxidizing, low-pH conditions
- Candidate catalysts: iridium oxide (IrO₂), ruthenium oxide (RuO₂), platinum group metals and their oxides

### Hydrogen Evolution Reaction (Cathode)
- 2 H₂O + 2 e⁻ → H₂ + 2 OH⁻
- Thermodynamic potential: 0 V (reference) at standard conditions
- In basic solution, nickel-based catalysts, nickel-molybdenum, or nickel-iron alloys are effective and lower-cost than platinum group metals

The hydrogen byproduct is a significant economic consideration. At commercial scale (250,000 t/yr cement plant):
- Hydrogen production: approximately 5,000–12,500 tonnes per year
- Revenue potential (at $2–4/kg H₂): $10–50 million annually
- Alternative use: on-site combustion for drying or other thermal needs, or electricity generation via fuel cells

## Product Chemistry — Calcium Silicate Hydrates

The precipitate from the cathode compartment is a calcium silicate hydrate (C-S-H) gel analogous to the binding phase that forms when Portland cement reacts with water. Key characteristics:

- **Calcium-to-silicon ratio (Ca/Si)**: Typically 0.8–1.7, controllable through process conditions
- **Amorphous or poorly crystalline**: Similar to C-S-H in hydrated Portland cement
- **Reactive**: Undergoes further hydration and carbonation when exposed to water and CO₂
- **Particle morphology**: Can be engineered through precipitation conditions (pH, temperature, concentration, residence time)

The precipitated product is filtered, washed to remove soluble salts, and dried at low temperature (<200°C). The drying step, while requiring energy, operates at far lower temperatures than the 1450°C required for Portland cement clinkering.

## Process Efficiency and Energy Consumption

### Thermodynamic Minimum
The thermodynamic minimum energy for the calcium carbonate decomposition reaction is approximately 178 kJ/mol CaCO₃, equivalent to approximately 0.5 MWh per tonne of CaCO₃, or approximately 0.7 MWh per tonne of cement (assuming 75% CaCO₃ in raw meal).

### Practical Energy Consumption
Practical energy consumption is higher due to:
- Electrochemical overpotentials (kinetic, ohmic, mass transport) at both electrodes
- Membrane resistance
- Pumping, filtration, and drying energy
- Process inefficiencies (side reactions, current inefficiency)

Published estimates suggest total electrical energy consumption in the range of 2–4 MWh per tonne of cement, with a pathway to 1.5–2.5 MWh per tonne through electrolyzer and process optimization.

### Energy Comparison
| Pathway | Primary Energy (GJ/t cement) | CO₂ (kg/t cement) |
|---------|---------------------------|-------------------|
| Conventional kiln (coal) | 3.0–4.0 (thermal) + 0.5 (electrical) | 600–900 |
| Conventional kiln (electrified) | 2.5–3.5 (electrical) | 400–600 (process only) |
| Sublime electrochemical | 2.0–4.0 (electrical) | 0–100 (grid-dependent) |

When powered by low-carbon electricity, Sublime's process achieves 90%+ CO₂ reduction versus conventional cement production while consuming comparable total energy — a remarkable achievement given that conventional cement has benefited from over 150 years of process optimization.

## Carbon Dioxide Management

### With Limestone Feedstock
When limestone (CaCO₃) is used as the calcium source, CO₂ is released in the anode compartment:
    CaCO₃ + 2 H⁺ → Ca²⁺ + H₂O + CO₂

This CO₂ stream is:
- Concentrated (>90% CO₂, dry basis — the balance is oxygen from the anode reaction)
- At ambient temperature and pressure (no compression required beyond that needed for transport)
- Suitable for capture, utilization, or sequestration without the expensive post-combustion capture systems required for dilute CO₂ streams from conventional kilns

If the CO₂ is captured and permanently stored (CCS), the process delivers carbon-negative cement — more CO₂ is sequestered than emitted.

### With Calcium Silicate Feedstock
When calcium silicate minerals (wollastonite, anorthite, basalt) are used, no CO₂ is released. The overall process chemistry is:
    CaSiO₃ (mineral) + H₂O → Ca²⁺ + SiO₂ (aq) + 2 OH⁻
followed by precipitation:
    Ca²⁺ + SiO₂ (aq) + 2 OH⁻ → CaSiO₃ · H₂O (cement)

This is net-zero CO₂ from chemistry, and when powered by renewable electricity, achieves near-zero total CO₂ emissions.

---

*Disclosure: Process chemistry and engineering details are based on published patent filings from Sublime Systems and MIT, peer-reviewed electrochemical engineering literature, and publicly available company presentations. Specific process parameters, electrolyte compositions, and membrane configurations are estimates based on disclosed information.*
