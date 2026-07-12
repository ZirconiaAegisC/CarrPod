# CSM EMAIL CAMPAIGN — SEND STATE
## July 2026 | Jason Brodsky | zirconia@aegisc.space
### Auto-generated state file for csm-email-sender.py resume capability

---

## CAMPAIGN STATUS

| Field | Value |
|-------|-------|
| Total emails in campaign | 225 |
| Emails sent with full 9-paragraph body | ~40 |
| Emails sent with confirmed PDFs attached | ~18 |
| Batch | BATCH-01 through BATCH-03 fully sent |
| Remaining batches | BATCH-04 through BATCH-09 (185+ emails) |
| Date of last send | 2026-07-12T04:08:00Z |
| Sender email | zirconia@aegisc.space |
| Sender name | Jason Brodsky |
| SOP in use | Baker Street + Williams blended |

---

## CONFIRMED DELIVERIES (with PDFs attached)

| Sent ID | Address | Company | Status |
|---------|---------|---------|--------|
| E001 | sanjiv.sharma@lmalloyds.com | Lloyd's Market Association | ✅ Delivered + PDF attached |
| E001-PDF | sanjiv.sharma@lmalloyds.com | LMA — PDF follow-up | ✅ Delivered |
| E002 | austin@reinsurance.org | RAA — Nicole Austin | ✅ Delivered + PDF attached |
| E002-PDF | rudis@reinsurance.org | RAA — Jason Rudis | ✅ Delivered + PDF attached |
| E003 | kwolcott@rims.org | RIMS — Kris Wolcott | ✅ Delivered + PDF attached |
| E004 | prteam@rms.com | RMS Moody's — Model Products | ✅ Delivered + PDF attached |
| E005 | fema-ncp@fema.dhs.gov | FEMA — National Continuity Programs | ✅ Delivered + PDF attached |
| E006 | saaronson@eei.org | EEI — Scott Aaronson | ✅ Delivered + PDF attached |
| E006-b | feedback@eei.org | EEI — Grid Team | ✅ Delivered + PDF attached |
| E007-a | Venkat.Banunarayanan@nreca.coop | NRECA — VP Integrated Grid | ✅ Sent (body only) |
| E007-b | Patti.Metro@nreca.coop | NRECA — Grid Ops | ✅ Sent (body only) |
| E007-c | ContactCenter@nreca.coop | NRECA — Contact Center | ✅ Sent (body only) |
| E008-a | central@cisa.dhs.gov | CISA — Scott Breor | ✅ Delivered + PDF attached |
| E008-b | central@cisa.dhs.gov | CISA — Central (body only) | ✅ Sent |
| E009-a | carol@iaem.com | IAEM — Carol Tagliaferri | ✅ Delivered + PDF attached |
| E009-b | julie@iaem.com | IAEM — Julie Husk | ✅ Delivered + PDF attached |
| E009-c | katie@iaem.com | IAEM — Katie Schlesinger | ✅ Delivered + PDF attached |
| E009-d | clay@iaem.com | IAEM — Clay Tyeryar | ✅ Delivered + PDF attached |
| E009-e | info@iaem.com | IAEM — General | ✅ Delivered + PDF attached |
| E010-a | tsheets@csg.org | NEMA — Trina Sheets | ✅ Delivered + PDF attached |
| E010-b | nema_nondiscrimination@csg.org | NEMA — Admin | ✅ Delivered + PDF attached |

## UNDELIVERABLE / BOUNCED

| Address | Reason | Action |
|---------|--------|--------|
| monica.benson@nerc.com | Policy violation — domain rejection | ⚠️ Skip @nerc.com entirely |
| sarojas@nerc.com | Policy violation — domain rejection | ⚠️ Skip @nerc.com entirely |
| gmd@nerc.net | Undeliverable | ⚠️ Skip @nerc.net |
| trina.sheets@csg.org | Invalid address | ✅ Fixed → tsheets@csg.org |
| engineering@nreca.coop | Sender not authorized for relay | ⚠️ Skip — mail server misconfigured |
| transmission@eei.org | Undeliverable | ⚠️ Skip — invalid address |

## AUTO-REPLIES (Delivered — OOO or received)

| Address | Type |
|---------|------|
| katie@iaem.com | Auto-reply — delivered |
| clay@iaem.com | Auto-reply — delivered |
| Lauren.O'Rourke@lloyds.com | Auto-reply — delivered |

---

## LEARNED PITFALLS (for the next script)

1. **NEVER use ms365_send-mail for attachments** — always use 5-step pipeline: create_draft → upload_session PDF1 → upload_session PDF2 → upload_session PDF3 → send_draft
2. **Upload sessions expire in ~90 seconds** — upload each PDF immediately after creating its session. SEQUENTIAL, not parallel.
3. **Parallel curl on same message ID causes auth race (401)** — always sequential: create → curl → create → curl → create → curl → send
4. **NERC (@nerc.com) domain rejects all external senders** — skip this domain entirely
5. **NRECA emails (Patti, Venkat, ContactCenter) still need PDF follow-ups** — on the PENDING list
6. **CISA central@ needs body-only email converted to full 9-paragraph + PDF**
7. **FEMA fema-ncp first email was body-only** — second one delivered with PDFs
8. **All initial "BATCH" labeled sends to jasonbrodsky@hotmail.com were test emails** — ignore
9. **Always check sent folder AND inbox for bounces after every 5 sends**
10. **The 256-node LoRa mesh and Ascension drone are the two most frequently referenced products** — templatize these

---

## REMAINING WORK

### Immediate (body-only emails needing PDF follow-ups)
1. CISA central@ — send full 9-paragraph + 3 PDFs
2. NRECA Venkat/Patti/ContactCenter — PDF follow-ups (short body, 3 PDFs)

### Full batches remaining (need 9-paragraph + 3 PDFs each)
- BATCH-04: Aerospace/Defense/Space (8 emails)
- BATCH-05: Marine/Maritime/Transport (8 emails)
- BATCH-06: Data/Telecom/Satellite (8 emails)
- BATCH-07: National Outreach Compendium (9 emails)
- BATCH-08: Global Outreach (157 emails)
- BATCH-09: Community/Specialist (10 emails)

---

## ATTACHMENTS (consistently used)

| File | Size | Use |
|------|------|-----|
| CSMEval11-COMPILED-Briefing-Packet.pdf | 47KB | Sector-specific; send with ALL emails |
| CSMGeneralOutreach-COMPILED-Compendium.pdf | 95KB | 9-part overview; send with ALL emails |
| COMPENDIUM-MINI.pdf | 38KB | Quick reference; send with ALL emails |

---

*State file generated 2026-07-12T04:20Z — CSMEmailOutgoing/July2026/SEND-STATE.md*
*For use by csm-email-sender.py auto-resume capability*
