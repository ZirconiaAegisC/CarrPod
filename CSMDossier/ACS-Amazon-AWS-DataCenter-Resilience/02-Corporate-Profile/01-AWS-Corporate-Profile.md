
# CORPORATE PROFILE: AMAZON WEB SERVICES / AMAZON.COM, INC.
## ACS-AMAZON-AWS-DATACENTER-RESILIENCE

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE | RESEARCH COMPLETED: JULY 2026**

---

## 1. COMPANY OVERVIEW

**Legal Name:** Amazon.com, Inc.
**AWS Entity:** Amazon Web Services, Inc. (wholly owned subsidiary)
**Founded:** 1994 (Amazon), 2006 (AWS launched)
**Headquarters:** Seattle, Washington (Amazon); Arlington, Virginia (HQ2)
**AWS Leadership HQ:** Seattle, WA and Herndon, VA (us-east-1 campus)
**Fiscal Year 2025 Revenue:** Amazon consolidated ~$638B; AWS Segment ~$105B (estimated)
**AWS Market Share:** ~31% of global cloud infrastructure (Q1 2026)
**Employees:** ~1.5M (Amazon consolidated); ~140,000 (AWS estimated)

## 2. EXECUTIVE LEADERSHIP

**Andrew R. Jassy — President and CEO, Amazon.com, Inc.** Founded AWS in 2003 (launched 2006), served as AWS CEO from 2016-2021, promoted to Amazon CEO July 2021. Deepest possible understanding of AWS infrastructure among any executive. Wrote the original AWS business plan. Key decision-maker on major AWS infrastructure investments.

**Matt Garman — CEO, Amazon Web Services.** Appointed June 2024, succeeded Adam Selipsky. Previously SVP of AWS Sales, Marketing, and Global Services (2020-2024); VP of AWS Compute Services (EC2, Lambda, Elastic Beanstalk) before that. 18+ year AWS tenure. Technical depth in compute infrastructure.

**James Hamilton — VP and Distinguished Engineer, AWS Infrastructure.** One of the most influential data center engineers in the industry. Designed the physical architecture of AWS data centers including power distribution, cooling, and network topology. Reports directly to senior leadership. Primary technical stakeholder for any infrastructure hardening program.

**Peter DeSantis — SVP, AWS Utility Computing.** Oversees AWS's core compute, storage, database, and networking engineering teams. Previously led Amazon EC2 engineering. Critical stakeholder for server farm power protection decisions.

**Prasad Kalyanaraman — VP, AWS Infrastructure Services.** Leads the team building and operating AWS data centers, networking, and hardware infrastructure globally.

## 3. AWS INFRASTRUCTURE — PHYSICAL ANALYSIS

### 3.1 Global Footprint (as of Q1 2026)

**31 Geographic Regions:**
- **Americas:** us-east-1 (N. Virginia), us-east-2 (Ohio), us-west-1 (N. California), us-west-2 (Oregon), ca-central-1 (Montreal), sa-east-1 (São Paulo), us-gov-east-1, us-gov-west-1
- **Europe:** eu-west-1 (Ireland), eu-west-2 (London), eu-west-3 (Paris), eu-central-1 (Frankfurt), eu-central-2 (Zurich), eu-north-1 (Stockholm), eu-south-1 (Milan), eu-south-2 (Madrid), il-central-1 (Tel Aviv), me-central-1 (UAE), me-south-1 (Bahrain)
- **Asia-Pacific:** ap-east-1 (Hong Kong), ap-south-1 (Mumbai), ap-south-2 (Hyderabad), ap-northeast-1 (Tokyo), ap-northeast-2 (Seoul), ap-northeast-3 (Osaka), ap-southeast-1 (Singapore), ap-southeast-2 (Sydney), ap-southeast-3 (Jakarta), ap-southeast-4 (Melbourne)

**99 Availability Zones** = 99 physically separate data center clusters, each with independent power, cooling, and networking.

### 3.2 Power Infrastructure

**Estimated Total Electrical Load:** 12-18 GW (based on public AWS sustainability reports and regional capacity disclosures)

**Power Architecture per AZ:**
- Primary substation: 230-345 kV transmission → 34.5 kV distribution
- Secondary substations: 34.5 kV → 480V (server racks, cooling)
- On-site backup: 2-6 MW diesel generator per data hall (N+1 redundancy)
- UPS: flywheel or battery, 15-45 seconds ride-through
- Typical AZ power draw: 40-200 MW

**Key Vulnerabilities:**
1. **Transformer Neutral Grounding:** All AWS-fed transformers use solid neutral grounding — maximum GIC coupling. No existing NBC installations.
2. **Northern Virginia Geology:** Piedmont physiographic province — igneous and metamorphic bedrock with soil resistivity >1,000 ohm-meters. GIC electric fields 5-10x higher than sedimentary basins. USGS identified as highest GIC-risk zone in continental US.
3. **European Interconnection:** The synchronous ENTSO-E grid means GIC originating from a CME impact over Scandinavia propagates through the interconnected European grid, reaching Ireland (eu-west-1), London (eu-west-2), and Frankfurt (eu-central-1) transformer substations.
4. **Texas (Planned Regions):** If AWS expands into ERCOT territory, the isolated grid provides some GIC propagation protection but has weaker frequency response — a different risk profile requiring TX-specific engineering.

### 3.3 Immersion Cooling Infrastructure

AWS has deployed liquid immersion cooling for high-density AI/ML clusters (Trainium, Inferentia chips). Each immersion cooling tank contains 50-200 kW of servers submerged in dielectric coolant. Coolant is circulated by electrically-driven pumps. If pumps stop:
- **90-180 seconds to thermal runaway** in a fully loaded tank
- **Permanent server destruction** from chip-level thermal damage
- **Coolant boiling** causing tank overpressure and potential rupture

This makes immersion cooling infrastructure the single most time-critical protection target in the AWS portfolio.

### 3.4 Backup Power Assessment

**Generator Fleet Estimate:** 2,500-4,000 diesel generators across all AWS facilities globally. Generator reliability during GMD events depends on:
- ATS controller survival (if grid power is harmonic-rich, ATS may fail to detect outage)
- Starting battery condition (battery chargers feed from grid power)
- Fuel transfer pump power (also grid-fed)
- Generator exciter electronics (sensitive to harmonic distortion)

**Williams Heuristic:** "A generator is a machine that turns diesel fuel into electricity. But it needs electronics to tell it when to start and what to do. If those electronics get fried by the solar storm before the generator starts, you have a very expensive metal box full of diesel that can't help you."

## 5. FINANCIAL CONTEXT

**AWS Revenue (2025):** ~$105B (estimated), up from $90.8B in 2023. 30%+ of Amazon consolidated operating income.
**AWS Daily Revenue:** ~$288M per day. An 8-week outage of a single major region (e.g., us-east-1) represents $16B+ in direct revenue loss, not counting customer impact or reputational damage.
**AWS Capital Expenditure (2025):** ~$52B (Amazon consolidated capex, majority allocated to AWS infrastructure). The $558.7M protection program represents ~1.1% of single-year AWS capex.

## 6. REGULATORY CONTEXT

**FedRAMP and GovCloud:** AWS operates dedicated government regions (us-gov-east-1, us-gov-west-1) subject to DoD and federal agency resilience requirements. Executive Order 13865 (2019) on EMP/GMD resilience explicitly covers federal data infrastructure.

**EU NIS2 Directive (effective 2024):** Classifies cloud computing providers as "essential entities" requiring risk management measures for infrastructure resilience, including electromagnetic threats.

**DHS Critical Infrastructure Sectors:** Cloud computing was formally designated a subsector of the Communications Sector in 2024. AWS is the largest entity in this sector.

---

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE**
