# F2-043 — ZrB2-SiC Flash Sintering and Vault Assembly Process
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Flash Sintering Process (Full Protocol)

### Pre-Sinter Powder Preparation
1. Receive ZrB₂ powder: certificate of analysis reviewed (purity ≥99.5%, D50 <3 µm)
2. Receive SiC powder: certificate of analysis reviewed (α-phase, purity ≥99%, D50 <2 µm)
3. Calculate blend masses for 12 vol% ZrB₂:
   - ZrB₂ density: 6.09 g/cm³; SiC density: 3.21 g/cm³
   - For 100g total: ZrB₂ = 12 vol% → mass_ZrB₂ = 12×6.09/(12×6.09+88×3.21) × 100 = 20.4g
4. Ball-mill blend: ZrO₂ media (no WC/Co to avoid contamination), argon, 4 h, 150 RPM
5. Dry blend: 80°C oven, 2 h, thin layer spread

### Green Body Formation
6. Load blend into graphite die (BERYL vault OD 900 mm → custom graphite die required)
7. Uniaxial press: 50 MPa for 5 minutes
8. Green body density check: ~63–67% theoretical (measure Archimedes density in ethanol)
9. Reject if <60%: re-press or investigate powder lot

### Flash Sintering Cycle
10. Load green body in graphite tooling, seat upper punch
11. Load into SPS/flash press, connect pyrometer
12. Evacuate to 10⁻³ Torr, then backfill argon to 1 atm
13. Ramp rate: 100°C/min to 1,800°C
14. At 1,800°C: apply 50 MPa; hold 5 min
15. Monitor: should see densification completed in first 2 min of hold
16. Cool: remove pressure at 1,800°C; free-cool under argon to <200°C (2–3 h)
17. Remove from die

### Post-Sinter Processing
18. Measure density: Archimedes method in water. Target: ≥98.0% TD.
    If <98%: reject lot (investigate powder, pressing, or temperature)
19. Wire EDM rough cut: define vault body to ±0.5 mm
20. Diamond surface grind: final dimensions ±0.1 mm per drawing
21. Inner bore diamond drill: cooling circuit inlet/outlet 8 mm each
22. UV fluorescence crack test: 100% surface coverage
    Reject: any crack >0.3 mm visible under 10× UV magnification
23. Megger test 1,000 V/60 s: confirm >10¹⁰ Ω bulk resistivity

## 2. Vault Assembly (BERYL Reference)

1. Bond polyimide-silica aerogel blanket (25 mm) to vault inner surface using Elium® adhesive
2. Pre-cure aerogel bond: 60°C / 1 h
3. Install BFRP/Elium® cell rack modules (4 racks, no metal fasteners — ZrO₂ M10 only)
4. Load LiFePO₄ cell modules; verify all cell group voltage match (±5 mV)
5. Install GaN BMS board (BFRP substrate); route all POF signal connections (PN-CC-002)
6. Install PEX-a/ZrO₂ cooling loop; leak test cooling circuit at 8 bar
7. Install ZrO₂ ceramic pressure relief valve (1.5 bar cracking pressure, 15 bar rated burst)
8. Close vault with ZrB₂–SiC lid; install Viton quad-ring seal (PN-CC-003)
9. Torque ZrO₂ M10 bayonet ring to 45 N·m (all 16 fasteners in star pattern)
10. Helium leak test: 10⁻⁷ mbar·L/s pass criterion (all joints, fittings, relief valve seat)
11. Electrical isolation test: >10¹⁰ Ω vault body to ground (Megger 1,000 V, 60 s)
12. BMS functional test: charge to 90% SOC, monitor all cell voltages (all within ±30 mV)


---
*End F2-043 | CSMVessel-Charlemagne-FleetV2 | June 2026*
