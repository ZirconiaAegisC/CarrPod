# SUB-PLAN 03 — PROJECT STRUCTURE
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 3 of 13
## Estimated Total Time: 3 minutes | GOAL: Full directory scaffolding for Marmalade Stage Super2

---

## PRE-REQUISITES
- SUB-PLAN-01 and SUB-PLAN-02 completed
- ANDROID_HOME, BUILD_TOOLS, ANDROID_JAR variables set

---

## OBJECTIVE
Create the complete directory tree for Marmalade Stage Super2. All source files will be Java (not Kotlin). No Gradle files will be created.

---

## STEP-BY-STEP COMMANDS

### STEP 03-01: Define project root variable
[CMD] export MARM_ROOT="/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_e5fd9349-535a-4fe2-9af4-9eb6a8120196/CSMApps/Marmalade/stage2/marmalade"
Expected time: 0.1s
Verification: `echo $MARM_ROOT | grep -q "stage2/marmalade" && echo "ROOT SET"`
Rollback: N/A

### STEP 03-02: Create top-level directories
[CMD] mkdir -p $MARM_ROOT/{src/main/java/com/carrpod/marmalade/{models,storage,screens,util},src/main/res/{values,mipmap-anydpi-v26},gen,obj,out,plans,lessons-learned}
Expected time: 0.1s
Verification: `ls $MARM_ROOT/src/main/java/com/carrpod/marmalade/models && echo "DIRS OK"`
Rollback: `rm -rf $MARM_ROOT`

### STEP 03-03: Verify directory structure
[CMD] find $MARM_ROOT -type d | sort
Expected time: 0.2s
Verification: Output shows all expected directories
Rollback: N/A

### STEP 03-04: Create placeholder .gitkeep in gen/ and obj/
[CMD] touch $MARM_ROOT/gen/.gitkeep
[CMD] touch $MARM_ROOT/obj/.gitkeep
Expected time: 0.1s
Verification: `ls $MARM_ROOT/gen/.gitkeep && ls $MARM_ROOT/obj/.gitkeep && echo "GITKEEP OK"`
Rollback: `rm $MARM_ROOT/gen/.gitkeep $MARM_ROOT/obj/.gitkeep`

### STEP 03-05: Create placeholder for root AndroidManifest path check
[CMD] ls -R $MARM_ROOT/src/
Expected time: 0.1s
Verification: Output shows the complete src/ tree
Rollback: N/A

---

## COMPLETION CHECK
- [ ] $MARM_ROOT/src/main/java/com/carrpod/marmalade/models/ exists
- [ ] $MARM_ROOT/src/main/java/com/carrpod/marmalade/storage/ exists
- [ ] $MARM_ROOT/src/main/java/com/carrpod/marmalade/screens/ exists
- [ ] $MARM_ROOT/src/main/java/com/carrpod/marmalade/util/ exists
- [ ] $MARM_ROOT/src/main/res/values/ exists
- [ ] $MARM_ROOT/src/main/res/mipmap-anydpi-v26/ exists
- [ ] $MARM_ROOT/gen/ exists
- [ ] $MARM_ROOT/obj/ exists
- [ ] $MARM_ROOT/out/ exists
- [ ] $MARM_ROOT/plans/ exists
- [ ] $MARM_ROOT/lessons-learned/ exists
- [ ] No .gradle/ directory exists
- [ ] No build.gradle.kts exists

---

## WATCHDOG DAEMON CONFIG
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=$MARM_ROOT/lessons-learned/watchdog-03-structure.log
```

---

*SUB-PLAN-03 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
