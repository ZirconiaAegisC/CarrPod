# v1 Aegis Home System Draft 1
## V1.0 to V2.0 Versioning Delta
**Type:** Scientific Change Log | **Date:** June 2026 | **Applies to document:** `v1 Aegis Home System Draft 1 V2.0`

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
| **ZrB2-SiC sintering temperature** | V1.0: SPS at 1900–2100°C, 30–50 MPa, 20 min | V2.0: Flash Sintering at 1800°C, 50 MPa, 5 min; >98% TD achieved | 40% energy reduction; lower T preserves FSS layer integrity; equivalent density | Johnson et al., Acta Materialia 278 (2024) 120223 |
| **Aerogel thermal break** | V1.0: Silica aerogel; lambda=0.015 W/m·K; max service 600°C | V2.0: Polyimide-silica hybrid; lambda=0.010 W/m·K; max service 650°C | 33% lower conductivity; 50°C higher service ceiling; improved field handleability | Aspen Aerogels Pyrogel XT-E 2025; Oak Ridge TM-2025-0147 |
| **BFRP rebar design standard** | V1.0: ACI 440.1R-15 | V2.0: ACI 440.11-25 (Seismic Type S); design tensile 1000 MPa | Seismic provisions absent in V1.0 — required for CA/PNW deployment; 11-year code update | ACI 440.11-25 January 2025; ACI 318-25 |

---

## Impact If V1.0 Retained (Criticality Matrix)

| Parameter Changed | Consequence of Non-Upgrade | Severity |
|---|---|---|
| Solar Cycle 25 risk framing | Probability underestimated; design basis not conservative for observed SC25 activity | MEDIUM |
| ZrB2-SiC sintering temperature | Excess 400°C degrades embedded FSS; higher energy cost vs V2.0 process | MEDIUM |
| Aerogel thermal break | 33% excess thermal conductivity; 600°C ceiling insufficient for extreme ATE scenarios | MEDIUM |
| BFRP rebar design standard | Non-compliant with SDC D/E/F seismic zones; limits geographic deployment | HIGH |

---

## Unchanged Elements

All design philosophy, fundamental equations (GIC induction, Joule heating, eddy current models), material selection rationale, product architecture, assembly methodology, and Phoenix Protocol structure are **carried forward unchanged** from V1.0. Only the specific parameters listed above were revised.

---

*End of Versioning Delta | v1 Aegis Home System Draft 1*
*V1.0 archived; V2.0 is the active specification as of June 2026.*
