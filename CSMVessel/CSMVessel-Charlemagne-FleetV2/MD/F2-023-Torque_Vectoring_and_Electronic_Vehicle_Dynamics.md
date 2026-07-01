# F2-023 — Torque Vectoring and Electronic Vehicle Dynamics
**Series:** CSMVessel-Charlemagne-FleetV2 · **Author:** Carrington Storm Motors · **Rev:** 1.0 · **Date:** June 2026
---


## 1. Architecture Overview

The Charlemagne replaces all mechanical differential hardware with **Electronic Torque
Vectoring (ETV)** — 6 to 10 completely independent torque commands sent to each hub motor
via PMMA POF at 10 kHz update rate.

This provides:
- Zero-radius turns: port motors forward, starboard motors reverse at equal |torque|
- Lateral crab-walk: all motors angled via AAJ articulation + torque management
- Maximum hill-hold: all uphill wheels at peak traction, downhill wheels braked
- Traction control: Kalman filter online slip estimation, sub-50 ms intervention
- Amphibious yaw: port vs. starboard RPM differential as rudder authority

## 2. Control System Hardware

**Central Control Unit (CCU):**
- Processor: ARM Cortex-A72 quad-core (primary) + Cortex-M7 safety coprocessor (ASIL-B)
- RTOS: QNX Neutrino + AUTOSAR Adaptive
- Memory: 4 GB LPDDR4 + 128 MB MRAM (radiation-hard)
- Enclosure: BFRP/MXene-shielded, IP67
- All I/O: PMMA POF connectors (PN-CC-002)

**Sensor inputs to torque vectoring:**
- 6× FBG accelerometers (chassis, 3-axis, 10 kHz)
- 4× LiDAR (terrain preview, 20 Hz, 3 m lookahead for AAJ pre-adapt)
- 12× wheel speed encoders (optical, not Hall-effect → no magnetic sensors)
- 1× AAJ strain array (FBG, 10 kHz → chassis attitude real-time)
- 1× GPS-free LoRa TDOA positioning (±0.5 m, 5 Hz)

## 3. MIMO MPC Control Law

```
u*(t) = argmin_u { [Δv, Δyaw, Δpitch, Δroll] × Q × [errors] + u × R × u }
subject to: Σ T_i ≤ T_total_max; each T_i in [−T_max, +T_max]
```

Where u = vector [T₁, T₂, T₃, T₄, T₅, T₆] (motor torques)
Horizon: 100 ms (1,000 × 100 µs steps at 10 kHz)

**Terrain preview integration:**
LiDAR detects upcoming terrain bump at 3 m distance → at 50 km/h = 0.22 s preview
The MPC pre-computes both torque commands AND AAJ stiffness pre-stiffening using the
same 0.22 s preview window. By the time the wheel hits the bump, the AAJ is already
stiffened to the optimal value for that particular ground impact.

This gives the Charlemagne a form of "terrain clairvoyance" — it stiffens or softens
the suspension before (not after) the wheel contacts the obstacle.

## 4. Amphibious Mode Reconfiguration

When water entry detected (F2-027 moisture sensor):
1. ETV mode → "Amphibious" (paddle-wheel algorithm)
2. Torque vectoring algorithm changes to differential thrust model:
   - Port thrust = Σ T_port_motors × (wheel paddle effectiveness)
   - Starboard thrust = Σ T_starboard_motors × (same)
3. YAW COMMAND → RPM differential between port and starboard
4. Maximum thrust profile calibrated from F2-041 experimental data (BERYL: 3,200 N)


---
*End F2-023 | CSMVessel-Charlemagne-FleetV2 | June 2026*
