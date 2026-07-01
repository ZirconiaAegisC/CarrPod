# F2-008 — Active Articulation Joint AAJ Platform Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Design Origin and Biomimetic Basis

The Active Articulation Joint (AAJ) is directly inspired by **Hypsibius dujardini** (water bear /
tardigrade). The tardigrade possesses a segmented body plan with a rigid outer cuticle and
an independently articulating musculature at each body segment junction. This allows
the organism to:
- Maintain continuous ground contact across irregular micro-terrain
- Isolate each body segment from mechanical shock at adjacent segments  
- Enter a "tun" cryptobiotic state by retracting all limbs and sealing the body

The AAJ replicates this macroscopically:
- The polymer accordion bellows = the flexible segmented cuticle
- The KNbO₃ piezo lattice = the musculature providing active stiffness modulation
- The tun state = Carrington Protocol → AAJ contracts, all legs retract, ALON dome seals

## 2. AAJ Physical Configuration

The BERYL-reference (sf=1.0) AAJ consists of:

**Bellows body:**
- Material: PEEK/polyimide co-extrusion compound (ρ > 10¹⁵ Ω·m)
- Dimensions (compressed): 480 mm OD × 350 mm length
- Dimensions (expanded max): 680 mm OD × 500 mm length
- Accordion pleats: 12 (BERYL); scaled to: round(12 × sf) for other vessels
- Wall thickness: 8 mm minimum (see F2-005 scaling exception rule)
- Hydrostatic test rating: 5 bar / 60 s (saltwater)

**KNbO₃–BaTiO₃ lattice (96 elements, BERYL):**
- Element: bimorph disc, 50 mm diameter × 6 mm total (2 × 3 mm layers)
- Elements per row: 12 (circumferential)
- Rows: 8 (axial along bellows length)
- Blocking force per element: F_b = d₃₃ × E × V = 285×10⁻¹² × 70×10⁹ × 150 V = 3.0 N
- Total blocking force (96 elements): 288 N (off-axis applied during stiffening)
- Energy harvest per element at 150 Hz: ~2.0 mJ/cycle
- Total harvest at 150 Hz (100–300 Hz motor harmonic band, BERYL): ~96 × 2.0 × 150 = 28,800 mW ≈ **29 W**

**Reinforcement rings:**
- Material: ZrB₂–SiC thin-wall cast rings (4 mm × 6 mm cross-section)
- Count: 12 rings (same as pleat count)
- Function: Prevent catastrophic bellows buckling during ±45° torsion + 50 kN axial load

## 3. Spectral Hygiene Function (4–8 Hz Spinal Stopband)

The **4–8 Hz spinal resonance danger band** is the primary biological threat of a rigid
vehicle chassis. In this band, seat-to-head transmissibility (STHT) exceeds 2× input
acceleration, compressing intervertebral discs.

**AAJ mechanical model:**
The bellows + KNbO₃ lattice system is a variable-stiffness mass-spring:
```
f_natural = (1/2π) × sqrt(k_AAJ / m_supported)
```
Where m_supported = CMBC mass + upper hull mass ≈ 250 kg (BERYL).

At k_off = 280 kN/m:
```
f_n = (1/2π) × sqrt(280,000 / 250) = (1/2π) × sqrt(1,120) = (1/2π) × 33.5 = 5.33 Hz
```
This places the natural frequency INSIDE the 4–8 Hz danger band — unacceptable!

**Solution — Active KNbO₃ stiffness modulation:**
By modulating the KNbO₃ piezo elements, the effective stiffness is continuously shifted:
- When 4–8 Hz content detected in chassis: instantly STIFFEN to k_active = 2,800 kN/m
- New f_n = (1/2π) × sqrt(2,800,000/250) = 16.8 Hz (above danger band)
- Or SOFTEN below 2 Hz: k_soft = 28 kN/m → f_n = 1.68 Hz (below danger band)

**The AAJ creates a dynamic "frequency dodge"** — the natural frequency is never permitted
to reside in 4–8 Hz by active real-time adjustment.

**100–300 Hz vascular shear band:** These motor harmonic frequencies are harvested
(not just filtered), converting them to electrical energy while removing them from the
cabin mechanical spectrum. See F2-013 for piezo harvest circuit design.

## 4. Amphibious Expansion Mode

When TOURMALINE through RHODONITE enter water, the AAJ bellows expand radially:
- Compressed OD: 480 mm (BERYL); Expanded OD: 680 mm
- Volume added by expansion: π/4 × (0.680² − 0.480²) × 0.45 m = 0.103 m³ (BERYL)
- Added buoyancy: 0.103 m³ × 1,025 kg/m³ × 9.81 m/s² = **1,036 N** per AAJ joint
- BERYL has 2 AAJ joints: +2,072 N additional buoyancy

Expansion actuation: KNbO₃ linear actuators + compressed N₂ pneumatic assist
Expansion time: 0.8 seconds (full compressed → full expanded)
The AAJ expansion directly counteracts the effect of the high-CG centralized battery core
during the land-to-water transition, as described in CSMVessel0000000009 §8.3.

## 5. Scaling Rules (see F2-005 for derivations)

```
k_off(sf)  = 280 kN/m × sf² 
k_max(sf)  = 2,800 kN/m × sf²
n_piezo(sf) = round(96 × sf^1.5)
t_wall(sf) = max(3 mm, 8 mm × sf)
Pleat count = round(12 × sf)
```

**Assembly drawing reference:** See F2-043 (Flash Sintering Protocol for ZrB₂–SiC rings)
and F2-042 (bellows extrusion / VARTM reinforcement rings).

## 6. Fleet-Wide AAJ Performance Summary

| Vessel | k_off | k_max | f_n range | Harvest (W est.) |
|---|---|---|---|---|
| TOURMALINE | 34 kN/m | 343 kN/m | 4–12 Hz (active) | ~2 W |
| OBSIDIAN | 85 kN/m | 847 kN/m | 4–14 Hz (active) | ~6 W |
| BERYL | 280 kN/m | 2,800 kN/m | 4–17 Hz (active) | ~29 W |
| AMETHYST | 630 kN/m | 6,300 kN/m | 4–20 Hz (active) | ~58 W |
| RHODONITE | 2,867 kN/m | 28,672 kN/m | 4–29 Hz (active) | ~350 W |

Cross-reference: F2-013 (KNbO₃ lattice), F2-021 (Schumann PEMF), F2-040 (spectral hygiene).


---
*End F2-008 | CSMVessel-Charlemagne-FleetV2 | June 2026*
