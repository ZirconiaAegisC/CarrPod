# CSMFAB000000000115 V1.0
## FEATHER-03: LoRa Mesh Radio & Communication Protocol Stack
### Version 1.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications
**Classification:** Communications Engineering Document

---

## 1. Radio Hardware — Semtech SX1262

| Parameter | Value |
|-----------|-------|
| Frequency bands | 868/915 MHz ISM |
| Modulation | LoRa (CSS), FSK, GFSK, MSK |
| TX power | +22 dBm (158 mW) |
| RX sensitivity | -148 dBm at SF12, BW 125 kHz |
| Link budget | 170 dB |
| Spreading factors | SF5 – SF12 |
| Data rate (LoRa) | 0.018 – 62.5 kbps |
| RX current | 4.6 mA |
| TX current | 118 mA at +22 dBm |
| Interface | SPI to ESP32-S3 |

### 1.1 Dielectric Resonator Antenna (DRA)

Mounted atop the Aegis-C ceramic shell — no internal antenna possible through SE ≥ 148 dB enclosure.
- Type: Cylindrical DRA, ZrO₂-SnO₂-TiO₂ ceramic puck, εᵣ=37
- Diameter 18 mm, height 12 mm
- Bandwidth: 902–928 MHz (VSWR ≤ 2.0)
- Gain: 4.1 dBi (broadside)
- Weather protection: PTFE radome, 1.5mm wall, IP67 sealed

**Why DRA:** No mechanical fatigue vs whip antennas. Solid-state. No metallic whip to act as lightning attractor.

### 1.2 RF Front-End Protection

Between SX1262 and antenna: ESD (Semtech RClamp0524P, ±15 kV), GIC blocking (Mini-Circuits TCBT-123+ bias tee, 100 nF DC-block at 500V), 902–928 MHz SAW bandpass filter (2.5 dB IL, 45 dB rejection), TX/RX switch (PE4259 SPDT, 0.35 dB IL).

## 2. MCU Platform — ESP32-S3

| Parameter | Value |
|-----------|-------|
| CPU | Xtensa LX7 dual-core, 240 MHz |
| SRAM | 512 KB |
| PSRAM | 8 MB (SPI octal) |
| Flash | 16 MB (SPI quad) |
| WiFi/BLE | WiFi disabled in production, BLE for local maintenance |
| Security | AES-256 keys stored in eFuse (non-extractable) |

## 3. Mesh Protocol — Meshtastic 2.x + Caltrans Extensions

### 3.1 Channel Allocation

| Channel | Purpose | Encryption |
|---------|---------|------------|
| CH0 PRIMARY | ITS/NTCIP telemetry | AES-256-CTR + HMAC-SHA256 |
| CH1 EMERGENCY | Inter-agency, 160-char text | Unencrypted (interoperability requirement) |
| CH2 DIAGNOSTIC | OTA updates, mesh topology, AB 2930 logs | AES-256-GCM |

### 3.2 Caltrans Extensions

**NTCIP/SNMPv3 Bridge:** ESP32-S3 runs lightweight SNMPv3 agent translating NTCIP 1202/1213 object definitions (phase status, detector occupancy, preemption state) into compressed mesh packets. Galvanically isolated RS-485-to-UART (ISO3082, 2.5 kV isolation).

**Priority Queuing:** Priority 7 (emergency alerts, ≤ 2.3s E2E), Priority 5 (signal preemption, ≤ 5.1s), Priority 3 (RWIS telemetry, ≤ 15s), Priority 0 (OTA updates, ≤ 4h overnight).

**CME Detection Trigger:** SX1262 RSSI noise floor monitoring. 3+ adjacent nodes report simultaneous noise floor increase > 3 dB above rolling 24h median → mesh broadcasts "EMP-CME-DETECT" priority-7 alert. Provides 15–45 minutes of warning before E3/GIC component arrives.

### 3.3 TDMA Frame Structure

Each channel uses 2-second TDMA superframe, 8 × 250 ms slots. Node slot assignment: hash of 8-byte Meshtastic ID mod 8. Per-slot capacity (SF11, BW 250 kHz): 137 bytes. 8-channel aggregate: 54.8 kbps theoretical, ~18.2 kbps usable.

## 4. Security Model

- Channel 0: AES-256-CTR + HMAC-SHA256, PSK rotated quarterly via OTA
- Channel 1: Unencrypted, authentication via node ID + message sequence chaining (anti-replay despite cleartext)
- Channel 2: AES-256-GCM, separate key
- Key storage: ESP32-S3 eFuse (OTP, non-extractable over JTAG)
- Physical attack requires: (1) breach Aegis-C (diamond wheel, 4+ min), (2) decap ESP32-S3 to probe eFuse, or (3) JTAG interposer (only encrypted data without eFuse key)

FIPS 140-3 Security Level 2 (tamper-evident enclosure), approaching Level 3 (tamper-resistant MCU).

---

*The mesh weaves through every highway. The signal survives every storm.*
