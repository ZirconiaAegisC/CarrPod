# F2-049 — Fleet Safety FMEA Top-Level Analysis
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. FMEA Structure

**FMEA type:** Design FMEA (DFMEA)
**Standard:** AIAG/VDA FMEA Handbook (2019)
**Severity scale:** 1–10 (10 = unsafe/safety-critical)
**Occurrence scale:** 1–10 (10 = very high probability)
**Detection scale:** 1–10 (10 = no detection mechanism)
**RPN = S × O × D** (Risk Priority Number); target <100

## 2. Top-Level Safety Failure Modes

| # | Failure Mode | Effect | S | O | D | RPN | Current Mitigation |
|---|---|---|---|---|---|---|---|
| 1 | CMBC single-cell thermal runaway | Internal fire | 8 | 2 | 1 | 16 | ZrB₂ vault contains fire (S drops to 3 with mitigation) |
| 2 | ALON dome panel fracture | Occupant exposure | 9 | 1 | 2 | 18 | Geodesic redundancy; AE monitoring |
| 3 | Motor Si₃N₄ bearing fracture | Loss of hub motor | 6 | 1 | 3 | 18 | 5/6 motor operation mode |
| 4 | GIC event during operation | Equipment damage | 7 | 4 | 1 | 28 | Dielectric Citadel — designed for this |
| 5 | Battery over-discharge | Loss of propulsion | 5 | 3 | 2 | 30 | BMS undervoltage cutoff; reserve 10% SOC |
| 6 | Water ingress hull | Electrical short | 8 | 2 | 2 | 32 | IP68 sealing; FBG moisture detection |
| 7 | Hub motor IP68 seal fail | Saltwater short | 7 | 2 | 3 | 42 | Triple-seal; pre-delivery IP68 test |
| 8 | Child entrapment TOURMALINE | Asphyxia/injury | 9 | 1 | 5 | 45 | 30-min life support; multi-mode egress |
| 9 | AAJ bellows fatigue failure | Reduced articulation | 4 | 2 | 4 | 32 | FBG lifetime monitoring; 2× design margin |
| 10 | ALON hatch seal failure | Water ingress | 7 | 2 | 3 | 42 | Dual-rib Viton seal; IP68 test per delivery |

## 3. GIC Event Analysis (Failure Mode #4)

**Failure mode:** Carrington-class GIC event during vehicle operation
**Reason this is in FMEA:** Not a failure of the vehicle — a threat from the environment.

**Analysis:**
The Dielectric Citadel architecture means the vehicle IS the mitigation.
With ρ_hull > 10¹⁰ Ω·m at all structural points:
- GIC induced current: I = E_geo × L / R = 20 V/km × 2 m / 10¹⁰ Ω > 10⁻¹² A
- Joule heating: P = I² × R = (10⁻¹²)² × 10¹⁰ = 10⁻¹⁴ W → essentially zero
**Residual RPN = 7 × 4 × 1 = 28** (S=7 because G5 severity to civilization is high;
O=4 because we are now in elevated Solar Cycle 25; D=1 because design prevents any damage)

**This is the lowest possible RPN for severity-7 with current solar cycle probability.**
The Charlemagne fleet has no further mitigation available or needed.

## 4. TOURMALINE Child Entrapment Analysis (Failure Mode #8)

To reduce D from 5 to 2 (improving detection):
- FBG respiration sensor as occupant-presence detector
- LoRa parent alert within 5 s of hatch sealed with occupant detected
- O₂ sensor monitoring CO₂ rise (proxy for time-since-ventilation)
- After implementation: RPN = 9 × 1 × 2 = 18 (acceptable)


---
*End F2-049 | CSMVessel-Charlemagne-FleetV2 | June 2026*
