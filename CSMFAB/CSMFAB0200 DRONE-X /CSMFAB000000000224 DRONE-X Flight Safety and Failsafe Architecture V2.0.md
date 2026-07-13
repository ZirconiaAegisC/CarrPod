# CSMFAB000000000224 — DRONE-X Flight Safety and Failsafe Architecture
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Safety Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — 6-layer safety architecture, kill switch, MCU watchdog, software failsafe, geofence, battery, daemon watchdog |

---

## 1. Six-Layer Safety Architecture

DRONE-X employs a defense-in-depth safety model with six independent layers, each capable of independently arresting flight in a failure scenario:

| Layer | Name | Mechanism | Response Time | Failure Coverage |
|-------|------|-----------|---------------|-----------------|
| 1 | Physical Kill Switch | DPDT toggle (galvanic isolation) | < 50 ms (human) | Total power loss, motor runaway |
| 2 | MCU Watchdog | STM32F103 IWDG (independent hardware timer) | 500 ms | MCU firmware hang, clock failure |
| 3 | Software Failsafe | App-side heartbeat/timeout monitor | 2,000 ms | App crash, USB/BT link loss |
| 4 | Geofence | Hard position/altitude bounds | 500 ms | Navigation error, flyaway |
| 5 | Battery Failsafe | Voltage threshold with escalating response | 1,000 ms | Power depletion, cell failure |
| 6 | Daemon Watchdog | Triple-daemon architecture (CSMFAB-228) | 1,000–3,000 ms | Multi-process failure, silent corruption |

## 2. Layer 1 — Physical Kill Switch

| Parameter | Value |
|-----------|-------|
| Switch type | DPDT toggle (MTS-202) |
| Rating | 10 A @ 16 VDC |
| Mounting location | Right-rear landing skid, outward-facing |
| Access | Single hand, no tools |
| Effect | Disconnects BOTH battery leads (positive and negative) |
| Fail-safe | Open = disconnected (no power to any system) |
| Independent of | All software, all MCUs, all semiconductors |

**Critical requirement:** The kill switch must remain accessible during all phases of flight — pilot can reach it during hand-launch, hover, and landing without risk of propeller contact.

## 3. Layer 2 — MCU Independent Watchdog

The STM32F103's IWDG (Independent Watchdog) uses a dedicated 40 kHz LSI oscillator completely independent of the system clock:

| Parameter | Value |
|-----------|-------|
| Watchdog type | IWDG (hardware, LSI 40 kHz) |
| Timeout period | 500 ms |
| Kick frequency | 100 Hz (every 10 ms) in flight loop |
| Reset on timeout | Hard MCU reset → all GPIO default to input → ESC signals go LOW → motors stop |
| Boot recovery | MCU reinitializes, waits for ARM command from phone |
| Independence | Separate clock (LSI), no dependency on HSE/HCLK/SysTick |

## 4. Layer 3 — Software Failsafe

| Event | Detection | Action | Recovery |
|-------|-----------|--------|----------|
| USB CDC disconnect | Missing heartbeat > 200 ms | BT failover attempt | Re-arm on link recovery |
| BT disconnect | Missing heartbeat > 500 ms | RTL via MCU standalone | Re-arm required |
| App crash | Heartbeat age > 2,000 ms | RTL via MCU standalone | Re-arm required |
| All links lost | MCU detects no USB + no BT for 2 s | MCU autonomous RTL (pre-loaded home GPS) | Re-arm required |
| MCU-to-ESC loss | ESC telemetry timeout > 500 ms | Disarm all ESCs | Full power cycle required |

## 5. Layer 4 — Geofence

| Fence Type | Limit | Violation Action |
|-----------|-------|-----------------|
| Max altitude | 120 m AGL (FAA Part 107) | Descend to 115 m, alert pilot |
| Max radius | 500 m from home | Yaw 180°, RTL at 12 m/s |
| Min altitude | 1.0 m AGL (except landing) | Climb to 5 m, hold position |
| Exclusion zones | User-defined polygons | Avoid or RTL if inside |
| Altitude floor (battery) | 10 m minimum at < 20% battery | Prevent climb, land immediately |

Geofence is enforced at 10 Hz by both the phone app AND the MCU firmware (redundant enforcement). MCU geofence uses home GPS coordinates stored at arming, eliminating phone dependency.

## 6. Layer 5 — Battery Failsafe

| Battery Level | Voltage (3S) | Action |
|--------------|-------------|--------|
| Normal | > 11.0V | Full operation |
| Caution | 10.8–11.0V | HUD warning "BATTERY LOW" |
| Low | 10.5–10.8V | Auto-RTL, phone charging disabled, max speed 8 m/s |
| Critical | 10.2–10.5V | Forced landing at current position, no climb allowed |
| Emergency | < 10.2V | Immediate disarm (if altitude < 2 m), else descend at 1 m/s |

Battery voltage measured by MCU ADC (PA0) through a 4:1 voltage divider (3.9kΩ/1kΩ), sampled at 200 Hz with 20 Hz Butterworth filter.

## 7. Layer 6 — Daemon Watchdog

Detailed specification in CSMFAB-228 and implemented in `dronex_daemon_watchdog.sh`. The triple-daemon architecture provides process-level redundancy:

| Daemon | Function | Rate | Timeout |
|--------|----------|------|---------|
| Daemon A (Exec) | Flight control execution monitor | 400 Hz | — |
| Daemon B (Check) | Health check of Daemon A | 200 Hz | 2× Daemon A timeout |
| Daemon C (Watchdog) | Monitor Daemon B, escalate alerts | 1 Hz | 4× Daemon B timeout |
| Meta-Watchdog | Monitor Daemon C from OS level | 0.2 Hz | 10× Daemon C timeout |

---

*"Safety is not a feature — it is the absence of single points of failure. And absence requires layers."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual or upon safety incident review
- Distribution: Engineering Team, Flight Safety Board, Regulatory Compliance
- Next Scheduled Review: July 2027
- Status: APPROVED — Safety Baseline
