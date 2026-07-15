# 12 — Analog Mixed Signal & Wireless: Product Deep Dive

## Protection Diodes & TVS: The Silent Enabler

Protection diodes are one of the most ubiquitous yet underappreciated categories of semiconductor devices. Every high-speed digital interface in every electronic product requires ESD protection to survive real-world handling and operation. As data interface speeds increase — from USB 2.0 at 480 Mbps to Thunderbolt 4 at 40 Gbps and PCIe 5.0 at 32 GT/s — the capacitance of the protection diode becomes a critical design parameter.

### Technical Requirements by Interface Speed

| Interface | Data Rate | Max Allowed Capacitance | Semtech Solution |
|-----------|-----------|------------------------|------------------|
| USB 2.0 | 480 Mbps | <3.0 pF | Standard ESD array |
| USB 3.2 Gen 1 | 5 Gbps | <0.5 pF | Ultra-low-C ESD |
| USB 3.2 Gen 2 | 10 Gbps | <0.3 pF | Ultra-low-C ESD |
| USB4 / Thunderbolt 4 | 40 Gbps | <0.15 pF | Sub-0.2 pF protection |
| HDMI 2.1 | 48 Gbps | <0.15 pF | Sub-0.2 pF protection |
| Ethernet (10G+) | 10+ Gbps | <1.0 pF | Multi-channel array |
| PCIe 5.0 | 32 GT/s | <0.2 pF | Sub-0.3 pF protection |

This progression creates a virtuous cycle for Semtech's protection business: each new, faster interface standard requires lower-capacitance protection diodes, which are more difficult to design and manufacture, and therefore command higher ASPs. The ongoing transition to USB4, HDMI 2.1, and PCIe 5.0 in consumer and computing devices is driving a mix upgrade within Semtech's protection portfolio.

### Surge Protection

Beyond ESD, Semtech's surge protection devices guard against higher-energy transient events induced by lightning strikes, power line disturbances, and inductive load switching. These products are used in:
- Telecom base station antenna ports and power inputs
- Industrial equipment exposed to harsh electrical environments
- Automotive electronics subject to load dump and jump-start transients
- Renewable energy inverters and power conditioning systems

### Filtered Protection Arrays

Integrating ESD protection with EMI/RFI filtering on a single silicon die, filtered protection arrays reduce component count, board area, and design complexity in space-constrained applications such as smartphones, tablets, and wearable devices. These multi-channel devices provide per-pin protection and filtering for LCD and camera interfaces, audio ports, and sensor connections.

## LoRa Radio Portfolio

### Discrete Transceivers

Semtech's SX126x and SX127x families are the workhorse LoRa transceivers deployed in millions of end devices. These ICs integrate the complete LoRa radio front-end including:
- Synthesizer and power amplifier for transmission
- Low-noise amplifier and I/Q downconverter for reception
- LoRa modem performing spread-spectrum modulation and demodulation
- FSK/OOK modem for compatibility with legacy ISM-band protocols
- SPI interface for connection to an external host microcontroller

The discrete transceiver architecture provides maximum flexibility, allowing device designers to select the optimal microcontroller, memory configuration, and sensor interfaces for their specific application.

### System-on-Chip Solutions

Semtech's LoRa Edge platform and integrated SoC devices combine a LoRa radio with an embedded ARM Cortex-M series microcontroller, flash memory, RAM, and peripheral interfaces in a single package. These devices reduce bill-of-materials cost, board area, and design complexity for cost-sensitive, space-constrained applications such as asset trackers, sensor nodes, and wearable devices. Selected devices also integrate a GNSS receiver for autonomous geolocation.

### Multi-Band and Multi-Protocol Devices

Addressing the global nature of IoT deployments, Semtech's multi-band LoRa transceivers support operation across all major sub-GHz ISM bands (433 MHz, 470 MHz, 868 MHz, 915 MHz) and the 2.4 GHz global ISM band, enabling a single device design to be deployed worldwide with only antenna matching adjustments.

## Wireless Charging ICs

Semtech's wireless power portfolio addresses both the transmit (power sending) and receive (power receiving) sides of inductive and resonant wireless charging systems. Key products include:

- **Receiver ICs** with integrated synchronous rectification, voltage regulation, and digital control, supporting up to 15W of received power for smartphone and tablet applications.
- **Transmitter ICs** with full-bridge inverter, coil current sensing, and foreign object detection, supporting single-coil and multi-coil transmitter designs.
- **High-power solutions** for medical devices, industrial handhelds, and power tools requiring 30-100W of wireless power transfer.

## Video Transport ICs

Semtech's video transport technology uses adaptive equalization and advanced modulation to carry uncompressed, visually lossless video over standard twisted-pair copper cable. The technology supports:

- Extension distances of 100-300 meters over Cat-5e/6/6a cable
- Resolutions up to 8K at 60 Hz with 4:4:4 chroma subsampling
- Bidirectional auxiliary channels for USB, RS-232, IR, and audio
- HDCP content protection pass-through

These products are marketed under the BlueRiver brand for AV-over-IP and extension applications. Target deployments include corporate conference rooms, university lecture halls, sports venue displays, broadcast studios, and medical operating theaters where the combination of high video quality, low latency, and long reach over existing copper infrastructure provides a compelling value proposition versus fiber optic alternatives.
