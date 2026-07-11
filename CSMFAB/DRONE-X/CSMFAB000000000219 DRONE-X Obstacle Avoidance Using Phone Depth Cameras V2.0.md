# CSMFAB000000000219 — DRONE-X Obstacle Avoidance Using Phone Depth Cameras
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Navigation & Safety Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — 4-tier depth perception, potential field avoidance algorithm, avoidance envelope specification |

---

## 1. Depth Perception Architecture

Obstacle avoidance relies on the 4-tier depth estimation system (CSMFAB-216) to build a real-time occupancy map:

| Depth Tier | Sensor | Horizontal FOV | Range | Resolution | Availability |
|------------|--------|---------------|-------|------------|-------------|
| Tier 1 | LiDAR (iPhone Pro) | 60° | 0.2–5.0 m | 256×192 depth map | ~20% of phones |
| Tier 2 | Stereo cameras | 70° | 0.3–10.0 m | 320×240 disparity | ~40% of phones |
| Tier 3 | Monocular MiDaS | 60° | 0.5–20.0 m | 256×256 relative depth | ~90% of phones |
| Tier 4 | Bounding box heuristic | 70° | 2.0–50.0 m | Sparse (per detected object) | All phones |

## 2. Occupancy Grid Map

The world is represented as a 2.5D occupancy grid centered on the drone:

| Grid Parameter | Value |
|---------------|-------|
| Map dimensions | 40 m × 40 m |
| Cell resolution | 0.5 m |
| Grid size | 80 × 80 cells |
| Update rate | 15 Hz (from CV pipeline depth output) |
| Decay rate | 0.95 per second (Bayesian update) |
| Observation model | P(occupied | detection) = 0.7, P(occupied | no detection) = 0.4 |
| Integration | Ray-casting from drone position along depth pixel rays |

The front-facing camera covers a 70° × 55° frustum. The drone performs periodic ±30° yaw sweeps at 0.5 Hz during autonomous flight to update lateral/rear cells.

## 3. Potential Field Avoidance Algorithm

Each occupied cell generates a repulsive potential field. The net avoidance vector is the sum of all repulsive vectors, weighted by occupancy probability and inverse distance squared:

```
F_avoid = Σ [K_rep × P(occupied) × (1/d²) × unit_vector(drone→cell)]
```

| Parameter | Value |
|-----------|-------|
| Repulsive gain (K_rep) | 2.5 |
| Minimum avoidance distance | 1.0 m (hard stop if closer) |
| Warning distance | 5.0 m (HUD alert, reduce speed) |
| Look-ahead distance | 15.0 m (pre-compute avoidance path) |
| Avoidance vector blending | 70% avoidance + 30% mission waypoint (weighted average) |
| Avoidance max speed reduction | 50% of cruise speed when obstacles within 5 m |
| Vertical avoidance | Active above 2 m altitude only (allow ground proximity) |

## 4. Avoidance Behavior by Flight Mode

| Flight Mode | Avoidance Behavior |
|-------------|-------------------|
| Manual (Angle) | HUD visual alert + haptic feedback on phone. No automatic intervention — pilot authority preserved. |
| Position Hold | Drone shifts up to 2 m laterally to maintain safe distance from detected obstacles. |
| Waypoint Mission | Path is dynamically adjusted up to 5 m from planned route. If clearance < 1 m at any point, mission pauses and hovers. |
| RTL | Standard RTL altitude (30 m) normally clears ground obstacles. If obstacle detected at RTL altitude, climb additional 10 m. |
| Follow-Me | Subject tracking maintained while avoiding obstacles between drone and subject. |
| Auto-Land | Landing site evaluated for obstacle clearance before descent. Abort and hover if obstruction detected within 2 m of landing zone. |

## 5. Avoidance Envelope

| Direction | Coverage | Sensor |
|-----------|----------|--------|
| Forward | 70° horizontal, 0.5–20 m range | Phone rear camera + depth tier |
| Forward (LiDAR) | 60° horizontal, 0.2–5 m range | iPhone LiDAR + ARKit depth API |
| Left/Right | ±30° from yaw sweeps, updated every 2 s | Camera during yaw sweep |
| Rear | During RTL only, via 180° yaw | Camera (brief rearward scan at RTL initiation) |
| Above/Below | Altitude clearance model | Barometer + known RTL altitudes |

**Known limitation:** No dedicated upward or downward obstacle sensor. Operations beneath overhanging structures require pilot vigilance. This is documented in the Field Manual (CSMFAB-229) as an operational constraint.

## 6. Performance Validation

| Test Scenario | Detection Rate | False Positive Rate | Latency (detection to avoidance) |
|---------------|---------------|---------------------|----------------------------------|
| Person at 5 m (LiDAR) | 98% | 2% | 150 ms |
| Tree trunk at 8 m (stereo) | 92% | 5% | 200 ms |
| Building wall at 15 m (MiDaS) | 85% | 8% | 350 ms |
| Vehicle at 25 m (bbox) | 78% | 12% | 120 ms |
| Thin wire/powerline (any tier) | 35% | N/A | N/A — **known hazard, pilot must avoid** |

---

*"Obstacles don't announce themselves. The difference between avoidance and collision is one frame of computation."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon CV model update
- Distribution: Engineering Team, ML/CV Team, Flight Safety
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
