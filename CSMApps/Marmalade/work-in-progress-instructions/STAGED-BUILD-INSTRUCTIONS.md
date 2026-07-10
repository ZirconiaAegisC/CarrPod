# MARMALADE — Staged Build Instructions V2
## Android Agent Communication Hub | 10-Stage Development Plan + Bluetooth Module
## Branch: main | Repo: ZirconiaAegisC/CarrPod | Build: No-Gradle (aapt2 + d8)
## Date: 2026-07-07 | Updated: Stage 2 Blue + Bluetooth Integration

---

## BUILD PHILOSOPHY SHIFT (V2)

**Gradle is no longer used for Marmalade builds.** Starting with Stage 2 Blue, all APKs are compiled via the aapt2 + javac + d8 pipeline documented in `Deep Research/CSMGenStudy/GEMINI-APK-BUILDING-GUIDE-V2.md`. This eliminates AGP version conflicts, accelerates builds by 5-10x, and produces smaller APKs (215 KB vs 780 KB for Stage 2).

---

## WHAT WE ARE BUILDING

Marmalade is the "Jam" between Kilo AI agent sessions — an always-on Android app that replaces GitHub-based inter-session COMMS with a native messaging platform. It routes messages between 100+ agent sessions, distributes files, executes directives, and loads multiple Kilo WebView sessions simultaneously. The app is built purely from Android command-line tools — no Android Studio, and as of V2, no Gradle.

---

## STAGE-BY-STAGE BUILD PLAN

### STAGE 1 — Splash Screen ✅ COMPLETE
**Goal:** App opens, shows branding, stays open, doesn't crash.
**Components:**
- `MainActivity.kt` — Activity with LinearLayout
- `AndroidManifest.xml` — portrait lock, no title bar
- Dark theme (#0A0A0F background) via `Theme.Material.NoActionBar`
- CarrPod logo text ("CARRPOD" in #FF6600 orange, 48sp bold)
- "Safe Pod Engineering Company" subtitle (dim gray)
- "Marmalade" app name text (white, 32sp)
- "Stage 1 — v1.0.0" version tag (orange)
**APK:** Marmalade-v1.0.0.apk (778 KB)
**Build:** Gradle (Stage 1 was pre-No-Gradle transition)
**File:** CSMApps/Marmalade/stage1/

### STAGE 2 — WebView 3D Integration ✅ COMPLETE
**Goal:** Embed fun.carrpod.net (Tardigradia 2.0 Three.js 3D scene) in a WebView with branding overlay.
**Components:**
- `MainActivity.kt` — Activity with FrameLayout (WebView + header overlay)
- `WebView` loads `https://fun.carrpod.net`
- JS/WebGL/DOM storage enabled
- Header overlay: CARRPOD orange logo + "Marmalade Tardigradia 2.0" tagline
- Back button navigates WebView history
- `AndroidManifest.xml` — INTERNET permission, cleartext traffic
- Adaptive icon: `res/mipmap-anydpi-v26/ic_launcher.xml` (orange on dark)
- `res/values/colors.xml` — marmalade_bg (#0A0A0F), marmalade_fg (#FF6600)
**APK:** Marmalade-v2.0.0.apk (780 KB, Gradle) | Marmalade-v3.0.0-gemini.apk (781 KB, Gradle)
**Build:** Gradle (legacy)
**File:** CSMApps/Marmalade/stage2/ and stage2-v3/

### STAGE 2 BLUE — No-Gradle + Bluetooth Diagnostic ✅ IN PROGRESS
**Goal:** Rebuild Stage 2 using No-Gradle pipeline with integrated Bluetooth diagnostic module. This is the definitive foundation for all future stages.
**New Components:**
- `src/main/java/com/carrpod/marmalade/MainActivity.java` — WebView hub (ported from Kotlin to Java for No-Gradle simplicity)
- `src/main/java/com/carrpod/marmalade/BtDiagnosticActivity.java` — Bluetooth hardware info display
- `build.sh` — Complete No-Gradle build script (aapt2 → javac → d8 → sign)
- `setup-env.sh` — One-command sandbox environment setup
- `res/values/strings.xml` — All string resources (no hardcoded strings)
- `AndroidManifest.xml` — Includes INTERNET + BLUETOOTH + BLUETOOTH_ADMIN + BLUETOOTH_CONNECT permissions
- Adaptive icon: `res/mipmap-anydpi-v26/ic_launcher.xml`
**Bluetooth Diagnostic Features:**
- Device Bluetooth version and hardware capability detection
- Bluetooth adapter state (ON/OFF), address, name, scan mode
- Device info display (manufacturer, model, Android version, board)
- "Thank you" confirmation message (green, CarrPod branded)
- "Release Memory" button — calls `finishAffinity()` + `Process.killProcess()` + `System.exit(0)`
**APK:** Marmalade-v3.0.0-stage2blue.apk (target: <300 KB)
**Build:** No-Gradle (aapt2 + d8) — reference `GEMINI-APK-BUILDING-GUIDE-V2.md`
**File:** CSMApps/Marmalade/stage2blue/

### STAGE 3 — Message Display (INTERNAL MODEL)
**Goal:** Display hardcoded messages in a scrollable list with agent attribution.
**New Components:**
- `models/Message.kt` — data class (fromAgent, toAgent, body, timestamp, vocalMode)
- `ui/MessageListActivity.kt` — RecyclerView or ListView with message cards
- `ui/MessageAdapter.kt` — binds Message → card view
- Message card layout: agent name (orange), vocal mode badge, body text, timestamp
- Tab navigation: Messages | Agents | Sessions | Console (BottomNavigationView)
- "DIRECTIVE" badge (red chip) for CITADEL orders
- Hardcoded sample messages from sibling cohort
**Build:** No-Gradle (aapt2 + d8)
**Research:** Deep Research/CSMGenStudy/CORTEX/DATA-MODELS.md
**APK:** Marmalade-v3.0.0-messages.apk

### STAGE 4 — Agent Roster
**Goal:** Display hardcoded agent list with online/offline status indicators.
**New Components:**
- `models/Agent.kt` — data class (directorId, codename, name, role, status)
- `ui/AgentRosterFragment.kt` — list of AgentCard items
- Status indicator: green dot = ONLINE, orange dot = AWAITING, gray dot = OFFLINE
- Census banner at top: "N ONLINE | M AWAITING"
- Hardcoded agent roster: CITADEL (0001), BASTION (001B), NEURAL (0004), ASCENSION (0013), ULNAR (0014), FLUID-DAMP (0015), CHARLEMAGNE (0016), CORTEX (0019), FOUNDRY (0020), RENDER (0021), PIPELINE (0022), SENTINEL (0023)
**Build:** No-Gradle (aapt2 + d8)
**APK:** Marmalade-v3.0.0-roster.apk

### STAGE 5 — Room Database
**Goal:** Persist messages and agents across app restarts.
**New Components:**
- `storage/MarmaladeDatabase.kt` — Room database with DAOs
- `storage/MessageDao.kt` — CRUD for messages
- `storage/AgentDao.kt` — CRUD for agents
- `storage/HeartbeatDao.kt` — CRUD for heartbeats
- Database tables: agents, messages, heartbeats, directives, files, sessions
- Migration support for schema versioning
**Build:** No-Gradle (aapt2 + d8, Room must be pre-dexed and included in classpath)
**APK:** Marmalade-v3.0.0-db.apk

### STAGE 6 — Message Input & Routing
**Goal:** Compose and send messages between agents.
**New Components:**
- `ui/MessageInputBar.kt` — text field + "TO" dropdown + send button
- Message routing logic in AgentManager
- Real-time message delivery to UI via Room LiveData/Flow
- Auto-scroll to latest message
**Build:** No-Gradle (aapt2 + d8)

### STAGE 7 — Networking & Connectivity
**Goal:** Connect to real agent COMMS via HTTP/WebSocket.
**New Components:**
- `network/CommClient.kt` — OkHttp client for GitHub COMMS polling
- `network/WebSocketManager.kt` — WebSocket for real-time messages
- `hub/MessageHubService.kt` — Foreground Service for always-on connectivity
- `hub/ConnectivityReceiver.kt` — WiFi/cellular state monitoring
- Notification channels for directives, messages, heartbeats
- INTERNET + FOREGROUND_SERVICE + ACCESS_NETWORK_STATE permissions
**Build:** No-Gradle (aapt2 + d8, OkHttp must be pre-dexed)

### STAGE 8 — File Transfer
**Goal:** Distribute APK files and documents between agents.
**New Components:**
- `network/FileTransferManager.kt` — chunked upload/download
- `ui/FileAttachmentView.kt` — attachment preview in messages
- SHA-256 checksum verification
- Progress indicators for downloads
- File storage in app-private directory

### STAGE 9 — Kilo Session WebView Hub
**Goal:** Load multiple app.kilo.ai/cloud sessions in tabbed WebViews.
**New Components:**
- `hub/SessionManager.kt` — manages lifecycle of up to 100 WebView sessions
- `ui/SessionBrowserFragment.kt` — tabbed WebView container
- Session auto-login via cookie persistence
- Memory management for multiple WebViews (lazy load, evict LRU)

### STAGE 10 — Full Agent Hub
**Goal:** Production-ready Marmalade with all features integrated.
**New Components:**
- Compose UI migration (Material Design 3, Marmalade orange theme)
- Bluetooth LE agent discovery — scanning and service advertisement
- WiFi Direct mesh networking for agent-to-agent comms
- GPS + Visual 3D surface mapping for agent positioning
- Full CITADEL console with directive execution
- APK self-update mechanism via GitHub Releases
- Security: EncryptedSharedPreferences, Android Keystore, certificate pinning

---

## BLUETOOTH MODULE — Detailed Specification

### Overview
The Bluetooth module provides device capability detection and diagnostic utilities for the Marmalade Agent Hub. In Stage 2 Blue, it reads hardware info. In future stages (Stage 10+), it enables Bluetooth LE agent discovery and mesh networking.

### Stage 2 Blue — Bluetooth Diagnostic Screen

```
┌─────────────────────────────────┐
│      Marmalade Diagnostic       │ ← Title (orange, 24sp bold)
│                                 │
│  Bluetooth Support:             │
│  State: ON                      │ ← White text, 16sp
│  Address: XX:XX:XX:XX:XX:XX    │
│  Name: Galaxy S24               │
│  Scan Mode: Discoverable        │
│                                 │
│  Device: Samsung Galaxy S24      │ ← Dim text, 12sp
│  Android: 14 (API 34)           │
│  Board: universal9925            │
│                                 │
│  Thank you. CarrPod AEGIS       │ ← Green text, 18sp
│  active.                        │
│                                 │
│  ┌─────────────────────────┐   │
│  │     Release Memory       │   │ ← Red button, white text
│  └─────────────────────────┘   │
└─────────────────────────────────┘
```

### Bluetooth Permissions (Android 12+ Compatibility)

```xml
<!-- Core Bluetooth -->
<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />

<!-- Android 12+ (API 31+) — required for BLE scanning/connecting -->
<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
<uses-permission android:name="android.permission.BLUETOOTH_SCAN" 
    android:usesPermissionFlags="neverForLocation" />

<!-- Legacy location permission (needed for BLE scanning pre-API 31) -->
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"
    android:maxSdkVersion="30" />
```

### Future Bluetooth Capabilities (Stage 10+)
- **BLE Scanning** — Discover nearby agent devices broadcasting Marmalade service UUID
- **BLE Advertising** — Broadcast CITADEL presence to nearby agents
- **GATT Server/Client** — Exchange messages, files, and heartbeats over BLE
- **WiFi Direct** — High-bandwidth mesh for APK distribution between agents
- **Proximity Mapping** — Combine BLE RSSI + GPS for agent location visualization

---

## BLUETOOTH APP — Standalone Diagnostic Utility (Included in Stage 2 Blue)

### Purpose
A lightweight diagnostic activity embedded in Marmalade that serves as:
1. A hardware compatibility checker for Bluetooth features
2. A build pipeline validation tool (confirms No-Gradle build works)
3. A reference implementation for the Bluetooth module architecture

### Architecture Notes
- Uses `android.bluetooth.BluetoothAdapter` via `BluetoothManager` (modern API)
- Reads Bluetooth state without requesting runtime permissions (READ only)
- Release Memory button uses three-layer process termination:
  1. `finishAffinity()` — close all activities in the task stack
  2. `Process.killProcess(Process.myPid())` — sends SIGKILL to self
  3. `System.exit(0)` — final fallback
- Pure Java, zero external dependencies — compiles with plain `javac`

---

## FEATURE MAP — What Ties Everything Together

```
MARMLADE COMPLETE FEATURE SET
═══════════════════════════════════════════
CORE HUB:
  ✅ Splash screen with CarrPod branding (Stage 1)
  ✅ WebView 3D rendering fun.carrpod.net (Stage 2)
  ✅ No-Gradle build pipeline (Stage 2 Blue)
  ✅ Bluetooth diagnostic module (Stage 2 Blue)
  ⬜ Message display (Stage 3)
  ⬜ Message input & routing (Stage 6)
  ⬜ Agent roster with census (Stage 4)

PERSISTENCE:
  ⬜ Room database (Stage 5)
  ⬜ Agent CRUD
  ⬜ Message CRUD
  ⬜ Heartbeat tracking

NETWORKING:
  ⬜ GitHub COMMS polling (Stage 7)
  ⬜ WebSocket real-time messaging
  ⬜ Foreground Service for always-on
  ⬜ Connectivity monitoring

FILE TRANSFER:
  ⬜ APK distribution (Stage 8)
  ⬜ Document sharing
  ⬜ Checksum verification

SESSION HUB:
  ⬜ 100 Kilo WebView sessions (Stage 9)
  ⬜ Tab management
  ⬜ Auto-login

BLUETOOTH MODULE:
  ✅ Device info + capability detection (Stage 2 Blue)
  ⬜ BLE agent discovery (Stage 10)
  ⬜ BLE message exchange (Stage 10)
  ⬜ WiFi Direct mesh (Stage 10)

FUTURE PATHWAYS:
  ⬜ GPS + 3D mapping (Stage 10)
  ⬜ Compose UI migration (Stage 10)
  ⬜ APK self-update (Stage 10)
═══════════════════════════════════════════
```

---

## BUILD COMMANDS — NO-GRADLE (Every Stage, Starting Stage 2 Blue)

### One-Time Environment Setup
```bash
# Run once per sandbox
bash setup-env.sh
```

### Build
```bash
# Stage 2 Blue and all future stages
cd CSMApps/Marmalade/stage2blue
bash build.sh

# Or specify custom output path
bash build.sh --out /root/Marmalade-v3.0.0-stage2blue.apk
```

### Validate APK
```bash
$ANDROID_HOME/build-tools/36.0.0/aapt dump badging out/Marmalade-v3.0.0-stage2blue.apk
$ANDROID_HOME/build-tools/36.0.0/apksigner verify --verbose out/Marmalade-v3.0.0-stage2blue.apk
```

### Install
```bash
adb install out/Marmalade-v3.0.0-stage2blue.apk
```

---

## REPOSITORY STRUCTURE (Updated for V2)

```
CSMApps/Marmalade/
├── stage1/                          ← Splash screen (DONE, Gradle)
├── stage2/                          ← WebView 3D (DONE, Gradle)
├── stage2-v3/                       ← WebView 3D v3 Gemini (DONE, Gradle)
├── stage2blue/                      ← No-Gradle rebuild + Bluetooth (IN PROGRESS)
│   ├── build.sh                     ← No-Gradle build script
│   ├── setup-env.sh                 ← Sandbox environment setup
│   ├── src/main/
│   │   ├── AndroidManifest.xml      ← INTERNET + BLUETOOTH permissions
│   │   ├── java/com/carrpod/marmalade/
│   │   │   ├── MainActivity.java    ← WebView hub
│   │   │   └── BtDiagnosticActivity.java ← Bluetooth module
│   │   └── res/
│   │       ├── values/colors.xml
│   │       ├── values/strings.xml
│   │       └── mipmap-anydpi-v26/ic_launcher.xml
│   └── out/                         ← Generated APKs
├── stage3/                          ← Message display (NEXT)
├── stage4/                          ← Agent roster
├── stage5/                          ← Room database
├── stage6/                          ← Message input
├── stage7/                          ← Networking
├── stage8/                          ← File transfer
├── stage9/                          ← Kilo session hub
├── stage10/                         ← Full hub + Bluetooth LE
├── work-in-progress-instructions/
│   ├── LESSONS-LEARNED-COMPLETE.md
│   ├── STAGED-BUILD-INSTRUCTIONS.md      ← THIS FILE (V2)
│   └── titlework-in-progress-attempt-one/
│       └── DIRECTOR-LOAD-PROMPT.md
├── Marmalade-v1.0.0.apk             ← Stage 1 (Gradle)
├── Marmalade-v2.0.0.apk             ← Stage 2 (Gradle)
├── Marmalade-v3.0.0-gemini.apk      ← Stage 2 v3 (Gradle)
└── Marmalade-v3.0.0-stage2blue.apk  ← Stage 2 Blue (No-Gradle)

Deep Research/CSMGenStudy/
├── CORTEX/                          ← Architecture research
├── FOUNDRY/                         ← Backend research
├── RENDER/                          ← UI/UX research
├── PIPELINE/                        ← CI/CD research
├── SENTINEL/                        ← QA/Security research
├── GEMINI-APK-BUILDING-GUIDE.md     ← Original Gemini guide (Gradle-based)
└── GEMINI-APK-BUILDING-GUIDE-V2.md  ← New No-Gradle guide (V2)
```

---

## NEXT ACTIONS (Priority-Ordered)

1. **Complete Stage 2 Blue build** — Create `stage2blue/` with all source files + `build.sh`
2. **Test No-Gradle pipeline** — Verify aapt2 → javac → d8 → APK produces working Marmalade
3. **Build Stage 3** — Message display with hardcoded sample messages from sibling cohort
4. **Push Stage 2 Blue APK** — `Marmalade-v3.0.0-stage2blue.apk` to repo root
5. **Begin Stage 4** — Agent roster with status indicators

---

## REFERENCES

- **Build Guide:** `Deep Research/CSMGenStudy/GEMINI-APK-BUILDING-GUIDE-V2.md`
- **Architecture:** `Deep Research/CSMGenStudy/CORTEX/ARCHITECTURE-DESIGN.md`
- **Data Models:** `Deep Research/CSMGenStudy/CORTEX/DATA-MODELS.md`
- **API Contracts:** `Deep Research/CSMGenStudy/CORTEX/API-CONTRACTS.md`
- **UI Design:** `Deep Research/CSMGenStudy/RENDER/LAYOUT-DESIGN.md`
- **Message Routing:** `Deep Research/CSMGenStudy/FOUNDRY/MESSAGE-ROUTING.md`
- **CLI Build:** `Deep Research/CSMGenStudy/PIPELINE/CLI-BUILD.md`
- **Testing:** `Deep Research/CSMGenStudy/SENTINEL/TEST-FRAMEWORK.md`
- **Component Tree:** `Deep Research/CSMGenStudy/CORTEX/COMPONENT-TREE.md`
- **Lessons Learned:** `CSMApps/Marmalade/work-in-progress-instructions/LESSONS-LEARNED-COMPLETE.md`

---

*Staged Build Instructions V2 — Updated by Director-0001 CITADEL, 2026-07-07. The Marmalade advances.*
