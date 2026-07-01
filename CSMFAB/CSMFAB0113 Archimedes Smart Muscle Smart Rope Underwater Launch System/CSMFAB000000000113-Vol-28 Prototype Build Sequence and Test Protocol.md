# CSMFAB000000000113-Vol-28
## Prototype Build Sequence and Hobbyist Test Protocol: Step-by-Step Guide
**Series:** CSMFAB000000000113 | **Volume:** 28 of 29 | **June 2026**

---

## 1. Minimum Viable Prototype (MVP): Scale 1 Nano Launch

**Goal:** Launch a 50 g, 160 mm ZrB2-SiC spinning spear from 10 m depth using 2 Smart Ropes and 2 paddleboards, achieving 300+ m/s exit velocity and >3 km apogee.

**Estimated build time:** 8-12 weeks for a 2-person team
**Estimated cost:** $400-$600 total
**Legal status:** 3.5 km apogee < 18,000 ft → below Class E airspace; no FAA notification required. File voluntary NOTMAR if >1 nm offshore.

### Phase 1 — Weeks 1-3: Spear Fabrication

**Week 1:** Acquire ZrB2 and SiC powders:
- ZrB2: 50g from American Elements (99.5%, -325 mesh): $42
- SiC: 10g from Alpha Aesar (98%): $8
- KNbO3-BaTiO3 discs (4×): from TDK 2025, $3.60 each = $14.40

Tape-cast ZrB2-SiC green tape per CSMFAB000000000001 protocol.
Press into 25mm diameter × 160mm cylinder mold (split steel mold, available from hobby ceramics supplier: $45).

**Week 2:** Fire in borrowed university ceramics kiln:
Flash sintering if available; conventional SPS otherwise.
Dimensional verification: OD 20mm ± 0.2mm, straightness < 0.5mm over 160mm length.

**Week 3:** Screw blade fabrication:
- Cast 3 helical blade segments from ZrB2-SiC green tape, arc-shaped
- Bond to spear body with ZrB2-SiC sinterable adhesive (CSM Materials Study Part I protocol)
- Install KNbO3-BaTiO3 flutter patches (4×) with UV epoxy

### Phase 2 — Weeks 4-6: Smart Rope Fabrication

**Week 4:** Acquire Smart Rope components:
- UHMWPE Dyneema SK75: 25m × 2 ropes = 50m, 3mm braid: $12.50 (DSM wholesale)
- ZrB2-SiC segment cubes: 16 per rope × 2 ropes = 32 cubes: machine from sintered blank $0.87 each = $27.84
- LoRa RAK3172 modules × 34 (including 2 per rope + 2 master + 2 spear): $6.50 each = $221

**Week 5:** Rope assembly:
- Thread UHMWPE through 16 ZrB2-SiC cubes per 10m rope
- Install KNbO3-BaTiO3 actuator in each cube
- Apply marine-grade viton O-ring seals on each bayonet joint
- Hydrostatic test at 15 bar for 1 hour

**Week 6:** Electronics integration:
- LoRa firmware: download open-source LoRa ranging firmware (GitHub: LoRa-Alliance/LoRaWAN-lib)
- Timing synchronization: GPS-disciplined crystal oscillators from GPSDXO ($45 each × 4 = $180)
- PMMA optical fiber trigger cable: 6m × $0.25 = $1.50 per rope

### Phase 3 — Weeks 7-8: Vessel Preparation and Dry Runs

- Acquire 2 paddleboards (or borrow): $0-$400
- Install BFRP rope mount frame on each paddleboard: $35 materials
- Dry-run rope deployment in swimming pool: verify timing synchronization < 0.2 ms
- Dry-run spear drop to 3m depth in pool: verify positive buoyancy, spin-up motor function

### Phase 4 — Weeks 9-10: Offshore Testing

**Test 1 — Static rope pull (no launch):**
- Deploy spear to 5m depth
- Rope pull test at 10% max force
- Verify synchronized actuation via accelerometer telemetry

**Test 2 — Shallow water launch:**
- Deploy spear to 3m depth
- Full rope actuation
- Measure exit velocity via high-speed camera (1000 fps): target >50 m/s
- Document trajectory arc

**Test 3 — Full depth launch:**
- Deploy spear to 10m depth
- Full rope actuation from 2 vessels
- Target exit velocity: 250-300 m/s
- Track apogee with radar altimeter or optical theodolite

---

## 2. Data Collection Protocol

Record during each test:
- Video: 4K main + 240fps super-slow for exit transition
- LoRa telemetry: acceleration, rotation, pressure vs time
- Radar track: if available (or theodolite manual tracking)
- Weather: sea state, wind, temperature, water depth

Key metrics:
- Water-exit velocity (from video frame analysis or radar)
- Trajectory angle vs predicted
- Rope synchronization timing (from telemetry)
- Spear spin rate at exit (from gyro telemetry)

---

## Citations (Vol 28)

- AeroTech hobbyist rocketry safety guidelines, 2024
- CSMFAB000000000001 V2.0, ZrB2-SiC fabrication protocol, CSM 2026
- CSMFAB000000000022 V2.0, Smart Rope manufacturing, CSM 2026
- FAA Advisory Circular AC 101-1, "Moored Balloons and Unmanned Rockets," 2022
- USCG Navigation Rules, International-Inland, 2022

*End Vol 28 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
