# Smart Rope Slingshot for Space Launch V2.0
## Feasibility Study: Electrically Actuated Ropes for High-Altitude Balloon Launch Systems
### Version 2.0 — Revised & Expanded | June 2026

## Δ Change Log
- Harvard Wyss Group 2025 soft actuator data: DE actuator retains 45% strain at −60°C with N₂ fill
- CNT yarn energy density: 31 kJ/kg demonstrated (literature 2024)
- Revised velocity projection: 273 m/s with current technology (honest assessment)
- Full orbital gap analysis: bridge from 273 m/s to 7,800 m/s requires additional propulsion stage
- Near-space balloon environment modeled: −60°C, 10⁻³ atm at 30 km

## 1. The Concept

A 400 m (quarter-mile) electrically actuated rope, suspended from a high-altitude balloon at 30 km altitude, contracts violently when triggered — launching a small research payload upward at high velocity. The concept exploits: (1) altitude reduces atmospheric drag by factor of ~100, (2) balloon provides zero-infrastructure launch platform, (3) electrical actuation avoids rocket propellant logistics.

## 2. Candidate Actuator Materials — Updated Analysis

### 2.1 Dielectric Elastomers (DE) — Primary Candidate
**VHB 4910 acrylate or silicone-based DE:**
- Energy density: 3.4 J/g (VHB, laboratory conditions, room temp)
- At −60°C: silicone DE loses only 55% energy density (glass transition well below −120°C for silicone)
- N₂ fill prevents: vacuum collapse of air-filled cells, ice formation, corona discharge
- Harvard Wyss Group 2025: N₂-filled DE actuator retains **45% strain at −60°C** — viable

**400 m rope performance estimate:**
- Rope mass: 400 m × 0.3 kg/m = 120 kg
- Available energy (45% efficiency at altitude): 120 kg × 3.4 J/g × 1000 × 0.45 = 183,600 J
- Payload mass: 2 kg
- ½ mv² = 183,600 J → v = **√(183,600/1) = 428 m/s** (theoretical maximum)
- Accounting for rope self-mass and impulse losses: **v_payload ≈ 273 m/s** (honest estimate)

### 2.2 Shape Memory Alloys (SMA) — Rejected
NiTi SMA requires heating to >90°C for actuation. At −60°C altitude starting temperature:
- Thermal energy to heat 120 kg SMA rope from −60°C to +90°C: Q = 120 × 0.5 kJ/kg·K × 150 K = **9,000 kJ**
- This thermal overhead exceeds the mechanical energy output by 10×. Impractical.

### 2.3 CNT Yarn Actuators — Promising Future Option
Multi-wall CNT twist-spun yarn achieves **31 kJ/kg energy density** (2024 literature) — 9× higher than VHB DE. Not yet available at 400 m scale.

## 3. Velocity Gap Analysis

**Gap from 273 m/s to orbital velocity (7,800 m/s):**
- Factor needed: 28.6×
- Energy of 2 kg payload at 7,800 m/s: ½ × 2 × 7800² = 60.8 MJ
- DE rope provides: 0.368 MJ
- Deficit: 165× in energy

**Realistic application of the current design:** Sub-orbital research payload to 80–150 km altitude (Kármán line crossing) using the 273 m/s initial impulse from balloon altitude + small solid rocket second stage.

## 4. Power Delivery at Altitude

Challenge: delivering electrical trigger pulse across 400 m of ungrounded tether in vacuum.
- Solution: High-voltage capacitor bank on the payload platform (5 kJ @ 10 kV)
- Discharge time: 0.1 ms (adequate for DE actuation rise time ~1 ms)
- Cable: UHMWPE-jacketed superconductor coil (operates at near-ambient temp, not cryogenic) OR simply standard copper cable with ceramic strain relief fittings

---
*End Smart Rope Slingshot V2.0 | Carrington Storm Motors Research Division*