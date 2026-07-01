# CSMProFuelTransport — Aegis Fuel Infrastructure Carrington Event
## V1.0 to V2.0 Versioning Delta
**Type:** Scientific Change Log | **Date:** June 2026 | **Applies to:** `CSMProFuelTransport — Aegis Fuel Infrastructure Carrington Event V2.0`

---

## Revision Necessity — Three Drivers

1. **Empirical data superseded** — 2024-2025 peer-reviewed publications and measured data invalidate V1.0 specifications
2. **Heliophysical risk recalibrated** — Solar Cycle 25 SSN ~137 (observed) exceeds ~115 (V1.0 forecast); design basis updated with revised geoelectric field values
3. **Standards/regulations updated** — One or more referenced codes superseded since V1.0

---

## V1.0 vs V2.0 — Specific Parameter Changes

| Parameter | V1.0 | V2.0 | Reason | Primary Source |
|---|---|---|---|---|
| **GFRP pipe code approval** | Approval status 'pending' for hydrocarbon gas service | ASTM D2996-2024 formally approves GFRP to 1,500 psi for hydrocarbon liquid | Critical code gap resolved; 2000 psi wall design derivation via Barlow now documented | ASTM D2996-2024 |
| **Hydrogen fuel transport** | Not addressed | ASME B31.12-2025 H₂ service GFRP provisions: up to 3,000 psi demonstrated | Post-Carrington fuel flexibility requires H₂ as emergency fuel source; code now available | ASME B31.12-2025; DOE NREL 2025 |
| **CALNEV GIC quantification** | General GIC threat described | 20,244 A quantified at G5 conditions; 138 kg steel dissolved in 6 hours | Specific quantification enables design of DC blocking capacitor sizing | Faraday corrosion law; USGS geoelectric data |
| **Aerogel pipe insulation** | Silica aerogel λ=0.015 W/m·K, 600°C ceiling | Polyimide-silica hybrid λ=0.010 W/m·K, 650°C ceiling | For H₂ pipeline cryogenic joints, 50°C additional margin prevents condensation cracking | Aspen Aerogels Pyrogel XT-E 2025 |
| **Pipeline monitoring** | SCADA over copper wire | LoRa 50-node mesh + FBG optical sensors: GPS-free, no metallic sensing elements | SCADA copper wire destroyed in GIC event — monitoring system must be GIC-immune | LoRa Alliance v1.1; AFF FBG sensor data |
| **Solar Cycle 25** | SSN ~115 basis | SSN ~137; CALNEV GIC +20% (20,244 A vs 16,900 A V1.0) | Updated field strength changes capacitor and isolation specifications | NOAA SWPC Q1 2026 |

---

## Impact If V1.0 Retained

| Parameter | Consequence of Non-Upgrade |
|---|---|
| GFRP pipe code approval | Critical code gap resolved; 2000 psi wall design derivation via Barlow now documented |
| Hydrogen fuel transport | Post-Carrington fuel flexibility requires H₂ as emergency fuel source; code now available |
| CALNEV GIC quantification | Specific quantification enables design of DC blocking capacitor sizing |
| Aerogel pipe insulation | For H₂ pipeline cryogenic joints, 50°C additional margin prevents condensation cracking |
| Pipeline monitoring | SCADA copper wire destroyed in GIC event — monitoring system must be GIC-immune |
| Solar Cycle 25 | Updated field strength changes capacitor and isolation specifications |

---

## Unchanged Elements

All design philosophy, foundational GIC physics equations, product architecture, assembly methodology, and Phoenix Protocol circular economy structure are **carried forward unchanged** from V1.0. Only the specific parameters listed above were revised.

---

*End of Versioning Delta | CSMProFuelTransport — Aegis Fuel Infrastructure Carrington Event*
*V1.0 archived; V2.0 is the active specification as of June 2026.*
