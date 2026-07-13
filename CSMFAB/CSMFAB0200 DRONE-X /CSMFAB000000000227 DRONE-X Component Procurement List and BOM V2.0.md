# CSMFAB000000000227 — DRONE-X Component Procurement List and BOM
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Procurement & Cost Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — complete BOM, $162.07/drone marginal cost, alternatives, batch pricing |

---

## 1. Complete Bill of Materials — Marginal Cost per Drone

| # | Component | Part Number | Source | Qty | Unit Cost | Extended |
|---|-----------|-------------|--------|-----|-----------|----------|
| 1 | Frame — BFRP filament | BFRP-Elium 1.75mm | Custom supplier | 318 g | $0.08/g | $25.44 |
| 2 | Motor | T-Motor F2306 1900KV | GetFPV / RaceDayQuads | 4 | $17.90 | $71.60 |
| 3 | ESC | BLHeli_32 30A | Hobbywing / Amazon | 4 | $11.50 | $46.00 |
| 4 | Propeller | Gemfan 6040-3 (set of 4) | GetFPV | 2 | $3.99 | $7.98 |
| 5 | Battery | GNB 3S 1800mAh 120C | GNB / Amazon | 1 | $16.99 | $16.99 |
| 6 | MCU board | STM32F103C8T6 Blue Pill | Amazon / AliExpress | 1 | $2.85 | $2.85 |
| 7 | Bluetooth module | HC-05 ZS-040 | Amazon / AliExpress | 1 | $3.50 | $3.50 |
| 8 | LoRa module | RFM95W SX1276 915 MHz | Adafruit / AliExpress | 1 | $9.95 | $9.95 |
| 9 | GPS module | BN-880Q (u-blox M8030) | Amazon / AliExpress | 1 | $14.99 | $14.99 |
| 10 | Power Distribution Board | Custom 2-layer PCB 50×40mm | JLCPCB (qty 5+) | 1 | $2.00 | $2.00 |
| 11 | Current sensor | ACS758LCB-050U | DigiKey / Mouser | 1 | $4.50 | $4.50 |
| 12 | Buck converter | Mini-360 MP1584 5V 3A | Amazon / AliExpress | 1 | $1.50 | $1.50 |
| 13 | Boost converter | MT3608 module | Amazon / AliExpress | 2 | $0.80 | $1.60 |
| 14 | Kill switch | MTS-202 DPDT toggle | Amazon / DigiKey | 1 | $1.50 | $1.50 |
| 15 | XT60 connector | Amass XT60U-F (pair) | Amazon | 1 | $1.50 | $1.50 |
| 16 | Capacitor 1000µF 25V | Low-ESR electrolytic | DigiKey / Mouser | 1 | $0.75 | $0.75 |
| 17 | Capacitor 330µF 25V | Low-ESR electrolytic | DigiKey / Mouser | 4 | $0.30 | $1.20 |
| 18 | Logic level shifter | TXB0104 module | Amazon / AliExpress | 1 | $1.20 | $1.20 |
| 19 | Misc hardware (bolts, standoffs, etc.) | Assorted M2/M3/M4 | Local / Amazon | 1 kit | $8.00 | $8.00 |
| 20 | Silicone wire (14/16/20/26 AWG) | Assorted | Amazon | 1 kit | $5.00 | $5.00 |
| 21 | Heat shrink + zip ties | Assorted | Amazon | 1 kit | $3.00 | $3.00 |
| 22 | USB-C OTG adapter | Micro USB to USB-C | Amazon | 1 | $1.50 | $1.50 |
| 23 | SMA antenna 915 MHz | Dipole 2 dBi | Amazon / AliExpress | 1 | $2.50 | $2.50 |
| 24 | MXene synthesis materials | Ti₃AlC₂, LiF, HCl (per 10 drones) | Lab supply | 0.1 kit | $12.00 | $1.20 |
| | **TOTAL MARGINAL COST** | | | | | **$162.07** |

## 2. Cost Breakdown by Subsystem

| Subsystem | Cost | % of Total |
|-----------|------|------------|
| Propulsion (motors, ESCs, props) | $125.58 | 77.5% |
| Electronics (MCU, BT, LoRa, GPS, PDB, sensors) | $43.39 | 26.8% |
| Power (battery, converters, connectors) | $22.84 | 14.1% |
| Frame (filament, hardware) | $33.44 | 20.6% |
| Materials (MXene, wire, misc) | $18.20 | 11.2% |

*Note: Percentages sum > 100% due to overlapping categorization.*

## 3. Component Alternatives

| Component | Primary | Budget Alt | Budget Cost | Performance Impact |
|-----------|---------|------------|-------------|-------------------|
| Motor | T-Motor F2306 $17.90 | DYS Samguk 2207 $10.90 | -$28.00 | -8% thrust, -5% efficiency |
| Battery | GNB 1800mAh $16.99 | CNHL 1500mAh $12.99 | -$4.00 | -1 min flight time |
| GPS | BN-880Q $14.99 | GY-NEO6MV2 $5.99 | -$9.00 | GPS only, no GLONASS/Galileo |
| ESC | BLHeli_32 30A $11.50 | BLHeli_S 30A $7.50 | -$16.00 | No ESC telemetry, slower response |
| Battery (safe) | GNB LiPo $16.99 | LiFePO4 3S2P $22.00 | +$5.00 | +1000 cycle life, -15% flight time |

**Budget total (with all alts): $105.07** — suitable for educational/training use where performance is secondary.

## 4. Batch Pricing

| Quantity | Motors (ea.) | ESCs (ea.) | Batteries (ea.) | Total BOM/drone |
|----------|-------------|------------|-----------------|-----------------|
| 1 drone | $17.90 | $11.50 | $16.99 | $162.07 |
| 5 drones | $16.50 | $10.00 | $15.00 | $146.57 |
| 10 drones | $15.00 | $9.00 | $14.00 | $135.07 |
| 50 drones | $13.50 | $8.00 | $12.50 | $119.57 |
| 100 drones | $12.00 | $7.00 | $11.00 | $103.07 |

Prices based on competitive quotes from 3+ distributors (GetFPV, RaceDayQuads, HobbyKing) as of June 2026. BFRP filament cost assumes in-house compounding at scale; commercial filament sourcing adds ~$5/drone.

## 5. Lead Times

| Category | Typical Lead Time |
|----------|-------------------|
| Motors (T-Motor) | 5–10 days (US distributor) |
| ESCs | 3–7 days |
| Batteries | 3–5 days (ground shipping only, Hazmat) |
| Custom PCB (JLCPCB) | 7–14 days (standard), 3–5 days (expedited) |
| BFRP filament | 14–21 days (custom compound) |
| MXene precursor (Ti₃AlC₂) | 14–30 days (lab supply chain) |

---

*"Every dollar on the BOM is a choice between cost and capability. Document the choice so the next builder understands the trade."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Quarterly (price updates)
- Distribution: Engineering Team, Procurement, Finance
- Next Scheduled Review: October 2026
- Status: APPROVED — Fiscal Baseline
