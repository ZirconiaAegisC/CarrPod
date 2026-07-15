# Glossary of Terms

**Document Classification:** ACS Internal — Reference
**Version:** 1.0
**Date:** July 2026

---

## A

- **AI Accelerator:** Specialized hardware designed to accelerate artificial intelligence inference and training workloads. On IBM Z, implemented via the on-chip AI accelerator within the Telum II processor and the discrete Spyre AI accelerator card.

- **AI Inferencing:** The process of using a trained machine learning model to make predictions or decisions on new input data. On IBM Z, AI inferencing is performed inline on transactional data without data movement.

- **ARR (Annual Recurring Revenue):** A financial metric measuring the predictable and recurring revenue generated from subscription-based products and services over a 12-month period.

- **ASIC (Application-Specific Integrated Circuit):** A custom integrated circuit designed for a specific application rather than general-purpose use. IBM uses ASICs for cryogenic quantum control electronics.

## B

- **Blue Jay:** IBM's post-Starling quantum processor architecture, targeting 100,000+ physical qubits and 10,000+ logical qubits with sub-10⁻¹⁵ logical error rates. Planned for production deployment circa 2033.

- **BSPDN (Backside Power Delivery Network):** A semiconductor manufacturing technique that routes power delivery through the backside of the silicon wafer, reducing resistance and freeing front-side area for logic and interconnect.

## C

- **c-coupler (Chip-to-Chip Coupler):** A quantum interconnect technology enabling direct quantum state transfer and entanglement generation between separate quantum processor chips within the same cryostat.

- **CLOPS (Circuit Layer Operations Per Second):** A performance metric for quantum computers measuring the number of circuit layers (sets of simultaneous quantum gates) that can be executed per second. IBM Heron r2 targets >5,000 CLOPS.

- **Cockatoo:** IBM's entanglement distribution protocol and architecture for connecting multiple Kookaburra FT modules into a multi-node quantum network.

- **CPACF (Central Processor Assist for Cryptographic Function):** An on-chip cryptographic coprocessor integrated into every IBM Z processor core, providing hardware acceleration for encryption, hashing, and message authentication.

- **Cryo-CMOS:** Complementary metal-oxide-semiconductor (CMOS) integrated circuits designed to operate at cryogenic temperatures (typically 4 Kelvin). Used for quantum processor control electronics.

- **Crypto Express:** A tamper-sensing cryptographic coprocessor card for IBM Z mainframes, providing hardware security module (HSM) functionality with FIPS 140-2 Level 4 certification.

## D

- **Dilution Refrigerator:** A cryogenic device capable of achieving temperatures below 15 millikelvin, required for operating superconducting qubit processors. Uses a mixture of helium-3 and helium-4 isotopes.

## F

- **Flamingo:** IBM's modular quantum processor architecture (2026–2027) introducing l-couplers and c-couplers for multi-chip quantum modules.

- **FTQC (Fault-Tolerant Quantum Computing):** Quantum computation performed using logical qubits encoded via quantum error correction codes, such that error rates are exponentially suppressed below the physical qubit error threshold.

## G

- **GDPS (Geographically Dispersed Parallel Sysplex):** IBM's multi-site continuous availability and disaster recovery solution for IBM Z mainframes, enabling zero data loss failover between geographically separated data centers.

## H

- **Heron:** IBM's 156-qubit quantum processor (2024–2026) with heavy-hexagonal lattice topology and tunable couplers. The r2 revision (2026) targets gate fidelities exceeding 99.9%.

## I

- **ISM (Internal Shared Memory):** A protocol enabling direct memory access and RDMA-class communication between LPARs on the same physical IBM Z system, implemented in SMC-Dv2.

## K

- **Kookaburra:** IBM's first fault-tolerant quantum computing (FTQC) module architecture, targeting deployment in 2028–2029. Implements quantum error correction codes (surface codes and qLDPC codes) at scale.

- **KVM for IBM Z (Kernel-based Virtual Machine):** A Linux-based hypervisor enabling virtualization on IBM Z and LinuxONE platforms, supporting Linux, z/OS, and z/VM guest operating systems.

## L

- **l-coupler (Long-Range Coupler):** A quantum interconnect technology enabling direct coupling between distant qubits on the same quantum processor chip, introduced in the Flamingo architecture.

- **Lightwell:** ACS's proprietary infrastructure protection platform for real-time IBM Z mainframe telemetry ingestion, analysis, and automated incident response.

- **Logical Qubit:** An error-corrected qubit composed of multiple physical qubits and protected by a quantum error correction code. Logical qubits exhibit lower error rates than their constituent physical qubits.

- **LPAR (Logical Partition):** A logical subdivision of an IBM Z mainframe's physical resources (CPUs, memory, I/O), enabling multiple independent operating system instances to run concurrently.

- **LPU (Logical Processing Unit):** A unit of processor capacity assigned to an LPAR on an IBM Z system, typically representing a fraction of a physical processor core.

## M

- **MIPs (Millions of Instructions Per Second):** A legacy performance metric for mainframe workloads. On modern IBM Z systems, MSU (Millions of Service Units) is the preferred capacity metric.

- **MSU (Millions of Service Units):** The standard capacity metric for IBM Z mainframes, used for software licensing and workload-based pricing. One MSU represents a defined amount of processor consumption.

## N

- **Nighthawk:** ACS's program for demonstrating practical quantum advantage in infrastructure protection workloads, leveraging IBM quantum processors through the Qiskit Function Catalog.

- **NIST PQC (Post-Quantum Cryptography):** Cryptographic algorithms standardized by NIST that are resistant to attacks by both classical and quantum computers. Standards include CRYSTALS-Kyber (FIPS 203), CRYSTALS-Dilithium (FIPS 204), and SPHINCS+ (FIPS 205).

## O

- **OpenShift:** Red Hat's enterprise Kubernetes platform for hybrid cloud application deployment and management. Certified on IBM Z and LinuxONE with full zCX container support.

- **OSA-Express:** IBM's high-speed networking adapter family for IBM Z mainframes, supporting Ethernet, Fibre Channel, and FICON connectivity. The OSA-Express7S supports 400 GbE.

## P

- **Parallel Sysplex:** IBM's clustering technology enabling multiple IBM Z mainframes to operate as a single logical system, sharing data and workload with high availability.

- **PTI (Program Temporary Fix Identifier):** An IBM identifier assigned to a specific software fix, patch, or update for z/OS and related mainframe software components.

## Q

- **qLDPC (Quantum Low-Density Parity-Check) Codes:** A family of quantum error correction codes characterized by sparse parity-check matrices, offering dramatically lower physical-to-logical qubit overhead ratios compared to surface codes. Demonstrated by Bravyi et al. (2024, Nature).

- **QKD (Quantum Key Distribution):** A cryptographic protocol that uses quantum mechanical principles to enable two parties to produce a shared random secret key, with security guaranteed by the laws of quantum physics.

- **QPU (Quantum Processing Unit):** The physical processor that executes quantum computations, comprising an array of qubits with control and readout infrastructure.

- **QV (Quantum Volume):** A hardware-agnostic metric for quantum computer performance introduced by IBM, measuring the largest random circuit of equal width and depth that can be successfully executed.

## R

- **RAIM (Redundant Array of Independent Memory):** IBM's memory protection technology for IBM Z mainframes, providing redundancy and error correction across memory DIMMs with tolerance for complete DIMM failures.

- **RHEL (Red Hat Enterprise Linux):** Red Hat's enterprise Linux distribution, the primary supported Linux operating system for IBM Z and LinuxONE platforms.

- **RoCE (RDMA over Converged Ethernet):** A network protocol enabling Remote Direct Memory Access (RDMA) over Ethernet networks, providing low-latency, high-bandwidth communication between systems.

## S

- **SMC-Dv2 (Shared Memory Communications Direct Version 2):** An IBM Z protocol enabling direct memory-to-memory communication between LPARs using ISM (Internal Shared Memory), achieving RDMA-class latency without requiring specialized networking hardware.

- **SMF (System Management Facilities):** IBM Z's data collection infrastructure for recording system events, performance metrics, and security-relevant information. SMF records (particularly SMF 119) provide the telemetry data ingested by the Lightwell platform.

- **Spyre:** The discrete AI accelerator card for IBM z17, providing 200+ TOPS (INT8) AI inference performance via PCIe Gen 5. Enables real-time AI inferencing on mainframe transactional workloads.

- **Starling:** IBM's multi-module fault-tolerant quantum computer assembled from interconnected Kookaburra FT modules, targeting 1,000–5,000 logical qubits. Planned deployment 2029–2032.

- **Surface Code:** A family of topological quantum error correction codes where qubits are arranged on a 2D lattice and stabilizer measurements are performed on local clusters. Currently the most well-studied QEC code but requires a high physical-to-logical qubit overhead ratio.

## T

- **Telum II:** IBM's 5nm processor for the z17 mainframe generation, featuring 8 cores per chip, an on-chip AI accelerator with 4x improvement over Telum (z16), and a dedicated cryptographic coprocessor per core.

- **TOPS (Tera Operations Per Second):** A performance metric for AI accelerators, measuring trillions of integer (typically INT8) operations per second. Lower precision operations (INT4, INT8) enable higher throughput for inference workloads.

## V

- **VQE (Variational Quantum Eigensolver):** A hybrid quantum-classical algorithm for finding the ground state energy of quantum systems, with applications in materials science, chemistry, and infrastructure optimization.

## W

- **watsonx:** IBM's integrated AI and data platform comprising watsonx.ai (foundation models), watsonx.data (lakehouse analytics), and watsonx.governance (AI risk management and compliance).

- **WLM (Workload Manager):** IBM z/OS component that dynamically manages system resources by prioritizing workloads based on business-defined goals and service level agreements.

## Z

- **z/OS:** IBM's flagship operating system for IBM Z mainframes, providing enterprise-class reliability, availability, serviceability, and security for mission-critical workloads.

- **z/VM:** IBM's hypervisor operating system for IBM Z, enabling virtualization of multiple z/OS, Linux on IBM Z, and z/VSE guest systems.

- **z/VSE:** IBM's operating system for smaller IBM Z configurations, typically used for batch processing and simpler online transaction processing workloads.

- **zCX (z/OS Container Extensions):** A feature of z/OS enabling the deployment and execution of Linux-based Docker containers directly on z/OS without requiring a separate Linux LPAR or z/VM.

---

## Document Control

| Version | Date | Author | Changes |
|---|---|---|---|
| 1.0 | July 2026 | ACS Infrastructure Protection | Initial glossary |
