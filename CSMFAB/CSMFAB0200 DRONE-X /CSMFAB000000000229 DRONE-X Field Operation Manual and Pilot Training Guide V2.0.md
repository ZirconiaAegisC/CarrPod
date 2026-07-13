# CSMFAB000000000229 — DRONE-X Field Operation Manual and Pilot Training Guide
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Operations & Training Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — Part 107 certification, standard procedures, emergency protocols, 10-hour training curriculum |

---

## 1. Pilot Requirements

| Requirement | Standard Operations (VLOS) | BVLOS Operations |
|-------------|---------------------------|-----------------|
| FAA Certification | Part 107 Remote Pilot Certificate | Part 107 + BVLOS waiver approval |
| DRONE-X Endorsement | Level 1 (4 hours training) | Level 2 (additional 6 hours) |
| Medical | Self-certified fit to operate | Class 3 Medical or DL |
| Currency | 3 takeoffs/landings in 90 days | 5 BVLOS flights in 90 days |
| Age | ≥ 16 years | ≥ 18 years |
| Recurrent Training | ALC-677 online every 24 months | Level 2 re-check every 12 months |

## 2. Standard Pre-Flight Procedure

1. **Site Assessment** (5 min)
   - Verify airspace authorization (LAANC if controlled airspace)
   - Check weather: wind < 10 m/s, visibility > 3 SM, no precipitation
   - Identify takeoff/landing zone (clear 5 m radius, level surface)
   - Identify emergency landing sites (3 minimum within 500 m)
   - Check NOTAMs/TFRs for area

2. **Equipment Setup** (5 min)
   - Deploy landing pad (1 m × 1 m high-visibility mat)
   - Position ground station (phone/tablet) on glare-free surface
   - Install battery, verify XT60 fully seated
   - Verify kill switch in OFF position during handling

3. **Drone Power-Up** (2 min)
   - Kill switch to FLIGHT
   - Launch DRONE-X app on phone
   - Wait for GPS 3D fix (HDOP < 2.0)
   - Complete enforced pre-flight checklist (CSMFAB-226)

4. **Arming** (30 s)
   - Announce "ARMING" to any bystanders
   - Verify propellers clear, all persons > 3 m
   - Press and hold ARM button (3-second safety delay)
   - Verify DSHOT idle (motors spinning at 5% with props OFF for test, then props ON)
   - Announce "TAKEOFF"

## 3. Emergency Procedures

| Emergency | Immediate Action | Follow-up |
|-----------|-----------------|-----------|
| Loss of control | Release sticks (auto-level), if no recovery → KILL SWITCH | Investigate cause before next flight |
| Motor failure (in flight) | Drone enters autorotation descent — maintain altitude control if possible, steer to clear area | Full motor/ESC inspection |
| Battery fire/smoke | KILL SWITCH, move away, use Class D extinguisher or sand | Dispose of battery per CSMFAB-230 |
| Flyaway | KILL SWITCH if within range, otherwise note last GPS position, notify ATC if near airport | Full telemetry investigation |
| Person/animal in flight path | Climb to maximum safe altitude, orbit until clear | File incident report |
| GPS loss | Switch to ATTI mode (manual attitude control without position hold), land immediately | Recalibrate GPS/IMU |
| App crash | Phone maintains last attitude command briefly; MCU watchdog triggers auto-RTL within 2 s | Re-arm required after app restart |
| Complete power loss | Drone falls — no recovery possible. KILL SWITCH if battery reconnects. | Full incident investigation |

## 4. Weather Limitations

| Parameter | Limit | Notes |
|-----------|-------|-------|
| Wind (sustained) | 10 m/s (22 mph) | Max recommended. T:W 4.26:1 allows 12 m/s margin, but turbulence degrades control. |
| Wind (gusts) | 15 m/s (33 mph) | Flight not recommended. |
| Temperature (operating) | -10°C to +45°C | Battery performance degrades below 0°C; pre-warm to 20°C. |
| Precipitation | None | BFRP and electronics are water-resistant, not waterproof. |
| Visibility | ≥ 3 statute miles | FAA Part 107 requirement. |
| Cloud ceiling | ≥ 500 ft AGL | Or 500 ft below clouds, whichever is higher. |
| Lightning | No flight within 10 NM | Electrostatic discharge risk to electronics. |
| Kp index | < 5 (no G1+ storm) | At Kp ≥ 6, GPS accuracy degrades, RTL should abort mission. |

## 5. Training Curriculum — Level 1 (VLOS Operations, 4 Hours)

| Module | Duration | Content |
|--------|----------|---------|
| 1. Theory | 1h | Part 107 regulations, airspace, weather, DRONE-X system architecture |
| 2. Simulator | 1h | App-based flight simulator (built into DRONE-X app), all flight modes |
| 3. Guided Flight | 1h | Instructor-supervised: takeoff, hover, basic maneuvers, landing |
| 4. Solo Flight & Checkride | 1h | Solo flight demonstrating all required maneuvers, emergency procedures |

## 6. Training Curriculum — Level 2 (BVLOS Operations, 6 Additional Hours)

| Module | Duration | Content |
|--------|----------|---------|
| 5. BVLOS Theory | 1h | Waiver requirements, cellular C2 link, risk assessment (SORA), airspace integration |
| 6. BVLOS Simulation | 1h | Simulated BVLOS missions with link degradation scenarios |
| 7. Guided BVLOS | 2h | Progressive BVLOS flights: 100 m → 300 m → 500 m range |
| 8. Emergency Drills | 1h | Link loss, lost comms, flyaway, airspace incursion scenarios |
| 9. Solo BVLOS & Checkride | 1h | Solo BVLOS mission with all required procedures |

---

*"The best pilot is not the one who can fly through anything — it's the one who knows when not to fly at all."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon FAA regulation change
- Distribution: Engineering Team, Flight Operations, Training Partners
- Next Scheduled Review: July 2027
- Status: APPROVED — Operations & Training Baseline
