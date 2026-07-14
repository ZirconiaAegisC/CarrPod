# CSMFAB0116-34 — ASSEMBLY PROCESS FLOW
## 1. COMPLETE ASSEMBLY FLOW
| Step | Station | Operation | Time (s) | Automated |
|------|---------|-----------|----------|-----------|
| 1 | S1 | Solder paste print (bottom side) | 30 | Yes |
| 2 | S1 | Pick-and-place bottom components | 45 | Yes |
| 3 | S2 | Reflow (bottom side) | 300 | Yes |
| 4 | S2 | AOI inspection (bottom) | 30 | Yes |
| 5 | S3 | Solder paste print (top side) | 30 | Yes |
| 6 | S3 | Pick-and-place top components | 60 | Yes |
| 7 | S4 | Reflow (top side) | 300 | Yes |
| 8 | S4 | AOI inspection (top) | 30 | Yes |
| 9 | S5 | ICT (in-circuit test) | 60 | Yes |
| 10 | S6 | Display bonding (OCA + vacuum lam) | 120 | Semi |
| 11 | S6 | Display functional test | 30 | Yes |
| 12 | S7 | Fin cage assembly | 60 | No |
| 13 | S7 | Battery install + connect | 45 | No |
| 14 | S8 | Housing + PCB + display integration | 90 | No |
| 15 | S8 | Crown + stem install | 45 | No |
| 16 | S9 | Case back install + torque | 30 | Semi |
| 17 | S9 | First boot + firmware flash | 60 | Yes |
| 18 | S10 | Display calibration | 90 | Yes |
| 19 | S10 | Camera calibration (if applicable) | 30 | Yes |
| 20 | S11 | Full functional test | 120 | Yes |
| 21 | S12 | IP68 sampling test (10%) | 30 | No |
| 22 | S12 | Final visual inspection | 30 | No |
| 23 | S12 | Packaging | 60 | No |
| TOTAL | | | ~1655s (27:35) | |

## 2. REWORK PROCEDURES
| Issue | Rework |
|-------|--------|
| Solder bridge | Hot air rework station, 350°C, 30s |
| Missing component | Manual placement + solder |
| Display delamination | Heat to 80°C, remove, clean, re-bond |
| Fin slot misalignment | Adjust set screws, re-measure |

