# CSMFAB000000000223 — DRONE-X Cellular BVLOS Telemetry and Command Link
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Communication & Regulatory Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — 4G/5G C2 link, WebRTC cloud relay, Part 107 BVLOS waiver compliance framework |

---

## 1. BVLOS Communication Architecture

Beyond Visual Line of Sight (BVLOS) operations use the phone's cellular data connection (4G LTE / 5G NR) as the primary Command and Control (C2) link, with LoRa mesh (CSMFAB-220) as a secondary redundant link.

```
Drone (Phone) ←→ [4G/5G Cell Tower] ←→ [Cloud Relay Server] ←→ [Pilot Phone/GCS 4G/5G]
                ←→ [LoRa 915 MHz → Mesh → Ground Station LoRa] (redundant)
```

| Link | Protocol | Latency (typical) | Throughput | Reliability |
|------|----------|-------------------|------------|-------------|
| Primary: 4G LTE | WebRTC (UDP) over cellular | 50–80 ms RTT | 5–20 Mbps | 99.5% (urban) |
| Primary: 5G NR | WebRTC (UDP) over cellular | 15–30 ms RTT | 50–200 Mbps | 99.9% (urban) |
| Secondary: LoRa | Custom serial over mesh | 80–200 ms | 0.5–5 kbps | 99.9% (within range) |
| Tertiary: Onboard | Autonomous RTL via MCU | 0 ms (local) | — | 100% (always available) |

## 2. WebRTC Cloud Relay

A cloud-hosted WebRTC Selective Forwarding Unit (SFU) relays video, telemetry, and commands between drone and pilot:

| Parameter | Value |
|-----------|-------|
| SFU server | AWS EC2 t3.medium (us-east-1, multi-region fallback) |
| WebRTC stack | Pion (Go) — open-source SFU |
| Signaling | WebSocket (WSS) with TLS 1.3 |
| ICE/STUN/TURN | coturn server (3478/tcp+udp, 5349/tls) |
| Video codec | H.264 (baseline, 720p @ 30fps, 2 Mbps) |
| Audio codec | Opus (32 kbps, for engine sound monitoring) |
| Data channel | SCTP over DTLS — telemetry (50 Hz), commands (10 Hz) |
| Encryption | DTLS-SRTP (mandatory, per WebRTC spec) |
| Authentication | JWT token issued by GCS, validated by SFU |

## 3. C2 Link Budget

| Command/Data Stream | Rate | Bandwidth | Latency Tolerance |
|--------------------|------|-----------|-------------------|
| Flight commands (basic) | 10 Hz | 5 kbps | < 200 ms |
| Flight commands (high-rate) | 50 Hz | 25 kbps | < 100 ms |
| Telemetry downlink | 20 Hz | 40 kbps | < 500 ms |
| Video (480p, H.264) | 25 fps | 1 Mbps | < 300 ms |
| Video (720p, H.264) | 30 fps | 2 Mbps | < 300 ms |
| Audio (engine) | 44.1 kHz mono | 32 kbps | < 500 ms |

Total uplink: ~30 kbps. Total downlink: ~2.1 Mbps (with 720p video).

## 4. Part 107 BVLOS Waiver Compliance

The DRONE-X cellular BVLOS architecture supports the evidentiary requirements for a FAA Part 107 BVLOS waiver (Section 107.31 waiver application):

| FAA Requirement | DRONE-X Implementation |
|----------------|----------------------|
| C2 link reliability | Dual-link (cellular + LoRa) with automatic failover |
| Detect and Avoid (DAA) | CV obstacle avoidance (CSMFAB-216, 219) + ADS-B In (via FlightAware API on phone) |
| Lost link procedure | Auto-RTL within 2 s of link loss, independent MCU failsafe |
| Airspace awareness | LAANC integration via FAA UAS Data Exchange |
| Remote ID | Phone GPS broadcasts position via cellular (meets ASTM F3411-22a Network Remote ID) |
| Operational risk assessment | SORA (Specific Operations Risk Assessment) generated per mission |
| Pilot qualification | Part 107 certificate + DRONE-X BVLOS endorsement (CSMFAB-229) |

## 5. Cellular Coverage Requirements

| Parameter | 4G LTE Minimum | 5G NR Recommended |
|-----------|---------------|-------------------|
| RSRP (Reference Signal Received Power) | > -110 dBm | > -115 dBm |
| RSRQ (Reference Signal Received Quality) | > -15 dB | > -18 dB |
| SINR (Signal to Interference + Noise) | > 0 dB | > -3 dB |
| Handover time | < 100 ms | < 50 ms |

The app monitors cellular signal quality in real time. If RSRP drops below -115 dBm for > 5 seconds, the drone automatically reduces cruise speed to 5 m/s and climbs to 50 m to improve signal. If coverage is lost entirely, the onboard RTL triggers.

## 6. Security Model

| Layer | Mechanism |
|-------|-----------|
| WebRTC signaling | WSS + JWT + API key |
| DTLS-SRTP | Mandatory encryption for media and data |
| Command authentication | HMAC-SHA256 on all C2 messages, per-session key |
| SFU isolation | Single-tenant SFU per flight (no cross-flight data mixing) |
| Cloud infrastructure | VPC with security groups, IAM roles, CloudTrail logging |
| SIM security | Phone carrier-grade SIM with PIN lock |

---

*"The line of sight is a legal boundary, not a technological one. Cross it only with redundant links and an impeccable safety case."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon FAA regulation change
- Distribution: Engineering Team, Regulatory Compliance, BVLOS Operations
- Next Scheduled Review: July 2027
- Status: APPROVED — BVLOS Operations Baseline
