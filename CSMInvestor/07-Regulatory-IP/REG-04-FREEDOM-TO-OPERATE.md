# REG-04: FREEDOM-TO-OPERATE ANALYSIS

**Document Classification:** Attorney-Client Privileged / Attorney Work Product — CONFIDENTIAL
**Date:** July 15, 2026
**Prepared by:** Rook (Security Director), Viktor Kael (Regulatory Affairs Director), with external IP counsel consultation (pending formal engagement)
**Document Ref:** CSM-REG-04-v1.0

---

## I. EXECUTIVE SUMMARY

A freedom-to-operate (FTO) analysis examines whether a product or process can be commercialized without infringing valid intellectual property rights of third parties. This document presents the FTO analysis for Carrington Storm Motors' five major product lines and identifies areas of risk, design-around strategies, licensing-in opportunities, and the need for formal legal opinions.

Key finding: CSM has freedom to operate in its core materials science domain, with manageable infringement risks in specific technology sub-areas. No single patent or patent family identified to date presents a blocking risk that cannot be addressed through design-around, licensing, or validity challenge. Formal FTO opinion letters from qualified IP counsel are recommended for the 12 highest-priority products before commercial launch.

---

## II. PRIOR ART SEARCH METHODOLOGY

### A. Search Strategy

Our FTO searches were conducted using the following methodology:

1. **Patent Database Search:**
   - USPTO Patent Full-Text and Image Database (PatFT/AppFT)
   - European Patent Office Espacenet
   - WIPO Patentscope (PCT applications)
   - Google Patents (for initial broad screening)
   - Commercial databases: Derwent Innovation and PatSnap (subscription access for full landscape analysis)

2. **Search Parameters:**
   - Keywords covering: MXene, MAX phase, exfoliation, electromagnetic shielding, EMI, EMP, HEMP, geomagnetic, GIC, dielectric, ceramic matrix composite, geopolymer, YInMn, thermochromic, amphibious vehicle, protonic communication
   - IPC/CPC classifications: H05K 9/00 (EMI shielding), C04B 35/00 (ceramics), C01B 32/00 (carbon nanomaterials), B63B (ships/vessels), B62D 57/00 (vehicles with non-conventional propulsion/ground contact)
   - Assignee searches: Drexel University, Murata Manufacturing, Samsung, 3M, Boeing, GE, Siemens, ABB, Northrop Grumman, Raytheon, Lockheed Martin

3. **Non-Patent Literature Search:**
   - Google Scholar, Web of Science for academic publications that may constitute prior art or signal competing R&D
   - Industry standards documents (IEEE, IEC, NIST) for embedded IP
   - Conference proceedings (MRS, ACS, IEEE PES, CIGRE)

4. **Search Date Range:** 2000-2026 (with specific attention to 2011-2026 for MXene-related art, given the 2011 discovery date)

### B. Limitations and Caveats

This analysis is preliminary and based on searches conducted by CSM's internal team. It does not constitute a formal legal opinion. The following limitations apply:

- Patent applications filed within the last 18 months may not yet be published (US provisional applications, non-provisional applications in their pre-publication secrecy period). There may be pending applications of which we are unaware.
- Patent claims are interpreted by courts, not by databases. The scope of a patent is determined by its claims as construed under applicable law. Our initial screening is based on the claims as written; a formal FTO opinion requires claim construction analysis by qualified counsel.
- The landscape changes continuously. A search conducted in July 2026 is a snapshot. Ongoing monitoring is required.

---

## III. KEY THIRD-PARTY PATENTS BY PRODUCT LINE

### A. MXene Compositions and Synthesis

**Patent: US 9,418,498 B2 — "Two-dimensional, ordered, two-dimensionally corrugated transition metal carbides and nitrides"**
- Assignee: Drexel University
- Priority Date: April 12, 2012
- Expiration (estimated): ~2033
- Key Claims: MXene compositions generically defined as M(n+1)X(n)T(x) where M is a transition metal, X is carbon and/or nitrogen, T is a surface termination group. Also claims methods of making MXenes by etching MAX phase precursors.
- FTO Assessment: This patent covers MXenes broadly. However, our MXene-polymer composite is a composition that includes MXene as one component within a polymer matrix — a distinct article of manufacture. Our composite is not the MXene itself but a downstream product that incorporates MXene. The Drexel patent does not claim polymer composites. **Risk: Low-Medium.** We are not practicing the claimed invention (we are buying/using MXene as a component, not manufacturing MXene per the claimed method). However, if we synthesize MXene in-house (as planned for our pilot plant), the method claims are directly relevant. **Design-Around:** Use third-party-sourced MXene while our in-house method patent (A-2, continuous-flow exfoliation) is pending and differentiates from the Drexel method.

**Patent: US 10,217,569 B2 — "Electromagnetic interference shielding comprising MXene"**
- Assignee: Drexel University
- Priority Date: April 3, 2017
- Expiration (estimated): ~2038
- Key Claims: EMI shielding articles comprising a substrate and a coating of MXene. The coating provides at least 20 dB shielding effectiveness.
- FTO Assessment: This patent claims MXene as an EMI shielding coating applied to a substrate. Our MXene-polymer composite is fundamentally different: the MXene is embedded within the polymer matrix in bulk, not applied as a surface coating. In the composite, the MXene is distributed throughout the material, not layered on top. **Risk: Low.** We are not applying MXene as a coating on a substrate; we are incorporating it into a bulk composite material. The claimed EMI shielding mechanism is different (absorption through thickness vs. reflection from a surface coating). Formal FTO opinion recommended to confirm this distinction.

**Patent: US 11,203,815 B2 — "Method for producing two-dimensional materials by electrochemical etching"**
- Assignee: Various (multiple academic institutions)
- Priority Date: 2018
- Key Claims: Electrochemical etching method for producing 2D materials including MXenes.
- FTO Assessment: Our continuous-flow exfoliation method (A-2) uses chemical etching (HF-based) combined with ultrasonic delamination, not electrochemical etching. **Risk: Low.** Different process chemistry.

---

### B. Ceramic Matrix Composites

**Patent: US 8,309,644 B2 — "Ceramic composite with integrated compliance layer"**
- Assignee: The Boeing Company
- Priority Date: 2008
- Expiration (estimated): ~2028
- Key Claims: CMC with integrated compliance layer for turbine engine applications.
- FTO Assessment: Boeing's patents are directed to aerospace propulsion applications (turbine engine components operating at >1000°C). Our CMC transformer housing is in a different technical field (electrical infrastructure) and operates at ambient to 150°C — far below the temperature regimes claimed by Boeing. The material systems also differ (Boeing's claims specify SiC/SiC composites for high-temperature oxidation resistance; ours uses SiC/Al2O3 for electrical resistivity at moderate temperatures). **Risk: Low.** Different field of use, different material system, different operating conditions. Formal FTO opinion recommended.

**Patent: US 9,828,276 B2 — "Ceramic matrix composite turbine engine component"**
- Assignee: General Electric Company
- Priority Date: 2015
- Key Claims: CMC turbine engine component with specific cooling channel geometry.
- FTO Assessment: Similar analysis to Boeing — field of use distinction is strong. GE's patents are directed solely to turbine engine applications. Our transformer housing is not a turbine component. **Risk: Low.**

**Patent: US 10,308,576 B2 — "Method for manufacturing ceramic matrix composite structures"**
- Assignee: Rolls-Royce Corporation
- Priority Date: 2016
- Key Claims: Method for manufacturing CMC structures using chemical vapor infiltration with specific parameter ranges.
- FTO Assessment: The CVI process is well-established prior art (developed at ONERA in France and ORNL in the US in the 1970s-1980s). Rolls-Royce's method claims specify parameter ranges optimized for aerospace components. Our CVI parameters, while trade secret, are optimized for different outcomes (electrical resistivity rather than high-temperature strength) and likely fall outside the claimed parameter ranges. **Risk: Low.** However, if Rolls-Royce's patent is drafted broadly enough to cover any CVI process producing structural CMC, there is a medium risk. Detailed claim construction analysis needed.

---

### C. EMP/EMI Shielding

**Patent: US 6,324,075 B1 — "Electromagnetic interference shield"**
- Assignee: 3M Innovative Properties Company
- Priority Date: 1999
- Expiration: Expired (approximately 2019)
- Status: **EXPIRED.** No longer in force. This and several other foundational EMI shielding patents from the 1990s-early 2000s have expired, opening significant FTO space.

**Patent: US 8,928,328 B2 — "EMP-hardened electronic device"**
- Assignee: Raytheon Company
- Priority Date: 2010
- Expiration (estimated): ~2031
- Key Claims: Electronic device with conductive enclosure forming a Faraday cage around sensitive components, with specific filtering on all input/output lines.
- FTO Assessment: Our approach is fundamentally different from conductive enclosure (Faraday cage) methods. We do not enclose individual devices in conductive cages. We make the structural materials of the infrastructure itself non-conductive and EMI-absorptive, preventing GIC from ever reaching sensitive components. **Risk: Low.** Different technical approach. Our technology avoids the Faraday cage patent space entirely by solving the problem at the materials level rather than the enclosure level.

**Patent: US 9,204,567 B2 — "Electromagnetic pulse protection for electrical substations"**
- Assignee: ABB Technology Ltd.
- Priority Date: 2012
- Expiration (estimated): ~2033
- Key Claims: Substation protection system employing surge arresters and isolation transformers to block EMP-induced transients.
- FTO Assessment: ABB's patent covers active protection systems (surge arresters, isolation transformers). Our approach is passive and materials-based — we prevent GIC from entering the substation in the first place by replacing conductive structural materials with dielectric materials, rather than trying to arrest or isolate GIC after it has entered the system. **Risk: Low.** Different technical approach. However, there is overlap in the intended outcome (substation protection), so this patent warrants ongoing monitoring.

---

### D. Amphibious Vehicles

**Patent: US 8,096,252 B2 — "Amphibious vehicle"**
- Assignee: Gibbs Technologies Ltd.
- Priority Date: 2007
- Expiration (estimated): ~2027
- Key Claims: Amphibious vehicle with retractable wheels enabling both land and water operation.
- FTO Assessment: Gibbs' patents cover wheel-retraction mechanisms for amphibious automotive vehicles. Our Sentinel-Class is a walking vehicle, not a wheeled vehicle, and operates on a fundamentally different locomotion principle (quadrupedal walking vs. wheeled driving). **Risk: Low.**

**Patent: US 9,327,867 B2 — "Amphibious vehicle with deployable marine propulsion"**
- Assignee: Various
- Key Claims: Amphibious vehicles with propulsion systems that transition between land and water modes.
- FTO Assessment: Our Sentinel-Class walking mechanism is mechanically distinct from wheeled amphibious vehicles. However, the concept of an amphibious vehicle is well-known prior art dating back centuries (amphibious military vehicles since WWII). The FTO space for amphibious vehicles is defined by specific mechanism claims, not by the general category. We are designing our walking mechanism to be patentable on its own merits, which means by definition it is novel with respect to existing amphibious vehicle patents. **Risk: Low.**

---

### E. Thermochromic Materials (YInMn Blue)

**Patent: US 8,282,701 B2 — "YInMn Blue Pigment"**
- Assignee: Oregon State University (discovered by Dr. Mas Subramanian)
- Priority Date: 2009
- Expiration (estimated): ~2029
- Key Claims: YInMn Blue pigment with composition YIn(1-x)Mn(x)O(3), where 0 < x ≤ 0.5.
- FTO Assessment: Our YInMn Blue smart coating uses the base YInMn Blue pigment — which, importantly, we purchase from commercial suppliers rather than synthesize. The use of YInMn Blue pigment in a coating is a downstream application that is not claimed by the Oregon State patent (which claims the pigment composition itself). Our innovation is doping the pigment to create thermochromic behavior — a distinct invention that builds on but does not infringe the base pigment patent. **Risk: Low.** We are a purchaser and user of the pigment, not a manufacturer. If we synthesize YInMn Blue in-house (possible at scale), we would need a license from Oregon State or would rely on the patent's expiration in 2029. 

**Status of Oregon State Licensing:** We have not yet approached Oregon State's technology transfer office for a license. Our current approach (purchasing from commercial pigment suppliers who have their own licenses from Oregon State) avoids the need for a direct license. If we bring YInMn Blue synthesis in-house, we will negotiate a license.

---

## IV. DESIGN-AROUND STRATEGIES

### A. MXene Composition Patents (Drexel)

**Design-Around Strategy:**
1. Focus patent claims on the composite, not the MXene itself. The Drexel patents claim MXene as a composition of matter. Our products are composites that incorporate MXene. This distinction is legally significant and provides substantial FTO.
2. For in-house MXene synthesis: our continuous-flow exfoliation method (A-2) is differentiated from the Drexel batch method by the continuous-flow architecture, yield optimization, and specific process parameters. We will ensure our method claims are clearly distinct.
3. Alternative: license the Drexel MXene patent portfolio for grid-protection applications. Drexel's technology transfer office has established relationships with industrial partners. A field-of-use license for "electrical grid protection" could be negotiated. **Estimated licensing cost: $100-250K upfront + 2-4% royalty on MXene-containing products.**

### B. CMC Manufacturing Patents (Boeing, GE, Rolls-Royce)

**Design-Around Strategy:**
1. Field-of-use differentiation is our strongest FTO position. The existing CMC patent thicket is entirely in aerospace propulsion. Our field — electrical infrastructure — is not claimed by any existing patent identified in our searches.
2. If broad CMC manufacturing method claims are identified that could read on our process, we will modify our CVI parameters to fall clearly outside the claimed ranges. Our process optimization is for electrical resistivity, not high-temperature strength — a fundamentally different design space.
3. We will apply for our own CMC patents in the electrical infrastructure field, establishing our own IP position in this whitespace.

### C. EMP/EMI Shielding Patents (Various)

**Design-Around Strategy:**
1. Our materials-science-based approach is inherently differentiated from the enclosure/cage/filter approach taken by existing EMP shielding patents. This is the strongest FTO position in our portfolio — we are not competing in the same technological paradigm.
2. For any patents that claim "a method of protecting electrical equipment from EMP" broadly, we will argue non-infringement based on the fundamentally different mechanism of action (materials-level dielectric protection vs. component-level conductive enclosure).
3. We will monitor new patent filings in the EMP/EMI space, particularly from defense contractors and grid equipment manufacturers, for any attempts to broaden claims to cover materials-based approaches.

### D. Amphibious Vehicle Patents (Gibbs, BAE, Lockheed)

**Design-Around Strategy:**
1. Our walking mechanism is mechanically distinct from wheeled and tracked amphibious vehicles. We are not designing a car that goes in water. We are designing a walking vehicle with a dielectric hull — a category that essentially does not exist in the prior art.
2. We will conduct detailed FTO searches for quadrupedal walking vehicle patents (Boston Dynamics, ANYbotics, Ghost Robotics) before finalizing the Sentinel-Class mechanical design. While these companies' patents focus on robotics at smaller scales (1-100 kg), we must ensure that scaling their mechanisms does not infringe.
3. Our amphibious walker patents (Category C) will be drafted to claim the unique combination of quadrupedal walking + dielectric hull + utility deployment payload — a combination that distinguishes our invention from both the robotics and amphibious vehicle patent landscapes.

---

## V. LICENSING-IN OPPORTUNITIES

### A. Recommended Licenses

| Patent/Portfolio | Licensor | Rationale | Estimated Cost | Priority |
|-----------------|---------|----------|---------------|---------|
| MXene composition patents | Drexel University | Clean FTO for in-house MXene synthesis; largest single IP risk | $100-250K upfront + 2-4% royalty | High |
| YInMn Blue pigment patent | Oregon State University | Required if we bring pigment synthesis in-house | $50-100K upfront + 2-3% royalty on pigment sales | Medium |
| CMC manufacturing process | Various (potential cross-license with Boeing/GE in non-competing field) | Defensive cross-license if needed for additional FTO certainty | Cross-license (no cash) | Low — current FTO assessment is favorable without license |
| Boston Dynamics walking robot patents | Hyundai Motor Group (acquired BD in 2021) | Depends on final Sentinel leg mechanism design; may not be needed if mechanism is sufficiently distinct | Unknown | Monitor |

### B. Cross-Licensing Position

CSM's growing patent portfolio (42 inventions identified) provides cross-licensing leverage. If a third party asserts patents against CSM, CSM may be able to negotiate a cross-license by offering access to CSM's patents in return.

Key cross-licensing leverage assets:
- CSM's MXene-polymer composite patents (novel compositions with superior EMI shielding performance)
- CSM's YInMn Blue doping patents (thermochromic smart coatings — applications beyond grid protection in aerospace, automotive, and construction)
- CSM's dielectric concrete patents (novel application of geopolymer chemistry for electrical infrastructure)

---

## VI. RISK ASSESSMENT MATRIX

| Product Line | Key Third-Party IP | Risk Level | Mitigation | Formal Opinion Needed? |
|-------------|-------------------|-----------|------------|----------------------|
| ShieldCore (MXene Composite + CMC Housing) | Drexel MXene patents, Boeing/GE/Rolls-Royce CMC patents | Low-Medium | Composite vs. coating distinction; field-of-use differentiation; possible Drexel license | Yes — before first commercial sale |
| SurgeGate (GIC Blocker) | ABB substation protection patents | Low | Different technical approach; ABB patent covers active surge arresters, not passive materials-based blocking | Yes — review-specific ABB patents |
| SubShield (Geopolymer Foundation) | Various concrete patents (general) | Low | Geopolymer concrete chemistry is distinct from Portland cement; specific dielectric application is novel | No — low risk |
| DriveShield (Vehicle ECU Protection) | Existing automotive EMI shielding patents | Low | Different materials approach; MXene composite vs. conductive enclosure | Monitor only |
| Sentinel Walker | Gibbs amphibious patents, Boston Dynamics walking robot patents | Low-Medium | Mechanical distinctiveness; unique combination of features; BD patents may be relevant depending on leg mechanism design | Yes — before detailed mechanical design freeze |
| Protonic Transceiver | Various communication patents | Very Low | Proton-based communication is essentially a greenfield technology area with minimal prior art | No — but monitor for new filings |
| YInMn Blue Smart Coating | Oregon State YInMn Blue patent | Low | We purchase pigment from licensed suppliers; in-house synthesis would require license | Yes — if in-house synthesis is brought forward |

### Risk Level Definitions:
- **Very Low:** No relevant third-party IP identified; FTO is essentially unconstrained.
- **Low:** Third-party IP exists but is clearly distinguishable in field of use, technical approach, or claim scope. Formal opinion may confirm but is not urgent.
- **Low-Medium:** Potentially relevant third-party IP identified; distinction arguments exist but should be tested in formal opinion. License may be a prudent backup.
- **Medium:** Relevant third-party IP identified; design-around or license is recommended before commercial launch.
- **High:** Blocking third-party IP identified; design-around or license is essential. Commercial launch should not proceed until FTO is clear.
- **Critical:** Third-party IP is clearly infringed; product cannot be commercialized without license or complete redesign.

---

## VII. FORMAL OPINIONS NEEDED

CSM should commission formal FTO opinions from qualified patent counsel for the following products before commercial launch:

| Product | Opinion Type | Estimated Cost | Timeline |
|---------|-------------|---------------|---------|
| ShieldCore EHV Transformer Housing | FTO Opinion (US) — covering MXene composite and CMC housing claims | $35-50K | Q1-Q2 2028 |
| SurgeGate GIC Blocker | FTO Opinion (US) — covering ABB and other substation protection claims | $20-30K | Q3 2028 |
| Sentinel Walker | FTO Opinion (US) — covering amphibious vehicle and walking robot claims | $30-45K | Q1-Q2 2029 (before construction) |
| MXene Synthesis Process | FTO Opinion (US) — covering Drexel and other MXene synthesis method claims | $25-35K | Q1-Q2 2027 (before pilot plant MXene synthesis begins) |
| DriveShield Vehicle Kit | FTO Opinion (US) — streamlined, focused on MXene composite claims | $15-20K | Q4 2027 |

Total formal opinion budget: $125,000-180,000 over 3 years. Allocated within Series A IP budget.

---

## VIII. ONGOING FTO MONITORING

FTO is not a one-time analysis. CSM will implement:

1. **Quarterly Patent Watch:** Automated patent alert service from commercial provider (Derwent or PatSnap) with alerts configured for all relevant CPC classifications, assignees, and keywords. Cost: $15,000/year.

2. **Pre-Launch FTO Review:** Six months before commercial launch of each product, a targeted FTO search will be conducted to identify any new patent filings since the last review. Cost: $5-10K per product.

3. **Competitor Monitoring:** Ongoing monitoring of key competitors' patent filing activity (Drexel, Boeing, GE, ABB, Siemens, 3M, Raytheon, Northrop, Lockheed, Boston Dynamics). Quarterly review of new publications and grants.

4. **Standards-Embedded IP Monitoring:** Review of new standards published by IEEE, IEC, and other SDOs for embedded IP that could create FTO issues (SEPs — standard-essential patents).

---

## IX. LEGAL DISCLAIMER

This Freedom-to-Operate analysis is a preliminary screening conducted by Carrington Storm Motors' internal team and is provided for informational purposes only. It does not constitute legal advice or a formal FTO opinion. Patent law, claim construction, and infringement analysis are complex legal matters that require analysis by qualified patent counsel. CSM will commission formal FTO opinions from external IP counsel before commercial launch of each product identified for formal opinion above.

The patent landscape is dynamic. Patents expire, new patents are granted, and pending applications publish on a daily basis. This analysis represents a snapshot as of July 2026 and must be updated regularly.

Nothing in this document should be construed as an admission of infringement or as a waiver of any legal right or defense. This document is protected by attorney-client privilege and work product doctrine where applicable.

---

**END OF DOCUMENT — CSM-REG-04-v1.0**

*Attorney-Client Privileged. Attorney Work Product. CONFIDENTIAL.*
