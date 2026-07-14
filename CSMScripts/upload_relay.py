#!/usr/bin/env python3
import json, sys, urllib.request, urllib.error, os

# Read upload session JSON from stdin
session_json = sys.stdin.read()
session = json.loads(session_json)
upload_url = session.get('uploadUrl')
if not upload_url:
    print("ERROR: No uploadUrl", file=sys.stderr)
    sys.exit(1)

file_path = sys.argv[1]
with open(file_path, 'rb') as f:
    data = f.read()

fs = len(data)
req = urllib.request.Request(upload_url, data=data, method='PUT', headers={
    'Content-Length': str(fs),
    'Content-Range': f'bytes 0-{fs-1}/{fs}'
})
try:
    resp = urllib.request.urlopen(req)
    code = resp.getcode()
    body = resp.read().decode() or '{}'
    try:
        r = json.loads(body)
        name = r.get('name', '')
        size = r.get('size', '')
        print(json.dumps({"status":"ok","code":code,"name":name,"size":size}))
    except:
        print(json.dumps({"status":"ok","code":code}))
except urllib.error.HTTPError as e:
    print(json.dumps({"status":"error","http_code":e.code,"body":e.read().decode()[:300]}))
