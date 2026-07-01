# F2-006 — Common Parts Master Registry and Interchangeability Rules
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Registry Purpose

This document is the **single source of truth** for all part numbers used across
the CSMVessel Charlemagne Fleet Series. Every fabrication, procurement, and QA
activity shall cross-reference this registry before sourcing any component.

## 2. Fixed Common Parts (All 5 Vessels — Identical)

### PN-CC-001: LoRa Radio Module
- Part: RAKwireless RAK3172 LPWAN Transceiver
- Frequency: 915 MHz (North America); 868 MHz (EU variant: PN-CC-001-EU)
- Package: Ceramic substrate, PEEK CF40 housing, no metallic radiator substrate
- Range: 2–15 km (terrain dependent), 5 km open water
- Certification: FCC Part 15, CE RED, IC RSS-247
- Supply: RAKwireless, MOQ 10, $6.50 each at 50+
- Dimensions: 15 mm × 15 mm × 2.5 mm (chip, not including PEEK housing)
- Data rate: 250 bps–5.4 kbps (LoRa SF7–SF12)
- Power consumption TX: 125 mW; RX: 15 mW; sleep: 1.6 µW
- GIC note: Ceramic substrate, no metallic antenna element — GIC-immune ✓

### PN-CC-002: PMMA Optical Fiber Connector (ZrO₂ Ferrule, IP68)
- Part: ZrO₂ ceramic ferrule, PMMA POF, FC/PC connector type
- Fiber OD: 2.2 mm (standard POF)
- Ferrule OD: 2.499 mm ±0.001 mm (precision zirconia ceramic)
- Insertion loss: < 0.8 dB
- Return loss: > 26 dB
- IP rating: IP68 (1 m/30 min per IEC 60529)
- Temperature: −40°C to +125°C
- Mating cycles: >1,000
- Supply: Huber+Suhner or AMP Netconnect, $4.20 each at 100+
- GIC note: Photonic transmission — zero electromagnetic susceptibility ✓

### PN-CC-003: Viton Quad-Ring CMBC Vault Seal Set
- Part: 4× Viton (FKM) quad-ring + ZrO₂ bayonet ring groove
- Ring cross-section: 3.53 mm (AS-568 standard)
- Ring inner diameter (BERYL ref): 890 mm (sf-specific groove, but ring compound identical)
- Durometer: 70 Shore A
- Temperature: −20°C to +200°C
- Chemical resistance: seawater, PAG coolant, LiFePO₄ electrolyte vapor
- Pressure rating: 20 bar static, 10 bar dynamic
- Supply: Parker Hannifin, Supelco, MOQ 1
- NOTE: Ring ID is sf-specific. Compound and cross-section are common.

### PN-CC-004: YInMn Blue + CsPbBr₃ QD Coating Compound (1-L can)
- Formulation: YIn₀.₇Mn₀.₃O₃ + CsPbBr₃ quantum dots in UV-stable polyurethane binder
- NIR reflectance (700–2500 nm): 85–92%
- Solar Reflectance Index (ASTM E1980): 130
- UV protection (QD enhancement vs plain YInMn): +31%
- Application: HVLP spray, DFT target 50 µm
- Cure: 80°C/45 min or 23°C/72 h
- Recoat interval: 8–10 years (vs 18–24 months conventional paint)
- Supplier: Shepherd Color Company (Cincinnati OH), $75–100/kg pigment content
- GIC note: Ceramic inorganic pigment, ρ > 10¹² Ω·m — does not affect dielectric integrity ✓

## 3. Scaled-Family Parts Reference

Scaled-family parts use the same design drawings but are manufactured at different
dimensional scales (sf). All are ordered by vessel code suffix:

| Family | TOURMALINE (T) | OBSIDIAN (O) | BERYL (B) | AMETHYST (A) | RHODONITE (R) |
|---|---|---|---|---|---|
| PN-AAJ-SF-x | PN-AAJ-SF-T | PN-AAJ-SF-O | PN-AAJ-SF-B | PN-AAJ-SF-A | PN-AAJ-SF-R |
| PN-HUB-SF-x | 150W 180mm wheel | 650W 330mm | 12kW 620mm | 22kW 930mm | 95kW 1984mm |
| PN-CMBC-SF-x | 280mm OD vault | 485mm OD | 900mm OD | 1180mm OD | 2100mm OD |
| PN-ALON-SF-x | 350mm radius dome | 550mm | 1000mm | 1500mm | 3200mm |

## 4. Interchangeability Rules

**RULE 1:** Fixed PN-CC-001 to PN-CC-020 parts are 100% interchangeable across all
five vessels. A PN-CC-001 from a TOURMALINE production run is identical to one from
a RHODONITE run. Order from the same lot where possible for consistency.

**RULE 2:** Scaled-family parts are NEVER interchangeable across vessels.
A PN-HUB-SF-T (TOURMALINE hub motor) cannot be substituted into a BERYL.
Vessel code (T/O/B/A/R) must be specified in every purchase order for SF parts.

**RULE 3:** Any engineering change that modifies a PN-CC-XXX common part requires
simultaneous ECO documentation for ALL FIVE vessels. The change cannot be applied
to one vessel without being evaluated for compatibility across the fleet.

Cross-reference: F2-005 (scaling), F2-004 (fleet architecture), F2-034 (QA master plan).


---
*End F2-006 | CSMVessel-Charlemagne-FleetV2 | June 2026*
