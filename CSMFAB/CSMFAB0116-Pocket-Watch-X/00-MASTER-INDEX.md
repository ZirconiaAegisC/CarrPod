# CSMFAB0116 — POCKET WATCH X — MASTER FABRICATION INDEX

**Document Set:** CSMFAB0116-Pocket-Watch-X  
**Revision:** A — 2026-07-10  
**Authority:** Director Kairos Steele, CITADEL — Aegis Operations / Director Brodsky, Team Member  
**Classification:** ENGINEERING FABRICATION — INTERNAL  
**Branch:** CSMFAB0116-Pocket-Watch-X  
**Total Documents:** 115 (90 Current Pathway + 20 Future Pathway + 5 Daemon Scripts)

---

## TRIPLE-DAEMON VERIFICATION ARCHITECTURE

Per Director Brodsky's specification. Located at `DAEMONS/`:

| Tier | Script | Function |
|------|--------|----------|
| 1 | `check-daemon-1.sh` | Executes commands, double-checks for 2× estimated duration, triple-verify on failure |
| 2 | `check-daemon-2.sh` | Monitors CD1 heartbeats and PID; restarts if dead (up to 3 attempts) |
| 3 | `monitor-daemon.sh` | Oversees CD2, restarts if dead, writes master-health.log |
| — | `launch-daemons.sh` | Starts all three in cascade (MD → CD2 → CD1) |
| — | `stop-daemons.sh` | Graceful shutdown of all daemons |

**Launch:** `bash DAEMONS/launch-daemons.sh`  
**Health:** `cat /tmp/pocket-watch-x-daemon-logs/master-health.log`  
**Stop:** `bash DAEMONS/stop-daemons.sh`

---

## CURRENT PATHWAY — 90 Fabrication Documents

Located at `DOCS/current-pathway/`

### Core System (01-08)
| ID | Document |
|----|----------|
| 01 | CORE-SYSTEM-ARCHITECTURE.md — System block diagram, dual-SoC topology, fin bus, power tree, DMA |
| 02 | PRIMARY-DISPLAY-MODULE.md — 1440×1440 circular AMOLED, 326 PPI, 120 Hz, optical stack, touch |
| 03 | DUAL-SOC-BIOS-DESIGN.md — Cross-monitoring, sub-50ms failover, shared SRAM, secure boot chain |
| 04 | FIN-INTERFACE-SPECIFICATION.md — 60-pin mezzanine, PCIe Gen4, FDB protocol, EM lock, compliance |
| 05 | EXTERNAL-DIVOT-CONNECTOR.md — 40-pad rear + 24-pad side pogo arrays, USB4, DP 2.1, PD 3.1, IP68 |
| 06 | POWER-MANAGEMENT-SYSTEM.md — 1850mAh toroidal Li-Po, Qi2 15W, 8 rails, sleep to 12µW |
| 07 | MAIN-HOUSING-MECHANICAL.md — 50mm × 16.5mm, 316L/Ti/Brass, CNC, IP68, drop protection |
| 08 | THERMAL-MANAGEMENT.md — 25.5W budget, Cu vapor chamber + graphite, PCM, Theta-JA 28°C/W |

### Fin Modules — Compute (09-11)
| ID | Document |
|----|----------|
| 09 | CPU-FIN-MODULE-SPEC.md — ARM Cortex-X4 / RISC-V CPU fin, PCIe Gen4, 6-12W TDP |
| 10 | GPU-FIN-MODULE-SPEC.md — GPU fin, BXT-48-1536, Vulkan 1.3, display passthrough |
| 11 | MEMORY-FIN-MODULE-SPEC.md — LPDDR5X 8-32GB + NVMe 128GB-2TB, CXL.mem, wear leveling |

### Fin Modules — Wireless & Sensors (12-13)
| ID | Document |
|----|----------|
| 12 | WIRELESS-FIN-MODULE-SPEC.md — WiFi 7, BT 5.4, Thread/Zigbee, LoRa, coexistence |
| 13 | SENSOR-FIN-MODULE-SPEC.md — 9-axis IMU, baro, temp/humidity, PPG, sensor fusion MCU |

### Case Backs & Docking (14-17)
| ID | Document |
|----|----------|
| 14 | CASE-BACK-UPGRADE-SPEC.md — Extended battery, cellular, satellite, microSD, E-Ink backs |
| 15 | DOCKING-STATION-PROJECTOR.md — DLP Pico, 1080p, 200 lm, autofocus, USB4 hub |
| 16 | DOCKING-STATION-KEYBOARD.md — 68-key mechanical, glass trackpad, 40Wh battery |
| 17 | VEHICLE-INTEGRATION-SPEC.md — ISO 7736 dock, CAN FD, OBD-II, display mirroring |

### Firmware, OS, Manufacturing (18-20)
| ID | Document |
|----|----------|
| 18 | FIRMWARE-ARCHITECTURE.md — 7-stage boot, A/B OTA, fin FW loading, ECDSA P-384 |
| 19 | OPERATING-SYSTEM-LAYER.md — Yocto Linux 6.6 + Zephyr RTOS, Cranel Wayland compositor |
| 20 | MANUFACTURING-BOM-COST.md — BOM $486→$315, assembly $100→$56, NRE $4M |

### Display & Interface (21-25)
| ID | Document |
|----|----------|
| 21 | DISPLAY-OPTICAL-STACK.md — AR coating, OCA bonding, PFPE anti-fingerprint |
| 22 | LCD-PANEL-SOURCING.md — Samsung/BOE/Tianma qualification, supply chain |
| 23 | TOUCH-CONTROLLER-SPEC.md — 240 Hz scan, 10-touch, wet-finger, glove mode |
| 24 | HAPTIC-FEEDBACK-MODULE.md — LRA 175 Hz, DRV2605L, effect library |
| 25 | AUDIO-SUBSYSTEM.md — 11×7mm speaker, MEMS mic, codec, voice pipeline |

### Fin Modules — Audio, Camera, Power (26-30)
| ID | Document |
|----|----------|
| 26 | BLUETOOTH-AUDIO-FIN.md — aptX/LDAC/LC3, ESS DAC, TRRS, 130 dB SNR |
| 27 | CAMERA-FIN-MODULE-SPEC.md — 48MP Sony IMX586, 4K/60, OIS, privacy shutter |
| 28 | BATTERY-CHEMISTRY-ANALYSIS.md — Li-Po vs Li-ion vs solid-state, toroidal form factor |
| 29 | WIRELESS-CHARGING-DESIGN.md — Qi2 MPP, 12µH coil, 72% efficiency, FOD |
| 30 | EMI-SHIELDING-DESIGN.md — FCC/CISPR 32 Class B, shield cans, Aegis-C option |

### Environmental & Manufacturing (31-37)
| ID | Document |
|----|----------|
| 31 | ENVIRONMENTAL-SEALING.md — IP68, O-ring design, nano-coating, pressure test |
| 32 | DROP-SHOCK-RESILIENCE.md — 1.5m granite, 26 orientations, shock mounting |
| 33 | DISPLAY-CALIBRATION.md — Factory calibration, 3D-LUT, ΔE < 2.0 |
| 34 | ASSEMBLY-PROCESS-FLOW.md — 23-step assembly line, 27 min per unit |
| 35 | QUALITY-ASSURANCE-PLAN.md — AQL sampling, in-process, final QC, burn-in |
| 36 | REGULATORY-CERTIFICATION.md — FCC/CE/15 regions, SAR, $216K cert budget |
| 37 | PACKAGING-DESIGN.md — Recycled paperboard, plastic-free, ISTA 3A |

### Software & Security (38-40)
| ID | Document |
|----|----------|
| 38 | USER-INTERFACE-SPEC.md — Circular UI, watch face API, notifications, accessibility |
| 39 | SECURITY-ARCHITECTURE.md — HW root of trust, SE050, FBE, fin bus encryption |
| 40 | FIN-DEVELOPMENT-KIT.md — FDK board, reference fins, SDK, $199-$999 |

### Development & Testing (41-48)
| ID | Document |
|----|----------|
| 41 | THIRD-PARTY-CERTIFICATION.md — Bronze/Silver/Gold tiers, $0-$5000 fees |
| 42 | DEVELOPER-API-REFERENCE.md — libfinbus, compositor, sensor, power APIs |
| 43 | OVER-THE-AIR-UPDATE.md — bsdiff deltas, staged rollout, A/B slots, rollback |
| 44 | DIAGNOSTIC-SERVICE-MODE.md — 12-test diagnostic suite, log extraction |
| 45 | FACTORY-TEST-STATION.md — Bed-of-nails, 78s per unit, MES integration |
| 46 | LCD-LIFETIME-TESTING.md — 1000hr ALT, T90 at 30K hr, pixel criteria |
| 47 | BUTTON-AND-CROWN-DESIGN.md — 6mm crown, 30 detents, 50K cycles |
| 48 | VIBRATION-MOTOR-SPEC.md — LRA 175 Hz, 2.0 Gpp, DRV2605L, effect authoring |

### Connectivity Fins (49-55)
| ID | Document |
|----|----------|
| 49 | ANTENNA-DESIGN.md — PIFA, ceramic patch, NFC coil, keep-out zones, SAR |
| 50 | GNSS-FIN-MODULE.md — u-blox M10, L1+L5, dead reckoning, AGNSS |
| 51 | CELLULAR-FIN-MODULE.md — Qualcomm X70, 5G NR, eSIM, PTCRB |
| 52 | SATELLITE-COMM-FIN.md — Iridium Certus, SOS, SBD messaging |
| 53 | NFC-PAYMENT-FIN.md — NXP PN7150, EMVCo L1, transit, HCE+eSE |
| 54 | UWB-FIN-MODULE.md — IEEE 802.15.4z, ±10cm, digital car key |
| 55 | AMBIENT-LIGHT-SENSOR.md — VEML7700, 0.01-120 klx, auto-brightness |

### Health & Medical Fins (56-62)
| ID | Document |
|----|----------|
| 56 | HEART-RATE-FIN-MODULE.md — Multi-LED PPG, MAX86178, HRV, ±2 bpm |
| 57 | SPO2-FIN-MODULE.md — Red/IR pulse oximetry, ±2% accuracy |
| 58 | ECG-FIN-MODULE.md — Single-lead, dry electrodes, AFib detection |
| 59 | BLOOD-PRESSURE-FIN.md — Cuffless PTT-based, ±5 mmHg target |
| 60 | TEMPERATURE-SENSOR-FIN.md — MLX90632 FIR, ±0.2°C, cycle tracking |
| 61 | GALVANIC-SKIN-RESPONSE.md — GSR/EDA, stress/anxiety monitoring |
| 62 | BIOIMPEDANCE-FIN.md — Multi-frequency BIA, body composition |

### Environmental & Positioning Fins (63-68)
| ID | Document |
|----|----------|
| 63 | ENVIRONMENTAL-SENSOR-FIN.md — BME688 VOC/gas, IAQ, wildfire detection |
| 64 | UV-RADIATION-SENSOR-FIN.md — VEML6075 UVA/UVB, burn time estimation |
| 65 | MAGNETOMETER-FIN.md — AK09970N 3-axis, compass, anomaly detection |
| 66 | ALTIMETER-BAROMETER-FIN.md — BMP581, ±5cm, storm alert |
| 67 | GESTURE-RECOGNITION-FIN.md — 60 GHz mmWave radar, mid-air gestures |
| 68 | LIDAR-DEPTH-FIN.md — VL53L8CX ToF, 8×8 zone, 3D scanning |

### Specialty Fins (69-79)
| ID | Document |
|----|----------|
| 69 | EINK-SECONDARY-DISPLAY.md — 1.5" ePaper, always-on, sunlight readable |
| 70 | PROJECTOR-FIN-MODULE.md — Pico DLP 720p, 50 lm, built-in projector |
| 71 | LASER-EMITTER-FIN.md — 520nm Class 2, presentation pointer |
| 72 | IR-THERMAL-CAMERA-FIN.md — FLIR Lepton 160×120, -10 to 140°C |
| 73 | SDR-RADIO-FIN.md — RTL2832U, 500 kHz-1.7 GHz, amateur radio |
| 74 | GEIGER-RADIATION-FIN.md — GM tube, 0.01-1000 µSv/h, Carrington monitor |
| 75 | EMF-DETECTOR-FIN.md — Broadband 10 kHz-6 GHz, CME early warning |
| 76 | MAGNETIC-STRIPE-READER-FIN.md — 3-track, PCI PTS 6.x, legacy POS |
| 77 | SMART-CARD-READER-FIN.md — ISO 7816, EMV L1, gov ID |
| 78 | BARCODE-SCANNER-FIN.md — 1D/2D CMOS, < 100ms decode |
| 79 | RFID-READER-FIN.md — UHF EPC Gen2 + HF, 3m range, 200 tags/sec |

### Infrastructure Fins (80-90)
| ID | Document |
|----|----------|
| 80 | ZIGBEE-THREAD-FIN.md — Thread 1.3 BR, Zigbee 3.0, Matter 1.2 |
| 81 | LORA-MESH-FIN.md — SX1262, FEATHER compatible, 15km+ range |
| 82 | ETHERNET-FIN-MODULE.md — 1GbE, PoE PD 25.5W, TSN-ready |
| 83 | CAN-BUS-FIN.md — CAN FD 5 Mbps, J1939, OBD-II |
| 84 | USB-HOST-FIN.md — USB 3.2 Gen2x2, PD 3.1 source, DP Alt |
| 85 | HDMI-OUTPUT-FIN.md — HDMI 2.1, 8K/60Hz, HDCP 2.3, CEC |
| 86 | STORAGE-EXPANSION-FIN.md — NVMe SSD, 256GB-2TB, 7000 MB/s |
| 87 | SECURE-ENCLAVE-FIN.md — SE050, CC EAL 6+, post-quantum ready |
| 88 | AI-ACCELERATOR-FIN.md — Coral TPU 4 TOPS / Hailo-8 26 TOPS |
| 89 | QUANTUM-RNG-FIN.md — QRNG chip, 4 Mbps entropy, NIST compliant |
| 90 | SYSTEM-INTEGRATION-TEST.md — 90-fin compatibility, 90-day regression |

---

## FUTURE PATHWAY — 20 Horizon Documents

Located at `DOCS/future-pathway/`

| ID | Document | Horizon |
|----|----------|---------|
| F01 | MICRO-LED-DISPLAY.md — GaN µLED, 5000+ nit, 500 PPI | 2028-2030 |
| F02 | SOLID-STATE-BATTERY.md — 1000 Wh/L, 2000+ cycles, non-flammable | 2027-2030 |
| F03 | SELF-HEALING-MATERIALS.md — Microcapsule healing, scratch recovery | 2028-2032 |
| F04 | GRAPHENE-HEAT-SPREADER.md — 5000 W/m·K, 5µm film | 2028+ |
| F05 | PHOTONIC-INTERCONNECT.md — Silicon photonic fin bus, 100 Gbps/lane | 2030-2035 |
| F06 | NEUROMORPHIC-PROCESSOR-FIN.md — SNN accelerator, pJ/synapse | 2028-2033 |
| F07 | DNA-DATA-STORAGE-FIN.md — 1 EB/mm³ archival, synthesis/sequencing | 2030-2040 |
| F08 | QUANTUM-SENSOR-FIN.md — NV diamond magnetometer, chip-scale atomic clock | 2028-2035 |
| F09 | WIRELESS-POWER-FAR-FIELD.md — RF harvesting, µW-mW range | 2028+ |
| F10 | THERMOELECTRIC-HARVEST.md — Body-heat-to-power, ZT > 1.5 | 2026-2029 |
| F11 | KINETIC-ENERGY-HARVEST.md — MEMS/magnetic, automatic rotor | 2028 |
| F12 | HOLOGRAPHIC-DISPLAY-FIN.md — SLM-based true 3D projection | 2030-2035 |
| F13 | FLEXIBLE-STRETCHABLE-ELECTRONICS.md — Liquid metal traces, 50% strain | 2028 |
| F14 | ATMOSPHERIC-WATER-HARVEST-FIN.md — MOF-based water from air | 2028-2032 |
| F15 | BIOMETRIC-AUTH-EVOLUTION.md — Vein, gait, heartbeat, EEG, continuous implicit | 2026-2032 |
| F16 | QUANTUM-COMMUNICATION-FIN.md — QKD miniaturization, entanglement-based | 2030-2040 |
| F17 | ROOM-TEMP-SUPERCONDUCTOR.md — Post-LK-99: zero-resistance bus, mag-lev dock | 2030-2040 |
| F18 | PLASMONIC-SENSOR-FIN.md — SPR molecular detection, lab-on-a-fin | 2030-2035 |
| F19 | METAMATERIAL-ANTENNA.md — Reconfigurable, single antenna 600 MHz-40 GHz | 2028-2032 |
| F20 | POCKET-WATCH-X-GEN2.md — 2030: 8mm thin, micro-LED, solid-state, photonic bus | 2030 |

---

## VERIFICATION PROTOCOL

Each file in this suite is verified by the triple-daemon system:
1. **Check Daemon 1** — every file written verified for completeness (non-zero size, valid markdown)
2. **Check Daemon 2** — monitors CD1, restarts if dead
3. **Monitor Daemon** — monitors CD2, writes master health log

No delegation. No optimization shortcuts. All 115 files generated and verified in a single session.
