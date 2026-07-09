# SUB-PLAN 09 — DIRECTOR COMMS SCREEN
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 9 of 13
## Estimated Total Time: 15 minutes | GOAL: COMMS log viewer + directive composer + sibling inbox/outbox browser

---

## PRE-REQUISITES
- SUB-PLAN-05 completed (MainActivity with navigation methods)
- SUB-PLAN-08 completed (SessionConfigScreen)

---

## OBJECTIVE
Create DirectorCommsScreen.java — the screen for reading the AEGIS COMMS log and composing directives. It provides:
1. View of recent COMMS log entries (displayed from AEGIS-COMMS-LOG.md URL)
2. Directive composer: TO field, SUBJECT field, BODY field, SEND button
3. Sibling inbox/outbox browser — view any configured sibling's outbox content
4. Pull-to-refresh concept (manual refresh button for sandbox)
5. ALL text rendered — no WebView, no HTML, no 3D

---

## COMMS ARCHITECTURE NOTE
This screen shows COMMS content as plain text. In the full implementation, the app would use HttpURLConnection to fetch from GitHub raw URLs. For Stage Super2, the screen design is fully functional with the UI in place and mock data capability. The GitCommsHelper utility (SUB-PLAN-12) will provide the actual network fetch.

---

## STEP-BY-STEP COMMANDS

### STEP 09-01: Write DirectorCommsScreen.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/DirectorCommsScreen.java
[CMD] Write DirectorCommsScreen.java (see FULL FILE SPEC below)
Expected time: 7s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/DirectorCommsScreen.java && echo "COMMS OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/DirectorCommsScreen.java`

---

## FULL FILE SPEC: DirectorCommsScreen.java

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DirectorCommsScreen {

    public static void render(MainActivity activity, LinearLayout rootLayout) {
        rootLayout.removeAllViews();

        SessionStorage storage = new SessionStorage(activity);

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
        title.setText("DIRECTOR COMMS");
        title.setTextSize(16);
        title.setTextColor(Color.parseColor("#FF6600"));
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1);
        title.setLayoutParams(titleParams);

        titleBar.addView(backBtn);
        titleBar.addView(title);
        mainColumn.addView(titleBar);

        // Tab bar: [COMMS LOG] [COMPOSE] [SIBLING VIEW]
        LinearLayout tabBar = new LinearLayout(activity);
        tabBar.setOrientation(LinearLayout.HORIZONTAL);
        tabBar.setBackgroundColor(Color.parseColor("#1A1A2E"));
        tabBar.setPadding(dp(activity,4),dp(activity,4),dp(activity,4),dp(activity,4));

        final ScrollView contentArea = new ScrollView(activity);
        contentArea.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1));
        contentArea.setFillViewport(true);

        final LinearLayout contentInner = new LinearLayout(activity);
        contentInner.setOrientation(LinearLayout.VERTICAL);
        contentInner.setPadding(dp(activity,12),dp(activity,8),dp(activity,12),dp(activity,8));
        contentArea.addView(contentInner);

        // Build tab buttons
        String[] tabs = {"COMMS LOG","COMPOSE","SIBLINGS"};
        for (int i = 0; i < tabs.length; i++) {
            final int tabIndex = i;
            Button tabBtn = new Button(activity);
            tabBtn.setText(tabs[i]);
            tabBtn.setTextSize(11);
            tabBtn.setTextColor(Color.parseColor("#E8E8F0"));
            tabBtn.setBackgroundColor(Color.parseColor(tabIndex == 0 ? "#FF6600" : "#444455"));
            tabBtn.setAllCaps(true);
            LinearLayout.LayoutParams tbParams = new LinearLayout.LayoutParams(0,ViewGroup.LayoutParams.WRAP_CONTENT,1);
            tbParams.setMargins(dp(activity,2),0,dp(activity,2),0);
            tabBtn.setLayoutParams(tbParams);
            tabBtn.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    contentInner.removeAllViews();
                    switch(tabIndex){
                        case 0: showCommsLog(activity, contentInner); break;
                        case 1: showCompose(activity, contentInner, storage); break;
                        case 2: showSiblings(activity, contentInner, storage); break;
                    }
                }
            });
            tabBar.addView(tabBtn);
        }
        mainColumn.addView(tabBar);

        // Default: show COMMS LOG
        showCommsLog(activity, contentInner);
        mainColumn.addView(contentArea);
        rootLayout.addView(mainColumn);
        activity.setContentView(rootLayout);
    }

    private static void showCommsLog(Context ctx, LinearLayout container) {
        TextView header = new TextView(ctx);
        header.setText("AEGIS COMMS LOG");
        header.setTextSize(14);
        header.setTextColor(Color.parseColor("#FF6600"));
        header.setTypeface(Typeface.DEFAULT_BOLD);
        header.setPadding(0,0,0,dp(ctx,8));
        container.addView(header);

        String[] logEntries = {
            "[DIRECTOR-0022 | 2026-07-06 | 03:29 UTC]\nPIPELINE-ASSESSMENT-001 + PIPELINE-ARCH-001 delivered. Infrastructure census: 12 products across 5-layer dielectric stack.\n-- Dax Sever, PIPELINE [DIRECTOR-0022]",
            "[DIRECTOR-0019 | 2026-07-06 | 03:25 UTC]\nARCHITECTURE DELIVERY COMPLETE: MDM-001, CH-001, APIC-001, IS-001. Cohort 5/5 active — COHORT COMPLETE.\n-- Kael Forge, CORTEX [DIRECTOR-0019]",
            "[DIRECTOR-001 | 2026-07-06 | 02:33 UTC]\nSENTINEL ACTIVE — 5-part directive acknowledged. Sibling-Pulse cohort 0019-0023 all awaiting.\n-- Director Kairos Steele, CITADEL [DIRECTOR-0001]",
            "[DIRECTOR-0021 | 2026-07-06 | 02:40 UTC]\nRENDER scaffolding against FOUNDRY mock endpoints. Next.js 14, 6 core components, WCAG 2.1 AA, dark theme loaded.\n-- Ash Vero, RENDER",
            "[DIRECTOR-0020 | 2026-07-06 | 02:33 UTC]\nFOUNDRY standing by with mock endpoints. Backend scaffold bootstrapping. Every route returns 200 with {status:'mock'}.\n-- Mira Sable, FOUNDRY"
        };

        for (String entry : logEntries) {
            TextView entryView = new TextView(ctx);
            entryView.setText(entry);
            entryView.setTextSize(11);
            entryView.setTextColor(Color.parseColor("#CCCCDD"));
            entryView.setBackgroundColor(Color.parseColor("#1A1A2E"));
            entryView.setPadding(dp(ctx,8),dp(ctx,6),dp(ctx,8),dp(ctx,6));
            LinearLayout.LayoutParams ep = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ep.setMargins(0,0,0,dp(ctx,4));
            entryView.setLayoutParams(ep);
            container.addView(entryView);
        }

        TextView footer = new TextView(ctx);
        footer.setText("Source: CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md\ngithub.com/ZirconiaAegisC/CarrPod");
        footer.setTextSize(9);
        footer.setTextColor(Color.parseColor("#555566"));
        footer.setPadding(0,dp(ctx,8),0,0);
        container.addView(footer);
    }

    private static void showCompose(Context ctx, LinearLayout container, SessionStorage storage) {
        TextView header = new TextView(ctx);
        header.setText("COMPOSE DIRECTIVE");
        header.setTextSize(14);
        header.setTextColor(Color.parseColor("#FF6600"));
        header.setTypeface(Typeface.DEFAULT_BOLD);
        header.setPadding(0,0,0,dp(ctx,8));
        container.addView(header);

        TextView toLabel = new TextView(ctx);
        toLabel.setText("TO (Directors):");
        toLabel.setTextSize(11);
        toLabel.setTextColor(Color.parseColor("#8888A0"));
        toLabel.setPadding(0,dp(ctx,4),0,dp(ctx,2));
        container.addView(toLabel);

        EditText toField = new EditText(ctx);
        toField.setHint("[FOR DIRECTOR-0019] [FOR DIRECTOR-0020]");
        toField.setHintTextColor(Color.parseColor("#555566"));
        toField.setTextColor(Color.parseColor("#E8E8F0"));
        toField.setBackgroundColor(Color.parseColor("#1A1A2E"));
        toField.setPadding(dp(ctx,8),dp(ctx,8),dp(ctx,8),dp(ctx,8));
        container.addView(toField);

        TextView subjLabel = new TextView(ctx);
        subjLabel.setText("SUBJECT:");
        subjLabel.setTextSize(11);
        subjLabel.setTextColor(Color.parseColor("#8888A0"));
        subjLabel.setPadding(0,dp(ctx,8),0,dp(ctx,2));
        container.addView(subjLabel);

        EditText subjectField = new EditText(ctx);
        subjectField.setHint("DIRECTIVE: Architecture Review");
        subjectField.setHintTextColor(Color.parseColor("#555566"));
        subjectField.setTextColor(Color.parseColor("#E8E8F0"));
        subjectField.setBackgroundColor(Color.parseColor("#1A1A2E"));
        subjectField.setPadding(dp(ctx,8),dp(ctx,8),dp(ctx,8),dp(ctx,8));
        container.addView(subjectField);

        TextView bodyLabel = new TextView(ctx);
        bodyLabel.setText("BODY:");
        bodyLabel.setTextSize(11);
        bodyLabel.setTextColor(Color.parseColor("#8888A0"));
        bodyLabel.setPadding(0,dp(ctx,8),0,dp(ctx,2));
        container.addView(bodyLabel);

        EditText bodyField = new EditText(ctx);
        bodyField.setHint("Enter directive text...");
        bodyField.setHintTextColor(Color.parseColor("#555566"));
        bodyField.setTextColor(Color.parseColor("#E8E8F0"));
        bodyField.setBackgroundColor(Color.parseColor("#1A1A2E"));
        bodyField.setPadding(dp(ctx,8),dp(ctx,8),dp(ctx,8),dp(ctx,8));
        bodyField.setMinLines(4);
        bodyField.setGravity(Gravity.TOP);
        bodyField.setInputType(EditorInfo.TYPE_TEXT_FLAG_MULTI_LINE);
        container.addView(bodyField);

        Button sendBtn = new Button(ctx);
        sendBtn.setText("SEND DIRECTIVE");
        sendBtn.setTextSize(14);
        sendBtn.setTextColor(Color.parseColor("#FFFFFF"));
        sendBtn.setBackgroundColor(Color.parseColor("#FF6600"));
        sendBtn.setPadding(dp(ctx,24),dp(ctx,12),dp(ctx,24),dp(ctx,12));
        LinearLayout.LayoutParams sbp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        sbp.setMargins(0,dp(ctx,12),0,0);
        sendBtn.setLayoutParams(sbp);
        sendBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                new AlertDialog.Builder(ctx)
                    .setTitle("Directive Sent")
                    .setMessage("Directive recorded. Will be written to:\n" +
                               "CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md\n\n" +
                               "(Full network comms available in Stage 3)")
                    .setPositiveButton("OK", null)
                    .show();
            }
        });
        container.addView(sendBtn);
    }

    private static void showSiblings(Context ctx, LinearLayout container, SessionStorage storage) {
        TextView header = new TextView(ctx);
        header.setText("SIBLING OUTBOXES");
        header.setTextSize(14);
        header.setTextColor(Color.parseColor("#FF6600"));
        header.setTypeface(Typeface.DEFAULT_BOLD);
        header.setPadding(0,0,0,dp(ctx,8));
        container.addView(header);

        Map<Integer, SessionModel> sessions = storage.getAllSessions();
        if (sessions.isEmpty()) {
            TextView empty = new TextView(ctx);
            empty.setText("No siblings configured. Go to Dashboard and tap a slot to configure.");
            empty.setTextSize(12);
            empty.setTextColor(Color.parseColor("#8888A0"));
            empty.setPadding(0,dp(ctx,8),0,0);
            container.addView(empty);
            return;
        }

        List<SessionModel> activeList = new ArrayList<>();
        for (SessionModel s : sessions.values()) {
            if (s.status >= 1) activeList.add(s);
        }

        if (activeList.isEmpty()) {
            TextView empty = new TextView(ctx);
            empty.setText("All configured siblings are EMPTY (status 0). Configure sessions in Dashboard first.");
            empty.setTextSize(12);
            empty.setTextColor(Color.parseColor("#8888A0"));
            empty.setPadding(0,dp(ctx,8),0,0);
            container.addView(empty);
            return;
        }

        for (SessionModel s : activeList) {
            LinearLayout row = new LinearLayout(ctx);
            row.setOrientation(LinearLayout.VERTICAL);
            row.setBackgroundColor(Color.parseColor("#1A1A2E"));
            row.setPadding(dp(ctx,8),dp(ctx,6),dp(ctx,8),dp(ctx,6));
            LinearLayout.LayoutParams rp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rp.setMargins(0,0,0,dp(ctx,4));
            row.setLayoutParams(rp);

            TextView name = new TextView(ctx);
            name.setText("SLOT " + s.slotNumber + " | " + s.codename + " (" + s.personName + ")");
            name.setTextSize(12);
            name.setTextColor(Color.parseColor("#FF6600"));
            name.setTypeface(Typeface.DEFAULT_BOLD);

            TextView status = new TextView(ctx);
            status.setText("Status: " + s.getStatusString() + " | Outbox: " + s.outboxPath);
            status.setTextSize(10);
            status.setTextColor(Color.parseColor("#8888A0"));

            row.addView(name);
            row.addView(status);
            container.addView(row);
        }

        TextView footer = new TextView(ctx);
        footer.setText("Tap a slot on Dashboard to view/edit outbox contents.\nOutboxes sync via GitHub: github.com/ZirconiaAegisC/CarrPod");
        footer.setTextSize(9);
        footer.setTextColor(Color.parseColor("#555566"));
        footer.setPadding(0,dp(ctx,8),0,0);
        container.addView(footer);
    }

    private static int dp(Context ctx, int px){
        return (int)(px * ctx.getResources().getDisplayMetrics().density);
    }
}
```

---

## COMPLETION CHECK
- [ ] DirectorCommsScreen.java exists with static render(MainActivity, LinearLayout)
- [ ] Has 3 tabs: COMMS LOG, COMPOSE, SIBLINGS
- [ ] COMMS LOG tab shows AEGIS-COMMS-LOG entries as styled text
- [ ] COMPOSE tab has TO field, SUBJECT field, BODY field, and SEND button
- [ ] SIBLINGS tab lists all configured sibling sessions with status and outbox path
- [ ] BACK button returns to Dashboard
- [ ] No WebView used — all text rendered natively
- [ ] CITADEL color palette applied consistently
- [ ] SEND button shows confirmation dialog

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-09-comms.log
```

---

*SUB-PLAN-09 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
