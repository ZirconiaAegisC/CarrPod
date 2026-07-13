# CSMFAB0116-44 — DIAGNOSTIC SERVICE MODE
## 1. ENTRY METHODS
| Method | Trigger |
|--------|---------|
| Key combination | Hold crown + tap display 5 times during boot |
| ADB command | adb reboot diagnostics |
| Factory test fixture | NFC tag on test station |
| Boot failure | Automatic entry after 3 failed boots |

## 2. DIAGNOSTIC SUITE
| Test | Duration | What It Tests |
|------|----------|---------------|
| DRAM test | 2s | Full memory address space (marching pattern) |
| Flash test | 5s | UFS block read/write/verify |
| Display test | 3s | RGB ramp, gray levels, uniformity |
| Touch test | 2s | Touch grid, edge detection |
| Audio test | 3s | Speaker sweep, mic loopback |
| Wireless test | 5s | WiFi connect, BT scan, GNSS fix |
| Fin slot test | 2s | Fin presence, enumeration, FDB read |
| Battery test | 10s | Capacity, internal resistance, cycle count |
| Thermal test | 30s | Heat to throttle, verify cooling |
| Sensor test | 2s | All sensors report valid data |
| Button/crown test | 1s | User presses each, verify detection |
| IP68 integrity | 5s | Pressure decay test |

## 3. LOG EXTRACTION
| Method | Data |
|--------|------|
| USB-C | Full syslog, dmesg, crash dumps |
| WiFi ADB | Wireless log pull |
| QR code on display | Encodes URL to upload compressed log package |

