# CSMFAB000000000114 — Vol-08
# Speed Governor — Mechanical and Electronic Design
## Keeping the ASB-1 at or Below 100 mph Per FAA §107.51
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: Why a Speed Governor Is Not Optional

14 CFR §107.51(a) states that small UAS must not exceed **100 mph (161 km/h) groundspeed** at any time. The ASB-1, in a 25 m/s (56 mph) updraft with a 3-turn spiral geometry and no speed limit, could theoretically spin to a tip speed exceeding 100 mph. At the cliff-top launch conditions the device targets, this is not hypothetical — in a strong coastal updraft at Malibu or a canyon thermal in Sedona, the ASB-1 WILL exceed 100 mph without a governor.

This is not a regulatory inconvenience. An uncontrolled spiral at 100+ mph that breaks its tether or drops from altitude is a projectile. The speed governor is a **safety device first** and a regulatory compliance mechanism second.

The ASB-1 uses a **dual governor approach**: a primary passive mechanical centrifugal flyweight governor that requires no electronics, and a secondary electronic governor via the flight controller that provides software-defined backup.

---

## Part 1: Primary Governor — Centrifugal Flyweight Mechanism

### 1.1 How a Centrifugal Governor Works

The centrifugal flyweight governor is one of the oldest control mechanisms in engineering — James Watt used it to control steam engines in 1788. The principle is elegant:

1. Two or more weighted arms are hinged to a rotating shaft
2. As rotation speed increases, centrifugal force pushes the arms outward and upward
3. The arms are mechanically linked to a control surface (traditionally a valve; in our case, a pitch-increasing mechanism)
4. As the arms rise, the control surface changes the blade pitch angle, increasing aerodynamic drag
5. Increased drag slows the rotation — the arms drop back
6. This creates a **self-regulating feedback loop** that maintains rotation near the governor's set point

### 1.2 ASB-1 Governor Design

**Mechanism:**
The ASB-1 centrifugal governor (3D-10) sits at the base of the spiral body, on the rotation axis. It consists of:

- **Hub assembly:** 3D-printed PLA axle sleeve, press-fit to the spiral body center shaft
- **Flyweight arms:** 3 arms × (1g steel fishing sinker + 30mm PETG arm) = 3 × 1.5g = 4.5g
- **Pivot springs:** 3 × 0.3g compression springs (hobby supplier, RC car suspension springs)
- **Pitch linkage:** 3 × 40mm BFRP push rods connecting arm tips to spiral blade root twist adjusters
- **Total governor mass:** Approximately 8g

**Operating principle for the ASB-1:**

As spin rate increases:
1. The three flyweight arms move outward (centrifugal effect)
2. Each arm is connected by the push rod to a twist adjuster on the inner spiral blade root
3. The twist adjuster rotates the blade root slightly toward a **higher pitch angle** (propeller terminology: coarser pitch)
4. Higher pitch = more angle of attack = more aerodynamic drag on the spiral = spin rate decreases
5. Arms fall back = pitch reduces = drag reduces = spin rate increases until equilibrium

This is a **passive, purely mechanical, self-regulating system**. No battery, no electronics, no software. It cannot fail due to electronics failure. It requires only that the flyweight arms can move freely and the push rods are correctly adjusted.

### 1.3 Governor Set Point Calculation

We want the governor to activate (arms begin to rise) at 4,000 RPM (the safe limit before approaching 100 mph tip speed) and reach full authority (maximum pitch increase) at 5,000 RPM.

Tip speed at 4,000 RPM with R = 0.075m:
```
V_tip = ω × R = (4000/60 × 2π) × 0.075 = (418.9) × 0.075 = 31.4 m/s = 113 km/h = 70 mph
```

Tip speed at 5,000 RPM governor limit:
```
V_tip = (5000/60 × 2π) × 0.075 = (523.6) × 0.075 = 39.3 m/s = 141 km/h = 87 mph
```

Full authority limit is 87 mph — below the FAA 100 mph limit with 13 mph margin. Good.

**Centrifugal force at governor activation (4,000 RPM):**
```
F_centrifugal = m_arm × ω² × r_arm
F_centrifugal = 0.001 × (418.9)² × 0.015 (arm pivot radius 15mm)
F_centrifugal = 0.001 × 175,518 × 0.015 = 2.63 N per arm
```

The spring return force must be calibrated to balance this at 4,000 RPM. Spring constant required:
```
k_spring = F_centrifugal / x_deflection = 2.63 / 0.010 (10mm arm lift at set point) = 263 N/m
```

A 0.3mm wire diameter, 8mm diameter, 10-coil spring gives k ≈ 250-280 N/m — available from RC car suspension spring sets. Adjust the pre-tension (screw and locknut on the arm pivot) to fine-tune the activation set point during calibration.

### 1.4 Governor Calibration Procedure

1. Assemble governor fully on a bench test shaft connected to a variable-speed DC motor
2. Spin up slowly while observing arm position with stroboscope or tachometer
3. Arms should begin rising at 4,000 RPM (+/- 200 RPM)
4. Full authority reached before 5,000 RPM
5. If activation too early (arms rise at <3,500 RPM): increase spring pre-tension by turning the pre-tension nut clockwise 1/4 turn, retest
6. If activation too late (arms still down at >4,500 RPM): reduce spring pre-tension 1/4 turn counterclockwise, retest
7. Confirm pitch linkage: as arms raise to full height, blade root pitch increases by 10-15° (measure with a digital protractor)
8. Record final spring pre-tension setting in the build log

---

## Part 2: Secondary Governor — Electronic Speed Limit

### 2.1 GPS Groundspeed Monitoring

The flight controller (SpeedyBee F405 Wing Mini running ArduPilot or custom firmware) monitors GPS groundspeed continuously. When groundspeed exceeds **85 mph (37.6 m/s)**, the FC takes the following automated actions:

1. **Step 1 — Motor active:** Activates the optional brushless motor in a **reverse/braking mode** (motor spins opposite to spiral direction to oppose rotation)
2. **Step 2 — Smart rope pitch:** Commands maximum pitch via Smart Rope actuators (Vol-09) — full coarse pitch position (maximum drag)
3. **Step 3 — FTS pre-arm:** Arms the FTS (parachute) system automatically, ready for immediate ground-command deployment
4. **Step 4 — Ground station alert:** Transmits priority alert packet to ground station (beep + red flash on SwarmView display)

At **95 mph (42.5 m/s):**
- **Automatic FTS trigger:** Deploys parachute without waiting for ground command
- This is the electronic hard-stop — the device will always deploy its parachute before reaching 100 mph

### 2.2 Spin Rate Monitoring

The IMU gyroscope Z-axis measures spiral body spin rate. At 5,500 RPM gyro reading:
1. FC immediately commands Smart Rope to maximum coarse pitch
2. Motor braking activated (if equipped)
3. Ground station alert transmitted

This provides spin-rate-based speed limiting as a backup to GPS groundspeed monitoring (useful if GPS signal briefly drops).

---

## Part 3: Combined Governor Operation

The two governors work together and are independent — either one can prevent over-speed without the other functioning:

```
WIND SPEED INCREASES
       ↓
ASB-1 SPIN RATE INCREASES
       ↓
   (Primary)                    (Secondary)
MECHANICAL GOVERNOR             ELECTRONIC GOVERNOR
Arms rise outward               GPS groundspeed monitored
Pitch linkage activates         Spin rate monitored
Pitch angle increases           At 85 mph: motor brake + Smart Rope coarse pitch
Drag increases                  At 95 mph: automatic FTS deployment
Spin rate stabilized at ~4,500 RPM
GOVERNED SPEED ~85 mph
FAA LIMIT = 100 mph ← 15 mph SAFETY MARGIN
```

---

## Part 4: Governor Maintenance and Inspection

Before every flight:
1. Visually inspect governor arm pivot pins — no bends, no corrosion
2. Verify spring return force by manually lifting each arm and releasing — it should snap back smartly
3. Confirm push rod connections are secure and not bent
4. With device spinning on test stand at 3,000 RPM (drill chuck test) — confirm arms are flush, no premature activation
5. Lubricate pivot pins lightly with dry PTFE spray (not oil — oil attracts debris)

> ⚠️ **SAFETY:** Never fly with a damaged or non-functional governor. If the mechanical governor fails in the field, fall back to the electronic governor only — but this is an elevated risk condition. Replace any damaged governor parts before the next flight.

---

## CHECKPOINT — Vol-08 Complete

Before proceeding, confirm:
- [ ] You understand how a centrifugal flyweight governor works (arms rise → pitch increases → drag increases → speed limited)
- [ ] You know the governor activation set point: 4,000 RPM (70 mph tip speed)
- [ ] You know the full-authority limit: 5,000 RPM (87 mph tip speed — below FAA 100 mph limit)
- [ ] You understand the spring constant required: 250-280 N/m (available from RC car spring sets)
- [ ] You understand the electronic secondary governor: 85 mph = motor brake + Smart Rope; 95 mph = auto FTS
- [ ] You know the pre-flight governor inspection procedure

**Proceed to:** Vol-09 (Smart Rope Actuators) or Vol-10 (Tether Safety System)

---

*CSMFAB000000000114-Vol-08 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
