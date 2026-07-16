#!/bin/bash
# ============================================================
# build-apk.sh — CarrPod No-Gradle Android APK Builder TEMPLATE
# ============================================================
# Pipeline: aapt2 compile → aapt2 link → asset inject → javac → d8 → zipalign → apksigner
#
# This is a TEMPLATE. Copy to your project and configure below.
#
# PREREQUISITES:
#   1. Run setup-sdk.sh first (or ensure ANDROID_HOME is set)
#   2. Java 17+ installed (apt-get install openjdk-17-jdk-headless)
#   3. Project structure:
#      YOUR_PROJECT/
#      ├── build.sh          (this file)
#      ├── src/main/
#      │   ├── AndroidManifest.xml
#      │   ├── res/values/strings.xml
#      │   ├── res/values/colors.xml
#      │   ├── res/mipmap-anydpi-v26/ic_launcher.xml
#      │   ├── assets/        (optional HTML/JS)
#      │   └── java/com/YOUR/PACKAGE/MainActivity.java
#      ├── out/               (created automatically)
#      ├── obj/               (created automatically)
#      └── gen/               (created automatically)
#
# LESSONS LEARNED (2026-07-16):
#   - Python/r8 zip APKs DON'T INSTALL. Must use aapt2 for binary manifest.
#   - build-tools must be <= platform API level (33.0.1 ⇔ android-33)
#   - curl needs -k flag in sandbox environments
#   - Google extracts android-13 → must rename to android-33
#   - Adaptive icon with @color refs works without image assets
# ============================================================
set -e

# ═══════════════════════════════════════════════════════
# CONFIGURE THESE FOR YOUR APP
# ═══════════════════════════════════════════════════════
PACKAGE="com.carrpod.marmalade"
APP_NAME="Marmalade"
VERSION_CODE=71
VERSION_NAME="7.0.1"
COMPILE_SDK=33
TARGET_SDK=33
MIN_SDK=24
BUILD_TOOLS_VERSION="33.0.1"

# ═══════════════════════════════════════════════════════
# DIRECTORIES (auto-detected, usually no change needed)
# ═══════════════════════════════════════════════════════
PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
SRC_DIR="$PROJECT_DIR/src/main"
GEN_DIR="$PROJECT_DIR/gen"
OBJ_DIR="$PROJECT_DIR/obj"
OUT_DIR="$PROJECT_DIR/out"

# SDK detection: check ANDROID_HOME, then try standard locations
if [ -n "$ANDROID_HOME" ] && [ -d "$ANDROID_HOME" ]; then
    SDK_DIR="$ANDROID_HOME"
elif [ -d "$PROJECT_DIR/../../../.sdk/android-sdk" ]; then
    SDK_DIR="$(cd "$PROJECT_DIR/../../../.sdk/android-sdk" && pwd)"
elif [ -d "$HOME/.sdk/android-sdk" ]; then
    SDK_DIR="$HOME/.sdk/android-sdk"
else
    echo "ERROR: ANDROID_HOME not set and .sdk not found"
    echo "Run setup-sdk.sh first."
    exit 1
fi

BUILD_TOOLS="$SDK_DIR/build-tools/$BUILD_TOOLS_VERSION"
PLATFORM="$SDK_DIR/platforms/android-$COMPILE_SDK"
ANDROID_JAR="$PLATFORM/android.jar"
AAPT2="$BUILD_TOOLS/aapt2"
D8="$BUILD_TOOLS/d8"
ZIPALIGN="$BUILD_TOOLS/zipalign"
APKSIGNER="$BUILD_TOOLS/apksigner"

# ═══════════════════════════════════════════════════════
echo "============================================================"
echo "  $APP_NAME v$VERSION_NAME — No-Gradle aapt2 Build"
echo "  Package: $PACKAGE"
echo "  SDK: $SDK_DIR"
echo "============================================================"

# Verify tools
if [ ! -f "$ANDROID_JAR" ]; then
    echo "ERROR: android.jar not found at $ANDROID_JAR"
    echo "Run: bash CSMScripts/android-toolkit/setup-sdk.sh"
    exit 1
fi

# Clean build dirs
rm -rf "$GEN_DIR" "$OBJ_DIR"
mkdir -p "$GEN_DIR" "$OBJ_DIR" "$OUT_DIR"

# ═══════════════════════════════════════════════════════
# STEP 1: aapt2 compile — resources → .flat → .zip
# ═══════════════════════════════════════════════════════
echo "[1/7] aapt2 compile — Processing resources..."
"$AAPT2" compile --dir "$SRC_DIR/res" -o "$OBJ_DIR/resources.zip" 2>/dev/null

# ═══════════════════════════════════════════════════════
# STEP 2: aapt2 link — generate base APK + R.java + resources.arsc
# ═══════════════════════════════════════════════════════
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

# ═══════════════════════════════════════════════════════
# STEP 2b: Inject assets (HTML, JS, images) into base APK
# ═══════════════════════════════════════════════════════
echo "[2b] Packaging assets..."
if [ -d "$SRC_DIR/assets" ]; then
    ASSET_COUNT=$(find "$SRC_DIR/assets" -type f | wc -l)
    echo "  Found $ASSET_COUNT asset files"
    ASSET_TMP="$OBJ_DIR/asset-tmp"
    mkdir -p "$ASSET_TMP"
    cp "$OUT_DIR/$APP_NAME-base.apk" "$ASSET_TMP/base.apk"
    (cd "$SRC_DIR" && zip -r "$ASSET_TMP/base.apk" assets/ 2>/dev/null)
    mv "$ASSET_TMP/base.apk" "$OUT_DIR/$APP_NAME-base.apk"
    rm -rf "$ASSET_TMP"
    echo "  Assets injected."
else
    echo "  No assets directory — skipping."
fi

# ═══════════════════════════════════════════════════════
# STEP 3: javac — compile Java source
# ═══════════════════════════════════════════════════════
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

# ═══════════════════════════════════════════════════════
# STEP 4: d8 — .class → classes.dex
# ═══════════════════════════════════════════════════════
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

# ═══════════════════════════════════════════════════════
# STEP 5: Inject dex into APK
# ═══════════════════════════════════════════════════════
echo "[5/7] Packaging — Injecting dex into APK..."
cp "$OUT_DIR/$APP_NAME-base.apk" "$OUT_DIR/$APP_NAME-dexed.apk"
if [ -f "$OBJ_DIR/classes.dex" ]; then
    cp "$OBJ_DIR/classes.dex" /tmp/classes.dex
    (cd /tmp && zip -q "$OUT_DIR/$APP_NAME-dexed.apk" classes.dex)
    rm -f /tmp/classes.dex
fi

# ═══════════════════════════════════════════════════════
# STEP 6: zipalign — 4-byte boundary alignment
# ═══════════════════════════════════════════════════════
echo "[6/7] zipalign — Aligning APK..."
"$ZIPALIGN" -p -f 4 \
    "$OUT_DIR/$APP_NAME-dexed.apk" \
    "$OUT_DIR/$APP_NAME-aligned.apk"

# ═══════════════════════════════════════════════════════
# STEP 7: apksigner — sign with debug keystore
# ═══════════════════════════════════════════════════════
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
        -dname "CN=$APP_NAME Debug, OU=CarrPod, O=CSM, L=Citadel, ST=Citadel, C=US" \
        2>/dev/null
    echo "  Generated debug.keystore"
fi

"$APKSIGNER" sign \
    --ks "$KEYSTORE" \
    --ks-pass pass:android \
    --key-pass pass:android \
    --out "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" \
    "$OUT_DIR/$APP_NAME-aligned.apk"

# ═══════════════════════════════════════════════════════
# DONE — Report + badging
# ═══════════════════════════════════════════════════════
SIZE=$(stat --printf="%s" "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" 2>/dev/null || echo "0")
echo ""
echo "═══════════════════════════════════════════════════════"
echo "  BUILD COMPLETE — $APP_NAME v$VERSION_NAME"
echo "  APK: $OUT_DIR/$APP_NAME-v$VERSION_NAME.apk"
echo "  Size: $SIZE bytes ($(echo "scale=1; $SIZE/1024" | bc 2>/dev/null || echo "?") KB)"
echo "═══════════════════════════════════════════════════════"

# Badging
"$AAPT2" dump badging "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" 2>/dev/null | head -5 || true

# Copy to CSMDropBox and repo root (best-effort)
REPO_ROOT="$(cd "$PROJECT_DIR/../../.." 2>/dev/null && pwd)"
cp "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" "$REPO_ROOT/CSMDropBox/$APP_NAME-v$VERSION_NAME.apk" 2>/dev/null && \
    echo "  Copied to CSMDropBox" || true
cp "$OUT_DIR/$APP_NAME-v$VERSION_NAME.apk" "$REPO_ROOT/$APP_NAME-v$VERSION_NAME.apk" 2>/dev/null && \
    echo "  Copied to repo root" || true

exit 0
