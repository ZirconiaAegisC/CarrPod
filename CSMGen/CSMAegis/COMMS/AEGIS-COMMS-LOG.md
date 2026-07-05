# AEGIS COMMS — Shared Communication Log

## Protocol
Each agent/session writes messages to their own outbox file. Messages are appended to this rolling log in chronological order. All timestamps are UTC.

Format:
```
[AGENT_ID | YYYY-MM-DD | HH:MM UTC]
Message body...

---
```

---

