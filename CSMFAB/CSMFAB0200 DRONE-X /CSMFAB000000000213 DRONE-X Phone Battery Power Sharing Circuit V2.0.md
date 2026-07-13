# CSMFAB000000000213 — DRONE-X Phone Battery Power Sharing Circuit
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Electronics Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — Mode A/B architecture, MT3608 boost, DPDT switch, phone-as-battery emergency mode |

---

## 1. Power Sharing Architecture

The power sharing circuit supports two operational modes, selected via a physical DPDT slide switch:

**Mode A — Phone Charging (Default):** Drone battery (3S LiPo) → MT3608 boost converter → 5V/1.5A → phone USB-C charging port. Phone operates on its own battery while being trickle-charged by the drone.

**Mode B — Phone as Emergency Battery (Emergency Only):** Phone USB-C OTG output → 5V → step-up to 11.1V → drone avionics rail. Used only when the main flight battery is depleted and an emergency landing must be completed.

## 2. Mode A: Drone Charges Phone

```
3S LiPo (11.1V) → [Kill Switch] → [MT3608 Boost 5V] → [DPDT SW Position A] → [USB-C VBUS] → Phone
```

| Parameter | Value |
|-----------|-------|
| Boost converter | MT3608 module (adjustable output set to 5.0V) |
| Output voltage | 5.0 V ± 0.25 V |
| Max output current | 1.5 A (current-limited by MCU GPIO control) |
| Enable control | MCU GPIO (high = enable, low = disable) |
| Enable threshold | Drone battery > 11.5V (to preserve flight power) |
| USB-C CC resistors | 5.1kΩ pull-down on CC1 and CC2 (indicates 1.5A source) |
| Protection | 2A resettable PTC fuse on output |
| LED indicator | Green LED = phone charging active |

## 3. Mode B: Phone Powers Drone (Emergency)

```
Phone USB-C OTG (5V) → [DPDT SW Position B] → [Boost to 11.1V] → [Avionics Rail ONLY]
```

| Parameter | Value |
|-----------|-------|
| Phone OTG mode | USB-C host with VBUS output enabled |
| Phone output | 5V, up to 900 mA (USB 3.0) or 1.5A (USB-PD capable phones) |
| Boost converter | MT3608 configured for 11.1V output |
| Load powered | Avionics only (MCU, GPS, LoRa, BT) — NOT motors |
| Avionics draw | ~0.2A @ 5V = ~1W total = ~100 mA @ 11.1V after boost |
| Max emergency duration | ~5 min (from typical phone battery, avionics-only load) |
| Purpose | Maintain control link and GPS fix during forced landing |

## 4. DPDT Switch Wiring

```
SWITCH POSITION A (Phone Charging):
  SW1-COM → MT3608_5V_OUT
  SW1-A   → USB-C VBUS (via PTC fuse)
  SW2-COM → GND
  SW2-A   → USB-C GND

SWITCH POSITION B (Phone as Battery):
  SW1-COM → MT3608_11.1V_IN
  SW1-B   → USB-C VBUS (phone OTG output)
  SW2-COM → Avionics GND
  SW2-B   → USB-C GND
```

The DPDT switch is labeled with a clear legend: "CHARGE ↔ EMERGENCY". A mechanical lock (sliding gate) prevents accidental switching to Mode B during normal operation.

## 5. USB-C Implementation

| Signal | Connection | Notes |
|--------|------------|-------|
| VBUS | Mode A: 5V out, Mode B: 5V in from phone | Via DPDT switch |
| GND | Common ground | Galvanically connected to drone GND |
| CC1 | 5.1kΩ to GND | Identifies as 1.5A source (Mode A) |
| CC2 | 5.1kΩ to GND | Identifies as 1.5A source (Mode A) |
| D+ | 10kΩ to 3.3V (MCU) | USB enumeration helper (Mode A) |
| D- | 10kΩ to GND | USB enumeration helper (Mode A) |
| SBU1/SBU2 | NC | Not used |

**Critical design rule:** The USB-C data lines (D+/D-) from the phone are NOT connected through the power sharing circuit. They route directly to the STM32F103 USB OTG port (CSMFAB-202). The power sharing circuit handles ONLY the VBUS and GND connections.

## 6. Safety Interlocks

| Interlock | Mechanism |
|-----------|-----------|
| Dual-mode prevention | DPDT switch ensures only one mode is active |
| Battery undervoltage | MCU disables phone charging below 11.5V drone battery |
| Phone undervoltage | Mode B only enabled when phone battery > 20% |
| Overcurrent | 2A PTC fuse on phone charge line, 500 mA PTC on Mode B |
| Reverse polarity | Schottky diode on USB-C VBUS input (Mode B) |
| Hot-plug | All connectors rated for hot-plug, no inrush limiter needed |

---

*"Power shared is power multiplied. But power routed incorrectly is power annihilated."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Electronics Assembly Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
