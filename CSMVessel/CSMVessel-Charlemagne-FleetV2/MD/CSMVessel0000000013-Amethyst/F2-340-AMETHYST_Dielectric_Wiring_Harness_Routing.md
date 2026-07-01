# F2-340 — AMETHYST: Dielectric Wiring Harness Routing
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
**Vessel:** AMETHYST
---

## Document Reference

**Vessel:** CSMVessel0000000013 — AMETHYST
**Type:** 8-Seat Passenger SUV
**Occupancy:** 8 adults (2+2+2+2 or 2+3+3 configuration)
**Scale Factor:** sf = 1.5
**Section:** Drivetrain
**Document:** Dielectric Wiring Harness Routing

---

## Vessel Specification Summary

| Parameter | AMETHYST Value | BERYL Reference | Scaling |
|---|---|---|---|
| Length | 4.80 m | 3.20 m | sf × 3.20 m |
| Width | 3.15 m | 2.10 m | sf × 2.10 m |
| Height | 2.70 m | 1.80 m | sf × 1.80 m |
| Mass (unladen) | 1,900 kg | 780 kg | sf³ × 780 kg (approx) |
| Battery capacity | 58 kWh / 400 V | 28 kWh / 400 V | sf^2.8 × 28 kWh |
| Hub motors | 8 × 22 kW | 6 × 12 kW | sf^2.3 × 12 kW per motor |
| Maximum speed | 140 km/h | 160 km/h | Governed (not sf-dependent) |
| Range | 240 km highway / 300 km city | 280 km highway | sf^2.8 derived from battery |
| COGS (10K/yr) | $38,000 @ 10K/yr | $22,500 | Scale + complexity |
| MSRP target | $85,000–$110,000 | $52,000–$72,000 | Market segment |

**Mineral name rationale:** Amethyst (SiO₂ with Fe³⁺ impurity giving purple color) — quartz mineral family, SiO₂ → precursor to SiC in ZrB₂–SiC composite

---

## Vessel Design Context

AMETHYST extends the Charlemagne architecture to 8-passenger capacity
using a dual-AAJ (two accordion joints) elongated spine and extended ALON dome.

8-motor (hexapedal-plus) configuration: 4 lateral pairs, providing:
- Higher peak torque for heavy institutional/fleet use
- Redundancy: vehicle can operate on 6 of 8 motors (25% failure margin)
- Marine propulsion: 8 paddle-wheels generate 5,200 N thrust (vs 3,200 N BERYL)

Extended ALON dome (r=1,500 mm): covers full 8-passenger cabin.
Dual-AAJ spine: provides independent articulation of front and rear cabin sections,
allowing AMETHYST to traverse obstacles that would challenge a single-AAJ vehicle.

Primary market: Emergency management fleets, government institutional vehicles,
luxury group transport for sustainability-forward organizations.
90-minute sealed life support for all 8 occupants in submersion scenarios.

---

## Platform Scaling Applied to Drivetrain: Dielectric Wiring Harness Routing

All dimensions and mechanical properties below are derived from BERYL (sf=1.0) reference
values using the scaling laws in F2-005.

### AAJ Scaled Parameters (sf=1.5)

| AAJ Parameter | AMETHYST Value | Calculation |
|---|---|---|
| Off-state stiffness k_off | 630.0 kN/m | 280 kN/m × 1.5² |
| Maximum stiffness k_max | 6300.0 kN/m | 2,800 kN/m × 1.5² |
| Piezo element count | 176 elements | round(96 × 1.5^1.5) |
| Bellows wall thickness | 12.0 mm | max(3 mm, 8 mm × 1.5) |
| Bellows OD (compressed) | 720 mm | 480 mm × 1.5 |
| Bellows OD (expanded) | 1020 mm | 680 mm × 1.5 |
| Axial travel | ±112 mm | ±75 mm × 1.5 |

### ALON Dome Scaled Parameters

| Dome Parameter | AMETHYST Value | Calculation |
|---|---|---|
| Dome radius | 1500 mm | 1,000 mm × 1.5 |
| Minimum wall thickness | 12 mm | max(8 mm, 8 mm × 1.5) |
| ALON panel mass (total) | 12.2 kg | 4.8 kg × sf^2.3 |

### CMBC Vault Scaled Parameters

Energy at sf=1.5: E = 28 kWh × 1.5^2.8 = **87.1 kWh** (battery system)
Vault OD: reference BERYL OD=900 mm; AMETHYST OD ≈ 1350 mm
Battery voltage: 400 V

---

## Fabrication Notes for Dielectric Wiring Harness Routing

This section covers Drivetrain fabrication specifics for AMETHYST.
All processes reference the platform standard volumes F2-042 through F2-050
with AMETHYST-specific dimensional adaptations per F2-005.

### Material Requirements (Specific to Dielectric Wiring Harness Routing)

Per F2-007 (Aegis Materials Specification), the following materials apply
to this fabrication scope at sf=1.5:

1. **Primary structure (BFRP/Elium®):** Basalt fiber, 4,840 MPa tensile + Elium® 175 thermoplastic
   - Panel thickness: 4.5–7.5 mm (hull skin) or 12.0–18.0 mm (structural frame)
   - FVF target: 55–65% (VARTM per F2-042)
   - ρ > 10¹² Ω·m — confirmed by incoming batch Megger test

2. **Ceramics (ZrB₂–SiC, ZrO₂, Si₃N₄):** Per F2-007 and F2-015/F2-016
   - All fasteners: ZrO₂ 3Y-TZP (PN-CC-010 / PN-CC-011)
   - Vault: ZrB₂–SiC flash-sintered per F2-043
   - Bearings: Si₃N₄ per F2-016 and F2-045

3. **Coatings (YInMn Blue, MXene):** PN-CC-004 and PN-CC-008
   - Exterior: 50 µm YInMn Blue + QD (SRI=130)
   - Interior EMI: 50 µm MXene tile pattern (SE=92 dB)

### Quality Check Points for Dielectric Wiring Harness Routing

Per F2-034 (Fleet QA Master Plan):
- [ ] Incoming material certificates verified
- [ ] Dimensional inspection to drawing ±0.1 mm (ceramics) / ±0.5 mm (BFRP)
- [ ] Megger test >10¹⁰ Ω at all metallic-adjacent interfaces
- [ ] NDT per F2-047 (C-scan for BFRP, UV crack check for ceramics)
- [ ] Traceability: lot number, technician ID, vehicle serial logged

### Cross-References

| Related Document | Topic |
|---|---|
| F2-005 | Scaling equations (sf=1.5 all values) |
| F2-007 | Complete materials specification |
| F2-042 | VARTM composite fabrication |
| F2-043 | ZrB₂–SiC vault sintering protocol |
| F2-044 | ALON dome fabrication |
| F2-045 | Hub motor ceramic bearing assembly |
| F2-046 | CMBC final assembly sequence |
| F2-047 | NDT and inspection protocol |
| F2-050 | Parts interchangeability registry |
| F2-051 | Second-pass issue log |

---

*Document 340 of 304–387 for AMETHYST.*
*Second-pass will add specific equations, drawings, and fabrication diagrams.*


---
*End F2-340 | AMETHYST | CSMVessel-Charlemagne-FleetV2 | June 2026*
