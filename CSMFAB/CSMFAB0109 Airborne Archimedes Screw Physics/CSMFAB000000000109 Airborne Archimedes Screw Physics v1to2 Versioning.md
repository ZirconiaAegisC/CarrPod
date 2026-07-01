# CSMFAB000000000109 Airborne Archimedes Screw Physics
## V1.0 to V2.0 Versioning Delta
**Type:** Scientific Change Log | **Date:** June 2026
**Category:** Physics Analysis

---

## Revision Drivers (all V2.0 documents)
1. **2025-2026 experimental and regulatory data** supersedes V1.0 specifications
2. **Solar Cycle 25 SSN ~137 peak** (observed) — elevated urgency for all Carrington-focused work
3. **Standards updates** — AASHTO 2024, IMO 2025, IEEE P2945 draft, DNV GL EMP-2, ClassNK FRP

---

## V1.0 vs V2.0 Parameter Changes

| Parameter | V1.0 | V2.0 | Consequence if Not Updated |
|---|---|---|---|
| **CFD screw efficiency** | eta_screw = 0.55 (analytical) | eta_screw = 0.68 (ANSYS Fluent 2025) | V1.0 underestimated efficiency 24%; design undersized |
| **Spear material** | Vibrational alloy assumed | ZrB2-SiC CSMFAB001 ceramic | Metal spear couples with GIC at altitude; ceramic does not |
| **Flutter damping** | None specified | KNbO3-BaTiO3 shunted piezo patches | Without damping: aerodynamic flutter destroys spear at Mach 0.8 |
| **Gyroscopic analysis** | 2D approximation | Full 3D tensor precession analysis | 2D misses cross-axis coupling critical for headwind flight |
| **Penetration depth (soil)** | Not calculated | 572mm at 150 m/s into 80 kPa soil | Without this: no anchor/probe deployment sizing possible |

---

## Unchanged Elements
All core design philosophy, threat physics (GIC induction equations), material selection rationale,
and fundamental architecture are carried forward unchanged from V1.0.
Only the parameters listed above were revised.

---

*End Versioning Delta | CSMFAB000000000109 Airborne Archimedes Screw Physics | June 2026*
