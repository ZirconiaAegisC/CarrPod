# ADRAS-J2 — Debris Capture & Removal Mission

## Program Overview

| Field | Detail |
|-------|--------|
| Full Name | Active Debris Removal by Astroscale — Japan 2 |
| Contracting Agency | Japan Aerospace Exploration Agency (JAXA) |
| Contract Value | ¥13.2 billion (approx. $88M USD) |
| Program Phase | CRD2 Phase II (Capture & Deorbit) |
| Target Launch | FY2027 (April 2027 – March 2028) |
| Target Object | H-IIA / H-IIB upper stage (same class as ADRAS-J target) |

## Mission Architecture

ADRAS-J2 represents the **first commercial contract for physical debris
capture and deorbit**. Unlike ADRAS-J (Phase I), which was an inspection and
characterization mission, ADRAS-J2 will execute the full removal chain:

### Capture Mechanism

The spacecraft carries a **lightweight robotic arm** developed in-house by
Astroscale. The arm design incorporates:

- Three-fingered compliant gripper with force-torque sensing at each digit.
- Redundant motor drives with fail-safe braking on each joint.
- Machine-vision-guided alignment using features mapped during ADRAS-J.
- A capture target interface on the H-IIA upper stage's Payload Attach Fitting
  (PAF) — a standardized structural ring common to nearly all launch vehicles.

### Deorbit Sequence

1. **Launch & Phasing:** Injection into a co-planar orbit below the target.
   Electric propulsion orbit-raising over 2-3 months to match altitude and
   phase.
2. **Rendezvous:** Approach from 50 km to 100 m using heritage ADRAS-J GNC
   algorithms with lidar/camera sensor fusion.
3. **Capture:** Robotic arm extends, grasps the PAF interface, and rigidizes
   after confirming positive lock on all three fingers.
4. **Stack Stabilization:** Combined ADRAS-J2 + debris stack attitude control
   using reaction wheels and thrusters. Despin of the target using control
   torque from the servicer.
5. **Deorbit Burn:** High-thrust chemical propulsion (added for this mission
   phase) lowers perigee to ~150 km for destructive atmospheric re-entry over
   the South Pacific Ocean Uninhabited Area (SPOUA).
6. **Controlled Re-entry:** Both ADRAS-J2 and the captured debris stage
   disintegrate upon atmospheric entry. Astroscale holds multiple patents on
   controlled re-entry targeting and fragmentation prediction.

## Contract Structure

The ¥13.2B contract with JAXA is structured with milestone payments:
- **25%** — Design review completion and PDR (Preliminary Design Review).
- **25%** — CDR (Critical Design Review) and manufacturing start.
- **25%** — Spacecraft integration and testing complete, launch readiness.
- **25%** — Successful capture and deorbit initiation.

## Industrial Team

| Partner | Contribution |
|---------|-------------|
| Astroscale (Prime) | Spacecraft bus, robotic arm, GNC, mission operations |
| Mitsubishi Electric | Communications payload, ground segment support |
| JAXA | Target selection, orbital data, range safety, contract oversight |
| Rocket Lab (candidate) | Launch vehicle (Electron or Neutron) |

## Strategic Significance

ADRAS-J2 is the **anchor contract** in Astroscale's backlog. Successful
execution would make Astroscale the only company in the world with
demonstrated end-to-end debris removal — from inspection through physical
capture to controlled deorbit — positioning it as the default provider for
the emerging global debris remediation market.
