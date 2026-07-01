# CSMFAB000000000114 — Vol-01
# FAA CFR Part 107 — Complete Compliance Analysis
## Archemedian Spiraling Bird UAS (ASB-1)
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: Why You Need to Read This First

Before you 3D print a single part or solder a single wire, you need to understand the regulatory environment your device will operate in. The Federal Aviation Administration (FAA) governs all aircraft operations in United States airspace — including tiny hand-thrown spiraling devices that look like maple seeds. Ignorance of these rules is not a defense; a violation can result in civil fines of up to $27,500 per incident and criminal penalties for willful violations.

The **good news**: the ASB-1 is designed from the ground up to comply with, or obtain waivers for, every applicable FAA rule. This volume walks through every relevant regulation, tells you exactly where the ASB-1 stands, and tells you what to do about the gaps.

The primary regulatory framework is **14 CFR Part 107 — Small Unmanned Aircraft Systems**, which covers all civil UAS operations weighing less than 55 pounds. This is your rulebook.

---

## Part 1: The Weight Threshold — Your Most Important Number

### 249 Grams (0.549 Pounds)

This number is the single most important design constraint for the ASB-1. Here is why it matters:

**At or above 250g:** You must register the drone with the FAA ($5 fee, 3-year validity). Once registered, you are also required to broadcast **Remote ID** — a continuous radio signal that tells the FAA and anyone nearby who you are, where your drone is, and where you (the pilot) are located. Remote ID hardware adds approximately 8-15g and costs $30-80.

**Below 250g (exactly 249g or less on takeoff):** You are **exempt from both registration and Remote ID**. The FAA's registration threshold under 14 CFR Part 48 is 0.55 pounds (250 grams). Below that, recreational flyers need not register. For Part 107 operations (research/educational), registration is technically required regardless of weight, but the Remote ID broadcast requirement does not apply to aircraft below the registration threshold.

> **Design Target:** The ASB-1 is engineered to a hard mass budget of **177g with 72g of margin** to the 249g limit. This is not optional. If a design decision adds weight, something else must come out.

---

## Part 2: Which Rules Apply — Recreational vs. Research

### 44809 Exception (Recreational Flying)

Congress created the Exception for Limited Recreational Operations of Unmanned Aircraft (49 U.S.C. §44809) as a simplified ruleset for hobby flying. However, **this does not apply to you** if you are:

- Flying for educational research credit at a university
- Collecting aeronautical data for research purposes
- Presenting results to academic audiences
- Flying as part of a mechatronics certificate program

All of the above are non-recreational purposes. You must fly under **14 CFR Part 107**.

### 14 CFR Part 107 — Small UAS Rule

This is your governing regulation for all ASB-1 operations. To fly under Part 107, you (the operator) must:

1. Pass the FAA Part 107 Knowledge Test (Remote Pilot Certificate)
2. Register each drone (if ≥250g) — ASB-1 is potentially exempt by weight
3. Follow all Part 107 operating rules (detailed below)
4. Obtain waivers for any rules you cannot comply with

**The Part 107 knowledge test** is offered at FAA-approved testing centers (PSI or CATS). Cost: ~$175. Pass score: 70%. Topics covered include airspace, weather, radio communications, emergency procedures, and loading/performance. This is your first milestone.

---

## Part 3: Rule-by-Rule Analysis

### §107.12 — Remote Pilot Certificate

**What it says:** You must hold a Remote Pilot Certificate issued by the FAA.

**ASB-1 Status:** REQUIRED. You must pass the Part 107 knowledge test before any Part 107 operation. As a Cypress University student in a drone class, you may already have this or be working toward it.

**Action:** Schedule and pass the FAA Part 107 Aeronautical Knowledge Test.

---

### §107.17 — Medical Condition

**What it says:** Do not operate if you know or have reason to know of any physical or mental condition that would interfere with safe operation.

**ASB-1 Status:** COMPLY. Standard self-certification. No medical certificate required for Part 107.

---

### §107.19 — Remote Pilot in Command (PIC) Responsibility

**What it says:** One person must be designated Remote Pilot in Command (RPIC). The RPIC is responsible for the safety of the operation.

**ASB-1 Status:** COMPLY. You (or your designated qualified co-pilot) are the RPIC for all ASB-1 operations. For swarm operations, see §107.35 below.

---

### §107.23 — Hazardous Operation

**What it says:** Do not operate in a reckless or careless manner that endangers life or property.

**ASB-1 Status:** COMPLY by design. The tether system (Vol-10), speed governor (Vol-08), and net recovery system (Vol-14) all serve to keep the device predictable and prevent runaway flight above populated areas.

---

### §107.25 — Operation from a Moving Vehicle or Aircraft

**What it says:** Do not operate from a moving vehicle unless in sparsely populated areas.

**ASB-1 Status:** COMPLY. The ASB-1 is hand-launched from a stationary position. The pilot stands on a cliff, rooftop, or beach — not in a moving vehicle.

---

### §107.29 — Daylight Operations

**What it says:** Only operate during daylight or civil twilight with anti-collision lighting.

**ASB-1 Status:** COMPLY. All ASB-1 research operations are planned for daytime only. No night waiver required. If future nighttime use is desired, a simple LED ring (1-2g) satisfies the anti-collision light requirement without a waiver.

---

### §107.31 — Visual Line of Sight (VLOS)

**What it says:** The Remote PIC must maintain unaided visual contact with the aircraft throughout the operation, sufficient to see its position, altitude, attitude, and direction of travel.

**ASB-1 Status:** **WAIVER REQUIRED for research operations.** In strong cliff winds, the ASB-1 may spiral upward and downwind beyond the point where naked-eye observation can determine its position and attitude. A tethered short-range operation (within 50m) is VLOS compliant. Extended free-flight research operations require a §107.31 waiver.

**Mitigation provided in waiver application:** LoRa GPS telemetry provides continuous position/altitude data to the ground station. Visual Observers (VOs) may be stationed at multiple points. Operations restricted to unpopulated areas over water.

**See Vol-02 for the full waiver application text.**

---

### §107.33 — Visual Observer

**What it says:** If a visual observer (VO) is used, the RPIC and VO must be in direct communication. The VO must be able to see the aircraft throughout flight.

**ASB-1 Status:** Swarm operations will use multiple VOs. The waiver for §107.31 will also address §107.33 requirements for the research scenario.

---

### §107.35 — Operation of Multiple Small UAS

**What it says:** A person may not act as Remote PIC or VO for more than one unmanned aircraft at the same time.

**ASB-1 Status:** **WAIVER REQUIRED.** Operating 5-20 units simultaneously requires a §107.35 waiver. This is one of the most-commonly-issued waivers in the FAA system. Multiple active 2026 waivers exist for university research programs operating 4 to 50+ drones simultaneously.

**Key waiver requirements:**
- Each unit must have an independent Flight Termination System (FTS)
- The RPIC must use an aggregated command and control (C2) system
- Swarm must remain within a defined operational area
- NOTAM required if operating above 200 ft AGL

**See Vol-02 for the full waiver application text and Vol-13 for swarm design.**

---

### §107.37 — Right of Way

**What it says:** The UAS must always yield the right of way to all manned aircraft.

**ASB-1 Status:** COMPLY. Operations target remote cliff and coastal areas with minimal manned aircraft traffic. Pre-flight airspace check via ForeFlight or SkyVector required. The ASB-1's tether and limited range act as a natural containment versus flight corridors.

---

### §107.39 — Operations Over People

**What it says:** Do not operate over moving vehicles or human beings not directly participating in the operation, unless the aircraft meets Category 1 requirements.

**Category 1 Requirements (§107.110):**
- Weighs 0.55 pounds (250g) or less on takeoff AND throughout the duration
- Does not contain any exposed rotating parts that would lacerate human skin upon impact

**ASB-1 Status:** The ASB-1 targets 177g — well below 0.55 lbs. Its spiral body is designed as a smooth, enclosed helix with no exposed sharp blade edges. If these conditions are maintained, the ASB-1 potentially meets **Category 1** and can operate over participating personnel.

> ⚠️ **SAFETY:** Even with Category 1 eligibility, never fly directly over non-participating bystanders. The net recovery system (Vol-14) and designated landing zones must be used at all times.

---

### §107.41 — Operation in Controlled Airspace

**What it says:** Do not fly in Class B, C, D, or E surface airspace without FAA authorization.

**ASB-1 Status:** Cliff/coastal/canyon operations typically occur in **Class G (uncontrolled) airspace**, which requires no prior authorization. Before any flight, verify airspace class using the FAA B4UFLY app or SkyVector. If near an airport, use the LAANC system for automatic authorization.

---

### §107.49 — Preflight Familiarization

**What it says:** Before flight, familiarize yourself with weather reports, NOTAMs, airspace restrictions, and the aircraft's operating limitations.

**ASB-1 Status:** COMPLY. Vol-20 (Hand-Launch Protocol) includes a preflight checklist that covers all §107.49 requirements.

---

### §107.51 — Operating Limitations

**What it says:**
- (a) Airspeed shall not exceed **100 mph groundspeed** at any time
- (b) Altitude shall not exceed **400 ft AGL** unless within 400 ft of a structure
- (c) Minimum 3 statute miles visibility
- (d) Minimum 500 ft below and 2,000 ft horizontal from clouds

**ASB-1 Status:**

| Limitation | Status |
|---|---|
| 100 mph airspeed | **GOVERNED** — centrifugal governor + electronic backup limits to 100 mph. Compliant. |
| 400 ft AGL | **WAIVER REQUIRED** — cliff launches into updrafts will exceed 400 ft. See Vol-02. |
| 3 sm visibility | COMPLY — only operate in clear or partly cloudy VFR conditions |
| Cloud clearance | COMPLY — target operations in open coastal/canyon areas away from cloud bases |

---

### §107.57 and §107.59 — Falsification, Records

**What it says:** Do not falsify applications, records, or reports to the FAA.

**ASB-1 Status:** COMPLY. All waiver applications and research records will be accurate and complete.

---

### §107.65 — Aeronautical Knowledge Recurrency

**What it says:** Remote pilot certificates must be maintained with recurrent training every 24 calendar months.

**ASB-1 Status:** COMPLY. Pass the initial test. Complete recurrent online training every 2 years via WINGS or the FAA Safety Team.

---

## Part 4: Summary Compliance Table

| Regulation | Topic | ASB-1 Status | Action Required |
|---|---|---|---|
| §107.12 | Remote Pilot Certificate | **REQUIRED** | Pass Part 107 test |
| §107.23 | Hazardous Operation | COMPLY | By design (tether + governor) |
| §107.25 | Moving Vehicle Launch | COMPLY | Stand still when launching |
| §107.29 | Daylight Operations | COMPLY | Daytime only |
| §107.31 | Visual Line of Sight | **WAIVER REQUIRED** | File §107.31 waiver for research |
| §107.35 | Single Drone Rule | **WAIVER REQUIRED** | File §107.35 waiver for swarm |
| §107.37 | Right of Way | COMPLY | Check NOTAMs and airspace |
| §107.39 | Operations Over People | COMPLY (Category 1) | Maintain <250g, no exposed blades |
| §107.41 | Controlled Airspace | COMPLY | Fly Class G; use LAANC if needed |
| §107.49 | Preflight | COMPLY | Use Vol-20 checklist |
| §107.51(a) | 100 mph Speed Limit | COMPLY | Speed governor installed |
| §107.51(b) | 400 ft AGL Limit | **WAIVER REQUIRED** | File §107.51 waiver for research |
| §107.51(c) | Visibility | COMPLY | VFR conditions only |
| §107.51(d) | Cloud Clearance | COMPLY | Stay below cloud bases |
| Part 48 Registration | Aircraft Registration | **EXEMPT** (under 250g) | None if under 249g |
| Part 89 Remote ID | Remote ID broadcast | **EXEMPT** (under threshold) | None if under 249g |

---

## Part 5: Aeronautical Research Pathway — §89.120

A powerful regulatory tool that most university drone projects never use is **14 CFR §89.120**, which exempts aircraft operating for aeronautical research from Remote ID requirements. Specifically:

> "Operations for the purpose of aeronautical research or to show compliance with regulations."

If the ASB-1 is formally designated as an aeronautical research device collecting wind profile data for publication or academic reporting, it qualifies under this section. This provides:

1. Exemption from Remote ID (secondary to weight exemption)
2. Stronger justification in waiver applications for BVLOS and altitude waivers
3. Better standing with FAA when unusual flight profiles are proposed

**Action:** Have Cypress University formally designate the ASB-1 project as an aeronautical research program. A department chair or professor letter is sufficient.

---

## CHECKPOINT — Vol-01 Complete

Before moving to Vol-02, confirm:
- [ ] You understand that Part 107 applies to all research/educational UAS operations
- [ ] You have noted that the Part 107 knowledge test is your first required action
- [ ] You understand the 249g exemption from registration and Remote ID
- [ ] You have identified the 3 waivers needed: §107.31, §107.35, §107.51(b)
- [ ] You understand the Category 1 over-people eligibility pathway (177g, no exposed blades)
- [ ] You understand the §89.120 aeronautical research designation advantage

**Proceed to:** Vol-02 (Waiver Applications) or Vol-03 (Aerodynamics Science)

---

*CSMFAB000000000114-Vol-01 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
