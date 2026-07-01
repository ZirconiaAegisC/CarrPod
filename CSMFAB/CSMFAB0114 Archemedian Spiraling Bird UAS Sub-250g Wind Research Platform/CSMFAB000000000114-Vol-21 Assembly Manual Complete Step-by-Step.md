# CSMFAB000000000114 — Vol-21
# Assembly Manual — Complete Step-by-Step
## Full Build Sequence for Cypress University Lab
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: Your 12-Step Build Guide

This is the master assembly document — everything distilled into a sequential build guide you can follow at your lab bench at Cypress University. Each step references the detailed volumes for deeper information. Work through these steps in order. Do not skip steps; each builds on the previous.

**Required tools:**
- FDM 3D printer (Prusa MK3 or equivalent) + PETG filament
- Soldering iron (temperature-controlled, 350°C recommended)
- 63/37 solder + flux pen
- Wire strippers (28AWG rated)
- Precision screwdriver set (M2, M3)
- Digital calipers (0.1mm resolution)
- Kitchen scale (0.1g resolution)
- Heat gun or lighter (for heat shrink tubing)
- Needle files and 400/800 grit wet sandpaper
- Needle-nose pliers
- Laptop with ArduPilot Mission Planner installed (free from ardupilot.org)
- Multimeter (continuity + voltage)

---

## PHASE 1: PRINT ALL PARTS (Days 1-3)

### Step 1 — Print the Spiral Body (3D-01, 3D-03)

Use 3D generation prompt file 3D-01 to generate the full spiral wing assembly STL. If needed, also print individual blade sections using 3D-03 and join with PETG adhesive.

Settings: 0.15mm layers, 4 perimeters, 20% gyroid infill, vertical orientation, PETG.
Expected print time: 4-6 hours.
**CHECKPOINT:** Weigh after printing. Target: 55-65g. If above 65g: re-examine settings.

### Step 2 — Print Supporting Parts

Print all remaining 3D parts in order of size (largest first):

| Part | 3D File | Material | Expected Mass | Print Time |
|---|---|---|---|---|
| Central Hub | 3D-02 | PETG | 8g | 45 min |
| Electronics Bay Shell | 3D-07 | PETG | 5g | 30 min |
| Nose Cone | 3D-04 | PETG | 8g | 30 min |
| Speed Governor | 3D-10 | PLA | 8g | 45 min |
| Smart Rope Housings ×4 | 3D-06 | BFRP or PETG | 1.5g each | 20 min each |
| Battery Compartment | 3D-09 | PETG | (inside bay) | 20 min |
| Launch Cradle | 3D-14 | PETG | 12g | 35 min |
| Tether Swivel Mount | 3D-11 companion | PETG | 2g | 15 min |

**CHECKPOINT:** All parts printed, support removed, deburred. All weighed individually and recorded.

---

## PHASE 2: ELECTRONICS PREPARATION (Days 3-4)

### Step 3 — Pre-Solder Electronics

On the bench (NOT inside the body):

1. Install heat inserts in FC mounting holes of Electronics Bay Shell (4× M2, 2× M2 on bay lid)
2. Solder XT30 female connector to battery leads from FC (10cm 22AWG leads)
3. Solder AMS1117-5V and AMS1117-3.3V LDO regulators to small perfboard with JST output connectors
4. Solder RFM95W LoRa module to SPI breakout wires (MOSI/MISO/SCK/CS/INT — 5 wires, 26AWG, 60mm each)
5. Solder SHT31 breakout to I2C wires (SDA/SCL/3.3V/GND — 4 wires, 60mm each)
6. Solder MPXV7002 ×4 to ADC wires (Signal/5V/GND — 3 wires × 4 = 12 wires, 40mm each)
7. Solder ATtiny85 to FTS sub-PCB (MOSFET gate, flyback diode, JST to SG90 servo)
8. Solder SMA driver PCB (4× AO3400 MOSFETs, gate resistors, JST connectors to SMA leads)

**CHECKPOINT (continuity test):** Use multimeter in continuity mode:
- Battery + to 5V reg input — no short to GND
- 5V output to FC 5V pin — continuity
- 3.3V output to LoRa VCC — continuity
- No cross-shorts between 5V and 3.3V rails

### Step 4 — Flash Flight Controller

1. Connect FC to laptop via USB micro cable
2. Open Mission Planner → Setup → Install Firmware
3. Select ArduPlane V4.x (not ArduCopter — ArduPlane has better fixed-wing/glider sensor handling)
4. Flash firmware, reboot FC
5. Configure parameters per the ASB-1 parameter file (provided as companion file: ASB1_params.param)
6. Verify barometer reads atmospheric pressure (~1013 hPa at sea level ± weather variation)
7. Verify IMU shows reasonable attitude (level when flat on desk)

---

## PHASE 3: ELECTRONICS INSTALLATION (Day 4-5)

### Step 5 — Populate Electronics Bay

1. Install FC on 4× silicone grommets in electronics bay — M2 × 6mm screws
2. Install LDO regulator board beneath FC (double-sided foam tape)
3. Route GPS wire from FC UART1 out through top port in bay shell — GPS antenna module goes on TOP of bay (later faces up in installed position)
4. Install RFM95W in lower bay area (double-sided foam tape)
5. Route LoRa antenna wire through side port — 86mm wire extends along outside of bay
6. Wire all components per diagram in Vol-18
7. Tuck all wires carefully — use small zip ties or hot glue blobs to keep organized
8. Total mass check: weigh full electronics bay assembly before closing. Target: ≤ 40g total.

### Step 6 — Install Battery Compartment

1. LiFePO₄ 2S 300mAh battery slides into the battery compartment (3D-09)
2. Secure with thin Velcro strap (1g)
3. Route XT30 connector to connect to bay power input
4. Snap battery compartment into body mid-section

---

## PHASE 4: ACTUATOR AND GOVERNOR INSTALLATION (Day 5-6)

### Step 7 — Install Smart Rope Actuators (Vol-09)

1. Thread nitinol SMA wire through each housing tube
2. Crimp end caps
3. Test activate each wire: 9V through 100Ω resistor → wire should contract visibly
4. Press-fit 4 housings into spiral arm slots at 60mm radius, 90° spacing
5. Run SMA wire leads through internal body channel to electronics bay
6. Connect to SMA driver PCB

### Step 8 — Install Speed Governor (Vol-08)

1. Press-fit governor hub assembly onto spiral body center shaft (bottom of body)
2. Verify flyweight arms swing freely on pivot pins
3. Connect 3 push rods from arm tips to blade root twist adjusters
4. Spring installation: thread pre-tension spring onto each arm bolt, set initial pre-tension
5. Bench test: spin at 3,000 RPM (drill test) — arms should be flush. Target: arms begin rising at 4,000 RPM.

### Step 9 — Attach Nose Cone and Tail Assembly

1. Press nose cone (3D-04) onto front of spiral body — it should snap-fit via integrated clips
2. Install wind sensor mast through nose cone top port — use PEEK sleeve at base, lock with set screw
3. Route pressure sensor tubes from mast base to MPXV7002 sensor array in electronics bay (4× 2mm silicone tubes, ~60mm each)
4. Attach tail fin assembly (3D-05) to bottom of body — 4× M2 screws
5. Install tether swivel mount at tail fin center — M3 heat insert + M3 stainless screw

---

## PHASE 5: FINAL ASSEMBLY AND SYSTEMS TEST (Day 6-7)

### Step 10 — Parachute Installation (Vol-11)

1. Pack parachute per Vol-11 procedure (star fold → roll → pack tube)
2. Insert pack tube into nose cone cavity
3. Install SG90 servo in nose cone (3 × M2 screws)
4. Fit servo arm to engage Velcro latch
5. Run servo wire through nose cone channel to electronics bay

### Step 11 — Full Weight Check

1. Weigh complete assembled device (all parts, battery installed, parachute packed)
2. **CRITICAL:** Must be ≤ 249g
3. Record actual weight in build log
4. If over 249g: identify heaviest non-essential component and reduce/remove

### Step 12 — Full Systems Test (Bench)

1. Power on → confirm green GPS lock LED within < 60 sec
2. SwarmView: confirm this unit appears on swarm map
3. Test FTS: SwarmView FTS test command → servo blinks (not deployed)
4. Test SMA actuators: send actuator commands from ground station → feel each arm for slight flex
5. Test speed governor: use drill on shaft, confirm arm rise at ~4,000 RPM
6. Test LoRa: walk 50m from device, confirm telemetry still received
7. Full pre-flight checklist (Vol-20) — all items green
8. **READY FOR TETHER TEST FLIGHT (Vol-25, Phase 1)**

---

## CHECKPOINT — Vol-21 Complete

Before proceeding to flight:
- [ ] All 12 assembly phases complete
- [ ] Device weight confirmed ≤ 249g on scale
- [ ] All systems tested per Step 12 bench test checklist
- [ ] IMU calibrated (Vol-18, 4-step calibration)
- [ ] FlightTest Phase 1 (tether test) planned per Vol-25

**Proceed to:** Vol-25 (Test Protocol)

---

*CSMFAB000000000114-Vol-21 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
