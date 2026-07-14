# CSMFAB0116-11 — POCKET WATCH X: MEMORY FIN MODULE SPECIFICATION
**Revision:** A | **Dependencies:** 04-FIN-INTERFACE-SPECIFICATION

## 1. PURPOSE
The Memory Fin adds RAM and/or NVMe storage to the Pocket Watch X via the fin bus.

## 2. RAM SPECIFICATIONS
| Parameter | Value |
|-----------|-------|
| Type | LPDDR5X |
| Speed | 8533 MT/s |
| Capacity options | 8 GB, 16 GB, 32 GB |
| Bus width | 64-bit (2 channels × 32-bit) |
| Bandwidth | 68 GB/s |
| ECC | Optional side-band ECC |
| Voltage | 1.05V (VDD1), 0.5V (VDD2) |
| Idle power | 25 mW (self-refresh) |
| Active power | 250 mW/Gbps |

## 3. STORAGE SPECIFICATIONS
| Parameter | Value |
|-----------|-------|
| Type | NVMe SSD (M.2 2230 equivalent in fin format) |
| Interface | PCIe Gen4 ×4 (shared with RAM controller) |
| Protocol | NVMe 1.4 |
| Capacity options | 128 GB, 256 GB, 512 GB, 1 TB, 2 TB |
| NAND type | 3D TLC (consumer), 3D pSLC (endurance) |
| Sequential read | 3500 MB/s |
| Sequential write | 3000 MB/s |
| Random 4K read | 500K IOPS |
| Random 4K write | 400K IOPS |
| Endurance | 0.3 DWPD (TLC), 1+ DWPD (pSLC) |
| Power (active) | 3.5 W |
| Power (idle) | 50 mW |
| Encryption | AES-256 XTS (self-encrypting drive) |

## 4. MEMORY COHERENCE
When a Memory Fin is inserted, its RAM joins a NUMA domain:
1. Local node: CPU fin / main SoC on-die LPDDR5X (8 GB, 68 GB/s)
2. Remote node: Memory Fin LPDDR5X (16-32 GB, 68 GB/s)
3. Main SoC OS treats this as NUMA node 1 with higher latency (+15 ns)
4. Cache coherence maintained via MESI protocol over PCIe CXL.mem protocol

## 5. CXL SUPPORT
Memory fins may implement CXL (Compute Express Link) over PCIe:
| Protocol | Support |
|----------|---------|
| CXL.io | PCIe enumeration and configuration |
| CXL.cache | Cache coherence between main SoC and fin |
| CXL.mem | Direct memory access to fin DRAM by main SoC |
| CXL 2.0 | Switching and pooling (future) |

## 6. WEAR LEVELING AND ENDURANCE
| Feature | Implementation |
|---------|---------------|
| Wear leveling | Dynamic + static, FTL-managed |
| Over-provisioning | 7% (TLC), 28% (pSLC) |
| Bad block mgmt | Factory + runtime remapping |
| ECC | LDPC (low-density parity check) |
| Read disturb | Periodic data refresh |
| Thermal throttling | Reduce writes at > 70°C NAND temp |

## 7. POWER RAILS
| Rail | Purpose |
|------|---------|
| VCORE (1.1V) | DRAM core |
| VIO (1.8V) | DRAM I/O |
| VMAIN (3.3V) | NAND and controller |

## 8. BENCHMARK REQUIREMENTS
| Benchmark | Metric |
|-----------|--------|
| DRAM: STREAM Triad | Bandwidth (GB/s) |
| DRAM: LMbench | Latency (ns) |
| NVMe: fio sequential | Read/Write MB/s |
| NVMe: fio random 4K | Read/Write IOPS |
| NVMe: fio latency | P99.9 latency (µs) |

## 9. VERIFICATION
| Test | Method | Criterion |
|------|--------|-----------|
| DRAM: memtest | Full address walk, 10 passes | Zero errors |
| DRAM: ECC injection | Flip bits via debug interface | Corrected/detected as expected |
| NVMe: endurance | Write 1 DWPD for life | Zero data loss |
| NVMe: power fail | Pull power during write | No data corruption |
| Hot-plug | 5000 cycles | Zero enumeration failures |
| NUMA latency | LMbench across nodes | Remote < 3× local latency |

