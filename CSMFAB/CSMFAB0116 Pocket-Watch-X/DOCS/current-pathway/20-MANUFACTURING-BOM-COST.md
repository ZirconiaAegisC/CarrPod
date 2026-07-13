# CSMFAB0116-20 — POCKET WATCH X: MANUFACTURING BILL OF MATERIALS & COST ANALYSIS
## 1. BILL OF MATERIALS (CORE UNIT)
| Component | Qty | Unit Cost | Extended Cost (1K) | Extended Cost (1M) |
|-----------|-----|-----------|---------------------|---------------------|
| SoC (Cortex-X4 octa-core) | 2 | 5 | 70 | 10 |
| LPDDR5X 8GB (shared) | 1 | 8 | 8 | 8 |
| UFS 3.1 128GB | 1 | 8 | 8 | 2 |
| Circular AMOLED 1440×1440 | 1 | 2 | 2 | 8 |
| Touch controller IC | 1 |  |  |  |
| Gorilla Glass 6 cover | 1 |  |  |  |
| PMIC + chargers | 2 | 2 | 4 | 6 |
| Battery 1850mAh toroidal | 1 | 5 | 5 | 0 |
| Qi2 coil + magnetics | 1 set |  |  |  |
| PCB (8-layer HDI) | 1 | 2 | 2 |  |
| Connectors (fin ×2 + divot) | 1 set | 5 | 5 | 6 |
| Housing (316L, CNC) | 1 | 5 | 5 | 8 |
| Vapor chamber | 1 |  |  |  |
| EMI shields | 1 set |  |  |  |
| Crown assembly | 1 |  |  |  |
| Crystals (32 kHz + 38.4 MHz) | 2 |  |  |  |
| Microphone + speaker | 2 |  |  |  |
| Antennas (WiFi/BT + LoRa) | 2 |  |  |  |
| Passive components | — |  |  |  |
| Screws, gaskets, adhesives | — |  |  |  |
| FPCs and interconnects | — |  |  |  |
| Nano-coating | 1 |  |  |  |
| **TOTAL BOM** | | | **86** | **15** |

## 2. ASSEMBLY COSTS
| Process | Per Unit (1K) | Per Unit (1M) |
|---------|---------------|---------------|
| SMT assembly (2 sides) | 2 | 8 |
| Display bonding | 5 |  |
| Fin slot alignment |  |  |
| Housing assembly | 2 |  |
| Test and calibration | 5 | 4 |
| Packaging |  |  |
| **TOTAL ASSEMBLY** | **00** | **6** |

## 3. TOTAL UNIT COST
| Tier | Volume | BOM | Assembly | NRE Amortized | Total COGS |
|------|--------|-----|----------|---------------|------------|
| Prototype | 100 | 86 | 00 | 50 | 36 |
| Pilot | 1,000 | 86 | 00 | 0 | 36 |
| Low Volume | 10,000 | 10 | 5 |  | 90 |
| Medium Volume | 100,000 | 70 | 5 | /tmp/gen_all_remaining.sh.50 | 35 |
| Mass Production | 1,000,000 | 15 | 6 | /tmp/gen_all_remaining.sh.05 | 71 |

## 4. NON-RECURRING ENGINEERING (NRE)
| Item | Cost |
|------|------|
| Industrial design | 50,000 |
| Mechanical engineering | 50,000 |
| Electrical engineering | 00,000 |
| PCB design (2 iterations) | 50,000 |
| Display custom tooling | ,200,000 |
| Housing tooling (forgings) | 80,000 |
| Connector tooling | 0,000 |
| Firmware/OS development | 00,000 |
| Certification (FCC/CE/BT SIG/etc.) | 50,000 |
| Test fixture development | 80,000 |
| Pilot run (100 units) | 3,600 |
| **TOTAL NRE** | **,033,600** |

## 5. RETAIL PRICING STRATEGY
| SKU | BOM | Margin | Retail |
|-----|-----|--------|--------|
| Base (316L) | 71 | 55% | 25 |
| Titanium | 95 | 55% | 78 |
| Brass | 85 | 55% | 56 |
| Fin: CPU Upgrade | 5 | 60% | 63 |
| Fin: GPU Upgrade | 8 | 60% | 45 |
| Fin: Memory 16GB+512GB | 8 | 60% | 20 |
| Fin: Wireless | 5 | 60% | 8 |
| Case Back: Extended Battery | 8 | 55% | 2 |
| Case Back: Cellular | 2 | 50% | 44 |
| Case Back: Satellite | 5 | 45% | 72 |
| Projector Dock | 5 | 50% | 70 |
| Keyboard Dock | 2 | 50% | 84 |

## 6. ASSEMBLY LINE DESIGN
| Station | Task | Time (s) | Workers |
|---------|------|----------|---------|
| S1 | SMT placement (top side) | 45 | 0 (auto) |
| S2 | SMT placement (bottom) | 45 | 0 (auto) |
| S3 | Reflow + AOI | 60 | 0 (auto) |
| S4 | Display bonding | 120 | 1 |
| S5 | Fin slot assembly | 60 | 1 |
| S6 | Housing + PCB integration | 90 | 2 |
| S7 | Case back + crown | 45 | 1 |
| S8 | Initial boot + firmware flash | 60 | 0 (auto) |
| S9 | Camera/display calibration | 90 | 1 |
| S10 | Functional test (automated) | 120 | 0 (auto) |
| S11 | IP68 test (sampling) | 30 | 1 |
| S12 | Final QC + packaging | 60 | 2 |
| **TOTAL** | | **825s (13:45)** | **9 operators** |

Throughput at 1M units/year: ~280 units/day/line. Required: ~10 lines.

