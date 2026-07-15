# Seismic Resilience Framework for Bridge Fleet Protection

---

## Document Control

| Field | Value |
|-------|-------|
| Document ID | ACS-TLBFP-TF-02 |
| Revision | 1.0 |
| Classification | Engineering Technical Framework |
| Date | July 2026 |
| Prepared For | ACS-TyLynn Bridge Fleet Protection Program |

---

## Executive Summary

The San Francisco Bay Area's bridge fleet operates in one of the world's most seismically active regions, with the Hayward, San Andreas, and Calaveras fault systems each capable of producing magnitude 7.0+ events affecting multiple structures simultaneously. This framework integrates the seismic retrofit methodologies pioneered by TYLin International during the $9 billion Toll Bridge Seismic Retrofit Program (1997–2019) with contemporary corrosion protection strategies, recognizing that the operational necessity of opening bridge structures for seismic work creates a unique opportunity to apply duplex coating systems that will protect the retrofit investment for the structure's extended service life. The document draws upon TYLin's direct engineering heritage — including the development of shear link beams for the Bay Bridge SAS tower, hinge pipe beam energy dissipation technology, and the self-anchored suspension design for the Bay Bridge East Span — to establish a resilience taxonomy applicable across the remaining fleet.

---

## Section 1: Seismic Context and Vulnerability

### 1.1 Fault System Characterization

The Bay Area bridge fleet lies within 15 kilometers of at least one of the three major strike-slip fault systems capable of generating large-magnitude earthquakes:

| Fault System | Maximum Credible Earthquake (Mw) | Recurrence Interval (years) | Last Major Rupture |
|-------------|----------------------------------|----------------------------|-------------------|
| San Andreas (Peninsula segment) | 7.9 | 200–300 | 1906 |
| Hayward-Rodgers Creek | 7.3 | 140–180 | 1868 |
| Calaveras | 7.0 | 250–400 | 1911 (partial), 1984 (Morgan Hill, M6.2) |

Ground motion prediction equations (GMPEs) developed by the USGS National Seismic Hazard Model indicate that Bay Area bridge sites can experience peak ground accelerations (PGA) of 0.4g to 0.8g for a 975-year return period event, with spectral accelerations at 1.0-second period (Sa₁) ranging from 0.6g to 1.2g at soft soil sites. The soft bay mud deposits underlying the eastern shoreline substantially amplify long-period ground motions through basin-edge effects, producing near-field velocity pulses that are particularly damaging to long-period bridge structures with fundamental periods of 2 to 5 seconds.

### 1.2 Loma Prieta as Catalyst

The 1989 Loma Prieta earthquake (Mw 6.9) caused the catastrophic collapse of a 50-foot section of the Bay Bridge's East Span upper deck and the partial collapse of the Cypress Street Viaduct (I-880) in Oakland, resulting in 42 of the 63 earthquake-related fatalities in the region. The event exposed critical vulnerabilities in the Bay Area's transportation infrastructure that had been identified in theoretical terms but not yet addressed through capital investment:

- **Insufficient seat widths** at expansion joints, which failed to accommodate relative displacements exceeding 150 mm at the Bay Bridge E9 pier.
- **Non-ductile detailing** of reinforced concrete pier columns, which exhibited brittle shear failures rather than the ductile flexural yielding assumed in contemporary capacity design.
- **Liquefaction-induced settlement** of approach fills and shallow foundations on saturated alluvial deposits.
- **Lack of continuity** between adjacent bridge spans, permitting unseating when bearing supports failed under combined vertical and lateral loading.

TYLin International (then T.Y. Lin International) played a central role in the post-Loma Prieta forensic assessment, developing new nonlinear analysis techniques and contributing to the Caltrans Seismic Design Criteria that were fundamentally rewritten between 1990 and 1995. This body of work established the performance-based design philosophy — specifying operational, life-safety, and collapse-prevention performance levels for design earthquakes at varying return periods — that has since been adopted internationally.

---

## Section 2: The Toll Bridge Seismic Retrofit Program (1997–2019)

### 2.1 Program Scope and Investment

The California Toll Bridge Seismic Retrofit Program, authorized by Senate Bill 60 (1997) and subsequently funded through successive legislative appropriations and toll revenue bond issuances, represented one of the largest concentrated seismic infrastructure investments in United States history. Total program expenditure reached approximately $9 billion (2020 dollars) across seven toll bridges, encompassing:

- **San Francisco–Oakland Bay Bridge East Span**: Complete replacement of the seismically vulnerable 1936 steel truss structure with a 2.0-mile segmental concrete skyway and the 1,263-foot self-anchored suspension main span ($6.4 billion).
- **San Francisco–Oakland Bay Bridge West Span**: Retrofit of the 1936 suspension bridge, including tower strengthening, expansion joint replacement with seismic isolation bearings, and anchorage housing reinforcement ($850 million).
- **Richmond–San Rafael Bridge**: Retrofit of the 5.5-mile double-deck cantilever truss bridge, including seismic isolation bearings at all piers, longitudinal restrainers, and approach viaduct column jacketing ($1.0 billion).
- **Benicia–Martinez Bridge**: Retrofit of the 1.2-mile continuous truss with foundation strengthening via large-diameter drilled shafts, isolation bearings, and steel truss member reinforcement ($250 million).
- **Carquinez Bridge**: Replacement of the 1927 steel truss with a new suspension bridge ($400 million).
- **San Mateo–Hayward Bridge**: Retrofit of the 7-mile trestle and high-rise section with isolation bearings, column jacketing, and foundation strengthening ($200 million).
- **Antioch Bridge**: Retrofit with isolation bearings and column jacketing ($75 million).

### 2.2 TYLin Engineering Innovations

#### 2.2.1 Shear Link Beams — Bay Bridge SAS Tower

The self-anchored suspension (SAS) tower of the Bay Bridge East Span incorporates TYLin-designed shear link beams as the primary energy dissipation mechanism within the tower's four shafts. Each shaft comprises four steel box columns interconnected at intervals by steel box beams designed to yield in shear under seismic loading before the columns develop plastic hinging. This configuration achieves:

- **Controlled hysteretic energy dissipation**: The shear links undergo repeated cyclic yielding during a major earthquake, converting seismic input energy into plastic strain energy within replaceable structural elements rather than within the primary load-carrying columns.
- **Repairability**: Post-earthquake damage is concentrated in the shear links, which can be unbolted and replaced without requiring tower decommissioning or structural steel repair to the main columns.
- **Stiffness compatibility**: The shear link dimensions and spacing are tuned to shift the tower's fundamental period away from the dominant spectral acceleration peaks of the site-specific design spectrum, reducing the inertial force demand on the tower foundation system.

This design concept was validated through full-scale cyclic testing at the University of California, San Diego, Powell Structural Engineering Laboratories, with shear link specimens achieving cumulative plastic rotation capacities exceeding 0.12 radians before fracture — substantially exceeding the 0.08 radian target specified in AISC 341 for high-seismic applications.

#### 2.2.2 Hinge Pipe Beam Energy Dissipators

TYLin developed the hinge pipe beam concept as a modular energy dissipation device for application at bridge expansion joints and between adjacent bridge frames. The device consists of a steel pipe section configured to undergo controlled plastic bending at a defined yield hinge location when subjected to relative displacements between adjacent structural elements. Key characteristics include:

- **Predictable force-displacement response**: The pipe diameter, wall thickness, and hinge location are selected to produce a defined elastic stiffness, yield force, and post-yield stiffness ratio calibrated through nonlinear finite element analysis.
- **Redundancy through array deployment**: Multiple hinge pipe beams are arranged in parallel at each joint location, ensuring that the failure of any single device (due to fabrication variability or unanticipated loading direction) does not compromise the overall energy dissipation capacity.
- **Replaceability**: The bolted end connections enable post-earthquake removal and replacement without structural demolition, analogous to the shear link beam philosophy applied at the member scale.

#### 2.2.3 Self-Anchored Suspension Design — East Span Main Span

The Bay Bridge East Span main span, at 1,263 feet (385 meters), is the world's longest single-tower self-anchored suspension span. The self-anchored configuration — in which the main suspension cables are anchored to the deck rather than to massive concrete anchorages at the shorelines — was selected by TYLin for this site specifically in response to seismic constraints:

- **Elimination of anchorage foundations in soft bay mud**: A conventional earth-anchored suspension design would have required massive gravity or pile-supported anchorages in 100+ feet of soft, liquefiable bay mud, creating differential settlement and seismic performance problems. The self-anchored configuration transfers cable forces into the deck system, which distributes the anchorage load along its full length.
- **Tuned mass damping through deck-cable interaction**: The coupled deck-cable-tower dynamic system distributes inertial forces during seismic excitation across multiple components rather than concentrating them at discrete anchorage points, reducing peak force demands on individual elements.
- **1,500-year design event**: The structure was designed to remain operational following a seismic event with a mean return period of 1,500 years — the most stringent performance criterion ever applied to a major bridge structure at the time of design — requiring a comprehensive nonlinear time-history analysis suite incorporating 20+ recorded and synthetic ground motion records scaled to the site-specific uniform hazard spectrum.

### 2.3 Seismic Technology Taxonomy

The retrofit program deployed the following technology categories systematically across the bridge fleet:

| Technology | Primary Function | Application Example | Performance Record |
|-----------|-----------------|-------------------|-------------------|
| Seismic Isolation Bearings (Lead-Rubber, Friction Pendulum) | Decouple superstructure from substructure motion; extend fundamental period beyond dominant spectral acceleration | Richmond–San Rafael: 300+ bearings installed at 76 piers | Operated through multiple moderate events (M4.5–5.5) without damage |
| Energy Dissipation Devices (Fluid Viscous Dampers, Metallic Yielding Dampers) | Absorb seismic energy through controlled inelastic deformation or fluid shear | Bay Bridge West Span: 96 fluid viscous dampers (Taylor Devices) installed at tower-deck connections | Force-velocity behavior validated in post-installation cyclic testing |
| Fiber-Reinforced Polymer (FRP) Wrapping | Confine reinforced concrete columns to increase ductility and prevent brittle shear failure | Richmond–San Rafael approach viaducts: 1,800 columns wrapped with carbon FRP | Confinement efficiency of 85–95% demonstrated in extracted core testing |
| Concrete and Steel Jacketing | Add confinement, shear capacity, and flexural strength to existing columns | Benicia–Martinez: elliptical steel jackets on 60+ bridge piers | No jacket distress observed in 20+ years of post-retrofit monitoring |
| Foundation Strengthening (Drilled Shafts, Micropiles) | Increase foundation capacity and reduce liquefaction-induced settlement | Carquinez Bridge replacement: 3.0 m diameter drilled shafts extending to bedrock at 60–80 m depth | Settlement less than 10 mm under full design loading |
| Longitudinal Restrainers (Cable, Rod, or Bumper Systems) | Prevent span unseating at expansion joints | All seven toll bridges: cable restrainers at every expansion joint | Function verified in nonlinear time-history analyses across 7 synthetic ground motion suites |

---

## Section 3: Current Fleet Vulnerability Assessment

### 3.1 Residual Risk After Retrofit Program

While the Toll Bridge Seismic Retrofit Program addressed the most critical vulnerabilities identified after Loma Prieta, residual seismic risk remains across several categories:

1. **Aging retrofit components**: Isolation bearings installed between 1998 and 2005 are now 18 to 25 years into their design service life of 50 years. Systematic condition assessment — including bearing shear stiffness measurement, lead core confinement verification, and elastomer ozone-cracking inspection — has not been performed at uniform intervals across the fleet.

2. **Substandard ground motion characterization**: The 1997–2005 design ground motions, while state-of-the-art at the time, preceded significant advances in near-fault ground motion characterization. Current USGS hazard models incorporate directivity effects and basin amplification factors that can increase spectral demands at long periods by 20% to 40% relative to the design basis motions used for the original retrofit designs.

3. **Liquefaction reassessment**: Updated subsurface investigations and CPT-based liquefaction triggering correlations (Boulanger and Idriss, 2014) may indicate higher liquefaction potential and volumetric strain than assumed in the retrofit designs for specific approach embankments and shallow-founded piers.

4. **Corrosion-induced capacity degradation**: In the 20+ years since retrofit completion, corrosion of structural steel elements — particularly at bearing seats, expansion joints, and anchorage zones — may have reduced the cross-sectional area and fatigue resistance of components whose seismic performance is predicated on full-section properties.

### 3.2 Priority Structures

Based on a weighted scoring matrix incorporating seismic hazard, structural vulnerability, traffic volume, economic criticality, and condition assessment data, the following structures warrant highest priority for seismic reassessment and potential re-retrofit:

1. **Richmond–San Rafael Bridge**: The cantilever truss configuration concentrates seismic demands at the truss pin connections — precisely the locations most susceptible to corrosion-induced section loss. The main span pier bearings, while isolated, depend on the truss chords for load path continuity.

2. **Benicia–Martinez Bridge**: The 1930 continuous truss, retrofitted with isolation bearings and member strengthening circa 2000, crosses a deep-water channel with thick soft clay deposits that amplify long-period ground motion. Foundation performance under updated hazard levels requires reassessment.

3. **San Mateo–Hayward Bridge**: The 7-mile trestle approach spans, supported on precast prestressed concrete piles driven into bay mud, are vulnerable to liquefaction-induced lateral spreading at the shoreline transitions. The current CIP concrete repair program ($163 million) addresses visible distress but does not include a complete seismic reassessment.

---

## Section 4: Integrated Seismic and Corrosion Protection Strategy

### 4.1 The Dual-Purpose Intervention Opportunity

The principal strategic insight connecting this seismic resilience framework to the corrosion protection framework (Document ACS-TLBFP-TF-01) is the operational and economic synergy achieved when bridge structures already opened for seismic retrofit work simultaneously receive duplex corrosion protection:

- **Scaffolding and access represent 30–50% of the total project cost** for either seismic retrofit or coating work independently. A combined scope amortizes these fixed access costs across both work packages.
- **Containment for abrasive blasting** during coating operations requires the same type of full-enclosure systems (negative-pressure ventilation, particulate filtration, stormwater management) that are deployed for seismic retrofit work involving steel cutting, welding, and concrete demolition. Combining the scopes eliminates duplicate containment mobilization and demobilization.
- **Traffic control and lane closure coordination** with the California Highway Patrol and regional transportation management agencies represents a significant scheduling constraint and public communication challenge. A single coordinated closure period for combined seismic and coating work reduces cumulative traffic disruption relative to two separate construction campaigns.

### 4.2 Speculative Integration: Open Seismic, Apply Duplex

For each bridge scheduled for seismic evaluation or retrofit in the current and next CIP cycles:

| Bridge | Next Seismic Window | Recommended Coating Integration |
|--------|-------------------|-------------------------------|
| Carquinez Bridge | FY27/28 (coating project) | Apply TSZ duplex to all accessible steel within scaffolding envelope; seismic reassessment of truss connections concurrent with surface preparation |
| San Mateo–Hayward | Phase 1 (FY24/25), Phase 2 (FY28/29) concrete repair | Install TSZ ICCP anodes on all concrete repair zones; extend CP coverage to adjacent chloride-contaminated areas while scaffolding is erected |
| SF–Oakland West Span | FY24/25 paint project | Apply TSZ duplex to tower exterior, stiffening truss, and cable band zones; incorporate seismic instrumentation (accelerometers, displacement transducers) for long-term structural health monitoring |
| Richmond–San Rafael | Post-2028 seismic reassessment recommended | Coordinate full-structure TSZ duplex application with any seismic strengthening work, exploiting the scaffolding amortization economics described in Section 4.1 |

### 4.3 Structural Health Monitoring Integration

The intersection of seismic resilience and corrosion protection creates an opportunity for instrumented structural health monitoring (SHM) that serves both domains:

- **Accelerometers and GPS/GNSS receivers** installed during seismic retrofit provide real-time post-earthquake condition assessment, enabling rapid determination of whether the structure can remain open to emergency traffic.
- **Corrosion potential mapping electrodes** embedded in concrete during ICCP anode installation provide continuous electrochemical condition data that informs both protection current adjustment and structural capacity degradation forecasting.
- **Strain gauges at retrofit connections** (shear links, damper brackets, bearing interfaces) provide direct performance verification during moderate seismic events (M4–5), generating empirical data to validate or refine the nonlinear analysis models used for design.

Degradation forecasting frameworks that combine seismic demand projections with corrosion-induced capacity reduction rates enable the development of time-dependent fragility curves — a methodology that directly informs capital planning by projecting the year at which a bridge's seismic performance drops below the operational or life-safety threshold.

---

## Section 5: Conclusion and Forward Path

The Bay Area bridge fleet has been seismically hardened through a $9 billion investment program representing the engineering community's best response to the vulnerabilities exposed by the 1989 Loma Prieta earthquake. The retrofit technologies — isolation bearings, energy dissipation devices, FRP confinement, and foundation strengthening — have established performance records spanning two decades of moderate seismic events without structural damage, validating the design philosophy.

However, the fleet's advancing age, the progressive deterioration of steel and concrete from the aggressive C4-C5 marine environment, and the escalation of ground motion characterization beyond the original design basis collectively argue for a proactive reassessment program. The confluence of BATA's current $500 million CIP coating program with the residual seismic vulnerabilities identified in this framework creates a strategic window — one in which coordinated seismic and corrosion interventions achieve economies of scale in access, containment, and traffic management that cannot be replicated if the work is performed sequentially.

TYLin International's direct engineering heritage — from the development of shear link beams and hinge pipe beam dissipators to the design of the world's longest self-anchored suspension span at the Bay Bridge East Span — positions the organization uniquely to lead this integrated assessment and to translate the empirical performance data from the retrofit program into a forward-looking resilience strategy for the next 50 years of bridge fleet operation.

---

## References

1. Caltrans. "Seismic Design Criteria Version 2.0." California Department of Transportation, 2019.
2. T.Y. Lin International / Moffatt & Nichol Joint Venture. "San Francisco–Oakland Bay Bridge East Span — Design Criteria and Basis of Design." 2002.
3. Astaneh-Asl, A., and Shen, J.H. "Seismic Behavior and Design of Shear Link Beams for the New Bay Bridge." *Journal of Structural Engineering*, ASCE, Vol. 134, No. 12, 2008.
4. Boulanger, R.W., and Idriss, I.M. "CPT and SPT Based Liquefaction Triggering Procedures." Center for Geotechnical Modeling, UC Davis, Report UCD/CGM-14/01, 2014.
5. Bay Area Toll Authority. "Toll Bridge Seismic Retrofit Program — Completion Report." Metropolitan Transportation Commission, 2020.
6. Taylor Devices, Inc. "Fluid Viscous Dampers for Seismic Energy Dissipation — Bay Bridge West Span Application." Technical Report, 2004.
7. University of California, San Diego. "Full-Scale Cyclic Testing of Shear Link Beams for the San Francisco–Oakland Bay Bridge Self-Anchored Suspension Tower." Powell Laboratories Report TR-2003/06, 2003.
8. United States Geological Survey. "National Seismic Hazard Model — 2023 Update." USGS, 2023.
9. AISC 341-22. "Seismic Provisions for Structural Steel Buildings." American Institute of Steel Construction, 2022.
10. FHWA. "Seismic Retrofitting Manual for Highway Structures: Part 1 — Bridges." FHWA-HRT-06-032, 2006.
