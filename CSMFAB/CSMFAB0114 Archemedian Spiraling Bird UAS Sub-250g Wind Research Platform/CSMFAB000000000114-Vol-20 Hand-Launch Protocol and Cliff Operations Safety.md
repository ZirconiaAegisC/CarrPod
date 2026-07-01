# CSMFAB000000000114 — Vol-20
# Hand-Launch Protocol and Cliff Operations Safety
## Step-by-Step Launch, Wind Reading, Observer Positions, Preflight Checklist
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: Launch Is the Most Critical Moment

The period between "hand holding the device" and "device in stable autorotation" — approximately 3-5 seconds — is the highest-risk phase of any ASB-1 operation. The device is at low spin rate (low gyroscopic stability), close to personnel, close to the cliff edge, and responsive to handling errors. A poor launch results in:
- Device tumbling (low spin at release → gyroscope not yet effective)
- Device flying back toward the thrower (released too early or into bad wind angle)
- Device diving below cliff level (released into a downdraft)

This volume specifies the exact launch technique, pre-launch checks, site assessment, and observer positions.

---

## Part 1: Pre-Launch Site Assessment

Before deploying any equipment, the RPIC must assess the launch site:

### Wind Assessment (5 minutes)

1. **Face into the wind** — feel the wind direction on your face
2. **Observe upward motion cues:** Do leaves, dust, or spray go upward? Is there visible updraft? Updraft is ideal for ASB-1 launch.
3. **Measure wind speed:** Use a handheld anemometer (Kestrel 1000 or smartphone with windmeter sensor). Target: 5-15 m/s for initial flights. If >20 m/s: use extended tether protocol only.
4. **Look for gusts:** Watch the vegetation or water surface for 10 seconds. Consistent smooth wind is ideal. High variability (gust factor > 1.5) = proceed with caution.
5. **Record wind direction on log sheet** — this is required data for research.

### Airspace Check (5 minutes)

1. Open FAA B4UFLY or ForeFlight
2. Confirm location is Class G or authorized Class E/D airspace
3. Check NOTAMs for any temporary flight restrictions (TFR) in the area
4. Visually scan the sky for any manned aircraft
5. If within 3 miles of an airport: file LAANC authorization via FAA DroneZone app before proceeding
6. Document airspace class in flight log

### Terrain Assessment (2 minutes)

1. Identify the cliff edge (or elevated launch point)
2. Mark a **5m safety zone** around the launch position — no spectators
3. Identify the **net recovery zone** — flat, clear area downwind of launch point, 10m from cliff edge minimum. Set up the net (Vol-14).
4. Identify tether reel anchor points — ground stakes driven at least 20cm into soil, or weighted with a filled water bottle (if no stake penetration possible on rock)

---

## Part 2: Pre-Flight Checklist

Complete before every flight (5-10 minutes):

### Device Checklist

- [ ] Battery fully charged (voltage check: > 7.0V on battery tester)
- [ ] GPS module: power on device, wait for GPS fix indicator (green LED or SwarmView GPS icon)
- [ ] IMU: ArduPilot preflight checks pass (no "PreArm: IMU not calibrated" warnings in Mission Planner or via LED pattern)
- [ ] FTS: In SwarmView, send test command → confirm servo blink response, confirm FTS ARMED indicator
- [ ] Parachute: packed and locked in nose cone (visual confirm: nose cone flush, Velcro latch tight)
- [ ] Tether: leader attached to swivel, swivel free-rotating (spin with hand — no binding), breakaway coupling intact
- [ ] Speed governor: arms flush (not pre-activated), spring return snappy on manual press
- [ ] Smart Rope: push-test each arm slot — all four actuator housings secure
- [ ] Wind sensor mast: straight, not bent, probe holes clear of debris

### Tether Reel Checklist

- [ ] Reel anchor staked or weighted securely
- [ ] 3m leader connected from device swivel to spool
- [ ] Brake mechanism: squeeze test → reel locks, release → reel spins freely
- [ ] All tether line on spool with no tangles (run 2m off spool and back to verify)

### Personnel Checklist

- [ ] RPIC at ground station, SwarmView open, all units showing on map
- [ ] Visual Observer 1: positioned on left flank of launch zone with binoculars
- [ ] Visual Observer 2: positioned on right flank
- [ ] Tether Operator: at tether reel, foot on brake pedal
- [ ] Spectators: at or behind the 10m spectator line

---

## Part 3: Launch Technique — Detailed

### Standard Wind Launch (5-15 m/s)

1. **Face directly into the wind** — your back should be toward the recovery zone, face toward the wind source
2. **Hold the launch cradle** (3D-14) in your dominant hand, device sitting in the cradle cup at waist height, spiral body nose pointing forward (slightly upward, 20° above horizontal)
3. **Confirm tether**: reach back with non-throw hand, verify tether leader is not tangled around your body or legs
4. **Slow spin-up**: using 3 fingers of the non-throw hand, gently flick the spiral body to initiate spin (clockwise when seen from above for a right-hand helix). Spin rate imparted: ~100-200 RPM
5. **Call out**: say loudly "LAUNCHING" — this alerts all observers and the tether operator
6. **Throw**: with a smooth overhand or sidearm release motion, accelerate the device forward-upward at a 30-45° angle into the wind, while simultaneously imparting additional wrist rotation. Release when the cradle leaves your hand naturally.
7. **Watch**: immediately step back from the cliff edge and observe the device
8. **Expected behavior**: the device continues spinning, the wind catches the spiral, spin rate increases, device climbs at 0.5-2 m/s initially, accelerating

### If the Device Does Not Climb

If the device descends after launch:
- Wind speed is insufficient for autorotation (< 5 m/s) → activate the brushless motor via ground station motor command
- Wind angle was unfavorable → reposition to face into wind, retry
- Launch angle was wrong (too horizontal) → aim 30° more upward next launch

### If the Device Flies Back Toward You

Step to the side immediately. The tether operator should apply full brake to stop line payout. Let the device settle. This typically indicates launch into a downdraft eddy near the cliff edge — reposition 2m back from the edge and retry.

---

## Part 4: During-Flight Monitoring

1. RPIC watches SwarmView: altitude should be increasing, GPS position stable (within tether range of anchor)
2. Visual Observers watch the device continuously — never take eyes off it
3. If you lose visual contact: immediately alert all observers, check SwarmView for GPS position, apply tether brake to stop altitude gain, consider FTS deployment if position unknown
4. Monitor for manned aircraft: VOs scan full horizon every 30 seconds
5. Tether operator: maintain gentle brake tension — allows controlled altitude rate; never fully release on first flight

---

## CHECKPOINT — Vol-20 Complete

Before proceeding, confirm:
- [ ] You can perform the 5-step site assessment (wind, airspace, terrain)
- [ ] You know all items in the pre-flight checklist
- [ ] You understand the 7-step launch technique in detail
- [ ] You know the response to unexpected behaviors (descent, flyback)
- [ ] You know during-flight monitoring duties for each role (RPIC, VOs, Tether Operator)

**Proceed to:** Vol-21 (Complete Assembly Manual)

---

*CSMFAB000000000114-Vol-20 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
