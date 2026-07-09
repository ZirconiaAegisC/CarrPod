# SUB-PLAN 08 — SESSION CONFIG SCREEN
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 8 of 13
## Estimated Total Time: 12 minutes | GOAL: Full session editor with all fields + pre-loaded Director personality data

---

## PRE-REQUISITES
- SUB-PLAN-06 completed (SessionModel, SessionStorage)
- SUB-PLAN-07 completed (DashboardScreen)

---

## OBJECTIVE
Create SessionConfigScreen.java — the screen that allows the Director to configure a single session slot. It provides:
1. Scrollable form with all SessionModel fields as labeled EditText inputs
2. Load existing session data from SessionStorage if slot already configured
3. Pre-populate dropdown values for codename, LLM engine, Director ID from known lists
4. SAVE button persists to SessionStorage
5. BACK button returns to Dashboard
6. DELETE button clears the slot

---

## PRE-LOADED DATA

### Known Directors (codename mapping):
```
1: CITADEL (Kairos Steele)
2: PHANTOM (Nyx Calder)
3: PROTON (Solara Vance)
4: NEURAL (Theron Nash)
5: CERVICAL (Lyra Kade)
6: MAGLEV (Rook Draven)
7: SILENCER (Orion Cross)
8: THORAX (Zephyr Arden)
9: STELLAR (Cypher Voss)
10: WAYFINDER (Eira Solven)
11: PET-SAFE (Bran Solara)
12: CLOUD-NEST (Thalia Rook)
13: ASCENSION (Auric Veyne)
14: ULNAR (Iris Dorne)
15: FLUID-DAMP (Sylas Fen)
16: HORIZON (Meridia Vaun) [SLOT ORIGINALLY CHARLEMAGNE]
17: VEIL (Corvus Nyx)
18: AURA (Aura Kind)
19: CORTEX (Kael Forge)
1B: BASTION
20: FOUNDRY (Mira Sable)
21: RENDER (Ash Vero)
22: PIPELINE (Dax Sever)
23: SENTINEL (Tess Mara)
```

### Known LLM Engines:
- deepseek-v4-pro
- gemini-2.5-pro
- claude-sonnet-4
- gpt-4o
- claude-opus-4
- gemini-2.5-flash

### Git branch options:
- main
- origin/main

---

## STEP-BY-STEP COMMANDS

### STEP 08-01: Write SessionConfigScreen.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/SessionConfigScreen.java
[CMD] Write SessionConfigScreen.java (see FULL FILE SPEC below)
Expected time: 7s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/SessionConfigScreen.java && echo "CONFIG OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/SessionConfigScreen.java`

---

## FULL FILE SPEC: SessionConfigScreen.java

```java
package com.carrpod.marmalade.screens;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.carrpod.marmalade.MainActivity;
import com.carrpod.marmalade.models.SessionModel;
import com.carrpod.marmalade.storage.SessionStorage;

public class SessionConfigScreen {

    private static final String[] CODENAMES = {
        "CITADEL","PHANTOM","PROTON","NEURAL","CERVICAL",
        "MAGLEV","SILENCER","THORAX","STELLAR","WAYFINDER",
        "PET-SAFE","CLOUD-NEST","ASCENSION","ULNAR","FLUID-DAMP",
        "HORIZON","VEIL","AURA","CORTEX","BASTION",
        "FOUNDRY","RENDER","PIPELINE","SENTINEL"
    };

    private static final String[] PERSON_NAMES = {
        "Kairos Steele","Nyx Calder","Solara Vance","Theron Nash","Lyra Kade",
        "Rook Draven","Orion Cross","Zephyr Arden","Cypher Voss","Eira Solven",
        "Bran Solara","Thalia Rook","Auric Veyne","Iris Dorne","Sylas Fen",
        "Meridia Vaun","Corvus Nyx","Aura Kind","Kael Forge","BASTION",
        "Mira Sable","Ash Vero","Dax Sever","Tess Mara"
    };

    private static final String[] DIRECTOR_IDS = {
        "DIRECTOR-0001","DIRECTOR-0002","DIRECTOR-0003","DIRECTOR-0004","DIRECTOR-0005",
        "DIRECTOR-0006","DIRECTOR-0007","DIRECTOR-0008","DIRECTOR-0009","DIRECTOR-0010",
        "DIRECTOR-0011","DIRECTOR-0012","DIRECTOR-0013","DIRECTOR-0014","DIRECTOR-0015",
        "DIRECTOR-0016","DIRECTOR-0017","DIRECTOR-0018","DIRECTOR-0019","DIRECTOR-001B",
        "DIRECTOR-0020","DIRECTOR-0021","DIRECTOR-0022","DIRECTOR-0023"
    };

    private static final String[] LLM_ENGINES = {
        "deepseek-v4-pro","gemini-2.5-pro","claude-sonnet-4","gpt-4o",
        "claude-opus-4","gemini-2.5-flash"
    };

    private static final String[] GIT_BRANCHES = {"main","origin/main"};

    public static void render(MainActivity activity, LinearLayout rootLayout, int slotNumber) {
        rootLayout.removeAllViews();

        final SessionStorage storage = new SessionStorage(activity);
        final SessionModel session = storage.getSession(slotNumber);
        session.slotNumber = slotNumber;

        LinearLayout mainColumn = new LinearLayout(activity);
        mainColumn.setOrientation(LinearLayout.VERTICAL);
        mainColumn.setBackgroundColor(Color.parseColor("#0A0A0F"));
        mainColumn.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        // Title bar
        LinearLayout titleBar = new LinearLayout(activity);
        titleBar.setOrientation(LinearLayout.HORIZONTAL);
        titleBar.setBackgroundColor(Color.parseColor("#1A1A2E"));
        titleBar.setPadding(dp(activity,12),dp(activity,8),dp(activity,12),dp(activity,8));
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
        title.setText("CONFIG: SLOT " + slotNumber);
        title.setTextSize(16);
        title.setTextColor(Color.parseColor("#FF6600"));
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1);
        title.setLayoutParams(titleParams);

        titleBar.addView(backBtn);
        titleBar.addView(title);
        mainColumn.addView(titleBar);

        // Scrollable form
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1));

        LinearLayout form = new LinearLayout(activity);
        form.setOrientation(LinearLayout.VERTICAL);
        form.setPadding(dp(activity,16),dp(activity,8),dp(activity,16),dp(activity,8));

        // codename picker
        form.addView(label(activity,"CODENAME"));
        final TextView codenameValue = formValue(activity, session.codename, "e.g. CITADEL");
        codenameValue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ showPicker(activity, "Select Codename", CODENAMES, codenameValue, session); }
        });
        form.addView(codenameValue);

        // person name picker
        form.addView(label(activity,"PERSON NAME"));
        final TextView personValue = formValue(activity, session.personName, "e.g. Kairos Steele");
        personValue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ showPicker(activity, "Select Name", PERSON_NAMES, personValue, session); }
        });
        form.addView(personValue);

        // director ID picker
        form.addView(label(activity,"DIRECTOR ID"));
        final TextView directorValue = formValue(activity, session.directorId, "e.g. DIRECTOR-0001");
        directorValue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ showPicker(activity, "Select Director ID", DIRECTOR_IDS, directorValue, session); }
        });
        form.addView(directorValue);

        // session ID text field
        form.addView(label(activity,"SESSION ID"));
        final EditText sessionIdField = new EditText(activity);
        sessionIdField.setText(session.sessionId);
        sessionIdField.setTextColor(Color.parseColor("#E8E8F0"));
        sessionIdField.setHint("agent_XXXX");
        sessionIdField.setHintTextColor(Color.parseColor("#555566"));
        sessionIdField.setBackgroundColor(Color.parseColor("#1A1A2E"));
        sessionIdField.setPadding(dp(activity,8),dp(activity,8),dp(activity,8),dp(activity,8));
        sessionIdField.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        form.addView(sessionIdField);

        // SOP URL text field
        form.addView(label(activity,"SOP URL"));
        final EditText sopUrlField = new EditText(activity);
        sopUrlField.setText(session.sopUrl);
        sopUrlField.setTextColor(Color.parseColor("#E8E8F0"));
        sopUrlField.setHint("https://github.com/.../DIRECTOR-XXXX.md or local path");
        sopUrlField.setHintTextColor(Color.parseColor("#555566"));
        sopUrlField.setBackgroundColor(Color.parseColor("#1A1A2E"));
        sopUrlField.setPadding(dp(activity,8),dp(activity,8),dp(activity,8),dp(activity,8));
        sopUrlField.setInputType(EditorInfo.TYPE_TEXT_VARIATION_URI);
        sopUrlField.setSingleLine(false);
        sopUrlField.setMinLines(2);
        form.addView(sopUrlField);

        // LLM engine picker
        form.addView(label(activity,"LLM ENGINE"));
        final TextView llmValue = formValue(activity, session.llmEngine, "e.g. deepseek-v4-pro");
        llmValue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ showPicker(activity, "Select LLM Engine", LLM_ENGINES, llmValue, session); }
        });
        form.addView(llmValue);

        // git branch picker
        form.addView(label(activity,"GIT BRANCH"));
        final TextView gitValue = formValue(activity, session.gitBranch, "main");
        gitValue.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ showPicker(activity, "Select Git Branch", GIT_BRANCHES, gitValue, session); }
        });
        form.addView(gitValue);

        // heartbeat path (auto-derived)
        form.addView(label(activity,"HEARTBEAT PATH"));
        EditText hbField = new EditText(activity);
        hbField.setText(session.heartbeatPath);
        hbField.setTextColor(Color.parseColor("#E8E8F0"));
        hbField.setHint("CSMGen/CSMAegis/COMMS/HEARTBEATS/director-XXXX.txt");
        hbField.setHintTextColor(Color.parseColor("#555566"));
        hbField.setBackgroundColor(Color.parseColor("#1A1A2E"));
        hbField.setPadding(dp(activity,8),dp(activity,8),dp(activity,8),dp(activity,8));
        form.addView(hbField);

        // outbox path
        form.addView(label(activity,"OUTBOX PATH"));
        EditText outField = new EditText(activity);
        outField.setText(session.outboxPath);
        outField.setTextColor(Color.parseColor("#E8E8F0"));
        outField.setHint("CSMGen/CSMAegis/COMMS/director-XXXX-outbox.md");
        outField.setHintTextColor(Color.parseColor("#555566"));
        outField.setBackgroundColor(Color.parseColor("#1A1A2E"));
        outField.setPadding(dp(activity,8),dp(activity,8),dp(activity,8),dp(activity,8));
        form.addView(outField);

        // inbox path
        form.addView(label(activity,"INBOX PATH"));
        EditText inField = new EditText(activity);
        inField.setText(session.inboxPath);
        inField.setTextColor(Color.parseColor("#E8E8F0"));
        inField.setHint("CSMGen/CSMAegis/COMMS/director-XXXX-inbox.md");
        inField.setHintTextColor(Color.parseColor("#555566"));
        inField.setBackgroundColor(Color.parseColor("#1A1A2E"));
        inField.setPadding(dp(activity,8),dp(activity,8),dp(activity,8),dp(activity,8));
        form.addView(inField);

        // product
        form.addView(label(activity,"PRODUCT"));
        EditText prodField = new EditText(activity);
        prodField.setText(session.product);
        prodField.setTextColor(Color.parseColor("#E8E8F0"));
        prodField.setHint("Aegis-C Composite Shield");
        prodField.setHintTextColor(Color.parseColor("#555566"));
        prodField.setBackgroundColor(Color.parseColor("#1A1A2E"));
        prodField.setPadding(dp(activity,8),dp(activity,8),dp(activity,8),dp(activity,8));
        form.addView(prodField);

        // save button
        form.addView(spacer(activity,dp(activity,16)));
        Button saveBtn = new Button(activity);
        saveBtn.setText("SAVE");
        saveBtn.setTextSize(16);
        saveBtn.setTextColor(Color.parseColor("#FFFFFF"));
        saveBtn.setBackgroundColor(Color.parseColor("#00FF88"));
        saveBtn.setPadding(dp(activity,24),dp(activity,12),dp(activity,24),dp(activity,12));
        saveBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                session.codename = codenameValue.getText().toString();
                session.personName = personValue.getText().toString();
                session.directorId = directorValue.getText().toString();
                session.sessionId = sessionIdField.getText().toString();
                session.sopUrl = sopUrlField.getText().toString();
                session.llmEngine = llmValue.getText().toString();
                session.gitBranch = gitValue.getText().toString();
                session.heartbeatPath = hbField.getText().toString();
                session.outboxPath = outField.getText().toString();
                session.inboxPath = inField.getText().toString();
                session.product = prodField.getText().toString();
                if (session.status == 0 && !session.sessionId.isEmpty()) session.status = 1;
                session.createdAt = System.currentTimeMillis() / 1000;
                session.slotNumber = slotNumber;
                storage.saveSession(session);
                activity.showDashboard();
            }
        });
        form.addView(saveBtn);

        // delete button
        form.addView(spacer(activity,dp(activity,8)));
        Button delBtn = new Button(activity);
        delBtn.setText("DELETE SLOT " + slotNumber);
        delBtn.setTextSize(14);
        delBtn.setTextColor(Color.parseColor("#FFFFFF"));
        delBtn.setBackgroundColor(Color.parseColor("#FF4466"));
        delBtn.setPadding(dp(activity,24),dp(activity,8),dp(activity,24),dp(activity,8));
        delBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                storage.deleteSession(slotNumber);
                activity.showDashboard();
            }
        });
        form.addView(delBtn);

        scrollView.addView(form);
        mainColumn.addView(scrollView);
        rootLayout.addView(mainColumn);
        activity.setContentView(rootLayout);
    }

    private static TextView label(Context ctx, String text){
        TextView tv = new TextView(ctx);
        tv.setText(text);
        tv.setTextSize(10);
        tv.setTextColor(Color.parseColor("#FF6600"));
        tv.setTypeface(Typeface.DEFAULT_BOLD);
        tv.setPadding(0,dp(ctx,12),0,dp(ctx,4));
        return tv;
    }

    private static TextView formValue(Context ctx, String value, String hint){
        TextView tv = new TextView(ctx);
        tv.setText(value.isEmpty() ? hint : value);
        tv.setTextSize(14);
        tv.setTextColor(value.isEmpty() ? Color.parseColor("#555566") : Color.parseColor("#E8E8F0"));
        tv.setBackgroundColor(Color.parseColor("#1A1A2E"));
        tv.setPadding(dp(ctx,8),dp(ctx,8),dp(ctx,8),dp(ctx,8));
        tv.setMinHeight(dp(ctx,40));
        return tv;
    }

    private static View spacer(Context ctx, int height){
        View v = new View(ctx);
        v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
        return v;
    }

    private static void showPicker(Context ctx, String title, String[] items, final TextView target, final SessionModel session){
        new AlertDialog.Builder(ctx)
            .setTitle(title)
            .setItems(items, new android.content.DialogInterface.OnClickListener(){
                public void onClick(android.content.DialogInterface dialog, int which){
                    target.setText(items[which]);
                    target.setTextColor(Color.parseColor("#E8E8F0"));
                }
            })
            .show();
    }

    private static int dp(Context ctx, int px){
        return (int)(px * ctx.getResources().getDisplayMetrics().density);
    }
}
```

---

## COMPLETION CHECK
- [ ] SessionConfigScreen.java exists with static render(MainActivity, LinearLayout, int slotNumber)
- [ ] Codename picker shows all 24 known Director codenames
- [ ] Person Name picker pre-populated with all 24 names
- [ ] Director ID picker has DIRECTOR-0001 through DIRECTOR-0023 + DIRECTOR-001B
- [ ] LLM Engine picker has 6 known engines
- [ ] Git Branch picker has main/origin/main options
- [ ] Session ID field is free-text EditText
- [ ] SOP URL field is multi-line EditText for URLs or local paths
- [ ] Heartbeat/Outbox/Inbox paths auto-suggest based on Director ID
- [ ] SAVE button persists to SessionStorage and returns to Dashboard
- [ ] DELETE button clears slot and returns to Dashboard
- [ ] BACK button returns to Dashboard without saving

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-08-config.log
```

---

*SUB-PLAN-08 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
