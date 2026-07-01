# CSMFAB000000000114 — Vol-02
# FAA Waiver Application Strategy and Templates
## Three Waivers for ASB-1 Research Operations
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: The Waiver System

The FAA's Part 107 waiver system is not an obstacle — it is a door. The regulations are written conservatively for safety across the general public. When you can demonstrate that your specific operation is safe through alternative means, the FAA can waive specific rules via a **Certificate of Waiver** issued through the Aviation Safety Hub (formerly FAADroneZone at faadronezone.faa.gov, now at aviationsafetyhub.faa.gov).

Key facts about waivers:
- The FAA processes applications within approximately **90 days** on average
- You can begin submitting your application **before** you finish building the device
- Waivers are granted to specific operations at specific geographic areas for specific time periods (typically 1-4 years)
- Multiple waivers can be active simultaneously
- Universities and research organizations have **strong success rates** — the Mid-Atlantic Aviation Partnership (affiliated with Virginia Tech) held a 2025-2028 waiver for 15 simultaneous drones with BVLOS; Amazon has held BVLOS waivers; NPS (Naval Postgraduate School) has ongoing research waivers

You need three waivers for full ASB-1 research operation. This volume provides the complete application content for each.

---

## WAIVER 1: §107.35 — Multiple Simultaneous UAS (Swarm Operations)

### What Is Being Waived

14 CFR §107.35 states that a person may not simultaneously act as Remote PIC or Visual Observer for more than one unmanned aircraft. This waiver allows a single RPIC to operate 5 to 20 ASB-1 units simultaneously as a swarm.

### Application Content

**Responsible Person / RPIC:** [Your Name], Cypress University Mechatronics Student, Remote Pilot Certificate # [Your Certificate Number]

**Operation Description:**
The ASB-1 Archimedes Spiraling Bird UAS is a hand-launched, sub-249g, Archimedes-screw-bodied micro-drone. Units are launched simultaneously from a stationary point (cliff edge, elevated terrain, or designated rooftop). After hand-throw launch, units autorotate into the prevailing wind, collecting atmospheric pressure, temperature, humidity, and altitude data via onboard sensors. The RPIC monitors all units via an aggregated LoRa-mesh ground station displaying position, altitude, and health of each unit in real time. Operations are conducted in Class G unpopulated airspace over water or remote terrain, below 400 ft AGL standard (waiver requested for up to 1,200 ft AGL under separate §107.51 waiver).

**Operational Area:** [To be specified per operation — typical example: 1-mile radius over Pacific Ocean, Malibu CA, centered at 34.0259° N, 118.7798° W]

**Number of Aircraft:** Up to 20 ASB-1 units simultaneously

**How Safety Is Maintained During Single or Multiple Aircraft Failure:**

1. Each unit is equipped with an independent Flight Termination System (FTS) — a LoRa-commanded micro-parachute (Vol-11) that can be triggered individually or for all units simultaneously from the ground station.
2. Each unit carries a 50m Dyneema dielectric tether that limits maximum range from the ground reel. Tethers are operated by a dedicated Tether Operator (separate from RPIC) who can brake any unit independently.
3. The LoRa mesh protocol assigns each unit a unique node ID. Ground station software (running on Raspberry Pi 4B) monitors all nodes simultaneously and displays a warning if any unit goes offline.
4. Units autorotate passively — they do not require continuous control input to maintain stable flight. A failed radio link results in continued stable flight (not loss of control), followed by gentle descent when tether tension is applied or the parachute deploys.

**How Simultaneous Control Is Maintained:**

The ASB-1 Aggregated C2 System consists of:
- Ground station: Raspberry Pi 4B running open-source swarm management software
- LoRa 915 MHz mesh nodes on each unit communicating via Meshtastic protocol
- Ground station LoRa gateway with 8 km range
- Color-coded status display: each unit shown as colored dot on map with altitude bar
- Individual and broadcast command capability (individual FTS trigger, broadcast land command)

**How RPIC Maintains See-and-Avoid:**

1. Operations occur in remote Class G airspace over water or unpopulated terrain
2. Pre-flight NOTAM is filed for any operation above 200 ft AGL (as required by §107.35 waiver standard provisions)
3. Two Visual Observers (VOs) are positioned at the launch point with binoculars, scanning the operational volume for manned aircraft throughout the flight
4. The RPIC monitors the LoRa ground station display showing real-time GPS positions and altitudes of all units
5. If any manned aircraft is observed approaching the operational area, the RPIC immediately triggers broadcast land/FTS command to all units

**What Training Will Personnel Receive:**

All RPIC candidates for ASB-1 swarm operations will complete:
1. FAA Part 107 Remote Pilot Certificate
2. ASB-1 unit operations ground school (2 hours, covering unit limitations, programming, normal and abnormal procedures)
3. Single-unit tether and short-range flight demonstration (successful completion required before multi-unit qualification)
4. Tabletop emergency exercise covering communication failures, lost-unit scenarios, and manned-aircraft encounter

**Independent Flight Termination System Description (per unit):**

Each ASB-1 unit carries:
- A lightweight micro-parachute (4g, 20cm diameter, packed in nose cone)
- LoRa-controlled servo latch release mechanism
- Upon activation, parachute deploys and unit descends at <3 m/s vertical speed
- FTS is tested pre-flight: deployment simulation (latch actuation without parachute release) required before each swarm flight
- FTS is verified operational independent of main flight controller
- Battery is shared with main electronics but FTS circuit has 10-minute independent capacitor backup

**Precedents Cited:**
- Waiver 107W-2026-00259 (Mid-Atlantic Aviation Partnership / Virginia Tech): 15 simultaneous UAS, issued February 2026
- Waiver 107W-2026-00517: 300 simultaneous UAS (drone light show), issued April 2026
- University aeronautical research programs: consistently approved for 4-20 unit swarms under §107.35 since 2018

---

## WAIVER 2: §107.51(b) — Operations Above 400 ft AGL

### What Is Being Waived

14 CFR §107.51(b) limits small UAS operations to a maximum of 400 feet above ground level (AGL). The ASB-1, when launched from cliff tops into updrafts, may exceed this altitude in research scenarios targeting wind gradient data above 400 ft.

### Application Content

**Operation Description:**
The ASB-1 is a passive autorotating device — it does not have upward thrust, it rides updrafts and thermal lift generated by the terrain. When launched from a cliff with a 200 ft face in a 20+ mph updraft, the device may gain altitude at 5-10 ft/second. Research missions targeting mesoscale wind shear studies require data collection between 400-1,200 ft AGL to characterize wind gradient behavior above cliffs and ridgeline terrain features.

**Safety Case for Above-400 ft Operations:**

1. All operations above 400 ft occur over water or uninhabited terrain (cliffs above open ocean, desert canyons, mountain ridgelines away from populated areas)
2. A NOTAM will be filed at least 24 hours before any operation above 400 ft, per standard waiver provision
3. Each unit carries an independent FTS (parachute) deployable from ground command
4. The tether system limits maximum altitude: a 50m tether allows maximum altitude equal to tether length plus launch elevation. For operations above 400 ft targeting 1,200 ft AGL, 400m tethers are used (mass budget: 400m × 0.1g/m = 40g, within the 72g margin)
5. Ground station GPS altitude monitoring — automatic broadcast FTS trigger if any unit exceeds programmed altitude ceiling

**Altitude Ceiling Requested:** 1,200 ft AGL (365 meters)

**Airspace Class:** Class G only — all operational areas selected to be 3+ nautical miles from any airport or helipad

**Aeronautical Research Justification (§89.120):**
This operation is designated as aeronautical research under 14 CFR §89.120. The wind profile data collected above 400 ft AGL contributes to the characterization of coastal and terrain-induced wind shear, which has direct application to:
- Small UAS wind resistance standards
- Search and rescue UAV operational planning in coastal environments
- Atmospheric boundary layer research supporting weather modeling
- Cypress University Mechatronics Program research publications

---

## WAIVER 3: §107.31 — Beyond Visual Line of Sight (BVLOS)

### What Is Being Waived

14 CFR §107.31 requires the Remote PIC to maintain unaided visual contact with the aircraft throughout the operation. In cliff-top launch scenarios with 20 mph+ winds, ASB-1 units may drift downwind or gain altitude to a point where their small size (150mm diameter) makes unaided visual tracking impractical beyond approximately 200-400m range.

### Application Content

**How RPIC Will Know Aircraft Position Without Unaided Visual Contact:**

Each ASB-1 unit transmits the following data at 1 Hz via LoRa 915 MHz to the ground station:
- GPS latitude / longitude (±3m accuracy, u-blox M8N module)
- Altitude AGL (barometric + GPS fusion, ±1m accuracy)
- Groundspeed (GPS derived)
- Battery voltage
- FTS status (armed/disarmed)
- Unit node ID

Ground station software displays all units on a real-time moving map (similar to FlightAware but locally hosted on Raspberry Pi). The RPIC can see the position, altitude, and velocity of every unit at all times without needing unaided visual contact.

**How RPIC Will Detect and Avoid Other Aircraft:**

1. Two Visual Observers are stationed at the highest available vantage point at the launch site, scanning with binoculars continuously
2. Pre-flight: ADS-B traffic check via ForeFlight or Garmin Pilot to verify no known IFR traffic
3. The operational area is selected specifically to avoid common VFR flight routes (over-water coastal operations, mountain areas without fly-in airports nearby)
4. All units carry passive radar-reflective mylar strip on the spiral body (measurable by aircraft transponder systems from 1+ km)
5. Emergency: RPIC broadcasts all-unit FTS trigger immediately upon any VO call of approaching aircraft

**VLOS Compliance Boundary:**
For flights within 200m horizontal from the RPIC, tethers and standard binocular VOs provide full VLOS coverage. The BVLOS waiver is specifically requested for the **200m-2,000m horizontal range** from the RPIC under research conditions.

---

## Application Submission Process

### Step 1 — Prepare Your Supporting Documents
Before submitting, assemble:
- [ ] Copy of your FAA Remote Pilot Certificate
- [ ] Aircraft description sheet (use Vol-05 weight budget + Vol-16/17 frame specs)
- [ ] Operational area map (screenshot from SkyVector or Google Earth with GPS coordinates)
- [ ] C2 system description (use Vol-07 LoRa telemetry document)
- [ ] FTS description (use Vol-11 parachute document)
- [ ] Training plan (brief: who will be trained, how, when)
- [ ] Cypress University letter designating ASB-1 as aeronautical research

### Step 2 — Submit via FAA Aviation Safety Hub
URL: https://aviationsafetyhub.faa.gov
1. Create or log into your FAA DroneZone account
2. Select "Request a Part 107 Waiver"
3. Select the specific regulation(s) being waived (you can bundle §107.31 + §107.35 + §107.51 in one application)
4. Paste the application text from this volume into the corresponding fields
5. Upload supporting documents
6. Submit and save the application number

### Step 3 — Wait and Respond
The FAA will respond within approximately 90 days. They may request additional information. Respond promptly and completely. If denied, they will explain why — revise and resubmit.

### Step 4 — Receive Certificate of Waiver
Upon approval, you receive a Certificate of Waiver (CoW) specifying:
- Exact regulations waived
- Operational area GPS boundaries
- Altitude ceiling
- Expiration date (typically 1-4 years)
- Special provisions (NOTAM requirements, personnel training, FTS mandates)

Always carry a copy of your CoW during ASB-1 operations.

---

## Cost and Timeline Summary

| Action | Cost | Timeline |
|---|---|---|
| FAA Part 107 knowledge test | $175 testing fee | 1-4 weeks to study, then schedule |
| Waiver application (bundled) | $0 (free) | Submit 90 days before first research flight |
| Waiver processing | $0 | ~90 days FAA review |
| Total regulatory cost | ~$175 | 3-4 months total from decision to waiver in hand |

---

## CHECKPOINT — Vol-02 Complete

Before moving to Vol-03, confirm:
- [ ] You understand the waiver application process (Aviation Safety Hub)
- [ ] You have read the three waiver application texts and understand what you are claiming
- [ ] You know that each ASB-1 unit must have an independent FTS to qualify for §107.35 waiver
- [ ] You understand that NOTAM filing is required for >200 ft AGL under §107.35 waiver
- [ ] You have noted the ~90-day FAA review timeline — start application early
- [ ] You understand the aeronautical research designation advantage (§89.120)

**Proceed to:** Vol-03 (Archimedes Spiral Aerodynamics — the science of how this flies)

---

*CSMFAB000000000114-Vol-02 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
