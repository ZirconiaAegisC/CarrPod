# v6 Aegis Home System Draft 6
## V1.0 to V2.0 Versioning Delta
**Type:** Scientific Change Log | **Date:** June 2026 | **Applies to document:** `v6 Aegis Home System Draft 6 V2.0`

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
| **Post-event navigation** | V1.0: GPS assumed operational | V2.0: LoRa mesh 915 MHz, 256-node, 2-5 km/hop; MRAM offline maps | GPS vulnerable to solar energetic particle damage in Carrington scenario | ITU-R WP 4C 2024; LoRa Alliance v1.1 |
| **Composite matrix — recyclability** | V1.0: Thermoset epoxy; irreversible crosslink; landfill end-of-life | V2.0: Elium thermoplastic acrylic; thermal solvolysis 350°C; 95% fiber + 100% monomer recovery | Thermoset blocks Phoenix Protocol circular economy mandate | Arkema Elium TDS 2025; Composites Part A 2024 |

---

## Impact If V1.0 Retained (Criticality Matrix)

| Parameter Changed | Consequence of Non-Upgrade | Severity |
|---|---|---|
| Solar Cycle 25 risk framing | Probability underestimated; design basis not conservative for observed SC25 activity | MEDIUM |
| Piezoelectric material | Lead restricted under RoHS Annex II; Tc 117°C lower = premature depolarization risk | HIGH |
| Post-event navigation | GPS invalid assumption in Carrington scenario; navigation fails in primary use case | HIGH |
| Composite matrix — recyclability | No end-of-life recovery path; contradicts Phoenix Protocol; Phoenix Protocol breach | HIGH |

---

## Unchanged Elements

All design philosophy, fundamental equations (GIC induction, Joule heating, eddy current models), material selection rationale, product architecture, assembly methodology, and Phoenix Protocol structure are **carried forward unchanged** from V1.0. Only the specific parameters listed above were revised.

---

*End of Versioning Delta | v6 Aegis Home System Draft 6*
*V1.0 archived; V2.0 is the active specification as of June 2026.*
