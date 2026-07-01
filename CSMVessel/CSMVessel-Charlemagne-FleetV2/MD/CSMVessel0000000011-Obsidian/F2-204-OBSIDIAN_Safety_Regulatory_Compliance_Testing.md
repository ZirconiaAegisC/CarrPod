# F2-204 — OBSIDIAN: Safety Regulatory Compliance Testing
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
**Vessel:** OBSIDIAN
---

## Document Reference

**Vessel:** CSMVessel0000000011 — OBSIDIAN
**Type:** Adult Motorcycle-Class Vessel
**Occupancy:** 1-2 adults
**Scale Factor:** sf = 0.55
**Section:** Safety
**Document:** Safety Regulatory Compliance Testing

---

## Vessel Specification Summary

| Parameter | OBSIDIAN Value | BERYL Reference | Scaling |
|---|---|---|---|
| Length | 1.76 m | 3.20 m | sf × 3.20 m |
| Width | 1.16 m | 2.10 m | sf × 2.10 m |
| Height | 0.99 m | 1.80 m | sf × 1.80 m |
| Mass (unladen) | 185 kg | 780 kg | sf³ × 780 kg (approx) |
| Battery capacity | 8.5 kWh / 96 V | 28 kWh / 400 V | sf^2.8 × 28 kWh |
| Hub motors | 6 × 650 W | 6 × 12 kW | sf^2.3 × 12 kW per motor |
| Maximum speed | 120 km/h | 160 km/h | Governed (not sf-dependent) |
| Range | 120 km city / 90 km aggressive | 280 km highway | sf^2.8 derived from battery |
| COGS (10K/yr) | $8,200 @ 10K/yr | $22,500 | Scale + complexity |
| MSRP target | $18,000–$28,000 | $52,000–$72,000 | Market segment |

**Mineral name rationale:** Obsidian — volcanic glass (SiO₂-rich basaltic composition) — the natural precursor analog to BFRP basalt fiber

---

## Vessel Design Context

OBSIDIAN is the single/dual occupant performance variant. It prioritizes:
- High-speed terrain traversal (120 km/h)
- Low-profile ALON visor cockpit (aerodynamically optimized, not full sphere)
- Sport-tuned AAJ (higher k_off at sf=0.55 for responsive handling)
- Target market: adventure enthusiasts, emergency first-responders, security

Design philosophy: The sleek black volcanic glass aesthetic is not accidental.
Obsidian was the sharpest cutting material humanity used for 2 million years.
OBSIDIAN the vessel is the sharpest mobility tool of the Carrington Age.

Key OBSIDIAN-specific features:
- ALON streamlined visor (not full sphere — aerodynamic wrap design)
- Sport suspension AAJ tuning (higher natural frequency for driver feedback)
- Lean-mode torque vectoring (motorcycle-style cornering physics)
- Quick-release single-rider configuration optional

---

## Platform Scaling Applied to Safety: Safety Regulatory Compliance Testing

All dimensions and mechanical properties below are derived from BERYL (sf=1.0) reference
values using the scaling laws in F2-005.

### AAJ Scaled Parameters (sf=0.55)

| AAJ Parameter | OBSIDIAN Value | Calculation |
|---|---|---|
| Off-state stiffness k_off | 84.7 kN/m | 280 kN/m × 0.55² |
| Maximum stiffness k_max | 847.0 kN/m | 2,800 kN/m × 0.55² |
| Piezo element count | 39 elements | round(96 × 0.55^1.5) |
| Bellows wall thickness | 4.4 mm | max(3 mm, 8 mm × 0.55) |
| Bellows OD (compressed) | 264 mm | 480 mm × 0.55 |
| Bellows OD (expanded) | 374 mm | 680 mm × 0.55 |
| Axial travel | ±41 mm | ±75 mm × 0.55 |

### ALON Dome Scaled Parameters

| Dome Parameter | OBSIDIAN Value | Calculation |
|---|---|---|
| Dome radius | 550 mm | 1,000 mm × 0.55 |
| Minimum wall thickness | 8 mm | max(8 mm, 8 mm × 0.55) |
| ALON panel mass (total) | 1.2 kg | 4.8 kg × sf^2.3 |

### CMBC Vault Scaled Parameters

Energy at sf=0.55: E = 28 kWh × 0.55^2.8 = **5.3 kWh** (battery system)
Vault OD: reference BERYL OD=900 mm; OBSIDIAN OD ≈ 495 mm
Battery voltage: 96 V

---

## Fabrication Notes for Safety Regulatory Compliance Testing

This section covers Safety fabrication specifics for OBSIDIAN.
All processes reference the platform standard volumes F2-042 through F2-050
with OBSIDIAN-specific dimensional adaptations per F2-005.

### Material Requirements (Specific to Safety Regulatory Compliance Testing)

Per F2-007 (Aegis Materials Specification), the following materials apply
to this fabrication scope at sf=0.55:

1. **Primary structure (BFRP/Elium®):** Basalt fiber, 4,840 MPa tensile + Elium® 175 thermoplastic
   - Panel thickness: 1.7–2.8 mm (hull skin) or 4.4–6.6 mm (structural frame)
   - FVF target: 55–65% (VARTM per F2-042)
   - ρ > 10¹² Ω·m — confirmed by incoming batch Megger test

2. **Ceramics (ZrB₂–SiC, ZrO₂, Si₃N₄):** Per F2-007 and F2-015/F2-016
   - All fasteners: ZrO₂ 3Y-TZP (PN-CC-010 / PN-CC-011)
   - Vault: ZrB₂–SiC flash-sintered per F2-043
   - Bearings: Si₃N₄ per F2-016 and F2-045

3. **Coatings (YInMn Blue, MXene):** PN-CC-004 and PN-CC-008
   - Exterior: 50 µm YInMn Blue + QD (SRI=130)
   - Interior EMI: 50 µm MXene tile pattern (SE=92 dB)

### Quality Check Points for Safety Regulatory Compliance Testing

Per F2-034 (Fleet QA Master Plan):
- [ ] Incoming material certificates verified
- [ ] Dimensional inspection to drawing ±0.1 mm (ceramics) / ±0.5 mm (BFRP)
- [ ] Megger test >10¹⁰ Ω at all metallic-adjacent interfaces
- [ ] NDT per F2-047 (C-scan for BFRP, UV crack check for ceramics)
- [ ] Traceability: lot number, technician ID, vehicle serial logged

### Cross-References

| Related Document | Topic |
|---|---|
| F2-005 | Scaling equations (sf=0.55 all values) |
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

*Document 204 of 136–219 for OBSIDIAN.*
*Second-pass will add specific equations, drawings, and fabrication diagrams.*


---
*End F2-204 | OBSIDIAN | CSMVessel-Charlemagne-FleetV2 | June 2026*
