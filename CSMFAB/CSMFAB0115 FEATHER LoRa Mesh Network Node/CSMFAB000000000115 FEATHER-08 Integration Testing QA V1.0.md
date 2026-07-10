# CSMFAB000000000115 V1.0
## FEATHER-08: Integration, Testing & Quality Assurance Protocol
### Version 1.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications
**Classification:** Manufacturing Quality Document

---

## 1. Production Workflow

6 parallel subassembly stations → 1 final integration station:

| Station | Operation | Cycle Time (min) | Capacity |
|---------|-----------|-----------------|----------|
| 1 — Enclosure | SPS sintering + MXene spray + YInMn bake | 60 | 24 shells/cycle (4 kilns × 6) |
| 2 — Solar Panel | Frame attach + j-box + MC4 | 12 | 10 panels/hr (2 techs) |
| 3 — PCB Assembly | Pick-and-place + reflow + AOI + Parylene | 8 | 45 boards/hr (automated) |
| 4 — Cable Harness | Cut + strip + crimp + test | 6 | 10 harnesses/hr (1 tech) |
| 5 — Battery Pack | Cell match + spot weld + BMS | 15 | 8 packs/hr (2 techs) |
| 6 — BFRP Bracket | CNC route + drill + PTFE insert | 10 | 6 brackets/hr (1 CNC) |
| 7 — Final Assembly | Install PCB + battery + wiring + close + POST | 18 | 12 units/hr (4 techs) |

**Total capacity:** 12 units/hr × 8 hr shift × 250 days/yr = **24,000 units/year**
**8,000-unit deployment (Phases 1–3):** 16 weeks of production

## 2. Incoming Material Inspection

### Ceramic Shell QC
- Wall thickness: ultrasonic gauge (100%), 0.75 ± 0.05 mm
- Surface defects: visual 10× mag, 350 lux (100%), no cracks > 2 mm
- EMI SE: VNA 1–18 GHz (1 per 50 shells), ≥ 148 dB at 1 GHz
- Sintered density: Archimedes (1 per 100), ≥ 97.5% theoretical
- Dimensional fit: Go/No-Go gauge for clamshell mating (100%), < 0.5 mm gap

### PCB Assembly QC
- Solder joints: AOI (Koh Young Zenith 2), 100%
- Missing/wrong components: AOI + bed-of-nails electrical test, 100%
- SX1262 RF output: spectrum analyzer at antenna connector (100%), +22 ± 1 dBm
- SX1262 RX sensitivity: signal generator at -120 dBm (100%)
- ESP32-S3 boot: serial console (100%)
- BMS function: charge/discharge at 10A, cell voltages ±25 mV (100%)
- MPPT efficiency: Class AAA solar simulator (1 per 100), η ≥ 95%
- Parylene thickness: eddy current gauge (100%), 50 ± 10 μm

## 3. Final Integration Gate Test (15 minutes)

| Step | Test | Duration | Pass Criteria |
|------|------|----------|---------------|
| 1 | Visual inspection | 30 s | No scratches, SN label affixed, QR scannable |
| 2 | Enclosure seal | 60 s | Pressure decay: 5 kPa → ≤ 0.1 kPa drop in 60 s |
| 3 | POST | 20 s | Green LED triple blink → bootloader handshake |
| 4 | Battery SOC | 15 s | I²C from BMS → SOC ≥ 70% (shipping charge) |
| 5 | Solar input | 45 s | Solar simulator → MPPT reports Vmpp ± 5% |
| 6 | LoRa TX | 30 s | Shielded chamber → +22 ± 2 dBm on spectrum analyzer |
| 7 | LoRa RX | 30 s | Reference TX at -100 dBm → PER < 1% (100 packets) |
| 8 | GPS lock | 180 s | u-blox M10 cold start → 3D fix HDOP < 2.0 |
| 9 | BLE pairing | 20 s | Phone app sees node in commissioning list |
| 10 | Dielectric isolation | 15 s | 5 kV DC Megger, star ground to exterior → R > 100 GΩ |
| 11 | Firmware version | 10 s | Hash matches build manifest for this SN |
| 12 | Power-down | 5 s | Deep-sleep command → current < 10 μA |

**Gate test FPY target: ≥ 99.5%**

### Failed Unit Disposition

| Failure | Action |
|---------|--------|
| Cosmetic scratch | Touch-up paint, re-test |
| Enclosure seal leak | Replace EMI gasket, re-test step 2 |
| Battery SOC < 70% | Charge to 100%, re-test step 4 |
| MPPT tracking error | Replace MPPT board (modular), re-test step 5 |
| LoRa TX/RX failure | Replace SX1262 module (M.2 format), re-test steps 6–7 |
| GPS no-lock | Replace u-blox M10 module, re-test step 8 |
| Dielectric isolation failure | **CRITICAL** — quarantine, root-cause analysis required |
| Firmware mismatch | Re-flash via USB-OTG, re-test step 11 |

## 4. Production Burn-In Protocol

2% random sample (1 per 50 units) undergoes 48-hour burn-in:
- Thermal cycling: -20°C (4h) → +60°C (4h) → 6 cycles, PER < 0.1%
- Solar cycling: simulator on/off (2h/2h) → 12 cycles, MPPT error < 2%
- Mesh relay stress: 20-node chamber, 8-hop topology, 50% channel flood → PDR > 99.0%

Any burn-in failure → 100% inspection of that 50-unit production lot.

## 5. Field Commissioning Verification (7-Day Monitoring)

| Day | Verification |
|-----|-------------|
| 1 | Mesh join ≥ 2 neighbors, GPS lock held 24h |
| 2 | Solar charge cycle: morning→evening SOC increase verified |
| 3 | ITS data: ≥ 1 NTCIP telemetry packet received at District TMC |
| 4 | Temperature log: internal never > 60°C during afternoon peak |
| 5 | LoRa range: neighbor ping → link budget > 120 dB for closest 3 |
| 6 | Emergency channel: test alert on CH1 → reception at District HQ |
| 7 | **Released to operational status** — "commissioning" → "active" in mesh |

**Any day 1–6 failure → auto-flag for field service visit within 72 hours.**

## 6. Ongoing Quality Monitoring

Every node reports diagnostic heartbeat every 6 hours (CH7) containing: node_id, uptime_hours, battery_soc_pct, solar_wh_today, internal_temp_c, LoRa TX/RX packet counts, PER, GPS lock time, neighbor_count, mesh_hops_to_gateway, isolation_resistance, firmware_hash.

CSM Cloud Dashboard (AWS GovCloud, FedRAMP Moderate) applies anomaly detection (Isolation Forest):
- Battery SOC degradation > 2%/month → schedule replacement
- LoRa PER > 0.5% → possible antenna damage → field inspection
- Internal temp trending +3°C above district average → possible PCM degradation
- Isolation resistance < 10 GΩ → possible PTFE contamination → cleaning/replacement

**MTBF target: > 100,000 hours (> 11.4 years)**

---

*Every node that leaves the factory carries the weight of a statewide network. None will fail.*
