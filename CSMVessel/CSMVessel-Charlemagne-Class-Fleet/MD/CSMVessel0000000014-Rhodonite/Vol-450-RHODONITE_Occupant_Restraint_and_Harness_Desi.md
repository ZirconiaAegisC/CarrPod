# Vol-450 — RHODONITE Safety Systems: Occupant Restraint and Harness Design
**Vessel:** CSMVessel0000000014 RHODONITE | **Series:** Charlemagne-Class-Fleet | **Date:** June 2026
---
## Document Reference
- **Vessel:** CSMVessel0000000014 — RHODONITE  
- **Type:** 3/4-Bus Transit Vessel
- **Occupancy:** 24-30 adults
- **Scale Factor:** sf=3.2 (BERYL reference = 1.0)
- **Section:** Safety Systems
- **Document:** Occupant Restraint and Harness Design

## Vessel Key Specifications
| Parameter | RHODONITE Value |
|---|---|
| Length | 9.6m |
| Width | 3.2m |
| Height | 3.0m |
| Mass (unladen) | 8,500kg |
| Battery | 185 kWh, 800V |
| Hub motors | 10×35kW |
| Max speed | 100 km/h |
| Range | 200 km loaded |
| Unit COGS (10K/yr) | $128,000 |
| MSRP | $285,000-$380,000 |

## Platform Inheritance

RHODONITE inherits the complete Charlemagne Platform Standard (Vol-011 to Vol-050) scaled by sf=3.2.
All scaling equations per Vol-012 (AAJ), Vol-013 (CMBC), Vol-014 (Hub motors), Vol-015 (ALON).

## RHODONITE-Specific Design Notes

Transit bus at 3/4 scale. Triple AAJ accordion joints. Multi-segment ALON cabin. 10-motor configuration for full transit torque. Full amphibious capability for flooding scenarios.

**Mineral Name Rationale:** Rhodonite — Mn silicate (MnSiO3, manganese in YInMn Blue pigment precursor)

## Fabrication Guidelines for Occupant Restraint and Harness Design

Per Charlemagne Class Fleet Platform Standard with sf=3.2 scaling applied:

### AAJ Scaled Specifications
- k_off = 280 kN/m × 3.2² = 2867 kN/m
- k_max = 2800 kN/m × 3.2² = 28672 kN/m
- Piezo elements = round(96 × 3.2^1.5) = 550 elements
- Wall thickness = max(3mm, 8mm × 3.2) = 26mm

### Battery Specifications
Per Vol-026 scaling:
- Configured for 185 kWh, 800V
- ZrB₂-SiC vault OD: refer to Vol-013 CMBC sizing table
- All LiFePO₄ cells per Vol-026 module standard
- GIC immunity per vessel Vol-013 verification protocol

### ALON Dome
Per Vol-015 and Vol-018:
- Dome radius = 0.62 × vessel max width = 198cm
- ALON panels per scaled geodesic subdivision
- All panel procurement: Surmet Corporation (Vol-047 ordering protocol)

### Manufacturing Priority for this Document
This document covers Occupant Restraint and Harness Design for the RHODONITE vessel.
All process protocols reference the Platform Standard volumes (Vol-045 to Vol-050).
RHODONITE-specific deviations from platform are documented with engineering rationale.

### Cross-References
- Platform base: Vol-011 to Vol-050
- TOURMALINE precedent (same concepts, different scale): Vol-051 to Vol-134
- Fleet cost context: Vol-008
- Mineral materials study: CSMFAB Materials Study Parts I-VI

---
*End Vol-450 | RHODONITE | CSMVessel-Charlemagne-Class-Fleet | June 2026*
