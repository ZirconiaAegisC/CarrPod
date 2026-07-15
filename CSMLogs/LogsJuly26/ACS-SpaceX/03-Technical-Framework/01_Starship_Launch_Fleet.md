# Framework 1: Starship and Launch Services

**Classification:** ACS Proprietary — Technical Framework
**Domain:** Launch Architecture, Vehicle Engineering, Operations

---

## 3.1 Starship/Super Heavy System Architecture

### 3.1.1 Vehicle Overview

Starship and Super Heavy constitute the first fully reusable two-stage super-heavy-lift launch system ever developed. The combined stack stands approximately 121 meters tall and produces 7,590 metric tons of thrust at liftoff across 33 Raptor 3 engines on the Super Heavy booster and 6 Raptor 3 engines (3 sea-level, 3 vacuum-optimized) on the Starship upper stage.

| Parameter | Super Heavy (Booster) | Starship (Upper Stage) |
|---|---|---|
| Height | 69 m | 52 m |
| Diameter | 9 m | 9 m |
| Propellant Mass | ~3,400 t | ~1,200 t |
| Engines | 33 × Raptor 3 | 3 × Raptor 3 SL + 3 × Raptor 3 Vac |
| Thrust (Total) | ~7,590 t | ~1,500 t |
| Propellant | LCH4/LOX | LCH4/LOX |

### 3.1.2 Raptor 3 Engine

The Raptor 3 represents the third major iteration of SpaceX's full-flow staged-combustion methalox engine. Key advancements over Raptor 2 include simplified manufacturing, elimination of external heat shielding through integrated regenerative cooling channels, reduced part count, and increased chamber pressure. Each Raptor 3 produces approximately 230 metric tons of thrust at sea level, with vacuum variants achieving 258 metric tons through an optimized nozzle expansion ratio.

### 3.1.3 Payload Performance

- **100 metric tons to Low Earth Orbit (LEO)** in fully reusable configuration (both stages recovered)
- **>200 metric tons to LEO** in expendable upper-stage configuration
- **21 metric tons to Geostationary Transfer Orbit (GTO)** with full reuse
- In-orbit refueling enables deep-space and lunar/interplanetary missions

## 3.2 Flight Test Program

### 3.2.1 Integrated Test Campaign

As of July 2026, SpaceX has completed 12 integrated Starship/Super Heavy test flights from Starbase, Texas. Each flight has progressively demonstrated additional capabilities:

| Flight | Date | Key Objectives | Outcome |
|---|---|---|---|
| IFT-1 | Apr 2023 | Stage separation, ascent | Partial success |
| IFT-2 | Nov 2023 | Hot staging, improved ascent | Partial success |
| IFT-3 | Mar 2024 | Payload door, prop transfer demo | Data collected |
| IFT-4 | Jun 2024 | Controlled reentry, landing burn | Booster splashdown achieved |
| IFT-5 | Oct 2024 | Booster catch at tower | Successful catch |
| IFT-6 | Nov 2024 | Ship reentry and splashdown | Successful |
| IFT-7 | Jan 2025 | Starlink mass simulator deploy | Vehicle loss (anomaly) |
| IFT-8 | Mar 2025 | Extended duration, prop transfer | Partial |
| IFT-9 | May 2025 | Booster re-catch, ship relight | Booster catch successful |
| IFT-10 | Aug 2025 | Full ship recovery test | Ship caught at tower |
| IFT-11 | Nov 2025 | Starlink payload simulator | Successful deploy simulation |
| IFT-12 | Mar 2026 | Full reuse demonstration | Booster + Ship re-flown |
| **IFT-13** | **Jul 16, 2026** | **First live Starlink deployment** | **Planned** |

### 3.2.2 Flight 13 Significance (July 16, 2026)

IFT-13 represents the first operational Starlink payload deployment from Starship, carrying a complement of V3 satellites into LEO. This marks the transition from experimental flight testing to revenue-generating commercial operations for the Starship platform. The flight deploys Starlink V3 satellites with a combined downlink capacity exceeding 60 Tbps — equivalent to approximately 1,200 V1.5 satellites, which previously required 20 Falcon 9 launches to achieve.

## 3.3 Falcon 9 and Falcon Heavy: Operational Cadence

### 3.3.1 Falcon 9

The Falcon 9 remains the workhorse of the global launch industry, having achieved the following milestones:

- **500+ total flights** as of early 2026
- **29 reuses** demonstrated on a single booster (B1062)
- **600th flight-proven booster** milestone crossed
- **165 launches** in FY2025 (6th consecutive annual record)
- Average turnaround: **<21 days** per booster
- Cumulative payload delivered to orbit: **>2,600 metric tons**

### 3.3.2 Transition Planning

SpaceX has stated that Falcon 9 and Falcon Heavy will remain in service through at least 2028, with the transition to Starship occurring gradually as reliability is proven and NASA/NSSL certification is achieved. The overlap period enables risk-managed migration of Starlink launches and commercial payloads.

### 3.3.3 Falcon Heavy

Falcon Heavy serves niche high-energy missions (direct GEO insertion, interplanetary, and classified national security payloads) at a premium over Falcon 9. The vehicle has flown 12 missions through mid-2026, including NASA's Europa Clipper and Psyche missions, as well as multiple NSSL payloads.

## 3.4 Launch Infrastructure

### 3.4.1 Active Pads

| Pad | Location | Vehicle(s) | Annual Capacity |
|---|---|---|---|
| SLC-40 | Cape Canaveral SFS | Falcon 9 | ~100 |
| LC-39A | Kennedy Space Center | Falcon 9, Falcon Heavy, Starship (future) | ~50 |
| SLC-4E | Vandenberg SFB | Falcon 9 (polar/SSO) | ~40 |
| Starbase OLM | Boca Chica, TX | Starship/Super Heavy | ~10 (growing) |

### 3.4.2 Future Infrastructure

SpaceX is constructing a second Starship launch tower at LC-39A and has initiated environmental review for Starship operations from SLC-37 at Cape Canaveral SFS. A floating launch and landing platform concept remains in design studies for equatorial and high-inclination orbits.

## 3.5 Reusability Economics

Falcon 9 reusability has demonstrated that first-stage recovery reduces per-launch cost by approximately 60-70% versus expendable mode. At a cadence of 165 launches per year, the cumulative savings versus an all-expendable manifest exceed $4 billion annually. Starship's full-stack reusability extends this economic model to the second stage — a capability no other launch system has demonstrated — and is projected to drive marginal launch cost below $10 million for high-cadence Starlink deployment missions.

## 3.6 Competitive Launch Market

| Provider | Vehicle | Payload to LEO | Reusability | 2025 Launches |
|---|---|---|---|---|
| SpaceX | Falcon 9 | 22.8 t | Partial (1st stage) | 165 |
| SpaceX | Starship | 100 t | Full | 3 (test) |
| ULA | Vulcan Centaur | 27.2 t | Engine recovery (planned) | 5 |
| Arianespace | Ariane 6 | 21.6 t | None | 2 |
| Roscosmos | Soyuz-2 | 8.2 t | None | 12 |
| CNSA | Long March 5B | 25 t | None | 4 |
| LandSpace | Zhuque-3 | ~20 t | Planned (1st stage) | 1 |
| Rocket Lab | Neutron | 13 t | Partial (1st stage) | Development |

---

*Technical specifications derived from SpaceX public filings, FAA environmental assessments, FCC applications, and observed flight data.*
