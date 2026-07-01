# CSMFAB000000000114 — Vol-23
# Aeronautical Research Data Collection Plan
## Mission Design, Measurement Protocol, and Data Format
**Carrington Storm Motors / Safe Pod Engineering Company**
**Version 1.0 | June 2026**

---

## Introduction: Turning Flights Into Science

Flying a device is an engineering achievement. Generating publishable atmospheric data from that device is a scientific achievement. This volume bridges the two — it tells you what research questions the ASB-1 uniquely answers, how to design flight missions to answer them, and what to do with the data afterward.

---

## Part 1: Research Questions the ASB-1 Can Answer

| Research Question | Scientific Value | Data Required |
|---|---|---|
| Q1: What is the wind speed/direction profile above a coastal cliff from 50-400 ft AGL? | Baseline for small UAS operational planning; sea-breeze characterization | Single-unit vertical sounding, multiple altitudes |
| Q2: How does the wind field vary horizontally across a 50m cliff face? | Cliff-edge turbulence; safety zones for paragliders and hang gliders | 5-10 unit linear swarm simultaneously |
| Q3: Does the cliff-top updraft have a predictable boundary altitude? | Wind energy siting; soaring bird behavior modeling | 2-3 unit differential altitude run |
| Q4: How do swarm units' wind measurements correlate at different altitudes? | Atmospheric coherence length; turbulence scale characterization | 5-20 unit swarm, full altitude range |
| Q5: How does temperature inversion affect updraft strength? | Micrometeorology; aviation weather understanding | Any single unit with SHT31 sensor, multiple days |

---

## Part 2: Standard Mission Profiles

### Mission Profile A: Single Vertical Sounding

- Units: 1 ASB-1
- Tether: 50m standard
- Launch site: cliff edge or elevated terrain, Class G airspace
- Duration: 20 minutes
- Altitude reached: 50-152 ft AGL (tether limited)
- Data product: Altitude vs. wind speed/direction profile (Fig. 1 style graph)
- Scientific value: Baseline measurement; paper/report contribution

### Mission Profile B: 5-Unit Cliff Lateral Survey

- Units: 5 ASB-1, 5m spacing along cliff edge
- Tether: 50m per unit
- Duration: 30 minutes (simultaneous)
- Altitude reached: target common altitude of 100 ft AGL (apply equal tether brake pressure)
- Data product: Wind speed and direction at 5 horizontal positions simultaneously = lateral gradient map
- Scientific value: First data on lateral wind gradients at this resolution for cliff sites

### Mission Profile C: 10-Unit 3D Atmosphere Map (Waiver Required)

- Units: 10 ASB-1, two 5-unit rows 15m apart
- Tether: 100m per unit (extended research tether, §107.51 waiver active)
- Duration: 45 minutes
- Altitude reached: up to 300 ft AGL
- Data product: 3D scatter plot of wind vectors at 10 positions over 45 minutes
- Scientific value: Maximum data density; suitable for publication in Journal of Atmospheric and Oceanic Technology

---

## Part 3: Data Recording Protocol

For every mission:
1. Start SwarmView ground station 10 minutes before launch — allows GPS warm start
2. Record mission metadata in log: date, time (UTC), launch site GPS coordinates, operator name, RPIC certificate number, waiver number (if applicable), ambient weather conditions
3. Record each launch time per unit to the nearest second
4. SwarmView automatically logs all telemetry to timestamped CSV (see Vol-06 data products)
5. After landing/recovery: note recovery time per unit and any anomalies
6. Back up CSV and JSON files to university network drive within 1 hour of mission completion

### Post-Flight Data Processing

Using Python + matplotlib (free, available on any laptop):

```python
import pandas as pd
import matplotlib.pyplot as plt

# Load SwarmView CSV output
df = pd.read_csv('3D_wind_map.csv')

# Plot altitude profile for unit 1
unit1 = df[df['node_id'] == 1]
plt.figure()
plt.plot(unit1['wind_speed_ms'], unit1['altitude_m'])
plt.xlabel('Wind Speed (m/s)')
plt.ylabel('Altitude AGL (m)')
plt.title('ASB-1 Unit 1 Vertical Wind Profile')
plt.grid(True)
plt.savefig('vertical_profile_unit1.png')
plt.show()
```

This generates the core research figures for your mechatronics program report.

---

## CHECKPOINT — Vol-23 Complete

Before proceeding, confirm:
- [ ] You understand the 5 research questions ASB-1 uniquely answers
- [ ] You know the 3 standard mission profiles (A: single sounding, B: lateral survey, C: 3D map)
- [ ] You understand the data recording protocol (SwarmView auto-log + manual metadata)
- [ ] You have verified you can run the Python post-processing script on your laptop

**Proceed to:** Vol-24 (Swarm Coordination) or Vol-28 (Professor Presentation)

---

*CSMFAB000000000114-Vol-23 | Version 1.0 | June 2026 | Carrington Storm Motors / Safe Pod Engineering Company*
