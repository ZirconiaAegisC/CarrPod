# DNS AUTHENTICATION SESSION LOG — aegisc.space
## 2026-07-14 | Director-001 CITADEL | AEGIS-COMMS

---

## SESSION SUMMARY

**Mission:** Deploy SPF, DKIM, and DMARC DNS records for `aegisc.space` to authorize
Microsoft 365 as the validated sending infrastructure for all corporate email.

**Outcome:** All DNS authentication records deployed. DKIM signing enabled.
Microsoft 365 now authoritative for all outbound `@aegisc.space` mail.

---

## INFRASTRUCTURE DETERMINATION

| Field | Value |
|-------|-------|
| Domain | aegisc.space |
| DNS Hosting | GoDaddy (domaincontrol.com nameservers) |
| Email Platform | Microsoft 365 Business (single tenant) |
| Sending Sources | Unified — single M365 tenant handles all `@aegisc.space` outbound |
| Zirconia Sending | Same M365 tenant |
| Initial DNS State | No prior SPF/DKIM/DMARC records |

---

## DNS RECORDS DEPLOYED (Sanitized — Copy-Ready)

### 1. MX RECORD — Inbound Mail Delivery
```
Type:    MX
Name:    @
Value:   aegisc-space.mail.protection.outlook.com
Priority: 0
TTL:     1 hour
```
**Purpose:** Routes all inbound `@aegisc.space` mail to Exchange Online Protection.

### 2. SPF RECORD — Sender Authorization
```
Type:    TXT
Name:    @
Value:   v=spf1 include:spf.protection.outlook.com -all
TTL:     1 hour
```
**Purpose:** Declares Microsoft 365 as the sole authorized sender. `-all` = hard fail
for all other sources. No spoofing vector.

### 3. DKIM CNAME RECORDS — Cryptographic Signing
```
Type:    CNAME
Name:    selector1._domainkey
Value:   selector1-aegisc-space._domainkey.[TENANT].onmicrosoft.com
TTL:     1 hour

Type:    CNAME
Name:    selector2._domainkey
Value:   selector2-aegisc-space._domainkey.[TENANT].onmicrosoft.com
TTL:     1 hour
```
**Purpose:** Delegates DKIM key management to Microsoft. CNAME values obtained from
Microsoft 365 Security Portal (security.microsoft.com/dkimv2). DKIM signing
manually enabled in portal after CNAME propagation confirmed.

### 4. DMARC RECORD — Policy Declaration
```
Type:    TXT
Name:    _dmarc
Value:   v=DMARC1; p=none; rua=mailto:dmarc-reports@aegisc.space; pct=100
TTL:     1 hour
```
**Purpose:** Monitoring mode. Collects aggregate reports. No blocking (`p=none`).
Recommended progression: p=none (2 weeks) → p=quarantine (2 weeks) → p=reject.

### 5. AUTODISCOVER CNAME — Client Auto-Configuration
```
Type:    CNAME
Name:    autodiscover
Value:   autodiscover.outlook.com
TTL:     1 hour
```
**Purpose:** Enables Outlook/Exchange client automatic configuration for `@aegisc.space`.

---

## DKIM ACTIVATION TIMELINE

1. CNAME records added to GoDaddy DNS
2. DNS propagation observed (Microsoft Security Portal confirmed CNAME resolution)
3. DKIM toggled ON in security.microsoft.com/dkimv2
4. Microsoft now applies DKIM signatures to all outbound `@aegisc.space` mail

---

## ADVANCED DELIVERABILITY — NEXT ACTIONS (Priority-Sorted)

| # | Action | Timeline | Status |
|---|--------|----------|--------|
| 1 | Register Google Postmaster Tools, verify aegisc.space | Today | PENDING |
| 2 | Register Microsoft SNDS | Today | PENDING |
| 3 | Send test to mail-tester.com — target 10/10 | Today | PENDING |
| 4 | Verify all records at learndmarc.com | Today | PENDING |
| 5 | Check blocklists at mxtoolbox.com | Today | PENDING |
| 6 | Create dmarc-reports@aegisc.space mailbox | This week | PENDING |
| 7 | Send first 10 emails to known contacts (engagement building) | This week | PENDING |
| 8 | Implement MTA-STS (TLS enforcement policy) | This month | PENDING |
| 9 | Domain warm-up — 30-day graduated volume | This month | PENDING |
| 10 | Add BIMI record (brand logo in inbox) | Month 2 | PENDING |

---

## VERIFICATION CHECKLIST

- [x] SPF record published and resolves
- [x] DKIM CNAME records published and resolving
- [x] DKIM signing enabled in Microsoft 365 portal
- [x] DMARC record published (monitoring mode)
- [x] MX record routing to Exchange Online
- [x] Autodiscover CNAME present
- [ ] Google Postmaster Tools registered
- [ ] Microsoft SNDS registered
- [ ] mail-tester.com 10/10 score confirmed
- [ ] learnDMARC.com all-green verification
- [ ] Blocklist check — all clean

---

## AUTHENTICATED BY
Director-001 CITADEL — Kairos Steele
Aegis Operations, Carrington Storm Motors / Safe Pod Engineering
DNS Authentication Session 2026-07-14

*"The DNS record is the first layer of the shield. Without it, every email
is a paper airplane in a hurricane. With it, every corporate gateway sees
exactly what we intend: a verified, authenticated, legitimate sender."*
