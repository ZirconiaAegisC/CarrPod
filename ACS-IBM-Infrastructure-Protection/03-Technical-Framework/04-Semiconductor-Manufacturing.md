# Semiconductor Manufacturing and Supply Chain Infrastructure

**Classification: CONFIDENTIAL — Infrastructure Protection Dossier**
**Document ID: ACS-IBM-SCMS-2026-004**
**Date: July 2026**
**Version: 1.4**

---

## Executive Summary

IBM's semiconductor manufacturing infrastructure spans the full lifecycle from fundamental materials research through high-volume processor fabrication, with a strategic emphasis on domestic U.S. production capacity. The Anderon quantum wafer foundry in Poughkeepsie, New York — the world's first pure-play quantum processor fabrication facility — anchors a broader manufacturing ecosystem that includes the production of advanced logic processors (Telum II), AI accelerators (Spyre), and next-generation nanosheet transistor technology. Supported by approximately $1 billion in CHIPS and Science Act incentives and matching IBM investment, this manufacturing infrastructure addresses multiple national priorities: domestic production of advanced semiconductors, supply chain resilience for critical computing infrastructure, and the development of a quantum computing industrial base. This document provides a comprehensive assessment of IBM's semiconductor manufacturing capabilities, fabrication processes, CHIPS Act partnerships, and supply chain resilience strategy.

---

## 1. The Anderon Quantum Wafer Foundry

### 1.1 Facility Overview

The Anderon facility, located on IBM's Poughkeepsie, New York campus, is the world's first semiconductor fabrication plant dedicated exclusively to the production of superconducting quantum processor wafers. Named after IBM physicist Charles H. Anderson, whose pioneering work in Josephson junction physics laid the foundation for superconducting qubit fabrication, the Anderon foundry represents a fundamental departure from conventional semiconductor manufacturing — both in the materials and processes employed and in the strategic purpose of the facility.

**Investment and Scale:** The facility represents a combined investment of approximately $2 billion, funded through $1 billion in CHIPS and Science Act incentives administered by the U.S. Department of Commerce and a matching $1 billion commitment from IBM. The foundry encompasses approximately 150,000 square feet of cleanroom space operating at ISO Class 4 (fewer than 352 particles of ≥0.5μm per cubic meter) and below, with specialized bays for electron-beam lithography, thin-film deposition, reactive ion etching, and metrology — all operating under the cryogenic-specific cleanliness requirements demanded by superconducting circuit fabrication.

**Production Capacity:** At full operational scale, projected for 2027-2028, the Anderon facility is expected to produce 5,000-10,000 quantum processor wafers annually. Given that a single wafer yields multiple processor dice (the exact count depending on processor generation — a Heron-class 133-qubit processor occupies a smaller die area than a Kookaburra-class LPU with its additional control and readout infrastructure), this production capacity supports the deployment of thousands of quantum systems per year across IBM's global quantum data center footprint and customer on-premises installations.

### 1.2 Fabrication Process

Unlike conventional CMOS semiconductor fabrication, which operates at dimensions approaching atomic scales (3nm gate lengths in leading-edge logic nodes), superconducting qubit fabrication operates at feature sizes in the range of 100-500 nanometers — larger than mature CMOS nodes but requiring materials science and process control that are qualitatively different from silicon transistor manufacturing.

**Substrate:** Quantum processor fabrication begins with high-resistivity (>10,000 Ω·cm) intrinsic silicon wafers. The high resistivity minimizes microwave losses in the substrate — critical because the qubit's electromagnetic mode extends several microns into the substrate, and any conductive losses in this region directly degrade coherence times. Wafers undergo aggressive cleaning and surface preparation to remove amorphous silicon oxide layers that host two-level system (TLS) defects — parasitic quantum systems that absorb energy from the qubit and cause decoherence.

**Superconducting Layers:** The active circuit layers are deposited using ultra-high-vacuum (UHV) physical vapor deposition (sputtering or evaporation) of aluminum and niobium. Aluminum forms the primary superconducting layer due to its low kinetic inductance, high critical temperature (1.2K for bulk Al), and well-characterized oxide (Al₂O₃) that serves as the tunnel barrier in Josephson junctions. Niobium is used for microwave resonators and wiring layers where its higher critical temperature (9.2K) provides margin against quasiparticle generation.

**Josephson Junction Formation:** The Josephson junction — the defining element of the transmon qubit — is fabricated using the Dolan bridge technique, a double-angle shadow evaporation process. An electron-beam lithography step patterns a suspended resist bridge; aluminum is evaporated at two angles, with an oxidation step between evaporations that forms the ~2nm-thick Al₂O₃ tunnel barrier. The junction area (typically 100-200nm × 100-200nm) and the oxidation conditions (oxygen pressure and exposure time) determine the junction's critical current and, therefore, the qubit's Josephson energy E_J. This is the single most process-sensitive step in the entire fabrication flow — variations in junction critical current across a wafer directly determine qubit frequency variability, which in turn affects gate fidelity and cross-talk.

**Multi-Layer Interconnects:** After junction formation, additional superconducting layers are deposited and patterned to form readout resonators, control lines, and inter-qubit couplers. These layers must maintain high quality factors (Q > 10^6 at microwave frequencies) while providing the connectivity required by the chip architecture. The multi-layer interconnect process is the primary area where quantum-specific fabrication diverges from conventional semiconductor BEOL (back-end-of-line) processing — the materials (aluminum, niobium, indium for bump bonds), deposition conditions (UHV to minimize contamination), and geometry constraints (controlled-impedance transmission lines for microwave signals) have no analog in CMOS manufacturing.

**Wafer-Level Testing:** Quantum processor wafers undergo cryogenic wafer-level testing — a capability unique to the Anderon facility. Individual dice on a wafer are cooled to millikelvin temperatures in a specialized cryogenic probe station and characterized for qubit frequencies, coherence times, gate fidelities, and cross-talk. This wafer-level screening identifies functional dice before the expensive processes of dicing, packaging, and full cryogenic integration, dramatically improving yield management compared to the research-lab approach of packaging and testing individually.

### 1.3 Strategic Significance

The Anderon foundry addresses multiple strategic imperatives:

**Domestic Quantum Supply Chain:** Before Anderon, superconducting qubit fabrication was concentrated in a small number of research facilities, none of which operated at production volumes. The foundry establishes a domestic, production-scale source of quantum processors, reducing dependence on international research collaborations and ensuring supply chain continuity for U.S. quantum computing infrastructure.

**Process IP Protection:** Fabrication processes developed at Anderon — particularly the Josephson junction formation recipes, multi-layer interconnect processes, and materials treatments that maximize coherence times — represent trade secrets with national security implications. By developing and operating these processes within a secure domestic facility, IBM protects the intellectual property that differentiates its quantum processors from competitors.

**Workforce Development:** The foundry creates a specialized semiconductor manufacturing workforce with skills that bridge conventional CMOS fabrication and quantum-specific processing. This workforce is a strategic asset for the broader U.S. quantum computing ecosystem, providing the human capital necessary for the quantum computing industry's anticipated growth over the coming decades.

---

## 2. Poughkeepsie Manufacturing Campus

### 2.1 Campus Overview

IBM's Poughkeepsie, New York campus is the company's primary manufacturing and development site for mainframe and enterprise computing systems. The campus spans over 400 acres and houses facilities for processor fabrication, system assembly and testing, and research and development — creating an integrated manufacturing environment where processors transition from wafer completion to system integration within a single campus.

**Facilities Integration:** The co-location of the Anderon quantum foundry with the existing mainframe manufacturing infrastructure creates synergies in utilities (shared high-voltage power, ultra-pure water, and process gas distribution), workforce (shared specialized technicians and engineers), and logistics (shared supply chain, security, and transportation infrastructure). The Poughkeepsie campus's established relationships with regional suppliers, educational institutions (including the State University of New York system), and transportation infrastructure (proximity to Stewart International Airport and major highway corridors) support both the quantum and classical manufacturing operations.

### 2.2 Telum II Processor Fabrication

The Telum II processor — the engine of the z17 mainframe — is fabricated on Samsung's advanced process technology. While final fabrication occurs at Samsung's foundry facilities, the processor design, verification, and post-fabrication characterization are performed at IBM's Poughkeepsie and Yorktown Heights facilities.

**Design and Verification:** Telum II's design — encompassing the 82-core processor complex, the on-chip AI accelerator, the cache hierarchy, and the SMP interconnect fabric — is produced by IBM's processor design team using proprietary advanced computational methodologies for physical design optimization, power analysis, and timing closure. The design process produces the GDSII layout data that Samsung's foundry uses to fabricate the physical wafers.

**Post-Fabrication Processing:** Completed Telum II wafers return to IBM facilities for testing, binning (sorting processors by achievable clock frequency and functional core count), and packaging. The packaging process — mounting the processor die onto the multi-chip module (MCM) that forms the z17 processor drawer — requires IBM's specialized assembly equipment and processes, reflecting the unique physical, thermal, and signal integrity requirements of mainframe-class multi-chip modules.

### 2.3 Spyre AI Accelerator Fabrication

The Spyre PCIe AI accelerator card — supporting up to 48 cards per z17 system — involves a multi-vendor supply chain: the accelerator ASIC is designed by IBM and fabricated at a semiconductor foundry partner; the high-bandwidth memory is sourced from memory manufacturers; the card-level assembly (PCB fabrication, component placement, final test) occurs at IBM and partner facilities. Spyre's production ramp is paced by the availability of advanced packaging capacity — the silicon interposer or bridge technology that connects the accelerator die to high-bandwidth memory — which remains a supply chain bottleneck across the semiconductor industry.

---

## 3. IBM Research Semiconductor Innovations

### 3.1 2nm Nanosheet Technology

In 2021, IBM Research announced the world's first 2nm node semiconductor technology — a nanosheet transistor architecture that represents a fundamental departure from the FinFET transistors that have dominated advanced logic since the 14nm node. The transition from FinFET (where the gate wraps around a vertical silicon fin) to nanosheet (where the gate completely surrounds stacked horizontal silicon nanosheets) provides improved electrostatic control of the transistor channel, enabling continued voltage scaling and performance improvement at reduced dimensions.

**Technical Specifications:** IBM's 2nm nanosheet technology achieves a contacted gate pitch of approximately 45nm and a metal pitch of approximately 24nm, yielding a transistor density roughly 2× that of the most advanced 5nm-class nodes. IBM projects that 2nm technology will deliver a 45% performance improvement or a 75% energy reduction compared to 7nm-class nodes, depending on the optimization target (performance vs. power efficiency).

**Manufacturing Partnerships:** IBM does not operate its own leading-edge CMOS foundry; instead, the IBM Research Alliance — including Samsung and, previously, GlobalFoundries and Intel — develops advanced process technologies that member companies then implement in their manufacturing facilities. Samsung's 3nm and 2nm-class nodes are direct implementations of the nanosheet technology developed in the IBM Research Alliance, demonstrating the pathway from IBM's fundamental research to high-volume manufacturing.

**Relevance to IBM's Product Portfolio:** The nanosheet technology developed at IBM Research directly benefits IBM's processor products — Telum II and its successors — through the foundry partnerships that translate IBM's process research into the manufacturing capability Samsung uses to fabricate IBM-designed processors. This model — IBM develops the fundamental process technology, alliance partners implement it in manufacturing — preserves IBM's semiconductor R&D capability without requiring the capital investment of operating a leading-edge CMOS foundry, which can exceed $20 billion per node.

### 3.2 Cryogenic CMOS

IBM Research has developed cryogenic CMOS integrated circuits specifically designed for operation at 4 Kelvin — the temperature stage of the dilution refrigerator where active control electronics can dramatically reduce the wiring complexity of quantum systems. Cryo-CMOS chips integrate multiplexers, amplifiers, and analog-to-digital converters that can operate reliably at temperatures where conventional silicon electronics would fail due to carrier freeze-out (the inability of dopant atoms to provide free charge carriers at cryogenic temperatures).

The fabrication of cryo-CMOS circuits requires process modifications — specific doping profiles, transistor geometries, and metallization schemes — that are not part of standard CMOS processes. IBM Research has developed these modifications through the same alliance model as the nanosheet technology, working with foundry partners to implement cryo-CMOS capability within existing manufacturing flows.

### 3.3 Advanced Packaging and Interconnects

IBM Research has a multi-decade history of innovation in semiconductor packaging, including the invention of the flip-chip interconnection (C4 — Controlled Collapse Chip Connection), the silicon interposer for 2.5D integration, and the development of direct-bonded copper hybrid bonding for 3D die stacking. These packaging technologies are critical for quantum processor deployment — the indium bump bonds that connect qubit chips to interposer substrates, the microwave cabling that carries control signals across temperature stages, and the inter-module quantum interconnects all depend on IBM's packaging and interconnect expertise.

For the z17 platform, advanced packaging enables the integration of Telum II processor dies, Spyre AI accelerator dies, and high-bandwidth memory into multi-chip modules with the signal integrity, power delivery, and thermal management required for mainframe reliability targets. IBM's internal packaging capabilities, combined with partnerships with outsourced semiconductor assembly and test (OSAT) providers, form a critical link in the supply chain that delivers finished processor modules to the Poughkeepsie system assembly operation.

---

## 4. CHIPS Act Partnerships and Supply Chain Resilience

### 4.1 CHIPS Act Funding Allocation

The CHIPS and Science Act of 2022 authorized approximately $52 billion in federal incentives for domestic semiconductor manufacturing and research. IBM's $1 billion allocation under the CHIPS Act — combined with the company's matching $1 billion commitment — is directed primarily toward the Anderon quantum wafer foundry, but also supports broader semiconductor manufacturing capability at the Poughkeepsie campus.

**Funding Structure:** CHIPS Act funding is typically structured as a combination of direct grants (for capital investment in manufacturing facilities) and investment tax credits (for ongoing manufacturing operations). The specific allocation between these mechanisms for IBM's award has not been publicly detailed, but the total $1 billion includes both the capital investment for Anderon's construction and the operational incentives for domestic quantum processor manufacturing.

**Compliance Requirements:** CHIPS Act recipients are subject to conditions including restrictions on expanding advanced semiconductor manufacturing capacity in "foreign countries of concern" (specifically China) for a period of 10 years, workforce development commitments, and community benefit plans. IBM's compliance with these conditions is integrated into the Anderon facility's operational planning.

### 4.2 Supply Chain Architecture

IBM's semiconductor supply chain for its enterprise computing products spans multiple tiers:

**Tier 1 — Direct Suppliers:** Companies that supply finished components (wafers, substrates, packaging materials, process chemicals) directly to IBM's manufacturing operations. These suppliers are subject to IBM's supplier quality management system, which includes on-site audits, statistical process control data sharing, and business continuity planning requirements.

**Tier 2 — Equipment Vendors:** Manufacturers of the specialized equipment used in semiconductor fabrication (lithography tools, deposition systems, etch tools, metrology instruments). IBM's relationships with equipment vendors are managed through the IBM Research Alliance, where alliance member companies provide a consolidated demand signal that improves equipment availability and pricing.

**Tier 3 — Raw Materials:** Suppliers of the fundamental materials (high-purity silicon, aluminum, niobium, process gases, photoresists) that enter the semiconductor fabrication process. Raw material supply chain resilience is a growing concern across the semiconductor industry, driven by the geographic concentration of material processing in a small number of countries and the increasing purity requirements of advanced semiconductor manufacturing.

### 4.3 Resilience Strategies

IBM's supply chain resilience for semiconductor manufacturing employs multiple strategies:

**Geographic Diversification:** While the Anderon foundry establishes domestic production for quantum processors, IBM's CMOS processor supply chain leverages Samsung's geographically distributed manufacturing footprint (South Korea, with expansion in the United States through Samsung's Taylor, Texas facility). This geographic diversity provides resilience against regional disruptions — natural disasters, geopolitical events, infrastructure failures — that could affect a single-location supply chain.

**Buffer Inventory:** For components with long lead times (specialized substrates, custom packaging materials, cryogenic control electronics), IBM maintains buffer inventories calibrated against supplier lead times and demand variability. The specific size and composition of these buffers are proprietary, but the practice is standard across the semiconductor industry, where production interruptions lasting days can cascade into product delivery delays measured in months.

**Multi-Sourcing:** Where technically and economically feasible, IBM qualifies multiple suppliers for critical materials and components. True multi-sourcing in semiconductor manufacturing is limited by the specialization of suppliers — a given advanced photoresist formulation may be available from only one supplier, and qualification of a second source can require months of process validation — but IBM's supply chain organization identifies and mitigates single-source risks through a combination of supplier development programs, qualification of alternative materials, and engineering-driven substitution plans.

**CHIPS Act Ecosystem Development:** IBM actively participates in the supplier ecosystem development programs funded through the CHIPS Act, which provide incentives for equipment vendors, material suppliers, and service providers to establish or expand U.S.-based operations. By expanding the domestic ecosystem of semiconductor suppliers, these programs reduce the supply chain risks associated with reliance on geographically concentrated international suppliers for critical manufacturing inputs.

### 4.4 Economic and National Security Dimensions

The semiconductor manufacturing infrastructure described in this document operates at the intersection of commercial and national security interests:

**Economic Competitiveness:** The CHIPS Act's explicit objective is to reverse the decline in U.S. share of global semiconductor manufacturing, which fell from approximately 37% in 1990 to approximately 12% by 2020. IBM's manufacturing investments — particularly the Anderon foundry, which creates a category of semiconductor manufacturing (quantum processors) where the United States leads rather than trails — contribute to this broader objective.

**National Security:** The Department of Defense has identified assured access to trusted semiconductor manufacturing as a critical national security requirement. Quantum processors — which will eventually threaten the cryptographic foundations of military and intelligence communications — are a particularly sensitive category where domestic manufacturing capability is essential. The Anderon foundry, as a U.S.-based, domestically operated facility producing processors with national security implications, directly addresses this requirement.

**Supply Chain Sovereignty:** The COVID-19 pandemic exposed the fragility of globally distributed semiconductor supply chains, where a disruption in a single country (Malaysia's packaging facilities during COVID lockdowns, Taiwan's TSMC during geopolitical tensions) can affect the entire global electronics industry. IBM's strategy of maintaining domestic manufacturing capability for strategically critical products (quantum processors, mainframe systems) while leveraging global partnerships for commodity semiconductor manufacturing (standard CMOS logic) balances the efficiency of global supply chains against the resilience of domestic production.

---

## 5. Manufacturing Technology Roadmap

### 5.1 Quantum Processor Scaling

The Anderon facility's production roadmap tracks the IBM Quantum Roadmap described in the Quantum Computing dossier:

- **2025-2026:** Production qualification for Loon and Nighthawk processors. Yield improvement through statistical process control and defect reduction programs.
- **2027-2028:** Process development for Kookaburra LPU and Cockatoo inter-module coupling structures, which introduce new fabrication requirements (through-substrate vias for inter-module interconnects, integrated cryo-CMOS control chips).
- **2029:** High-volume production for Starling-system processor modules, supporting the deployment of multiple complete Starling systems.
- **2030-2033:** Continuous improvement in process control, yield, and throughput to support Blue Jay-class systems requiring tens of thousands of physical qubit modules per system.

### 5.2 Advanced Logic Processor Development

IBM Research continues to develop advanced CMOS process technologies through the IBM Research Alliance:

- **2nm Nanosheet:** Transfer to Samsung manufacturing, production qualification for future IBM Z processors beyond Telum II.
- **Beyond 2nm:** Research into gate-all-around (GAA) transistor architectures beyond nanosheet, backside power delivery, and 3D monolithic integration — technologies that will enable the continued performance scaling of mainframe processors through the early 2030s.

### 5.3 Integrated Manufacturing Vision

IBM's long-term semiconductor manufacturing vision integrates the quantum and classical processor supply chains into a unified domestic manufacturing ecosystem centered on the Poughkeepsie campus. This vision leverages the shared infrastructure, workforce, and supply chain relationships described throughout this document to create a resilient, domestically based manufacturing capability for the full spectrum of IBM's processor products — from the superconducting qubits that power quantum computation to the advanced CMOS logic that drives mainframe and enterprise AI workloads.
