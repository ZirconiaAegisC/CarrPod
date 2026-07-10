# CSMFAB0116-24 — POCKET WATCH X: HAPTIC FEEDBACK MODULE
## 1. ACTUATOR SPECIFICATION
| Parameter | Value |
|-----------|-------|
| Type | LRA (Linear Resonant Actuator) |
| Manufacturer | AAC Technologies / Jinlong |
| Dimensions | 10 × 5 × 2.5 mm |
| Resonant frequency | 175 Hz |
| Acceleration | 2.0 Gpp |
| Rise time | 10 ms |
| Stop time | 8 ms |
| Rated voltage | 2.8 Vrms |
| Max voltage | 3.6 Vrms |
| Drive IC | TI DRV2605L (haptic driver with effects library) |
| Interface | I²C |
| Power (max click) | 150 mW |
| Power (idle) | < 1 µW |

## 2. HAPTIC EFFECT LIBRARY
| Effect | Description | Duration |
|--------|-------------|----------|
| Click | Short crisp tap | 15 ms |
| Double click | Two quick taps | 30 ms |
| Thud | Soft deep pulse | 50 ms |
| Buzz | Sustained vibration | 500 ms |
| Ramp up | Increasing intensity | 200 ms |
| Ramp down | Decreasing intensity | 200 ms |
| Tick | Ultra-short pulse | 5 ms |
| Heartbeat | Two-pulse rhythm | 200 ms |
| Crown detent | Simulated mechanical click | Continuous at 30 ms |

## 3. MOUNTING
- LRA mounted via adhesive pad (3M VHB) to housing inner wall.
- Isolated from PCB via foam gasket (prevents rattling).
- Resonant frequency tuned post-assembly via automatic calibration sweep.

## 4. USE CASES
- Button press feedback (crown, soft keys).
- Notifications (different patterns for different apps).
- Scrolling detents (crown rotation simulation).
- Keyboard feedback (when docked to keyboard dock).
- Gaming feedback (API exposed to fin GPU driver).
