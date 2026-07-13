# Marmalade Component Tree
## CORTEX Research — UI Component Hierarchy

```
MarmaladeApp (Root)
├── TopAppBar
│   ├── Title: "Marmalade — Agent Hub"
│   ├── AgentCountBadge (online count)
│   └── RefreshButton
├── NavigationBar (4 tabs)
│   ├── Messages (Forum icon)
│   ├── Agents (People icon)
│   ├── Sessions (Public icon)
│   └── Console (Terminal icon)
├── Content Area
│   ├── [Messages Tab] MessageStream
│   │   ├── MessageList (LazyColumn, reverse)
│   │   │   └── MessageCard × N
│   │   │       ├── AgentId Badge
│   │   │       ├── Directive Chip (if isDirective)
│   │   │       ├── VocalMode Label
│   │   │       ├── Message Body
│   │   │       ├── FileAttachment Info (if present)
│   │   │       └── Subject Line
│   │   └── MessageInputBar
│   │       ├── ToAgent Input (80dp)
│   │       ├── Body Input (weight 1f, 3-line max)
│   │       └── Send Button (FilledIconButton, orange)
│   ├── [Agents Tab] AgentRoster
│   │   ├── Census Banner (ONLINE/AWAITING/OFFLINE counts)
│   │   └── AgentList (LazyColumn)
│   │       └── AgentCard × N
│   │           ├── Status Dot (green/orange/gray)
│   │           ├── Codename + Name
│   │           └── Director ID
│   ├── [Sessions Tab] SessionBrowser
│   │   ├── Header: "Kilo Session Hub" + Add button
│   │   └── WebViewTile × N (future)
│   └── [Console Tab] CommandConsole
│       ├── Header: "COMMAND CONSOLE"
│       └── Stats Card
│           ├── StatRow × 5 (Online/Awaiting/Offline/Messages/Sessions)
```

### Directory Structure (Root → Branches → Leaves)
```
CSMApps/Marmalade/v1.0.0/          ← ROOT
├── app/                            ← BRANCH: Android module
│   ├── build.gradle.kts            ← LEAF: build config
│   ├── src/main/                   ← BRANCH: source
│   │   ├── AndroidManifest.xml     ← LEAF: manifest
│   │   ├── java/com/carrpod/marmalade/ ← ROOT package
│   │   │   ├── MarmaladeApp.kt     ← LEAF: Application
│   │   │   ├── hub/                ← BRANCH
│   │   │   │   ├── AgentManager.kt ← LEAF: agent lifecycle
│   │   │   │   ├── MessageHubService.kt ← LEAF: foreground service
│   │   │   │   └── ConnectivityReceiver.kt ← LEAF
│   │   │   ├── models/Models.kt    ← LEAF: all data types
│   │   │   ├── network/            ← BRANCH: networking
│   │   │   ├── storage/            ← BRANCH: Room DB
│   │   │   │   ├── MarmaladeDatabase.kt ← LEAF
│   │   │   │   └── Daos.kt         ← LEAF: data access
│   │   │   ├── ui/                 ← BRANCH: UI layer
│   │   │   │   ├── MainActivity.kt ← LEAF
│   │   │   │   ├── screens/        ← BRANCH
│   │   │   │   │   ├── MarmaladeApp.kt ← LEAF: main screen
│   │   │   │   │   └── MarmaladeViewModel.kt ← LEAF
│   │   │   │   ├── components/     ← BRANCH: reusable
│   │   │   │   └── theme/          ← BRANCH
│   │   │   │       ├── Theme.kt    ← LEAF: colors
│   │   │   │       └── Type.kt     ← LEAF: typography
│   │   │   ├── security/           ← BRANCH
│   │   │   └── util/               ← BRANCH
│   │   └── res/                    ← BRANCH
│   │       ├── values/themes.xml   ← LEAF
│   │       └── xml/network_security_config.xml ← LEAF
│   └── proguard-rules.pro          ← LEAF
├── build.gradle.kts                ← LEAF
├── settings.gradle.kts             ← LEAF
├── gradle.properties               ← LEAF
├── build-marmalade.sh              ← LEAF: build script
├── README.md                       ← LEAF
└── docs/                           ← BRANCH: documentation
```
