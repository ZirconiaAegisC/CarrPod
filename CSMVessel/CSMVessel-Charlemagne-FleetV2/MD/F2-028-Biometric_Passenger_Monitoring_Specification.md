# F2-028 — Biometric Passenger Monitoring Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Sensor Suite — All-Optical

All passenger biometric sensors use non-contact or indirect (vibrational) methods.
**No metallic electrodes contact any passenger.** This principle is maintained because:
- Metallic skin electrodes → conductive loops → GIC coupling through human body
- Under G5 storm: potential shock hazard if skin electrodes present

The all-optical approach also improves comfort and eliminates gel/adhesive requirements.

## 2. Sensor Details

### Heart Rate and HRV (Primary Stress Marker)
- Technology: PVDF-TrFE film vibrational cardiography (ballistocardiography)
- Placement: Seat cushion (PN-CC-016 PVDF-TrFE film)
- Principle: Heartbeat mechanical vibration → PVDF film voltage → optical coupler → MRAM
- Accuracy: ±4 BPM at rest, ±8 BPM in motion (adequate for safety monitoring)
- HRV calculation: RR-interval analysis, SDNN and RMSSD computed every 5 min
- GIC immunity: PVDF-TrFE is a polymer, ρ > 10¹² Ω·m — zero GIC coupling ✓

### Respiration Rate
- Technology: FBG optical strain gauge woven into 5-point harness chest strap
- Principle: Chest expansion during breathing → strain in harness → FBG wavelength shift
- Accuracy: ±1 breath/min
- Response time: Real-time (no averaging delay)

### SpO₂ (Blood Oxygen Saturation)
- Technology: 660 nm/940 nm LED pair in headrest cushion (reflection mode PPG)
- Accuracy: ±2% SpO₂ (laboratory validated)
- Activation: Only when occupant head is within 3 cm of sensor (proximity-triggered)

### Occupant Presence
- Technology: PVDF-TrFE seat pressure sensor (same film as cardiography, different threshold)
- Function: Safety interlock — speed limited to 5 km/h if seat is unoccupied while in motion

## 3. Emergency Thresholds

| Metric | Normal Range | Warning | Emergency Action |
|---|---|---|---|
| HR | 50–120 BPM | <40 or >160 BPM for >10 s | Stop + LoRa alert |
| RR | 10–25 breaths/min | <6 for >15 s | Stop + EPIRB |
| SpO₂ | 94–100% | <90% | Stop + LoRa + O₂ activate |
| HRV RMSSD | >20 ms (BERYL) | Sustained drop >50% | PEMF amplitude increase |


---
*End F2-028 | CSMVessel-Charlemagne-FleetV2 | June 2026*
