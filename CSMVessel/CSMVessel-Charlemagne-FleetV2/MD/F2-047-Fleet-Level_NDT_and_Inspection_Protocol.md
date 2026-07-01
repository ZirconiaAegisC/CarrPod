# F2-047 — Fleet-Level NDT and Inspection Protocol
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Non-Destructive Testing Methods

### Ultrasonic C-Scan (Primary NDT for BFRP and ALON)
- Equipment: Olympus EPOCH 650 or equivalent, 5 MHz transducer
- Scan resolution: 1 mm × 1 mm grid
- Reference standard: Flat-bottomed hole (FBH) 6 mm diameter, 50% depth
- Reject criterion: Any indication > FBH reference (delamination area > 6 mm diameter)
- All hull panels: 100% C-scan before assembly
- ALON panels: 100% C-scan, adapted for ceramic (10 MHz transducer, water-coupled)

### Helium Leak Testing (All Sealed Assemblies)
- Method: Vacuum hood over joint, helium spray inside
- Mass spectrometer sensitivity: 10⁻⁸ mbar·L/s instrument detection limit
- CMBC vault pass criterion: 10⁻⁷ mbar·L/s
- Hub motor seal: 10⁻⁶ mbar·L/s (less stringent, V-ring backup available)
- ALON dome: air pressure 2 bar / 60 min (no leak by bubble observation)

### Megger (Electrical Isolation — MOST IMPORTANT QA STEP)
- Instrument: Megger MIT1025 or equivalent, 1,000 V DC
- All Si₃N₄ bearings: >10¹² Ω shaft-to-housing
- CMBC vault assembled: >10¹⁰ Ω vault body to chassis
- Full vehicle: 20-point hull scan, all >10¹⁰ Ω
- This test is performed at 3 stages: post-bearing-install, post-vault-assembly, post-vehicle-assembly
- Any reading <10⁸ Ω on any point: STOP LINE. Investigate and resolve before proceeding.

### Fiber Bragg Grating (FBG) Structural Health Monitoring
- Permanent embedded sensors (PN-CC-007) at 48 strategic points (BERYL reference)
- Baseline measurement after first assembly; archived in MRAM + remote database
- Alarm: any FBG reading that deviates >3,000 µε from baseline → inspection required
- Benefit: lifetime structural monitoring catches fatigue initiation before failure

### Acoustic Emission (AE) During Proof Load Testing
- Applied to: ALON dome assembly (proof load = 5× static occupant mass)
- Criterion: Cumulative AE counts <1,000 during full proof load application (brittle crack indicator)
- Exceeds: Suspect ALON panel, isolate and replace

## 2. Complete Pre-Delivery QA Checklist

See F2-034 for full table. Key requirements:
- All Megger readings >10¹⁰ Ω: MANDATORY
- He-leak test: MANDATORY
- IP68 immersion: MANDATORY
- AAJ vibration spectrum: MANDATORY
- ALON optical: SAMPLE (3 panels per dome)
- GIC immunity scan: MANDATORY
- Biometric sensor: SAMPLE (1 seat per vehicle)


---
*End F2-047 | CSMVessel-Charlemagne-FleetV2 | June 2026*
