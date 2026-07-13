# CSMFAB0116-05 — POCKET WATCH X: EXTERNAL DIVOT CONNECTOR
**Revision:** A — 2026-07-10 | **Dependencies:** 01-CORE-SYSTEM-ARCHITECTURE

## 1. PURPOSE
The external divot array provides electrical connectivity between the Pocket Watch X core and external docking systems (cases, projectors, keyboards, vehicles, etc.).

## 2. MECHANICAL SPECIFICATION
| Parameter | Value |
|-----------|-------|
| Divot count (rear) | 40 pads |
| Divot count (side) | 24 pads |
| Pad diameter | 1.2 mm |
| Pad pitch | 2.0 mm |
| Pad material | Au-plated BeCu |
| Contact type | Pogo pin (dock side) |
| Mating cycles | 10,000 minimum |
| Spring force per pin | 0.6 N |
| Total insertion force | 38.4 N (rear), 14.4 N (side) |
| Wiping action | 0.3 mm lateral on insertion |

## 3. REAR DIVOT PINOUT (40 pads, circular arrangement)
| Pads | Signal | Description |
|------|--------|-------------|
| 1-4 | GND | Ground reference |
| 5-8 | VBUS | USB-C power (5-20V, 5A) |
| 9-12 | USB3_TX/RX | USB 3.2 Gen2 SuperSpeed |
| 13-14 | USB2_DP/DN | USB 2.0 data |
| 15-16 | CC1/CC2 | USB-C configuration channel |
| 17-20 | DP_AUX/LANE[2:0] | DisplayPort 2.1 (4 lanes) |
| 21-22 | SBU1/SBU2 | Sideband use (audio, debug) |
| 23-26 | GPIO[3:0] | General purpose I/O |
| 27-28 | I2C_SDA/SCL | Dock management bus |
| 29-30 | UART_TX/RX | Serial debug |
| 31-32 | DOCK_DETECT[1:0] | Dock type identification |
| 33-34 | VBAT | Battery passthrough (for charging dock) |
| 35-36 | SPKR+/SPKR- | Audio output to dock |
| 37-40 | GND | Ground return |

## 4. SIDE DIVOT PINOUT (24 pads, linear array)
| Pads | Signal | Description |
|------|--------|-------------|
| 1-4 | GND | Ground |
| 5-8 | VBUS | Power input |
| 9-10 | USB2_DP/DN | USB 2.0 |
| 11-14 | CAN_H/CAN_L | CAN FD bus (vehicle) |
| 15-16 | LIN | LIN bus (vehicle) |
| 17-18 | I2C_SDA/SCL | Accessory bus |
| 19-20 | DOCK_DETECT_SIDE[1:0] | Side dock ID |
| 21-24 | GND | Ground |

## 5. DOCK TYPE DETECTION
| DOCK_DETECT[1:0] | Dock Type |
|-------------------|-----------|
| 00 | No dock |
| 01 | Projector dock |
| 10 | Keyboard dock |
| 11 | Vehicle dock |

Side divot uses same encoding with DOCK_DETECT_SIDE pins.

## 6. USB4/TBT4 IMPLEMENTATION
| Parameter | Value |
|-----------|-------|
| Standard | USB4 Version 2.0 |
| Max speed | 40 Gbps (Gen3 ×2) |
| DisplayPort | DP 2.1 Alt Mode (UHBR20) |
| Power Delivery | PD 3.1 (EPR, up to 240W) |
| Device role | Dual-role (DRD) |
| Host mode | USB host for peripherals |
| Device mode | Mass storage, MTP, ADB |

## 7. DISPLAYPORT ALT MODE
| Parameter | Value |
|-----------|-------|
| DP standard | DP 2.1 |
| Max resolution | 7680×4320 @ 60 Hz (8K) |
| Max lanes | 4 (UHBR20) |
| HDR | HDR10, HLG, Dolby Vision passthrough |
| HDCP | HDCP 2.3 |
| MST | Multi-stream transport for dual displays |
| DSC | Display Stream Compression 1.2a |

## 8. POWER DELIVERY
| Parameter | Value |
|-----------|-------|
| PD standard | USB PD 3.1 |
| Sink mode | 5V/3A, 9V/3A, 15V/3A, 20V/5A (100W) |
| Source mode | 5V/3A (15W to accessories) |
| EPR support | 28V/5A, 36V/5A, 48V/5A (240W) |
| PPS support | 3.3-21V programmable |

## 9. ENVIRONMENTAL SEALING
| Parameter | Value |
|-----------|-------|
| Pad recess | 0.3 mm below surface |
| Pad surround | Silicone grommet (IP68) |
| Dock-side seal | O-ring (EPDM, 0.8 mm cross-section) |
| Mated IP rating | IP68 |
| Unmated IP rating | IP68 (pad recess + nano-coating prevents shorting) |
| Corrosion resistance | 96 hours salt spray (ASTM B117) |

## 10. ESD PROTECTION
| Parameter | Value |
|-----------|-------|
| ESD diodes | Per-pin TVS (5V working, 8V clamp) |
| IEC 61000-4-2 | ±8 kV contact, ±15 kV air |
| Clamping response | < 1 ns |
| Capacitance | < 0.5 pF per pin |

## 11. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Contact resistance | 4-wire Kelvin | < 50 mΩ per pin |
| Insertion cycle | 10,000 automated | < 100 mΩ end-of-life |
| USB4 eye | Compliance test | Pass USB4 Gen3 |
| DP link training | DP 2.1 test fixture | Train at UHBR20 |
| IP68 submersion | 2m, 30 min, powered | No ingress |
| ESD | Gun test per IEC | No reset, no data loss |
| Salt spray | 96 hr, then functional test | All pins functional |

