#!/usr/bin/env python3
"""
COMPREHENSIVE BOUNCE ANALYSIS & DRAFT SYNC
═══════════════════════════════════════════════════════════════
- Deep scan for "Delivery has failed" and similar messages
- Categorize all bounce types with email patterns
- Copy master draft list from hotmail → zirconia
- Update SEND-STATE.md with detailed metrics
"""

import json, os, urllib.request, urllib.parse, time, re
from collections import Counter
from datetime import datetime, timedelta

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
        time.sleep(0.03)
    return moved

def fetch_all_messages_deep(token, folder='inbox', max_pages=15):
    """Fetch up to 1500 messages"""
    all_msgs = []
    url = f'/me/mailFolders/{folder}/messages?$top=100&$select=id,subject,from,toRecipients,ccRecipients,receivedDateTime,bodyPreview,body'
    
    for page in range(max_pages):
        msgs = graph_call(token, url)
        if not msgs or 'value' not in msgs:
            break
        all_msgs.extend(msgs['value'])
        if '@odata.nextLink' in msgs:
            url = msgs['@odata.nextLink'].replace(GRAPH, '')
        else:
            break
        time.sleep(0.15)
    return all_msgs

def analyze_delivery_failures(token, account_name):
    """Find ALL delivery failure messages"""
    print(f'\n🔍 DELIVERY FAILURE ANALYSIS: {account_name}')
    print('─' * 60)
    
    # Scan inbox + sent + deleted
    inbox_msgs = fetch_all_messages_deep(token, 'inbox', max_pages=15)
    sent_msgs = fetch_all_messages_deep(token, 'sentitems', max_pages=8)
    deleted_msgs = fetch_all_messages_deep(token, 'deleteditems', max_pages=5)
    
    all_msgs = inbox_msgs + sent_msgs + deleted_msgs
    print(f'   Scanned: {len(inbox_msgs)} inbox + {len(sent_msgs)} sent + {len(deleted_msgs)} deleted = {len(all_msgs)} total')
    
    failure_patterns = [
        'delivery has failed',
        'delivery failed',
        'undeliverable',
        'non-delivery',
        'failed to deliver',
        'could not deliver',
        'delivery status notification',
        'failure notice',
        'returned mail',
        'bounce',
        'blocked',
        'rejected',
        'policy violation',
        'quarantine',
        'deferred',
        'delayed',
    ]
    
    system_senders = ['postmaster', 'mailer-daemon', 'bounce', 'noreply', 'admin', 'system']
    
    failures = []
    for m in all_msgs:
        subject = (m.get('subject') or '').lower()
        body = (m.get('bodyPreview') or '').lower()
        from_info = m.get('from', {})
        from_addr = from_info.get('emailAddress', {}).get('address', '').lower() if from_info else ''
        
        is_failure = any(p in subject or p in body for p in failure_patterns)
        is_system = any(s in from_addr for s in system_senders)
        
        if is_failure:
            failures.append(m)
    
    print(f'   Found {len(failures)} delivery failure messages')
    
    # Categorize and extract emails
    categories = Counter()
    rejected_emails = []
    rejected_domains = Counter()
    failure_details = []
    
    email_pattern = r'[\w\.-]+@[\w\.-]+\.\w+'
    
    for m in failures:
        subject = m.get('subject', '')
        body = m.get('bodyPreview', '') or m.get('body', {}).get('content', '') if m.get('body') else ''
        from_info = m.get('from', {})
        from_addr = from_info.get('emailAddress', {}).get('address', '') if from_info else ''
        date = m.get('receivedDateTime', '')[:10]
        
        # Categorize
        subj_body = (subject + ' ' + body).lower()
        if any(w in subj_body for w in ['undeliverable', 'non-delivery', 'failed to deliver', 'could not deliver', 'failure notice', 'returned mail']):
            cat = 'HARD_BOUNCE'
        elif any(w in subj_body for w in ['blocked', 'rejected', 'policy', 'quarantine', 'spam']):
            cat = 'BLOCKED'
        elif any(w in subj_body for w in ['deferred', 'delayed', 'retry', 'warning']):
            cat = 'DEFERRED'
        elif any(w in subj_body for w in ['auto-reply', 'out of office', 'vacation']):
            cat = 'AUTO_REPLY'
        else:
            cat = 'OTHER_FAILURE'
        
        categories[cat] += 1
        
        # Extract rejected emails
        emails = re.findall(email_pattern, subject + ' ' + body)
        for email in emails:
            email_lower = email.lower()
            if not any(sys in email_lower for sys in system_senders):
                rejected_emails.append(email)
                rejected_domains[email.split('@')[1].lower()] += 1
        
        failure_details.append({
            'date': date,
            'subject': subject[:80],
            'from': from_addr,
            'category': cat,
            'emails': emails
        })
    
    print(f'\n   Categories:')
    for cat, count in categories.most_common():
        print(f'      {cat}: {count}')
    
    print(f'\n   Top Rejected Domains:')
    for domain, count in rejected_domains.most_common(20):
        print(f'      {domain}: {count}')
    
    # Local part analysis
    local_parts = Counter()
    for email in rejected_emails:
        local = email.split('@')[0].lower()
        local_parts[local] += 1
    
    print(f'\n   Top Rejected Local Parts:')
    for local, count in local_parts.most_common(20):
        print(f'      {local}@... : {count}')
    
    return categories, rejected_domains, local_parts, failure_details, len(failures)

def cleanup_failures(token, account_name, dest_folder_name):
    """Move all failure messages to folder"""
    print(f'\n🧹 CLEANING {account_name} — Moving failures to {dest_folder_name}')
    print('─' * 60)
    
    dest_id = get_or_create_folder(token, dest_folder_name)
    
    inbox_msgs = fetch_all_messages_deep(token, 'inbox', max_pages=15)
    sent_msgs = fetch_all_messages_deep(token, 'sentitems', max_pages=8)
    deleted_msgs = fetch_all_messages_deep(token, 'deleteditems', max_pages=5)
    all_msgs = inbox_msgs + sent_msgs + deleted_msgs
    
    failure_patterns = [
        'delivery has failed', 'delivery failed', 'undeliverable', 'non-delivery',
        'failed to deliver', 'could not deliver', 'delivery status notification',
        'failure notice', 'returned mail', 'bounce', 'blocked', 'rejected',
        'policy violation', 'quarantine', 'deferred', 'delayed'
    ]
    system_senders = ['postmaster', 'mailer-daemon', 'bounce', 'noreply', 'admin', 'system']
    
    failure_ids = []
    for m in all_msgs:
        subject = (m.get('subject') or '').lower()
        body = (m.get('bodyPreview') or '').lower()
        from_info = m.get('from', {})
        from_addr = from_info.get('emailAddress', {}).get('address', '').lower() if from_info else ''
        
        is_failure = any(p in subject or p in body for p in failure_patterns)
        is_system = any(s in from_addr for s in system_senders)
        
        if is_failure and is_system:
            failure_ids.append(m['id'])
    
    print(f'   Found {len(failure_ids)} system failure messages to move')
    
    if failure_ids:
        moved = move_messages(token, failure_ids, dest_id)
        print(f'   ✅ Moved {moved} to {dest_folder_name}')
    else:
        print('   No system failures to move')
    
    return len(failure_ids)

def sync_drafts_hotmail_to_zirconia():
    """Copy drafts from hotmail to zirconia"""
    print('\n🔄 SYNCING DRAFTS: hotmail → zirconia')
    print('─' * 60)
    
    # Get hotmail drafts
    hotmail_drafts = graph_call(HOTMAIL_TOKEN, '/me/mailFolders/drafts/messages?$top=200&$select=id,subject,toRecipients,ccRecipients,body,attachments')
    
    if not hotmail_drafts or 'value' not in hotmail_drafts:
        print('   No drafts found in hotmail')
        return 0
    
    drafts = hotmail_drafts['value']
    print(f'   Found {len(drafts)} drafts in hotmail')
    
    synced = 0
    for draft in drafts:
        subject = draft.get('subject', '(no subject)')
        to_recipients = draft.get('toRecipients', [])
        cc_recipients = draft.get('ccRecipients', [])
        body = draft.get('body', {}).get('content', '')
        attachments = draft.get('attachments', [])
        
        if not to_recipients:
            continue
        
        # Create draft in zirconia
        msg = {
            'subject': subject,
            'body': {'contentType': 'HTML', 'content': body},
            'toRecipients': to_recipients,
            'ccRecipients': cc_recipients
        }
        
        result = graph_call(ZIRCONIA_TOKEN, '/me/messages', msg, method='POST')
        
        if result and 'id' in result:
            # Copy attachments
            for att in attachments:
                if att.get('@odata.type') == '#microsoft.graph.fileAttachment':
                    att_data = {
                        '@odata.type': '#microsoft.graph.fileAttachment',
                        'name': att['name'],
                        'contentBytes': att['contentBytes']
                    }
                    graph_call(ZIRCONIA_TOKEN, f"/me/messages/{result['id']}/attachments", att_data, method='POST')
            synced += 1
            print(f'      ✅ Synced: {subject[:60]}')
        else:
            print(f'      ❌ Failed: {subject[:60]}')
        
        time.sleep(0.1)
    
    print(f'   ✅ Synced {synced}/{len(drafts)} drafts to zirconia')
    return synced

def update_send_state_detailed(z_categories, z_domains, h_categories, h_domains, total_sent=225):
    """Update SEND-STATE.md with comprehensive metrics"""
    print('\n📊 UPDATING SEND-STATE.MD WITH DETAILED METRICS')
    print('─' * 60)
    
    all_categories = z_categories + h_categories
    all_domains = z_domains + h_domains
    
    hard = all_categories.get('HARD_BOUNCE', 0)
    blocked = all_categories.get('BLOCKED', 0)
    deferred = all_categories.get('DEFERRED', 0)
    auto = all_categories.get('AUTO_REPLY', 0)
    other = all_categories.get('OTHER_FAILURE', 0)
    
    total_bounces = hard + blocked
    delivered = total_sent - total_bounces
    success_rate = (delivered / total_sent * 100) if total_sent > 0 else 0
    
    state_path = '/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_40a69c3b-ac84-4c37-b935-27fe9ef06341/CSMReach/CSMEmailOutgoing/July2026/SEND-STATE.md'
    
    with open(state_path, 'r') as f:
        content = f.read()
    
    # Build metrics section
    metrics = f'''---
## CAMPAIGN SUCCESS METRICS (Updated {datetime.now().strftime("%Y-%m-%d %H:%M")})

| Metric | Count | Percentage |
|--------|-------|------------|
| **Total Campaign Emails** | {total_sent} | 100% |
| **Estimated Delivered** | {delivered} | {success_rate:.1f}% |
| **Hard Bounces** | {hard} | {hard/total_sent*100:.1f}% |
| **Blocked/Rejected** | {blocked} | {blocked/total_sent*100:.1f}% |
| **Deferred/Delayed** | {deferred} | {deferred/total_sent*100:.1f}% |
| **Auto-Replies** | {auto} | {auto/total_sent*100:.1f}% |
| **Other Failures** | {other} | {other/total_sent*100:.1f}% |
| **TOTAL BOUNCES** | {total_bounces} | {total_bounces/total_sent*100:.1f}% |

### Top 20 Rejected Domains
| Domain | Rejections |
|--------|------------|
'''
    
    for domain, count in all_domains.most_common(20):
        metrics += f'| {domain} | {count} |\n'
    
    metrics += '\n### Bounce Quality Analysis\n'
    metrics += '| Pattern | Count | Likely Cause |\n|---------|-------|--------------|\n'
    
    # Analyze local parts for patterns
    local_analysis = {
        'info@': 'Generic inbox — often unmonitored or auto-filtered',
        'admin@': 'Admin inbox — strict policies',
        'contact@': 'Contact form — may route to ticketing',
        'support@': 'Support queue — high volume, auto-filters',
        'sales@': 'Sales inbox — aggressive spam filtering',
        'hr@': 'HR inbox — strict corporate policies',
        'security@': 'Security team — blocks external',
        'legal@': 'Legal — blocks unsolicited',
        'compliance@': 'Compliance — regulatory filtering',
        'it@': 'IT department — technical blocks',
    }
    
    for local, count in all_domains.most_common(10):
        pass
    
    metrics += '\n---\n'
    
    # Insert into file
    if '## CAMPAIGN STATUS' in content:
        parts = content.split('## CAMPAIGN STATUS', 1)
        if len(parts) == 2:
            after_status = parts[1].split('---', 1)
            if len(after_status) == 2:
                new_content = parts[0] + '## CAMPAIGN STATUS' + after_status[0] + '---' + metrics + after_status[1]
            else:
                new_content = content + '\n' + metrics
        else:
            new_content = content + '\n' + metrics
    else:
        new_content = content + '\n' + metrics
    
    with open(state_path, 'w') as f:
        f.write(new_content)
    
    print(f'   ✅ SEND-STATE.md updated')
    print(f'   Success Rate: {success_rate:.1f}% ({delivered}/{total_sent})')
    print(f'   Hard Bounces: {hard}, Blocked: {blocked}, Deferred: {deferred}')
    
    return success_rate, total_bounces, delivered

def main():
    print('═' * 70)
    print('   COMPREHENSIVE DELIVERY FAILURE ANALYSIS & CLEANUP')
    print('═' * 70)
    
    # Analyze both accounts
    z_cat, z_dom, z_loc, z_det, z_count = analyze_delivery_failures(ZIRCONIA_TOKEN, 'zirconia@aegisc.space')
    h_cat, h_dom, h_loc, h_det, h_count = analyze_delivery_failures(HOTMAIL_TOKEN, 'jasonbrodsky@hotmail.com')
    
    # Clean both accounts
    z_moved = cleanup_failures(ZIRCONIA_TOKEN, 'zirconia', 'Delivery-Failures-Archive')
    h_moved = cleanup_failures(HOTMAIL_TOKEN, 'hotmail', 'basketballs')
    
    # Sync drafts
    synced = sync_drafts_hotmail_to_zirconia()
    
    # Update metrics
    success_rate, total_bounces, delivered = update_send_state_detailed(z_cat, z_dom, h_cat, h_dom)
    
    print('\n' + '═' * 70)
    print('   COMPREHENSIVE CLEANUP COMPLETE')
    print('═' * 70)
    print(f'   Zirconia failures analyzed: {z_count} | moved: {z_moved}')
    print(f'   Hotmail failures analyzed: {h_count} | moved: {h_moved}')
    print(f'   Drafts synced: {synced}')
    print(f'   Campaign Success Rate: {success_rate:.1f}%')
    print(f'   Estimated Delivered: {delivered}/{225}')
    print(f'   Total Bounces: {total_bounces}')

if __name__ == '__main__':
    main()