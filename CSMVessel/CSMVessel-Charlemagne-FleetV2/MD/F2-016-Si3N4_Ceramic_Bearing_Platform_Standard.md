# F2-016 — Si3N4 Ceramic Bearing Platform Standard
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Specification

Si₃N₄ rolling element bearings for hub motor use must meet:
- Rolling element material: β-phase Si₃N₄, fracture toughness >5 MPa·m^0.5
- Race material: ZrO₂ 3Y-TZP (Y₂O₃ stabilized, fracture toughness 8–12 MPa·m^0.5)
- Electrical resistivity: >10¹² Ω·m (shaft-to-housing, verified per F2-047)
- Temperature: −40°C to +800°C (adequate for all hub motor applications)

## 2. Bearing Selection by Vessel

| Vessel | Bore ID | OD | Width | Type | Load Rating | Speed |
|---|---|---|---|---|---|---|
| TOURMALINE | 20 mm | 47 mm | 14 mm | 6004 equiv | 7.8 kN static | 12,000 RPM |
| OBSIDIAN | 30 mm | 62 mm | 16 mm | 6006 equiv | 14.3 kN | 9,000 RPM |
| BERYL | 80 mm | 140 mm | 26 mm | 6216 equiv | 80 kN | 4,500 RPM |
| AMETHYST | 100 mm | 180 mm | 34 mm | 6320 equiv | 120 kN | 3,200 RPM |
| RHODONITE | 150 mm | 270 mm | 45 mm | 6230 equiv | 240 kN | 1,500 RPM |

## 3. Mandatory Megger Test After Installation

After each hub motor bearing installation:
- Instrument: Megger MIT1025 or equivalent (1,000 V DC)
- Pass criterion: R_insulation ≥ 10¹⁰ Ω (shaft-to-housing bus)
- Failure action: Disassemble, inspect for contamination, reinstall new bearing
- Record: Serial number, date, measured resistance, technician ID

This test is the single most important QA step in the entire hub motor assembly sequence.
A Si₃N₄ bearing that reads <10¹⁰ Ω has been contaminated during installation and
MUST NOT ship in a Charlemagne fleet vehicle.


---
*End F2-016 | CSMVessel-Charlemagne-FleetV2 | June 2026*
