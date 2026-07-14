# CSMFAB0116-25 — POCKET WATCH X: AUDIO SUBSYSTEM
## 1. SPEAKER
| Parameter | Value |
|-----------|-------|
| Type | Dynamic micro-speaker |
| Driver size | 11 × 7 mm oval |
| Impedance | 8 Ω |
| Rated power | 0.5 W |
| Max power | 1.0 W |
| Frequency response | 400 Hz — 20 kHz (±6 dB) |
| SPL | 80 dB at 10 cm, 0.5W |
| THD | < 5% at rated power |
| Water protection | Gore-Tex membrane over port |
| Port location | Side of housing, 3.0 × 0.5 mm slot |

## 2. MICROPHONE
| Parameter | Value |
|-----------|-------|
| Type | MEMS analog (Knowles SPH0641LU) |
| Sensitivity | -26 dBFS (94 dB SPL, 1 kHz) |
| SNR | 64.5 dBA |
| Frequency response | 100 Hz — 10 kHz |
| Max SPL | 120 dB |
| Directivity | Omnidirectional |
| Port location | Side of housing, 1.0 mm hole with mesh |
| Always-on capability | Yes (keyword detection, < 1 mW) |

## 3. AUDIO CODEC
| Parameter | Value |
|-----------|-------|
| IC | Cirrus Logic CS42L52 or Wolfson WM8994 |
| DAC | 24-bit, 96 kHz |
| ADC | 24-bit, 96 kHz |
| Interfaces | I²S to SoC, I²C for control |
| Headphone output | Via audio fin or USB-C |
| DSP | 5-band EQ, dynamic range compression |
| Power (playback) | 8 mW |
| Power (idle) | < 10 µW |

## 4. VOICE COMMAND PIPELINE
1. Always-on microphone captures audio.
2. Zephyr RTOS on sensor MCU runs keyword detection ("Hey Pocket" or custom).
3. On keyword detection, wakes main SoC.
4. Audio streamed to main SoC for cloud or on-device ASR.
5. NLU engine processes intent.
6. TTS response played through speaker.

## 5. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Speaker SPL | SPL meter at 10 cm, 0.5W | > 78 dBA |
| Speaker THD | Audio analyzer at 1 kHz | < 5% |
| Mic SNR | Anechoic chamber | > 62 dBA |
| Keyword detection | 100 utterances in noise | > 95% accuracy |
| Water resistance | IP68 submersion, play audio after dry | No degradation |
