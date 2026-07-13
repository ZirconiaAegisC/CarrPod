# CSMFAB000000000207 — DRONE-X Central Hub and Arm Interface
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Mechanical Engineering Design Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — 60° dovetail interface, center stack layers, wire routing, landing skids |

---

## 1. Central Hub Architecture

The center hub comprises three stacked BFRP plates forming a rigid sandwich structure. The plates are joined via 4× M3 stainless steel standoffs (25 mm), creating a protected avionics bay between the middle and bottom plates.

| Layer | Thickness | Function |
|-------|-----------|----------|
| Top plate | 5.0 mm | Phone clamp mount (4× M3 threaded inserts), GPS antenna recess |
| Middle plate | 4.0 mm | STM32 MCU mount, PDB mount, ESC signal distribution |
| Bottom plate | 4.0 mm | Battery strap slots, arm interface dovetail receivers |

Total hub weight: 80 g (assembled with hardware).

## 2. 60° Dovetail Arm Interface

Each arm connects to the hub via a 60° dovetail joint with a single M4 × 20 mm stainless steel locking bolt. The dovetail geometry provides positive mechanical registration and transfers both bending moments and torsional loads through the joint.

| Dovetail Parameter | Value |
|-------------------|-------|
| Included angle | 60° |
| Dovetail width (base) | 14 mm |
| Dovetail width (tip) | 9 mm |
| Dovetail length | 28 mm |
| Engagement depth | 5 mm |
| Locking bolt | M4 × 20 mm, stainless A2-70 |
| Bolt torque | 2.5 N·m |
| Joint shear capacity | 890 N (per arm, static) |
| Joint bending capacity | 12.5 N·m (per arm, static) |

The 60° angle was selected over 45° (stronger but harder to print accurately) and 75° (easier to print but lower pull-out resistance) as the optimal balance for BFRP FDM printing tolerances.

## 3. Center Stack Assembly Sequence

| Step | Layer | Action |
|------|-------|--------|
| 1 | Bottom plate | Insert arm dovetail receivers |
| 2 | Bottom plate | Route ESC power wires through bottom slots |
| 3 | Bottom plate | Mount PDB with 3× M2.5 nylon standoffs |
| 4 | Middle plate | Mount STM32 MCU board with 4× M2 standoffs |
| 5 | Middle plate | Connect ESC signal wires to MCU header |
| 6 | Middle plate | Route LoRa antenna SMA bulkhead through side port |
| 7 | Middle plate | Place MXene EMI shield over avionics (CSMFAB-214) |
| 8 | Top plate | Mount phone clamp assembly |
| 9 | All | Install 4× M3 × 25 mm standoffs, torque to 1.0 N·m |

## 4. Wire Routing and EMI Management

| Wire Bundle | Gauge | Route |
|-------------|-------|-------|
| Motor phase wires (3 per arm) | 16 AWG silicone | Through arm interior channel, exits at motor mount |
| ESC signal wires | 26 AWG twisted pair | Along arm bottom, enters hub through side slot |
| Battery leads | 14 AWG XT60 | Through bottom plate slot, 50 mm length |
| LoRa antenna coax | RG-178 | SMA bulkhead on side, away from battery leads |
| GPS antenna | U.FL to SMA | Recessed in top plate, 30 mm from MCU |

All signal wires are routed ≥ 15 mm from power wires where parallel runs exceed 20 mm. Signal wires crossing power wires do so at 90° angles only.

## 5. Landing Skid Design

Each of the two landing skids is a single BFRP print (1h 00m each, 18 g filament). The skid profile is an inverted arch with 45 mm ground clearance and a 3 mm elastomeric foot pad (TPU overmold).

| Skid Parameter | Value |
|---------------|-------|
| Ground clearance | 45 mm (sufficient for 6040 prop tip clearance) |
| Skid spread | 180 mm (lateral stability) |
| Foot contact area | 2 × 600 mm² per skid |
| Maximum sink rate absorption | 2.5 m/s (no structural damage) |

---

*"A hub is where forces converge — design every joint as if the entire machine depends on it. Because it does."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Assembly Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
