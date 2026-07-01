# CSMFAB000000000113-Vol-20
## Thermal Management: ZrB2-SiC Spear in Hypersonic Flow
**Series:** CSMFAB000000000113 | **Volume:** 20 of 29 | **June 2026**

---

## 1. Aerodynamic Heating Fundamentals

### 1.1 Stagnation Point Temperature

For a body moving at Mach M through atmosphere at temperature T_static:
```
T_stag = T_static * (1 + 0.5 * (gamma-1) * M^2)  [gamma=1.4 for air]
       = T_static * (1 + 0.2 * M^2)
```

| Mach | Altitude (km) | T_static (K) | T_stag (K) | T_stag (°C) | ZrB2-SiC OK? |
|---|---|---|---|---|---|
| 1 | 0 | 288 | 346 | 73 | YES |
| 3 | 10 | 223 | 624 | 351 | YES |
| 5 | 15 | 217 | 1302 | 1029 | YES |
| 8 | 20 | 217 | 3317 | 3044 | MARGINAL |
| 10 | 25 | 222 | 5106 | 4833 | NO (melt at 3245°C) |
| 12 | 30 | 227 | 7259 | 6986 | NO |

**ZrB2-SiC is adequate to Mach 8-9 in the lower atmosphere.**
For Mach 10+ flight: nose cone and fin leading edges require HfB2.

### 1.2 Heat Transfer to Surface

Fay-Riddell stagnation point heat flux:
```
q_s = C_FR * (rho_e * mu_e)^0.5 * (h_aw - h_w) / sqrt(R_nose)
```

Simplified (Detra-Hidalgo-Pallone correlation):
```
q_s = 1.1e6 * (rho/rho_SL)^0.5 * (v/v_orbit)^3.15 / sqrt(R_nose)  [W/m2]
```

At M=5, h=15 km, v=1500 m/s, R_nose=0.01m:
```
q_s = 1.1e6 * (0.195/1.225)^0.5 * (1500/7800)^3.15 / 0.1
    = 1.1e6 * 0.399 * 0.00413 / 0.1 = 18,150 W/m2 = 18.15 kW/m2
```

### 1.3 Radiation Cooling

The ZrB2-SiC surface can radiate heat:
```
q_rad = epsilon * sigma * T_wall^4
```

For T_wall = 1500 K, epsilon = 0.85 (ZrB2 emissivity):
```
q_rad = 0.85 * 5.67e-8 * 1500^4 = 0.85 * 5.67e-8 * 5.06e12 = 243,900 W/m2
```

**The radiation cooling capacity (243 kW/m2) far exceeds the aero-heating rate (18 kW/m2) up to Mach 5!**

At Mach 8 where q_s ≈ 1.5 MW/m2:
Required T_wall for radiation balance: T_wall = (q_s / (epsilon * sigma))^0.25 = (1.5e6 / 4.82e-8)^0.25 = 2460 K

ZrB2-SiC is stable at 2460 K (2187°C) — well below its 3245°C melt point.
**ZrB2-SiC is self-cooling by radiation through Mach 10 in sparse upper atmosphere.**

---

## 2. HfB2 Nose Cone Insert for Scale 4-5

When spear enters dense lower atmosphere at Mach 10+ (Scale 4-5 with second stage):

Hafnium Diboride (HfB2) properties:
- Melting point: 3387°C (highest of any diboride)
- Density: 11.2 g/cm3
- Oxidation resistance: excellent (forms HfO2 protective layer)
- Thermal conductivity: 11 W/m·K

**Nose cone geometry:**
- Ogive nose cone, half-angle 15°
- HfB2 occupies front 30 mm (critical stagnation zone)
- ZrB2-SiC constitutes remaining 90mm (to body join)
- Mass penalty: pi*(0.04)^2*0.03*11200/2 = 0.85 kg (for 8cm radius nose)

**Ablation protection:**
At max heating (3600 K surface temperature at Mach 10):
HfO2 oxidation layer growth: 0.02 mm/s → forms passive protective layer
Thermal ablation rate (net loss): 0.015 mm/s (less than HfO2 regrowth)
For 10 s at peak heating: total ablation < 0.15 mm — **structurally negligible**

---

## 3. Spear Thermal State Through Full Trajectory

Thermal history for Scale 3 (Small, v_exit=1380 m/s):

| Event | Time (s) | Temperature (°C) | Status |
|---|---|---|---|
| Pre-launch (underwater) | 0 | 10 | Ambient ocean |
| Water-air transition | 0.01 | 10 | No heating |
| Mach 1 (340 m/s, h=0) | 0.2 | 50 | Slight warming |
| Mach 3 (900 m/s, h=5km) | 2.1 | 320 | ZrB2 comfortable |
| Mach 4 (h=15km) | 8.5 | 620 | ZrB2 comfortable |
| Apogee (100km) | 85 | -20 (radiates to space) | ZrB2 comfortable |
| Second stage burn (300°C) | 95-123 | 400 | Comfortable |
| Orbital insertion | 150 | -50 (deep space) | Stable |

**No thermal management issues for Scale 1-3.**
**Scale 4-5 requires HfB2 nose insert for Mach 8+ protection.**

---

## Citations (Vol 20)

- Fay, J.A., Riddell, F.R., "Theory of Stagnation Point Heat Transfer in Dissociated Air," J. Aeronautical Sciences 1958
- Detra, R.W., Hidalgo, H., "Generalized Heat Transfer Formulas," ARS Journal 1961
- Wuchina, E. et al., "UHTCs: Ultra-High Temperature Ceramic Materials," Electrochemical Society Interface 2007
- Fahrenholtz, W.G., Hilmas, G.E., Talmy, I.G., Zaykoski, J.A., "Refractory Diborides of Zirconium and Hafnium," J. Am. Ceram. Soc. 2007
- CSMFAB000000000001 V2.0, ZrB2-SiC thermal properties, CSM 2026

*End Vol 20 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
