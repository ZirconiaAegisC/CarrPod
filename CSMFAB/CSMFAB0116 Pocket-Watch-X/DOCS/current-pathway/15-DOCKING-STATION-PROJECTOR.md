# CSMFAB0116-15 — POCKET WATCH X: DOCKING STATION — PROJECTOR
## 1. SPECIFICATION
The Projector Dock is a desktop docking station that projects the Pocket Watch X display onto a wall or screen.
| Parameter | Value |
|-----------|-------|
| Projection technology | DLP Pico (Texas Instruments DLP230NP) |
| Native resolution | 1920 × 1080 (Full HD) |
| Brightness | 200 ANSI lumens |
| Contrast ratio | 1000:1 |
| Throw ratio | 1.2:1 |
| Image size | 30-120 inch diagonal |
| Focus | Autofocus (camera-based, < 2s) |
| Keystone correction | Automatic ±40° horizontal/vertical |
| Lamp life | 20,000 hours (LED, non-replaceable) |
| Audio | 2× 3W stereo speakers |
| Dimensions | 120 × 80 × 30 mm |
| Weight | 280 g |
| Power | USB-C PD input (20V/3A, 60W) |

## 2. DOCK CONNECTOR
| Parameter | Value |
|-----------|-------|
| Pocket Watch X connection | Rear divot array (40-pin pogo) |
| Additional ports | 2× USB-C (USB 3.2 Gen2, 10 Gbps), 1× HDMI 2.1 output |
| Power delivery to watch | 15W wireless (Qi2 MPP) + USB PD |
| Watch retention | Magnetic ring + mechanical latch |

## 3. OPERATION
1. Drop Pocket Watch X onto projector dock — magnetic alignment engages.
2. Watch detects PROJECTOR dock type via DOCK_DETECT[1:0] = 01.
3. Watch switches to Desktop Mode UI (windowed, multi-tasking).
4. Projector powers on LED, autofocuses within 2 seconds.
5. USB-C hub enumerates connected peripherals.
6. Audio routes to dock speakers.

## 4. COOLING
Built-in 25mm blower fan (22 dBA) that activates when projector dock detects watch thermal load above 15W. Forced air through divot gap cools the watch housing by 5-10°C.

## 5. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| Brightness | ANSI lumens measurement | ≥ 200 lm |
| Focus time | Timer from insertion to sharp image | < 2 s |
| Keystone | ±40° tilt, measure geometry | < 1% distortion |
| Fan noise | SPL meter at 30 cm | < 25 dBA at max |

