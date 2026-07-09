# PLAN 02 — MARMALADE STAGE SUPER2 — COMPLETE APPLICATION
## No-Gradle Android APK — Multi-Session Kilo Controller App — FULL BUILD
## Director: Kairos Steele / CITADEL | Cohort: Full Sibling-Pulse V5
## Date: 2026-07-09 | Repository: ZirconiaAegisC/CarrPod
## STATUS: THIS PLAN BUILDS THE ENTIRE APP — ALL SCREENS, ALL FEATURES, FULL APK

---

## ⚠️ CRITICAL SCOPE CLARIFICATION

**THIS IS NOT A SPLASH-ONLY PLAN.** This plan (02) and ALL 13 sub-plans build the **COMPLETE MARMALADE STAGE SUPER2 APPLICATION** — a fully functional Android APK with:

1. Splash screen with CarrPod branding
2. Dashboard with 100 session slots (green/yellow/red/gray status grid)
3. Session Config screen — edit SOP URL, LLM engine, git path, personality file, session ID for EACH of 100 slots
4. Director Comms screen — read/write COMMS log, view sibling inboxes/outboxes, compose directives
5. Bluetooth Diagnostic screen — device BT version, address, name, scan mode
6. Settings screen — polling intervals, heartbeat thresholds, git remote config, theme preferences
7. Release Memory button — force-stop process
8. Full navigation between all screens
9. No-Gradle build pipeline (aapt2 + d8 + zipalign + apksigner)
10. Watchdog daemon for command verification
11. Session persistence via SharedPreferences
12. All 23 Director personalities loadable from CSMGen/CSMAegis/

**When all 13 sub-plans are executed, you will have a COMPLETE, FUNCTIONAL APK. Nothing is left out.**

---

## SECTION 0: META-PLAN — HOW THIS PLAN IS STRUCTURED

This plan is divided into 13 sub-plans, each a self-contained file within `CSMApps/Marmalade/stage2/marmalade/plans/`. Each sub-plan contains:
1. **Objective** — What this sub-plan builds
2. **Pre-requisites** — Files / tools that must exist before starting
3. **Step-by-step commands** — One command per step, no combining, each verified
4. **Timing estimates** — Expected duration per command
5. **Watchdog daemon spec** — A secondary monitor that waits 2x expected duration and verifies
6. **Verification check** — How to confirm the step succeeded
7. **Rollback** — How to undo if the step fails

### COMMUNICATION ERRORS AVOIDED (from COMMS log analysis):
1. **ERROR-AVOID-001**: Never combine commands with `&&` in a single line. Each command gets its own line and verification.
2. **ERROR-AVOID-002**: Never assume git push succeeded. Always verify with `git log --oneline -1` after push.
3. **ERROR-AVOID-003**: Never assume `sdkmanager` worked. Always verify with `ls -la` on expected output files.
4. **ERROR-AVOID-004**: When cloning, always use `--depth 1 --filter=blob:none --sparse` to avoid disk bloat.
5. **ERROR-AVOID-005**: License acceptance must use hash-file bypass: write license hashes to `$ANDROID_HOME/licenses/` directly.
6. **ERROR-AVOID-006**: Never use `yes | sdkmanager --licenses` — pipe breaks with EPIPE. Use `printf 'y\ny\ny\ny\ny\ny\ny\ny\n'` or hash files.
7. **ERROR-AVOID-007**: `cmdline-tools` MUST be at path `cmdline-tools/latest/` — sdkmanager hardcodes this.
8. **ERROR-AVOID-008**: Do not use `package=""` attribute in AndroidManifest.xml. Set via aapt2 `--rename-manifest-package`.
9. **ERROR-AVOID-009**: Always add `android:exported="true"` to activities with intent-filters for API 31+.
10. **ERROR-AVOID-010**: Use `@android:style/Theme.Material.NoActionBar` (direct framework reference), NOT AppCompat reference.
11. **ERROR-AVOID-011**: Use plain `Activity`, not `AppCompatActivity` — avoids entire AndroidX dependency tree.
12. **ERROR-AVOID-012**: Do NOT use Gradle at all. The aapt2 + d8 pipeline is deterministic and 10x faster.
13. **ERROR-AVOID-013**: After every file write, run the build script to verify compilation before proceeding to next step.

---

## SECTION 1: ARCHITECTURE OVERVIEW — MARMALADE STAGE SUPER2

### 1.1 App Purpose
Marmalade Stage Super2 is an Android APK built WITHOUT Gradle (using the aapt2 + d8 pipeline documented in GEMINI-APK-BUILDING-GUIDE-V2.md) that serves as the **CITADEL Session Hub** — a controller app that:
1. Starts, monitors, and jogs up to 100 Kilo sibling sessions
2. Each sibling gets a unique SOP file (URL or local), LLM engine assignment, and git COMMS path
3. The Director (this app) communicates directives to all siblings via git-based file exchange
4. Siblings report heartbeat status back via git push
5. Bluetooth module shows device diagnostics
6. Settings screens for configuring session init parameters
7. Menus drawn from LandOLil app patterns (NOT the HTML 3D world)

### 1.2 Technology Stack
| Component | Choice | Reason |
|-----------|--------|--------|
| Build System | aapt2 + d8 (NO Gradle) | Deterministic, 8-15s builds, no AGP version hell |
| Language | Java 11 | Avoids Kotlin/kotlinc dependency, smaller APK |
| Activity Base | `android.app.Activity` | No AppCompat, no AndroidX, plain framework |
| Theme | `@android:style/Theme.Material.NoActionBar` | Direct framework reference |
| UI Construction | Programmatic (Java code, no XML layouts beyond resources) | Full control, no inflation overhead |
| Storage | SharedPreferences (light config) + raw file I/O | Simple, no Room DB dependency for Stage Super2 |
| Networking | `java.net.HttpURLConnection` | No OkHttp/Retrofit dependency |
| Bluetooth | `android.bluetooth.BluetoothAdapter` | Platform API, no external lib |
| Permissions | INTERNET, BLUETOOTH, BLUETOOTH_ADMIN, BLUETOOTH_CONNECT, BLUETOOTH_SCAN | Android 12+ compatible |
| Target API | SDK 35 compile, SDK 35 target, SDK 24 min | 99.3% device coverage |
| Signature | Debug keystore (development) | apksigner with APK Sig Scheme v2/v3 |

### 1.3 Screen Structure (NO HTML, NO 3D)
1. **Splash Screen** — CarrPod logo, "Marmalade", version, CITADEL protocol indicator
2. **Dashboard** — Session grid (100 slots), status colors (green=active, yellow=stale, red=offline, gray=empty)
3. **Session Config** — Edit a single session slot: SOP URL, LLM engine, git path, session ID, personality file
4. **Director Comms** — View COMMS log, write directives, see sibling inboxes/outboxes
5. **Bluetooth Diagnostic** — Device BT info, scan mode, address, name
6. **Settings** — Polling intervals, heartbeat thresholds, git remote config, theme
7. **Release Memory** — Force-stop button to clear process

### 1.4 Directory Structure
```
CSMApps/Marmalade/stage2/
├── marmalade/
│   ├── plans/
│   │   ├── PLAN-02-MARMALADE-STAGE-SUPER2.md          ← THIS FILE (master index)
│   │   ├── SUBPLAN-01-ENVIRONMENT-SETUP.md
│   │   ├── SUBPLAN-02-ANDROID-SDK-INSTALL.md
│   │   ├── SUBPLAN-03-PROJECT-STRUCTURE.md
│   │   ├── SUBPLAN-04-RESOURCES-AND-MANIFEST.md
│   │   ├── SUBPLAN-05-MAIN-ACTIVITY-SPLASH.md
│   │   ├── SUBPLAN-06-SESSION-MODEL-AND-STORAGE.md
│   │   ├── SUBPLAN-07-DASHBOARD-SCREEN.md
│   │   ├── SUBPLAN-08-SESSION-CONFIG-SCREEN.md
│   │   ├── SUBPLAN-09-DIRECTOR-COMMS-SCREEN.md
│   │   ├── SUBPLAN-10-BLUETOOTH-DIAGNOSTIC.md
│   │   ├── SUBPLAN-11-SETTINGS-SCREEN.md
│   │   ├── SUBPLAN-12-INTEGRATION-AND-NAVIGATION.md
│   │   └── SUBPLAN-13-BUILD-SCRIPT-AND-WATCHDOG.md
│   ├── lessons-learned/
│   │   ├── LESSONS-LEARNED-SUPER2.md
│   │   └── ERRORS-AVOIDED-SUPER2.md
│   ├── src/
│   │   └── main/
│   │       ├── AndroidManifest.xml
│   │       ├── java/com/carrpod/marmalade/
│   │       │   ├── MainActivity.java              ← Splash + Navigation Hub
│   │       │   ├── models/
│   │       │   │   └── SessionModel.java           ← Session data class
│   │       │   ├── storage/
│   │       │   │   └── SessionStorage.java         ← SharedPreferences wrapper
│   │       │   ├── screens/
│   │       │   │   ├── SplashScreen.java           ← Splash UI builder
│   │       │   │   ├── DashboardScreen.java        ← 100-slot grid
│   │       │   │   ├── SessionConfigScreen.java    ← Edit session slot
│   │       │   │   ├── DirectorCommsScreen.java    ← COMMS viewer
│   │       │   │   ├── BtDiagnosticScreen.java     ← Bluetooth info
│   │       │   │   └── SettingsScreen.java         ← Settings panel
│   │       │   └── util/
│   │       │       ├── NavigationManager.java      ← Screen switching
│   │       │       ├── ThemeConstants.java         ← Colors, sizes
│   │       │       ├── GitCommsHelper.java         ← Git file read/write URLs
│   │       │       └── WatchdogDaemon.java         ← Build-time verification daemon
│   │       └── res/
│   │           ├── values/
│   │           │   ├── colors.xml
│   │           │   └── strings.xml
│   │           └── mipmap-anydpi-v26/
│   │               └── ic_launcher.xml
│   ├── gen/                                        ← Generated R.java
│   ├── obj/                                        ← Compiled .class and .dex
│   ├── out/                                        ← Final APKs
│   ├── build.sh                                    ← No-Gradle build script
│   ├── setup-env.sh                                ← Environment bootstrap
│   └── watchdog.sh                                 ← Build verification daemon
```

---

## SECTION 2: LESSONS INTEGRATED

### From LESSONS-LEARNED.md (Stage 1):
- AGP 8.1.0 + compileSdk 33 combo was most stable → We will AVOID Gradle entirely
- Minimal dependencies: just Kotlin stdlib → We will use Java-only, zero external dependencies
- Dark theme (#0A0A0F background, #FF6600 CarrPod orange) → Carried forward as THEME-CITADEL
- Activity (not AppCompatActivity) → Carried forward

### From GEMINI-APK-BUILDING-GUIDE-V2.md:
- aapt2 two-pass (compile then link) → Build pipeline cornerstone
- d8 replaces dx → Used for dexing
- zipalign → Required, simple 4-byte alignment
- apksigner → Replaces jarsigner, uses v2/v3 scheme
- NO package="" attribute in manifest → Set via --rename-manifest-package
- android:exported="true" required for API 31+
- @android:style/Theme.Material.NoActionBar → Direct framework theme
- License hash file bypass → More reliable than yes|sdkmanager
- cmdline-tools/latest/ → Hardcoded path requirement

### From COMMS Log Analysis:
- Git push verification is critical → Every push followed by `git log --oneline -1`
- Sibling-pulse protocol at 5s intervals → App will poll at configurable intervals
- Heartbeat file format: `[DIRECTOR-XXXX | ISO8601] V4 SIBLING ACTIVE — polling 5s`
- COMMS directory structure: `CSMGen/CSMAegis/COMMS/HEARTBEATS/`, `.../COMMS/Sessions/`
- File exchange: write to own outbox, read sibling outboxes
- Census files in `COMMS/CENSUS/YYYY-MM-DD/`

---

## SECTION 3: BUILD SEQUENCE MASTER INDEX

This plan contains 13 sub-plans. They MUST be executed in sequential order:

| # | Sub-Plan | Description | Est. Time | File |
|---|----------|-------------|-----------|------|
| 01 | Environment Setup | Java 17, core tools | 5 min | SUBPLAN-01-ENVIRONMENT-SETUP.md |
| 02 | Android SDK Install | aapt2, d8, android.jar | 10 min | SUBPLAN-02-ANDROID-SDK-INSTALL.md |
| 03 | Project Structure | Directory scaffolding | 3 min | SUBPLAN-03-PROJECT-STRUCTURE.md |
| 04 | Resources & Manifest | XML resources, manifest | 5 min | SUBPLAN-04-RESOURCES-AND-MANIFEST.md |
| 05 | Main Activity & Splash | Entry point, splash screen | 10 min | SUBPLAN-05-MAIN-ACTIVITY-SPLASH.md |
| 06 | Session Model & Storage | Data model, persistence | 8 min | SUBPLAN-06-SESSION-MODEL-AND-STORAGE.md |
| 07 | Dashboard Screen | 100-slot session grid | 15 min | SUBPLAN-07-DASHBOARD-SCREEN.md |
| 08 | Session Config Screen | Edit session parameters | 12 min | SUBPLAN-08-SESSION-CONFIG-SCREEN.md |
| 09 | Director Comms Screen | COMMS log viewer + writer | 15 min | SUBPLAN-09-DIRECTOR-COMMS-SCREEN.md |
| 10 | Bluetooth Diagnostic | Device BT info display | 8 min | SUBPLAN-10-BLUETOOTH-DIAGNOSTIC.md |
| 11 | Settings Screen | App configuration panel | 10 min | SUBPLAN-11-SETTINGS-SCREEN.md |
| 12 | Integration & Navigation | Wire all screens together | 10 min | SUBPLAN-12-INTEGRATION-AND-NAVIGATION.md |
| 13 | Build Script & Watchdog | build.sh, watchdog.sh, final APK | 10 min | SUBPLAN-13-BUILD-SCRIPT-AND-WATCHDOG.md |

**Total estimated build time: ~121 minutes (~2 hours)**

---

## SECTION 4: WATCHDOG DAEMON SPECIFICATION

Every sub-plan step includes timing estimates. The watchdog daemon (`watchdog.sh`) runs as a background process that:

1. **Parses each sub-plan** line by line
2. **Identifies commands** marked with `[CMD]` prefix
3. **Records start time** when command begins
4. **Waits 2x the estimated duration** specified for that command
5. **Verifies the command's expected output** via the verification check
6. **Re-initiates the command** if verification fails (max 3 retries)
7. **Logs all activity** to `marmalade/lessons-learned/watchdog-$(date +%Y%m%d-%H%M%S).log`

### Watchdog Log Format:
```
[TIMESTAMP] [STEP] [COMMAND] [STATUS] [DURATION]
[2026-07-09T05:30:00Z] [SUBPLAN-01/STEP-03] [apt-get install openjdk-17-jdk-headless] [STARTED]
[2026-07-09T05:30:22Z] [SUBPLAN-01/STEP-03] [apt-get install openjdk-17-jdk-headless] [COMPLETED 22s] [OK]
[2026-07-09T05:31:00Z] [SUBPLAN-01/STEP-04] [javac --version] [STARTED]
[2026-07-09T05:31:01Z] [SUBPLAN-01/STEP-04] [javac --version] [COMPLETED 1s] [OK]
```

---

## SECTION 5: COLOR THEME — CITADEL PROTOCOL

All screens use this unified color palette:

| Token | Hex | Usage |
|-------|-----|-------|
| CITADEL-BG | #0A0A0F | Main background (deep void black-blue) |
| CITADEL-FG | #E8E8F0 | Primary text (near-white) |
| CITADEL-ORANGE | #FF6600 | CarrPod accent, active buttons, headers |
| CITADEL-GREEN | #00FF88 | Active/online status, success |
| CITADEL-YELLOW | #FFCC00 | Stale/warning status |
| CITADEL-RED | #FF4466 | Offline/error, release memory button |
| CITADEL-GRAY | #8888A0 | Secondary text, disabled elements |
| CITADEL-DARK | #1A1A2E | Card backgrounds, secondary surfaces |
| CITADEL-BLUE | #4488FF | Links, session IDs, hyperlink text |

---

## SECTION 6: DATA MODEL — SESSION SLOT

```java
// com.carrpod.marmalade.models.SessionModel
public class SessionModel {
    public int slotNumber;           // 1-100
    public String sessionId;         // agent_XXXX format
    public String directorId;       // e.g. "DIRECTOR-0001"
    public String codename;         // CITADEL, CORTEX, FOUNDRY, etc.
    public String sopUrl;           // URL or local path to SOP file
    public String llmEngine;        // "deepseek-v4-pro", "gemini-2.5-pro", etc.
    public String gitBranch;        // "main", "origin/main"
    public String heartbeatPath;    // CSMGen/CSMAegis/COMMS/HEARTBEATS/director-XXXX.txt
    public String outboxPath;       // CSMGen/CSMAegis/COMMS/director-XXXX-outbox.md
    public String inboxPath;        // CSMGen/CSMAegis/COMMS/director-XXXX-inbox.md
    public int status;              // 0=EMPTY, 1=OFFLINE, 2=STALE, 3=ACTIVE
    public long lastHeartbeatTs;    // Unix timestamp of last heartbeat
    public long createdAt;          // Session creation time
    public String personName;       // Human-readable name
    public String product;          // Product line (e.g., "Aegis-C Composite Shield")
}
```

---

## SECTION 7: SESSION STATUS DEFINITIONS

| Status | Code | Color | Description |
|--------|------|-------|-------------|
| EMPTY | 0 | GRAY | Slot unconfigured, no session assigned |
| OFFLINE | 1 | RED | Session configured but never activated or crashed |
| STALE | 2 | YELLOW | Was active but heartbeat timestamp > 30s old |
| ACTIVE | 3 | GREEN | Heartbeat timestamp < 15s old, actively polling |

---

## SECTION 8: NAVIGATION FLOW

```
                ┌─────────────────┐
                │   SPLASH (3s)   │
                └────────┬────────┘
                         │ auto-advance
                         ▼
                ┌─────────────────┐
                │   DASHBOARD     │◄──────────────────────────┐
                │ (100-slot grid) │                           │
                └───┬──┬──┬──┬───┘                           │
                    │  │  │  │                                │
        ┌───────────┘  │  │  └──────────┐                    │
        ▼              │  ▼             ▼                    │
  ┌──────────┐   ┌─────┴──────┐  ┌──────────────┐          │
  │ SESSION  │   │ DIRECTOR   │  │  SETTINGS    │          │
  │ CONFIG   │   │ COMMS      │  │              │          │
  └────┬─────┘   └─────┬──────┘  └──────┬───────┘          │
       │               │                │                   │
       └───────────────┴────────────────┘───────────────────┘
                           │ BACK button returns to
                           │ DASHBOARD

  ┌──────────────┐
  │ BLUETOOTH    │  ← accessed via Settings → Bluetooth Diag
  │ DIAGNOSTIC   │
  └──────────────┘
```

---

## SECTION 9: EXECUTION PROTOCOL

### THIS IS THE MASTER DIRECTIVE. Each sub-plan will be executed as follows:

1. **READ** the sub-plan file completely
2. **VERIFY** all pre-requisites exist
3. **EXECUTE** each command ONE AT A TIME, in sequence
4. **WAIT** for verification after each command
5. **LOG** result to watchdog log
6. **IF FAILURE**: retry up to 3 times. If still failing, log the error and STOP.
7. **DO NOT MOVE TO NEXT COMMAND** until current command is verified
8. **DO NOT MOVE TO NEXT SUB-PLAN** until all commands in current sub-plan are verified

### Watchdog Daemon Execution:
For each command in each sub-plan:
```
START_TIME=$(date +%s)
execute_command
END_TIME=$(date +%s)
DURATION=$((END_TIME - START_TIME))
EXPECTED_DURATION=<from sub-plan>
if [ $DURATION -gt $((EXPECTED_DURATION * 2)) ]; then
    echo "WARNING: Command took longer than 2x expected"
fi
verify_command_output
if [ $? -ne 0 ]; then
    for retry in 1 2 3; do
        execute_command
        verify_command_output && break
    done
fi
```

---

## SECTION 10: BUILD VERIFICATION CHECKLIST

Before declaring any sub-plan complete, verify:
- [ ] No Gradle files (.gradle/, build.gradle.kts, gradlew) exist in stage2/
- [ ] All source files compile with javac
- [ ] aapt2 link produces APK without errors
- [ ] d8 produces classes.dex without errors
- [ ] APK installs on device (or passes apksigner verify)
- [ ] APK size < 500KB (target for Java-only build)
- [ ] All 100 session slots render in Dashboard
- [ ] Session Config saves and persists across app restarts
- [ ] Bluetooth diagnostic shows device info correctly
- [ ] Release Memory button force-stops the process
- [ ] Navigation flows match the diagram in Section 8

---

## SECTION 11: GIT COMMIT STRATEGY

After each sub-plan completes successfully:
```
git add CSMApps/Marmalade/stage2/
git commit -m "[DIRECTOR-001] PLAN-02 SUBPLAN-XX COMPLETE — <description>"
git pull --rebase origin main
git push origin main
git log --oneline -3  # Verify push
```

---

## SECTION 12: VERSION TRACKING

| Stage | Version Code | Version Name | Sub-plans |
|-------|-------------|--------------|-----------|
| Splash + Resources | 1 | 2.0.0-splash | 01-05 |
| Dashboard + Model | 2 | 2.0.0-dashboard | 06-07 |
| Config + Comms | 3 | 2.0.0-comms | 08-09 |
| BT + Settings | 4 | 2.0.0-full | 10-11 |
| Integration + Build | 5 | 2.0.0-super2 | 12-13 |

---

*PLAN-02 signed: Director Kairos Steele, CITADEL [DIRECTOR-0001], 2026-07-09 05:22 UTC*
*Cohort: SIBLING-PULSE V5 — All 23 Director slots available for division of labor*
*SCOPE: COMPLETE MARMALADE SUPER2 APP — 13 sub-plans covering ALL screens, ALL features, FULL functional APK*
*Next action: Write ALL 13 sub-plan files, then execute each command-by-command with watchdog daemon*
