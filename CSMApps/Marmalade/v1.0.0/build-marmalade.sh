#!/bin/bash
# ================================================================
# MARMALADE APK BUILD SCRIPT — CLI only, no Android Studio
# Usage: bash build-marmalade.sh [debug|release]
# ================================================================
set -e

VERSION="1.0.0"
APK_DIR="app/build/outputs/apk"
BUILD_TYPE="${1:-debug}"

# Detect Android SDK
if [ -n "$ANDROID_HOME" ]; then
    SDK_DIR="$ANDROID_HOME"
elif [ -d "$HOME/Android/Sdk" ]; then
    SDK_DIR="$HOME/Android/Sdk"
elif [ -d "/usr/local/android-sdk" ]; then
    SDK_DIR="/usr/local/android-sdk"
else
    echo "Android SDK not found. Downloading cmdline-tools..."
    SDK_DIR="$HOME/Android/Sdk"
    mkdir -p "$SDK_DIR"
fi

export ANDROID_HOME="$SDK_DIR"

echo "=== MARMALADE v$VERSION BUILD ==="
echo "Android SDK: $ANDROID_HOME"
echo "Build type:  $BUILD_TYPE"
echo ""

# Check for gradlew
if [ ! -f "./gradlew" ]; then
    echo "Generating Gradle wrapper..."
    gradle wrapper --gradle-version 8.5 2>/dev/null || {
        echo "Gradle not found. Install Gradle: sdk install gradle"
        exit 1
    }
fi

chmod +x ./gradlew

echo "Building APK..."
if [ "$BUILD_TYPE" = "release" ]; then
    if [ ! -f "marmalade.keystore" ]; then
        echo "Generating keystore..."
        keytool -genkey -v -keystore marmalade.keystore -alias marmalade \
            -keyalg RSA -keysize 2048 -validity 10000 \
            -storepass marmalade2024 -keypass marmalade2024 \
            -dname "CN=Marmalade, OU=CarrPod, O=CarrPod, L=Citadel, ST=Citadel, C=US"
    fi
    ./gradlew assembleRelease
    APK_PATH="$APK_DIR/release/app-release.apk"
else
    ./gradlew assembleDebug
    APK_PATH="$APK_DIR/debug/app-debug.apk"
fi

if [ -f "$APK_PATH" ]; then
    SIZE=$(ls -lh "$APK_PATH" | awk '{print $5}')
    echo ""
    echo "=== BUILD SUCCESS ==="
    echo "APK: $APK_PATH"
    echo "SIZE: $SIZE"
    echo ""
    echo "Install: adb install $APK_PATH"
else
    echo "Build failed. APK not found at $APK_PATH"
    exit 1
fi
