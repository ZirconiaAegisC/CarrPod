# P0-07: Faraday Alarm GIC Detection Sensor — Complete Fabrication
## CSMFAB-P007 | CSM-COM-FA-001 | Priority P0 | Episodes E01, E08

**Function:** MEMS magnetometer + integrated Rogowski coil detects GIC magnitude on any conductor and provides progressive audio/visual alarm at 5A, 50A, and 100A per phase thresholds. Alerts homeowners and utility operators to active geomagnetic disturbance before equipment damage occurs.

| Parameter | Home Version | Substation Version |
|-----------|-------------|-------------------|
| GIC detection range | 0.5–200A | 1–2,000A |
| Rogowski coil aperture | 25mm (clamp-on) | 150mm (split-core) |
| Magnetometer | MEMS 3-axis, ±8 Gauss | MEMS 3-axis, ±16 Gauss |
| Alarm thresholds | 5A/20A/50A | 50A/200A/1,000A |
| Alarm type | LED (green/amber/red) + 85dB buzzer | Industrial beacon + dry contact relay |
| Display | OLED, real-time current | 7-segment LED, 4-digit |
| Communication | FEATHER LoRa mesh node | FEATHER LoRa + Modbus RTU |
| Power | 2× AA lithium (2yr life) | 24V DC (substation battery) |
| Enclosure | BFRP, IP65 | BFRP + MXene shield, IP67 |
| Mounting | Magnetic clamp to panel | DIN rail + conduit |
| Unit cost | $340 | $1,850 |

## INSTALLATION
- **Home:** Clamp Rogowski coil around main service entrance conductor (200A panel). Magnetic-mount sensor to panel door. Audible alarm inside living space.
- **Substation:** Split-core Rogowski around transformer neutral. Sensor on DIN rail in control house. Relay output to SCADA.
- **FEATHER mesh:** Both versions auto-join nearest FEATHER node. Data transmitted: GIC magnitude, timestamp, GPS location, alarm state.

## GIC THRESHOLD RATIONALE
- **5A:** Minor GMD event (Kp 5-6). Advisory only. No expected equipment damage.
- **50A:** Moderate GMD (Kp 7-8). Half-cycle saturation possible in distribution transformers. Action: notify utility, reduce load.
- **100A+:** Severe GMD (Kp 9). Transformer heating within minutes. Action: disconnect from grid if equipped with GIC blocker (P0-03), otherwise shutdown sequence.
