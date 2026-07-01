# CSMFAB000000000114 — Vol-10
# Dielectric Tether Safety System
## The Keep-Close Mechanism: 50m Dyneema Reel, Swivel, and Electromagnetic Brake
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: The Most Important Safety Device on the ASB-1

Before every other safety system — before the speed governor, before the parachute, before the LoRa ground command — the tether is the device that prevents a runaway ASB-1 from becoming a hazard. It is a length of incredibly strong, nearly weightless rope connecting the device to the ground. When properly designed and operated, it:

1. Prevents the ASB-1 from drifting more than tether-length away from the operator
2. Allows the operator to physically recover the device by reeling in the line
3. Acts as a passive speed limiter (tension increases drag at high speeds)
4. Keeps the device within visual range (VLOS compliance for non-waivered flights)
5. Provides a mechanical ground-truth confirming the device is still connected

This is the system that answers the question you asked: **"How do we keep it close by?"**

---

## Part 1: Tether Material — UHMWPE (Dyneema)

### Why Dyneema?

| Property | Dyneema SK-75 | Steel Cable | Nylon | What It Means |
|---|---|---|---|---|
| Breaking strength (0.5mm) | 48 kg | 12 kg | 8 kg | 4× stronger |
| Density | 0.97 g/cm³ | 7.8 g/cm³ | 1.14 g/cm³ | Floats on water |
| Mass (0.5mm × 50m) | 0.95g | 7.7g | 2.2g | Nearly weightless |
| Stretch | < 1% | ~0.5% | 20-30% | Non-elastic (critical for precise control) |
| Conductivity | ~10¹⁴ Ω·m | Conductive | Insulating | Fully dielectric — Stellar-Aegis compliant |
| UV resistance | Excellent | Good | Poor | Outdoor durable |
| Temperature range | -150°C to +80°C | Wide | -40 to +90°C | Works in all UAV weather |

Dyneema SK-75 (Dyneema is DSM's brand name; UHMWPE is the generic name) is the same material used in cut-resistant gloves, bulletproof composites, and marine tow lines. In 0.5mm diameter monofilament or 7-strand braid, it is nearly invisible to the naked eye and weighs less than 20mg per meter.

**Tether mass calculation:**
- 0.5mm UHMWPE braid: 0.019 g/m
- 50m tether reel: 50 × 0.019 = **0.95g total mass on reel** (negligible)
- 3m device leader (attached to device): 3 × 0.019 = **0.057g addition to device mass**

These masses are trivially small. Even a 500m tether reel weighs only 9.5g.

---

## Part 2: Tether System Architecture

The tether system has 3 main components:

### Component 1: Device-Side Leader (on the ASB-1)
- **3m of 0.5mm Dyneema** attached to the tail swivel point (3D-11)
- **Breakaway coupling at 150g tension** — a small polymer-coated crimp loop that fails at 150g pull force, releasing the device rather than pulling it violently if the tether suddenly becomes taut from an unexpected angle
- The breakaway is calibrated above the device's normal tether-following tension in flight (<80g) but below the tension at which the tether could damage the swivel mount or drag the device dangerously
- After breakaway, the device continues flying under FTS/parachute command

### Component 2: Swivel Connector (3D-11 + Hardware)
- Ball-bearing swivel connector — allows ASB-1 to rotate freely around the tether axis without twisting the tether
- 360° free rotation: the spiral body can complete thousands of revolutions without wrapping the tether
- Material: Type 316 stainless steel swivel (non-ferromagnetic grade — still conductive; isolated from body by PEEK sleeve per Stellar-Aegis Protocol)
- Rated breaking strength: 5 kg
- Attachment: M3 threaded stud screwing into heat insert in the tail fin assembly

### Component 3: Ground Unit — Electromagnetic Reel Brake
The ground reel allows controlled deployment and retrieval of the tether. It consists of:

- **Reel body:** 100mm diameter ABS spool, 80mm wide, mounted on a tripod or hand-held
- **Dyneema tether:** 50m (standard) or up to 500m (extended research reel)
- **Electromagnetic brake:** A 12V electromagnetic coil apply friction to the spool spindle. When the operator energizes the coil (via foot pedal or hand button), the spool brakes smoothly and controllably
- **Variable brake force:** 0-15N by adjusting current to the coil via a PWM controller (the same type used for DIY BLDC speed controllers — < $5)
- **Line guide:** A PTFE-lined fairlead keeps the line from wrapping over itself during retrieval

**Operating the reel:**
- During initial launch: reel free-spins, allowing the ASB-1 to pull line as it climbs
- At desired altitude: operator gradually applies brake — increasing tether tension slows the climb rate
- For altitude maintenance: gentle brake pressure holds altitude
- For retrieval: manual reel-in while releasing brake pressure to avoid snapping the line
- Emergency retrieval: full brake stops line pay-out; operator manually retrieves

---

## Part 3: Tether Geometry and Flight Behavior

### 3.1 Catenary Angle

A tethered aerodynamic body in wind does not fly straight up — the tether angles with the wind. The equilibrium angle θ of the tether from vertical is:

```
tan(θ) = Horizontal_drag_force / (Lift - Weight)
```

For ASB-1 in 15 m/s wind at 8.7 N lift, 1.74 N weight, and horizontal drag ~0.5N (tether drag + device drag):
```
tan(θ) = 0.5 / (8.7 - 1.74) = 0.5 / 6.96 = 0.072
θ = arctan(0.072) = 4.1° from vertical
```

The ASB-1 tether will be nearly vertical in moderate conditions. In extreme 25 m/s winds with high horizontal drag:
```
tan(θ) = 3.0 / (large_lift - weight) ≈ 0.4
θ = 22° from vertical
```

Even at 22° tether angle, a 50m tether gives an altitude of:
```
h = 50 × cos(22°) = 50 × 0.927 = 46.4m = 152 ft AGL
```

152 ft is well within standard Part 107 limits and a good altitude for wind research. For the §107.51 waiver targeting 1,200 ft, extended tethers (400m) are used — see tether extension notes in Part 4.

### 3.2 Tether Drag Contribution

The tether itself causes drag in the wind, which adds to the load on the ASB-1. For a 50m tether:
```
F_tether_drag = ½ × ρ × d_tether × L_tether × CD_cylinder × V²
F_tether_drag = ½ × 1.225 × 0.0005 × 50 × 1.2 × 225
F_tether_drag = 0.041 N
```

0.041 N of additional drag force from the tether — negligible at 8.7 N lift. Even 500m of tether adds <0.4 N — still manageable with the ASB-1's lift capacity.

---

## Part 4: Extended Tether Operations (Altitudes >152 ft)

For research operations above 152 ft AGL (50m tether maximum altitude), the following extended tether options are available:

| Option | Tether Length | Max AGL (15 m/s wind) | Max AGL (25 m/s wind) | Added Mass (reel only) |
|---|---|---|---|---|
| Standard | 50m | 46m / 152 ft | 37m / 121 ft | 1g tether |
| Extended | 100m | 93m / 305 ft | 75m / 246 ft | 2g tether |
| Research | 200m | 185m / 607 ft | 149m / 489 ft | 4g tether |
| Extended research | 400m | 371m / 1,217 ft | 298m / 977 ft | 8g tether |

For altitudes above 400 ft AGL, the §107.51(b) waiver (Vol-02) must be in effect. All tether lengths use 0.5mm Dyneema, which weighs 0.019 g/m.

> ⚠️ **IMPORTANT:** For extended research tether operations (above 200 ft), a spotter or Visual Observer is required, and the NOTAM must be filed. See Vol-02 and Vol-20.

---

## Part 5: Breakaway Coupling and Emergency Release

The breakaway coupling is the last resort before the FTS parachute. It is designed to release the device cleanly if the following occurs:

1. Tether snags on terrain feature (rock, tree, etc.)
2. Unexpected lateral gust creates sudden high-tension event
3. Device departs beyond expected range

**Breakaway coupling specification:**
- Material: 30 lb monofilament fishing line loop (Stren Clear, 0.38mm diameter) — biodegradable and non-conductive
- Breaking strength: 30 lb = 13.6 kg — but the loop is doubled, so effective: 7 kg
- Wait — we want 150g (1.47 N) release force. Use a smaller loop:
- **Actual coupling:** Single monofilament loop of 0-lbs clear fishing line (0.11mm diameter), breaking strength ~200g = 1.96 N
- This allows tether to normally hold 80-100g tension during flight without triggering breakaway
- Upon 200g+ tension event: loop breaks — device is released, continues under parachute/FTS

Replacement cost per coupling: approximately $0.02 (a $5 spool of fishing line provides hundreds of loops). Replace breakaway coupling before every flight.

---

## CHECKPOINT — Vol-10 Complete

Before proceeding, confirm:
- [ ] You understand why Dyneema was chosen (strong + nearly weightless + fully dielectric)
- [ ] You know the full tether system: device leader (3m Dyneema) + swivel (3D-11) + ground reel (electromagnetic brake)
- [ ] You understand the catenary angle calculation and maximum altitude for given tether length
- [ ] You know the breakaway coupling specification (200g tensile loop — monofilament)
- [ ] You understand the extended tether table (50m to 400m options vs. altitude capability)
- [ ] You know the ground reel electromagnetic brake uses a standard PWM coil controller

**Proceed to:** Vol-11 (Flight Termination System) or Vol-13 (Swarm Operations)

---

*CSMFAB000000000114-Vol-10 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
