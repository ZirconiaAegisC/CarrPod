# CSMFAB000000000202 — DRONE-X USB-C OTG Bridge MCU Design
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Electronics Engineering Design Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — STM32F103C8T6 BOM, pin assignments, firmware architecture, PCB layout |

---

## 1. MCU Selection and BOM

The STM32F103C8T6 "Blue Pill" development board serves as the USB-C OTG bridge MCU, providing USB 2.0 Full Speed peripheral/host mode, 3× USART, 2× SPI, 2× I²C, and a 72 MHz ARM Cortex-M3 core. Total BOM cost: $10.44.

| Component | Part Number | Qty | Unit Cost | Total |
|-----------|-------------|-----|-----------|-------|
| MCU board | STM32F103C8T6 Blue Pill | 1 | $2.85 | $2.85 |
| USB-C OTG adapter | Micro USB to USB-C OTG cable | 1 | $1.50 | $1.50 |
| Logic level shifter | TXB0104 (3.3V ↔ 5V) | 1 | $1.20 | $1.20 |
| HC-05 BT module | HC-05 ZS-040 | 1 | $3.50 | $3.50 |
| PCB/custom board | 40×30 mm 2-layer prototype | 1 | $0.50 | $0.50 |
| Passives | 100nF, 10µF caps, 10kΩ resistors | 8 | $0.05 | $0.40 |
| Pin headers | 2.54 mm male/female headers | 6 | $0.08 | $0.49 |
| **Total** | | | | **$10.44** |

## 2. Pin Assignments

| STM32F103 Pin | Function | Connected To |
|---------------|----------|-------------|
| PA9 (TX1) | USART1 TX | MCU ↔ HC-05 BT |
| PA10 (RX1) | USART1 RX | MCU ↔ HC-05 BT |
| PA2 (TX2) | USART2 TX | MCU ↔ USB CDC bridge (phone) |
| PA3 (RX2) | USART2 RX | MCU ↔ USB CDC bridge (phone) |
| PB10 (TX3) | USART3 TX | MCU ↔ ESC #1 (#1-4 via I²C multiplex) |
| PB11 (RX3) | USART3 RX | MCU ↔ ESC telemetry |
| PA4 | SPI1 NSS | LoRa module CS (CSMFAB-220) |
| PA5 | SPI1 SCK | LoRa module SCK |
| PA6 | SPI1 MISO | LoRa module MISO |
| PA7 | SPI1 MOSI | LoRa module MOSI |
| PB0 | GPIO Input | Kill switch status |
| PB1 | GPIO Output | Status LED (arming indicator) |
| PA0 | ADC1 IN0 | Battery voltage divider (1:4) |
| PA1 | ADC1 IN1 | Current sensor (ACS758) |

## 3. Firmware Architecture

The firmware operates on a cooperative multitasking model within a 1 kHz SysTick interrupt:

**Task Schedule:**
- **400 Hz** — Flight loop: ESC command generation, motor mix, DSHOT300 output
- **200 Hz** — Sensor poll: battery V/I, kill switch, LoRa packet queue
- **100 Hz** — Telemetry encode: JSON packet assembly, UART transmission to phone
- **50 Hz** — Command decode: parse incoming phone commands, execute safety checks
- **10 Hz** — Diagnostics: CRC error rate, MCU temperature, uptime, heartbeat LED

**Memory Budget:**
- Flash: 28 kB of 64 kB used (44%)
- RAM: 12 kB of 20 kB used (60%)
- Stack: 4 kB reserved

## 4. Communication Protocol

The serial protocol between phone and MCU operates at 921600 baud, 8N1, with the following frame:

```
[0xAA] [CMD 1B] [LEN 1B] [PAYLOAD 0–32B] [CRC16 2B] [0x55]
```

CRC-16 polynomial: 0x8005 (CRC-16-IBM), initial value 0xFFFF.

**Command Subset (Flight Critical):**

| CMD | Name | Payload | Response |
|-----|------|---------|----------|
| 0x01 | MOTOR_CMD | 4× uint16 throttle [1000–2000] | ACK |
| 0x02 | ARM | uint8: 0x5A (arm), 0xA5 (disarm) | ACK + status |
| 0x05 | SET_KILL | uint8: 0x01 (engage), 0x00 (release) | ACK |
| 0x10 | TELEM_REQ | None | 32B telemetry packet |
| 0x20 | LORA_TX | uint8 len + payload | ACK + RSSI |
| 0x30 | PING | uint8 seq | PONG + seq |

## 5. PCB Layout Specifications

| Parameter | Value |
|-----------|-------|
| Board dimensions | 40 mm × 30 mm |
| Layers | 2 |
| Copper weight | 1 oz |
| Min trace width | 8 mil (signal), 24 mil (power) |
| Power plane | 3.3V regulated from 5V USB VBUS |
| Decoupling | 100 nF ceramic per IC + 10 µF tantalum bulk |
| Connector | Right-angle USB-C receptacle, JST-XH for ESC signal |
| EMI shielding | MXene Ti₃C₂Tₓ 45 µm spray coat on top layer (CSMFAB-214) |

---

*"Every bit that crosses the bridge must arrive unchanged — latency is a tax, jitter is a weapon."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Electronics Assembly Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
