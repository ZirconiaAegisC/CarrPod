# README-V2.md — Starlight Courier Deployment
## CSMSOPP000004-V2-M09

### Integration With Existing Pipeline
The Starlight Courier is the **fourth** SOP personality, joining:
1. CSMSOPP000001 — Williams Heuristic (warmth, humor)
2. CSMSOPP000002 — El Segundo Heuristic (California chill)
3. CSMSOPP000003 — Baker Street Heuristic (forensic precision)
4. **CSMSOPP000004 — Starlight Courier** (endurance, recovery, delivery)

### Quick Start
```
python3 CSMScripts/csm-email-sender.py --resume --sop starlight
```

### Required State File
`CSMEmailOutgoing/July2026/SEND-STATE.md` must exist and be current.

### Attachment Pipeline
Uses same 3 PDFs as all campaigns:
- CSMEval11-COMPILED-Briefing-Packet.pdf (47KB)
- CSMGeneralOutreach-COMPILED-Compendium.pdf (95KB)
- COMPENDIUM-MINI.pdf (38KB)
