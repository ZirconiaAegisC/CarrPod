# MASTER EMAIL TEMPLATES — Congressional & Media Correspondence
## ACS / DOE / Congressional Liaison Office
### Prepared: July 2026 — Classification: Business Development — Internal Use

---

## Template Configuration Reference

| Field | Purpose | Format |
|-------|---------|--------|
| `{SENDER_NAME}` | Sender full name | John A. Mitchell |
| `{SENDER_TITLE}` | Sender role | Director, Advanced Energy Partnerships |
| `{SENDER_ORG}` | Organization | ACS Congressional Liaison Office |
| `{SENDER_PHONE}` | Direct line | (202) 555-0147 |
| `{SENDER_EMAIL}` | Reply-to address | j.mitchell@acs-doe-gov.org |
| `{RECIPIENT_NAME}` | Contact full name | Jane Smith |
| `{RECIPIENT_TITLE}` | Contact title | Chief Technology Officer |
| `{COMPANY_NAME}` | Company legal name | Tesla, Inc. |
| `{COMPANY_CITY}` | HQ city | Austin, TX |
| `{COMPANY_SECTOR}` | Industry sector | Electric Vehicles |
| `{DOSSIER_ID}` | Research dossier reference | ACS-DOS-2026-0142 |
| `{DOSSIER_DATE}` | Dossier completion date | July 12, 2026 |
| `{SPECIFIC_TECH}` | Company's key technology | Solid-state battery architecture |
| `{LEGISLATIVE_ACT}` | Relevant law/bill name | Energy Security & Advanced Manufacturing Act of 2026 |
| `{ACT_NUMBER}` | Public law or bill number | H.R. 8742 / P.L. 119-87 |
| `{ACT_SECTION}` | Specific section reference | Section 407(c)(2) |
| `{DATE_14DAYS}` | Date 14 days from send | July 31, 2026 |
| `{COUNTRY_NAME}` | Country for international | Germany |
| `{US_EMBASSY_CITY}` | Embassy location | Berlin |
| `{CALENDLY_LINK}` | Scheduling link | https://calendly.com/j-mitchell-acs/30min |
| `{TRACKING_ID}` | Unique tracking number | ACS-MC-2026-00001 |

---

## TEMPLATE A — Cold Outreach: Company WITH Existing ACS Dossier

**Use When:** Company has been researched and a dossier exists in the ACS system. Reference specific findings to demonstrate depth of knowledge.

**Subject Line Format:**
```
{COMPANY_NAME} — ACS Research Partnership on {SPECIFIC_TECH} — {TRACKING_ID}
```

**Body:**

```
Dear {RECIPIENT_NAME},

I am writing from the Advanced Capabilities & Systems (ACS) Congressional Liaison Office
in Washington, D.C. Our team has completed an in-depth analysis of {COMPANY_NAME}'s
work in {SPECIFIC_TECH}, documented in Dossier {DOSSIER_ID} (completed {DOSSIER_DATE}).

Your team's progress in this domain aligns directly with priority areas identified by
the Joint Committee on Energy and Advanced Manufacturing. As Congress advances the
{LEGISLATIVE_ACT}, companies positioned at the intersection of national security and
industrial innovation stand to benefit from accelerated partnership frameworks.

We are seeking to establish a structured dialogue with {COMPANY_NAME}'s leadership
to explore:

  1. Alignment between your technology roadmap and federal energy/manufacturing
     priorities under {ACT_NUMBER}, particularly {ACT_SECTION}.

  2. Opportunities for {COMPANY_NAME} to participate in coordinated industry
     working groups convening in Washington this autumn.

  3. Pathways for your R&D programs to interface with DOE National Laboratory
     resources and testing infrastructure.

Our dossier on {COMPANY_NAME} indicates that your {COMPANY_CITY}-based operations
are at a stage where structured federal engagement could accelerate deployment
timelines and provide regulatory clarity. We would welcome the opportunity to
schedule a confidential briefing.

I can be reached directly at {SENDER_PHONE} or {SENDER_EMAIL}. You may also
schedule a call at your convenience via {CALENDLY_LINK}.

With respect and appreciation for your work,

{SENDER_NAME}
{SENDER_TITLE}
{SENDER_ORG}
{SENDER_PHONE} | {SENDER_EMAIL}
```

**Metadata Tags (JSON block in email headers for AI routing):**
```
X-ACS-Template: A
X-ACS-Dossier: {DOSSIER_ID}
X-ACS-Sector: {COMPANY_SECTOR}
X-ACS-Priority: HIGH
X-ACS-Tracking: {TRACKING_ID}
X-ACS-Requires-Dossier: TRUE
X-ACS-FollowUp-Date: {DATE_14DAYS}
```

---

## TEMPLATE B — Cold Outreach: Company WITHOUT Existing Dossier

**Use When:** Company is on the outreach list but no dossier has been prepared yet. Invite partnership and information-sharing to build the dossier.

**Subject Line Format:**
```
{COMPANY_NAME} — Federal Advanced Manufacturing & Energy Partnership Inquiry — {TRACKING_ID}
```

**Body:**

```
Dear {RECIPIENT_NAME},

I am reaching out from the Advanced Capabilities & Systems (ACS) Congressional
Liaison Office in Washington, D.C. Our office coordinates industry engagement
for the Joint Committee on Energy and Advanced Manufacturing, connecting private-
sector innovation leaders with federal priorities.

{COMPANY_NAME} has been identified through our sector analysis as a significant
contributor to {COMPANY_SECTOR} advancement in the United States. As Congress
considers the {LEGISLATIVE_ACT}, we are actively building our understanding of
the companies whose work will shape implementation.

We would value the opportunity to:

  1. Learn more about {COMPANY_NAME}'s current technology roadmap, production
     capabilities, and growth trajectory from your {COMPANY_CITY} headquarters.

  2. Share an overview of relevant federal programs, funding mechanisms, and
     regulatory developments that may impact your sector.

  3. Explore whether a formal ACS research dossier on {COMPANY_NAME} would
     be mutually beneficial — providing your team with a direct channel to
     Congressional staff and agency leadership.

This is an invitation to a dialogue, not a solicitation. There is no cost
to your company, and all discussions begin under mutual non-disclosure terms.

I welcome a brief introductory call. You can reach me at {SENDER_PHONE} or
{SENDER_EMAIL}, or schedule directly via {CALENDLY_LINK}.

Respectfully,

{SENDER_NAME}
{SENDER_TITLE}
{SENDER_ORG}
{SENDER_PHONE} | {SENDER_EMAIL}
```

**Metadata Tags:**
```
X-ACS-Template: B
X-ACS-Dossier: NONE
X-ACS-Sector: {COMPANY_SECTOR}
X-ACS-Priority: MEDIUM
X-ACS-Tracking: {TRACKING_ID}
X-ACS-Requires-Dossier: FALSE
X-ACS-FollowUp-Date: {DATE_14DAYS}
```

---

## TEMPLATE C — Legal Enactment Notice: Sending Relevant Legislation

**Use When:** A bill has passed or executive action has been taken that directly affects the company's sector. Attach or link the legislative text.

**Subject Line Format:**
```
{COMPANY_NAME} — Enactment Notice: {LEGISLATIVE_ACT} ({ACT_NUMBER}) — {TRACKING_ID}
```

**Body:**

```
Dear {RECIPIENT_NAME},

This is a formal notification from the ACS Congressional Liaison Office regarding
the enactment of the {LEGISLATIVE_ACT}, signed into law as {ACT_NUMBER}.

Our analysis indicates that {ACT_SECTION} of this legislation carries direct
implications for {COMPANY_NAME}'s operations in {COMPANY_SECTOR}. Key provisions
include new federal procurement preferences, manufacturing investment tax credits,
and expedited permitting pathways for qualifying domestic production facilities.

We have prepared a section-by-section analysis of the Act as it pertains to
{COMPANY_SECTOR} enterprises. This document is available for download through
our secure portal, or we can arrange a briefing with our legislative affairs
team to walk through the provisions relevant to your {COMPANY_CITY} operations.

Action items for {COMPANY_NAME}:

  1. Review eligibility criteria under {ACT_SECTION} for the Advanced
     Manufacturing Production Credit (estimated effective date: Q1 2027).

  2. Assess whether existing or planned facilities qualify for the
     accelerated environmental review process established in Title IV.

  3. Contact our office to schedule a compliance and opportunity briefing.

We stand ready to support your team in navigating the new landscape.

Sincerely,

{SENDER_NAME}
{SENDER_TITLE}
{SENDER_ORG}
{SENDER_PHONE} | {SENDER_EMAIL}
```

**Metadata Tags:**
```
X-ACS-Template: C
X-ACS-Dossier: {DOSSIER_ID}
X-ACS-Sector: {COMPANY_SECTOR}
X-ACS-Priority: CRITICAL
X-ACS-Tracking: {TRACKING_ID}
X-ACS-Legislative-Act: {LEGISLATIVE_ACT}
X-ACS-Act-Number: {ACT_NUMBER}
X-ACS-FollowUp-Date: {DATE_14DAYS}
```

---

## TEMPLATE D — International Outreach: Non-US Entities

**Use When:** Reaching companies headquartered outside the United States. Adapted for diplomatic tone, references to bilateral agreements, and US Embassy coordination.

**Subject Line Format:**
```
{COMPANY_NAME} — US-{COUNTRY_NAME} Advanced Technology Partnership — {TRACKING_ID}
```

**Body:**

```
Dear {RECIPIENT_NAME},

I write from the Advanced Capabilities & Systems (ACS) Congressional Liaison
Office in Washington, D.C. Our office has been tasked by the Joint Committee
on Energy and Advanced Manufacturing to strengthen transatlantic and transpacific
technology partnerships, with particular focus on {COMPANY_SECTOR} collaboration.

{COMPANY_NAME}'s leadership in {SPECIFIC_TECH} has drawn the attention of
policymakers on both sides of the Atlantic/Pacific. As the United States and
{COUNTRY_NAME} deepen cooperation under existing bilateral science and technology
agreements, we see significant opportunity for structured engagement with
companies like yours.

Our objectives include:

  1. Facilitating introductions between {COMPANY_NAME} and US-based partners,
     including National Laboratories, university research consortia, and
     domestic manufacturers seeking international collaboration.

  2. Providing clarity on US regulatory frameworks affecting {COMPANY_SECTOR}
     companies seeking to establish or expand US operations.

  3. Coordinating with the US Embassy in {US_EMBASSY_CITY} to arrange
     in-country briefings and site visits where appropriate.

All communications are conducted with full respect for {COMPANY_NAME}'s
proprietary interests and national regulatory obligations. We adhere to
both US and {COUNTRY_NAME} protocols for commercial diplomacy.

I would be honored to schedule an introductory discussion. I can be reached
at {SENDER_PHONE}, by email at {SENDER_EMAIL}, or via {CALENDLY_LINK}.

With high regard,

{SENDER_NAME}
{SENDER_TITLE}
{SENDER_ORG}
Washington, D.C., United States
{SENDER_PHONE} | {SENDER_EMAIL}
```

**Metadata Tags:**
```
X-ACS-Template: D
X-ACS-Dossier: {DOSSIER_ID}
X-ACS-Sector: {COMPANY_SECTOR}
X-ACS-Priority: HIGH
X-ACS-Tracking: {TRACKING_ID}
X-ACS-Country: {COUNTRY_NAME}
X-ACS-International: TRUE
X-ACS-FollowUp-Date: {DATE_14DAYS}
```

---

## TEMPLATE E — Follow-Up: 14-Day No-Response

**Use When:** No response received 14 days after initial outreach. Professional, persistent but polite.

**Subject Line Format:**
```
RE: {ORIGINAL_SUBJECT} — Following Up
```

**Body:**

```
Dear {RECIPIENT_NAME},

I am following up on my correspondence of {ORIGINAL_DATE} regarding {COMPANY_NAME}'s
potential engagement with the ACS Congressional Liaison Office.

I understand that leadership schedules are demanding, and this follow-up is sent
in the spirit of persistence rather than pressure. The legislative calendar in
Washington is moving forward, and the window for early participation in the
{LEGISLATIVE_ACT} implementation framework is narrowing.

Should {COMPANY_NAME} wish to be included in the next round of industry briefings
and working group formation, I would encourage connecting in the coming week.

For your convenience, here again is my direct contact information and scheduling link:

  Phone: {SENDER_PHONE}
  Email: {SENDER_EMAIL}
  Calendar: {CALENDLY_LINK}

If {COMPANY_NAME} has decided not to participate at this time, a brief response
to that effect would be appreciated so we may update our records accordingly.

Thank you for your consideration.

Respectfully,

{SENDER_NAME}
{SENDER_TITLE}
{SENDER_ORG}
```

**Metadata Tags:**
```
X-ACS-Template: E
X-ACS-Dossier: {DOSSIER_ID}
X-ACS-Sector: {COMPANY_SECTOR}
X-ACS-Priority: MEDIUM
X-ACS-Tracking: {TRACKING_ID}
X-ACS-FollowUp-Number: 1
X-ACS-Original-Date: {ORIGINAL_DATE}
```

---

## TEMPLATE F — C-Suite Executive Direct Contact

**Use When:** Reaching CEO, CTO, or other C-level executive directly. Formal tone, emphasizes strategic importance, shorter body.

**Subject Line Format:**
```
{COMPANY_NAME} — Strategic Federal Partnership Opportunity — Office of {RECIPIENT_TITLE}
```

**Body:**

```
Dear {RECIPIENT_NAME},

I am addressing this directly to your office given the strategic significance
of the matter. The ACS Congressional Liaison Office, operating under the
auspices of the Joint Committee on Energy and Advanced Manufacturing, has
identified {COMPANY_NAME} as a priority partner for the implementation of
the {LEGISLATIVE_ACT}, recently enacted as {ACT_NUMBER}.

Your company's position in {COMPANY_SECTOR}, and specifically its {SPECIFIC_TECH}
program, places {COMPANY_NAME} among a select group of enterprises whose
participation will shape the industrial policy landscape for the next decade.

I am requesting a brief, confidential discussion — at your convenience —
to outline the specific mechanisms through which {COMPANY_NAME} can engage.
This is not a public process; initial conversations are held in strict
confidence and carry no obligation.

My direct line is {SENDER_PHONE}. Alternatively, my office can coordinate
through your Chief of Staff or Executive Assistant at your preference.

With respect for your time and your company's mission,

{SENDER_NAME}
{SENDER_TITLE}
{SENDER_ORG}
Washington, D.C.
{SENDER_PHONE} | {SENDER_EMAIL}
```

**Metadata Tags:**
```
X-ACS-Template: F
X-ACS-Dossier: {DOSSIER_ID}
X-ACS-Sector: {COMPANY_SECTOR}
X-ACS-Priority: CRITICAL
X-ACS-Tracking: {TRACKING_ID}
X-ACS-Executive-Contact: TRUE
X-ACS-FollowUp-Date: {DATE_14DAYS}
```

---

## AI Mail System Routing Configuration

The following header values are embedded in each outgoing email and parsed by the ACS Correspondence Management System for automated routing, tracking, and follow-up scheduling.

### Priority Routing Matrix

| Priority | Response SLA | Escalation Path | Max Follow-Ups |
|----------|-------------|-----------------|----------------|
| CRITICAL | 72 hours | Chief of Staff review at Day 5 | 3 |
| HIGH | 7 days | Senior Liaison review at Day 10 | 2 |
| MEDIUM | 14 days | Automated template E at Day 14 | 1 |
| LOW | 30 days | Archived at Day 30 | 0 |

### Sector Classification Tags

```
X-ACS-Sector: SEMICONDUCTOR
X-ACS-Sector: CLEAN-ENERGY
X-ACS-Sector: FUSION
X-ACS-Sector: BATTERY-STORAGE
X-ACS-Sector: LITHIUM-MINERALS
X-ACS-Sector: EV-TRANSPORT
X-ACS-Sector: AIRCRAFT-AEROSPACE
X-ACS-Sector: HYDROGEN
X-ACS-Sector: CARBON-CAPTURE
X-ACS-Sector: CEMENT-STEEL
X-ACS-Sector: ADDITIVE-MANUFACTURING
X-ACS-Sector: CONSTRUCTION
X-ACS-Sector: DEFENSE
X-ACS-Sector: INFRASTRUCTURE
X-ACS-Sector: INTERNATIONAL
```

### Tracking ID Format

```
ACS-MC-{YEAR}-{BATCH}{SEQUENCE}
Example: ACS-MC-2026-B101 = Batch 1, Company 01
         ACS-MC-2026-I901 = International Batch 9, Company 01
```

---

*Document maintained by ACS Correspondence Operations. Revision Date: July 19, 2026.*
*All templates are authorized for use under ACS Communications Protocol v3.2.*
