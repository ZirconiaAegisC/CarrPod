# SUB-PLAN 06 — SESSION MODEL AND STORAGE
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 6 of 13
## Estimated Total Time: 8 minutes | GOAL: SessionModel.java + SessionStorage.java for 100-slot persistence

---

## PRE-REQUISITES
- SUB-PLAN-03 completed (directory structure)
- SUB-PLAN-05 completed (MainActivity.java)

---

## OBJECTIVE
Create the data layer:
1. `SessionModel.java` — A simple POJO representing one session slot with all fields needed for the Director's 100-sibling control
2. `SessionStorage.java` — SharedPreferences-based persistence for 100 session slots. No Room DB dependency — keeps APK small and builds fast.

---

## DATA MODEL SPECIFICATION

### SessionModel Fields:
| Field | Type | Description |
|-------|------|-------------|
| slotNumber | int | 1-100 slot identifier |
| sessionId | String | Agent session UUID (e.g., "agent_7d77648c...") |
| directorId | String | "DIRECTOR-0001" through "DIRECTOR-0023" |
| codename | String | CITADEL, CORTEX, FOUNDRY, RENDER, PIPELINE, SENTINEL, etc. |
| personName | String | Human name (Kairos Steele, Kael Forge, etc.) |
| sopUrl | String | URL or local path to SOP/personality file |
| llmEngine | String | "deepseek-v4-pro", "gemini-2.5-pro", etc. |
| gitBranch | String | "main", "origin/main" |
| heartbeatPath | String | COMMS/HEARTBEATS/director-XXXX.txt |
| outboxPath | String | COMMS/director-XXXX-outbox.md |
| inboxPath | String | COMMS/director-XXXX-inbox.md |
| status | int | 0=EMPTY, 1=OFFLINE, 2=STALE, 3=ACTIVE |
| lastHeartbeatTs | long | Unix timestamp (seconds) of last heartbeat |
| createdAt | long | Unix timestamp when slot was first configured |
| product | String | Product line (e.g., "Aegis-C Composite Shield") |

### Storage Strategy:
- Each of the 100 slots stored as a set of SharedPreferences strings keyed by slot number
- Keys: `session_{N}_sessionId`, `session_{N}_directorId`, etc.
- SessionStorage provides CRUD: getSession(int slot), save(SessionModel), delete(int slot), getAll()
- Boot-time load: all 100 slots read once from SharedPreferences into in-memory Map<Integer, SessionModel>

---

## STEP-BY-STEP COMMANDS

### STEP 06-01: Write SessionModel.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/models/SessionModel.java
[CMD] Write SessionModel.java (see FULL FILE SPEC below)
Expected time: 2s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/models/SessionModel.java && echo "MODEL OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/models/SessionModel.java`

### STEP 06-02: Write SessionStorage.java
Write file: $MARM_ROOT/src/main/java/com/carrpod/marmalade/storage/SessionStorage.java
[CMD] Write SessionStorage.java (see FULL FILE SPEC below)
Expected time: 3s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/storage/SessionStorage.java && echo "STORAGE OK"`
Rollback: `rm $MARM_ROOT/src/main/java/com/carrpod/marmalade/storage/SessionStorage.java`

### STEP 06-03: Verify both files exist and have correct packages
[CMD] grep -c "package" $MARM_ROOT/src/main/java/com/carrpod/marmalade/models/SessionModel.java $MARM_ROOT/src/main/java/com/carrpod/marmalade/storage/SessionStorage.java
Expected time: 0.1s
Verification: Output shows package declarations present
Rollback: N/A

---

## FULL FILE SPEC: SessionModel.java

```java
package com.carrpod.marmalade.models;

public class SessionModel {
    public int slotNumber;
    public String sessionId;
    public String directorId;
    public String codename;
    public String personName;
    public String sopUrl;
    public String llmEngine;
    public String gitBranch;
    public String heartbeatPath;
    public String outboxPath;
    public String inboxPath;
    public int status;
    public long lastHeartbeatTs;
    public long createdAt;
    public String product;

    public SessionModel() {
        this.slotNumber = 0;
        this.sessionId = "";
        this.directorId = "";
        this.codename = "";
        this.personName = "";
        this.sopUrl = "";
        this.llmEngine = "";
        this.gitBranch = "main";
        this.heartbeatPath = "";
        this.outboxPath = "";
        this.inboxPath = "";
        this.status = 0;
        this.lastHeartbeatTs = 0;
        this.createdAt = System.currentTimeMillis() / 1000;
        this.product = "";
    }

    public SessionModel(int slotNumber) {
        this();
        this.slotNumber = slotNumber;
    }

    public String getStatusString() {
        switch (status) {
            case 0: return "EMPTY";
            case 1: return "OFFLINE";
            case 2: return "STALE";
            case 3: return "ACTIVE";
            default: return "UNKNOWN";
        }
    }

    public int getStatusColor() {
        switch (status) {
            case 0: return 0xFF8888A0;
            case 1: return 0xFFFF4466;
            case 2: return 0xFFFFCC00;
            case 3: return 0xFF00FF88;
            default: return 0xFF8888A0;
        }
    }

    public String getSlotLabel() {
        return "SLOT " + slotNumber + (codename.isEmpty() ? "" : " | " + codename);
    }
}
```

## FULL FILE SPEC: SessionStorage.java

```java
package com.carrpod.marmalade.storage;

import android.content.Context;
import android.content.SharedPreferences;
import com.carrpod.marmalade.models.SessionModel;
import java.util.HashMap;
import java.util.Map;

public class SessionStorage {

    private static final String PREFS_NAME = "marmalade_sessions";
    private static final String PREFIX = "session_%d_";
    private static final int MAX_SLOTS = 100;
    private final SharedPreferences prefs;
    private final Map<Integer, SessionModel> cache;

    public SessionStorage(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        cache = new HashMap<>();
        loadAll();
    }

    private String key(int slot, String field) {
        return String.format(PREFIX + field, slot);
    }

    private void loadAll() {
        cache.clear();
        for (int i = 1; i <= MAX_SLOTS; i++) {
            SessionModel session = new SessionModel(i);
            session.sessionId = prefs.getString(key(i, "sessionId"), "");
            session.directorId = prefs.getString(key(i, "directorId"), "");
            session.codename = prefs.getString(key(i, "codename"), "");
            session.personName = prefs.getString(key(i, "personName"), "");
            session.sopUrl = prefs.getString(key(i, "sopUrl"), "");
            session.llmEngine = prefs.getString(key(i, "llmEngine"), "");
            session.gitBranch = prefs.getString(key(i, "gitBranch"), "main");
            session.heartbeatPath = prefs.getString(key(i, "heartbeatPath"), "");
            session.outboxPath = prefs.getString(key(i, "outboxPath"), "");
            session.inboxPath = prefs.getString(key(i, "inboxPath"), "");
            session.status = prefs.getInt(key(i, "status"), 0);
            session.lastHeartbeatTs = prefs.getLong(key(i, "lastHeartbeatTs"), 0);
            session.createdAt = prefs.getLong(key(i, "createdAt"), 0);
            session.product = prefs.getString(key(i, "product"), "");
            if (!session.sessionId.isEmpty()) {
                cache.put(i, session);
            }
        }
    }

    public SessionModel getSession(int slotNumber) {
        SessionModel cached = cache.get(slotNumber);
        if (cached != null) return cached;
        return new SessionModel(slotNumber);
    }

    public Map<Integer, SessionModel> getAllSessions() {
        return new HashMap<>(cache);
    }

    public void saveSession(SessionModel session) {
        SharedPreferences.Editor editor = prefs.edit();
        int s = session.slotNumber;
        editor.putString(key(s, "sessionId"), session.sessionId);
        editor.putString(key(s, "directorId"), session.directorId);
        editor.putString(key(s, "codename"), session.codename);
        editor.putString(key(s, "personName"), session.personName);
        editor.putString(key(s, "sopUrl"), session.sopUrl);
        editor.putString(key(s, "llmEngine"), session.llmEngine);
        editor.putString(key(s, "gitBranch"), session.gitBranch);
        editor.putString(key(s, "heartbeatPath"), session.heartbeatPath);
        editor.putString(key(s, "outboxPath"), session.outboxPath);
        editor.putString(key(s, "inboxPath"), session.inboxPath);
        editor.putInt(key(s, "status"), session.status);
        editor.putLong(key(s, "lastHeartbeatTs"), session.lastHeartbeatTs);
        editor.putLong(key(s, "createdAt"), session.createdAt);
        editor.putString(key(s, "product"), session.product);
        editor.apply();
        cache.put(s, session);
    }

    public void updateStatus(int slotNumber, int status, long heartbeatTs) {
        SessionModel session = getSession(slotNumber);
        session.slotNumber = slotNumber;
        session.status = status;
        session.lastHeartbeatTs = heartbeatTs;
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(key(slotNumber, "status"), status);
        editor.putLong(key(slotNumber, "lastHeartbeatTs"), heartbeatTs);
        editor.apply();
        cache.put(slotNumber, session);
    }

    public void deleteSession(int slotNumber) {
        SharedPreferences.Editor editor = prefs.edit();
        int s = slotNumber;
        editor.remove(key(s, "sessionId"));
        editor.remove(key(s, "directorId"));
        editor.remove(key(s, "codename"));
        editor.remove(key(s, "personName"));
        editor.remove(key(s, "sopUrl"));
        editor.remove(key(s, "llmEngine"));
        editor.remove(key(s, "gitBranch"));
        editor.remove(key(s, "heartbeatPath"));
        editor.remove(key(s, "outboxPath"));
        editor.remove(key(s, "inboxPath"));
        editor.remove(key(s, "status"));
        editor.remove(key(s, "lastHeartbeatTs"));
        editor.remove(key(s, "createdAt"));
        editor.remove(key(s, "product"));
        editor.apply();
        cache.remove(slotNumber);
    }

    public int getActiveCount() {
        int count = 0;
        for (SessionModel s : cache.values()) {
            if (s.status == 3) count++;
        }
        return count;
    }

    public int getConfiguredCount() {
        return cache.size();
    }
}
```

---

## COMPLETION CHECK
- [ ] SessionModel.java exists in models/ package
- [ ] SessionStorage.java exists in storage/ package
- [ ] SessionModel has all 14 fields (slotNumber through product)
- [ ] SessionModel has getStatusString() returning EMPTY/OFFLINE/STALE/ACTIVE
- [ ] SessionModel has getStatusColor() returning ARGB values matching CITADEL palette
- [ ] SessionStorage uses SharedPreferences (not Room/SQLite)
- [ ] SessionStorage supports 100 slots (1-100)
- [ ] SessionStorage has CRUD methods: getSession(), saveSession(), deleteSession(), getAllSessions()
- [ ] SessionStorage has updateStatus() for heartbeat tracking
- [ ] SessionStorage loads all sessions into memory cache on construction
- [ ] No database dependencies (no Room, no SQLite imports)

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-06-model.log
```

---

*SUB-PLAN-06 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
