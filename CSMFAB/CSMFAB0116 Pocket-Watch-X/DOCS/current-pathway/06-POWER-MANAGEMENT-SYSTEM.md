# CSMFAB0116-06 — POCKET WATCH X: POWER MANAGEMENT SYSTEM
**Revision:** A — 2026-07-10 | **Dependencies:** 01-CORE-SYSTEM-ARCHITECTURE

## 1. BATTERY SPECIFICATIONS
| Parameter | Value |
|-----------|-------|
| Chemistry | Li-Po (LiCoO₂ cathode, graphite anode) |
| Nominal voltage | 3.85V |
| Capacity | 1850 mAh |
| Energy | 7.12 Wh |
| Shape | Toroidal (ring), 46mm OD, 20mm ID, 4.5mm thick |
| Internal resistance | < 80 mΩ (fresh) |
| Cycle life | 500 cycles to 80% (0.5C charge, 1C discharge) |
| Charge temp | 0°C to 45°C |
| Discharge temp | -20°C to 60°C |
| Protection | PCM (over/under-voltage, over-current, short circuit) |
| Certification | UN38.3, IEC 62133, UL 2054 |

## 2. CHARGING SYSTEM
| Parameter | Value |
|-----------|-------|
| Charger IC | TI BQ25970 (or equivalent) |
| Charge topology | Switch-mode buck, 97% peak efficiency |
| Input voltage | 5-12V (USB or wireless) |
| Max charge current | 3A (1.62C) |
| Charge phases | Pre-charge, CC, CV, termination |
| Pre-charge current | 100 mA (< 3.0V) |
| CV voltage | 4.45V ± 0.5% |
| Termination current | 100 mA |
| Recharge threshold | 4.1V |
| Charge timer | 4 hours safety timeout |
| JEITA compliance | Yes (temp-based current reduction) |

## 3. WIRELESS CHARGING
| Parameter | Value |
|-----------|-------|
| Standard | Qi 2.0 (MPP – Magnetic Power Profile) |
| Coil type | Single-coil, toroidal, 40mm OD |
| Coil inductance | 12 µH |
| Operating frequency | 127.7 kHz |
| Max RX power | 15W |
| Alignment | Magnetic ring (NdFeB, N52, 2mm × 36 pcs) |
| Foreign object detection | Q-factor + power loss method |
| Efficiency | 72% (coil-to-battery, typical) |

## 4. POWER RAIL ARCHITECTURE
| Rail | Voltage | Source | Max Load | Notes |
|------|---------|--------|----------|-------|
| VSYS | 3.3-4.45V | Battery | System input | Unregulated |
| VMAIN | 3.3V | Buck from VSYS | 5A | Main peripherals |
| VCORE | 1.1V | Buck from VSYS | 4A | SoC core |
| VIO | 1.8V | Buck from VSYS | 2A | I/O |
| VDDR | 1.05V | Buck from VSYS | 3A | LPDDR5X |
| VANA | 2.8V | LDO from VMAIN | 500mA | Analog |
| VDIS | 12V | Boost from VSYS | 200mA | Display |
| VCHG | 5-12V | USB/Wireless | 3A | Charging input |

## 5. PMIC SELECTION
| Parameter | Value |
|-----------|-------|
| PMIC | Dialog DA9063-xx + DA9214 (or equivalent) |
| Buck converters | 6 integrated + 2 external |
| LDOs | 11 integrated |
| I²C interface | Standard mode (100 kHz) and Fast-mode (400 kHz) |
| OTP configuration | Factory-programmed startup sequence |
| Watchdog | Integrated (programmable 0.5-128s timeout) |
| RTC | Integrated with 32.768 kHz crystal |
| GPIO | 16 configurable |

## 6. POWER STATE MACHINE
| State | Description | SoC | Display | Fin 0/1 | Wireless |
|-------|-------------|-----|---------|---------|----------|
| ACTIVE | Full operation | 12W | On (720mW) | As needed | On |
| STANDBY | Display on, CPU clocked down | 2W | On (280mW) | Retention | On |
| DOZE | Display off, background tasks | 200mW | Off | Retention | DTIM3 |
| SLEEP | Deep sleep, wake on timer | 1mW | Off | Off | Off |
| HIBERNATE | RAM saved to flash | 12µW | Off | Off | Off |
| OFF | Battery protection only | 0.1µW | Off | Off | Off |

## 7. FUEL GAUGE
| Parameter | Value |
|-----------|-------|
| IC | Maxim MAX17055 (ModelGauge m5) |
| Accuracy | ±1% SOC (after learning) |
| Voltage measurement | ±7.5 mV |
| Current measurement | ±0.5 mA (with 10 mΩ sense) |
| Temperature | Internal + external thermistor |
| I²C address | 0x36 |
| Learning cycle | Auto-calibrates after one full charge |

## 8. THERMAL PROTECTION
| Threshold | Action |
|-----------|--------|
| Battery > 45°C | Reduce charge current to 0.5C |
| Battery > 50°C | Stop charging |
| Battery > 60°C | Emergency shutdown |
| Battery < 0°C | Pre-charge only (50 mA) |
| SoC junction > 95°C | Throttle CPU/GPU |
| SoC junction > 105°C | Emergency shutdown |
| PCB hot spot > 85°C | Reduce power budget |

## 9. BATTERY LIFETIME MANAGEMENT
| Feature | Description |
|---------|-------------|
| Charge limit | User-selectable 80% max (extends cycle life) |
| Adaptive charging | Learns user schedule, tops up before wake |
| Trickle charge | Maintains at 80% when docked long-term |
| Storage mode | Discharges to 50% if unused > 1 week |
| Health reporting | SoH, cycle count, manufacturing date |

## 10. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Capacity | 0.2C discharge from 4.45V to 3.0V | > 1800 mAh |
| Charge efficiency | Measure Vin×Iin vs. Vbat×Ibat | > 90% average |
| Sleep current | Precision ammeter | < 15 µA |
| Battery life (typical) | 50% brightness, mixed workload | > 24 hours |
| Battery life (AOD) | Always-on display mode | > 18 hours |
| Wireless charging | Qi2 MPP test tool | 15W received, < 40°C coil temp |
| Safety | Short battery terminals | PCM disconnects < 500 µs |
| Thermal | Charge at 45°C ambient, 1C | No thermal runaway |

