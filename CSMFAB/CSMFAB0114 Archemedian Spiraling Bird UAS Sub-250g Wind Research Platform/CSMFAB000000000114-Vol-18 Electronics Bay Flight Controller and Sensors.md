# CSMFAB000000000114 — Vol-18
# Electronics Bay — Flight Controller and Sensors
## Wiring Diagram, Controller Selection, and IMU Calibration
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: The Brain of the ASB-1

The electronics bay (3D-07) is a 38mm inner diameter × 60mm long clamshell cylinder housed at the mid-body of the ASB-1. Inside this 60cc volume lives everything that makes the device intelligent: the flight controller, GPS, radio, sensors, battery management, and actuator drivers. Getting the electronics right is the second hardest fabrication challenge after the spiral body print.

---

## Part 1: Flight Controller Selection

**Selected: SpeedyBee F405 Wing Mini**

| Specification | Value | Relevance |
|---|---|---|
| Processor | STM32F405RGT6, 168 MHz Cortex-M4 | Sufficient for sensor fusion at 1 kHz IMU |
| IMU | ICM-42688-P (6-axis gyro+accel) | High-quality MEMS IMU; 32kHz data |
| Barometer | DPS310 pressure sensor | ±0.06 hPa = ±0.5m altitude |
| OSD | Integrated AT7456E | Field diagnostic display (optional) |
| UART ports | 6 hardware UART | GPS, LoRa, serial telemetry |
| SPI ports | 2 | IMU, LoRa module |
| PWM outputs | 8 | ESC, FTS servo, SMA driver signals |
| ADC inputs | 4 | Battery voltage, pressure sensors |
| Firmware | ArduPilot (recommended) or Betaflight | ArduPilot has more sensor fusion capability |
| Mass | 7g | Meets budget |
| Dimensions | 36mm × 36mm | Fits within 38mm ID bay |
| Cost | ~$35 | Affordable |

ArduPilot firmware is strongly recommended over Betaflight for this application because it natively supports:
- Barometric altitude hold
- GPS-based position logging
- External sensor data logging (pressure probe, SHT31)
- Configurable PWM outputs for FTS servo and SMA drivers
- Serial telemetry compatible with SwarmView LoRa protocol

---

## Part 2: Wiring Diagram (Simplified)

```
                    ┌─────────────────────────────────────────┐
                    │         SpeedyBee F405 Wing Mini       │
                    │                                         │
BATTERY ──XT30──────┤ VBAT ──→ Voltage divider → ADC         │
         │          │                                         │
         ├──5V LDO──┤ 5V ──→ GPS (20mA), FTS servo (5mA)    │
         │          │                                         │
         ├──3.3V LDO┤ 3.3V ──→ LoRa RFM95W (SPI1)           │
                    │         SHT31 (I2C1)                    │
                    │         ATtiny85 FTS MCU (3.3V)         │
                    │                                         │
                    │ UART1 ──→ GPS (u-blox M8N, 9600 baud)  │
                    │ UART2 ──→ LoRa UART bridge (optional)  │
                    │ SPI1 ──→ RFM95W (CS, SCK, MOSI, MISO, INT)│
                    │ I2C1 ──→ SHT31 (SDA, SCL)              │
                    │ ADC1-4 ──→ MPXV7002 ×4 pressure sensors│
                    │ PWM1 ──→ Brushless motor ESC            │
                    │ PWM2 ──→ FTS servo (SG90)              │
                    │ PWM3 ──→ SMA Driver CH1 (North arm)    │
                    │ PWM4 ──→ SMA Driver CH2 (East arm)     │
                    │ PWM5 ──→ SMA Driver CH3 (South arm)    │
                    │ PWM6 ──→ SMA Driver CH4 (West arm)     │
                    └─────────────────────────────────────────┘
```

---

## Part 3: IMU Calibration Procedure

**Critical: The IMU must be calibrated before any flight. An uncalibrated IMU gives incorrect attitude data, which corrupts all wind measurements.**

### Step 1 — Accelerometer Calibration

1. Place the ASB-1 body on a flat level surface
2. Connect to ArduPilot Mission Planner via USB
3. Navigate to: Initial Setup → Mandatory Hardware → Accel Calibration
4. Follow the 6-position calibration tool (hold device in 6 orientations: level, nose down, nose up, right side, left side, inverted)
5. Click "Calibrate Accel"
6. Repeat if any calibration position shows >5% error

### Step 2 — Compass/Magnetometer Calibration

1. Navigate to: Initial Setup → Mandatory Hardware → Compass
2. Click "Start": Rotate the device through all orientations while moving it through a figure-8 pattern for 30 seconds
3. Click "Done"
4. Verify compass heading shows correct heading vs. a known reference (phone compass)

### Step 3 — IMU Temperature Calibration

The ICM-42688-P has a temperature compensation register. Enable it:
1. ArduPilot parameter: INS_TCAL_ENABLE = 1
2. The IMU will self-calibrate temperature compensation on the next 10-minute warm-up after cold start

### Step 4 — Level Attitude Trim

With the ASB-1 fully assembled (spiral body installed, battery in bay), place on a flat surface:
1. Mission Planner: Initial Setup → Accel Calibration → "Calibrate Level"
2. This sets the trim offset for the roll/pitch axis in ASB-1's installed orientation

---

## Part 4: Electronics Bay Physical Assembly

1. Cut all wires to minimum practical lengths (measure twice, cut once — extra wire = extra mass)
2. Install heat inserts in electronics bay shell mounting holes (M2, 5mm diameter tip, soldering iron at 220°C)
3. Mount flight controller to bay using M2 × 6mm screws through 6mm silicone vibration isolator grommets (4 at board corners)
4. Solder all connectors per wiring diagram above — use flux-core 63/37 solder; apply heat for minimum time
5. Route GPS to upper bay position (GPS needs sky view — top of bay, antenna facing upward in installed position)
6. Mount LoRa module to lower bay wall with double-sided foam tape
7. Install electronics bay into spiral body mid-cavity — secure with 4× M2 screws through body wall to heat inserts
8. Route antenna wire through side port, secure with hot glue at port exit

> ⚠️ **SAFETY:** Never power the device with the battery while soldering. Never short the battery terminals. Use a XT30 extension cable during bench testing so the battery remains outside the body during any electrical work.

---

## CHECKPOINT — Vol-18 Complete

Before proceeding, confirm:
- [ ] You understand the SpeedyBee F405 Wing Mini selection rationale (ArduPilot support, 7g mass, adequate I/O)
- [ ] You know the wiring diagram (battery → LDO regulators → FC → all peripherals)
- [ ] You can perform the 4-step IMU calibration sequence
- [ ] You understand the physical assembly sequence (heat inserts → grommets → solder → install)

**Proceed to:** Vol-19 (Remote ID) or Vol-20 (Launch Protocol)

---

*CSMFAB000000000114-Vol-18 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
