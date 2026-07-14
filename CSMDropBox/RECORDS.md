# DNS RECORDS — aegisc.space — Microsoft 365 Unified
## Copy-paste ready for GoDaddy DNS Management

---

## RECORD 1: MX (Mail Delivery — receives email)

This tells the world "mail sent TO @aegisc.space goes to Microsoft's servers."

| Field | Value |
|-------|-------|
| **Type** | MX |
| **Name** | @ |
| **Priority** | 0 |
| **Value** | `aegisc-space.mail.protection.outlook.com` |
| **TTL** | 1 hour (or default) |

---

## RECORD 2: SPF (Authorized Senders)

This tells the world "only Microsoft 365 can send mail FROM @aegisc.space."

| Field | Value |
|-------|-------|
| **Type** | TXT |
| **Name** | @ |
| **Value** | `v=spf1 include:spf.protection.outlook.com -all` |
| **TTL** | 1 hour (or default) |

---

## RECORD 3: DMARC (Policy — MONITORING MODE)

This tells the world "send me reports, but don't block anything yet."

| Field | Value |
|-------|-------|
| **Type** | TXT |
| **Name** | `_dmarc` |
| **Value** | `v=DMARC1; p=none; rua=mailto:dmarc-reports@aegisc.space; pct=100` |
| **TTL** | 1 hour (or default) |

---

## RECORD 4: DKIM CNAME #1 (Email Signing)

**You get this value FROM Microsoft, not from me.**

| Field | Value |
|-------|-------|
| **Type** | CNAME |
| **Name** | `selector1._domainkey` |
| **Value** | *(Get from Microsoft — see DKIM instructions below)* |
| **TTL** | 1 hour (or default) |

---

## RECORD 5: DKIM CNAME #2 (Email Signing)

**You get this value FROM Microsoft, not from me.**

| Field | Value |
|-------|-------|
| **Type** | CNAME |
| **Name** | `selector2._domainkey` |
| **Value** | *(Get from Microsoft — see DKIM instructions below)* |
| **TTL** | 1 hour (or default) |

---

## RECORD 6: Autodiscover (Outlook auto-config)

| Field | Value |
|-------|-------|
| **Type** | CNAME |
| **Name** | `autodiscover` |
| **Value** | `autodiscover.outlook.com` |
| **TTL** | 1 hour (or default) |

---

## HOW TO GET THE DKIM CNAME VALUES

1. Open a NEW browser tab
2. Go to: **https://security.microsoft.com/dkimv2**
3. Find `aegisc.space` in the domain list
4. Click it → click **Enable** DKIM
5. Microsoft will show you TWO CNAME values — copy them EXACTLY
6. Paste into Records 4 and 5 above in GoDaddy

---

## FINAL DNS ZONE — What your GoDaddy screen should look like

```
Type     Name                      Value                                          Priority   TTL
----     -------------------       ------------------------------------------     --------   ---
MX       @                         aegisc-space.mail.protection.outlook.com       0          1 hour
TXT      @                         v=spf1 include:spf.protection.outlook.com -all           1 hour
TXT      _dmarc                    v=DMARC1; p=none; rua=mailto:dmarc-reports@...            1 hour
CNAME    selector1._domainkey      selector1-aegisc-space._domainkey.XXXXX.on...             1 hour
CNAME    selector2._domainkey      selector2-aegisc-space._domainkey.XXXXX.on...             1 hour
CNAME    autodiscover              autodiscover.outlook.com                                  1 hour
```
