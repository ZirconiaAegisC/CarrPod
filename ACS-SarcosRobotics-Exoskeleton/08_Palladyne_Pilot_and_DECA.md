# PALLADYNE PILOT & DECA ARCHITECTURE

## PALLADYNE PILOT

Palladyne Pilot is positioned as a multi-domain autonomous platform — a command-and-control
(C2) software framework designed to integrate, task, and supervise heterogeneous unmanned
systems across air, ground, and maritime domains. It operates at a higher architectural level
than SwarmOS: while SwarmOS manages intra-swarm coordination at the vehicle level, Palladyne
Pilot provides the mission-level C2 layer for commanders and operators.

### Core Functionality

- **Multi-Domain Integration** — Simultaneous management of aerial (fixed-wing, rotary,
  loitering munitions), ground (UGV), and maritime (USV, UUV) unmanned systems within a
  unified operational picture.

- **Mission Planning & Dynamic Re-Tasking** — Operators define objectives, constraints,
  and rules of engagement. Palladyne Pilot continuously optimizes asset allocation and
  tasking in response to evolving battlefield conditions.

- **Sensor Fusion & Common Operating Picture** — Aggregates data from all managed assets
  into a single interface, providing situational awareness and decision support.

- **Interoperability** — Designed to integrate with existing military C2 systems including
  the Army's Project Convergence framework, the Navy's Project Overmatch, and the Air
  Force's Advanced Battle Management System (ABMS).

### Relationship to SwarmOS

SwarmOS and Palladyne Pilot operate in a hierarchical relationship:

| Layer | Platform | Function |
|---|---|---|
| Mission C2 | Palladyne Pilot | Operator interface, mission planning, multi-swarm coordination |
| Swarm Autonomy | SwarmOS | Intra-swarm coordination, formation control, task allocation |
| Vehicle Control | Onboard Avionics | Individual platform guidance, navigation, payload management |

This layered architecture enables Palladyne to sell SwarmOS as a standalone autonomy stack
(integration with third-party C2 systems) or as part of the complete Palladyne Pilot+SwarmOS
solution.

## DECA: DISTRIBUTED EDGE COMPUTING ARCHITECTURE

DECA (Distributed Edge Computing Architecture) is Palladyne's hardware reference architecture
for onboard autonomous system processing. It provides the physical computing substrate on
which SwarmOS, Palladyne Pilot agent software, and third-party autonomy applications execute.

### DECA Components

- **BRAIN X2** — Second-generation edge computing module designed for autonomous vehicle
  deployment. Provides GPU-accelerated inference, sensor processing pipelines, and secure
  communication interfaces in a SWaP-constrained (Size, Weight, and Power) form factor
  suitable for Group 1-3 UAS and man-portable loitering munitions.

- **DECA Networking Fabric** — Mesh networking protocol enabling low-latency, high-
  reliability data sharing between DECA-equipped vehicles. Designed to operate in
  contested electromagnetic environments with graceful degradation under jamming.

- **DECA Sensor Framework** — Standardized interfaces for EO/IR cameras, LIDAR, radar,
  electronic support measures (ESM), and signals intelligence (SIGINT) payloads, enabling
  rapid sensor integration without custom engineering for each platform.

### Hardware-Agnostic Philosophy

Palladyne has emphasized that SwarmOS and Palladyne Pilot are not dependent on DECA hardware
and can run on third-party edge computing platforms. This hardware-agnostic strategy is
intended to lower barriers to adoption by allowing integration with existing customer
hardware ecosystems. However, it also means Palladyne faces the classic platform company
challenge: the most valuable customers will eventually want to commoditize the hardware layer
and capture value at the systems integration level, potentially limiting Palladyne's hardware
revenue.

## DEVELOPMENT MATURITY

As of mid-2026, Palladyne Pilot and DECA are at varying stages of maturity:

- DECA BRAIN X2 has been demonstrated in integrated flight tests (IntelliSwarm, February 2026)
- Palladyne Pilot has been described in company presentations but independent verification of
  its operational maturity versus competitive systems is limited
- The $13.8 million USAF contract may provide a venue for advancing Palladyne Pilot toward an
  operational capability demonstration

The critical path for Palladyne Pilot is transitioning from technology demonstration to an
accredited, cyber-hardened, and operationally validated C2 system meeting DoD Information
Network (DoDIN) Approved Products List requirements — a multi-year, multi-million dollar
process that has challenged all entrants into the military C2 software market.
