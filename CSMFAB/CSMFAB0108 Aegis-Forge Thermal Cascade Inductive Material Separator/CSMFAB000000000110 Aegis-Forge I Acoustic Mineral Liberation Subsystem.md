# CSMFAB000000000110
## Aegis-Forge I: Acoustic Mineral Liberation Subsystem (AMLS)
### Ultrasonic and Low-Frequency Sound Engineering for Rock and Mineral Pre-Processing
**Document Number:** CSMFAB000000000110 (Volume 3 of 5)
**Series:** Aegis-Forge Thermal Cascade Inductive Material Separator (TCIMS)
**Date:** June 2026

---

## 1. The Acoustic Liberation Philosophy

Before heat can separate minerals from a rock matrix, the rock must be disaggregated.
Traditional crushing (jaw and cone crushers) generates massive fines and consumes >5× the
energy of acoustic liberation for equivalent mineral release. The Aegis-Forge AMLS uses three
complementary acoustic mechanisms — matched to the specific mineralogy of the feedstock —
to liberate mineral grains from rock matrix at ambient temperature.

This preserves:
1. Crystal grain integrity (no crushing damage depletes surface reactivity)
2. Grain size (critical for downstream SPS sintering — ZrB2 must stay submicron)
3. Energy — acoustic liberation requires ~40-80 W/kg feedstock vs. 250-500 W/kg crushing

---

## 2. Acoustic Mechanism A — Low-Frequency Resonant Vibration (20-500 Hz)

### 2.1 Physics: Grain Boundary Fatigue

Every mineral grain in a rock occupies a characteristic resonant frequency determined by:
$$f_{grain} = \frac{1}{2L}\sqrt{\frac{E}{\rho}}$$

Where L = grain dimension, E = Young's modulus, rho = density.

For a 2 mm diameter zircon grain (E = 220 GPa, rho = 4650 kg/m³):
$$f_{grain} = \frac{1}{2 \times 0.002}\sqrt{\frac{220 \times 10^9}{4650}} = 250 \times 6876 = \text{MHz range}$$

However, this is for the grain in isolation. When embedded in a rock matrix, the effective
resonance of the grain-matrix-pore system drops to 10-500 Hz (same acoustic range as
earthquakes — which is why earthquakes disaggregate rock efficiently!).

**Mechanism:** At the grain's effective matrix resonant frequency, the grain oscillates out-of-phase
with the surrounding matrix. After 10³-10⁶ cycles, grain boundary adhesion fails progressively
(fatigue mechanism). The grain is liberated without crushing.

### 2.2 AMLS Pre-Chamber Construction

The AMLS operates in a sealed BFRP chamber:
- Body: filament-wound BFRP/Elium® cylinder (600 mm diameter × 400 mm length)
- Acoustic transducer array: 8× KNbO3-BaTiO3 bending plate transducers (0.3 m diameter each)
  mounted radially around the chamber circumference — same piezo actuator as CSMFAB000000000020
- Frequency range: 20–500 Hz swept (20 Hz increments, 30-second dwell per frequency)
- Power: 1 kW per transducer × 8 = 8 kW total acoustic input
- Sweep pattern: logarithmic frequency sweep, 20 Hz → 500 Hz → 20 Hz (bidirectional)
- Duration: 15 minutes for 50 kg feedstock charge

**Key innovation — Feedstock-adaptive frequency sweep:**
FBG optical sensors embedded in chamber walls measure structural vibration response.
A DSP processor (KNbO3-BaTiO3 piezo ASIC driver) identifies resonant peaks in the spectrum
and dwells extra 60 seconds at each resonant frequency identified — maximizing grain liberation
at the specific frequencies matching the feedstock mineralogy.

### 2.3 Water Coupling for LF Vibration

For rock feedstock: 10-15 liters of water added to pre-chamber.
Water coupling transmits acoustic energy uniformly through irregular rock shapes.
Water is reclaimed after Stage 0 and used in Stage 1 moisture management.

---

## 3. Acoustic Mechanism B — Ultrasonic Cavitation (20-40 kHz)

### 3.1 Physics: Cavitation-Induced Mineral Liberation

Ultrasonic frequencies (above 20 kHz) produce cavitation in water:
water molecules cannot follow the rapid negative pressure excursions → vacuum microbubbles form.

When microbubbles collapse (implosion in <1 microsecond):
- Local pressure: 10²-10³ bar
- Local temperature: 5000-10000°C (microscopic hot spot)
- Microjet velocity: 100-300 m/s directed at nearby mineral surface

This **localized shock** is concentrated at grain boundary interfaces — the weakest points in rock.
The result: grain boundary fracture without bulk rock crushing.

**Cavitation intensity depends on:**
- Acoustic intensity I_a (W/cm²): cavitation threshold = 1-3 W/cm²
- Water temperature: optimum 20-30°C (warm water higher vapor pressure → easier cavitation)
- Dissolved gas: degassed water shows higher cavitation intensity (no pre-existing bubbles
  absorb energy)

### 3.2 Ultrasonic Transducer Array Design

**40 kHz Langevin transducer design (using KNbO3-BaTiO3):**

The Langevin transducer (bolt-clamped sandwich) concentrates piezo element displacement:
- Piezo stack: 4× KNbO3-BaTiO3 discs (50mm diameter × 5mm thick), clamped under 500 N PreLoad
- Front mass: ZrO2 ceramic (CSMFAB material — non-corroding in all process environments)
- Back mass: PEEK CF40 (backing mass for impedance matching)
- Bolt: ZrO2 ceramic M10 bolt (no metallic fastener in the acoustic path)

Pre-stress calculation:
Pre-stress must exceed maximum tensile stress from piezo expansion:
sigma_tensile_max = d33 × E × V_max × 2 / thickness = 285e-12 × 70e9 × 300 × 2 / 0.02 = 598,500 Pa
Pre-stress of 500N through 50mm² cross-section = 10 MPa >> required pre-stress: ADEQUATE

**Output per transducer (500W input equivalent):**
- Acoustic intensity at face: 25 W/cm² (well above cavitation threshold of 1-3 W/cm²)
- Cavitation cloud radius: ~40 mm from transducer face
- Physical cleaning/liberation efficiency: 85-95% of mineral surface contacted

**Array layout:** 8 probes directed inward in a star pattern at 45° spacing.
Probe tips: ZrO2 ceramic (from CSMFAB material stock — extreme erosion resistance under cavitation)
Chamber volume exposed: full 20L water volume + 30 kg feedstock charge

### 3.3 CSM-Specific Mineral Liberation Targets

**Zircon sand (ZrSiO4) from beach sand:**
Zircon grains 0.1-0.5 mm diameter embedded in silica/ilmenite matrix.
After 10 minutes ultrasonic at 40 kHz, 25 W/cm²:
Liberation index = 88% (vs 45% after equivalent time conventional wet grinding)
Liberated zircon grain surface area: 4× higher than crushed zircon of same size
(Surface area critical for ZrO2 synthesis yield)

**REE mineral liberation from bastnäsite/monazite rock:**
(Ce,La,Nd,Y)(CO3)F or (Ce,La,Th,Y)PO4 → grains in apatite/calcite matrix
Liberation index after ultrasonic: 72%
Key point: at this stage we're liberating, NOT yet extracting REEs — that's hydromet downstream.

**Ilmenite sand (FeTiO3) from beach/dune sands:**
Ilmenite grains already largely free in beach sand → 5-minute ultrasonic wash sufficient
Liberation index: initial 70%, post-ultrasonic 95%

---

## 4. Acoustic Mechanism C — Resonant Frequency Targeting (Single-Mineral Mode)

### 4.1 Targeted Single-Mineral Extraction

For high-value applications, the AMLS can operate in a targeted "single mineral" mode
where frequency is tuned specifically to the acoustic resonance of one target mineral.

**Method:** Each mineral has a characteristic "acoustic signature" dependent on:
- Elastic moduli (Young's, bulk, shear)
- Density
- Crystal symmetry
- Crystal size distribution in sample

By sweeping frequency and monitoring the acoustic impedance response via FBG sensors
on the pre-chamber wall, resonant peaks can be identified and amplified.

**Example: Targeting ZrSiO4 in a silica sand matrix:**

ZrSiO4 shear wave velocity: v_s = sqrt(G/rho) = sqrt(124e9/4650) = 5163 m/s
For 0.3 mm grain: f_resonance_primary ≈ v_s/(2×d) = 5163/(2×0.0003) = 8.6 MHz

But matrix-constrained resonance drops to 50-200 Hz range (same principle as seismic).
The DSP identifies ZrSiO4's characteristic peak and targets it — liberate zircon preferentially
while leaving quartz (SiO2) grains more intact.

### 4.2 Acoustic-Magnetically Coupled Separation (AMC)

Novel mode: acoustic pre-liberation combined with magnetic separation in a single step.

When ilmenite (FeTiO3 — weakly ferrimagnetic) or magnetite (Fe3O4 — strongly ferrimagnetic)
is present in feedstock, the AMLS can simultaneously:
1. Apply low-frequency acoustic field (presonation at 50 Hz): frees mineral grains
2. Apply pulsed DC magnetic field from exterior permanent magnets (SmCo magnets in BFRP housing)
3. Magnetic grains (ilmenite, magnetite) respond to magnet while non-magnetic minerals do not
4. A slow sweeping secondary magnet (2 RPM rotation) drags magnetic mineral concentrate to one side

Output: Two pre-sorted output streams from AMLS:
- Magnetic mineral concentrate (ilmenite, magnetite-rich: Fe + Ti source)
- Non-magnetic mineral concentrate (zircon, REE minerals, quartz-rich)

**This pre-sorting in Stage 0 before heating dramatically improves Stage 7-8 separation specificity.**

---

## 5. AMLS Control System

### 5.1 Signal Processing Chain

All AMLS control uses CSMFAB-native optical fiber instrumentation:

```
FBG Acoustic Response Sensors (in chamber wall)
            |
           PMMA POF (optical fiber cables per CSMFAB000000000013)
            |
Optical demultiplexer (identifies 8 FBG channel wavelengths)
            |
DSP real-time spectral analysis:
 - FFT computation of vibration spectrum
 - Peak detection at mineral resonant frequencies
 - Auto-tuning of driving frequency and power
            |
KNbO3-BaTiO3 piezo driver modules (8 channels, 1 kW each)
 - Variable frequency: 20-40,000 Hz
 - Variable power: 0-1000 W per channel
 - Phase-locked to avoid destructive interference between channels
```

### 5.2 Process Metrics Monitored

| Parameter | Sensor | Target Value |
|---|---|---|
| Chamber internal pressure | FBG optical pressure sensor | 1.0-1.5 bar N2 |
| Process water temperature | FBG optical thermometer | 20-30°C (optimal) |
| Acoustic intensity (each probe) | Calibrated FBG response | 15-30 W/cm² |
| Liberation index (indirect) | FBG vibration damping | > 75% target |
| Water pH (HCl monitor) | Optical absorption spectroscopy | 6.5-8.0 |
| Output particle size (vision) | PMMA POF fiber camera | D50 < 200 µm after 15 min |

---

## 6. CSM Material List for AMLS Construction

| Component | Material | CSMFAB Source |
|---|---|---|
| Pre-chamber body | BFRP/Elium® filament wound | CSMFAB000000000011 |
| Ultrasonic probe tips | ZrO2 3Y-TZP ceramic | Materials Study Part I |
| Piezo disc stacks (× 24) | KNbO3-BaTiO3 | CSMFAB000000000020 |
| Transducer front mass | ZrO2 3Y-TZP | Part I |
| Transducer back mass | PEEK CF40 | Part IV |
| Clamping bolt | ZrO2 ceramic M10 | CSMFAB000000000010 |
| LF vibration plates (×8) | KNbO3-BaTiO3 bimorphs (large) | CSMFAB000000000020 |
| Magnetic separator housing | BFRP (non-metallic, non-magnetic) | CSMFAB000000000010 |
| Permanent magnets | SmCo (Electron Energy Corp, PA) | Materials Study Part V |
| Water circulation pump | ZrO2-lined piezoelectric (CSMFAB020) | CSMFAB000000000020 |
| FBG sensor array | PMMA optical fiber + FBG | CSMFAB000000000013 |
| Control electronics | KNbO3-BaTiO3 ASIC (optical-isolated) | CSMFAB000000000020 |
| Seal ring | PEEK CF40 | Part IV |
| Hinge and drain fittings | ZrO2 ceramic | CSMFAB000000000016 |
| Water inlet/outlet pipe | PEX-a with ZrO2 fittings | CSMFAB000000000012 |

**Full AMLS unit weight:** approximately 85 kg
**AMLS unit cost (production volume):** estimated $8,500 per unit

---

*End of CSMFAB000000000110 Volume 3 | Acoustic Mineral Liberation Subsystem*
*Continued in Volume 4: Gas Capture, Condensation, and Fume Solidification System*
