# Autonomous Android Application Synthesis — Blueprint for Command-Line Compilation
## Source: Google Gemini — Generated Guide (retrieved via voice prompt)
## Key Insights Applied to Marmalade Stage 2 v3.0

---

## KEY LESSONS EXTRACTED FROM GEMINI PDF

### 1. API Level Targeting (Google Play 2026)
- **Android 17 (Cinnamon Bun) = API 37** — bleeding edge, newest June 2026
- **Android 16 (Baklava) = API 36** — stable, highly recommended
- **Android 15 (Vanilla Ice Cream) = API 35** — MINIMUM for Google Play as of Aug 2026
- **Action:** Stage 2 v3 targets compileSdk=36, targetSdk=35, minSdk=24

### 2. License Acceptance Bypass
Instead of `yes | sdkmanager --licenses` (which can fail with EPIPE), write SHA-1 hashes directly:
```bash
mkdir -p $ANDROID_HOME/licenses
echo "8933bad161af4178b1185d1a37fbf41ea5269c55" > $ANDROID_HOME/licenses/android-sdk-license
echo "84831b9409646a918e30573bab4c9c91346d8abd" > $ANDROID_HOME/licenses/android-sdk-preview-license
```
**Action:** Use license hash files instead of piping `yes`

### 3. cmdline-tools Directory Structure
The `sdkmanager` has HARDCODED relative path expectations. Extracted content MUST be at `$ANDROID_HOME/cmdline-tools/latest/`. Failure causes ClassDefFoundError.
**Action:** Already correctly implemented in our pipeline.

### 4. Mini Method — aapt2 + d8 (No Gradle)
For lightweight apps, bypass Gradle entirely:
```
aapt2 link → compile resources
javac → compile Java/Kotlin
d8 → dex bytecode
aapt2 add → package APK
zipalign → align
apksigner → sign
```
**Action:** Our current Gradle approach works. Mini Method reserved for Stage 3 optimization.

### 5. Adaptive Icon Generation
The guide recommends programmatic icon generation from AI image generator descriptions.
**Action:** Generate simple adaptive icon XML for Stage 2.

### 6. Build Architecture Choice
- **Gradle wrapper** → for complex multi-module projects
- **Raw toolchain (Mini Method)** → for lightweight single-APK builds
**Action:** Keep Gradle for Stage 2 (it works), Mini Method for Stage 3+ optimization.

### 7. Cryptographic Signing
Debug signing is automatic. Release signing requires keystore generation via `keytool`.
**Action:** Already implemented with `marmalade.keystore` from previous builds.

---

## BUILD RECIPE — REFINED (v3.0)

```bash
# 1. Java
apt-get install -y openjdk-17-jdk-headless

# 2. Android SDK with license bypass
ANDROID_HOME=/opt/android-sdk
mkdir -p $ANDROID_HOME/cmdline-tools
wget https://dl.google.com/android/repository/commandlinetools-linux-14742923_latest.zip
unzip commandlinetools-*.zip -d $ANDROID_HOME/cmdline-tools
mv $ANDROID_HOME/cmdline-tools/cmdline-tools $ANDROID_HOME/cmdline-tools/latest

# License bypass (NO yes pipe)
mkdir -p $ANDROID_HOME/licenses
echo "8933bad161af4178b1185d1a37fbf41ea5269c55" > $ANDROID_HOME/licenses/android-sdk-license

# 3. Install components (API 36 for Baklava target)
sdkmanager "platforms;android-36" "build-tools;36.0.0" "platform-tools"

# 4. Gradle wrapper
gradle wrapper --gradle-version 8.5

# 5. Build
./gradlew assembleDebug
```

---

## WHAT CHANGED FROM OUR ORIGINAL BUILD

| Original | Refined (Gemini) |
|----------|-----------------|
| compileSdk=33 | compileSdk=36 (Baklava/Android 16) |
| targetSdk=33 | targetSdk=35 (Google Play minimum) |
| `yes \| sdkmanager --licenses` | License hash files (no pipe) |
| No adaptive icons | Adaptive icon XML |
| `commandlinetools-linux-11076708_latest.zip` | Updated URL from guide |
| build-tools 33.0.2 | build-tools 36.0.0 |
