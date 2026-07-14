# CSMFAB0116-14 — POCKET WATCH X: CASE BACK UPGRADE SPECIFICATION
**Revision:** A | **Dependencies:** 07-MAIN-HOUSING-MECHANICAL, 05-EXTERNAL-DIVOT-CONNECTOR

## 1. PURPOSE
The Case Back is a replaceable rear cover that adds functionality beyond the standard threaded metal cover. It connects via the rear divot array.

## 2. STANDARD CASE BACK (INCLUDED)
| Parameter | Value |
|-----------|-------|
| Material | Matches housing choice (316L/Ti/Brass) |
| Thread | M48 × 0.5mm, 8-start |
| Thickness | 2.5 mm |
| Weight | 15 g (steel) |
| Features | O-ring groove, tool slots, engraved logo |
| IP rating | IP68 (with O-ring) |

## 3. EXTENDED BATTERY CASE BACK
| Parameter | Value |
|-----------|-------|
| Additional battery | 1200 mAh toroidal Li-Po |
| Total capacity (with internal) | 3050 mAh |
| Battery life extension | +60% (from 24h to ~38h typical) |
| Thickness added | +3.5 mm (total device 20.0 mm) |
| Charging | Charges alongside internal battery |
| Fuel gauge | Integrated with main PMIC |
| Weight added | +18 g |
| Price adder | +$79 |

## 4. CELLULAR MODEM CASE BACK
| Parameter | Value |
|-----------|-------|
| Modem | Qualcomm X70 (5G NR) |
| Bands | sub-6 GHz (n1-n106), mmWave (n257-n263) |
| SIM | eSIM (GSMA SGP.22), optional nano-SIM slot |
| Max speed | 10 Gbps DL, 3.5 Gbps UL (5G) |
| Antenna | Integrated PIFA array in case back |
| GNSS | GPS/GLONASS/Galileo/BeiDou (integrated with modem) |
| Power | 2.5 W (5G active), 50 mW (LTE idle) |
| Thickness added | +3.0 mm (total 19.5 mm) |
| Weight added | +22 g |
| Certifications | PTCRB, GCF, carrier-specific |
| Price adder | +$149 |

## 5. SATELLITE MESSAGING CASE BACK
| Parameter | Value |
|-----------|-------|
| Constellation | Iridium Certus (L-band) |
| Services | SOS, SMS-like messaging, location sharing |
| Antenna | Ceramic patch antenna in case back |
| Power (TX burst) | 3.0 W peak, 50 mW average idle |
| Message latency | 5-30 seconds |
| Coverage | Global (pole-to-pole) |
| Thickness added | +3.5 mm (total 20.0 mm) |
| Weight added | +25 g |
| Subscription | Iridium service required ($15-50/month) |
| Price adder | +$199 |

## 6. MICROSD CASE BACK
| Parameter | Value |
|-----------|-------|
| Card slot | microSDXC (up to 2 TB) |
| Interface | SD 3.0 (UHS-I, 104 MB/s) |
| Features | Push-push mechanism, spring-loaded dust cover |
| Use case | Media storage, data logging, backup |
| Thickness added | +1.5 mm (total 18.0 mm) |
| Weight added | +5 g |
| Price adder | +$29 |

## 7. E-INK SECONDARY DISPLAY CASE BACK
| Parameter | Value |
|-----------|-------|
| Display | E-Ink Carta 1300, 1.5" circular |
| Resolution | 240 × 240 |
| DPI | 226 PPI |
| Features | Always-on, sunlight readable |
| Content | Time, notifications, compass, weather, custom image |
| Update speed | 350 ms (full), 120 ms (partial) |
| Power | 0 W static, 10 mW during refresh |
| Thickness added | +2.0 mm (total 18.5 mm) |
| Weight added | +8 g |
| Price adder | +$69 |

## 8. MECHANICAL INTERFACE
All case backs use the same M48 × 0.5mm threaded interface and connect electrically via 4 rear divot pads:
- VBAT (battery connection)
- I²C_SDA/SCL (management bus)
- DOCK_DETECT (case back type identification)

## 9. CASE BACK DETECTION
The main SoC reads the I²C bus on case back attachment:
1. Case back EEPROM provides type, serial number, and capability flags.
2. Main SoC loads appropriate driver.
3. If case back requires additional battery capacity, fuel gauge re-learns total pack.
4. Cellular/satellite case backs register as network interfaces.
5. E-Ink case back registers as secondary display.

## 10. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Thread engagement | Go/No-Go gauge | 4+ turns engagement |
| IP68 seal | 2m, 30 min with case back installed | No ingress |
| Electrical contact | 4-wire measurement | < 100 mΩ per pad |
| Case back swap | 1000 cycles | No thread wear, seal intact |
| Cellular RX sensitivity | Call box | < -100 dBm (LTE B13) |
| Satellite TX | Anechoic chamber with sim | TX power within 1 dB of spec |

