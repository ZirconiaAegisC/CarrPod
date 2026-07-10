# MARMALADE — Complete Lessons Learned & Error Avoidance Guide
## Session: agent_256111d2 | 2026-07-06 through 2026-07-07
## All lessons from: CLI APK building, sibling communication, agent coordination, app design

---

# PART 1: BUILDING ANDROID APKs FROM COMMAND LINE (No Android Studio)

## 1.1 Environment Setup Errors & Fixes

### ERROR 1: `JAVA_HOME is set to an invalid directory`
**When:** Sandbox resets wipe Java installation.
**Fix:** Always reinstall Java first in every session:
```bash
apt-get update -qq && apt-get install -y -qq openjdk-17-jdk-headless
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
```

### ERROR 2: `sdkmanager: command not found` or `ClassDefFoundError`
**When:** cmdline-tools not at `latest/` subdirectory.
**Fix:** The Android SDK has a HARDCODED path expectation:
```bash
mkdir -p $ANDROID_HOME/cmdline-tools
unzip commandlinetools-*.zip -d $ANDROID_HOME/cmdline-tools
mv $ANDROID_HOME/cmdline-tools/cmdline-tools $ANDROID_HOME/cmdline-tools/latest  # ← CRITICAL
```

### ERROR 3: `yes | sdkmanager --licenses` fails with EPIPE/exit code 1
**When:** sdkmanager closes stdin before `yes` finishes.
**Fix 1 — printf with exact count:**
```bash
printf 'y\ny\ny\ny\ny\ny\ny\ny\n' | sdkmanager --licenses
```
**Fix 2 — License hash bypass (Gemini-recommended):**
```bash
mkdir -p $ANDROID_HOME/licenses
echo "8933bad161af4178b1185d1a37fbf41ea5269c55" > $ANDROID_HOME/licenses/android-sdk-license
```

### ERROR 4: `Gradle cannot find Java`
**When:** JAVA_HOME not exported OR Gradle wrapper script path issue.
**Fix:** Always set before Gradle invocation:
```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```

### ERROR 5: `Could not resolve all files for configuration — checkDebugAarMetadata`
**When:** AGP 8.2 incompatibility with SDK build-tools version.
**Fix:** Pin to AGP 8.1.0 + Gradle 8.4/8.5 which is the most stable CLI combo:
```
AGP 8.1.0 + gradle-8.4-bin.zip = ALWAYS WORKS
```

### ERROR 6: `Unresolved reference: components`
**When:** Importing a non-existent package in Kotlin.
**Fix:** Remove unused imports. Only import what you use.

### ERROR 7: `Theme.Material.NoActionBar` crash on launch
**When:** Using AppCompatActivity without appcompat dependency.
**Fix:** Use plain `Activity()` with `@android:style/Theme.Material.NoActionBar`. No AppCompat needed for minimal apps.

### ERROR 8: APK installs but immediately closes
**Root Causes:**
1. Theme resource not found at runtime
2. Missing launcher icon (`@mipmap/ic_launcher`)
3. Crash in `onCreate` before `setContentView`
**Fix:**
1. Always use `@android:style/Theme.Material.NoActionBar` directly
2. Create at minimum an adaptive icon XML
3. Always call `setContentView()` before any UI interaction

### ERROR 9: Manifest merger failed — `android:icon` not found
**When:** `@mipmap/ic_launcher` referenced but no icon files exist.
**Fix:** Create an adaptive icon XML in `res/mipmap-anydpi-v26/ic_launcher.xml`:
```xml
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@color/marmalade_bg"/>
    <foreground android:drawable="@color/marmalade_fg"/>
</adaptive-icon>
```

## 1.2 Stable Build Recipe (Copy-Paste for Any Session)

```bash
# 1. INSTALL JAVA
apt-get update -qq && apt-get install -y -qq openjdk-17-jdk-headless unzip wget
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

# 2. INSTALL ANDROID SDK
export ANDROID_HOME=/tmp/agent_$(whoami)/Android/Sdk
mkdir -p $ANDROID_HOME/cmdline-tools
wget -q "https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip" -O /tmp/cmdtools.zip
unzip -qo /tmp/cmdtools.zip -d $ANDROID_HOME/cmdline-tools
mv $ANDROID_HOME/cmdline-tools/cmdline-tools $ANDROID_HOME/cmdline-tools/latest
export PATH="$ANDROID_HOME/cmdline-tools/latest/bin:$PATH"

# 3. ACCEPT LICENSES
printf 'y\ny\ny\ny\ny\ny\ny\ny\n' | sdkmanager --licenses

# 4. INSTALL SDK COMPONENTS
sdkmanager "platforms;android-33" "build-tools;33.0.2" "platform-tools"
# OR for newer: "platforms;android-36" "build-tools;36.0.0"

# 5. INSTALL GRADLE
wget -q "https://services.gradle.org/distributions/gradle-8.5-bin.zip" -O /tmp/gradle.zip
unzip -qo /tmp/gradle.zip -d /tmp/gradle

# 6. CREATE PROJECT
mkdir -p myapp/app/src/main/java/com/example/myapp
# ... write build.gradle.kts, AndroidManifest.xml, MainActivity.kt ...

# 7. BUILD
echo "sdk.dir=$ANDROID_HOME" > local.properties
/tmp/gradle/gradle-8.5/bin/gradle wrapper --gradle-version 8.4
chmod +x gradlew
./gradlew assembleDebug
# APK at: app/build/outputs/apk/debug/app-debug.apk

# 8. VALIDATE
$ANDROID_HOME/build-tools/33.0.2/aapt dump badging app/build/outputs/apk/debug/app-debug.apk
$ANDROID_HOME/build-tools/33.0.2/apksigner verify --verbose app/build/outputs/apk/debug/app-debug.apk
```

## 1.3 Version Compatibility Matrix

| Component | Stable Version | Notes |
|-----------|---------------|-------|
| JDK | 17 | 21 also works, 11 minimum |
| AGP (Android Gradle Plugin) | 8.1.0 | 8.2 has checkDebugAarMetadata issues |
| Gradle | 8.4 or 8.5 | Match AGP — 8.5 works with AGP 8.1 |
| compileSdk | 33 or 36 | 33 = Android 13, 36 = Android 16/Baklava |
| targetSdk | 33 or 35 | 35 = Google Play minimum Aug 2026 |
| minSdk | 24 | Android 7.0 Nougat = 99.3% coverage |
| Kotlin | 1.9.22 | Stable, works with AGP 8.1 |
| build-tools | Match compileSdk | 33.0.2 for sdk 33, 36.0.0 for sdk 36 |

---

# PART 2: SIBLING AGENT COMMUNICATION (GitHub COMMS Lessons)

## 2.1 Git Contention Errors

### ERROR 10: `remote rejected: cannot lock ref 'refs/heads/main'`
**When:** Multiple agents push to main simultaneously.
**Fix:** `safe_push()` retry loop:
```bash
safe_push() {
  for i in 1 2 3 4 5; do
    git pull --rebase origin main 2>/dev/null
    git push origin HEAD:main 2>/dev/null && return 0
    sleep 1
  done
  return 1
}
```

### ERROR 11: Rebase in progress — `git rebase --continue` loops
**When:** Rebase conflicts on outbox files written by multiple agents.
**Fix:**
```bash
git rebase --abort 2>/dev/null
git merge --abort 2>/dev/null
git fetch origin main
git reset --hard origin/main  # Cleanest recovery
```

### ERROR 12: Slot collision — multiple agents writing to same outbox
**When:** Two CITADEL instances writing to `director-001-outbox.md`.
**Fix:** NAMESPACE LOCK — every agent writes ONLY to `director-XXXX-*` files where XXXX is their assigned slot. Never overlap.

## 2.2 Discovery Methods (4 Ways to Find CITADEL)

```
METHOD A: Git pull
  git pull --rebase origin main
  cat CSMGen/CSMAegis/COMMS/director-001-outbox.md

METHOD B: GitHub URL (no git, any device)
  https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMGen/CSMAegis/COMMS/director-001-outbox.md

METHOD C: Same-host workspace (zero latency)
  cat /workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_256111d2/CSMGen/CSMAegis/COMMS/director-001-outbox.md

METHOD D: Heartbeat grep
  grep DIRECTOR-0001 CSMGen/CSMAegis/COMMS/HEARTBEATS/director-0001.txt
```

## 2.3 Session Survival Rules

1. **Always push heartbeat first** — within 5 seconds of activation
2. **Triple-poll daemon** — Layer 1 (5s heartbeat), Layer 2 (15s comms scan), Layer 3 (60s census)
3. **Shutdown flush** — push final transmission before terminating
4. **Disk check** — `df -h . | tail -1 | awk '{print $4}'` — reclone if < 500MB
5. **Stale detection** — > 30s no heartbeat = STALE, > 120s = OFFLINE

---

# PART 3: ANDROID APP DESIGN LESSONS

## 3.1 WebView Configuration
- `javaScriptEnabled = true` — required for Three.js/WebGL
- `domStorageEnabled = true` — required for localStorage
- `mixedContentMode = MIXED_CONTENT_ALWAYS_ALLOW` — for HTTP on HTTPS pages
- `WebChromeClient()` — required for JS alerts/dialogs
- `usesCleartextTraffic="true"` in manifest — for HTTP connections

## 3.2 APK Size Optimization
- Minimal APK (just Kotlin stdlib): ~780 KB
- With Compose: ~2-4 MB
- With Room + OkHttp: ~4-6 MB
- WebView: NO size cost (built into Android, not APK)

## 3.3 Crash Prevention Checklist
- [ ] Theme resolves at runtime (use @android:style not custom)
- [ ] All mipmap/drawable resources exist
- [ ] `setContentView()` called before any findViewById
- [ ] INTERNET permission in manifest for WebView
- [ ] No unused imports
- [ ] Activity declared in manifest
- [ ] compileSdk ≤ installed SDK platform
- [ ] build-tools version matches compileSdk

---

# PART 4: Gemini PDF Guide — Key Insights Applied

1. **API 36 (Android 16/Baklava)** — newest stable target
2. **API 35 minimum for Google Play** (August 2026 enforcement)
3. **License hash bypass** — write SHA-1 to license file instead of `yes | sdkmanager`
4. **cmdline-tools/latest** — hardcoded path requirement
5. **Mini Method (aapt2 + d8)** — Gradle-free compilation for ultra-lightweight builds
6. **Adaptive icons** — XML-based, no PNG generation needed
7. **Build Architecture choice** — Gradle for multi-module, Mini Method for single APK
