# SUB-PLAN 04 — RESOURCES AND MANIFEST
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 4 of 13
## Estimated Total Time: 5 minutes | GOAL: AndroidManifest.xml, colors.xml, strings.xml, ic_launcher.xml

---

## PRE-REQUISITES
- SUB-PLAN-03 completed (directory structure exists)
- $MARM_ROOT variable set

---

## OBJECTIVE
Create all XML resource files and the AndroidManifest.xml. This is the foundation that aapt2 will compile. NO Gradle files. NO package="" attribute in manifest.

---

## CRITICAL MANIFEST RULES (From GEMINI-APK-BUILDING-GUIDE-V2.md):
1. NO `package=""` attribute on <manifest> — set via aapt2 `--rename-manifest-package`
2. `android:exported="true"` REQUIRED on all activities with intent-filters
3. Use `@android:style/Theme.Material.NoActionBar` — direct framework reference
4. Use plain `Activity`, not `AppCompatActivity` — avoids AndroidX dependency
5. Include all required permissions upfront: INTERNET, BLUETOOTH, BLUETOOTH_ADMIN, BLUETOOTH_CONNECT, BLUETOOTH_SCAN
6. `usesCleartextTraffic="true"` for HTTP comms with dev servers
7. Two activities: MainActivity (launcher) + BtDiagnosticActivity (via intent)

---

## STEP-BY-STEP COMMANDS

### STEP 04-01: Create colors.xml
Write file: $MARM_ROOT/src/main/res/values/colors.xml
[CMD] Write colors.xml (see FILE SPEC below)
Expected time: 1s
Verification: `ls $MARM_ROOT/src/main/res/values/colors.xml && echo "COLORS OK"`
Rollback: `rm $MARM_ROOT/src/main/res/values/colors.xml`

### STEP 04-02: Create strings.xml
Write file: $MARM_ROOT/src/main/res/values/strings.xml
[CMD] Write strings.xml (see FILE SPEC below)
Expected time: 1s
Verification: `ls $MARM_ROOT/src/main/res/values/strings.xml && echo "STRINGS OK"`
Rollback: `rm $MARM_ROOT/src/main/res/values/strings.xml`

### STEP 04-03: Create ic_launcher.xml (adaptive icon)
Write file: $MARM_ROOT/src/main/res/mipmap-anydpi-v26/ic_launcher.xml
[CMD] Write ic_launcher.xml (see FILE SPEC below)
Expected time: 1s
Verification: `ls $MARM_ROOT/src/main/res/mipmap-anydpi-v26/ic_launcher.xml && echo "ICON OK"`
Rollback: `rm $MARM_ROOT/src/main/res/mipmap-anydpi-v26/ic_launcher.xml`

### STEP 04-04: Create AndroidManifest.xml
Write file: $MARM_ROOT/src/main/AndroidManifest.xml
[CMD] Write AndroidManifest.xml (see FILE SPEC below)
Expected time: 1s
Verification: `ls $MARM_ROOT/src/main/AndroidManifest.xml && echo "MANIFEST OK"`
Rollback: `rm $MARM_ROOT/src/main/AndroidManifest.xml`

### STEP 04-05: Verify all XML files are valid
[CMD] xmllint --noout $MARM_ROOT/src/main/AndroidManifest.xml 2>&1 || echo "xmllint not installed, skip"
Expected time: 0.5s
Verification: No XML parse errors
Rollback: N/A

---

## FILE SPEC: colors.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="marmalade_bg">#0A0A0F</color>
    <color name="marmalade_fg">#E8E8F0</color>
    <color name="marmalade_orange">#FF6600</color>
    <color name="marmalade_green">#00FF88</color>
    <color name="marmalade_yellow">#FFCC00</color>
    <color name="marmalade_red">#FF4466</color>
    <color name="marmalade_gray">#8888A0</color>
    <color name="marmalade_dark">#1A1A2E</color>
    <color name="marmalade_blue">#4488FF</color>
</resources>
```

## FILE SPEC: strings.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">Marmalade</string>
    <string name="app_subtitle">Safe Pod Engineering Company</string>
    <string name="app_version">Stage Super2 — v2.0.0</string>
    <string name="dashboard_title">Session Dashboard</string>
    <string name="session_config_title">Session Config</string>
    <string name="director_comms_title">Director COMMS</string>
    <string name="bluetooth_title">Bluetooth Diagnostic</string>
    <string name="settings_title">Settings</string>
    <string name="release_memory">Release Memory</string>
    <string name="session_active">ACTIVE</string>
    <string name="session_stale">STALE</string>
    <string name="session_offline">OFFLINE</string>
    <string name="session_empty">EMPTY</string>
    <string name="btn_save">SAVE</string>
    <string name="btn_cancel">CANCEL</string>
    <string name="btn_send">SEND DIRECTIVE</string>
    <string name="btn_back">BACK TO DASHBOARD</string>
</resources>
```

## FILE SPEC: ic_launcher.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@android:color/black"/>
    <foreground android:drawable="@android:color/black"/>
</adaptive-icon>
```

## FILE SPEC: AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.BLUETOOTH" />
    <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
    <uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />
    <uses-permission android:name="android.permission.BLUETOOTH_SCAN"
        android:usesPermissionFlags="neverForLocation" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@android:style/Theme.Material.NoActionBar"
        android:usesCleartextTraffic="true">

        <activity
            android:name="com.carrpod.marmalade.MainActivity"
            android:exported="true"
            android:screenOrientation="portrait"
            android:configChanges="orientation|screenSize|keyboardHidden">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <activity
            android:name="com.carrpod.marmalade.screens.BtDiagnosticScreen"
            android:exported="false"
            android:screenOrientation="portrait" />

    </application>
</manifest>
```

---

## COMPLETION CHECK
- [ ] colors.xml exists with 9 CITADEL theme colors
- [ ] strings.xml exists with 17 string resources
- [ ] ic_launcher.xml exists (adaptive icon, black-on-black minimal)
- [ ] AndroidManifest.xml exists with NO package="" attribute
- [ ] Manifest has INTERNET, BLUETOOTH, BLUETOOTH_ADMIN, BLUETOOTH_CONNECT, BLUETOOTH_SCAN, ACCESS_NETWORK_STATE permissions
- [ ] Manifest has `android:exported="true"` on MainActivity
- [ ] Manifest uses `@android:style/Theme.Material.NoActionBar`
- [ ] Manifest references `com.carrpod.marmalade.MainActivity` and `com.carrpod.marmalade.screens.BtDiagnosticScreen`
- [ ] usesCleartextTraffic="true" set on application

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-04-resources.log
```

---

*SUB-PLAN-04 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
