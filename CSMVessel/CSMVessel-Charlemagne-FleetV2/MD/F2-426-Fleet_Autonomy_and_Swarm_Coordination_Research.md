# F2-426 — Fleet Autonomy and Swarm Coordination Research
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Current Capability

All five Charlemagne vessels already have the hardware needed for swarm coordination:
- PN-CC-001 LoRa (256-node mesh, 15 km range)
- GPS-free TDOA positioning (±0.5 m from LoRa triangulation)
- PMMA POF data bus
- FBG terrain mapping (continuous structural feedback)
- MIMO MPC torque vectoring (10 kHz, programmable)

The fleet can TODAY communicate, share position, and coordinate at a swarm level.
What's needed: Higher-layer swarm intelligence software.

## 2. Target Swarm Behaviors

| Behavior | Use Case | Technical Requirement |
|---|---|---|
| Convoy formation | RHODONITE bus fleet | Lead vehicle broadcasts route; others follow at 15 m gap |
| Emergent obstacle avoidance | All vessels in city mesh | Share FBG terrain maps; re-route around known obstacles |
| Joint amphibious operation | Mass evacuation | Mesh-coordinate water entry/exit to avoid collision |
| Distributed rescue grid | Emergency response | AMETHYST fleet deploys in search pattern; BERYL covers sectors |
| Child safety net (TOURMALINE) | Neighborhood monitoring | If any TOURMALINE loses parent LoRa, nearest adult vessel investigates |

## 3. Software Development Plan

Phase 1 (12 months): Convoy following algorithm on 3× RHODONITE in test environment
Phase 2 (18 months): Emergent rerouting in urban mesh (virtual, simulation-first)
Phase 3 (24 months): Full swarm deployment trials with 10-vessel mixed fleet
Phase 4 (36 months): Commercial fleet offering with manufacturer-warranty swarm software

Key partner: MIT DARPA-sponsored multi-agent systems research group (collaboration proposal F2-430)


---
*End F2-426 | CSMVessel-Charlemagne-FleetV2 | June 2026*
