# Mainframe and Hybrid Cloud Economics: Platform Modernization ROI

**Document ID:** ACS-IBM-MHCE-2026-001  
**Classification:** ACS Internal — Strategic Financial Analysis  
**Date:** July 2026  
**Author:** ACS Financial Intelligence Unit  
**Revision:** 1.8  

---

## Executive Summary

IBM's mainframe and hybrid cloud platform businesses represent the twin engines of near-term cash flow generation that fund the quantum computing and artificial intelligence investments of the next decade. The z17 mainframe cycle, launched in Q4 2025, is the strongest in IBM's recorded history, with 67% year-over-year revenue growth in the launch quarter and 51% sustained growth in Q1 2026. LinuxONE, IBM's Linux-focused mainframe platform, delivers a 65% total cost of ownership advantage over distributed x86 server architectures, positioning it as the definitive solution for data center consolidation at a time when North American data center rental rates have reached $400 per kilowatt per month with record-low vacancy rates.

On the hybrid cloud side, Red Hat OpenShift has reached $1.9 billion in annualized recurring revenue with 30%+ growth, while the acquisitions of HashiCorp (Terraform infrastructure-as-code) and Confluent (real-time data streaming) extend IBM's software portfolio into two of the fastest-growing segments of enterprise IT. Software gross margins of 83.4% provide the profit engine that subsidizes quantum's capital-intensive development cycle, while infrastructure margins improving from 52.8% to 56.9% year-over-year demonstrate operating leverage in the hardware business that underpins mainframe economics.

---

## 1. Mainframe Economics: The z17 Product Cycle

### 1.1 Revenue Growth Trajectory

The z17 mainframe represents the most commercially successful platform launch in IBM's modern history. The revenue ramp has exceeded internal projections and external consensus estimates in every quarter since introduction:

| Quarter | Year | z Systems Revenue Growth (YoY) | Commentary |
|---|---|---|---|
| Q3 2025 | 2025 | +18% | Pre-announcement anticipation; z16 tail demand |
| Q4 2025 | 2025 | +67% | z17 launch; catch-up demand from deferred refresh cycles |
| Q1 2026 | 2026 | +51% | Sustained momentum; broad-based vertical adoption |
| Q2 2026E | 2026 | +38–44% | Normalizing from peak; still historically exceptional |
| FY2026E | 2026 | +42–48% | Full-year projection; strongest mainframe cycle since System/360 |

Three structural factors differentiate the z17 cycle from prior mainframe product introductions:

**AI Inference at the Point of Transaction:** The z17 embeds the IBM Spyre Accelerator, an on-chip AI inference engine that enables real-time fraud detection, anti-money laundering screening, and credit decisioning against transaction data without moving sensitive financial data off-platform. This capability directly addresses regulatory requirements for data residency and latency constraints that preclude cloud-based AI inference for payment processing.

**Quantum-Safe Cryptography Integration:** The z17 is the first enterprise platform to ship with NIST-standardized post-quantum cryptographic algorithms (CRYSTALS-Kyber for key encapsulation and CRYSTALS-Dilithium for digital signatures) implemented in hardware security modules. Financial institutions facing cryptographic migration mandates from FS-ISAC and the European Central Bank view the z17 as a pre-integrated compliance solution, accelerating refresh cycles.

**Data Center Density Economics:** A single z17 frame (39U) can consolidate the workload of 50–200 x86 servers, depending on workload type. At $400/kW/month for colocation power and cooling, and with vacancy rates at historic lows in primary North American markets (Northern Virginia, Santa Clara, Dallas, Chicago all below 3%), the physical footprint savings of mainframe consolidation translate directly to millions in annual operating expenditure reduction.

### 1.2 Installed Base Dynamics: 85% MIPs Retention and Growth

A critical metric for mainframe business health is the behavior of the installed base as measured in MIPs (millions of instructions per second) — the aggregate processing capacity deployed across all customer sites. For the z17 cycle:

- **85% of installed MIPs are maintaining or growing capacity**, indicating that customers are expanding their mainframe footprints, not migrating workloads to alternative platforms.
- **10% of installed MIPs are in gradual decline**, consistent with historical attrition from merger-driven consolidation and legacy application decommissioning.
- **5% of installed MIPs are in active migration**, predominantly to LinuxONE or to IBM Power systems, not to competitor platforms.

This retention profile implies a remaining weighted-average customer lifetime of 18–22 years for z Systems revenue, a duration that supports extremely high customer lifetime value calculations and justifies IBM's continued investment in the platform.

### 1.3 Performance Economics: 130% Program-to-Program vs. z16

The z17 achieves 130% program-to-program throughput improvement compared to the z16, which was itself the strongest performer in the z Systems lineage. This generational improvement is composed of:

| Improvement Source | Contribution | Mechanism |
|---|---|---|
| Telum II processor microarchitecture | +45% | 5nm process (vs. 7nm on z16); 8 cores/chip (vs. 5); 40MB L2 cache (vs. 32MB) |
| Spyre Accelerator integration | +35% | On-chip AI inference for transaction scoring, fraud detection, and data compression |
| Memory subsystem and I/O bandwidth | +25% | DDR5 memory; PCIe Gen 6; 2x memory bandwidth vs. z16 |
| Compiler and middleware optimization | +15% | COBOL and Java just-in-time compilation improvements; z/OS 3.1 scheduler enhancements |
| System-level integration effects | +10% | Combined throughput gains exceeding sum of components due to balanced system design |

For customers running high-volume transaction processing (credit card authorization, securities trade settlement, airline reservation, telecommunications billing), the per-transaction cost reduction of approximately 55–60% (130% more work at similar or slightly higher system cost) provides a compelling financial case for refresh, even for organizations that historically deferred mainframe upgrades.

### 1.4 LinuxONE: Consolidation Economics

LinuxONE, IBM's Linux-optimized mainframe platform, achieves a verified 65% total cost of ownership reduction compared to equivalently provisioned distributed x86 server environments. The TCO analysis incorporates:

**Hardware Acquisition (5-year view):**
- LinuxONE Emperor 4: ~$2.5M (fully configured with 200 IFLs)
- Equivalent x86 footprint: ~$4.8M (200 servers at ~$24K each, fully configured)
- Hardware savings: 48%

**Software Licensing:**
- LinuxONE: RHEL subscription bundled; database and middleware licensing based on core count (fewer, faster cores)
- x86: Per-core licensing on 200+ servers accumulates substantial Oracle, Microsoft, and VMware license cost
- Software savings: 55–65% (varies by ISV licensing model)

**Facilities and Power:**
- LinuxONE: Single 42U rack; approximately 22 kW power draw at full utilization; 10 sq ft footprint
- x86 equivalent: 8+ racks; approximately 85 kW power draw; 80+ sq ft footprint
- At $400/kW/month and $15/sq ft/month: LinuxONE annual facilities cost ~$122K; x86 annual facilities cost ~$534K
- Facilities savings: 77%

**Operational Labor:**
- LinuxONE: 0.5 FTE system administrator for 200 IFLs (high automation, single system image)
- x86: 3–5 FTEs for 200+ servers (provisioning, patching, monitoring, hardware replacement)
- Labor savings: 75–85%

**Availability and Downtime:**
- LinuxONE: 99.999%+ uptime (5.26 minutes unplanned downtime per year)
- x86 cluster: 99.95%–99.99% (requires redundant hardware and complex failover orchestration)
- Cost of downtime for enterprise workloads: $5,600/minute (Gartner IT Key Metrics Data)
- Availability economic advantage for LinuxONE: $200K–$1.5M per year depending on workload criticality

---

## 2. Red Hat and Software Platform Economics

### 2.1 OpenShift: $1.9B ARR at 30%+ Growth

Red Hat OpenShift, IBM's enterprise Kubernetes platform, reached $1.9 billion in annualized recurring revenue in Q1 2026, with sustained growth exceeding 30% year-over-year. OpenShift's economics are structurally advantaged relative to competing Kubernetes distributions:

**Revenue Composition:**
- Core OpenShift Container Platform subscriptions: ~55% of ARR ($1.05B)
- OpenShift AI / OpenShift Data Science: ~18% of ARR ($340M) — fastest-growing segment
- OpenShift Virtualization: ~12% of ARR ($230M) — VMware displacement driver
- OpenShift Service Mesh and Serverless: ~8% of ARR ($150M)
- Ansible Automation Platform (bundled/adjacent): ~7% of ARR ($130M)

**Competitive Positioning:**
- OpenShift commands a 40–50% price premium over vanilla Kubernetes distributions (Rancher, D2iQ) but delivers 60–70% lower operational cost through integrated security, compliance, and lifecycle management
- The Broadcom-VMware acquisition (2023) triggered a wave of enterprise VMware-to-OpenShift Virtualization migration evaluations, with IBM reporting a 300% increase in OpenShift Virtualization pipeline since Q1 2024
- Major hyperscaler Kubernetes services (EKS, AKS, GKE) compete on initial adoption but lose on multi-cloud consistency and enterprise support; OpenShift is the only platform that delivers an identical Kubernetes experience across on-premises, AWS, Azure, GCP, IBM Cloud, and edge environments

**Economic Model:**
- OpenShift subscription gross margins: 85–88%
- Customer acquisition cost (CAC) payback period: 14–18 months (enterprise SaaS median: 18–24 months)
- Net revenue retention: 120–125% (indicating strong expansion within existing accounts)
- Lifetime value to CAC ratio: 8:1 to 10:1

### 2.2 Red Hat Enterprise Linux (RHEL): The Subscription Foundation

RHEL remains the stable, cash-generative foundation of Red Hat's business, with approximately $4.5B–$5.0B in annual revenue and mid-single-digit growth augmented by price increases and workload expansion. RHEL's economic contribution to IBM extends beyond direct revenue:

- RHEL subscriptions create cross-sell pathways to OpenShift, Ansible, and OpenShift AI
- RHEL's market share in enterprise Linux (estimated 60–65% of paid Linux server operating system deployments) provides unmatched visibility into enterprise IT infrastructure planning
- RHEL's position as the default operating system for all major cloud providers ensures IBM's relevance in cloud-native infrastructure regardless of which hyperscaler wins a given workload

### 2.3 Ansible Automation Platform

Ansible Automation Platform contributes approximately $800M–$1.0B in annual recurring revenue with growth exceeding 25%. The economic thesis:

- Enterprise IT organizations managing 1,000+ servers spend an estimated 30–40% of operational labor on manual configuration, compliance remediation, and incident response — all addressable through Ansible automation
- Typical Ansible deployment delivers 60–80% reduction in manual operational tasks, translating to $500K–$2M annual savings for a mid-market enterprise and $5M–$20M for Global 2000 organizations
- Ansible's agentless architecture creates zero marginal cost of deployment, enabling rapid expansion through existing RHEL and OpenShift accounts

### 2.4 OpenShift AI and the Enterprise AI Platform Opportunity

OpenShift AI, Red Hat's platform for deploying, managing, and scaling machine learning workloads, represents the highest-growth vector within the Red Hat portfolio. Revenue is estimated at $340M ARR with growth exceeding 50%:

- Addresses enterprise demand for on-premises and hybrid AI/ML infrastructure that cannot use public cloud AI services due to data sovereignty, latency, or regulatory constraints
- Integrates with IBM watsonx for model development and governance, creating a full-stack enterprise AI platform that spans infrastructure (OpenShift AI), model development (watsonx.ai), data management (watsonx.data), and governance (watsonx.governance)
- GPU-as-a-Service capabilities on OpenShift AI enable enterprises to share expensive GPU infrastructure across data science teams, improving utilization rates from 25–35% (dedicated GPU workstations) to 60–80% (shared, scheduled clusters)

---

## 3. Strategic Acquisitions: M&A Economics

### 3.1 HashiCorp: Infrastructure-as-Code Platform

IBM's acquisition of HashiCorp (announced 2024, closed 2025) for approximately $6.4 billion (enterprise value) brought Terraform, the industry-standard infrastructure-as-code platform, into IBM's software portfolio. The acquisition economics:

**Standalone HashiCorp Metrics (at acquisition):**
- Revenue: ~$600M annualized, growing 20–25%
- Terraform Cloud/Terraform Enterprise: ~$400M ARR
- Vault (secrets management): ~$150M ARR
- Boundary, Consul, Nomad, Packer: ~$50M ARR
- Gross margin: 80%+
- Operating margin: negative (pre-acquisition), reflecting standalone growth investment

**Post-Acquisition Synergies:**
- Terraform's ubiquity in infrastructure provisioning (~70% of infrastructure-as-code deployments use Terraform HCL) provides IBM with visibility into and influence over the infrastructure provisioning decisions of virtually every major enterprise
- HashiCorp Configuration Language (HCL) and Terraform providers for IBM Cloud, IBM Power, and IBM z Systems create native provisioning pathways that competitors cannot replicate
- Ansible + Terraform integration: Terraform provisions the infrastructure; Ansible configures the software — together they form a complete GitOps pipeline for hybrid cloud infrastructure
- Revenue synergy estimate: $300M–$500M incremental annual IBM revenue within three years through cross-sell and bundling
- Cost synergy estimate: $150M–$200M annual savings through G&A consolidation and cloud infrastructure optimization

**Implied acquisition multiple:** 10.7x revenue (pre-synergy); 6.5x revenue (post-synergy, year 3). Comparable to median infrastructure software M&A multiples of 8–12x.

### 3.2 Confluent: Data Streaming for Real-Time AI

IBM's acquisition of Confluent (speculative, under evaluation as of 2026) would bring Apache Kafka and the Confluent Cloud data streaming platform into IBM's portfolio. The strategic and economic rationale:

**Standalone Confluent Metrics (2025 estimates):**
- Revenue: ~$1.0B–$1.2B annualized, growing 25–30%
- Confluent Cloud: ~55% of revenue; Confluent Platform (on-premises): ~45%
- Gross margin: 70–75% (cloud mix diluting from on-premises 85%+)
- Net revenue retention: 125–130%
- Market capitalization: $10B–$14B (volatile, as of mid-2026)

**Strategic Rationale:**
- Real-time data streaming is the ingestion layer for AI workloads; every enterprise deploying AI at scale requires a streaming data infrastructure to feed models with current data
- Confluent's Kafka protocol is the industry standard for event streaming, with 80%+ of Fortune 500 companies using Kafka in some capacity
- Integration with IBM watsonx, IBM Event Automation, and IBM MQ creates a unified enterprise data-in-motion platform that spans legacy messaging (MQ), event processing (Event Automation), and modern streaming (Confluent/Kafka)
- Competitive counter to hyperscaler managed Kafka services (Amazon MSK, Azure Event Hubs, Google Pub/Sub) that commoditize the streaming layer

**Economic Impact:**
- Estimated acquisition enterprise value: $12B–$14B (25–30% premium to pre-announcement market capitalization)
- Revenue synergy: $400M–$700M incremental IBM revenue within three years (bundled IBM-Confluent deals, IBM Consulting implementation pull-through)
- Implied post-synergy acquisition multiple: 8–10x revenue
- Integration risk: moderate — Confluent operates as an independent entity under IBM, similar to Red Hat model

---

## 4. Margin Expansion Dynamics

### 4.1 Segment Margin Analysis

IBM's financial performance reflects a deliberate shift toward higher-margin software and services revenue, with infrastructure margins improving through product cycle effects and manufacturing efficiency:

| Segment | Q4 2025 Gross Margin | Q1 2026 Gross Margin | Prior Year Comparison | Margin Driver |
|---|---|---|---|---|
| Software | 83.4% | 83.1% | +80 bps YoY | Recurring revenue mix; Red Hat scale; SaaS transition |
| Consulting | 28.7% | 28.2% | +120 bps YoY | Higher utilization; automation-driven delivery |
| Infrastructure | 52.8% | 56.9% | +410 bps YoY | z17 cycle; manufacturing efficiency; supply chain normalization |
| Financing | 48.5% | 47.9% | +60 bps YoY | Interest rate environment; credit quality |

**Software gross margins at 83.4%** represent the highest-margin segment in IBM's portfolio and the primary engine of consolidated margin expansion. Software comprises approximately 45% of IBM's total revenue but contributes an estimated 65% of gross profit. The shift toward subscription and SaaS revenue models (from perpetual license plus maintenance) creates near-term revenue recognition headwinds but medium-term margin tailwinds as sales and marketing efficiency improves with recurring revenue visibility.

**Infrastructure gross margins improving from 52.8% to 56.9%** reflect the powerful product cycle economics of the z17 mainframe. New mainframe product introductions typically drive 300–600 basis points of margin expansion in the infrastructure segment over the subsequent six to eight quarters, as manufacturing yields improve, component costs decline, and the revenue mix shifts toward higher-margin capacity upgrades and software bundles.

### 4.2 Consolidated Margin Trajectory

| Year | Revenue Mix | Gross Margin | Operating Margin | EPS | Commentary |
|---|---|---|---|---|---|
| 2023 | 42% SW / 32% Consulting / 26% Infra | 55.3% | 16.2% | $9.27 | Base year; pre-z17 |
| 2024 | 44% SW / 31% Consulting / 25% Infra | 56.8% | 17.5% | $10.21 | Software acceleration; consulting growth |
| 2025 | 45% SW / 30% Consulting / 25% Infra | 58.2% | 18.8% | $11.35 | z17 launch; Red Hat momentum |
| 2026E | 47% SW / 29% Consulting / 24% Infra | 59.5% | 19.7% | $12.50–$13.00 | Full z17 year; software margin expansion |
| 2027E | 49% SW / 28% Consulting / 23% Infra | 60.8% | 20.5% | $13.50–$14.25 | Software >50% of revenue; consulting efficiency gains |

The long-term margin target of 65%+ gross margin and 25%+ operating margin (IBM's stated medium-term objectives) is achievable by 2028–2030, driven primarily by software mix shift and infrastructure margin normalization at the higher post-z17 base.

---

## 5. Data Center Consolidation and Facilities Economics

### 5.1 The Data Center Capacity Crisis

North American data center markets face a structural supply-demand imbalance that directly advantages IBM's mainframe consolidation value proposition:

| Colocation Market | Q1 2026 Vacancy Rate | Rental Rate ($/kW/month) | YoY Rate Increase | Pipeline (MW, under construction) |
|---|---|---|---|---|
| Northern Virginia | 0.8% | $175–$225 | +18% | 1,200 MW |
| Santa Clara / Silicon Valley | 1.2% | $275–$350 | +22% | 180 MW (land-constrained) |
| Dallas / Fort Worth | 2.1% | $145–$185 | +15% | 450 MW |
| Chicago | 1.8% | $155–$195 | +16% | 320 MW |
| Phoenix | 2.5% | $140–$180 | +14% | 600 MW |
| Atlanta | 1.5% | $150–$190 | +17% | 280 MW |
| Frankfurt | 1.0% | €200–€280 | +20% | 250 MW |
| London | 1.5% | £180–£250 | +18% | 200 MW |
| Singapore | 0.5% | S$350–S$450 | +25% | 80 MW (land-constrained) |

The drivers of this crisis are structural and likely to persist:
- Hyperscaler (AWS, Azure, GCP) absorption of available capacity: the three major cloud providers leased an estimated 4,500 MW of incremental capacity in 2025 alone
- AI/GPU workload density: a single NVIDIA H100 server rack draws 40–60 kW, compared to 5–10 kW for a typical enterprise server rack — dramatically accelerating power capacity absorption
- Power utility interconnection delays: new data center projects in Northern Virginia face 3–5 year timelines for utility power delivery, creating a supply response lag
- Land and zoning constraints in primary markets: Santa Clara has effectively banned new data center construction above 5 MW; Loudoun County, Virginia, has imposed moratoriums and height restrictions

### 5.2 Mainframe Consolidation Financial Model

For a representative enterprise operating 500 x86 servers across two colocation facilities:

**Pre-Consolidation x86 Environment (Annual Cost):**
- Hardware depreciation/lease: $2.4M (500 servers × $24K ÷ 5 years)
- Facilities (power + space): $1.1M (500 servers × 400W average draw × $400/kW/month + 2,500 sq ft × $15/sq ft/month)
- Software licensing: $3.2M (OS, database, middleware, virtualization, monitoring)
- Operational labor: $1.5M (7 FTEs at $215K fully loaded)
- Maintenance and support: $1.0M
- **Total Annual Cost: $9.2M**

**Post-Consolidation LinuxONE Environment (Annual Cost):**
- Hardware depreciation/lease: $0.9M (3 × LinuxONE Emperor 4 ÷ 5 years, redundant configuration)
- Facilities (power + space): $0.18M (3 frames × 6.5 kW average draw × $400/kW/month + 30 sq ft × $15/sq ft/month)
- Software licensing: $1.4M (reduced core-count licensing; IBM bundled software)
- Operational labor: $0.4M (2 FTEs at $215K fully loaded)
- Maintenance and support: $0.35M (IBM maintenance inclusive for years 1–3)
- **Total Annual Cost: $3.23M**

**Annual Savings: $5.97M (65% reduction)**

**Three-Year Cumulative Savings (including migration cost):**
- Year 1: $2.5M ($5.97M savings − $3.5M one-time migration services)
- Year 2: $6.0M
- Year 3: $6.3M (incremental savings from optimized operations)
- Three-Year Cumulative: $14.8M
- Payback Period: 7 months (from go-live; 11 months from project initiation)

This model is representative of mid-market to enterprise deployments; larger deployments (1,000+ x86 servers) typically achieve 68–72% savings due to greater consolidation density and proportionally lower per-unit migration costs.

---

## 6. Strategic Implications and Recommendations

### 6.1 The Mainframe-Hybrid Cloud-Quantum Bridge

IBM's platform strategy is architecturally coherent in a way that competitors cannot replicate:

1. **Mainframe (z17/LinuxONE):** The transactional and data-sovereignty platform. Runs mission-critical workloads with five-nines availability and integrated AI inference. Generates the predictable cash flow that funds quantum investment.

2. **Hybrid Cloud (Red Hat OpenShift/Ansible/Terraform):** The application deployment and infrastructure automation platform. Provides the consistent operating environment across on-premises, edge, and multi-cloud deployments. Drives software revenue growth and margin expansion.

3. **Quantum (Qiskit/Quantum System Two/Starling):** The computational acceleration platform. Offloads specific high-value optimization, simulation, and machine learning workloads from classical infrastructure. The long-term growth and valuation driver.

4. **AI (watsonx/Spyre/OpenShift AI):** The intelligence layer that spans all three platforms. Embedded in the mainframe for transaction-time inference, deployed on OpenShift for enterprise AI/ML workloads, and accelerated by quantum for specialized computational subroutines.

The integration of these four platforms creates a technology stack that addresses enterprise computing requirements from the most fundamental (reliable transaction processing) to the most advanced (quantum-accelerated molecular simulation), with IBM capturing margin at every layer.

### 6.2 For ACS Advisory Clients

1. **Mainframe accounts should accelerate z17 refresh cycles.** The combination of 55–60% per-transaction cost reduction, integrated AI inference, and quantum-safe cryptography creates a compelling financial and risk-management case for immediate upgrade, even outside normal refresh cycles.

2. **x86-heavy enterprises should commission LinuxONE TCO analyses.** At $400/kW/month data center rates and 65% verified TCO reduction, LinuxONE consolidation is among the highest-return infrastructure investments available. The migration business case typically pays back within 12 months.

3. **VMware-dependent enterprises should evaluate OpenShift Virtualization.** Broadcom's VMware licensing changes (per-core pricing, bundle mandates) have increased VMware total cost of ownership by 200–400% for many enterprises. OpenShift Virtualization provides a credible migration path with 40–60% cost savings and enhanced multi-cloud portability.

4. **Infrastructure and operations leaders should adopt Ansible + Terraform as the standard automation fabric.** The HashiCorp acquisition creates an end-to-end infrastructure-as-code and configuration management platform that is unmatched in the market. Enterprises standardizing on this stack will achieve 60–80% operational labor reduction and improved security posture through codified compliance.

5. **AI infrastructure planners should evaluate OpenShift AI for GPU workload orchestration.** GPU sharing and scheduling on OpenShift AI can improve GPU utilization from 25–35% to 60–80%, reducing the capital intensity of enterprise AI deployment while providing a platform that spans on-premises, cloud, and edge environments.

---

## Appendix A: Key Assumptions

1. z17 product cycle follows historical pattern: 6–8 quarters of elevated growth followed by normalization to mid-single-digit growth by late 2027
2. Data center rental rates increase 8–12% annually through 2030, driven by hyperscaler demand and constrained supply
3. LinuxONE TCO advantage of 65% is sustained through 2030 as x86 server and licensing costs inflate
4. Red Hat revenue growth of 25–30% is sustained through 2028, moderating to 18–22% by 2030
5. HashiCorp and Confluent acquisitions are integrated under the Red Hat model (independent operation within IBM)
6. No material change to data sovereignty regulations that would disadvantage mainframe or hybrid cloud deployment models

## Appendix B: References

- IBM Annual Report, Fiscal Year 2025
- IBM Q1 2026 Earnings Release and Supplemental Information
- IBM z17 Announcement Materials, October 2025
- IBM LinuxONE Emperor 4 TCO Study, IBM Systems Group (2025)
- Red Hat Annual Report, Fiscal Year 2025 (Red Hat, Inc. SEC Filings)
- CBRE, "North America Data Center Trends, Q1 2026"
- JLL, "Global Data Center Outlook, 2026"
- Gartner, "IT Key Metrics Data 2026"
- Synergy Research Group, "Hyperscaler Data Center Capex, 2025 Full Year"
- ACS Internal Financial Model: IBM Segment Economics and Margin Projections (v3.7)

---

*This document is produced by ACS Financial Intelligence Unit for internal and client advisory purposes. All projections are based on publicly available information and ACS proprietary analysis. This document does not constitute investment advice.*
