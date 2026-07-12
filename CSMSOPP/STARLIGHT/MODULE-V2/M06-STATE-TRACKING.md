# STATE-TRACKING.md — Resume Architecture
## CSMSOPP000004-V2-M06

### SEND-STATE.md Format
```
| Sent ID | Address | Company | Status |
```
Plus sections: CONFIRMED DELIVERIES, UNDELIVERABLE/BOUNCED, REMAINING WORK, LEARNED PITFALLS.

### Auto-Resume Logic
1. Read SEND-STATE.md from CSMEmailOutgoing/July2026/
2. Parse REMAINING WORK section
3. Sort by priority (body-only emails first, then full batches)
4. Send next 5
5. Update SEND-STATE.md with new entries
6. Git commit + push to main

### State Integrity
- **Single source of truth.** Never guess what's been sent.
- **Immutable log.** Appended, never overwritten.
- **Human-readable.** Can be opened in any text editor.
