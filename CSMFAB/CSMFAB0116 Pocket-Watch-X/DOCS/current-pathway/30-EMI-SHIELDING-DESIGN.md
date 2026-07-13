# CSMFAB0116-30 — POCKET WATCH X: EMI SHIELDING DESIGN
## 1. SHIELDING REQUIREMENTS
| Standard | Limit | Frequency Range |
|----------|-------|-----------------|
| FCC Part 15B | Class B radiated | 30 MHz — 40 GHz |
| CISPR 32 | Class B | 30 MHz — 6 GHz |
| EN 55032 | Class B | 30 MHz — 6 GHz |
| Internal self-compatibility | — | 1 kHz — 10 GHz |

## 2. SHIELDING STRATEGY
| Component | Shield Type | Material |
|-----------|-------------|----------|
| Main PCB | Board-level shield can | Cupronickel (C7521), 0.15 mm |
| SoC Package | On-package shield | Conformal Cu coating |
| Fin bus | Differential signaling | PCIe Gen4 spec |
| WiFi/BT | Partitioned shield can | Separate compartment |
| Battery | No shield required | Non-emitting |
| Display FPC | Grounded copper tape | 3M 1181 |
| External divots | TVS diodes per pin | — |

## 3. AEGIS-C INTEGRATION (OPTIONAL)
For Carrington-event resilience, the Aegis-C composite shield (ZrB₂-SiC with MXene EMI layer) may be integrated as a case back liner:
| Parameter | Aegis-C Value |
|-----------|---------------|
| Shielding effectiveness | 148-165 dB (1 kHz — 10 GHz) |
| MXene layer thickness | 45 µm |
| Weight addition | 1.2 g |
| Cost addition | /unit |
