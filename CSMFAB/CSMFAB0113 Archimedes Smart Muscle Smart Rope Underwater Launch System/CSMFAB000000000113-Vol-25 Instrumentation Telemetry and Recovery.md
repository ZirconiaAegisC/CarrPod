# CSMFAB000000000113-Vol-25
## Instrumentation, Telemetry, and Spear Recovery Systems
**Series:** CSMFAB000000000113 | **Volume:** 25 of 29 | **June 2026**

---

## 1. On-Spear Instrumentation Suite

All sensors use Aegis Telluric-Proof architecture: PMMA optical fiber, FBG sensing, LoRa wireless.

### 1.1 Sensor Package

| Sensor | Type | Range | Sample Rate | Mass (g) |
|---|---|---|---|---|
| 3-axis accelerometer | MEMS, fiber-coupled | ±500 g | 10 kHz | 2 |
| Angular rate (gyro) | MEMS, fiber-coupled | ±10,000 deg/s | 1 kHz | 3 |
| Static pressure | FBG optical | 0.001-110 kPa | 100 Hz | 4 |
| Dynamic pressure (pitot) | FBG optical | 0-5 MPa | 100 Hz | 3 |
| Nose temperature | ZrB2-SiC embedded FBG | -50°C to 3000°C | 10 Hz | 2 |
| GPS | Ceramic-packaged chip | all | 10 Hz | 5 |
| LoRa transmitter | Ceramic chip | 915 MHz, 250 mW | — | 4 |
| Camera | ZrO2-housed, fisheye | 4K video | 60 fps | 8 |
| MRAM data storage | Radiation-hard | 4 GB | — | 3 |
| Power (LiFePO4) | ZrO2-housed cell | 50 Wh | — | 180 |

Total instrument mass: ~214 g (fits in 60mm diameter × 150mm payload section)

### 1.2 Telemetry Link Budget

LoRa 915 MHz link from 100 km altitude to surface vessel:
Free-space path loss: L_fs = 20*log(4*pi*d/lambda) = 20*log(4*pi*100000/0.326) = 141 dB
LoRa transmitter EIRP: 250 mW → +24 dBm
LoRa sensitivity (spreading factor 12): -137 dBm
Link margin: +24 - 141 - (-137) = **+20 dB** — excellent link at 100 km altitude.

Real-time data at ~500 bps (LoRa SF12): pressure, temperature, acceleration → trajectory reconstruction.

---

## 2. Recovery Systems

### 2.1 Parachute Deployment (Suborbital Missions)

For suborbital flights reaching 100 km apogee, spear re-enters at:
v_reentry = sqrt(2 * 9.81 * 100000) = 1,407 m/s (vacuum equivalent)
With atmospheric braking at 80 km: v at 80km = ~1,200 m/s

**KNbO3-BaTiO3 mortar parachute deployment at 5 km altitude:**
- Deployment triggered by barometric threshold (FBG pressure sensor reads 54 kPa)
- KNbO3-BaTiO3 linear actuator ejects parachute canister from nose
- Pilot chute deploys: 0.5 m diameter, extracts main drogue
- Main chute: 3 m diameter ribbon parachute (suitable to 300 m/s deployment)
- Final descent rate: v_term = sqrt(2mg / (rho*A*Cd)) = sqrt(2*2*9.81/(1.225*7.07*1.2)) = 2.0 m/s

Splashdown velocity: 2.0 m/s — safe for recovery.

### 2.2 GPS + LoRa Tracking

LoRa beacon remains active throughout flight and post-splashdown (waterproof ZrO2 housing).
Signal range on ocean surface (flat terrain, LoRa SF12): 15 km
Vessels monitor beacon and dispatch recovery RIB to splashdown coordinates.

### 2.3 Recovery Vessel Specification

Fast recovery RIB: 8m length, BFRP hull, outboard engine (35 kW).
Speed: 45 knots → recovers spear within 3 km in < 5 minutes, 50 km in < 75 minutes.

---

## Citations (Vol 25)

- LoRa Alliance, LoRaWAN Physical Layer specification, 2022
- CSMFAB000000000013 V2.0, PMMA optical fiber instrumentation, CSM 2026
- Knacke, T.W., Parachute Recovery Systems Design Manual, NWC TP 6575, 1992
- AeroTech Parachute Systems, descent rate calculations, 2024

*End Vol 25 | CSMFAB000000000113 | CSM Safe Pod Engineering Company | June 2026*
