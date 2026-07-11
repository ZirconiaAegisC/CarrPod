# CSMFAB000000000214 — DRONE-X MXene EMI Shielding for Avionics Bay
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Materials & EMC Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — Ti₃C₂Tₓ 45 µm spray coating, 92 dB SE, synthesis protocol, QC specification |

---

## 1. MXene Material Specification

The avionics bay EMI shield employs a Ti₃C₂Tₓ (titanium carbide) MXene thin-film coating applied via airbrush spray deposition onto the interior surface of the BFRP center hub plates. This 2D transition metal carbide provides exceptional EMI shielding effectiveness at minimal weight penalty.

| Property | Value |
|----------|-------|
| Material | Ti₃C₂Tₓ MXene (Tₓ = -O, -OH, -F surface terminations) |
| Synthesis method | MILD etching (LiF/HCl, 24h at 35°C) |
| Flake size (d₅₀) | 2–5 µm lateral, 1–2 nm thickness |
| Coating thickness | 45 µm (±5 µm) |
| Coating density | 2.31 g/cm³ |
| Coating areal density | 10.4 mg/cm² |
| Total coating weight | 3.8 g (both hub plates) |
| Electrical conductivity | 8,000 S/cm (in-plane) |
| EMI SE (at 45 µm) | 92 dB (X-band, 8–12 GHz) |
| EMI SE (1 kHz–10 GHz) | 85–95 dB |

## 2. Shielding Effectiveness Breakdown

| Frequency Band | SE Total (dB) | SE Absorption (dB) | SE Reflection (dB) |
|---------------|---------------|-------------------|--------------------|
| 1–30 MHz | 85 dB | 62 dB | 23 dB |
| 30–300 MHz | 88 dB | 58 dB | 30 dB |
| 300 MHz–1 GHz | 91 dB | 55 dB | 36 dB |
| 1–10 GHz | 92 dB | 48 dB | 45 dB |

The absorption-dominant mechanism (vs. reflection-dominant for metals) is a key advantage of MXene — it minimizes secondary EMI reflections within the avionics bay that could couple into the LoRa or GPS antennas.

## 3. Synthesis Protocol (MILD Method)

**Reagents (per 1 g Ti₃AlC₂ MAX phase precursor):**
- Ti₃AlC₂ MAX phase powder: 1.0 g (200 mesh, >98% purity)
- LiF: 1.6 g
- HCl (9M): 20 mL
- Deionized water: 200 mL (for washing)

**Procedure:**
1. Dissolve 1.6 g LiF in 20 mL 9M HCl in a PTFE beaker, stir 10 min
2. Slowly add 1.0 g Ti₃AlC₂ powder over 10 min (exothermic — maintain < 40°C)
3. Stir at 35°C for 24 h (magnetic stirrer, 400 RPM)
4. Centrifuge at 3500 RPM for 5 min, decant supernatant
5. Wash with DI water, repeat centrifugation until pH ≈ 6
6. Collect dark green/black sediment — this is multi-layer Ti₃C₂Tₓ
7. Delaminate: add LiCl (0.5 g per 1 g MXene), hand-shake 15 min
8. Centrifuge at 3500 RPM for 5 min, collect dark supernatant (single/few-layer flakes)
9. Concentrate to 20 mg/mL for spray deposition

## 4. Spray Deposition Protocol

| Parameter | Value |
|-----------|-------|
| Application method | Airbrush, 0.3 mm nozzle |
| MXene concentration | 20 mg/mL in DI water |
| Air pressure | 15–20 PSI |
| Spray distance | 15–20 cm from substrate |
| Substrate temperature | 60°C (heated bed) |
| Layer count | 8–10 passes (builds to 45 µm) |
| Drying time between layers | 2 min (at 60°C) |
| Post-deposition cure | 80°C for 30 min |
| Surface finish | Metallic dark green, matte |

## 5. Quality Control

| Test | Method | Pass Criteria |
|------|--------|---------------|
| Thickness | Micrometer, 5-point average | 45 ± 5 µm |
| Adhesion | Tape test (ASTM D3359, Method B) | ≥ 4B rating |
| Conductivity | 4-point probe | ≥ 5,000 S/cm |
| SE validation | Vector network analyzer (VNA), waveguide method | ≥ 85 dB at 8–12 GHz |
| Visual inspection | 10× magnification | No cracks, no delamination, uniform coverage |

QC frequency: Every batch (every 10 drone sets), 1 sample coupon per batch.

---

*"A shield is a promise: what's inside stays safe, no matter what's outside. Test that promise before you trust it."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Materials Science Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
