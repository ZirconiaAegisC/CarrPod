# CSMFAB000000000022 Smart Rope Actuator Design Specification
## V1.0 to V2.0 Versioning Delta
**Type:** Scientific Change Log | **Date:** June 2026
**Category:** Space Launch / Actuator

---

## Revision Drivers (all V2.0 documents)
1. **2025-2026 experimental and regulatory data** supersedes V1.0 specifications
2. **Solar Cycle 25 SSN ~137 peak** (observed) — elevated urgency for all Carrington-focused work
3. **Standards updates** — AASHTO 2024, IMO 2025, IEEE P2945 draft, DNV GL EMP-2, ClassNK FRP

---

## V1.0 vs V2.0 Parameter Changes

| Parameter | V1.0 | V2.0 | Consequence if Not Updated |
|---|---|---|---|
| **Piezoelectric actuator material** | PZT-5H (lead, Tc=193degC) | KNbO3-BaTiO3 (lead-free, Tc=310degC) | RoHS violation; thermally unreliable at -60degC altitude |
| **Hinge material** | Spring steel (ferromagnetic) | Ti3AlC2 MAX Phase (non-magnetic, machinable) | GIC failure at altitude; brittle at -60degC |
| **EMI shield** | Cu mesh SE=45 dB | MXene Ti3C2Tx SE=92 dB | 47 dB shielding deficit in DEW/HPM environment |
| **Actuator temp range** | -50degC to +200degC | -60degC to +400degC | V1.0 actuator fails at 30km altitude temperature |
| **V2.0 velocity estimate** | ~250 m/s estimated | 320-450 m/s (DE actuator data at altitude) | V1.0 velocity was under-estimated |

---

## Unchanged Elements
All core design philosophy, threat physics (GIC induction equations), material selection rationale,
and fundamental architecture are carried forward unchanged from V1.0.
Only the parameters listed above were revised.

---

*End Versioning Delta | CSMFAB000000000022 Smart Rope Actuator Design Specification | June 2026*
