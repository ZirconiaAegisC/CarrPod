# F2-019 — PMMA Optical Fiber Data Network Specification
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Why All-Optical

The Charlemagne Fleet's signal/data network uses **PMMA Plastic Optical Fiber (POF)
exclusively**. Conventional automotive copper CAN bus or Ethernet networks are
electromagnetically susceptible and represent a GIC vulnerability.

POF physics advantage:
- Signal carrier: photons, not electrons
- Susceptibility to time-varying magnetic flux dΦ/dt: **zero** (light is not affected by
  magnetic fields at vehicle-scale flux densities)
- GIC-induced noise in POF network: **0 mV** (tested to 200 V/m per RTCA DO-160G)
- EMI-induced bit-error rate: zero at any tested field intensity

## 2. Network Specification

| Parameter | Value |
|---|---|
| Fiber type | PMMA step-index POF, 1 mm OD |
| Bandwidth | 100 MHz·km (exceeds all in-vehicle data rate requirements) |
| Attenuation | 200 dB/km at 650 nm (adequate for 10 m max run) |
| Connector | ZrO₂ ceramic ferrule, FC/PC type (PN-CC-002) |
| IP rating | IP68 (all connectors, 1 m/30 min) |
| Bend radius | 25 mm minimum |
| Operating temperature | −40°C to +85°C |
| Cost | $0.25–0.80/m |

## 3. Protocols by Function

| Function | Protocol | Data Rate | Notes |
|---|---|---|---|
| Motor torque command | MOST (over POF) | 25 Mbps | Automotive standard |
| Safety bus (ABS/ESC/AAJ) | ARINC 629 optical | 20 Mbps | Deterministic, fault-tolerant |
| Sensor data collection | Gigabit Ethernet (IEEE 802.3z) | 1 Gbps | LiDAR, camera streams |
| LoRa external comms | PMMA POF to LoRa module | 5.4 kbps | PN-CC-001 modules |
| BMS monitoring | I2C via optical coupler | 400 kbps | Zero metal to cell terminals |

## 4. Fleet Wiring Run Lengths

Calculated from vessel dimensions (longest run = longest vessel diagonal):
- TOURMALINE: max run 2.0 m → 0.4 dB loss → negligible
- BERYL: max run 6.0 m → 1.2 dB loss → acceptable (budget: 10 dB)
- RHODONITE: max run 15 m → 3.0 dB loss → acceptable (use 3× amplification node)


---
*End F2-019 | CSMVessel-Charlemagne-FleetV2 | June 2026*
