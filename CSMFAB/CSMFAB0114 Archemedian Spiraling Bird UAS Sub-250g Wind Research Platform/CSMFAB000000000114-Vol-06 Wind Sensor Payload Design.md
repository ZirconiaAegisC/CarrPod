# CSMFAB000000000114 — Vol-06
# Wind Sensor Payload Design
## What the ASB-1 Measures, How It Measures It, and What the Data Looks Like
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: The Reason This Device Exists

The ASB-1 is not a toy. It is a **flying atmospheric instrument**. Every design decision — the spiral geometry, the light weight, the LoRa radio, the tether system — exists to put a small, sensitive instrument package into a specific region of the atmosphere (cliff-top, coastal, canyon) and extract high-quality wind data that cannot be obtained any other way at this cost. This volume describes exactly what the sensors are, how they work, what they measure, and how the data flows.

---

## Part 1: What We Are Measuring — The Wind Data Hierarchy

Atmospheric wind research at the 50-1,200 ft AGL altitude range targets several distinct data products:

| Priority | Measurement | Variable | Sensor | Notes |
|---|---|---|---|---|
| P1 | Wind speed magnitude | V_wind (m/s) | 4-hole pressure probe | Derived from differential pressure |
| P1 | Wind direction (azimuth) | ψ_wind (°) | 4-hole probe + IMU heading | Combined calculation |
| P2 | Vertical wind component | V_vertical (m/s) | 4-hole probe (all 4 ports) | Updraft/downdraft quantification |
| P2 | Altitude AGL | h (m) | Barometric + GPS fusion | ±1m target accuracy |
| P3 | Atmospheric pressure | P (hPa) | BMP388 + 4-hole probe | Background met data |
| P3 | Air temperature | T (°C) | SHT31 | ±0.3°C accuracy |
| P3 | Relative humidity | RH (%) | SHT31 | ±2% RH accuracy |
| P4 | Position (GPS) | lat/lon | u-blox M8N | Swarm grid mapping |
| P4 | Device attitude | pitch/roll/yaw | IMU (onboard FC) | Wind calculation correction |

---

## Part 2: The Four-Hole Pressure Probe — Primary Wind Sensor

### 2.1 Operating Principle

A four-hole pressure probe (also called a multi-hole probe or cobra probe) is the gold standard for atmospheric wind measurement in research drones. It consists of a nose-mounted tip with four small holes arranged symmetrically around the circumference, plus one center hole. By measuring the differential pressure between holes on opposite sides, you can calculate the 3D wind velocity vector.

**The physics:**
The pressure at each hole is a function of the total velocity and angle:
```
P_hole = P_static + ½ × ρ × V² × cos²(α_hole)
```

Where α_hole is the angle between the probe axis and the flow direction. By solving the system of 4 pressure equations simultaneously, you extract the 3D velocity vector components (u, v, w — East/North/Up in a geographic reference frame).

### 2.2 Sensor Selection: MPXV7002DP Differential Pressure Sensor

For the ASB-1, we use the **Freescale/NXP MPXV7002DP** differential pressure sensor (or equivalent):

| Specification | Value |
|---|---|
| Pressure range | ±2 kPa (±20 mbar) |
| Sensitivity | 1.0 V/kPa |
| Response time | 1 ms |
| Temperature compensation | Built-in |
| Supply voltage | 5V |
| Mass per sensor | 0.5g |
| Package | SSOP-8 or DIP-8 |
| Cost | ~$3-5 each |

Four sensors are needed (one per hole pair). Total sensor mass: 2g. These are wired to the Arduino Nano Zero or directly to the flight controller's ADC pins.

### 2.3 Probe Tip Geometry

The probe tip (3D-08) is a 3D-printed part with:
- 4mm outer diameter tip
- 4 holes at 90° spacing, each 0.5mm diameter
- 45° chamfer on each hole to reduce turbulence
- Central 1mm bore for total pressure reference
- Mounting on 3mm carbon tube mast (40mm above nose cone)

> ⚠️ NOTE: The carbon tube mast is electrically conductive. It must be electrically isolated from the BFRP spiral body using a 2mm PEEK sleeve at the base mount. This is consistent with the Stellar-Aegis non-inductive protocol.

### 2.4 Wind Speed Calculation (on-device)

The flight controller firmware calculates wind speed from pressure differential:
```
V_wind = sqrt(2 × ΔP / ρ)
```

At sea level (ρ = 1.225 kg/m³), detecting V_wind = 10 m/s requires:
```
ΔP = ½ × 1.225 × 100 = 61.25 Pa = 0.06125 kPa
```

The MPXV7002DP minimum detectable pressure is approximately 10 Pa, giving a minimum detectable wind speed of:
```
V_min = sqrt(2 × 0.010 / 1.225) = 0.13 m/s
```

Detection capability: **0.13 to 57 m/s** with the MPXV7002DP sensors. This covers the entire ASB-1 operating envelope (5-25 m/s) with excellent margin.

---

## Part 3: Temperature and Humidity Sensor (SHT31)

**Sensor:** Sensirion SHT31-D

| Specification | Value |
|---|---|
| Temperature range | –40 to +125°C |
| Temperature accuracy | ±0.3°C (typ) |
| Humidity range | 0-100% RH |
| Humidity accuracy | ±2% RH (typ) |
| Interface | I²C (400 kHz) |
| Supply voltage | 2.4-5.5V |
| Mass | 0.1g (chip on breakout board ~0.8g total) |
| Cost | ~$5 on breakout board |
| Response time | 8-15 ms |

**Mounting position:** The SHT31 is mounted on the outside of the electronics bay shell, facing downward into the airstream. This provides an unobstructed view of the surrounding atmosphere without the heated air from the electronics bay contaminating the measurement. A 3mm BFRP shield plate deflects direct sunlight off the sensor to avoid radiation heating error.

---

## Part 4: Barometric Altimeter (BMP388)

**Sensor:** Bosch BMP388 (integrated into the SpeedyBee FC)

| Specification | Value |
|---|---|
| Pressure range | 300-1250 hPa |
| Pressure resolution | 0.016 Pa |
| Altitude resolution | ≈ 0.13 cm in still air |
| Altitude accuracy | ±0.5 m (typical, absolute) |
| Temperature coefficient | 0.0003 hPa/°C (compensated) |
| Interface | SPI or I²C |
| Mass | Integrated in FC (0g additional) |

The BMP388 is used for altitude tracking because GPS altitude accuracy is typically ±3-5m (worse than barometric). For the atmospheric boundary layer research mission, 0.5m altitude accuracy with 0.13cm resolution is excellent.

**Altitude calculation:**
```
h = 44330 × (1 − (P/P0)^(1/5.255))
```

Where P0 is the reference pressure at launch altitude (set automatically at power-on).

---

## Part 5: IMU — Inertial Measurement Unit

The IMU is integrated in the SpeedyBee F405 Wing Mini flight controller. It provides:

| Axis | Sensor | Resolution |
|---|---|---|
| 3-axis accelerometer | ICM-42688-P | ±16g, 0.0005g resolution |
| 3-axis gyroscope | ICM-42688-P | ±2000°/s, 0.061°/s resolution |
| Magnetometer (optional) | HMC5883L breakout | ±1300 µT, ±0.73 µT resolution |

The IMU serves two purposes in the ASB-1:
1. **Attitude correction** — the spiral body spins constantly. Without IMU data, the 4-hole probe does not know which direction it is pointing at any moment. The IMU provides real-time heading and attitude, allowing the pressure probe measurement to be corrected to a geographic (N/S/E/W/up/down) reference frame.
2. **Spin rate monitoring** — the gyroscope Z-axis measures the spin rate of the spiral body. This data is displayed on the ground station and is used by the speed governor algorithm.

---

## Part 6: GPS Module Data

**Module:** u-blox M8N (or SAM-M10Q for mass-reduced variant)

| Specification | Value |
|---|---|
| Update rate | 10 Hz (configurable to 18 Hz) |
| Position accuracy | ±2.5m CEP (circular error probable) |
| Altitude accuracy | ±3m (GPS alone), ±0.5m (blended with BMP388) |
| Velocity accuracy | ±0.1 m/s |
| Acquisition time | < 30 sec (warm start); < 60 sec (cold start) |

GPS position is used for swarm grid mapping. Each unit reports its lat/lon at 1 Hz to the ground station. The ground station builds a real-time 3D scatter plot showing each ASB-1 unit as a colored dot at its GPS position and altitude. Wind vectors calculated at each unit's position are overlaid on the map.

---

## Part 7: Data Architecture and Logging

### 7.1 On-Device Data Processing

The SpeedyBee FC (or equivalent Betaflight/ArduPilot FC) runs a lightweight data fusion algorithm:

1. Read all sensors at 10 Hz (GPS), 100 Hz (pressure probe), 1000 Hz (IMU)
2. Fuse baro + GPS altitude (complementary filter)
3. Apply spin rate correction to pressure probe readings using IMU heading
4. Calculate 3D wind vector in geographic frame (u, v, w)
5. Package data into LoRa telemetry packet
6. Transmit at 1 Hz (every second) to ground station
7. Log raw data to onboard microSD card at 10 Hz

### 7.2 LoRa Telemetry Packet Structure

Each packet is 32 bytes, transmitted at 1 Hz:

| Bytes | Field | Format | Range |
|---|---|---|---|
| 0 | Node ID | uint8 | 1-20 |
| 1 | Sequence number | uint8 | 0-255 (wraps) |
| 2-3 | Latitude (offset from launch) | int16, 0.001° LSB | ±32° offset |
| 4-5 | Longitude (offset from launch) | int16, 0.001° LSB | ±32° offset |
| 6-7 | Altitude AGL | uint16, 0.1m LSB | 0-6553.5m |
| 8-9 | Wind speed E component (u) | int16, 0.01 m/s LSB | ±327 m/s |
| 10-11 | Wind speed N component (v) | int16, 0.01 m/s LSB | ±327 m/s |
| 12-13 | Wind speed vertical (w) | int16, 0.01 m/s LSB | ±327 m/s |
| 14-15 | Temperature | int16, 0.01°C LSB | ±327°C |
| 16-17 | Humidity | uint16, 0.01% LSB | 0-100% RH |
| 18-19 | Pressure | uint16, 0.1 hPa LSB | 0-6553.5 hPa |
| 20 | Battery voltage | uint8, 50mV LSB | 0-12.75V |
| 21 | Spin rate | uint8, 100 RPM LSB | 0-25,500 RPM |
| 22 | Status flags | uint8 bitfield | FTS armed, GPS fix, etc. |
| 23 | CRC-8 checksum | uint8 | Packet integrity |

Total: 24 bytes per packet per unit, transmitted once per second per unit, easily handled by LoRa at SF7/BW125 (≈ 5 kbps effective rate, 20 units = 480 bytes/second = well within capacity).

---

## Part 8: Research Data Products

After a swarm flight, the ground station generates the following output files:

1. **3D_wind_map.csv** — lat, lon, altitude, u, v, w for every measurement point, every second
2. **altitude_profile_unit_X.csv** — altitude vs. wind speed profile for each unit (vertical sounding)
3. **swarm_formation.png** — screenshot of swarm position map at peak altitude
4. **raw_telemetry_YYYYMMDD.json** — complete raw telemetry archive for post-processing

These files are the deliverable for any university research report or FAA aeronautical research waiver submission.

---

## CHECKPOINT — Vol-06 Complete

Before proceeding, confirm:
- [ ] You understand how the 4-hole pressure probe measures 3D wind velocity
- [ ] You know the minimum detectable wind speed: 0.13 m/s (MPXV7002DP)
- [ ] You understand how IMU attitude data corrects wind measurement to geographic coordinates
- [ ] You know the LoRa packet structure and transmission rate (1 Hz per unit, 24 bytes)
- [ ] You understand the 3 key output files (3D wind map, altitude profile, raw telemetry)

**Proceed to:** Vol-07 (LoRa Telemetry System) or Vol-18 (Electronics Bay)

---

*CSMFAB000000000114-Vol-06 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
