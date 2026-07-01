# F2-026 — Thermal Management and Cooling Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Cooling Fluid Selection: PAG (Polyalkylene Glycol)

The Charlemagne Fleet uses **PAG dielectric coolant** — NOT ethylene glycol water mixture:

| Property | EG/Water 50:50 | PAG | Advantage |
|---|---|---|---|
| Electrical conductivity | ~0.1–1 mS/cm (ionic) | <0.001 mS/cm | 1,000× less conductive |
| Resistivity | ~10⁴ Ω·m | >10⁸ Ω·m | Meets Dielectric Citadel standard |
| Biodegradability | Moderate | >98% | Environmental compliance |
| Flash point | 111°C | >250°C | Fire safety in AAJ/CMBC context |
| Viscosity at 20°C | 4 mPa·s | 8–12 mPa·s | Slightly higher (acceptable) |

**Critical:** EG/water solution becomes ionically conductive over time as it picks up
metal ions from system corrosion. PAG remains dielectric indefinitely (no metal in contact).

## 2. Cooling Circuit Architecture

```
CMBC (heat source) → ZrO₂ fitting → PEX-a tubing → ZrO₂ fitting → 
KNbO₃ piezo pump → ZrO₂ fitting → BFRP heat exchanger → 
ZrO₂ fitting → back to CMBC inlet
```

**No metal anywhere in the cooling loop.** All fittings: ZrO₂ compression type.
Tubing: PEX-a (cross-linked polyethylene, ρ > 10¹² Ω·m).
Heat exchanger (ambient-to-coolant): BFRP core, ZrO₂ tubes.

## 3. CMBC Thermal Model (BERYL Reference)

| Condition | Cell heat gen | Coolant ΔT | Cell max temp | Status |
|---|---|---|---|---|
| Normal (1C charge) | 35 W | 0.6°C | 27°C | Excellent |
| High power (2C continuous) | 150 W | 2.6°C | 31°C | Good |
| Worst case (5C pulse, 30 s) | 375 W | 6.5°C | 41°C | Acceptable (<55°C limit) |
| Post-runaway (single cell) | 800 W | 14°C | 44°C | Warning (cooling activated) |

**Hub motor cooling:** Each hub motor generates ~480 W heat at rated continuous load.
Motors are air-cooled (external fins on motor housing) — no coolant loop required for motors.
The ceramic housing (PEEK CF40) conducts heat to fin array; radiation from YInMn Blue
coated external fin surface provides additional cooling.


---
*End F2-026 | CSMVessel-Charlemagne-FleetV2 | June 2026*
