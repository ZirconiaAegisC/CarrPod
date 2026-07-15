# 07 — Data Center Demand Drivers: 800G, 1.6T & 3.2T

## Secular Growth in Data Center Bandwidth

Global data center bandwidth demand is growing at a compound annual rate of approximately 30-40%, driven by the exponential expansion of hyperscale cloud services, enterprise digital transformation, video streaming, and — most significantly — the rapid buildout of AI training and inference infrastructure. This bandwidth growth translates directly into demand for faster optical and copper interconnects, and by extension, demand for Semtech's signal integrity products.

## The AI Infrastructure Catalyst

The emergence of large language models and generative AI has fundamentally altered the scale and architecture of data center networks. Training runs for frontier models now involve tens of thousands of GPUs operating in parallel across multiple server racks, interconnected by high-bandwidth, low-latency networks. This "AI fabric" requires:

- Optical interconnects at every level of the network hierarchy (GPU-to-switch, switch-to-switch, data center-to-data center interconnect)
- A transition to higher per-lane data rates to keep aggregate bandwidth scaling while managing fiber count and connector density
- Increased deployment of active copper cables using re-timers for cost-effective intra-rack GPU cluster connections

## Data Rate Transition Roadmap

### 800G (Current High-Volume Generation)

800G represents the current high-volume generation of optical interconnect technology. Using eight lanes of 106 Gbps PAM4 modulation or four lanes of 212 Gbps PAM4, 800G modules are being deployed by all major hyperscale cloud providers. Semtech's FiberEdge products are designed into multiple 800G optical module reference designs, generating substantial ongoing revenue. The 800G deployment cycle is expected to continue growing through calendar year 2026 as second-tier cloud providers and enterprises begin their adoption.

### 1.6T (Emerging Ramp)

1.6T optical modules represent the next major inflection point in data center interconnects. Doubling aggregate throughput from 800G to 1.6T, these modules use eight lanes of 212 Gbps PAM4. Semtech has invested heavily in developing the next generation of TIAs, laser drivers, and CDRs capable of operating at 212 Gbps per lane. Customer qualification activity for 1.6T interconnect products is accelerating, with multiple hyperscale customers expected to begin volume deployments in the second half of FY2027. This product cycle is anticipated to be a multi-year growth driver for the Signal Integrity segment, directly translating to higher revenue per optical module as content value increases with data rate.

### 3.2T (Development Horizon)

While early in the development cycle, 3.2T optical interconnect technology is already on the roadmap. Achieving 3.2 Tbps aggregate throughput will require even higher per-lane data rates — potentially 424 Gbps — demanding significant advances in analog circuit design, packaging, and thermal management. Semtech's front-end engagement with lead customers on 3.2T architectures positions the company to maintain technology leadership through the next generation of data center networking.

## Revenue Implications for Semtech

Each generational transition in optical data rates directly increases Semtech's revenue per optical module. Higher data rates require higher-bandwidth, lower-noise analog front-end circuits, which command higher average selling prices (ASPs). As the installed base of optical modules shifts from 400G to 800G to 1.6T, the dollar content per port for Semtech's products increases. This "content growth" dynamic, combined with unit volume growth driven by expanding data center capacity, creates a compound growth trajectory for the Signal Integrity segment over the medium term.

## Competitive Dynamics

The optical interconnect IC market is concentrated among a small number of qualified suppliers, reflecting the technical difficulty of designing analog circuits that operate reliably at 100+ Gbps per lane. Semtech competes primarily with Broadcom and Marvell in the data center optical interconnect market. Key competitive factors include:

- Signal integrity performance (bandwidth, noise, jitter tolerance)
- Power efficiency (increasingly critical for high-density optical module thermal management)
- Foundry process technology and manufacturing yield
- Depth of customer relationships and design-in pipeline
- Breadth of portfolio (ability to supply multiple ICs per module)

## Hyperscale Customer Landscape

The data center optical interconnect market is dominated by a small number of hyperscale cloud providers whose capital expenditure decisions drive industry-wide demand. These customers — including the three largest US cloud platforms and major Chinese cloud operators — are collectively investing over $200 billion annually in data center infrastructure, with an increasing share directed toward GPU-accelerated AI clusters. Semtech maintains active design-in engagements with all major hyperscale customers and their optical module supply chains.

## Module Architecture Evolution

The optical module market is evolving toward several new form factors that influence signal integrity IC requirements:

**Pluggable Modules (OSFP, QSFP-DD800)** — The dominant form factor for 400G and 800G deployments. These hot-swappable modules plug into switch front panels and rely on discrete TIA, driver, and CDR ICs that maximize Semtech's revenue content per port.

**Linear Pluggable Optics (LPO)** — An emerging architecture that eliminates the DSP from the optical module, relying on direct electrical connections between the switch ASIC and the optical components. LPO requires exceptionally high-performance analog front-ends capable of driving signals across lossy PCB traces without DSP-based compensation, a technical challenge that plays to Semtech's analog design expertise.

**Co-Packaged Optics (CPO)** — A longer-term architecture in which optical engines are integrated directly onto the switch package substrate, eliminating pluggable connectors altogether. While CPO reduces the per-port number of certain discrete ICs, it requires highly integrated optical interface chips that combine multiple channels of TIA, driver, and CDR functionality in a single package. Semtech is developing CPO-compatible product architectures to participate in this market evolution.

## China Data Center Market

China represents both a significant opportunity and a risk for the Signal Integrity segment. Chinese hyperscale operators — including Alibaba, Tencent, Baidu, and ByteDance — are deploying 800G optical interconnects at scale and represent a substantial addressable market. However, US export controls on advanced semiconductor technology create uncertainty about the volume and specifications of products that can be sold to China-based customers. Semtech's Signal Integrity products, which are designed on mature mixed-signal process nodes rather than advanced digital logic processes, have generally been less directly affected by export controls than GPU and advanced AI chip restrictions, but the regulatory environment remains dynamic and requires ongoing monitoring.

## Supply Chain Resilience

The Signal Integrity segment's supply chain has been strengthened through multi-sourcing initiatives, safety stock programs, and long-term capacity reservation agreements with foundry partners. The company maintains buffer inventory of finished goods and die bank to buffer against foundry capacity fluctuations. Lead times for optical interconnect ICs are typically 12-16 weeks, and the company targets on-time delivery performance exceeding 95% for its hyperscale customers. Obsolescence risk is managed through careful alignment of production volumes with customer demand forecasts and conservative write-down policies on slow-moving inventory.
