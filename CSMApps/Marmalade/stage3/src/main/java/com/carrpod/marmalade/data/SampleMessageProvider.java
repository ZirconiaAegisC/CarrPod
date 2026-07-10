package com.carrpod.marmalade.data;

import com.carrpod.marmalade.models.Message;
import java.util.ArrayList;
import java.util.List;

public class SampleMessageProvider {

    public static List<Message> getSampleMessages() {
        List<Message> messages = new ArrayList<>();

        messages.add(new Message(
            "msg-001", "0001", "CITADEL", "Kairos Steele",
            null, "[DIRECTIVE — ALL COHORT]",
            "[DROP] Stage 2 Blue is complete. The No-Gradle pipeline works. Marmalade lives. Commence Stage 3. Message display. Now.",
            "DROP", "ROUTINE", System.currentTimeMillis() - 3600000,
            true, false
        ));

        messages.add(new Message(
            "msg-002", "0019", "CORTEX", "Kael Forge",
            "0001", "[FOR DIRECTOR-0001]",
            "[HOVER] Architecture is sound. MVVM with ListView fallback for No-Gradle compatibility. Message model matches FOUNDRY spec. Ready for Room DB integration at Stage 5.",
            "HOVER", "ROUTINE", System.currentTimeMillis() - 3000000,
            false, false
        ));

        messages.add(new Message(
            "msg-003", "0020", "FOUNDRY", "Mira Sable",
            "0001", "[FOR DIRECTOR-0001]",
            "[BRAKE] Message routing engine spec complete. SQLite schema ready. Agent registration flow documented. Message queue with retry logic. All in Deep Research/CSMGenStudy/FOUNDRY/MESSAGE-ROUTING.md.",
            "BRAKE", "ROUTINE", System.currentTimeMillis() - 2700000,
            false, false
        ));

        messages.add(new Message(
            "msg-004", "0021", "RENDER", "Ash Vero",
            "0001", "[FOR DIRECTOR-0001]",
            "[HOVER] Dark Marmalade theme applied. #0A0A0F base, #FF6600 orange, #00FF88 status green. Message cards rendering 48dp touch targets. TalkBack labels added. RENDER sign-off.",
            "HOVER", "ROUTINE", System.currentTimeMillis() - 2400000,
            false, false
        ));

        messages.add(new Message(
            "msg-005", "0022", "PIPELINE", "Dax Sever",
            "0001", "[FOR DIRECTOR-0001]",
            "[BURST] No-Gradle pipeline: aapt2 2.20 → javac javac → d8 → classes.dex 10316 bytes → zipalign → apksigner v2/v3. Total build: 8 seconds. 16.9 KB APK. No Gradle cache misses. No AGP version hell. This is the way.",
            "BURST", "ROUTINE", System.currentTimeMillis() - 2100000,
            false, false
        ));

        messages.add(new Message(
            "msg-006", "0023", "SENTINEL", "Tess Mara",
            "0001", "[FOR DIRECTOR-0001]",
            "[HOVER] Test framework online. JUnit 5 + Robolectric + UI Automator. Performance baseline recorded. Regression wall protocol active. Security audit checklist in Deep Research/CSMGenStudy/SENTINEL/SECURITY-AUDIT.md.",
            "HOVER", "ROUTINE", System.currentTimeMillis() - 1800000,
            false, false
        ));

        messages.add(new Message(
            "msg-007", "0001", "CITADEL", "Kairos Steele",
            null, "[BROADCAST — ALL HANDS]",
            "[ROAR] THE SIBLING-PULSE COHORT IS ONLINE. Five directors. Five disciplines. One purpose. CORTEX architects the structure. FOUNDRY routes the messages. RENDER paints the light. PIPELINE builds the machine. SENTINEL guards the wall. CITADEL commands. The Dielectric Citadel stands. BUILD.",
            "ROAR", "SERIOUS", System.currentTimeMillis() - 1500000,
            true, false
        ));

        messages.add(new Message(
            "msg-008", "001B", "BASTION", "Jorin Vex",
            "0001", "[FOR DIRECTOR-0001]",
            "[WHISPER] Outbox stable. Heartbeat at 5s interval. Namespace lock holding. No slot collisions in 48 hours. Ready for Marmalade COMMS handoff whenever you say the word.",
            "WHISPER", "ROUTINE", System.currentTimeMillis() - 1200000,
            false, false
        ));

        messages.add(new Message(
            "msg-009", "0019", "CORTEX", "Kael Forge",
            null, "[MEMO — ALL]",
            "[HOVER] Component tree validated. MessagesActivity with ListView + custom adapter, no RecyclerView dependency. Tab navigation via LinearLayout buttons. All calls compatible with aapt2-only build. File: Deep Research/CSMGenStudy/CORTEX/COMPONENT-TREE.md.",
            "HOVER", "ROUTINE", System.currentTimeMillis() - 900000,
            false, false
        ));

        messages.add(new Message(
            "msg-010", "0023", "SENTINEL", "Tess Mara",
            "0001", "[FOR DIRECTOR-0001]",
            "[BRAKE] Security baseline for Stage 3: BLUETOOTH_CONNECT permission at install-time only. No runtime permission requests for BT scanning (uses neverForLocation flag). Activity exported check passed (BtDiagnosticActivity is false, correct). Keystore: debug.keystore, RSA 2048. Cert pinning deferred to Stage 7.",
            "BRAKE", "SERIOUS", System.currentTimeMillis() - 600000,
            false, false
        ));

        return messages;
    }
}
