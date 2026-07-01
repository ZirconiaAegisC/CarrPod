# F2-078 — TOURMALINE: 4-8 Hz Bandgap Test and Validation
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
**Vessel:** TOURMALINE
---

## Document Reference

**Vessel:** CSMVessel0000000010 — TOURMALINE
**Type:** Child Toy Fun Vessel
**Occupancy:** 1-2 children (ages 4-12)
**Scale Factor:** sf = 0.35
**Section:** AAJ System
**Document:** 4-8 Hz Bandgap Test and Validation

---

## Vessel Specification Summary

| Parameter | TOURMALINE Value | BERYL Reference | Scaling |
|---|---|---|---|
| Length | 1.12 m | 3.20 m | sf × 3.20 m |
| Width | 0.74 m | 2.10 m | sf × 2.10 m |
| Height | 0.63 m | 1.80 m | sf × 1.80 m |
| Mass (unladen) | 42 kg | 780 kg | sf³ × 780 kg (approx) |
| Battery capacity | 1.92 kWh / 48 V | 28 kWh / 400 V | sf^2.8 × 28 kWh |
| Hub motors | 6 × 150 W | 6 × 12 kW | sf^2.3 × 12 kW per motor |
| Maximum speed | 25 km/h governed | 160 km/h | Governed (not sf-dependent) |
| Range | 46 km nominal | 280 km highway | sf^2.8 derived from battery |
| COGS (10K/yr) | $4,200 @ 10K/yr | $22,500 | Scale + complexity |
| MSRP target | $9,800–$12,500 | $52,000–$72,000 | Market segment |

**Mineral name rationale:** Tourmaline (Na,Ca)(Al,Fe)₃(BO₃)₃Si₆O₁₈ — complex borosilicate; boron → ZrB₂ synthesis

---

## Vessel Design Context

TOURMALINE is the market entry vessel. It embodies the complete Charlemagne
philosophy at child-safe scale. Every component is genuine Aegis engineering:
real ZrB₂–SiC vault, real ALON dome (8 mm wall), real Si₃N₄ bearings.
The vessel is not a toy pretending to be a Charlemagne — it IS a Charlemagne.

Key TOURMALINE-only features:
- 5-point UHMWPE child harness (ECE R44 compliant)
- Parent LoRa tether (PN-CC-001): geo-fence, speed cap, emergency stop
- LED full-RGB customization + KNbO₃ sound system (85 dB max)
- 30-minute sealed O₂ life support (F2-027)
- Schumann PEMF fixed at 0.5 µT (conservative pediatric)

Platform exceptions from BERYL sf=1.0:
- ECO-TOUR-001: Lattice-Lock uses 25% density (not standard 8%)
- ECO-TOUR-002: Sorbothane A10 dome mounts (not A20) for f_n < 4 Hz
- AAJ natural frequency tuning: k_off must keep f_n outside 4–8 Hz danger band

---

## Platform Scaling Applied to AAJ System: 4-8 Hz Bandgap Test and Validation

All dimensions and mechanical properties below are derived from BERYL (sf=1.0) reference
values using the scaling laws in F2-005.

### AAJ Scaled Parameters (sf=0.35)

| AAJ Parameter | TOURMALINE Value | Calculation |
|---|---|---|
| Off-state stiffness k_off | 34.3 kN/m | 280 kN/m × 0.35² |
| Maximum stiffness k_max | 343.0 kN/m | 2,800 kN/m × 0.35² |
| Piezo element count | 20 elements | round(96 × 0.35^1.5) |
| Bellows wall thickness | 3.0 mm | max(3 mm, 8 mm × 0.35) |
| Bellows OD (compressed) | 168 mm | 480 mm × 0.35 |
| Bellows OD (expanded) | 238 mm | 680 mm × 0.35 |
| Axial travel | ±26 mm | ±75 mm × 0.35 |

### ALON Dome Scaled Parameters

| Dome Parameter | TOURMALINE Value | Calculation |
|---|---|---|
| Dome radius | 350 mm | 1,000 mm × 0.35 |
| Minimum wall thickness | 8 mm | max(8 mm, 8 mm × 0.35) |
| ALON panel mass (total) | 0.4 kg | 4.8 kg × sf^2.3 |

### CMBC Vault Scaled Parameters

Energy at sf=0.35: E = 28 kWh × 0.35^2.8 = **1.5 kWh** (battery system)
Vault OD: reference BERYL OD=900 mm; TOURMALINE OD ≈ 315 mm
Battery voltage: 48 V

---

## Fabrication Notes for 4-8 Hz Bandgap Test and Validation

This section covers AAJ System fabrication specifics for TOURMALINE.
All processes reference the platform standard volumes F2-042 through F2-050
with TOURMALINE-specific dimensional adaptations per F2-005.

### Material Requirements (Specific to 4-8 Hz Bandgap Test and Validation)

Per F2-007 (Aegis Materials Specification), the following materials apply
to this fabrication scope at sf=0.35:

1. **Primary structure (BFRP/Elium®):** Basalt fiber, 4,840 MPa tensile + Elium® 175 thermoplastic
   - Panel thickness: 1.0–1.8 mm (hull skin) or 2.8–4.2 mm (structural frame)
   - FVF target: 55–65% (VARTM per F2-042)
   - ρ > 10¹² Ω·m — confirmed by incoming batch Megger test

2. **Ceramics (ZrB₂–SiC, ZrO₂, Si₃N₄):** Per F2-007 and F2-015/F2-016
   - All fasteners: ZrO₂ 3Y-TZP (PN-CC-010 / PN-CC-011)
   - Vault: ZrB₂–SiC flash-sintered per F2-043
   - Bearings: Si₃N₄ per F2-016 and F2-045

3. **Coatings (YInMn Blue, MXene):** PN-CC-004 and PN-CC-008
   - Exterior: 50 µm YInMn Blue + QD (SRI=130)
   - Interior EMI: 50 µm MXene tile pattern (SE=92 dB)

### Quality Check Points for 4-8 Hz Bandgap Test and Validation

Per F2-034 (Fleet QA Master Plan):
- [ ] Incoming material certificates verified
- [ ] Dimensional inspection to drawing ±0.1 mm (ceramics) / ±0.5 mm (BFRP)
- [ ] Megger test >10¹⁰ Ω at all metallic-adjacent interfaces
- [ ] NDT per F2-047 (C-scan for BFRP, UV crack check for ceramics)
- [ ] Traceability: lot number, technician ID, vehicle serial logged

### Cross-References

| Related Document | Topic |
|---|---|
| F2-005 | Scaling equations (sf=0.35 all values) |
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

*Document 78 of 52–135 for TOURMALINE.*
*Second-pass will add specific equations, drawings, and fabrication diagrams.*


---
*End F2-078 | TOURMALINE | CSMVessel-Charlemagne-FleetV2 | June 2026*
