# CSMFAB062: GRID-HEART — Passive Non-Contact Transformer Monitor
## Episode 17 | Priority P2 | By CROSS

**Function:** Guitar-pickup-style magnetic field sensor clamps onto utility pole. Detects 60Hz transformer field presence. Reports status via FEATHER mesh. Real-time transformer health map without SCADA.

| Spec | Value |
|------|-------|
| Sensor | Ferrite core coil, non-contact, 60Hz detection |
| Mounting | Hot-stick clamp, 5 minutes, no electrical contact |
| Processor | Core-1 with 60Hz detection firmware |
| Communication | FEATHER LoRa, reports once/day normal, real-time during event |
| Data | Transformer ID, GPS location, energized/de-energized, timestamp |
| Power | 2× AA lithium (3yr life) — no solar needed |
| Unit cost | $34 |
| Neighborhood deployment (50 poles) | $1,700 |

## UTILITY INTEGRATION
Grid-Heart data feeds into utility SCADA via FEATHER mesh gateway. Map view: green (energized), red (de-energized). Enables targeted crew dispatch without manual patrol.
