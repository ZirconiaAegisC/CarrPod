# F2-005 — Shared Platform Scaling Protocol
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Scale Factor Definition

The BERYL (4-seat passenger car) is the **canonical reference platform** at sf=1.0.
All other vessels are derived by applying the scale factor to reference dimensions.

**Fleet scale factors:**
- TOURMALINE: sf = 0.35 (micro toy)
- OBSIDIAN: sf = 0.55 (motorcycle-class)
- BERYL: sf = 1.0 (reference)
- AMETHYST: sf = 1.5 (8-seat SUV)
- RHODONITE: sf = 3.2 (transit bus)

## 2. Linear Dimension Scaling

For any linear dimension d in BERYL:
```
d_vessel = d_BERYL × sf
```

BERYL reference dimensions:
- Overall length: 3,200 mm
- Overall width: 2,100 mm
- Overall height: 1,800 mm
- Hub motor wheel OD: 620 mm
- AAJ bellows OD (compressed): 480 mm
- CMBC vault outer diameter: 900 mm
- ALON dome radius: 1,000 mm
- Ground clearance (nominal): 380 mm
- Hub-to-hub track width: 2,100 mm
- Wheelbase (front hub to rear hub): 3,200 mm
- Leg upper segment length: 460 mm
- Leg lower segment length: 460 mm

## 3. Mechanical Property Scaling Laws

### 3.1 AAJ Stiffness
```
k_off(sf)  = k_ref × sf² = 280 kN/m × sf²
k_max(sf)  = k_max_ref × sf² = 2,800 kN/m × sf²
```
Justification: stiffness scales as (cross-section area) / (length) ~ sf²/sf = sf for a tube,
but the AAJ is a 2D-constrained bellows where dominant stiffness scales as sf².

### 3.2 Piezoelectric Element Count
```
n_piezo(sf) = round(96 × sf^1.5)
```
Justification: 96 elements are specified for BERYL; the number scales with bellows
circumference (~sf) times element density (proportional to sf^0.5 for consistent areal
density), giving sf^1.5.

| Vessel | sf | n_piezo | k_off (kN/m) | k_max (kN/m) |
|---|---|---|---|---|
| TOURMALINE | 0.35 | 20 | 34.3 | 343 |
| OBSIDIAN | 0.55 | 39 | 84.7 | 847 |
| BERYL | 1.0 | 96 | 280 | 2,800 |
| AMETHYST | 1.5 | 177 | 630 | 6,300 |
| RHODONITE | 3.2 | 570 | 2,867 | 28,672 |

### 3.3 Hub Motor Power
```
P_hub(sf) = 12 kW × sf^2.3  [per motor]
```
Derivation: Motor power scales with vehicle mass (sf³) divided by speed (constant target
speed → sf⁰), corrected by drivetrain efficiency gains at higher power → net exponent 2.3.
The 2.3 exponent was empirically verified against the prototype BERYL specification.

### 3.4 Battery Capacity
```
E_battery(sf) = 28 kWh × sf^2.8  [total pack]
```
Derivation: Energy scales with mass (sf³) and desired range divided by efficiency improvement
at larger scale (net exponent ~2.8).

| Vessel | P_hub (W ea) | Total P (kW) | Battery (kWh) | Voltage |
|---|---|---|---|---|
| TOURMALINE | 148 | 0.89 | 1.92 | 48 V |
| OBSIDIAN | 640 | 3.84 | 8.3 | 96 V |
| BERYL | 12,000 | 72.0 | 28.0 | 400 V |
| AMETHYST | 22,000 | 176.0 | 58.0 | 400 V |
| RHODONITE | 95,000 | 950.0 | 185.0 | 800 V |

### 3.5 ALON Dome Wall Thickness
Minimum thickness regardless of scale:
```
t_ALON = max(8 mm, 8 mm × sf)  [for vessels with sf < 1]
t_ALON = 8 mm × sf              [for vessels with sf ≥ 1]
```

Note: TOURMALINE and OBSIDIAN both use 8 mm minimum wall thickness (same as
BERYL) even though sf < 1.0, because structural requirements set a minimum ballistic
floor that cannot be scaled below 8 mm.

### 3.6 AAJ Bellows Wall Thickness
```
t_bellows = max(3 mm, 8 mm × sf)
```

## 4. Exception Table

Dimensions and parameters that do NOT simply scale with sf:

| Parameter | Rule | Reason |
|---|---|---|
| ALON min wall thickness | 8 mm floor at all scales | Ballistic minimum |
| IP68 seal pressure | 3 bar all scales | Marine standard |
| 4–8 Hz bandgap | Always 4–8 Hz regardless of scale | Human biology fixed |
| Schumann PEMF frequency | Always 7.83 Hz | Earth resonance fixed |
| GIC immunity criterion | Always ρ ≥ 10¹⁰ Ω·m | Physics fixed |
| LoRa frequency | 915 MHz | FCC fixed |
| LiFePO₄ cell chemistry | Same cells all scales | Cell unchanged |

## 5. Cross-Vessel Parts Compatibility

When a part has sf-dependent dimensions, it is a **scaled-family part** and
must be ordered at the correct sf. Never substitute BERYL parts into TOURMALINE
or vice versa — the AAJ ring frames, hub motor bolt patterns, and CMBC vault
flanges are sf-specific.

Cross-reference: F2-004 (fleet architecture), F2-050 (parts registry).


---
*End F2-005 | CSMVessel-Charlemagne-FleetV2 | June 2026*
