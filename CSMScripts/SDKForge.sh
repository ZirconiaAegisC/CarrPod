#!/bin/bash
# ============================================================
# SDKForge.sh — CarrPod One-Shot Cloud Build Environment
#
# RECOMMENDED SESSION STARTUP COMMAND:
#   bash CSMScripts/SDKForge.sh && eval "$(bash CSMScripts/SDKForge.sh --export-env)"
#
# Or use the wrapper:
#   bash CSMScripts/SESSION-START.sh
# ============================================================
# Usage:  bash SDKForge.sh [--verify-only]
#
# This script bootstraps a complete Android APK build toolchain
# in a cloud sandbox environment with NO Gradle, NO AndroidX,
# NO Kotlin compiler. One command. Ready to build.
#
# What it does:
#   1. Installs Java 17, zip, unzip, bc (system packages)
#   2. Downloads Android command-line tools
#   3. Downloads platform android-33 (API 33)
#   4. Downloads build-tools 33.0.1 (aapt2, d8, zipalign, apksigner)
#   5. Verifies all tools present and functional
#   6. Exports ANDROID_HOME + prints ready-to-build instructions
#
# Verified working pairs:
#   build-tools 33.0.1  ⇔  platform android-33   ✓
#   build-tools 34.0.0  ⇔  platform android-34   ✓ (fallback)
#
# Critical notes for cloud/sandbox environments:
#   - curl -k is mandatory (self-signed CA chains)
#   - Google extracts platform 33 as 'android-13' → rename
#   - Some build-tools URLs return 404 — fallback chain built in
#
# Project: CarrPod (github.com/ZirconiaAegisC/CarrPod)
# Session: 2026-07-25
# ============================================================
set -e

# ─── Configuration ───────────────────────────────────
SDK_BASE="${ANDROID_HOME:-$(pwd)/.sdk/android-sdk}"
BUILD_TOOLS_VERSION="33.0.1"
COMPILE_SDK="33"
CMDTOOLS_URL="https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip"
PLATFORM_URL="https://dl.google.com/android/repository/platform-${COMPILE_SDK}_r02.zip"
BT_URL="https://dl.google.com/android/repository/build-tools_r${BUILD_TOOLS_VERSION}-linux.zip"
BT_FALLBACK_URL="https://dl.google.com/android/repository/build-tools_r34.0.0-linux.zip"

# ─── Colors ──────────────────────────────────────────
RED='\033[0;31m'; GREEN='\033[0;32m'; YELLOW='\033[1;33m'; CYAN='\033[0;36m'; NC='\033[0m'
msg()  { echo -e "${GREEN}[SDKForge]${NC} $1"; }
warn() { echo -e "${YELLOW}[SDKForge]${NC} $1"; }
err()  { echo -e "${RED}[SDKForge]${NC} $1"; }

# ─── Banner ──────────────────────────────────────────
echo ""
echo -e "${CYAN}╔══════════════════════════════════════════════════════╗${NC}"
echo -e "${CYAN}║${NC}          ${GREEN}SDKForge — CarrPod Cloud Toolchain${NC}          ${CYAN}║${NC}"
echo -e "${CYAN}║${NC}  Build Tools: ${YELLOW}${BUILD_TOOLS_VERSION}${NC}  |  Platform: ${YELLOW}android-${COMPILE_SDK}${NC}     ${CYAN}║${NC}"
echo -e "${CYAN}║${NC}  Target: ${CYAN}${SDK_BASE}${NC}  ${CYAN}║${NC}"
echo -e "${CYAN}╚══════════════════════════════════════════════════════╝${NC}"
echo ""

# ─── Export-env mode (skip install, just print env vars) ───
if [ "$1" = "--export-env" ]; then
    BT_DIR="$SDK_BASE/build-tools/$BUILD_TOOLS_VERSION"
    echo "export ANDROID_HOME=${SDK_BASE}"
    echo "export BUILD_TOOLS_VERSION=${BUILD_TOOLS_VERSION}"
    echo "export COMPILE_SDK=${COMPILE_SDK}"
    echo "export PATH=\"${BT_DIR}:\$PATH\""
    exit 0
fi

# ─── Verify-only mode ────────────────────────────────
if [ "$1" = "--verify-only" ]; then
    msg "Running in verify-only mode..."
    BT_DIR="$SDK_BASE/build-tools/$BUILD_TOOLS_VERSION"
    PLATFORM_DIR="$SDK_BASE/platforms/android-$COMPILE_SDK"
    FAIL=0
    for tool in aapt2 d8 zipalign apksigner; do
        if [ -f "$BT_DIR/$tool" ]; then echo "  ${GREEN}✓${NC} $tool"; else echo "  ${RED}✗${NC} $tool MISSING"; FAIL=1; fi
    done
    [ -f "$PLATFORM_DIR/android.jar" ] && echo "  ${GREEN}✓${NC} android.jar" || { echo "  ${RED}✗${NC} android.jar MISSING"; FAIL=1; }
    java -version >/dev/null 2>&1 && echo "  ${GREEN}✓${NC} java" || { echo "  ${RED}✗${NC} java MISSING"; FAIL=1; }
    if [ "$FAIL" -eq 1 ]; then err "Some tools missing — run without --verify-only to install"; exit 1; fi
    msg "All tools present. Toolchain is ready."
    exit 0
fi

# ─── Step 1: System prerequisites ────────────────────
msg "[1/5] Installing system packages..."
apt-get update -qq 2>/dev/null || true
DEBIAN_FRONTEND=noninteractive apt-get install -y -qq \
    openjdk-17-jdk-headless zip unzip bc \
    2>/dev/null || true

java -version 2>&1 | head -1
javac -version 2>&1 | head -1
msg "System packages ready."

# ─── Step 2: Android cmdline-tools ────────────────────
msg "[2/5] Downloading Android cmdline-tools..."
mkdir -p "$SDK_BASE/cmdline-tools"

CMDTOOLS_ZIP="$SDK_BASE/../cmdline-tools.zip"

if [ ! -f "$SDK_BASE/cmdline-tools/latest/bin/sdkmanager" ]; then
    curl -k -sL "$CMDTOOLS_URL" -o "$CMDTOOLS_ZIP" 2>&1
    SIZE=$(stat --printf="%s" "$CMDTOOLS_ZIP" 2>/dev/null || echo 0)
    if [ "$SIZE" -lt 100000 ]; then
        err "cmdline-tools download failed (size: $SIZE bytes)"
        warn "Check network. URL: $CMDTOOLS_URL"
        exit 1
    fi
    msg "  Downloaded: $SIZE bytes ($(echo "scale=1; $SIZE/1048576" | bc 2>/dev/null || echo "?") MB)"

    rm -rf "$SDK_BASE/tmp-extract"
    mkdir -p "$SDK_BASE/tmp-extract"
    unzip -qo "$CMDTOOLS_ZIP" -d "$SDK_BASE/tmp-extract"
    rm -rf "$SDK_BASE/cmdline-tools/latest"
    mv "$SDK_BASE/tmp-extract/cmdline-tools" "$SDK_BASE/cmdline-tools/latest"
    rm -rf "$SDK_BASE/tmp-extract"
    msg "  cmdline-tools installed."
else
    msg "  cmdline-tools already present."
fi

# ─── Step 3: Android Platform ─────────────────────────
msg "[3/5] Downloading platform android-${COMPILE_SDK}..."
PLATFORM_ZIP="$SDK_BASE/../platform-${COMPILE_SDK}.zip"
PLATFORM_DIR="$SDK_BASE/platforms/android-${COMPILE_SDK}"

if [ ! -f "$PLATFORM_DIR/android.jar" ]; then
    curl -k -sL "$PLATFORM_URL" -o "$PLATFORM_ZIP" 2>&1
    SIZE=$(stat --printf="%s" "$PLATFORM_ZIP" 2>/dev/null || echo 0)
    if [ "$SIZE" -lt 100000 ]; then
        err "Platform download failed (size: $SIZE bytes)"
        warn "URL: $PLATFORM_URL"
        exit 1
    fi
    msg "  Downloaded: $SIZE bytes ($(echo "scale=1; $SIZE/1048576" | bc 2>/dev/null || echo "?") MB)"

    mkdir -p "$SDK_BASE/platforms"
    unzip -qo "$PLATFORM_ZIP" -d "$SDK_BASE/platforms"
    # Google extracts android-33 as android-13 (codename oddity)
    [ -d "$SDK_BASE/platforms/android-13" ] && mv "$SDK_BASE/platforms/android-13" "$PLATFORM_DIR" 2>/dev/null || true
    msg "  Platform android-${COMPILE_SDK} installed."
else
    msg "  Platform already present."
fi

# ─── Step 4: Build Tools ─────────────────────────────
msg "[4/5] Downloading build-tools ${BUILD_TOOLS_VERSION}..."
BT_ZIP="$SDK_BASE/../build-tools-${BUILD_TOOLS_VERSION}.zip"
BT_DIR="$SDK_BASE/build-tools/${BUILD_TOOLS_VERSION}"

if [ ! -f "$BT_DIR/aapt2" ]; then
    curl -k -sL "$BT_URL" -o "$BT_ZIP" 2>&1
    SIZE=$(stat --printf="%s" "$BT_ZIP" 2>/dev/null || echo 0)
    if [ "$SIZE" -lt 100000 ]; then
        warn "Primary build-tools URL returned 404 (size: $SIZE). Trying fallback..."
        curl -k -sL "$BT_FALLBACK_URL" -o "$BT_ZIP" 2>&1
        SIZE=$(stat --printf="%s" "$BT_ZIP" 2>/dev/null || echo 0)
        if [ "$SIZE" -lt 100000 ]; then
            err "All build-tools download attempts failed."
            err "Primary: $BT_URL"
            err "Fallback: $BT_FALLBACK_URL"
            exit 1
        fi
        BUILD_TOOLS_VERSION="34.0.0"
        BT_DIR="$SDK_BASE/build-tools/$BUILD_TOOLS_VERSION"
        warn "Using build-tools $BUILD_TOOLS_VERSION (fallback)"
    fi
    msg "  Downloaded: $SIZE bytes ($(echo "scale=1; $SIZE/1048576" | bc 2>/dev/null || echo "?") MB)"

    mkdir -p "$SDK_BASE/build-tools"
    unzip -qo "$BT_ZIP" -d "$SDK_BASE/build-tools"
    [ -d "$SDK_BASE/build-tools/android-13" ] && mv "$SDK_BASE/build-tools/android-13" "$BT_DIR" 2>/dev/null || true
    msg "  build-tools ${BUILD_TOOLS_VERSION} installed."
else
    msg "  build-tools already present."
fi

# ─── Step 5: Verify ──────────────────────────────────
msg "[5/5] Verifying complete toolchain..."
AAPT2="$BT_DIR/aapt2"
D8="$BT_DIR/d8"
ZIPALIGN="$BT_DIR/zipalign"
APKSIGNER="$BT_DIR/apksigner"
ANDROID_JAR="$PLATFORM_DIR/android.jar"

FAIL=0
echo ""
for tool in aapt2 d8 zipalign apksigner; do
    if [ -f "$BT_DIR/$tool" ]; then echo "  ${GREEN}✓${NC} $tool"; else echo "  ${RED}✗${NC} $tool MISSING"; FAIL=1; fi
done
[ -f "$ANDROID_JAR" ] && echo "  ${GREEN}✓${NC} android.jar (platform ${COMPILE_SDK})" || { echo "  ${RED}✗${NC} android.jar MISSING"; FAIL=1; }
java -version >/dev/null 2>&1 && echo "  ${GREEN}✓${NC} java $(java -version 2>&1 | head -1 | cut -d' ' -f2)" || { echo "  ${RED}✗${NC} java MISSING"; FAIL=1; }
echo ""

if [ "$FAIL" -eq 1 ]; then
    err "═══════════════════════════════════════════════════════"
    err "  SOME TOOLS ARE MISSING — Check network and retry."
    err "═══════════════════════════════════════════════════════"
    exit 1
fi

# ─── Done ────────────────────────────────────────────
echo -e "${GREEN}═══════════════════════════════════════════════════════${NC}"
echo -e "${GREEN}  SDKFORGE COMPLETE — Toolchain Ready${NC}"
echo -e "${GREEN}═══════════════════════════════════════════════════════${NC}"
echo ""
echo -e "  ${YELLOW}Build tools:${NC} ${BT_DIR}"
echo -e "  ${YELLOW}Platform:${NC}    ${PLATFORM_DIR}"
echo -e "  ${YELLOW}SDK base:${NC}    ${SDK_BASE}"
echo ""
echo -e "  ${CYAN}Build an APK:${NC}"
echo -e "  export ANDROID_HOME=${SDK_BASE}"
echo -e "  cd CSMApps/Bounce/v1.0.79 && bash build.sh"
echo ""
echo -e "  source <(bash SDKForge.sh --export-env)"
echo ""

exit 0
