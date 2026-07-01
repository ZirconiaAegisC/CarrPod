# CSMFAB000000000114 — Vol-07
# LoRa Telemetry and Ground Station Design
## Radio System, Data Format, Hardware, and Ground Control Software
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

*References: CSMFAB000000000102 V2.0 (LoRa Mesh Architecture) | CSMFAB000000000113-Vol-02 (Smart Rope Energy Architecture)*

---

## Introduction: Why LoRa?

Three radio technologies were evaluated for the ASB-1 telemetry link: WiFi (2.4 GHz), Bluetooth 5.0, and LoRa (Long Range, 915 MHz). LoRa won on all fronts:

| Criterion | WiFi 2.4GHz | Bluetooth 5.0 | LoRa 915 MHz |
|---|---|---|---|
| Range (open air) | 100-300 m | 50-400 m | **3-8 km** |
| Power consumption | High (150+ mW) | Medium (50 mW) | **Low (25-125 mW TX, 3-5 mW RX)** |
| Penetration (trees/terrain) | Poor | Poor | **Excellent** |
| Multi-node mesh | Requires router | Limited | **Native mesh (Meshtastic)** |
| GPS resilience | Requires GPS | Requires GPS | **Works without GPS** |
| Cost per module | $5-8 | $3-5 | **$5-8 (RFM95W)** |
| Interference sensitivity | High (congested band) | High | **Very low (spread spectrum FHSS)** |
| Mass (module + antenna) | 4g | 2g | **4g** |

The range advantage is decisive: 8 km air-to-ground range with LoRa covers any reasonable cliff-top research scenario. WiFi begins to fail at 300m — completely inadequate for a device that may drift 1+ km from the launch point.

---

## Part 1: LoRa Radio Module Selection

**Module: Hope RF RFM95W (or TTGO LoRa32 dev board for prototyping)**

| Specification | Value |
|---|---|
| RF frequency | 915 MHz (USA ISM band, no license required) |
| TX power | 2 to +20 dBm (125 mW maximum) |
| RX sensitivity | −148 dBm at SF12/BW125 |
| Spreading factor | SF6 to SF12 (selectable) |
| Bandwidth | 7.8 kHz to 500 kHz (selectable) |
| Modulation | LoRa CSS (chirp spread spectrum) |
| Interface | SPI (up to 10 MHz) |
| Supply voltage | 3.3 or 5V |
| Dimensions | 16mm × 16mm |
| Mass | 1.5g |
| Cost | ~$5-8 |

**Operating parameters for ASB-1 telemetry:**
- Spreading Factor: SF7 (short range, high data rate — adequate at <8 km)
- Bandwidth: 125 kHz
- Coding Rate: 4/5
- TX Power: 14 dBm (25 mW) — adequate for 5 km with 3 dBi ground antenna
- Transmit interval: 1 Hz (every 900 ms active + 100 ms transmit)

**Effective over-air data rate at SF7/BW125:** ~5.5 kbps
**Per-packet time on air:** ~22 ms at 24 bytes payload
**Duty cycle:** 22 ms / 1000 ms = 2.2% — well within the ISM band 1% duty cycle guideline even at SF7

---

## Part 2: Antenna Design (On-Device)

**Antenna: Quarter-Wave Monopole Wire**

The simplest, lightest, and most effective antenna for 915 MHz in this application: a straight wire of the correct length, connected to the RFM95W SMA port via a coax pigtail.

```
Quarter-wave length at 915 MHz:
λ/4 = (speed_of_light) / (4 × frequency)
λ/4 = 300,000,000 / (4 × 915,000,000)
λ/4 = 82 mm
```

**Construction:**
1. Cut 86mm of 22AWG solid copper wire (5% longer than theoretical, then trim to SWR minimum)
2. Solder to SMA connector center pin
3. Hot-glue to the outside of the electronics bay shell, running axially downward
4. The wire is oriented along the spin axis — this gives a nearly omnidirectional radiation pattern in the horizontal plane (toroidal pattern), ideal for ground station reception

The mass of this antenna is approximately **1g** inclusive of SMA connector and 50mm coax pigtail.

> ⚠️ NOTE: The antenna wire is copper — electrically conductive. It must be insulated from the BFRP body throughout its length using heat shrink tubing. The SMA connector must be mounted on a PEEK standoff to break any conductive path to the device body. Do not allow bare copper to contact the BFRP structure.

---

## Part 3: Meshtastic Protocol for Swarm Mesh

**Meshtastic** is an open-source firmware for LoRa modules that creates a self-organizing mesh network — meaning each node can relay messages from other nodes, extending the effective range beyond direct radio-to-ground-station paths. It supports up to 64 nodes on a single mesh.

For ASB-1 swarm operation:
- Each unit runs a Meshtastic-variant firmware (modified for periodic sensor reporting rather than human text messages)
- Each unit has a unique node ID (1-20)
- Units that are too far from the ground station relay their data through closer units
- The ground station receives a consolidated data stream from all 20 units via the closest relay nodes

**Mesh topology example (5-unit swarm on a cliff):**
```
Ground Station (LoRa gateway, Raspberry Pi)
    |
    ├── Unit 1 (direct link, 500m away)
    ├── Unit 2 (direct link, 800m away)
    ├── Unit 3 (via Unit 1 relay, 1200m away from ground)
    ├── Unit 4 (via Unit 2 relay, 1500m away from ground)
    └── Unit 5 (via Unit 2 and Unit 4 relay, 2000m from ground)
```

---

## Part 4: Ground Station Hardware

The ground station is built around a **Raspberry Pi 4B** (or 5) with a LoRa gateway hat. This is a portable field unit carried in a small backpack.

### Ground Station Component List

| Component | Function | Cost | Mass |
|---|---|---|---|
| Raspberry Pi 4B (2 GB RAM) | Main computer; runs SwarmView software | ~$45 | 46g |
| LoRa HAT (RAK831 gateway hat) | 8-channel LoRa gateway; receives all 20 units | ~$80 | 35g |
| 915 MHz 3dBi yagi antenna | Directional antenna; aimed at swarm | ~$15 | 50g |
| SMA-to-N coax cable (1m) | Antenna cable | ~$5 | 20g |
| USB power bank (10,000 mAh) | 6+ hours field power | ~$20 | 180g |
| 7-inch display (touchscreen) | Real-time swarm map display | ~$30 | 165g |
| Micro-SD card (32 GB) | Data logging | ~$8 | 2g |
| Waterproof case (Pelican 1150) | Carry and protect in field | ~$40 | 750g based on size |
| **TOTAL** | | **~$243** | **~1.25 kg** |

Note: The ground station is NOT part of the ASB-1 mass budget. It is fixed ground equipment.

### SwarmView Software (Open Source, Pi-hosted)

SwarmView is a simple Python application (written for this project, ~300 lines of Python) that:
1. Listens to the LoRa gateway for incoming Meshtastic telemetry packets
2. Parses each packet per the format in Vol-06
3. Plots each unit as a colored dot on a folium (OpenStreetMap-based) map with altitude displayed as dot elevation
4. Overlays wind vector arrows at each unit's position: direction = arrow direction, magnitude = arrow length
5. Logs all data to CSV and JSON files (Vol-06 data products)
6. Displays battery voltage, spin rate, FTS status for each unit in a sidebar table
7. Provides individual FTS trigger buttons and broadcast FTS trigger button (red emergency button)

SwarmView source code will be provided as a companion repository or zip file with this fabrication package.

---

## Part 5: Flight Command Protocol

The ground station can send commands back to units via downlink LoRa. Commands:

| Command Code | Function | Target |
|---|---|---|
| 0x01 | FTS Deploy (parachute trigger) | Individual unit (by node ID) |
| 0xFF | Broadcast FTS Deploy (all units) | All units simultaneously |
| 0x02 | Smart Rope actuate left | Individual unit |
| 0x03 | Smart Rope actuate right | Individual unit |
| 0x04 | Smart Rope center (neutral) | Individual unit |
| 0x10 | Motor on (if equipped) | Individual unit |
| 0x11 | Motor off | Individual unit |
| 0x20 | Ping / request status | Individual unit |

Commands are sent at any time from the SwarmView FTS panel. Command packets are 4 bytes: [0xAA sync] [node ID] [command code] [CRC-8].

---

## Part 6: Radio Frequency and Regulatory Notes

LoRa 915 MHz (902-928 MHz ISM band) in the United States operates under:
- **FCC Part 15** — no license required for devices under 1W EIRP

The RFM95W at 14 dBm TX (+25 mW) with a 2 dBi antenna gives EIRP = 14 + 2 = 16 dBm = 40 mW — well under the 1W (30 dBm) Part 15 limit.

No special frequency coordination, HAM license, or FAA radio station authorization is required for this system. The 915 MHz ISM band is freely available for commercial and experimental use.

---

## Part 7: Redundancy and Link Budget

### Link Budget Calculation

At 14 dBm TX, −148 dBm RX sensitivity, free-space path loss at 5 km:

```
FSPL = 20×log10(5000) + 20×log10(915×10⁶) + 20×log10(4π/3×10⁸)
FSPL = 74 + 179.2 − 31.5 = 121.7 dB

Received power = TX_power + TX_antenna − FSPL + RX_antenna
= 14 dBm + 2 dBi − 121.7 dB + 3 dBi (gateway yagi)
= −102.7 dBm

Link margin = −102.7 − (−148) = 45.3 dB margin
```

**45 dB link margin** at 5 km is extraordinary. Even with 30 dB of additional losses (multipath, terrain shadowing, device orientation), the link remains viable. This is why LoRa SF7/BW125 is more than adequate — the SF12 mode would add another 15 dB margin at the cost of longer time-on-air.

---

## CHECKPOINT — Vol-07 Complete

Before proceeding, confirm:
- [ ] You understand why LoRa was chosen over WiFi and Bluetooth (range, mesh, power)
- [ ] You know the antenna length: 82mm quarter-wave wire
- [ ] You understand the Meshtastic mesh topology for multi-unit relay
- [ ] You know the ground station hardware list and estimated cost (~$243)
- [ ] You understand the FTS trigger command structure (all-units broadcast via 0xFF)
- [ ] You know the link budget gives 45 dB margin at 5 km — very robust

**Proceed to:** Vol-08 (Speed Governor) or Vol-12 (Battery and Power)

---

*CSMFAB000000000114-Vol-07 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
