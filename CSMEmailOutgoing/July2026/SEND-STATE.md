# CSM EMAIL CAMPAIGN — SEND STATE
## July 2026 | CSM Outreach | Aegis Ops
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
| Sender | CSM-AEGIS-001 |
| SOP in use | Baker Street + Williams blended |

---

## CONFIRMED DELIVERIES (with PDFs attached)

| Sent ID | Recipient Ref | Organization | Status |
|---------|--------------|--------------|--------|
| E001 | LMA-EM-01 | Lloyd's Market Assoc | ✅ Delivered + PDF attached |
| E001-PDF | LMA-EM-01 | LMA — PDF follow-up | ✅ Delivered |
| E002 | RAA-FA-01 | RAA — Federal Affairs | ✅ Delivered + PDF attached |
| E002-PDF | RAA-SCR-01 | RAA — State Relations | ✅ Delivered + PDF attached |
| E003 | RIMS-BD-01 | RIMS — Business Dev | ✅ Delivered + PDF attached |
| E004 | RMS-MP-01 | RMS Moody's — Models | ✅ Delivered + PDF attached |
| E005 | FEMA-NCP-01 | FEMA — Continuity | ✅ Delivered + PDF attached |
| E006 | EEI-SP-01 | EEI — Security | ✅ Delivered + PDF attached |
| E006-b | EEI-GR-01 | EEI — Grid Team | ✅ Delivered + PDF attached |
| E007-a | NRECA-IG-01 | NRECA — Integrated Grid | ✅ Sent (body only) |
| E007-b | NRECA-GO-01 | NRECA — Grid Ops | ✅ Sent (body only) |
| E007-c | NRECA-CC-01 | NRECA — Contact Ctr | ✅ Sent (body only) |
| E008-a | CISA-ISD-01 | CISA — ISD Lead | ✅ Delivered + PDF attached |
| E008-b | CISA-CENT-01 | CISA — Central | ✅ Sent |
| E009-a | IAEM-EX-01 | IAEM — Exhibits | ✅ Delivered + PDF attached |
| E009-b | IAEM-CONF-01 | IAEM — Conference | ✅ Delivered + PDF attached |
| E009-c | IAEM-SPON-01 | IAEM — Sponsorship | ✅ Delivered + PDF attached |
| E009-d | IAEM-EXDIR-01 | IAEM — Exhibit Dir | ✅ Delivered + PDF attached |
| E009-e | IAEM-INFO-01 | IAEM — General | ✅ Delivered + PDF attached |
| E010-a | NEMA-ED-01 | NEMA — Exec Dir | ✅ Delivered + PDF attached |
| E010-b | NEMA-ADMIN-01 | NEMA — Admin | ✅ Delivered + PDF attached |
| E026 | DARPA-DSO-01 | DARPA Defense Sciences | ✅ Delivered + 3 PDFs attached |
| E027 | AFRL-DE-01 | AFRL Directed Energy | ✅ Delivered + 3 PDFs attached |
| E028 | NASA-HELIO-01 | NASA Heliophysics | ✅ Delivered + 3 PDFs attached |
| E029 | NOAA-SWPC-01 | NOAA SWPC | ✅ Delivered + 3 PDFs attached |
| E030 | AIAA-SciTech-01 | AIAA SciTech Forum | ✅ Delivered + 3 PDFs attached |
| E031 | SPACE-SYM-01 | Space Symposium Foundation | ✅ Delivered + 3 PDFs attached |
| E032 | AIA-DEF-01 | Aerospace Industries Association | ✅ Delivered + 3 PDFs attached |
| E033 | NDIA-SYM-01 | NDIA Symposia | ✅ Delivered + 3 PDFs attached |
| E034 | CLIA-REG-01 | CLIA Cruise Lines Intl | ✅ Delivered + 3 PDFs attached |
| E035 | SNAME-ED-01 | SNAME Naval Architects | ✅ Delivered + 3 PDFs attached |
| Batch | BATCH-05 | Marine/Maritime (8) | 2/8 sent — E036-E041 researched, NOT SENT |
| Batch | BATCH-06 | Data/Telecom/Satellite (8) | NOT SENT |
| Batch | BATCH-07 | National Outreach (9) | NOT SENT |
| Batch | BATCH-08 | Global Outreach (157) | NOT SENT |
| Batch | BATCH-09 | Community/Specialist (10) | NOT SENT |
| Status | CEASED | Operations halted per operator directive | CSM-AEGIS-Starlight |
| Date | 2026-07-12T05:21Z | Session terminated | see AEGIS-SESSION-LOG |

## UNDELIVERABLE / BOUNCED

| Ref | Reason | Action |
|-----|--------|--------|
| NERC-SD-01 | Policy violation — domain rejection | ⚠️ Skip @nerc.com entirely |
| NERC-SD-02 | Policy violation — domain rejection | ⚠️ Skip @nerc.com entirely |
| NERC-GMD-01 | Undeliverable | ⚠️ Skip @nerc.net |
| NEMA-ED-BAD | Invalid address | ✅ Fixed → NEMA-ED-01 |
| NRECA-ENG-BAD | Sender not authorized for relay | ⚠️ Skip — mail server misconfigured |
| EEI-TD-BAD | Undeliverable | ⚠️ Skip — invalid address |

## AUTO-REPLIES (Delivered)

| Ref | Type |
|-----|------|
| IAEM-SPON-01 | Auto-reply — delivered |
| IAEM-EXDIR-01 | Auto-reply — delivered |
| LM-EM-02 | Auto-reply — delivered |

---

## LEARNED PITFALLS (for the next script)

1. **NEVER use ms365_send-mail for attachments** — always use 5-step pipeline: create_draft → upload_session PDF1 → upload_session PDF2 → upload_session PDF3 → send_draft
2. **Upload sessions expire in ~90 seconds** — upload each PDF immediately after creating its session. SEQUENTIAL, not parallel.
3. **Parallel curl on same message ID causes auth race (401)** — always sequential: create → curl → create → curl → create → curl → send
4. **NERC domain rejects all external senders** — skip this domain entirely
5. **NRECA emails (Patti, Venkat, ContactCenter) still need PDF follow-ups** — on the PENDING list
6. **CISA central@ needs body-only email converted to full 9-paragraph + PDF**
7. **FEMA first email was body-only** — second one delivered with PDFs
8. **All initial "BATCH" labeled sends were test emails** — ignore
9. **Always check sent folder AND inbox for bounces after every 5 sends**
10. **The 256-node LoRa mesh and Ascension drone are the two most frequently referenced products** — templatize these

---

## REMAINING WORK

### Immediate (body-only emails needing PDF follow-ups)
1. CISA Central — full 9-paragraph + 3 PDFs
2. NRECA — PDF follow-ups (short body, 3 PDFs)

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

*State file generated 2026-07-12T04:27Z — CSMEmailOutgoing/July2026/SEND-STATE.md*
*For use by csm-email-sender.py auto-resume capability*
*All email addresses and personal names replaced with organization abbreviations per privacy protocol*
