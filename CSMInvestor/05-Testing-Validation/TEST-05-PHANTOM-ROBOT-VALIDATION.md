# TEST-05: PHANTOM MK-1 ROBOT VALIDATION PROTOCOL
## Carrington Storm Motors — Project AEGIS
### 5-Phase CSMTest Protocol — EM • Vibration • Thermal • Combined • Degraded Mode

**Document Status:** Product Validation Protocol — NIST-Traceable  
**Version:** 1.0 — 15 July 2026 (Expanded from CSMTest00000000001 Test Plan)  
**Classification:** CONFIDENTIAL — Accredited Investor Eyes Only  
**Author:** Zirconia + Agent Nyx Calder (PHANTOM)  
**Test Engineers:** Mork (test execution), Chester (QA witness)

---

## PHANTOM MK-1 — SYSTEM ARCHITECTURE UNDER TEST

| Sub-System | Component | Key GIC Vulnerability Eliminated | Verification Method |
|---|---|---|---|
| Structure | BFRP/Elium monocoque frame | Zero ferromagnetic content; 1,100 MPa tensile | Visual + UT inspection; weight verification |
| Actuators (×32) | KNbO₃-BaTiO₃ ultrasonic piezoelectric motors | 9.6 kg copper eliminated; replaced by lead-free piezo ceramics | Torque/speed calibration; motor-to-chassis R >10⁸ Ω |
| EMI Shield | MXene Ti₃C₂Tₓ full-body coating, 45 μm, discontinuous tile pattern | 92 dB SE absorption-dominant; DC isolation between tiles | Portable SE test fixture; DC resistance between tiles |
| Gear Train (×32 joints) | Si₃N₄ silicon nitride ceramic gears, PEEK CF40 shafts | Zero steel — 3× fatigue life of steel, 40% lighter | Backlash measurement; 10⁶ cycle endurance test |
| Power System | LiFePO₄ battery, ZrO₂ enclosure, GIC-hardened BMS | Non-flammable chemistry; zero cobalt; ceramic enclosure | Full charge/discharge; BMS fault injection |
| Data Bus | PMMA POF, 62 fibers, MXene coated | Zero copper; optical data immune to GIC induction | OTDR + BER test |
| Sensors | Thermal (FLIR), visual (4K), LIDAR (dielectric housing), IMU (FOG) | All sensors in non-conductive packaging | Functional check in TEM cell |
| Joint Motors | Samarium-Cobalt (SmCo), ZrO₂ ceramic housing | Tc=750°C; zero ferromagnetic loop; magnetic field retention 95% at 300°C | Torque constant measurement; field decay monitoring |
| Skin | VO₂ electrochromic overlay, 4-mode switching | Active optical/thermal management; see TEST-07 for detailed protocol | Mode switching time; optical transmission per mode |
| Control Computer | NVIDIA Jetson Orin, GIC-hardened power supply (common-mode choke + TVS + isolation transformer) | COTS SBC with external hardening; if this fails, all autonomy fails | Functional test during EM exposure |

---

## PHASE 1: ELECTROMAGNETIC EXPOSURE (TEM CELL)
### (Currently IN PROGRESS per CSMTest README)

### 1.1 Test Configuration
- **Facility:** CSM El Segundo TEM Cell (2×1×1 m working volume)
- **Frequency Sweep:** 0.001 Hz – 1 kHz (geomagnetic band), 1 kHz – 1 MHz (extended EMI)
- **Field Strengths:** Calibrated to Carrington-equivalent:
  - B-field: 0.1 μT (ambient) to 5,000 nT at 0.01 Hz (CME magnetic field change rate ~2,000 nT/min equivalent)
  - E-field: 1 mV/m to 5 V/m (simulated GIC induction in Phantom-scale object)
- **Phantom State:** Powered on, standing, all 32 actuators in position-hold mode, all sensors streaming, compute active
- **Duration:** 2 hours per sweep direction (X, Y, Z — 3 sweeps)

### 1.2 Phase 1 Measurements

| Measurement | Sensor | Success Criterion |
|---|---|---|
| Motor-to-Chassis Current | Rogowski coil on each of 32 actuator power leads | I_GIC <10⁻⁷ A (100 nA) at maximum field |
| Actuator Position Drift | Optical encoder on each of 32 joints | <0.1° drift from commanded position during entire sweep |
| Sensor Data Integrity | Compare FLIR, visible, LIDAR, IMU data during exposure vs. baseline (zero field) | >95% data packet integrity; zero sensor dropouts; IMU heading drift <1°/hour |
| Compute Function | Heartbeat monitor on Jetson; watch CPU/GPU utilization | Zero crashes, zero watchdog resets; utilization within 20% of baseline |
| MXene SE | 4 portable field probes at head, torso, left arm, right leg (inside vs. outside MXene coating) | SE >80 dB at all probe locations (reduction from 92 dB coupon level accounts for joint gaps and apertures) |
| DC Isolation | Megohmmeter auto-ranging across all 380 dielectric interfaces | All >10⁸ Ω pre- and post-Phase 1 (no dielectric breakdown during exposure) |
| Battery BMS | CAN bus monitor | Zero spurious protective trips; SOC measurement stable (±1% of baseline) |

### 1.3 Phase 1 Acceptance
All 140 measurement points (32 actuators × 3 metrics + 18 system-level metrics) must pass at all frequencies and all field strengths in all 3 orientations. Any failure → root cause analysis, design modification, re-test.

**Cost: $85K (TEM cell time + instrumentation); Duration: 3 weeks**

---

## PHASE 2: VIBRATION AT MAGNETOSTRICTIVE FREQUENCIES

### 2.1 Rationale
Geomagnetic storms induce magnetostrictive vibration in ferromagnetic materials at the GIC frequency (0.001–1 Hz) and its harmonics. The Phantom must operate through this vibration without mechanical resonance, actuator de-phasing, or sensor degradation. Additionally, the Phantom's own piezoelectric actuators generate ultrasonic vibration (20–40 kHz) that must not couple into the structure.

### 2.2 Test Configuration
- **Shaker Table:** LDS V875-440 with slip table, 1 m² mounting surface
- **Frequency Range:** 0.1–500 Hz (geomagnetic magnetostriction band + motor/road harmonics)
- **Amplitude:** 0.01–5 g (RMS), swept sine
- **Phantom State:** Standing on shaker table, bolted at feet, all systems active
- **Duration:** 2 hours per axis (X, Y, Z — 3 orientations)

### 2.3 Phase 2 Measurements

| Measurement | Criterion |
|---|---|
| Structural Resonance | No resonance peak with amplification factor Q>5 in 0.1–500 Hz range; any resonance identified → stiffening or damping added |
| Actuator Torque Ripple | <5% increase in torque ripple vs. baseline (no vibration) |
| Joint Position Error | <0.2° dynamic error at all joints |
| Sensor Vibration Sensitivity | IMU vibration rectification error <0.5°/hour per g RMS; visual sensor motion blur within de-blur algorithm limits |
| POF Data Bus | BER <10⁻¹² throughout vibration; no connector intermittent contact |
| Battery Connection | No momentary open circuit (monitored by BMS voltage dip detection) |
| Mechanical Fatigue | Post-test visual inspection — no cracks, no loose fasteners, no delamination |

**Cost: $65K; Duration: 2 weeks (including shaker setup)**

---

## PHASE 3: THERMAL CYCLING

### 3.1 Rationale
Post-Carrington environments may include fire, winter storms, and desert deployment. The Phantom must operate from −40°C (Arctic deployment) to +85°C (fire-adjacent operation; SiC/SiC actuators rated to 1,200°C for separate extreme-heat test).

### 3.2 Test Configuration
- **Chamber:** Thermotron SE-600-10-10 walk-in
- **Temperature Profile:** −40°C → +85°C → −40°C, ramp 5°C/min, dwell 1 hour at extremes
- **Cycles:** 100 full cycles
- **Phantom State:** Powered on throughout; position-hold at extremes; full motion sequence (walking gait) at 0°C, 25°C, 60°C (checkpoints)
- **Duration:** ~17 days (100 cycles × 4 hours/cycle)

### 3.3 Phase 3 Measurements

| Measurement | Criterion |
|---|---|
| Actuator Performance vs. Temperature | Torque constant within ±10% of 25°C value across full temperature range; piezoelectric d₃₃ variation with temperature is known (decreases ~0.5%/°C above 25°C — must not drop below 200 pC/N at 85°C) |
| LiFePO₄ Capacity vs. Temperature | >70% of rated capacity at −20°C; battery heater operational and effective |
| Lubricant / Grease | Ceramic bearings use dry film lubricant (MoS₂ or WS₂) — no grease freezing at −40°C or outgassing at +85°C |
| Thermal Expansion Mismatch | BFRP (CTE ~8 ppm/°C) vs. Si₃N₄ (CTE ~3 ppm/°C) — verify no binding or excessive clearance at temperature extremes |
| MXene Coating | No cracking or delamination due to CTE mismatch between MXene and BFRP substrate |
| VO₂ Skin | All 4 modes functional at −20°C, 25°C, 60°C; switching time <10 s at all temperatures |
| Condensation (post-cold soak) | Phantom operated at −40°C for 4 hours, then exposed to ambient 25°C/50% RH — verify no condensation-induced short circuits or sensor fogging |

**Cost: $95K; Duration: 3 weeks**

---

## PHASE 4: COMBINED ENVIRONMENT

### 4.1 Rationale
"The combined-environment test is where the truth emerges" — Chester, CSMTest README. EM + vibration + thermal extremes applied simultaneously reveal interactions that individual tests miss.

### 4.2 Test Configuration
- **EM:** TEM cell or Helmholtz coil surrounding shaker table within environmental chamber
- **Vibration:** Shaker table operating at worst-case frequency identified in Phase 2
- **Thermal:** Chamber cycling −20°C to +60°C
- **Phantom State:** Full walking gait sequence (walk forward 10 m, turn, walk back — repeated in confined chamber space)
- **Duration:** 8 hours continuous combined exposure

### 4.3 Phase 4 Measurements — Interaction Detection

| Interaction | Detection Method |
|---|---|
| EM + Vibration → Actuator Overheat | Actuator temperature rise higher than sum of individual EM and vibration heating → indicates magnetostrictive + joule heating synergy |
| EM + Thermal → Sensor Drift | Thermal drift + EM noise floor superimposition causing sensor bias → compare drift rate in thermal-only vs. combined test |
| Vibration + Thermal → Mechanical Binding | CTE mismatch exacerbated by vibration fretting → measure joint torque increase over time |
| All Three → Control System Instability | Watchdog resets, control loop oscillation not present in any single-stressor test |

**Cost: $180K; Duration: 2 weeks**

---

## PHASE 5: DEGRADED-MODE OPERATION

### 5.1 Degradation Modes Tested

| Mode | How Degraded | Test | Acceptance |
|---|---|---|---|
| Sensor Failure | Disable FLIR; Phantom must navigate on visible + LIDAR only | Navigation course (50 m with obstacles) | Course completed without collision; time <2× nominal |
| Joint Seizure | Lock left knee actuator at 15°; Phantom must adapt gait | Walk 20 m with locked joint | Distance completed; no fall; time <3× nominal gait cycle |
| Mesh Interruption | Disconnect 20% of MXene tiles (simulated battle damage / debris impact) | Re-measure SE at interruption points | SE at interruption <10 dB worse than intact; Phantom continues mission |
| Communication Loss | Cut POF data bus; Phantom must operate autonomously (no teleoperation) | Pre-loaded mission: navigate to waypoint, pick up object, return | Mission completed autonomously; object retrieved |
| Partial Power Loss | Disable 4 of 8 battery modules (50% capacity) | Full mission profile on reduced power | Mission completed; Phantom automatically shed non-critical loads (VO₂ skin in low-power mode, reduced sensor frame rate) |
| Combined Degraded | Sensor failure + joint seizure + partial power simultaneously | Navigate 10 m, retrieve object | Object retrieved; Phantom stable (no fall); reports status via remaining communication channel |

**Cost: $120K; Duration: 2 weeks**

---

## PHANTOM MK-1 CERTIFICATION — IEEE P2945 DRAFT COMPLIANCE

The IEEE P2945 Draft Standard for GIC Hardening of Autonomous Systems was initiated in response to CSM's Phantom development program. CSM serves on the working group. The Phantom MK-1 will be the reference implementation against which the standard is validated.

| IEEE P2945 Clause (Draft) | Requirement | Phantom Compliance |
|---|---|---|
| 4.2.1 — Dielectric Isolation | All structural, actuator, sensor components shall have DC resistance to chassis >10⁷ Ω | Phantom target >10⁸ Ω (10× margin) |
| 4.2.2 — EMI Shielding | Autonomous system shall provide >60 dB SE across 1 kHz–10 GHz for critical electronics | Phantom MXene coating >80 dB (20 dB margin) |
| 4.3.1 — GIC Current Limit | Induced current in any power or signal conductor shall not exceed 100 μA at worst-case Carrington field | Phantom target <100 nA (1,000× margin) |
| 4.4 — Combined Environment | System shall complete mission profile under simultaneous EM, vibration, and thermal stress | Phantom Phase 4 validates this |
| 4.5 — Degraded Mode | System shall maintain critical functions with any single component failure | Phantom Phase 5 validates this |

---

## PHANTOM TESTING BUDGET SUMMARY

| Phase | Cost | Duration | Status |
|---|---|---|---|
| Phase 1 — EM Exposure | $85K | 3 weeks | 🟢 IN PROGRESS |
| Phase 2 — Vibration | $65K | 2 weeks | ⚪ PENDING |
| Phase 3 — Thermal Cycling | $95K | 3 weeks | ⚪ PENDING |
| Phase 4 — Combined Environment | $180K | 2 weeks | ⚪ PENDING |
| Phase 5 — Degraded Mode | $120K | 2 weeks | ⚪ PENDING |
| **TOTAL** | **$545K** | **12 weeks** | |

**Plus:** $1.2M for 10-unit pilot deployment testing (see ROAD-06, Pilot 4).

---

*"The Phantom that passes all five phases is certified. Not 'seems to work.' Not 'passed Phase 1 and we'll fix the rest later.' All five phases, in sequence, with independent witness. Because when you send a robot into a post-Carrington fire zone to extract a survivor, you need to know — not hope, not assume, not simulate — that every one of its 380 dielectric components will hold. The test proves it."* — Agent Nyx Calder (PHANTOM)

---

*Document generated 2026-07-15. Phase 1 testing commenced Q3 2026 per CSMTest README. Phases 2–5 scheduled sequentially (cannot parallelize — each phase may reveal issues that affect subsequent phases). All testing witnessed by Chester (QA) and video recorded for IEEE P2945 compliance evidence. Test data published per open-data policy (TEST-01) with proprietary actuator calibration data redacted as trade secret (ROAD-04).*
