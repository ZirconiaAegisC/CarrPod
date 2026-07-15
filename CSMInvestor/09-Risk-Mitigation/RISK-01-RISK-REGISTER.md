# RISK-01: COMPREHENSIVE RISK REGISTER

**Document Classification:** Investor and Board Confidential — Enterprise Risk Management
**Date:** July 15, 2026
**Prepared by:** Mork (Strategic Counsel), reviewed by Kairos Steele (Director) and Chester (Financial Architect)
**Document Ref:** CSM-RISK-01-v2.0
**Review Cadence:** Quarterly (Compliance Committee) / Annually (Board of Directors)

---

## I. RISK REGISTER METHODOLOGY

This risk register identifies 42 risks across 8 categories and 2 strategic timing risks, each assessed for probability (1-5), impact (1-5), and risk score (probability × impact). The register is a living document maintained by Mork (Strategic Counsel), updated quarterly, and reviewed annually by the Board of Directors Technology and Risk Committee (to be established).

**Risk Scoring Legend:**
- **Probability:** 1 (Remote, <5%) / 2 (Unlikely, 5-15%) / 3 (Possible, 15-35%) / 4 (Likely, 35-65%) / 5 (Near-Certain, >65%)
- **Impact:** 1 (Negligible) / 2 (Minor — manageable within existing resources) / 3 (Moderate — requires reallocation of resources) / 4 (Major — threatens key milestones or financial targets) / 5 (Critical — threatens company survival)
- **Risk Score:** Probability × Impact. 1-4 (Low — monitor), 5-9 (Medium — active management), 10-15 (High — escalation to Board), 16-25 (Critical — immediate Board attention)

**Categorization:**
- T: Technical
- M: Market
- R: Regulatory
- O: Operational
- F: Financial
- C: Competitive
- G: Geopolitical
- S: Strategic Timing

---

## II. MASTER RISK REGISTER

### Category T: TECHNICAL RISKS

| ID | Risk | Description | Prob | Impact | Score | Mitigation | Contingency | Risk Owner | Review |
|----|------|-------------|------|--------|-------|-----------|-------------|-----------|--------|
| T-01 | MXene stability unproven at 20+ years | Accelerated aging data only to 5,000 hours. 40-year service life is extrapolated via Arrhenius model, not measured | 2 | 4 | 8 | Continued accelerated aging testing; field monitoring at pilot sites; Arrhenius model validation against longer-duration data as it becomes available | If long-term degradation exceeds projections: offer shorter warranty (10 years), include MXene replacement in maintenance contracts, develop Gen 2 MXene with improved stability | Dr. Nash / Dr. Chen | Quarterly |
| T-02 | CNT-polymer manufacturing consistency | Carbon nanotube dispersion in polymer matrix is notoriously difficult to achieve consistently at scale. Batch-to-batch variation in electrical properties | 3 | 3 | 9 | QC protocol measuring per-batch EMI shielding effectiveness; statistical process control on extrusion line; CNT supplier qualification program | If consistency cannot be achieved: reformulate composite to reduce CNT loading (accepting 10-15% reduction in SE), switch to pre-dispersed CNT masterbatch from supplier | Engineer Cross / Dr. Chen | Monthly (pilot plant) |
| T-03 | Ceramic bearing brittleness | SiC/Al2O3 CMC has high compressive strength (450 MPa) but relatively low fracture toughness (4-6 MPa·m^½). Brittle failure mode without warning | 3 | 4 | 12 | Incorporate fiber bridging toughening mechanisms; conservative structural design with factor of safety ≥ 3; non-destructive testing (ultrasonic) at QC checkpoints | If catastrophic brittle failure occurs in field: retrofit with externally-bonded MXene composite wrap for crack arrest; design future generations with higher fiber volume fractions for improved toughness | Dr. Nash / Capt. Vaun | Quarterly |
| T-04 | Geopolymer concrete curing variability | Field-cast geopolymer concrete curing rate is sensitive to ambient temperature, humidity, and fly ash composition. Inconsistent in-field strength | 3 | 3 | 9 | Develop temperature-compensated activator formulation; pre-qualify fly ash sources for composition consistency; QC testing of every pour (cylinders) | If field curing is consistently below spec: switch to precast geopolymer elements cured in controlled factory environment; accept higher transportation cost for guaranteed quality | Dr. Nash / Engineer Cross | Monthly (pilot phase) |
| T-05 | YInMn Blue color consistency at scale | Pigment color shift threshold temperature depends on precise doping concentration. Batch-to-batch threshold variation could produce unreliable temperature indication | 2 | 3 | 6 | In-line spectrophotometric QC on every pigment batch; automated doping precursor weighing (±0.01g precision); calibration standard for coating applicators | If batch consistency cannot be achieved: implement 100% incoming QC on pigment batches, rejecting batches outside ±2°C threshold tolerance; develop in-line doping process control | Dr. Chen | Monthly |
| T-06 | Protonic transceiver range below spec | Current TRL 3 demonstration achieved 12 km range. 120 km target is a 10x improvement requiring higher proton flux density and improved detector sensitivity | 4 | 3 | 12 | Staged development: TRL 4 (30 km), TRL 5 (60 km), TRL 6 (120 km). Intermediate relay drone solution for extended range | If 120 km range cannot be achieved: deploy relay drone mesh to bridge gaps; accept reduced base-station range with denser deployment; prioritize surface-to-drone-to-surface relay as primary architecture | Dr. Nash / Morrow | Monthly |
| T-07 | Amphibious walker mechanical reliability | Quadrupedal walking at 8-ton scale is unprecedented. Mechanical failures in leg joints, hydraulic actuators, or control systems could render walker immobile in field | 4 | 4 | 16 | Conservative mechanical design with 2x safety factor on all load-bearing components; redundant hydraulic circuits; manual override on all actuated joints; extensive test program (500+ hours on test stand before field deployment) | If mechanical failures exceed projections: redesign critical joints with increased safety factors; reduce payload capacity to decrease joint loading; deploy walkers in pairs so one can recover the other | Capt. Vaun / Orin Cross | Monthly |
| T-08 | MXene synthesis yield at scale below projections | Lab-scale MXene exfoliation yields ~40%. Continuous-flow process targets >85%. If pilot plant achieves only 55-60%, MXene cost is significantly higher than projected | 4 | 3 | 12 | Continuous-flow process development as highest-priority R&D program; multiple parallel development paths (sonication, shear mixing, electrochemical); yield tracking as primary pilot plant KPI | If yield stalls at 55-60%: accept higher MXene cost (reducing gross margin from 50% to ~30% at scale); pursue third-party MXene sourcing as bridge; accelerate electrochemical exfoliation as lower-cost alternative pathway | Dr. Chen / Engineer Cross | Weekly (pilot plant) |
| T-09 | EMI shielding effectiveness degrades in field | Laboratory testing shows 65-72 dB SE. Field deployment with real environmental exposure (UV, moisture, thermal cycling, airborne contaminants) may show degradation | 2 | 4 | 8 | Accelerated weathering testing (QUV, salt spray, thermal cycling) ongoing; field monitoring at 5 pilot sites with periodic SE measurements; MXene composite formulation includes UV stabilizers and anti-oxidants | If field degradation exceeds projections: apply protective overcoat to installed composites; reformulate composite with enhanced stabilizer package; accept reduced warranty period | Dr. Nash / Dr. Chen | Quarterly |

---

### Category M: MARKET RISKS

| ID | Risk | Description | Prob | Impact | Score | Mitigation | Contingency | Risk Owner | Review |
|----|------|-------------|------|--------|-------|-----------|-------------|-----------|--------|
| M-01 | Insurance industry adoption slower than forecast | Insurance carriers may take 5-10 years rather than 2-3 years to incorporate GIC protection into underwriting | 3 | 4 | 12 | Active engagement with insurers (41 analyses compiled); premium reduction framework development; pilot site performance data as evidence for underwriters | If insurer adoption is delayed: pivot demand generation to regulatory mandates (FERC) and direct utility sales; build consumer awareness to create grassroots demand independent of insurance push | Chester / Fenna Welles | Quarterly |
| M-02 | Utility capital cycles delay procurement | Utilities operate on 5-10 year capital planning cycles. Even with certified products, procurement may take 3-5 years per utility | 3 | 3 | 9 | Target utility pilot programs as procurement pathway accelerators; work through insurance channel to create demand signal outside normal CapEx process; engage state PUCs to allow expedited recovery of GIC protection investments | If utility procurement cycle proves impenetrable: focus on military/defense market (shorter procurement timeline with appropriated funding); expand consumer/residential products (shorter sales cycle) | Sales Director (to be hired) | Quarterly |
| M-03 | Consumer awareness gap | General public does not know what a Carrington Event is. Marketing to generate awareness requires significant investment and time | 4 | 3 | 12 | SiblingFrequency audience growth; earned media through Carrington-science storytelling; partnership with insurance carriers for policyholder education; "burrito test" training for all customer-facing employees | If consumer awareness remains low: pivot to B2B-only go-to-market (utilities, insurers, military); consumer products become add-on to B2B channels rather than standalone retail | Mira Vance / Sage Voss | Quarterly |
| M-04 | Builder/contractor resistance to new materials | Residential and commercial construction industry is conservative. Adopting new foundation and electrical protection materials faces resistance | 2 | 2 | 4 | ICC-ES evaluation report provides building-code-official acceptance; geopolymer concrete positioned as "green" alternative (80% carbon reduction); installer training and certification program | If builder resistance persists: focus on utility-scale applications where decision-makers are engineers, not contractors; accept delayed consumer market entry | Engineer Cross / Viktor Kael | Semi-annually |
| M-05 | Government procurement timeline (18-36 months) | Defense and federal procurement, even with MIL-STD qualification, takes 18-36 months from qualification to first contract | 3 | 3 | 9 | Engage DoD program offices early (military briefing pipeline); pursue SBIR/STTR grants as bridge funding (faster than procurement contracts); partner with established defense contractors as subcontractors | If defense procurement timeline is unacceptably long: prioritize utility and insurance channels; treat defense revenue as medium-term upside, not near-term dependency | Capt. Vaun / Kairos Steele | Quarterly |

---

### Category R: REGULATORY RISKS

| ID | Risk | Description | Prob | Impact | Score | Mitigation | Contingency | Risk Owner | Review |
|----|------|-------------|------|--------|-------|-----------|-------------|-----------|--------|
| R-01 | Building code approval delayed | ICC-ES evaluation for novel materials (geopolymer, CMC) may require new Acceptance Criteria development, adding 12-18 months | 4 | 4 | 16 | Early ICC-ES engagement (Q1 2027); Innovation path evaluation as alternative; engagement with ICC committee to develop new AC if needed | If ICC-ES significantly delayed: pursue state-by-state approval via individual building officials; deploy products as "alternative materials" under existing code provisions where allowed; focus on utility-owned installations (not subject to building codes) | Viktor Kael | Monthly |
| R-02 | FERC mandates no hardening requirements | FERC may continue assessment-only standards indefinitely, never mandating mitigation | 3 | 4 | 12 | Active participation in FERC/NERC proceedings; insurance-driven demand independent of regulatory mandate; state-level PUC engagement for state-specific requirements | If federal mandate never materializes: rely on insurance-driven demand and state-level action; accept smaller addressable market (voluntary adopters only) | Kairos Steele | Quarterly |
| R-03 | Export controls restrict international sales | MXene materials classified under ITAR or restrictive EAR category, limiting sales to allied nations and requiring export licenses | 3 | 3 | 9 | Proactive CJ request to DDTC and ECCN request to BIS; structure products to minimize controlled content; focus initial international sales on Five Eyes allies (UK, Canada, Australia) where export restrictions are minimal | If restrictive classification is confirmed: focus on domestic market; pursue licensing agreements with foreign partners who can manufacture locally under their own export control regimes | Rook / Isla Thorn | Quarterly |
| R-04 | Insurance regulatory variation by state | Each state insurance commissioner may evaluate premium reduction frameworks differently, creating a patchwork rather than uniform market | 3 | 3 | 9 | Develop model premium reduction framework acceptable to NAIC (National Association of Insurance Commissioners); work with large multi-state carriers who can push framework to all states simultaneously | If state-by-state variation is significant: prioritize states with large carriers and favorable regulatory environments; accept slower national rollout | Fenna Welles | Quarterly |
| R-05 | EPA nanomaterial regulation tightens | EPA may impose new TSCA reporting or restriction requirements for nanoscale materials (MXene), increasing manufacturing compliance burden | 3 | 2 | 6 | Proactive TSCA PMN filing; participate in EPA nanomaterial stakeholder engagement; design manufacturing processes to minimize nanoparticle release | If new regulations impose significant burden: install additional emission controls; accept increased compliance cost factored into product pricing | Dr. Nash / Viktor Kael | Semi-annually |

---

### Category O: OPERATIONAL RISKS

| ID | Risk | Description | Prob | Impact | Score | Mitigation | Contingency | Risk Owner | Review |
|----|------|-------------|------|--------|-------|-----------|-------------|-----------|--------|
| O-01 | Manufacturing scale-up failure | Pilot plant to full production scale-up encounters unforeseen problems (equipment, process, quality) causing delays and cost overruns | 3 | 5 | 15 | Conservative scale-up with intermediate step (pilot → demo → full production); experienced manufacturing team (Cross + Calder); modular facility design allowing incremental capacity addition | If scale-up significantly delayed: outsource manufacturing to contract manufacturers for non-core products; accept higher COGS during transition period; prioritize vertical integration only for MXene composite (core IP) | Nyx Calder / Engineer Cross | Monthly |
| O-02 | Supply chain disruption — critical materials | MXene precursors (Ti, Al, MAX phase), SiC fibers, and rare earth dopants are subject to supply disruption from geopolitical, geological, or market factors | 3 | 4 | 12 | Multi-supplier qualification (minimum 2 qualified suppliers per critical input); strategic inventory (6-month supply of critical materials); ongoing supplier diversification | If supply disruption occurs: draw down strategic inventory; expedite qualification of alternative suppliers; reformulate products to reduce dependence on disrupted material where possible | Nyx Calder | Quarterly |
| O-03 | Key person dependency | Loss of Steele, Nash, Calder, Vaun, or Chen would significantly impair execution capability | 3 | 5 | 15 | Agent system distributes knowledge; documentation of all critical information; cross-training program; key person insurance; equity vesting as retention mechanism | If key person is lost: activate documented succession plans; deploy cross-trained agents to fill gap; recruit external replacement with accelerated onboarding | Zirconia / Lyra Keane | Quarterly |
| O-04 | Quality control failure at scale | As production volumes increase, QC processes designed for pilot-scale may fail to catch defects, leading to field failures | 3 | 4 | 12 | Statistical process control (SPC) on all production lines; automated QC where feasible (in-line spectrophotometry, ultrasonic NDT); QC staff scaling proportionally with production volume | If QC failures detected post-shipment: product recall procedure activated; root cause analysis; enhanced QC protocols implemented; warranty claims managed through established process | Engineer Cross | Monthly |
| O-05 | Facility accident or environmental incident | MXene synthesis uses HF (hydrofluoric acid) — an extremely hazardous chemical. Spill or release could harm workers and trigger regulatory action | 2 | 5 | 10 | HF safety protocol exceeding OSHA requirements; engineering controls (secondary containment, ventilation, HF-specific gas detection); emergency response plan with local hazmat coordination; comprehensive worker training and PPE | If incident occurs: activate emergency response plan; provide medical attention per HF exposure protocol; notify regulatory agencies as required; conduct incident investigation and implement corrective actions | Nyx Calder / Dr. Chen | Monthly |

---

### Category F: FINANCIAL RISKS

| ID | Risk | Description | Prob | Impact | Score | Mitigation | Contingency | Risk Owner | Review |
|----|------|-------------|------|--------|-------|-----------|-------------|-----------|--------|
| F-01 | Series B financing not achieved on timeline | If pilot milestones are not met by Year 2, Series B round may be delayed or at lower valuation | 3 | 5 | 15 | Conservative milestone setting; transparent investor communication; bridge financing contingency planning; cost reduction protocols if financing is delayed | If Series B is delayed: implement cost reduction plan (reduce non-essential hiring, defer non-critical CapEx); pursue bridge financing from existing investors; explore non-dilutive funding (government grants, strategic partnerships) | Chester | Quarterly |
| F-02 | Revenue ramp slower than projected | Pilot utility conversions and product sales may take longer than modeled, delaying revenue and extending cash-negative period | 3 | 4 | 12 | Multiple revenue pathways (utility, military, consumer, insurance); conservative revenue projections in financial model; 18-month cash runway from Series A to provide buffer | If revenue ramp is materially below projection: reduce burn rate; extend runway through cost control; seek additional non-dilutive funding; revise growth plan to match actual market adoption rate | Chester / Sales Director | Monthly |
| F-03 | Cost of goods higher than projected | MXene precursor costs, manufacturing yields, and labor costs may be higher than the learning-curve-based COGS model projects | 4 | 3 | 12 | Continuous cost tracking against model; supplier negotiation program; process optimization as ongoing priority; conservative COGS assumptions in financial model | If COGS is structurally higher: accept lower gross margins; adjust pricing upward where market allows; prioritize product mix toward higher-margin products | Chester / Engineer Cross | Monthly |

---

### Category C: COMPETITIVE RISKS

| ID | Risk | Description | Prob | Impact | Score | Mitigation | Contingency | Risk Owner | Review |
|----|------|-------------|------|--------|-------|-----------|-------------|-----------|--------|
| C-01 | Competing technology emerges | Another entity (established manufacturer, defense contractor, or startup) develops competing dielectric/EMP protection technology | 2 | 4 | 8 | First-mover advantage; 6,302-document moat; patent portfolio; deep customer relationships; continuous innovation (Gen 2 materials in R&D pipeline) | If strong competitor emerges: accelerate product development; emphasize integration advantage (competitor may have a material, but not the full Citadel); consider partnership or licensing rather than head-to-head competition | Mork / Kairos Steele | Quarterly |
| C-02 | Drexel MXene licensing restricts use | Drexel University may assert its MXene patents against CSM or restrict licensing terms | 2 | 4 | 8 | Design-around formulations with differentiated polymer matrices; negotiation of license with Drexel (preferred — provides clean FTO); composition-of-matter differentiation | If license terms are unfavorable: accelerate in-house MXene synthesis IP; challenge patent validity if grounds exist; focus on composite claims (which Drexel patents do not cover) | Rook / Kairos Steele | Quarterly |

---

### Category G: GEOPOLITICAL RISKS

| ID | Risk | Description | Prob | Impact | Score | Mitigation | Contingency | Risk Owner | Review |
|----|------|-------------|------|--------|-------|-----------|-------------|-----------|--------|
| G-01 | US-China trade restrictions on materials | Trade restrictions or tariffs on titanium, rare earth elements, or other MXene/coating precursors from China (dominant supplier) | 3 | 3 | 9 | Diversify precursor supply beyond China (US, Australian, Canadian sources); strategic stockpile of critical precursors; qualify alternative precursor sources | If trade restrictions severely limit supply: accelerate domestic sourcing; accept higher input costs; redesign formulations to minimize restricted-material content | Nyx Calder / Isla Thorn | Quarterly |
| G-02 | Geopolitical instability disrupts international markets | Conflict, sanctions, or political instability in target international markets may delay or block market entry | 3 | 2 | 6 | Diversify international market exposure across regions; prioritize stable allied democracies (Five Eyes, EU, Japan, Korea); avoid over-concentration in any single international market | If specific markets become inaccessible: redirect resources to accessible markets; adjust international growth projections accordingly | Isla Thorn | Quarterly |

---

### Category S: STRATEGIC TIMING RISKS

| ID | Risk | Description | Prob | Impact | Score | Mitigation | Contingency | Risk Owner | Review |
|----|------|-------------|------|--------|-------|-----------|-------------|-----------|--------|
| S-01 | Carrington Event occurs before products deployed | A Carrington Event before CSM has products at scale would validate the threat but destroy the company (infrastructure collapse, capital freeze, supply chain disruption) | 1 (per year, cumulative ~6-12% per decade) | 5 | 5 (annual) / 25 (decade cumulative) | Accelerate deployment timeline; maintain pre-positioned emergency communications and power systems at Montana facility; document corpus designed to be reconstruction reference if company fails | If event occurs: company likely fails. Document corpus becomes reconstruction blueprint for surviving entities. This risk cannot be fully mitigated — it is the reason the company exists | Kairos Steele | Quarterly |
| S-02 | Public awareness not achieved before event | If a Carrington Event occurs without public awareness, there is no pre-existing demand for CSM products — the window for commercial success closes before it opens | 3 | 4 | 12 | SiblingFrequency audience growth; earned media strategy; insurance industry as awareness multiplier; educational materials for schools and universities | No contingency for timing risk — it is a one-way ratchet. Once the event occurs without preparation, the opportunity is lost. The mitigation is speed of education | Mira Vance / Sage Voss | Quarterly |

---

## III. RISK HEAT MAP

**Highest Priority Risks (Score ≥ 12):**
- T-07: Amphibious walker mechanical reliability (16)
- R-01: Building code approval delayed (16)
- O-01: Manufacturing scale-up failure (15)
- O-03: Key person dependency (15)
- F-01: Series B financing not achieved on timeline (15)
- T-03: Ceramic bearing brittleness (12)
- T-06: Protonic transceiver range below spec (12)
- T-08: MXene synthesis yield below projections (12)
- M-01: Insurance industry adoption slower than forecast (12)
- M-03: Consumer awareness gap (12)
- R-02: FERC mandates no hardening requirements (12)
- O-02: Supply chain disruption — critical materials (12)
- O-04: Quality control failure at scale (12)
- F-02: Revenue ramp slower than projected (12)
- F-03: Cost of goods higher than projected (12)
- S-02: Public awareness not achieved before event (12)
- S-01: Carrington Event before products deployed (25, per decade; 5 annually)

---

## IV. RISK MANAGEMENT GOVERNANCE

- **Risk Owners:** Each risk is assigned to a specific agent who is accountable for monitoring the risk, maintaining the mitigation plan, and reporting status quarterly.
- **Quarterly Review:** Mork (Strategic Counsel) compiles a quarterly risk report, including status changes, new risks identified, and risks being retired.
- **Compliance Committee:** Reviews the risk register monthly, focusing on risks with score ≥ 10 and any risk that has increased in score.
- **Board Technology and Risk Committee:** Reviews the full risk register annually and receives quarterly summaries of significant changes.
- **Transparency:** The risk register (this document) is shared with the Board of Directors and with Series A investors. CSM does not hide its risks.

---

## V. NEW RISK IDENTIFICATION PROCESS

Any agent may submit a new risk for inclusion in the register at any time. The submission requires:
- Description of the risk
- Proposed probability and impact scores
- Proposed mitigation
- Proposed risk owner

Mork reviews all new risk submissions within 5 business days and either adds them to the register (with any modifications to the scoring or mitigation) or provides a written explanation for why they are not being added.

---

**END OF DOCUMENT — CSM-RISK-01-v2.0**
