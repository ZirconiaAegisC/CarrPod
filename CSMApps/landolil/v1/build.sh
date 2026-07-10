#!/bin/bash
# ============================================================
# build.sh — No-Gradle APK Build for Land 'O Lil v1
# Pipeline: aapt2 compile → aapt2 link → javac → d8 → zipalign → apksigner
# ============================================================
set -e

PACKAGE="com.carrpod.landolil"
APP_NAME="LandOLil"
VERSION_CODE=1
VERSION_NAME="1.0.0"
COMPILE_SDK=36
TARGET_SDK=35
MIN_SDK=24
BUILD_TOOLS_VERSION="36.0.0"

PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
SRC_DIR="$PROJECT_DIR/src/main"
GEN_DIR="$PROJECT_DIR/gen"
OBJ_DIR="$PROJECT_DIR/obj"
OUT_DIR="$PROJECT_DIR/out"

ANDROID_HOME="${ANDROID_HOME:-/tmp/android-sdk}"
BUILD_TOOLS="$ANDROID_HOME/build-tools/$BUILD_TOOLS_VERSION"
PLATFORM="$ANDROID_HOME/platforms/android-$COMPILE_SDK"
ANDROID_JAR="$PLATFORM/android.jar"
AAPT2="$BUILD_TOOLS/aapt2"
D8="$BUILD_TOOLS/d8"
ZIPALIGN="$BUILD_TOOLS/zipalign"
APKSIGNER="$BUILD_TOOLS/apksigner"

echo "============================================================"
echo "  Land 'O Lil v1 — No-Gradle Build"
echo "  Package: $PACKAGE  |  Version: $VERSION_NAME"
echo "============================================================"

if [ ! -f "$ANDROID_JAR" ]; then
    echo "ERROR: android.jar not found at $ANDROID_JAR"
    echo "Run: export ANDROID_HOME=/tmp/android-sdk && bash setup-env.sh"
    exit 1
fi

rm -rf "$GEN_DIR" "$OBJ_DIR"
mkdir -p "$GEN_DIR" "$OBJ_DIR" "$OUT_DIR"

echo "[1/7] aapt2 compile — Processing resources..."
"$AAPT2" compile --dir "$SRC_DIR/res" -o "$OBJ_DIR/resources.zip" 2>/dev/null

echo "[2/7] aapt2 link — Generating base APK + R.java..."
"$AAPT2" link \
    -o "$OUT_DIR/$APP_NAME-base.apk" \
    -I "$ANDROID_JAR" \
    --manifest "$SRC_DIR/AndroidManifest.xml" \
    --java "$GEN_DIR" \
    --min-sdk-version $MIN_SDK \
    --target-sdk-version $TARGET_SDK \
    --version-code $VERSION_CODE \
    --version-name "$VERSION_NAME" \
    --auto-add-overlay \
    -v \
    "$OBJ_DIR/resources.zip" \
    2>&1 | grep -v "note:" | head -5

echo "[3/7] javac — Compiling Java sources..."
ALL_SOURCES=$(find "$SRC_DIR/java" "$GEN_DIR" -name "*.java" 2>/dev/null)
echo "  Found $(echo "$ALL_SOURCES" | wc -l) source files"

javac \
    -source 11 -target 11 \
    -classpath "$ANDROID_JAR" \
    -d "$OBJ_DIR" \
    -sourcepath "$SRC_DIR/java:$GEN_DIR" \
    -Xlint:-options \
    $ALL_SOURCES \
    2>&1 | grep -v "warning:" || true

CLASS_COUNT=$(find "$OBJ_DIR" -name "*.class" | wc -l)
echo "  Compiled $CLASS_COUNT class files"

echo "[4/7] d8 — Converting to dex bytecode..."
if [ "$CLASS_COUNT" -gt 0 ]; then
    "$D8" \
        --lib "$ANDROID_JAR" \
        --min-api $MIN_SDK \
        --output "$OBJ_DIR" \
        $(find "$OBJ_DIR" -name "*.class") \
        2>&1 | tail -1 || {
            find "$OBJ_DIR" -name "*.class" | xargs "$D8" --lib "$ANDROID_JAR" --min-api $MIN_SDK --output "$OBJ_DIR"
        }

    if [ -f "$OBJ_DIR/classes.dex" ]; then
        DEX_SIZE=$(stat --printf="%s" "$OBJ_DIR/classes.dex" 2>/dev/null || echo "0")
        echo "  classes.dex: $DEX_SIZE bytes"
    else
        echo "ERROR: d8 did not produce classes.dex"
        exit 1
    fi
else
    echo "ERROR: No classes compiled"
    exit 1
fi

echo "[5/7] Packaging — Injecting dex into APK..."
cp "$OUT_DIR/$APP_NAME-base.apk" "$OUT_DIR/$APP_NAME-dexed.apk"
if [ -f "$OBJ_DIR/classes.dex" ]; then
    cp "$OBJ_DIR/classes.dex" /tmp/classes.dex
    (cd /tmp && zip -q "$OUT_DIR/$APP_NAME-dexed.apk" classes.dex)
fi

echo "[6/7] zipalign — Aligning APK..."
"$ZIPALIGN" -p -f 4 \
    "$OUT_DIR/$APP_NAME-dexed.apk" \
    "$OUT_DIR/$APP_NAME-aligned.apk"

echo "[7/7] apksigner — Signing APK..."
KEYSTORE="$PROJECT_DIR/debug.keystore"
if [ ! -f "$KEYSTORE" ]; then
    keytool -genkey -v \
        -keystore "$KEYSTORE" \
        -alias androiddebugkey \
        -keyalg RSA -keysize 2048 \
        -validity 10000 \
        -storepass android \
        -keypass android \
        -dname "CN=LandOLil Debug, OU=Tardigradia, O=CarrPod, L=Lab, ST=Dev, C=US" \
        2>/dev/null
    echo "  Generated debug.keystore"
fi

"$APKSIGNER" sign \
    --ks "$KEYSTORE" \
    --ks-pass pass:android \
    --key-pass pass:android \
    --out "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" \
    "$OUT_DIR/$APP_NAME-aligned.apk"

SIZE=$(stat --printf="%s" "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" 2>/dev/null || echo "0")
echo ""
echo "═══════════════════════════════════════════════════════════"
echo "  BUILD COMPLETE — Land 'O Lil v$VERSION_NAME"
echo "  APK: $OUT_DIR/$APP_NAME-v$VERSION_NAME.apk"
echo "  Size: $SIZE bytes ($(echo "scale=1; $SIZE/1024" | bc 2>/dev/null || echo "?") KB)"
echo "═══════════════════════════════════════════════════════════"

"$AAPT2" dump badging "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" 2>/dev/null | head -5 || true

cp "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" "$PROJECT_DIR/../../../../LandOLil-v$VERSION_NAME.apk" 2>/dev/null && \
    echo "  Copied to repo root: LandOLil-v$VERSION_NAME.apk" || true

exit 0
