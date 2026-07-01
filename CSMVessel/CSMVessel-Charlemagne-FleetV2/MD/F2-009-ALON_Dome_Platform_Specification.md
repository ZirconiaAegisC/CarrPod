# F2-009 — ALON Dome Platform Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Dome Purpose and Architecture

The ALON dome is not ordinary glazing. It is the structural armor, the optical viewport,
the electromagnetic shield, and the occupant life-safety enclosure simultaneously.
It enables the Charlemagne to be described as "a mechanical womb" — the human occupant
is geometrically and structurally enclosed in a transparent dielectric fortress.

**Properties that make ALON uniquely qualified for this role:**
1. **Hardness** (Knoop 1,800): 4× harder than silica glass, 3× harder than steel
2. **Transparency** (200–5,000 nm): UV through mid-IR visible without optical filters
3. **Dielectric** (ρ > 10¹²): Cannot form GIC eddy currents under any solar storm
4. **Ballistic** (equivalent to Level IIIA at tested thicknesses): child-safe at any projectile
5. **Chemical resistance**: seawater, acid rain, all expected environmental exposures

## 2. Geodesic Dome Design

**Geodesic class:** Class II, frequency-3v (3v) for vessels sf ≤ 1.0
**Geodesic class:** Class II, frequency-6v (6v) for vessels sf > 1.0 (AMETHYST, RHODONITE)

**Class II 3v subdivision (TOURMALINE, OBSIDIAN, BERYL):**
- 80 triangular panels total (20 unique shapes)
- 30 structural nodes (PEEK CF40)
- Strut member types: 3 (A, B, C struts by length)

**BERYL reference dome geometry:**
- Radius: 1,000 mm
- Coverage: 120° arc (hemisphere from equator up)
- Number of ALON panels: 80 triangular panels
- Largest panel dimensions: ~420 mm × 420 mm × 380 mm
- Minimum thickness: 8 mm (see F2-007 scaling exception)

**Dome radius by vessel:**
`r_dome = 1,000 mm × sf` (BERYL reference sf=1.0)

## 3. ALON Node (PEEK CF40 Coupling Hub)

Each geodesic node where 5 or 6 ALON panel edges meet uses a PEEK CF40 coupling hub:
- Material: PEEK CF40 (40% chopped carbon fiber reinforced PEEK)
- Resistivity: >10¹⁰ Ω·m (CF below percolation threshold)
- Tensile strength: 220 MPa
- Temperature limit: 260°C continuous
- Fasteners: ZrO₂ M6 bolts per PN-CC-011
- Sealant: Aerosil-filled silicone (PN-CC-017) in 3 mm joint gap
- Node mass (per BERYL): approx. 180 g each × 30 nodes = 5.4 kg total

## 4. Optical Coatings

**Exterior (visible face):**
- YInMn Blue zone (lower dome ring, 5–7 panels): PN-CC-004
- PEDOT:PSS + AgNW transparent EMI coating (all panels): SE = 35 dB, T_visible > 75%
- Application: spray from colloidal dispersion, DFT 2 µm

**Interior (occupant-facing):**
- ALD AlOₓ anti-reflective coating: 50 nm, reduces glare from 8% to 1.5%
- PVDF-TrFE film adhesive pad on lower dome (head-impact protection): 5 mm EVA foam
  backed by PVDF-TrFE harvest layer (see F2-028)

## 5. Dome Mount System (Viscoelastic Isolation)

The ALON dome must NOT be part of the primary hull load path. It is suspended on
viscoelastic isolators (PN-CC-020, Sorbothane A20 Shore):

**BERYL reference mount system:**
- 8× Sorbothane mounts, Shore 20 durometer
- Mount stiffness per unit: k_mount = 0.9 kN/m × 8 = 7.2 kN/m total
- Dome mass (BERYL): 62 kg
- Dome natural frequency: f_n = (1/2π) × sqrt(7,200/62) = (1/2π) × 10.8 = 1.72 Hz

**Critical:** 1.72 Hz is below the 4–8 Hz danger band ✓

**TOURMALINE dome detuning note:**  
At sf=0.35: standard Sorbothane A20 gives f_n ≈ 6.9 Hz (within danger band!).
TOURMALINE must use softer Sorbothane A10 to achieve f_n < 4 Hz.
This is documented as Engineering Change ECO-TOUR-001 on file in F2-051.

## 6. Entry/Exit Hatch

All vehicles: one rear-facing ALON panel replaced by ALON hatch assembly.

**Hatch specification (BERYL reference):**
- Hatch panel: ALON 8 mm, same material as dome panels
- Frame: PEEK CF40 ring, 10 mm wall
- Seal: Viton dual-rib, 5 bar rated
- Primary actuator: KNbO₃–BaTiO₃ linear actuator (PN-CC-015 variant)
- Manual release: PEEK CF40 internal handle, 15 N force required
- Emergency rescue: External PEEK pull-ring, Iron Carrington Red (#C0392B)
- Time to open from inside: < 3 seconds
- Underwater protocol: pressurize cabin to ambient from O₂ reserve, then open

## 7. ALON Supply Chain

**Current supplier (Year 1–2):** Surmet Corporation, Burlington MA
- Lead time: 14–20 weeks from finalized drawing
- Cost: $800–1,200/kg finished polished plate (2026)
- TOURMALINE full dome: ~$4,200 (4.8 kg × ~$875/kg)
- BERYL full dome: ~$54,600 (62 kg × ~$879/kg)

**Risk:** Surmet is the sole commercial US ALON producer.
**Mitigation:** Investigate MgAl₂O₄ (spinel) as alternative; Kyocera/CeramTec plan
spinel lines for 2027 at ~40% lower cost (see F2-424). Reserve ALON supply 6-month
strategic stock at program start.

Cross-reference: F2-007 (ALON material spec), F2-044 (fabrication), F2-049 (FMEA).


---
*End F2-009 | CSMVessel-Charlemagne-FleetV2 | June 2026*
