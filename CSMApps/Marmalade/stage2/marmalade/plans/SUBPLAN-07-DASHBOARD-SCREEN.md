# SUB-PLAN 07 — DASHBOARD SCREEN
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 7 of 13
## Estimated Total Time: 15 minutes | GOAL: Scrollable 100-slot session grid with status colors + bottom nav bar

---

## PRE-REQUISITES
- SUB-PLAN-05 completed (MainActivity.java)
- SUB-PLAN-06 completed (SessionModel.java + SessionStorage.java)

---

## OBJECTIVE
Create DashboardScreen.java — the primary screen after splash. It displays:
1. A scrollable grid of 100 session slots (10 columns x 10 rows)
2. Each slot shows: slot number + codename (3 chars) with status color background
3. Bottom navigation bar: [Session Config] [Comms] [Settings] [Bluetooth] [Release]
4. Active count indicator at top
5. Tapping a slot navigates to SessionConfigScreen for that slot
6. Auto-refreshes status colors from storage every time screen is shown

---

## LAYOUT SPECIFICATION

### Top Bar:
```
[ACTIVE: 5/100] [CONFIGURED: 23/100] [CITADEL v2.0.0]
```
Background: CITADEL-DARK (#1A1A2E), Text: CITADEL-FG (#E8E8F0), size 12sp

### Session Grid:
- ScrollView wrapping a GridLayout or nested LinearLayouts
- 10 columns, 10 rows (100 total)
- Each cell: 32dp x 32dp, rounded square, status color fill
- Text inside: slot number (small font, 9sp)
- Tapping a cell → showSessionConfig(slotNumber)

### Bottom Navigation Bar:
- 5 buttons in a horizontal row at bottom of screen
- [SESSIONS] [COMMS] [SETTINGS] [BLUETOOTH] [RELEASE]
- Background: CITADEL-DARK (#1A1A2E)
- Button colors: CITADEL-ORANGE (#FF6600) with CITADEL-FG text
- On tap: navigate to respective screen

---

## STEP-BY-STEP COMMANDS

### STEP 07-01: Write DashboardScreen.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/DashboardScreen.java
[CMD] Write DashboardScreen.java (see FULL FILE SPEC below)
Expected time: 7s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/DashboardScreen.java && echo "DASHBOARD OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/DashboardScreen.java`

### STEP 07-02: Verify DashboardScreen references correct classes
[CMD] grep -c "import com.carrpod.marmalade" $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/DashboardScreen.java && echo "IMPORTS OK"
Expected time: 0.1s
Verification: Import count > 0
Rollback: N/A

---

## FULL FILE SPEC: DashboardScreen.java

```java
package com.carrpod.marmalade.screens;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.carrpod.marmalade.MainActivity;
import com.carrpod.marmalade.models.SessionModel;
import com.carrpod.marmalade.storage.SessionStorage;
import java.util.Map;

public class DashboardScreen {

    public static void render(MainActivity activity, LinearLayout rootLayout) {
        rootLayout.removeAllViews();

        SessionStorage storage = new SessionStorage(activity);
        Map<Integer, SessionModel> sessions = storage.getAllSessions();

        LinearLayout mainColumn = new LinearLayout(activity);
        mainColumn.setOrientation(LinearLayout.VERTICAL);
        mainColumn.setBackgroundColor(Color.parseColor("#0A0A0F"));
        mainColumn.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT));

        // ── TOP STATUS BAR ─────────────────────────────────
        LinearLayout topBar = new LinearLayout(activity);
        topBar.setOrientation(LinearLayout.HORIZONTAL);
        topBar.setBackgroundColor(Color.parseColor("#1A1A2E"));
        topBar.setPadding(dp(activity, 12), dp(activity, 8), dp(activity, 12), dp(activity, 8));
        topBar.setGravity(Gravity.CENTER_VERTICAL);

        int activeCount = storage.getActiveCount();
        int configuredCount = storage.getConfiguredCount();

        TextView statusText = new TextView(activity);
        statusText.setText("ACTIVE: " + activeCount + "/100 | CONFIGURED: " + configuredCount + "/100");
        statusText.setTextSize(12);
        statusText.setTextColor(Color.parseColor("#E8E8F0"));
        statusText.setTypeface(Typeface.DEFAULT_BOLD);

        TextView titleText = new TextView(activity);
        titleText.setText("SESSION DASHBOARD");
        titleText.setTextSize(14);
        titleText.setTextColor(Color.parseColor("#FF6600"));
        titleText.setTypeface(Typeface.DEFAULT_BOLD);
        titleText.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        titleText.setLayoutParams(titleParams);

        topBar.addView(statusText);
        topBar.addView(titleText);
        mainColumn.addView(topBar);

        // ── SCROLLABLE SESSION GRID ────────────────────────
        ScrollView scrollView = new ScrollView(activity);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 0, 1));
        scrollView.setFillViewport(false);

        LinearLayout gridContainer = new LinearLayout(activity);
        gridContainer.setOrientation(LinearLayout.VERTICAL);
        gridContainer.setPadding(dp(activity, 8), dp(activity, 8), dp(activity, 8), dp(activity, 8));

        int cols = 10;
        int rows = 10;
        int cellSize = dp(activity, 32);
        LinearLayout currentRow = null;

        for (int r = 0; r < rows; r++) {
            currentRow = new LinearLayout(activity);
            currentRow.setOrientation(LinearLayout.HORIZONTAL);
            currentRow.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            rowParams.setMargins(0, 0, 0, dp(activity, 2));
            currentRow.setLayoutParams(rowParams);

            for (int c = 0; c < cols; c++) {
                final int slotNumber = r * cols + c + 1;
                SessionModel session = sessions.get(slotNumber);
                if (session == null) session = new SessionModel(slotNumber);

                FrameLayout cell = new FrameLayout(activity);
                int cellBg = session.getStatusColor();
                cell.setBackgroundColor(cellBg);
                LinearLayout.LayoutParams cellParams = new LinearLayout.LayoutParams(cellSize, cellSize);
                cellParams.setMargins(dp(activity, 1), 0, dp(activity, 1), 0);
                cell.setLayoutParams(cellParams);

                TextView cellText = new TextView(activity);
                cellText.setText(String.valueOf(slotNumber));
                cellText.setTextSize(9);
                cellText.setTextColor(cellBg == 0xFF8888A0 ? Color.parseColor("#555566") : Color.parseColor("#0A0A0F"));
                cellText.setGravity(Gravity.CENTER);
                cellText.setLayoutParams(new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                cell.addView(cellText);

                final int finalSlot = slotNumber;
                cell.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.showSessionConfig(finalSlot);
                    }
                });

                currentRow.addView(cell);
            }
            gridContainer.addView(currentRow);
        }

        scrollView.addView(gridContainer);
        mainColumn.addView(scrollView);

        // ── BOTTOM NAVIGATION BAR ──────────────────────────
        LinearLayout navBar = new LinearLayout(activity);
        navBar.setOrientation(LinearLayout.HORIZONTAL);
        navBar.setBackgroundColor(Color.parseColor("#1A1A2E"));
        navBar.setPadding(dp(activity, 4), dp(activity, 6), dp(activity, 4), dp(activity, 6));
        navBar.setGravity(Gravity.CENTER);

        String[] navLabels = {"SESSIONS", "COMMS", "SETTINGS", "BT", "RELEASE"};
        View.OnClickListener[] navActions = new View.OnClickListener[]{
            new View.OnClickListener() { public void onClick(View v) { activity.showDashboard(); } },
            new View.OnClickListener() { public void onClick(View v) { activity.showDirectorComms(); } },
            new View.OnClickListener() { public void onClick(View v) { activity.showSettings(); } },
            new View.OnClickListener() { public void onClick(View v) { activity.showBtDiagnostic(); } },
            new View.OnClickListener() { public void onClick(View v) {
                activity.finishAffinity();
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);
            }}
        };

        for (int i = 0; i < navLabels.length; i++) {
            Button btn = new Button(activity);
            btn.setText(navLabels[i]);
            btn.setTextSize(10);
            btn.setTextColor(Color.parseColor("#E8E8F0"));
            btn.setBackgroundColor(Color.parseColor("#FF6600"));
            btn.setPadding(dp(activity, 8), dp(activity, 4), dp(activity, 8), dp(activity, 4));
            btn.setAllCaps(true);
            btn.setOnClickListener(navActions[i]);
            LinearLayout.LayoutParams btnParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
            btnParams.setMargins(dp(activity, 2), 0, dp(activity, 2), 0);
            btn.setLayoutParams(btnParams);
            navBar.addView(btn);
        }

        mainColumn.addView(navBar);
        rootLayout.addView(mainColumn);
        activity.setContentView(rootLayout);
    }

    private static int dp(Context ctx, int px) {
        return (int)(px * ctx.getResources().getDisplayMetrics().density);
    }
}
```

---

## COMPLETION CHECK
- [ ] DashboardScreen.java exists in screens/ package
- [ ] Has static render(MainActivity, LinearLayout) method
- [ ] Top bar shows active count and configured count
- [ ] ScrollView contains 100 session cells (10x10 grid)
- [ ] Each cell colored by session status: EMPTY=gray, OFFLINE=red, STALE=yellow, ACTIVE=green
- [ ] Each cell shows slot number
- [ ] Tapping cell calls activity.showSessionConfig(slotNumber)
- [ ] Bottom nav bar has 5 buttons: SESSIONS, COMMS, SETTINGS, BT, RELEASE
- [ ] RELEASE button calls finishAffinity() + killProcess() + System.exit(0)
- [ ] Uses dp() helper for density-independent pixels

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-07-dashboard.log
```

---

*SUB-PLAN-07 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
