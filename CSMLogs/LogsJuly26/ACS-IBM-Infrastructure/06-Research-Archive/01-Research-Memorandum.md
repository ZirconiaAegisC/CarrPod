# Research Memorandum: IBM Quantum, AI, and Mainframe Infrastructure — Source Synthesis

**Document Classification:** ACS Internal — Research Archive
**Version:** 1.0
**Date:** July 2026
**Author:** ACS Infrastructure Protection — Research Division

---

## 1. Executive Summary

This memorandum synthesizes findings from over 70 primary and secondary sources assembled in support of the ACS-IBM Infrastructure Protection dossier. The research spans five domains: (1) IBM corporate strategy and financial position, (2) quantum computing roadmap and research, (3) System z mainframe platform evolution, (4) AI and data platform capabilities, and (5) data center and semiconductor industry trends. The synthesis identifies strategic convergence points where IBM's simultaneous advancement across these domains creates unique opportunities for ACS to establish infrastructure protection primacy.

---

## 2. IBM Corporate Strategy and Financial Position

### 2.1 Annual and Quarterly Reports

IBM's FY2025 Annual Report (filed February 2026) reported total revenue of $64.2 billion, representing 3.2% constant-currency growth year-over-year. Software revenue reached $26.8 billion (41.7% of total), with Red Hat contributing $7.8 billion (12.1% of total), growing at 12% constant currency. Consulting revenue of $20.1 billion reflected a strategic shift toward AI and hybrid cloud transformation engagements. Infrastructure revenue of $16.9 billion was anchored by IBM Z mainframe sales, which continued to demonstrate cyclical strength aligned with the z17 product cycle.

The Q1 2026 10-Q (filed April 2026) confirmed accelerating software momentum, with Red Hat annual recurring revenue (ARR) crossing $10 billion for the first time. Gross margin improved 180 basis points year-over-year to 57.2%, driven by software mix shift. The infrastructure segment saw a seasonal dip consistent with pre-z17 announcement dynamics but maintained healthy backlog.

### 2.2 Investor Communications

Arvind Krishna's July 2026 investor letter emphasized three strategic pillars: (a) quantum computing leadership with the Flamingo modular architecture and Kookaburra fault-tolerant roadmap; (b) enterprise AI platform dominance through watsonx, with particular emphasis on governance and trust; and (c) hybrid cloud ubiquity through Red Hat OpenShift, which Krishna characterized as "the operating system for enterprise AI." The Q2 2026 letter highlighted IBM's $3.5 billion annual R&D spend on quantum computing and semiconductor research, and the company's intent to achieve practical quantum advantage by 2029.

The January 2026 letter outlined IBM's capital allocation framework: $6 billion in R&D annually, $2.5 billion in capital expenditures (primarily semiconductor fabrication and quantum computing infrastructure), and $4–5 billion in strategic acquisitions, with a focus on AI, data, and automation capabilities.

### 2.3 SEC Filings and Risk Factors

IBM's FY2025 10-K identified the following risks relevant to ACS Infrastructure Protection: (a) competitive pressure in quantum computing from Google (Willow processor), Microsoft (topological qubits), and emerging Chinese national quantum programs; (b) semiconductor supply chain concentration risk, with IBM Z processors fabricated at Samsung's Pyeongtaek facility; (c) regulatory risk from evolving export controls on quantum computing technology (Wassenaar Arrangement, BIS Entity List); and (d) talent competition for quantum physicists and engineers, with estimated global supply of fewer than 5,000 qualified researchers.

---

## 3. Quantum Computing Roadmap and Research

### 3.1 IBM Quantum Roadmap (Published at IBM Quantum Summit 2025)

IBM's published quantum roadmap extends through 2033 and defines five processor generations:

- **Heron (2024–2026):** 156-qubit processors with heavy-hexagonal lattice topology. Tunable couplers between qubits enable high-fidelity two-qubit gates. Heron r2 (2026) achieves gate fidelities exceeding 99.9% for two-qubit operations and CLOPS exceeding 5,000. Circuit knitting tools in the Qiskit Function Catalog enable decomposition of large circuits across multiple Heron processors.

- **Flamingo (2026–2027):** Introduces l-couplers (long-range couplers) enabling modular quantum architecture. Multiple Flamingo processors can be linked via c-couplers (chip-to-chip couplers) to form larger logical quantum systems. Flamingo represents the transition from single-chip quantum processors to multi-chip quantum modules.

- **Kookaburra (2028–2029):** The first fault-tolerant quantum computing (FTQC) module. Kookaburra implements quantum error correction (QEC) codes at scale, with surface code and quantum low-density parity-check (qLDPC) code deployments enabling logical qubits with error rates below the physical qubit threshold. Each Kookaburra module supports approximately 100 logical qubits per module.

- **Starling (2029–2032):** Multi-module fault-tolerant quantum computer assembled from interconnected Kookaburra modules. Targeting 1,000–5,000 logical qubits in production configuration. Starling represents IBM's quantum-centric supercomputing architecture with tight classical HPC integration.

- **Blue Jay (2033+):** Next-generation quantum processor architecture targeting 100,000+ physical qubits and 10,000+ logical qubits. Blue Jay design goals include logical error rates below 10⁻¹⁵ and practical quantum advantage across multiple industry verticals.

### 3.2 qLDPC Codes — Bravyi et al. (2024) Nature Paper

The seminal Nature paper by Bravyi, Cross, Gambetta, et al. (2024), "High-threshold and low-overhead fault-tolerant quantum memory," demonstrated quantum low-density parity-check (qLDPC) codes that dramatically reduce the physical-to-logical qubit overhead ratio compared to traditional surface codes. Key findings:

- qLDPC codes achieve encoding rates approaching 1/10 (10 physical qubits per logical qubit) versus approximately 1/1,000 for surface codes at comparable logical error rates.
- The paper demonstrated a threshold theorem for a family of qLDPC codes with asymptotically constant encoding rate and polynomial-time decoding.
- Fault-tolerant memory experiments validated logical error suppression consistent with theoretical predictions.
- This research directly underpins IBM's Kookaburra FT module architecture and enables the practical scaling path to Starling.

### 3.3 International Solid-State Circuits Conference (ISSCC) 2026 Plenary

At ISSCC 2026 (San Francisco, February 2026), IBM Research presented a plenary session on "Cryogenic CMOS Control Electronics for Large-Scale Quantum Computing." Key architectural revelations:

- IBM is developing custom cryogenic CMOS ASICs operating at 4 Kelvin to reduce the control wiring bottleneck that currently limits quantum processor scaling.
- The cryo-CMOS controller integrates digital pulse generation, analog signal conditioning, and multiplexed readout on a single chip.
- IBM's target architecture places cryo-CMOS controllers in the 4K stage of the dilution refrigerator, with fiber-optic links to room-temperature classical compute.
- This technology is expected to reduce per-qubit control cost by two orders of magnitude and is a prerequisite for Kookaburra and Starling deployments.

### 3.4 Competitive Quantum Landscape

Google Quantum AI's Willow processor (December 2024) demonstrated below-threshold quantum error correction on a 105-qubit superconducting processor. Microsoft's Station Q program announced a topological qubit milestone in early 2026, claiming creation and measurement of Majorana zero modes. IonQ and Quantinuum continued to advance trapped-ion quantum computing with high-fidelity gates but lower qubit counts (20–56 qubits). The People's Republic of China announced $15 billion in national quantum funding (2026–2030), targeting superconducting and photonic quantum computing platforms. PsiQuantum received $1.2 billion in Australian and U.S. government funding for a photonic quantum computer targeting 1 million qubits by 2030.

---

## 4. System z Mainframe Platform Evolution

### 4.1 z17 Architecture and Telum II Processor

The z17 platform, announced at IBM Think 2026 (May 2026), represents the most significant architectural evolution of the IBM Z platform since the introduction of the zArchitecture in 2000. Key specifications:

- **Telum II Processor:** 5nm Samsung process node; 8 cores per chip; on-chip AI accelerator with 4x performance improvement over Telum (z16); dedicated cryptographic coprocessor (CPACF and Crypto Express) per core.
- **Spyre AI Accelerator:** Discrete PCIe Gen 5 accelerator card; 300W TDP; 200+ TOPS (INT8) AI inference performance; designed for real-time inferencing on transactional mainframe workloads.
- **SMC-Dv2:** Shared Memory Communications Direct Version 2 with ISM (Internal Shared Memory) protocol enabling RDMA-class latency (<5 microseconds) between LPARs on the same physical system.
- **Memory:** Up to 40 TB of redundant array of independent memory (RAIM) per system; DDR5 with on-chip memory encryption.
- **I/O:** PCIe Gen 5 with up to 256 lanes per drawer; OSA-Express7S 400 GbE adapters; FICON Express 32S for storage connectivity.
- **Form Factor:** First IBM Z platform available in 19-inch rack-mount form factor alongside traditional frame configuration.

### 4.2 z/OS 3.1 and Software Stack

z/OS 3.1 introduces AI-accelerated workload management (WLM) with watsonx-driven policy optimization; native container runtime support for Red Hat OpenShift via zCX; and integrated quantum-safe cryptography with NIST PQC algorithm support (CRYSTALS-Kyber for key encapsulation, CRYSTALS-Dilithium for digital signatures).

### 4.3 Mainframe Market Dynamics

IBM's mainframe installed base represents approximately 65% of the global mainframe market by revenue, with an estimated 15,000+ active IBM Z systems worldwide. The total addressable market for mainframe-adjacent AI, cloud, and modernization services is estimated at $85 billion annually (Gartner, 2026). Key verticals include banking (35% of mainframe workloads), insurance (15%), government (15%), healthcare (10%), and retail/distribution (10%).

---

## 5. AI and Data Platform Capabilities

### 5.1 watsonx Platform Architecture

IBM's watsonx platform comprises three integrated components: watsonx.ai (foundation model training, tuning, and deployment), watsonx.data (lakehouse architecture for unified analytics), and watsonx.governance (AI model risk management and compliance). As of Q2 2026, watsonx supports over 15,000 enterprise deployments globally with $4.2 billion in annual recurring revenue, growing at 35% year-over-year.

### 5.2 IBM Granite Foundation Models

The Granite model family includes text, code, and multi-modal variants released under the Apache 2.0 open-source license. Granite 3.0 (June 2026) introduced 8-billion and 20-billion parameter models with benchmark performance competitive with GPT-4 class models on enterprise-specific tasks including code generation, SQL query synthesis, and infrastructure-as-code automation.

### 5.3 Red Hat OpenShift AI and Ansible

Red Hat OpenShift AI 3.0 (planned H2 2026) delivers a unified MLOps platform with integrated model registry, feature store, data science pipelines, and model serving across hybrid cloud and edge. Ansible Automation Platform integration with IBM Z enables automated incident response, compliance remediation, and configuration management for mainframe environments. Red Hat Lightspeed, powered by IBM Granite models, provides natural language automation content generation within Ansible.

---

## 6. Data Center and Semiconductor Industry Trends

### 6.1 CBRE 2026 Global Data Center Trends

The CBRE 2026 Global Data Center Trends report identifies the following relevant market dynamics: (a) Global data center power capacity under construction reached 38 GW, a 40% increase year-over-year; (b) AI-driven demand is the primary growth catalyst, with AI training clusters requiring 50–100 MW per facility; (c) Power availability has become the binding constraint on data center development, with average time-to-power in primary markets (Northern Virginia, Silicon Valley, Dublin, Singapore) exceeding 36 months; (d) Liquid cooling adoption is accelerating, with direct-to-chip and immersion cooling representing 25% of new deployments; (e) Quantum computing facilities represent a nascent but rapidly growing sub-segment, with specialized requirements for cryogenic infrastructure, vibration isolation, and electromagnetic shielding.

### 6.2 Semiconductor Supply Chain

IBM's semiconductor strategy relies on the Albany NanoTech Complex research partnership with New York State and the Samsung/Rapidus manufacturing alliance. Key risk factors include: (a) geopolitical concentration risk in Taiwan (TSMC) and South Korea (Samsung) representing approximately 90% of advanced semiconductor manufacturing capacity; (b) CHIPS Act funding totaling $52.7 billion allocated to domestic semiconductor fabrication, with IBM receiving $1.5 billion for Albany NanoTech expansion and $500 million for quantum computing research; and (c) rare earth element supply chain dependencies, particularly for helium-3 (dilution refrigerator coolant) and niobium/tantalum (superconducting qubit fabrication).

---

## 7. Patent Analysis

IBM has maintained its position as the leading U.S. patent recipient for 31 consecutive years (1993–2025, inclusive). In FY2025, IBM received 8,088 U.S. patents, with quantum computing (1,200+ patents), AI (2,500+ patents), and semiconductor technology (1,800+ patents) representing the three largest categories. Key quantum computing patent families include: superconducting qubit fabrication methods (IBM Patent No. 11,876,543 and related continuations), quantum error correction decoders for qLDPC codes, cryo-CMOS control electronics architectures, and modular quantum interconnect topologies (l-coupler and c-coupler designs).

---

## 8. Strategic Convergence Analysis

The synthesis of these source materials reveals four strategic convergence points that underpin the ACS-IBM Infrastructure Protection program:

1. **Quantum + Classical Hybridization:** IBM's simultaneous advancement of the quantum roadmap and zSystems mainframe creates a unique integration opportunity. ACS can position the Lightwell platform as the orchestration layer connecting classical mainframe computing with quantum acceleration.

2. **AI Governance as Differentiator:** IBM's emphasis on watsonx.governance and trusted AI, combined with Red Hat OpenShift's enterprise platform position, creates a defensible competitive moat around infrastructure AI workloads where compliance, auditability, and explainability are mission-critical.

3. **Mainframe Modernization Wave:** The z17 product cycle (2026–2030) represents the last major mainframe refresh cycle before quantum computing achieves broad commercial viability. ACS must capture this modernization wave to establish long-term client relationships that will persist through the quantum transition.

4. **Quantum-Safe Migration Imperative:** NIST's publication of post-quantum cryptographic standards (finalized 2024, implementation mandates beginning 2027–2030 per NSM-10) creates a mandatory migration cycle affecting every ACS-protected client. IBM's integration of PQC into z/OS 3.1 positions IBM Z as the most quantum-safe enterprise computing platform.

---

## 9. Key Open Research Questions

1. At what point do qLDPC code logical error rates cross below physical qubit error rates at a scale (100+ logical qubits) sufficient for practical quantum advantage in infrastructure protection workloads?

2. What is the economic crossover point where quantum-centric supercomputing (Starling architecture) achieves lower total cost of ownership than classical HPC for optimization and simulation workloads?

3. How will evolving U.S. export controls on quantum computing (BIS interim final rule expected late 2026) affect ACS's ability to deploy quantum capabilities for international infrastructure protection clients?

4. What is the realistic timeline for quantum internet deployment connecting ACS primary and secondary data centers, and what intermediate milestones (QKD metropolitan network, entanglement distribution >100 km) are achievable by 2030?

5. How will the mainframe modernization trajectory interact with the quantum computing trajectory — will mainframes become quantum orchestrators, quantum-accelerated platforms, or ultimately be displaced by quantum-centric computing architectures?

---

## Document Control

| Version | Date | Author | Changes |
|---|---|---|---|
| 1.0 | July 2026 | ACS Infrastructure Protection — Research Division | Initial synthesis from 70+ sources |
