# F2-024 — LoRa Mesh Fleet Communication Network Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. System Overview

All internal and external fleet communications use **LoRa (Long Range) spread-spectrum
radio** at 915 MHz (North America) / 868 MHz (Europe), mounted in ceramic-chip packages
with no metallic antenna elements (PN-CC-001).

Why LoRa is the correct choice for the Charlemagne Fleet:
- **GPS-free operation:** LoRa TDOA (Time Difference of Arrival) provides ±0.5 m positioning
  without GPS satellites (which may be damaged during Carrington-class solar events)
- **GIC immune:** Ceramic chip, PEEK housing, no metallic radiator — operates normally
  through G5 geomagnetic storms when conventional cellular and WiFi systems fail
- **Long range:** 2–15 km per hop (extended with mesh relay nodes)
- **Low power:** 125 mW TX, 15 mW RX — harvest-powered from AAJ piezo array

## 2. Fleet LoRa Applications

| Application | Mode | Range Required | Update Rate | Vessels |
|---|---|---|---|---|
| Parent-child tether | Bidirectional | 5 km | 1 Hz position | TOURMALINE |
| Fleet convoy | Mesh | 15 km | 0.5 Hz | RHODONITE fleet |
| Swarm coordination | Broadcast | 5 km | 2 Hz | All 5 types |
| Emergency distress | Broadcast | 15 km | On-demand | All 5 types |
| GPS-free positioning | TDOA triangulation | 2 km (to nearest 3 nodes) | Continuous | All |
| OTA firmware update | Unicast | Short range | Weekly max | All |

## 3. GPS-Free Positioning Protocol

**The most critical innovation:** LoRa TDOA positioning that works when GPS is down.

Algorithm:
1. Vehicle broadcasts a precision-timestamped LoRa pulse (MRAM-stored crystal reference)
2. 3+ surrounding vehicles receive this pulse
3. Time difference of arrival (TDOA) triangulated by fleet mesh coordinator
4. Position estimate: ±0.5 m (urban), ±2 m (open water)

**Why this matters for the Charlemagne mission:**
During a Carrington event (when GPS becomes unreliable due to solar energetic particle
bombardment), the fleet can still navigate, coordinate, and support each other.

## 4. Parent Supervision Mode (TOURMALINE-Specific)

One PN-CC-001 module per TOURMALINE is designated as the "parent tether" node:
- Parent iOS/Android app maintains continuous LoRa link
- Vehicle reports: speed, GPS/TDOA position, battery, biometrics
- Parent commands: geo-fence boundary, speed cap override, emergency stop
- Latency: <500 ms parent command → vehicle response
- Link loss: >60 s without parent acknowledgment → speed capped to 3 km/h


---
*End F2-024 | CSMVessel-Charlemagne-FleetV2 | June 2026*
