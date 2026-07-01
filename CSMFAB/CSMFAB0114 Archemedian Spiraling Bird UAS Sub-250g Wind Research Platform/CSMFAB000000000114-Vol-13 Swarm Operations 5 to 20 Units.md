# CSMFAB000000000114 — Vol-13
# Swarm Operations — 5 to 20 Units
## Multi-Unit Launch, Spacing, Collision Avoidance, and LoRa Mesh
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: Why a Swarm?

A single ASB-1 unit produces one time-series of wind measurements at one evolving position. This gives you a vertical wind sounding (altitude vs. wind speed, like a weather balloon), but tells you nothing about the **spatial structure** of the wind field — how wind speed and direction change horizontally across a cliff face or over a water body.

Wind varies dramatically over short distances. A 50m spacing swarm of 10 units launched simultaneously from a cliff provides:
- **10 simultaneous altitude profiles** through the same atmospheric layer
- **3D wind maps** showing horizontal gradients (cliff-edge acceleration, wake turbulence, sea-breeze front)
- **Research quality data** that meteorologists, search-and-rescue planners, and atmospheric scientists cannot get from any fixed instrument network at this cost

The scientific value of the swarm over the single unit scales **super-linearly**: 5 units gives 5× more data points but perhaps 25× more scientific information, because the spatial correlations between units reveal wind structures invisible in a single-point record.

---

## Part 1: Swarm Formation Geometry

### 1.1 Linear Formation (Cliff-Edge Launch)

For a cliff-edge research mission, the most natural formation is a linear array along the cliff edge:

```
CLIFF EDGE (looking from above, wind blowing from left)

Wind →  📡 📡 📡 📡 📡  (5 units, 5m separation)
        ↑  ↑  ↑  ↑  ↑
        Each unit's tether anchored behind on cliff top
        | ←──── 20m total span ────→ |

Wind →  📡 📡 📡 📡 📡 📡 📡 📡 📡 📡  (10 units, 5m separation)
        | ←────────── 45m total span ──────────→ |
```

**Spacing requirement:** Minimum 5m between units horizontally. This ensures:
- No tether entanglement (each 50m tether is anchored at a point 5m from its neighbors)
- No aerodynamic interference (each unit's spiral wake dissipates within 2-3 body widths = <1m)
- Visual distinguishability for observers

### 1.2 Grid Formation (Open Area Research)

For mapping a 2D area (e.g., over a lake or above a beach), launch from multiple points in a grid:

```
10-unit grid: 2 rows × 5 columns
Row A:   📡  📡  📡  📡  📡   (15m spacing)
Row B:   📡  📡  📡  📡  📡   (15m spacing)
         15m cross-track spacing between rows
```

Total coverage: 60m × 15m = 900 m² spatial coverage for the wind map.

---

## Part 2: Multi-Unit Launch Protocol

### Launch Sequence for 10-Unit Cliff Formation

**Equipment needed:**
- 10 ASB-1 units, fully charged, FTS armed, packed
- 10 tether reels, each with 50m Dyneema + EM brake, anchored to anchor stakes at 5m intervals
- 2 Visual Observers (VO)
- 1 RPIC at ground station
- 1 Tether Operator per 5 units (2 minimum for 10-unit swarm)

**Sequence:**
1. Pre-flight checks: all units powered, GPS fix acquired (green LED), FTS armed (SwarmView confirms)
2. Anchor all 10 tether reels at their spaced positions along cliff edge
3. RPIC confirms SwarmView shows all 10 units on map with GPS fix
4. VOs take positions at each end of the formation line with binoculars
5. RPIC calls: "All units ready. Launch on countdown: 5 — 4 — 3 — 2 — 1 — LAUNCH"
6. Launch team throws all units within 5 seconds of the "LAUNCH" call
7. Each throw is a firm wrist-spin release angled 20° upward into the wind
8. VOs immediately begin scanning the airspace for the ascending units and for any conflicting aircraft
9. RPIC monitors SwarmView: all units should appear ascending within 10 seconds
10. If any unit fails to show GPS altitude increasing, call that unit number and deploy FTS before it drifts

---

## Part 3: Collision Avoidance

### 3.1 Passive Separation (Tether-Based)

The tether is the primary collision prevention mechanism. Each unit's tether is anchored at a fixed point on the ground. As long as:
- Ground anchors are 5m apart
- Each tether is 50m long
- Units are in a common updraft (approximately same altitude)

The maximum horizontal distance between any two unit positions = anchor separation (5m) + tether angle difference. In uniform updraft conditions, all units fly nearly vertically above their anchors — separation is maintained by the anchor spacing.

### 3.2 Active Collision Avoidance (Electronic)

The SwarmView ground station software tracks GPS positions of all units. If any two units' GPS positions come within 3m of each other:
1. SwarmView displays a proximity alert and sound alarm
2. RPIC uses Smart Rope commands (Vol-09) to steer the approaching units apart
3. If separation continues to decrease below 2m: automatic FTS trigger on the lower-priority unit (lower node ID takes priority to remain flying; higher node ID deploys FTS)

In practice, tethered swarm operations maintain separation automatically. Electronic collision avoidance is a backup for unusual wind conditions (lee-side turbulence creating lateral tether drift).

---

## Part 4: Communication Mesh for 20 Units

At maximum 20-unit swarm, the LoRa mesh topology:

- Each unit transmits at 1 Hz at a slightly different phase offset (node ID × 50ms phase delay)
- Twenty units × 22ms time-on-air each = 440ms used out of 1000ms window = 44% duty cycle
- At SF7/BW125, packets from 20 units fill the air well within the 1 Hz window
- No packet collision possible because each unit transmits in its own 50ms slot (TDMA-like timing)

Meshtastic inherently handles mesh routing. Units that cannot reach the ground station directly relay through intermediate units.

**Mesh performance at 20 units, 500m spread:**
- Units 1-5: direct ground station link (within 500m)
- Units 6-15: one relay hop (via units 1-5)
- Units 16-20: two relay hops if needed (via 6-15 via 1-5)
- End-to-end latency: < 3 seconds for two-hop path
- Data rate: sufficient for 1 Hz reporting per unit

---

## CHECKPOINT — Vol-13 Complete

Before proceeding, confirm:
- [ ] You understand the linear formation geometry (5m minimum unit spacing, tethers anchored at ground)
- [ ] You know the 10-unit launch sequence (5-second window for all throws; RPIC on ground station)
- [ ] You understand passive collision avoidance (tether anchor spacing maintains separation)
- [ ] You understand the electronic collision avoidance backup (GPS proximity alert + auto FTS)
- [ ] You know the LoRa mesh TDMA scheme (each unit has a 50ms phase offset for collision-free transmission)

**Proceed to:** Vol-14 (Net Recovery System) or Vol-24 (Swarm Coordination Protocol)

---

*CSMFAB000000000114-Vol-13 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
