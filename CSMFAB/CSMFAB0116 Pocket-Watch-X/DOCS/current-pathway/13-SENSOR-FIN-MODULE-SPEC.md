# CSMFAB0116-13 — POCKET WATCH X: SENSOR FIN MODULE SPECIFICATION
**Revision:** A | **Dependencies:** 04-FIN-INTERFACE-SPECIFICATION

## 1. PURPOSE
The Sensor Fin provides environmental and motion sensing capabilities. It includes a dedicated sensor fusion MCU for local processing.

## 2. SENSOR SUITE
| Sensor | Part | Range | Accuracy | Rate |
|--------|------|-------|----------|------|
| Accelerometer | Bosch BMI270 | ±16g | ±0.5 mg | 1600 Hz |
| Gyroscope | Bosch BMI270 | ±2000 dps | ±0.05 dps | 1600 Hz |
| Magnetometer | AKM AK09970N | ±4912 µT | ±0.3 µT | 200 Hz |
| Barometer | Bosch BMP581 | 300-1250 hPa | ±6 Pa (±5 cm) | 400 Hz |
| Temperature | Sensirion SHT45 | -40 to +125°C | ±0.1°C | 10 Hz |
| Humidity | Sensirion SHT45 | 0-100% RH | ±1.0% RH | 10 Hz |
| Ambient light | Vishay VEML7700 | 0-120 klx | ±5% | 100 Hz |
| UV index | Vishay VEML6075 | UVA/UVB | ±1 UVI | 10 Hz |
| PPG (HR) | Maxim MAX86178 | — | — | 512 Hz |
| Microphone | Knowles SPH0641LU | 120 dB SPL | ±1 dB | 48 kHz |

## 3. SENSOR FUSION MCU
| Parameter | Value |
|-----------|-------|
| MCU | STM32U5 (ARM Cortex-M33, 160 MHz) |
| RAM | 2 MB SRAM |
| Flash | 4 MB |
| Sensor interface | Dedicated SPI/I²C busses |
| Fusion output | Quaternion, Euler, heading, gravity, linear accel at 400 Hz |
| Power | 15 mW (always-on sensor hub mode) |

## 4. SENSOR FUSION ALGORITHMS
| Algorithm | Description | Rate |
|-----------|-------------|------|
| 9-axis IMU fusion | Accel+Gyro+Mag → attitude quaternion | 400 Hz |
| Pedometer | Step count + cadence | Real-time |
| Activity classifier | Still/Walk/Run/Bike/Vehicle | 25 Hz |
| Altitude tracking | Baro+IMU fusion (no GPS needed) | 100 Hz |
| Tap detection | Double-tap on housing | Interrupt-driven |
| Free-fall | Zero-g detection | Interrupt-driven |
| Tilt/gesture | Wrist-tilt detection | 50 Hz |

## 5. DATA STREAMING PROTOCOL
Sensors stream data to main SoC via I²C (1 MHz) or dedicated I²S (audio). Format:

| Byte offset | Field |
|-------------|-------|
| 0 | Packet type (0x01 = IMU, 0x02 = Environmental, 0x03 = Biometric) |
| 1 | Timestamp (ms since last packet, uint16) |
| 3-N | Sensor data (packed struct, type-specific) |
| N+1 | CRC-8 |

## 6. POWER MODES
| Mode | Power | Sensors Active |
|------|-------|---------------|
| Always-on (AOD) | 2 mW | Accel (25 Hz) + baro (1 Hz) |
| Motion tracking | 15 mW | All IMU (400 Hz) + baro (100 Hz) |
| Full environment | 25 mW | All sensors at nominal rates |
| Audio sensing | 30 mW | Mic + keyword detection |
| Sleep | 5 µW | Wake-on-motion interrupt |

## 7. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Accel calibration | 6-point tumble | < 5 mg residual |
| Gyro calibration | Rate table, ±1000 dps | < 0.1 dps residual |
| Mag calibration | Helmholtz coil | < 1 µT residual |
| Barometer accuracy | Pressure chamber | ±6 Pa (±0.5m) |
| Temperature accuracy | Thermal chamber vs NIST ref | ±0.2°C |
| Humidity accuracy | Salt bath calibration | ±2% RH |
| Sensor fusion heading | Rotate ±180°, compare to ref | < 2° RMS error |
| Power | Precision ammeter per mode | Within 10% of spec |

