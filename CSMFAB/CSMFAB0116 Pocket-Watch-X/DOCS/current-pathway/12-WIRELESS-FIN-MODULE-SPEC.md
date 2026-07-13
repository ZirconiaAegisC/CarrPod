# CSMFAB0116-12 — POCKET WATCH X: WIRELESS FIN MODULE SPECIFICATION
**Revision:** A | **Dependencies:** 04-FIN-INTERFACE-SPECIFICATION

## 1. PURPOSE
The Wireless Fin provides radio connectivity: WiFi, Bluetooth, Thread, Zigbee, and optionally LoRa.

## 2. WIFI
| Parameter | Value |
|-----------|-------|
| Standard | WiFi 7 (802.11be) with WiFi 6E fallback |
| Bands | 2.4 GHz, 5 GHz, 6 GHz |
| Channel bandwidth | 20/40/80/160/320 MHz |
| MIMO | 2×2 MU-MIMO |
| Modulation | 4096-QAM (WiFi 7), 1024-QAM (WiFi 6) |
| Max PHY rate | 5.8 Gbps (320 MHz, 4096-QAM, 2×2) |
| Features | OFDMA, TWT, BSS coloring, MLO |
| Security | WPA3-Personal/Enterprise, OWE |
| Power (TX) | 1.2 W at +20 dBm |
| Power (RX) | 0.4 W |
| Power (idle) | 10 mW (DTIM-10) |
| Sensitivity | -72 dBm at MCS 13 (4096-QAM) |

## 3. BLUETOOTH
| Parameter | Value |
|-----------|-------|
| Standard | Bluetooth 5.4 |
| Features | LE Audio, Auracast, Channel Sounding, PAwR |
| PHYs | LE 1M, LE 2M, LE Coded (S=2, S=8) |
| Audio | LC3 codec, multi-stream |
| Profiles | A2DP, HFP, HID, BLE Mesh |
| Max throughput | 2 Mbps (LE 2M) |
| Range | 200m line-of-sight (LE Coded S=8) |
| Coexistence | Shared antenna with WiFi (PTA arbitration) |

## 4. THREAD / ZIGBEE
| Parameter | Value |
|-----------|-------|
| Standard | IEEE 802.15.4 |
| Frequency | 2.4 GHz (channel 11-26) |
| Protocols | Thread 1.3, Zigbee 3.0, Matter 1.2 |
| Role | Router / End Device / Border Router |
| Mesh | Self-healing, up to 250 nodes |
| Range | 100m indoor (typical) |
| Power | 50 mW (TX), 20 mW (RX) |

## 5. LORA (OPTIONAL)
| Parameter | Value |
|-----------|-------|
| Chipset | Semtech SX1262 or equivalent |
| Frequency | 863-928 MHz (regional) |
| Protocol | LoRaWAN 1.1, point-to-point LoRa |
| Spreading factor | SF7-SF12 |
| Bandwidth | 125/250/500 kHz |
| Max link budget | 170 dB |
| Range | 15 km+ line-of-sight |
| Power | 100 mW at +22 dBm |
| Integration | Compatible with CSMFAB0115 FEATHER mesh nodes |

## 6. ANTENNA INTEGRATION
| Parameter | Value |
|-----------|-------|
| WiFi/BT antenna | Shared PIFA on fin PCB edge |
| 802.15.4 antenna | Chip antenna (Johanson 2450AT18x100) |
| LoRa antenna | U.FL connector for external whip |
| Antenna keep-out | 5 mm from fin edge (all directions) |
| Impedance | 50 Ω |
| VSWR | < 2:1 across band |

## 7. COEXISTENCE
WiFi (2.4 GHz), BT, Thread/Zigbee all operate in the 2.4 GHz ISM band. Coexistence managed by:
1. Packet Traffic Arbitration (PTA): 3-wire interface between WiFi and BT PHYs
2. Time-slotting: WiFi gets priority in high-throughput mode, BT for audio streaming
3. Channel avoidance: Thread/Zigbee scans for WiFi channels and selects least-congested
4. Adaptive frequency hopping (AFH): BT hops away from WiFi channels in use

## 8. REGULATORY
| Region | WiFi | BT | LoRa |
|--------|------|----|------|
| FCC (US) | Part 15.247, 15.407 | Part 15.247 | Part 15.247 |
| CE (EU) | EN 300 328, EN 301 893 | EN 300 328 | EN 300 220 |
| MIC (JP) | ARIB STD-T66/T71 | ARIB STD-T66 | ARIB STD-T108 |
| SRRC (CN) | MIIT regulations | MIIT | MIIT |
| SAR limit | 1.6 W/kg (1g) / 2.0 W/kg (10g) | Same | — |

## 9. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| WiFi throughput | iPerf3, 1m from AP | > 3 Gbps (6 GHz, 320 MHz) |
| BT range | LE Coded S=8, open field | > 150m reliable |
| Coexistence | WiFi throughput + BT audio | Throughput drop < 10% |
| LoRa range | SF12, 125 kHz, urban | > 3 km |
| SAR | DASY6 system | Below FCC/CE limits |
| Spurious emissions | Spectrum analyzer | Within regulatory mask |

