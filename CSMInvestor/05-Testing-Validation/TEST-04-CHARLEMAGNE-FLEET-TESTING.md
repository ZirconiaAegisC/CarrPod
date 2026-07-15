# TEST-04: CHARLEMAGNE FLEET TESTING PROTOCOL
## Carrington Storm Motors — Project AEGIS
### Hull GIC Susceptibility • Amphibious Mechanism • Electronics Hardening • Propulsion • Safety

**Document Status:** Vessel Testing Protocol — Maritime Classification Alignment  
**Version:** 1.0 — 15 July 2026  
**Classification:** CONFIDENTIAL — Accredited Investor Eyes Only  
**Author:** Zirconia + Captain Meridia Vaun (CHARLEMAGNE)  
**Test Engineers:** Mork (dry dock/system testing), Chester (safety systems verification)

---

## TESTING PHILOSOPHY

A cruise vessel is a floating city of 3,000 souls, 100,000 gross tonnes, and 1,000 feet of steel hull that acts as a geomagnetic antenna. The Charlemagne testing protocol must verify that CSM's hardening transforms this 1,000-foot antenna into a 1,000-foot insulator — reducing hull-induced current to <0.03% of unprotected baseline. Testing spans three environments: dry dock (controlled current injection), sea trials (simulated GIC in open water), and in-service monitoring (continuous data during commercial operation).

---

## PHASE 1: COMPONENT-LEVEL VALIDATION (TRL 3→4→5)

### 1.1 MXene Hull Coating — Marine Environment

| Test | Method | Specimen | Duration | Pass/Fail |
|---|---|---|---|---|
| SE on Steel Substrate | ASTM D4935 (TEM cell) — MXene on shipbuilding steel (AH36 grade), 300×300×10 mm plates with surface preparation per marine coating standard (SSPC-SP10 near-white blast) | 5 coated plates, 5 uncoated control | — | SE >85 dB at 10 MHz–1 GHz on steel (steel's own SE is reflection-based; MXene adds absorption) |
| Salt Spray | ASTM B117, 5% NaCl, 35°C | 10 coated plates | 1,000 hours (extended from standard 500 — marine requirement) | SE degradation <5 dB; no blistering per ASTM D714 |
| Cyclic Corrosion (CCT) | ISO 20340 (Procedure A for offshore — 72h UV/condensation + 72h salt spray + 24h low-temperature at −20°C) | 10 coated plates | 25 cycles (4,200 hours) | SE degradation <10 dB; no under-film corrosion >2 mm from scribe |
| Cathodic Disbondment | ASTM G8 (impressed current cathodic protection at −1.5V vs. SCE for 28 days in synthetic seawater) | 5 coated plates | 28 days | Disbondment radius <10 mm from intentional holiday; coating remains adherent |
| Antifouling Compatibility | Apply commercial antifouling (silyl acrylate self-polishing) over MXene; verify no SE degradation and no MXene delamination | 5 plates with MXene + antifouling topcoat | 6 months seawater immersion (static raft test) | SE within 5 dB; no delamination; antifouling performance equivalent to standard hull coating |

**Cost: $124K; Duration: 12 months (cyclic corrosion is longest-lead test)**

### 1.2 BFRP Structural Elements — Marine Grade

| Test | Method | Acceptance |
|---|---|---|
| Tensile | ASTM D3039 (direction 0° and 90°) | >1,000 MPa (saltwater-saturated condition) |
| Compression | ASTM D6641 | >600 MPa |
| Flexural | ASTM D7264 | >800 MPa |
| Interlaminar Shear | ASTM D2344 | >50 MPa |
| Water Absorption | ASTM D570 (24h immersion) | <0.5% weight gain |
| Fire | IMO FTP Code Part 1 (non-combustibility), Part 5 (surface flammability) | Pass IMO criteria for non-combustible material; surface flammability within SOLAS limits |
| Smoke & Toxicity | IMO FTP Code Part 2 | Pass IMO criteria |

### 1.3 PMMA POF Wiring — Marine Installation

| Test | Method | Acceptance |
|---|---|---|
| Tensile (cable) | IEC 60794-1-2 (optical fiber cable tensile) | >500 N without optical performance degradation |
| Bend Radius | OTDR measurement at minimum bend | <30 mm minimum bend radius without insertion loss increase >0.1 dB |
| Fire | IEC 60332-1-2 (vertical flame propagation for single cable) | Self-extinguishing within 425 mm of top clamp |
| Smoke | IEC 61034-2 (smoke density, 3 m cube test) | >60% light transmittance (low smoke) |
| Halogen-Free | IEC 60754-1 (halogen acid gas) | <0.5% HCl equivalent |
| Vibration | MIL-STD-167-1 (shipboard vibration, Type I — environmental) | No connector loosening; OTDR stable throughout |
| Water Immersion | 30 days at 3 m water depth (simulated cable tray flooding) | No water ingress; OTDR stable |
| **Data Rate — 1,000 m** | Bit error rate test (BERT) at 1 Gbps, 1,000 m POF with 10 connectors | BER <10⁻¹² |

---

## PHASE 2: SUB-SCALE VESSEL SECTION (TRL 4→5→6)

### 2.1 Test Article — 10 m Hull Section

Construct a 10 m × 3 m × 3 m vessel hull section replicating:
- Outer hull: MXene-coated AH36 steel, 20 mm thickness
- Inner structure: BFRP stiffeners at 600 mm spacing
- Deck section: BFRP grating with MXene mesh overlay
- Cable tray: 1,000 m PMMA POF (representative 1/50th scale of vessel data network)
- Battery room mock-up: LiFePO₄ rack at 1:10 scale (2 MWh equivalent)
- Watertight door: Dielectric hinge, MXene gasket
- Ballast tank section: Coated interior with impressed current CP system

### 2.2 Test Sequence — Hull Section

| Test | Equipment | Procedure | Acceptance |
|---|---|---|---|
| Dry Dock Current Injection | 500 A AC source, 0.001–1 Hz; electrode array in water tank (seawater simulant: 3.5% NaCl) surrounding hull section | Inject current into water → measure hull current distribution via 24 Rogowski coils at BFRP/steel interfaces | Hull-induced current <0.03% of injected current; BFRP/steel interface current <1 mA |
| Hydrostatic Pressure | Seawater tank, pressurize to 0.5 MPa (50 m depth equivalent) on hull exterior | 24-hour sustained pressure; visual inspection + ultrasonic thickness measurement | No water ingress through coating; no delamination; coating thickness ±5% of pre-test |
| Fire Scenario | IMO FTP Code — pool fire (heptane) under hull section for 30 minutes | Temperature at inner hull surface; structural integrity post-fire | Inner hull temperature <200°C (BFRP glass transition ~140°C — must not exceed); no structural collapse |

**Phase 2 Cost: $1.8M (10 m hull section construction + testing); Duration: 6 months**

---

## PHASE 3: DRY DOCK — COMPLETE VESSEL TESTING (TRL 6→7)

### 3.1 Current Injection — Complete Vessel

**Test Configuration:**
- Vessel in dry dock (or floating at dock with shore power disconnected and gangway isolated)
- 4 × 1,000 A current injection electrodes placed at cardinal points 100 m from vessel in surrounding water (or ground for dry dock)
- Injection waveform: 0.001–1 Hz, 1–500 A per electrode (total 4–2,000 A injected)
- 200+ measurement points: Rogowski coils at all BFRP/steel interfaces, voltage sensors bow-to-stern and port-to-starboard, magnetometers at 10 locations on each deck

**Acceptance Criteria:**
- Hull-induced current (integrated across all measurement points) <0.03% of total injected current
- No individual measurement point exceeds 0.1% of injected current
- All dielectric joints (BFRP/steel interfaces) carry <10 mA at maximum injection
- PMMA POF data network: zero induced current, zero BER increase during injection
- LiFePO₄ battery BMS: no spurious protective trips triggered by induced currents
- FOG navigation: heading drift <0.1° during maximum injection

**Cost: $1.2M; Duration: 2 weeks (test execution), 2 months (preparation + analysis)**

### 3.2 System-by-System Verification

| System | Test | Method | Acceptance |
|---|---|---|---|
| Emergency Propulsion (piezoelectric) | Full power test at dock | Run emergency propulsion at rated power (2,000 HP if available; otherwise diesel-electric with dielectric isolation) for 1 hour | All electrical parameters within spec; motor-to-hull resistance >10⁸ Ω; zero abnormal vibration |
| Navigation (FOG + POF) | Accuracy comparison vs. GPS over 24 hours at dock | Compare FOG heading, roll, pitch with GPS/INS reference | Heading error <0.1° sec lat (standard for marine FOG) |
| Fire Suppression (dielectric pumps) | Flow test at each of 5 fire zones | Activate fire pumps; measure flow at each hydrant; run for 1 hour continuous | Flow >spec per fire plan; pump motor temperature within limits; dielectric isolation maintained |
| Emergency Communications (Protonic) | 12-node message relay test across vessel | Send 100 test messages between bridge, engine room, and 10 passenger deck nodes | >99% message delivery; latency <5 seconds per hop; zero messages lost |
| Hotel Load (LiFePO₄ battery) | Full charge/discharge cycle | Charge battery from shore power; discharge at 5 MW hotel load for 4 hours (simulated GIC event blackout duration) | Battery temperature within limits; BMS no faults; capacity >95% of rated |
| Entertainment Systems (POF network) | Bandwidth test to 100 representative cabins | Stream 4K video to 100 cabins simultaneously via POF backbone | >95% of cabins report zero buffering; bandwidth per cabin >25 Mbps |
| Watertight Integrity | Hose test per SOLAS II-1 | Spray all doors, hatches, cable penetrations with 12 mm nozzle at 10 m distance | No water ingress through any penetration |

### 3.3 Safety Systems — Emergency Drills

| Drill | Scenario | Duration | Acceptance |
|---|---|---|---|
| **GIC Blackout Drill** | All bridge electronics "fail" (simulated); crew must navigate on FOG backup; switch hotel load to LiFePO₄; activate Protonic emergency communications; launch lifeboats (simulated) | 2 hours | All systems transfer within SOLAS-required time limits; crew proficiency rated >80% by independent assessor |
| **Fire in Battery Room** | Simulated LiFePO₄ thermal event; crew must isolate, suppress, and evacuate adjacent zones | 1 hour | Fire team response time <5 minutes; suppression effective within 10 minutes; no simulated casualties |
| **Casualty Evacuation** | 50 simulated casualties (passenger + crew) distributed across 5 decks; crew must locate, triage, and evacuate to muster stations | 2 hours | All casualties located within 30 minutes; all evacuated within 2 hours; triage accuracy >90% |

**Phase 3 Cost: $3.8M (inclusive of crew training, independent assessors, instrumentation rental); Duration: 3 months (dry dock test window)**

---

## PHASE 4: SEA TRIALS (TRL 7→8)

### 4.1 Sea Trial Test Plan

| Test | Location | Duration | Method | Acceptance |
|---|---|---|---|---|
| **Speed/Power Trial** | Open ocean, calm conditions (Sea State <3) | 4 hours | Standardized speed trial per ITTC Recommended Procedures; measure shaft power at 50%, 75%, 90%, 100% MCR | Power within 5% of pre-retrofit baseline (MXene coating and BFRP structural weight — verify no drag penalty or power increase >2%) |
| **Endurance Trial** | Coastal transit, 24 hours | 24 hours | Continuous operation at service speed; all systems monitored | Zero EMI-related anomalies; all GIC sensors within background; battery system nominal |
| **Maneuvering Trial** | Designated sea trial area | 4 hours | Turning circle, zig-zag, crash stop per IMO resolution MSC.137(76) | Maneuvering characteristics within IMO standards; FOG navigation stable during all maneuvers |
| **GIC Simulation at Sea** | Open ocean, >50 nm offshore | 8 hours | Towed electrode array behind vessel; inject 0.001–1 Hz current into seawater; measure hull response (similar to dry dock test but in actual operating environment — most realistic GIC simulation possible) | Hull-induced current <0.03% of injected; all systems nominal; navigation unaffected |
| **Heavy Weather Trial** | Open ocean, Sea State 5–6 (if available) | 4 hours | Operate at reduced speed in heavy seas; monitor structural response of BFRP stiffeners via FBG strain gauges | BFRP strain within design limits; no structural acoustic emission (indicating no cracking); MXene coating adhesion maintained (visual inspection at next port) |
| **Anchoring Trial** | Designated anchorage, 30 m depth | 2 hours | Deploy and retrieve both anchors; verify windlass current isolation | Windlass motor-to-hull resistance >10⁸ Ω; anchor chain isolated from hull (ceramic fairlead inserts verified) |

### 4.2 Continuous Monitoring During Sea Trials

| Parameter | Sensors | Data Volume (24 hours) |
|---|---|---|
| Hull voltage (bow-stern, port-starboard) | 4 voltage sensors, 1 Hz | 345,600 samples/sensor |
| GIC at BFRP/steel interfaces | 200 Rogowski coils, 1 Hz | 17.3 million samples |
| POF data network BER | OTDR monitoring at 6-minute intervals | 240 measurements |
| Battery BMS telemetry | BMS CAN bus data, 1 Hz | 86,400 samples |
| Navigation (FOG vs. GPS) | FOG + GPS comparison at 10 Hz | 864,000 samples |
| Structural strain (FBG) | 50 FBG sensors at 100 Hz | 432 million samples |
| Engine/propulsion parameters | Engine room data logger, 0.1 Hz | 8,640 samples |
| **TOTAL** | | **~500 GB per 24 hours** |

**Phase 4 Cost: $4.5M (ship time, fuel, crew, equipment); Duration: 2 weeks at sea + 2 months data analysis**

---

## PHASE 5: IN-SERVICE MONITORING (TRL 8→9)

### 5.1 12-Month Commercial Operation

After sea trials, the Charlemagne pilot vessel enters commercial service with all 200+ GIC sensors continuously monitoring. Key metrics tracked:

| Metric | Target |
|---|---|
| GIC events detected (Kp ≥5 storm days) | Correlate with NOAA SWPC data; verify <0.03% induced current during actual geomagnetic storms |
| System availability (all hardened systems) | >99.9% uptime |
| Passenger/crew safety incidents attributable to EM systems | Zero |
| Insurance claims (compare to pre-retrofit baseline) | Documented reduction |
| Maintenance events on hardened systems | <2 per 1,000 operating hours |
| Passenger satisfaction (cruise surveys) | No negative comments related to EM hardening; <1% of passengers aware of hardening (transparent protection) |

**Phase 5 Cost: $1.8M (monitoring equipment + data analysis + crew training); Duration: 12 months**

---

## TARGET VERIFICATION — 0.03% INDUCED CURRENT

### Verification Methodology

The Charlemagne design target of <0.03% induced current is verified through:

1. **Component Level:** Each of 200+ BFRP/steel interfaces individually verified >10⁸ Ω DC resistance (Phase 1)
2. **Sub-Scale:** 10 m hull section current injection shows <0.03% (Phase 2)
3. **Dry Dock:** Full vessel current injection shows <0.03% (Phase 3) — PRIMARY VERIFICATION
4. **Sea Trials:** At-sea GIC simulation confirms dry dock results under operational conditions (Phase 4)
5. **In-Service:** During actual geomagnetic storms, continuous monitoring confirms sustained <0.03% (Phase 5)

**Metric Definition:** Hull-Induced Current Ratio = (Total current measured across all BFRP/steel interface Rogowski coils) / (Total current injected into water) × 100%. Target <0.03% means >99.97% of injected current is blocked or diverted around the hull by MXene coating + BFRP isolation.

---

## CHARLEMAGNE TESTING BUDGET SUMMARY

| Phase | Duration | Cost |
|---|---|---|
| Phase 1: Component Validation | 12 months | $1.2M |
| Phase 2: Sub-Scale Hull Section | 6 months | $1.8M |
| Phase 3: Dry Dock Vessel Testing | 3 months | $3.8M |
| Phase 4: Sea Trials | 2 months (at sea) | $4.5M |
| Phase 5: In-Service Monitoring | 12 months | $1.8M |
| **TOTAL** | **35 months** | **$13.1M** |

Plus: $47M for the vessel retrofit itself (not a testing cost — the vessel is a commercial asset after testing).

---

*"A cruise ship is the most complex machine most humans will ever set foot on. Testing it for electromagnetic hardening is not about one measurement — it is about 200 simultaneous measurements at every conductive interface, verified at the component level, the sub-scale level, the dry dock level, at sea, and in service. When 3,000 passengers board a Charlemagne-hardened vessel, they are trusting their lives to a system that has been tested to the same standard as a military vessel entering a combat zone — because a Carrington Event is a battlefield, and the enemy is the Sun."* — Captain Meridia Vaun (CHARLEMAGNE)

---

*Document generated 2026-07-15. All testing phases are contingent on securing a cruise line partner for the pilot vessel (see ROAD-09). Phase 1 (component validation) begins Q4 2026 upon MXene production at 10 kg/day. Phase 2 (hull section) requires dry dock access — target Q3 2027. Phase 3 (full vessel dry dock) tied to partner vessel's scheduled dry dock window (target Q1 2028). ABS/DNV surveyors to witness all Phase 3 and Phase 4 testing.*
