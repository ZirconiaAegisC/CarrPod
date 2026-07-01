# F2-040 — Acoustic Treatment and Spectral Hygiene Validation
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Three Frequency Bands Requiring Management

| Band | Frequency | Biological Harm | CSM Solution | Target Attenuation |
|---|---|---|---|---|
| Spinal resonance | 4–8 Hz | Intervertebral disc compression, STHT >2× | AAJ active stop-band | >40 dB at seat |
| Vascular damage | 100–300 Hz | Womersley plug flow, arterial stenosis | Piezo harvest (removes energy) | >30 dB at floor |
| Schumann resonance | 7.83 Hz | Not a threat — MISSING field is problem | PEMF injection | 0.5–2.0 µT present |

The 100–300 Hz vascular hazard band was first documented in CSMFAB series (Aegis Embark,
Vol-029). Motor harmonics from electric hub motors fall precisely in this range:
- 6-pole motor at 600–3,000 RPM: fundamental 60–300 Hz
- 3rd harmonic: 180–900 Hz
- Average power in 100–300 Hz band: 65% of total vibration energy in this motor class

## 2. ALON Dome Acoustic Properties

ALON's extraordinary stiffness (E=334 GPa) means it is highly acoustically reflective.
**Critical concern:** The dome must NOT have its own structural resonance within 4–8 Hz.

**Dome natural frequency analysis (BERYL, r=1000 mm, t=8 mm):**

For a spherical shell:
```
f_ring = (1/2π) × sqrt(E×t / (ρ×r²×(1+ν)))
       = (1/2π) × sqrt(334×10⁹×0.008 / (3,690×1.0²×1.14))
       = (1/2π) × sqrt(783,000,000)
       = (1/2π) × 27,982 = 4,454 Hz
```

4,454 Hz is well above the 4–8 Hz danger band ✓

**However**, the dome + isolator system resonance must also be checked:
```
f_dome_system = (1/2π) × sqrt(k_isolators / m_dome)
```
For BERYL Sorbothane A20 isolators: k_total = 7,200 N/m, m_dome = 62 kg:
```
f_dome_system = (1/2π) × sqrt(7,200/62) = 1.72 Hz ✓ (below 4 Hz danger band)
```

TOURMALINE exception: requires A10 Sorbothane to achieve f_dome_system < 4 Hz.
ECO-TOUR-001 documents this deviation.

## 3. Test Protocol

**Method:** Mount complete vehicle on 2-axis electrodynamic shaker table.
Input: Swept sine 0.5–500 Hz at 0.1g amplitude.
Measure: Accelerometer at seat pan, headrest, floor, ALON dome interior.
Pass criteria: Seat-to-chassis transmissibility <−40 dB in 4–8 Hz band.


---
*End F2-040 | CSMVessel-Charlemagne-FleetV2 | June 2026*
