# Marmalade v1.0.0 — Android Agent Communication Hub
# Project: CSMApps/Marmalade
# Built for command-line compilation: ./gradlew assembleDebug

## MARMALADE CORE CONCEPT

Marmalade is the "Jam" between all Kilo AI agent sessions. It replaces GitHub-based
COMMS with a native Android messaging platform that can:
1. Route messages between 100+ simultaneous agent sessions
2. Load multiple app.kilo.ai/cloud WebView sessions
3. Track agent heartbeats and census in real-time
4. Distribute APK files and research documents to agents
5. Execute directives from CITADEL (Director-0001) to any authorized agent
6. Extend to Bluetooth/WiFi/GPS/3D mapping in future versions

## TREE ARCHITECTURE (Roots → Branches → Leaves)

```
CSMApps/Marmalade/v1.0.0/          ← ROOT: project root
├── app/                            ← BRANCH: Android application module
│   ├── build.gradle.kts            ← LEAF: app dependencies & config
│   ├── src/
│   │   ├── main/                   ← BRANCH: main source set
│   │   │   ├── AndroidManifest.xml
│   │   │   ├── java/com/carrpod/marmalade/
│   │   │   │   ├── MarmaladeApp.kt          ← LEAF: Application class
│   │   │   │   ├── hub/                      ← BRANCH: core hub module
│   │   │   │   │   ├── AgentManager.kt       ← LEAF: agent lifecycle
│   │   │   │   │   ├── MessageHubService.kt  ← LEAF: foreground service
│   │   │   │   │   └── ConnectivityReceiver.kt
│   │   │   │   ├── models/Models.kt          ← LEAF: all data types
│   │   │   │   ├── network/                  ← BRANCH: networking
│   │   │   │   ├── storage/                  ← BRANCH: Room database
│   │   │   │   │   ├── MarmaladeDatabase.kt
│   │   │   │   │   └── Daos.kt
│   │   │   │   ├── ui/                       ← BRANCH: Compose UI
│   │   │   │   │   ├── MainActivity.kt
│   │   │   │   │   ├── screens/MarmaladeApp.kt + ViewModel
│   │   │   │   │   ├── components/           ← BRANCH: reusable UI
│   │   │   │   │   └── theme/Theme.kt + Type.kt
│   │   │   │   ├── security/                 ← BRANCH: auth & encryption
│   │   │   │   └── util/                     ← BRANCH: utilities
│   │   │   └── res/                          ← BRANCH: resources
│   │   ├── test/                             ← BRANCH: unit tests
│   │   └── androidTest/                      ← BRANCH: instrumentation tests
│   └── proguard-rules.pro                    ← LEAF
├── build.gradle.kts                          ← LEAF
├── settings.gradle.kts                       ← LEAF
├── gradle.properties                         ← LEAF
├── gradle/wrapper/                           ← BRANCH: Gradle wrapper
└── docs/                                     ← BRANCH: documentation
```

## BUILD INSTRUCTIONS

Prerequisites:
- Android SDK CLI Tools (or ANDROID_HOME set)
- JDK 17+
- Gradle 8.2+

```bash
# Set ANDROID_HOME
export ANDROID_HOME=~/Android/Sdk

# Build debug APK
./gradlew assembleDebug
# APK at: app/build/outputs/apk/debug/app-debug.apk

# Build release APK (requires keystore)
./gradlew assembleRelease
# APK at: app/build/outputs/apk/release/app-release.apk

# Install to device
adb install app/build/outputs/apk/debug/app-debug.apk

# Clean
./gradlew clean
```

## FUTURE PATHWAYS

v2.0: Bluetooth Low Energy agent discovery
v3.0: WiFi Direct file transfer mesh
v4.0: GPS + Visual 3D surface mapping
v5.0: WebView-based Kilo session orchestrator (100 sessions)
