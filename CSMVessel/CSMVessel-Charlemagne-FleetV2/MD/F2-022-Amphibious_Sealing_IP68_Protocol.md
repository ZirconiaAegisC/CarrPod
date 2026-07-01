# F2-022 — Amphibious Sealing IP68 Protocol
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Sealing Philosophy

**Every potential water-ingress path is treated as a likely failure mode.**
The Charlemagne Fleet operates in saltwater (σ = 5.5 S/m) — the most corrosive and
electrically conductive natural fluid on Earth. Standard automotive IP67 (1 m/30 min) is
inadequate. Fleet standard: **IP68+ (3 bar continuous / 30 m depth equivalent)**.

## 2. Hub Motor Triple-Seal System

| Seal | Material | Rated Pressure | Function |
|---|---|---|---|
| Primary: ZrO₂ face seal | Lapped ZrO₂ face, PEEK housing | 5 bar continuous | Main seal: shaft rotation |
| Secondary: Viton V-ring | FKM 70 Shore A | 5 bar backup | If primary fails |
| Cable gland: PEEK compression | PEEK CF40, ceramic ferule | IP68 at 3 bar | Power cable penetration |
| POF gland: ZrO₂ ferrule | PN-CC-002 ferrule | IP68 at 3 bar | Data fiber penetration |

**Critical rule:** Zero metallic cable armor on any cable exiting the motor housing.
UHMWPE mechanical protection braid only (PN-CC-008 family). Any metallic armor would
create a conductive path from housing to chassis → GIC coupling → EDM damage.

## 3. CMBC Vault Sealing

Vault seal: Viton quad-ring (PN-CC-003) in ZrB₂–SiC machined groove
- Test: Helium leak test 10⁻⁷ mbar·L/s before vehicle delivery
- Rated: 20 bar static (operational: 3 bar max during diving operations)
- Service interval: Inspect and replace every 5 years or 100,000 km

## 4. ALON Dome Hatch

Main hatch seal: Viton dual-rib (not quad-ring — this is a door seal, not a static joint)
- Rated: 5 bar (50 m equivalent)
- Confirmed by: Testing hatch at 3 bar/30 min salt spray per IEC 60529 IP68

## 5. Complete Vehicle IP68 Test Protocol

1. Close all hatches, verify all glands connected
2. Submerge to 1.0 m in 3.5% NaCl solution
3. Hold 30 minutes
4. Remove; immediately check: CMBC vault humidity sensor (PN-CC-014), all motor housings,
   all harness penetrations
5. Pass criterion: zero humidity ingress detected anywhere in 30 minutes post-test
6. Additionally: all hub motor Megger readings post-test must remain ≥10¹⁰ Ω


---
*End F2-022 | CSMVessel-Charlemagne-FleetV2 | June 2026*
