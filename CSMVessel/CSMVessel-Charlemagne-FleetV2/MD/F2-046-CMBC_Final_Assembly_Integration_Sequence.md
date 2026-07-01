# F2-046 — CMBC Final Assembly Integration Sequence
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Assembly Workspace Requirements

- ISO Class 7 cleanroom section (≤350,000 particles/m³ >0.5 µm)
- ESD mat and all-ESD-safe tools (no metallic tools that contact active cells)
- Temperature: 20–25°C (CMBC assembly temperature-sensitive for cell matching)
- Humidity: 30–60% RH (cell chemistry requires controlled atmosphere)
- Fire suppression: CO₂ NFPA 75 system (no water sprinklers near LiFePO₄)

## 2. Full Integration Sequence (BERYL CMBC)

**Day 1 (4 hours): Vault pre-work**
1. ZrB₂–SiC vault body inspected (crack test, Megger, dimensional)
2. Aerogel blanket bonded to vault interior (Elium® adhesive, cure 60°C/1h)
3. BFRP cell rack modules (4×) installed; ZrO₂ M10 fasteners to 35 N·m
4. Cell module slot alignment verified: ±1 mm for uniform compression

**Day 2 (6 hours): Cell loading**
5. LiFePO₄ modules sorted by open-circuit voltage (within ±5 mV per rack)
6. Aerogel inter-cell spacers (5 mm) placed between each cell layer
7. UHMWPE flexible busbars installed: verify all connections continuity with PMMA POF-coupled voltage probe
8. Route POF bus cables from BMS board through PEEK-sealed gland in vault wall

**Day 3 (3 hours): BMS and cooling**
9. GaN BMS board (BFRP substrate) installed on PEEK CF40 standoffs
10. FBG temperature sensor array woven between cell rows (FBG fiber PN-CC-007)
11. PEX-a cooling coil installed; ZrO₂ compression fittings torqued
12. Cooling loop pressure test (argon, 8 bar/10 min): confirm no leaks at ZrO₂ fittings
13. ZrO₂ pressure relief valve installed and set-pressure verified (1.5 bar cracking pressure)

**Day 4 (4 hours): Close and test**
14. Vault lid lowered; Viton quad-ring (PN-CC-003) seated in groove
15. ZrO₂ bayonet ring installed: 16 fasteners in star pattern, 45 N·m each
16. Helium leak test: 10⁻⁷ mbar·L/s pass criterion, test all joints simultaneously
17. Megger test: vault body to ground >10¹⁰ Ω (confirms GIC immunity of assembled vault)
18. BMS functional commissioning: charge to 95% SOC via BMS, observe all cell voltages (all within ±30 mV)
19. CMBC thermal test: discharge at 2C for 10 min with cooling active; max cell temperature <40°C
20. Final data package: sign off with technician ID, all Megger values, He-test date, BMS commissioning

## 3. CMBC Integration into Vehicle Chassis

21. Lift CMBC onto vehicle chassis using ZrO₂-padded lifting fixture
22. Seat on 4× Sorbothane A20 isolation mounts (PN-CC-020) directly above AAJ centerline
23. ZrO₂ M16 retaining bolts (×4) through chassis BFRP brackets: 120 N·m each
24. Route UHMWPE power cables to hub motor GaN inverters (star routing pattern, loop areas <0.25 m²)
25. Route POF BMS bus cable to CCU (ZrO₂ ferrule connectors at each end)
26. Route PEX-a cooling circuit from CMBC to belly-pan heat exchanger
27. Final GIC scan: Megger probe at 20 points on CMBC exterior with vault installed: all >10¹⁰ Ω


---
*End F2-046 | CSMVessel-Charlemagne-FleetV2 | June 2026*
