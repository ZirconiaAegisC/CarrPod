
# CORPORATE PROFILE: A.P. MØLLER — MÆRSK A/S
## ACS-MAERSK-CONTAINER-FLEET-PROTECTION

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE | RESEARCH COMPLETED: JULY 2026**

---

## 1. COMPANY OVERVIEW

**Legal Name:** A.P. Møller — Mærsk A/S
**Founded:** 1904 (by Arnold Peter Møller and his father Peter Mærsk Møller)
**Headquarters:** Copenhagen, Denmark
**Ticker:** MAERSK-B.CO (Nasdaq Copenhagen)
**Fiscal Year 2025 Revenue:** ~$54 billion (estimated)
**Fleet Size:** 700+ owned and chartered container vessels
**Container Capacity:** 4.1+ million TEU
**Employees:** ~100,000
**Global Port Network:** 65+ terminals in 40+ countries (APM Terminals)

## 2. EXECUTIVE LEADERSHIP

**Vincent Clerc — Chief Executive Officer.** Appointed January 2023, succeeding Søren Skou. Previously CEO of Ocean & Logistics (Maersk's core business). 25-year Maersk veteran. Led the transformation from a pure shipping company to an integrated logistics provider. Educational background in mechanical engineering from Technical University of Denmark. Technical depth that appreciates physical infrastructure risks.

**Patrick Jany — Chief Financial Officer.** Appointed January 2023. Previously CFO of Clariant AG and Member of the Management Board at Lanxess AG. European industrial finance background with understanding of long-cycle capital investment in physical assets.

**Navneet Kapoor — Executive Vice President, Chief Technology and Information Officer.** Joined Maersk 2005. Oversees all technology including fleet IT systems, vessel bridge electronics standards, and port automation. 20+ years at Maersk. Primary technical stakeholder for vessel electronics hardening.

**Rabab Raafat Boulos — Executive Vice President, Chief Operating Officer.** Oversees fleet operations, port operations, and logistics integration. Operational authority over vessel deployment and safety protocols.

## 3. FLEET ANALYSIS — GIC VULNERABILITY

### 3.1 Vessel Classes and Electrical Profiles

**Triple-E Class (31 vessels, 18,000-20,568 TEU):**
- Length: 399-400 meters — among the longest vessels afloat
- Hull surface area: ~22,000 m² wetted surface in seawater
- Electrical generation: 5 x 5 MW diesel generators + shaft generators
- Bridge electronics: Fully integrated navigation system (Furuno/Transas INS), dual ECDIS, X/S-band radar, DP-capable
- GIC Risk: Very High. Maximum hull length creates largest conductor path through disturbed magnetic field. Highest-value cargo per vessel ($200-500M).

**H-Class/M-Class (20+ vessels, 15,000-18,000 TEU):**
- Similar electrical architecture to Triple-E. Slightly smaller hull = slightly lower GIC coupling but still in maximum risk category.

**E-Class (8 vessels, 15,500 TEU):**
- Original Emma Maersk design. Older bridge electronics (2006-2008 vintage), less integrated than Triple-E — paradoxically more resilient to GIC because simpler. But older power systems have less internal protection.

**ICE-Class Vessels (Baltic/Arctic routes):**
- Operate at higher geomagnetic latitudes (55-75 degrees) where GIC coupling is strongest. Hull reinforcement for ice adds electrical continuity (more welding, more structural steel in contact with seawater).

**Feeder and Regional Vessels (200+, 2,000-10,000 TEU):**
- Lower per-vessel risk due to smaller hull dimensions. Standardization benefit: one HPMS design fits most vessels in this class.

### 3.2 Key Trade Routes — Geomagnetic Risk

| Route | Geomagnetic Latitude | GIC Risk | Maersk Ships on Route |
|-------|---------------------|----------|----------------------|
| Asia-Europe (Suez) | 5°N-50°N | High in N. Atlantic, Mediterranean | 120+ |
| Transpacific | 25°N-55°N | Moderate-High in N. Pacific | 100+ |
| Transatlantic | 25°N-60°N | Highest GIC risk zone | 80+ |
| Asia-Middle East | 10°N-30°N | Low-Moderate | 60+ |
| Latin America | 10°S-40°S | Low (Southern hemisphere GIC weaker) | 50+ |
| Baltic/Arctic | 55°N-75°N | Extreme GIC risk | 15+ |

### 3.3 Port Infrastructure Vulnerability

APM Terminals operates automated container terminals using electrically-driven cranes (Ship-to-Shore gantry cranes: 5-25 MW each), automated stacking cranes, and autonomous guided vehicles. A single modern terminal can draw 50-100 MW. Terminal operating systems (Navis TOS, proprietary Maersk systems) run on local data center infrastructure. During a GMD event, port power quality degradation can disable crane PLCs and terminal operating systems, halting all cargo movement and creating a backlog that takes weeks to clear.

## 4. REGULATORY AND SAFETY CONTEXT

**SOLAS Chapter V — Safety of Navigation:** Requires vessels to maintain navigational equipment including radar, ECDIS, GPS, and AIS. A GMD event that disables these systems creates a regulatory compliance crisis for any vessel underway.

**ISM Code (International Safety Management):** Requires ship operators to identify and mitigate risks to safety and the environment. GMD/GIC risk is currently not required to be assessed under ISM — but a post-event investigation would likely find this to be a failure of the SMS (Safety Management System) to identify foreseeable risks.

**Danish Maritime Authority:** Maersk's flag state regulator. Denmark's maritime safety framework would be the jurisdictional authority for any GMD-related vessel incident involving Danish-flagged Maersk ships.

---

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE**
