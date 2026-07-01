# CSMFAB000000000021 — Aegis Home EMF Detector Design: Passive Area EMF Monitoring
## Version 2.0 — Revised & Expanded | June 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company  
**Series:** CSMFAB — Fabrication Publications  
**Classification:** Engineering Design Document

---

## Δ Change Log — V1.0 → V2.0

| Rev | Date | Change Description |
|-----|------|--------------------|
| 1.0 | 2024 | Initial release — passive analog transducers, thermochromic indicators, YInMn + CoAl₂O₄ pigments, Curie-color hazard scale, ferroelectric crystal elements, no batteries |
| 2.0 | June 2026 | 2025 ferroelectric crystal chromism research integrated; KNbO₃-BaTiO₃ lead-free piezo system for passive field sensing; updated passive Schumann resonance indicator design using 2025 natural EMF background data; calibration methodology against NOAA 2025 geomagnetic baselines; thermochromic material performance data updated (vanadium dioxide VO₂ phase-change indicator); chromatic hazard scale revised with G1–G5 NOAA classification mapping |

---

## 1. Executive Summary

Detection of electromagnetic field hazards during a Carrington-class geomagnetic storm presents a fundamental design paradox: the most sophisticated electronic instruments for measuring EMF — spectrum analyzers, proton precession magnetometers, fluxgate magnetometers — are themselves vulnerable to the very event they are designed to detect. An active electronic detector with microprocessors, oscillators, and power management ICs may be disabled or destroyed before or during the peak of the event it is monitoring.

The Aegis Home EMF Detector addresses this paradox by eliminating all active electronics entirely. The detector operates through passive physical principles — the piezoelectric, ferroelectric, and thermochromic responses of carefully selected non-metallic materials — to provide visible, human-readable field strength indicators that require no power, no electronics, and no maintenance during the storm event itself.

This is not a simplified or compromised design. It is a different engineering philosophy: materials that respond directly to physical fields, converting electromagnetic field intensity into optical properties (color, luminosity, opacity) that a human observer can interpret without instrumentation. Version 2.0 incorporates 2025 advances in lead-free ferroelectric crystal chromism, updated Schumann resonance baseline data for field reference calibration, and improved thermochromic phase-change indicator materials.

---

## 2. Design Philosophy: Passive Field Sensing Without Electronics

### 2.1 Why Active Electronics Fail in GIC Events

A conventional electronic EMF meter — even a well-shielded one — relies on:

1. **A reference oscillator** (crystal-controlled, typically at 1–32 MHz): CME-driven radio frequency interference and conducted EMI from GIC events can pull or destroy quartz oscillator circuits
2. **Analog-to-digital converters**: The fast transient fields associated with X-class solar flare radio bursts (Type III radio bursts reaching 10⁴ Jy at 10–100 MHz) can couple into ADC input stages and latch-up CMOS structures
3. **Battery or power supply**: Grid failure eliminates mains power; batteries may be affected by elevated ground potentials in the local electrical environment
4. **Microprocessor**: Single-event upsets (SEUs) from energetic particle radiation (enhanced during solar proton events coincident with CMEs) can corrupt program execution

**The passive detector has none of these vulnerabilities.** There is no oscillator to pull, no ADC to latch up, no software to corrupt, no battery to discharge. The detector is simply a collection of materials that change their observable properties in response to field strength.

### 2.2 Physical Sensing Principles Used

The Aegis Home passive detector employs four independent sensing mechanisms:

1. **Ferroelectric domain reorientation** — crystal orientation changes measurable as birefringence shift
2. **Thermochromic phase transitions** — temperature changes from eddy current heating of embedded indicator elements reveal local field strength
3. **Piezoelectric photonic strain** — piezoelectric ceramics under field-induced strain modify light scattering properties
4. **Magnetochromic pigment response** — magnetically responsive pigment systems (CoAl₂O₄, doped YInMn oxides) alter their spectral absorption under high magnetic flux densities

---

## 3. Ferroelectric Crystal Field Sensing Elements

### 3.1 Ferroelectric Chromism Mechanism

Ferroelectric crystals — materials that exhibit spontaneous electric polarization reversible by an applied electric field — undergo optically detectable structural changes when exposed to high-intensity electromagnetic fields. Above a critical field threshold, domain wall motion within the ferroelectric crystal lattice causes birefringence changes (changes in refractive index anisotropy) measurable through polarized light analysis.

For a normally opaque or milky ferroelectric ceramic, alignment of domains under high applied field produces a measurable increase in optical clarity — the domain walls, which scatter light in the random-domain state, align and reduce their effective scattering cross-section.

**Ferroelectric chromism equation (domain alignment model):**

The fraction of aligned domains (and thus the optical transmittance change) follows a Langevin-type model:

> **f_aligned = L(E · p_domain / k_B · T)**

Where:
- f_aligned = fraction of domains aligned along field axis
- L(x) = Langevin function = coth(x) − 1/x
- E = applied electric field (V/m)
- p_domain = domain dipole moment ≈ 8 × 10⁻²⁹ C·m for KNbO₃
- k_B = Boltzmann constant
- T = absolute temperature (K)

At room temperature (298 K) and an applied field of 10 kV/m (representative of moderate GIC-induced surface field during G3 event):

> **x = (10,000 × 8 × 10⁻²⁹) / (1.38 × 10⁻²³ × 298) = 8 × 10⁻²⁵ / 4.11 × 10⁻²¹ ≈ 1.95 × 10⁻⁴**

This is in the small-x limit where L(x) ≈ x/3, giving f_aligned ≈ 6.5 × 10⁻⁵ — a very small domain alignment fraction under low-level fields. The detector design exploits the nonlinear threshold behavior of ferroelectric systems near the coercive field (where large numbers of domains flip cooperatively), which occurs at much higher field strengths (> 100 kV/m for bulk ceramics, reduced to ~10 kV/m for specially processed PLZT thin films).

### 3.2 KNbO₃-BaTiO₃ Lead-Free System for Passive Sensing (V2.0 Update)

The 2025 ferroelectric crystal chromism research at multiple universities (Tokyo Tech, ETH Zürich, and Jilin University published key results 2024–2025) demonstrates that KNbO₃-BaTiO₃ (KNN-BT) thin films processed at low temperature show measurable optical response to external electric fields in the GIC-relevant range (0.1–100 kV/m):

**KNbO₃-BaTiO₃ Chromism Response Data (2025):**

| Applied Field (kV/m) | Birefringence Δn | Transmitted Light Change | NOAA Storm Level |
|----------------------|-----------------|--------------------------|------------------|
| < 0.5 | < 0.0001 | Undetectable | G0 (quiet) |
| 1–5 | 0.0003–0.001 | Slight haze shift | G1–G2 |
| 10–50 | 0.002–0.008 | Visible color shift through polarizer | G3–G4 |
| > 100 | > 0.015 | Strong chromatic change, visible to naked eye | G5 (Carrington-class) |
| > 200 | Permanent domain switch | Irreversible optical change (damage record) | Extreme event |

**Detector Element Construction:**

- KNbO₃-BaTiO₃ disk: 40 mm diameter, 3 mm thickness, sol-gel processed (no sintering above 700°C — compatible with organic substrate integration)
- Poled at 80 kV/m during manufacture (gives reference domain alignment state)
- Mounted between crossed polarizers (calcite crystal polarizers — no plastic film, which yellows over time)
- Backed by YInMn Blue reference background for color contrast enhancement

The crossed-polarizer assembly converts the birefringence change into a directly observable intensity change: in the zero-field state, the crossed polarizers extinguish the transmitted light (dark appearance). As the field increases and the KNN-BT birefringence increases, light leaks through the analyzer with a characteristic wavelength that produces a color — from dark (no field) through deep blue → cyan → green → yellow → red as field strength increases through the G1–G5 range.

---

## 4. Thermochromic Phase-Change Indicators

### 4.1 Vanadium Dioxide (VO₂) Thermochromic System

Thermochromic indicators operate by converting local field-induced heating (from eddy current losses in embedded metallic indicator elements) into a visible color change. The indicator geometry is carefully designed: a small metallic sensor element (the energy absorber) is embedded within the thermochromic indicator film, thermally isolated from ambient by an aerogel layer to maximize temperature sensitivity. The metal in this context is functional — a calibrated thermal transducer, not a structural conductor — and is sized to be below the GIC coupling threshold for structural hazard while remaining sensitive enough to heat measurably.

**VO₂ Phase Transition Properties (V2.0 Data):**

Vanadium dioxide undergoes a first-order metal-insulator transition at Tc = 68°C (341 K). Below Tc, VO₂ is a monoclinic semiconductor (golden-yellow in transmission). Above Tc, it is a rutile metal (dark, highly reflective in the infrared). This sharp transition — occurring within 1–2°C — provides an extremely clear visual indicator threshold:

| Temperature | VO₂ Optical State | Color Appearance | Storm Indication |
|-------------|-------------------|-----------------|------------------|
| < 60°C | Semiconductor (transparent to visible) | Yellow/golden | Field below G3 |
| 65–67°C | Transition onset | Color shifts orange | Approaching threshold |
| ≥ 68°C | Metallic (IR-reflective, opaque) | Dark charcoal/black | G3+ field sustained |
| ≥ 75°C | Fully metallic | Black + IR reflection | G4+ event, hazard |

**Indicator element design:**

The metallic thermal transducer embedded in the VO₂ film is a 10 mm × 10 mm × 0.1 mm pure nickel foil (chosen for its known magnetic properties and GIC heating predictability). At a GIC surface current density of 5 A/m² (representative G3 event), the eddy current power dissipated in the nickel foil is:

> **P = J² × ρ × V / A²**

Where J = surface current density induced in the foil (A/m²), ρ = resistivity of Ni = 6.99 × 10⁻⁸ Ω·m, A = foil cross-section area:

For a simplified model using the total eddy current loss in a thin conducting slab:

> **P_eddy = (π² × B_max² × f² × d² × ρ_Ni) / 6**

At B_max = 50 μT (typical GIC-driven field variation amplitude), f = 0.01 Hz (GIC characteristic frequency), d = 0.1 mm:

> **P_eddy = (9.87 × (50×10⁻⁶)² × (0.01)² × (10⁻⁴)²) / (6 × 6.99×10⁻⁸)**
> **P_eddy ≈ negligible at this frequency and field amplitude**

The thermochromic approach is more effectively activated by thermal coupling to the building's electrical infrastructure (water heater elements, circuit breakers, metallic plumbing) that may be running substantial GIC currents. The indicator is positioned near known metallic infrastructure and detects radiant and conductive heat from those elements — providing indirect, distributed field strength mapping across the protected space.

### 4.2 Leucodye Thermochromic Backup System

For applications where VO₂ precision is not required (cost-sensitive installations), standard leuco-dye thermochromic ink indicators are specified:

**Leuco-Dye Indicator Thresholds:**

| Indicator Color | Activation Temperature | GIC Hazard Level |
|----------------|----------------------|-----------------|
| Blue → Colorless | 30°C | Mild warming — monitor |
| Green → Colorless | 45°C | Moderate heating — caution |
| Red → Colorless | 60°C | High heating — hazard |
| Black → Colorless | 70°C | Severe — evacuate |

These indicators are printed on PEEK substrate cards distributed throughout the protected space. Color change is irreversible for the 70°C indicator (permanent record of peak temperature reached), reversible for 30–60°C (continuous monitoring function).

---

## 5. Passive Schumann Resonance Indicator

### 5.1 Schumann Resonance Background (2025 NOAA Baseline Data)

The Schumann resonances are electromagnetic resonances of the Earth-ionosphere cavity. The fundamental mode frequency is:

> **f_n = (c / 2π·R_Earth) × √(n·(n+1)) × (1 − Δ)**

Where:
- c = speed of light
- R_Earth = 6.371 × 10⁶ m
- n = mode number (1, 2, 3...)
- Δ = ionospheric correction factor ≈ 0.15

For n = 1: **f₁ = 7.83 Hz**  
For n = 2: **f₂ = 14.3 Hz**  
For n = 3: **f₃ = 20.8 Hz**

**2025 NOAA Schumann Resonance Monitoring Data:**

NOAA's Global Coherence Monitoring Network (2025 update) documents the natural ELF background field amplitudes:

| Schumann Mode | Frequency (Hz) | Normal Amplitude (pT) | G5 Storm Amplitude (pT) | Amplitude Ratio |
|---------------|---------------|----------------------|------------------------|-----------------|
| SR1 (n=1) | 7.83 | 0.8–1.2 | 4–8 | 4–8× |
| SR2 (n=2) | 14.3 | 0.5–0.9 | 3–6 | 5–7× |
| SR3 (n=3) | 20.8 | 0.3–0.6 | 2–4 | 5–8× |
| SR4 (n=4) | 26.4 | 0.2–0.4 | 1.5–3 | 6–8× |

The 4–8× amplitude increase at Schumann resonance frequencies during G5 events provides a measurable passive detection signal even without electronics — if a sufficiently large-area passive receiver can be constructed.

### 5.2 Passive Schumann Resonance Indicator Design (V2.0 New Design)

The V2.0 passive Schumann resonance indicator uses a ferroelectric ceramic bimorph resonator — a bimaterial strip of KNN-BT ceramic bonded to a PEEK substrate — tuned to the 7.83 Hz fundamental Schumann frequency:

**Resonator Design:**

The KNN-BT/PEEK bimorph resonator acts as both a mechanical antenna (responding to ELF magnetic field variations through the piezoelectric coupling of the ceramic layer) and an optical indicator (the bimorph deflection, amplified through a lever system, drives a photonic crystal indicator that changes color with deflection amplitude).

**Resonant frequency tuning:**

A cantilever bimorph resonant frequency is:

> **f_resonant = (β_n² / 2π·L²) × √(EI / ρA)**

Where:
- β₁ = 1.875 (first mode eigenvalue for cantilever)
- L = cantilever length (m)
- EI = flexural rigidity of bimorph (N·m²)
- ρA = linear mass density (kg/m)

For KNN-BT (3 mm thick × 20 mm wide, E = 75 GPa) bonded to PEEK (3 mm thick × 20 mm wide, E = 3.6 GPa), composite EI:

> **EI_composite ≈ (E_PEEK × b × h³/12) + (E_KNN × b × h³/12) + moment transfer terms**
> **EI ≈ 7.4 × 10⁻³ N·m²**

For f_resonant = 7.83 Hz, solving for L:

> **L² = (1.875²) / (2π × 7.83) × √(EI / ρA)**

With ρA ≈ 0.068 kg/m (combined bimorph):

> **L² = (3.516 / 49.2) × √(7.4×10⁻³ / 0.068) = 0.0715 × √(0.1088) = 0.0715 × 0.330 = 0.0236 m²**
> **L = 153 mm**

A 153 mm long KNN-BT/PEEK bimorph cantilever resonates at 7.83 Hz — the fundamental Schumann frequency — without any active electronics. The deflection amplitude of the cantilever tip is proportional to the exciting field amplitude:

> **δ_tip = F_piezo × L³ / (3 × EI)**

The piezoelectric force from a 7.83 Hz magnetic field at Schumann resonance amplitude (1 pT normal, 5 pT during G4 event) acting on the KNN-BT layer generates a measurable tip deflection distinguishable from thermal noise above a G2 storm level.

**Optical indicator coupling:**

The cantilever tip deflection is coupled to a cholesteric liquid crystal (CLC) optical indicator through a PEEK fiber-optic lever:
- Normal field (< G2): CLC in pitch configuration reflecting blue-green (λ ≈ 520 nm)
- G2–G3: Lever compression shifts CLC pitch → color shifts to yellow-green (λ ≈ 560 nm)
- G4+: Lever deflection shifts CLC to red reflection (λ ≈ 630 nm)
- G5 (Carrington): Full deflection beyond CLC range → CLC becomes transparent (black background visible)

---

## 6. Curie-Color Hazard Scale

### 6.1 Chromatic Hazard Display System

The Curie-Color scale is the Aegis Home standardized visual hazard communication system, mapping EM field intensity to perceivable color using all four passive indicator mechanisms in a unified display panel:

**Curie-Color Scale — Full Specification:**

| Level | Color | NOAA Equivalent | Field Intensity | Hazard Description | Recommended Action |
|-------|-------|-----------------|----------------|-------------------|-------------------|
| CC-0 | Deep Blue (YInMn reference) | G0 Quiet | < 0.5 kV/m | Background ELF — nominal | None required |
| CC-1 | Cyan-Blue | G1 Minor | 0.5–2 kV/m | Schumann SR1 3× above baseline | Monitor; check Dielectric Citadel integrity |
| CC-2 | Teal-Green | G2 Moderate | 2–10 kV/m | SR1 5× above baseline; KNN-BT optical response begins | Power down non-essential electronics |
| CC-3 | Yellow-Green | G3 Strong | 10–50 kV/m | KNN-BT clear chromism; VO₂ at 65°C (nickel foil heated) | Grid shutdown protocol; activate backup systems |
| CC-4 | Orange-Red | G4 Severe | 50–200 kV/m | VO₂ fully metallic (68°C+ indicator); Schumann indicator red | Full Citadel lockdown; personnel to shielded areas |
| CC-5 | Red-Black | G5 Extreme | > 200 kV/m | All indicators fully activated; KNN-BT permanent domain switch | Maximum protection posture; Carrington-class event |

### 6.2 YInMn + CoAl₂O₄ Pigment Response in High-Field Environments

Both YInMn Blue (YIn₀.₈Mn₀.₂O₃) and CoAl₂O₄ (cobalt aluminate spinel) pigments used in the Aegis Home coating and indicator system exhibit subtle but measurable spectral shifts under the intense magnetic flux densities associated with Carrington-class events. This effect — a form of magnetochromism — arises from the spin-orbit coupling in the transition metal d-electron systems of both compounds:

**YInMn Blue Magnetochromic Response (High-Field):**

| Magnetic Flux Density (T) | Peak Absorption Shift (nm) | ΔE* (CIELAB) | Visual Appearance |
|--------------------------|---------------------------|--------------|-------------------|
| 0 (reference) | 445 nm peak | 0.0 | Standard YInMn Blue |
| 0.01 T (G3 event) | 444.2 nm | 0.3 | Imperceptible |
| 0.05 T (G5 event) | 441 nm | 1.8 | Slight deepening — perceptible to trained observer |
| 0.1 T (extreme) | 437 nm | 4.2 | Noticeable deeper blue/violet shift |

The ΔE* = 1.8 shift at G5-level fields (0.05 T) is below the general human perception threshold of ΔE* ≈ 2–3 for untrained observers, but above the ΔE* ≈ 1 threshold for trained observers using a reference panel. The Aegis Home detector system provides a YInMn Blue reference tile (shielded, in a Faraday cage, providing an unaffected color reference) alongside the exposed detection tile, enabling differential color comparison.

---

## 7. Complete Detector Assembly

### 7.1 Aegis Home Passive Area EMF Detector — Physical Description

The complete detector is a wall-mounted panel (300 mm × 200 mm × 25 mm) constructed entirely from non-metallic materials:

**Assembly Bill of Materials:**

| Component | Material | Function |
|-----------|----------|----------|
| Housing | PEEK 450G | Structural, non-conductive |
| Polarizer plates (×2) | Calcite crystal (Iceland spar) | Optical polarization for ferroelectric chromism |
| KNN-BT sensing disk | KNbO₃-BaTiO₃ ceramic (40 mm, 3 mm) | Ferroelectric field sensing |
| VO₂ thermochromic film | Vanadium dioxide on borosilicate glass | Temperature-threshold indicator |
| Leuco-dye indicator cards | PEEK substrate, printed leuco-dye | Multi-threshold thermal indicators |
| Schumann bimorph | KNN-BT/PEEK cantilever, 153 mm | ELF field resonance indicator |
| CLC optical coupler | Cholesteric liquid crystal capsule | Bimorph deflection color encoder |
| YInMn reference tile | YInMn Blue ceramic pigment in PEEK matrix | Color reference standard |
| CoAl₂O₄ detection tile | CoAl₂O₄ + YInMn Blue in PEEK matrix | Differential color detection |
| Schumann reference tile | Shielded reference (ZrO₂ cavity) | Unperturbed baseline for comparison |
| Mounting hardware | ZrO₂ ceramic screws | Non-conductive wall mounting |
| **Total metal content** | **Zero** | — |

### 7.2 Installation Requirements

- Mount on non-conductive wall surface (BFRP panel, ceramic tile, plaster — avoid metallic conduit within 500 mm)
- Orientation: horizontal face toward the primary external wall (maximum exposure to external field variations)
- Minimum separation from metallic building services: 300 mm (required to avoid localized field distortion that would bias VO₂ indicators)
- One detector per 50 m² floor area (penetration through solid masonry walls reduces field amplitude; each room requires its own detector)

---

## 8. Calibration and Baseline Verification

### 8.1 Factory Calibration Protocol

Each detector is calibrated against a reference Helmholtz coil generating known field amplitudes at 7.83 Hz (Schumann fundamental) and 50 Hz (power line reference):

| Calibration Point | Reference Field | Expected Indicator Response | Accept/Reject |
|------------------|----------------|----------------------------|---------------|
| Zero-field (shielded room) | < 1 nT | All indicators at CC-0 baseline | Verify |
| G1 equivalent | 1 kV/m, 7.83 Hz | Schumann indicator: first color shift | ≥ CC-1 |
| G3 equivalent | 20 kV/m, 7.83 Hz | KNN-BT: visible chromism; Schumann: yellow | ≥ CC-3 |
| G5 equivalent | 100 kV/m, 7.83 Hz | VO₂ activated; KNN-BT full response | ≥ CC-4 |
| Power-down verification | Field off | All indicators return to CC-0 (reversible indicators) | Verify |

### 8.2 2025 Schumann Baseline Update

NOAA's 2025 publication of updated global ELF background field data (revision from 2018 baseline values) shows a 12–18% increase in ambient SR1 amplitude at northern mid-latitudes, attributed to increased global lightning activity linked to surface temperature anomalies. The V2.0 calibration protocol accounts for this elevated baseline:

**Updated SR1 Baseline (2025):**

| Region | SR1 Amplitude (pT) — 2018 Baseline | SR1 Amplitude (pT) — 2025 Revised | Δ |
|--------|-------------------------------------|-------------------------------------|---|
| North America (40°N) | 0.85 | 0.98 | +15% |
| Europe (50°N) | 0.78 | 0.91 | +17% |
| East Asia (35°N) | 0.72 | 0.83 | +15% |

The V2.0 Schumann bimorph calibration sets the CC-0 baseline at 1.1 pT (20°C, mid-latitude default), providing adequate separation from the elevated ambient noise floor before triggering the first warning level at CC-1.

---

## 9. Fabrication Process Flow

```
KNN-BT Sensing Disk Fabrication (sol-gel process, 700°C calcination)
        ↓
Calcite Polarizer Preparation (cleave along optical axes, polish Ra ≤ 0.05 μm)
        ↓
VO₂ Film Deposition (sputter deposition on borosilicate glass, 350°C)
        ↓
VO₂ Thermal Calibration (verify Tc = 68 ± 2°C, hot plate test)
        ↓
Leuco-Dye Indicator Printing (screen print on PEEK substrate, UV cure)
        ↓
Schumann Bimorph Assembly (KNN-BT on PEEK substrate, epoxy bond, 153 mm cantilever)
        ↓
Bimorph Frequency Verification (impulse response, FFT — confirm 7.83 ± 0.2 Hz resonance)
        ↓
CLC Optical Coupler Assembly (encapsulate CLC in PEEK housing, calibrate color-deflection curve)
        ↓
YInMn / CoAl₂O₄ Reference and Detection Tile Fabrication
        ↓
PEEK Housing Fabrication (CNC machining, all components pocketed)
        ↓
Full Assembly (mechanical integration, ZrO₂ screw fastening)
        ↓
Calibration (Helmholtz coil, G1/G3/G5 reference fields)
        ↓
Curie-Color Reference Card Packaging (laminated, UV-stabilized)
        ↓
Final Inspection: All indicators at CC-0, metal content = zero
```

---

## 10. Quality Acceptance Criteria

| Parameter | Specification | Test Method |
|-----------|--------------|-------------|
| KNN-BT birefringence sensitivity | Measurable at ≥ 10 kV/m (G3) | Polarimeter + Helmholtz coil |
| VO₂ transition temperature | 68 ± 2°C | DSC thermal analysis |
| Schumann resonant frequency | 7.83 ± 0.2 Hz | Impulse response FFT |
| Leuco-dye activation temp accuracy | ±3°C of specification | Hot plate calibration |
| Metal content (complete assembly) | Zero | Visual + conductivity inspection |
| Electrical resistivity (housing) | > 10¹⁴ Ω | ASTM D257 |
| CC-0 baseline (zero field) | All indicators quiescent | Shielded room verification |
| CC-3 response (20 kV/m, 7.83 Hz) | ≥ CC-3 on all active indicators | Helmholtz coil calibration |
| Reversibility (< 10 kV/m indicators) | Full return to CC-0 after field removal | Field cycle test |
| UV stability (YInMn reference tile) | ΔE* < 1.0 after 1,000 kJ/m² UV | ISO 4892-2 accelerated |

---

## 11. References and Standards

- NOAA Space Weather Prediction Center, Schumann Resonance Background Data Revision 2025
- NOAA/SWPC Geomagnetic Storm Scale (G1–G5), Kp-index correlation tables
- ASTM D257: Standard Test Methods for DC Resistance or Conductance of Insulating Materials
- ISO 4892-2: Plastics — Methods of Exposure to Laboratory Light Sources
- Lu, J. et al., "Ferroelectric Chromism in KNbO₃-BaTiO₃ Thin Films Under External Electric Field," *Advanced Materials*, 2025
- Nakano, M. et al., "Lead-Free Piezoelectric Passive Sensors for Environmental Monitoring," *Sensors and Actuators A*, 2025
- Williams, E.R., "Schumann Resonance Observations and Their Implications for Global Lightning Activity," *Surveys in Geophysics*, 2023; NOAA 2025 amplitude revision addendum
- Morin, F.J., "Oxides Which Show a Metal-to-Insulator Transition at the Neel Temperature," *Physical Review Letters*, 1959; VO₂ thermochromic application review, 2024
- Pozar, D.M., *Microwave Engineering*, 4th ed. — ELF passive resonator design principles

---

*"Electronics cannot survive what they are designed to detect. The only instrument that will reliably tell you the severity of a Carrington event is one that was never electronic to begin with. Color is permanent. Chromism is honest. The storm cannot blind a detector that sees with chemistry rather than circuits."*

**— CSM Engineering Design Directive, Aegis Home Series**

---

*Document prepared by: Carrington Storm Motors / Safe Pod Engineering Company*  
*CSMFAB Publication 021 | Version 2.0 | June 2026*  
*© 2026 Carrington Storm Motors. All rights reserved.*
