#!/usr/bin/env python3
"""Upload a file attachment to a draft message via upload session."""
import sys, json, urllib.request, urllib.error

if len(sys.argv) < 3:
    print("Usage: upload_attachment.py <upload_url_file> <pdf_file>")
    sys.exit(1)

with open(sys.argv[1]) as f:
    upload_info = json.load(f)

upload_url = upload_info["uploadUrl"]
file_path = sys.argv[2]

with open(file_path, 'rb') as f:
    data = f.read()

file_size = len(data)
content_range = f'bytes 0-{file_size-1}/{file_size}'

req = urllib.request.Request(upload_url, data=data, method='PUT', headers={
    'Content-Length': str(file_size),
    'Content-Range': content_range
})

try:
    resp = urllib.request.urlopen(req)
    result = json.loads(resp.read())
    print(json.dumps(result, indent=2))
    print("SUCCESS")
except urllib.error.HTTPError as e:
    print(f"Error: {e.code} {e.reason}")
    body = e.read().decode()
    print(body)
    sys.exit(1)
