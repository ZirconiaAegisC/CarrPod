# 06 — Signal Integrity Products: FiberEdge & CopperEdge

## Product Portfolio Architecture

Semtech's Signal Integrity product portfolio is organized into two primary product families, each targeting distinct physical media types and use cases within data center and networking infrastructure.

## FiberEdge: Optical Interconnect Platform

The FiberEdge family encompasses Semtech's complete portfolio of optical interconnect ICs designed for fiber optic communication links spanning data rates from 25 Gbps per lane to 200 Gbps per lane. These products form the electro-optical interface that converts between the electrical domain of switch ASICs and the optical domain of fiber optic cables.

### Product Categories

**Transimpedance Amplifiers (TIAs)**
TIAs are located at the receiver end of an optical link. When incident light strikes a photodetector, the resulting current is measured in microamps — far too weak for direct processing by digital logic. The TIA converts this tiny photocurrent into a differential voltage signal with sufficient amplitude for subsequent clock and data recovery stages. Semtech's TIA portfolio spans a range of bandwidths, gain settings, and input-referred noise specifications to match diverse photodetector types and link budgets.

**Laser Drivers**
Laser drivers sit at the transmitter end of an optical link. Digital data from a switch ASIC arrives as a high-speed electrical signal, which the laser driver modulates into a precisely controlled current waveform to drive a directly modulated laser or an external electro-absorption modulator. Semtech's laser drivers incorporate programmable bias current control, modulation amplitude adjustment, and eye-crossing calibration to optimize optical signal quality over temperature and process variation.

**Clock and Data Recovery (CDR) ICs**
CDRs extract the embedded clock from incoming serial data and retime the data to remove accumulated jitter. In modern optical modules, a bidirectional CDR may be integrated alongside the TIA and laser driver functions to provide a complete retimed electrical interface to the host system.

### Data Rate Progression

| Standard | Per-Lane Rate | Aggregate Throughput | Product Status |
|----------|---------------|---------------------|----------------|
| 100G-LR4 | 25 Gbps | 100 Gbps | Mature, declining |
| 400G-SR8/DR4 | 53 Gbps (PAM4) | 400 Gbps | High-volume production |
| 800G-SR8/DR8 | 106 Gbps (PAM4) | 800 Gbps | High-volume production, growing |
| 1.6T | 212 Gbps (PAM4) | 1.6 Tbps | Ramping production |
| 3.2T | 212+ Gbps (PAM4) | 3.2 Tbps | Development, pre-engagement |

## CopperEdge: Copper Interconnect Platform

The CopperEdge family addresses high-speed electrical signal integrity challenges over copper media, including printed circuit board traces, backplane connectors, and copper cable assemblies. These products are essential in data center architectures where electrical links connect switch ASICs to optical modules, GPU clusters to network interfaces, and server compute trays to top-of-rack switches.

### Product Categories

**Linear Re-drivers**
Re-drivers amplify and equalize degraded electrical signals without performing clock recovery. They compensate for frequency-dependent loss in PCB traces and connectors, extending the reach of high-speed serial links. Linear re-drivers are particularly well-suited for applications requiring low latency and protocol-agnostic operation.

**Retimers**
Retimers perform full clock recovery and data retiming in addition to equalization. By completely regenerating the signal, retimers achieve longer reach and better bit error rate performance than re-drivers. They are typically deployed in the most demanding applications such as active electrical cables and long-reach backplane connections, and increasingly in GPU-to-network interface connections in AI server architectures.

### Key Applications

- **Server-to-switch interconnects** in rack-scale and disaggregated compute architectures
- **Active electrical cables** for intra-rack and adjacent-rack connections at 400G and 800G speeds
- **GPU cluster interconnects** in AI training infrastructure, scaling to thousands of nodes
- **Backplane signal conditioning** in chassis-based networking and telecom equipment

## Design-In Cycle Dynamics

Signal integrity ICs follow extended design-in cycles, typically spanning 12 to 24 months from initial engagement to volume production. Customers qualify these components as part of complete optical module or system designs, running extensive compliance testing. Once qualified, a supplier's position is highly defensible, as re-qualifying an alternative component requires significant engineering investment. This dynamic creates a recurring revenue stream with multi-year visibility for each design win.

## Revenue per Optical Module

As optical data rates escalate, Semtech's content per module increases. A typical 400G optical module might contain $4-6 of Semtech signal integrity ICs (TIA plus laser driver). An 800G module increases this to approximately $8-12 as per-lane rates double and noise requirements tighten. Early 1.6T designs indicate content of $15-20 per module, reflecting the additional value of 212 Gbps PAM4-capable analog front-ends. This content growth trajectory, multiplied by growing module unit volumes, underpins the Signal Integrity segment's growth outlook.

## Power Efficiency Leadership

Power consumption is an increasingly critical design parameter for optical modules, particularly as module port density increases in data center switches. A 32-port 800G switch line card must dissipate the heat from 32 optical modules in a constrained form factor. Semtech's signal integrity ICs are designed for best-in-class power efficiency, employing advanced circuit techniques including adaptive power scaling, dynamic bias control, and integrated digital calibration to minimize DC power consumption while maintaining signal integrity compliance. Power efficiency has become a key competitive differentiator, with hyperscale customers specifying maximum power budgets per optical module that directly influence supplier selection.
