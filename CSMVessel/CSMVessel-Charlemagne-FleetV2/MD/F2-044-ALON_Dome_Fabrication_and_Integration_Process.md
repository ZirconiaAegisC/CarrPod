# F2-044 — ALON Dome Fabrication and Integration Process
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. ALON Panel Sourcing

Send drawing package to Surmet Corporation (Burlington MA):
- Document: geodesic dome geometry for target vessel (sf-specific)
- Panel types: 3 (A: 5 panels; B: 10 panels; C: 5 panels per Class II 3v for sf≤1.0)
- Thickness: 8 mm minimum per F2-009 specification
- Surface finish: polished both faces, T >80% at 550 nm
- Request: with silane coupling agent pre-treatment for adhesive compatibility
- Lead time: 14–20 weeks from confirmed drawing

**Surmet order package must include:**
- Complete geodesic panel geometry DXF/STP files
- Surface finish specification (optical transmission, roughness)
- Chemical compatibility note (acid-etched, silane-treated surface for Aerosil silicone bond)

## 2. In-House Polishing (If Required)

If panels arrive with T<80%:
1. Mount on vacuum chuck, CNC 5-axis grinder
2. Grade progression: 120→400→1,000→2,000 grit diamond suspension
3. Final: colloidal silica 0.02 µm in water slurry, polishing pad
4. Target: T>82% at 550 nm (allow 2% margin above spec for coating losses)
5. Measure: spectrophotometer (Hach DR2800 or equivalent) per 5-panel sample

## 3. PEDOT:PSS + AgNW Transparent EMI Coating

Apply to interior face of all ALON panels before dome assembly:
1. Clean: DI water rinse, nitrogen blow-dry
2. PEDOT:PSS colloidal (Clevios PH1000, 1% solid): spray at 0.15 mL/cm²
3. Add AgNW (50 nm diameter, 10 µm length): mix 5:1 PEDOT:PSS:AgNW by volume
4. Spray 3 passes, anneal at 150°C / 15 min between each pass
5. Final dry film: 2 µm PEDOT:PSS + AgNW
6. Measure SE: >35 dB at 1 GHz (vector network analyzer)

## 4. Dome Assembly (BERYL Reference)

**Assembly fixture:** BFRP half-sphere mold, 1,000 mm ID, accuracy ±0.3 mm

1. Install 5 base row panels (CoAl₂O₄ coating on first ring) into fixture
2. Apply Aerosil-silicone sealant (PN-CC-017) to all joint interfaces (3 mm bond gap)
3. Install PEEK CF40 nodes (ZrO₂ M6 × 4 fasteners per node)
4. Torque ZrO₂ M6 to 5 N·m (low — isolators must remain in compliant zone)
5. Cure first ring: 24 h at ambient, then proceed
6. Install subsequent rows, rows 2–6 (for 3v Class II)
7. Install dome ring (PEEK CF40) — interface to hull viscoelastic mounts
8. Pressure test: inflate to 2 bar, hold 60 min (no leaks at any joint)
9. Optical final: measure T on 3 arbitrary panels. All >78%.
10. Install hatch assembly (rear-facing panel replaced with ALON hatch frame)


---
*End F2-044 | CSMVessel-Charlemagne-FleetV2 | June 2026*
