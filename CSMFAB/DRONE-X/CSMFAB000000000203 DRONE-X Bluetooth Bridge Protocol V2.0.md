# CSMFAB000000000203 — DRONE-X Bluetooth Bridge Protocol
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Communication Protocol Specification

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — HC-05 configuration, latency budget, USB/BT failover, security specification |

---

## 1. Bluetooth Module Configuration

The HC-05 (ZS-040) module operates as the fallback communication bridge when the USB-C OTG link is unavailable. Configured as a Bluetooth 2.0+EDR slave device, it provides a wireless serial bridge at 115200 baud.

| Parameter | Value |
|-----------|-------|
| Module | HC-05 ZS-040 |
| Bluetooth version | 2.0 + EDR |
| RF output | Class 2 (+4 dBm) |
| Range | 10 m open air |
| UART baud rate | 115200 (AT-factory: 38400) |
| UART config | 8N1, no flow control |
| AT command mode | EN pin HIGH at power-on |
| Device name | "DRONE-X-XXXX" (last 4 of MAC) |
| PIN code | 1234 (default), configurable via AT |
| Role | Slave |

**HC-05 AT Configuration Sequence:**
```
AT+NAME=DRONE-X-A3F2
AT+ROLE=0
AT+UART=115200,0,0
AT+PSWD=9731
AT+CMODE=0
AT+RESET
```

## 2. Latency Budget Comparison

| Metric | USB-C OTG (Primary) | Bluetooth HC-05 (Fallback) |
|--------|---------------------|----------------------------|
| Physical layer | USB 2.0 FS 12 Mbps | BT 2.0+EDR 2.1 Mbps |
| Effective throughput | 921600 bps | 115200 bps |
| Serialization delay (32B) | 0.28 ms | 2.22 ms |
| MCU processing | 0.5 ms | 0.5 ms |
| Link round-trip (avg) | 1.2 ms | 9.0 ms |
| Link round-trip (P99) | 3.0 ms | 22.0 ms |
| Flight control loop penalty | +3 ms | +9 ms (acceptable below 20 ms) |
| Jitter (std dev) | 0.4 ms | 3.5 ms |

USB-C is the primary link. Bluetooth engages automatically when USB CDC reports a disconnection for > 200 ms. Reconnection to USB reverts to the primary link without flight interruption.

## 3. Failover State Machine

```
State: USB_ACTIVE → [USB disconnect > 200ms] → BT_ACQUIRING
State: BT_ACQUIRING → [BT connect + 5x ping ACK] → BT_ACTIVE
State: BT_ACTIVE → [USB reconnect + 5x ping ACK] → USB_ACTIVE
State: BT_ACTIVE → [BT disconnect > 500ms] → LINK_LOST (trigger RTL)
State: LINK_LOST → [either link recovered] → re-arm required
```

Hysteresis prevents ping-pong failover: 5 successful consecutive pings at 50 ms intervals must be received before promoting a link.

## 4. Security Model

| Layer | Mechanism |
|-------|-----------|
| Bluetooth pairing | PIN authentication (4-digit, configurable) |
| Link encryption | BT 2.0 E0 stream cipher (128-bit equivalent) |
| Application authentication | SHA-256 HMAC on all command frames |
| Replay protection | 32-bit monotonic sequence counter per session |
| Session binding | Per-flight random session key derived from ECDH P-256 |
| Pairing mode | Manual — hold BT button on MCU board for 3 seconds |

The HMAC is computed over the entire serial frame (CMD + LEN + PAYLOAD) using a session key. Receipt of a frame with invalid HMAC triggers an increment of the intrusion counter and, after 5 consecutive failures, locks the link for 60 seconds.

## 5. Packet Throughput Budget

At 115200 baud with 8N1 (10 bits/byte), raw throughput is 11520 bytes/s. Accounting for framing overhead (5 bytes per 32-byte payload), effective application throughput is approximately 9980 bytes/s. This supports:

| Data Stream | Rate | Bytes/s |
|-------------|------|---------|
| Flight commands (phone→MCU) | 200 Hz | 1,400 |
| Telemetry (MCU→phone) | 50 Hz | 1,600 |
| LoRa mesh relay | 10 Hz avg | 800 |
| Heartbeat/ping | 10 Hz | 50 |
| **Total** | | **3,850** (33% utilization) |

---

*"Two paths double the chance of arrival — but only if the switch between them is seamless."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Software Development Team
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
