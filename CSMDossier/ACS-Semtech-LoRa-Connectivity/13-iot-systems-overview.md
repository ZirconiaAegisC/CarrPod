# 13 — IoT Systems & Connectivity: Segment Overview

## Segment Definition

The IoT Systems & Connectivity segment delivers complete hardware and software solutions for Internet of Things deployments. This segment encompasses LoRa modules, gateways, and routers; the AirLink family of cellular routers and gateways; and associated cloud-based device management and connectivity platforms. Unlike the other segments, which primarily sell semiconductor components to equipment manufacturers, IoT Systems sells finished, deployable hardware products directly to enterprises, network operators, and system integrators.

## FY2026 Segment Financials

| Metric | Value |
|--------|-------|
| FY2026 Revenue | $354 million |
| Revenue Share | 33.7% of total |
| Segment Margin | 35.5% |
| YoY Revenue Growth | ~15% |

The 35.5% segment margin is the lowest among Semtech's three segments, reflecting the hardware-centric nature of the business. Modules, gateways, and routers carry higher bill-of-materials costs and lower gross margins than the semiconductor products in the Signal Integrity and Analog segments. However, this segment provides strategic value by enabling end-to-end LoRa ecosystem deployment and creating pull-through demand for the analog segment's LoRa chipset products.

## Product Categories

### LoRa Modules

Semtech's LoRa modules integrate a LoRa radio transceiver (or SoC), a microcontroller, an antenna interface, and associated passive components onto a compact, pre-certified PCB assembly. Modules dramatically reduce the design complexity, development time, and regulatory certification burden for end-device manufacturers. Rather than designing a discrete radio circuit, laying out an RF PCB, and navigating FCC, CE, and other regulatory approvals, a device maker can drop a pre-certified module onto their product PCB and focus on their application's value-add.

Module variants span:
- Regional frequency bands (868 MHz, 915 MHz, 433 MHz, 2.4 GHz)
- Power levels (from +14 dBm for short-range sensors to +22 dBm for maximum reach)
- Microcontroller integration (modules with embedded MCU vs. AT-command modules)
- Form factors (SMT for automated assembly, pluggable for prototyping)
- Additional sensors (GPS/GNSS, accelerometer, temperature) integrated on-module

### LoRa Gateways

LoRa gateways are the bridge between end devices operating on the LoRaWAN protocol and IP-based network servers. A gateway receives LoRa-modulated packets from end devices in its coverage area, demodulates and packetizes the data, and forwards it over Ethernet, Wi-Fi, or cellular backhaul to a LoRaWAN network server. In the reverse direction, the gateway receives downlink packets from the network server and transmits them to target end devices.

Semtech offers both indoor and outdoor gateway variants:
- **Indoor gateways** support 8-channel concurrent reception, PoE power, and compact enclosures suitable for office, retail, and light industrial environments.
- **Outdoor gateways** support 16-channel concurrent reception, IP67 weatherproof enclosures, integrated 4G/LTE cellular backhaul, and extended temperature operation for pole-top deployments in smart city, agricultural, and industrial applications.

### LoRa Routers

More advanced than simple gateways, Semtech's LoRa routers incorporate edge computing capabilities, enabling local data processing, protocol translation, and decision-making without round-tripping to the cloud. This architecture reduces backhaul bandwidth, lowers latency for time-critical control applications, and enables continued operation during cloud connectivity outages.

### AirLink Cellular Routers

The AirLink product family, acquired through Semtech's Sierra Wireless transaction, provides ruggedized 4G/LTE and 5G cellular routers and gateways for mission-critical enterprise and industrial applications. Key verticals include:
- **Public safety** — Routers in police vehicles, fire apparatus, and ambulances provide always-on connectivity for computer-aided dispatch, video streaming, and database access.
- **Transit and transportation** — Onboard connectivity for bus, rail, and fleet vehicles supporting passenger Wi-Fi, fare collection, vehicle telematics, and real-time tracking.
- **Industrial and utility** — Remote connectivity for SCADA systems, substation automation, pipeline monitoring, and distributed energy resource management.
- **Retail and branch** — Primary or backup WAN connectivity for point-of-sale, inventory management, and digital signage.

AirLink routers are differentiated by ruggedized mechanical design, extended temperature operation, carrier certification across global mobile networks, integrated GPS, and advanced networking features including VPN, stateful firewall, and dual-SIM failover.

## Manufacturing and Supply Chain

The IoT Systems segment operates a hybrid manufacturing model. Module assembly is outsourced to contract manufacturers, while certain gateway and router products are assembled in-house or through strategic manufacturing partners. The company maintains inventory of finished goods to support short lead times for enterprise and carrier customers, which requires working capital investment typical of hardware-centric businesses — a factor contributing to the segment's lower margin profile relative to Semtech's semiconductor-only segments.

## Competitive Positioning in IoT Systems

### LoRa Modules and Gateways

The LoRa module and gateway market is fragmented, with numerous suppliers offering products based on Semtech's own LoRa radios. Semtech competes in this market against customers of its own semiconductor business — module makers such as Murata, Seeed Studio, and RAKwireless — as well as gateway vendors including Kerlink, Cisco, and Multitech. Semtech's differentiation in this market derives from its unique position as both the silicon supplier and the systems provider, offering integrated hardware-plus-software solutions and the ability to optimize system-level performance across the silicon-to-cloud stack.

### AirLink Cellular Routers

In the enterprise cellular router market, Semtech's AirLink products compete with offerings from Cradlepoint (Ericsson), Digi International, Sierra Wireless (now part of Semtech), and Inseego. Key competitive factors include:
- Carrier certification breadth across global mobile network operators
- Ruggedization and environmental specifications for vehicle and outdoor deployment
- Integrated cloud management and zero-touch provisioning capabilities
- GPS and dead-reckoning for mobile asset tracking
- 5G migration support and backward compatibility with 4G/LTE networks

### Strategic Value of IoT Systems

While the IoT Systems segment generates lower margins than the semiconductor segments, its strategic importance to Semtech's overall business model is substantial. The segment:
- Provides a direct channel to enterprise and carrier customers, bypassing module and gateway intermediaries
- Creates pull-through demand for Semtech's LoRa radios (sold in the Analog segment) and protection devices
- Generates recurring cloud subscription revenue that improves overall corporate revenue quality
- Captures a larger share of the LoRa value chain than silicon-only sales would allow
