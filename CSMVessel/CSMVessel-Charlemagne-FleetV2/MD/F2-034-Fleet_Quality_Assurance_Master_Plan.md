# F2-034 — Fleet Quality Assurance Master Plan
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. QMS Foundation

**Standard:** ISO 9001:2015 with automotive supplement IATF 16949:2016

**Key additional requirements:**
- IEEE P2945 (2025 draft): GIC hardening documentation for every vehicle
- ISO 26262: Functional safety evidence trail for ASIL-B systems
- Lot traceability: Every PN-CC-001 through PN-CC-020 and scaled-family part traceable
  to raw material certificate and final vehicle serial number

## 2. Incoming Inspection Requirements

| Material | Test | Acceptance Criterion | Ref |
|---|---|---|---|
| ZrB₂–SiC sintered vault | XRD phase purity | ZrB₂ + SiC, no ZrO₂ formation | F2-015 |
| ZrB₂–SiC vault | Megger 1,000 V | >10¹⁰ Ω·m bulk | F2-004 |
| ALON panels | Optical transmission | >80% at 550 nm per 10 mm | F2-009 |
| ALON panels | Dimensional check | ±0.3 mm per drawing | F2-009 |
| LiFePO₄ cells | Capacity (0.2C discharge) | >100 Ah (≥95% nominal) | F2-012 |
| LiFePO₄ cells | OCV at 50% SOC | 3.28–3.32 V | F2-012 |
| Si₃N₄ bearings | Megger 1,000 V | >10¹² Ω (race-to-race) | F2-016 |
| KNbO₃–BaTiO₃ discs | d₃₃ meter | 270–300 pC/N | F2-013 |
| Basalt fiber | Tensile coupon | >4,500 MPa (single fiber) | F2-014 |

## 3. Final Vehicle Release Criteria

Every vehicle leaving the facility must pass ALL of the following:

1. **GIC Immunity Scan:** Megger probe at 20 points on hull exterior. All >10¹⁰ Ω.
   (This is the single most important pass/fail criterion for the Charlemagne brand.)
2. **IP68 Immersion:** Full vehicle, 1 m / 30 min in 3.5% NaCl. All sensors pass post-test.
3. **AAJ Vibration:** On shaker table, 4–8 Hz sweep: chair pad transmissibility <−40 dB.
4. **Amphibious Pool:** Vehicle enters pool, AAJ expands, floats 5 min in 80 kg load.
5. **Torque Vector / Zero-Radius Turn:** On dry floor, 360° rotation in <0.3 m diameter.
6. **GAN/BMS Functional:** Full charge-discharge cycle, all cells within ±20 mV.
7. **LoRa Network:** All nodes report, GPS-free TDOA position within ±1 m of landmark.
8. **Spectral Hygiene:** Schumann PEMF active at 7.83 Hz ± 0.1 Hz per FBG HRV response.
9. **ALON Optical:** Transmission check at 3 dome panels >78% at 550 nm.
10. **Biometric Monitoring:** Pulse detected from seat pad within 30 s of occupant sitting.


---
*End F2-034 | CSMVessel-Charlemagne-FleetV2 | June 2026*
