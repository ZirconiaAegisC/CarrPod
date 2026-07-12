#!/usr/bin/env python3
"""
AEGIS BATCH EMAIL SENDER — Starlight SOP Pipeline
==================================================
For use within Kilo MCP environment. This script generates the MCP function calls
as JSON instruction files. Kilo (the orchestrator) reads these files and executes
the MCP tools in sequence.

SOP: CSMSOPP000004-STARLIGHT — 5-step pipeline:
  1. Chalk the shoes: Create draft
  2-4. Upload 3 PDFs via upload sessions (sequential, immediate)
  5. Curtain: Send draft

Output: SEND-STATE.md updated after each batch.
"""
import json, os, re, glob, datetime, sys, urllib.request, urllib.error

BASE = "CSMEmailOutgoing/July2026"
ATTACH = f"{BASE}/ATTACHMENTS"
SEND_STATE_PATH = f"{BASE}/SEND-STATE.md"
FROM_ADDR = "zirconia@aegisc.space"
FROM_NAME = "Jason Brodsky"
SENDER_SIG = "Director of External Affairs & Strategic Partnerships | Carrington Storm Motors | Safe Pod Engineering Company"

PDFS = [
    ("CSMEval11-COMPILED-Briefing-Packet.pdf", f"{ATTACH}/CSMEval11-COMPILED-Briefing-Packet.pdf"),
    ("CSMGeneralOutreach-COMPILED-Compendium.pdf", f"{ATTACH}/CSMGeneralOutreach-COMPILED-Compendium.pdf"),
    ("COMPENDIUM-MINI.pdf", f"{ATTACH}/COMPENDIUM-MINI.pdf"),
]

# All emails go to this test address until real addresses are verified
TO_ADDR = "jasonbrodsky@hotmail.com"
TO_NAME = "Jason Brodsky"

def parse_email_md(filepath):
    """Extract subject and body from a CSM email MD file."""
    with open(filepath) as f:
        content = f.read()
    
    subj_match = re.search(r'\*\*SUBJECT:\*\*\s*(.+)', content)
    subject = subj_match.group(1).strip() if subj_match else "Carrington Storm Motors | July 2026"
    
    # Extract the body — everything between the first --- and the last ---
    # The email MD has: header → --- → Williams meta → --- → core deliverable → --- → signature
    parts = content.split('---')
    body_html = build_html_body(parts, subject)
    
    return {"subject": subject, "body_html": body_html}

def build_html_body(parts, subject):
    """Convert MD email body to styled HTML."""
    body = '<html><body style="font-family:Arial,sans-serif;font-size:14px;color:#222;max-width:600px;">'
    
    # Core deliverable is in parts[2] (the section between second and third ---)
    core = parts[2] if len(parts) > 2 else '\n'.join(parts[1:])
    
    for line in core.strip().split('\n'):
        stripped = line.strip()
        if stripped.startswith('KEY FACTS:') or stripped.startswith('Key Facts:'):
            body += f'<p><strong>{stripped}</strong></p>'
        elif re.match(r'^\d+\.', stripped):
            body += f'<p>{stripped}</p>'
        elif stripped.startswith('ATTACHMENT:') or stripped.startswith('NEXT STEP:'):
            body += f'<p><strong>{stripped}</strong></p>'
        elif stripped.startswith('Dear '):
            body += f'<p>{stripped}</p>'
        elif re.match(r'^[-•]', stripped):
            body += f'<li>{stripped.lstrip("-• ")}</li>'
        elif not stripped:
            body += '<br>'
        else:
            body += f'<p>{stripped}</p>'
    
    body += f'<br><p style="color:#666;font-size:12px;">— {FROM_NAME}<br>{SENDER_SIG}<br>{FROM_ADDR}</p>'
    body += '</body></html>'
    return body

def list_pending_emails(batch_dir=None):
    """List emails NOT yet in SEND-STATE.md as fully sent."""
    # Parse SEND-STATE to find what's been sent
    sent_ids = set()
    if os.path.exists(SEND_STATE_PATH):
        with open(SEND_STATE_PATH) as f:
            for line in f:
                m = re.match(r'\|\s*(\S+)\s*\|', line)
                if m and '✅' in line:
                    sent_ids.add(m.group(1))
    
    batch_dirs = [batch_dir] if batch_dir else sorted(glob.glob(f"{BASE}/BATCH-*/"))
    
    pending = []
    for bd in batch_dirs:
        if not os.path.isdir(bd):
            continue
        batch_name = os.path.basename(bd)
        for ef in sorted(glob.glob(f"{bd}/E*.md")):
            eid = os.path.basename(ef).replace('.md','')
            if eid not in sent_ids:
                data = parse_email_md(ef)
                data["batch"] = batch_name
                data["file"] = ef
                data["id"] = eid
                pending.append(data)
    
    return pending

def generate_mcp_sequence(email_data, draft_msg_id=None):
    """Generate the sequence of MCP calls needed for one email.
    Returns a list of JSON objects representing tool calls.
    """
    calls = []
    
    # Step 1: Create Draft
    calls.append({
        "step": 1, "tool": "ms365_create-draft-email", "label": "Chalk the shoes",
        "body": {
            "subject": email_data["subject"],
            "toRecipients": [{"emailAddress": {"address": TO_ADDR, "name": TO_NAME}}],
            "body": {"contentType": "html", "content": email_data["body_html"]}
        }
    })
    
    # Steps 2-4: Upload each PDF
    for i, (pdf_name, pdf_path) in enumerate(PDFS):
        pdf_size = os.path.getsize(pdf_path)
        calls.append({
            "step": 2 + i,
            "tool": "ms365_create-mail-attachment-upload-session",
            "label": f"Upload {pdf_name}",
            "body": {"AttachmentItem": {"attachmentType": "file", "name": pdf_name, "size": pdf_size}},
            "upload_file": pdf_path,
            "upload_size": pdf_size
        })
    
    # Step 5: Send
    calls.append({
        "step": 5, "tool": "ms365_send-draft-message", "label": "Curtain",
        "needs_messageId": True
    })
    
    return calls

if __name__ == "__main__":
    if "--list" in sys.argv:
        pending = list_pending_emails()
        print(f"\nPENDING EMAILS: {len(pending)}")
        for p in pending:
            print(f"\n  [{p['batch']}] {p['id']}")
            print(f"    Subject: {p['subject'][:80]}")
    
    elif "--generate" in sys.argv:
        # Generate MCP call sequence for first pending email
        pending = list_pending_emails()
        if pending:
            email = pending[0]
            seq = generate_mcp_sequence(email)
            print(json.dumps(seq, indent=2))
    
    elif "--batch" in sys.argv:
        batch_num = None
        for a in sys.argv:
            if a.startswith("--batch="):
                batch_num = a.split("=")[1]
        
        if batch_num:
            batch_dir = f"{BASE}/BATCH-{batch_num.zfill(2)}*"
            matches = sorted(glob.glob(batch_dir))
            if matches:
                pending = list_pending_emails(matches[0])
                print(json.dumps({"pending_count": len(pending), "batch_name": os.path.basename(matches[0])}))
    
    else:
        pending = list_pending_emails()
        print(f"\nAEGIS BATCH SENDER")
        print(f"Pending emails: {len(pending)}")
        print(f"PDFs: {len(PDFS)}")
        print(f"Target: {TO_ADDR}")
        print(f"\nUsage:")
        print(f"  --list         List all pending emails")
        print(f"  --generate     Generate MCP sequence for next pending email")
        print(f"  --batch NN     Info about batch NN")
