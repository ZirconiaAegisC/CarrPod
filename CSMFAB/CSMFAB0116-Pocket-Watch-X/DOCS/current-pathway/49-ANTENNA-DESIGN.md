# CSMFAB0116-49 — ANTENNA DESIGN
## 1. INTERNAL ANTENNAS
| Antenna | Type | Bands | Location |
|---------|------|-------|----------|
| WiFi/BT | PIFA | 2.4-2.5 GHz, 5.15-5.85 GHz, 5.925-7.125 GHz | Top edge of PCB |
| GNSS | Ceramic patch | 1575.42 MHz (L1), 1176.45 MHz (L5) | Under display |
| NFC | Loop coil | 13.56 MHz | Wrapped around battery |
| 802.15.4 | Chip antenna | 2.405-2.480 GHz | Side of PCB |
| Cellular (case back) | PIFA array | 600 MHz — 6 GHz | In case back module |

## 2. ANTENNA KEEP-OUT ZONES
| Zone | Clearance |
|------|-----------|
| WiFi PIFA | 5 mm from metal in all directions |
| GNSS patch | 3 mm ground plane clearance |
| NFC coil | 2 mm from battery metal foil |
| All antennas | No copper fill in keep-out zones |

## 3. SAR COMPLIANCE
| Band | SAR Target (10g) | Limit |
|------|------------------|-------|
| 2.4 GHz WiFi | 0.8 W/kg | 2.0 W/kg |
| 5 GHz WiFi | 0.6 W/kg | 2.0 W/kg |
| BT | 0.2 W/kg | 2.0 W/kg |

