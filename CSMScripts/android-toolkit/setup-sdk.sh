#!/bin/bash
# ============================================================
# setup-sdk.sh — CarrPod Android SDK Bootstrap
# Downloads and installs everything needed for No-Gradle APK builds.
# Verified working: 2026-07-16 (Marmalade v7b build)
# ============================================================
# Usage:
#   bash setup-sdk.sh                    # install to .sdk/android-sdk/
#   ANDROID_HOME=/custom/path bash setup-sdk.sh  # install elsewhere
# ============================================================
set -e

# ─── CONFIGURABLE VERSIONS ─────────────────────────────
# These are the KNOWN WORKING version combinations.
# DO NOT change without testing compatibility!
# build-tools 33.0.1 ⇔ platform android-33 (API 33, Android 13)
# build-tools 34.0.1 ⇔ platform android-34 (API 34, Android 14)
# Rule: build-tools major.minor must <= platform API level major
BUILD_TOOLS_VERSION="33.0.1"
COMPILE_SDK="33"
SDK_BASE="${ANDROID_HOME:-$(dirname "$(dirname "$0")")/.sdk/android-sdk}"

echo "═══════════════════════════════════════════════════════"
echo "  CarrPod Android SDK Bootstrap"
echo "  Target: $SDK_BASE"
echo "  Build Tools: $BUILD_TOOLS_VERSION"
echo "  Platform: android-$COMPILE_SDK"
echo "═══════════════════════════════════════════════════════"

# ─── STEP 1: Install system prerequisites ──────────────
echo ""
echo "[1/5] Installing system prerequisites..."
apt-get update -qq 2>/dev/null || true
apt-get install -y -qq openjdk-17-jdk-headless zip unzip bc 2>/dev/null || true
java -version 2>&1 | head -1
javac -version 2>&1 | head -1

# ─── STEP 2: Download & install cmdline-tools ──────────
echo ""
echo "[2/5] Downloading Android cmdline-tools..."
mkdir -p "$SDK_BASE/cmdline-tools"

CMDTOOLS_URL="https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip"
CMDTOOLS_FILE="$SDK_BASE/../cmdline-tools.zip"

if [ ! -f "$SDK_BASE/cmdline-tools/latest/bin/sdkmanager" ]; then
    curl -k -sL "$CMDTOOLS_URL" -o "$CMDTOOLS_FILE" 2>&1
    SIZE=$(stat --printf="%s" "$CMDTOOLS_FILE" 2>/dev/null || echo 0)
    if [ "$SIZE" -lt 100000 ]; then
        echo "ERROR: cmdline-tools download failed (size: $SIZE)"
        echo "Check network or try alternate URL in script"
        exit 1
    fi
    echo "  Downloaded: $SIZE bytes"

    rm -rf "$SDK_BASE/tmp-extract"
    mkdir -p "$SDK_BASE/tmp-extract"
    cd "$SDK_BASE/tmp-extract" && unzip -qo "$CMDTOOLS_FILE" 2>&1
    rm -rf "$SDK_BASE/cmdline-tools/latest"
    mkdir -p "$SDK_BASE/cmdline-tools"
    mv "$SDK_BASE/tmp-extract/cmdline-tools" "$SDK_BASE/cmdline-tools/latest"
    rm -rf "$SDK_BASE/tmp-extract"
    echo "  cmdline-tools installed."
else
    echo "  cmdline-tools already present."
fi

# ─── STEP 3: Download platform ─────────────────────────
echo ""
echo "[3/5] Downloading platform android-$COMPILE_SDK..."
PLATFORM_ZIP="$SDK_BASE/../platform-$COMPILE_SDK.zip"
PLATFORM_DIR="$SDK_BASE/platforms/android-$COMPILE_SDK"

if [ ! -f "$PLATFORM_DIR/android.jar" ]; then
    # Platform 33 = android-13 naming convention
    PLATFORM_URL="https://dl.google.com/android/repository/platform-${COMPILE_SDK}_r02.zip"
    curl -k -sL "$PLATFORM_URL" -o "$PLATFORM_ZIP" 2>&1
    SIZE=$(stat --printf="%s" "$PLATFORM_ZIP" 2>/dev/null || echo 0)
    if [ "$SIZE" -lt 100000 ]; then
        echo "ERROR: Platform download failed (size: $SIZE)"
        exit 1
    fi
    echo "  Downloaded: $SIZE bytes"

    mkdir -p "$SDK_BASE/platforms"
    cd "$SDK_BASE/platforms" && unzip -qo "$PLATFORM_ZIP" 2>&1
    # Rename android-13 -> android-33 (Google's extraction oddity)
    [ -d "android-13" ] && mv "android-13" "android-33" 2>/dev/null || true
    echo "  Platform installed."
else
    echo "  Platform already present."
fi

# ─── STEP 4: Download build-tools ──────────────────────
echo ""
echo "[4/5] Downloading build-tools $BUILD_TOOLS_VERSION..."
BT_ZIP="$SDK_BASE/../build-tools-$BUILD_TOOLS_VERSION.zip"
BT_DIR="$SDK_BASE/build-tools/$BUILD_TOOLS_VERSION"

if [ ! -f "$BT_DIR/aapt2" ]; then
    BT_URL="https://dl.google.com/android/repository/build-tools_r${BUILD_TOOLS_VERSION}-linux.zip"
    curl -k -sL "$BT_URL" -o "$BT_ZIP" 2>&1
    SIZE=$(stat --printf="%s" "$BT_ZIP" 2>/dev/null || echo 0)
    if [ "$SIZE" -lt 100000 ]; then
        echo "ERROR: Build-tools download failed (size: $SIZE)"
        echo "Falling back to build-tools_r34.0.0..."
        BT_URL="https://dl.google.com/android/repository/build-tools_r34.0.0-linux.zip"
        curl -k -sL "$BT_URL" -o "$BT_ZIP" 2>&1
        SIZE=$(stat --printf="%s" "$BT_ZIP" 2>/dev/null || echo 0)
        if [ "$SIZE" -lt 100000 ]; then
            echo "ERROR: All build-tools fallbacks failed"
            exit 1
        fi
        BUILD_TOOLS_VERSION="34.0.0"
        BT_DIR="$SDK_BASE/build-tools/$BUILD_TOOLS_VERSION"
    fi
    echo "  Downloaded: $SIZE bytes"

    mkdir -p "$SDK_BASE/build-tools"
    cd "$SDK_BASE/build-tools" && unzip -qo "$BT_ZIP" 2>&1
    # Extract creates 'android-13' folder; rename if needed
    [ -d "android-13" ] && mv "android-13" "$BUILD_TOOLS_VERSION" 2>/dev/null || true
    echo "  Build-tools installed."
else
    echo "  Build-tools already present."
fi

# ─── STEP 5: Verify ────────────────────────────────────
echo ""
echo "[5/5] Verifying toolchain..."
AAPT2="$BT_DIR/aapt2"
D8="$BT_DIR/d8"
ZIPALIGN="$BT_DIR/zipalign"
APKSIGNER="$BT_DIR/apksigner"
ANDROID_JAR="$PLATFORM_DIR/android.jar"

FAIL=0
for tool in aapt2 d8 zipalign apksigner; do
    if [ -f "$BT_DIR/$tool" ]; then
        echo "  $tool: OK"
    else
        echo "  $tool: MISSING"
        FAIL=1
    fi
done
[ -f "$ANDROID_JAR" ] && echo "  android.jar: OK" || { echo "  android.jar: MISSING"; FAIL=1; }
java -version >/dev/null 2>&1 && echo "  java: OK" || { echo "  java: MISSING"; FAIL=1; }

if [ "$FAIL" -eq 1 ]; then
    echo ""
    echo "ERROR: Some tools missing. Check downloads."
    exit 1
fi

# ─── Done ──────────────────────────────────────────────
echo ""
echo "═══════════════════════════════════════════════════════"
echo "  SDK SETUP COMPLETE"
echo "  ANDROID_HOME=$SDK_BASE"
echo "  Build Tools: $BT_DIR"
echo "  Platform: $PLATFORM_DIR"
echo "═══════════════════════════════════════════════════════"
echo ""
echo "Add to your build.sh:"
echo "  export ANDROID_HOME=${SDK_BASE}"
echo "  BUILD_TOOLS_VERSION=\"${BUILD_TOOLS_VERSION}\""
echo "  COMPILE_SDK=\"${COMPILE_SDK}\""
echo ""
exit 0
