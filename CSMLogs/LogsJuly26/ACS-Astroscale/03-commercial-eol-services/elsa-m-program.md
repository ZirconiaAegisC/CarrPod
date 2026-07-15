# ELSA-M — End-of-Life Services by Astroscale — Multiple

## Program Overview

| Field | Detail |
|-------|--------|
| Full Name | End-of-Life Services by Astroscale — Multiple |
| Customer | Eutelsat OneWeb |
| Funding | Public-Private Partnership (ESA / UK Space Agency) |
| Target Orbit | LEO ~1,200 km |
| Launch Vehicle | Isar Aerospace Spectrum |
| Launch Site | Andøya Spaceport, Norway |
| Contract Value | ~¥12.0 billion (cumulative, multi-satellite) |

## Mission Concept

ELSA-M is Astroscale's **first commercial end-of-life removal service**.
Unlike ADRAS-J2, which removes legacy debris already in orbit, ELSA-M is
designed as a *pre-planned service*: satellite operators contract with
Astroscale before launch, and the servicer removes satellites at the
conclusion of their operational lives.

The business model is analogous to decommissioning bonds in terrestrial
industries — operators pay into a removal contract over the satellite's
operating life, and Astroscale executes removal on schedule.

## Technical Architecture

### Servicer Spacecraft

The ELSA-M servicer is designed for **multiple-target removal** in a single
mission. Key specifications:

- **Docking Mechanism:** Magnetic capture using a standardized lightweight
  Docking Plate (DP) installed on the client satellite before launch. The DP
  weighs under 500g and adds negligible cost to the client satellite.
- **Delta-V Budget:** Sufficient for capture and deorbit of 3–5 OneWeb-class
  satellites (~150 kg each) from ~1,200 km to disposal orbit within 5 years.
- **Propulsion:** Electric (Hall-effect thrusters) for phasing and
  orbit-lowering; cold-gas thrusters for terminal approach and docking.
- **Autonomous Capture:** Vision-based terminal guidance with AprilTag-style
  fiducial markers on the Docking Plate.

### Operational Sequence

1. **Launch:** Isar Aerospace Spectrum delivers the ELSA-M servicer to a
   parking orbit near 1,200 km.
2. **Phasing:** The servicer uses electric propulsion to sequentially phase
   with each target satellite over weeks/months.
3. **Rendezvous & Capture:** Autonomous approach, magnetic docking, and
   rigidization. Each capture takes approximately 2–3 days from initial
   approach.
4. **Deorbit:** Servicer lowers the combined stack to a disposal orbit below
   600 km, releases the client satellite (or remains attached), and the
   stack decays naturally within 5 years.
5. **Repeat:** Servicer returns to the operational orbit and phases with the
   next client satellite.

## Partnership Structure

The ESA/UKSA funding is structured as a co-investment PPP where the public
agencies fund development and first-mission costs, and Astroscale retains
commercial exploitation rights for subsequent missions.

## Commercial Significance

Eutelsat OneWeb operates a constellation of ~650 satellites at ~1,200 km.
Under current guidelines, each satellite must be deorbited within 5 years of
end-of-life. ELSA-M provides a commercial alternative to relying solely on
onboard propulsion systems, which may fail or be insufficient. The OneWeb
contract serves as a **reference mission** intended to unlock the broader
megaconstellation EOL market (SpaceX Starlink, Amazon Kuiper, Telesat
Lightspeed, and future Chinese constellations).
