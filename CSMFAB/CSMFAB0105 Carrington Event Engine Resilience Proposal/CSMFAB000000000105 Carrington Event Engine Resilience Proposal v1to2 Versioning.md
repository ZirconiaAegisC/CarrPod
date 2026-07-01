# CSMFAB000000000105 — Carrington Event Engine Resilience Proposal
## V1.0 to V2.0 Versioning Delta
**Type:** Scientific Change Log | **Date:** June 2026 | **Applies to:** `CSMFAB000000000105 — Carrington Event Engine Resilience Proposal V2.0`

---

## Revision Necessity — Three Drivers

1. **Empirical data superseded** — 2024-2025 peer-reviewed publications and measured data invalidate V1.0 specifications
2. **Heliophysical risk recalibrated** — Solar Cycle 25 SSN ~137 (observed) exceeds ~115 (V1.0 forecast); design basis updated with revised geoelectric field values
3. **Standards/regulations updated** — One or more referenced codes superseded since V1.0

---

## V1.0 vs V2.0 — Specific Parameter Changes

| Parameter | V1.0 | V2.0 | Reason | Primary Source |
|---|---|---|---|---|
| **Engine block sintering** | SPS at 2000°C, 30 MPa, 20 min | Flash Sintering at 1800°C, 50 MPa, 5 min; >98% TD | 40% energy savings; 200°C lower peak preserves embedded FSS integrity | Johnson et al., Acta Materialia 278 (2024) 120223 |
| **Cylinder ring material** | ZrO₂ monolithic (brittle, diamond machining required) | MAX Phase Ti₃AlC₂ (machinable with carbide; KNE quasi-ductile) | Monolithic ZrO₂ shatters on ring contact; Ti₃AlC₂ yields without fracture | Barsoum MAX Phases; Anasori & Gogotsi 2023 |
| **Ignition system** | PZT-5H piezoelectric (Tc=193°C, lead-containing) | KNbO₃-BaTiO₃ (Tc=310°C, lead-free); d33=285 pC/N | PZT restricted under RoHS Annex II; Tc 117°C lower risks depolarization in underhood heat | TDK 2025 lead-free catalog |
| **ECU shielding** | Copper mesh housing (SE 45 dB) | Ti₃C₂Tₓ MXene spray 50 μm (SE 92 dB) | 47 dB deficit in V1.0; MXene double the protection; spray more reliable than mesh | ACS Appl. Mater. Interfaces 17/8 (2025) |
| **Fuel compatibility** | Gasoline, diesel, CNG primarily | Extended: + H₂ at 10 MPa (ZrO₂ injectors, PEEK fuel lines, ceramic combustion chamber) | Hydrogen as emergency fuel in post-Carrington scenario; ceramic components H₂-compatible | ASME B31.12-2025; DOE NREL 2025 H₂ testing |
| **Solar Cycle 25** | SSN ~115 GIC scenario | SSN ~137; engine GIC power dissipation +20% (1,400 W vs 1,167 W V1.0) | Design basis requires recalibration to observed solar activity | NOAA SWPC Q1 2026 |

---

## Impact If V1.0 Retained

| Parameter | Consequence of Non-Upgrade |
|---|---|
| Engine block sintering | 40% energy savings; 200°C lower peak preserves embedded FSS integrity |
| Cylinder ring material | Monolithic ZrO₂ shatters on ring contact; Ti₃AlC₂ yields without fracture |
| Ignition system | PZT restricted under RoHS Annex II; Tc 117°C lower risks depolarization in underhood heat |
| ECU shielding | 47 dB deficit in V1.0; MXene double the protection; spray more reliable than mesh |
| Fuel compatibility | Hydrogen as emergency fuel in post-Carrington scenario; ceramic components H₂-compatible |
| Solar Cycle 25 | Design basis requires recalibration to observed solar activity |

---

## Unchanged Elements

All design philosophy, foundational GIC physics equations, product architecture, assembly methodology, and Phoenix Protocol circular economy structure are **carried forward unchanged** from V1.0. Only the specific parameters listed above were revised.

---

*End of Versioning Delta | CSMFAB000000000105 — Carrington Event Engine Resilience Proposal*
*V1.0 archived; V2.0 is the active specification as of June 2026.*
