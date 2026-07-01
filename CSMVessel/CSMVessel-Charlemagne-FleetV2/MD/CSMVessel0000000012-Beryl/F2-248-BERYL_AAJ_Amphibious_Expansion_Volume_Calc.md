# F2-248 — BERYL: AAJ Amphibious Expansion Volume Calc
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
**Vessel:** BERYL
---

## Document Reference

**Vessel:** CSMVessel0000000012 — BERYL
**Type:** 4-Seat Passenger Car
**Occupancy:** 4 adults (2+2 configuration)
**Scale Factor:** sf = 1.0
**Section:** AAJ System
**Document:** AAJ Amphibious Expansion Volume Calc

---

## Vessel Specification Summary

| Parameter | BERYL Value | BERYL Reference | Scaling |
|---|---|---|---|
| Length | 3.20 m | 3.20 m | sf × 3.20 m |
| Width | 2.10 m | 2.10 m | sf × 2.10 m |
| Height | 1.80 m | 1.80 m | sf × 1.80 m |
| Mass (unladen) | 780 kg | 780 kg | sf³ × 780 kg (approx) |
| Battery capacity | 28 kWh / 400 V | 28 kWh / 400 V | sf^2.8 × 28 kWh |
| Hub motors | 6 × 12 kW | 6 × 12 kW | sf^2.3 × 12 kW per motor |
| Maximum speed | 160 km/h | 160 km/h | Governed (not sf-dependent) |
| Range | 280 km highway / 350 km city | 280 km highway | sf^2.8 derived from battery |
| COGS (10K/yr) | $22,500 @ 10K/yr | $22,500 | Scale + complexity |
| MSRP target | $52,000–$72,000 | $52,000–$72,000 | Market segment |

**Mineral name rationale:** Beryl (Be₃Al₂Si₆O₁₈) — hexagonal crystal, Al-silicate mineral family aligned with ALON Al₂₃O₂₇N₅

---

## Vessel Design Context

BERYL is the canonical Charlemagne reference platform (sf=1.0).
Every specification in the platform standard documents (F2-011 to F2-051)
references BERYL values. The other four vessels are derived FROM BERYL.

4-seat configuration: 2 front + 2 rear in geodesic ALON dome with 1,000 mm radius.
This provides genuine 360° panoramic visibility — the dome IS the windshield.
No A-pillars, no B-pillars, no blind spots.

Primary market: premium family vehicle replacement for sustainability-conscious
households that want genuine cross-terrain and amphibious capability alongside
immunity to infrastructure collapse scenarios.

BERYL is the "benchmark EV that survives what Teslas cannot."
Feature set: full ALON panoramic dome, 6-motor hexapedal, 28 kWh 280km range,
full amphibious, GIC immune, 4-8 Hz spinal protection, Schumann PEMF cabin.

---

## Platform Scaling Applied to AAJ System: AAJ Amphibious Expansion Volume Calc

All dimensions and mechanical properties below are derived from BERYL (sf=1.0) reference
values using the scaling laws in F2-005.

### AAJ Scaled Parameters (sf=1.0)

| AAJ Parameter | BERYL Value | Calculation |
|---|---|---|
| Off-state stiffness k_off | 280.0 kN/m | 280 kN/m × 1.0² |
| Maximum stiffness k_max | 2800.0 kN/m | 2,800 kN/m × 1.0² |
| Piezo element count | 96 elements | round(96 × 1.0^1.5) |
| Bellows wall thickness | 8.0 mm | max(3 mm, 8 mm × 1.0) |
| Bellows OD (compressed) | 480 mm | 480 mm × 1.0 |
| Bellows OD (expanded) | 680 mm | 680 mm × 1.0 |
| Axial travel | ±75 mm | ±75 mm × 1.0 |

### ALON Dome Scaled Parameters

| Dome Parameter | BERYL Value | Calculation |
|---|---|---|
| Dome radius | 1000 mm | 1,000 mm × 1.0 |
| Minimum wall thickness | 8 mm | max(8 mm, 8 mm × 1.0) |
| ALON panel mass (total) | 4.8 kg | 4.8 kg × sf^2.3 |

### CMBC Vault Scaled Parameters

Energy at sf=1.0: E = 28 kWh × 1.0^2.8 = **28.0 kWh** (battery system)
Vault OD: reference BERYL OD=900 mm; BERYL OD ≈ 900 mm
Battery voltage: 400 V

---

## Fabrication Notes for AAJ Amphibious Expansion Volume Calc

This section covers AAJ System fabrication specifics for BERYL.
All processes reference the platform standard volumes F2-042 through F2-050
with BERYL-specific dimensional adaptations per F2-005.

### Material Requirements (Specific to AAJ Amphibious Expansion Volume Calc)

Per F2-007 (Aegis Materials Specification), the following materials apply
to this fabrication scope at sf=1.0:

1. **Primary structure (BFRP/Elium®):** Basalt fiber, 4,840 MPa tensile + Elium® 175 thermoplastic
   - Panel thickness: 3.0–5.0 mm (hull skin) or 8.0–12.0 mm (structural frame)
   - FVF target: 55–65% (VARTM per F2-042)
   - ρ > 10¹² Ω·m — confirmed by incoming batch Megger test

2. **Ceramics (ZrB₂–SiC, ZrO₂, Si₃N₄):** Per F2-007 and F2-015/F2-016
   - All fasteners: ZrO₂ 3Y-TZP (PN-CC-010 / PN-CC-011)
   - Vault: ZrB₂–SiC flash-sintered per F2-043
   - Bearings: Si₃N₄ per F2-016 and F2-045

3. **Coatings (YInMn Blue, MXene):** PN-CC-004 and PN-CC-008
   - Exterior: 50 µm YInMn Blue + QD (SRI=130)
   - Interior EMI: 50 µm MXene tile pattern (SE=92 dB)

### Quality Check Points for AAJ Amphibious Expansion Volume Calc

Per F2-034 (Fleet QA Master Plan):
- [ ] Incoming material certificates verified
- [ ] Dimensional inspection to drawing ±0.1 mm (ceramics) / ±0.5 mm (BFRP)
- [ ] Megger test >10¹⁰ Ω at all metallic-adjacent interfaces
- [ ] NDT per F2-047 (C-scan for BFRP, UV crack check for ceramics)
- [ ] Traceability: lot number, technician ID, vehicle serial logged

### Cross-References

| Related Document | Topic |
|---|---|
| F2-005 | Scaling equations (sf=1.0 all values) |
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

*Document 248 of 220–303 for BERYL.*
*Second-pass will add specific equations, drawings, and fabrication diagrams.*


---
*End F2-248 | BERYL | CSMVessel-Charlemagne-FleetV2 | June 2026*
