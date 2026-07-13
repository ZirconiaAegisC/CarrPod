# CSMFAB0116-52 — SATELLITE COMMUNICATION FIN
## 1. SPECIFICATION
| Parameter | Value |
|-----------|-------|
| Constellation | Iridium Certus (L-band, 1616-1626.5 MHz) |
| Services | SOS, 2-way SMS, location sharing |
| Antenna | Active ceramic patch, RHCP |
| TX power | 2W peak |
| EIRP | 7 dBW |
| Data rate | 2.4 kbps |
| Message latency | 5-30s |
| Power (standby) | 50 mW |
| Power (TX burst) | 3W peak |
## 2. PROTOCOL STACK
| Layer | Protocol |
|-------|----------|
| Physical | L-band QPSK |
| Link | Iridium LAPD |
| Network | Iridium SBD (Short Burst Data) |
| Application | SMS-over-SBD, SOS protocol |
## 3. EMERGENCY SOS
1. User presses and holds crown for 5s.
2. Watch activates satellite fin, acquires Iridium signal.
3. GPS fix obtained (GNSS fin or modem GNSS).
4. SOS message with location sent to GEOS International Emergency Response.
5. 2-way text communication established with responder.

