# CSMProWaterTransport — Aegis Water System Carrington Resilience Proposal
## V1.0 to V2.0 Versioning Delta
**Type:** Scientific Change Log | **Date:** June 2026 | **Applies to:** `CSMProWaterTransport — Aegis Water System Carrington Resilience Proposal V2.0`

---

## Revision Necessity — Three Drivers

1. **Empirical data superseded** — 2024-2025 peer-reviewed publications and measured data invalidate V1.0 specifications
2. **Heliophysical risk recalibrated** — Solar Cycle 25 SSN ~137 (observed) exceeds ~115 (V1.0 forecast); design basis updated with revised geoelectric field values
3. **Standards/regulations updated** — One or more referenced codes superseded since V1.0

---

## V1.0 vs V2.0 — Specific Parameter Changes

| Parameter | V1.0 | V2.0 | Reason | Primary Source |
|---|---|---|---|---|
| **GFRP water main approval** | Approval status general | ASTM D2996-2024: 1,500 psi for water service formally approved | Code approval gap resolved; specific pressure rating removes procurement barrier | ASTM D2996-2024 |
| **PEX-a standard** | ASTM F876 (unspecified year) | ASTM F876-25: UV stabilizer requirements and chloramine certification path updated | Active standard requires reference to current edition for regulatory compliance | ASTM F876-25 |
| **Aerogel pipe insulation** | Silica aerogel λ=0.015 W/m·K, 600°C | Polyimide-silica hybrid λ=0.010 W/m·K, 650°C | For GFRP pipe handling hot liquids (up to 200°C process water), additional thermal margin required | Aspen Aerogels Pyrogel XT-E 2025 |
| **Reservoir concrete** | Portland cement OPC: 40 MPa, 505 kg CO₂/m³ | Geopolymer (fly ash + metakaolin + GGBS): 80 MPa, 113 kg CO₂/m³ (RILEM 2025) | 78% CO₂ reduction; 2× strength; ACI 318-25 geopolymer provisions now available | RILEM TC-281 2025; ACI 318-25 |
| **Pump piezoelectric material** | PZT-5H (lead-containing, Tc=193°C) | KNbO₃-BaTiO₃ (lead-free, Tc=310°C, d33=285 pC/N) | RoHS/REACH compliance; 117°C higher Tc prevents depoling in hot pump rooms | TDK 2025 lead-free catalog |
| **Pipeline monitoring** | Metallic SCADA sensing | FBG optical pressure transducers + LoRa 50-node mesh (no metallic sensing elements) | Metallic SCADA sensors couple GIC into monitored circuit — self-defeating design | AFF FBG data 2025; LoRa Alliance v1.1 |
| **LA Aqueduct GIC quantification** | General threat described | 9,363 A at G5 (LA Basin amplified 43 V/km); 64.2 kg steel dissolved in 6 hours | Specific quantification required for MAOP failure probability analysis | USGS 2024; NOAA SWPC Q1 2026 |

---

## Impact If V1.0 Retained

| Parameter | Consequence of Non-Upgrade |
|---|---|
| GFRP water main approval | Code approval gap resolved; specific pressure rating removes procurement barrier |
| PEX-a standard | Active standard requires reference to current edition for regulatory compliance |
| Aerogel pipe insulation | For GFRP pipe handling hot liquids (up to 200°C process water), additional thermal margin required |
| Reservoir concrete | 78% CO₂ reduction; 2× strength; ACI 318-25 geopolymer provisions now available |
| Pump piezoelectric material | RoHS/REACH compliance; 117°C higher Tc prevents depoling in hot pump rooms |
| Pipeline monitoring | Metallic SCADA sensors couple GIC into monitored circuit — self-defeating design |
| LA Aqueduct GIC quantification | Specific quantification required for MAOP failure probability analysis |

---

## Unchanged Elements

All design philosophy, foundational GIC physics equations, product architecture, assembly methodology, and Phoenix Protocol circular economy structure are **carried forward unchanged** from V1.0. Only the specific parameters listed above were revised.

---

*End of Versioning Delta | CSMProWaterTransport — Aegis Water System Carrington Resilience Proposal*
*V1.0 archived; V2.0 is the active specification as of June 2026.*
