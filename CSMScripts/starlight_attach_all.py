#!/usr/bin/env python3
"""Starlight attachment relay — create session + upload in one go.
Uses direct Graph API with stored token.
"""
import json, sys, os, urllib.request, urllib.error, urllib.parse

MESSAGE_ID = 'AAMkAGI3NGFjYzg4LTc3ZjctNDFlNC1hM2U1LTQ5YTA5MDliZDk0YwBGAAAAAAAe3LK_HiAnQ5bt_iTJ4aPCBwD4yrgtyCB-S4agEHXKN3NsAAAAAAEPAAD4yrgtyCB-S4agEHXKN3NsAAAGZG3lAAA='

def create_upload_session(token, msg_id, name, size):
    url = f"https://graph.microsoft.com/v1.0/me/messages/{msg_id}/attachments/createUploadSession"
    body = json.dumps({"AttachmentItem": {"attachmentType": "file", "name": name, "size": size}}).encode()
    req = urllib.request.Request(url, data=body, method='POST', headers={
        "Authorization": f"Bearer {token}",
        "Content-Type": "application/json"
    })
    return json.loads(urllib.request.urlopen(req).read())

def put_bytes(upload_url, file_path):
    with open(file_path, 'rb') as f:
        data = f.read()
    fs = len(data)
    req = urllib.request.Request(upload_url, data=data, method='PUT', headers={
        'Content-Length': str(fs),
        'Content-Range': f'bytes 0-{fs-1}/{fs}'
    })
    resp = urllib.request.urlopen(req)
    return json.loads(resp.read())

if __name__ == "__main__":
    # Find token from MCP config
    token = None
    for root, dirs, files in os.walk(os.path.expanduser("~/.kilo")):
        for f in files:
            if f.endswith('.json') and 'mcp' in root.lower():
                try:
                    with open(os.path.join(root, f)) as fh:
                        cfg = json.load(fh)
                    if 'access_token' in str(cfg):
                        token = cfg.get('access_token')
                        break
                except:
                    pass
        for f in files:
            if f == 'token.json':
                try:
                    with open(os.path.join(root, f)) as fh:
                        data = json.load(fh)
                    if 'access_token' in data:
                        token = data['access_token']
                except:
                    pass

    if not token:
        print("No token found. Run ms365_login first.")
        sys.exit(1)

    files_to_attach = [
        ("CSMGeneralOutreach-COMPILED-Compendium.pdf", "CSMEmailOutgoing/July2026/ATTACHMENTS/CSMGeneralOutreach-COMPILED-Compendium.pdf"),
        ("COMPENDIUM-MINI.pdf", "CSMEmailOutgoing/July2026/ATTACHMENTS/COMPENDIUM-MINI.pdf"),
    ]

    for name, path in files_to_attach:
        size = os.path.getsize(path)
        print(f"Uploading {name} ({size} bytes)...")
        try:
            session = create_upload_session(token, MESSAGE_ID, name, size)
            upload_url = session['uploadUrl']
            result = put_bytes(upload_url, path)
            print(f"  ✓ {result.get('name', result.get('id','done'))} - {result.get('size','')} bytes")
        except Exception as e:
            print(f"  ✗ {e}")
