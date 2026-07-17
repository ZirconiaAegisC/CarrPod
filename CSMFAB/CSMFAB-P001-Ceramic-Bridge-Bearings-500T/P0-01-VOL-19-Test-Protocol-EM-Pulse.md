# P0-01-VOL-19: Test Protocol — EM Pulse + GIC Simulation
## CSMFAB-P001 | Ceramic Bridge Bearings 500T

---

## EM PULSE TEST BATTERY

### TEST EM-01: Conducted GIC Simulation (Factory Sample)

| Parameter | Value |
|-----------|-------|
| Applied current | DC, 0-200A ramp |
| Path | Top anchor bolt → bearing assembly → bottom anchor bolt |
| Measurement | Voltage drop across bearing, current on bottom side |
| Pass criterion | Voltage drop demonstrates >10⁸ Ω·m effective resistivity; bottom current <0.1A |
| Frequency | 1 per 500 units |

### TEST EM-02: Radiated EM Field Immunity

| Parameter | Value |
|-----------|-------|
| Field strength | 50 V/m, 10 kHz — 10 GHz sweep |
| Standard | MIL-STD-461G, RS103 |
| Measurement | Induced voltage on bearing housing surface |
| Pass criterion | Induced voltage <1V at any frequency |
| Frequency | First article only |

### TEST EM-03: Magnetic Field Saturation

| Parameter | Value |
|-----------|-------|
| Applied B-field | DC, 0-1.0 T |
| Measurement | Magnetic flux through bearing assembly |
| Pass criterion | ZTA is non-magnetic — flux density unchanged (±1%) from free-air baseline |
| Frequency | First article only |

### TEST EM-04: Lightning Strike Indirect Effects

| Parameter | Value |
|-----------|-------|
| Waveform | 8/20 μs current pulse, 100 kA peak (per IEC 62305) |
| Path | Bridge girder → bearing → substructure |
| Measurement | Bearing integrity post-strike |
| Pass criterion | No physical damage, dielectric unchanged |
| Frequency | First article only |
