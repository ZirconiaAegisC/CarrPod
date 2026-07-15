
# EXECUTIVE SUMMARY
## ACS-AMAZON-AWS-DATACENTER-RESILIENCE
### AWS Global Data Center GIC Hardening Program

**CLASSIFICATION: COMMERCIAL-IN-CONFIDENCE | DOCUMENT VERSION: 1.0 — 15 JULY 2026**

---

## 1. THE STRATEGIC PROBLEM

Amazon Web Services operates the world's largest cloud computing infrastructure: 100+ data center facilities across 31 geographic regions and 99 Availability Zones, consuming an estimated 12-18 GW of electricity. Every facility draws power through high-voltage transformers that are not GIC-rated. During a geomagnetic disturbance, quasi-DC currents induced in transmission lines flow through transformer neutrals, causing half-cycle saturation — a condition where the core saturates on alternate half-cycles, producing harmonics, reactive power consumption, and potentially permanent thermal damage.

AWS's us-east-1 region (Northern Virginia) — the largest cloud computing concentration on Earth, estimated at 7+ million square feet of data center space — sits on Appalachian Piedmont geology with high soil resistivity, dramatically increasing GIC coupling. A Carrington-class event striking this region during peak load would destroy multiple substation transformers simultaneously. Replacement timeline during a global transformer shortage: 6-18 months.

**Without cloud computing during a Carrington event, the digital economy collapses.** AWS hosts 31% of global cloud infrastructure, including critical workloads for finance, healthcare, government, defense, logistics, and communications. An AWS outage of more than 24-48 hours triggers cascading failures across every sector that depends on cloud services — which is essentially every sector.

## 2. THE ACS SOLUTION

**Phase 1: Substation-Level NBC Installation.** Neutral-blocking capacitors at every AWS regional primary substation (31 locations). Each NBC costs $2.2-4.1M installed, depending on transformer MVA rating. Validated by EPRI 2024 GMD Mitigation Guidelines. Blocks >95% of quasi-DC GIC current.

**Phase 2: AZ-Level Protection.** Extended NBC protection to individual Availability Zone substations in high-risk geomagnetic latitudes (>40 degrees — Northern Europe, Northern US, Northern China, Japan regions).

**Phase 3: Generator Control and Cooling Protection.** GIC-hardened ATS controllers that detect GIC and isolate generator control bus within 50 ms. Power conditioning for immersion cooling pump drives with MXene-based filtering and 30-second ride-through.

**Phase 4: Rack-Level PDU Protection.** GIC-rated power distribution units with MXene DC-link capacitors at server rack level, protecting individual power supplies from harmonic-rich GIC-disturbed power.

**Phase 5: Protonic Backup Communications.** CSM-PC-5000 network linking AWS regional facilities with GIC-immune communication for failover coordination when fiber and radio fail.

## 3. WILLIAMS HEURISTIC — PLAIN LANGUAGE

Data centers are buildings full of computers that need perfect electricity. During a solar storm, the electricity coming from the grid becomes "dirty" — full of distortion that can damage the computers' power supplies and the transformers feeding the building. We stop the dirty electricity at the building's main power connection (where the transformer is), filter what gets through to the computers, and make sure backup generators actually work during the storm. The internet runs on AWS. If AWS goes down, the internet goes down. This is about keeping the lights on for the digital economy.

## 4. FINANCIAL SUMMARY

| Metric | Value |
|--------|-------|
| Total program cost | $558.7M |
| Annual AWS revenue (2025) | ~$105B |
| Program as % of AWS revenue (48 months) | ~0.13%/year |
| Estimated loss prevented (Scenario C) | $18-42B |
| ROI at first event | 32x - 75x |
| NPV at 7% over 25 years | +$8.2B to +$24.1B |

## 5. RECOMMENDED NEXT ACTIONS

1. Executive briefing with Mr. Jassy, Mr. Garman, and AWS Infrastructure leadership (90 minutes)
2. Technical workshop with AWS Infrastructure Engineering and Global Real Estate teams (2 days)
3. GIC vulnerability assessment at us-east-1 (Northern Virginia) and eu-west-1 (Ireland) — ACS-funded demonstration
4. Pilot NBC installation at one us-east-1 AZ substation (target: Month 8)

---

**ACS INFRASTRUCTURE PROTECTION DIVISION**
**Project AEGIS Command Team**
*"The shield before the storm."*
