# ENDURANCE-ENGINE.md — Sustained Sending
## CSMSOPP000004-V2-M04

### The Long Drive Protocol
225 emails is a cattle drive from Texas to Kansas. You don't rush the herd — you keep them moving steadily. Key principles:

1. **5-at-a-time cadence:** Send 5, pause 10 seconds, verify sent folder, continue.
2. **Hydrate:** Check M365 auth token every 50 emails. Re-authenticate if expiring.
3. **Brand your work:** Every email logged to SEND-STATE.md immediately.
4. **Camp at dusk:** After 50 emails, run full audit (sent folder + inbox bounces).
5. **Ride at dawn:** Resume from SEND-STATE.md — never rely on memory.
