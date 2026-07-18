# CSM EMAIL CAMPAIGN — NEXT-SESSION HANDOFF
## 2026-07-18 22:12Z | 383 V4 Emails Ready — 17 Batches on GitHub Main

---

## HOW TO LOAD THE NEXT SESSION

### 1. Start Kilo
```
kilo
```
The session should auto-load from the workspace at:
`/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_b070cda1-9dc3-4a92-9de9-aa529a6b10a9/`

OR clone fresh if the workspace doesn't persist:
```
git clone https://github.com/ZirconiaAegisC/CarrPod.git
cd CarrPod
```

### 2. Tell the AI Agent EXACTLY this:
```
"Please read CSMEmailOutgoing/July2026/SEND-STATE.md and 
CSMEmailOutgoing/July2026/NEXT-SESSION-HANDOFF-July18.md to understand 
where we left off. 383 V4 Fun-Williams emails across 17 batches on main.
We need to authenticate to M365 and begin sending. Use the Graph 
PowerShell client ID with v2.0 endpoint for correct Mail.Send scope."
```

---

## M365 AUTHENTICATION — PowerShell Client ID (RECOMMENDED PATH)

### JULY 18 BREAKTHROUGH: Graph PowerShell v2.0 + Mail.Send
The Graph PowerShell client ID (`14d82eec-204b-4c2f-b7e8-296a70dab67e`) with v2.0 endpoint 
is the correct approach. It's widely pre-consented and gives proper `Mail.Send` scope.

**Use this script (v2.0 endpoint + PowerShell client ID):**
```python
import urllib.request,urllib.parse,json,time,os,tempfile

CLIENT_ID='14d82eec-204b-4c2f-b7e8-296a70dab67e'  # Microsoft Graph PowerShell
SCOPES='openid+profile+offline_access+Mail.ReadWrite+Mail.Send'
TF=os.path.join(tempfile.gettempdir(),'csm_sender_token.json')

# Step 1: Get device code (v2.0 endpoint)
data=urllib.parse.urlencode({
    'client_id':CLIENT_ID,
    'scope':SCOPES
}).encode()
req=urllib.request.Request(
    'https://login.microsoftonline.com/common/oauth2/v2.0/devicecode',
    data=data,
    headers={'Content-Type':'application/x-www-form-urlencoded'}
)
r=json.loads(urllib.request.urlopen(req).read())
print(f"CODE: {r['user_code']}")
print(f"URL:  https://microsoft.com/devicelogin")

# Poll for token (v2.0 token endpoint)
dc=r['device_code']; iv=int(r['interval'])
t0=time.time()
while time.time()-t0<int(r['expires_in'])-10:
    time.sleep(iv)
    data=urllib.parse.urlencode({
        'client_id':CLIENT_ID,
        'scope':SCOPES,
        'grant_type':'urn:ietf:params:oauth:grant-type:device_code',
        'code':dc
    }).encode()
    req=urllib.request.Request(
        'https://login.microsoftonline.com/common/oauth2/v2.0/token',
        data=data,
        headers={'Content-Type':'application/x-www-form-urlencoded'}
    )
    try:
        tr=json.loads(urllib.request.urlopen(req).read())
        tr['expires_on']=time.time()+int(tr.get('expires_in',3600))
        os.makedirs(os.path.dirname(TF),exist_ok=True)
        with open(TF,'w') as f: json.dump(tr,f)
        print(f'\nAUTH OK! Scopes: {tr.get("scope","")}')
        exit(0)
    except urllib.error.HTTPError as e:
        err=json.loads(e.read())
        if err.get('error')=='authorization_pending':
            print(f'\rT-{int(t0+int(r["expires_in"])-time.time())}s',end='',flush=True)
        else:
            print(f'\nERR: {err.get("error")}: {err.get("error_description","")[:150]}')
            exit(1)
```

**Key differences from earlier attempts:**
- Uses `v2.0/devicecode` and `v2.0/token` endpoints (NOT v1.0)
- Uses `scope` parameter instead of `resource` — gives correct Graph audience
- PowerShell client ID has `Mail.ReadWrite` + `Mail.Send` pre-consented in most tenants
- Returns access token with correct `scope: Mail.ReadWrite Mail.Send`

### Sender Account
- **Email:** zirconia@aegisc.space
- **Name:** Jason Brodsky, Director of External Affairs
- **Provider:** GoDaddy Microsoft 365
- **SMTP Auth:** ENABLED
- **DNS:** SPF/DKIM/DMARC active (fixed July 13)

### Fallback Client IDs (if PowerShell doesn't work)
- Azure CLI: `04b07795-8ddb-461a-bbee-02f9e1bf7b46` (uses `resource`, not `scope`)
- Azure PowerShell: `1950a258-227b-4e31-a9cf-717495945fc2`

---

## SENDING PIPELINE (Once Authenticated)

### 5-Step Send Process
```
1. CREATE DRAFT    → POST /me/messages
2. UPLOAD PDF 1    → POST /me/messages/{id}/attachments/createUploadSession
3. UPLOAD PDF 2    → PUT {uploadUrl}
4. UPLOAD PDF 3-4  → PUT {uploadUrl}
5. SEND DRAFT      → POST /me/messages/{id}/send
```

### After EVERY 5 sends:
1. Check Sent folder: `GET /me/mailFolders/sentitems/messages?$top=5`
2. Check Inbox for bounces: search for "undeliverable"
3. Log bounces to `SEND-STATE.md`

---

## CAMPAIGN STATE — July 18, 2026 22:12Z

| Batch | Sector | Count | Status |
|---|---|---|---|
| BATCH-01 | Insurance/Reinsurance | 7 | SENT ✓ |
| BATCH-02 | Energy/Utilities | 4 | SENT ✓ (NRECA body-only needs PDF follow-up) |
| BATCH-03 | Govt/Emergency | 5 | SENT ✓ (CISA body-only needs PDF follow-up) |
| BATCH-04 | Aerospace/Defense | 4 | SENT ✓ (bounced pre-DNS fix July 12, DNS fixed July 13) |
| BATCH-05 | Marine/Maritime | 16 | E034-E035 SENT | E036-E041 PENDING |
| BATCH-06 | Data/Telecom | 16 | PENDING |
| BATCH-07 | National Outreach | 18 | PENDING |
| BATCH-08 | Global Outreach | 160 | PENDING (compendiums) |
| BATCH-09 | Community/Specialist | 20 | PENDING |
| BATCH-10 | Cleantech/Energy | 8 | PENDING |
| BATCH-11 | Aerospace/Space | 5 | PENDING |
| BATCH-12 | Manufacturing/Materials | 8 | PENDING |
| BATCH-13 | Major Corporations | 17 | PENDING |
| BATCH-14 | Automotive/Transportation | 15 | PENDING |
| BATCH-15 | Infrastructure/Safety | 27 | PENDING |
| BATCH-16 | Untapped Sectors | 28 | PENDING |
| BATCH-17 | Consumer/Robotics/Materials | 25 | PENDING |
| **TOTAL** | | **383** | **~40 sent, ~343 ready** |
| + CSMEval | Compendiums 01-40 | 40 | 39 created, 01 pending |

### Start Sending Order
1. First: E036-E041 (BATCH-05 remaining — 6 emails)
2. Then: BATCH-06 through BATCH-15 in order (280+ emails)

### PDFs for Attachments (in ATTACHMENTS/ folder)
- CSMEval11-COMPILED-Briefing-Packet.pdf (45KB)
- CSMGeneralOutreach-COMPILED-Compendium.pdf (92KB)
- COMPENDIUM-MINI.pdf (36KB)
- CSMEval19-COMPILED-Briefing-Packet.pdf (5.4KB in /tmp/)

### Bounced/Archived
- 33 pre-V4 originals archived in `basketballs/`
- 12 bounced domain-block (now fixed with DNS)
- Recovery SOP at `CSMSOPP/STARLIGHT/MODULE-V2/M03-RECOVERY-PROTOCOL.md`

---

## KEY FILES TO READ FIRST
1. `CSMEmailOutgoing/July2026/SEND-STATE.md` — canonical bounce/delivery tracking
2. `CSMEmailOutgoing/July2026/SESSION-HANDOFF.md` — previous session handoff
3. `CSMGen/CommsLogs/July2026/` — all operational logs
4. `/tmp/agent_b070cda1-9dc3-4a92-9de9-aa529a6b10a9/csm_sender.py` — Python sender script

---

*Handoff prepared July 18, 2026 by AI Scribe under direction of Jason Brodsky of California*