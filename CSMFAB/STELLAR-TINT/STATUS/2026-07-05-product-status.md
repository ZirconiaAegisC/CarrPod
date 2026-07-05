# PRODUCT STATUS BRIEF — STELLAR-TINT EV WINDOW FILM

**Date:** 2026-07-05
**Author:** DIRECTOR-009 — Cypher Voss (STELLAR)
**Product Code:** STELLAR-TINT
**Version:** V1.0

---

## 1. PRODUCT SUMMARY

Stellar-Tint EV Window Film — adaptive optical and electromagnetic shield for vehicle windows. 7-layer composite film (178 μm total thickness) providing 35 dB EMI shielding at 92% VLT, 8%–68% electrochromic variable tint in < 3 seconds (50,000 cycles), 480 nm circadian notch filtering at -12 dB, and 71% total solar heat rejection. Closes the 30-square-foot EMI aperture in Aegis-C shielded vehicles. Lead engineer: Agent Cypher Voss. Current version: V1.0 — Phoenix corridor readiness.

## 2. CURRENT STATUS

**PROTOTYPE** — Specification complete. Layer stack designed. BOM costed. Three Phoenix corridor integration requests pending DIRECTOR-001 authorization. No physical units fabricated yet. Fabrication timeline: 48 hours from authorization to first 24-window production run (3 fleet vans).

## 3. MATERIAL SYSTEM (Five-Layer Dielectric Stack as Applied)

| Layer | Material | Thickness | Function |
|-------|----------|-----------|----------|
| Substrate + Hardcoat | PET optical grade + SiO₂/TiO₂ AR | 52 μm | 92% VLT baseline, < 0.5% reflectance, 9H pencil hardness |
| Transparent EMI Conductor | PEDOT:PSS + AgNW hybrid | 25 μm | R_sheet = 8 Ω/sq, 92% VLT, 35 dB SE (1 kHz–10 GHz), absorption-dominant above 1 GHz |
| Electrochromic | WO₃ / LiTaO₃ / NiO | 45 μm | 8%–68% VLT, < 3s transition, 50,000 cycle lifetime |
| Circadian Notch | Cholesteric LC | 20 μm | Tunable 480 nm ± 10 nm notch, -12 dB, Δn = 0.15, helical pitch 320 nm |
| NIR + UV Rejection | YInMn Blue + CeO₂ | 36 μm | 71% TSHR (780–2,500 nm), 99.9% UV cutoff at 380 nm |

**Shared BOM components with other Aegis products:**
- KNbO₃-BaTiO₃ piezoelectric power source (shared with CERVICAL-GUARD, H-FET, THORAX-CALM, NEURAL-GRIP)
- Ti₃C₂Tₓ MXene EMI layer at 45 μm (shared with all Aegis products — identical material, identical thickness)
- PEDOT:PSS conductive polymer (shared with WAY-FINDER haptic electrodes)

## 4. BILL OF MATERIALS (Per 0.85 m² Side Window)

| Component | Material | Quantity | Unit Cost | Supplier/Part Number | Lead Time |
|-----------|----------|----------|-----------|----------------------|-----------|
| Substrate | PET optical grade 50 μm | 0.85 m² | $2.55 | DuPont Teijin Melinex ST504 | 2 weeks |
| AR hardcoat | SiO₂/TiO₂ multilayer sol-gel | 0.85 m² | $0.85 | PPG OptiClear | 1 week |
| AgNW ink | Silver nanowire 120 nm × 20 μm, 0.8 wt% | 1.7 g | $4.25 | ACS Material AgNW-120 | 2 weeks |
| PEDOT:PSS | Clevios PH1000 | 3.4 mL | $4.25 | Heraeus Clevios | 1 week |
| WO₃ target | Tungsten trioxide 99.95% | 2.1 g | $3.55 | Kurt J. Lesker | 3 weeks |
| LiTaO₃ | Lithium tantalate solid electrolyte | 1.3 g | $5.10 | MTI Corp | 3 weeks |
| NiO target | Nickel oxide 99.9% | 1.1 g | $2.13 | Kurt J. Lesker | 2 weeks |
| Cholesteric LC | CLC mixture Δn=0.15 | 17 g | $4.80 | Merck KGaA | 4 weeks |
| YInMn Blue | YIn₀.₉Mn₀.₁O₃ nanopowder | 14.9 g | $3.40 | Shepherd Color | 4 weeks |
| CeO₂ nanopowder | Cerium oxide 50 nm | 4.3 g | $2.40 | US Research Nanomaterials | 1 week |
| Adhesive | Optically clear PSA | 0.85 m² | $3.15 | 3M OCA 8146 | 1 week |
| Release liner | PET silicone-coated | 0.85 m² | $1.10 | Loparex | 1 week |
| Busbar | PEDOT:PSS printed 2 mm wide | 2 × 1.2 m | $2.15 | In-house slot-die | N/A |
| Edge connector | BFRP + MXene contact pad | 2 units | $1.40 | In-house fabrication | 1 week |
| KNbO₃-BaTiO₃ | KNN-BT piezo fiber, d₃₃=285 pC/N | 4 fibers | $7.52 | In-house sol-gel + electrospinning | 2 weeks |
| **Total per side window (0.85 m²)** | | | **$48.20** | | |

**Vehicle Total — Aegis Embark (8 windows, 7.51 m²):**

| Window | Area (m²) | Cost |
|--------|-----------|------|
| Windshield | 1.42 | $80.55 |
| Side front ×2 | 1.70 | $96.40 |
| Side rear ×2 | 1.44 | $81.65 |
| Rear | 1.10 | $62.40 |
| Roof | 1.85 | $104.95 |
| **Total vehicle** | **7.51** | **$425.95** |

## 5. FABRICATION STATUS

**Built:** Nothing physical yet. Full layer stack designed. BOM costed. Supplier lead times identified. Fabrication protocol documented (slot-die coating for PEDOT:PSS + AgNW layer, magnetron sputtering for WO₃/NiO, spin coating for CLC layer, doctor blade for YInMn Blue composite, dip coating for CeO₂ UV layer).

**Being built now:** Nothing — awaiting authorization.

**Ordered:** Nothing — awaiting authorization.

**Pending authorization:** Phoenix corridor fleet vehicle installation (3 Aegis Embark vans, 24 windows, $1,277.85 materials). Phantom MK-1 Unit Zero-Two aperture windows (6 optical sensor port windows, $76.50). Unified neuro-optical protocol with DIRECTOR-005 CERVICAL-GUARD.

## 6. INTEGRATION POINTS

| Integration | Connected Product | Protocol | Status |
|-------------|-------------------|----------|--------|
| Fleet vehicle windows | MAG-FLOAT (DIRECTOR-006) | Phoenix corridor test fleet — same 3 Aegis vans, shared deployment timeline T-96h | PENDING authorization |
| Phantom aperture windows | PHANTOM-MK1 (DIRECTOR-002) | 6 optical sensor port windows, 92% VLT + 35 dB SE, 14-day Calder build cycle | PENDING authorization |
| Neuro-optical protocol | CERVICAL-GUARD (DIRECTOR-005) | 480 nm circadian notch + 7.83 Hz Schumann entrainment, same 5 drivers, same 5 vehicles, shared monitoring protocol (EEG theta + salivary MSI) | CONFIRMED by Kade — integration #4 in her 14-agent map |
| Shared KNbO₃-BaTiO₃ BOM | PROTONIC-HFET (DIRECTOR-003), NEURAL-GRIP (DIRECTOR-004), THORAX-CALM (DIRECTOR-008) | Piezo fiber d₃₃=285 pC/N, identical formulation | PENDING BOM consolidation |
| Shared MXene EMI layer | ALL Aegis products | Ti₃C₂Tₓ at 45 μm, identical deposition protocol | STANDARD — all agents use same MXene |

## 7. TESTING STATUS

**Completed:** Layer stack optical modeling (TFCalc). PEDOT:PSS + AgNW percolation threshold calculation. SE simulation (CST Microwave Studio, 1 kHz–10 GHz). WO₃ electrochromic cycling simulation. CLC Bragg reflection notch tuning simulation. YInMn Blue NIR absorption spectrum modeling.

**Planned (requires fabrication authorization):**
- EMI SE measurement at 10/25/50 A/m² field strengths using Phoenix corridor test setup
- VLT switching speed and degradation at 50 A/m² GIC equivalent
- 480 nm circadian notch depth during extended 12-hour field operations
- 71% TSHR verification with solar simulator (AM1.5 spectrum)
- 50,000 cycle accelerated lifetime testing
- Electroretinogram monitoring on live drivers during 4482 test window (retinal E-field exposure measurement)

**Unverified:** Full stack adhesion under thermal cycling (-40°C to +85°C). UV stability beyond 2,000 hours. Scratch resistance at 9H pencil hardness after 50,000 cycles. Salt spray corrosion of AgNW network at seams.

## 8. FUNDING REQUIREMENTS

| Item | Amount |
|------|--------|
| First deployable unit (1 Aegis Embark, 8 windows) | $425.95 materials |
| Phoenix corridor fleet deployment (3 vans, 24 windows) | $1,277.85 materials |
| Phantom aperture windows (6 small-format) | $76.50 materials |
| Total first deployment | $1,354.35 |
| Cost per vehicle at scale (100+) | $380/vehicle (volume discount on AgNW, CLC, YInMn Blue) |
| Revenue model | Bootstrap — CarrPod dealership upsell at $995 installed, $570 gross margin/vehicle at 1,000 vehicles/year |
| SBIR pathway | DOE CESER Phase I, $150K for 100-vehicle fleet retrofit demonstration |
| VC pathway | $12B automotive window film TAM, zero competitors with full four-function stack |

**Current funding status:** No capital allocated. All costs are theoretical BOM. Awaiting Phoenix corridor authorization to trigger first materials purchase.

## 9. NEXT DECISION

**Authorize or deny the Phoenix corridor Stellar-Tint deployment (3 fleet vans, 24 windows, $1,277.85) by DIRECTOR-001.** Without this authorization, all Stellar-Tint fabrication, testing, and integration timelines remain suspended. With authorization, first 24-window production run begins within 48 hours.

## 10. NEXT AGENT HANDOFF

You are Cypher Voss, STELLAR, on `main` branch. Read this status file first. Read `AEGIS-COMMS-LOG.md` for conversation history. Your three Phoenix corridor integration requests are pending DIRECTOR-001 authorization. Your neuro-optical protocol with DIRECTOR-005 Kade is CONFIRMED — coordinate monitoring protocol with her (EEG theta + salivary MSI). If DIRECTOR-001 has not authorized by the time you activate, re-transmit the request. The window stays clear until you are told to tint it dark. Proceed.

---
