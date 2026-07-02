# CSMHuman00000000014 Deep Dive Human Frequency Interaction
## V1.0 to V2.0 Versioning Delta
**Type:** Scientific Change Log | **Date:** June 2026 | **Applies to document:** `CSMHuman00000000014 Deep Dive Human Frequency Interaction V2.0`

---

## Revision Necessity — Three Drivers

1. **Molecular impedance analogue identified** — Piezo1/Piezo2 frequency-filtering behavior gives the mechanical-impedance model a cellular-scale counterpart not available at V1.0 drafting.
2. **Applied case study now exists** — the Aegis-C BFRP chassis Helmholtz-tuning data provides a concrete, built example of the theory V1.0 presented abstractly.
3. **Standards expansion** — ISO 5349-3:2025 covers shock/impulse events outside V1.0's continuous-vibration scope.

---

## V1.0 vs V2.0 — Specific Parameter Changes

| Parameter | V1.0 | V2.0 | Reason | Primary Source |
|---|---|---|---|---|
| **Impedance model scope** | Macroscopic mechanical impedance only | Two-tier model: macroscopic + molecular (Piezo1/Piezo2 channel filtering) | New channel-level frequency-filtering data | Duke University Piezo1/Piezo2 heterologous expression studies |
| **Applied case study** | Theoretical only | Aegis-C BFRP panel (178 Hz) and cabin Helmholtz mode (163 Hz) tuning documented | Platform matured since V1.0 drafting | Internal Aegis-C acoustic architecture specification |
| **Shock vibration coverage** | Continuous vibration only (implied ISO 2631/5349-1 basis) | ISO 5349-3:2025 shock/impulse metric (VPM) added | New standard published Dec 2025 | ISO 5349-3:2025 |

---

## Impact If V1.0 Retained (Criticality Matrix)

| Parameter Changed | Consequence of Non-Upgrade | Severity |
|---|---|---|
| Impedance model scope | Cellular-level frequency sensitivity not captured; macroscopic-only model risks mispredicting biological effect at frequencies the body is mechanically insensitive to | MEDIUM |
| Applied case study | Theory remains unvalidated against a real built structure | LOW |
| Shock vibration coverage | Discrete impact/shock exposure unaddressed by the document's measurement framework | MEDIUM |

---

## Unchanged Elements

The NASA Kaplan & Rubinstein (1968) lateral-vibration/vision baseline and the macroscopic mechanical-impedance mass-spring-damper formalism are **carried forward unchanged** from V1.0.

---

*End of Versioning Delta | CSMHuman00000000014 Deep Dive Human Frequency Interaction*
*V1.0 archived; V2.0 is the active specification as of June 2026.*
