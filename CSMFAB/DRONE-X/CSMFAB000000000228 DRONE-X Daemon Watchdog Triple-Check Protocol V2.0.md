# CSMFAB000000000228 — DRONE-X Daemon Watchdog Triple-Check Protocol
## Version 2.0 — Initial Release | July 2026
**Organization:** Carrington Storm Motors / Safe Pod Engineering Company
**Series:** CSMFAB — Fabrication Publications | DRONE-X Sub-Series
**Classification:** Software Safety Engineering Document

---

## Δ Change Log

| Rev | Date | Change Description |
|-----|------|--------------------|
| 2.0 | July 2026 | Initial V2.0 release — Daemon A/B/C architecture, heartbeat protocol, escalating alerts, meta-watchdog specification |

---

## 1. Triple-Daemon Architecture

The daemon watchdog system (Layer 6 of the safety architecture, CSMFAB-224) provides process-level redundancy through three independent daemon processes and a fourth OS-level meta-watchdog. Implemented as a shell script (`dronex_daemon_watchdog.sh`) running on the phone as an Android foreground service or iOS background task.

```
┌── Daemon A (Exec) ──────────────────────────────┐
│ 400 Hz flight control loop integrity monitor     │
│ Heartbeat → shared mem segment (updated every    │
│ 2.5 ms). Exits if main loop stops > 10 ms.      │
└────────────────────────┬─────────────────────────┘
                         │ monitors heartbeats
┌── Daemon B (Check) ─────────────────────────────┐
│ 200 Hz health checker. Reads Daemon A heartbeat. │
│ Triggers alert if heartbeat age > 2× timeout     │
│ (20 ms). Logs to syslog and IPC to Daemon C.     │
└────────────────────────┬─────────────────────────┘
                         │ monitors heartbeats
┌── Daemon C (Watchdog) ──────────────────────────┐
│ 1 Hz escalator. Reads Daemon B health. Escalates │
│ in 3 tiers: WARN (1s), CRITICAL (2s), RTL (3s). │
│ Writes to /var/run/dronex/watchdog.status        │
└────────────────────────┬─────────────────────────┘
                         │ monitors heartbeats
┌── Meta-Watchdog (OS) ───────────────────────────┐
│ 0.2 Hz (every 5 seconds). Monitors Daemon C PID. │
│ If Daemon C dead > 10 s, triggers system-level   │
│ force-stop of application + audio alarm.         │
└─────────────────────────────────────────────────┘
```

## 2. Daemon A — Flight Control Executive (400 Hz)

| Parameter | Value |
|-----------|-------|
| Execution rate | 400 Hz (every 2.5 ms) |
| Monitoring target | Main flight control loop iteration count |
| Heartbeat mechanism | Atomic increment of `g_loop_count` in shared memory segment |
| Timeout detection | If `g_loop_count` unchanged for > 10 ms (4 cycles) |
| Failure response | Write FAIL to shared mem, log to syslog, set exit code 1 |
| Restart policy | Auto-restart by Daemon B (up to 3 times, then escalate) |
| Initiation | Started by Daemon B at boot |

## 3. Daemon B — Health Checker (200 Hz)

| Parameter | Value |
|-----------|-------|
| Execution rate | 200 Hz (every 5 ms) |
| Monitoring target | Daemon A heartbeat + shared memory integrity |
| Timeout detection | Daemon A heartbeat age > 20 ms (2× Daemon A timeout) |
| Heartbeat mechanism | Atomic increment of `g_check_count` in shared memory |
| Restart handling | Kills old Daemon A, starts new instance (max 3 retries) |
| Failure response (3 restarts exhausted) | Write CRITICAL to shared mem, notify Daemon C via IPC pipe |
| Memory integrity check | CRC32 of critical state struct (every 50 cycles = 4 Hz) |

## 4. Daemon C — Escalating Watchdog (1 Hz)

| Tier | Heartbeat Age | Status | Action |
|------|--------------|--------|--------|
| 1 — Warning | 1.0–2.0 s | WARN | Log to syslog, orange HUD indicator |
| 2 — Critical | 2.0–3.0 s | CRIT | Red HUD indicator, audio alert on phone, disable autonomous modes |
| 3 — RTL | > 3.0 s | FATAL | Attempt software RTL (send RTL command via MCU bridge). If no ACK within 500 ms, escalate to meta-watchdog. |

| Parameter | Value |
|-----------|-------|
| Execution rate | 1 Hz |
| Monitoring target | Daemon B heartbeat + IPC pipe |
| Status file | /var/run/dronex/watchdog.status (JSON) |
| Audio alert | 3 kHz tone, 100 ms burst, repeating every 1 s at Tier 2, every 0.5 s at Tier 3 |

## 5. Meta-Watchdog — OS-Level Guardian

| Parameter | Value |
|-----------|-------|
| Execution rate | 0.2 Hz (every 5 s) |
| Monitoring target | Daemon C PID existence + status file age |
| Timeout detection | Daemon C PID absent OR status file age > 10 s |
| Failure response | Android: `am force-stop com.csm.dronex`; iOS: terminate app via watchdog assertion |
| Audio alarm | Maximum volume, distinct "WOOOP WOOOP" pattern — "land immediately" |
| Logging | Writes to persistent storage, survives app restart |

## 6. Shared Memory Layout

The three daemons communicate via a 128-byte shared memory segment (POSIX shm):

| Offset | Field | Type | Description |
|--------|-------|------|-------------|
| 0x00 | loop_count | uint32 | Daemon A heartbeat counter |
| 0x04 | check_count | uint32 | Daemon B heartbeat counter |
| 0x08 | state_crc | uint32 | CRC32 of flight state struct |
| 0x0C | daemon_a_restarts | uint8 | Count of Daemon A restarts |
| 0x0D | daemon_a_pid | int32 | Daemon A PID |
| 0x11 | daemon_b_pid | int32 | Daemon B PID |
| 0x15 | daemon_c_pid | int32 | Daemon C PID |
| 0x19 | status_flags | uint8 | Bitmask: 0x01=WARN, 0x02=CRIT, 0x04=FATAL |
| 0x1A | timestamp_ms | uint64 | Last update timestamp (monotonic ms) |
| 0x22 | reserved | 94 bytes | Future expansion |

---

*"Three processes watching each other is not paranoia — it's the minimum viable architecture when failure costs altitude."*

---

**Document Control**
- Author: Director Kairos Steele, CITADEL — Aegis Operations
- Review Cadence: Annual
- Distribution: Engineering Team, Software Safety Team
- Next Scheduled Review: July 2027
- Status: APPROVED — Software Safety Baseline
