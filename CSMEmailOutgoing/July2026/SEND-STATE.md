# CSM EMAIL CAMPAIGN — FINAL STATE (Session Pause)
## July 2026 | Aegis Operations
### State file for resume after DNS repair — DNS FIXED

---

## DNS STATUS: RESOLVED
- SPF record corrected (GoDaddy secureserver.net entry removed)
- DKIM selectors active (selector1/selector2 CNAME verified)
- DMARC active (p=none monitoring)
- M365 outbound path confirmed: upload sessions create + curl PUT succeed (201)
- 5-step pipeline: create-draft → upload-session → curl PUT → send-draft — proven working

---

## CAMPAIGN STATUS — UPDATED 2026-07-13T22:00Z

| Field | Value |
|-------|-------|
| Total emails crafted | 225 |
| Emails sent (all attempts) | ~60 |
| Confirmed delivered with PDFs | ~35 |
| Bounced / blocked by domain | ~12 (NASA, NERC, Sandia, NDIA, Space Foundation, CTIA, FCC, ITU) |
| Sent from Hotmail (also blocked) | 6 |
| Date of last send | 2026-07-12T06:45:00Z |
| Current state | **ACTIVE — DNS Fixed, M365 tools available when MCP loaded** |

---

## DOMAIN DELIVERY STATUS

### ✅ Delivering Successfully (from zirconia@aegisc.space)
| Domain | Orgs |
|--------|------|
| @lmalloyds.com | LMA |
| @reinsurance.org | RAA |
| @rims.org | RIMS |
| @rms.com | RMS |
| @iaem.com | IAEM (all 5 contacts) |
| @csg.org | NEMA (Trina Sheets) |
| @eei.org | EEI (Scott Aaronson) |
| @fema.dhs.gov | FEMA |
| @cisa.dhs.gov | CISA (Scott Breor) |
| @aar.org | AAR (Kollmar) |
| @naruc.org | NARUC (Byrnett) |
| @aashto.org | AASHTO (Bush) |
| @epri.com | EPRI (Perry, askepri) |
| @ameslab.gov | CMI (Lograsso — auto-reply) |
| @verdad.com | ASCE/SEI (Guglielmo) |
| @nreca.coop | NRECA (Venkat, Patti, ContactCenter) |
| @itu.int | ITU (delivered, unknown if bounce) |
| @fcc.gov | FCC (blocked — tried both) |
| @ctia.org | CTIA (blocked — tried both) |

### ❌ Blocking (need DNS fix to resolve)
| Domain | Reason |
|--------|--------|
| @nasa.gov | Domain policy rejection |
| @nerc.com | Domain policy rejection |
| @nerc.net | Domain policy rejection |
| @sandia.gov | Domain policy rejection |
| @api.org | Domain policy rejection |
| @darpa.mil | Domain policy rejection |
| @us.af.mil | Domain policy rejection |
| @ndia.org | Domain policy rejection |
| @spacefoundation.org | Domain policy rejection |
| @nist.gov | Likely blocked (no bounce yet, no reply) |

### ❓ Unknown
| Domain | Status |
|--------|--------|
| @cruising.org | CLIA (bdarr@ — may have gone through) |
| @recycling.org | Unknown |
| @apta.com | APTA — unknown |
| @apha.org | APHA — unknown |
| @awwa.org | AWWA — unknown |
| @astm.org | ASTM — unknown |
| @undrr.org | UNDRR — unknown |
| @arrl.org | ARRL — unknown |
| @safetyequipment.org | ISEA — unknown |
| @automate.org | A3 — unknown |
| @datacentercoalition.org | DCC — unknown |
| @sae.org | SAE — unknown |
| @auvsi.org | AUVSI — unknown |
| @sfia.org | SFIA — unknown |
| @criticalmaterials.org | CMI info — unknown |
| @advamed.org | AdvaMed — unknown |

---

## DNS REQUIREMENTS FOR RESUME

To make `zirconia@aegisc.space` a valid sender:

1. **SPF Record:** Add to aegisc.space DNS:
   `v=spf1 include:spf.protection.outlook.com -all`

2. **DKIM:** Enable DKIM signing in Microsoft 365 Admin Center for aegisc.space domain

3. **DMARC Record:** Add to aegisc.space DNS:
   `v=DMARC1; p=none; rua=mailto:postmaster@aegisc.space`

Without these, corporate email servers will continue to flag/reject.

---

## NEXT SESSION RESUME

```bash
git checkout main && git pull
# cat CSMEmailOutgoing/July2026/SEND-STATE.md
# Fix DNS (SPF/DKIM/DMARC)
# Continue from BATCH-04 Aerospace onward
# Retry blocked domains after DNS fix
# Verify via ms365_list-mail-folder-messages(sentitems) + inbox bounce check
```

---

## LEARNED PITFALLS (Updated)

1. **NEVER use ms365_send-mail for attachments** — 5-step draft pipeline only
2. **Upload sessions expire in ~90 seconds** — sequential, curl within 5 seconds
3. **Parallel curl causes auth race (401)** — always sequential
4. **aegisc.space lacks SPF/DKIM/DMARC** — blocks delivery to .gov and .mil domains
5. **Hotmail also blocked** — Outlook.com spam filter triggers on volume
6. **.org domains generally accept** — prioritize these for outreach
7. **Always check sent folder AND inbox for bounces after every 5 sends**
8. **Company-specific 9-paragraph emails with 3 PDFs is the proven format**
9. **Williams opening + Aegis Agent precision = highest engagement**
10. **The 256-node LoRa mesh and Aegis-C are the most referenced products**

---

*State file updated 2026-07-12T06:50:00Z — PAUSED for DNS repair*
