# CSMFAB000000000114 — Vol-09
# Smart Rope Smart Muscle Actuation System
## SMA Wire Flight Control — Why Smart Rope Wins Over Fluid for V1.0
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

*References: CSMFAB000000000022 V2.0 (Smart Rope Actuator) | CSMFAB000000000113-Vol-09 (Smart Muscle Spear Design) | CSMFAB0017 (Dielectric Rope Fabrication)*

---

## Introduction: The Actuation Decision

The ASB-1 needs a way to tilt its spin axis — to steer. Think of it like tilting a gyroscope: a small tilt creates a controlled precession that turns the device. In a bird, this tilting is accomplished by the bird's muscles pulling on bones and tendons. In the ASB-1, we replicate this function using **Shape Memory Alloy (SMA) wire actuators** — the Smart Rope system developed in the Carrington Storm Motors lineage.

### Why Not Internal Fluid Actuation?

The user asked for an evaluation of Smart Rope vs. fluid. Here is the definitive analysis:

**Internal Fluid Actuation would require:**
- A fluid reservoir: 5-15g minimum
- A miniature pump: 8-15g (smallest available, e.g., DMFP-100 micro pump)
- Pressure tubing: 3-5g for internal routing
- Seals and fittings: 2-3g for pressure-rated connections
- Control valve: 3-5g (miniature servo-actuated)
- **Total fluid system: 21-43g**

With only 72g of mass margin and 21-43g consumed by the fluid system, there would be insufficient margin for sensor upgrades, parachute, or any build tolerance. Beyond mass:

- Fluid systems leak in cold, wet coastal environments
- A miniature high-pressure pump requires CNC-machined seals — not 3D-printable at Cypress
- Fluid pump motor is an electrical inductance source — violates the Stellar-Aegis Protocol
- Temperature variation changes fluid viscosity, affecting actuation force

**Smart Rope/Smart Muscle uses:**
- 4× Nitinol SMA wire (100mm each, 0.1mm diameter): 0.04g total (negligible)
- 4× SMA wire housing tubes (3D-printed BFRP): 1.5g each × 4 = 6g
- SMA driver PCB (MOSFET array): 2g
- Signal wiring: 0.5g
- **Total Smart Rope system: ~8.5g vs. 21-43g for fluid**

**Verdict: Smart Rope wins by 12-35g in mass, is fabricable at Cypress with soldering tools only, and has no fluid failure modes.**

---

## Part 1: Shape Memory Alloy (SMA) Science

### 1.1 What Is Nitinol?

Nitinol (Nickel-Titanium alloy, from NIckel, TItanium, and Naval Ordnance Laboratory where it was discovered) is a metallic alloy with an extraordinary property: it "remembers" a shape. When you cool it down and deform it, it stays deformed. When you heat it back up, it returns to its original memorized shape with significant force. This temperature-triggered shape change is called the **shape memory effect**.

In wire form, nitinol contracts in length (typically 3-5%) when heated above its transformation temperature (typically 45-90°C depending on alloy composition). For the ASB-1, we use **45°C Nitinol** — it activates at a mild temperature achievable by resistive heating with a small current pulse.

### 1.2 SMA Wire Properties (0.1mm Nitinol)

| Property | Value |
|---|---|
| Wire diameter | 0.1 mm (100 µm) |
| Activation temperature | 45-55°C |
| Deactivation temperature | 25-35°C (returns to cool shape) |
| Contraction on activation | 3-4% of length |
| Pull force at 0.1mm dia | ~1.5-2.0 N (150-200 g-force) |
| Operating current | 50-80 mA for resistive heating |
| Resistance | ~85 Ω/m (8.5 Ω for 100mm length) |
| Power to activate | I² × R = (0.070)² × 8.5 = 0.042 W = 42 mW |
| Activation time | 0.1-0.5 seconds |
| Deactivation time | 0.3-1.0 seconds (passive cooling) |
| Number of cycles | 1,000,000+ cycles (proper use) |
| Cost | ~$2-4 per meter (Dynalloy Flexinol or equivalent) |

For 100mm wire: contraction upon activation = 3.5% × 100mm = **3.5mm of linear motion**.

This 3.5mm linear contraction, applied at the 60mm blade-root position of the spiral arm, produces:
```
Tilt angle = arctan(3.5mm / 60mm) = arctan(0.0583) = 3.3°
```

A 3.3° spin-axis tilt per actuator activation. With 4 actuators at 90° spacing, the tilt direction can be controlled in any azimuthal direction by activating 1, 2, or 3 actuators simultaneously at different power levels.

### 1.3 Non-Inductive Compliance (Stellar-Aegis Protocol)

The Smart Rope system achieves Stellar-Aegis Protocol compliance through the dielectric fiber braiding technique from CSMFAB0017 (Dielectric Rope Fabrication). Each SMA wire is:
1. Braided with UHMWPE (Ultra-High Molecular Weight Polyethylene, Dyneema) fiber at 30° braid angle
2. The UHMWPE braid has resistivity > 10¹⁴ Ω·m — completely non-inductive
3. The resulting Smart Rope has a metallic core (the nitinol wire, conducting current) surrounded by a non-inductive dielectric sheath
4. The dielectric sheath prevents GIC (Geomagnetically Induced Currents) from coupling through the actuator into the device structure
5. The active conductor runs from the driver PCB to the wire and back — it does NOT form a loop through the device body

---

## Part 2: Actuator Housing (3D-08 / 3D-06)

The SMA actuator housing (3D-06) is a 3D-printed BFRP tube:
- Outer diameter: 8mm
- Inner bore: 3mm (SMA wire channel)
- Length: 35mm
- Features: Crimp end cap at each end, wire exit slots, mounting boss (press-fit into spiral arm slot)
- Material: BFRP (Basalt Fiber Reinforced Polymer) — non-magnetic, non-inductive

**Four housings are mounted at 90° spacing** on the inner face of the spiral arm, at 60mm from the center hub. When the SMA wire in a housing contracts, it pulls the spiral arm tip slightly inward — tilting the spin axis in that arm's direction.

---

## Part 3: SMA Driver Circuit

The SMA driver is a tiny custom PCB (or can be built on a 20mm × 30mm perfboard):

**Components:**
- 4× N-channel MOSFET (IRLML2244 or AO3400, SOT-23 package, 4A continuous, 0.028Ω Rds)
- 4× 10 kΩ gate resistors
- 4× flyback diodes (BAT54 Schottky, minimal mass)
- Microcontroller header (connects to FC PWM out or I²C)
- 4-pin JST connector (connects to SMA wires via Smart Rope harness)

**Operation:**
1. FC generates PWM signal (0-100% duty cycle) to select MOSFET gate
2. MOSFET switches current through the SMA wire in pulses
3. Average current = duty cycle × 80mA = proportional heating = proportional contraction
4. Independent control of 4 wires = full 2D axis control of spin axis tilt

**Total PCB mass: 2g** on perfboard; 1g if custom PCB fabricated.

---

## Part 4: Control Modes

| Mode | Actuator State | Effect |
|---|---|---|
| Neutral / passive | All wires at 0% duty cycle | Wires cool, device in passive gyro-stabilized flight |
| North tilt | Wire #1 at 100% duty cycle | Spin axis tilts toward North arm; precession begins |
| South tilt | Wire #3 at 100% duty cycle | Spin axis tilts toward South arm |
| East tilt | Wire #2 at 100% duty cycle | Spin axis tilts East |
| West tilt | Wire #4 at 100% duty cycle | Spin axis tilts West |
| Combined heading | 2 adjacent wires at 50-100% | Diagonal tilt for any heading |
| Full coarse pitch (emergency) | All wires at 100% pull | Maximum pitch angle = maximum drag (speed govern) |

---

## Part 5: Fabrication at Cypress University

### Materials Needed
- [ ] Nitinol wire 0.1mm diameter (Dynalloy Flexinol HT 100um) — 500mm minimum, ~$5
- [ ] UHMWPE (Dyneema SK-75) fiber, 0.1mm strand for braiding — $5-10 for enough to braid 4× housings
- [ ] BFRP filament for 3D printing housing tubes (Markforged or CW02 BFRP) — available via university 3D print store
- [ ] N-channel MOSFET (AO3400, SOT-23) × 4 — $1 total, Digikey or Mouser
- [ ] Perfboard 30mm × 20mm — $1
- [ ] JST PH 2.0 4-pin connectors × 3 — $2
- [ ] 30AWG silicone wire (for SMA leads, flexible) — $5 for small reel

### Assembly Steps (Summary — Full detail in Vol-21)
1. 3D print 4× actuator housings from BFRP/PETG
2. Cut 4× 110mm pieces of 0.1mm nitinol wire (10mm extra for crimping)
3. Crimp SMA wire into both end caps of housing — use crimp sleeves (2mm copper crimp, hobby supplier)
4. Test activation: apply 9V battery through 100Ω resistor to SMA wire terminals — wire should contract ~3.5mm visibly
5. Braid UHMWPE fiber over housing exterior (braiding jig in university lab)
6. Solder MOSFET driver PCB per schematic (provided with this series)
7. Connect SMA wire leads to MOSFET driver via JST harness
8. Install 4 housings in spiral body arm slots — press fit + one drop of CA adhesive

---

## CHECKPOINT — Vol-09 Complete

Before proceeding, confirm:
- [ ] You know why Smart Rope beats fluid for V1.0 (mass, simplicity, Stellar-Aegis compliance)
- [ ] You understand how SMA wire activates (electrical heating → shape change)
- [ ] You know the contraction produced: 3.5mm per 100mm wire activated = 3.3° tilt
- [ ] You understand the UHMWPE braiding provides non-inductive compliance (CSMFAB0017 protocol)
- [ ] You know the driver PCB design (4× MOSFET, ~2g)
- [ ] You have identified all materials needed from the fabrication list

**Proceed to:** Vol-10 (Dielectric Tether Safety System)

---

*CSMFAB000000000114-Vol-09 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
