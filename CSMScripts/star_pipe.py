#!/usr/bin/env python3
"""Single-shot attachment upload: gets upload URL from MCP JSON output, PUTs bytes immediately.
Reads the upload session response from stdin as JSON, extracts uploadUrl, and uploads the file.
"""
import sys, json, urllib.request, urllib.error, os

if len(sys.argv) < 2:
    print("Usage: star.py <file_path>", file=sys.stderr)
    print("       Reads upload session JSON from stdin.", file=sys.stderr)
    sys.exit(1)

file_path = sys.argv[1]

# Read upload session info from stdin
session_json = sys.stdin.read()
session = json.loads(session_json)
upload_url = session.get('uploadUrl')
if not upload_url:
    print(f"ERROR: No uploadUrl in session data", file=sys.stderr)
    sys.exit(1)

if not os.path.exists(file_path):
    print(f"ERROR: File not found: {file_path}", file=sys.stderr)
    sys.exit(1)

with open(file_path, 'rb') as f:
    data = f.read()

fs = len(data)
req = urllib.request.Request(upload_url, data=data, method='PUT', headers={
    'Content-Length': str(fs),
    'Content-Range': f'bytes 0-{fs-1}/{fs}'
})

try:
    resp = urllib.request.urlopen(req)
    result = json.loads(resp.read())
    print(json.dumps({"status": "ok", "name": result.get("name",""), "size": result.get("size","")}))
except urllib.error.HTTPError as e:
    body = e.read().decode()
    print(json.dumps({"status": "error", "code": e.code, "body": body[:500]}))
    sys.exit(1)
