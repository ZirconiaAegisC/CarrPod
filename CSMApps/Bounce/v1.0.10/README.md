# Bounce v1.0.0 — Technical Documentation

**TAF/DMV Vehicle Mesh Network**
**CarrPod — Safe Pod Engineering Company**
**2026-07-19**

---

## Purpose

Bounce is a conceptual vehicle-to-vehicle (V2V) mesh network visualization system. It
simulates how vehicles could broadcast their trajectory, status, and hazard information
by rapidly rotating their Wi-Fi SSID — not as a hotspot, but as a one-way beacon that
any nearby receiver can passively read without connecting. This is inspired by the FAA's
TAF (Terminal Aerodrome Forecast) and METAR weather code systems, merged with DMV
vehicle registration data, creating a human-readable but machine-compact broadcast format.

The app visualizes this network in a 3D environment: a central "tardigrade" sphere
represents the user's vehicle, and other vehicles appear as colored beacons positioned
relative to the user, each labeled with its broadcast SSID code.

---

## Architecture

```
┌─────────────────────────────────────────────┐
│                  APK (185 KB)                │
│  ┌─────────────────────────────────────┐    │
│  │         WebView (Android)            │    │
│  │  ┌──────────────────────────────┐   │    │
│  │  │   bounce.html (22 KB)         │   │    │
│  │  │   ┌────────────────────┐      │   │    │
│  │  │   │  Three.js r128     │      │   │    │
│  │  │   │  OrbitControls     │      │   │    │
│  │  │   │  EffectComposer    │      │   │    │
│  │  │   │  UnrealBloomPass   │      │   │    │
│  │  │   │  [3D Scene]        │      │   │    │
│  │  │   └────────────────────┘      │   │    │
│  │  └──────────────────────────────┘   │    │
│  │   MainActivity.java (JsBridge)      │    │
│  └─────────────────────────────────────┘    │
│  AndroidManifest.xml (binary AXML)          │
│  resources.arsc (binary table)              │
│  classes.dex (Dalvik bytecode)              │
└─────────────────────────────────────────────┘
```

### Build Pipeline (No-Gradle, No AndroidX)

```
aapt2 compile  →  resources.zip (.flat files)
aapt2 link     →  base.apk + R.java + binary AndroidManifest + resources.arsc
zip -r         →  asset injection (JS, HTML)
javac          →  .class files (Java 11 bytecode)
d8             →  classes.dex (Dalvik bytecode)
zip            →  dex injection into APK
zipalign       →  4-byte boundary alignment
apksigner      →  debug keystore signing
```

**Toolchain:**
| Tool | Version | Source |
|------|---------|--------|
| JDK | 17.0.19 (Adoptium) | api.adoptium.net |
| aapt2 | 33.0.1 | dl.google.com/android |
| d8 | 33.0.1 | dl.google.com/android |
| zipalign | 33.0.1 | dl.google.com/android |
| apksigner | 33.0.1 | dl.google.com/android |
| android.jar | API 33 (Android 13) | dl.google.com/android |

**Key build parameters:**
- `PACKAGE`: com.carrpod.bounce
- `COMPILE_SDK`: 33, `TARGET_SDK`: 33, `MIN_SDK`: 24
- `VERSION_CODE`: 100, `VERSION_NAME`: 1.0.0

---

## SSID Code System

### Format
```
TAF{heading}{fleet}{speed}-{make}{color}
```

### Field Breakdown

| Field | Position | Values | Example |
|-------|----------|--------|---------|
| `TAF` | Prefix | Fixed | `TAF` |
| `heading` | 3 digits | 000–359 (compass heading) | `145` |
| `fleet` | 3 chars | `CIV` (civilian) or `FLT` (fleet) | `CIV` |
| `speed` | 3 digits | 000–999 (mph, padded) | `065` |
| `-` | Separator | Fixed | `-` |
| `make` | 3 chars | First 3 letters of make, uppercase | `FOR` |
| `color` | 3 chars | First 3 letters of color, uppercase | `WHI` |

### Example Codes
```
TAF090CIV065-FORWHI    → Ford F-150 White, heading East, 65 mph, civilian
TAF270FLT055-TESSIL    → Tesla Model 3 Silver, heading West, 55 mph, fleet
TAF045CIV030-HONRED    → Honda Civic Red, heading NE, 30 mph, civilian
TAF180FLT070-RAMBLA    → RAM 1500 Black, heading South, 70 mph, fleet
```

### DMV Companion Code
```
FL-{yy}-{plate5}
```
Example: `FL-23-47821` (Florida, 2023 model year, plate 47821)

### Hazard Codes
When a vehicle detects a hazard, it appends a hazard tag:
```
FOG_PATCH, ICE_BRIDGE, DEBRIS_LN1, DEBRIS_LN2, ANIMAL_XING,
CONSTRUCTION, ACCIDENT_AHEAD, FLOODING, LOW_VIS, WIND_GUST,
HAIL_RISK, EMERGENCY_VEH
```

### Fleet Key System
- **CIV mode**: Public SSID, readable by all nearby receivers
- **FLT mode**: Fleet vehicles share an encrypted inner code layer that only fleet members can decode, while still broadcasting the public outer SSID for safety

---

## 3D Visualization System

### Scene Composition

```
┌──────────────────────────────────────────────┐
│  FogExp2(0x010206, 0.008)                    │
│  AmbientLight(0x151525)                      │
│  PointLight(0xFFFFFF, 2, 150) @ (0,25,0)     │
│                                              │
│  ┌─ Grid Floor ─────────────────────────┐    │
│  │  40×40 grid, 5-unit spacing          │    │
│  │  0x0A1230 lines, opacity 0.3         │    │
│  │                                      │    │
│  │  ┌─ Compass Rose ───────────────┐    │    │
│  │  │  N: Blue  (0x4488FF)          │    │    │
│  │  │  S: Orange (0xFF6600)          │    │    │
│  │  │  E: Green  (0x00FF88)          │    │    │
│  │  │  W: Red    (0xFF4466)          │    │    │
│  │  └───────────────────────────────┘    │    │
│  └───────────────────────────────────────┘    │
│                                              │
│  ┌─ Tardigrade (You) ────────────────────┐   │
│  │  Top hemisphere: 1.4 radius, orange    │   │
│  │  Bottom lobe: 1.2 radius, offset -0.6  │   │
│  │  Two white eyes @ (+/-0.5, 0.6, 0.9)   │   │
│  │  Wireframe cage: 1.7 radius            │   │
│  │  Torus ring: 1.8 radius, horizontal    │   │
│  └───────────────────────────────────────┘   │
│                                              │
│  ┌─ Vehicle Beacons ─────────────────────┐   │
│  │  Sphere dots: 0.5 radius              │   │
│  │  Torus rings: 0.65 radius             │   │
│  │  Text labels: canvas sprites          │   │
│  │  Physics: repulsion + home spring     │   │
│  └───────────────────────────────────────┘   │
└──────────────────────────────────────────────┘
```

### Tardigrade Sphere (lines 151-175 in bounce.html)

The central vehicle marker uses a two-lobed geometry inspired by tardigrade anatomy:
- **Top hemisphere**: `.SphereGeometry(1.4, 48, 24, 0, 2π, 0, 0.7π)` — phi-limited dome
- **Bottom lobe**: `.SphereGeometry(1.2, 48, 24, 0, 2π, 0.4π, 0.75π)` — offset downward
- **Eyes**: Two small white spheres on the top hemisphere facing forward (+z)
- **Wireframe cage**: Full sphere wireframe at 1.7 radius, 15% opacity
- **Ring**: Torus at 1.8 radius, horizontal, 50% opacity

The tardigrade group rotates slowly (`rotation.y += 0.002`), the wireframe pulses
with `scale.setScalar(1 + sin(t*0.002)*0.06)`, and the ring spins on its Z axis.

### Beacon Beads (lines 178-218)

Each vehicle beacon is a `THREE.Group` containing:
- **Dot**: `SphereGeometry(0.5, 16, 8)` with color based on make or hazard
- **Ring**: `TorusGeometry(0.65, 0.04, 8, 16)` in the same color
- **Label**: `Sprite` with canvas-rendered text (Make initial + Color initial)

### Color Logic

| Condition | Color |
|-----------|-------|
| Hazard present | Red (#FF4466) |
| Fleet vehicle | Green (#00FF88) |
| Civilian | Make-based color from `makeToColor()` |
| Make-based fallback | Vehicle color from `colorToHex()` |

**Make-to-color mapping:**
```javascript
Ford → #2B6EB0 (Ford Blue)
Chevy → #C4982E (Chevy Gold)
Toyota → #CC0000 (Toyota Red)
Honda → #0088CC
BMW → #1C69D4
Tesla → #CC0000
...
```

### Physics Engine (lines 288-303)

```javascript
// Per-frame, per-beacon physics:
for each beacon a:
  for each other beacon b:
    dx = a.x - b.x
    dz = a.z - b.z
    dist = sqrt(dx² + dz²)
    if dist < 4.0:
      overlap = 4.0 - dist
      force = overlap * 6          // repulsion constant
      a.vx += (dx/dist) * force    // push away in x
      a.vz += (dz/dist) * force    // push away in z

  // Spring attraction toward home position
  a.vx += (home.x - a.x) * 0.1
  a.vz += (home.z - a.z) * 0.1

  // Damping
  a.vx *= 0.88
  a.vz *= 0.88

  // Euler integration
  a.x += a.vx * dt
  a.z += a.vz * dt
  a.y += sin(t * 0.0015 + heading * 0.01) * 0.3 * dt  // gentle bob
```

**Physics constants:**
- `REPULSION`: 6.0 (force applied per unit overlap)
- `COLLISION_RANGE`: 4.0 units
- `HOME_SPRING`: 0.1 (attraction to home position)
- `DAMPING`: 0.88 (per-frame velocity multiplier)
- `BOB_AMPLITUDE`: 0.3 (vertical oscillation)

---

## HUD System

### Left Panel: BEACONS
- **My Vehicle**: Heading, speed, altitude, SSID code, fleet key status
- **Nearby Beacons**: Scrollable list of all visible vehicles with SSID, make, status, DMV code, and hazard alerts

### Right Panel: FORGE
- **Controls**: +VEHICLE, +FLEET, SCATTER, RESET
- **Legend**: Color-coded vehicle type indicators
- **App Info**: Version and CarrPod branding

### Tab-Tuck
Each panel has a thin vertical tab (26px wide) that remains visible when the panel is
tucked off screen. Click the tab to toggle the panel in/out. The TUCK button in the
header tucks both panels simultaneously.

### Native Java Buttons (MainActivity.java)
- `+VEHICLE` → `Bounce.addSimVehicle()`
- `+FLEET` → `Bounce.addRandomFleet()`
- `SCATTER` → `Bounce.scatterBeacons()`
- `FLEET KEY` → `Bounce.toggleFleet()` (toggles all beacons CIV ↔ FLT)
- `CLEAN` → hides header overlay for unobstructed 3D view

---

## Flight Path

The FLY button triggers a Catmull-Rom spline camera traversal through 8 random waypoints
over 12 seconds. Implementation (lines 307-309):

```javascript
fly() {
  this._fly = !this._fly;
  if(!this._fly) { this.controls.autoRotate = true; return }
  var wp = [];
  for(var i = 0; i < 8; i++)
    wp.push(new THREE.Vector3(
      (Math.random() - 0.5) * 45,
      (Math.random() - 0.5) * 12,
      (Math.random() - 0.5) * 45));
  this._flyWp = wp;
  this._flyP = 0;
}
```

The spline interpolates 4 control points at a time using Catmull-Rom blending,
and the camera linearly interpolates toward the computed position at lerp rate 0.04
per frame.

---

## Findings & Lessons Learned

### What Works Well
1. **aapt2 pipeline** produces reliable binary manifests and resources.arsc — zero install failures
2. **Canvas sprite labels** are performant even at 60+ beacons (no DOM overhead)
3. **Physics repulsion** creates natural-looking organic movement without expensive collision detection
4. **SSID code readability** — the 3-char abbreviations are surprisingly legible at small font sizes
5. **Fleet toggle** instantly changes visual identity without rebuilding geometry
6. **JDK 17 from Adoptium** works when system package manager has no JDK

### Limitations
1. **Altitude is simulated** — no real GPS integration yet (hardcoded to ground plane)
2. **SSID broadcast speed** — real Android SSID changes require root and are rate-limited by the Wi-Fi chipset (~50ms per change minimum)
3. **Wi-Fi scanning rate** — Android limits Wi-Fi scans to ~4 per 2-minute window for background apps
4. **No real Bluetooth LE integration** for the dual-phone ranging feature described in concept
5. **No camera integration** for visual vehicle detection

### Future Integration Paths
1. **SSID Broadcast**: Use `WifiManager.addNetwork()` + `WifiManager.enableNetwork()` on a hotspot-less configuration to cycle SSIDs on rooted devices
2. **SSID Scanning**: `WifiManager.startScan()` with `BroadcastReceiver` for `SCAN_RESULTS_AVAILABLE_ACTION`
3. **Bluetooth Ranging**: BLE advertising with TxPower for RSSI-based distance estimation between paired phones
4. **GPS Integration**: `LocationManager.requestLocationUpdates()` for real heading/speed/altitude
5. **Camera**: `Camera2 API` with ML Kit object detection for vehicle recognition and 3D position estimation

---

## File Inventory

```
CSMApps/Bounce/v1/
├── build.sh                          (5,142 B) — aapt2 build script
├── src/main/
│   ├── AndroidManifest.xml           (1,025 B) — package config
│   ├── res/
│   │   ├── values/colors.xml         — bounce_bg (#010206), bounce_fg (#FF6600)
│   │   ├── values/strings.xml        — app_name, tagline
│   │   └── mipmap-anydpi-v26/
│   │       └── ic_launcher.xml       — adaptive icon (@color refs)
│   ├── assets/
│   │   ├── bounce.html               (22,823 B) — 3D engine + SSID system
│   │   └── js/                       — Three.js + bloom + controls (8 files)
│   └── java/com/carrpod/bounce/
│       └── MainActivity.java         — WebView host, JsBridge, native buttons
├── out/
│   └── Bounce-v1.0.0.apk             (185,687 B) — signed installable APK
├── gen/                              — generated R.java
└── obj/                              — intermediate build artifacts

CSMDropBox/
└── Bounce-v1.0.0.apk                 — distribution copy

Bounce-v1.0.0.apk                     — repo root copy
```

---

## Build & Deploy

```bash
# Prerequisites
export JAVA_HOME=.sdk/jdk17
export ANDROID_HOME=.sdk/android-sdk

# Build
cd CSMApps/Bounce/v1 && bash build.sh

# Output
out/Bounce-v1.0.0.apk  (185 KB, signed, installable)
```

- **Minimum Android**: API 24 (Android 7.0)
- **Target Android**: API 33 (Android 13)
- **Permissions**: INTERNET only (for potential future web integration)

---

*Generated 2026-07-19T23:23Z by session agent_66fbea06*
*CarrPod — Safe Pod Engineering Company*
