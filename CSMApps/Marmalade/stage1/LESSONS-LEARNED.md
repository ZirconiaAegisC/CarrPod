# Marmalade Stage 1 — Build Recipe & Lessons Learned
## Date: 2026-07-07 | Built entirely via CLI, no Android Studio

---

## RECIPE: Build a Minimal Android APK from Scratch (No Studio)

### Prerequisites (Fresh Linux Sandbox)
```bash
# 1. Install Java 17
apt-get update && apt-get install -y openjdk-17-jdk-headless

# 2. Install Android SDK Command-line Tools
mkdir -p $HOME/Android/Sdk && cd $HOME/Android/Sdk
wget https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip
unzip commandlinetools-linux-*.zip -d cmdline-tools
mv cmdline-tools/cmdline-tools cmdline-tools/latest

# 3. Accept licenses + install required packages
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$ANDROID_HOME/cmdline-tools/latest/bin:$PATH
yes | sdkmanager --licenses
sdkmanager "platforms;android-33" "build-tools;33.0.2" "platform-tools"

# 4. Install Gradle
wget https://services.gradle.org/distributions/gradle-8.5-bin.zip
unzip gradle-8.5-bin.zip -d $HOME/gradle
```

### Minimal Project Structure
```
CSMApps/Marmalade/stage1/
├── build.gradle.kts              (root: plugin declarations)
├── settings.gradle.kts           (module include)
├── local.properties              (sdk.dir path)
├── app/
│   ├── build.gradle.kts          (android config, dependencies)
│   └── src/main/
│       ├── AndroidManifest.xml   (activity declaration, theme)
│       ├── java/.../MainActivity.kt  (the app)
│       └── res/values/themes.xml (dark theme)
```

### Key Lessons

1. **AGP 8.1.0 + compileSdk 33** — Most stable combo for CLI builds. AGP 8.2 has `checkDebugAarMetadata` issues.
2. **Gradle 8.4 or 8.5** — Use `gradle wrapper --gradle-version 8.4` to generate.
3. **Minimal dependencies** — Just `kotlin("stdlib")` for a Stage 1 skeleton. No AppCompat needed.
4. **Java 11 target** — `jvmTarget = "11"` avoids compatibility issues.
5. **Dark theme** — `android:Theme.Material.NoActionBar` with `#0A0A0F` background.
6. **Activity (not AppCompatActivity)** — Simpler, fewer dependencies.
7. **APK size: 778KB** — A clean skeleton with just Kotlin runtime.

### Verified Build Command
```bash
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export ANDROID_HOME=$HOME/Android/Sdk
export PATH=$HOME/gradle/gradle-8.5/bin:$PATH
cd CSMApps/Marmalade/stage1
./gradlew assembleDebug
# APK: app/build/outputs/apk/debug/app-debug.apk
```

### GitHub Push Verification
```bash
git add CSMApps/Marmalade/stage1/
git commit -m "[DIRECTOR-001] STAGE 1 APK — 778KB, CarrPod logo + Marmalade text"
git push origin HEAD:main
# Verify: curl -I https://github.com/ZirconiaAegisC/CarrPod/blob/main/CSMApps/Marmalade/stage1/app/build/outputs/apk/debug/app-debug.apk
```
