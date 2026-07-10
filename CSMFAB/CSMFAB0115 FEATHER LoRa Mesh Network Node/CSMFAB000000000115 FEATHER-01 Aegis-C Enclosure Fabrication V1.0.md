# CSMFAB000000000115 V1.0
## FEATHER-01: Aegis-C Composite Enclosure — Fabrication Specification
### Version 1.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications
**Classification:** Manufacturing Process Document

---

## 1. Enclosure Requirements

The FEATHER node enclosure must:
1. Provide SE ≥ 148 dB across 1 kHz to 10 GHz to protect internal electronics from CME-induced E1, E2, and E3 EMP components
2. Maintain dielectric isolation from mounting pole — zero GIC pathway to internal electronics
3. Withstand 50 years of California sun exposure (UV Index 8–11 in summer)
4. Operate as a NEMA 4X/IP66 enclosure
5. Pass UL 94 V-0 flammability rating (non-contributor to wildfire)
6. Maintain internal temperature below 65°C with passive cooling only
7. Provide integrated solar panel mounting with 50 psf snow load capacity for Sierra installations
8. Total weight ≤ 4.5 kg for the empty enclosure assembly

## 2. Material Selection: Aegis-C Lite Formula

### 2.1 Primary Shell — ZrB₂-SiC Composite (Reduced Thickness)

| Parameter | Aegis-C Full | Aegis-C Lite (FEATHER) |
|-----------|-------------|------------------------|
| Laminae count | 12–24 | 6 (3 × 0°, 3 × 90° alternating) |
| Sintered wall thickness | 1.5–3.0 mm | 0.75 ± 0.05 mm |
| SE at 45 kHz (MXene layer) | 92 dB | 88 dB |
| Total composite SE | 148–165 dB | 148–152 dB |
| Weight per enclosure | 3.8 kg | 2.1 kg |
| Flexural strength | 450–620 MPa | 380–420 MPa |

### 2.2 Tape Casting Slurry (per 1 kg dry solids)

| Component | Mass |
|-----------|------|
| ZrB₂ powder (d₅₀ = 1.2 μm) | 700 g |
| SiC powder (d₅₀ = 0.8 μm) | 300 g |
| PVB binder (Butvar B-98) | 55 g |
| DBP plasticizer | 28 g |
| Ethanol/MEK (1:1 vol) | 380 mL |
| Menhaden fish oil dispersant | 4 g |

**Doctor blade gap:** 150 μm (yields ~90 μm green tape)
**Green tape density:** 3.1 g/cm³

### 2.3 MXene Ti₃C₂Tₓ EMI Layer Application

1. **Etching:** Ti₃AlC₂ MAX phase etched in 40% HF (48 hours, 25°C) → Ti₃C₂Tₓ colloidal suspension
2. **Delamination:** DMSO intercalation (18 hours, 25°C)
3. **Spray deposition:** 50 μm nozzle, 3 bar N₂, 15 cm distance, 3 passes → 45 ± 5 μm dried film
4. **Curing:** Vacuum oven, 80°C, 4 hours → cross-linked Ti₃C₂Tₓ film with 88 dB SE
5. **Encapsulation:** ALD alumina (Al₂O₃) overcoat, 15 nm, 200°C — prevents MXene oxidation

### 2.4 YInMn Blue Exterior Coating

**Formula:** YIn₀.₉Mn₀.₁O₃ pigment (28 wt%), Tego RAD 2500 UV-curable acrylate (58 wt%), TiO₂ UV blocker (10 wt%), BYK-333 wetting agent (2 wt%), Irgacure 819 photoinitiator (2 wt%)
**NIR reflectance:** 78% → surface temperature 12–15°C below ambient on 110°F day

## 3. Enclosure Molding & Assembly

Two-piece clamshell with tongue-and-groove EMI seal joint. Silver-plated copper knit mesh gasket (3 mm dia) compressed to 1.5 mm. Cable penetrations via waveguide-below-cutoff (WBC) feedthroughs. RF antenna: N-type bulkhead connector, PTFE dielectric, DC-blocked (500V standoff). Solar panel: Amphenol AT series 2-pin, 100 nF/1 kV DC-block capacitor on internal side.

## 4. SPS Sintering Protocol

| Parameter | Value |
|-----------|-------|
| Die material | Graphite (ISO-63) |
| Pressure | 35 MPa |
| Temperature ramp | 100°C/min to 1850°C |
| Hold time | 5 minutes at 1850°C |
| Cycle time | 45 minutes per shell |
| Energy consumption | 4.2 kWh per shell |

### 4.1 Flash Sintering Alternative (High-Volume)

At 5,000+ units/year: DC field 120 V/cm, furnace 1200°C, 8 min cycle, 0.8 kWh/shell — 81% energy reduction, 94% of SPS flexural strength.

## 5. Passive Thermal Management

1. YInMn Blue NIR reflectance → 12–15°C solar heat gain reduction
2. 6 mm air gap between PCB mounting plate and enclosure interior via BFRP standoffs
3. PCM (PureTemp 53, Tm=53°C, 220 kJ/kg latent heat, 50g) — absorbs 11 kJ during peak solar load

**Verified thermal model:** Internal PCB temperature stays below 58°C at 45°C ambient with 1100 W/m² solar irradiance.

## 6. Quality Control Checks

| Test | Standard | Acceptance Criteria |
|------|----------|---------------------|
| EMI SE | IEEE 299 | ≥ 148 dB at 1 GHz |
| IP66 water ingress | IEC 60529 | No water after 100 L/min at 3 m for 3 min |
| Salt fog | ASTM B117 | 1000 hours, no corrosion |
| Thermal cycling | -40°C ↔ +85°C, 100 cycles | No MXene delamination |
| UV exposure | ASTM G154 Cycle 1 | ΔE < 3.0 after 2000 hours |
| Mechanical shock | MIL-STD-810G 516.6 | 40g, 11 ms, 3 axes |

---

*The enclosure is the first line of the Citadel. It does not fail.*
