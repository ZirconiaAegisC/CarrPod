# SUB-PLAN 13 — BUILD SCRIPT AND WATCHDOG DAEMON
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 13 of 13
## Estimated Total Time: 10 minutes | GOAL: build.sh (No-Gradle aapt2+d8 pipeline), watchdog.sh, final signed APK

---

## PRE-REQUISITES
- SUB-PLANS 01-12 ALL completed (all source files, resources, manifest)
- ANDROID_HOME=/tmp/android-sdk
- BUILD_TOOLS=/tmp/android-sdk/build-tools/36.0.0
- ANDROID_JAR=/tmp/android-sdk/platforms/android-36/android.jar
- JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

---

## OBJECTIVE
1. Create `build.sh` — the No-Gradle build script that compiles all Java sources, packages resources, produces a signed APK
2. Create `watchdog.sh` — the command verification daemon that monitors build steps
3. Execute the build to produce the final Marmalade-Stage-Super2-v2.0.0.apk

---

## BUILD PIPELINE (7 steps):

```
Step 1: aapt2 compile     → resources.zip
Step 2: aapt2 link         → unaligned.apk + R.java
Step 3: javac              → .class files
Step 4: d8                 → classes.dex
Step 5: zip inject dex     → dexed.apk
Step 6: zipalign           → aligned.apk
Step 7: apksigner sign     → final signed APK
```

---

## STEP-BY-STEP COMMANDS

### STEP 13-01: Write build.sh
Write file: $MARM_ROOT/build.sh
[CMD] Write build.sh (see FULL FILE SPEC below)
Expected time: 3s
Verification: `ls $MARM_ROOT/build.sh && chmod +x $MARM_ROOT/build.sh && echo "BUILD.SH OK"`
Rollback: `rm $MARM_ROOT/build.sh`

### STEP 13-02: Write watchdog.sh
Write file: $MARM_ROOT/watchdog.sh
[CMD] Write watchdog.sh (see FULL FILE SPEC below)
Expected time: 2s
Verification: `ls $MARM_ROOT/watchdog.sh && chmod +x $MARM_ROOT/watchdog.sh && echo "WATCHDOG.SH OK"`
Rollback: `rm $MARM_ROOT/watchdog.sh`

### STEP 13-03: Set build environment variables
[CMD] export ANDROID_HOME=/tmp/android-sdk
[CMD] export BUILD_TOOLS=$ANDROID_HOME/build-tools/36.0.0
[CMD] export ANDROID_JAR=$ANDROID_HOME/platforms/android-36/android.jar
[CMD] export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
[CMD] export PATH=$JAVA_HOME/bin:$ANDROID_HOME/cmdline-tools/latest/bin:$PATH
Expected time: 0.3s
Verification: `echo "ANDROID_HOME=$ANDROID_HOME BUILD_TOOLS=$BUILD_TOOLS ANDROID_JAR=$ANDROID_JAR"`
Rollback: N/A

### STEP 13-04: Clear previous build artifacts
[CMD] rm -rf $MARM_ROOT/gen/* $MARM_ROOT/obj/* $MARM_ROOT/out/*
Expected time: 0.5s
Verification: `ls $MARM_ROOT/gen/ && ls $MARM_ROOT/obj/ && ls $MARM_ROOT/out/`
Rollback: N/A

### STEP 13-05: Compile resources with aapt2
[CMD] $BUILD_TOOLS/aapt2 compile --dir $MARM_ROOT/src/main/res -o $MARM_ROOT/obj/resources.zip
Expected time: 3s
Verification: `ls -la $MARM_ROOT/obj/resources.zip && echo "AAPT2 COMPILE OK"`
Rollback: `rm $MARM_ROOT/obj/resources.zip`

### STEP 13-06: Link resources + generate R.java
[CMD] $BUILD_TOOLS/aapt2 link -o $MARM_ROOT/out/marmalade-unaligned.apk -I $ANDROID_JAR --manifest $MARM_ROOT/src/main/AndroidManifest.xml --java $MARM_ROOT/gen --min-sdk-version 24 --target-sdk-version 35 --version-code 5 --version-name "2.0.0-super2" --rename-manifest-package "com.carrpod.marmalade" --auto-add-overlay $MARM_ROOT/obj/resources.zip
Expected time: 3s
Verification: `ls $MARM_ROOT/out/marmalade-unaligned.apk && find $MARM_ROOT/gen -name "R.java" && echo "AAPT2 LINK OK"`
Rollback: `rm -rf $MARM_ROOT/out/marmalade-unaligned.apk $MARM_ROOT/gen/*`

### STEP 13-07: Copy generated R.java into source tree
[CMD] R_JAVA=$(find $MARM_ROOT/gen -name "R.java" | head -1)
[CMD] mkdir -p $MARM_ROOT/gen_src/com/carrpod/marmalade
[CMD] cp $R_JAVA $MARM_ROOT/gen_src/com/carrpod/marmalade/R.java
Expected time: 0.5s
Verification: `ls $MARM_ROOT/gen_src/com/carrpod/marmalade/R.java && echo "R.JAVA COPIED"`
Rollback: `rm -rf $MARM_ROOT/gen_src`

### STEP 13-08: Compile Java sources
[CMD] javac -source 11 -target 11 -bootclasspath $ANDROID_JAR -d $MARM_ROOT/obj -sourcepath $MARM_ROOT/src/main/java:$MARM_ROOT/gen_src $(find $MARM_ROOT/src/main/java $MARM_ROOT/gen_src -name "*.java")
Expected time: 10s
Verification: `find $MARM_ROOT/obj -name "*.class" | wc -l && echo "JAVAC OK — classes compiled"`
Rollback: `rm -rf $MARM_ROOT/obj/*.class`

### STEP 13-09: Convert .class to .dex with d8
[CMD] $BUILD_TOOLS/d8 --lib $ANDROID_JAR --min-api 24 --output $MARM_ROOT/obj $(find $MARM_ROOT/obj -name "*.class")
Expected time: 5s
Verification: `ls $MARM_ROOT/obj/classes.dex && echo "D8 OK"`
Rollback: `rm $MARM_ROOT/obj/classes.dex`

### STEP 13-10: Inject classes.dex into APK
[CMD] cp $MARM_ROOT/out/marmalade-unaligned.apk $MARM_ROOT/out/marmalade-dexed.apk
[CMD] cp $MARM_ROOT/obj/classes.dex /tmp/classes.dex
[CMD] (cd /tmp && zip -q $MARM_ROOT/out/marmalade-dexed.apk classes.dex)
Expected time: 1s
Verification: `unzip -l $MARM_ROOT/out/marmalade-dexed.apk | grep classes.dex && echo "DEX INJECTED"`
Rollback: `rm $MARM_ROOT/out/marmalade-dexed.apk`

### STEP 13-11: Zipalign
[CMD] $BUILD_TOOLS/zipalign -p -f 4 $MARM_ROOT/out/marmalade-dexed.apk $MARM_ROOT/out/marmalade-aligned.apk
Expected time: 1s
Verification: `ls $MARM_ROOT/out/marmalade-aligned.apk && echo "ZIPALIGN OK"`
Rollback: `rm $MARM_ROOT/out/marmalade-aligned.apk`

### STEP 13-12: Generate debug keystore
[CMD] keytool -genkey -v -keystore $MARM_ROOT/debug.keystore -alias androiddebugkey -keyalg RSA -keysize 2048 -validity 10000 -storepass android -keypass android -dname "CN=Marmalade, OU=CarrPod, O=CarrPod, L=Citadel, ST=Citadel, C=US" 2>&1 || echo "KEYSTORE EXISTS"
Expected time: 2s
Verification: `ls $MARM_ROOT/debug.keystore && echo "KEYSTORE OK"`
Rollback: `rm $MARM_ROOT/debug.keystore`

### STEP 13-13: Sign APK
[CMD] $BUILD_TOOLS/apksigner sign --ks $MARM_ROOT/debug.keystore --ks-pass pass:android --key-pass pass:android --out $MARM_ROOT/out/Marmalade-Stage-Super2-v2.0.0.apk $MARM_ROOT/out/marmalade-aligned.apk
Expected time: 2s
Verification: `ls $MARM_ROOT/out/Marmalade-Stage-Super2-v2.0.0.apk && echo "SIGNED OK"`
Rollback: `rm $MARM_ROOT/out/Marmalade-Stage-Super2-v2.0.0.apk`

### STEP 13-14: Verify APK
[CMD] $BUILD_TOOLS/aapt2 dump badging $MARM_ROOT/out/Marmalade-Stage-Super2-v2.0.0.apk | head -10
Expected time: 1s
Verification: Output shows package name, versionCode, versionName
Rollback: N/A

### STEP 13-15: Display final APK info
[CMD] ls -la $MARM_ROOT/out/Marmalade-Stage-Super2-v2.0.0.apk
Expected time: 0.1s
Verification: Shows file size
Rollback: N/A

---

## FULL FILE SPEC: build.sh

```bash
#!/bin/bash
# ================================================================
# MARMALADE STAGE SUPER2 — NO-GRADLE BUILD SCRIPT
# Pipeline: aapt2 compile → aapt2 link → javac → d8 → zip → zipalign → apksigner
# Zero Gradle dependency. Deterministic. <15 second builds.
# ================================================================
set -e

PACKAGE="com.carrpod.marmalade"
APP_NAME="Marmalade"
VERSION_CODE=5
VERSION_NAME="2.0.0-super2"
COMPILE_SDK=36
TARGET_SDK=35
MIN_SDK=24
BUILD_TOOLS_VERSION="36.0.0"

ANDROID_HOME="${ANDROID_HOME:-/tmp/android-sdk}"
BUILD_TOOLS="$ANDROID_HOME/build-tools/$BUILD_TOOLS_VERSION"
PLATFORM="$ANDROID_HOME/platforms/android-$COMPILE_SDK"
ANDROID_JAR="$PLATFORM/android.jar"
AAPT2="$BUILD_TOOLS/aapt2"
D8="$BUILD_TOOLS/d8"
ZIPALIGN="$BUILD_TOOLS/zipalign"
APKSIGNER="$BUILD_TOOLS/apksigner"

PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
SRC_DIR="$PROJECT_DIR/src/main"
GEN_DIR="$PROJECT_DIR/gen"
GEN_SRC_DIR="$PROJECT_DIR/gen_src"
OBJ_DIR="$PROJECT_DIR/obj"
OUT_DIR="$PROJECT_DIR/out"

echo "=== MARMALADE STAGE SUPER2 BUILD ==="
echo "Package: $PACKAGE"
echo "Version: $VERSION_NAME ($VERSION_CODE)"
echo "SDK: $COMPILE_SDK → target $TARGET_SDK | min $MIN_SDK"
echo ""

rm -rf "$GEN_DIR" "$GEN_SRC_DIR" "$OBJ_DIR" "$OUT_DIR"
mkdir -p "$GEN_DIR" "$GEN_SRC_DIR" "$OBJ_DIR" "$OUT_DIR"

echo "[1/7] Compiling resources with aapt2..."
"$AAPT2" compile --dir "$SRC_DIR/res" -o "$OBJ_DIR/resources.zip"

echo "[2/7] Linking resources + generating R.java..."
"$AAPT2" link \
    -o "$OUT_DIR/$APP_NAME-unaligned.apk" \
    -I "$ANDROID_JAR" \
    --manifest "$SRC_DIR/AndroidManifest.xml" \
    --java "$GEN_DIR" \
    --min-sdk-version $MIN_SDK \
    --target-sdk-version $TARGET_SDK \
    --version-code $VERSION_CODE \
    --version-name "$VERSION_NAME" \
    --rename-manifest-package "$PACKAGE" \
    --auto-add-overlay \
    "$OBJ_DIR/resources.zip"

R_JAVA=$(find "$GEN_DIR" -name "R.java" | head -1)
mkdir -p "$GEN_SRC_DIR/${PACKAGE//.//}"
cp "$R_JAVA" "$GEN_SRC_DIR/${PACKAGE//.//}/R.java"

echo "[3/7] Compiling Java sources..."
javac \
    -source 11 -target 11 \
    -bootclasspath "$ANDROID_JAR" \
    -d "$OBJ_DIR" \
    -sourcepath "$SRC_DIR/java:$GEN_SRC_DIR" \
    $(find "$SRC_DIR/java" "$GEN_SRC_DIR" -name "*.java")

CLASS_COUNT=$(find "$OBJ_DIR" -name "*.class" | wc -l)
echo "  Compiled $CLASS_COUNT class files"

echo "[4/7] Converting to dex bytecode with d8..."
"$D8" \
    --lib "$ANDROID_JAR" \
    --min-api $MIN_SDK \
    --output "$OBJ_DIR" \
    $(find "$OBJ_DIR" -name "*.class")

echo "[5/7] Injecting classes.dex into APK..."
cp "$OUT_DIR/$APP_NAME-unaligned.apk" "$OUT_DIR/$APP_NAME-dexed.apk"
cp "$OBJ_DIR/classes.dex" /tmp/marmalade-classes.dex
(cd /tmp && zip -q "$OUT_DIR/$APP_NAME-dexed.apk" marmalade-classes.dex)
rm /tmp/marmalade-classes.dex

echo "[6/7] Aligning APK..."
"$ZIPALIGN" -p -f 4 \
    "$OUT_DIR/$APP_NAME-dexed.apk" \
    "$OUT_DIR/$APP_NAME-aligned.apk"

echo "[7/7] Signing APK..."
KEYSTORE="${KEYSTORE:-$PROJECT_DIR/debug.keystore}"
if [ ! -f "$KEYSTORE" ]; then
    keytool -genkey -v \
        -keystore "$KEYSTORE" \
        -alias androiddebugkey \
        -keyalg RSA -keysize 2048 \
        -validity 10000 \
        -storepass android \
        -keypass android \
        -dname "CN=Marmalade, OU=CarrPod, O=CarrPod, L=Citadel, ST=Citadel, C=US" \
        2>/dev/null
fi

FINAL_APK="$OUT_DIR/$APP_NAME-Stage-Super2-v$VERSION_NAME.apk"
"$APKSIGNER" sign \
    --ks "$KEYSTORE" \
    --ks-pass pass:android \
    --key-pass pass:android \
    --out "$FINAL_APK" \
    "$OUT_DIR/$APP_NAME-aligned.apk"

echo ""
echo "============================================="
SIZE=$(stat --printf="%s" "$FINAL_APK" 2>/dev/null || echo "unknown")
echo "  BUILD COMPLETE — $APP_NAME Stage Super2"
echo "  APK: $FINAL_APK"
echo "  Size: $SIZE bytes"
echo "============================================="

"$AAPT2" dump badging "$FINAL_APK" | head -5
```

## FULL FILE SPEC: watchdog.sh

```bash
#!/bin/bash
# ================================================================
# MARMALADE WATCHDOG DAEMON — Command Verification Logger
# Monitors build steps, logs duration, retries on failure
# ================================================================

LOG_DIR="$(cd "$(dirname "$0")" && pwd)/lessons-learned"
LOG_FILE="$LOG_DIR/watchdog-$(date +%Y%m%d-%H%M%S).log"
MAX_RETRIES=3
TIMEOUT_MULTIPLIER=2

log_step(){
    echo "[$(date -u +%Y-%m-%dT%H:%M:%SZ)] [$1] [$2] [$3]" | tee -a "$LOG_FILE"
}

verify_and_retry(){
    local step_name="$1"
    local expected_sec="$2"
    local cmd="$3"
    local verify="$4"
    local attempt=1

    while [ $attempt -le $MAX_RETRIES ]; do
        log_step "$step_name" "ATTEMPT-$attempt" "START (expected ${expected_sec}s)"

        START_TS=$(date +%s)
        eval "$cmd" 2>&1 | tee -a "$LOG_FILE"
        CMD_EXIT=${PIPESTATUS[0]}
        END_TS=$(date +%s)
        DURATION=$((END_TS - START_TS))

        if [ $CMD_EXIT -eq 0 ] && eval "$verify"; then
            log_step "$step_name" "OK" "${DURATION}s"
            if [ $DURATION -gt $((expected_sec * TIMEOUT_MULTIPLIER)) ]; then
                log_step "$step_name" "WARN" "Took ${DURATION}s, expected ${expected_sec}s ($((TIMEOUT_MULTIPLIER))x threshold)"
            fi
            return 0
        fi

        log_step "$step_name" "FAIL-${attempt}" "${DURATION}s — exit code $CMD_EXIT"
        attempt=$((attempt + 1))

        if [ $attempt -le $MAX_RETRIES ]; then
            log_step "$step_name" "RETRY" "Waiting 2s before retry $attempt..."
            sleep 2
        fi
    done

    log_step "$step_name" "FATAL" "Failed after $MAX_RETRIES attempts"
    return 1
}

# If called as main script with sub-plan argument
if [ $# -ge 1 ]; then
    echo "Watchdog Daemon active — monitoring sub-plan: $1"
    echo "Log: $LOG_FILE"
fi
```

---

## COMPLETION CHECK
- [ ] build.sh exists and is executable
- [ ] watchdog.sh exists and is executable
- [ ] build.sh references correct paths: $BUILD_TOOLS, $ANDROID_JAR, $SRC_DIR
- [ ] build.sh has all 7 build steps in sequence
- [ ] Final APK: $MARM_ROOT/out/Marmalade-Stage-Super2-v2.0.0.apk
- [ ] APK size reported (should be <500KB for Java-only build)
- [ ] aapt2 dump badging shows correct package and version
- [ ] watchdog.sh logs to lessons-learned/ directory
- [ ] watchdog.sh supports 3 retries with 2x timeout multiplier

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-13-build.log
```

---

*SUB-PLAN-13 | Director Kairos Steele, CITADEL | 2026-07-09 05:23 UTC*
*FINAL SUB-PLAN — When complete, the entire Marmalade Stage Super2 app is built.*
