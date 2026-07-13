# CSMFAB0116-33 — DISPLAY CALIBRATION
## 1. FACTORY CALIBRATION FLOW
1. Panel aging: 4 hours at 80°C, 100% white (stabilizes OLED).
2. Flat-field measurement: 16 gray levels (0-255, step 17).
3. White point: Adjust RGB gains for D65 (x=0.3127, y=0.3290).
4. Gamma: Fit power-law curve (γ=2.2) using 17-point LUT.
5. Color gamut: Measure DCI-P3 primaries and secondaries.
6. Uniformity: 13-zone grid across circular display.
7. Store calibration data in DDIC NVM (3D-LUT, 17³ entries).

## 2. INSTRUMENTS
| Instrument | Purpose | Accuracy |
|------------|---------|----------|
| Konica Minolta CA-410 | Colorimeter | ±0.002 Δxy |
| Konica Minolta CS-2000 | Spectroradiometer | ±2% luminance |
| Imaging colorimeter | Uniformity map | ±3% per pixel |

## 3. CALIBRATION TARGETS
| Parameter | Target | Tolerance |
|-----------|--------|-----------|
| White point | D65 (6504K) | ±200K |
| Gamma | 2.2 | ±0.05 |
| Luminance (center) | 200 nit (SDR cal level) | ±2% |
| ΔE average (24-patch) | — | < 2.0 |
| ΔE max | — | < 4.0 |

