# F2-045 — Hub Motor Assembly with Ceramic Bearing Protocol
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Pre-Assembly Inspection

### Motor Incoming Inspection
Receive hub motor kit from supplier (BLDC, wound with alumina-ceramic coated wire):
1. Phase resistance balance (3-phase): measure all three; must be within ±2%
   If out of balance: return to supplier — winding defect
2. Winding insulation: 1,000 V Megger / 60 s; >500 MΩ winding-to-shell (bare motor, no bearing)
3. Back-EMF test: rotate at exactly 100 RPM by external motor; measure line-to-line voltage
   Target: K_v × 100 RPM ± 5% per specification
4. Dimensional: shaft OD, housing bore, bearing shelf depth to drawing ± 0.02 mm

### Si₃N₄ Bearing Incoming Check
5. Megger (rolling element batch, 1,000 V, 60 s): R_insulation >10¹² Ω race-to-race
6. Dimensional: bore ID, OD, width to ABEC-7 tolerance per drawing
7. Surface: inspect for chips, cracks, surface defects under 5× magnification

## 2. Bearing Installation

**CRITICAL: All steps must be performed on an ESD-safe workstation.**
**CRITICAL: No steel tools or metal fixtures may contact the Si₃N₄ bearing races.**

1. Clean housing bore with IPA + lint-free wipe (remove all machining coolant residue)
2. Heat motor housing to 80°C (thermal oven, uniform soak 15 min): housing bore expands +0.003 mm
3. Cool bearing to −40°C (dry ice bath or cryogenic chamber, 20 min): bearing OD contracts −0.005 mm
4. Net fit: 0.015 mm interference (adequate for bearing retention)
5. Remove motor from oven; remove bearing from cold storage simultaneously
6. Press bearing into bore immediately using PEEK mandrel only (no steel punches, no impact)
7. Bearing must seat fully without resistance — if resistance felt, STOP and investigate
   (means bore temperature dropped or bearing warmed before seating)
8. Allow to return to room temperature (15 min minimum)
9. Verify bearing free rotation: no roughness, approximately 0.2 N·m pre-load drag

## 3. Post-Install Megger Test (MANDATORY)

10. Megger between shaft and motor housing bus: 1,000 V / 60 s
11. **PASS: ≥10¹² Ω** (log date, value, bearing lot number, technician ID)
12. **FAIL: <10¹⁰ Ω** → STOP. Disassemble. Inspect bearing for contamination.
    Likely cause: residual metallic contamination from housing bore machining
    Remediation: Clean bore with diamond lap, re-inspect, install new bearing

## 4. IP68 Sealing Sequence

13. Install ZrO₂ ceramic face seal into PEEK housing (precision-lapped, 0.5 µm flatness)
14. Install Viton V-ring backup seal (PN-CC-013) over shaft
15. Connect UHMWPE power cable to PEEK compression gland; torque to seal manufacturer spec
16. Connect PMMA POF data cable to ZrO₂ ferrule connector (PN-CC-002)
17. Assemble motor housing halves; install ZrO₂ M6 fasteners (PN-CC-011) in star pattern
18. IP68 hydrostatic test: submerge in 3.5% NaCl at 3 bar / 5 min
    Observe for air bubbles: any bubble = fail, disassemble and inspect
19. Post-immersion Megger: >10¹⁰ Ω shaft-to-housing maintained after immersion

## 5. Final Functional Test

20. Connect to test stand; drive at 100 RPM under no load
21. Back-EMF re-check: must match pre-assembly value ±3%
22. Temperature rise at 50% rated load for 10 min: <15°C rise above ambient
23. Log complete assembly data package: bearing lot, Megger values, IP68 date, functional test

**Reject criteria:** Any Megger <10¹⁰ Ω at any point. Any IP68 leak. Back-EMF deviation >5%.


---
*End F2-045 | CSMVessel-Charlemagne-FleetV2 | June 2026*
