# F2-037 — Regenerative Braking and Piezoelectric Energy Harvest
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Two Energy Recovery Mechanisms

The Charlemagne Fleet recovers energy through two simultaneous, complementary pathways:

**Pathway 1 — Regenerative Braking (hub motors as generators):**
During deceleration, the hub motors are commanded to generate torque opposing motion.
This converts kinetic energy to electrical energy, returned to the CMBC.
- Conversion efficiency: 65–72% (kinetic → electrical)
- Recovery scenario: Urban driving (high stop frequency) → +25–35% range extension
- Control: Regenerative torque command from MIMO MPC (F2-023)

**Pathway 2 — AAJ Piezoelectric Harvest:**
The KNbO₃–BaTiO₃ AAJ lattice continuously harvests mechanical energy from:
- 100–300 Hz motor harmonic vibrations (the "vascular poison" band)
- Road irregularity impacts transmitted through the terrain
- Acoustic standing waves inside the vehicle structure
Total harvest: 2 W (TOURMALINE) to ~350 W (RHODONITE)

## 2. Energy Balance at BERYL Scale

| Source | Recovery Rate | Annual Contribution at 15,000 km/year |
|---|---|---|
| Regen braking (urban mix) | 12 kW average | +8,500 kWh/year |
| AAJ piezo harvest | 29 W continuous | +254 kWh/year |
| Optional solar roof (400W peak) | 150 W average | +1,314 kWh/year |
| **Total annual recovery** | | **+10,068 kWh equivalent** |

Annual consumption at 15,000 km (BERYL): ~5,500 kWh
Net: The fleet recovers nearly twice its consumption on solar + regen, making
average net consumption approximately 0 kWh — theoretically net-zero operation.

## 3. Harvest Circuit (AAJ → CMBC)

KNbO₃ piezo elements → Full-bridge rectifier (ZnO varistor ceramic, no metallic diodes)
→ MLCC capacitor buffer (ZrO₂ dielectric, 100 µF 200 V)
→ GaN boost converter (ceramic package, isolated from chassis)
→ CMBC DC bus charge input

Harvest efficiency: 78% (piezo-to-DC, measured at prototype)

The 22% loss is primarily in the full-bridge rectifier and capacitor ESR.
GaN boost converter itself: >97% efficient.


---
*End F2-037 | CSMVessel-Charlemagne-FleetV2 | June 2026*
