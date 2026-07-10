# CSMFAB000000000115 V1.0
## FEATHER-02: Solar Power & Energy Storage Subsystem
### Version 1.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications
**Classification:** Power Systems Design Document

---

## 1. Design Requirements

The FEATHER node must operate continuously through: California summer irradiance peaks (1,100 W/m²), Central Valley tule fog (8–14 consecutive days below 50 W/m²), Sierra snowpack (panel buried 30 days/year), CME-induced grid collapse (indefinite autonomous operation), and wildfire smoke attenuation (60% irradiance reduction at AQI 300+).

## 2. Solar Panel Subsystem

| Parameter | Value |
|-----------|-------|
| Technology | Monocrystalline silicon, half-cut PERC |
| Rated power (STC) | 100W |
| Vmpp | 18.6V |
| Impp | 5.38A |
| Cell efficiency | 22.5% |
| Dimensions | 670 × 540 × 25 mm |
| Weight | 4.2 kg |
| Glass | 3.2 mm tempered, ARC-coated |
| Frame | Anodized aluminum 6063-T5 |

**Mounting:** BFRP brackets with PTFE anti-galvanic isolation washers. Fixed tilt 35° (California latitude-optimized). Adjustable to 55° for Sierra winter snow shedding. Remote panel deployment up to 30 m from enclosure via armored PV cable.

**Tule Fog Energy Budget:** 100 Ah / 1,280 Wh battery provides 50 days autonomy against 24 Wh/day load. Even worst-case 14-day fog cycle never drops battery below 80% SOC.

## 3. Battery Subsystem

| Parameter | Value |
|-----------|-------|
| Chemistry | LiFePO₄ (LFP) |
| Nominal voltage | 12.8V (4S configuration) |
| Capacity | 100 Ah (1,280 Wh) |
| Cycle life | 3,500 cycles to 80% capacity |
| Calendar life | 12 years (at 25°C average) |
| Operating temperature | -20°C to +60°C charge, -30°C to +70°C discharge |
| Self-discharge | ≤ 3% per month |
| BMS | Integrated 4S, 100A continuous, cell balancing ±25 mV |

**Why LiFePO₄:** 3,500 cycles vs 300 cycles SLA. Thermal runaway threshold > 270°C vs 180°C for NMC. Zero cobalt — no supply chain ethics concerns. Passive cooling sufficient. FAA 49 CFR 173.185 compliant.

**Cold-Weather Charging:** LiFePO₄ cannot charge below 0°C. Self-heating battery circuit: 2 × 10W Kapton heating pads + DS18B20 temp sensor. Activate at -3°C, deactivate at +3°C. 30-minute pre-heat uses 10 Wh. Negligible vs 1,280 Wh battery.

## 4. MPPT Charge Controller

| Parameter | Value |
|-----------|-------|
| Topology | Synchronous buck converter, GaN FET (GS61008P) |
| Input voltage range | 5–28V |
| Output voltage | 14.6V (LFP charge) |
| Max charge current | 10A |
| Efficiency | 96.5% at Vmpp = 18.6V, Iout = 5A |
| Standby power | 1.2 mW |
| Switching frequency | 500 kHz (enables 80% smaller inductor) |

**GaN vs Si:** Zero Qrr → zero switching loss. 3.2% efficiency gain vs Si FET at partial load (critical for fog-belt operation).

## 5. Power Budget

| Component | Active (W) | Sleep (μW) | Duty Cycle |
|-----------|-----------|------------|------------|
| ESP32-S3 MCU | 0.35 | 80 | Continuous |
| SX1262 LoRa (RX) | 0.024 | 1.2 | 98% RX |
| SX1262 LoRa (TX) | 0.50 | — | 1% TX burst |
| MPPT controller | 0.0012 | 0.0012 | Continuous |
| BMS | 0.0005 | 0.0005 | Continuous |
| Battery heater | 20.0 | 0 | < 0.1% (only below -3°C) |

**Total average power:** 1.01 W → **24.2 Wh/day**
**Battery autonomy:** 1,280 Wh / 24.2 Wh = **52.8 days without any solar**

## 6. CAL FIRE Wildfire Compliance

- LiFePO₄ chemistry → no thermal runaway
- Aegis-C ceramic enclosure → UL 94 V-0, melting point 1,600°C+
- BMS overcurrent: 100A fuse within 10 cm of battery terminal
- All internal wiring: silicone-jacketed, 200°C rated, MIL-W-16878/4
- Auto disconnect if internal temp > 70°C

---

*The Sun powers it. The Shield protects it. The Battery ensures it never sleeps.*
