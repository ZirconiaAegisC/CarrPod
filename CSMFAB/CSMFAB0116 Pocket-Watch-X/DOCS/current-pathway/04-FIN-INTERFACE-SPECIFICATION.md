# CSMFAB0116-04 — POCKET WATCH X: FIN INTERFACE SPECIFICATION

**Revision:** A — 2026-07-10
**Classification:** ENGINEERING FABRICATION — INTERNAL / OPEN STANDARD
**Dependencies:** 01-CORE-SYSTEM-ARCHITECTURE

## 1. PURPOSE

This document defines the mechanical, electrical, and protocol interface for Pocket Watch X upgrade fins. This is an **open standard** — any manufacturer may produce compatible fins.

## 2. MECHANICAL INTERFACE

### 2.1 Fin Form Factor

| Parameter | Value | Tolerance |
|-----------|-------|-----------|
| Length (X) | 22.00 mm | ±0.10 mm |
| Width (Y) | 12.00 mm | ±0.10 mm |
| Thickness (Z) | 3.50 mm | ±0.05 mm |
| Mass | 3.0 g | +1.0 g |
| PCB thickness | 0.6 mm | 6-layer HDI |
| Connector-to-edge distance | 3.00 mm | ±0.05 mm |

### 2.2 Fin Slot in Housing

| Parameter | Value |
|-----------|-------|
| Slot width | 12.40 mm (+0.10 mm clearance) |
| Slot height | 3.80 mm (+0.15 mm clearance) |
| Slot depth | 25.00 mm (3 mm beyond connector) |
| Insertion guide | Tapered entry, 15° chamfer |
| Retaining mechanism | Spring-loaded ball detent + electromagnetic lock |
| Dust cover | Silicone flap, IP68 when closed |

### 2.3 Connector

| Parameter | Value |
|-----------|-------|
| Connector type | 60-pin mezzanine, board-to-board |
| Manufacturer p/n | Panasonic P4S series or equivalent |
| Pitch | 0.35 mm |
| Stacking height | 0.8 mm (mated) |
| Contact material | Au (0.2 µm) over Ni-Pd (1.5 µm) |
| Mating cycles | 5000 minimum |
| Contact resistance | < 25 mΩ initial, < 50 mΩ end-of-life |
| Insertion force | 45 N max |
| Extraction force | 8 N min, 30 N max |
| Alignment tolerance | ±0.3 mm XY, ±0.1 mm Z |

## 3. ELECTRICAL INTERFACE

### 3.1 Pinout (60-pin, viewed from fin looking into slot)

| Pin | Name | Direction | Description |
|-----|------|-----------|-------------|
| 1-4 | PCIE_TX_P/N[3:0] | Fin → Main | PCIe Gen4 transmit |
| 5-8 | PCIE_RX_P/N[3:0] | Main → Fin | PCIe Gen4 receive |
| 9 | REFCLK_P/N | Main → Fin | 100 MHz PCIe reference |
| 10 | PERST_L | Main → Fin | PCIe reset |
| 11-12 | USB3_TX/RX | Fin → Main | USB 3.2 Gen2 SS |
| 13-14 | USB2_DP/DN | Bidirectional | USB 2.0 |
| 15-18 | DP_AUX_P/N | Main → Fin | DisplayPort AUX |
| 19-20 | I2C_SDA/SCL | Main → Fin | 1 MHz management bus |
| 21 | FIN_DETECT | Fin → Main | Pulled to GND by fin |
| 22-23 | FIN_TYPE[1:0] | Fin → Main | ADC resistor divider ID |
| 24-27 | VMAIN (3.3V) | Main → Fin | 5A max |
| 28-31 | VCORE (1.1V) | Main → Fin | 4A max |
| 32-35 | GND | — | Power return |
| 36-39 | VIO (1.8V) | Main → Fin | 2A max |
| 40-43 | SPARE[3:0] | Bidirectional | Reserved |
| 44-47 | JTAG (TDI/TDO/TMS/TCK) | Bidirectional | Debug |
| 48-51 | UART (TX/RX/RTS/CTS) | Bidirectional | Console |
| 52-55 | I2S (BCLK/LRCLK/DIN/DOUT) | Bidirectional | Audio |
| 56 | FIN_LOCK | Main → Fin | EM lock control |
| 57-60 | GND | — | Power return |

### 3.2 Power Delivery Per Fin Slot

| Rail | Voltage | Max Current | Ripple | Notes |
|------|---------|-------------|--------|-------|
| VMAIN | 3.3V ±5% | 5A (16.5W) | < 50 mVpp | General purpose |
| VCORE | 1.1V ±3% | 4A (4.4W) | < 20 mVpp | Core logic |
| VIO | 1.8V ±5% | 2A (3.6W) | < 40 mVpp | I/O |

Total power budget per fin: **24.5W** (combined). Each fin declares its actual draw in the FDB.

### 3.3 Signal Integrity Requirements

| Parameter | Min | Typ | Max | Unit |
|-----------|-----|-----|-----|------|
| PCIe Tx diff amplitude | 800 | 900 | 1200 | mVppd |
| PCIe Rx sensitivity | — | — | 100 | mVppd |
| PCIe Tx eye height | 100 | — | — | mV |
| PCIe Tx eye width | 0.5 | — | — | UI |
| USB3 eye height | 100 | — | — | mV |
| I²C rise time (100 pF load) | — | — | 300 | ns |

## 4. FIN TYPE IDENTIFICATION

### 4.1 ADC Divider

FIN_TYPE[0] and FIN_TYPE[1] are connected to 10-bit ADC inputs on the main SoC. Each pin is pulled up to 1.8V via 10 kΩ on the main board. The fin places a resistor to GND on each pin. The resulting voltage encodes the fin class and subclass.

| Voltage (V) | Value | Fin Class |
|-------------|-------|-----------|
| 0.00-0.18 | 0x00 | CPU upgrade |
| 0.18-0.36 | 0x20 | GPU accelerator |
| 0.36-0.54 | 0x40 | Memory/storage |
| 0.54-0.72 | 0x60 | Wireless radio |
| 0.72-0.90 | 0x80 | Sensor suite |
| 0.90-1.08 | 0xA0 | I/O expansion |
| 1.08-1.26 | 0xC0 | Special function |
| 1.26-1.44 | 0xE0 | Reserved |
| 1.44-1.80 | 0xFF | Unrecognized/empty |

### 4.2 Fin Descriptor Block (FDB)

The first 256 bytes of PCIe configuration space extension (bytes 256-511 of config space) contain the FDB:

| Offset | Size | Field |
|--------|------|-------|
| 0x00 | 4 | Magic: 0x4657424B ("FDBK") |
| 0x04 | 2 | FDB version (1.0 = 0x0100) |
| 0x06 | 2 | Total FDB length in bytes |
| 0x08 | 4 | Manufacturer ID (IANA PEN or custom) |
| 0x0C | 4 | Product ID |
| 0x10 | 2 | Hardware revision (major.minor BCD) |
| 0x12 | 4 | Firmware version |
| 0x16 | 2 | Power budget request (mW) |
| 0x18 | 2 | Peak power budget (mW, burst < 10ms) |
| 0x1A | 2 | Thermal contribution (mW/°C above ambient) |
| 0x1C | 4 | Capability flags |
| 0x20 | 4 | Required fin bus lanes (0=auto, 1-4) |
| 0x24 | 32 | Fin name (ASCII, null-terminated) |
| 0x44 | 32 | Firmware filename (for auto-loading) |
| 0x64 | 16 | Cryptographic signature |
| 0x74 | 12 | Reserved |
| 0x80 | 128 | Capability-specific data |

### 4.3 Capability Flags

| Bit | Flag |
|-----|------|
| 0 | Supports PCIe Gen4 |
| 1 | Supports PCIe Gen3 fallback |
| 2 | Has on-fin MCU |
| 3 | Requires fin-specific firmware load |
| 4 | Has DMA master capability |
| 5 | Supports AER (Advanced Error Reporting) |
| 6 | Has I²S audio |
| 7 | Has on-fin sensors |
| 8 | Requires >15W sustained power |
| 9 | Hot-pluggable (can be removed live) |
| 10 | Hot-swappable (requires shutdown) |
| 11-15 | Reserved |

## 5. FIN INSERTION/REMOVAL PROTOCOL

### 5.1 Insertion Sequence

1. User inserts fin. FIN_DETECT pulled low.
2. ISR fires. SoC reads FIN_TYPE ADC.
3. SoC powers VMAIN, waits 1 ms for rail stabilization.
4. SoC powers VCORE, VIO. Waits 1 ms.
5. SoC de-asserts PERST_L.
6. SoC sends PCIe link training (Gen1 → Gen2 → Gen3 → Gen4 negotiation).
7. SoC reads FDB from config space extension.
8. SoC validates FDB signature (optional, per security policy).
9. SoC loads fin driver from firmware store.
10. Driver probe function runs.
11. EM lock solenoid engages (FIN_LOCK driven high).
12. User notification: "Fin ready."

### 5.2 Removal Sequence

1. User requests fin removal via UI or physical eject button.
2. SoC calls fin driver `pre_remove()` callback.
3. Fin driver completes pending DMA, flushes caches.
4. SoC de-asserts FIN_LOCK (EM lock releases).
5. SoC asserts PERST_L (puts fin in reset).
6. SoC powers off VCORE, VIO, VMAIN (reverse order).
7. User pulls fin out. FIN_DETECT goes high.
8. User notification: "Fin removed."

## 6. FIN COMPLIANCE TESTING

### 6.1 Required Tests

| Test | Method | Criterion |
|------|--------|-----------|
| Mechanical fit | Go/No-Go gauge | ±0.10 mm on all axes |
| Connector alignment | X-ray | Pins centered in receptacles |
| Power draw | Source meter | Within declared budget +10% |
| PCIe eye diagram | VNA at fin connector | Section 3.3 limits |
| Hot-plug cycling | 5000 insertions (automated) | 0 enumeration failures |
| Thermal imaging | Under 24.5W load | Fin surface < 70°C |
| ESD | ±8 kV contact, ±15 kV air per IEC 61000-4-2 | No latch-up |
| EMI | Radiated emissions per CISPR 32 Class B | Pass |

### 6.2 Certification

Fins passing all compliance tests receive the "Works with Pocket Watch X" certification and may use the compatibility logo. Testing is performed at CSM-authorized test labs or via self-certification with audit.

## 7. ELECTROMAGNETIC LOCK

| Parameter | Value |
|-----------|-------|
| Type | Miniature solenoid |
| Holding force | 10 N |
| Operating voltage | 3.3V |
| Hold current | 150 mA |
| Pull-in current | 300 mA (100 ms pulse) |
| Dimensions | 4.0 × 3.0 × 2.0 mm |
| Life cycles | 50,000 |

## 8. FIN DESIGN GUIDELINES

1. All fins must implement the PCIe Gen4 endpoint at minimum (Gen3 accepted for low-bandwidth fins).
2. Fins drawing > 5W must include thermal vias and contact pad for heat spreader interface.
3. Fins with RF must include shielding can and pass conducted/radiated emissions.
4. Fins with firmware must support signed updates via the Fin FW Update Protocol.
5. Pin SPARE[3:0] may be re-purposed by agreement with CSM for non-standard functions.

## 9. VERIFICATION

| Test | Method | Criterion |
|------|--------|-----------|
| Fin enumeration | Insert 100 fins (all types) | 100% detection, 0 false IDs |
| Sustained power draw | Run fin at max declared budget for 1 hr | No OCP trip, no thermal limit |
| PCIe link stability | 24-hour BER test | BER < 10⁻¹² |
| Fin lock retention | Pull test | > 10N before release |
| EMC | Pre-compliance scan in chamber | 6 dB margin to limits |
