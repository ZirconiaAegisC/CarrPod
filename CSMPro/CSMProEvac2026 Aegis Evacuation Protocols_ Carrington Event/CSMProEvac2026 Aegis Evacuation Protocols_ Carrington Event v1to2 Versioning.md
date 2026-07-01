# CSMProEvac2026 — Aegis Evacuation Protocols: Carrington Event
## V1.0 to V2.0 Versioning Delta
**Type:** Scientific Change Log | **Date:** June 2026 | **Applies to:** `CSMProEvac2026 — Aegis Evacuation Protocols: Carrington Event V2.0`

---

## Revision Necessity — Three Drivers

1. **Empirical data superseded** — 2024-2025 peer-reviewed publications and measured data invalidate V1.0 specifications
2. **Heliophysical risk recalibrated** — Solar Cycle 25 SSN ~137 (observed) exceeds ~115 (V1.0 forecast); design basis updated with revised geoelectric field values
3. **Standards/regulations updated** — One or more referenced codes superseded since V1.0

---

## V1.0 vs V2.0 — Specific Parameter Changes

| Parameter | V1.0 | V2.0 | Reason | Primary Source |
|---|---|---|---|---|
| **LA Basin GIC threat model** | National average geoelectric field (10 V/km) used | USGS 2024 revised: LA Basin amplification factor 3.5-5×; effective field 43 V/km | LA sits on high-conductivity Cenozoic sediment — amplification cannot be ignored in design | USGS Open-File Report 2024-1022 |
| **Evacuation lead time** | Standard NOAA alert: 15-45 min warning | SR monitoring network: 4-6 hr advance warning via Schumann frequency shift detection | Critical: evacuation window closes at T+45 min; 4-6 hr SR warning enables orderly evacuation | JGR Space Physics 130/3 (2025) |
| **Emergency communications** | Copper-wired LAFD/LAPD radio (GIC-vulnerable) | LoRa 915 MHz 256-node mesh; GPS-free; solar powered; 30-day autonomous | Copper comms destroyed in GIC scenario — primary channel lost; LoRa immune and decentralized | LoRa Alliance v1.1; ITU-R WP 4C 2024 |
| **Bridge infrastructure** | Steel bridge vulnerability described qualitatively | Caltrans 2025 BFRP deck overlay pilot: 72% GIC reduction per span, quantified | Pilot data validates approach at scale; cost confirmed at $180M for 340 CA bridges | Caltrans 2025 pilot program data |
| **Safe Refuge Center shielding** | General Faraday cage concept | MXene Ti₃C₂Tₓ spray specified (SE 92 dB, $85,000/building) for existing structures | Specific implementation path and cost now available; V1.0 had no implementation specification | ACS Appl. Mater. Interfaces 2025 |
| **Mass casualty extraction** | Generic helicopter protocol | Aegis-Ascension Seraphim drones (CSMFAB000000000050 V2.0) integrated: 250 kg capacity, GIC-immune | Helicopter fleet is aluminum — GIC-vulnerable during extraction; BFRP drones immune | CSMFAB000000000050 V2.0 |
| **Solar Cycle 25** | Generic solar maximum framing | SSN ~137 peak; 20% elevated GIC probability 2025-2027 window specifically | Risk window is NOW — not future — V2.0 reflects current elevated probability | NOAA SWPC Q1 2026 |

---

## Impact If V1.0 Retained

| Parameter | Consequence of Non-Upgrade |
|---|---|
| LA Basin GIC threat model | LA sits on high-conductivity Cenozoic sediment — amplification cannot be ignored in design |
| Evacuation lead time | Critical: evacuation window closes at T+45 min; 4-6 hr SR warning enables orderly evacuation |
| Emergency communications | Copper comms destroyed in GIC scenario — primary channel lost; LoRa immune and decentralized |
| Bridge infrastructure | Pilot data validates approach at scale; cost confirmed at $180M for 340 CA bridges |
| Safe Refuge Center shielding | Specific implementation path and cost now available; V1.0 had no implementation specification |
| Mass casualty extraction | Helicopter fleet is aluminum — GIC-vulnerable during extraction; BFRP drones immune |
| Solar Cycle 25 | Risk window is NOW — not future — V2.0 reflects current elevated probability |

---

## Unchanged Elements

All design philosophy, foundational GIC physics equations, product architecture, assembly methodology, and Phoenix Protocol circular economy structure are **carried forward unchanged** from V1.0. Only the specific parameters listed above were revised.

---

*End of Versioning Delta | CSMProEvac2026 — Aegis Evacuation Protocols: Carrington Event*
*V1.0 archived; V2.0 is the active specification as of June 2026.*
