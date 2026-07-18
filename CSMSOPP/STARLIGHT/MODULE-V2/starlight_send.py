#!/usr/bin/env python3
"""
STARLIGHT COURIER — AEGIS Email Batch Sender
═══════════════════════════════════════════════════════
CSMSOPP000004 · Starlight Courier Heuristic
MD→HTML via pandoc · 3-PDF attachments · Human pacing

DEPENDENCIES:
  pip3 install packages: (none — stdlib only)
  system: pandoc (apt-get install pandoc)

USAGE:
  # Test an email to yourself first:
  python3 starlight_send.py --test --batch BATCH-05 --email E036
  
  # Send a full batch with human pacing:
  python3 starlight_send.py --batch BATCH-06
  
  # Send a single email:
  python3 starlight_send.py --batch BATCH-06 --email E042

TOKEN: place at /tmp/starlight_token.json
  {"access_token":"...","expires_on":...}
"""

import subprocess, json, os, urllib.request, urllib.parse, base64, re, time, random, sys, argparse

# ─── CONFIG ────────────────────────────────────────────
TOKEN_PATH = '/tmp/agent_66c9dc83-0ae4-46ee-9f4d-67ca2d344f74/csm_token.json'
WORKSPACE  = '/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_66c9dc83-0ae4-46ee-9f4d-67ca2d344f74'
ATTACH_DIR = os.path.join(WORKSPACE, 'CSMEmailOutgoing', 'July2026', 'ATTACHMENTS')
BATCH_ROOT = os.path.join(WORKSPACE, 'CSMEmailOutgoing', 'July2026')
GRAPH_BASE = 'https://graph.microsoft.com/v1.0'
SENDER_EMAIL = 'zirconia@aegisc.space'

ATTACHMENT_PDFS = [
    'CSMEval11-COMPILED-Briefing-Packet.pdf',
    'CSMGeneralOutreach-COMPILED-Compendium.pdf',
    'COMPENDIUM-MINI.pdf'
]

PRETTY_SIGNATURE = '''
<br>
<table style="border-top:3px solid #1a5276;padding-top:15px;margin-top:30px;width:100%;">
<tr><td style="font-family:Georgia,serif;">
<p style="margin:0;font-size:15px;color:#1a5276;"><strong>Jason Brodsky</strong></p>
<p style="margin:4px 0;font-size:13px;color:#444;">Director of External Affairs &amp; Strategic Partnerships</p>
<p style="margin:2px 0;font-size:13px;color:#444;">Carrington Storm Motors &middot; Safe Pod Engineering Company</p>
<p style="margin:2px 0;font-size:12px;color:#888;">zirconia@aegisc.space &middot; aegisc.space &middot; San Francisco, California</p>
<p style="margin-top:12px;font-size:10px;color:#aaa;font-style:italic;">Composed by AI under human direction &middot; CSMSOPP000001 (Williams) + CSMSOPP000003 (Baker Street)<br>All technical content human-reviewed. All outreach decisions human-made. July 2026.</p>
</td></tr></table>
'''

# ─── GRAPH API ─────────────────────────────────────────
def load_token():
    with open(TOKEN_PATH) as f:
        return json.load(f)['access_token']

def graph_call(token, path, body=None, method='GET'):
    url = GRAPH_BASE + path
    data = json.dumps(body).encode() if body else None
    req = urllib.request.Request(url, data=data, method=method)
    req.add_header('Authorization', f'Bearer {token}')
    req.add_header('Content-Type', 'application/json')
    try:
        resp = urllib.request.urlopen(req)
        raw = resp.read()
        return json.loads(raw) if raw else {'ok': True}
    except urllib.error.HTTPError as e:
        err = e.read().decode()
        print(f'  ⚠️  HTTP {e.code}: {err[:200]}')
        return None

# ─── PANDOC MD→HTML ────────────────────────────────────
def md_to_html(md_content):
    """
    Convert Carrington Storm Motors markdown to HTML via pandoc.
    Uses --standalone for full document, then we strip <html><body> wrappers
    and inject our own styling.
    """
    result = subprocess.run(
        ['pandoc', '--standalone', '--from', 'markdown', '--to', 'html5', '--wrap=none'],
        input=md_content,
        capture_output=True,
        text=True,
        timeout=15
    )
    if result.returncode != 0:
        print(f'  ⚠️  Pandoc error: {result.stderr[:200]}')
        return None
    
    html = result.stdout
    
    # Extract body content (pandoc wraps in <html><body>)
    body_match = re.search(r'<body>(.*)</body>', html, re.DOTALL)
    if body_match:
        inner = body_match.group(1)
    else:
        inner = html
    
    # Remove pandoc metadata block (title, date headers if any)
    inner = re.sub(r'<h1[^>]*>.*?</h1>', '', inner, count=1)
    
    # Build final styled email
    styled = '<html><body style="font-family:Georgia,serif;color:#222;max-width:600px;">\n'
    styled += inner
    styled += PRETTY_SIGNATURE
    styled += '\n</body></html>'
    
    return styled

# ─── PARSE EMAIL FILE ──────────────────────────────────
def parse_email_file(filepath):
    """Extract TO, SUBJECT, and body from a .md email file."""
    with open(filepath) as f:
        content = f.read()
    
    to_match = re.search(r'\*\*TO:\*\*\s*(.+)', content)
    subj_match = re.search(r'\*\*SUBJECT:\*\*\s*(.+)', content)
    
    to_line = to_match.group(1).strip() if to_match else ''
    subject = subj_match.group(1).strip() if subj_match else 'No Subject'
    
    # Extract body: everything after FIRST '---' (includes human declaration + main body)
    body_start = 0
    for i, line in enumerate(content.split('\n')):
        if line.strip() == '---':
            body_start = i + 1
            break
    
    body_md = '\n'.join(content.split('\n')[body_start:])
    
    # Parse TO addresses
    to_addrs = []
    for addr in to_line.split(','):
        addr = addr.strip()
        if '@' in addr:
            to_addrs.append({'emailAddress': {'address': addr}})
    
    return {
        'to_raw': to_line,
        'to_addrs': to_addrs,
        'subject': subject,
        'body_md': body_md,
        'file': filepath
    }

# ─── VERIFY ────────────────────────────────────────────
def verify_email(parsed):
    """Check Williams preamble + Baker Street specs present."""
    body = parsed['body_md'].lower()
    has_williams = 'artificial intelligence' in body or 'composed by' in body
    has_specs = bool(re.search(r'\d+\s*db|\d+\s*ghz|mil-std|ieee\s*\d|astm\s*\w\d', body))
    paras = len([p for p in body.split('\n\n') if len(p.strip()) > 50])
    status = '✅ FULL' if paras >= 5 and has_williams and has_specs else '⚠️ SHORT'
    return status, paras, has_williams, has_specs

# ─── BUILD ATTACHMENTS ─────────────────────────────────
def build_attachments():
    atts = []
    for pdf_name in ATTACHMENT_PDFS:
        pdf_path = os.path.join(ATTACH_DIR, pdf_name)
        if not os.path.exists(pdf_path):
            print(f'  ⚠️  PDF not found: {pdf_path}')
            continue
        with open(pdf_path, 'rb') as f:
            data = f.read()
        atts.append({
            '@odata.type': '#microsoft.graph.fileAttachment',
            'name': pdf_name,
            'contentBytes': base64.b64encode(data).decode()
        })
    return atts

# ─── SEND ONE EMAIL ────────────────────────────────────
def send_one(token, parsed, atts, test_address=None):
    to_addr = test_address if test_address else parsed['to_addrs']
    if not to_addr:
        print('  ⚠️  No email address found — skipping')
        return False
    
    subject_prefix = 'TEST — ' if test_address else ''
    
    # Convert MD to HTML via pandoc
    html = md_to_html(parsed['body_md'])
    if not html:
        return False
    
    msg = {
        'subject': subject_prefix + parsed['subject'],
        'body': {'contentType': 'HTML', 'content': html},
        'toRecipients': [{'emailAddress': {'address': to_addr}}] if isinstance(to_addr, str) else to_addr,
        'attachments': atts
    }
    
    result = graph_call(token, '/me/sendMail', {'message': msg, 'saveToSentItems': True}, method='POST')
    if result:
        utc_time = time.strftime('%Y-%m-%dT%H:%M:%SZ', time.gmtime())
        print(f'  ✅ SENT at {utc_time} (HTML: {len(html)} chars)')
        return True
    return False

# ─── WRITE SEND LOG ────────────────────────────────────
def write_send_log(batch_dir, entries):
    log_path = os.path.join(batch_dir, 'SEND-LOG.md')
    with open(log_path, 'w') as f:
        f.write(f'# {os.path.basename(batch_dir)} SEND LOG\n')
        f.write('## Starlight Courier · Pandoc MD→HTML · AEGIS Agent\n\n')
        f.write('| UTC Time | ID | Recipient | Address | Status |\n')
        f.write('|----------|----|-----------|---------|--------|\n')
        for entry in entries:
            f.write(f'| {entry["time"]} | {entry["id"]} | {entry["name"]} | {entry["addr"]} | {entry["status"]} |\n')

# ─── FIND EMAIL FILES ──────────────────────────────────
def find_email_files(batch_dir):
    """Find all unique email .md files in a batch (prefer V4/FUN versions)."""
    all_files = sorted([f for f in os.listdir(batch_dir) if f.endswith('.md') and not f.startswith('BATCH') and not f.startswith('SEND')])
    
    # Group by email ID (e.g., E036 from E036-DNV...V4-FUN-WILLIAMS.md)
    groups = {}
    for f in all_files:
        eid = f.split('-')[0] if f.startswith('E') else f[:10]
        if eid not in groups:
            groups[eid] = []
        groups[eid].append(f)
    
    # Pick the best version: prefer V4 > FUN > 9PARA > FINAL > longest filename
    chosen = []
    for eid, files in groups.items():
        best = None
        for f in files:
            fname = f.lower()
            score = 0
            if 'v4' in fname: score += 100
            if 'fun' in fname: score += 50
            if 'williams' in fname: score += 50
            if '9para' in fname: score += 30
            if 'final' in fname: score += 10
            if best is None or score > best[0]:
                best = (score, f)
        chosen.append(best[1] if best else files[0])
    
    return sorted(chosen)

# ─── MAIN ──────────────────────────────────────────────
def main():
    parser = argparse.ArgumentParser(description='Starlight Courier Email Sender')
    parser.add_argument('--batch', required=True, help='Batch directory name (e.g. BATCH-05-Marine-Maritime)')
    parser.add_argument('--email', help='Specific email file (e.g. E036.md)')
    parser.add_argument('--test', action='store_true', help='Send test to yourself instead of real recipients')
    parser.add_argument('--test-addr', default='jasonbrodsky@hotmail.com', help='Test email address')
    parser.add_argument('--pace-min', type=int, default=45, help='Minimum seconds between sends')
    parser.add_argument('--pace-max', type=int, default=120, help='Maximum seconds between sends')
    parser.add_argument('--live', action='store_true', help='Actually send to real recipients (required for real sends)')
    args = parser.parse_args()
    
    batch_dir = os.path.join(BATCH_ROOT, args.batch)
    if not os.path.isdir(batch_dir):
        print(f'❌ Batch directory not found: {batch_dir}')
        sys.exit(1)
    
    token = load_token()
    atts = build_attachments()
    print(f'📎 {len(atts)} PDFs loaded')
    
    # Find email files
    if args.email:
        email_files = [args.email]
    else:
        email_files = find_email_files(batch_dir)
    
    print(f'\n{"═"*60}')
    print(f'📨 BATCH: {args.batch}')
    print(f'📧 EMAILS: {len(email_files)}')
    test_addr = args.test_addr if args.test else None
    live = args.live
    print(f'🎯 MODE: {"TEST → "+test_addr if test_addr else "LIVE SEND" if live else "DRY RUN (use --test or --live)"}')
    print(f'{"═"*60}')
    
    if not test_addr and not live:
        print('⚠️  Must specify --test or --live. No emails sent.')
        sys.exit(0)
    
    log_entries = []
    for i, fname in enumerate(email_files):
        filepath = os.path.join(batch_dir, fname)
        parsed = parse_email_file(filepath)
        status, paras, has_w, has_s = verify_email(parsed)
        
        eid = fname.split('-')[0] if fname.startswith('E') else fname[:10]
        to_display = test_addr if test_addr else parsed['to_raw'][:50]
        
        print(f'\n── {i+1}/{len(email_files)} ── {fname}')
        print(f'  TO:      {to_display}')
        print(f'  SUBJECT: {parsed["subject"][:60]}')
        print(f'  VERIFY:  {status} ({paras} paras, Williams:{has_w}, Specs:{has_s})')
        
        if status == '⚠️ SHORT' and not test_addr:
            print(f'  ⚠️  SHORT email — skipping in live mode. Review manually.')
            continue
        
        success = send_one(token, parsed, atts, test_address=test_addr)
        utc_time = time.strftime('%Y-%m-%dT%H:%M:%SZ', time.gmtime())
        
        log_entries.append({
            'time': utc_time,
            'id': eid,
            'name': parsed['to_raw'][:40],
            'addr': to_display,
            'status': 'SENT ✅' if success else 'FAILED ❌'
        })
        
        # Natural pacing
        if i < len(email_files) - 1 and success:
            delay = random.randint(args.pace_min, args.pace_max)
            print(f'  ⏳ Natural pace: {delay}s...')
            time.sleep(delay)
    
    # Write log
    write_send_log(batch_dir, log_entries)
    print(f'\n{"═"*60}')
    print(f'✅ BATCH COMPLETE: {len(log_entries)} sent')
    print(f'📝 SEND-LOG.md written to {batch_dir}')
    print(f'{"═"*60}')

if __name__ == '__main__':
    main()
