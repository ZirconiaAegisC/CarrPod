# CSMFAB0116-09 — POCKET WATCH X: CPU FIN MODULE SPECIFICATION
**Revision:** A — 2026-07-10 | **Dependencies:** 04-FIN-INTERFACE-SPECIFICATION

## 1. PURPOSE
The CPU Fin is an upgrade module that adds or replaces the primary processing capability of the Pocket Watch X.

## 2. MECHANICAL
As defined in CSMFAB0116-04 Section 2. Additional requirements:

| Parameter | Value |
|-----------|-------|
| PCB layers | 8-layer HDI (any-layer microvia) |
| Shielding | Top and bottom EMI shield cans (Cupronickel) |
| Thermal pad | Exposed copper pad (8×8 mm) on top for heat spreader contact |
| Weight | 3.5 g max |

## 3. PROCESSOR OPTIONS
| Arch | Example SoC | Cores | Max Clock | L2/L3 Cache | TDP | Process |
|------|-------------|-------|-----------|-------------|-----|---------|
| ARM | Cortex-X4 octa-core | 1+3+4 | 3.4 GHz | 1MB/8MB | 8W | 3nm |
| ARM | Cortex-A720 octa-core | 1+3+4 | 2.8 GHz | 512KB/4MB | 5W | 4nm |
| RISC-V | SiFive P870 hexa-core | 6 | 2.5 GHz | 1MB/4MB | 6W | 5nm |
| x86 | Intel Lunar-Lake-class | 4P+4E | 4.5/3.5 GHz | 2.5MB/12MB | 12W | 3nm (fin requires active dock cooling) |

## 4. MEMORY
| Parameter | Value |
|-----------|-------|
| RAM type | LPDDR5X-8533 |
| Capacity options | 8 GB / 16 GB / 32 GB |
| Bus width | 64-bit (2×32-bit channels) |
| Bandwidth | 68 GB/s |
| ECC | Optional (side-band ECC) |
| Package | PoP (Package-on-Package) with SoC |

## 5. POWER
| Parameter | Value |
|-----------|-------|
| Nominal draw (idle) | 150 mW |
| Nominal draw (typical) | 3.5 W |
| Max sustained | Per FDB (8 W typical CPU fin) |
| Peak (burst < 10 ms) | 1.5× sustained |
| Rails used | VCORE (1.1V), VIO (1.8V), VMAIN (3.3V) |
| Power management | DVFS via on-fin PMIC with main SoC control |

## 6. PCIE INTERFACE
| Parameter | Value |
|-----------|-------|
| Link width | ×4 |
| Generation | Gen4 (16 GT/s) |
| Endpoint class | Root Complex or Endpoint (configurable) |
| BAR0 | 256 MB (prefetchable, for direct memory access) |
| BAR1 | 64 KB (non-prefetchable, for control registers) |
| MSI-X | 32 vectors |
| AER | Supported |

## 7. INTER-SOC COMMUNICATION
When a CPU Fin is inserted, it may optionally negotiate to become the PRIMARY SoC:
1. On insertion, CPU fin advertises "root complex capable" in FDB flags.
2. Main SoC evaluates fin capability vs. its own.
3. If fin is more capable (higher benchmark score, newer generation), main SoC may yield primary role.
4. Handoff proceeds via failover protocol (CSMFAB0116-03).
5. Former primary becomes co-processor or standby.

## 8. BENCHMARK REQUIREMENTS
All CPU fins must self-report benchmark scores in FDB capability extension:
| Benchmark | Metric |
|-----------|--------|
| Geekbench 6 single-core | Score |
| Geekbench 6 multi-core | Score |
| SPECint 2017 rate-1 | Score |
| AI benchmark (MLPerf Tiny) | Inference time (ms) |
| Power efficiency | Geekbench 6 multi-core / Watt |

## 9. THERMAL INTERFACE
| Parameter | Value |
|-----------|-------|
| Contact area | 64 mm² (8×8 mm copper pad) |
| Flatness | < 0.03 mm across pad |
| Roughness | Ra < 0.4 µm |
| TIM recommendation | Shin-Etsu X-23-8030 (6 W/m·K) |
| Max junction temp | 105°C |
| Throttle onset | 95°C |

## 10. FIRMWARE
| Component | Description |
|-----------|-------------|
| On-fin boot ROM | Minimal init (DDR training, PCIe link up) |
| Fin driver | Loaded by main SoC OS after enumeration |
| DVFS table | Frequency/voltage pairs stored in fin EEPROM |
| Thermal table | Temperature/power limits in FDB extension |
| Update mechanism | Signed firmware via main SoC OTA pipeline |

## 11. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| PCIe link training | Insert fin, monitor LTSSM | Train to Gen4 ×4 within 100 ms |
| Benchmark | Run Geekbench 6 | Score within 5% of fin spec |
| Thermal | 8W sustained load, 1 hr | Junction < 95°C |
| Power | Precision ammeter on each rail | Within 10% of FDB declaration |
| Hot-plug | 5000 cycles | Zero enumeration failures |
| EMC | Near-field probe scan | No emissions above CISPR 32 Class B |

