# CSMFAB000000000221 — DRONE-X Multi-Phone Swarm Coordination Protocol
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Swarm Systems Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — swarm state machine, inter-drone collision avoidance, leader election, mission types |

---

## 1. Swarm State Machine

Each drone in the swarm operates one of the following states:

```
INIT → SYNC → ARMED → [LEADER | FOLLOWER] → MISSION → RTL → LANDED
  ↑                                                    ↓
  └─────────────────────── ABORT ←─────────────────────┘
```

| State | Description |
|-------|-------------|
| INIT | Boot, calibrate sensors, join LoRa mesh |
| SYNC | Receive swarm configuration from ground station, synchronize clocks |
| ARMED | Motors armed, waiting for takeoff command |
| LEADER | Active formation leader — broadcast position, generate formation waypoints |
| FOLLOWER | Track leader position, maintain formation offset |
| MISSION | Executing synchronized mission (waypoints, search pattern, etc.) |
| RTL | Return to launch, maintain formation during transit |
| LANDED | Disarmed, swarm mission complete |
| ABORT | Emergency abort — all drones land immediately, ignore formation |

## 2. Leader Election Algorithm

The swarm uses a deterministic leader election based on the Bully Algorithm, prioritized by:

| Priority Rank | Criterion |
|---------------|-----------|
| 1 (highest) | Designated by ground station (manual override) |
| 2 | Longest continuous GPS fix duration |
| 3 | Highest battery state of charge (%) |
| 4 | Lowest node ID (deterministic tiebreaker) |

Leader election runs at swarm initialization and whenever the current leader's heartbeat is absent for 5 consecutive intervals (10 seconds). Election result is broadcast via LoRa mesh and acknowledged by all nodes.

## 3. Inter-Drone Collision Avoidance

Each drone broadcasts its GPS position, velocity vector, and planned waypoint at 2 Hz via LoRa. The receiving drone projects a 3D collision cylinder around each peer:

| Collision Parameter | Value |
|--------------------|-------|
| Horizontal separation (min) | 5.0 m |
| Vertical separation (min) | 3.0 m |
| Prediction horizon | 5.0 s |
| Avoidance maneuver | Vertical displacement preferred (climb/descend 3 m) |
| Avoidance response time | < 500 ms from detection |
| Formation override | Collision avoidance takes priority over formation maintenance |

If a projected collision is detected, both drones execute complementary avoidance maneuvers (one climbs, the other descends, determined by node ID parity).

## 4. Formation Geometries

| Formation | Parameters | Description |
|-----------|------------|-------------|
| Grid | rows × cols, spacing (m) | Rectangular grid, leader at [0,0] |
| Line | heading (deg), spacing (m) | Single line perpendicular to heading |
| V-Shape | angle (deg), spacing (m) | V-formation, leader at apex |
| Circle | radius (m), node_count | Circular formation, leader at center |
| Custom | array of {dx, dy, dz} per node | User-defined formation file |

Formation offsets are computed relative to the leader's position and heading. Followers use the leader's broadcast position + offset as their position setpoint, fed through the position PID controller (CSMFAB-215).

## 5. Mission Types

| Mission Type | Description | Max Drones |
|-------------|-------------|------------|
| SYNCHRONIZED_WAYPOINTS | All drones fly identical waypoint mission with formation offsets | 64 |
| AREA_SURVEY | Grid-based survey coverage, drones assigned non-overlapping sectors | 16 |
| POINT_OF_INTEREST | All drones orbit a common point at different altitudes and radii | 32 |
| FOLLOW_TARGET | Drones track a moving GPS target with assigned angles | 8 |
| SEARCH_PATTERN | Parallel sweep pattern with assigned lanes | 12 |
| PERIMETER_PATROL | Drones distributed along a polygon perimeter | 24 |

## 6. Ground Station Interface

A single phone running the DRONE-X app functions as the ground control station (GCS). The GCS phone connects to the swarm via its local MCU bridge LoRa radio. All swarm commands, telemetry aggregation, and mapping display run on the GCS phone.

| GCS Function | Update Rate | Description |
|-------------|-------------|-------------|
| Telemetry aggregation | 2 Hz per drone | All drone positions, battery, status displayed on map |
| Swarm health panel | 1 Hz | Node count, link quality, outlier detection |
| Command broadcast | On demand | Formation changes, mission start/abort |
| Video relay (if enabled) | 0.2 Hz per drone | Thumbnail frames from any drone's camera (high latency) |

---

*"A swarm is not many drones flying together. A swarm is one distributed organism, and the protocol is its nervous system."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Swarm Systems Team
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
