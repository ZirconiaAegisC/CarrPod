#!/bin/bash
# ============================================================
# setup-env.sh — Marmalade Android SDK Environment Setup
# No-Gradle pipeline. One-command sandbox bootstrap.
# ============================================================
set -e

echo "[1/6] Installing Java 17..."
apt-get update -qq > /dev/null 2>&1
apt-get install -y -qq openjdk-17-jdk-headless unzip wget > /dev/null 2>&1
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH="$JAVA_HOME/bin:$PATH"

echo "[2/6] Downloading Android SDK command-line tools..."
ANDROID_HOME="${ANDROID_HOME:-/tmp/android-sdk}"
mkdir -p "$ANDROID_HOME/cmdline-tools"

CMDTOOLS_URL="https://dl.google.com/android/repository/commandlinetools-linux-11076708_latest.zip"
wget -q "$CMDTOOLS_URL" -O /tmp/cmdtools.zip 2>/dev/null || {
    echo "Primary URL failed, trying alternate..."
    CMDTOOLS_URL="https://dl.google.com/android/repository/commandlinetools-linux-7583922_latest.zip"
    wget -q "$CMDTOOLS_URL" -O /tmp/cmdtools.zip
}

unzip -qo /tmp/cmdtools.zip -d "$ANDROID_HOME/cmdline-tools"
mv "$ANDROID_HOME/cmdline-tools/cmdline-tools" "$ANDROID_HOME/cmdline-tools/latest" 2>/dev/null || true
export PATH="$ANDROID_HOME/cmdline-tools/latest/bin:$PATH"

echo "[3/6] Accepting licenses..."
mkdir -p "$ANDROID_HOME/licenses"
echo "8933bad161af4178b1185d1a37fbf41ea5269c55" > "$ANDROID_HOME/licenses/android-sdk-license"
echo "84831b9409646a918e30573bab4c9c91346d8abd" > "$ANDROID_HOME/licenses/android-sdk-preview-license"
echo "d975f751698a77b662f1254ddbeed3901e976f5a" > "$ANDROID_HOME/licenses/intel-android-extra-license"
printf 'y\ny\ny\ny\ny\ny\ny\ny\n' | sdkmanager --licenses > /dev/null 2>&1 || true

echo "[4/6] Installing SDK components (platforms;android-36 build-tools;36.0.0)..."
sdkmanager --install "platforms;android-36" "build-tools;36.0.0" "platform-tools" > /dev/null 2>&1

echo "[5/6] Verifying installation..."
BUILD_TOOLS="$ANDROID_HOME/build-tools/36.0.0"
PLATFORM="$ANDROID_HOME/platforms/android-36"

if [ -f "$BUILD_TOOLS/aapt2" ]; then
    echo "  aapt2: $($BUILD_TOOLS/aapt2 version 2>&1 | head -1)"
else
    echo "  ERROR: aapt2 not found"
    exit 1
fi

if [ -f "$BUILD_TOOLS/d8" ]; then
    echo "  d8: found"
else
    echo "  ERROR: d8 not found"
    exit 1
fi

if [ -f "$PLATFORM/android.jar" ]; then
    echo "  android.jar: PRESENT (API 36)"
else
    echo "  ERROR: android.jar not found"
    exit 1
fi

echo "[6/6] Setup complete."
echo ""
echo "  export ANDROID_HOME=$ANDROID_HOME"
echo "  export JAVA_HOME=$JAVA_HOME"
echo "  export BUILD_TOOLS=$BUILD_TOOLS"
echo "  export ANDROID_JAR=$PLATFORM/android.jar"
