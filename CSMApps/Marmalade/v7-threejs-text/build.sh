#!/bin/bash
# Marmalade v7.0 — 3D Alphabet Engine Build
# Pipeline: Python build script using javac + r8 + jarsigner
set -e

PROJECT_DIR="$(cd "$(dirname "$0")" && pwd)"
SDK_DIR="${ANDROID_HOME:-$(cd "$PROJECT_DIR/../../../.sdk/android-sdk" 2>/dev/null && pwd)}"

echo "============================================================"
echo "  Marmalade v7.0 — 3D Alphabet Engine Build"
echo "  Project: $PROJECT_DIR"
echo "  SDK: $SDK_DIR"
echo "============================================================"

export ANDROID_HOME="$SDK_DIR"

python3 "$PROJECT_DIR/build.py" "$@"
EXIT=$?

if [ $EXIT -eq 0 ]; then
    echo ""
    echo "APK location: $PROJECT_DIR/out/Marmalade-v7.0.0.apk"
    ls -lh "$PROJECT_DIR/out/Marmalade-v7.0.0.apk" 2>/dev/null || echo "Check out/ directory"
fi

exit $EXIT
