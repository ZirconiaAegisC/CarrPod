#!/usr/bin/env python3
"""
DEEP INBOX CLEANUP — 30-Day Bounce Analysis
═══════════════════════════════════════════════════════════════
Goes back ~30 days, categorizes bounces, logs rejection patterns,
updates SEND-STATE.md with success rate
"""

import json, os, urllib.request, urllib.parse, time, re
from collections import Counter
from datetime import datetime, timedelta

# Load tokens
with open('/tmp/kilo/csm_token.json') as f:
    ZIRCONIA_TOKEN = json.load(f)['access_token']

with open('/tmp/kilo/hotmail_token.json') as f:
    HOTMAIL_TOKEN = json.load(f)['access_token']

GRAPH = 'https://graph.microsoft.com/v1.0'

def headers(token):
    return {'Authorization': f'Bearer {token}', 'Content-Type': 'application/json'}

def graph_call(token, path, body=None, method='GET'):
    url = GRAPH + path
    data = json.dumps(body).encode() if body else None
    req = urllib.request.Request(url, data=data, method=method)
    for k, v in headers(token).items():
        req.add_header(k, v)
    try:
        resp = urllib.request.urlopen(req)
        raw = resp.read()
        return json.loads(raw) if raw else {'ok': True}
    except urllib.error.HTTPError as e:
        return {'error': e.code, 'body': e.read().decode()}

def get_or_create_folder(token, folder_name):
    folders = graph_call(token, '/me/mailFolders?$select=id,displayName&$top=100')
    for f in folders.get('value', []):
        if f['displayName'].lower() == folder_name.lower():
            return f['id']
    result = graph_call(token, '/me/mailFolders', {'displayName': folder_name}, method='POST')
    return result.get('id')

def move_messages(token, msg_ids, dest_folder_id):
    moved = 0
    for mid in msg_ids:
        result = graph_call(token, f'/me/messages/{mid}/move',
                          {'destinationId': dest_folder_id}, method='POST')
        if result.get('ok') or 'id' in result:
            moved += 1
        time.sleep(0.05)
    return moved

def fetch_all_messages(token, folder='inbox', max_pages=10):
    """Fetch messages from folder with pagination"""
    all_msgs = []
    url = f'/me/mailFolders/{folder}/messages?$top=100&$select=id,subject,from,toRecipients,ccRecipients,receivedDateTime,bodyPreview'
    
    for page in range(max_pages):
        msgs = graph_call(token, url)
        if not msgs or 'value' not in msgs:
            break
        all_msgs.extend(msgs['value'])
        print(f'   Page {page+1}: {len(msgs["value"])} messages (total: {len(all_msgs)})')
        
        if '@odata.nextLink' in msgs:
            url = msgs['@odata.nextLink'].replace(GRAPH, '')
        else:
            break
        time.sleep(0.2)
    
    return all_msgs

def categorize_bounce(subject, from_addr, body_preview=''):
    """Categorize bounce type and extract rejected address"""
    subj_lower = subject.lower()
    from_lower = from_addr.lower()
    body_lower = body_preview.lower()
    
    # Extract email addresses from subject/body
    email_pattern = r'[\w\.-]+@[\w\.-]+\.\w+'
    emails_found = re.findall(email_pattern, subject + ' ' + body_preview)
    
    # Categorize
    if any(w in subj_lower for w in ['undeliverable', 'non-delivery', 'delivery status', 'failure notice']):
        if 'postmaster' in from_lower or 'mailer-daemon' in from_lower:
            return 'HARD_BOUNCE', emails_found
        return 'SOFT_BOUNCE', emails_found
    elif any(w in subj_lower for w in ['delayed', 'deferred', 'retry', 'warning']):
        return 'DEFERRED', emails_found
    elif any(w in subj_lower for w in ['blocked', 'rejected', 'policy', 'spam', 'quarantine']):
        return 'BLOCKED', emails_found
    elif any(w in subj_lower for w in ['auto-reply', 'out of office', 'vacation', 'automatic reply']):
        return 'AUTO_REPLY', emails_found
    else:
        return 'OTHER_BOUNCE', emails_found

def extract_domain(email):
    """Extract domain from email"""
    if '@' in email:
        return email.split('@')[1].lower()
    return 'unknown'

def analyze_bounces_deep(token, account_name):
    """Deep bounce analysis going back 30 days"""
    print(f'\n🔍 DEEP ANALYSIS: {account_name}')
    print('─' * 60)
    
    # Get inbox messages (up to 1000 = ~10 pages)
    msgs = fetch_all_messages(token, 'inbox', max_pages=10)
    print(f'   Total messages scanned: {len(msgs)}')
    
    # Also check sent folder for bounces
    sent_msgs = fetch_all_messages(token, 'sentitems', max_pages=5)
    print(f'   Sent messages scanned: {len(sent_msgs)}')
    
    all_msgs = msgs + sent_msgs
    
    bounce_categories = Counter()
    rejected_emails = []
    rejected_domains = Counter()
    bounce_details = []
    
    cutoff_date = datetime.now() - timedelta(days=30)
    
    for m in all_msgs:
        received = m.get('receivedDateTime', '')
        if received:
            try:
                msg_date = datetime.fromisoformat(received.replace('Z', '+00:00')).replace(tzinfo=None)
                if msg_date < cutoff_date:
                    continue
            except:
                pass
        
        subject = m.get('subject', '')
        from_info = m.get('from', {})
        from_addr = from_info.get('emailAddress', {}).get('address', '') if from_info else ''
        body = m.get('bodyPreview', '')
        
        category, emails = categorize_bounce(subject, from_addr, body)
        
        if category != 'OTHER_BOUNCE' or any(w in subject.lower() for w in ['bounce', 'deliver', 'undeliver', 'failed', 'returned']):
            bounce_categories[category] += 1
            bounce_details.append({
                'date': received[:10] if received else 'unknown',
                'subject': subject[:80],
                'from': from_addr,
                'category': category,
                'emails': emails
            })
            
            for email in emails:
                if '@' in email and 'postmaster' not in email.lower() and 'mailer-daemon' not in email.lower():
                    rejected_emails.append(email)
                    rejected_domains[extract_domain(email)] += 1
    
    print(f'\n   Bounce Categories:')
    for cat, count in bounce_categories.most_common():
        print(f'      {cat}: {count}')
    
    print(f'\n   Top Rejected Domains:')
    for domain, count in rejected_domains.most_common(15):
        print(f'      {domain}: {count}')
    
    print(f'\n   Top Rejected Email Patterns:')
    local_parts = Counter()
    for email in rejected_emails:
        local = email.split('@')[0]
        local_parts[local] += 1
    for local, count in local_parts.most_common(15):
        print(f'      {local}@... : {count}')
    
    return bounce_categories, rejected_domains, local_parts, bounce_details

def cleanup_zirconia_deep(token):
    """Move ALL CC'd campaign emails to archive (not just recent)"""
    print('\n🔵 ZIRCONIA DEEP CLEANUP')
    print('─' * 60)
    
    archive_id = get_or_create_folder(token, 'Campaign-CC-Archive')
    
    msgs = fetch_all_messages(token, 'inbox', max_pages=10)
    
    campaign_msgs = []
    for m in msgs:
        cc = m.get('ccRecipients', [])
        for c in cc:
            addr = c.get('emailAddress', {}).get('address', '').lower()
            if 'zirconia@aegisc.space' in addr or 'jasonbrodsky@hotmail.com' in addr:
                campaign_msgs.append(m)
                break
    
    print(f'   Found {len(campaign_msgs)} CC\'d campaign emails (30-day scan)')
    
    if campaign_msgs:
        ids = [m['id'] for m in campaign_msgs]
        moved = move_messages(token, ids, archive_id)
        print(f'   ✅ Moved {moved} emails to Campaign-CC-Archive')
    else:
        print('   No campaign CC emails found')
    
    return len(campaign_msgs)

def cleanup_hotmail_deep(token):
    """Move ALL bounces to basketballs folder"""
    print('\n🟠 HOTMAIL DEEP CLEANUP')
    print('─' * 60)
    
    bb_id = get_or_create_folder(token, 'basketballs')
    
    msgs = fetch_all_messages(token, 'inbox', max_pages=10)
    sent_msgs = fetch_all_messages(token, 'sentitems', max_pages=5)
    all_msgs = msgs + sent_msgs
    
    bounce_msgs = []
    for m in all_msgs:
        subject = m.get('subject', '').lower()
        from_info = m.get('from', {})
        from_addr = from_info.get('emailAddress', {}).get('address', '') if from_info else ''
        from_lower = from_addr.lower()
        
        is_bounce = any(w in subject for w in ['undeliverable', 'delivery', 'returned', 'failed', 'bounce', 'non-delivery', 'deferred', 'delayed', 'blocked', 'rejected', 'policy violation'])
        is_system = 'postmaster' in from_lower or 'mailer-daemon' in from_lower or 'bounce' in from_lower
        
        if is_bounce and is_system:
            bounce_msgs.append(m)
    
    print(f'   Found {len(bounce_msgs)} bounce emails (30-day scan)')
    
    if bounce_msgs:
        ids = [m['id'] for m in bounce_msgs]
        moved = move_messages(token, ids, bb_id)
        print(f'   ✅ Moved {moved} bounces to basketballs folder')
    else:
        print('   No bounces found')
    
    return len(bounce_msgs)

def update_send_state_with_success_rate(bounce_categories, rejected_domains, total_sent_estimate=225):
    """Update SEND-STATE.md with success rate"""
    print('\n📊 UPDATING SEND-STATE.MD WITH SUCCESS RATE')
    print('─' * 60)
    
    # Calculate bounces
    hard_bounces = bounce_categories.get('HARD_BOUNCE', 0)
    soft_bounces = bounce_categories.get('SOFT_BOUNCE', 0)
    blocked = bounce_categories.get('BLOCKED', 0)
    deferred = bounce_categories.get('DEFERRED', 0)
    
    total_bounces = hard_bounces + soft_bounces + blocked
    total_delivered_estimate = total_sent_estimate - total_bounces
    success_rate = (total_delivered_estimate / total_sent_estimate * 100) if total_sent_estimate > 0 else 0
    
    # Read current SEND-STATE.md
    state_path = '/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_40a69c3b-ac84-4c37-b935-27fe9ef06341/CSMReach/CSMEmailOutgoing/July2026/SEND-STATE.md'
    
    with open(state_path, 'r') as f:
        content = f.read()
    
    # Create success rate section
    success_section = f'''---
## CAMPAIGN SUCCESS METRICS (Updated {datetime.now().strftime("%Y-%m-%d")})

| Metric | Value |
|--------|-------|
| **Total Campaign Emails** | {total_sent_estimate} |
| **Estimated Delivered** | {total_delivered_estimate} |
| **Hard Bounces** | {hard_bounces} |
| **Soft Bounces** | {soft_bounces} |
| **Blocked/Rejected** | {blocked} |
| **Deferred** | {deferred} |
| **Total Bounces** | {total_bounces} |
| **SUCCESS RATE** | **{success_rate:.1f}%** |

### Top Rejected Domains
'''
    
    for domain, count in rejected_domains.most_common(10):
        success_section += f'| {domain} | {count} |\n'
    
    success_section += '\n---\n'
    
    # Insert after CAMPAIGN STATUS section
    if '## CAMPAIGN STATUS' in content:
        parts = content.split('## CAMPAIGN STATUS', 1)
        if len(parts) == 2:
            after_status = parts[1].split('---', 1)
            if len(after_status) == 2:
                new_content = parts[0] + '## CAMPAIGN STATUS' + after_status[0] + '---' + success_section + after_status[1]
            else:
                new_content = content + '\n' + success_section
        else:
            new_content = content + '\n' + success_section
    else:
        new_content = content + '\n' + success_section
    
    with open(state_path, 'w') as f:
        f.write(new_content)
    
    print(f'   ✅ SEND-STATE.md updated')
    print(f'   Success Rate: {success_rate:.1f}% ({total_delivered_estimate}/{total_sent_estimate})')
    
    return success_rate, total_bounces, total_delivered_estimate

def main():
    print('═' * 60)
    print('   DEEP CAMPAIGN INBOX CLEANUP — 30 DAY SCAN')
    print('═' * 60)
    
    # Deep analysis
    z_bounces, z_domains, z_locals, z_details = analyze_bounces_deep(ZIRCONIA_TOKEN, 'zirconia@aegisc.space')
    h_bounces, h_domains, h_locals, h_details = analyze_bounces_deep(HOTMAIL_TOKEN, 'jasonbrodsky@hotmail.com')
    
    # Combine bounce data
    all_bounces = z_bounces + h_bounces
    all_domains = z_domains + h_domains
    
    # Deep cleanup
    z_moved = cleanup_zirconia_deep(ZIRCONIA_TOKEN)
    h_moved = cleanup_hotmail_deep(HOTMAIL_TOKEN)
    
    # Update SEND-STATE with success rate
    success_rate, total_bounces, delivered = update_send_state_with_success_rate(all_bounces, all_domains)
    
    print('\n' + '═' * 60)
    print('   DEEP CLEANUP COMPLETE')
    print('═' * 60)
    print(f'   Zirconia CC emails archived: {z_moved}')
    print(f'   Hotmail bounces moved: {h_moved}')
    print(f'   Total bounces analyzed: {sum(all_bounces.values())}')
    print(f'   Campaign Success Rate: {success_rate:.1f}%')
    print(f'   Estimated Delivered: {delivered}/{225}')

if __name__ == '__main__':
    main()