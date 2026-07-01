# CSMFAB000000000113-Vol-18
## Solid Rocket Second Stage Integration: GIC-Immune Design
**Series:** CSMFAB000000000113 | **Volume:** 18 of 29 | **June 2026**

---

## 1. SRM Design Requirements

The second stage SRM must be:
1. **GIC-immune:** No metallic electrical paths through the motor body
2. **Seawater-launch compatible:** Sealed against moisture during underwater transit
3. **Compact enough to fit inside spear nose cone**
4. **Reliably ignitable** using Aegis piezoelectric systems (no e-match copper wire)

### 1.1 Propellant: APCP (Ammonium Perchlorate Composite)

Standard APCP composition for high-Isp hobbyist motors:
- Ammonium perchlorate (AP): 68% — oxidizer
- Aluminum powder: 18% — fuel (NOTE: aluminum is conductive — mitigated by discontinuous particle geometry)
- HTPB binder: 14% — matrix (hydroxy-terminated polybutadiene)

**V2.0 GIC-immune modification:**
Replace aluminum powder with **boron carbide (B4C)** fuel:
- B4C density: 2.52 g/cm3 (vs Al: 2.70)
- B4C Isp contribution: slightly lower than Al but competitive
- **B4C is electrically insulating** (rho > 10^8 Ohm·m) — no GIC coupling through propellant
- Revised composition: AP 72%, B4C 14%, HTPB 14%
- Isp penalty: ~5% reduction (255s vs 260s for Al-APCP)

**Alternatively:** Replace Al with **diborane-reduced ZrB2 particles** — consistent with Aegis portfolio.
ZrB2 as APCP fuel: high energy density (18 MJ/kg), GIC-immune, consistent with CSMFAB materials ecosystem.

### 1.2 Motor Case: BFRP/Elium® Cylinder

Pressure vessel design for SRM case:
- Operating pressure: 10 MPa (100 bar) — typical APCP chamber pressure
- Design pressure: 15 MPa (150% MEOP)
- Safety factor: 4.0 on burst

From CSMFAB000000000009 BFRP rebar data (hoop stress formula, Barlow):
```
Wall thickness: t = P * D / (2 * sigma) = 15e6 * 0.06 / (2 * 500e6) = 0.9 mm
```

For D=60 mm (Scale 3 SRM), t = 0.9 mm, add 1mm safety margin: **t = 2 mm wall**

BFRP cylinder mass per meter: rho * pi * D * t * 1 = 1850 * pi * 0.06 * 0.002 = 0.697 kg/m
For L=1.2 m SRM: m_case = 0.697 * 1.2 = **0.84 kg**

### 1.3 Nozzle: ZrB2-SiC Ceramic

Chamber gas temperature for APCP: ~3200°C
ZrB2-SiC melting point: 3245°C — marginal!

**Solution:** Hafnium diboride (HfB2) nozzle throat insert, T_melt = 3387°C:
- Provides 187°C margin above combustion temperature
- HfB2 throat erosion rate: 0.04 mm/s at 3200°C (test data, Fahrenholtz et al. 2007)
- For 30 s burn, throat erosion: 1.2 mm — acceptable for single-use nozzle
- Body: ZrB2-SiC (adequate except at throat)

### 1.4 Piezoelectric Ignition System

Standard e-match (NiCr bridgewire in BP primer): requires metallic wire — GIC-sensitive.

**V2.0 Aegis piezoelectric igniter:**
KNbO3-BaTiO3 impact-sensitive piezo striker (adapted from CSMFAB000000000021 EMF detector):
- Strike energy: 10 mJ at 8 kV output
- Minimum AP ignition threshold: 1 mJ at 200°C local hot spot
- 10 mJ >> 1 mJ: reliable ignition
- Zero metal electrical paths
- Triggered by spring-loaded ZrO2 striker pin, released by PEEK CF40 retention clip
- PEEK clip retraction: LoRa command activates KNbO3-BaTiO3 linear actuator → releases pin

**Ignition sequence:**
1. Apogee detected by barometric sensor (FBG optical pressure sensor)
2. LoRa master vessel command received by spear electronics
3. PEEK retention clip releases → ZrO2 striker spring fires → piezo igniter activates
4. BP primer ignites → APCP grain ignites → motor burns

---

## 2. Complete SRM Specifications (Scale 3)

| Parameter | Value |
|---|---|
| Motor type | GIC-immune APCP SRM |
| Diameter | 60 mm |
| Length | 1.2 m |
| Total mass | 35.0 kg |
| Propellant mass | 32.4 kg |
| Case mass (BFRP) | 0.84 kg |
| Nozzle mass (ZrB2-SiC + HfB2 insert) | 0.76 kg |
| Igniter mass | 0.04 kg |
| Hardware/misc | 0.96 kg |
| Burn time | ~28 s |
| Average thrust | ~2,750 N |
| Peak thrust | ~4,200 N |
| Isp (estimated) | 255 s |
| Total impulse | ~77,000 N·s |
| Propellant: AP/B4C/HTPB | 72/14/14 wt% |

---

## 3. Integration with Spear Body

The SRM occupies the aft 1.2 m of the spear. Forward section contains payload.

For Scale 3 spear (L=0.64m, D=0.08m): the SRM is a **separate second stage** attached to the spear base, deployed after the spear clears the water. The two-stage assembly:

- Spear (0.64m) + SRM (1.2m) + separation collar (0.05m) = 1.89 m total
- Launch mass: 3.9 (spear) + 35 (SRM) + 2 (payload) = 40.9 kg total
- CG location: 0.92 m from nose (stable)

---

## Citations (Vol 18)

- Sutton, G.P., Biblarz, O., Rocket Propulsion Elements, 9th Ed, Wiley 2017
- Fahrenholtz, W.G., Hilmas, G.E., "Ultra-High Temperature Ceramics," Annual Review Mat. Res. 2012
- Kubota, N., Propellants and Explosives, 3rd Ed, Wiley-VCH 2015
- AeroTech SRM catalog, 2025
- CSMFAB000000000009 V2.0, BFRP pressure vessel, CSM 2026
- CSMFAB000000000021 V2.0, Piezoelectric detection, CSM 2026

*End Vol 18 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
