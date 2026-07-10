# CSMFAB0116-22 — POCKET WATCH X: LCD/OLED PANEL SOURCING
## 1. PANEL VENDOR QUALIFICATION
| Vendor | Panel | Status | Notes |
|--------|-------|--------|-------|
| Samsung Display | E6 AMOLED circular | Primary | Proven quality, MOQ 100K |
| BOE | Custom circular OLED | Secondary | Lower cost, MOQ 50K |
| Tianma | Circular LCD (MIPI) | Alternative | LCD fallback option |
| AUO | 1.39" AMOLED | Evaluation | Current smartwatch panel |

## 2. SELECTION CRITERIA
| Criterion | Weight | Samsung | BOE | Tianma |
|-----------|--------|---------|-----|--------|
| Resolution | 20% | 1440×1440 | 1080×1080 | 800×800 |
| Brightness | 15% | 2000 nit | 1500 nit | 1000 nit |
| Color gamut | 10% | 100% DCI-P3 | 95% DCI-P3 | 85% NTSC |
| Cost (1M) | 25% | $48 | $35 | $18 |
| Yield | 15% | 92% | 88% | 95% |
| Lead time | 10% | 14 wks | 10 wks | 8 wks |
| Support | 5% | Excellent | Good | Fair |

## 3. QUALITY ACCEPTANCE CRITERIA
| Defect | Class A | Class B | Reject |
|--------|---------|---------|--------|
| Bright pixel | 0 | ≤ 2 | > 2 |
| Dark pixel | ≤ 3 | ≤ 5 | > 5 |
| Adjacent defects | 0 | 0 | Any |
| Mura | None | Minor edge | Any center |
| Color uniformity | Δu'v' < 0.005 | Δu'v' < 0.01 | > 0.01 |
| Luminance uniformity | > 90% | > 85% | < 85% |

## 4. SUPPLY CHAIN RESILIENCE
- Minimum 2 qualified vendors for each component.
- Safety stock: 4 weeks demand at 1M annual rate (~77K units).
- Second-source qualification required before production ramp.
- Panel redesign path if circular AMOLED supply constrained.
