# RECOVERY-PROTOCOL.md — Bounce and Fall Recovery
## CSMSOPP000004-V2-M03

### The Fall Recovery Sequence
1. **Do not freeze.** Send the next email immediately.
2. **Log the fall.** Record address, error type, timestamp.
3. **Classify the fall:**
   - Policy violation → Domain blacklist. Skip the domain.
   - Invalid address → Research correct address. Retry.
   - Auth race (401) → Re-create session. Retry immediately.
   - Rate limit (429) → Wait 30 seconds. Retry.
4. **Transform.** Update SEND-STATE.md with new knowledge.

### Learned Classifications
- `@nerc.com` — Policy violation. Skip entire domain.
- `@nreca.coop` — MX misconfiguration. Use named contacts only.
- `@eei.org` — Valid for named contacts. Invalid for generic roles.
