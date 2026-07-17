# P0-01-VOL-14: Assembly Sequence — Stage 4: Post-Installation Verification
## CSMFAB-P001 | Ceramic Bridge Bearings 500T

---

## POST-INSTALL VERIFICATION CHECKLIST

| Check | Method | Pass Criteria | When |
|-------|--------|---------------|------|
| Bearing settlement | Dial indicator on 4 corners | ≤3mm, ≤1mm differential | Immediately after load |
| Bearing rotation | Clinometer on housing | ≤0.005 rad under dead load | After 24hr |
| Dielectric continuity | Megger test, 1 kV DC | >100 MΩ structure-to-substructure | After weather seal cure (7d) |
| Anchor bolt torque | Torque wrench re-check | ≥405 N·m (90% of spec) | 7 days, 30 days, annually |
| Weather seal integrity | Visual + 50 kPa water spray | No water ingress into housing | Annually |
| PTFE surface wear | Feeler gauge at housing-disc gap | ≤1mm wear depth | Annually |
| GIC current measurement | Rogowski coil on bridge girder | <0.1 A during Kp >7 event | Continuous (FEATHER node) |

## LONG-TERM MONITORING
Each bearing installation is paired with a FEATHER LoRa mesh node (CSMFAB0115) that monitors:
- Bridge girder current (Rogowski coil, 0.01-100A range)
- Bearing temperature (thermocouple, ±0.5°C)
- Bearing displacement (LVDT, ±0.1mm)
- Ambient geomagnetic field (MEMS magnetometer)

Data transmitted via LoRa mesh to regional NannyCam monitoring instance. Alerts generated at 5A GIC threshold (amber) and 50A (red). Post-event inspection triggered automatically.
