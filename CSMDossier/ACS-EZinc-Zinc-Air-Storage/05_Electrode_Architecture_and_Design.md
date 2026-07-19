# e-Zinc — Electrode Architecture & Design

## Three-Dimensional Electrode Concept

Traditional zinc batteries use flat, planar electrodes where the zinc active
material is applied as a thin coating on a two-dimensional current collector.
e-Zinc's core innovation is the use of **three-dimensional electrode structures**
that dramatically increase the surface area available for electrochemical
reactions while providing a mechanically stable framework for zinc deposition
and dissolution over thousands of cycles. This architectural approach directly
addresses the dendrite, shape change, and passivation challenges described in
the preceding chapter.

## Negative Electrode Design

The negative electrode (anode during discharge, cathode during charge) consists
of a high-surface-area, electrically conductive substrate that serves as both
current collector and structural scaffold for the zinc active material. Key
design features include:

| Feature | Function | Benefit |
|---------|----------|---------|
| High porosity (>70%) | Accommodates zinc volume changes during cycling | Prevents mechanical stress and delamination |
| Controlled pore size distribution | Uniform current density across thickness | Suppresses dendrite initiation |
| Engineered surface chemistry | Promotes uniform zinc nucleation | Prevents localized deposition |
| Three-dimensional current collection | Low electrical resistance throughout volume | High energy efficiency |

## Positive Electrode (Air Cathode) Design

The air cathode is a multilayer structure that must perform several functions
simultaneously:

1. **Gas diffusion layer** — a hydrophobic, porous layer (typically PTFE-treated
   carbon paper or cloth) that allows atmospheric oxygen to enter the cell while
   preventing electrolyte leakage. The hydrophobicity is critical: it must resist
   electrolyte penetration while remaining permeable to oxygen.

2. **Current collector** — a conductive mesh or expanded metal (typically nickel
   or nickel-coated) embedded within or adjacent to the gas diffusion layer that
   carries electrical current to and from the reaction sites.

3. **Catalyst layer** — a mixture of high-surface-area carbon, bifunctional
   catalyst particles (capable of catalyzing both oxygen reduction and oxygen
   evolution), and a hydrophobic binder. This layer provides the triple-phase
   boundary where gaseous oxygen, liquid electrolyte, and solid catalyst meet.

4. **Electrolyte-facing layer** — a hydrophilic layer that ensures good ionic
   contact with the aqueous electrolyte while preventing gas bubble accumulation
   that would block ion transport.

## Bifunctional Catalyst Development

The air cathode catalyst is arguably the most critical material in the entire
cell. It must catalyze two fundamentally different reactions — oxygen reduction
(during discharge) and oxygen evolution (during charge) — with high activity
and long-term stability. e-Zinc's catalyst development program has focused on:

- **Non-precious metal catalysts** — transition metal oxides (manganese, cobalt,
  nickel-based) and perovskite structures that provide adequate bifunctional
  activity without the cost and supply constraints of platinum-group metals
- **High-surface-area carbon supports** — engineered carbon materials that
  provide electrical conductivity and catalyst dispersion while resisting
  oxidative corrosion during the oxygen evolution reaction
- **Composite catalyst systems** — combinations of materials optimized separately
  for ORR and OER, integrated into a single electrode structure

## Electrolyte Management System

Unlike sealed batteries, e-Zinc's system incorporates active electrolyte
management:

- **Circulation** — pumps that maintain uniform electrolyte composition throughout
  the cell and prevent stratification that would cause non-uniform current
  distribution
- **Filtration** — removal of particulates and precipitates that could clog
  electrodes or separators
- **Conductivity monitoring** — sensors that track electrolyte condition and
  trigger replenishment or adjustment as needed
- **Thermal control** — heat exchangers that maintain optimal operating temperature,
  rejecting waste heat from the exothermic discharge reaction and ohmic losses

## Scale-Up Considerations

Translating the electrode architecture from laboratory-scale single cells
(typically <100 cm²) to commercial-scale modules (square meters) requires
addressing several challenges:

- **Uniformity** — maintaining consistent electrode properties (porosity,
  thickness, catalyst loading) across large areas
- **Current distribution** — ensuring uniform current density across the full
  electrode area to prevent localized degradation
- **Gas management** — designing flow paths that provide uniform oxygen access
  to all regions of the air cathode
- **Manufacturing process** — developing roll-to-roll or batch coating processes
  capable of producing electrodes at commercial volumes and costs