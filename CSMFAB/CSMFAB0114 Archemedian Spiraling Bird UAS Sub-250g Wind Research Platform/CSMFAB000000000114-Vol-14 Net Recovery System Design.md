# CSMFAB000000000114 — Vol-14
# Net Recovery System Design
## Catching High-Velocity Spiraling Devices Safely
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: Solving the Landing Problem

The ASB-1 descends from research altitude via parachute (FTS, ~7.76 m/s terminal velocity) or by tether retrieval. In either case, the device is **still spinning** as it descends — the spiral body continues autorotating at some fraction of its flight speed as it falls through calmer air near the ground.

A 177g device spinning at 500-1,000 RPM descending at 7 m/s has the aerodynamics of a small spinning top moving at roughly cycling speed. Catching it bare-handed is dangerous (rotating edges, impact force). Allowing it to hit the ground uncontrolled risks electronics damage.

The solution is a **net recovery system**: a lightweight, portable, tensioned net that safely decelerates the device and the spiral body when they contact the net material without laceration or structural damage.

---

## Part 1: Net Physics

### Impact Force Calculation

When the ASB-1 descends at 7.76 m/s into a net, the deceleration depends on how much the net deforms:

```
F_impact = m × V² / (2 × d_net_deflection)
```

If the net deflects 30cm during arrest:
```
F_impact = 0.177 × (7.76)² / (2 × 0.30) = 0.177 × 60.2 / 0.60 = 17.8 N
```

17.8 N = 1.8 kg-force applied to the net. For a 1.2m × 1.2m net the threads carry this across the full capture area — each 10cm mesh square carries approximately 17.8N / (144 squares) = 0.12 N. Even 1mm Dyneema mesh squares would have a breaking strength of ~50 N each — massively overbuilt. The net is structurally very easy.

### Spinning Blade Hazard

The spiral body edges are smooth curved BFRP surfaces — no exposed sharp edges per the Category 1 FAA requirement. However, rotating at 500 RPM, the tip is moving at:
```
V_tip = ω × R = (500/60 × 2π) × 0.075 = 52.4 × 0.075 = 3.93 m/s
```

At this tip speed, contact with bare skin could cause a brush burn but not laceration (no sharp edge). Contact with a polypropylene or UHMWPE net mesh causes rapid deceleration of the spin without any cutting — the net material is flexible and wraps the spiral edges rather than being cut by them.

---

## Part 2: Net Design

### Net Specifications

| Parameter | Value |
|---|---|
| Net shape | Octagonal (provides even tension in all directions) |
| Net diameter | 1.2m (provides center capture zone of ~0.9m) |
| Mesh material | 15mm polypropylene knotless mesh, 1mm strand thickness |
| Mesh size | 15mm × 15mm squares |
| Frame | 8 × 400mm aluminum tube arms (6061-T6 3/8" OD), joining at center hub |
| Frame mass | 8 × 30g = 240g (not part of drone mass budget) |
| Corner anchors | 8 × ground stakes, 15cm aluminum (anchor system) |
| Net mass | 0.180 m² area × 35 g/m² polypropylene = ~63g + frame |
| Total recovery system | ~600g (entirely ground equipment) |

### Net Geometry — Funnel Shape

The net is tensioned in a **concave funnel shape** (like a satellite dish) rather than flat. This means the center of the net is lowest, and the edges curve upward. Benefits:
- Device descending into the wide capture area naturally slides toward the center
- The center depression absorbs vertical momentum (deeper deflection = lower impact force)
- The funnel shape passively de-spins the device (rotational drag against concave surface)

**How to achieve the funnel shape:**
1. Attach the 8 aluminum tube arms at 45° spacing to a central hub ring (30mm ID, 3D printed)
2. Arms angle downward at 15° from horizontal
3. Net attached to arm tips at 1.2m span
4. Natural tension creates concave bowl shape

---

## Part 3: Frame Design (3D-12)

The catch net frame (3D-12) consists of:

- **Central hub:** 30mm ID × 50mm long 3D-printed BFRP ring with 8 × 45° arm sockets
- **Arms:** 8 × 400mm sections of 3/8" (9.5mm OD) aluminum tube (art supply or hardware store)
- **Ground stake sockets:** 8 × 3D-printed spike mounts at arm tips (press the stake into the ground, slide socket over stake)
- **Ground stakes:** 8 × 15cm × 5mm OD aluminum rod stakes (tent peg style)

**Assembly time:** Under 3 minutes (hub → arms snap in → net unfolds → stakes in corners)
**Disassembly:** Reverse of above (arms pull out of hub, net rolls up, stakes pull from ground)
**Total transport volume:** Rolls compactly into a 1.2m × 100mm cylinder bag

---

## Part 4: Recovery Zone Layout

For single-unit VLOS flight along a cliff:

```
CLIFF EDGE
═══════════════════════════════════════════════════
  SAFETY ZONE (no spectators)
        ↑ 5m minimum
[  NET RECOVERY ZONE  ]  ← 1.5m × 1.5m flat area
        ↑  10m minimum from cliff edge
  SPECTATOR VIEWING  ← roped off at 10m from net

  RPIC POSITION (behind spectators, 15m from net)
```

For swarm operations, one net per 5 units, or use a larger 2.4m × 2.4m net for 10-unit recovery.

> ⚠️ **SAFETY:** All personnel outside the net zone during descent. The net operator stands behind the net, protected by the net itself, ready to apply tension if the descent angle is off-center. Never stand downwind of the net with a tethered unit descending.

---

## CHECKPOINT — Vol-14 Complete

Before proceeding, confirm:
- [ ] You know the impact force: 17.8 N at 7.76 m/s with 30cm net deflection — easily handled by polypropylene mesh
- [ ] You understand the funnel-shaped net (concave bowl, passively de-spins device, directs to center)
- [ ] You know the frame design: 8-arm octagonal hub with aluminum tubes and ground stakes
- [ ] You understand the safety zone layout (5m minimum clear zone; spectators at 10m+)
- [ ] You know assembly time: < 3 minutes

**Proceed to:** Vol-15 (Material Selection) or Vol-20 (Launch Protocol)

---

*CSMFAB000000000114-Vol-14 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
