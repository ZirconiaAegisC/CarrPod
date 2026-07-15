# 09 — Diagnostics & High-Speed Imaging

## Classification: Proprietary — ACS Internal Use Only

---

## 1. Diagnostic Philosophy

The ECLAIR diagnostic suite is designed to answer four sequential questions for
each experimental shot:

1. Did the four guns fire synchronously and inject magnetized jets into the nozzle?
2. Did the jets merge and form the predicted plectonemic braided topology?
3. Did peristaltic compression increase the plasma density and temperature at the
   throat?
4. Did magnetic reconnection deposit energy into the ions?

Each question maps to a specific diagnostic tier with defined instrumentation.

---

## 2. High-Speed Visible Imaging (5 Million fps)

The centerpiece of the ECLAIR diagnostic suite is the high-speed visible-light
camera operating at 5 million frames per second (200 ns inter-frame interval).
This is the primary instrument for answering Questions 1 and 2.

| Camera Parameter | Specification |
|---|---|
| Frame rate | 5,000,000 fps |
| Exposure time per frame | 100–150 ns |
| Resolution | 256 × 256 pixels (typical at max frame rate) |
| Spectral range | 400–700 nm (visible), filtered as needed |
| Number of frames per shot | 16–64 (depending on memory segmentation) |
| Trigger | Synchronized to gun discharge trigger |

### Imaging Objectives

- **Jet injection verification**: each gun's muzzle flash appears as a distinct
  bright spot at t = 0. If a gun misfires, the absence is immediately visible.
- **Jet merging dynamics**: the four individual jets converge and merge over
  5–15 μs. The camera captures the radial compression and the formation of the
  central plasma column.
- **Plectonemic braiding**: the twisted, helical structure of the merged flux
  tubes is expected to produce visible striations in the plasma self-emission.
  The presence of these striations and their helical pitch angle confirm braiding.
- **Reconnection outflow**: fast plasma jets ejected from reconnection X-points
  appear as transient bright streaks propagating away from the central column
  at velocities exceeding the local sound speed.

---

## 3. Magnetic Probe Arrays

Three-axis B-dot probes (measuring dB/dt in three orthogonal directions) are
arrayed at multiple axial and azimuthal positions along the nozzle. The probes
provide the primary data for MHD reconstruction.

| Parameter | Specification |
|---|---|
| Number of probe stations | 12 axial × 4 azimuthal = 48 total |
| Probe type | Multi-axis inductive (B-dot) |
| Frequency response | DC to 50 MHz |
| Digitizer | 12-bit, 250 MS/s per channel |
| Time resolution | 4 ns |

### Derived Quantities

- Br, Bθ, Bz versus (r, z, t) → 3D magnetic field reconstruction
- Current density J (from ∇ × B) → identification of current sheets (reconnection
  sites)
- Magnetic helicity density A · B → verification of helicity injection and decay

---

## 4. Interferometry

Multi-chord laser interferometry provides the electron density distribution. A
frequency-doubled Nd:YAG laser (532 nm) is split into multiple chords passing
through the nozzle at different axial positions.

| Parameter | Specification |
|---|---|
| Laser wavelength | 532 nm (Nd:YAG, frequency-doubled) |
| Number of chords | 4–8 |
| Time resolution | Limited by digitizer (1–10 ns effective) |
| Density range | 10^20–10^23 m⁻³ (line-integrated) |

---

## 5. Spectroscopy

| Technique | Measured Quantity | Instrument |
|---|---|---|
| Ion Doppler broadening | Ion temperature (T_i) | High-resolution visible spectrometer |
| Stark broadening | Electron density (n_e) | Visible spectrometer |
| Line ratio thermometry | Electron temperature (T_e) | VUV spectrometer |
| Impurity line survey | Wall material contamination | Survey spectrometer (200–800 nm) |

---

## 6. Nuclear Diagnostics (Planned)

For D-T operation, the following nuclear diagnostics will be added:

| Detector | Purpose | Sensitivity |
|---|---|---|
| Scintillator-photomultiplier | Neutron yield | > 10⁶ neutrons/shot |
| Time-of-flight neutron spectrometer | Ion temperature from neutron spectrum | ΔE ≈ 0.1 MeV at 14 MeV |
| Proton detector (D-He³ phase) | Fusion proton yield and spectrum | > 10⁴ protons/shot |

---

## 7. Shot Cadence and Data Architecture

Each ECLAIR shot generates approximately 5–10 GB of raw data (primarily from
the high-speed camera and magnetic probe digitizers). Data is streamed to a
local RAID array and analyzed in near-real-time using a Python-based processing
pipeline. Shot turnaround time (from trigger to analyzed results) is
approximately 5–10 minutes, limited by data transfer and computational MHD
reconstruction.
