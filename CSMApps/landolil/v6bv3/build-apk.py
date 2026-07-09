#!/usr/bin/env python3
"""
Land O Lil v6bv3 APK Builder — WebView + Three.js (v6b architecture)
Pipeline: gen-r -> javac -> r8/d8 -> zip APK (with assets) -> jarsigner
Identical methodology to v6b: WebView, HTML/JS assets, SensorEventListener, GPU monitor
"""

import os, sys, subprocess, shutil, zipfile, re, time

VERSION_NAME = "6bv3"
VERSION_CODE = 631
MIN_SDK = 24
TARGET_SDK = 35
PACKAGE = "com.carrpod.landolil"
APP_LABEL = "Land O Lil"
VERSION_PREFIX = "LandOLil"

SCRIPT_DIR = os.path.dirname(os.path.abspath(__file__))
SRC_MAIN = os.path.join(SCRIPT_DIR, "src", "main")
SRC_JAVA = os.path.join(SRC_MAIN, "java")
SRC_RES = os.path.join(SRC_MAIN, "res")
SRC_ASSETS = os.path.join(SRC_MAIN, "assets")
SRC_MANIFEST = os.path.join(SRC_MAIN, "AndroidManifest.xml")
GEN_DIR = os.path.join(SCRIPT_DIR, "gen")
OBJ_DIR = os.path.join(SCRIPT_DIR, "obj")
OUT_DIR = os.path.join(SCRIPT_DIR, "out")

R8_JAR = "/tmp/agent_bd9c3afd-d3d1-4c53-8888-d25c5232fcd8/android-sdk/cmdline-tools/latest/lib/r8.jar"
STUB_JAR = "/tmp/agent_bd9c3afd-d3d1-4c53-8888-d25c5232fcd8/stub-android/android.jar"
KEYSTORE = os.path.join(SCRIPT_DIR, "debug.keystore")
KEYSTORE_PASS = os.environ.get("ANDROID_KEYSTORE_PASS", "android")
KEY_ALIAS = "androiddebugkey"

VERIFY_DIR = os.path.join(SCRIPT_DIR, "verification")

def run(cmd, **kwargs):
    result = subprocess.run(cmd, capture_output=True, text=True, **kwargs)
    if result.returncode != 0:
        print(f"  STDERR: {result.stderr[-2000:]}")
        raise RuntimeError(f"Command failed: {' '.join(cmd[:3])}... (exit {result.returncode})")
    return result.stdout

def clean():
    for d in [GEN_DIR, OBJ_DIR]:
        if os.path.exists(d):
            shutil.rmtree(d)
        os.makedirs(d)
    os.makedirs(OUT_DIR, exist_ok=True)
    os.makedirs(VERIFY_DIR, exist_ok=True)

def generate_r_java():
    r_entries = {}
    resource_ids = {}

    values_dir = SRC_RES
    for root, _, files in os.walk(values_dir):
        for fname in sorted(files):
            if not fname.endswith(".xml"):
                continue
            fpath = os.path.join(root, fname)
            with open(fpath) as f:
                content = f.read()

            for m in re.finditer(r'<color\s+name="(\w+)"[^>]*>([^<]+)</color>', content):
                name = m.group(1)
                r_entries.setdefault('color', []).append(name)
                resource_ids[('color', name)] = len(r_entries['color']) - 1

            for m in re.finditer(r'<string\s+name="(\w+)"[^>]*>([^<]+)</string>', content):
                name = m.group(1)
                r_entries.setdefault('string', []).append(name)
                resource_ids[('string', name)] = len(r_entries['string']) - 1

            for m in re.finditer(r'<style\s+name="(\w+)"', content):
                name = m.group(1)
                r_entries.setdefault('style', []).append(name)
                resource_ids[('style', name)] = len(r_entries['style']) - 1

    r_path = os.path.join(GEN_DIR, PACKAGE.replace('.', '/'), 'R.java')
    os.makedirs(os.path.dirname(r_path), exist_ok=True)

    type_ids = {}
    next_tid = 0
    lines = [f"package {PACKAGE};", "", "public final class R {"]
    base = 0x7F
    
    for type_name in sorted(r_entries.keys()):
        if type_name not in type_ids:
            type_ids[type_name] = next_tid
            next_tid += 1
        tid = type_ids[type_name]
        lines.append(f"    public static final class {type_name} {{")
        for i, name in enumerate(r_entries[type_name]):
            hex_id = f"0x{base:02x}{tid:02x}{i:04x}"
            lines.append(f"        public static final int {name}={hex_id};")
        lines.append("    }")
    
    lines.append("}")
    with open(r_path, 'w') as f:
        f.write('\n'.join(lines))
    print(f"  [gen-r] R.java generated with {sum(len(v) for v in r_entries.values())} resource IDs")
    return r_path

def compile_java():
    sources = []
    for root, _, files in os.walk(SRC_JAVA):
        for f in files:
            if f.endswith(".java"):
                sources.append(os.path.join(root, f))
    for root, _, files in os.walk(GEN_DIR):
        for f in files:
            if f.endswith(".java"):
                sources.append(os.path.join(root, f))

    print(f"  [javac] Compiling {len(sources)} Java sources...")
    
    run([
        "javac", "-source", "11", "-target", "11",
        "-classpath", STUB_JAR,
        "-d", OBJ_DIR,
        "-sourcepath", f"{SRC_JAVA}:{GEN_DIR}",
        "-Xlint:-options",
    ] + sources)
    
    class_files = []
    for root, _, files in os.walk(OBJ_DIR):
        for f in files:
            if f.endswith(".class"):
                class_files.append(os.path.join(root, f))
    print(f"  [javac] Compiled {len(class_files)} class files")
    return class_files

def convert_to_dex(class_files):
    print(f"  [d8] Converting {len(class_files)} class files to dex...")
    
    cmd = [
        "java", "-Xmx512M", "-cp", R8_JAR,
        "com.android.tools.r8.D8",
        "--lib", STUB_JAR,
        "--min-api", str(MIN_SDK),
        "--output", OBJ_DIR,
    ] + class_files
    
    run(cmd)
    
    dex_path = os.path.join(OBJ_DIR, "classes.dex")
    if not os.path.exists(dex_path):
        raise RuntimeError("classes.dex was not generated")
    
    size = os.path.getsize(dex_path)
    print(f"  [d8] classes.dex: {size} bytes")
    return dex_path

def build_minimal_arsc():
    import struct
    pkg_utf16 = PACKAGE.encode('utf-16-le')[:256].ljust(256, b'\x00')
    data = bytearray()
    data += struct.pack('<HHII', 0x0002, 12, 12 + 256 + 288, 1)
    data += struct.pack('<HHIIII', 0x0001, 28, 28 + len(pkg_utf16) + 4, 1, 0x00, 0x00)
    data += struct.pack('<II', 0, len(pkg_utf16) // 2)
    data += pkg_utf16
    data += struct.pack('<HH', 0, 0)
    package_start = len(data)
    data += struct.pack('<HHIIII', 0x0200, 288, 288 + len(pkg_utf16), 0x7F, 0, 0)
    data += pkg_utf16
    data += struct.pack('<HHIIII', 0x0001, 28, 28, 0, 0, 0)
    data += struct.pack('<II', 0, 0)
    data += struct.pack('<HHIIII', 0x0001, 28, 28, 0, 0, 0)
    data += struct.pack('<II', 0, 0)
    
    arsc_path = os.path.join(OBJ_DIR, "resources.arsc")
    with open(arsc_path, 'wb') as f:
        f.write(bytes(data))
    print(f"  [arsc] resources.arsc: {len(data)} bytes")
    return arsc_path

def assemble_apk(dex_path, arsc_path):
    base_apk = os.path.join(OUT_DIR, f"{VERSION_PREFIX}-base.apk")
    
    with zipfile.ZipFile(base_apk, 'w', zipfile.ZIP_DEFLATED) as zf:
        # AndroidManifest.xml — uncompressed
        zf.writestr("AndroidManifest.xml", open(SRC_MANIFEST, 'rb').read(), compress_type=zipfile.ZIP_STORED)
        
        # resources.arsc
        if os.path.exists(arsc_path):
            zf.write(arsc_path, "resources.arsc")
        
        # classes.dex
        zf.write(dex_path, "classes.dex")
        
        # Resource XMLs
        for root, _, files in os.walk(SRC_RES):
            for fname in sorted(files):
                if fname.endswith(".xml"):
                    fpath = os.path.join(root, fname)
                    arcname = os.path.relpath(fpath, SRC_MAIN)
                    zf.write(fpath, arcname)
        
        # ASSETS — the core of v6b mass
        if os.path.isdir(SRC_ASSETS):
            asset_count = 0
            for root, _, files in os.walk(SRC_ASSETS):
                for fname in files:
                    fpath = os.path.join(root, fname)
                    arcname = os.path.relpath(fpath, SRC_MAIN)
                    zf.write(fpath, arcname)
                    asset_count += 1
            print(f"  [assets] Injected {asset_count} asset files")
    
    size = os.path.getsize(base_apk)
    print(f"  [zip] Base APK: {base_apk} ({size} bytes)")
    return base_apk

def sign_apk(apk_path):
    final_apk = os.path.join(OUT_DIR, f"{VERSION_PREFIX}-v{VERSION_NAME}.apk")
    shutil.copy(apk_path, final_apk)
    
    print(f"  [sign] Signing...")
    run([
        "jarsigner",
        "-keystore", KEYSTORE,
        "-storepass", KEYSTORE_PASS,
        "-keypass", KEYSTORE_PASS,
        "-sigalg", "SHA256withRSA",
        "-digestalg", "SHA-256",
        final_apk,
        KEY_ALIAS,
    ])
    
    run(["jarsigner", "-verify", final_apk])
    
    size = os.path.getsize(final_apk)
    print(f"  [sign] Signed APK: {final_apk} ({size} bytes)")
    return final_apk

def verify_timestamp():
    ts = time.strftime("%Y-%m-%dT%H:%M:%SZ", time.gmtime())
    log_path = os.path.join(VERIFY_DIR, "watchdog.log")
    with open(log_path, 'a') as f:
        f.write(f"[{ts}] BUILD PASS | VERSION: {VERSION_NAME}\n")

def main():
    start_time = time.time()
    print("=" * 60)
    print(f"  Land O Lil v{VERSION_NAME} — WebView + Three.js APK Builder")
    print(f"  Package: {PACKAGE}")
    print("=" * 60)
    
    clean()
    
    print("\n[1/6] Generating R.java from resources...")
    generate_r_java()
    
    print("\n[2/6] Compiling Java source...")
    class_files = compile_java()
    
    print("\n[3/6] Converting to DEX bytecode...")
    dex_path = convert_to_dex(class_files)
    
    print("\n[4/6] Building resources...")
    arsc_path = build_minimal_arsc()
    
    print("\n[5/6] Assembling APK with assets...")
    apk_path = assemble_apk(dex_path, arsc_path)
    
    print("\n[6/6] Signing APK...")
    final_apk = sign_apk(apk_path)
    
    elapsed = time.time() - start_time
    size = os.path.getsize(final_apk)
    
    verify_timestamp()
    
    print("\n" + "=" * 60)
    print(f"  BUILD COMPLETE — Land O Lil v{VERSION_NAME}")
    print(f"  APK: {final_apk}")
    print(f"  Size: {size} bytes ({size/1024:.1f} KB)")
    print(f"  Time: {elapsed:.1f}s")
    print("=" * 60)
    
    # Copy to repo root
    root_apk = os.path.join(SCRIPT_DIR, "..", "..", "..", "..", f"{VERSION_PREFIX}-v{VERSION_NAME}.apk")
    shutil.copy(final_apk, root_apk)
    print(f"  Copied to repo root: {root_apk}")
    
    return 0

if __name__ == "__main__":
    sys.exit(main())
