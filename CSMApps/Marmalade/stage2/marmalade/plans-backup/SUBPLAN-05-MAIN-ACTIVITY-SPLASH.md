# SUB-PLAN 05 — MAIN ACTIVITY AND SPLASH SCREEN
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 5 of 13
## Estimated Total Time: 10 minutes | GOAL: MainActivity.java with splash screen + navigation hub

---

## PRE-REQUISITES
- SUB-PLAN-04 completed (AndroidManifest.xml and resources exist)
- $MARM_ROOT/src/main/java/com/carrpod/marmalade/ directory exists

---

## OBJECTIVE
Write MainActivity.java — the entry point of the app. This class serves as:
1. The splash screen (shown for 3 seconds on launch)
2. The navigation hub that switches between all other screens
3. The activity declared as MAIN/LAUNCHER in AndroidManifest.xml
4. Uses programmatic UI construction (no XML layouts, pure Java views)

---

## ARCHITECTURE NOTE
MainActivity extends `android.app.Activity` (NOT AppCompatActivity). This avoids the entire AndroidX dependency tree. The background is set to CITADEL-BG (#0A0A0F). CarrPod orange (#FF6600) is used for the logo and accent elements.

The NavigationManager utility (SUB-PLAN-12) will handle screen switching. For now, MainActivity builds the splash screen and provides a method for screen switching that all other screens call back to.

---

## STEP-BY-STEP COMMANDS

### STEP 05-01: Write MainActivity.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/MainActivity.java
[CMD] Write MainActivity.java (see FULL FILE SPEC below)
Expected time: 5s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/MainActivity.java && wc -l $MARM_ROOT/src/main/java/com/carrpod/marmalade/MainActivity.java && echo "MAIN OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/MainActivity.java`

### STEP 05-02: Verify Java syntax (quick check that file has valid structure)
[CMD] grep -q "public class MainActivity" $MARM_ROOT/src/main/java/com/carrpod/marmalade/MainActivity.java && echo "CLASS OK"
Expected time: 0.1s
Verification: Output contains "CLASS OK"
Rollback: N/A

### STEP 05-03: Verify package declaration
[CMD] grep -q "package com.carrpod.marmalade;" $MARM_ROOT/src/main/java/com/carrpod/marmalade/MainActivity.java && echo "PKG OK"
Expected time: 0.1s
Verification: Output contains "PKG OK"
Rollback: N/A

### STEP 05-04: Verify MainActivity extends Activity (not AppCompatActivity)
[CMD] grep -q "extends Activity" $MARM_ROOT/src/main/java/com/carrpod/marmalade/MainActivity.java && echo "EXTENDS OK"
Expected time: 0.1s
Verification: Output contains "EXTENDS OK"
Rollback: N/A

---

## FULL FILE SPEC: MainActivity.java

```java
package com.carrpod.marmalade;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private LinearLayout rootLayout;
    private String currentScreen = "SPLASH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootLayout = new LinearLayout(this);
        rootLayout.setOrientation(LinearLayout.VERTICAL);
        rootLayout.setGravity(Gravity.CENTER);
        rootLayout.setBackgroundColor(Color.parseColor("#0A0A0F"));
        rootLayout.setLayoutParams(new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT));
        showSplash();
    }

    private void showSplash() {
        currentScreen = "SPLASH";
        rootLayout.removeAllViews();

        LinearLayout splashLayout = new LinearLayout(this);
        splashLayout.setOrientation(LinearLayout.VERTICAL);
        splashLayout.setGravity(Gravity.CENTER);

        TextView logo = new TextView(this);
        logo.setText("CARRPOD");
        logo.setTextSize(48);
        logo.setTextColor(Color.parseColor("#FF6600"));
        logo.setTypeface(Typeface.DEFAULT_BOLD);
        logo.setGravity(Gravity.CENTER);
        logo.setPadding(0, 0, 0, dp(16));

        TextView subtitle = new TextView(this);
        subtitle.setText("Safe Pod Engineering Company");
        subtitle.setTextSize(12);
        subtitle.setTextColor(Color.parseColor("#8888A0"));
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 0, 0, dp(64));

        TextView appName = new TextView(this);
        appName.setText("Marmalade");
        appName.setTextSize(32);
        appName.setTextColor(Color.parseColor("#E8E8F0"));
        appName.setTypeface(Typeface.DEFAULT_BOLD);
        appName.setGravity(Gravity.CENTER);
        appName.setPadding(0, 0, 0, dp(8));

        TextView version = new TextView(this);
        version.setText("Stage Super2 — v2.0.0");
        version.setTextSize(12);
        version.setTextColor(Color.parseColor("#FF6600"));
        version.setGravity(Gravity.CENTER);
        version.setPadding(0, 0, 0, dp(16));

        TextView protocol = new TextView(this);
        protocol.setText("CITADEL Protocol Active");
        protocol.setTextSize(10);
        protocol.setTextColor(Color.parseColor("#00FF88"));
        protocol.setGravity(Gravity.CENTER);

        splashLayout.addView(logo);
        splashLayout.addView(subtitle);
        splashLayout.addView(appName);
        splashLayout.addView(version);
        splashLayout.addView(protocol);

        rootLayout.addView(splashLayout);
        setContentView(rootLayout);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                showDashboard();
            }
        }, 3000);
    }

    public void showDashboard() {
        currentScreen = "DASHBOARD";
        com.carrpod.marmalade.screens.DashboardScreen.render(this, rootLayout);
    }

    public void showSessionConfig(int slotNumber) {
        currentScreen = "SESSION_CONFIG";
        com.carrpod.marmalade.screens.SessionConfigScreen.render(this, rootLayout, slotNumber);
    }

    public void showDirectorComms() {
        currentScreen = "DIRECTOR_COMMS";
        com.carrpod.marmalade.screens.DirectorCommsScreen.render(this, rootLayout);
    }

    public void showBtDiagnostic() {
        currentScreen = "BT_DIAGNOSTIC";
        com.carrpod.marmalade.screens.BtDiagnosticScreen.render(this, rootLayout);
    }

    public void showSettings() {
        currentScreen = "SETTINGS";
        com.carrpod.marmalade.screens.SettingsScreen.render(this, rootLayout);
    }

    public LinearLayout getRootLayout() {
        return rootLayout;
    }

    private int dp(int px) {
        return (int)(px * getResources().getDisplayMetrics().density);
    }
}
```

---

## COMPLETION CHECK
- [ ] MainActivity.java exists at correct path
- [ ] Package declaration is `com.carrpod.marmalade`
- [ ] Extends `android.app.Activity` (not AppCompatActivity)
- [ ] Contains showSplash() method with CarrPod branding
- [ ] Contains navigation methods: showDashboard(), showSessionConfig(), showDirectorComms(), showBtDiagnostic(), showSettings()
- [ ] Splash auto-advances to Dashboard after 3 seconds
- [ ] Uses CITADEL color palette (#0A0A0F, #FF6600, #E8E8F0, #8888A0, #00FF88)
- [ ] Has dp() helper method
- [ ] Has getRootLayout() for screen switching

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-05-main.log
```

---

*SUB-PLAN-05 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
