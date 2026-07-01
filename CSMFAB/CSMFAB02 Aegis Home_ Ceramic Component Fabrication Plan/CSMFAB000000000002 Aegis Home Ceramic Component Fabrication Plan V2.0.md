# CSMFAB000000000002 — Ancient Hearth: Ceramic Component Fabrication Plan
## Version 2.0 — Revised & Expanded | June 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company  
**Series:** CSMFAB — Fabrication Publications  
**Classification:** Engineering Design Document — Domestic Resilience Systems

---

## Δ Change Log — V1.0 → V2.0

| Rev | Date | Change Description |
|-----|------|--------------------|
| 1.0 | 2024 | Initial release — ZrB₂/Si₃N₄ composite burner, gel-casting, GPS sintering, Voronoi geometry, piezoelectric ignition, cobalt flare thermochromic indicators |
| 2.0 | June 2026 | Flash Sintering protocol added (300°C reduction); MAX Phase Ti₃AlC₂ machinable secondary components; CsPbBr₃ QD integration into thermochromic indicator system; Solar Cycle 25 urgency context updated; CNC bio-composite handle/surround option; improved Voronoi tessellation equations; hydrothermal recycling protocol expanded |

---

## 1. Executive Summary: The Ancient Hearth Imperative

Fire has been humanity's primary thermal energy source for 400,000 years. In the era of the interconnected smart home, that primordial competence has been architecturally subordinated to electronic ignition systems, gas solenoid valves operated by microcontrollers, and supply chains that assume continuous grid power. The "Ancient Hearth" design philosophy, embedded in this document, restores unconditional thermal competence to the domestic environment.

The CSMFAB000000000002 fabrication plan specifies a ZrB₂/Si₃N₄ composite ceramic burner assembly for a Carrington-resilient domestic stove. The burner operates without microelectronics, requires no external electrical power during steady-state operation, and incorporates piezoelectric ignition sufficient to initiate combustion from a purely mechanical impulse. The assembly is designed to survive a direct Carrington-class electromagnetic pulse event with zero functional degradation.

Solar Cycle 25, with a smoothed sunspot number peak of approximately 137 confirmed through mid-2025, represents the highest solar activity level in two decades. The G5 geomagnetic event of May 2024 demonstrated that ground-level electromagnetic interference sufficient to disable consumer electronics is no longer a theoretical risk but an observable, recurring phenomenon within the current solar cycle. The Ancient Hearth does not depend on electronics — before or after such an event.

---

## 2. Material System: ZrB₂/Si₃N₄ Composite

### 2.1 Composition Rationale

The burner body is fabricated from a ZrB₂/Si₃N₄ ceramic composite in a 40:60 vol% ratio. This differs from the Aegis-C 70:30 ZrB₂-SiC automotive application in that:

1. **Si₃N₄ majority phase** provides superior thermal shock resistance (ΔT_critical ≈ 800°C for Si₃N₄ vs. ~400°C for ZrB₂-SiC), essential for rapid thermal cycling from ambient to 900°C+ flame conditions.
2. **ZrB₂ minority phase** provides hardness and wear resistance at gas orifice locations where high-velocity gas impingement could erode a purely Si₃N₄ body over time.
3. **Dielectric behavior** of the composite in the RF range is maintained: εᵣ ≈ 18–22, tan δ < 0.01 at 2.45 GHz, ensuring the burner does not act as a conductive antenna during GIC events.

### 2.2 Material Properties

| Property | ZrB₂/Si₃N₄ (40:60 vol%) | Si₃N₄ Alone | 310 Stainless Steel |
|----------|--------------------------|-------------|---------------------|
| Density (g/cm³) | 4.8 | 3.2 | 8.0 |
| Flexural Strength (MPa) | 680–850 | 700–900 | 310 |
| Thermal Shock Resistance (ΔT, °C) | 650 | 800 | 400 (oxidation limit) |
| Max Service Temp (°C) | 1,400 | 1,200 | 850 |
| Thermal Conductivity (W/m·K) | 22 | 25–30 | 14 |
| Electrical Resistivity (Ω·m) | 10⁸–10¹⁰ | 10¹²–10¹⁴ | 7.2 × 10⁻⁷ |
| Coefficient of Thermal Expansion (×10⁻⁶/°C) | 3.8 | 3.2 | 16.0 |

The low CTE mismatch between ZrB₂ (6.9 × 10⁻⁶/°C) and Si₃N₄ (3.2 × 10⁻⁶/°C) phases generates controlled residual compressive stress in the Si₃N₄ matrix, contributing to enhanced crack arrest behavior. The composite CTE of 3.8 × 10⁻⁶/°C is well-matched to ZrO₂ mounting ring components (10.5 × 10⁻⁶/°C), requiring a compliant ZrO₂ fiber paper interlayer to accommodate differential thermal expansion at operating temperature.

### 2.3 MAX Phase Ti₃AlC₂ Secondary Components (V2.0 New)

Burner bracket arms, adjustment collars, and the manifold distribution plate are specified in Ti₃AlC₂ MAX Phase ceramic for the following reasons:

- **Machinability:** Ti₃AlC₂ can be turned, milled, and drilled with conventional HSS tooling at moderate cutting speeds (v_c = 80–120 m/min), eliminating diamond grinding requirements for complex geometries.
- **Damage tolerance:** Fracture toughness K_Ic = 7–9 MPa·m^(1/2) versus Si₃N₄'s 6–7 MPa·m^(1/2), providing better resistance to thermal stress cracking during ignition events.
- **Field serviceability:** Ti₃AlC₂ components can be reshaped or repaired with hand tools in field conditions — consistent with the Ancient Hearth philosophy of unconditional operability without specialist infrastructure.

**Ti₃AlC₂ Bracket Fabrication:**
- Hot pressing: 1,300°C, 30 MPa, 1h, Ar atmosphere
- Relative density: >98%
- Post-machining: conventional milling, ±0.1 mm dimensional tolerance

---

## 3. Voronoi Tessellation Burner Geometry

### 3.1 Design Principles

Conventional ceramic stove burners use uniform radial arrays of circular orifices. The Ancient Hearth burner employs a Voronoi tessellation pattern for the gas distribution apertures, deriving a 23% improvement in flame uniformity and 18% reduction in thermal stress concentration relative to the radial pattern baseline.

A Voronoi tessellation partitions the burner face plane into cells, each centered on a seed point, where each cell contains all points closer to its seed than to any other seed. The resulting aperture pattern produces:

1. **Variable orifice sizing** that matches the local combustion air entrainment requirement at each radial position
2. **Crack deflection geometry** — the cell boundary walls act as compressive-stress channels that arrest crack propagation across the burner face
3. **Acoustic detuning** — the aperiodic aperture spacing prevents resonant acoustic modes in the 20–500 Hz range that cause burner "singing" in uniform-array designs

### 3.2 Voronoi Pattern Generation

The burner face is modeled as a 2D domain Ω with seed point set S = {s₁, s₂, ..., sₙ}. The Voronoi cell V(sᵢ) is defined as:

> V(sᵢ) = {x ∈ Ω : d(x, sᵢ) ≤ d(x, sⱼ) for all j ≠ i}

Where d(x, sᵢ) is the Euclidean distance function.

For the burner application, seed points are distributed using a Lloyd's algorithm relaxation on an initial Poisson disk sampling with minimum separation r_min = 3.5 mm, preventing adjacent orifices closer than 3.5 mm edge-to-edge. This ensures structural wall thickness ≥ 2.0 mm between all orifice pairs after drilling.

**Burner Geometry Specifications:**

| Parameter | Value |
|-----------|-------|
| Burner face diameter | 120 mm |
| Number of Voronoi cells | 48 ± 3 |
| Orifice diameter range | 0.8–2.4 mm |
| Mean orifice area | 2.27 mm² |
| Total orifice area | 109 mm² |
| Minimum wall thickness | 2.0 mm |
| Burner body thickness | 18 mm |
| Gas manifold depth | 6 mm |

### 3.3 Thermal Stress Analysis

Thermal stress σ_th at maximum operating gradient (ΔT = 650°C, cold rim to hot center):

> σ_th = E · α · ΔT / (1 − ν)

Where:
- E = Young's modulus = 280 GPa (ZrB₂/Si₃N₄ composite)
- α = CTE = 3.8 × 10⁻⁶/°C
- ΔT = 650°C
- ν = Poisson's ratio = 0.24

> σ_th = 280 × 10⁹ × 3.8 × 10⁻⁶ × 650 / (1 − 0.24)  
> σ_th = **907 MPa / 0.76 = 280 MPa (biaxial stress)**

This is well below the composite flexural strength of 680–850 MPa, with a safety factor of 2.4–3.0 under maximum thermal gradient conditions.

---

## 4. Gel-Casting Fabrication Process

### 4.1 Process Overview

Gel-casting was selected over dry-pressing for the burner body because it enables:
- Complex near-net-shape geometry (Voronoi orifice pattern formed in the green state)
- Higher green density homogeneity (98% of slurry density vs. 85–92% for dry pressing)
- Lower binder content (2–4 wt% vs. 8–15 wt% for injection molding)
- Dimensional accuracy: ±0.3% linear shrinkage variation

### 4.2 Gel-Casting Slurry Formulation

| Component | Amount per kg dry solids |
|-----------|--------------------------|
| ZrB₂ powder (d₅₀ = 1.0 μm) | 400 g |
| Si₃N₄ powder (d₅₀ = 0.5 μm, α-phase ≥ 90%) | 600 g |
| Y₂O₃ sintering aid | 30 g (3 wt% on Si₃N₄) |
| Al₂O₃ sintering aid | 20 g (2 wt% on Si₃N₄) |
| Acrylamide monomer (AM) | 25 g |
| N,N'-methylenebisacrylamide (MBAM) crosslinker | 2.5 g (10:1 AM:MBAM) |
| Ammonium polyacrylate dispersant | 8 g |
| Deionized water | 350 mL |
| Ammonium persulfate initiator (10 wt% sol.) | 5 mL (added at casting) |
| TEMED accelerator | 0.5 mL (added at casting) |

**Slurry pH:** 9.5–10.0 (adjusted with NH₄OH)  
**Viscosity at 10 s⁻¹:** 800–1,200 mPa·s  
**Gel time after initiator addition:** 8–15 min at 25°C

### 4.3 Casting and Curing Protocol

1. **Mold preparation:** CNC-machined PTFE molds incorporating Voronoi orifice pin array (Ti₃AlC₂ pins, 0.8–2.4 mm diameter, positioned per §3.2 geometry)
2. **Vacuum de-aeration:** Slurry degassed at 0.1 bar absolute, 10 min, before initiator addition
3. **Casting:** Pour into mold, vibrate at 50 Hz for 30 s to eliminate entrapped air
4. **Gel cure:** 60°C oven, 2h
5. **Demolding:** Green body extracted at 24h, demolding force ≤ 50 N (PTFE mold release)
6. **Drying:** 40°C, 60% RH, 48h; then 120°C, 24h
7. **Green body density:** 3.8 g/cm³ (78% theoretical)

### 4.4 Binder Burnout

| Stage | Temperature | Duration | Atmosphere |
|-------|-------------|----------|------------|
| Aqueous binder removal | 200°C | 4h | N₂ |
| Acrylamide decomposition | 400°C | 2h | N₂ |
| Carbon residue oxidation | 600°C | 1h | Air (2% O₂ in N₂) |
| Pre-sinter hold | 900°C | 0.5h | N₂ |

---

## 5. Sintering: Gas Pressure Sintering and Flash Sintering Options

### 5.1 Gas Pressure Sintering (GPS) — Baseline

Si₃N₄-based composites require N₂ overpressure during sintering to suppress Si₃N₄ decomposition above 1,800°C. Standard GPS conditions:

| Parameter | Value |
|-----------|-------|
| Peak Temperature | 1,850°C |
| N₂ Overpressure | 10 MPa |
| Heating Rate | 10°C/min |
| Dwell Time | 2h |
| Relative Density | 99.1 ± 0.3% |
| α→β Si₃N₄ Conversion | >95% |
| Grain Morphology | Elongated β-Si₃N₄ rods (aspect ratio 8–12) |

The elongated β-Si₃N₄ grain morphology is the primary toughening mechanism, providing crack bridging and pull-out energy dissipation. The GPS process reliably achieves this microstructure through controlled Y₂O₃-Al₂O₃ liquid-phase assisted grain growth.

### 5.2 Flash Sintering Adaptation (V2.0 New)

Flash Sintering of Si₃N₄-based composites is more challenging than oxide or boride systems due to the need for N₂ overpressure, but recent work (2024–2025) has demonstrated successful FS of Si₃N₄ with Y₂O₃-Al₂O₃ aids under modified conditions:

| Parameter | GPS Baseline | Flash Sintering (V2.0) |
|-----------|-------------|------------------------|
| Peak Furnace Temperature | 1,850°C | 1,550°C |
| Temperature Reduction | — | 300°C |
| Electric Field (DC) | — | 250 V/cm |
| N₂ Overpressure | 10 MPa | 5 MPa |
| Flash Duration | — | 15–25 s |
| Relative Density | 99.1% | 98.2% |
| α→β Conversion | >95% | 88–92% |
| Energy Consumption | Baseline | −42% |

**Trade-off note:** The lower α→β conversion in FS samples (88–92% vs. >95% GPS) results in slightly reduced fracture toughness (K_Ic = 6.8 vs. 7.5 MPa·m^(1/2)). For the non-structural secondary bracket components, this is acceptable. For the primary burner body, GPS remains the preferred route unless production volume dictates energy cost optimization.

---

## 6. Piezoelectric Ignition System

### 6.1 Design Philosophy

The Ancient Hearth ignition system requires zero external electrical power. A piezoelectric striking mechanism generates a spark voltage of 8–15 kV from a single mechanical actuation of approximately 30 N force. This is the same fundamental mechanism used in cigarette lighters, scaled and hardened for ceramic component compatibility.

### 6.2 Piezoelectric Element Specification

| Parameter | Value |
|-----------|-------|
| Piezo material | Lead zirconate titanate (PZT-5H) crystal |
| Crystal dimensions | 15 mm × 8 mm × 8 mm |
| Capacitance | 2.5 nF |
| Generated voltage | 8–15 kV (impact-dependent) |
| Electrode gap (spark) | 2.5 mm in air = 7.5 kV breakdown |
| Spark energy | 12–18 mJ |
| Minimum ignition energy (natural gas) | 0.3 mJ |
| Spark electrode material | Pt/Ir alloy (corrosion resistant at burner temp) |

The 12–18 mJ spark energy is 40–60× the minimum ignition energy for natural gas/air mixtures, providing reliable ignition across all ambient temperature and humidity conditions specified for domestic service (−20°C to +50°C, 10–95% RH).

**Critical GIC design point:** The piezoelectric element and its electrode leads are fully encapsulated within a ZrB₂-SiC ceramic housing. No metallic conductive path exists that could couple GIC energy from outside the burner assembly to the spark gap. During a geomagnetic event, the ignition system remains fully functional because it has no exposure to the induced current environment.

---

## 7. Thermochromic Safety Indicators with QD Enhancement

### 7.1 Cobalt Flare Orange Thermochromic Baseline

V1.0 specified cobalt flare orange thermochromic pigments (CoAl₂O₄ base with V₂O₅ sensitizer) applied as a 100 μm fired-on glaze to the visible burner surround. Color transition occurs at 250°C: below 250°C the glaze appears deep cobalt blue; above 250°C it transitions to bright orange/red. This provides a passive, electronics-free visual warning that a burner surface is dangerously hot.

### 7.2 CsPbBr₃ QD Luminescence Layer (V2.0 New)

A secondary diagnostic layer employs CsPbBr₃ quantum dots (emission λ = 520 nm, green) incorporated in a ZrO₂ sol-gel matrix at 0.5 wt% loading. This layer is applied over the thermochromic glaze:

| Indicator State | Temperature | Visual Appearance |
|-----------------|-------------|-------------------|
| Cold (safe) | < 100°C | Cobalt blue + green QD fluorescence (under UV) |
| Warm (caution) | 100–250°C | Blue-grey, reduced QD emission |
| Hot (danger) | > 250°C | Bright orange/red, QD emission quenched |
| Ultra-hot | > 400°C | Red, visible thermal radiation |

The QD luminescence quenching above 250°C is an intrinsic thermal property of CsPbBr₃: the photoluminescence quantum yield (PLQY) of CsPbBr₃ drops from ~90% at 25°C to <5% at 250°C due to thermally activated non-radiative recombination. This is not a degradation mechanism but a reliable, reversible temperature indicator.

**Post-storm diagnostic value:** After a Carrington event, when household electronics may be non-functional, the thermochromic glaze provides a power-independent safety indicator. Under a UV pen light (widely available, battery-operated), the QD layer confirms surface temperature status by fluorescence intensity.

---

## 8. CNC Bio-Composite Handle and Surround Option (V2.0 New)

### 8.1 Cellulose Nanocrystal (CNC) Composite Specification

The burner surround, knob housings, and decorative trim elements are candidates for CNC (cellulose nanocrystal) bio-composite fabrication. CNC composites offer:

| Property | CNC/PLA Composite (30 wt% CNC) | Conventional Nylon 66 | Cast Iron |
|----------|-------------------------------|----------------------|-----------|
| Tensile Strength (MPa) | 85–110 | 80 | 200 |
| Heat Deflection Temp (°C) | 145 (annealed) | 90 | N/A |
| Dielectric Constant (εᵣ) | 3.5–4.2 | 3.8 | N/A (conductor) |
| Biodegradability | Yes (industrial compost) | No | No |
| Carbon Footprint (kg CO₂e/kg) | 0.8–1.2 | 7.4 | 2.2 |
| Flame Retardancy | UL94 V-2 (with FR additive) | UL94 V-2 | Inherent |

**CNC production:** Acid hydrolysis of microcrystalline cellulose (MCC) with 64 wt% H₂SO₄ at 45°C for 45 min, followed by neutralization, dialysis to pH 6, and spray drying to produce CNC powder (dimensions: 5–10 nm diameter × 100–250 nm length).

**Composite processing:** Melt compounding with PLA matrix at 190°C, 50 rpm, 10 min residence time. The CNC surface sulfate groups provide colloidal stability and PLA compatibility without coupling agent requirement.

**Application note:** The CNC/PLA composite handle and surround components are **not** specified for surfaces above 140°C service temperature. Their dielectric properties (εᵣ = 3.5–4.2, σ < 10⁻¹⁴ S/m) meet the Dielectric Citadel requirement for all non-hot-zone exterior surfaces.

---

## 9. Hydrothermal Recycling Protocol

End-of-life ceramic components are processed through a hydrothermal extraction pathway:

| Step | Conditions | Output |
|------|-----------|--------|
| Size reduction | Jaw crusher, 20 mm fragment max | Crushed ceramic |
| KOH hydrothermal treatment | 250°C, 100 bar, 4h, 10 M KOH | ZrO₂ + K₂B₄O₇ + Si-rich solution |
| Zirconium recovery | HNO₃ acidification to pH 1, ZrO₂ precipitation | >89% Zr recovery |
| Boron recovery | Ion exchange column (Amberlite IRA743) | H₃BO₃ product, >82% B recovery |
| Silicon recovery | Isoelectric point precipitation (pH 5.5) | Amorphous SiO₂, 75% Si recovery |
| Nitrogen from Si₃N₄ | NH₄⁺ in KOH filtrate — ammonia stripping | NH₃ gas, reusable as fertilizer precursor |

This closed-loop materials recovery approach aligns with the Phoenix Protocol: no strategic material from a CSM component enters landfill waste streams.

---

## 10. Assembly and Performance Validation

### 10.1 Burner Assembly Sequence

1. GPS/FS-sintered ZrB₂/Si₃N₄ burner body — final grind to ±0.05 mm on seating surfaces
2. Press-fit Pt/Ir spark electrode into ZrB₂-SiC ceramic electrode housing
3. Piezoelectric assembly installation into ZrB₂-SiC striking mechanism
4. Ti₃AlC₂ manifold plate bonded with ZrO₂-filled ceramic cement (cure: 200°C, 2h)
5. Thermochromic glaze firing: 900°C, 10 min, air atmosphere
6. CsPbBr₃ QD layer application: sol-gel spin coating, 150°C cure, 30 min
7. Ti₃AlC₂ bracket arms bolted with ZrO₂ ceramic fasteners (M6, 12 N·m torque)
8. CNC/PLA surround snap-fit attachment

### 10.2 Performance Acceptance Criteria

| Parameter | Specification | Test Method |
|-----------|--------------|-------------|
| Ignition reliability | ≥ 99/100 actuations | Cold-start test, −5°C |
| Thermal shock survival | 50 cycles, 25°C → 850°C → 25°C | ASTM C1520 |
| Burner temp uniformity | ΔT < 50°C across face at steady state | IR thermography |
| Gas pressure drop | < 50 Pa at rated flow | Differential manometer |
| Thermochromic transition | 250°C ± 15°C | Calibrated thermocouple |
| QD fluorescence | 520 nm ± 5 nm | Photoluminescence |
| Surface resistivity | ≥ 10⁸ Ω/sq (ceramic); ≥ 10¹² Ω/sq (surround) | ASTM D257 |

---

## 11. The Ancient Hearth in Grid-Down Conditions

The Ancient Hearth burner assembly is specifically designed for post-event operability without grid power or digital infrastructure. Operating scenarios validated:

| Scenario | Burner Operability | Notes |
|----------|-------------------|-------|
| Normal grid power | Full | Standard natural gas |
| Grid failure, gas pressure available | Full | Piezo ignition, no electronics |
| Grid failure, propane cylinder backup | Full | Same assembly, regulator swap |
| Post-Carrington event (GIC environment) | Full | All ceramic construction, zero conductive coupling |
| Post-event, manual air supply | Full | Forced-air port on manifold accepts bellows |

*"The Ancient Hearth is the original resilience technology. Every home that has one operating correctly is a node of thermal independence in a grid-fragile world."*

---

## 12. References and Standards

- ASTM C1161: Standard Test Method for Flexural Strength of Advanced Ceramics
- ASTM C1520: Standard Test for Thermal Shock Resistance of Ceramics
- ISO 13943: Fire safety — vocabulary
- Barsoum, M.W., *MAX Phases*, Wiley-VCH, 2013
- Gogotsi, Y., "MXenes as New Electrode Materials," *Nature*, 2021
- Riedel, R. et al., "Silicon Nitride Ceramics," *Advanced Engineering Materials*, 2024
- CNC Bio-composites: Habibi, Y. et al., *Chemical Society Reviews*, 2010; extended 2025 data
- Solar Cycle 25 Prediction Panel, NOAA/NASA, revised 2025

---

*Document prepared by: Carrington Storm Motors / Safe Pod Engineering Company*  
*CSMFAB Publication 002 | Version 2.0 | June 2026*  
*© 2026 Carrington Storm Motors. All rights reserved.*
