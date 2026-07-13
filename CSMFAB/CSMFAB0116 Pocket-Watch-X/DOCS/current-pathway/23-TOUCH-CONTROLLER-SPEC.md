# CSMFAB0116-23 — POCKET WATCH X: TOUCH CONTROLLER SPECIFICATION
## 1. CONTROLLER SPECS
| Parameter | Value |
|-----------|-------|
| IC | Synaptics S3908 / FocalTech FT3681 |
| Technology | Mutual capacitance |
| Channels | 32 TX × 32 RX (1024 nodes) |
| Scan rate | 240 Hz |
| Report rate | 240 Hz (active), 60 Hz (idle) |
| Latency (touch-down) | < 12 ms |
| Resolution | 4096 × 4096 |
| Multi-touch | 10 simultaneous contacts |
| Touch size detection | Yes (1-20 mm diameter) |
| Palm rejection | AI-based classifier |
| Wet-finger | Frequency hopping mode |
| Glove mode | Increased sensitivity, user-togglable |
| Stylus | Active capacitive (USI 2.0, WGP, MPP) |
| Stylus pressure | 4096 levels |
| Stylus tilt | ±60° |
| Power (active) | 15 mW |
| Power (idle) | 0.5 mW |
| Sleep wake-up | Touch-to-wake in < 50 ms |

## 2. FIRMWARE FEATURES
- Noise adaptation: automatically adjusts thresholds for charger noise.
- Grip suppression: detects fingers holding device edge, rejects.
- Water rejection: locks touch during submersion, unlocks when dry.
- Proximity detection: senses face near screen during call.

## 3. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Touch accuracy | Robot finger, 100-point grid | Error < 0.5 mm |
| Linearity | Draw diagonal line | Deviation < 0.3 mm |
| Jitter | Hold stationary touch | < 0.2 mm peak-to-peak |
| Latency | High-speed camera (1000 fps) | < 12 ms |
| Wet test | Water droplet on surface | No false touches |
| Glove test | 1.5 mm leather glove | All touches detected |
