# VERIFICATION-LAYER.md — Post-Send Audit
## CSMSOPP000004-V2-M08

### After Every 5 Sends
```
ms365_list-mail-folder-messages(sentitems, top=5)
→ Verify hasAttachments=true on each
→ Log any hasAttachments=false for immediate retry
```

### After Every 10 Sends
```
ms365_list-mail-folder-messages(inbox, search="undeliverable")
→ Log bounced addresses to SEND-STATE.md UNDELIVERABLE section
→ Classify error type
→ Update domain blacklist if policy violation
```

### After Campaign Batch Complete
```
Full audit: ms365_list-mail-folder-messages(sentitems, top=50)
→ Cross-reference with SEND-STATE.md
→ Flag discrepancies
```
