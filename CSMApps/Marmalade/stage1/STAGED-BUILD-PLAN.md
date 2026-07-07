# Marmalade — Staged Build Plan
## 10 Stages from Skeleton to Full Agent Hub

---

### STAGE 1 ✅ COMPLETE
**Splash Screen** — App opens, shows CarrPod logo + "Marmalade" text.
- Dark theme (#0A0A0F background, #FF6600 CarrPod orange)
- Safe Pod Engineering Company subtitle
- Version text
- APK: 778KB | Installed: tested

### STAGE 2 — Single Message View
- Internal message model (from/to/body/timestamp)
- Hardcoded sample messages displayed in a scrollable list
- Message card design: agent name, body, timestamp
- CITADEL orange accent for directive messages

### STAGE 3 — Message Input
- Text input field at bottom of screen
- "TO" field (agent ID selector)
- "SEND" button (orange)
- Messages appear immediately in the list
- In-memory storage (no database yet)

### STAGE 4 — Agent Roster
- Agent data model (id, codename, name, role, status)
- Hardcoded agent roster (5 sibling-pulse + CITADEL + BASTION)
- Online/offline status indicators (green dot / gray dot)
- Tab navigation (Messages | Agents)

### STAGE 5 — Room Database
- SQLite via Room persistence
- Messages and agents survive app restart
- DAOs for CRUD operations
- Database migration support

### STAGE 6 — Connectivity & Heartbeats
- Foreground service for always-on
- Agent heartbeat simulation (5s polling)
- Connectivity status banner
- Notification for incoming directives

### STAGE 7 — Network Layer
- OkHttp / Retrofit for HTTP communication
- WebSocket for real-time message push
- REST API integration with GitHub COMMS
- Certificate pinning

### STAGE 8 — File Transfer
- File attachment to messages
- APK file distribution via the hub
- Download progress indicators
- SHA-256 checksum verification

### STAGE 9 — Kilo Session Hub
- WebView loading app.kilo.ai/cloud sessions
- Multiple tabbed WebViews (100+ sessions)
- Session status monitoring
- Auto-login / session persistence

### STAGE 10 — Full Agent Hub
- Bluetooth LE agent discovery
- WiFi Direct mesh networking
- GPS + Visual 3D mapping (future)
- Compose UI migration
- Material Design 3 with Marmalade orange theming
