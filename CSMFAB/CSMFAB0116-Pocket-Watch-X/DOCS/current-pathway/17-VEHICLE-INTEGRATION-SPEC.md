# CSMFAB0116-17 — POCKET WATCH X: VEHICLE INTEGRATION SPECIFICATION
## 1. PURPOSE
Vehicle integration allows the Pocket Watch X to interface with automotive systems for navigation, diagnostics, media, and vehicle control.

## 2. VEHICLE DOCK
| Parameter | Value |
|-----------|-------|
| Form factor | ISO 7736 (DIN) compliant, 1-DIN slot |
| Watch slot | Front-facing, magnetic alignment |
| Connectivity to vehicle | CAN FD (2 channels), LIN 2.2, OBD-II |
| Connectivity to watch | Side divot connector + BT |
| Power | Vehicle 12V (ISO 7637-2 protected) |
| Power to watch | 15W (Qi2 MPP) |
| Audio integration | Analog aux + BT A2DP to vehicle audio system |
| Microphone | Built-in MEMS mic for voice commands |

## 3. CAN BUS INTERFACE
| Parameter | Value |
|-----------|-------|
| Protocol | CAN 2.0B (11/29-bit IDs) and CAN FD |
| Speed | Up to 5 Mbps (CAN FD), 1 Mbps (CAN 2.0B) |
| Channels | 2 (HS-CAN + MS-CAN or Powertrain + Body) |
| Isolation | Galvanic (ISO 11898-2 compliant transceiver) |
| OBD-II | Automatic PID polling via standard PIDs |
| DTC reading | ISO 15765-4 (CAN TP) |

## 4. DISPLAY MIRRORING
| Parameter | Value |
|-----------|-------|
| Connection | DP 2.1 via divot → vehicle display input |
| Resolutions supported | 1920×720 (ultrawide dash), 1280×720, 1920×1080 |
| Touch passthrough | If vehicle display supports touch, watch receives input |
| Steering wheel controls | CAN messages mapped to media/nav actions |
| Voice assistant | Watch mic + vehicle mic for navigation commands |

## 5. SAFETY FEATURES
- Watch locks certain functions when vehicle is in motion (per CAN speed signal).
- Driving Mode UI: simplified, large-touch-target, voice-primary interface.
- Emergency: watch detects crash via accelerometer, can auto-dial emergency via cellular case back.

## 6. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| CAN bus | Vector CANalyzer | 0% error frames at 5 Mbps |
| OBD-II | Connect to reference ECU | All standard PIDs readable |
| Power protection | ISO 7637-2 test pulses | No damage, no reset |
| Display mirroring | Connect to automotive display | 60 fps, no frame drops |
| Temperature | -30 to +85°C in vehicle cabin | Functional across range |

