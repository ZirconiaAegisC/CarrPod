# F2-025 — GAN Power Electronics and BMS Architecture
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Why GaN

Standard Si-IGBT inverters for hub motors are being replaced with GaN HEMT (High-Electron
Mobility Transistor) in all Charlemagne fleet vessels:

| Property | Si IGBT | GaN HEMT | Fleet Advantage |
|---|---|---|---|
| Switching frequency | 10–20 kHz | 100–500 kHz | 5–25× lower switching loss |
| Drain efficiency | 96–97% | 97–99% | 1–2% motor drive efficiency gain |
| Package size | Metal TO-247 | Ceramic QFN | 5–10× smaller, GIC-immune pkg |
| Radiation hardness | ~10 krad | >100 krad | 10× better for SPE events |
| Thermal resistance | Higher | Lower | Better heat dissipation |
| Risk | Latch-up possible | No latch-up | Safer under EMP |

**GaN package requirement:** Ceramic QFN (Quad Flat No-Lead) package ONLY.
Metal TO-247 or TO-263 packages are NOT acceptable — metallic case → potential GIC
coupling through package body to driving circuit.

## 2. Hub Motor Drive Architecture (per motor)

Each of the 6–10 hub motors has a dedicated:
1. **3-phase GaN inverter** (PEEK CF40 housing, MXene inner EMI shield)
   - Switching frequency: 200 kHz (ultra-low audible noise in windings)
   - FOC (Field-Oriented Control): 100 kHz control loop update rate
2. **PMMA POF CAN bus** from CCU to motor controller (no metallic signal path)
3. **Isolated DC power rail** from CMBC via UHMWPE/PEEK cable
4. **GaN synchronous rectifier** for regenerative braking (captures 65–72% kinetic energy)

## 3. BMS Architecture

**Philosophy:** Zero metallic conductor from any BMS circuit element to any cell terminal.

Implementation:
- Cell voltage monitoring chip → ceramic hybrid → internal optical coupler → PMMA POF bus
- Cell temperature: FBG optical fiber sensors (not metallic K-type thermocouples)
- Balancing resistors: ZnO varistor-based (ceramic, no metal wires)
- BMS PCB substrate: BFRP (not standard FR4)
- Cell-to-cell busbars: Aluminum conductor inside PEEK isolation sleeve
  (conductive where needed, completely non-conductive exterior)

**Protection functions:**
- Overvoltage: disconnect relay (PEEK-actuated) at >3.65 V/cell
- Undervoltage: disconnect at <2.45 V/cell (0.05 V margin before chemistry damage)
- Overcurrent: soft limit 2C in firmware; hardware glass fuse in ZrO₂ holder at 5C
- Overtemperature: shutdown at 55°C via FBG monitoring, re-enable at 45°C


---
*End F2-025 | CSMVessel-Charlemagne-FleetV2 | June 2026*
