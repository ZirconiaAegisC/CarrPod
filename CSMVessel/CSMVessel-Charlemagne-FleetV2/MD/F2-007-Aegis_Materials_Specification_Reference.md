# F2-007 — Aegis Materials Specification Reference
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Primary Structural Ceramics

### ZrB₂–SiC (12 vol% ZrB₂ in SiC matrix, Flash-Sintered)

**Application in fleet:** CMBC vault, AAJ reinforcement rings, nose cone assemblies

**Fabrication standard:** Flash Sintering Protocol (F2-043)
- Temperature: 1,800°C (reduced from 2,100°C SPS by F2-043 protocol saving 40% energy)
- Time: 5 min at temperature
- Pressure: 50 MPa
- Atmosphere: argon
- Density achieved: >98% theoretical

**Mechanical properties (as-sintered, room temperature):**
| Property | Value | Test Standard |
|---|---|---|
| Tensile strength | 850 MPa | ASTM C1273 |
| Compressive strength | 1,800 MPa | ASTM C773 |
| Fracture toughness K_IC | 4.0 MPa·m^0.5 | ASTM C1421 |
| Vickers hardness | 22 GPa | ASTM C1327 |
| Young's modulus | 250 GPa | ASTM C1259 |
| Poisson's ratio | 0.14 | ASTM C1259 |

**Thermal properties:**
| Property | Value |
|---|---|
| Melting point (ZrB₂ phase) | 3,245°C |
| Safe service temperature | 2,000°C (oxidizing), 2,800°C (inert) |
| Thermal conductivity | 55–65 W/m·K at 1,000°C |
| Coefficient of thermal expansion | 7.2×10⁻⁶ /K (average 25–1500°C) |

**Electrical properties:**
| Property | Value |
|---|---|
| Bulk resistivity (at 12 vol% ZrB₂) | >10¹⁰ Ω·m |
| This is BELOW the ZrB₂ percolation threshold (~15 vol%) | — |
| The ceramic is an electrical insulator despite ZrB₂ content | — |

**Supplier options (2026):**
- Treibacher Industrie AG (Austria): powder, 99.5%, <5 µm, $280–320/kg
- American Elements (USA): powder, 99.5%, $340–380/kg, MOQ 100g
- In-house SHS (Self-propagating High-temperature Synthesis): ~$95–110/kg (see F2-048)

### ALON (Aluminum Oxynitride, Al₂₃O₂₇N₅)

**Mechanical properties (Surmet SA/F-series):**
| Property | Value | Test |
|---|---|---|
| Knoop hardness | 1,800 kg/mm² | ASTM C849 |
| Young's modulus | 334 GPa | ASTM C1259 |
| Shear modulus | 135 GPa | ASTM C1259 |
| Compressive strength | 2,680 MPa | ASTM C773 |
| Flexural strength | 304 MPa | ASTM C1161 |
| Density | 3.69 g/cm³ | — |

**Optical properties:**
- Transmission range: 200–5,000 nm (UV to mid-IR)
- Refractive index at 550 nm: 1.790
- Internal transmittance >85% at 550 nm (10 mm thickness)

**Supplier:** Surmet Corporation, 33 Northwestern Drive, Burlington MA 01803 USA
- Lead time: 14–20 weeks for polished stock
- Cost: $800–1,200/kg polished and finished plate
- MOQ: project quantities (call for quote)
- Note: Surmet is the ONLY domestic US commercial ALON producer as of 2026

### Si₃N₄ (β-phase, gas-pressure sintered with Y₂O₃ additive)

**Application:** Hub motor bearings (rolling elements and races)

**Properties:**
| Property | Value |
|---|---|
| Density | 3.21 g/cm³ (vs steel 7.85) — 59% lighter |
| Vickers hardness | 1,700 kg/mm² |
| Young's modulus | 310 GPa |
| Fracture toughness | 5.5–8 MPa·m^0.5 (with Y₂O₃ additive) |
| Electrical resistivity | >10¹² Ω·m |
| Service temperature | −40°C to +800°C |
| Thermal expansion | 2.7×10⁻⁶ /K (vs steel 11.7×10⁻⁶ /K) |

**Supplier:** NSK (Si₃N₄ bearing catalog), NTN, or Boca Bearing Company
- Standard bearing sizes available in Si₃N₄ from stock
- Custom sizes: 6–8 week lead from Kyocera Industrial Ceramics

## 2. Composite Materials

### BFRP/Elium® (Basalt Fiber Reinforced Polymer, Thermoplastic Matrix)

**Fiber specification:**
- Base mineral: Basalt (SiO₂ 45–55%, Al₂O₃ 12–17%, Fe₂O₃ 9–15%)
- Fiber tensile strength: 4,840 MPa (Mafic USA aerospace grade)
- Fiber modulus: 95 GPa
- Fiber density: 2.67 g/cm³
- Supplier: Mafic USA, Telford PA; Basaltex (Belgium)

**Matrix specification:**
- Resin: Elium® 175 (Arkema SA, France) — methyl methacrylate base
- Cure: Ambient temperature (23°C), 30–90 min, no autoclave required
- Post-cure: 60°C/2h for maximum Tg=110°C
- Recyclability: Thermal solvolysis at 350°C → 95% fiber recovery + 100% monomer recovery

**Composite mechanical properties at 60% FVF:**
| Property | Value | Direction |
|---|---|---|
| Tensile strength | 1,100 MPa | Along fiber (0°) |
| Tensile modulus | 65 GPa | Along fiber (0°) |
| Tensile strength | 50 MPa | Transverse (90°) |
| Density | 1.85 g/cm³ | — |
| Electrical resistivity | >10¹² Ω·m | — |

## 3. Piezoelectric Material

### KNbO₃–BaTiO₃ (Lead-Free, Tc=310°C)

This is the **mandatory** piezoelectric material for ALL fleet applications.
PZT (lead zirconate titanate) is PROHIBITED in the Charlemagne Fleet due to:
(a) EU RoHS Directive 2011/65/EU restricts lead compounds in EEE
(b) REACH restriction SVHC list
(c) PZT Tc=193°C is insufficient for underhood temperatures in AMETHYST/RHODONITE

**KNbO₃–BaTiO₃ key properties:**
| Property | Value | Comparison to PZT-5H |
|---|---|---|
| d₃₃ (piezo charge constant) | 285 pC/N | PZT-5H: 289 pC/N (+1.4%) |
| Curie temperature Tc | 310°C | PZT-5H: 193°C (+60%) |
| Dielectric constant | 600–1,200 at 1 kHz | PZT-5H: 3,400 |
| Density | 4,850 kg/m³ | PZT-5H: 7,750 kg/m³ |
| Compliance | RoHS/REACH | PZT: RESTRICTED |
| In-house synthesis cost | $28–40/kg | Commercial: $180–250/kg |

**In-house synthesis (see F2-048):**
K₂CO₃ + Nb₂O₅ → 2 KNbO₃ (at 1,000°C, 4 h, air)
Then solid-state blending with BaTiO₃ → co-fire 1,250°C/2h → pole 3 kV/mm at 130°C

## 4. Coating Materials

### YInMn Blue + CsPbBr₃ QD Topcoat (see F2-018 for full spec)
- Solar Reflectance Index SRI = 130 (vs standard dark coat SRI = 10–25)
- NIR (700–2500 nm) reflectance: 85–92%
- Temperature differential vs dark surface in direct sun: up to 70°C cooler
- Critical mineral: Indium (In) — Phoenix Protocol recovery 99.4% at EOL (F2-048)

### MXene Ti₃C₂Tₓ (see F2-017 for full spec)
- EMI SE = 92 dB at 1–40 GHz in 50 µm thickness (ACS AMI 2025)
- Tile pattern (5×5 cm with 1 mm gaps): blocks GHz while preventing DC GIC loops
- In-house synthesis from MAX Phase Ti₃AlC₂: $55–75/kg vs $1,500–2,500/kg commercial

Cross-reference: F2-008 (AAJ), F2-009 (ALON), F2-015 (ZrB₂ vault), F2-042 (VARTM).


---
*End F2-007 | CSMVessel-Charlemagne-FleetV2 | June 2026*
