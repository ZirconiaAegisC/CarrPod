# CarrPod No-Gradle Android APK Toolkit

## Overview

This toolkit builds installable Android APK files using **only command-line SDK tools** —
no Gradle, no Android Studio, no AndroidX, no Kotlin compiler.

**Verified working:** 2026-07-16 — Marmalade v7b build (255 KB APK)

---

## Quick Start

```bash
# 1. Bootstrap the SDK (one time)
bash CSMScripts/android-toolkit/setup-sdk.sh

# 2. Scaffold a new project (or use existing)
bash CSMScripts/android-toolkit/project-scaffold.sh MyApp com.carrpod.myapp

# 3. Edit src/main/ and build.sh, then build
cd MyApp && bash build.sh
```

---

## ⚠️ CRITICAL LESSONS LEARNED

### 1. The Python/r8 Approach DOES NOT WORK for Installable APKs
**Symptom:** APK builds but Android refuses to install (no error, just "App not installed")
**Root cause:** Android requires a **binary AndroidManifest.xml** (compiled AXML format), not raw XML text. Python zip tools write raw XML. Only `aapt2 link` produces a valid binary manifest.
**Fix:** Always use the `aapt2` pipeline. Never use Python zip assembly for the manifest.

### 2. SDK Version Compatibility is STRICT
```
build-tools 33.0.1  ⇔  platform android-33  ✓ WORKS
build-tools 36.0.0  ⇔  platform android-36  ✓ SHOULD WORK (if both available)
build-tools 33.0.1  ⇔  platform android-36  ✗ FAILS (aapt2 can't parse newer resources)
build-tools 34.0.0  ⇔  platform android-34  ✓ SHOULD WORK
```
**Rule:** The build-tools major.minor version must be **≤** the platform API level's Android version equivalent.

### 3. Google's Platform ZIP Extraction Oddity
When unzipping `platform-33_r02.zip`, the folder extracts as `android-13/` (not `android-33/`).
Google uses Android codename (`android-13`) internally while the standard folder name uses API level (`android-33`).
**Fix:** Rename `android-13` → `android-33` after extraction.

### 4. Download URLs That Actually Work
```
✓ https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip    (146 MB)
✓ https://dl.google.com/android/repository/platform-33_r02.zip                            (67 MB)
✓ https://dl.google.com/android/repository/platform-36_r02.zip                            (63 MB)
✓ https://dl.google.com/android/repository/platform-tools_r35.0.2-linux.zip               (7 MB)
✓ https://dl.google.com/android/repository/build-tools_r33.0.1-linux.zip                  (56 MB)
✗ https://dl.google.com/android/repository/build-tools_r34.0.0-linux.zip                  (404!)
✗ https://dl.google.com/android/repository/build-tools_r36.0.0-linux.zip                  (404!)
✗ https://dl.google.com/android/repository/platform-33_r03.zip                             (404!)
✗ https://dl.google.com/android/repository/android-13_r03.zip                              (404!)
```
The Google CDN returns 404 for many SDK versions. Trial-and-error required.

### 5. curl Needs `-k` in Sandbox Environments
Sandbox containers often have self-signed certificates or proxy CA chains.
**Fix:** Use `curl -k -sL` for all downloads.

### 6. Java Source/Target Must Be 11
Even with JDK 17 installed, compile with `-source 11 -target 11`.
The `d8` dexer from build-tools 33.0.1 is tested against Java 11 bytecode.
Newer Java features may cause subtle dex failures.

### 7. Asset Injection Order Matters
Assets (HTML/JS/images) must be injected **after** aapt2 link (base APK created)
but **before** dex injection and signing.
**Incorrect order:** dex-in → assets → zipalign → sign = assets overwrite dex!
**Correct order:** aapt2 link → assets inject → javac → d8 → dex inject → zipalign → sign

---

## Build Pipeline (7 Steps)

```
┌──────────────────────────────────────────────────┐
│ 1. aapt2 compile                                 │
│    res/values/*.xml ──→ obj/resources.zip (.flat) │
├──────────────────────────────────────────────────┤
│ 2. aapt2 link                                    │
│    resources.zip + manifest ──→ base.apk + R.java │
│    ▸ Produces binary AndroidManifest.xml          │
│    ▸ Produces binary resources.arsc               │
├──────────────────────────────────────────────────┤
│ 2b. Asset injection                              │
│    zip -r base.apk assets/                       │
├──────────────────────────────────────────────────┤
│ 3. javac                                         │
│    *.java + R.java ──→ obj/*.class               │
│    ▸ -source 11 -target 11                       │
│    ▸ -classpath android.jar                      │
├──────────────────────────────────────────────────┤
│ 4. d8                                            │
│    *.class ──→ obj/classes.dex                   │
│    ▸ --min-api 24 --lib android.jar              │
├──────────────────────────────────────────────────┤
│ 5. Dex injection                                 │
│    zip base.apk classes.dex                      │
├──────────────────────────────────────────────────┤
│ 6. zipalign                                      │
│    -p -f 4 (4-byte alignment)                    │
├──────────────────────────────────────────────────┤
│ 7. apksigner                                     │
│    sign with debug.keystore                      │
│    ▸ auto-generates on first build               │
│    ▸ dname: CN={APP_NAME} Debug, OU=CarrPod      │
└──────────────────────────────────────────────────┘
```

---

## Project Structure

```
YOUR_PROJECT/
├── build.sh                          # ← Copy from build-apk.sh, edit top vars
├── debug.keystore                    # Auto-generated on first build
├── src/main/
│   ├── AndroidManifest.xml           # Package, permissions, activity
│   ├── res/
│   │   ├── values/
│   │   │   ├── strings.xml           # app_name, tagline
│   │   │   └── colors.xml            # app_bg, app_fg (used by icon!)
│   │   └── mipmap-anydpi-v26/
│   │       └── ic_launcher.xml       # Adaptive icon: @color refs
│   ├── assets/                       # HTML, JS, images (optional)
│   └── java/com/carrpod/YOURAPP/
│       └── MainActivity.java
├── out/                              # Built APKs
│   ├── {APP}-base.apk                # After aapt2 link
│   ├── {APP}-dexed.apk               # After dex injection
│   ├── {APP}-aligned.apk             # After zipalign
│   └── {APP}-v{VERSION}.apk          # FINAL SIGNED APK ✓
├── obj/                              # Intermediate build artifacts
│   ├── resources.zip
│   └── classes.dex
└── gen/                              # Generated R.java
```

---

## Adaptive Icon Without Image Assets

The v6b technique works flawlessly. Uses `<adaptive-icon>` with `@color` references:

```xml
<!-- res/mipmap-anydpi-v26/ic_launcher.xml -->
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@color/app_bg"/>
    <foreground android:drawable="@color/app_fg"/>
</adaptive-icon>
```

```xml
<!-- res/values/colors.xml -->
<color name="app_bg">#FF0A0A0F</color>   <!-- Dark background -->
<color name="app_fg">#FFFF6600</color>   <!-- Orange foreground -->
```

This creates a solid-color icon that works on all API 26+ devices.
No PNG/SVG needed. aapt2 compiles the color references into the binary APK.

---

## Tool Dependencies

| Tool | Package | Version |
|------|---------|---------|
| Java | openjdk-17-jdk-headless | 17.0.19 |
| javac | same | 17.x |
| aapt2 | build-tools | 33.0.1 |
| d8 | build-tools | 33.0.1 |
| zipalign | build-tools | 33.0.1 |
| apksigner | build-tools | 33.0.1 |
| keytool | JDK (built-in) | any |
| zip | apt | any |
| unzip | apt | any |
| curl | apt/brew | any (with -k flag) |

---

## Troubleshooting

| Problem | Diagnosis | Fix |
|---------|-----------|-----|
| APK won't install | Check: `unzip -p app.apk AndroidManifest.xml \| file -` — should say "Android binary XML", not "XML document" | Use aapt2 pipeline (not Python zip) |
| aapt2 link fails with "Failed to load resources table" | build-tools version incompatible with platform | Downgrade platform to match build-tools (e.g., android-33 with build-tools 33.0.1) |
| javac "package android.* does not exist" | Missing -classpath | Add `-classpath $ANDROID_JAR` |
| d8 hangs or crashes | OOM or bad classpath | Use `--lib $ANDROID_JAR` explicitly |
| "No classes.dex" after d8 | d8 failed silently | Check CLASS_COUNT > 0 before d8 |
| curl 404 on build-tools | Version not available from Google CDN | Try 33.0.1 (known working) or 30.0.3 |
| curl SSL error | Sandbox CA chain | Add `-k` flag to curl |

---

## Session History

| Date | Session | What Was Built | Key Discovery |
|------|---------|---------------|---------------|
| 2026-07-07 | DIRECTOR-001 | LandOLil v1-v7b (11 releases) | aapt2 pipeline established |
| 2026-07-09 | CITADEL-001 | LandOLil v6bv2, v6bv3, v7b | Adaptive icon @color technique |
| 2026-07-16 | agent_66fbea06 | Marmalade v7b | **SDK compat matrix verified, Python approach FAILED** |

---
*CarrPod — Safe Pod Engineering Company*
*Android Toolkit v1.0 — 2026-07-16*
