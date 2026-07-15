# 12 — 6-Trajectory Heliosphere Mission Architecture

## Classification: Proprietary — ACS Internal Use Only

---

## 1. Multi-Trajectory Concept

The NASA NIAC study evaluates six distinct trajectories for a heliosphere
mission, each corresponding to a different departure direction, solar cycle
phase, and scientific measurement objective. The six-trajectory approach is
enabled by the Helicity Drive's variable specific impulse (I_sp) and high
delta-V capability, which allow the same propulsion system to execute
significantly different flight profiles without redesign.

The six trajectories map to six directions on the sky, chosen to sample
different regions of the heliosphere:

1. **Nose trajectory** — toward the heliosphere's leading edge (direction of
   the Sun's motion through the local interstellar medium)
2. **Tail trajectory** — toward the heliospheric tail, the extended wake
   region behind the Sun's motion
3. **North polar trajectory** — toward the heliosphere's northern pole, where
   the solar magnetic field lines are open
4. **South polar trajectory** — toward the southern heliospheric pole
5. **Flank trajectory A** — toward one side of the heliosphere, at
   intermediate heliographic latitude
6. **Flank trajectory B** — toward the opposite flank, providing symmetry and
   comparative measurements

---

## 2. Trajectory Design Parameters

Each trajectory is characterized by:

| Parameter | Symbol | Range |
|---|---|---|
| Right ascension (J2000) | α | 0°–360° |
| Declination (J2000) | δ | -90° to +90° |
| Heliocentric distance at target | R_target | 100–200 AU |
| Total mission delta-V | ΔV_total | 50–200 km/s |
| Cruise velocity | v_cruise | 10–30 AU/year |
| Required I_sp | I_sp | 3,000–25,000 seconds |
| Thrust-to-mass ratio | T/m | 10⁻⁴–10⁻² m/s² |
| Departure window | — | Solar cycle dependent (radiation environment) |

---

## 3. Nose Trajectory (Highest Priority)

The nose direction (approximately RA ~ 17h, Dec ~ -17°, in the constellation
Ophiuchus) represents the shortest distance to the heliopause because the
heliosphere is compressed in the direction of motion. The nose trajectory
offers the fastest transit to the interstellar medium and is the highest-
priority science objective.

| Parameter | Value |
|---|---|
| Target distance | ~110–130 AU |
| ΔV requirement | ~60 km/s |
| Cruise velocity | ~20 AU/year |
| Transit time | ~6 years |
| I_sp (optimal) | ~15,000 s |
| Power required | ~500 kW |

---

## 4. Tail Trajectory

The heliospheric tail extends hundreds to thousands of AU behind the Sun; the
exact extent is unknown because it has never been directly measured. The tail
trajectory would provide the first direct in-situ data on the tail's length,
plasma density, and magnetic structure.

| Parameter | Value |
|---|---|
| Target distance | 150–400 AU |
| ΔV requirement | 100–200 km/s |
| Cruise velocity | 25–30 AU/year |
| Transit time | 8–12 years |
| I_sp (optimal) | ~20,000–25,000 s |
| Power required | ~1 MW |

The tail trajectory is the most demanding of the six and serves as the
design-driving case for the Helicity Drive's upper-performance regime.

---

## 5. Polar Trajectories

The north and south polar trajectories cross the heliopause at high
heliographic latitudes, where the heliopause may be farther from the Sun
(due to reduced ram pressure) and where the transition from solar wind to
interstellar plasma may occur through different physical mechanisms.

| Parameter | North Polar | South Polar |
|---|---|---|
| Target distance | ~130–180 AU | ~130–180 AU |
| ΔV requirement | ~80 km/s | ~80 km/s |
| Cruise velocity | ~18 AU/year | ~18 AU/year |
| Transit time | ~7–10 years | ~7–10 years |

---

## 6. Flank Trajectories

The flank trajectories pass through intermediate heliographic latitudes,
providing a comparative dataset between the well-studied equatorial plane
(Voyager, Pioneer) and the polar regions.

| Parameter | Flank A | Flank B |
|---|---|---|
| Target distance | ~120–150 AU | ~120–150 AU |
| ΔV requirement | ~70 km/s | ~70 km/s |
| Cruise velocity | ~18 AU/year | ~18 AU/year |
| Transit time | ~7–8 years | ~7–8 years |

---

## 7. Mission Architecture Trades

The Helicity Drive's variable I_sp capability enables a fundamental mission
design trade:

| Strategy | I_sp | Thrust | Transit Time | Fuel Mass |
|---|---|---|---|---|
| High-thrust, low-I_sp | 3,000 s | High | Shorter | Higher |
| Balanced | 10,000 s | Medium | Medium | Medium |
| High-I_sp, low-thrust | 25,000 s | Low | Longer | Lower |

The six-trajectory study evaluates each trajectory at multiple points in this
trade space to determine the optimal trajectory-specific I_sp and thrust
profile. The Helicity Drive's ability to vary I_sp by adjusting the
peristaltic compression ratio and reconnection heating power — without hardware
changes — is a key enabler for this multi-mission flexibility.

---

## 8. Programmatic Context

A dedicated heliosphere mission has been identified as a high-priority objective
in the Heliophysics Decadal Survey. The six-trajectory NIAC study positions the
Helicity Drive as a candidate propulsion system for such a mission, competing
conceptually with solar sails, nuclear electric propulsion, and radioisotope
electric propulsion — all of which offer lower delta-V or longer transit times.
