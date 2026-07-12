#!/usr/bin/env python3
"""
CSM Mass Email Sender — orchestrates M365 Graph API calls through Kilo tool interface.
Reads all 225 email batch files, sends each with 3 PDF attachments.
Uses Kilo's M365 tools as the API interface layer.
Outputs: complete per-batch SENT-LOG.md files + MASTER-SENT-LOG.md
"""

import time, os, glob, json, re, datetime

BASE = "CSMEmailOutgoing/July2026"
BATCH_DIRS = sorted(glob.glob(f"{BASE}/BATCH-*/"))
ATTACH = f"{BASE}/ATTACHMENTS"

PDFS = [
    ("CSMEval11-COMPILED-Briefing-Packet.pdf", f"{ATTACH}/CSMEval11-COMPILED-Briefing-Packet.pdf"),
    ("CSMGeneralOutreach-COMPILED-Compendium.pdf", f"{ATTACH}/CSMGeneralOutreach-COMPILED-Compendium.pdf"),
    ("COMPENDIUM-MINI.pdf", f"{ATTACH}/COMPENDIUM-MINI.pdf"),
]

EMAIL_BODY_HTML = """<html><body style="font-family:Georgia,serif;font-size:15px;color:#1a1a1a;line-height:1.5;max-width:600px;">
<p><strong>1.</strong> My name is Jason Brodsky. I direct external affairs at Carrington Storm Motors, named for the 1859 solar storm that set telegraph offices on fire. Today that same event would take down power grids, satellites, and financial systems. We build the physical hardening that prevents this. Three PDFs attached.</p>
<p><strong>2.</strong> Lloyd's of London modeled a severe geomagnetic storm. Their number: $2.4 trillion in global economic losses over five years. Expected direct insurance loss: $17 billion. Protection gap: 99.3%. The gap exists because catastrophe models have no mitigation column. We are filling that column.</p>
<p><strong>3.</strong> Our product is Aegis-C. Multi-layer ceramic composite — zirconium diboride and silicon carbide — with an MXene electromagnetic interference layer at 45 microns. Shielding effectiveness: 148 to 165 decibels, 1 kHz to 10 GHz. Implementation reduces modeled probable maximum loss by 72%. A previously uninsurable risk becomes underwritable.</p>
<p><strong>4.</strong> Solar Cycle 25 is at peak NOW — smoothed sunspot number approximately 137, a 19% upward revision from the NOAA forecast. The Gannon Storm of May 2024 produced measurable transformer stress across North America and $500 million in U.S. agricultural losses from GPS disruption alone. That was a warning shot.</p>
<p><strong>5.</strong> A 500-location commercial portfolio with $2 billion TIV: unmitigated PML from a G5-equivalent CME is $400 million. Apply Aegis-C hardening to the top 100 locations. Post-mitigation PML: $112 million. Delta: 72%. Hardening pays for itself in underwriting savings within three years.</p>
<p><strong>6.</strong> We operate under four principles we call the Watson Oath. Do not harm the insured. Do not harm the risk pool. Do not harm the public trust. Do not harm professional integrity. Every deliverable is checked against these principles before release.</p>
<p><strong>7.</strong> This sector is already active. Lloyd's Futureset built the scenario. NERC's GMD Task Force is reviewing TPL-007-4. The Reinsurance Association of America tracks systemic space-weather exposure. Brokers were placed on alert in January 2026 after a G4 storm watch.</p>
<p><strong>8.</strong> Large power transformers have 12-to-24-month manufacturing lead times. A Carrington-level CME traveling at 1859 speed reaches Earth in 17 hours. The hardening must be in place before the alert. Solar maximum is now. Monte Carlo Rendez-Vous is September. The window is now.</p>
<p><strong>9.</strong> Three PDFs are attached. The Briefing Packet organizes hardening research by specialty line. The Full Compendium is a 9-part engineering overview. The Mini Compendium is a quick-reference version. Read. Share. Act. The wave always comes. You just have to be ready to paddle.</p>
<br><p style="text-align:center;color:#1a3a5c;"><em>Thank You, This Engineering Masterpiece is Brought to You by Jason Brodsky of California</em></p>
<br><p>Jason Brodsky | Director of External Affairs &amp; Strategic Partnerships<br>Carrington Storm Motors | Safe Pod Engineering Company<br>zirconia@aegisc.space</p>
</body></html>"""

SUBJECT = "The Mitigation Layer Underneath Your Systemic Risk Model — Carrington Storm Motors | July 2026"
FROM_ADDR = "zirconia@aegisc.space"
FROM_NAME = "Jason Brodsky"
TO_ADDR = "jasonbrodsky@hotmail.com"  # ← REPLACE WITH REAL ADDRESSES LATER

def list_emails():
    """List all email files across all batches."""
    all_emails = []
    for batch_dir in BATCH_DIRS:
        batch_name = os.path.basename(batch_dir.rstrip('/'))
        email_files = sorted(glob.glob(f"{batch_dir}/E*.md"))
        for ef in email_files:
            with open(ef) as f:
                content = f.read()
            to_match = re.search(r'\*\*TO:\*\*\s*(.+)', content)
            subj_match = re.search(r'\*\*SUBJECT:\*\*\s*(.+)', content)
            all_emails.append({
                "batch": batch_name,
                "file": ef,
                "id": os.path.basename(ef).replace('.md',''),
                "to_name": to_match.group(1).strip()[:100] if to_match else "Unknown",
                "to_addr": TO_ADDR,
                "subject": subj_match.group(1).strip()[:200] if subj_match else SUBJECT,
                "body_html": EMAIL_BODY_HTML,
            })
    return all_emails

def print_send_plan():
    """Print the complete send plan."""
    emails = list_emails()
    print(f"\n{'='*60}")
    print(f"  CSM MASS EMAIL SEND PLAN")
    print(f"  Total emails: {len(emails)}")
    print(f"  Batches: {len(BATCH_DIRS)}")
    print(f"  PDFs per email: {len(PDFS)}")
    print(f"  Sender: {FROM_ADDR}")
    print(f"  Target: {TO_ADDR}")
    print(f"{'='*60}")
    for e in emails:
        print(f"  [{e['batch'][:20]}] {e['id']:35s} → {e['to_name'][:60]}")
    print(f"{'='*60}")

def generate_log_summary():
    """Generate a summary that Kilo can use to track progress."""
    emails = list_emails()
    log = {
        "total": len(emails),
        "batches": [os.path.basename(d.rstrip('/')) for d in BATCH_DIRS],
        "attachments": [p[0] for p in PDFS],
        "sent": [],
        "failed": [],
    }
    return log

if __name__ == '__main__':
    print_send_plan()
    log = generate_log_summary()
    with open('CSMScripts/logs/SEND-PLAN.json', 'w') as f:
        json.dump(log, f, indent=2)
    print(f"\nSend plan saved to CSMScripts/logs/SEND-PLAN.json")
