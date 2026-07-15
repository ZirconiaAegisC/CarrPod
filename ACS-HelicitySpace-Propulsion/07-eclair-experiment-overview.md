# 07 — ECLAIR Experiment Overview

## Classification: Proprietary — ACS Internal Use Only

---

## 1. Program Identity

ECLAIR is the sub-scale experimental prototype of the Helicity Drive. The name
"ECLAIR" is an acronym internal to the Helicity Space program; the experiment
serves as the primary experimental validation platform for the three-mechanism
fusion propulsion concept (peristaltic compression + plectonemic confinement +
reconnection heating).

The ECLAIR apparatus is designed as a single-pulse (non-repetitive) proof-of-concept
experiment. It does not produce net thrust; its function is to demonstrate that the
three mechanisms operate simultaneously in a controlled manner, producing the plasma
conditions predicted by theory and by the LA-COMPASS 3D MHD simulations.

---

## 2. Experimental Configuration

| Parameter | Value |
|---|---|
| Number of plasma guns | 4 |
| Gun type | Coaxial electromagnetic accelerator |
| Nozzle geometry | Convergent-divergent, passive peristaltic coil arrangement |
| Fuel | Deuterium (initial), Deuterium-Tritium (planned) |
| Pulse duration | ~100 μs (compression to exhaust) |
| Repetition rate | Single-shot (diagnostic reset between pulses) |
| Facility | Helicity Space laboratory, Pasadena, CA |
| Status | Operational; plasma jet demonstration July 2026 |

The four guns are arranged at 90° azimuthal intervals around the nozzle inlet. Each
gun fires a magnetized plasma jet into the common convergent section. The jets merge
to form the plectonemic braided structure as they enter the peristaltic compression
field.

---

## 3. Diagnostic Suite

ECLAIR is instrumented with a comprehensive set of plasma diagnostics to validate
each of the three mechanisms:

### Magnetic Diagnostics

- **Multi-axis B-dot probe arrays** at 12 axial positions along the nozzle to
  reconstruct 3D magnetic field topology versus time
- **Rogowski coils** on each gun to measure injected current and total helicity
- **Flux loops** at the nozzle throat to detect reconnection-driven flux changes

### Optical Diagnostics

- **High-speed visible camera**: 5 million frames per second, capturing jet merging
  dynamics, plectonemic braiding, and plasma evolution
- **Visible spectroscopy**: ion Doppler broadening for temperature measurement,
  impurity line identification
- **Vacuum ultraviolet (VUV) spectroscopy**: detection of fusion-relevant
  temperatures via line ratios

### Density Diagnostics

- **Laser interferometry**: line-integrated electron density along multiple chords
  for tomographic reconstruction
- **Thomson scattering**: single-point measurement of electron temperature and
  density at the nozzle throat (if signal-to-noise permits against bremsstrahlung
  background)

### Nuclear Diagnostics

- **Neutron time-of-flight detectors**: for D-T operation, measuring fusion yield
  and ion temperature from neutron spectrum broadening
- **Proton detectors** (planned for D-He³ phase): charged-particle spectroscopy

---

## 4. Experimental Objectives

| Priority | Objective | Success Criterion |
|---|---|---|
| 1 | Demonstrate plectonemic jet merging | Four distinct jets → single braided column visible on camera |
| 2 | Demonstrate peristaltic compression | Density increase factor ≥ 10 at throat vs inlet |
| 3 | Observe magnetic reconnection | Reconnection outflow signatures in camera and magnetic probes |
| 4 | Measure ion heating | T_i ≥ 200 eV (initial D₂); T_i ≥ 1 keV (D-T, later) |
| 5 | Validate MHD simulations | Agreement with LA-COMPASS within factor of 2 on density, temperature, and field topology |
| 6 | Confirm wall-free confinement | Absence of wall-material spectral lines in the compressed plasma |

---

## 5. July 2026 Plasma Jet Demonstration

The July 2026 milestone — plasma jet demonstration — represents the first integrated
operation of all four guns firing into the peristaltic nozzle. This is a critical
gate on the path to full ECLAIR operation. The demonstration is designed to:

- Validate gun synchronization (all four guns firing within < 1 μs of each other)
- Verify that jets enter the nozzle along the designed magnetic field lines
- Acquire first high-speed camera imagery of the merging region
- Provide initial magnetic probe data to compare with LA-COMPASS predictions

The demonstration does not require fusion-relevant temperatures; its purpose is to
confirm the plasma handling and injection subsystems before the higher-energy D-T
campaigns begin.

---

## 6. Path from ECLAIR to Prototype Engine

ECLAIR is a single-shot research experiment. The next step, tentatively designated
ECLAIR-2 or Helicity Drive Engineering Model, will incorporate:

- **Repetition-rated capacitor banks** for multi-pulse operation (initial target:
  1 Hz, progressing to 10 Hz)
- **Superconducting nozzle coils** to demonstrate sustained DC magnetic field
  operation
- **Thrust measurement** via a calibrated thrust balance integrated into the
  vacuum chamber
- **D-He³ fuel handling** to validate the operational fuel cycle for spaceflight
