# APS-R — Astroscale Prototype Servicer for Refueling

## Program Overview

| Field | Detail |
|-------|--------|
| Full Name | Astroscale Prototype Servicer for Refueling |
| Customer | United States Space Force (USSF) |
| Contracting Office | Space Systems Command (SSC), Los Angeles AFB |
| Contract Value | ~¥5.5 billion (~$37M USD) |
| Program Phase | Prototype Development & Ground Demonstration |
| Target Orbit Class | Geostationary Earth Orbit (GEO) |

## Mission Concept

APS-R addresses one of the highest-value use cases in on-orbit servicing:
**refueling geostationary communications satellites**. GEO satellites
typically cost $200M–$500M to build and launch, and their operational life
is limited primarily by the exhaustion of station-keeping propellant — not
by degradation of the revenue-generating communications payload.

A refueling service that extends a GEO satellite's life by 3–5 years
generates significant economic value: a satellite earning $50M–$100M in
annual revenue can justify a $20M–$40M refueling mission.

## Technical Architecture

### Refueling Interface

APS-R uses the **Orbit Fab RAFTI (Rapidly Attachable Fluid Transfer
Interface)** as the standard refueling port. RAFTI is an open-standard
interface developed by US-based Orbit Fab, consisting of:

- A passive half installed on the client satellite (weighs ~1.5 kg).
- An active half on the APS-R servicer (weighs ~3.0 kg).
- Self-aligning mechanical coupling with a 3-degree capture cone.
- Hermetic fluid seal rated for hydrazine, MMH, NTO, and "green"
  propellants including AF-M315E and LMP-103S.
- Integrated electrical pass-through for health telemetry.

### Servicer Design

The APS-R spacecraft is designed for **multi-client GEO servicing**:

- **Propellant Capacity:** 500 kg of hydrazine, sufficient for 4–6 client
  refueling operations.
- **Rendezvous:** Standard GEO drift-orbit rendezvous at ~0.1°/day relative
  drift rate, using electric propulsion for long-duration phasing.
- **Capture:** RAFTI docking from a station-keeping box ~50m from the
  client, with vision-based relative navigation.
- **Propellant Transfer:** Pressurized bladder system. Transfer rate of
  ~10 kg/hour. A typical refueling (~50 kg) completes in 5 hours.
- **Inspection:** Pre- and post-refueling inspection of the client using
  high-resolution cameras.

## US Space Force Context

The US Space Force has identified on-orbit refueling as a "critical
warfighting capability" under the **Space Warfighting Construct**. The
ability to maneuver freely in GEO without propellant constraints is
considered essential for space superiority.

APS-R is part of the Space Force's broader **On-Orbit Servicing,
Assembly, and Manufacturing (OSAM)** portfolio, which also includes:

- USSF / Northrop Grumman Mission Extension Vehicle (MEV) — docked life
  extension via the servicer's own thrusters.
- USSF / Astroscale APS-R — dedicated refueling.
- DARPA Robotic Servicing of Geosynchronous Satellites (RSGS) — robotic
  repair and upgrade.

## Development Timeline

| Milestone | Target Date |
|-----------|-------------|
| System Requirements Review (SRR) | Q3 2025 ✓ |
| Preliminary Design Review (PDR) | Q1 2026 ✓ |
| Critical Design Review (CDR) | Q3 2026 |
| Ground Demonstration (RAFTI mate/demate, fluid transfer) | Q2 2027 |
| Flight Hardware Delivery | FY2028 |
