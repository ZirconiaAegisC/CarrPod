# SEND-PIPELINE.md — 5-Step Delivery
## CSMSOPP000004-V2-M05

### The Proven Pipeline (from painful experience)
```
1. ms365_create-draft-email     → draft ID
2. ms365_create-mail-attachment-upload-session → upload URL
   → curl PUT immediately (within 5 seconds!)
3. ms365_create-mail-attachment-upload-session → upload URL
   → curl PUT immediately
4. ms365_create-mail-attachment-upload-session → upload URL
   → curl PUT immediately
5. ms365_send-draft-message     → SENT
```

### CRITICAL RULES
- **Sequential only.** Never parallel attachments on same draft.
- **curl immediately.** Upload session tokens live ~90 seconds.
- **Verify after send.** Check sent folder for hasAttachments=true.
- **NEVER use ms365_send-mail for attachments.** It drops them silently.
