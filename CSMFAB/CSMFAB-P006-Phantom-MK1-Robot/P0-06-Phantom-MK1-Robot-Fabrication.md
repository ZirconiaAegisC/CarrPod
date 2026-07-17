# P0-06: Phantom MK-1 Aegis-Hardened Robot — Complete Fabrication
## CSMFAB-P006 | CSM-ROB-PH-001 | Priority P0 | Episodes E01, E02

**Function:** Humanoid inspection robot with full EM immunity. 32 DOF. Deployed to substations, bridges, pipelines, and Charlemagne fleet vessels for post-GMD inspection without human exposure to energized environments.

| Spec | Value |
|------|-------|
| Height | 1.82 m |
| Weight | 95 kg |
| DOF | 32 (2 × 7 arms, 2 × 6 legs, 4 torso, 2 neck) |
| Power | 2.4 kWh LiFePO₄ battery (MXene-shielded), 6hr runtime |
| Actuators | 32 × Harmonic Drive + BFRP gear housing |
| Computing | Triple-redundant voting processors (ARM Cortex-A78, GaN power ICs) |
| Sensors | 2× thermal camera, 1× LIDAR, 4× ultrasonic, 2× Rogowski coil (GIC detection), 1× radiation detector |
| Communication | Protonic-HFET transceiver (primary) + FEATHER LoRa (backup) |
| Shielding | ZrB₂-SiC ceramic armor on CPU/power modules; MXene EMI coating on all cable harnesses |
| Enclosure | BFRP-Elium body shell, 3mm wall |
| Unit cost @ 100/yr | $185,000 |
| Unit cost @ 1,000/yr | $142,000 |

## SUBSYSTEMS
1. **Power:** 2.4 kWh battery → GaN DC-DC converters (3.4 eV bandgap, EM-immune) → distributed servo drives
2. **Actuation:** Harmonic Drive CSD-20-160 (gear ratio 160:1) in BFRP housing with ceramic output bearing
3. **Sensing:** All sensor enclosures individually Faraday-caged. Data buses use CNT-001 wiring.
4. **Computing:** 3× ARM Cortex-A78 in lockstep voting. Any processor dissent → safe-state (freeze, notify via Protonic link)
5. **Communications:** Protonic-HFET primary (50km range elevated); FEATHER LoRa 915MHz backup (15km mesh)
6. **End effectors:** Quick-change tool interface — dielectric wrench set, thermal camera probe, GIC measurement clamp

## SELF-DESTRUCT (CSMMECH02)
Per Episode E02 reference: integrated key zeroization + firmware overwrite + micro-thermite physical destruction at 0.8% unit cost.
