# Research Memorandum: SpaceX Starship–Starlink Integrated Analysis

**Classification:** ACS Proprietary — Research Archive
**Date:** July 15, 2026
**Author:** Advanced Capabilities Syndicate, Research Division
**Subject:** Analytical foundations and methodological notes underpinning the ACS-SpaceX-Starship-Starlink dossier

---

## 12.1 Scope and Methodology

This memorandum documents the research process, source materials, analytical frameworks, and key assumptions embedded in the 16-document ACS dossier. The research effort spans primary-source financial data (SpaceX S-1 SEC filing, IPO prospectus, quarterly earnings), technical specifications (FCC/ITU filings, FAA environmental assessments, NASA contract documents), operational metrics (publicly reported launch data, satellite tracking databases), and secondary analysis (industry reports, competitor filings, academic research on LEO constellations and space economics).

### 12.1.1 Primary Sources Utilized

1. **SpaceX S-1 Registration Statement** (Filed SEC, May 2026) — Definitive source for FY2023–FY2025 financial statements, segment breakdowns, risk factors, and pre-IPO capitalization
2. **SpaceX S-1/A Amendment** (Filed SEC, June 12, 2026) — Final IPO pricing, share structure, updated Q1 2026 preliminary financials
3. **SpaceX Q1 2026 Earnings Release** (August 2026, anticipated) — Quarterly financial update (projected)
4. **FCC International Bureau Filings** (IBFS) — Starlink spectrum authorizations, orbital shell modifications, D2C Supplemental Coverage from Space application
5. **FAA Office of Commercial Space Transportation** — Starship/Super Heavy launch license applications, environmental assessments, mishap investigation reports
6. **ITU Radiocommunication Sector (ITU-R)** — Starlink spectrum filings, orbital slot registrations
7. **NASA Procurement Data** — Commercial Crew, CRS-2, HLS, and Gateway Logistics contract values and modifications
8. **DoD Budget Justification Documents** (FY2025, FY2026) — NSSL Phase 2/3, Starshield, Golden Dome contract line items
9. **SpaceX Public Webcasts and Presentations** — Musk/Shotwell statements on milestones, capability projections, and strategic intent

### 12.1.2 Secondary and Analytical Sources

- BryceTech Space Report (quarterly launch and manufacturing data)
- Jonathan's Space Report (satellite catalog and orbital tracking)
- CelesTrak/Space-Track (TLE data for Starlink constellation analysis)
- Morgan Stanley Space Research (industry-wide valuation frameworks)
- Quilty Analytics (satellite broadband competitive analysis)
- NSR / Analysys Mason (LEO constellation market sizing)
- 3GPP Technical Reports (TR 38.821, TR 38.811 — NTN specifications)
- IEEE / AIAA conference proceedings (optical ISL, phased array, space-based compute papers)

## 12.2 Key Assumptions and Derivations

### 12.2.1 Starlink Subscriber Economics

**ARPU calculation:** Derived from reported $11.4B Starlink revenue, an estimated $2.0B allocated to hardware terminal sales, and $1.24B to enterprise/government, yielding approximately $8.16B in pure subscription revenue. Divided by 10.3M year-end subscribers (= 12-month average), yielding $792/year/subscriber or $66/month.

**Terminal cost:** SpaceX reported terminal manufacturing cost reduction from approximately $2,500 (2021) to $599 (2025). Subsidy calculation assumes average selling price of $499, yielding approximately $100 per-unit subsidy amortized over 24-month expected life for $45/year per-subscriber cost.

**Satellite per-subscriber capacity cost:** Total constellation depreciation of $2.8B divided by 10.3M subscribers = ~$272/year. With satellite operational life of approximately 5 years, total in-orbit asset base of approximately $14B for 10,747 operational satellites is consistent with ~$1.3M per-satellite cost (blended V1.5/V2 Mini).

### 12.2.2 Starship Marginal Launch Cost

**Derivation:** The $6.3M target is derived as follows:
- Booster amortization: $100M build cost / 100 flights = $1.0M
- Upper stage amortization: $50M build cost / 50 flights = $1.0M
- Propellant: 4,600 metric tons LCH4 + LOX at ~$170/ton = $0.78M
- Launch operations: Range safety, telemetry, personnel, recovery fleet = $2.0M
- Refurbishment (thermal tile inspection, engine health checks, minor repairs) = $1.5M
- **Total:** ~$6.3M

This figure assumes mature operations (50+ flights per vehicle) and does not account for initial learning-curve costs, which may be 2–3× higher in the first 25 flights.

### 12.2.3 Orbital AI Compute Feasibility Assessment

**Power budget rationale:** A 20 kW solar array on a 2,000 kg V3-class satellite bus yields approximately 10–12 kW available for compute after propulsion, communications, and housekeeping loads. At 2026 chip efficiency of approximately 0.5 PFLOPS/kW (H100-class at lower precision), this yields ~5–6 PFLOPS per satellite. Terafab custom silicon targeting 2 PFLOPS/kW (space-optimized, lower clock, wider parallelism) could achieve ~20 PFLOPS per satellite. Our estimate of 1 PFLOPS per satellite is conservative and factors in radiation-hardened overhead, redundancy, and early-generation silicon limitations.

**Latency analysis:** At 340 km VLEO, one-way propagation delay is approximately 1.1 ms. With ISL routing (~2–3 hops to nearest ground station), end-to-end latency from user query to result is approximately 8–12 ms, competitive with or superior to terrestrial data center round-trip times for inference workloads.

**Thermal management advantage:** Space-based radiative cooling eliminates the largest operational cost component of terrestrial data centers (cooling energy = 25–40% of total data center electricity). In vacuum, a satellite radiator at 300K rejects approximately 460 W/m². A 10 m² radiator handles the full 4.6 kW waste heat from compute operations with zero energy input.

## 12.3 Competitive Intelligence Notes

### 12.3.1 Amazon Kuiper

Amazon has launched approximately 6 prototype satellites through mid-2026. Production satellites are manufactured at Amazon's Kirkland, WA facility with projected launch rate of 40+ per month beginning H2 2026, primarily aboard ULA Vulcan, Ariane 6, and Blue Origin New Glenn. Kuiper's FCC license requires 1,618 satellites operational by July 2026 (50% of 3,236)—a deadline that will be missed, triggering a regulatory extension request. Kuiper's competitive disadvantage is launch cost: without a reusable rocket, per-satellite deployment cost is 5–10× Starlink's.

### 12.3.2 China's GuoWang

China's GuoWang (National Network) constellation plans 12,992 satellites across LEO shells. Approximately 50 satellites have been launched through mid-2026 aboard Long March 5B and Long March 8A rockets. China's reusable launcher programs (LandSpace Zhuque-3, Space Pioneer Tianlong-3) are targeting first-stage recovery by 2027. GuoWang is projected to serve primarily domestic and Belt-and-Road markets, with limited commercial competitiveness in Western-aligned markets.

### 12.3.3 Eutelsat OneWeb

OneWeb's 634-satellite constellation (1,200 km altitude) serves enterprise and government customers. Eutelsat's merger with OneWeb (2023) has stabilized the program financially, but the higher-altitude architecture results in higher latency (~50 ms) and lower per-satellite throughput than Starlink. OneWeb is a complementary rather than direct competitive service.

### 12.3.4 AST SpaceMobile

AST SpaceMobile has demonstrated 14 Mbps throughput to an unmodified handset via its BlueWalker 3 test satellite. Five Block 1 BlueBird production satellites are in orbit as of mid-2026, with commercial service planned for late 2026. AST's large phased array architecture (64 m² per satellite) potentially enables higher per-beam throughput than Starlink D2C but at significantly higher per-satellite cost and manufacturing complexity. AST's reliance on third-party launch providers (SpaceX, ironically, for initial launches) places it at a structural cost disadvantage.

## 12.4 Data Gaps and Qualifiers

| Data Point | Status | Impact on Analysis |
|---|---|---|
| Starlink per-country subscriber detail | Not publicly disclosed | Geographic distribution is estimated |
| Starship per-flight cost (actual) | Not disclosed | $6.3M is a target; actual may be 2–5× higher initially |
| Starshield classified contract values | Partially redacted | Government revenue likely understated by $1–3B |
| Terafab chip specifications | Pre-design phase | Performance assumptions may shift significantly |
| Starlink V3 satellite manufacturing cost | Not disclosed | $1.5M estimate based on V2 Mini costs and mass scaling |
| xAI relationship financial terms | Not disclosed | Transfer pricing assumptions embedded in AI Compute segment |
| Golden Dome satellite sensor payload | Classified | Technical specifications excluded from analysis |

## 12.5 Revision History

| Version | Date | Author | Changes |
|---|---|---|---|
| 0.1 (Draft) | Jul 1, 2026 | ACS Research | Initial compilation following IPO |
| 0.5 (Review) | Jul 10, 2026 | ACS Research | Financial data cross-referenced with S-1; technical sections peer-reviewed |
| 1.0 (Release) | Jul 15, 2026 | ACS Research | Final dossier published; Flight 13 anticipation addendum |

---

*This memorandum serves as the methodological appendix to the ACS dossier. All financial projections are based on stated assumptions and represent estimates, not guarantees of future performance. Competitive intelligence is derived from public sources as of July 2026.*
