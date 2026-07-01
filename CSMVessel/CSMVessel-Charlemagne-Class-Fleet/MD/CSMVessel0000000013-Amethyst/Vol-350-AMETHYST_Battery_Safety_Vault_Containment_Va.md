# Vol-350 — AMETHYST Battery System: Battery Safety Vault Containment Validation
**Vessel:** CSMVessel0000000013 AMETHYST | **Series:** Charlemagne-Class-Fleet | **Date:** June 2026
---
## Document Reference
- **Vessel:** CSMVessel0000000013 — AMETHYST  
- **Type:** 8-Seat Passenger SUV
- **Occupancy:** 8 adults
- **Scale Factor:** sf=1.5 (BERYL reference = 1.0)
- **Section:** Battery System
- **Document:** Battery Safety Vault Containment Validation

## Vessel Key Specifications
| Parameter | AMETHYST Value |
|---|---|
| Length | 4.8m |
| Width | 3.15m |
| Height | 2.4m |
| Mass (unladen) | 2,100kg |
| Battery | 58 kWh, 400V |
| Hub motors | 8×18kW |
| Max speed | 140 km/h |
| Range | 240 km highway, 300 km city |
| Unit COGS (10K/yr) | $38,000 |
| MSRP | $85,000-$110,000 |

## Platform Inheritance

AMETHYST inherits the complete Charlemagne Platform Standard (Vol-011 to Vol-050) scaled by sf=1.5.
All scaling equations per Vol-012 (AAJ), Vol-013 (CMBC), Vol-014 (Hub motors), Vol-015 (ALON).

## AMETHYST-Specific Design Notes

Extended 8-seat dual-row cabin in enlarged ALON dome. Dual AAJ accordion joints. 8-motor hexapedal-plus configuration. Transit/institutional primary market.

**Mineral Name Rationale:** Amethyst — SiO2 with Fe3+ (relates to SiC precursor minerals)

## Fabrication Guidelines for Battery Safety Vault Containment Validation

Per Charlemagne Class Fleet Platform Standard with sf=1.5 scaling applied:

### AAJ Scaled Specifications
- k_off = 280 kN/m × 1.5² = 630 kN/m
- k_max = 2800 kN/m × 1.5² = 6300 kN/m
- Piezo elements = round(96 × 1.5^1.5) = 176 elements
- Wall thickness = max(3mm, 8mm × 1.5) = 12mm

### Battery Specifications
Per Vol-026 scaling:
- Configured for 58 kWh, 400V
- ZrB₂-SiC vault OD: refer to Vol-013 CMBC sizing table
- All LiFePO₄ cells per Vol-026 module standard
- GIC immunity per vessel Vol-013 verification protocol

### ALON Dome
Per Vol-015 and Vol-018:
- Dome radius = 0.62 × vessel max width = 195cm
- ALON panels per scaled geodesic subdivision
- All panel procurement: Surmet Corporation (Vol-047 ordering protocol)

### Manufacturing Priority for this Document
This document covers Battery Safety Vault Containment Validation for the AMETHYST vessel.
All process protocols reference the Platform Standard volumes (Vol-045 to Vol-050).
AMETHYST-specific deviations from platform are documented with engineering rationale.

### Cross-References
- Platform base: Vol-011 to Vol-050
- TOURMALINE precedent (same concepts, different scale): Vol-051 to Vol-134
- Fleet cost context: Vol-008
- Mineral materials study: CSMFAB Materials Study Parts I-VI

---
*End Vol-350 | AMETHYST | CSMVessel-Charlemagne-Class-Fleet | June 2026*
