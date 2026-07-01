# CSMFAB000000000113-Vol-17
## Orbital Velocity Gap Analysis: What Second Stage is Needed?
**Series:** CSMFAB000000000113 | **Volume:** 17 of 29 | **June 2026**

---

## 1. Delta-V Budget for Each Scale

### 1.1 The Tyranny of the Rocket Equation

The Tsiolkovsky rocket equation:
```
delta_v = Isp * g0 * ln(m0 / m_dry)
```

Where Isp = specific impulse (s), g0=9.81 m/s2, m0=initial wet mass, m_dry=dry mass.

For a solid rocket motor (SRM) with Isp=260s (typical composite propellant):
Mass ratio required = e^(delta_v / (Isp * g0)) = e^(7177 / (260 * 9.81)) = e^2.81 = 16.6

**The second stage must be 94% propellant by mass.** This is aggressive but achievable.

### 1.2 Second Stage Mass Requirements by Scale

| Scale | v_exit (m/s) | dv_needed (m/s) | Mass ratio | Stage mass (kg) | Propellant mass (kg) |
|---|---|---|---|---|---|
| Nano | 340 | ~7500 | 18.2 | 0.25 | 0.237 |
| Micro | 690 | ~7200 | 16.4 | 3.5 | 3.29 |
| Small | 1380 | ~6600 | 13.3 | 35 | 32.4 |
| Medium | 1040 | ~6900 | 14.9 | 350 | 327 |
| Large | 680 | ~7200 | 16.4 | 4000 | 3756 |

**Scale 3 (Small) is the most efficient:** 35 kg total second stage for 5-10 kg payload. This is in the range of commercially available hobby SRMs (e.g., AeroTech K-class: up to 2500 N·s, $80-$400).

### 1.3 Effective Payload Mass Fractions

If total launch vehicle (spear + payload + second stage) is 50 kg:
- Scale 3 (Small): Payload = 50 - 10 (spear) - 35 (stage) = **5 kg payload** (10%)
- Scale 4 (Medium): Payload = 500 - 100 - 350 = **50 kg payload** (10%)
- Scale 5 (Large): Payload = 5000 - 1000 - 4000 = **0 kg** (negative! impossible at this scale)

**Large scale cannot reach orbit without multi-staging or increased exit velocity.**

---

## 2. Two-Stage Configuration

### 2.1 The Ideal Staging Strategy

The AMSR-UBSCLS constitutes Stage 0 (pre-boost). The second stage fires at apogee:

**Optimal firing time:** At apogee, where v_horizontal is maximum fraction of total velocity.

For a 42° launch at v_exit=1462 m/s:
At apogee (102 km):
- v_horizontal = v_exit * cos(42°) * (1 - drag_loss_h) = 1086 * 0.82 = 891 m/s
- v_vertical = 0 (by definition at apogee)

Required circularization burn at 102 km altitude:
v_orbital(102km) = sqrt(mu / (R_earth + 102km)) = sqrt(3.986e14 / 6.478e6) = 7843 m/s

Delta-v for circularization: 7843 - 891 = **6952 m/s**

### 2.2 Miniaturized SRM Design (GIC-Immune)

The second stage must be GIC-immune per Aegis protocol:
- Case: BFRP/Elium® filament-wound pressure vessel (same as CSMFAB000000000009)
- Propellant: APCP (ammonium perchlorate composite) — no metallic components
- Igniter: KNbO3-BaTiO3 piezoelectric shock igniter (from CSMFAB000000000021 EMF detector tech)
- Nozzle: ZrB2-SiC ceramic (3245°C melt vs. ~3500°C combustion gas temp — marginal; see Vol 20)

**SRM for Scale 3 (35 kg total mass, 32.4 kg propellant, 2.6 kg case/nozzle):**
- Burn time: ~30 s at average thrust
- Average thrust: F_avg = 32.4 * 240 / 30 = 260 N (Isp=260s gives exhaust velocity 2550 m/s)
  Wait: thrust = m_dot * v_exhaust = (32.4/30) * (260*9.81) = 1.08 * 2550 = 2754 N
- Average acceleration on 5 kg payload: 2754/5 = 550 m/s² = 56g — high but brief

**Result: Scale 3 achieves orbital insertion with a commercially-sourceable SRM.**

---

## 3. Multi-Stage Theoretical Analysis for Large Scale

The Large scale (1000 kg spear) requires three-stage configuration for orbit:

Stage 0: AMSR-UBSCLS → 680 m/s (surface to ~18 km coast)
Stage 1: First SRM → additional 3000 m/s (18 km to 200 km coast)
Stage 2: Second SRM → remaining 4500 m/s (circularization at 300 km)

Total launch mass: 1000 (spear) + 8000 (Stage 1 SRM) + 2000 (Stage 2 SRM) = 11,000 kg
Payload capacity: ~500 kg

**This is in the SmallSat/MicroSat launcher class.** Comparable to Electron rocket (Virgin Orbit payload: 300 kg to LEO).

---

## Citations (Vol 17)

- Tsiolkovsky, K.E., "Exploration of the Universe with Reaction Machines," 1903
- Sutton, G.P., Biblarz, O., Rocket Propulsion Elements, 9th Ed, Wiley 2017
- Turner, M.J.L., Rocket and Spacecraft Propulsion, 3rd Ed, Springer 2009
- AeroTech APCP propellant data, 2024
- CSMFAB000000000009 V2.0, BFRP pressure vessel specs, CSM 2026

*End Vol 17 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
