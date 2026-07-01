# F2-433 — RHODONITE: Energy Budget and Range Analysis
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
**Vessel:** RHODONITE
---

## Document Reference

**Vessel:** CSMVessel0000000014 — RHODONITE
**Type:** 3/4-Scale Transit Bus
**Occupancy:** 24-30 adults seated (ADA accessible configuration)
**Scale Factor:** sf = 3.2
**Section:** Battery
**Document:** Energy Budget and Range Analysis

---

## Vessel Specification Summary

| Parameter | RHODONITE Value | BERYL Reference | Scaling |
|---|---|---|---|
| Length | 10.24 m | 3.20 m | sf × 3.20 m |
| Width | 6.72 m | 2.10 m | sf × 2.10 m |
| Height | 5.76 m | 1.80 m | sf × 1.80 m |
| Mass (unladen) | 9,200 kg | 780 kg | sf³ × 780 kg (approx) |
| Battery capacity | 185 kWh / 800 V | 28 kWh / 400 V | sf^2.8 × 28 kWh |
| Hub motors | 10 × 95 kW | 6 × 12 kW | sf^2.3 × 12 kW per motor |
| Maximum speed | 100 km/h | 160 km/h | Governed (not sf-dependent) |
| Range | 200 km (loaded) | 280 km highway | sf^2.8 derived from battery |
| COGS (10K/yr) | $128,000 @ 10K/yr | $22,500 | Scale + complexity |
| MSRP target | $285,000–$380,000 | $52,000–$72,000 | Market segment |

**Mineral name rationale:** Rhodonite (MnSiO₃) — manganese silicate; manganese (Mn) is the key chromophore in YInMn Blue (YIn₁₋ₓMnₓO₃) pigment coating every RHODONITE surface

---

## Vessel Design Context

RHODONITE is the transit and institutional flagship of the Charlemagne Fleet.
At 3/4 scale of a standard 12 m city bus (9.6 m effective passenger length),
RHODONITE is legal on all standard bus routes globally.

RHODONITE operates when every other transit system in the city doesn't.
During a Carrington event:
- Standard electric buses: copper windings + aluminum chassis = destroyed in minutes
- RHODONITE: ZrB₂–SiC vault + BFRP chassis + ceramic bearings = operative indefinitely

Technical adaptations at sf=3.2:
- Triple-AAJ spine: 3 accordion joints allow full articulation of 10.24 m length
- 10-motor (5 lateral pairs): maximum transit torque and redundancy
- Modular 4-vault CMBC: 4× 1,050 mm OD vault units (ECO-RHOD-001)
- Multi-segment ALON passenger cabin: 3 domed sections joined by PEEK CF40 connectors
- ADA accessibility: ZrO₂ ceramic ramp mechanism, low-floor boarding zones

45-minute O₂ life support for 30 passengers (flood/submersion emergency).

---

## Platform Scaling Applied to Battery: Energy Budget and Range Analysis

All dimensions and mechanical properties below are derived from BERYL (sf=1.0) reference
values using the scaling laws in F2-005.

### AAJ Scaled Parameters (sf=3.2)

| AAJ Parameter | RHODONITE Value | Calculation |
|---|---|---|
| Off-state stiffness k_off | 2867.2 kN/m | 280 kN/m × 3.2² |
| Maximum stiffness k_max | 28672.0 kN/m | 2,800 kN/m × 3.2² |
| Piezo element count | 550 elements | round(96 × 3.2^1.5) |
| Bellows wall thickness | 25.6 mm | max(3 mm, 8 mm × 3.2) |
| Bellows OD (compressed) | 1536 mm | 480 mm × 3.2 |
| Bellows OD (expanded) | 2176 mm | 680 mm × 3.2 |
| Axial travel | ±240 mm | ±75 mm × 3.2 |

### ALON Dome Scaled Parameters

| Dome Parameter | RHODONITE Value | Calculation |
|---|---|---|
| Dome radius | 3200 mm | 1,000 mm × 3.2 |
| Minimum wall thickness | 26 mm | max(8 mm, 8 mm × 3.2) |
| ALON panel mass (total) | 69.7 kg | 4.8 kg × sf^2.3 |

### CMBC Vault Scaled Parameters

Energy at sf=3.2: E = 28 kWh × 3.2^2.8 = **727.1 kWh** (battery system)
Vault OD: reference BERYL OD=900 mm; RHODONITE OD ≈ 2880 mm
Battery voltage: 800 V

---

## Fabrication Notes for Energy Budget and Range Analysis

This section covers Battery fabrication specifics for RHODONITE.
All processes reference the platform standard volumes F2-042 through F2-050
with RHODONITE-specific dimensional adaptations per F2-005.

### Material Requirements (Specific to Energy Budget and Range Analysis)

Per F2-007 (Aegis Materials Specification), the following materials apply
to this fabrication scope at sf=3.2:

1. **Primary structure (BFRP/Elium®):** Basalt fiber, 4,840 MPa tensile + Elium® 175 thermoplastic
   - Panel thickness: 9.6–16.0 mm (hull skin) or 25.6–38.4 mm (structural frame)
   - FVF target: 55–65% (VARTM per F2-042)
   - ρ > 10¹² Ω·m — confirmed by incoming batch Megger test

2. **Ceramics (ZrB₂–SiC, ZrO₂, Si₃N₄):** Per F2-007 and F2-015/F2-016
   - All fasteners: ZrO₂ 3Y-TZP (PN-CC-010 / PN-CC-011)
   - Vault: ZrB₂–SiC flash-sintered per F2-043
   - Bearings: Si₃N₄ per F2-016 and F2-045

3. **Coatings (YInMn Blue, MXene):** PN-CC-004 and PN-CC-008
   - Exterior: 50 µm YInMn Blue + QD (SRI=130)
   - Interior EMI: 50 µm MXene tile pattern (SE=92 dB)

### Quality Check Points for Energy Budget and Range Analysis

Per F2-034 (Fleet QA Master Plan):
- [ ] Incoming material certificates verified
- [ ] Dimensional inspection to drawing ±0.1 mm (ceramics) / ±0.5 mm (BFRP)
- [ ] Megger test >10¹⁰ Ω at all metallic-adjacent interfaces
- [ ] NDT per F2-047 (C-scan for BFRP, UV crack check for ceramics)
- [ ] Traceability: lot number, technician ID, vehicle serial logged

### Cross-References

| Related Document | Topic |
|---|---|
| F2-005 | Scaling equations (sf=3.2 all values) |
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

*Document 433 of 388–471 for RHODONITE.*
*Second-pass will add specific equations, drawings, and fabrication diagrams.*


---
*End F2-433 | RHODONITE | CSMVessel-Charlemagne-FleetV2 | June 2026*
