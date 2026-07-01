# CSMFAB000000000113-Vol-22
## Launch Platform: Vessel Design and Multi-Boat Coordination System
**Series:** CSMFAB000000000113 | **Volume:** 22 of 29 | **June 2026**

---

## 1. Vessel Specifications for AMSR-UBSCLS Operations

### 1.1 Master Vessel (Command Boat)

The master vessel performs:
- Launch sequencing and LoRa command broadcast
- Spear deployment and underwater positioning
- Recovery coordination post-launch

**Requirements:**
- Length: 10-15 m (30-50 ft) — sufficient for rope handling + dive team
- Hull: BFRP/Elium® (GIC-immune, CSMFAB000000000011-compatible)
- Propulsion: diesel-electric hybrid — main engine stopped during launch to reduce vibration
- Crew: 4 minimum (pilot, dive coordinator, electronics operator, safety officer)
- Equipment: BFRP davit crane for spear deployment, rope spool, LoRa master station

**Standard research vessel options (charter or purchase):**
- Rigid Inflatable Boat (RIB) 12m with BFRP hull modification: ~$85,000
- Purpose-built BFRP research vessel 12m: ~$180,000

### 1.2 Slave Vessels (n-1 Support Boats)

For n=6 configuration: 5 slave vessels positioned at hexagonal ring.

**Minimum slave vessel requirements:**
- Length: 5-8m (sufficient to carry 50m rope spool + actuator)
- Hull: fiberglass acceptable (GIC-immune alternative: BFRP)
- Crew: 2 per vessel minimum
- Equipment: rope spool BFRP frame, LoRa slave radio, ZrO2 ceramic cleat for rope attachment

**Budget options for hobbyist hobbyist scale (n=4, 10m ropes):**
- Inflatable kayaks with BFRP frame insert: ~$800 each
- Small aluminum motorboats: acceptable (far from spear center — minimal GIC risk at 6m radius)
- Total slave vessel budget for 3 support boats: $2,400 minimal

### 1.3 Vessel Positioning Protocol (GPS-Free)

LoRa ranging system:
1. Master vessel: LoRa broadcast position reference (ranging beacon mode)
2. Each slave vessel: measures time-of-flight to master → computes distance
3. Slave-to-slave ranging confirms hexagonal geometry within ±0.5m
4. All vessels motor to calculated position

**Positioning accuracy required:** ±2 m (from Vol 05 analysis)
LoRa ranging accuracy: ±0.5 m — **meets requirement.**

No GPS required. Entire system operates in GPS-denied Carrington-event scenario.

---

## 2. Rope Deployment Sequence

### Step 1: Anchor Spear Beneath Vessels
- Pneumatic guide weight (BFRP housing, N2-filled) attaches to spear base
- Guide weight drops spear to target depth (30m for Scale 3)
- Time: 60 seconds descent

### Step 2: Vessel Circle Formation
- Master vessel marks center; all boats motor to hexagonal positions
- LoRa ranging confirms geometry within ±1m
- Time: 15-20 minutes

### Step 3: Rope Connection
- Diver from each vessel descends to 2m depth
- Clip Smart Rope terminal connector (ZrO2 bayonet) to spear base lug
- Surface; rope naturally hangs upward (positively buoyant)
- Time: 5 minutes per rope; all 6 in parallel = 5 minutes total

### Step 4: Pre-Tension
- Each vessel's winch takes up rope slack
- Tension load cell (FBG optical) confirms 5000 N pre-tension per rope
- Time: 2 minutes

### Step 5: Final Checks
- Electronics team: confirms all LoRa nodes active
- Spear spin-up: verified via angular rate sensor reading (FBG optical)
- Sea state: confirmed Beaufort ≤ 3
- Safety zone: 500m radius confirmed clear by radar sweep

### Step 6: Launch Sequence
- Master vessel transmits ARMED command
- 30 second countdown broadcast via LoRa
- FIRE command: all 6 rope actuators trigger simultaneously
- Time: < 0.1 ms from command to all-rope actuation

Total preparation time (calm seas): **45-60 minutes**

---

## 3. Recovery Protocol

Post-launch, Smart Ropes float to surface (positive buoyancy).
Recovery:
1. Each vessel retrieves its rope (3-5 minutes per rope)
2. Spear recovery: GPS beacon (or LoRa on spear) tracked as it descends after apogee
3. Spear lands ~50-250 km downrange at sea
4. Recovery vessel (fast RIB) dispatched to coordinate: ~1-3 hour recovery

**For suborbital missions:** Spear enters at high velocity — recovery via parachute deployed by KNbO3-BaTiO3 mortar at atmospheric entry, or intentional ocean impact (expendable missions).

---

## Citations (Vol 22)

- CSMFAB000000000011 V2.0, BFRP vessel hull design, CSM 2026
- LoRa Alliance, LoRaWAN Ranging Protocol, 2024
- Bowditch, N., American Practical Navigator, NGA 2019
- USCG, "Operating Requirements for Small Vessels in Offshore Waters," CFR Title 46, 2024

*End Vol 22 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
