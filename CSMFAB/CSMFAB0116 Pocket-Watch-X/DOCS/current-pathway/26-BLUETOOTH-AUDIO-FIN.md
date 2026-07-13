# CSMFAB0116-26 — POCKET WATCH X: BLUETOOTH AUDIO FIN
## 1. SPECIFICATION
| Parameter | Value |
|-----------|-------|
| Bluetooth | BT 5.4 with LE Audio |
| Audio codecs | SBC, AAC, aptX, aptX HD, aptX Adaptive, LDAC, LC3 |
| Sample rates | 44.1, 48, 96 kHz |
| Bit depth | 16, 24-bit |
| DAC | ESS ES9219C (32-bit, 130 dB SNR) |
| Headphone output | 3.5 mm TRRS jack |
| Output power | 2 Vrms into 32 Ω |
| Output impedance | < 1 Ω |
| Balanced output | Optional 2.5 mm TRRS |
| THD+N | < 0.0005% at 1 kHz |
| SNR | 130 dB |

## 2. FEATURES
- Auracast broadcast audio support.
- Multi-point: connect to 2 devices simultaneously.
- USB audio class 2.0 when fin connected via fin bus.
- High-gain mode for high-impedance headphones (detected automatically).

## 3. POWER
| Mode | Power |
|------|-------|
| Playback (32 Ω) | 120 mW |
| Idle | 5 mW |
| Sleep | < 0.5 mW |

## 4. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| THD+N | Audio Precision analyzer | < 0.001% at 1 kHz, 0 dBFS |
| SNR | A-weighted | > 125 dB |
| Codec compatibility | Test with all listed codecs | All functional |
| Range | Open air, SBC | > 10m |
