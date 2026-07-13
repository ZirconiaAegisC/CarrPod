# CSMFAB0116-27 — POCKET WATCH X: CAMERA FIN MODULE SPECIFICATION
## 1. SENSOR SPECIFICATION
| Parameter | Value |
|-----------|-------|
| Sensor | Sony IMX586 (1/2.0" type) or equivalent |
| Resolution | 48 MP (8000 × 6000 effective) |
| Pixel size | 0.8 µm (1.6 µm with 4-in-1 binning) |
| Binned resolution | 12 MP (4000 × 3000) |
| Lens | 5-element plastic, f/2.0 |
| Focal length | 4.7 mm (26 mm equivalent) |
| Focus | PDAF (phase detection auto focus) |
| OIS | 2-axis optical image stabilization |
| Video | 4K @ 60 fps, 1080p @ 240 fps |
| ISP | On-fin image signal processor |

## 2. MECHANICAL
| Parameter | Value |
|-----------|-------|
| Fin dimensions | 22 × 12 × 5.5 mm (taller than standard) |
| Lens protrusion | 1.5 mm above fin surface |
| Privacy shutter | Physical sliding cover |
| Lens protection | Sapphire glass window |

## 3. VIDEO STREAMING OVER FIN BUS
| Parameter | Value |
|-----------|-------|
| Interface | PCIe Gen4 ×4 |
| Format | MIPI CSI-2 encapsulated over PCIe |
| Max throughput | 12 Gbps (sufficient for 4K/60) |
| Latency | < 5 ms (glass-to-glass) |
| HDR | Staggered HDR (2 exposures) |

## 4. POWER
| Mode | Power |
|------|-------|
| 4K/60 video | 2.5 W |
| 1080p/60 video | 1.2 W |
| Photo burst | 2.0 W |
| Standby | 50 mW |
