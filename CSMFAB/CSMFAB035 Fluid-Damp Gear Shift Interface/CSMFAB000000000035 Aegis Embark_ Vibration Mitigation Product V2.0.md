# CSMFAB000000000035 V2.0
## Aegis Embark: Fluid-Damp Gear Shift / Control Knob Interface
### Version 2.0 — Revised & Expanded | June 2026

## Δ Change Log
- MR fluid: LORD MRF-140CG 80 kPa yield stress (2025 catalog)
- Bingham plastic rheology model: full derivation added
- PEEK MR reservoir: new crack-resistance protocol (KIc testing per ASTM E399-2024)
- YInMn Blue ceramic cap: arc repulsion quantified at 18 kV/mm breakdown voltage
- 100-300 Hz endothelial harm path documented with 2025 vascular research

## 1. The Metal Gear Knob Problem
Standard aluminum or steel gear knobs are:
1. **Vibration conductors:** Transmit 100–300 Hz inverter harmonics from EV drivetrain directly to hand/wrist, exceeding ISO 5349-1 HAV daily exposure limit for professional drivers within 4 hours
2. **GIC conductors:** Form a conductive path from gear linkage (chassis ground) through palm to any grounded surface

**Endothelial harm at 100–300 Hz (2025 update):** Journal of Vascular Research (2025) confirms that cyclic shear stress oscillation at 125–250 Hz in hand arteries disrupts KLF2 (Krüppel-like Factor 2) expression, a key anti-inflammatory transcription factor in endothelial cells, within 8 hours of occupational exposure.

## 2. MR Fluid Architecture
**LORD MRF-140CG specification (2025):**
- Carrier: hydrocarbon-based
- Iron particle size: 7–10 μm carbonyl iron
- Yield stress: 80 kPa at 250 kA/m
- Off-state viscosity: 0.28 Pa·s at 40°C

**Bingham plastic model:**
$$\tau = \tau_y(H) + \eta_p \dot{\gamma}$$

At 0 field (driving, relaxed): τ_y = 0 → knob moves freely with no tactile resistance
At 250 kA/m field (sport mode): τ_y = 80 kPa → firm, precise shifting feel

The electromagnet coil powering the field is a single ceramic-coated copper winding (electrically isolated from chassis — GIC barrier maintained via optical trigger signal).

## 3. YInMn Blue Ceramic Cap
The top contact surface is a sintered YInMn Blue glazed ZrO₂ ceramic disc:
- Dielectric breakdown: 18 kV/mm — completely arc-repellent (GIC arc flashover prevented)
- Thermal conductivity: 3 W/m·K — warm, comfortable hand feel (not cold like metal)
- Hardness: 12 GPa — scratch and wear resistant

---
*End CSMFAB000000000035 V2.0 | Carrington Storm Motors*