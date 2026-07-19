# Iron Flow Battery Chemistry — All-Iron Redox Reactions

## Fundamental Principle

The ESS iron flow battery is an electrochemical energy storage device that converts electrical energy into chemical potential stored in liquid electrolytes. The fundamental operating principle is a redox flow battery (RFB): two liquid electrolyte solutions are pumped through separate half-cells of an electrochemical stack, where reversible reduction-oxidation reactions occur at inert electrodes separated by a proton-exchange membrane.

## Two Half-Reactions

The ESS battery employs a unique all-iron chemistry, meaning that the same base element — iron — participates in both the positive and negative half-cell reactions, but in different oxidation states:

**Positive Electrode (Cathode during charge):**
```
2Fe²⁺  ⇌  2Fe³⁺  +  2e⁻      E⁰ = −0.77 V vs SHE
```
During charging, ferrous ions (Fe²⁺) are oxidized to ferric ions (Fe³⁺) at the positive electrode. During discharge, ferric ions are reduced back to ferrous ions.

**Negative Electrode (Anode during charge):**
```
Fe²⁺  +  2e⁻  ⇌  Fe⁰(s)      E⁰ = −0.44 V vs SHE
```
During charging, ferrous ions are reduced and deposit as solid metallic iron on the negative electrode surface. During discharge, the plated iron dissolves back into solution as Fe²⁺ ions.

## Overall Cell Reaction

The combined cell reaction during charge is:
```
3FeCl₂  →  2FeCl₃  +  Fe⁰(s)
```
During discharge, the reaction reverses completely. The net cell voltage is approximately 1.2 V, derived from the difference between the two half-cell potentials (0.77 V − (−0.44 V) = 1.21 V). In practice, cells are stacked in series to achieve higher system voltages.

## Electrolyte Composition

The electrolyte is a simple aqueous solution of iron (II) chloride (FeCl₂) dissolved in water with a supporting salt (typically NaCl or KCl) to enhance ionic conductivity. The solution is:

- **Abundant:** Iron is the fourth most common element in Earth's crust, representing approximately 5% by weight
- **Non-toxic:** Iron chloride solutions are not classified as hazardous materials under OSHA or DOT regulations
- **Non-flammable:** Aqueous solutions cannot ignite, eliminating the thermal runaway risks associated with lithium-ion chemistries
- **pH-neutral to mildly acidic:** Operating pH range of 2–4, minimizing corrosion challenges in balance-of-system components
- **Inexpensive:** Iron chloride costs approximately $0.30–0.50 per kilogram at industrial scale

## Key Chemical Advantages

### 1. Single-Element Chemistry
Unlike vanadium redox flow batteries (VRFB) that require vanadium in both V⁴⁺/V⁵⁺ and V²⁺/V³⁺ oxidation states, the ESS chemistry uses only iron in different oxidation states. This eliminates the need for expensive separation membranes designed to prevent cross-contamination between different metals. If iron ions migrate across the membrane, no permanent capacity loss occurs — the electrolyte simply re-equilibrates.

### 2. Plating Rather Than Dissolution
The negative electrode reaction involves plating solid iron onto the electrode, rather than simply changing the oxidation state of ions remaining in solution. This allows for higher energy density in the negative half-cell compared to solution-phase-only flow batteries. The plating morphology must be carefully controlled to prevent dendritic growth, which could short-circuit the cell. ESS has developed proprietary electrode surface treatments and charging protocols to ensure uniform, dense, adherent plating.

### 3. No Gas Evolution Side Reactions
Under normal operating conditions, the all-iron chemistry operates within a voltage window that avoids water electrolysis (hydrogen or oxygen evolution). This means the electrolyte does not require periodic replenishment or rebalancing, in contrast to some zinc-based flow batteries that experience hydrogen evolution at the negative electrode.

## Chemical Durability

Laboratory and field testing has demonstrated that the iron electrolyte chemistry supports more than 20,000 full charge-discharge cycles without measurable degradation in capacity or round-trip efficiency. This is because:

1. The redox reactions are fully reversible and involve no phase-change or structural transformation of electrode materials
2. Unlike lithium-ion intercalation electrodes, there is no mechanical stress from lithium insertion/deinsertion
3. The liquid electrolytes are continuously circulated, ensuring uniform composition and temperature throughout the system

## Electrolyte Management System

The battery includes a sophisticated electrolyte management subsystem that monitors and controls:

- **pH regulation:** Automated addition of hydrochloric acid to maintain optimal pH
- **Oxidation state balance:** Sensors continuously monitor the Fe²⁺/Fe³⁺ ratio and trigger rebalancing cycles if needed
- **Temperature control:** Heat exchangers maintain electrolyte between 25–50°C for optimal kinetics
- **Filtration:** Particulate filters capture any iron particles that may detach from electrodes during cycling