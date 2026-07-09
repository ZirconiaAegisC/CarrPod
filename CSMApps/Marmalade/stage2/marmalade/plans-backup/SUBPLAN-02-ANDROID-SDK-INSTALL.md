# SUB-PLAN 02 — ANDROID SDK INSTALL
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 2 of 13
## Estimated Total Time: 10 minutes | GOAL: aapt2, d8, android.jar ready for no-Gradle build

---

## PRE-REQUISITES
- SUB-PLAN-01 completed (Java 17, wget, unzip, /tmp/android-sdk)
- ANDROID_HOME=/tmp/android-sdk
- JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

---

## OBJECTIVE
Install Android SDK command-line tools, platform, and build-tools. Prepare the no-Gradle build toolchain: aapt2, d8, zipalign, apksigner, android.jar.

---

## STEP-BY-STEP COMMANDS

### STEP 02-01: Download Android command-line tools
[CMD] wget -q https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip -O /tmp/cmdtools.zip
Expected time: 30s (download dependent)
Verification: `ls -la /tmp/cmdtools.zip | grep -q "cmdtools" && echo "DOWNLOAD OK"`
Rollback: `rm /tmp/cmdtools.zip`

### STEP 02-02: Unzip command-line tools
[CMD] unzip -qo /tmp/cmdtools.zip -d /tmp/android-sdk/cmdline-tools
Expected time: 5s
Verification: `ls /tmp/android-sdk/cmdline-tools/cmdline-tools/bin/sdkmanager && echo "UNZIP OK"`
Rollback: `rm -rf /tmp/android-sdk/cmdline-tools`

### STEP 02-03: CRITICAL: Move to cmdline-tools/latest/ (sdkmanager hardcodes this path)
[CMD] mv /tmp/android-sdk/cmdline-tools/cmdline-tools /tmp/android-sdk/cmdline-tools/latest
Expected time: 0.5s
Verification: `ls /tmp/android-sdk/cmdline-tools/latest/bin/sdkmanager && echo "MV OK"`
Rollback: `mv /tmp/android-sdk/cmdline-tools/latest /tmp/android-sdk/cmdline-tools/cmdline-tools`

### STEP 02-04: Set PATH for sdkmanager
[CMD] export PATH=/tmp/android-sdk/cmdline-tools/latest/bin:$PATH
Expected time: 0.1s
Verification: `which sdkmanager && echo "PATH OK"`
Rollback: N/A

### STEP 02-05: Create licenses directory
[CMD] mkdir -p /tmp/android-sdk/licenses
Expected time: 0.1s
Verification: `ls -d /tmp/android-sdk/licenses && echo "LICENSES DIR OK"`
Rollback: N/A

### STEP 02-06: Write license hash files (bypass interactive acceptance)
[CMD] echo "8933bad161af4178b1185d1a37fbf41ea5269c55" > /tmp/android-sdk/licenses/android-sdk-license
Expected time: 0.1s
Verification: `cat /tmp/android-sdk/licenses/android-sdk-license | grep -q "8933" && echo "LICENSE 1 OK"`
Rollback: `rm /tmp/android-sdk/licenses/android-sdk-license`

### STEP 02-07: Write second license hash
[CMD] echo "84831b9409646a918e30573bab4c9c91346d8abd" > /tmp/android-sdk/licenses/android-sdk-preview-license
Expected time: 0.1s
Verification: `cat /tmp/android-sdk/licenses/android-sdk-preview-license | grep -q "84831" && echo "LICENSE 2 OK"`
Rollback: `rm /tmp/android-sdk/licenses/android-sdk-preview-license`

### STEP 02-08: Write third license hash (Intel extra)
[CMD] echo "d975f751698a77b662f1254ddbeed3901e976f5a" > /tmp/android-sdk/licenses/intel-android-extra-license
Expected time: 0.1s
Verification: `cat /tmp/android-sdk/licenses/intel-android-extra-license | grep -q "d975" && echo "LICENSE 3 OK"`
Rollback: `rm /tmp/android-sdk/licenses/intel-android-extra-license`

### STEP 02-09: Install platform android-36
[CMD] sdkmanager --install "platforms;android-36"
Expected time: 60s
Verification: `ls /tmp/android-sdk/platforms/android-36/android.jar && echo "PLATFORM OK"`
Rollback: `sdkmanager --uninstall "platforms;android-36"`

### STEP 02-10: Install build-tools 36.0.0
[CMD] sdkmanager --install "build-tools;36.0.0"
Expected time: 60s
Verification: `ls /tmp/android-sdk/build-tools/36.0.0/aapt2 && ls /tmp/android-sdk/build-tools/36.0.0/d8 && echo "BUILD-TOOLS OK"`
Rollback: `sdkmanager --uninstall "build-tools;36.0.0"`

### STEP 02-11: Install platform-tools
[CMD] sdkmanager --install "platform-tools"
Expected time: 40s
Verification: `ls /tmp/android-sdk/platform-tools/adb && echo "PLATFORM-TOOLS OK"`
Rollback: `sdkmanager --uninstall "platform-tools"`

### STEP 02-12: Verify all build tools
[CMD] ls -la /tmp/android-sdk/build-tools/36.0.0/
Expected time: 0.5s
Verification: Output shows aapt2, d8, zipalign, apksigner in the listing
Rollback: N/A

### STEP 02-13: Set build environment variables
[CMD] export BUILD_TOOLS=/tmp/android-sdk/build-tools/36.0.0
[CMD] export ANDROID_JAR=/tmp/android-sdk/platforms/android-36/android.jar
Expected time: 0.1s
Verification: `echo $BUILD_TOOLS | grep "36.0.0" && echo $ANDROID_JAR | grep "android.jar" && echo "ENV OK"`
Rollback: N/A

---

## COMPLETION CHECK
- [ ] /tmp/android-sdk/cmdline-tools/latest/bin/sdkmanager exists
- [ ] /tmp/android-sdk/platforms/android-36/android.jar exists
- [ ] /tmp/android-sdk/build-tools/36.0.0/aapt2 exists
- [ ] /tmp/android-sdk/build-tools/36.0.0/d8 exists
- [ ] /tmp/android-sdk/build-tools/36.0.0/zipalign exists
- [ ] /tmp/android-sdk/build-tools/36.0.0/apksigner exists
- [ ] /tmp/android-sdk/platform-tools/adb exists
- [ ] License files at /tmp/android-sdk/licenses/
- [ ] BUILD_TOOLS and ANDROID_JAR env vars set

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_e5fd9349-535a-4fe2-9af4-9eb6a8120196/CSMApps/Marmalade/stage2/marmalade/lessons-learned/watchdog-02-sdk.log
```

---

*SUB-PLAN-02 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
