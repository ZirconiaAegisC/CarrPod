# e-Zinc — Zinc-Air Battery Fundamentals

## Electrochemical Basis

Zinc-air batteries are a type of metal-air electrochemical cell that generates
electricity through the oxidation of zinc metal with oxygen from ambient air.
Unlike conventional batteries that contain both anode and cathode active materials
within a sealed container, zinc-air batteries are "half-open" systems: the zinc
anode is contained within the cell, while the cathode reactant — oxygen — is drawn
from the surrounding atmosphere. This architecture gives zinc-air batteries a
fundamental advantage in specific energy, since the heaviest component of most
batteries (the cathode active material) is effectively supplied by the environment.

## Discharge Chemistry

During discharge (electricity production), the following reactions occur:

- **Anode (oxidation):** Zn + 4OH⁻ → Zn(OH)₄²⁻ + 2e⁻
  followed by precipitation: Zn(OH)₄²⁻ → ZnO + H₂O + 2OH⁻
- **Cathode (reduction):** O₂ + 2H₂O + 4e⁻ → 4OH⁻
- **Overall:** 2Zn + O₂ → 2ZnO

Zinc metal is oxidized at the anode, releasing electrons that flow through the
external circuit (doing useful work) and producing zincate ions that eventually
precipitate as zinc oxide. At the air cathode, atmospheric oxygen is reduced to
hydroxide ions, which migrate through the electrolyte to complete the circuit.

## Charge Chemistry

During charging, an external voltage is applied to reverse the discharge reactions:

- **Cathode (now the positive electrode):** 4OH⁻ → O₂ + 2H₂O + 4e⁻
- **Anode (now the negative electrode):** ZnO + H₂O + 2e⁻ → Zn + 2OH⁻
- **Overall:** 2ZnO → 2Zn + O₂

The zinc oxide produced during discharge is electrochemically reduced back to
zinc metal, which plates onto the anode current collector. This reversibility —
accomplished without dendrite formation or irreversible side reactions — is the
central technical achievement that distinguishes e-Zinc's technology from
historical zinc-air rechargeable battery attempts.

## Aqueous Electrolyte Advantage

e-Zinc uses an **aqueous alkaline electrolyte**, typically potassium hydroxide
solution, which provides several advantages over the organic electrolytes used in
lithium-ion batteries:

- **Non-flammable** — zero risk of thermal runaway or electrolyte fire, eliminating
  the need for complex thermal management and fire suppression systems
- **High ionic conductivity** — aqueous electrolytes have substantially higher
  ionic conductivity than organic electrolytes, enabling higher power density
- **Low cost** — potassium hydroxide is an industrial commodity chemical with
  well-established production and supply chains
- **Environmental compatibility** — in the event of a containment breach, the
  electrolyte poses minimal environmental hazard

## The Air Electrode

The air cathode is a critical component that must simultaneously:

1. Allow oxygen from the atmosphere to diffuse to the reaction sites
2. Catalyze the oxygen reduction reaction during discharge
3. Catalyze the oxygen evolution reaction during charge
4. Prevent electrolyte leakage while permitting gas transport
5. Resist carbonate formation from atmospheric CO₂

This multifunctional requirement makes air electrode design the most challenging
aspect of zinc-air battery engineering and the area where e-Zinc's proprietary
technology provides the greatest competitive differentiation.

## Key Performance Metrics

| Parameter | e-Zinc Target | Context |
|-----------|--------------|---------|
| Discharge duration | 12-100+ hours | Positioned for long-duration storage |
| Round-trip efficiency | >70% | Competitive with other long-duration technologies |
| Cycle life | >5,000 cycles | 20+ year operational lifetime |
| Calendar life | >20 years | Matches project finance horizons |
| Installed cost | <$100/kWh | Target set by DOE Long Duration Storage Shot |
| Operating temperature | -20°C to +50°C | Suitable for outdoor installation |