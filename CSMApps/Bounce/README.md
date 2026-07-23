# Bounce — TAF/DMV Vehicle Mesh Network

**Version 1.0.64 | CarrPod — Safe Pod Engineering Company**
**2026-07-23**

---

## What Is Bounce?

Bounce is a **vehicle-to-vehicle mesh network visualization system** for Android.
It simulates how vehicles could broadcast their trajectory, status, and hazard
information by rapidly rotating their Wi-Fi SSID — not as a hotspot, but as a
one-way beacon readable by any nearby receiver without connecting. This is
inspired by the FAA's TAF (Terminal Aerodrome Forecast), METAR weather codes,
DMV vehicle registration data, and ICAO NOTAM/pilot report standards.

The app scans the local radio environment (Wi-Fi + Bluetooth LE) and paints all
emitting devices as 3D dots around a central "tardigrade" sphere representing
your vehicle. It broadcasts a rotating sequence of 4 SSIDs carrying license
plate, trajectory, human-readable speed/direction, and FAA METAR wind in standard
aviation format.

---

## Architecture

```
┌─────────────────────────────────────────────────┐
│                 Android APK (~201 KB)            │
│  ┌─────────────────────────────────────────┐    │
│  │  MainActivity.java (WebView host)        │    │
│  │  ┌─ WifiManager (Wi-Fi scanning)         │    │
│  │  ├─ BluetoothLeScanner (BLE scanning)    │    │
│  │  ├─ WifiP2pManager (SSID broadcast)      │    │
│  │  ├─ LocationManager (GPS tracking)       │    │
│  │  ├─ SensorManager (compass + accelerom.) │    │
│  │  ├─ PowerManager (wake lock for trail)   │    │
│  │  └─ WebView → JsBridge → bounce.html     │    │
│  └─────────────────────────────────────────┘    │
│  ┌─────────────────────────────────────────┐    │
│  │  bounce.html (~550 lines)                │    │
│  │  ┌─ Three.js r128 (3D rendering)         │    │
│  │  ├─ OrbitControls (camera)               │    │
│  │  ├─ EffectComposer + UnrealBloomPass     │    │
│  │  ├─ Tardigrade sphere + beacon dots      │    │
│  │  ├─ CatmullRom trail line (GPU-safe)     │    │
│  │  ├─ Tab-tuck HUD panels (4 panels)       │    │
│  │  └─ Spring-physics fly camera            │    │
│  └─────────────────────────────────────────┘    │
└─────────────────────────────────────────────────┘
```

### Build Pipeline (No Gradle, No AndroidX)

```
aapt2 compile → aapt2 link → asset injection → javac → d8 → zipalign → apksigner
```

**Toolchain:** JDK 17 (Adoptium), aapt2 33.0.1, d8 33.0.1, zipalign 33.0.1, apksigner 33.0.1
**Target:** API 33 (Android 13), Min: API 24 (Android 7.0)

---

## Features

### 3D Visualization
| Feature | Detail |
|---------|--------|
| **Tardigrade Sphere** | 2-lobe orange/amber mesh with eyes, wireframe cage, torus ring |
| **Vehicle Beacons** | Colored dots with ring indicators and floating labels |
| **Beacon Physics** | Repulsion + spring attraction (billiard-ball bouncing) |
| **Grid Floor** | 40×40 grid with N/S/E/W compass rose markers |
| **BT Device Dots** | Blue 3D spheres at estimated RSSI distance, pulsing glow |
| **Trail Line** | CatmullRom smooth curve tracking vehicle movement, auto-saves every 60s |
| **UnrealBloomPass** | HDR glow post-processing pipeline |
| **ACES Tone Mapping** | Cinematic color grading (HTML demo only) |

### Camera Modes
| Mode | Description |
|------|-------------|
| **Orbit** | Pinch-zoom, rotate, pan (OrbitControls with auto-spin) |
| **FLY** | Tours all SSID waypoints with spring-physics camera, infinite loop |
| **POV** | Chase camera behind vehicle at adjustable distance (10–120 units) |

### HUD Panels (Tab-Tuck) — Left Side
| Panel | Content |
|-------|---------|
| **BT** | Bluetooth device list (name, RSSI dBm, distance in meters) |
| **SCAN** | Live Wi-Fi access point list (SSID, RSSI dBm, distance, persistence) |
| **BEACONS** | My Trajectory (heading, speed, altitude, GPS, plate, origin key, orientation) + Scanner list |

### HUD Panels (Tab-Tuck) — Right Side
| Panel | Content |
|-------|---------|
| **FORGE** | Controls (buttons), Legend (color guide), Wi-Fi Scanner |
| **Legend** | Color guide + FAA METAR code table (RA, SN, FG, TS, BR, HZ, FZ) + Wind format |

### Radio Scanning
| Radio | Method | Interval | Data Yield |
|-------|--------|----------|-----------|
| **Wi-Fi** | WifiManager.startScan() + BroadcastReceiver | 1000ms | SSID, BSSID, RSSI (dBm), estimated distance (m) |
| **Bluetooth LE** | BluetoothLeScanner.startScan() + ScanCallback | Continuous (LOW_LATENCY) | Device name, MAC, RSSI (dBm), estimated distance |

### GPS & Sensors
| Sensor | Purpose |
|--------|---------|
| **GPS** | Heading (bearing), speed (mph), altitude (ft), lat/lng position |
| **Accelerometer** | Gravity vector for device orientation |
| **Magnetometer** | Compass heading (fallback when GPS stationary) |
| **Fusion** | getRotationMatrix() → getOrientation() → azimuth + pitch |

### SSID Broadcast (Wi-Fi Direct Group Owner)
```
Slot 0: {key}{license_plate}        Example: A7KCarrPodNet
Slot 1: {key}TA{hdg}{spd}{fleet}{make}{color}G{gps}  Example: A7KTA090CIV065G26717430
Slot 2: {key}HD{hdg}-{dir}-{spd}mph   Example: A7KHD090-NE-65mph
Slot 3: {key}{hdg}KT                   Example: A7K090KT

Duty cycle: 5.1s per slot (2.5s broadcast + 2.6s dead time)
5GHz band: setGroupOperatingBand(GROUP_OWNER_BAND_5GHZ)
```

**Broadcast methods (in priority order):**
1. `WifiP2pConfig.Builder` (API 29+) — autonomous Group Owner with custom SSID
2. Reflection `setDeviceName()` (legacy, API <30)
3. Bonjour DNS-SD service advertising (fallback)

### Trail System
| Feature | Detail |
|---------|--------|
| **Recording** | Continuous GPS-based trail recording at full frame rate |
| **Rendering** | CatmullRomCurve3 smooth spline through points, rebuilt every 5 frames |
| **GPU Safety** | Old geometries disposed via `geometry.dispose()` + `material.dispose()` |
| **Point Cap** | 2000 points max (oldest shifted out) |
| **Auto-Save** | Every 60 seconds: `trail-0.json`, `trail-1.json`, ... |
| **Stationary Filter** | Removed in v1.0.61 — records continuously |
| **Background** | Wake lock keeps CPU alive with screen off |

### FAA Code Table
| Code | Meaning | Category |
|------|---------|----------|
| RA | Rain | Precipitation |
| SN | Snow | Precipitation |
| FG | Fog | Obscuration |
| TS | Thunderstorm | Hazard |
| BR | Mist | Obscuration |
| HZ | Haze | Obscuration |
| FZ | Freezing | Modifier |
| 09010KT | Wind 090° at 10 knots | Wind format |
| FEW/BKN/OVC/CLR | Cloud coverage | Sky condition |

### Feature List (Built-In Trackers)
| Feature | Status |
|---------|--------|
| 3D Alphabet Engine | ✅ |
| Sphere Collision Physics | ✅ |
| Floating Dot Swarms | ✅ |
| UnrealBloomPass Rendering | ✅ |
| Orbit Camera Controls | ✅ |
| Flight Path (FLY) | ✅ |
| Tab-Tuck HUD System | ✅ |
| POV Chase Camera | ✅ |
| Wi-Fi Scanning (real) | ✅ |
| Bluetooth LE Scanning | ✅ |
| Wi-Fi Direct Broadcast | ✅ |
| FAA METAR Code Table | ✅ |
| Trail Recording (auto-save) | ✅ |
| GPS Speed/Heading/Altitude | ✅ |
| Compass + Accelerometer | ✅ |
| Wake Lock (background) | ✅ |
| aapt2 No-Gradle Build | ✅ |
| Adaptive Icon System | ✅ |

---

## Permissions Required

| Permission | Purpose | API Level |
|-----------|---------|-----------|
| INTERNET | WebView content | All |
| ACCESS_WIFI_STATE | Wi-Fi scanning | All |
| CHANGE_WIFI_STATE | Wi-Fi Direct broadcast | All |
| ACCESS_FINE_LOCATION | GPS + legacy Wi-Fi scanning | All |
| ACCESS_COARSE_LOCATION | Coarse GPS | All |
| ACCESS_BACKGROUND_LOCATION | Background GPS | 29+ |
| ACCESS_NETWORK_STATE | Network status | All |
| CHANGE_NETWORK_STATE | P2P operations | All |
| NEARBY_WIFI_DEVICES | Wi-Fi scanning (API 33+) | 33+ |
| BLUETOOTH_SCAN | BLE scanning | 31+ |
| BLUETOOTH_CONNECT | BLE operations | 31+ |
| BLUETOOTH_ADVERTISE | BLE advertising | 31+ |
| BLUETOOTH (legacy) | BT access (API ≤30) | All |
| BLUETOOTH_ADMIN (legacy) | BT admin (API ≤30) | All |
| WAKE_LOCK | Background trail recording | All |

---

## Version History (Selected)

| Version | Key Change |
|---------|-----------|
| v1.0.0 | Initial Bounce app |
| v1.0.14 | Wi-Fi Direct custom SSID (P2pConfig) |
| v1.0.20 | Duty-cycle SSID broadcast (5s ON, 2.5s OFF) |
| v1.0.22 | 4-slot broadcast + 3-digit originator key |
| v1.0.25 | Magnetometer + accelerometer sensor fusion |
| v1.0.27 | Real GPS mph (zero-fix when stationary) |
| v1.0.28 | POV zoomed out 5× |
| v1.0.30 | Real Wi-Fi scanner with dBm + distance |
| v1.0.35 | Removed simulated scanner, real data only |
| v1.0.38 | SCAN pullout panel above BEACONS |
| v1.0.48 | Bluetooth LE scanning (BT tab panel) |
| v1.0.49 | BT 3D dots, TRAIL button, SAVE export |
| v1.0.50 | BT pulse glow, POV zoom buttons, default plate |
| v1.0.54 | Trail decimation prevents crash (GPU fix) |
| v1.0.57 | Auto-save trail every 60s |
| v1.0.60 | Clean v1.0.55 base + all fixes via Python |
| v1.0.62 | CatmullRom smooth trail curves |
| v1.0.63 | Wake lock for background trail recording |
| v1.0.64 | FAA METAR code table + 4th broadcast slot |

---

## Build & Deploy

```bash
# Prerequisites
export JAVA_HOME=.sdk/jdk17
export ANDROID_HOME=.sdk/android-sdk

# Build
cd CSMApps/Bounce/v1.0.64 && bash build.sh

# Output
out/Bounce-v1.0.64.apk  (~201 KB, signed, installable)
```

**Minimum Android:** API 24 (Android 7.0)
**Target Android:** API 33 (Android 13)
**Permissions:** 15 permissions (see above)
**Build time:** ~4 seconds

---

*CarrPod — Safe Pod Engineering Company*
*Document generated 2026-07-23*
