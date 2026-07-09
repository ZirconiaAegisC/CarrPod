# SUB-PLAN 11 — SETTINGS SCREEN
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 11 of 13
## Estimated Total Time: 10 minutes | GOAL: Full settings panel — polling intervals, heartbeat thresholds, git config, theme

---

## PRE-REQUISITES
- SUB-PLAN-05 completed (MainActivity with showSettings method)
- SUB-PLAN-06 completed (SessionStorage for settings persistence)

---

## OBJECTIVE
Create SettingsScreen.java — a full settings panel for the Director's app. Settings include:
1. Polling interval (seconds) — how often the app checks sibling heartbeats
2. Heartbeat stale threshold (seconds) — when a sibling is marked STALE vs OFFLINE
3. GitHub raw base URL — base URL for fetching COMMS files
4. GitHub token (masked) — personal access token for authenticated API calls
5. CITADEL session ID — the Director's own session ID
6. Theme selector — currently only CITADEL Dark (future: Light mode)
7. About section — version, build date, repository link
8. Reset All Data button — wipes all session configurations

---

## SETTINGS STORAGE
Settings are stored using SharedPreferences with key prefix "marmalade_settings_" to keep them separate from session data. SettingsScreen reads and writes through a SettingsHelper inner class.

---

## STEP-BY-STEP COMMANDS

### STEP 11-01: Write SettingsScreen.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/SettingsScreen.java
[CMD] Write SettingsScreen.java (see FULL FILE SPEC below)
Expected time: 7s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/SettingsScreen.java && echo "SETTINGS OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/SettingsScreen.java`

---

## FULL FILE SPEC: SettingsScreen.java

```java
package com.carrpod.marmalade.screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.carrpod.marmalade.MainActivity;

public class SettingsScreen {

    private static final String SETTINGS_PREFS = "marmalade_settings";
    private static final String KEY_POLL_INTERVAL = "poll_interval_seconds";
    private static final String KEY_STALE_THRESHOLD = "stale_threshold_seconds";
    private static final String KEY_GIT_BASE_URL = "git_base_url";
    private static final String KEY_GIT_TOKEN = "git_token";
    private static final String KEY_CITADEL_SESSION = "citadel_session_id";

    private static final String DEFAULT_POLL_INTERVAL = "5";
    private static final String DEFAULT_STALE_THRESHOLD = "30";
    private static final String DEFAULT_GIT_BASE_URL = "https://raw.githubusercontent.com/ZirconiaAegisC/CarrPod/main/";
    private static final String DEFAULT_CITADEL_SESSION = "agent_7d77648c-9af0-4e38-a3b0-fe31f037ba16";

    public static void render(MainActivity activity, LinearLayout rootLayout) {
        rootLayout.removeAllViews();
        final Context ctx = activity;

        LinearLayout mainColumn = new LinearLayout(activity);
        mainColumn.setOrientation(LinearLayout.VERTICAL);
        mainColumn.setBackgroundColor(Color.parseColor("#0A0A0F"));
        mainColumn.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        // Title bar
        LinearLayout titleBar = new LinearLayout(activity);
        titleBar.setOrientation(LinearLayout.HORIZONTAL);
        titleBar.setBackgroundColor(Color.parseColor("#1A1A2E"));
        titleBar.setPadding(dp(ctx,12),dp(ctx,8),dp(ctx,12),dp(ctx,8));
        titleBar.setGravity(Gravity.CENTER_VERTICAL);

        Button backBtn = new Button(activity);
        backBtn.setText("< BACK");
        backBtn.setTextSize(12);
        backBtn.setTextColor(Color.parseColor("#E8E8F0"));
        backBtn.setBackgroundColor(Color.parseColor("#FF6600"));
        backBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ activity.showDashboard(); }
        });

        TextView title = new TextView(activity);
        title.setText("SETTINGS");
        title.setTextSize(16);
        title.setTextColor(Color.parseColor("#FF6600"));
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1);
        title.setLayoutParams(titleParams);

        titleBar.addView(backBtn);
        titleBar.addView(title);
        mainColumn.addView(titleBar);

        // Scrollable settings form
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1));

        LinearLayout form = new LinearLayout(activity);
        form.setOrientation(LinearLayout.VERTICAL);
        form.setPadding(dp(ctx,16),dp(ctx,12),dp(ctx,16),dp(ctx,12));

        final SharedPreferences prefs = ctx.getSharedPreferences(SETTINGS_PREFS, Context.MODE_PRIVATE);

        // Polling Interval
        form.addView(sectionLabel(ctx, "POLLING"));
        final EditText pollField = settingsField(ctx, prefs.getString(KEY_POLL_INTERVAL, DEFAULT_POLL_INTERVAL));
        form.addView(labeledField(ctx, "Poll Interval (seconds)", pollField, "How often to check sibling heartbeats"));

        // Stale Threshold
        final EditText staleField = settingsField(ctx, prefs.getString(KEY_STALE_THRESHOLD, DEFAULT_STALE_THRESHOLD));
        form.addView(labeledField(ctx, "Stale Threshold (seconds)", staleField, "Sibling marked STALE after this many seconds"));

        // Git Base URL
        form.addView(sectionLabel(ctx, "GITHUB"));
        final EditText gitUrlField = settingsField(ctx, prefs.getString(KEY_GIT_BASE_URL, DEFAULT_GIT_BASE_URL));
        gitUrlField.setSingleLine(false);
        gitUrlField.setMinLines(2);
        form.addView(labeledField(ctx, "GitHub Raw Base URL", gitUrlField, "Base URL for COMMS file access"));

        // Git Token
        final EditText tokenField = settingsField(ctx, prefs.getString(KEY_GIT_TOKEN, ""));
        tokenField.setHint("ghp_************************************");
        tokenField.setHintTextColor(Color.parseColor("#555566"));
        form.addView(labeledField(ctx, "GitHub Token (masked)", tokenField, "Personal Access Token for authenticated API"));

        // CITADEL Session ID
        form.addView(sectionLabel(ctx, "DIRECTOR"));
        final EditText sessionField = settingsField(ctx, prefs.getString(KEY_CITADEL_SESSION, DEFAULT_CITADEL_SESSION));
        form.addView(labeledField(ctx, "CITADEL Session ID", sessionField, "Director's own agent session ID"));

        // Theme
        form.addView(sectionLabel(ctx, "APPEARANCE"));
        TextView themeInfo = new TextView(ctx);
        themeInfo.setText("Theme: CITADEL Dark (#0A0A0F)\n(Future: Light mode)");
        themeInfo.setTextSize(12);
        themeInfo.setTextColor(Color.parseColor("#8888A0"));
        themeInfo.setPadding(0,0,0,dp(ctx,12));
        form.addView(themeInfo);

        // About
        form.addView(sectionLabel(ctx, "ABOUT"));
        TextView aboutInfo = new TextView(ctx);
        aboutInfo.setText("Marmalade Stage Super2 v2.0.0\n" +
                         "Multi-Session Kilo Controller\n" +
                         "No-Gradle Build (aapt2 + d8)\n" +
                         "Target: Android 14+ (API 35)\n" +
                         "Build: 2026-07-09\n" +
                         "Repository: github.com/ZirconiaAegisC/CarrPod\n" +
                         "Director: Kairos Steele, CITADEL");
        aboutInfo.setTextSize(11);
        aboutInfo.setTextColor(Color.parseColor("#8888A0"));
        aboutInfo.setPadding(0,0,0,dp(ctx,8));
        form.addView(aboutInfo);

        // Save Settings button
        form.addView(spacer(ctx,dp(ctx,8)));
        Button saveBtn = new Button(ctx);
        saveBtn.setText("SAVE SETTINGS");
        saveBtn.setTextSize(14);
        saveBtn.setTextColor(Color.parseColor("#FFFFFF"));
        saveBtn.setBackgroundColor(Color.parseColor("#00FF88"));
        saveBtn.setPadding(dp(ctx,24),dp(ctx,10),dp(ctx,24),dp(ctx,10));
        saveBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(KEY_POLL_INTERVAL, pollField.getText().toString());
                editor.putString(KEY_STALE_THRESHOLD, staleField.getText().toString());
                editor.putString(KEY_GIT_BASE_URL, gitUrlField.getText().toString());
                editor.putString(KEY_GIT_TOKEN, tokenField.getText().toString());
                editor.putString(KEY_CITADEL_SESSION, sessionField.getText().toString());
                editor.apply();
                new AlertDialog.Builder(ctx)
                    .setTitle("Settings Saved")
                    .setMessage("All settings saved.\nRestart app for polling changes to take effect.")
                    .setPositiveButton("OK", null)
                    .show();
            }
        });
        form.addView(saveBtn);

        // Reset All Data button
        form.addView(spacer(ctx,dp(ctx,8)));
        Button resetBtn = new Button(ctx);
        resetBtn.setText("RESET ALL SESSION DATA");
        resetBtn.setTextSize(14);
        resetBtn.setTextColor(Color.parseColor("#FFFFFF"));
        resetBtn.setBackgroundColor(Color.parseColor("#FF4466"));
        resetBtn.setPadding(dp(ctx,24),dp(ctx,10),dp(ctx,24),dp(ctx,10));
        resetBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new AlertDialog.Builder(ctx)
                    .setTitle("CONFIRM RESET")
                    .setMessage("This will delete ALL 100 session slot configurations.\n\nThis cannot be undone.\n\nAre you sure?")
                    .setPositiveButton("YES, RESET ALL", new android.content.DialogInterface.OnClickListener(){
                        public void onClick(android.content.DialogInterface d, int w){
                            ctx.getSharedPreferences("marmalade_sessions", Context.MODE_PRIVATE).edit().clear().apply();
                            ctx.getSharedPreferences(SETTINGS_PREFS, Context.MODE_PRIVATE).edit().clear().apply();
                            new AlertDialog.Builder(ctx)
                                .setTitle("Reset Complete")
                                .setMessage("All session data and settings cleared.")
                                .setPositiveButton("OK", null)
                                .show();
                        }
                    })
                    .setNegativeButton("CANCEL", null)
                    .show();
            }
        });
        form.addView(resetBtn);

        // Bluetooth Diagnostic shortcut
        form.addView(spacer(ctx,dp(ctx,8)));
        Button btBtn = new Button(ctx);
        btBtn.setText("BLUETOOTH DIAGNOSTIC");
        btBtn.setTextSize(14);
        btBtn.setTextColor(Color.parseColor("#FFFFFF"));
        btBtn.setBackgroundColor(Color.parseColor("#4488FF"));
        btBtn.setPadding(dp(ctx,24),dp(ctx,10),dp(ctx,24),dp(ctx,10));
        btBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ activity.showBtDiagnostic(); }
        });
        form.addView(btBtn);

        scrollView.addView(form);
        mainColumn.addView(scrollView);
        rootLayout.addView(mainColumn);
        activity.setContentView(rootLayout);
    }

    private static TextView sectionLabel(Context ctx, String text){
        TextView tv = new TextView(ctx);
        tv.setText(text);
        tv.setTextSize(11);
        tv.setTextColor(Color.parseColor("#FF6600"));
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setPadding(0,dp(ctx,16),0,dp(ctx,6));
        return tv;
    }

    private static EditText settingsField(Context ctx, String value){
        EditText et = new EditText(ctx);
        et.setText(value);
        et.setTextSize(13);
        et.setTextColor(Color.parseColor("#E8E8F0"));
        et.setBackgroundColor(Color.parseColor("#1A1A2E"));
        et.setPadding(dp(ctx,8),dp(ctx,8),dp(ctx,8),dp(ctx,8));
        et.setSingleLine(true);
        return et;
    }

    private static LinearLayout labeledField(Context ctx, String label, EditText field, String hint){
        LinearLayout row = new LinearLayout(ctx);
        row.setOrientation(LinearLayout.VERTICAL);

        TextView lbl = new TextView(ctx);
        lbl.setText(label);
        lbl.setTextSize(11);
        lbl.setTextColor(Color.parseColor("#8888A0"));
        lbl.setPadding(0,0,0,dp(ctx,2));
        row.addView(lbl);
        row.addView(field);

        TextView hintView = new TextView(ctx);
        hintView.setText(hint);
        hintView.setTextSize(9);
        hintView.setTextColor(Color.parseColor("#555566"));
        hintView.setPadding(0,dp(ctx,2),0,dp(ctx,4));
        row.addView(hintView);

        return row;
    }

    private static View spacer(Context ctx, int height){
        View v = new View(ctx);
        v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
        return v;
    }

    private static int dp(Context ctx, int px){
        return (int)(px * ctx.getResources().getDisplayMetrics().density);
    }
}
```

---

## COMPLETION CHECK
- [ ] SettingsScreen.java exists with static render(MainActivity, LinearLayout)
- [ ] Poll Interval field with default 5 seconds
- [ ] Stale Threshold field with default 30 seconds
- [ ] Git Base URL field with default raw GitHub URL
- [ ] Git Token field (masked hint)
- [ ] CITADEL Session ID field with default agent ID
- [ ] Theme section showing "CITADEL Dark"
- [ ] About section with version, build date, repo link
- [ ] SAVE SETTINGS button persists to SharedPreferences
- [ ] RESET ALL SESSION DATA with confirmation dialog
- [ ] BLUETOOTH DIAGNOSTIC shortcut button
- [ ] BACK button returns to Dashboard

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-11-settings.log
```

---

*SUB-PLAN-11 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
