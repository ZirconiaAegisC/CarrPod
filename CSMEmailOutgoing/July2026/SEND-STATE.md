# CSM EMAIL CAMPAIGN — FINAL STATE
## July 2026 | Aegis Ops — DNS FIXED

---

## DNS STATUS: RESOLVED
- SPF record corrected (conflicting registrar entry removed)
- DKIM selectors active
- DMARC active
- M365 outbound confirmed: upload sessions + curl PUT = 201
- Proven 5-step pipeline: draft → upload-session → curl PUT → send-draft

---

## CAMPAIGN STATUS

| Field | Value |
|-------|-------|
| Total crafted | 225 |
| Sent (all attempts) | ~60 |
| Confirmed delivered + PDFs | ~35 |
| Bounced/blocked | ~12 (.gov/.mil domains + .org policy blocks) |
| DNS fix date | 2026-07-13 |
| Pipeline | **ACTIVE — resume when MCP loaded** |

---

## DOMAIN DELIVERY

### ✅ Accepting
| Domain Pattern | Count |
|--------|------|
| *.org (most) | ~15 |
| *.com (most) | ~8 |
| *.dkv/major .gov | 4 |
| *.coop | 1 |

### ❌ Blocking (domain policy)
| Pattern | Type |
|--------|------|
| *.gov (specific agencies) | Policy rejection |
| *.mil | Policy rejection |
| *.com (specific) | Policy rejection |

---

## EMAILS SENT WITH PDFs (DNS-FIXED SESSION)

| # | Recipient | Org | PDFs |
|---|-----------|-----|------|
| 1 | D.B. | NARUC | ✅ |
| 2 | E.G. | ASCE/SEI | ✅ |
| 3 | P.B. | AASHTO | ✅ |
| 4 | R.K. | AAR | ✅ |
| 5 | C.P. | EPRI | ✅ |
| 6 | T.L. | DOE CMI | ✅ |

---

## PROVEN PIPELINE
```
1. create-draft → draft ID
2. upload-session → curl PUT (within 5 sec)
3. upload-session → curl PUT
4. upload-session → curl PUT
5. send-draft → SENT
CRITICAL: Sequential only. Never parallel. ~90 sec session tokens.
```

---

## RESUME
```
git pull && cat CSMEmailOutgoing/July2026/SEND-STATE.md
# M365 MCP required: /mcps → enable → new session
# Login with company email
# Scan sent folder for hasAttachments=false
# Fix each, then continue BATCH-04 through BATCH-09 (~180 remaining)
```

---

## PITFALLS
1. Never send-mail for attachments — 5-step pipeline only
2. Upload sessions expire ~90 sec — sequential, fast curl
3. Parallel curl = 401 auth race
4. Registrar default SPF conflicts with M365 — remove it
5. Duplicate DMARC records cause issues
6. Check sent + inbox for bounces every 5 sends
7. Williams opening + precision body = proven
8. Company-specific body + 3 PDFs = deliverable
9. Never include technical troubleshooting in recipient emails

---

*State file updated 2026-07-13T22:05Z — DNS FIXED, pipeline confirmed*
*All identifiers abbreviated. No email addresses, no full names.*
