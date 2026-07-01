# CSMFAB000000000114 — Vol-05
# Sub-250g Mass Budget and Weight Engineering
## Every Gram Accounted For
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: The 249-Gram Constitution

In the ASB-1 design universe, weight is the governing constraint — the constitution from which all other design laws derive. Every single component decision, every material choice, every sensor selection, every wire gauge choice, every fastener — all are judged first by their mass contribution to the 249-gram limit.

Why 249 grams? Because 250 grams triggers mandatory FAA registration and (for some operations) Remote ID broadcast requirements. Staying at 249 grams or below keeps the device in a dramatically simpler regulatory category. It also keeps the device small and throwable by hand, which is the entire operational concept. Lose this constraint and you lose the mission.

This volume defines, justifies, and controls every gram in the ASB-1 system.

---

## Part 1: The Master Mass Budget Table

This table is the living document of the ASB-1's mass. Any design change that adds mass must identify which line item it replaces or reduces.

| # | Component | Baseline Mass | Notes |
|---|---|---|---|
| 1 | Spiral wing/body structure (BFRP 3D print) | 60 g | 3-turn helix body; inner hub; 150mm diameter |
| 2 | Nose cone (BFRP printed) | 8 g | 25mm dia × 40mm long ogive; wind probe mount |
| 3 | Tail vane / fin assembly (BFRP sheet) | 4 g | 4 fins × 0.6mm BFRP laminate; swivel mount |
| 4 | Electronics bay shell (BFRP printed) | 5 g | 38mm ID × 60mm clamshell; 1.2mm wall |
| 5 | Flight controller (SpeedyBee F405 Wing Mini) | 7 g | Tiny FC; gyro + baro + OSD included |
| 6 | IMU / barometric altimeter (BMP388) | 1 g | Integrated into FC board |
| 7 | GPS module (u-blox M8N min) | 8 g | 16mm × 16mm module; 3m accuracy |
| 8 | LoRa radio module (RFM95W 915 MHz) | 3 g | 16mm × 16mm; 125 mW TX |
| 9 | LoRa antenna (wire monopole) | 1 g | 82mm quarter-wave wire + connector |
| 10 | Micro brushless motor (optional, 1105 size) | 9 g | For hover assist in calm conditions |
| 11 | ESC (electronic speed controller, 10A) | 4 g | BLHeli_S 10A mini ESC |
| 12 | Battery (LiFePO₄ 2S 300mAh) | 35 g | GNB 2S 300mAh LiFePO₄; safest chemistry |
| 13 | Battery connector + leads (XT30) | 2 g | 100mm 22AWG leads |
| 14 | Smart Rope actuator system (4×SMA+housing) | 6 g | 4× nitinol wire 100mm + 3D printed housing |
| 15 | SMA driver circuit (tiny PCB) | 2 g | MOSFET + resistor array; custom or hobby |
| 16 | Speed governor assembly (3D printed PLA) | 8 g | Centrifugal flyweight; spring; axle bushing |
| 17 | Tether swivel attachment point | 3 g | UHMWPE ball swivel; M3 threaded stud |
| 18 | Micro-parachute FTS (packed) | 4 g | 20cm UHMWPE canopy; para cord + latch servo |
| 19 | Wind sensor mast (carbon tube, 3mm × 40mm) | 1 g | Note: carbon is conductive; isolate from body |
| 20 | MEMS pressure probe (4-hole, 3D printed) | 3 g | MPXV7002 or SDP810 differential sensors |
| 21 | Temperature/humidity sensor (SHT31) | 1 g | 2.5mm × 2.5mm; zero structure weight |
| 22 | Wiring harness (total vehicle wiring) | 4 g | 150mm avg runs; 26-28AWG throughout |
| 23 | Fasteners (M2 screws, heat inserts) | 2 g | 10× M2×6mm screws + inserts |
| 24 | Vibration isolation pads (silicone grommets) | 1 g | 4× 6mm M2 grommets for FC mounting |
| | **TOTAL BASELINE** | **177 g** | |
| | **FAA 249g LIMIT** | **249 g** | |
| | **REMAINING MARGIN** | **+72 g** | |

---

## Part 2: Margin Reserve Policy

The 72g margin is not "free weight" to add random features. It is a formal reserve, managed as follows:

| Reserve Category | Allocated Margin | Purpose |
|---|---|---|
| Manufacturing tolerance | 5 g | 3D prints can vary ±3% from CAD mass |
| Cable routing excess | 3 g | Actual wiring runs longer than minimal |
| Assembly hardware | 3 g | Zip ties, heat shrink, adhesive |
| Sensor upgrade path | 15 g | Future addition of lidar or ultrasonic |
| Extended tether leader | 5 g | 3m tether leader on device; 3m × 0.1g/m × 10 = 3g minimum; at 3mm dia = ~5g |
| Parachute upgrade | 4 g | Larger canopy if higher-altitude waiver |
| Battery capacity upgrade | 15 g | Option to use 2S 500mAh LiFePO₄ instead (+15g vs baseline) |
| Strategic reserve | 22 g | Do not spend without design review |
| **TOTAL RESERVE** | **72 g** | = 249 − 177 |

**Rule:** No single component may use more than 25g of strategic reserve without sign-off from the project lead (you). If a component choice requires more than 25g, it must displace something else from the baseline.

---

## Part 3: Component-Level Mass Analysis

### 3.1 The Spiral Body — Largest Single Mass (60g)

The spiral body accounts for 34% of the total mass budget. This is acceptable because it **is** the device — the spiral is both the structure and the aerodynamic surface.

**How 60g was calculated:**
- BFRP (Basalt Fiber Reinforced Polymer) density: 1.85 g/cm³
- Spiral shell wall thickness: 1.2mm
- Approximate outer surface area of 3-turn helix (150mm dia, 200mm tall): ~240 cm²
- Volume of 1.2mm-wall surface: 240 cm² × 0.12 cm = 28.8 cm³
- Mass: 28.8 × 1.85 = 53.3g
- Add hub cylinder (30mm dia × 200mm tall, 1.2mm wall): ~3g
- Add printed infill and support structures removed: estimate 3.7g waste
- **Total spiral body: ~60g** ✓

**Could this be lighter?** Yes — switching to 0.8mm walls reduces to ~40g, but structural analysis in Vol-16 shows 0.8mm walls fail in torsion at >3,000 RPM. 1.2mm is the minimum for structural safety. If alternate materials become available (thin carbon-fiber composite — but note: carbon is electrically conductive and violates the Stellar-Aegis non-inductive protocol), the body could lighten. For V1.0, 60g is fixed.

### 3.2 The Battery — Second Largest Mass (35g)

The LiFePO₄ 2S 300mAh battery was chosen for three reasons:
1. **Safety**: LiFePO₄ chemistry is the safest lithium chemistry — thermal runaway temperature is 210°C vs. 130°C for LiPo. Critical for Stellar-Aegis Protocol.
2. **Mass**: 35g is within budget. A LiPo equivalent (3.7V 2S 300mAh) would be ~20g, saving 15g, but violates the safety and thermal requirement.
3. **Endurance**: At 300mAh × 7.4V nominal = 2.22 Wh. At 30mW idle electronics draw (LoRa + GPS + FC), this provides 74 hours of sensor-only operation. At full motor-assist flight (5W typical), it provides 26 minutes. In passive autorotation mode (electronics only), 90+ minutes.

**Can we use a lighter battery?** The 200mAh 2S LiFePO₄ version weighs ~24g (saving 11g). Endurance drops proportionally. This is the primary budget decision for the builder: higher endurance or more mass margin. **Baseline uses 300mAh**; the builder can choose 200mAh to release 11g to the strategic reserve.

### 3.3 The Motor — Optional (9g)

The 1105 brushless motor is **optional** in the ASB-1. In winds above 5 m/s, the device autorotates without power. The motor is only needed for:
- Launching in very light or calm winds (indoors, demonstrations)
- An initial spin-up boost to get to autorotation threshold faster
- Controlled descent against light updrafts

If the use case is exclusively outdoor cliff/coastal wind research, **the motor and ESC can be removed**, saving 13g (9g motor + 4g ESC). This immediately drops the device to 164g, well under the 177g baseline. **Version 1.0 baseline includes the motor** to maximize flexibility. The build instructions in Vol-21 show how to omit it.

### 3.4 The GPS — Important Tradeoff (8g)

The u-blox M8N GPS module is the second heaviest electronic component. Its function (position telemetry for ground station display) is essential for BVLOS waiver compliance. The M8N is the smallest practical GPS module available at this precision class.

Alternative: The u-blox SAM-M10Q weighs just 3g (same ±3m accuracy) but costs more (~$25 vs. ~$12). If the 5g saving is needed for another component, the SAM-M10Q is the direct upgrade. Mark as a future option in Vol-22 (BOM).

---

## Part 4: Weight Engineering Rules

1. **Weigh everything before assembly.** A kitchen scale with 0.1g resolution (standard $12 Amazon cooking scale) is required for all component verification.
2. **Record actual mass vs. budgeted mass** in the build log (Vol-21). If actual exceeds budget by more than 5g cumulative, stop and solve before continuing.
3. **Print in BFRP/PETG first, weigh, then finish.** 3D prints often accumulate raft/support waste. Post-process (remove supports, sand) and weigh before assuming the CAD mass is accurate.
4. **Solder connections close to the board.** Long wiring runs add unnecessary mass. Route all wiring inside the body channel (Vol-21 shows routing path).
5. **No metal fasteners unless in compression.** Use M2 heat inserts for all threaded connections. Avoid oversize M3 where M2 suffices.

---

## Part 5: Mass Impact of Tether

The tether leader (the portion of tether attached to the device) adds mass during flight. This must be included in the takeoff weight calculation.

| Tether Configuration | Length on Device | Mass Added |
|---|---|---|
| Standard research (50m reel) | 3m leader | 0.3g (UHMWPE 0.5mm dia = 0.1g/m) |
| Extended research (100m reel) | 5m leader | 0.5g |
| Short tether (cliff edge test) | 1m leader | 0.1g |

UHMWPE (Dyneema) 0.5mm diameter monofilament: **0.1 g/meter**. This is negligibly light. Even a 50m full tether attached to the device would add only 5g to takeoff mass — negligible compared to the 72g margin.

> **Key design decision:** The tether is attached at the **tail swivel point** (3D-11), below the center of gravity. This is critical — attaching at the nose or mid-body would create pitch moments that destabilize the spiral. Below CG attachment lets the device swing freely at the natural pendulum angle (nearly vertical in updrafts).

---

## Part 6: Final Takeoff Weight Verification Checklist

Before each flight, complete this weight verification:

- [ ] Weigh fully assembled device (including battery, charged)
- [ ] Confirm weight is < 249g on your kitchen scale
- [ ] Weigh tether leader section and add to device weight
- [ ] Confirm total is still < 249g
- [ ] If total exceeds 249g: identify cause, remove component or reduce tether leader length, re-weigh
- [ ] Record date and weight in flight log

**Never assume — always weigh.**

---

## CHECKPOINT — Vol-05 Complete

Before proceeding, confirm:
- [ ] You have read the complete mass budget table and know every line item
- [ ] You understand the 72g reserve policy (do not spend without justification)
- [ ] You know which components can be removed or substituted to change the mass (motor, GPS, battery)
- [ ] You understand that the tether leader adds negligible mass
- [ ] You have identified a 0.1g resolution scale as a required tool for the build

**Proceed to:** Vol-06 (Wind Sensor Payload) or Vol-21 (Assembly Manual)

---

*CSMFAB000000000114-Vol-05 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
