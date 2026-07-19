#!/bin/bash
# ============================================================
# project-scaffold.sh — Create a new CarrPod Android project
# Sets up the standard directory structure and minimal files.
# Usage: bash project-scaffold.sh MyApp com.carrpod.myapp
# ============================================================
set -e

APP_NAME="${1:-MyApp}"
PACKAGE="${2:-com.carrpod.myapp}"
PACKAGE_PATH="${PACKAGE//./\/}"

echo "Scaffolding: $APP_NAME ($PACKAGE)"

mkdir -p "src/main/java/$PACKAGE_PATH"
mkdir -p "src/main/res/values"
mkdir -p "src/main/res/mipmap-anydpi-v26"
mkdir -p "src/main/assets"
mkdir -p "out" "obj" "gen"

cat > "src/main/AndroidManifest.xml" << XML
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="$PACKAGE">

    <uses-permission android:name="android.permission.INTERNET" />

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:theme="@android:style/Theme.Material.NoActionBar"
        android:usesCleartextTraffic="true"
        android:hardwareAccelerated="true">

        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:screenOrientation="portrait"
            android:hardwareAccelerated="true"
            android:configChanges="orientation|screenSize|keyboardHidden">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
XML

cat > "src/main/res/values/strings.xml" << XML
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="app_name">$APP_NAME</string>
    <string name="tagline">CarrPod \u2022 Safe Pod Engineering Company</string>
    <string name="clean_view">Clean View</string>
</resources>
XML

cat > "src/main/res/values/colors.xml" << XML
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="app_bg">#FF0A0A0F</color>
    <color name="app_fg">#FFFF6600</color>
</resources>
XML

cat > "src/main/res/mipmap-anydpi-v26/ic_launcher.xml" << XML
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@color/app_bg"/>
    <foreground android:drawable="@color/app_fg"/>
</adaptive-icon>
XML

cat > "src/main/java/$PACKAGE_PATH/MainActivity.java" << JAVA
package $PACKAGE;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.parseColor("#0A0A0F"));

        LinearLayout content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        content.setGravity(Gravity.CENTER);
        FrameLayout.LayoutParams cp = new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        content.setLayoutParams(cp);

        TextView logo = new TextView(this);
        logo.setText("$APP_NAME");
        logo.setTextSize(36f);
        logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setGravity(Gravity.CENTER);
        content.addView(logo);

        TextView tag = new TextView(this);
        tag.setText("CarrPod — Safe Pod Engineering Company");
        tag.setTextSize(12f);
        tag.setTextColor(Color.parseColor("#8888A0"));
        tag.setGravity(Gravity.CENTER);
        tag.setPadding(0, 16, 0, 0);
        content.addView(tag);

        root.addView(content);
        setContentView(root);
    }
}
JAVA

# Copy build-apk.sh template from toolkit if available
TOOLKIT="$(dirname "$0")/build-apk.sh"
if [ -f "$TOOLKIT" ]; then
    cp "$TOOLKIT" ./build.sh
    echo "Copied build script from toolkit."
else
    echo "No build-apk.sh found in toolkit — copy it to ./build.sh manually."
fi

echo ""
echo "═══════════════════════════════════════════════════════"
echo "  Project scaffolded: $APP_NAME"
echo "  Package: $PACKAGE"
echo ""
echo "  Next steps:"
echo "  1. Edit build.sh — set PACKAGE, APP_NAME, VERSION"
echo "  2. Edit MainActivity.java"
echo "  3. Run: bash build.sh"
echo "═══════════════════════════════════════════════════════"
