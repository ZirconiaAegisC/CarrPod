# ACS-Redwire-Space-Infrastructure Dossier
## Document 07 — Mako: MEO, GEO, and X-GEO Platform for RPO, Docking, and Refueling

### 7.1 Platform Overview

Mako represents the highest-performance spacecraft bus in Redwire's platform
portfolio, designed for missions in medium Earth orbit, geostationary orbit,
and beyond-geostationary (X-GEO) regimes including cislunar space. The platform
is purpose-built for rendezvous and proximity operations, satellite servicing,
docking, and orbital refueling — mission profiles that demand precision
navigation, robust propulsion, and high autonomy.

### 7.2 Propulsion System Architecture

Mako's propulsion subsystem distinguishes it from conventional satellite buses.
The platform employs a dual-mode propulsion architecture combining a primary
bi-propellant chemical propulsion system for large delta-V maneuvers with a
high-thrust electric propulsion system for station-keeping and fine orbit
adjustment. The chemical system uses a storable propellant combination with
heritage dating to geostationary satellite apogee engines, while the electric
system is derived from flight-proven Hall-effect thruster designs.

Total delta-V capability exceeds 2,500 meters per second, sufficient for orbit
raising from geostationary transfer orbit to geostationary orbit, inclination
changes of several degrees, and multiple rendezvous and docking sequences
during a single mission. This delta-V budget places Mako in a class typically
reserved for dedicated servicing vehicles rather than general-purpose satellite
buses.

### 7.3 Rendezvous and Proximity Operations

Rendezvous and proximity operations require a sensor suite and guidance system
that can transition from absolute navigation using GPS and star trackers at
hundreds of kilometers of range, through relative navigation using optical and
LIDAR sensors at intermediate ranges, to precision docking sensors at ranges
of meters to centimeters. Mako integrates a multi-modal relative navigation
sensor suite comprising:

- Wide field-of-view visible cameras for target acquisition at ranges from
  100 kilometers to 1 kilometer.
- Narrow field-of-view infrared cameras for relative pose estimation at ranges
  from 1 kilometer to 10 meters.
- Scanning LIDAR for precision range and bearing measurement during the final
  approach and docking phases.

The guidance, navigation, and control software implements autonomous mission
sequencing from target acquisition through docking, with ground-in-the-loop
supervision capability for mission assurance during critical phases.

### 7.4 Docking and Capture Mechanisms

Mako is compatible with multiple docking and berthing interfaces including the
standard grapple fixture used on the International Space Station and Hubble
Space Telescope, the NASA Docking System for crewed vehicle interfaces, and
mission-specific mechanical and fluid transfer interfaces for satellite
servicing. The robotic arm, when equipped, provides six degrees of freedom for
precise positioning of servicing tools and refueling connectors.

### 7.5 Refueling Mission Architecture

Satellite refueling requires the servicing vehicle to locate the client
satellite, perform rendezvous and proximity operations, capture or dock with
the client, establish a fluid transfer connection, transfer propellant while
maintaining attitude control, and safely separate from the client. Mako has
been designed with this end-to-end mission sequence as a primary design
reference case rather than an afterthought.

The fluid transfer subsystem includes propellant tanks sized for both the
servicing vehicle's own consumption and the transfer budget allocated to the
client satellite, redundant valves and pressure regulators for reliability,
and leak detection sensors for mission safety. The first operational refueling
missions are expected to target geostationary communications satellites, where
the economic value of extending a satellite's operational life by several years
justifies the cost of a dedicated servicing mission.

### 7.6 X-GEO and Cislunar Applications

Beyond GEO, Mako's propulsion capability enables missions in cislunar space
including lunar orbit insertion, halo orbit station-keeping around the
Earth-Moon Lagrange points, and deep-space technology demonstrations. The
platform's radiation tolerance, designed for the GEO radiation environment,
provides sufficient margin for the more benign cislunar radiation conditions
with the exception of passages through the Van Allen belts, which must be
managed through trajectory design.

### 7.7 Commercial and Government Demand

Near-term demand for Mako-class capabilities is driven by U.S. Space Force
interest in satellite servicing and space domain awareness in the GEO belt,
commercial satellite operators seeking life extension for high-value
communications satellites, and NASA and international exploration programs
requiring logistics and servicing capabilities in cislunar space as human
presence extends beyond low Earth orbit.

### 7.8 Competitive Landscape

Mako competes with Northrop Grumman's Mission Extension Vehicle and Mission
Robotic Vehicle product lines, Astroscale's life extension and debris removal
platforms, and emerging servicing vehicles from international competitors.
Redwire's competitive differentiation lies in Mako's integration with the
broader Redwire platform family, enabling customers to procure a full range of
spacecraft capabilities — from VLEO through cislunar — from a single supplier.
