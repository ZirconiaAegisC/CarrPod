# CSMFAB0116-02 — POCKET WATCH X: PRIMARY DISPLAY MODULE

**Revision:** A — 2026-07-10
**Classification:** ENGINEERING FABRICATION — INTERNAL
**Dependencies:** 01-CORE-SYSTEM-ARCHITECTURE

## 1. DISPLAY SPECIFICATION

### 1.1 Physical Parameters

| Parameter | Value | Notes |
|-----------|-------|-------|
| Shape | Circular | Full circle, no flat edge |
| Active diameter | 42.00 mm | ±0.05 mm |
| Viewable diameter | 40.00 mm | After bezel mask |
| Resolution | 1440 × 1440 pixels | Square within circle |
| Pixel density | 326 PPI | Retina-class at 30 cm |
| Pixel pitch | 77.9 µm | RGB subpixel |
| Aspect ratio | 1:1 | Circular crop |
| Bezel width | 4.0 mm | Masked black |
| Glass cover | 0.7 mm | Corning Gorilla Glass 6 |
| Total stack thickness | 2.85 mm | Including touch and polarizer |

### 1.2 Optical Parameters

| Parameter | Value | Notes |
|-----------|-------|-------|
| Display technology | AMOLED | Samsung E6-class panel |
| Peak brightness | 2000 nits | HDR peak, 1% window |
| Sustained brightness | 800 nits | Full-screen white |
| Contrast ratio | 2,000,000:1 | Native OLED |
| Color gamut | 100% DCI-P3 | Factory calibrated |
| Delta-E | < 2.0 | Average across 16 patches |
| White point | D65 (6504K) | ±200K tolerance |
| Gamma | 2.2 | Power-law |
| Viewing angle | ±85° | Half-luminance |
| Reflectance | < 1.5% | With AR coating |

### 1.3 Temporal Parameters

| Parameter | Value |
|-----------|-------|
| Refresh rate | 120 Hz (variable 1-120 Hz) |
| Response time (GtG) | < 1 ms |
| PWM dimming | DC-like at < 100 nit, 480 Hz above |
| Flicker index | < 0.01 |

## 2. DISPLAY OPTICAL STACK

```
Layer 1: Anti-reflective coating (SiO₂/TiO₂, 5-layer)
Layer 2: Gorilla Glass 6 (0.7 mm)
Layer 3: OCA film (25 µm, 3M CEF)
Layer 4: Circular polarizer (Nitto Denko)
Layer 5: Touch sensor film (ITO, 50 µm PET)
Layer 6: OCA film (25 µm)
Layer 7: Encapsulation glass (30 µm)
Layer 8: OLED emitter layer (RGB)
Layer 9: TFT backplane (LTPS, 50 µm)
Layer 10: Polyimide substrate (20 µm)
Layer 11: Backing film (25 µm PI)
```

## 3. TOUCH INTERFACE

### 3.1 Touch Controller

| Parameter | Value |
|-----------|-------|
| Controller IC | Synaptics S3908 (circular-optimized) |
| Technology | Mutual capacitance |
| Touch resolution | 4096 × 4096 |
| Report rate | 240 Hz |
| Latency | < 8 ms (touch-down to report) |
| Multi-touch | 10 simultaneous |
| Stylus support | Active capacitive, 4096 pressure levels |
| Palm rejection | Yes, via machine learning classifier |
| Wet-finger operation | Yes, via frequency hopping |
| Glove mode | Yes, user-selectable |

### 3.2 Gesture Library

| Gesture | Detection | Application |
|---------|-----------|-------------|
| Single tap | Yes | Select/activate |
| Double tap | Yes | Zoom/return |
| Long press | 500 ms threshold | Context menu |
| Swipe (4 dir) | Yes | Scroll/navigate |
| Circular swipe | CW/CCW | Crown emulation |
| Pinch | 2-finger | Zoom |
| 2-finger rotation | Yes | Image rotate |
| Edge swipe | From bezel | System gestures |

## 4. DISPLAY BACKLIGHT (AMOLED)

AMOLED technology eliminates the backlight requirement. Each subpixel is self-emissive:

| Parameter | Value |
|-----------|-------|
| Subpixel arrangement | Diamond Pixel (RG-BG) |
| Subpixels per pixel | 2 (green shared) |
| Emitter material | Phosphorescent blue, fluorescent red/green |
| Lifetime (T95) | 30,000 hours at 200 nit |
| Burn-in mitigation | Pixel shifting (1 px/hr), brightness cap per subpixel |

## 5. DISPLAY INTERFACE

### 5.1 MIPI DSI-2 Interface

| Parameter | Value |
|-----------|-------|
| Protocol | MIPI DSI-2 v2.0 |
| Lanes | 4 data lanes |
| Lane speed | 6.0 Gbps/lane |
| Total bandwidth | 24 Gbps |
| Command mode | Video mode (primary), command mode (low-power) |
| Compression | DSC 1.2a (visually lossless) |
| Panel self-refresh | Yes (PSR with framebuffer in DDIC) |

### 5.2 Display Driver IC (DDIC)

| Parameter | Value |
|-----------|-------|
| Manufacturer | Samsung LSI / Magnachip |
| Interface to panel | Internal MIPI (proprietary) |
| On-chip framebuffer | 8 MB (PSR mode) |
| Color processing | 10-bit internal pipeline |
| HDR support | HDR10, HDR10+, Dolby Vision (license) |

## 6. COVER GLASS

### 6.1 Specifications

| Parameter | Value |
|-----------|-------|
| Material | Corning Gorilla Glass 6 |
| Thickness | 0.7 mm |
| Surface finish | Polished, AR-coated |
| Edge treatment | 2.5D chamfer, 0.3 mm radius |
| Compressive stress | > 600 MPa |
| Depth of compression | > 40 µm |
| Knoop hardness | 595 kgf/mm² |
| Drop survival | 1.6 m onto granite (device-level) |

### 6.2 Anti-Reflective Coating

| Parameter | Value |
|-----------|-------|
| Layer count | 5 (SiO₂/TiO₂ alternating) |
| Deposition method | Magnetron sputtering |
| Reflectance (450-650 nm) | < 0.8% average |
| Scratch resistance | 8H pencil hardness |
| Oleophobic topcoat | Perfluoropolyether (PFPE) |
| Contact angle (water) | > 115° initial |

## 7. DISPLAY BONDING PROCESS

### 7.1 Steps

1. Clean glass and panel surfaces with plasma (Ar/O₂, 200W, 60s).
2. Apply OCA film to panel at 60°C, 0.3 MPa, 30s dwell.
3. Align glass to panel (±25 µm XY, ±0.05° rotation).
4. Vacuum lamination at 0.1 Pa, 65°C, 0.5 MPa, 120s.
5. Autoclave cure at 50°C, 0.5 MPa, 20 minutes for bubble removal.
6. UV edge cure (365 nm, 2 J/cm²) for perimeter seal.
7. Optical inspection for bubbles, particles, alignment.

### 7.2 Acceptance Criteria

| Defect | Limit |
|--------|-------|
| Bubbles > 100 µm | 0 allowed |
| Particles > 50 µm | 0 allowed |
| Alignment error | < 50 µm |
| Mura | None visible at any gray level |
| Bright pixel | 0 allowed |
| Dark pixel | < 3 total, < 2 adjacent |

## 8. CIRCULAR DISPLAY CALIBRATION

### 8.1 Factory Calibration

1. Panel aging: 4 hours at 80°C, 100% white.
2. Flat-field calibration at 16 gray levels (0-255, step 17).
3. White point adjustment via RGB gain registers.
4. Gamma curve fitting (power-law, gamma 2.2).
5. DCI-P3 gamut volume measurement.
6. Uniformity measurement (13-zone grid across circle).
7. Calibration data stored in DDIC NVM.

### 8.2 Uniformity Targets

| Zone | Luminance tolerance | Color tolerance (Δu'v') |
|------|---------------------|--------------------------|
| Center | ±2% | < 0.002 |
| Mid-radius | ±3% | < 0.004 |
| Edge | ±5% | < 0.006 |

## 9. POWER CONSUMPTION

| Display Mode | Power (mW) | Notes |
|-------------|-----------|-------|
| Always-On (AOD) | 8 | Minimal pixels, 1 Hz refresh |
| Low-power (60 Hz) | 280 | 100 nit, static image |
| Standard (120 Hz) | 720 | 200 nit, typical UI |
| HDR peak (120 Hz) | 1800 | 2000 nit, 1% window |
| Sleep (off) | 0.1 | DDIC in deep sleep |

## 10. VERIFICATION CHECKPOINTS

| Test | Method | Criterion |
|------|--------|-----------|
| Resolution | Microscope measurement | 1440×1440 ± 0 pixels |
| Brightness | Konica Minolta CS-2000 | Peak ≥ 2000 nit |
| Uniformity | 13-point measurement | Per section 8.2 |
| Color accuracy | Colorimeter, 24-patch Macbeth | ΔE < 2.0 average |
| Touch accuracy | Robot finger, 100-point grid | Error < 0.5 mm |
| Drop test | 1.6m onto granite, 6 faces | Glass intact, display functional |
| Submersion | IP68, 2m, 30 min | No water ingress, display functional |
| Temperature cycle | -40°C to +85°C, 100 cycles | No delamination, display functional |
| Burn-in | 500 hours static pattern | < 2% luminance difference |
