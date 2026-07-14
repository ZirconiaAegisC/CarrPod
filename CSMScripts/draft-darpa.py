#!/usr/bin/env python3
"""
Draft DARPA Email — creates M365 draft with 3 PDFs via Graph API device-code auth.
Usage: python3 CSMScripts/draft-darpa.py [--send]
"""

import json, base64, os, re, time, sys, urllib.request, urllib.parse, urllib.error

CLIENT_ID = "14b2d65b-4dd7-4ea0-9a36-2b39cba11a3e"
SCOPES = ["Mail.Send", "Mail.ReadWrite", "offline_access"]
TOKEN_FILE = "/tmp/agent_e8425ffd-fb8e-49e3-a43c-6919e4cfad60/csm_token.json"

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
ATTACH = os.path.join(BASE, "CSMEmailOutgoing", "July2026", "ATTACHMENTS")
EMAIL_FILE = os.path.join(BASE, "CSMEmailOutgoing", "July2026", "BATCH-04-Aerospace-Defense", "E026-DARPA-Defense-Sciences.md")

PDFS = [
    os.path.join(ATTACH, "CSMEval11-COMPILED-Briefing-Packet.pdf"),
    os.path.join(ATTACH, "CSMGeneralOutreach-COMPILED-Compendium.pdf"),
    os.path.join(ATTACH, "COMPENDIUM-MINI.pdf"),
]

# ─── AUTH ────────────────────────────────────────────────────

def graph_call(method, endpoint, token, body=None):
    url = f"https://graph.microsoft.com/v1.0/{endpoint}"
    data = json.dumps(body).encode() if body else None
    headers = {"Authorization": f"Bearer {token}", "Content-Type": "application/json"}
    req = urllib.request.Request(url, data=data, method=method, headers=headers)
    try:
        resp = urllib.request.urlopen(req)
        ct = resp.headers.get("Content-Type", "")
        raw = resp.read()
        if raw and "json" in ct:
            return json.loads(raw)
        return raw.decode() if raw else None
    except urllib.error.HTTPError as e:
        err = e.read().decode() if e.fp else str(e)
        print(f"  [!] HTTP {e.code}: {err[:300]}")
        raise

def get_token():
    if os.path.exists(TOKEN_FILE):
        with open(TOKEN_FILE) as f:
            td = json.load(f)
        if "refresh_token" in td:
            try:
                data = urllib.parse.urlencode({
                    "client_id": CLIENT_ID,
                    "grant_type": "refresh_token",
                    "refresh_token": td["refresh_token"],
                }).encode()
                req = urllib.request.Request(
                    "https://login.microsoftonline.com/common/oauth2/v2.0/token",
                    data=data,
                    headers={"Content-Type": "application/x-www-form-urlencoded"}
                )
                resp = json.loads(urllib.request.urlopen(req).read())
                if "access_token" in resp:
                    resp["refresh_token"] = td.get("refresh_token", resp.get("refresh_token"))
                    with open(TOKEN_FILE, "w") as f:
                        json.dump(resp, f)
                    return resp["access_token"]
            except:
                pass
    # Device code
    dc_url = "https://login.microsoftonline.com/common/oauth2/v2.0/devicecode"
    dc_data = urllib.parse.urlencode({"client_id": CLIENT_ID, "scope": " ".join(SCOPES)}).encode()
    req = urllib.request.Request(dc_url, data=dc_data, headers={"Content-Type": "application/x-www-form-urlencoded"})
    dc = json.loads(urllib.request.urlopen(req).read())

    print("\n" + "="*60)
    print("  M365 AUTHENTICATION REQUIRED")
    print("="*60)
    print(f"\n  {dc['message']}\n")
    print(f"  URL:  {dc['verification_uri']}")
    print(f"  CODE: {dc['user_code']}")
    print("\n  Open the URL, enter the code, sign in with your M365 account.")
    print("  Waiting 120 seconds...\n")

    token_url = "https://login.microsoftonline.com/common/oauth2/v2.0/token"
    start = time.time()
    while time.time() - start < 120:
        time.sleep(5)
        data = urllib.parse.urlencode({
            "client_id": CLIENT_ID,
            "grant_type": "urn:ietf:params:oauth:grant-type:device_code",
            "device_code": dc["device_code"],
        }).encode()
        req = urllib.request.Request(token_url, data=data, headers={"Content-Type": "application/x-www-form-urlencoded"})
        try:
            resp = json.loads(urllib.request.urlopen(req).read())
            if "access_token" in resp:
                with open(TOKEN_FILE, "w") as f:
                    json.dump(resp, f)
                print("  [OK] Authenticated!\n")
                return resp["access_token"]
            if resp.get("error") == "authorization_pending":
                print(f"  ... waiting ({(time.time()-start):.0f}s) ...", end="\r")
        except:
            pass
    raise TimeoutError("Authentication timed out.")

# ─── PARSE EMAIL ─────────────────────────────────────────────

def parse_md(filepath):
    with open(filepath) as f:
        content = f.read()
    subj = re.search(r'\*\*SUBJECT:\*\*\s*(.+)', content)
    to_match = re.search(r'\*\*TO:\*\*\s*(.+)', content)
    subject = subj.group(1).strip() if subj else "Carrington Storm Motors Outreach"

    # Convert to simple HTML
    lines = content.split('\n')
    html = ['<html><body style="font-family:Arial,sans-serif;font-size:14px;color:#222;">']
    for line in lines:
        if line.startswith('# ') or line.startswith('## ') or line.startswith('### '):
            lvl = len(re.match(r'^#+', line).group())
            html.append(f'<h{min(lvl+1,4)} style="color:#1a3a5c;">{line.lstrip("#").strip()}</h{min(lvl+1,4)}>')
        elif line.startswith('---') or line.startswith('==='):
            html.append('<hr style="border:1px solid #ddd;">')
        elif line.startswith('**') and '**' in line[2:]:
            html.append(f'<p><strong>{line.strip("*")}</strong></p>')
        elif line.strip().startswith('- ') or line.strip().startswith('• '):
            html.append(f'<li>{line.strip().lstrip("-• ")}</li>')
        elif line.strip().startswith('['):
            html.append(f'<p style="color:#555;font-style:italic;">{line.strip()}</p>')
        elif not line.strip():
            html.append('<br>')
        else:
            html.append(f'<p>{line}</p>')
    html.append(f'<br><p style="color:#666;font-size:12px;">-- Jason Brodsky<br>Director of External Affairs &amp; Strategic Partnerships<br>Carrington Storm Motors | Safe Pod Engineering Company<br>zirconia@aegisc.space</p>')
    html.append('</body></html>')
    return subject, '\n'.join(html)

# ─── PIPELINE ─────────────────────────────────────────────────

def create_draft(token, subject, body_html, to_addr=None):
    msg = {
        "subject": subject,
        "body": {"contentType": "html", "content": body_html},
    }
    if to_addr:
        msg["toRecipients"] = [{"emailAddress": {"address": to_addr}}]
    result = graph_call("POST", "me/messages", token, msg)
    print(f"  [1/5] Draft created: {result['id']}")
    return result["id"]

def add_attachment_file(token, msg_id, filepath):
    filename = os.path.basename(filepath)
    with open(filepath, "rb") as f:
        b64 = base64.b64encode(f.read()).decode()
    body = {
        "@odata.type": "#microsoft.graph.fileAttachment",
        "name": filename,
        "contentBytes": b64,
    }
    graph_call("POST", f"me/messages/{msg_id}/attachments", token, body)
    size = os.path.getsize(filepath)
    print(f"  [ATTACH] {filename} ({size//1024} KB) -> DONE")

def send_draft(token, msg_id):
    url = f"https://graph.microsoft.com/v1.0/me/messages/{msg_id}/send"
    req = urllib.request.Request(url, data=b"", method="POST", headers={"Authorization": f"Bearer {token}"})
    urllib.request.urlopen(req)
    print("  [5/5] SENT")

# ─── MAIN ─────────────────────────────────────────────────────

def main():
    do_send = "--send" in sys.argv

    print("CSM DARPA Draft Creator — Graph API Pipeline")
    print(f"Email: {os.path.basename(EMAIL_FILE)}")
    for i, p in enumerate(PDFS, 1):
        exists = "OK" if os.path.exists(p) else "MISSING"
        size = os.path.getsize(p) if os.path.exists(p) else 0
        print(f"  PDF {i}: {os.path.basename(p)} ({size//1024} KB) [{exists}]")

    if any(not os.path.exists(p) for p in PDFS):
        print("\n[ERROR] Missing PDF attachments. Cannot proceed.")
        sys.exit(1)

    print("\nParsing email body...")
    subject, html_body = parse_md(EMAIL_FILE)
    print(f"  Subject: {subject[:100]}...")
    print(f"  Body: {len(html_body)} chars")

    print("\nAuthenticating...")
    token = get_token()

    print("\nCreating draft (no recipient — will place in Drafts folder)...")
    draft_id = create_draft(token, subject, html_body)

    print("\nAttaching PDFs...")
    for p in PDFS:
        add_attachment_file(token, draft_id, p)

    if do_send:
        print("\nSending draft...")
        send_draft(token, draft_id)
    else:
        print(f"\n[OK] Draft ready in M365 Drafts folder.")
        print(f"     Draft ID: {draft_id}")
        print(f"     To send: python3 CSMScripts/draft-darpa.py --send")

if __name__ == "__main__":
    main()
