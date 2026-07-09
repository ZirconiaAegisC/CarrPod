#!/bin/bash
set -e
export ANDROID_HOME="${ANDROID_HOME:-/tmp/agent_e5fd9349-535a-4fe2-9af4-9eb6a8120196/android-sdk}"
BUILD_TOOLS="$ANDROID_HOME/build-tools/36.0.0"
ANDROID_JAR="$ANDROID_HOME/platforms/android-36/android.jar"
PROJ="$(cd "$(dirname "$0")" && pwd)"
SRC="$PROJ/src/main"
GEN="$PROJ/gen"; GENSRC="$PROJ/gen_src"; OBJ="$PROJ/obj"; OUT="$PROJ/out"

rm -rf "$GEN" "$GENSRC" "$OBJ" "$OUT"; mkdir -p "$GEN" "$GENSRC" "$OBJ" "$OUT"

echo "=== MARMALADE STAGE SUPER2 BUILD ==="
echo "[1/7] aapt2 compile..."
"$BUILD_TOOLS/aapt2" compile --dir "$SRC/res" -o "$OBJ/resources.zip"
echo "[2/7] aapt2 link..."
"$BUILD_TOOLS/aapt2" link -o "$OUT/Marmalade-unaligned.apk" -I "$ANDROID_JAR" --manifest "$SRC/AndroidManifest.xml" --java "$GEN" --min-sdk-version 24 --target-sdk-version 35 --version-code 5 --version-name "2.0.0-super2" --rename-manifest-package "com.carrpod.marmalade" --auto-add-overlay "$OBJ/resources.zip"
R_JAVA=$(find "$GEN" -name "R.java" | head -1)
mkdir -p "$GENSRC/com/carrpod/marmalade"
cp "$R_JAVA" "$GENSRC/com/carrpod/marmalade/R.java"
echo "[3/7] javac..."
javac -source 11 -target 11 -bootclasspath "$ANDROID_JAR" -d "$OBJ" -sourcepath "$SRC/java:$GENSRC" $(find "$SRC/java" "$GENSRC" -name "*.java")
echo "[4/7] d8..."
"$BUILD_TOOLS/d8" --lib "$ANDROID_JAR" --min-api 24 --output "$OBJ" $(find "$OBJ" -name "*.class")
echo "[5/7] dex injection..."
cp "$OUT/Marmalade-unaligned.apk" "$OUT/Marmalade-dexed.apk"
cp "$OBJ/classes.dex" /tmp/build-classes.dex
(cd /tmp && zip -q "$OUT/Marmalade-dexed.apk" build-classes.dex)
rm /tmp/build-classes.dex
echo "[6/7] zipalign..."
"$BUILD_TOOLS/zipalign" -p -f 4 "$OUT/Marmalade-dexed.apk" "$OUT/Marmalade-aligned.apk"
echo "[7/7] apksigner..."
KS="$PROJ/debug.keystore"
if [ ! -f "$KS" ]; then keytool -genkey -v -keystore "$KS" -alias androiddebugkey -keyalg RSA -keysize 2048 -validity 10000 -storepass android -keypass android -dname "CN=M,OU=C,O=C,L=Citadel,ST=Citadel,C=US" 2>/dev/null; fi
"$BUILD_TOOLS/apksigner" sign --ks "$KS" --ks-pass pass:android --key-pass pass:android --out "$OUT/Marmalade-Stage-Super2-v2.0.0.apk" "$OUT/Marmalade-aligned.apk"
echo "BUILD COMPLETE — $(ls -lh "$OUT/Marmalade-Stage-Super2-v2.0.0.apk" | awk '{print $5}')"
"$BUILD_TOOLS/aapt2" dump badging "$OUT/Marmalade-Stage-Super2-v2.0.0.apk" | head -5
