# CSMFAB0116-48 — VIBRATION MOTOR SPECIFICATION
## 1. LRA DETAILS
| Parameter | Value |
|-----------|-------|
| Type | Linear Resonant Actuator |
| Part | AAC Technologies ELV1411A or equivalent |
| Dimensions | 10 × 5 × 2.5 mm |
| Resonant frequency | 175 Hz ±5 Hz |
| Acceleration | 2.0 Gpp (peak-to-peak) |
| Rise time (0-90%) | 10 ms |
| Stop time (100-10%) | 8 ms |
| Rated voltage | 2.8 Vrms |
| Rated current | 110 mArms |
| DC resistance | 18 Ω |
| Drive IC | TI DRV2605L |
| Interface | I²C |

## 2. EFFECT AUTHORING
| Effect | Waveform |
|--------|----------|
| Short click | 15 ms sine at resonance |
| Medium click | 30 ms sine at resonance |
| Strong click | 60 ms sine with overdrive |
| Double click | Two 10 ms pulses, 20 ms gap |
| Ramp | Linear amplitude ramp over 200 ms |

