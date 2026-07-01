# F2-423 — Wireless Energy Transfer Charging Technology
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## SAE J2954b Technology Overview

Standard: SAE TIR J2954b (Draft, 2025) — Wireless Power Transfer for light-duty + transit

**Key parameters for RHODONITE application:**
- Power transfer: 22 kW (Class WPT3 — transit bus class)
- Efficiency at rated power: 94%
- Air gap tolerance: 100–250 mm (adequate for variable-height bus stops)
- Alignment tolerance: ±75 mm lateral, ±75 mm longitudinal (achievable with GPS-assisted docking)
- Ground pad: embedded in road surface, weatherproof IP67
- Vehicle pad: ZrO₂-ceramic-encased receiving coil (no metallic shell — GIC immune)

**RHODONITE charging pad specification:**
- Coil: Litz wire in ZrO₂ composite housing (not magnetic — achieves coupling via resonance)
- Frequency: 85 kHz (SAE J2954 standard band)
- Receiving coil ID: 600 × 600 mm
- Communication: LoRa (PN-CC-001) between pad controller and RHODONITE BMS
- Safety interlock: Zero power transfer unless vehicle present AND LoRa handshake confirmed

**Pilot program recommendation:**
Install test pad at 3 RHODONITE-designated bus stops in pilot city.
Measure: efficiency, alignment statistics, charging contribution vs. route consumption.
Capital: $45,000 per pad installation.


---
*End F2-423 | CSMVessel-Charlemagne-FleetV2 | June 2026*
