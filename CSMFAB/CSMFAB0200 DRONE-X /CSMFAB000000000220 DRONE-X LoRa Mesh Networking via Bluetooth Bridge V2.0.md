# CSMFAB000000000220 — DRONE-X LoRa Mesh Networking via Bluetooth Bridge
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Communication Systems Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — RFM95W SX1276, 915 MHz, 64-node mesh, swarm commands, 8 km range |

---

## 1. LoRa Module Specification

| Parameter | Value |
|-----------|-------|
| Module | RFM95W (HopeRF) |
| Transceiver | Semtech SX1276 |
| Frequency | 915 MHz (ISM band, Americas) / 868 MHz (EU) |
| Modulation | LoRa (spread spectrum CSS) |
| Bandwidth | 125 kHz (default), 250/500 kHz configurable |
| Spreading factor | SF7–SF12 |
| Coding rate | 4/5 (default) to 4/8 |
| Max TX power | +20 dBm (100 mW) |
| RX sensitivity | -148 dBm (SF12, 125 kHz) |
| Link budget | 168 dB |
| Range (LOS) | 8 km (SF10, 125 kHz, dipole antenna) |
| Range (urban) | 1.5–3 km |
| Data rate (SF7) | 5468 bps |
| Data rate (SF12) | 293 bps |
| Interface | SPI to STM32F103 MCU |
| Antenna | 915 MHz dipole, 2 dBi, SMA connector |
| Weight | 4.5 g (module only) |

## 2. Mesh Network Architecture

The DRONE-X LoRa mesh supports up to 64 nodes in an ad-hoc, self-healing topology using a lightweight distance-vector routing protocol:

| Mesh Parameter | Value |
|---------------|-------|
| Max nodes | 64 |
| Topology | Mesh (every node can relay) |
| Routing protocol | Simplified AODV (Ad-hoc On-Demand Distance Vector) |
| Max hops | 6 |
| TTL per packet | 8 |
| Heartbeat interval | 2 s |
| Route timeout | 30 s |
| Packet size (max) | 50 bytes (frame limited) |
| Encryption | AES-128 (pre-shared key per swarm session) |
| Node ID | 4 bytes (derived from MCU serial + random) |

## 3. Packet Frame Format

```
[PREAMBLE 8B] [SYNC 2B] [DEST_ID 4B] [SRC_ID 4B] [SEQ 2B] [TYPE 1B] [TTL 1B] [PAYLOAD 0-26B] [CRC16 2B]
```

| Packet Type | Description |
|-------------|-------------|
| 0x01 | SWARM_CMD (formation, mission, leader election) |
| 0x02 | TELEMETRY (position, battery, status) |
| 0x03 | HEARTBEAT (node alive) |
| 0x04 | RELAY (forwarded packet) |
| 0x05 | ALERT (obstacle, battery critical, link lost) |
| 0x06 | ROUTE_REQ (route discovery) |
| 0x07 | ROUTE_REPLY (route response) |

## 4. Swarm Command Set via LoRa

| Command | Payload | Behavior |
|---------|---------|----------|
| FORMATION_GRID | rows, cols, spacing_m | Form grid formation |
| FORMATION_LINE | heading_deg, spacing_m | Line formation |
| FOLLOW_LEADER | leader_id, offset_x, offset_y, offset_z | Follow specified leader |
| MISSION_START | mission_id | All nodes start synchronized mission |
| MISSION_ABORT | reason_code | All nodes RTL immediately |
| LAND_ALL | None | All nodes land at current position |
| ORBIT | center_lat, center_lon, radius_m, alt_m | Orbit specified point |

Swarm commands (see CSMFAB-221 for full swarm protocol) are relayed through the mesh. The ground control station (phone app) transmits via Bluetooth to the local MCU bridge, which forwards via LoRa to the mesh.

## 5. LoRa ↔ Phone Bridge Architecture

```
Phone App → [USB-C/BT Serial] → STM32 MCU → [SPI] → RFM95W LoRa → Mesh
                                                                    ↓
Phone App ← [USB-C/BT Serial] ← STM32 MCU ← [SPI] ← RFM95W LoRa ← Mesh
```

The MCU buffers up to 16 outgoing and 16 incoming LoRa packets. The phone app polls for received packets at 10 Hz. Packets are acknowledged at the mesh layer — the MCU retries unacknowledged packets up to 3 times (at 500 ms intervals) before reporting delivery failure.

## 6. Coexistence with 2.4 GHz Systems

LoRa at 915 MHz is spectrally separated from the 2.4 GHz Bluetooth and Wi-Fi bands. However, care is taken with physical placement:

| Separation Requirement | Distance |
|------------------------|----------|
| LoRa antenna to BT antenna | ≥ 80 mm |
| LoRa antenna to GPS antenna | ≥ 120 mm |
| LoRa antenna to ESC/motor wiring | ≥ 50 mm |
| LoRa antenna polarization | Vertical (matching ground station) |

---

*"One drone is a scout. Sixty-four is a network. The only difference is a protocol."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Communication Systems Team
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
