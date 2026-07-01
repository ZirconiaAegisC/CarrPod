# F2-012 — LiFePO4 Battery Module Platform Standard
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Chemistry Selection Rationale

LiFePO₄ (olivine crystal structure cathode) was selected over NMC, NCA, and LFP alternatives:

| Property | LiFePO₄ | NMC 811 | NCA | Advantage |
|---|---|---|---|---|
| Thermal runaway onset | 270°C | 145°C | 150°C | +125°C safety margin |
| Cycle life (to 80%) | 3,000–6,000 | 1,000–2,000 | 800–1,500 | 3× longer life |
| Cobalt content | Zero | ~12 wt% | ~15 wt% | No DRC supply risk |
| Energy density | 125–160 Wh/kg | 250–300 Wh/kg | 270–290 Wh/kg | Accepted trade-off |
| Specific power | 1,500–3,000 W/kg | 2,000–4,000 W/kg | 2,500–5,000 W/kg | Adequate for fleet |
| Cost (2026) | $0.85–1.20/Wh | $1.10–1.40/Wh | $1.20–1.50/Wh | Lowest cost |

## 2. Cell Specification (BERYL Reference, 105 Ah Prismatic)

| Parameter | Value |
|---|---|
| Cell format | Prismatic, pouch-free aluminum case (note: case is external to CMBC) |
| Nominal capacity | 105 Ah |
| Nominal voltage | 3.2 V |
| Max charge voltage | 3.65 V |
| Minimum discharge voltage | 2.5 V |
| Dimensions (L×W×H) | 73.5 × 27.5 × 200 mm |
| Mass | 1.73 kg |
| Discharge rate (continuous) | 2C = 210 A |
| Discharge rate (peak, 30 s) | 5C = 525 A |
| Charge rate (standard) | 1C = 105 A (1-hour charge) |
| Module operating temperature | −20°C to +55°C |

## 3. Module Assembly Protocol

All cell modules inside the CMBC are assembled WITHOUT metal structural frames:
- Cell-to-cell: polyimide-silica aerogel spacers (5 mm) — thermal barrier
- Module frame: BFRP/Elium® composite rail (no metal)
- UHMWPE flexible busbar: aluminum conductor enclosed in PEEK isolation sleeve
  (conductive inside, completely non-conductive outside surface)
- Cell monitoring wires: Route ONLY via PMMA POF after optical coupler — zero metallic
  conductor in the monitoring circuit contacts cell terminals

## 4. State of Health Indicators

BMS monitors via FBG optical sensors (no metallic K-type thermocouples):
- Temperature: FBG optical fiber woven between cell rows
- Voltage: Ceramic hybrid IC via optical coupler to POF bus
- Capacity fade: Coulomb counting + voltage curve analysis
- Alarm: ≥55°C → throttle back; ≥65°C → emergency disconnect


---
*End F2-012 | CSMVessel-Charlemagne-FleetV2 | June 2026*
