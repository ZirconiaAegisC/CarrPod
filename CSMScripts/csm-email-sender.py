#!/usr/bin/env python3
"""
CSM Email Sender — Carrington Storm Motors Outreach Campaign
=============================================================
Sends handcrafted emails with attachments through Microsoft Graph API.
Authentication via OAuth2 device-code flow (interactive login required once).
All 9 batches supported. Sends sequentially with rate-limit pacing.
Logs every send to SENT-LOG.md in each batch folder.

Usage:
    python3 csm-email-sender.py --test
    python3 csm-email-sender.py --batch 01
    python3 csm-email-sender.py --all

Author: Jason Brodsky (zirconia@aegisc.space)
Date: July 2026
"""

import json
import base64
import os
import re
import time
import glob
import urllib.request
import urllib.error
import datetime

# ─── CONFIGURATION ───────────────────────────────────────────────

CLIENT_ID = "14b2d65b-4dd7-4ea0-9a36-2b39cba11a3e"  # MS365 MCP default
SCOPES = ["Mail.Send", "Mail.ReadWrite", "offline_access"]
FROM_ADDRESS = "zirconia@aegisc.space"
FROM_NAME = "Jason Brodsky"
SENDER_SIGNATURE = "Director of External Affairs & Strategic Partnerships | Carrington Storm Motors | Safe Pod Engineering Company"

BASE_DIR = "CSMEmailOutgoing/July2026"
ATTACHMENTS_DIR = f"{BASE_DIR}/ATTACHMENTS"
BATCH_DIRS = sorted(glob.glob(f"{BASE_DIR}/BATCH-*/"))

# Rate limiting: max emails per minute (Microsoft throttles ~30/min for most plans)
SEND_DELAY_SECONDS = 2.5  # ~24 emails per minute — safe margin
TOKEN_FILE = os.path.expanduser("~/.csm_email_token.json")

# ─── AUTHENTICATION ──────────────────────────────────────────────

def get_device_code():
    """Get device code from Microsoft for OAuth2 device-code flow."""
    import urllib.parse
    url = f"https://login.microsoftonline.com/common/oauth2/v2.0/devicecode"
    data = urllib.parse.urlencode({
        "client_id": CLIENT_ID,
        "scope": " ".join(SCOPES)
    }).encode()
    req = urllib.request.Request(url, data=data, headers={"Content-Type": "application/x-www-form-urlencoded"})
    resp = urllib.request.urlopen(req)
    return json.loads(resp.read())

def poll_for_token(device_code, interval=5, timeout=120):
    """Poll Microsoft until user completes device-code login."""
    import urllib.parse
    url = "https://login.microsoftonline.com/common/oauth2/v2.0/token"
    start = time.time()
    while time.time() - start < timeout:
        time.sleep(interval)
        data = urllib.parse.urlencode({
            "client_id": CLIENT_ID,
            "grant_type": "urn:ietf:params:oauth:grant-type:device_code",
            "device_code": device_code,
        }).encode()
        req = urllib.request.Request(url, data=data, headers={"Content-Type": "application/x-www-form-urlencoded"})
        try:
            resp = json.loads(urllib.request.urlopen(req).read())
            if "access_token" in resp:
                return resp
            if resp.get("error") == "authorization_pending":
                print(f"  ... waiting ({(time.time()-start):.0f}s) ...", end="\r")
                continue
        except urllib.error.HTTPError:
            pass
    raise TimeoutError("Login timed out. Please try again.")

def load_token():
    """Load cached token from disk, refresh if expired."""
    if os.path.exists(TOKEN_FILE):
        with open(TOKEN_FILE) as f:
            token_data = json.load(f)
        # Refresh if expired or near expiry
        if "refresh_token" in token_data:
            import urllib.parse
            url = "https://login.microsoftonline.com/common/oauth2/v2.0/token"
            data = urllib.parse.urlencode({
                "client_id": CLIENT_ID,
                "grant_type": "refresh_token",
                "refresh_token": token_data["refresh_token"],
            }).encode()
            try:
                req = urllib.request.Request(url, data=data, headers={"Content-Type": "application/x-www-form-urlencoded"})
                resp = json.loads(urllib.request.urlopen(req).read())
                if "access_token" in resp:
                    resp["refresh_token"] = token_data.get("refresh_token", resp.get("refresh_token"))
                    with open(TOKEN_FILE, "w") as f:
                        json.dump(resp, f)
                    return resp["access_token"]
            except:
                pass
    return None

def authenticate():
    """Full OAuth2 device-code authentication flow."""
    token = load_token()
    if token:
        print("✓ Using cached/refreshed token")
        return token

    print("\n" + "=" * 72)
    print("  MICROSOFT 365 LOGIN REQUIRED")
    print("=" * 72)

    dc = get_device_code()
    print(f"\n  {dc['message']}\n")
    print(f"  URL: {dc['verification_uri']}")
    print(f"  CODE: {dc['user_code']}")
    print(f"\n  ← Open the URL above, enter the code, and sign in.")
    print(f"  This script will wait up to 120 seconds...")

    token_data = poll_for_token(dc["device_code"])
    with open(TOKEN_FILE, "w") as f:
        json.dump(token_data, f)
    print(f"\n✓ Authenticated successfully!")
    return token_data["access_token"]


# ─── GRAPH API HELPERS ───────────────────────────────────────────

def graph_post(token, endpoint, body_dict):
    """Send POST to Microsoft Graph API."""
    url = f"https://graph.microsoft.com/v1.0/{endpoint}"
    data = json.dumps(body_dict).encode()
    req = urllib.request.Request(url, data=data, method="POST", headers={
        "Authorization": f"Bearer {token}",
        "Content-Type": "application/json"
    })
    resp = urllib.request.urlopen(req)
    return json.loads(resp.read())

def create_draft(token, to_address, to_name, subject, body_html):
    """Create a draft message. Returns message ID."""
    msg = {
        "subject": subject,
        "body": {"contentType": "html", "content": body_html},
        "toRecipients": [{"emailAddress": {"address": to_address, "name": to_name}}],
        "from": {"emailAddress": {"address": FROM_ADDRESS, "name": FROM_NAME}}
    }
    result = graph_post(token, "me/messages", msg)
    return result["id"]

def add_attachment(token, message_id, file_path, file_name):
    """Add a file attachment to a draft message (base64)."""
    with open(file_path, "rb") as f:
        content_bytes = base64.b64encode(f.read()).decode()
    body = {
        "@odata.type": "#microsoft.graph.fileAttachment",
        "name": file_name,
        "contentBytes": content_bytes
    }
    return graph_post(token, f"me/messages/{message_id}/attachments", body)

def send_draft(token, message_id):
    """Send a draft message."""
    url = f"https://graph.microsoft.com/v1.0/me/messages/{message_id}/send"
    req = urllib.request.Request(url, data=b"", method="POST", headers={
        "Authorization": f"Bearer {token}",
        "Content-Type": "application/json"
    })
    try:
        urllib.request.urlopen(req)
        return True
    except urllib.error.HTTPError as e:
        print(f"  ✗ Send failed: {e.code} {e.reason}")
        return False


# ─── EMAIL PARSER ────────────────────────────────────────────────

def parse_email_file(filepath):
    """Parse a CSM email MD file into its components."""
    with open(filepath) as f:
        content = f.read()

    # Extract fields
    to_match = re.search(r'\*\*TO:\*\*\s*(.+)', content)
    subject_match = re.search(r'\*\*SUBJECT:\*\*\s*(.+)', content)
    attachment_match = re.search(r'ATTACHMENT:\s*([^\n]+)', content)

    # Extract HTML body from markdown (everything between --- markers after the header)
    body_parts = content.split('---')
    if len(body_parts) >= 2:
        body_text = '---'.join(body_parts[1:])
    else:
        body_text = content

    # Convert markdown body to simple HTML
    html_body = markdown_to_html(body_text)

    return {
        "to": to_match.group(1).strip() if to_match else "UNKNOWN",
        "subject": subject_match.group(1).strip() if subject_match else "Carrington Storm Motors Outreach",
        "body_html": html_body,
        "attachment_ref": attachment_match.group(1).strip() if attachment_match else None,
        "file": os.path.basename(filepath)
    }

def markdown_to_html(text):
    """Basic markdown-to-HTML conversion for email body."""
    lines = text.split('\n')
    html_lines = ['<html><body style="font-family:Arial,sans-serif;font-size:14px;color:#222;">']
    in_code = False

    for line in lines:
        # Headers
        if line.startswith('# ') or line.startswith('## ') or line.startswith('### '):
            level = len(re.match(r'^#+', line).group())
            content = line.lstrip('#').strip()
            tag = f"h{min(level+1, 4)}"
            html_lines.append(f'<{tag} style="color:#1a3a5c;">{content}</{tag}>')
        # Separators
        elif line.startswith('---') or line.startswith('==='):
            html_lines.append('<hr style="border:1px solid #ddd;">')
        # Bold markers
        elif line.startswith('**') and line.endswith('**'):
            html_lines.append(f'<p><strong>{line.strip("*")}</strong></p>')
        # List items
        elif line.strip().startswith('- ') or line.strip().startswith('• '):
            content = line.strip().lstrip('-• ').strip()
            html_lines.append(f'<li>{content}</li>')
        # Numbered items (KEY FACTS)
        elif re.match(r'^\d+\.', line.strip()):
            html_lines.append(f'<p>{line.strip()}</p>')
        # Blank lines
        elif not line.strip():
            html_lines.append('<br>')
        # Regular text
        else:
            html_lines.append(f'<p>{line}</p>')

    html_lines.append(f'<br><p style="color:#666;font-size:12px;">— {FROM_NAME}<br>{SENDER_SIGNATURE}<br>{FROM_ADDRESS}</p>')
    html_lines.append('</body></html>')
    return '\n'.join(html_lines)


# ─── ATTACHMENT RESOLVER ─────────────────────────────────────────

def resolve_attachment(email_data):
    """Given an email's attachment reference, return the correct file path."""
    ref = email_data.get("attachment_ref", "")
    if not ref:
        return None

    mapping = {
        "CSMEval11": f"{ATTACHMENTS_DIR}/CSMEval11-COMPILED-Briefing-Packet.md",
        "COMPILED-Briefing": f"{ATTACHMENTS_DIR}/CSMEval11-COMPILED-Briefing-Packet.md",
        "COMPILED-Briefing-Packet": f"{ATTACHMENTS_DIR}/CSMEval11-COMPILED-Briefing-Packet.md",
        "CSMGeneralOutreach-COMPILED": f"{ATTACHMENTS_DIR}/CSMGeneralOutreach-COMPILED-Compendium.md",
        "Global-Compendium": f"{ATTACHMENTS_DIR}/CSMGeneralOutreach-Global-Compendium.md",
        "Global-Compendium.md": f"{ATTACHMENTS_DIR}/CSMGeneralOutreach-Global-Compendium.md",
        "Compendium": f"{ATTACHMENTS_DIR}/CSMGeneralOutreach-COMPILED-Compendium.md",
    }

    for key, path in mapping.items():
        if key.lower() in ref.lower():
            return path

    # Default: try the Compendium
    if "global" in ref.lower():
        return f"{ATTACHMENTS_DIR}/CSMGeneralOutreach-Global-Compendium.md"
    return f"{ATTACHMENTS_DIR}/CSMGeneralOutreach-COMPILED-Compendium.md"


# ─── SEND ENGINE ─────────────────────────────────────────────────

def send_email(token, email_data, attachment_path=None, dry_run=False):
    """Send a single email with optional attachment. Returns True on success."""
    if dry_run:
        print(f"  [DRY RUN] TO: {email_data['to'][:80]}")
        print(f"           SUBJECT: {email_data['subject'][:80]}")
        print(f"           ATTACH: {os.path.basename(attachment_path) if attachment_path else 'none'}")
        return "DRY_RUN"

    try:
        # Step 1: Create draft
        draft_id = create_draft(
            token,
            "placeholder@example.com",  # Will be replaced with real address
            email_data.get("to", "Contact").split("—")[0].strip()[:50],
            email_data["subject"],
            email_data["body_html"]
        )

        # Step 2: Attach file (if applicable)
        if attachment_path and os.path.exists(attachment_path):
            add_attachment(token, draft_id, attachment_path, os.path.basename(attachment_path))

        # Step 3: Send
        send_draft(token, draft_id)
        return draft_id
    except Exception as e:
        raise


def send_batch(token, batch_dir, dry_run=False, recipient_map=None):
    """Send all emails in a batch directory."""
    batch_name = os.path.basename(batch_dir.rstrip('/'))
    email_files = sorted(glob.glob(f"{batch_dir}/E*.md"))
    log_entries = []

    print(f"\n{'='*72}")
    print(f"  BATCH: {batch_name}")
    print(f"  Emails: {len(email_files)}")
    print(f"{'='*72}\n")

    for i, email_file in enumerate(email_files, 1):
        email_data = parse_email_file(email_file)
        attachment_path = resolve_attachment(email_data)
        email_id = os.path.basename(email_file).replace('.md', '')

        # Resolve recipient if we have a real address
        to_addr = "placeholder@example.com"  # TODO: Replace with actual address
        to_name = email_data["to"][:100]

        print(f"  [{i}/{len(email_files)}] {email_id}")
        print(f"      TO: {to_name[:80]}")
        print(f"      SUBJECT: {email_data['subject'][:80]}")
        print(f"      ATTACH: {os.path.basename(attachment_path) if attachment_path else 'none'}")

        try:
            result = send_email(token, email_data, attachment_path, dry_run=dry_run)
            status = "SENT" if not dry_run else "DRY_RUN"
            log_entries.append(f"✓ {datetime.datetime.utcnow().isoformat()} | {status} | {email_id} | {to_name[:60]}")
            print(f"      ✓ {status}")

            if not dry_run and i < len(email_files):
                time.sleep(SEND_DELAY_SECONDS)

        except Exception as e:
            log_entries.append(f"✗ {datetime.datetime.utcnow().isoformat()} | FAILED | {email_id} | {str(e)[:100]}")
            print(f"      ✗ FAILED: {e}")

    # Write batch SENT-LOG
    log_path = f"{batch_dir}/SENT-LOG.md"
    with open(log_path, "w") as f:
        f.write(f"# {batch_name} — SENT LOG\n")
        f.write(f"## CSMEmailOutgoing | {datetime.datetime.utcnow().isoformat()}\n\n")
        f.write(f"Total: {len(email_files)} | Sent: {status_count(log_entries, 'SENT')} | Failed: {status_count(log_entries, 'FAILED')}\n\n")
        for entry in log_entries:
            f.write(f"{entry}\n")

    print(f"\n  ✓ {batch_name} complete. Log: {log_path}")


def status_count(entries, status):
    return sum(1 for e in entries if status in e)


# ─── MAIN ────────────────────────────────────────────────────────

def main():
    import sys

    args = sys.argv[1:]
    dry_run = "--dry-run" in args or "--test" in args
    test_mode = "--test" in args
    batch_arg = None
    do_all = "--all" in args

    for a in args:
        if a.startswith("--batch="):
            batch_arg = a.split("=")[1]
        elif a == "--batch":
            idx = args.index("--batch")
            if idx + 1 < len(args):
                batch_arg = args[idx + 1]

    print("\n" + "=" * 72)
    print("  CSM EMAIL SENDER — Carrington Storm Motors Outreach")
    print("  July 2026 | Jason Brodsky | zirconia@aegisc.space")
    print("=" * 72)

    # Authenticate
    token = authenticate()

    # Determine what to send
    if test_mode or dry_run:
        # Test: send first email from BATCH-01
        batch = f"{BASE_DIR}/BATCH-01-Insurance-Reinsurance"
        print(f"\n  *** TEST MODE {'(DRY RUN)' if dry_run else ''} ***")
        print(f"  Sending test email from {batch}")
        send_batch(token, batch, dry_run=True, recipient_map=None)
        if not dry_run:
            email_files = sorted(glob.glob(f"{batch}/E*.md"))
            if email_files:
                email_data = parse_email_file(email_files[0])
                attachment_path = resolve_attachment(email_data)
                send_email(token, email_data, attachment_path)
        print("\n  ✓ Test complete.")

    elif batch_arg:
        batch = f"{BASE_DIR}/BATCH-{batch_arg.zfill(2)}*"
        matches = glob.glob(batch)
        if matches:
            send_batch(token, matches[0], dry_run=dry_run)
        else:
            print(f"  ✗ Batch {batch_arg} not found.")

    elif do_all:
        for batch_dir in BATCH_DIRS:
            send_batch(token, batch_dir, dry_run=dry_run)
            print(f"  Cool-down: 10 seconds...")
            time.sleep(10)

    else:
        print("\n  Usage:")
        print("    python3 csm-email-sender.py --test          # Dry-run test of first email")
        print("    python3 csm-email-sender.py --batch 01     # Send batch 01")
        print("    python3 csm-email-sender.py --batch 01 --dry-run  # Preview batch 01")
        print("    python3 csm-email-sender.py --all          # Send ALL batches")
        print("\n  (No action taken. Add --test, --batch NN, or --all)")

if __name__ == "__main__":
    main()
