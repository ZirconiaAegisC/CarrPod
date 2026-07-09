# SUB-PLAN 01 — ENVIRONMENT SETUP
## Parent: PLAN-02-MARMALADE-STAGE-SUPER2 | Sequence: 1 of 13
## Estimated Total Time: 5 minutes | GOAL: Java 17 + core CLI tools installed

---

## PRE-REQUISITES
- Linux sandbox environment (Ubuntu/Debian)
- Root/sudo access
- Internet connectivity

---

## OBJECTIVE
Install Java 17 OpenJDK and core command-line tools required before any Android SDK work begins.

---

## STEP-BY-STEP COMMANDS

### STEP 01-01: Update package index
[CMD] apt-get update -qq
Expected time: 15s
Verification: `apt-cache policy openjdk-17-jdk-headless | grep -q Candidate && echo "OK"`
Rollback: N/A (safe operation)

### STEP 01-02: Install Java 17 headless
[CMD] apt-get install -y -qq openjdk-17-jdk-headless
Expected time: 45s
Verification: `javac --version 2>&1 | grep -q "17" && echo "JAVA 17 OK"`
Rollback: `apt-get remove -y openjdk-17-jdk-headless`

### STEP 01-03: Verify Java installation
[CMD] java -version 2>&1 | head -3
Expected time: 1s
Verification: Output shows "openjdk version 17"
Rollback: N/A

### STEP 01-04: Set JAVA_HOME permanently
[CMD] echo 'export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64' >> /etc/environment
Expected time: 0.5s
Verification: `source /etc/environment && echo $JAVA_HOME | grep -q "java-17" && echo "JAVA_HOME OK"`
Rollback: Remove the line from /etc/environment

### STEP 01-05: Verify JAVA_HOME is set
[CMD] export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
Expected time: 0.1s
Verification: `echo $JAVA_HOME`
Rollback: N/A

### STEP 01-06: Install unzip and wget (needed for SDK download)
[CMD] apt-get install -y -qq unzip wget
Expected time: 20s
Verification: `which unzip && which wget && echo "TOOLS OK"`
Rollback: N/A

### STEP 01-07: Create Android SDK directory
[CMD] mkdir -p /tmp/android-sdk
Expected time: 0.1s
Verification: `ls -d /tmp/android-sdk && echo "SDK DIR OK"`
Rollback: `rm -rf /tmp/android-sdk`

### STEP 01-08: Export ANDROID_HOME
[CMD] export ANDROID_HOME=/tmp/android-sdk
Expected time: 0.1s
Verification: `echo $ANDROID_HOME | grep -q "/tmp/android-sdk" && echo "ANDROID_HOME OK"`
Rollback: N/A

---

## COMPLETION CHECK
- [ ] Java 17 installed and `javac --version` returns 17
- [ ] JAVA_HOME set to /usr/lib/jvm/java-17-openjdk-amd64
- [ ] ANDROID_HOME set to /tmp/android-sdk
- [ ] unzip and wget available
- [ ] /tmp/android-sdk directory exists

---

## WATCHDOG DAEMON CONFIG FOR SUB-PLAN 01
```
WATCHDOG_TIMEOUT_MULTIPLIER=2
WATCHDOG_MAX_RETRIES=3
WATCHDOG_LOG=/workspace/bb8f9c5f-e866-4346-a29c-8d72daa0ad2d/sessions/agent_e5fd9349-535a-4fe2-9af4-9eb6a8120196/CSMApps/Marmalade/stage2/marmalade/lessons-learned/watchdog-01-env.log
```

---

*SUB-PLAN-01 | Director Kairos Steele, CITADEL | 2026-07-09 05:22 UTC*
