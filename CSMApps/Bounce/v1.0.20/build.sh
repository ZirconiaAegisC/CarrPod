#!/bin/bash
# ============================================================
# build.sh — No-Gradle APK Build for Bounce v1
# Pipeline: aapt2 compile → aapt2 link → javac → d8 → zipalign → apksigner
# ============================================================
set -e

PACKAGE="com.carrpod.bounce"
APP_NAME="Bounce"
VERSION_CODE=120
VERSION_NAME="1.0.20"
COMPILE_SDK=33
TARGET_SDK=33
MIN_SDK=24
BUILD_TOOLS_VERSION="33.0.1"

PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
SRC_DIR="$PROJECT_DIR/src/main"
GEN_DIR="$PROJECT_DIR/gen"
OBJ_DIR="$PROJECT_DIR/obj"
OUT_DIR="$PROJECT_DIR/out"

SDK_DIR="${ANDROID_HOME:-$(cd "$PROJECT_DIR/../../../../.sdk/android-sdk" 2>/dev/null && pwd)}"
BUILD_TOOLS="$SDK_DIR/build-tools/$BUILD_TOOLS_VERSION"
PLATFORM="$SDK_DIR/platforms/android-$COMPILE_SDK"
ANDROID_JAR="$PLATFORM/android.jar"

# JDK detection
if [ -d "$PROJECT_DIR/../../../../.sdk/jdk17" ]; then
    export JAVA_HOME="$PROJECT_DIR/../../../../.sdk/jdk17"
    export PATH="$JAVA_HOME/bin:$PATH"
fi
if [ -d "/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_66fbea06-0aa4-4203-9bec-a468b0eb7b02/.sdk/jdk17" ]; then
    export JAVA_HOME="/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_66fbea06-0aa4-4203-9bec-a468b0eb7b02/.sdk/jdk17"
    export PATH="$JAVA_HOME/bin:$PATH"
fi

AAPT2="$BUILD_TOOLS/aapt2"
D8="$BUILD_TOOLS/d8"
ZIPALIGN="$BUILD_TOOLS/zipalign"
APKSIGNER="$BUILD_TOOLS/apksigner"

echo "============================================================"
echo "  Bounce v1 — No-Gradle aapt2 Build"
echo "  Package: $PACKAGE  |  Version: $VERSION_NAME"
echo "  JDK: $JAVA_HOME"
echo "============================================================"

if [ ! -f "$ANDROID_JAR" ]; then echo "ERROR: android.jar not found"; exit 1; fi
if [ ! -f "$AAPT2" ]; then echo "ERROR: aapt2 not found"; exit 1; fi

rm -rf "$GEN_DIR" "$OBJ_DIR"
mkdir -p "$GEN_DIR" "$OBJ_DIR" "$OUT_DIR"

echo "[1/7] aapt2 compile..."
"$AAPT2" compile --dir "$SRC_DIR/res" -o "$OBJ_DIR/resources.zip" 2>/dev/null

echo "[2/7] aapt2 link..."
"$AAPT2" link -o "$OUT_DIR/$APP_NAME-base.apk" -I "$ANDROID_JAR" \
    --manifest "$SRC_DIR/AndroidManifest.xml" --java "$GEN_DIR" \
    --min-sdk-version $MIN_SDK --target-sdk-version $TARGET_SDK \
    --version-code $VERSION_CODE --version-name "$VERSION_NAME" \
    --auto-add-overlay -v "$OBJ_DIR/resources.zip" 2>&1 | grep -v "note:" | head -5

echo "[2b] Assets..."
if [ -d "$SRC_DIR/assets" ]; then
    ATMP="$OBJ_DIR/atmp"; mkdir -p "$ATMP"
    cp "$OUT_DIR/$APP_NAME-base.apk" "$ATMP/base.apk"
    (cd "$SRC_DIR" && zip -r "$ATMP/base.apk" assets/ 2>/dev/null)
    mv "$ATMP/base.apk" "$OUT_DIR/$APP_NAME-base.apk"; rm -rf "$ATMP"
fi

echo "[3/7] javac..."
ALL_SOURCES=$(find "$SRC_DIR/java" "$GEN_DIR" -name "*.java" 2>/dev/null)
javac -source 11 -target 11 -classpath "$ANDROID_JAR" -d "$OBJ_DIR" \
    -sourcepath "$SRC_DIR/java:$GEN_DIR" -Xlint:-options $ALL_SOURCES 2>&1 | grep -v "warning:" || true

echo "[4/7] d8..."
"$D8" --lib "$ANDROID_JAR" --min-api $MIN_SDK --output "$OBJ_DIR" \
    $(find "$OBJ_DIR" -name "*.class") 2>&1 | tail -1 || \
    find "$OBJ_DIR" -name "*.class" | xargs "$D8" --lib "$ANDROID_JAR" --min-api $MIN_SDK --output "$OBJ_DIR"

echo "[5/7] Dex inject..."
cp "$OUT_DIR/$APP_NAME-base.apk" "$OUT_DIR/$APP_NAME-dexed.apk"
cp "$OBJ_DIR/classes.dex" /tmp/classes.dex
(cd /tmp && zip -q "$OUT_DIR/$APP_NAME-dexed.apk" classes.dex); rm -f /tmp/classes.dex

echo "[6/7] zipalign..."
"$ZIPALIGN" -p -f 4 "$OUT_DIR/$APP_NAME-dexed.apk" "$OUT_DIR/$APP_NAME-aligned.apk"

echo "[7/7] apksigner..."
KEYSTORE="$PROJECT_DIR/debug.keystore"
if [ ! -f "$KEYSTORE" ]; then
    keytool -genkey -v -keystore "$KEYSTORE" -alias androiddebugkey -keyalg RSA \
        -keysize 2048 -validity 10000 -storepass android -keypass android \
        -dname "CN=Bounce Debug, OU=CarrPod, O=CSM, L=Citadel, ST=Citadel, C=US" 2>/dev/null
fi
"$APKSIGNER" sign --ks "$KEYSTORE" --ks-pass pass:android --key-pass pass:android \
    --out "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" "$OUT_DIR/$APP_NAME-aligned.apk"

SIZE=$(stat --printf="%s" "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" 2>/dev/null || echo 0)
echo ""
echo "═══════════════════════════════════════════════════════════"
echo "  BUILD COMPLETE — $APP_NAME v$VERSION_NAME"
echo "  APK: $OUT_DIR/$APP_NAME-v$VERSION_NAME.apk"
echo "  Size: $SIZE bytes ($(echo "scale=1; $SIZE/1024" | bc 2>/dev/null || echo "?") KB)"
echo "═══════════════════════════════════════════════════════════"

"$AAPT2" dump badging "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" 2>/dev/null | head -5 || true
cp "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" "$PROJECT_DIR/../../../../CSMDropBox/$APP_NAME-v$VERSION_NAME.apk" 2>/dev/null && echo "  CSMDropBox copy OK" || true
cp "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" "$PROJECT_DIR/../../../../$APP_NAME-v$VERSION_NAME.apk" 2>/dev/null && echo "  Repo root copy OK" || true
exit 0
