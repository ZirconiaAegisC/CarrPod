# F2-041 — Amphibious Phase-C Transition Protocol
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Three-Phase Roadmap

Per CSMVessel0000000009 §8, the Charlemagne progresses through three phases:

**Phase A — Terrestrial hexapedal validation:**
Validate torque vectoring, AAJ vibration isolation, LiDAR terrain preview + pre-adapt.
Success criteria: "Skyhook" damping effect — occupant experiences near-zero pitch/roll
across highly uneven terrain. Measured: occupant seat acceleration < 0.1g at 6 Hz.

**Phase B — ALON integration + spectral hygiene:**  
Mount ALON shell on validated Phase A chassis.
Validate acoustic properties inside sealed dome.
Confirm: 4–8 Hz bandgap maintained, acoustic resonances not amplified by dome.
Activate 7.83 Hz Schumann PEMF emitters.
Validate: FBG biometric response confirms HRV improvement with PEMF active.

**Phase C — Amphibious transition:**
Hermetically seal all hub motors per F2-022.
Replace all steel bearings with Si₃N₄ (if Phase A ran with interim steel bearings).
Validate AAJ expansion and buoyancy management.

## 2. Phase C Technical Sequence

When vehicle enters water:
1. FBG moisture sensor detects water at chassis level → activates amphibious protocol
2. KNbO₃–BaTiO₃ actuators expand AAJ bellows toward maximum volume (0.8 s)
3. Pontoon pods deploy (Elium® BFRP foam-filled pods, stored retracted under belly pan)
4. Torque vectoring transitions to "paddlewheel mode"
   - Port wheels: forward thrust mode
   - Starboard wheels: forward thrust mode
   - Yaw control: port vs. starboard RPM differential
5. Speed capped to 8 km/h (BERYL Froude-limited water speed)
6. Life support pre-check: O₂ reserve, hatch seal confirmed

## 3. Buoyancy Calculation (BERYL Reference)

**Required displcement at float (BERYL + 4 adults):**
```
Mass = 780 kg (vehicle) + 4×80 kg (occupants) = 1,100 kg
Required displacement = 1,100 / 1,025 = 1.073 m³
```

**Hull volume (BERYL approximate):**
Hull: 3.2 × 2.1 × 0.8 m (partial hull below waterline) ≈ 1.25 m³
Less: CMBC vault displacement ≈ 0.33 m³
**Net neutral hull displacement:** ~0.92 m³ → insufficient by ~0.15 m³

**AAJ expansion contribution (2 joints, BERYL):**
Each AAJ joint expanded: π/4 × (0.68² − 0.48²) × 0.45 = 0.103 m³
Two joints: 0.206 m³ total
Plus pontoon pods: 3 × 0.025 m³ = 0.075 m³

**Total displacement:** 0.92 + 0.206 + 0.075 = **1.201 m³**
**Buoyancy margin:** (1.201 − 1.073) / 1.073 = **+11.9%** (freeboard reserve 120 mm) ✓


---
*End F2-041 | CSMVessel-Charlemagne-FleetV2 | June 2026*
