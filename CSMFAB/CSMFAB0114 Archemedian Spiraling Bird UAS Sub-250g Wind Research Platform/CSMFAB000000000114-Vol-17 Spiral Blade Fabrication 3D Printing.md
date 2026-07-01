# CSMFAB000000000114 — Vol-17
# Spiral Blade Fabrication — 3D Printing
## Print Settings, Geometry, and Post-Processing
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: 3D Printing the Flying Helix

The ASB-1 spiral body is the most geometrically complex part of the entire device. A 3-turn helix with variable pitch twist along the blade span, a central hub, and internal cavities for electronics and actuator housings — this is exactly the kind of geometry that 3D printing excels at. No traditional subtractive machining process (milling, turning, routing) can produce this shape economically. The 3D printer at Cypress University is the key enabling technology.

This volume walks through every step of printing a successful spiral body, from file preparation to first test spin.

---

## Part 1: Print Material Selection

### Primary Recommendation: PETG (Available Everywhere)

For the Cypress University makerspace (typically equipped with Prusa MK3 or similar FDM printers), **PETG** is the best available non-exotic material:

| Property | PLA | **PETG** | ABS | BFRP (Markforged) |
|---|---|---|---|---|
| Tensile strength | 50 MPa | **52 MPa** | 40 MPa | 540 MPa |
| Layer adhesion | Good | **Excellent** | Variable | Excellent |
| Warping tendency | Low | **Low (better than ABS)** | High | None |
| Post-process sanding | Easy | **Easy** | Moderate | Difficult |
| Printer requirements | Standard | **Standard** | Heated chamber ideal | Markforged only |
| Cost | $18/kg | **$20/kg** | $22/kg | $175/spool |
| Dielectric/non-conductive | Yes | **Yes** | Yes | Yes |

**Use PETG for all structural prints at Cypress University.** BFRP is the production target (V1.1 upgrade) — PETG gets the V1.0 prototype in the air.

---

## Part 2: Printer Settings for Spiral Body

For Prusa MK3S+ or equivalent with 0.4mm nozzle:

| Setting | Value | Rationale |
|---|---|---|
| Layer height | 0.15mm | Fine resolution for blade surface smoothness |
| Perimeter shells | 4 (outer wall) | Provides 1.6mm wall thickness (exceeds 1.2mm minimum) |
| Infill | 20% gyroid | Strong and isotropic; gyroid resists torsion |
| Print speed | 40mm/s | Slower for dimensional accuracy on curves |
| Bed temp | 90°C | PETG adhesion |
| Nozzle temp | 235-240°C | PETG optimal |
| Fan cooling | 30% (not full) | Allow some residual heat for layer fusion — PETG needs this |
| Supports | Tree supports (Prusa Slicer) | Removes easily from helix interior |
| Support interface | 0.3mm gap, 2 layers | Allows clean removal without scarring blade surface |
| Orientation | Vertical (helix axis = Z axis) | Optimal layer orientation for torsion loads |

### Critical Print Orientation Note

Print the spiral body with the **rotation axis (Z axis) vertical**. This means the helix turns as the Z axis increases — layers are horizontal rings. This orientation puts the print seam on the inner hub (not on the blade surface) and gives optimal layer-to-layer strength for the torsional and bending loads in the blade.

**DO NOT print sideways** — a horizontal print orientation would put the primary load axis across the layer lines, creating a weak delamination failure mode.

---

## Part 3: File Preparation (from 3D-01 and 3D-03 Prompt Files)

1. Generate the 3D model using the prompts in CSMFAB000000000114-3D-01 and 3D-03
2. Export as STL or 3MF from the generator (Meshy, Tripo3D, or Blender)
3. Import into PrusaSlicer or Bambu Studio
4. Scale verification: confirm body diameter is exactly 150mm, height 200mm
5. Apply the print settings above
6. Generate supports
7. Review layer preview: confirm blade walls show 4 perimeter lines at all cross-sections
8. Slice and export G-code

**Estimated print time:** 4-6 hours for the full spiral body at 0.15mm layers
**Filament used:** approximately 35-45g of PETG

---

## Part 4: Post-Processing

After the print is complete and supports are removed:

1. **Deburr support contact points:** Use a fine needle file or 220-grit sandpaper on the inner blade surfaces where supports contacted. Goal: smooth surface, no raised nubs that would cause aerodynamic turbulence.

2. **Surface sanding:** Wet-sand the outer blade surface with 400-grit, then 800-grit waterproof sandpaper. Work along the blade span (not across). This removes layer lines and creates a smoother aerodynamic surface. Estimated Cp improvement: +5-8% vs. unsanded print.

3. **Acetone vapor treatment (optional for very smooth finish):** If Cypress has an acetone safety cabinet, a 30-second acetone vapor exposure melts the outer 0.2mm of PETG, creating a near-glass-smooth surface. Dramatically reduces aerodynamic drag.

4. **Weight check:** After post-processing, weigh on the 0.1g scale. Target: 55-65g. If over 65g, check for dense infill or review print settings.

5. **Visual inspection:** Hold body up to light and look for any cracked layer lines, delaminations, or bubbles. None allowed in blade span areas. Minor defects on inner hub acceptable.

6. **Primer coat (optional):** One light coat of plastic model primer (Rustoleum 2X) fills remaining surface imperfections and provides a good base for paint if desired.

---

## Part 5: Test Spin Before Electronics Installation

Before installing any electronics:

1. Mount the spiral body on a 6mm diameter steel shaft (from the university metal shop — metal shaft is just for testing, not in the final device)
2. Hold shaft in a drill press chuck or lathe spindle
3. Spin up slowly to 500 RPM → 1,000 RPM → 1,500 RPM (use tachometer)
4. Listen for: resonance (buzzing/humming) which indicates a gap in layer bonding → reject print
5. Look for: any visible vibration or wobble indicating mass imbalance
6. If wobble: add modeling clay to the light side until balanced, then note the position for permanent epoxy ballast correction
7. **Success criterion:** Smooth spin to 1,500 RPM with no resonance, no visible wobble, and no cracking

---

## CHECKPOINT — Vol-17 Complete

Before proceeding, confirm:
- [ ] You understand why PETG is used for V1.0 (available at Cypress; adequate strength margin)
- [ ] You know the critical print settings: 0.15mm layers, 4 perimeters, 20% gyroid infill, vertical orientation
- [ ] You understand the post-processing sequence: deburr → sand 400/800 grit → weight check
- [ ] You know the test spin protocol: 1,500 RPM, no resonance, no wobble
- [ ] You know target print mass: 55-65g

**Proceed to:** Vol-18 (Electronics Bay) or Vol-21 (Assembly Manual, full build sequence)

---

*CSMFAB000000000114-Vol-17 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
