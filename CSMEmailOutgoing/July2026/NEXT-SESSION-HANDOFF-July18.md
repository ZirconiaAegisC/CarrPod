# CSM EMAIL CAMPAIGN — NEXT-SESSION HANDOFF
## 2026-07-18 | 330 V4 Emails Ready — 15 Batches on GitHub Main

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
CSMEmailOutgoing/July2026/SESSION-HANDOFF.md to understand 
where we left off in the email campaign. There are 330 
ready-to-send V4 Fun-Williams emails across 15 batches 
in CSMEmailOutgoing/July2026/ on GitHub main. We need to 
authenticate to Microsoft 365 and begin sending."
```

---

## M365 AUTHENTICATION — WHAT WE KNOW

### Sender Account
- **Email:** zirconia@aegisc.space
- **Name:** Jason Brodsky, Director of External Affairs, Carrington Storm Motors
- **Provider:** GoDaddy Microsoft 365
- **SMTP Auth:** ENABLED (toggled in GoDaddy Admin on July 17)
- **DNS:** SPF/DKIM/DMARC all active (fixed July 13)

### Python Device Code Auth (THIS IS WHAT WORKED)
The most successful auth method was a Python script using the Azure CLI client ID during the July 17 session. The script is at:

```
/tmp/agent_b070cda1-9dc3-4a92-9de9-aa529a6b10a9/csm_sender.py
```

**Tell the agent to run:**
```
python3 -c "
import urllib.request,urllib.parse,json,time,os,tempfile
CLIENT_ID='04b07795-8ddb-461a-bbee-02f9e1bf7b46'; TF=os.path.join(tempfile.gettempdir(),'csm_sender_token.json')
data=urllib.parse.urlencode({'client_id':CLIENT_ID,'resource':'https://graph.microsoft.com'}).encode()
req=urllib.request.Request('https://login.microsoftonline.com/common/oauth2/devicecode?api-version=1.0',data=data)
req.add_header('Content-Type','application/x-www-form-urlencoded')
r=json.loads(urllib.request.urlopen(req).read())
code=r['user_code']; dc=r['device_code']; iv=int(r['interval']); exp=int(r['expires_in'])
print(f'CODE: {code}')
print(f'URL:  https://microsoft.com/devicelogin')
print(f'Timer: {int(exp/60)}min')
t0=time.time()
while time.time()-t0<exp-5:
    time.sleep(iv)
    data=urllib.parse.urlencode({'client_id':CLIENT_ID,'resource':'https://graph.microsoft.com','grant_type':'urn:ietf:params:oauth:grant-type:device_code','code':dc}).encode()
    req=urllib.request.Request('https://login.microsoftonline.com/common/oauth2/token?api-version=1.0',data=data)
    req.add_header('Content-Type','application/x-www-form-urlencoded')
    try:
        tr=json.loads(urllib.request.urlopen(req).read())
        tr['expires_on']=time.time()+int(tr.get('expires_in',3600))
        os.makedirs(os.path.dirname(TF),exist_ok=True)
        with open(TF,'w') as f: json.dump(tr,f)
        print(f'\\nAUTH OK! {tr.get(\"expires_in\")}s')
        exit(0)
    except urllib.error.HTTPError as e:
        err=json.loads(e.read())
        if err.get('error')=='authorization_pending': print(f'\\rT-{int(t0+exp-time.time())}s',end='',flush=True)
        else: print(f'\\nERR: {err.get(\"error\",\"\")}'); exit(1)
"
```

**When you get a code:**
1. Open a PRIVATE/INCOGNITO browser window
2. Go to https://microsoft.com/devicelogin
3. Enter the code shown on screen
4. Sign in as zirconia@aegisc.space
5. Approve any MFA push on your Microsoft Authenticator phone app
6. The script auto-detects success and caches the token

### What DIDN'T Work
- `m365-graph_login` tool — device code flow, same issue
- `npx @softeria/ms-365-mcp-server --login` — hung/needed TUI interaction
- The MCP server's built-in client ID — may need admin consent in GoDaddy tenant

### SMTP Fallback (Plan B)
If Graph API auth keeps failing:
- Server: smtp.office365.com, Port: 587, STARTTLS
- The user can share the password with the agent in-chat (not saved to files)
- Python smtplib can send directly without OAuth
- Downside: no draft inspection, but BCC to self for verification

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

## CAMPAIGN STATE — July 18, 2026

| Batch | Sector | Count | Status |
|---|---|---|---|
| BATCH-01 | Insurance/Reinsurance | 7 | SENT ✓ |
| BATCH-02 | Energy/Utilities | 4 | SENT ✓ (NRECA body-only, needs PDF follow-up) |
| BATCH-03 | Govt/Emergency | 5 | SENT ✓ (CISA body-only, needs PDF follow-up) |
| BATCH-04 | Aerospace/Defense | 4 | SENT ✓ (bounced pre-DNS, some resent) |
| BATCH-05 | Marine/Maritime | 16 | E034-E035 SENT | E036-E041 READY |
| BATCH-06 | Data/Telecom | 16 | READY |
| BATCH-07 | National Outreach | 18 | READY |
| BATCH-08 | Global Outreach | 160 | READY (compendiums) |
| BATCH-09 | Community/Specialist | 20 | READY |
| BATCH-10 | Cleantech/Energy | 8 | READY |
| BATCH-11 | Aerospace/Space | 5 | READY |
| BATCH-12 | Manufacturing/Materials | 8 | READY |
| BATCH-13 | Major Corporations | 17 | READY |
| BATCH-14 | Automotive/Transportation | 15 | READY |
| BATCH-15 | Infrastructure/Safety | 27 | READY |
| **TOTAL** | | **330** | **~40 sent, ~290 ready** |

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