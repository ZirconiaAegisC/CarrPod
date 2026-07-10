# CSMFAB0116-01 — POCKET WATCH X: CORE SYSTEM ARCHITECTURE

**Revision:** A — 2026-07-10
**Classification:** ENGINEERING FABRICATION — INTERNAL
**Dependencies:** None (root document)

## 1. SYSTEM OVERVIEW

The Pocket Watch X is a modular wearable computing platform in a traditional pocket watch form factor. It consists of three architectural layers:

1. **Core Module (Proprietary):** Circular display + dual-SoC + power management + housing — the profit center.
2. **Fin Slots (Open Standard):** Two internal expansion slots accepting upgrade modules (CPU, GPU, memory, wireless, sensor, etc.).
3. **External Divots (Open Standard):** Contact array on back/sides for docking into cases, vehicles, projectors, keyboards, and other host devices.

### 1.1 Physical Constraints

| Parameter | Value | Tolerance |
|-----------|-------|-----------|
| Housing diameter | 50.00 mm | ±0.05 mm |
| Housing thickness (core) | 16.50 mm | ±0.10 mm |
| Weight (core only, Ti housing) | 85 g | ±5 g |
| Operating temperature | -20°C to +55°C | — |
| Storage temperature | -40°C to +85°C | — |
| Ingress protection | IP68 | 2m submersion, 30 min |

### 1.2 Architectural Block Diagram

```
┌─────────────────────────────────────────────┐
│                 EXTERNAL DIVOT ARRAY          │
│  USB4/DP2.1/PD3.1 — pogo-pin contacts        │
├─────────────────────────────────────────────┤
│  ┌─────────────┐  ┌─────────────┐           │
│  │  SoC-A       │  │  SoC-B       │           │
│  │  ARM X4      │  │  ARM X4      │  DUAL-SoC │
│  └──────┬──────┘  └──────┬──────┘           │
│         └────────┬───────┘                   │
│                  │ FIN BUS SWITCH             │
│         ┌────────┴────────┐                  │
│    ┌────┴────┐      ┌─────┴────┐             │
│    │ FIN 0   │      │ FIN 1    │             │
│    │ PCIe4x4 │      │ PCIe4x4  │             │
│    └─────────┘      └──────────┘             │
│         │                                     │
│    ┌────┴────────────────────────┐           │
│    │     CIRCULAR DISPLAY        │           │
│    │  1440×1440 OLED, 326 PPI   │           │
│    └─────────────────────────────┘           │
│    ┌─────────────────────────────┐           │
│    │   POWER MANAGEMENT UNIT     │           │
│    │  1850mAh, Qi2 15W, 8 rails  │           │
│    └─────────────────────────────┘           │
└─────────────────────────────────────────────┘
```

## 2. DUAL-SOC ARCHITECTURE

### 2.1 SoC Selection

| Parameter | SoC-A | SoC-B |
|-----------|-------|-------|
| Architecture | ARM Cortex-X4 | ARM Cortex-X4 |
| Core count | 8 (1+3+4) | 8 (1+3+4) |
| Max clock | 3.2 GHz | 3.2 GHz |
| LPDDR5X | 8 GB shared pool | shared with A |
| GPU | Mali-G720-Immortalis | shared GPU block |
| NPU | 45 TOPS | 45 TOPS |
| Process node | 3nm GAA | 3nm GAA |
| Idle power | 12 mW | 12 mW |
| TDP | 6 W | 6 W |

### 2.2 Cross-Monitoring Protocol

SoC-B continuously monitors SoC-A through a dedicated I²C heartbeat channel running at 400 kHz. Every 50 ms, SoC-A pulses a GPIO line connected to SoC-B's interrupt pin. If SoC-B detects three consecutive missed pulses (>150 ms gap), it triggers the failover sequence:

1. SoC-B asserts the `FAILOVER_REQ` line high.
2. SoC-B reads SoC-A's last saved register state via shared SRAM (2 MB, dual-port, 0 wait-state).
3. SoC-B takes ownership of the display framebuffer, fin bus, and external divot controller.
4. SoC-B initiates a soft reset of SoC-A via dedicated `RESET_A` GPIO.
5. Post-reset, SoC-A boots into diagnostic mode. SoC-B runs a 256-point test vector.
6. If SoC-A passes diagnostics, control transfers back. If not, SoC-B remains primary.
7. Total failover latency: < 50 ms from detection to stable operation.

### 2.3 Shared Memory Map

| Region | Size | Purpose | Access |
|--------|------|---------|--------|
| 0x0000_0000 | 64 KB | Boot ROM | Read-only, both |
| 0x0001_0000 | 2 MB | Cross-monitoring SRAM | Dual-port R/W |
| 0x0020_0000 | 256 MB | Display framebuffer | Write-mutex |
| 0x1000_0000 | 7.75 GB | Main DDR pool | MESI-coherent |

## 3. FIN BUS ARCHITECTURE

### 3.1 Physical Layer

| Parameter | Specification |
|-----------|--------------|
| Connector type | 60-pin mezzanine, 0.35 mm pitch |
| Mating cycles | 5000 minimum |
| Contact resistance | < 25 mΩ (initial) |
| Contact material | Au over Ni-Pd |
| Retention force | 8 N per fin slot |
| Fin dimensions (max) | 22.0 × 12.0 × 3.5 mm |

### 3.2 Pin Allocation (60-pin connector)

| Pins | Signal | Description |
|------|--------|-------------|
| 1-4 | PCIE_TX[3:0] | PCIe Gen4 ×4 TX pairs |
| 5-8 | PCIE_RX[3:0] | PCIe Gen4 ×4 RX pairs |
| 9 | PCIE_CLK_P/N | PCIe reference clock (100 MHz) |
| 10 | PCIE_RST_L | PCIe reset (active low) |
| 11-13 | USB_DP/DN | USB 3.2 Gen2 ×1 |
| 14-17 | DP_AUX | DisplayPort AUX channel |
| 18-21 | I2C_SDA/SCL | Management bus (1 MHz) |
| 22 | FIN_DETECT | Fin insertion detect (pull-up) |
| 23 | FIN_TYPE[1:0] | Fin type ID (ADC read) |
| 24-27 | VMAIN | Main power rail (3.3V, 5A) |
| 28-31 | VCORE | Core power rail (1.1V, 4A) |
| 32-35 | GND | Ground |
| 36-39 | VIO | I/O power rail (1.8V, 2A) |
| 40-43 | SPARE[3:0] | Reserved for future use |
| 44-47 | JTAG | Debug interface |
| 48-51 | UART | Serial console |
| 52-55 | AUDIO | I²S audio bus |
| 56 | FIN_LOCK | Electromagnetic lock solenoid |
| 57-60 | GND | Ground |

### 3.3 Protocol Stack

1. **Layer 1 — Physical:** PCIe Gen4 ×4 lanes + USB 3.2 Gen2 + DP AUX
2. **Layer 2 — Link:** PCIe data link layer with fin-specific configuration space
3. **Layer 3 — Transport:** Fin Descriptor Block (FDB) protocol for discovery and enumeration

### 3.4 Fin Discovery Sequence

1. Insertion detected via `FIN_DETECT` (pulled low by fin presence).
2. SoC reads `FIN_TYPE` ADC value to determine fin class (8-bit resolution, 256 types).
3. SoC enables `VMAIN`, `VCORE`, `VIO` rails in sequence (2 ms per rail).
4. SoC enumerates PCIe endpoint at Bus 0, Device 0.
5. SoC reads Fin Descriptor Block (first 256 bytes of PCIe config space extension):
   - Manufacturer ID (4 bytes)
   - Product ID (4 bytes)
   - Hardware revision (2 bytes)
   - Firmware version (4 bytes)
   - Power budget request (2 bytes, mW)
   - Capability flags (4 bytes)
6. SoC loads fin-specific driver from firmware store.
7. Fin operational. EM lock engages after 500 ms stable operation.

## 4. POWER ARCHITECTURE

### 4.1 Power Rails

| Rail | Voltage | Max Current | Domain |
|------|---------|-------------|--------|
| VMAIN | 3.3V | 5A | Fin slots, external divot |
| VCORE | 1.1V | 4A | SoC cores |
| VIO | 1.8V | 2A | I/O peripherals |
| VDDR | 1.05V | 3A | DDR memory |
| VANA | 2.8V | 500mA | Analog/RF |
| VDIS | 12V | 200mA | Display backlight |
| VBAT | 3.85V (nom) | — | Battery terminal |
| VCHG | 5V-12V | 3A | Charging input |

### 4.2 System Power Budget

| Component | Active (W) | Idle (mW) | Sleep (µW) |
|-----------|-----------|-----------|------------|
| Dual SoC | 12.0 | 24 | 12 |
| Display (200 nit) | 1.8 | 50 | 1 |
| Touch controller | 0.3 | 5 | 0.1 |
| WiFi/BT | 1.2 | 10 | 0 |
| Fin 0 (typical CPU) | 6.0 | 100 | 5 |
| Fin 1 (typical GPU) | 4.0 | 80 | 5 |
| Sensors | 0.2 | 2 | 0.05 |
| **Total** | **~25.5** | **~271** | **~23.15** |

## 5. THERMAL BUDGET

| Parameter | Value |
|-----------|-------|
| Max sustained TDP | 25.5 W |
| Thermal solution | Copper vapor chamber + graphite spreader |
| Theta-JA | 28°C/W (core only) |
| Max junction temp | 105°C (SoC), 85°C (battery) |
| Throttle onset | 95°C SoC junction |
| Surface temp limit | 43°C (regulatory) |

## 6. CLOCK ARCHITECTURE

| Clock | Frequency | Source | Domain |
|-------|-----------|--------|--------|
| SoC PLL | 3.2 GHz | Internal XO | CPU cores |
| DDR | 8533 MHz | SoC PLL | Memory |
| PCIe RefClk | 100 MHz | TCXO ±2.5 ppm | Fin bus |
| Display | 148.5 MHz | SoC PLL | MIPI DSI-2 |
| USB | 24 MHz | USB PHY XO | USB controller |
| WiFi/BT | 38.4 MHz | RF XO ±10 ppm | Wireless |
| RTC | 32.768 kHz | Tuning fork XTAL | Always-on |
| Sensor | 26 MHz | MEMS oscillator | Sensor hub |

## 7. DMA AND INTERCONNECT

| Path | Bandwidth | Protocol | Notes |
|------|-----------|----------|-------|
| SoC-A ↔ SoC-B | 68 GB/s | Coherent mesh | LPDDR5X shared |
| Fin 0 ↔ SoC | 16 GT/s ×4 | PCIe Gen4 | Full-duplex |
| Fin 1 ↔ SoC | 16 GT/s ×4 | PCIe Gen4 | Full-duplex |
| Display ↔ SoC | 6 Gbps/lane ×4 | MIPI DSI-2 | 24 Gbps total |
| Ext Divot ↔ SoC | 40 Gbps ×1 | USB4/TBT4 | Bidirectional |
| NPU ↔ DDR | 137 GB/s | Internal bus | 45 TOPS inference |

## 8. STARTUP SEQUENCE

1. **T=0 ms:** Battery or external power applied.
2. **T=2 ms:** PMIC core rails (VCORE, VIO, VDDR) sequenced on.
3. **T=5 ms:** SoC-A internal 32 kHz oscillator starts.
4. **T=10 ms:** SoC-A PLL locks at 3.2 GHz.
5. **T=12 ms:** Boot ROM validates Bootloader signature (ECDSA P-384).
6. **T=15 ms:** Bootloader loads L1 firmware and hands off.
7. **T=20 ms:** SoC-A checks SoC-B presence via I²C heartbeat.
8. **T=25 ms:** Both SoCs negotiate primary/secondary via shared SRAM flag.
9. **T=30 ms:** Primary SoC initializes fin bus, enumerates inserted fins.
10. **T=50 ms:** Display framebuffer initialized, splash screen loaded.
11. **T=100 ms:** UI thread starts. Device ready for user interaction.

## 9. VERIFICATION CHECKPOINTS

| Checkpoint | Method | Acceptance Criteria |
|------------|--------|---------------------|
| Power sequencing | Oscilloscope, all rails | Within 2 ms of spec |
| PCIe eye diagram | VNA/TDR at fin connector | Eye height > 100 mV, width > 0.5 UI |
| Failover latency | Logic analyzer on GPIO | < 50 ms from trigger to display stable |
| Thermal imaging | IR camera at 25.5W load | No hotspot > 95°C junction |
| Fin insertion/removal | 10,000 cycle test | Zero errors in enumeration |
| Boot time | Timer from power-on to UI ready | < 150 ms total |
