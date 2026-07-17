# CSMFAB064: CARR-FORGE — Open-Source Fabrication Platform
## Episode 17 | Priority P2 | By CITADEL

**Function:** Public, version-controlled repository hosting every CSM fabrication design. Community-contributed improvements. PCB Gerbers, 3D STLs, BOMs, assembly guides. Anyone can build, anyone can improve. Open standard hardware ecosystem.

**Platform Architecture:**
| Component | Implementation |
|-----------|---------------|
| Repository | Git-based (GitHub public org: carr-forge) |
| Design files | KiCad (PCB), FreeCAD (3D), Markdown (docs) |
| License | CERN-OHL-S 2.0 (hardware), CC-BY-SA 4.0 (docs) |
| CI/CD | Gerber generation on commit, auto-BOM costing |
| Web frontend | Static site (Hugo), searchable, filterable by category |
| Community | Issues, PRs, discussions, contributor recognition |
| Ordering | Direct links to PCBWay/Oshpark for Gerbers, JLCPCB for 3D prints |

**Initial Content:** All CSMFAB053-064 designs + existing CSMFAB catalog (01-064).

**Funding:** CarrPod.org domain + server hosting = $48/month. Community maintained.
