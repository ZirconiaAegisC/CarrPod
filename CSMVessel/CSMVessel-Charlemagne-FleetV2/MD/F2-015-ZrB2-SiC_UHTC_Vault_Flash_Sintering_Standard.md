# F2-015 — ZrB2-SiC UHTC Vault Flash Sintering Standard
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Material Composition

**Target composition:** ZrB₂ 12 vol% + SiC 88 vol%

The ZrB₂ loading is deliberately held below the electrical percolation threshold
(~15 vol%), ensuring the composite remains electrically insulating despite containing
a mildly conductive phase. This is the critical design point enabling GIC immunity.

**Percolation physics:**
- Below φ_crit ≈ 15 vol%: ZrB₂ particles are isolated by SiC matrix
- Each ZrB₂ particle: conductive; but no continuous conductive path exists
- Macroscopic DC resistivity: >10¹⁰ Ω·m (verified by 4-probe Megger at 1,000 V)
- At 12 vol% ZrB₂: safely 25% below percolation threshold → robust margin

## 2. Flash Sintering Protocol (F2-043 summary here)

**Step 1 — Powder preparation:**
- ZrB₂ powder: 99.5% purity, D50 < 3 µm (Treibacher Industrie or equivalent)
- SiC powder: 99% purity, α-phase, D50 < 2 µm (Saint-Gobain Hexoloy grade)
- Blend ratio: 12 vol% ZrB₂ + 88 vol% SiC
- Ball-mill blend: 4 h, argon, WC/Co balls, target D90 < 5 µm

**Step 2 — Green body formation:**
- Die press: 50 MPa uniaxial, stainless die (note: stainless contamination negligible
  at <0.01 wt% and does not affect product ρ below QL threshold)
- Green density: 63–67% theoretical

**Step 3 — Flash sintering:**
- Equipment: SPS/Flash press, graphite die and punch set
- Ramp rate: 100°C/min to 1,800°C
- Peak temperature: 1,800°C (reduced from 2,100°C SPS by flash process)
- Soak time: 5 minutes at peak
- Applied pressure: 50 MPa
- Atmosphere: argon (99.999% purity)
- Sintered density: >98% theoretical (target >98.5%)

**Step 4 — Machining:**
- Wire EDM rough cut: ±0.5 mm on all external surfaces
- Diamond surface grind: ±0.1 mm final dimensions
- ID bore for cooling circuit: 8 mm diamond drill

**Energy saving vs. conventional SPS:**
- Conventional SPS: 2,100°C × 20 min = full kiln thermal budget
- Flash sintering: 1,800°C × 5 min = 40% energy reduction
- Source: Johnson et al., Acta Materialia 278 (2024) 120223

## 3. Vault Integration Protocol (see F2-046)

After sintering and machining:
1. Bond polyimide-silica aerogel blanket (25 mm) to vault inner surface using Elium® adhesive
2. Install BFRP/Elium® cell rack modules (4 racks, no metal)
3. Install LiFePO₄ modules per F2-012
4. Install GaN BMS board (BFRP substrate)
5. Route PEX-a/ZrO₂ cooling circuit
6. Install ZrO₂ ceramic pressure relief valve (3 min, 1.5 bar cracking pressure)
7. Close vault with ZrB₂–SiC lid, Viton quad-ring seal PN-CC-003
8. Helium leak test: 10⁻⁷ mbar·L/s pass criterion
9. Electrical isolation test: >10¹⁰ Ω vault-to-ground (Megger 1,000 V, 60 s)


---
*End F2-015 | CSMVessel-Charlemagne-FleetV2 | June 2026*
