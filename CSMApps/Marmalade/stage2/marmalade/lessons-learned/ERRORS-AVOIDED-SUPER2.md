# ERRORS AVOIDED — MARMALADE STAGE SUPER2
## Compilation of ALL errors encountered + avoided in this build
## Director Kairos Steele, CITADEL | 2026-07-09

---

## BUILD SYSTEM ERRORS AVOIDED

| # | Error | Stage Where It Would Occur | Mitigation |
|---|-------|---------------------------|------------|
| E-001 | `package="..." is no longer supported` | Manifest processing (aapt2 link) | Manifest has no package attribute; set via `--rename-manifest-package` |
| E-002 | `android:exported needs to be explicitly specified` | API 31+ (Android 12) runtime crash | All activities with intent-filters have `android:exported="true"` |
| E-003 | `Hardcoded string, should use @string resource` | aapt2 compile warning | All strings in colors.xml/strings.xml; all text set in Java or via resources |
| E-004 | `Build was configured to prefer settings repos` | Gradle (if used) | No Gradle used — aapt2+d8 pipeline entirely |
| E-005 | `yes \| sdkmanager --licenses` EPIPE failure | SDK install | License hash files written directly to $ANDROID_HOME/licenses/ |
| E-006 | `JAVA_HOME is set to an invalid directory` | javac step | JAVA_HOME explicitly set to /usr/lib/jvm/java-17-openjdk-amd64 |
| E-007 | `ClassDefFoundError: javax/xml/bind` | sdkmanager (wrong path) | cmdline-tools at `cmdline-tools/latest/` (hardcoded) |
| E-008 | `Unresolved reference: AppCompatActivity` | Compile (if AppCompatActivity used) | Uses plain `Activity` class only |
| E-009 | `Theme.Material.NoActionBar crash at runtime` | App launch (AppCompat bridge) | Uses `@android:style/Theme.Material.NoActionBar` (direct framework) |
| E-010 | `@mipmap/ic_launcher not found` | APK install/launch | Adaptive icon XML at res/mipmap-anydpi-v26/ic_launcher.xml |
| E-011 | `INTERNET permission missing` | WebView/network access | INTERNET permission declared in manifest |
| E-012 | `BLUETOOTH_CONNECT permission missing` | API 31+ Bluetooth access | BLUETOOTH_CONNECT declared with neverForLocation flag |
| E-013 | `NAMESPACE_NOT_SPECIFIED` AGP error | Gradle (if used) | Set via aapt2 `--rename-manifest-package` |
| E-014 | `AGP version mismatch` (8.1 vs 8.2) | Gradle (if used) | No AGP/no Gradle |
| E-015 | `allprojects { repositories {} }` block error | Gradle settings.gradle | No Gradle files at all |

## RUNTIME ERRORS AVOIDED

| # | Error | Mitigation |
|---|-------|------------|
| E-016 | APK installs but immediately closes | Launcher icon exists, theme references correct, NoActionBar used |
| E-017 | SecurityException on getAddress()/getName() | BtDiagnosticScreen wraps Bluetooth calls in try-catch with SecurityException handling |
| E-018 | NullPointerException on null SharedPreferences | SessionStorage initializes all fields with empty defaults |
| E-019 | IndexOutOfBounds on session slot | Dashboard grid loops 0-99, session storage checks bounds |
| E-020 | Memory leak from unreleased handler references | MainActivity uses Handler on main looper, screen switching replaces root views |

## ARCHITECTURE ERRORS AVOIDED

| # | Error | Mitigation |
|---|-------|------------|
| E-021 | Dependency hell from Gradle + AGP + Kotlin plugin | Zero external dependencies, pure Java + Android framework |
| E-022 | APK bloat from kotlin-stdlib (~500KB) | Java-only source, expected APK <250KB |
| E-023 | Room database annotation processing complexity | SharedPreferences + in-memory cache for 100 slots |
| E-024 | Compose/AndroidX migration breaking changes | Plain Activity + programmatic UI, no Compose |
| E-025 | HTML/WebView rendering inconsistencies | Zero WebView usage. All text rendered natively. |
| E-026 | 3D/Canvas rendering performance issues | Zero 3D. Zero HTML. Flat UI with standard Views. |

## GIT COMMUNICATIONS ERRORS AVOIDED

| # | Error | Mitigation |
|---|-------|------------|
| E-027 | Push failure undetected | Every git op verified with log check |
| E-028 | Merge conflict from concurrent sibling writes | Each director writes to own file; no shared files |
| E-029 | Sparse checkout missing needed files | Complete clone of required paths; verified after each pull |
| E-030 | Token auth failure for private repos | Token stored in Settings with masked display |

---

## COMMAND COMBINATION ERRORS AVOIDED

**ERROR-AVOID-001 through ERROR-AVOID-013** (see PLAN-02 Section 0) are all enforced by the sub-plan structure:
- One command per [CMD] block
- Verification check for every command
- Rollback procedure for every command
- Watchdog daemon monitors every step
- 3 retries maximum, 2x timeout threshold

---

*ERRORS-AVOIDED-SUPER2.md | Director Kairos Steele, CITADEL | 2026-07-09 05:23 UTC*
