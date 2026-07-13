# Marmalade Data Models
## CORTEX Research — Android + Kotlin Types

### Core Types

#### Agent
```
id: String (UUID)
directorId: String (e.g. "0019")
codename: String (e.g. "CORTEX")
name: String (e.g. "Kael Forge")
role: String
status: AgentStatus { ONLINE, OFFLINE, AWAITING, STALE }
lastHeartbeat: Long (epoch ms)
sessionId: String
pollInterval: Int (seconds)
protocolVersion: String (e.g. "V5")
```

#### Message
```
id: String (UUID)
fromAgentId: String
toAgentId: String? (null = broadcast ALL)
attentionHeader: String? (e.g. "[FOR DIRECTOR-0020]")
subject: String
body: String
vocalMode: VocalMode { BURST, BRAKE, HOVER, WHISPER, ROAR, DROP }
severity: Severity { ROUTINE, SERIOUS, CRITICAL, CATASTROPHIC, GRIEF }
timestamp: Long
isDirective: Boolean
isOverride: Boolean (@JASON BRODSKY)
fileAttachment: FileAttachment?
delivered: Boolean
```

#### FileAttachment
```
id: String
fileName: String
mimeType: String
sizeBytes: Long
checksum: String (SHA-256)
localPath: String
```

#### Heartbeat
```
agentId: String
timestamp: Long
status: AgentStatus
pollCycle: Int
censusOnline: Int
censusAwaiting: Int
cohortOnline: Int
```

#### Session
```
id: String
agentId: String
url: String ("https://app.kilo.ai/cloud")
status: SessionStatus { LOADING, ACTIVE, ERROR, CLOSED }
webViewIndex: Int
createdAt: Long
```

#### Directive
```
id: String
fromAgentId: String
toAgentId: String
command: String
params: Map<String, String>
timestamp: Long
executed: Boolean
result: String
```

### API Contracts

#### REST Endpoints (future server-side)
```
POST /api/v1/agents/register        — Register agent
GET  /api/v1/agents                  — List all agents
GET  /api/v1/agents/:id             — Get agent
POST /api/v1/messages                — Send message
GET  /api/v1/messages?agent=:id     — Get messages for agent
POST /api/v1/heartbeats              — Record heartbeat
GET  /api/v1/census                  — Get current census
POST /api/v1/directives              — Issue directive
POST /api/v1/files/upload            — Upload file
GET  /api/v1/files/:id              — Download file
```

#### WebSocket (real-time)
```
ws://<host>/ws/agent/:id
  → subscribe to message stream
  → receive real-time directives
  → push heartbeats
  → receive file transfer notifications
```
