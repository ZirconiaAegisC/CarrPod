# SUB-PLAN 10 — BLUETOOTH DIAGNOSTIC SCREEN
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 10 of 13
## Estimated Total Time: 8 minutes | GOAL: Bluetooth device info display with diagnostic data

---

## PRE-REQUISITES
- SUB-PLAN-05 completed (MainActivity with showBtDiagnostic method)
- SUB-PLAN-04 completed (AndroidManifest.xml with BLUETOOTH permissions)

---

## OBJECTIVE
Create BtDiagnosticScreen.java — a diagnostic screen showing the device's Bluetooth capabilities. Patterned after the Gemini Guide V2 Bluetooth module (Part 3.2), this screen:
1. Shows Bluetooth adapter state (ON/OFF)
2. Shows Bluetooth MAC address
3. Shows Device name (Android Bluetooth name)
4. Shows Scan mode (Discoverable/Connectable/None)
5. Shows Device hardware info (Manufacturer, Model, Android version, API level)
6. Shows "Thank you. CarrPod AEGIS active." status line
7. Release Memory button to force-stop the app

---

## PERMISSION NOTE
BLUETOOTH_CONNECT and BLUETOOTH_SCAN permissions are declared in the manifest. On Android 12+ (API 31+), the user must grant these at runtime. For Stage Super2, we show the info that is available and gracefully handle permission denial.

---

## STEP-BY-STEP COMMANDS

### STEP 10-01: Write BtDiagnosticScreen.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/BtDiagnosticScreen.java
[CMD] Write BtDiagnosticScreen.java (see FULL FILE SPEC below)
Expected time: 5s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/BtDiagnosticScreen.java && echo "BT OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/BtDiagnosticScreen.java`

---

## FULL FILE SPEC: BtDiagnosticScreen.java

```java
package com.carrpod.marmalade.screens;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Process;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.carrpod.marmalade.MainActivity;

public class BtDiagnosticScreen {

    public static void render(MainActivity activity, LinearLayout rootLayout) {
        rootLayout.removeAllViews();

        LinearLayout mainColumn = new LinearLayout(activity);
        mainColumn.setOrientation(LinearLayout.VERTICAL);
        mainColumn.setGravity(Gravity.CENTER);
        mainColumn.setBackgroundColor(Color.parseColor("#0A0A0F"));
        mainColumn.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mainColumn.setPadding(dp(activity,24),dp(activity,24),dp(activity,24),dp(activity,24));

        // Title
        TextView title = new TextView(activity);
        title.setText("Marmalade Diagnostic");
        title.setTextSize(24);
        title.setTextColor(Color.parseColor("#FF6600"));
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0,0,0,dp(activity,8));

        // CITADEL protocol line
        TextView protocol = new TextView(activity);
        protocol.setText("CITADEL Protocol V2");
        protocol.setTextSize(10);
        protocol.setTextColor(Color.parseColor("#00FF88"));
        protocol.setGravity(Gravity.CENTER);
        protocol.setPadding(0,0,0,dp(activity,24));

        // Bluetooth info
        TextView btInfo = new TextView(activity);
        btInfo.setText(getBluetoothInfo(activity));
        btInfo.setTextSize(14);
        btInfo.setTextColor(Color.parseColor("#E8E8F0"));
        btInfo.setGravity(Gravity.CENTER);
        btInfo.setPadding(0,dp(activity,8),0,dp(activity,4));
        btInfo.setLineSpacing(dp(activity,4),1.0f);

        // Device info
        TextView deviceInfo = new TextView(activity);
        deviceInfo.setText(getDeviceInfo());
        deviceInfo.setTextSize(11);
        deviceInfo.setTextColor(Color.parseColor("#8888A0"));
        deviceInfo.setGravity(Gravity.CENTER);
        deviceInfo.setPadding(0,dp(activity,4),0,dp(activity,16));

        // Permissions note
        TextView permNote = new TextView(activity);
        permNote.setText("Permissions required for full BT access:\nBLUETOOTH, BLUETOOTH_ADMIN,\nBLUETOOTH_CONNECT, BLUETOOTH_SCAN");
        permNote.setTextSize(9);
        permNote.setTextColor(Color.parseColor("#555566"));
        permNote.setGravity(Gravity.CENTER);
        permNote.setPadding(0,0,0,dp(activity,16));

        // Thank you message
        TextView thanks = new TextView(activity);
        thanks.setText("Thank you. CarrPod AEGIS active.");
        thanks.setTextSize(16);
        thanks.setTextColor(Color.parseColor("#00FF88"));
        thanks.setGravity(Gravity.CENTER);
        thanks.setPadding(0,dp(activity,8),0,dp(activity,24));

        // Back to Dashboard button
        Button backBtn = new Button(activity);
        backBtn.setText("BACK TO DASHBOARD");
        backBtn.setTextSize(14);
        backBtn.setTextColor(Color.parseColor("#FFFFFF"));
        backBtn.setBackgroundColor(Color.parseColor("#FF6600"));
        backBtn.setPadding(dp(activity,24),dp(activity,10),dp(activity,24),dp(activity,10));
        backBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){ activity.showDashboard(); }
        });

        // Release Memory button
        Button releaseBtn = new Button(activity);
        releaseBtn.setText("Release Memory");
        releaseBtn.setTextSize(14);
        releaseBtn.setTextColor(Color.parseColor("#FFFFFF"));
        releaseBtn.setBackgroundColor(Color.parseColor("#FF4466"));
        releaseBtn.setPadding(dp(activity,24),dp(activity,10),dp(activity,24),dp(activity,10));
        LinearLayout.LayoutParams rbp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rbp.setMargins(0,dp(activity,8),0,0);
        releaseBtn.setLayoutParams(rbp);
        releaseBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                activity.finishAffinity();
                Process.killProcess(Process.myPid());
                System.exit(0);
            }
        });

        mainColumn.addView(title);
        mainColumn.addView(protocol);
        mainColumn.addView(btInfo);
        mainColumn.addView(deviceInfo);
        mainColumn.addView(permNote);
        mainColumn.addView(thanks);
        mainColumn.addView(backBtn);
        mainColumn.addView(releaseBtn);

        rootLayout.addView(mainColumn);
        activity.setContentView(rootLayout);
    }

    private static String getBluetoothInfo(Context ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("Bluetooth Support:\n\n");

        try {
            BluetoothManager btManager = (BluetoothManager) ctx.getSystemService(Context.BLUETOOTH_SERVICE);
            if (btManager != null) {
                BluetoothAdapter adapter = btManager.getAdapter();
                if (adapter != null) {
                    sb.append("State: ").append(adapter.isEnabled() ? "ON" : "OFF").append("\n");
                    try {
                        String addr = adapter.getAddress();
                        sb.append("Address: ").append(addr != null ? addr : "N/A").append("\n");
                    } catch (SecurityException e) {
                        sb.append("Address: [Permission Required]\n");
                    }
                    try {
                        String name = adapter.getName();
                        sb.append("Name: ").append(name != null ? name : "N/A").append("\n");
                    } catch (SecurityException e) {
                        sb.append("Name: [Permission Required]\n");
                    }
                    try {
                        sb.append("Scan Mode: ").append(getScanModeString(adapter.getScanMode())).append("\n");
                    } catch (SecurityException e) {
                        sb.append("Scan Mode: [Permission Required]\n");
                    }
                } else {
                    sb.append("No Bluetooth adapter found.\n");
                }
            } else {
                sb.append("Bluetooth service unavailable.\n");
            }
        } catch (Exception e) {
            sb.append("Error: ").append(e.getMessage()).append("\n");
        }

        return sb.toString();
    }

    private static String getDeviceInfo() {
        return "Device: " + Build.MANUFACTURER + " " + Build.MODEL + "\n" +
               "Product: " + Build.PRODUCT + "\n" +
               "Android: " + Build.VERSION.RELEASE + " (API " + Build.VERSION.SDK_INT + ")\n" +
               "Board: " + Build.BOARD + "\n" +
               "Build: " + Build.ID;
    }

    private static String getScanModeString(int scanMode) {
        switch (scanMode) {
            case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
                return "Discoverable";
            case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
                return "Connectable (Not Discoverable)";
            case BluetoothAdapter.SCAN_MODE_NONE:
                return "Not Connectable";
            default:
                return "Unknown (" + scanMode + ")";
        }
    }

    private static int dp(Context ctx, int px){
        return (int)(px * ctx.getResources().getDisplayMetrics().density);
    }
}
```

---

## COMPLETION CHECK
- [ ] BtDiagnosticScreen.java exists with static render(MainActivity, LinearLayout)
- [ ] Shows Bluetooth adapter state (ON/OFF)
- [ ] Shows MAC address, device name, scan mode (with SecurityException handling)
- [ ] Shows device hardware info (manufacturer, model, Android version, API level, board, build ID)
- [ ] Shows CITADEL Protocol indicator
- [ ] Shows "Thank you. CarrPod AEGIS active." message
- [ ] BACK TO DASHBOARD button navigates home
- [ ] Release Memory button calls finishAffinity() + killProcess() + System.exit(0)
- [ ] Permission failure gracefully handled with "[Permission Required]" text
- [ ] CITADEL color palette applied

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-10-bluetooth.log
```

---

*SUB-PLAN-10 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
