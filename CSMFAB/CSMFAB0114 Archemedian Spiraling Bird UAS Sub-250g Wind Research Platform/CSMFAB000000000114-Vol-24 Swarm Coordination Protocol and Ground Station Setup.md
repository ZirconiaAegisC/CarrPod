# CSMFAB000000000114 — Vol-24
# Swarm Coordination Protocol and Ground Station Setup
## Multi-Unit LoRa Mesh, Ground Control Software, Field Setup
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction

Vol-13 covered swarm operations strategy. This volume covers the operational ground station setup and field coordination protocol in step-by-step detail.

---

## Part 1: Ground Station Field Setup Sequence

**Time required: 15 minutes before first launch**

1. Remove Raspberry Pi 4B and display from Pelican case
2. Prop display at comfortable viewing angle (kickstand built into case lid)
3. Connect 7" display via HDMI + USB
4. Connect LoRa gateway HAT (already mounted to Pi in case)
5. Connect 915 MHz yagi antenna to HAT SMA port (point antenna toward expected flight zone)
6. Connect USB power bank (Pi + display draw ~8W; 10,000 mAh bank provides ~5 hours)
7. Power on Pi — SwarmView loads automatically on boot (configured as startup service)
8. Wait 60 seconds for Pi GPS fix (if external GPS dongle attached) or enter site GPS manually
9. Verify SwarmView map view centered on launch site

**On SwarmView startup, verify:**
- Map displays at correct zoom level (should show launch site)
- Unit monitoring table (right side panel) shows all expected units as "offline" (red icons)
- FTS panel (bottom) shows individual FTS trigger buttons for all 20 possible nodes
- Data log indicator shows current log file name (YYYYMMDD-HHMM.csv)

---

## Part 2: Per-Unit Pre-Launch Check (SwarmView)

For each unit:
1. Power on unit (JST battery connect)
2. Within 60 seconds: unit icon on SwarmView map goes from red to yellow (no GPS fix) to green (GPS fix)
3. Verify: unit's telemetry row shows reasonable altitude (~0m AGL at launch point), battery voltage > 7.0V, status = "ARMED_FTS"
4. If unit does not appear after 90 seconds: check LoRa antenna connection on that unit, power cycle

---

## Part 3: Launch Call Protocol

For 10-unit coordinated launch:
- RPIC calls: "RPIC CHECK" — confirms SwarmView shows all 10 units green
- VO1 calls: "VO1 CLEAR" — sky clear, no aircraft
- VO2 calls: "VO2 CLEAR"
- Tether Operator: "TETHERS READY"
- RPIC: "LAUNCH COUNTDOWN: 5... 4... 3... 2... 1... LAUNCH"
- Launch team releases all units within 5 seconds

---

## Part 4: In-Flight LoRa Mesh Monitoring

SwarmView displays in real-time:
- Unit positions on map (updating at 1 Hz)
- Altitude bar graph (all units side-by-side)
- Wind vector arrows at each position
- FTS status (armed = green; triggered = red)
- Battery alert: any unit below 6.8V turns yellow voltage indicator

**If unit disappears from map (telemetry loss >10 seconds):**
1. RPIC announces "Unit X signal lost"
2. VO scans visually for the unit
3. If located visually and in safe area: wait for signal recovery (often temporary LoRa shadow)
4. If not located visually within 30 seconds: RPIC triggers FTS for that unit from SwarmView
5. Tether operator applies brake on that unit's reel

---

## CHECKPOINT — Vol-24 Complete

- [ ] You know the 9-step ground station field setup sequence
- [ ] You know the SwarmView pre-launch unit verification per-unit checklist
- [ ] You know the 5-call launch safety protocol
- [ ] You understand the response to lost telemetry (30-second visual search, then FTS trigger)

**Proceed to:** Vol-25 (Test Protocol)

---

*CSMFAB000000000114-Vol-24 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
