# Vol-250 — BERYL Hexapedal Drivetrain: Hub Motor Selection and Scaling
**Vessel:** CSMVessel0000000012 BERYL | **Series:** Charlemagne-Class-Fleet | **Date:** June 2026
---
## Document Reference
- **Vessel:** CSMVessel0000000012 — BERYL  
- **Type:** 4-Seat Passenger Car
- **Occupancy:** 4 adults
- **Scale Factor:** sf=1.0 (BERYL reference = 1.0)
- **Section:** Hexapedal Drivetrain
- **Document:** Hub Motor Selection and Scaling

## Vessel Key Specifications
| Parameter | BERYL Value |
|---|---|
| Length | 3.2m |
| Width | 2.1m |
| Height | 1.8m |
| Mass (unladen) | 780kg |
| Battery | 28 kWh, 400V |
| Hub motors | 6×12kW |
| Max speed | 160 km/h |
| Range | 280 km highway, 350 km city |
| Unit COGS (10K/yr) | $22,500 |
| MSRP | $52,000-$72,000 |

## Platform Inheritance

BERYL inherits the complete Charlemagne Platform Standard (Vol-011 to Vol-050) scaled by sf=1.0.
All scaling equations per Vol-012 (AAJ), Vol-013 (CMBC), Vol-014 (Hub motors), Vol-015 (ALON).

## BERYL-Specific Design Notes

Reference platform design, standard BERYL specs as per CSMVessel0000000009, full dome visibility, 4-adult seating in 2+2 configuration

**Mineral Name Rationale:** Beryl — Be3Al2Si6O18, hexagonal silicate (ALON chemistry precursor group)

## Fabrication Guidelines for Hub Motor Selection and Scaling

Per Charlemagne Class Fleet Platform Standard with sf=1.0 scaling applied:

### AAJ Scaled Specifications
- k_off = 280 kN/m × 1.0² = 280 kN/m
- k_max = 2800 kN/m × 1.0² = 2800 kN/m
- Piezo elements = round(96 × 1.0^1.5) = 96 elements
- Wall thickness = max(3mm, 8mm × 1.0) = 8mm

### Battery Specifications
Per Vol-026 scaling:
- Configured for 28 kWh, 400V
- ZrB₂-SiC vault OD: refer to Vol-013 CMBC sizing table
- All LiFePO₄ cells per Vol-026 module standard
- GIC immunity per vessel Vol-013 verification protocol

### ALON Dome
Per Vol-015 and Vol-018:
- Dome radius = 0.62 × vessel max width = 130cm
- ALON panels per scaled geodesic subdivision
- All panel procurement: Surmet Corporation (Vol-047 ordering protocol)

### Manufacturing Priority for this Document
This document covers Hub Motor Selection and Scaling for the BERYL vessel.
All process protocols reference the Platform Standard volumes (Vol-045 to Vol-050).
BERYL-specific deviations from platform are documented with engineering rationale.

### Cross-References
- Platform base: Vol-011 to Vol-050
- TOURMALINE precedent (same concepts, different scale): Vol-051 to Vol-134
- Fleet cost context: Vol-008
- Mineral materials study: CSMFAB Materials Study Parts I-VI

---
*End Vol-250 | BERYL | CSMVessel-Charlemagne-Class-Fleet | June 2026*
