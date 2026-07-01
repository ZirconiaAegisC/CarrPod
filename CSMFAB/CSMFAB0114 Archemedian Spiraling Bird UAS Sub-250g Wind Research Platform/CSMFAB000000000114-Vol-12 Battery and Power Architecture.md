# CSMFAB000000000114 — Vol-12
# Battery and Power Architecture
## LiFePO₄ Power System, Solar Option, Solar Charging Safety
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: Why LiFePO₄ Instead of LiPo

The standard drone battery chemistry is Lithium Polymer (LiPo): high energy density, low weight, available everywhere. Yet the ASB-1 uses **Lithium Iron Phosphate (LiFePO₄)** instead. Here is the full reasoning:

| Property | LiPo 2S 300mAh | LiFePO₄ 2S 300mAh | Winner |
|---|---|---|---|
| Nominal voltage | 7.4V | 6.6V | LiPo (higher voltage for motors) |
| Energy (Wh) | ~2.22 Wh | ~1.98 Wh | LiPo (10% more energy) |
| Mass | ~18-22g | ~32-38g | LiPo (lighter) |
| Thermal runaway temp | 130°C | **210°C** | **LiFePO₄ (80°C safer)** |
| Cycle life | 300-500 cycles | **2,000+ cycles** | **LiFePO₄** |
| Swelling/puffing risk | High | Very low | **LiFePO₄** |
| Cost per unit | $6-12 | $8-15 | Comparable |
| Stellar-Aegis Protocol | Conductive metallic foil wrapping | BFRP outer sleeve available | **LiFePO₄** |

The cliff-top and coastal environment the ASB-1 operates in involves:
- Salt air (accelerates LiPo corrosion)
- Temperature variations (−5°C mornings to 35°C afternoons in summer)
- No immediate access to fire extinguisher if thermal runaway occurs over a cliff

LiFePO₄'s 80°C higher thermal runway temperature makes it dramatically safer in these conditions. The 10% energy penalty is acceptable — the ASB-1 is primarily a passively-powered autorotating device that barely draws current during nominal flight.

---

## Part 1: Battery Specifications

**Selected Battery: GNB 2S 300mAh HV LiFePO₄ (or equivalent)**

| Specification | Value |
|---|---|
| Chemistry | LiFePO₄ (Lithium Iron Phosphate) |
| Configuration | 2S (two cells in series) |
| Nominal voltage | 6.6V (3.3V per cell nominal; 3.6V fully charged) |
| Capacity | 300 mAh |
| Energy content | 300mAh × 6.6V = 1.98 Wh |
| C-rating | 30C continuous |
| Max continuous current | 300mAh × 30C = 9A |
| Max burst current | 60C (limited burst) → 18A |
| Cutoff voltage (low) | 5.6V (2.8V per cell) |
| Charge voltage | 7.2V (3.6V per cell max) |
| Mass | 35g |
| Dimensions (approximate) | 48mm × 30mm × 12mm |
| Connector | JST-PH 2.0 (matches battery bay in 3D-09) |

---

## Part 2: Power Budget

Every electronic system has a power budget — how much current it draws and how long the battery lasts.

| System | Voltage | Current Draw | Power (W) | Notes |
|---|---|---|---|---|
| Flight Controller (FC) | 5V regulated | 50 mA | 0.25W | SpeedyBee F405 idle |
| GPS module | 3.3V | 20 mA | 0.066W | u-blox M8N acquisition |
| LoRa TX (active) | 3.3V | 100 mA × 2.2% duty | 0.0073W avg | 22ms per second average |
| LoRa RX (listening) | 3.3V | 10 mA | 0.033W | Continuous listening |
| IMU + Baro | 3.3V | 3 mA | 0.010W | Integrated in FC |
| Pressure sensors (×4) | 5V | 2 mA each = 8 mA | 0.040W | MPXV7002, powered continuous |
| Temperature/humidity (SHT31) | 3.3V | 1.5 mA | 0.005W | Continuous |
| SMA actuators (idle) | 6.6V | 0 mA | 0W | Only draw current when activated |
| SMA actuators (1 active) | 6.6V | 80 mA | 0.53W | During actuation (< 2% duty) |
| Brushless motor (if hovering) | 6.6V | 500-1500 mA | 3.3-9.9W | Only in calm/motor-assist mode |
| FTS servo (standby) | 5V | 5 mA | 0.025W | SG90 servo standby current |
| ATtiny85 FTS MCU | 3.3V | 1 mA | 0.003W | Always on (independent FTS) |
| 5V voltage regulator losses | — | ~5% | 0.020W | LDO regulator efficiency |

**Total electronics draw (passive autorotation, no motor):**
```
0.25 + 0.066 + 0.007 + 0.033 + 0.010 + 0.040 + 0.005 + 0.025 + 0.003 + 0.020 = 0.459W
```

**Battery life (passive autorotation):**
```
t = Energy / Power = 1.980 Wh / 0.459 W = 4.31 hours
```

In passive autorotation with no motor, the ASB-1 electronics can run for **over 4 hours** on one charge. Practical flight endurance is limited by tether management and research protocol, not battery.

**Battery life (motor-assist hover, 1105 motor at cruise):**
```
Approximate motor draw at hover: 750 mA × 6.6V = 4.95W
Total draw with motor: 0.459 + 4.95 = 5.41W
t = 1.980 / 5.41 = 0.366 hours = 22 minutes
```

Motor-assist mode endurance: **~22 minutes** — adequate for calm-day demonstrations at Cypress.

---

## Part 3: Wiring Architecture

The power distribution follows a simple star topology from the battery:

```
BATTERY (2S LiFePO₄ 300mAh)
   |
   ├── Main fuse (3A polyfuse, self-resetting)
   |
   ├── 5V LDO Regulator (AMS1117-5.0)
   |   ├── Flight Controller (50 mA)
   |   ├── GPS Module (20 mA) — via FC 5V rail
   |   ├── SG90 FTS Servo (5 mA standby)
   |   └── MPXV7002 Pressure Sensors ×4 (8 mA)
   |
   ├── 3.3V LDO Regulator (AMS1117-3.3)
   |   ├── RFM95W LoRa Module (10-100 mA)
   |   ├── SHT31 Temperature/Humidity (1.5 mA)
   |   └── ATtiny85 FTS MCU (1 mA)
   |
   ├── Direct 6.6V (battery voltage)
   |   ├── Brushless Motor via ESC
   |   └── SMA Driver MOSFET array (via driver PCB)
   |
   └── Charge port (JST-PH 2.0, to rear-accessible port on body)
```

All wiring uses 28AWG silicone-insulated wire (maximum flexibility, minimum mass, -60°C to +200°C rated).

---

## Part 4: Charging Protocol

**Charger:** Any LiFePO₄-compatible balance charger
- Recommended: ISDT Q6 Nano (30g, $25, outputs up to 14W, has LiFePO₄ mode)
- Charge rate: 0.5C to 1C = 150-300 mA charge current
- At 300 mA charge rate: ~1 hour from empty to full
- Balance charging: always use balance port — prevents cell imbalance

> ⚠️ **SAFETY:** LiFePO₄ must never be charged above 3.65V per cell (7.3V for 2S). Use a charger with automatic LiFePO₄ cutoff. Never use a LiPo charger on a LiFePO₄ battery — the charge voltages are different (4.2V/cell for LiPo vs. 3.6V/cell for LiFePO₄).

---

## Part 5: Solar Charging Option (Future Upgrade — V1.1)

For extended research flights (endurance > 4 hours), a flexible solar patch can be integrated on the outer surface of the spiral body:

- **Solar cell:** 37mm × 37mm CIGS flexible thin-film cell (5V, 60mA at AM1.5 sun, 0.3W per cell)
- **4 cells** on top side of spiral body surface: 4 × 0.3W = 1.2W max (in direct sun)
- **MPPT converter:** 0.5g TI BQ25570 ultra-low-power MPPT harvester in electronics bay
- At 1.2W harvest vs. 0.459W electronics draw: net positive energy = indefinite endurance
- **Mass penalty:** 4 cells × 0.5g + MPPT converter 0.5g = 2.5g total

This is a +2.5g modification, well within the 72g reserve. Deferred to V1.1 pending main V1.0 build validation.

---

## CHECKPOINT — Vol-12 Complete

Before proceeding, confirm:
- [ ] You understand why LiFePO₄ was chosen over LiPo (thermal safety, cycle life, Stellar-Aegis compliance)
- [ ] You know the power budget: 0.459W passive autorotation = 4.3 hours endurance
- [ ] You know the wiring topology (star distribution from battery, two regulators at 5V and 3.3V)
- [ ] You know the charging protocol: LiFePO₄ balance charger, 1C = 300mA, ~1 hour charge time
- [ ] You know the solar upgrade path for V1.1 (2.5g, would provide indefinite endurance in sun)

**Proceed to:** Vol-13 (Swarm Operations) or Vol-21 (Assembly Manual)

---

*CSMFAB000000000114-Vol-12 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
