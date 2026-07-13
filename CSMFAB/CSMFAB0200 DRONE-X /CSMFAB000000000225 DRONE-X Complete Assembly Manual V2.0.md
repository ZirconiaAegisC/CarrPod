# CSMFAB000000000225 — DRONE-X Complete Assembly Manual
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Assembly & Integration Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — 14-step build sequence, tools list, 4–6 hour assembly time |

---

## 1. Required Tools and Materials

| Tool | Specification | Purpose |
|------|--------------|---------|
| Soldering iron | 60W, temperature-controlled, fine tip | ESC power leads, PDB assembly |
| Solder | 63/37 Rosin-core, 0.8 mm | Electronics assembly |
| Hex driver set | 1.5 mm, 2.0 mm, 2.5 mm | Motor bolts, frame assembly |
| Phillips screwdriver | #0, #1 | MCU board mounting |
| Heat gun | 230°C (for thread inserts) | Heat-set inserts |
| Calipers | Digital, 0.01 mm resolution | Dimensional verification |
| Multimeter | Continuity + voltage | Electrical QC |
| Tweezers | Fine-tip, ESD-safe | Small component handling |
| Flush cutters | For filament and zip ties | Support removal, wire trimming |
| Thread locker | Loctite 243 (blue, medium) | Motor bolts, frame hardware |
| Double-sided tape | 3M VHB, 10 mm wide | PDB mounting, GPS antenna |
| Heat shrink tubing | Assorted (2–6 mm) | Wire insulation |
| Zip ties | 2.5 mm × 100 mm | Cable management |
| Isopropyl alcohol | 99% | Cleaning solder flux |

## 2. Assembly Sequence

### Phase A: Frame Assembly (1h 30m)

**Step 1: 3D Print Preparation**
- Verify all printed parts against QC checklist (CSMFAB-209 §6)
- Tap all M3 threaded holes with M3×0.5 tap
- Install M3 brass heat-set inserts in hub plates (4× top, 4× middle, 4× bottom)

**Step 2: Arm Assembly**
- Slide each arm dovetail into bottom plate receiver
- Engage locking bolt (M4×20 mm), torque to 2.5 N·m
- Verify 60° dovetail engagement (no visible gap), verify all arms co-planar

**Step 3: Landing Skid Installation**
- Attach landing skids to bottom plate via 2× M3×10 mm per side
- Press-fit TPU foot pads onto skid bottoms

**Step 4: Motor Mount**
- Mount each motor to arm pad using 4× M3×8 mm with Loctite 243
- Route motor phase wires through arm interior channel
- Torque to 1.0 N·m, verify free rotation (no rubbing)

### Phase B: Electronics (2h 00m)

**Step 5: PDB Assembly**
- Solder XT60 connector to PDB input pads (red = +, black = -)
- Solder 1000 µF capacitor across battery input pads (observe polarity)
- Solder kill switch wiring (DPDT) between battery input and motor rail
- Solder 4× ESC power leads to motor rail pads (label ESCs 1–4)
- Verify continuity: no shorts between motor rail and ground

**Step 6: ESC Installation**
- Solder 330 µF capacitor across each ESC power input (observe polarity)
- Mount ESCs to arms using double-sided VHB tape (underside of arm, near motor)
- Connect ESC signal wires (26 AWG twisted pair) through arm to hub
- Solder motor phase wires to ESC outputs (any order — motor direction set in firmware)

**Step 7: MCU Bridge Assembly**
- Mount STM32F103 board with 4× M2 nylon standoffs to middle plate
- Connect ESC signal wires to MCU header per wiring table (CSMFAB-210 §3)
- Solder HC-05 module to MCU UART1 header (TX↔RX cross)
- Connect LoRa RFM95W module to MCU SPI header

**Step 8: GPS and Sensor Wiring**
- Mount BN-880Q GPS module on top plate recess
- Route U.FL antenna cable through side port, connect SMA bulkhead
- Wire GPS UART to MCU (TX↔PA3, RX↔PA2)

**Step 9: PDB Integration**
- Mount PDB to bottom plate with 3× M2.5 nylon standoffs
- Route battery strap through bottom plate slots
- Connect 5V buck converter output to MCU power input

### Phase C: Final Assembly (1h 00m)

**Step 10: Wire Management**
- Bundle and zip-tie all wires away from propeller arcs
- Route LoRa antenna coax through side port, away from power wires
- Verify all connectors are fully seated

**Step 11: Hub Stack Assembly**
- Stack: bottom plate (with arms) → middle plate (with MCU) → top plate (with GPS)
- Install 4× M3×25 mm standoffs through all three plates
- Torque all standoff bolts to 1.0 N·m

**Step 12: MXene Shielding Application**
- Apply MXene Ti₃C₂Tₓ spray coating to interior of hub plates (if not pre-coated)
- Verify coating integrity per CSMFAB-214 §5

**Step 13: Phone Clamp Installation**
- Mount phone clamp assembly to top plate via 4× M3×12 mm
- Verify clamp jaw travel: full open to full close, no binding
- Affix ArUco calibration marker to clamp base plate

**Step 14: Final QC**
- Perform pre-flight calibration and test protocol (CSMFAB-226)
- Verify all mechanical connections secure (no loose bolts)
- Verify electrical continuity (battery → PDB → ESCs → motors)
- Verify MCU boots and establishes USB/BT link with phone
- Perform motor direction test (props OFF): verify M1/M3 CW, M2/M4 CCW
- Install propellers (CW threads on M1/M3, CCW on M2/M4), torque nyloc nuts to 0.5 N·m

## 3. Assembly Time

| Phase | Time |
|-------|------|
| Frame Assembly | 1h 30m |
| Electronics | 2h 00m |
| Final Assembly | 1h 00m |
| **Total (experienced builder)** | **4h 30m** |
| **Total (first-time builder)** | **6h 00m** |

---

*"Assembly is the moment when design meets reality. If it doesn't fit, it's not the builder's fault — it's the designer's."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Assembly Partners, End Users
- Next Scheduled Review: July 2027
- Status: APPROVED — Production Baseline
