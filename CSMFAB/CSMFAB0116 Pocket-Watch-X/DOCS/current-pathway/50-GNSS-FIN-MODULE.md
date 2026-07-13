# CSMFAB0116-50 — GNSS FIN MODULE
## 1. RECEIVER SPECIFICATION
| Parameter | Value |
|-----------|-------|
| Chipset | u-blox M10 or Sony CXD5610 |
| Constellations | GPS (L1), GLONASS (L1), Galileo (E1), BeiDou (B1I) |
| L5 support | GPS L5, Galileo E5a (dual-band for ionospheric correction) |
| Channels | 72 acquisition |
| TTFF cold | < 25s |
| TTFF hot | < 1s |
| Accuracy (autonomous) | < 2.5m CEP |
| Accuracy (SBAS) | < 1.5m CEP |
| Sensitivity acquisition | -148 dBm |
| Sensitivity tracking | -165 dBm |
| Update rate | 1-10 Hz |
| Power (tracking) | 25 mW |
| Power (acquisition) | 80 mW |

## 2. DEAD RECKONING
When GNSS signal is lost, the fin uses IMU data (from Sensor Fin) for dead reckoning:
| Parameter | Value |
|-----------|-------|
| IMU source | Sensor Fin (13-SENSOR-FIN) |
| DR accuracy (1 min no GNSS) | < 10m error |
| DR accuracy (10 min no GNSS) | < 50m error |
| Wheel speed input | Via vehicle CAN (17-VEHICLE-INTEGRATION) |

## 3. ASSISTED GNSS
| Source | Method | TTFF Improvement |
|--------|--------|------------------|
| Cellular (case back) | SUPL 2.0 | Cold start < 5s |
| WiFi (Wireless Fin) | WiFi positioning | Hybrid accuracy < 5m |

