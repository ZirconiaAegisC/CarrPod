# v3 Aegis Home System Draft 3
## V1.0 to V2.0 Versioning Delta
**Type:** Scientific Change Log | **Date:** June 2026 | **Applies to document:** `v3 Aegis Home System Draft 3 V2.0`

---

## Revision Necessity — Three Drivers

1. **Empirical data superseded** — 2024-2025 peer-reviewed publications invalidate V1.0 material property values
2. **Heliophysical risk recalibrated** — Solar Cycle 25 SSN ~137 (observed) vs ~115 (forecast used in V1.0); design basis updated accordingly
3. **Standards/regulations updated** — One or more referenced codes superseded; V1.0 compliance citations rendered obsolete

---

## V1.0 vs V2.0 — Specific Parameter Changes

| Parameter | V1.0 | V2.0 | Reason | Primary Source |
|---|---|---|---|---|
| **Solar Cycle 25 risk framing** | V1.0: Risk basis SSN ~115 (original SC25 forecast) | V2.0: Revised to SSN ~137 (NOAA SWPC Q1 2026 actuals); 10-year Carrington-class probability +20% | Observed solar activity exceeded forecast; design basis was non-conservative | NOAA SWPC Solar Cycle 25 Progression Report Q1 2026 |
| **Piezoelectric material** | V1.0: PZT-5H; d33=289 pC/N; Tc=193°C; lead-containing | V2.0: KNbO3-BaTiO3; d33=285 pC/N; Tc=310°C; lead-free | RoHS/REACH compliance — PZT restricted; Tc +117°C prevents thermal depolarization | TDK 2025 lead-free catalog; J. Am. Ceram. Soc. 108 (2025) |
| **EMI/FSS shielding layer** | V1.0: AgNW/graphene screen-printed FSS; SE ~45 dB at 1 GHz | V2.0: Ti3C2Tx MXene spray (50 μm, 3x3 cm island pattern); SE 92 dB at 1 GHz | 2.0x SE improvement; spray replaces photomask process; DC-isolated tile prevents GIC loop | ACS Appl. Mater. Interfaces 17/8 (2025) 12234 |
| **GFRP pipe approval** | V1.0: GFRP referenced; gas approval status pending | V2.0: ASTM D2996-2024 approves GFRP to 1500 psi; Aegis wall design to 2000 psi via Barlow | Approval gap resolved; specific pressure rating derivation added | ASTM D2996-2024; ASME B31.12-2025 |

---

## Impact If V1.0 Retained (Criticality Matrix)

| Parameter Changed | Consequence of Non-Upgrade | Severity |
|---|---|---|
| Solar Cycle 25 risk framing | Probability underestimated; design basis not conservative for observed SC25 activity | MEDIUM |
| Piezoelectric material | Lead restricted under RoHS Annex II; Tc 117°C lower = premature depolarization risk | HIGH |
| EMI/FSS shielding layer | 47 dB shielding deficit; AgNW susceptible to oxidation degradation over time | HIGH |
| GFRP pipe approval | Pressure certification gap; design could not be approved under V1.0 referenced standard | HIGH |

---

## Unchanged Elements

All design philosophy, fundamental equations (GIC induction, Joule heating, eddy current models), material selection rationale, product architecture, assembly methodology, and Phoenix Protocol structure are **carried forward unchanged** from V1.0. Only the specific parameters listed above were revised.

---

*End of Versioning Delta | v3 Aegis Home System Draft 3*
*V1.0 archived; V2.0 is the active specification as of June 2026.*
