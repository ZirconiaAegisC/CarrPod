#!/usr/bin/env python3
"""
INBOX CLEANUP — Campaign Email Organization
═══════════════════════════════════════════════════════════════
Moves CC'd campaign emails to organized folders
Moves bounces to basketballs folder
Reports counts and destinations
"""

import json, os, urllib.request, urllib.parse, time

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

def get_or_create_folder(token, folder_name, parent='msgfolderroot'):
    """Get folder ID or create it"""
    # Search existing folders
    folders = graph_call(token, f'/me/mailFolders?$select=id,displayName&$top=100')
    for f in folders.get('value', []):
        if f['displayName'].lower() == folder_name.lower():
            return f['id']
    
    # Create folder
    result = graph_call(token, f'/me/mailFolders', 
                       {'displayName': folder_name}, method='POST')
    return result.get('id')

def move_messages(token, msg_ids, dest_folder_id):
    """Move messages to destination folder"""
    moved = 0
    for mid in msg_ids:
        result = graph_call(token, f'/me/messages/{mid}/move',
                          {'destinationId': dest_folder_id}, method='POST')
        if result.get('ok') or 'id' in result:
            moved += 1
        time.sleep(0.1)  # Rate limit
    return moved

def cleanup_zirconia():
    """Move CC'd campaign emails to 'Campaign-CC-Archive' folder"""
    print('\n🔵 ZIRCONIA CLEANUP')
    print('─' * 50)
    
    # Create/get archive folder
    archive_id = get_or_create_folder(ZIRCONIA_TOKEN, 'Campaign-CC-Archive')
    print(f'   Archive folder: Campaign-CC-Archive (ID: {archive_id[:20]}...)')
    
    # Get inbox messages (check last 200)
    msgs = graph_call(ZIRCONIA_TOKEN, 
                     '/me/mailFolders/inbox/messages?$top=200&$select=id,subject,ccRecipients,receivedDateTime')
    
    campaign_msgs = []
    for m in msgs.get('value', []):
        cc = m.get('ccRecipients', [])
        for c in cc:
            addr = c.get('emailAddress', {}).get('address', '').lower()
            if 'zirconia@aegisc.space' in addr or 'jasonbrodsky@hotmail.com' in addr:
                campaign_msgs.append(m)
                break
    
    print(f'   Found {len(campaign_msgs)} CC\'d campaign emails in inbox')
    
    if campaign_msgs:
        ids = [m['id'] for m in campaign_msgs]
        moved = move_messages(ZIRCONIA_TOKEN, ids, archive_id)
        print(f'   ✅ Moved {moved} emails to Campaign-CC-Archive')
        
        # Show samples
        for m in campaign_msgs[:5]:
            subj = m.get('subject', '(no subject)')[:60]
            date = m.get('receivedDateTime', '')[:10]
            print(f'      • [{date}] {subj}...')
        if len(campaign_msgs) > 5:
            print(f'      ... and {len(campaign_msgs) - 5} more')
    else:
        print('   No campaign CC emails found in inbox')
    
    return len(campaign_msgs)

def cleanup_hotmail():
    """Move bounces to basketballs folder"""
    print('\n🟠 HOTMAIL CLEANUP')
    print('─' * 50)
    
    # Get/create basketballs folder
    bb_id = get_or_create_folder(HOTMAIL_TOKEN, 'basketballs')
    print(f'   Basketballs folder: (ID: {bb_id[:20]}...)')
    
    # Get inbox messages
    msgs = graph_call(HOTMAIL_TOKEN,
                     '/me/mailFolders/inbox/messages?$top=200&$select=id,subject,from,receivedDateTime')
    
    bounce_msgs = []
    for m in msgs.get('value', []):
        subj = m.get('subject', '').lower()
        frm = str(m.get('from', {})).lower()
        
        if any(w in subj for w in ['undeliverable', 'delivery', 'returned', 'failed', 'bounce', 'non-delivery']):
            if 'postmaster' in frm or 'mailer-daemon' in frm or 'bounce' in frm:
                bounce_msgs.append(m)
    
    print(f'   Found {len(bounce_msgs)} bounce emails in inbox')
    
    if bounce_msgs:
        ids = [m['id'] for m in bounce_msgs]
        moved = move_messages(HOTMAIL_TOKEN, ids, bb_id)
        print(f'   ✅ Moved {moved} bounces to basketballs folder')
        
        for m in bounce_msgs[:5]:
            subj = m.get('subject', '(no subject)')[:60]
            date = m.get('receivedDateTime', '')[:10]
            frm = m.get('from', {}).get('emailAddress', {}).get('address', 'unknown')
            print(f'      • [{date}] {subj}... (from: {frm})')
        if len(bounce_msgs) > 5:
            print(f'      ... and {len(bounce_msgs) - 5} more')
    else:
        print('   No bounces found in inbox')
    
    # Also check sent folder for bounce receipts
    sent = graph_call(HOTMAIL_TOKEN,
                     '/me/mailFolders/sentitems/messages?$top=100&$select=id,subject,toRecipients')
    
    sent_bounces = []
    for m in sent.get('value', []):
        subj = m.get('subject', '').lower()
        if any(w in subj for w in ['undeliverable', 'delivery', 'returned', 'failed', 'bounce']):
            sent_bounces.append(m)
    
    if sent_bounces:
        print(f'   Found {len(sent_bounces)} bounce-related emails in Sent Items')
        ids = [m['id'] for m in sent_bounces]
        moved = move_messages(HOTMAIL_TOKEN, ids, bb_id)
        print(f'   ✅ Moved {moved} from Sent to basketballs')
    
    return len(bounce_msgs) + len(sent_bounces)

def main():
    print('═' * 60)
    print('   CAMPAIGN INBOX CLEANUP')
    print('═' * 60)
    
    z_count = cleanup_zirconia()
    h_count = cleanup_hotmail()
    
    print('\n' + '═' * 60)
    print(f'   SUMMARY: {z_count} CC\'d emails archived (zirconia)')
    print(f'            {h_count} bounces moved to basketballs (hotmail)')
    print('═' * 60)

if __name__ == '__main__':
    main()