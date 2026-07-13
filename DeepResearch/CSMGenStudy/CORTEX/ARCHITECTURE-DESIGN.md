# Marmalade Architecture Design
## CORTEX Research — Android App Architecture Patterns

### Executive Summary
Marmalade requires a robust architecture for an always-on Android messaging hub capable of managing 100+ concurrent agent sessions. After evaluating MVVM, MVI, and Clean Architecture, the recommended approach is **MVVM + Clean Architecture hybrid** with Jetpack Compose.

### Architecture Decision: MVVM + Clean Architecture

Layer 0 (Data): Room Database, OkHttp networking, SharedPreferences
Layer 1 (Domain): Repository pattern, UseCases, Models
Layer 2 (Presentation): ViewModels + Jetpack Compose UI
Layer 3 (Service): Foreground Service for always-on connectivity

### Data Flow
```
Agent → MessageHubService → AgentManager → Room DB → Repository → ViewModel → Compose UI
                   ↑                                                         |
                   └─────────────────────────────────────────────────────────┘
```

### Key Architectural Decisions
1. **Single Activity** — `MainActivity` hosts all Compose screens via Navigation Compose
2. **Room Database** — Single source of truth for agents, messages, heartbeats, files, sessions
3. **Foreground Service** — `MessageHubService` runs always-on, manages WebSocket connections
4. **Repository Pattern** — `AgentManager` acts as central repository decoupling data sources from UI
5. **Unidirectional Data Flow (UDF)** — ViewModels expose StateFlows, UI collects and renders

### Component Tree (Root → Branches → Leaves)
```
MarmaladeApp (ROOT)
├── MessageStream (BRANCH) — message routing UI
│   ├── MessageCard (LEAF) — individual message display
│   └── MessageInputBar (LEAF) — compose + send
├── AgentRoster (BRANCH) — agent management
│   └── AgentCard (LEAF) — agent status display
├── SessionBrowser (BRANCH) — Kilo WebView sessions
│   └── WebViewTile (LEAF) — individual session WebView
└── CommandConsole (BRANCH) — CITADEL directives
    └── StatRow (LEAF) — census statistics
```

### Directory Structure (Root → Branches → Leaves)
```
CSMApps/Marmalade/v1.0.0/          ← ROOT
├── app/                            ← Android module BRANCH
│   ├── src/main/java/com/carrpod/marmalade/ ← package ROOT
│   │   ├── hub/                    ← BRANCH: core hub logic
│   │   ├── models/                 ← LEAF: data types
│   │   ├── network/               ← BRANCH: networking
│   │   ├── storage/               ← BRANCH: Room database
│   │   ├── ui/screens/            ← BRANCH: compose screens
│   │   ├── ui/components/         ← BRANCH: reusable widgets
│   │   ├── ui/theme/              ← LEAF: visual theme
│   │   ├── security/              ← BRANCH: auth/encryption
│   │   └── util/                  ← BRANCH: utilities
│   └── src/main/res/              ← BRANCH: Android resources
└── docs/                           ← BRANCH: documentation
```
