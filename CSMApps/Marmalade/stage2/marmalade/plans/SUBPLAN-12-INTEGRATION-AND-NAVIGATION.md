# SUB-PLAN 12 — INTEGRATION AND NAVIGATION
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 12 of 13
## Estimated Total Time: 10 minutes | GOAL: NavigationManager + GitCommsHelper + ThemeConstants utilities

---

## PRE-REQUISITES
- SUB-PLANS 05-11 completed (all source files)
- SUB-PLAN-03 completed (util/ directory exists)

---

## OBJECTIVE
Create utility classes that tie the full app together:
1. **ThemeConstants.java** — Centralized color/font/size constants
2. **GitCommsHelper.java** — Stub for future GitHub COMMS network operations
3. **NavigationManager.java** — (Optional if MainActivity handles navigation directly — MainActivity already has show*() methods)

The navigation is already fully functional because MainActivity.java (SUB-PLAN-05) contains all screen switching methods, and each screen calls back to those methods via the `activity.showXxx()` pattern. This sub-plan verifies the integration and creates the remaining utility files.

---

## STEP-BY-STEP COMMANDS

### STEP 12-01: Write ThemeConstants.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/util/ThemeConstants.java
[CMD] Write ThemeConstants.java (see FULL FILE SPEC below)
Expected time: 2s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/util/ThemeConstants.java && echo "THEME OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/util/ThemeConstants.java`

### STEP 12-02: Write GitCommsHelper.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/util/GitCommsHelper.java
[CMD] Write GitCommsHelper.java (see FULL FILE SPEC below)
Expected time: 2s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/util/GitCommsHelper.java && echo "GITCOMMS OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/util/GitCommsHelper.java`

### STEP 12-03: Write WatchdogDaemon.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/util/WatchdogDaemon.java
[CMD] Write WatchdogDaemon.java (see FULL FILE SPEC below)
Expected time: 2s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/util/WatchdogDaemon.java && echo "WATCHDOG OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/util/WatchdogDaemon.java`

### STEP 12-04: List all Java source files to verify integration
[CMD] find $MARM_ROOT/src -name "*.java" | sort
Expected time: 0.5s
Verification: Should show exactly 12 Java files
Rollback: N/A

### STEP 12-05: Verify all files compile together by checking package consistency
[CMD] for f in $(find $MARM_ROOT/src -name "*.java"); do echo "$f: $(head -1 $f)"; done
Expected time: 0.5s
Verification: All show correct package declarations
Rollback: N/A

---

## FULL FILE SPEC: ThemeConstants.java

```java
package com.carrpod.marmalade.util;

import android.graphics.Color;
import android.graphics.Typeface;

public final class ThemeConstants {

    public static final String CITADEL_BG = "#0A0A0F";
    public static final String CITADEL_FG = "#E8E8F0";
    public static final String CITADEL_ORANGE = "#FF6600";
    public static final String CITADEL_GREEN = "#00FF88";
    public static final String CITADEL_YELLOW = "#FFCC00";
    public static final String CITADEL_RED = "#FF4466";
    public static final String CITADEL_GRAY = "#8888A0";
    public static final String CITADEL_DARK = "#1A1A2E";
    public static final String CITADEL_BLUE = "#4488FF";

    public static final int COLOR_BG = Color.parseColor(CITADEL_BG);
    public static final int COLOR_FG = Color.parseColor(CITADEL_FG);
    public static final int COLOR_ORANGE = Color.parseColor(CITADEL_ORANGE);
    public static final int COLOR_GREEN = Color.parseColor(CITADEL_GREEN);
    public static final int COLOR_YELLOW = Color.parseColor(CITADEL_YELLOW);
    public static final int COLOR_RED = Color.parseColor(CITADEL_RED);
    public static final int COLOR_GRAY = Color.parseColor(CITADEL_GRAY);
    public static final int COLOR_DARK = Color.parseColor(CITADEL_DARK);
    public static final int COLOR_BLUE = Color.parseColor(CITADEL_BLUE);

    public static final int COLOR_STATUS_EMPTY = COLOR_GRAY;
    public static final int COLOR_STATUS_OFFLINE = COLOR_RED;
    public static final int COLOR_STATUS_STALE = COLOR_YELLOW;
    public static final int COLOR_STATUS_ACTIVE = COLOR_GREEN;

    public static final int MAX_SESSION_SLOTS = 100;
    public static final int DASHBOARD_COLUMNS = 10;
    public static final int DEFAULT_POLL_INTERVAL_SECONDS = 5;
    public static final int DEFAULT_STALE_THRESHOLD_SECONDS = 30;

    public static final String APP_NAME = "Marmalade";
    public static final String APP_VERSION = "2.0.0-super2";
    public static final int VERSION_CODE = 5;

    private ThemeConstants() {}
}
```

## FULL FILE SPEC: GitCommsHelper.java

```java
package com.carrpod.marmalade.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GitCommsHelper {

    private static final String SETTINGS_PREFS = "marmalade_settings";
    private static final String DEFAULT_BASE_URL = "https://raw.githubusercontent.com/ZirconiaAegisC/CarrPod/main/";

    public static String getBaseUrl(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences(SETTINGS_PREFS, Context.MODE_PRIVATE);
        return prefs.getString("git_base_url", DEFAULT_BASE_URL);
    }

    public static String getCommsLogUrl(Context ctx) {
        return getBaseUrl(ctx) + "CSMGen/CSMAegis/COMMS/AEGIS-COMMS-LOG.md";
    }

    public static String getOutboxUrl(Context ctx, String directorId) {
        String id = directorId.replace("DIRECTOR-", "").toLowerCase();
        return getBaseUrl(ctx) + "CSMGen/CSMAegis/COMMS/director-" + id + "-outbox.md";
    }

    public static String getHeartbeatUrl(Context ctx, String directorId) {
        String id = directorId.replace("DIRECTOR-", "").toLowerCase();
        return getBaseUrl(ctx) + "CSMGen/CSMAegis/COMMS/HEARTBEATS/director-" + id + ".txt";
    }

    public static String fetchUrl(String urlString) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestProperty("Accept", "text/plain");
            if (conn.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line).append("\n");
                }
                reader.close();
            }
            conn.disconnect();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
        return result.toString();
    }
}
```

## FULL FILE SPEC: WatchdogDaemon.java

```java
package com.carrpod.marmalade.util;

public class WatchdogDaemon {

    private final String commandName;
    private final long expectedDurationMs;
    private final int maxRetries;
    private long startTimeMs;
    private int attemptCount;
    private String lastError;

    public WatchdogDaemon(String commandName, long expectedDurationMs, int maxRetries) {
        this.commandName = commandName;
        this.expectedDurationMs = expectedDurationMs;
        this.maxRetries = maxRetries;
        this.attemptCount = 0;
        this.lastError = null;
    }

    public void start() {
        this.startTimeMs = System.currentTimeMillis();
        this.attemptCount++;
        this.lastError = null;
    }

    public boolean checkTimeout() {
        long elapsed = System.currentTimeMillis() - startTimeMs;
        return elapsed > (expectedDurationMs * 2);
    }

    public boolean shouldRetry() {
        return attemptCount < maxRetries;
    }

    public void recordError(String error) {
        this.lastError = error;
    }

    public String getCommandName() { return commandName; }
    public long getElapsedMs() { return System.currentTimeMillis() - startTimeMs; }
    public int getAttemptCount() { return attemptCount; }
    public String getLastError() { return lastError; }

    public String getLogLine(boolean success) {
        return String.format("[%s] [%s] [%s] [%dms attempt %d/%d]",
            new java.text.SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(new java.util.Date()),
            commandName,
            success ? "OK" : "FAIL: " + (lastError != null ? lastError : "timeout"),
            getElapsedMs(),
            attemptCount,
            maxRetries
        );
    }
}
```

---

## COMPLETION CHECK
- [ ] ThemeConstants.java in util/ with 9 color constants, status colors, app metadata
- [ ] GitCommsHelper.java in util/ with getBaseUrl(), getCommsLogUrl(), getOutboxUrl(), getHeartbeatUrl(), fetchUrl()
- [ ] WatchdogDaemon.java in util/ with timeout checking and retry logic
- [ ] Total Java source files: 12 (MainActivity + 6 screens + 2 model/storage + 3 utility)
- [ ] All files have correct package declarations
- [ ] ThemeConstants MAX_SESSION_SLOTS = 100
- [ ] ThemeConstants APP_VERSION = "2.0.0-super2"

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-12-integration.log
```

---

*SUB-PLAN-12 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
