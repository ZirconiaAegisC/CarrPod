# ADVANCED EMAIL DELIVERABILITY — BEYOND SPF/DKIM/DMARC
## aegisc.space — Microsoft 365 — Business Sender Reputation

Your DNS authentication (SPF/DKIM/DMARC) is now active. What follows is the full deliverability stack that corporate email teams consider table stakes.

---

## 1. POSTMASTER TOOLS — REGISTER WITH THE BIG TWO

**Google Postmaster Tools:** https://postmaster.google.com
- [ ] Verify `aegisc.space` (add a TXT verification record they give you)
- [ ] Monitor: IP reputation, domain reputation, spam rate, delivery errors
- [ ] The spam rate bar MUST stay under 0.10%. Over 0.30% and Gmail throttles you.

**Microsoft SNDS (Smart Network Data Services):** https://sendersupport.olc.protection.outlook.com/snds/
- [ ] Register for the IP(s) your Microsoft 365 tenant sends from
- [ ] Monitor: complaint rate by IP, spam trap hits, blocklist status

**Yahoo/Verizon Postmaster:** https://senders.yahooinc.com/ (if you send to Yahoo/AOL)

Why: These give you the exact same dashboards recipient companies use. You see your reputation before they reject you.

---

## 2. GOOGLE — ADDITIONAL VERIFICATION BEYOND SPF/DKIM/DMARC

**Search Console verification** adds reputation weight for Gmail delivery:
- [ ] Go to https://search.google.com/search-console
- [ ] Add `aegisc.space` as a property
- [ ] Verify with DNS TXT record (takes 1 minute)
- [ ] Submit sitemap (helps overall domain authority)

Also create a **Google Business Profile** for Carrington Storm Motors if you haven't:
- [ ] https://business.google.com
- [ ] Verified business = domain trust boost

---

## 3. CUSTOM MAIL FROM / RETURN-PATH — THE ENVELOPE SENDER

**Problem:** By default, Microsoft 365 uses `bounces@onmicrosoft.com` as the Return-Path envelope. This means:
- SPF checks the Return-Path domain, not the From domain
- Email forwarding can break SPF alignment
- Some filters flag mismatched Return-Path

**Fix:** Use a custom subdomain for your Return-Path / Mail-From:
```
bounce.aegisc.space  TXT  v=spf1 include:spf.protection.outlook.com -all
```

Then configure your Microsoft 365 tenant to use `@bounce.aegisc.space` as the bounce address (via Exchange Admin Center → Mail Flow → Accepted Domains, or through a third-party connector if using a relay).

This gives you **strict SPF alignment** under DMARC — corporate gateways notice.

---

## 4. EMAIL WARM-UP — DON'T BLAST FROM A COLD DOMAIN

**Critical for new domains.** Sending volume to never-contacted addresses from a brand-new domain = spam filter beacon.

**The 30-day warm-up protocol:**

| Week | Max Daily Sends | Recipient Type |
|------|----------------|----------------|
| 1 | 5-10 | Only to people who REPLIED or OPTED IN |
| 2 | 15-25 | Increasing gradually |
| 3 | 50-100 | Interleaved with replies |
| 4+ | Ramp to normal | Maintain < 0.10% spam rate |

**Tools that automate warm-up (optional):**
- Warmbox.ai
- Mailwarm.com
- Inboxally.com
- Lemwarm (part of Lemlist)

They send automated engagement emails to seed accounts that open/reply/star your mail, building positive reputation signals.

---

## 5. FEEDBACK LOOPS (FBL) — GOOGLE + YAHOO

Register for complaint feedback loops. When someone clicks "This is spam," you get notified and MUST remove them.

**Google FBL:** Automatically enrolled if you have DMARC `rua` set. Google sends aggregate and forensic reports to your `rua` email.

**Yahoo FBL:** https://senders.yahooinc.com/complaint-feedback-loop/

**Microsoft:** Handled automatically through JMRP (Junk Mail Reporting Program) — you're auto-enrolled if you use Microsoft 365 as sender.

**Comcast FBL:** https://postmaster.comcast.net/feedback-loop.html

---

## 6. TLS / MTA-STS — ENCRYPTED TRANSPORT

Corporate email gateways increasingly REQUIRE TLS. Without it, some deliverability downgrades.

**MTA-STS for aegisc.space:**

Step A: Create a TXT record:
```
_mta-sts.aegisc.space  TXT  v=STSv1; id=2026071201
```

Step B: Host an MTA-STS policy file at:
```
https://mta-sts.aegisc.space/.well-known/mta-sts.txt
```
Contents:
```
version: STSv1
mode: enforce
mx: aegisc-space.mail.protection.outlook.com
max_age: 86400
```

This tells mail servers: "Only accept mail to aegisc.space if the connection is TLS-encrypted." Microsoft 365 already supports TLS by default — MTA-STS just formally declares it.

---

## 7. BIMI — YOUR LOGO IN THEIR INBOX

Brand Indicators for Message Identification. When your DMARC is at `p=quarantine` or `p=reject`, you can add:

```
default._bimi.aegisc.space  TXT  v=BIMI1; l=https://aegisc.space/logo.svg
```

Requirements:
- SVG logo file (Tiny 1.2 profile, no scripts, no external resources)
- HTTPS hosting
- Verified Mark Certificate (VMC) for full Apple Mail/Gmail support (DigiCert or Entrust)

Even without VMC, Yahoo and some clients show BIMI logos with just DMARC passing.

---

## 8. LIST HYGIENE — THIS IS WHERE REPUTATIONS DIE

**The #1 killer of new business domains:** sending to stale, purchased, or scraped lists.

RULES:
- NEVER send to a purchased list. Instant reputation tank.
- Verify every email BEFORE first send (ZeroBounce, NeverBounce, Hunter.io verification)
- Remove hard bounces immediately (Microsoft 365 does this automatically)
- Remove recipients who haven't opened in 90 days
- Use double opt-in for any mailing list signups
- Honor one-click unsubscribe (required by Gmail/Yahoo since Feb 2024)

**Microsoft 365 built-in tools:**
- Exchange Admin Center → Protection → Spam filter → Review quarantine daily
- Message trace: check delivery status for every important email

---

## 9. TESTING — SEND TO ACTUAL CORPORATE GATEWAYS

Send test emails to each of these and check headers:

| Send To | Gateway to defeat | What to look for |
|---------|-------------------|-----------------|
| **Gmail** (personal) | Google Workspace spam filter | SPF/DKIM/DMARC = PASS in headers |
| **Outlook.com** | Microsoft consumer filter | Junk folder vs. Inbox |
| **ProtonMail** | Strict open-source filtering | Very sensitive to new domains |
| **mail-tester.com** | Aggregate scoring | Score 10/10 |
| **check-auth@verifier.port25.com** | Automated auth check | Returns full report via email |

**Free tools:**
- https://www.mail-tester.com — sends a full deliverability report
- https://www.learndmarc.com — visual DNS record checker
- https://mxtoolbox.com/deliverability/ — checks blacklists

---

## 10. BLOCKLIST MONITORING

Check if your domain or sending IP is on any blocklists:

- [ ] https://mxtoolbox.com/blacklists.aspx — check `aegisc.space`
- [ ] https://multirbl.valli.org/ — multi-RBL lookup
- [ ] https://www.spamhaus.org/lookup/ — the big one

If you're clean, great. If not, each RBL has a delisting process. Spamhaus is the one that matters most for corporate email.

---

## 11. SIGNATURE HYGIENE + BRANDING

Every email you send should have:
- Full name
- Title ("Director of Aegis Operations, Carrington Storm Motors")
- Company name + domain
- Physical mailing address (CAN-SPAM Act requirement for commercial mail)
- One-click unsubscribe link (required)

A professional, consistent signature signals legitimacy to both human recipients AND content filters. Inconsistent or missing signatures correlate with spam.

---

## 12. ENGAGEMENT METRICS — THE SILENT REPUTATION BUILDER

Modern spam filters (especially Gmail) weight engagement HEAVILY:
- Open rate
- Reply rate
- Forward rate
- "Not spam" clicks
- Time spent reading
- Reply within sender's organization

PRIORITY: Your first 20-50 emails should go to people who WILL reply. Start conversations. Every reply is a reputation credit.

---

## EXECUTION ORDER (Priority-Sorted)

1. **Today:** Register Google Postmaster Tools + verify domain
2. **Today:** Register Microsoft SNDS
3. **Today:** Send a test email to mail-tester.com → score must be 10/10
4. **This week:** Verify SPF/DKIM/DMARC with LearnDMARC.com
5. **This week:** Check all blocklists → delist if needed
6. **This month:** Implement MTA-STS (TLS policy)
7. **This month:** Start sending ONLY to known contacts, < 10/day first week
8. **Month 2:** Scale volume after DMARC reports show clean data
9. **Month 2:** Add BIMI record for logo in inboxes
10. **Ongoing:** Monitor Google Postmaster + Microsoft SNDS weekly
