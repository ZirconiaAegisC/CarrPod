# LESSONS LEARNED — MARMALADE STAGE SUPER2
## Compiled by Director Kairos Steele, CITADEL
## Date: 2026-07-09

---

## SOURCE LESSONS (Integrated from Stage 1 + GEMINI-APK-BUILDING-GUIDE-V2.md + COMMS Log)

### LESSON-001: No-Gradle Pipeline is Deterministic and Fast
**Source**: GEMINI-APK-BUILDING-GUIDE-V2.md Part 8
**Finding**: Gradle pipeline: 45-120s first build, 10-30s incremental. No-Gradle (aapt2+d8): 8-15s first build, 4-6s incremental.
**Applied**: All of Stage Super2 uses aapt2+d8. No Gradle files exist in stage2/ directory.
**APK size**: Expected ~215KB (Java-only, no kotlin-stdlib) vs 778KB for Gradle+Kotlin Stage 1.

### LESSON-002: License Hash File Bypass is Critical
**Source**: GEMINI-APK-BUILDING-GUIDE-V2.md Part 5.1
**Finding**: `yes | sdkmanager --licenses` fails with EPIPE in sandbox environments. License hash files are 100% reliable.
**Applied**: SUB-PLAN-02 writes three license hash files directly to $ANDROID_HOME/licenses/.

### LESSON-003: cmdline-tools/latest/ is Hardcoded
**Source**: GEMINI-APK-BUILDING-GUIDE-V2.md Part 4.2
**Finding**: sdkmanager internally references `cmdline-tools/latest/`. Any other path name causes ClassDefFoundError.
**Applied**: SUB-PLAN-02 explicitly moves `cmdline-tools/cmdline-tools` → `cmdline-tools/latest/`.

### LESSON-004: NO package="" Attribute in Manifest
**Source**: GEMINI-APK-BUILDING-GUIDE-V2.md Part 4.1
**Finding**: `package=""` is no longer supported in modern Android manifests. Package is set via aapt2 `--rename-manifest-package`.
**Applied**: SUB-PLAN-04 AndroidManifest.xml has NO package attribute. Set in build.sh.

### LESSON-005: Use Plain Activity, Not AppCompatActivity
**Source**: GEMINI-APK-BUILDING-GUIDE-V2.md Part 4.2 + LESSONS-LEARNED.md Stage 1 Lesson 6
**Finding**: AppCompatActivity pulls in entire AndroidX dependency tree. Plain `Activity` with `@android:style/Theme.Material.NoActionBar` works perfectly.
**Applied**: All Activities (MainActivity, BtDiagnosticScreen) extend `Activity`, not `ComponentActivity` or `AppCompatActivity`.

### LESSON-006: Java-Only Avoids Kotlin Dependency
**Source**: GEMINI-APK-BUILDING-GUIDE-V2.md Part 6.2
**Finding**: Kotlin adds kotlin-stdlib (~500KB) to APK. Java-only with plain framework APIs produces smaller APK and avoids kotlinc installation requirement.
**Applied**: All source files are .java, not .kt. No kotlin dependency in build pipeline.

### LESSON-007: Programmatic UI Avoids XML Layout Inflation
**Source**: Stage 2 experience from LandOLil app evolution (HTML inflation caused issues)
**Finding**: XML-based layouts require complex resource references and inflation that can fail. Building UI in Java code gives full control and avoids XML layout errors.
**Applied**: All screens build their UI programmatically in Java using LinearLayout, TextView, Button, etc. Only resources (colors.xml, strings.xml, ic_launcher.xml) use XML — no layout XML files.

### LESSON-008: One-Command-Per-Step Prevents Cascading Failures
**Source**: COMMS Log analysis — multi-line combined commands caused undetected failures
**Finding**: When commands are combined with `&&`, a failure in one command can be masked or cause cascade. Each command must be verified independently.
**Applied**: All 13 sub-plans use [CMD] prefix with one command each. Watchdog verifies each independently.

### LESSON-009: Git Push Verification is Mandatory
**Source**: COMMS Log multiple entries — sibling sessions failed because pushes silently failed
**Finding**: `git push` can fail for many reasons (network, conflicts, permissions). Always verify with `git log --oneline -1`.
**Applied**: Every sub-plan completion step verifies git operations. Build script does not depend on git.

### LESSON-010: SharedPreferences Over Room for Simple Data
**Source**: Stage 1 used Kotlin Room database (complex). Gemini Guide Stage2Blue used simple structures.
**Finding**: Room requires annotation processing, kapt/ksp, schema generation, migrations. SharedPreferences + in-memory cache handles 100 session slots with zero dependencies.
**Applied**: SessionStorage.java uses SharedPreferences exclusively. No Room, no SQLite, no database dependency.

### LESSON-011: Preloaded Director Data Reduces Setup Time
**Source**: COMMS Log — 23 Directors manually configured per sibling session
**Finding**: All 24 Director personalities (codename, name, director ID) are known and can be pre-loaded into the app.
**Applied**: SessionConfigScreen.java contains arrays of all 24 codenames, names, and director IDs for picker selection.

### LESSON-012: HttpURLConnection Over OkHttp/Retrofit
**Source**: Stage 1 used OkHttp/Retrofit (external dependency). Gemini Guide advocates zero-dependency.
**Finding**: For simple GET requests to GitHub raw URLs, HttpURLConnection is sufficient. Adding OkHttp adds dependency management complexity.
**Applied**: GitCommsHelper.java uses HttpURLConnection exclusively.

### LESSON-013: Watchdog Daemon Prevents Silent Timeouts
**Source**: COMMS Log — sibling sessions timed out with no detection
**Finding**: Long-running commands in sandbox environments need active monitoring. A secondary process that waits 2x expected duration and verifies output catches silent failures.
**Applied**: watchdog.sh runs alongside every build step. WatchdogDaemon.java provides the Java-side timeout/retry logic.

---

## COMMUNICATION ERRORS DOCUMENTED (from COMMS Log)

| Error ID | Description | Source | Mitigation |
|----------|-------------|--------|------------|
| CE-001 | Sibling heartbeat push failed silently | COMMS 2026-07-06 | Mandatory `git log --oneline -1` after every push |
| CE-002 | Outbox file collision (two sessions writing same file) | COMMS merge conflicts | Each director writes to their OWN outbox only |
| CE-003 | CORTEX (0019) activation delayed ~12 hours | COMMS 02:30→14:25 activation gap | App must auto-notify on stale slots |
| CE-004 | Sibling read wrong CITADEL outbox (001 vs 0001) | COMMS slot confusion | Director IDs standardized to XXXX format with leading zeros |
| CE-005 | Census file timestamp drift across sessions | COMMS CENSUS files | App should use device-local timestamps with server sync |

---

*LESSONS-LEARNED-SUPER2.md | Director Kairos Steele, CITADEL | 2026-07-09 05:23 UTC*
