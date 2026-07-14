# CSMFAB0116-35 — QUALITY ASSURANCE PLAN
## 1. INCOMING INSPECTION
| Component | Sampling | Tests |
|-----------|----------|-------|
| SoC | AQL 0.065 | Visual, X-ray |
| Display | AQL 0.065 | Visual, luminance, pixel defect |
| PCB | AQL 0.10 | Visual, electrical test coupon |
| Battery | AQL 0.065 | Visual, capacity, IR, X-ray |
| Housing | AQL 0.10 | CMM, visual, thread gauge |
| Connectors | AQL 0.065 | Visual, pin straightness |
| Passive components | AQL 0.25 | Sample LCR check |

## 2. IN-PROCESS CHECKS
| Stage | Check | Frequency |
|-------|-------|-----------|
| Post-SMT | AOI | 100% |
| Post-SMT | X-ray (BGA/CSP) | 100% |
| Post-display bond | Visual | 100% |
| Post-integration | Power-on | 100% |
| Functional test | Automated test suite | 100% |

## 3. FINAL QC
| Test | Coverage |
|------|----------|
| Visual (cosmetic) | 100% |
| Display (pixel, uniformity) | 100% |
| Touch (grid test) | 100% |
| Audio (sweep test) | 100% |
| Wireless (RX sensitivity) | 10% sample |
| Battery (charge/discharge) | 10% sample |
| IP68 | 5% sample |
| Drop test | 0.1% sample (destructive) |

## 4. BURN-IN
Every unit undergoes 4-hour burn-in:
- Cyclic thermal (25-55°C)
- Display at 50% brightness cycling white/black/red/green/blue
- WiFi continuous ping test
- Battery discharge to 50%, recharge to 100%

