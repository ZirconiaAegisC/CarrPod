# CSMFAB0116-45 — FACTORY TEST STATION DESIGN
## 1. TEST FIXTURE
| Component | Description |
|-----------|-------------|
| Bed-of-nails | Pogo pins for rear divot (40-pin) + side divot (24-pin) |
| NFC antenna | For factory mode trigger |
| RF coupling box | Shielded chamber for wireless test |
| Camera | Inspection camera for display visual test |
| Thermal camera | FLIR for thermal test |
| Audio coupler | Artificial ear + mouth for audio test |

## 2. AUTOMATED TEST SEQUENCE
| Step | Test | Time | Parallel? |
|------|------|------|-----------|
| 1 | DUT insertion, divot connection | 2s | — |
| 2 | Power-on, boot to diag mode | 5s | — |
| 3 | DRAM + flash test | 7s | — |
| 4 | Display + touch test | 5s | — |
| 5 | Audio test | 3s | — |
| 6 | Sensor test | 2s | — |
| 7 | Wireless test (RF chamber) | 5s | Yes (chamber shared) |
| 8 | Fin slot test | 2s | — |
| 9 | Battery test | 10s | — |
| 10 | Thermal test | 30s | — |
| 11 | Button/crown test | 1s | — |
| 12 | IP68 integrity | 5s | — |
| 13 | Result upload to MES | 1s | — |
| **TOTAL** | | **~78s per unit** | |

## 3. MES INTEGRATION
| Data | Format |
|------|--------|
| Serial number | Unique per unit |
| Test results | Pass/fail + measurements per test |
| Component tracking | Batch/lot numbers from SMT |
| Yield dashboard | Real-time, per station |

