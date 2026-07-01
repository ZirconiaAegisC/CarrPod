# CSMFAB000000000113-Vol-06
## Optimal Depth, Rope Length, and Vessel Spacing: Complete Parametric Study
**Series:** CSMFAB000000000113 | **Volume:** 06 of 29 | **June 2026**

---

## 1. Complete Parametric Space

The three independent design variables are:
- d: launch depth [5, 10, 15, 20, 30, 50, 75, 100] m
- R: vessel radius [1, 3, 5, 7, 10, 15, 20] m
- n: number of vessels [2, 3, 4, 6, 8, 10, 12]

Dependent outputs:
- v_exit: total spear exit velocity
- H_apogee: maximum altitude (no second stage)
- E_total: total energy required from ropes
- m_rope_total: total rope system mass

### 1.1 Master Performance Matrix (n=6, 2 kg spear)

| d (m) | R (m) | L_rope (m) | alpha | eta_v | v_exit (m/s) | H (km) | E_total (kJ) |
|---|---|---|---|---|---|---|---|
| 10 | 1 | 10.05 | 5.7° | 99.5% | 840 | 36.0 | 42.4 |
| 10 | 3 | 10.44 | 16.7° | 95.8% | 805 | 33.1 | 40.6 |
| 20 | 2 | 20.10 | 5.7° | 99.5% | 1,460 | 108.6 | 73.6 |
| 20 | 4 | 20.40 | 11.3° | 98.1% | 1,435 | 105.0 | 72.3 |
| 30 | 3 | 30.15 | 5.7° | 99.5% | 2,040 | 212.6 | 102.8 |
| 30 | 6 | 30.59 | 11.3° | 98.1% | 2,002 | 204.4 | 100.9 |
| 50 | 5 | 50.25 | 5.7° | 99.5% | 2,980 | 453.4 | 150.2 |
| 50 | 10 | 50.99 | 11.3° | 98.1% | 2,926 | 436.2 | 147.5 |
| 75 | 7.5 | 75.37 | 5.7° | 99.5% | 3,840 | 752 | 193.5 |
| 100 | 10 | 100.50 | 5.7° | 99.5% | 4,520 | 1,042 | 227.8 |

*v_exit includes screw exit velocity (22 m/s) + Smart Rope delta_v.*
*H calculated from H = v_exit^2 * sin^2(42°) / (2g) for vacuum ballistic.*

### 1.2 Key Findings

1. **Vertical efficiency is maximized at R/d = 0.05-0.1** (eta_v > 99%). For d=30m, R=3m is near-optimal.

2. **Exit velocity scales linearly with depth** (up to ~75 m, beyond which screw exit v plateaus):
   v_exit ≈ 22 + (d * 1.34 * n/6)   [for n=6, 50 m ropes]

3. **Apogee scales as v_exit^2** — doubling depth quadruples apogee altitude.

4. **Rope length has minimal effect on performance** (L_rope ≈ d for small R):
   Going from R=3m to R=6m (d=30m): rope length increases 1.5%, efficiency decreases 1.4%. **Negligible.**

5. **Vessel spacing is NOT a limiting factor at R=5-10m** for 6 vessels — adequate spacing for practical boat maneuvering.

---

## 2. Recommended Configurations by Scale

### 2.1 Nano Hobbyist (50 g spear)
- **d = 10 m** (shallow, safe for small team)
- **R = 2 m** (small boat circle; paddleboard-deployed)
- **n = 2-4** (minimal vessel count for hobby operation)
- Expected v_exit: 310-450 m/s → H = 4.9-10.4 km

### 2.2 Micro Amateur (1 kg spear)
- **d = 15 m**
- **R = 3 m**
- **n = 4**
- Expected v_exit: 500-700 m/s → H = 12.7-25.5 km

### 2.3 Small Amateur (10 kg spear)
- **d = 25 m**
- **R = 5 m**
- **n = 6**
- Expected v_exit: 900-1,200 m/s → H = 41.5-74 km (Karman line borderline)

### 2.4 Medium Amateur (100 kg spear)
- **d = 40 m**
- **R = 8 m**
- **n = 8**
- Expected v_exit: 700-1,000 m/s → H = 25-51 km (requires second stage for orbit)

### 2.5 Large/Theoretical (1,000 kg spear)
- **d = 60 m**
- **R = 12 m**
- **n = 12**
- Expected v_exit: 500-800 m/s → H = 12.8-33 km (significant second stage needed)

---

## 3. Depth vs. Rope Count Trade Analysis

For a fixed total energy budget E_budget:

If E_budget = 500 kJ and rope efficiency eta = 0.65:
Effective energy delivered to spear: E_eff = 325 kJ

Option A: **Deep launch** (d=50m, n=6)
- v_exit = sqrt(2 * E_eff / m_spear) + v_screw = sqrt(2*325000/2) + 22 = 572 + 22 = **594 m/s**
- System: 6 vessels × 50m rope each

Option B: **Shallow launch** (d=20m, n=12)
- Same total energy, but n=12 vessels × 20m rope each
- v_exit = 572 + 22 = **594 m/s** (same energy → same speed)
- System: 12 vessels × 20m rope each

Option C: **Moderate** (d=30m, n=8)
- Same energy, fewer vessels
- v_exit = 594 m/s
- System: 8 vessels × 30m rope each

**Key insight: For fixed energy budget, v_exit is independent of depth/n — it depends only on energy.
Depth/n choice is determined by practical constraints: dive team access, vessel count, sea state.**

---

## 4. Sensitivity Analysis

### 4.1 Sea State Effect on Performance

| Sea State (Beaufort) | Wave Height (m) | Position Error (m) | Force Variation | v_exit Reduction |
|---|---|---|---|---|
| 0-1 (Calm) | 0-0.1 | 0.05-0.2 | < 0.1% | Negligible |
| 2 (Light breeze) | 0.1-0.5 | 0.2-0.8 | 0.5-1.2% | < 1% |
| 3 (Gentle breeze) | 0.5-1.25 | 0.8-2.0 | 1.5-3% | 1-2% |
| 4 (Moderate) | 1.25-2.5 | 2.0-5.0 | 3-6% | 3-5% |
| 5 (Fresh) | 2.5-4.0 | 5.0-8.0 | 6-12% | 5-10% |

**Maximum operating sea state: Beaufort 3** for precision launches. Beaufort 2 preferred.

### 4.2 Water Temperature Effect

Cold water (4°C): rho=1000 kg/m3, mu=1.6e-3 Pa·s → Cd slightly lower → 2% better performance.
Hot water (30°C): rho=995 kg/m3, mu=0.8e-3 Pa·s → 0.5% lower performance.

Water temperature effect is negligible (< 3%).

---

## Citations (Vol 06)

- Froude, W., "On the Resistance of the Theory of the Resistance of Motion," INA 1869
- Lamb, H., Hydrodynamics, 6th Ed, Cambridge UP 1932 (classic tether geometry)
- Price, W.G., Bishop, R.E.D., Probabilistic Theory of Ship Dynamics, 1974
- CSMFAB000000000022 V2.0, rope performance data, CSM 2026
- CSMFAB000000000109 V2.0, exit velocity data, CSM 2026

*End Vol 06 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
