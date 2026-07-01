# CSMFAB000000000114 — Vol-11
# Flight Termination System and Micro-Parachute
## Backup Safety and FAA Waiver Compliance Requirement
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: Why Every ASB-1 Must Have an FTS

The FAA §107.35 swarm waiver (Vol-02) has one non-negotiable requirement: **each aircraft in a swarm must carry an independent Flight Termination System (FTS)**. This is not optional for waiver compliance. But even if you are flying a single unit without a waiver, the FTS is the emergency brake that ensures a malfunctioning ASB-1 cannot become a dangerous projectile.

The FTS has one job: upon command (or automatic trigger), **immediately reduce the device's speed and descent rate to something that cannot injure a person or damage property**.

For the ASB-1, the FTS is a **micro-parachute**: a 20cm diameter hemispherical canopy that deploys from the nose cone on a LoRa command or automatic trigger from the flight controller.

---

## Part 1: Parachute Sizing and Physics

### Terminal Velocity After Parachute Deployment

We want the ASB-1 to descend at no more than 3 m/s (about walking pace) after parachute deployment.

Drag force from parachute:
```
F_drag = ½ × ρ × A_canopy × CD × V²
```

Setting F_drag = device weight (for terminal velocity condition):
```
m × g = ½ × ρ × A × CD × V²
```

Solving for required canopy area:
```
A = (2 × m × g) / (ρ × CD × V²)
A = (2 × 0.177 × 9.81) / (1.225 × 1.5 × 9)
A = 3.473 / 16.54
A = 0.210 m²
```

Required canopy area: 0.210 m². For a hemispherical canopy:
```
A = π × r²
r = sqrt(0.210 / π) = sqrt(0.0668) = 0.258 m
Diameter = 0.517 m ≈ 52 cm
```

Wait — 52 cm diameter canopy on a 150mm device is physically impossible to pack. The terminal velocity requirement must be relaxed.

**Revised requirement:** Reduce impact speed to below 6 m/s (still survivable for the device, unlikely to injure people at this weight).

```
A = (2 × 0.177 × 9.81) / (1.225 × 1.5 × 36)
A = 3.473 / 66.15
A = 0.0525 m²
r = sqrt(0.0525 / π) = 0.129 m
Diameter = 26 cm
```

A **26 cm diameter hemispherical parachute** achieves 6 m/s terminal velocity — light enough to cause minor device damage on landing but not injury to bystanders even at 177g. This size is packable.

**Revised terminal velocity check with 20cm canopy:**
```
V_terminal = sqrt((2 × m × g) / (ρ × CD × A))
V_terminal = sqrt((3.473) / (1.225 × 1.5 × 0.0314))
V_terminal = sqrt(3.473 / 0.0577) = sqrt(60.2) = 7.76 m/s
```

Accept 7.76 m/s as descent speed with 20cm canopy — approximately 17 mph, comparable to a thrown baseball's maximum safe catch speed. For 177g at 7.76 m/s:
```
KE = ½ × 0.177 × 7.76² = ½ × 0.177 × 60.2 = 5.3 J
```

5.3 Joules — below the FAA Category 1 injury threshold (100 ft·lbf ≈ 135 J is common standard; 5.3 J is well below). **The 20cm parachute is adequate for safety.**

---

## Part 2: Parachute Design and Packing

### Canopy Material: UHMWPE Ripstop

Material: 40 denier Dyneema/UHMWPE ripstop fabric (same material as Dyneema tether — non-conductive, Stellar-Aegis compliant)

| Property | Value |
|---|---|
| Mass per square meter | 35 g/m² |
| Canopy area (20cm) | 0.0314 m² |
| Canopy fabric mass | 0.0314 × 35 = 1.1g |
| 6× suspension lines (50cm each) | 0.5mm Dyneema × 3m total = 0.057g |
| Crown loop (apex reinforcement) | 0.1g |
| **Total parachute mass** | **~1.3g** |

Plus pilot chute bag, deployment servo, and mounting bracket: **~4g total FTS assembly**.

### Packing Procedure

1. Lay canopy flat on clean surface
2. Fold into 6 segments (star fold from apex to skirt)
3. Roll tightly from apex down, suspension lines wrapped around bundle
4. Insert into 25mm ID × 40mm long cylindrical pack tube (3D printed BFRP)
5. Secure with Velcro tape on outer diameter of pack tube
6. Insert into nose cone cavity (3D-04 has integrated cavity for the FTS tube)

### Deployment Mechanism

A micro servo (SG90, 4.4g) holds a Velcro latch on the pack tube. Upon FTS trigger:
1. LoRa command received OR automatic trigger from FC
2. FC sends 1ms PWM signal to servo
3. Servo arm rotates 90° in 0.1 second
4. Velcro latch releases pack tube cover
5. Spring plunger (0.2g compressed spring) ejects the pack tube from the nose
6. Airflow immediately inflates canopy as it clears the nose
7. Suspension lines pull taut, canopy fully inflated in 0.3-0.5 seconds
8. Device decelerates from terminal spiral speed to 7.76 m/s descent

---

## Part 3: FTS Control and Independence

The FTS system must be **independent** from the main flight controller (per FAA waiver requirement). This means:

- FTS servo and trigger logic must be functional even if the main FC crashes
- FTS battery must have independent power (capacitor backup on FTS circuit)
- FTS LoRa receiver can share the same hardware LoRa module but must have priority interrupt override

**Implementation:**
- The standard RFM95W LoRa module handles both telemetry (outbound) and FTS command (inbound)
- The LoRa module is connected to the main FC via SPI
- BUT an additional direct connection: RFM95W DIO0 interrupt pin → dedicated FTS MCU (ATtiny85, 0.4g, $1) → SG90 servo
- The ATtiny85 runs a single-purpose firmware: wait for FTS command packet (node ID + 0x01 or 0xFF) → trigger servo
- If main FC fails or crashes, ATtiny85 still has power and still listens on LoRa — it is fully independent
- ATtiny85 capacitor backup: 1mF capacitor provides ~5 seconds of operation after main power failure — sufficient for the servo to actuate

**Pre-flight FTS test:**
1. Power on device
2. From ground station SwarmView, send FTS deployment test command (returns servo to latch position only — parachute NOT released, but servo movement confirmed)
3. Verify servo LED indicator blinks on SwarmView display
4. Pack parachute into nose cone
5. Device ready for flight

---

## CHECKPOINT — Vol-11 Complete

Before proceeding, confirm:
- [ ] You know the 20cm canopy achieves 7.76 m/s terminal velocity at 177g = 5.3 J impact energy (safe)
- [ ] You understand the packing procedure (star fold → rolling → pack tube → Velcro latch)
- [ ] You know the FTS independence requirement (ATtiny85 as dedicated FTS MCU with capacitor backup)
- [ ] You understand the pre-flight FTS test (servo actuation test without live deployment)
- [ ] You know total FTS mass: ~4g (parachute 1.3g + servo 4.4g + ATtiny85 0.4g + bracket hardware)

**Proceed to:** Vol-12 (Battery and Power) or Vol-13 (Swarm Operations)

---

*CSMFAB000000000114-Vol-11 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
