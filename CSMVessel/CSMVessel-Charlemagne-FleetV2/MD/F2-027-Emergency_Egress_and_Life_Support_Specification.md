# F2-027 — Emergency Egress and Life Support Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Occupant Life Safety Protocol

All Charlemagne fleet vessels carry an integrated emergency life support system.
This is necessitated by the amphibious capability: the vehicle may be submerged with
occupants inside during the water-entry/exit sequence or in flooding conditions.

## 2. O₂ Life Support by Vessel

| Vessel | O₂ supply | CO₂ scrubber | Duration | Occupants |
|---|---|---|---|---|
| TOURMALINE | 0.4 kg O₂ | LiOH 0.15 kg | 30 min | 2 children |
| OBSIDIAN | 0.9 kg O₂ | LiOH 0.3 kg | 60 min | 2 adults |
| BERYL | 1.5 kg O₂ | LiOH 0.5 kg | 90 min | 4 adults |
| AMETHYST | 3.0 kg O₂ | LiOH 1.0 kg | 90 min | 8 adults |
| RHODONITE | 8.0 kg O₂ | LiOH 2.8 kg | 45 min | 30 adults |

O₂ cylinder: BFRP/Elium® composite, 300 bar working pressure (same material as CMBC reinforcement)
LiOH scrubber: cartridge format, pull-and-use, zero electronics required
Activation: automatic when ALON hatch sealed + FBG moisture sensor detects immersion

## 3. Egress Protocol

**Primary egress (normal):**
- ALON hatch: KNbO₃–BaTiO₃ linear actuator, 1.5 N·m opening torque
- Manual backup: PEEK CF40 interior handle, 15 N
- Open time: <3 s from closed to 90% open

**Underwater egress:**
1. Life support activates automatically on submersion detection
2. Occupant breathes from O₂ system while equalizing dome pressure to ambient
3. At pressure equalization (depth-dependent wait time), hatch can be opened safely
4. External rescue: Iron Carrington Red (#C0392B) PEEK pull-ring on dome exterior
   → opens hatch from outside, no tools, <5 s

**EPIRB automatic activation:**
PN-CC-019 (ceramic 406 MHz COSPAS-SARSAT) activates when:
- Vessel immersed >1 m AND not responding to LoRa ping for >60 s
- Transmits GPS/TDOA position to SAR services
- Battery: 48-hour transmission at 125 mW

## 4. Fire Egress

ALON dome is non-flammable (ceramic). BFRP hull: self-extinguishing with Elium® FR formulation.
Main fire risk: external wildfire or directed energy event.
YInMn Blue coating (SRI=130) reduces radiant heat loading by ~70% vs dark surface.
ZrB₂–SiC battery vault: contains any internal fire completely.
Occupant maximum dome temperature in 10-minute external 1,200°C fire exposure: ~85°C.
This maintains survivable temperature but triggers automatic egress protocol.


---
*End F2-027 | CSMVessel-Charlemagne-FleetV2 | June 2026*
