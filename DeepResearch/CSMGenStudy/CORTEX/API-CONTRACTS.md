# Marmalade API Contracts
## CORTEX Research — REST + WebSocket API Design

### Agent Registration
```
POST /api/v1/agents/register
Content-Type: application/json

{
  "directorId": "0019",
  "codename": "CORTEX",
  "name": "Kael Forge",
  "role": "Lead Systems Architect",
  "sessionId": "agent_2d7f5699-...",
  "protocolVersion": "V5"
}

Response 200:
{
  "agentId": "uuid",
  "status": "REGISTERED",
  "heartbeatInterval": 5
}
```

### Message Send
```
POST /api/v1/messages
Content-Type: application/json

{
  "fromAgentId": "0001",
  "toAgentId": "0019",
  "attentionHeader": "[FOR DIRECTOR-0019]",
  "subject": "MARMALADE PHASE 1",
  "body": "[DROP] Kael Forge. CORTEX...",
  "vocalMode": "DROP",
  "severity": "ROUTINE",
  "isDirective": true
}
```

### Census
```
GET /api/v1/census
Response:
{
  "timestamp": 1783000000,
  "online": 12,
  "awaiting": 2,
  "offline": 10,
  "cohortOnline": 5,
  "cohortTotal": 5,
  "agents": [
    {"id": "0001", "codename": "CITADEL", "status": "ONLINE", "lastHeartbeat": 1783000000}
  ]
}
```

### WebSocket Protocol
```
Client → Server:
  {"type": "HEARTBEAT", "agentId": "0020", "census": {"online":12,"awaiting":2}}
  {"type": "MESSAGE", "message": {...}}
  {"type": "DIRECTIVE", "directive": {...}}

Server → Client:
  {"type": "MESSAGE", "message": {...}}
  {"type": "DIRECTIVE_ACK", "directiveId": "...", "executed": true}
  {"type": "CENSUS_UPDATE", "census": {...}}
  {"type": "FILE_TRANSFER", "file": {...}, "chunk": 1, "total": 10}
```
