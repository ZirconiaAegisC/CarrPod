#!/usr/bin/env python3
"""Starlight 5-step: Create upload session + immediately PUT bytes.
Uses MS365 MCP authentication. For files < 100KB, direct base64 via send-mail works.
For anything larger, this script is the relay.
"""
import json, sys, os, urllib.request, urllib.error

# The MCP already authenticated us. We need the graph API token.
# We'll use a simpler approach: read the token from the MCP auth cache.
# The MCP stores token in ~/.kilo/mcp_configs or similar.
# For now, we rely on ms365_create-mail-attachment-upload-session being called first,
# then immediately call this with the URL.

if len(sys.argv) < 3:
    print("Usage: starupload.py <upload_url> <file_path>")
    sys.exit(1)

upload_url = sys.argv[1]
file_path = sys.argv[2]

with open(file_path, 'rb') as f:
    data = f.read()

fs = len(data)
print(f"Uploading {file_path} ({fs} bytes) ...", end=" ")

req = urllib.request.Request(upload_url, data=data, method='PUT', headers={
    'Content-Length': str(fs),
    'Content-Range': f'bytes 0-{fs-1}/{fs}'
})

try:
    resp = urllib.request.urlopen(req)
    r = json.loads(resp.read())
    print(f"DONE: {r.get('name','ok')} ({r.get('size','')} bytes)")
    sys.exit(0)
except urllib.error.HTTPError as e:
    body = e.read().decode()
    print(f"FAIL: HTTP {e.code}")
    print(body[:500])
    sys.exit(1)
