# CSMFAB0116-55 — AMBIENT LIGHT AND PROXIMITY SENSOR
## 1. AMBIENT LIGHT SENSOR
| Parameter | Value |
|-----------|-------|
| Sensor | Vishay VEML7700-TT |
| Channels | ALS (ambient), White |
| Range | 0.01 — 120 klx |
| Resolution | 0.0042 lx/ct |
| ADC | 16-bit |
| I²C address | 0x10 |
| Power (active) | 45 µW |
| Power (shutdown) | 0.5 µW |

## 2. PROXIMITY SENSOR
| Parameter | Value |
|-----------|-------|
| Type | IR LED + photodiode |
| Wavelength | 940 nm |
| Range | 0 — 10 cm |
| Application | Detect face near screen during call, disable touch |

## 3. AUTO-BRIGHTNESS ALGORITHM
| Ambient Light | Display Brightness |
|---------------|-------------------|
| 0 lux (dark) | 2 nit |
| 50 lux (dim room) | 20 nit |
| 500 lux (office) | 100 nit |
| 5000 lux (overcast) | 300 nit |
| 10000 lux (daylight) | 800 nit |
| 100000 lux (direct sun) | 2000 nit |

