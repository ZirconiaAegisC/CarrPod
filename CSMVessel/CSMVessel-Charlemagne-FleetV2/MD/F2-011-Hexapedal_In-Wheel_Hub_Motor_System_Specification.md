# F2-011 — Hexapedal In-Wheel Hub Motor System Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Six-Motor Architecture Philosophy

The Charlemagne Class completely abandons the centralized motor + differential drivetrain
that has defined automotive architecture since 1886. Instead, each wheel is driven by an
**independent, sealed, in-wheel hub motor** — providing:

- **Independent torque vectoring:** Each wheel receives a precisely calculated torque
  command, allowing zero-radius turns, lateral crab-walk, and full anti-lock control
- **Redundancy:** The vehicle can operate at full capability with 5 of 6 motors (BERYL),
  or at degraded capability with as few as 4 of 6
- **Amphibious paddle-wheel:** Each motor becomes a marine propulsion element by
  rotating at controlled RPM, no separate propeller required
- **No mechanical differentials:** Differentials use steel gears, hypoid oil, and
  conductive shafts — all GIC-susceptible. Hub motors eliminate all of this.

## 2. Hub Motor Specifications (BERYL Reference, sf=1.0)

| Parameter | Value |
|---|---|
| Motor type | Permanent magnet BLDC, in-wheel hub |
| Continuous power (per motor) | 12 kW |
| Peak power (30 s) | 30 kW per motor |
| Continuous torque | 280 N·m |
| Peak torque (10 s) | 700 N·m |
| Nominal RPM at rated speed | 580 RPM (160 km/h, 620 mm OD wheel) |
| Stator material | Silicon carbide fiber/epoxy composite housing |
| Winding wire | Alumina-ceramic coated copper magnet wire |
| Rotor material | BFRP laminate + SmCo permanent magnets |
| SmCo magnet holder | ZrO₂ ceramic cup (no steel back-iron) |
| Bearing type | Si₃N₄ rolling elements, ZrO₂ races (PN-HUB-SF-B) |
| Efficiency at rated load | 97% |
| Mass (complete hub assembly) | 48 kg (BERYL reference) |
| IP rating | IP68 + (3 bar/30 min in 3.5% NaCl per F2-022) |

## 3. Ceramic Bearing System

**Why ceramic bearings are mandatory:**

A conventional steel bearing in saltwater:
- Creates a galvanic cell: Fe (anode) + seawater (electrolyte) + housing (cathode)
- Corrosion rate: uncoated steel in seawater 0.1–0.3 mm/year
- EDM damage: GIC current flows through bearing → electrical discharge machining pitting
  → catastrophic bearing failure within hours of GIC event

Si₃N₄ ceramic bearings:
- ρ > 10¹² Ω·m → no galvanic pair, no EDM current path
- Zero corrosion in any pH/salinity combination
- Operating without lubricant up to 60% rated load (run-dry capability)
- 3× lower thermal expansion than steel → reduced thermal cycling fatigue

**Bearing installation protocol (see F2-045):**
1. Motor at 80°C → housing bore expanded +0.003 mm
2. Si₃N₄ bearing at −40°C → bearing OD contracted −0.005 mm
3. Net fit: 0.015 mm interference → full installation without force using PEEK mandrel
4. Post-installation Megger test: >10¹² Ω shaft-to-housing (mandatory pass criterion)

## 4. Motor Sealing for Saltwater Submersion

**Three-layer seal system:**
1. **Primary:** ZrO₂ ceramic face seal (lapped to 0.5 µm flatness)
   - Gap: 15 µm face-to-face
   - Rated: 3 bar continuous, 5 bar peak
2. **Secondary:** Viton V-ring backup seal (PN-CC-013)
   - Activates only if primary seal fails
3. **Power cable seal:** PEEK compression gland, IP68 rated
4. **POF data cable seal:** ZrO₂ ferrule connector (PN-CC-002)

**All cable penetrations exit the motor housing through PEEK-housed, IP68-rated fittings.
No metallic cable armor, no metallic connector shells, no grounded shield.**

## 5. Torque Vectoring Control (brief; full detail in F2-023)

Each of the 6 (or 8/10) hub motors receives its torque command from the MIMO MPC
(Multi-Input Multi-Output Model Predictive Controller) running at 10 kHz on the Central
Control Unit (F2-023).

Special modes:
- **Zero-radius turn:** Port motors forward, starboard motors reverse, all at equal |torque|
- **Crab walk:** All motors angled, torque vectored for lateral translation
- **Amphibious paddle:** All motors at controlled RPM for hydrodynamic thrust
  - Port vs. starboard RPM differential → yaw control (no rudder needed)
  - BERYL paddle-mode: max thrust 3,200 N → max water speed 8 km/h (Froude limited)

## 6. Scaled Hub Motor Parameters

| Vessel | P_hub (W ea) | Peak P (W) | Torque (N·m) | RPM max | Wheel OD |
|---|---|---|---|---|---|
| TOURMALINE | 148 | 370 | 8 | 1,320 | 180 mm |
| OBSIDIAN | 640 | 1,600 | 35 | 820 | 330 mm |
| BERYL | 12,000 | 30,000 | 280 | 580 | 620 mm |
| AMETHYST | 22,000 | 55,000 | 510 | 430 | 930 mm |
| RHODONITE | 95,000 | 238,000 | 2,200 | 200 | 1,984 mm |

Cross-reference: F2-022 (sealing), F2-016 (Si₃N₄ bearings), F2-023 (torque vectoring).


---
*End F2-011 | CSMVessel-Charlemagne-FleetV2 | June 2026*
