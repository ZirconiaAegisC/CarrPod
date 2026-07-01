# F2-020 — Lattice-Lock Negative-Stiffness Floor Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Biomechanical Mandate

The Lattice-Lock floor system is the one component that DEFINES the CMBC centralized
architecture as superior. It functions by exploiting a counter-intuitive material response:

**Conventional spring:** force and displacement are proportional (positive stiffness)
**Negative-stiffness element:** at a critical force, the element SNAPS LATERALLY
instead of compressing — it dissipates energy without transmitting impulse

When the 4–8 Hz chassis vibration attempts to excite the occupant's spine:
- The Lattice-Lock cells are pre-loaded just below snap-through threshold
- A 4–8 Hz chassis impulse causes the cells to snap laterally
- The impulse energy is absorbed in the snap-through event
- Near-zero force is transmitted to the occupant floor surface
- **Result: >40 dB attenuation of the 4–8 Hz band at the occupant interface**

## 2. Gyroid Lattice Design

**Geometry:** Schwartz P or Gyroid TPMS (Triply Periodic Minimal Surface)
- Cell size: 12 mm × 12 mm × 8 mm per unit cell (BERYL reference)
- Relative density: 8% (standard); 25% (TOURMALINE — ECO-TOUR-001, see F2-051)
- Manufacturing: SLS (Selective Laser Sintering) with PEEK polymer powder
- Post-cure: HIP (Hot Isostatic Press) at 330°C / 150 MPa for PEEK densification

**TOURMALINE ECO note:** At 8% relative density, the cell's static load capacity =
280 kg/m² × 0.123 m² floor area = 34.4 kg — insufficient for 80 kg occupant load.
Required density for TOURMALINE: 25% (capacity = 140 kg/m² → adequate).
The 25% density still maintains adequate snap-through behavior per vibration testing.

## 3. Layer Stack (Bottom to Top)

1. **ZrB₂–SiC structural base** (6 mm): load transfer from chassis to lattice
2. **Lattice-Lock gyroid** (35 mm): vibration isolation
3. **Polyimide-silica aerogel** (10 mm, λ=0.010 W/m·K): thermal break + acoustic
4. **Basalt textile cover** (3 mm): FTP Code 2000 compliant, comfort surface

Total floor assembly: **54 mm** | Mass: 28 kg/m² (BERYL reference)


---
*End F2-020 | CSMVessel-Charlemagne-FleetV2 | June 2026*
