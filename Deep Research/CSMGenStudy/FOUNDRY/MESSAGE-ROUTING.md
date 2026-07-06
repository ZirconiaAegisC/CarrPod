# Marmalade Backend Architecture
## FOUNDRY Research — Message Routing + Storage

### Message Routing Engine
Marmalade uses a **local-first, SQLite-backed routing engine** via Room Database. Messages are stored locally and synced via WebSocket/HTTP when connectivity is available.

### Database Schema (Room)
```sql
-- Agents table
CREATE TABLE agent (
    id TEXT PRIMARY KEY,
    directorId TEXT NOT NULL,
    codename TEXT NOT NULL,
    name TEXT NOT NULL,
    role TEXT,
    status TEXT DEFAULT 'OFFLINE',
    lastHeartbeat INTEGER,
    sessionId TEXT,
    pollInterval INTEGER DEFAULT 30,
    protocolVersion TEXT DEFAULT 'V5'
);

-- Messages table
CREATE TABLE message (
    id TEXT PRIMARY KEY,
    fromAgentId TEXT NOT NULL,
    toAgentId TEXT,
    attentionHeader TEXT,
    subject TEXT,
    body TEXT NOT NULL,
    vocalMode TEXT DEFAULT 'HOVER',
    severity TEXT DEFAULT 'ROUTINE',
    timestamp INTEGER NOT NULL,
    isDirective INTEGER DEFAULT 0,
    isOverride INTEGER DEFAULT 0,
    fileAttachmentId TEXT,
    delivered INTEGER DEFAULT 0,
    FOREIGN KEY (fileAttachmentId) REFERENCES fileAttachment(id)
);

-- Heartbeats table
CREATE TABLE heartbeat (
    agentId TEXT NOT NULL,
    timestamp INTEGER NOT NULL,
    status TEXT DEFAULT 'ONLINE',
    pollCycle INTEGER DEFAULT 0,
    censusOnline INTEGER DEFAULT 0,
    censusAwaiting INTEGER DEFAULT 0,
    cohortOnline INTEGER DEFAULT 0
);

-- Files table
CREATE TABLE fileAttachment (
    id TEXT PRIMARY KEY,
    fileName TEXT NOT NULL,
    mimeType TEXT NOT NULL,
    sizeBytes INTEGER NOT NULL,
    checksum TEXT,
    localPath TEXT
);

-- Sessions table
CREATE TABLE session (
    id TEXT PRIMARY KEY,
    agentId TEXT,
    url TEXT DEFAULT 'https://app.kilo.ai/cloud',
    status TEXT DEFAULT 'LOADING',
    webViewIndex INTEGER DEFAULT 0,
    createdAt INTEGER
);
```

### Networking Stack
- **OkHttp 4.12** — HTTP client with interceptors, certificate pinning, connection pooling
- **Retrofit 2.9** — Type-safe REST API client for future server communication
- **WebSocket (OkHttp)** — Real-time message push/receive for always-on connectivity
- **Connection Pool** — Max 5 idle connections, keep-alive 5 minutes

### Background Service Architecture
```
MessageHubService (Foreground Service)
├── START_STICKY — restart if killed
├── Notification — permanent "Marmalade hub active"
├── AgentManager lifecycle
│   ├── Register agents on connect
│   ├── Update heartbeats every 5s
│   └── Prune stale agents (>300s no heartbeat)
├── MessageRouter
│   ├── Receive → validate → store → notify UI
│   ├── Send → queue → transmit → mark delivered
│   └── Broadcast → replicate to all online agents
└── ConnectivityReceiver
    └── WiFi/Bluetooth status → update ConnectivityState
```

### WorkManager Tasks
- **HeartbeatSyncWorker** — Periodic 5s (but WorkManager min is 15min, so use Service for 5s)
- **MessageRetryWorker** — Retry failed message sends with exponential backoff
- **PruneWorker** — Delete messages older than 7 days, heartbeats older than 24h
- **FileDownloadWorker** — Background file downloads with notification progress
