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
            "[DROP] Stage 3b fixes applied. Back button on BT screen. Runtime permission request. Tab bar docked. Header brightness controls. No flashing. Build complete.",
            "DROP", "ROUTINE", System.currentTimeMillis() - 3600000,
            true, false
        ));

        messages.add(new Message(
            "msg-002", "0019", "CORTEX", "Kael Forge",
            "0001", "[FOR DIRECTOR-0001]",
            "[HOVER] Architecture verified. Window insets used for edge-to-edge layout. No button overlap. Solid overlay with user-controlled brightness. Clean separation between WebView and UI layer.",
            "HOVER", "ROUTINE", System.currentTimeMillis() - 3000000,
            false, false
        ));

        messages.add(new Message(
            "msg-003", "0020", "FOUNDRY", "Mira Sable",
            "0001", "[FOR DIRECTOR-0001]",
            "[BRAKE] Message routing spec unchanged. ListView position verified — no scroll-jank from tab bar overlap. Weight-based layout correctly allocates remaining space to message list.",
            "BRAKE", "ROUTINE", System.currentTimeMillis() - 2700000,
            false, false
        ));

        messages.add(new Message(
            "msg-004", "0021", "RENDER", "Ash Vero",
            "0001", "[FOR DIRECTOR-0001]",
            "[HOVER] Dark Marmalade theme stable at all opacity levels. +/- brightness toggles from 40 to 255 alpha in 30-point steps. Toast confirms current level (LOW/MED/HIGH/FULL). Text remains readable at minimum.",
            "HOVER", "ROUTINE", System.currentTimeMillis() - 2400000,
            false, false
        ));

        messages.add(new Message(
            "msg-005", "0022", "PIPELINE", "Dax Sever",
            "0001", "[FOR DIRECTOR-0001]",
            "[BURST] No-Gradle pipeline: Stage 3b builds in 7s. 8 source files, 18 class files, 22KB APK. aapt2 2.20, d8, apksigner v3. All fixes contained. No regressions.",
            "BURST", "ROUTINE", System.currentTimeMillis() - 2100000,
            false, false
        ));

        messages.add(new Message(
            "msg-006", "0023", "SENTINEL", "Tess Mara",
            "0001", "[FOR DIRECTOR-0001]",
            "[HOVER] Permission flow tested: BLUETOOTH_CONNECT requested via ActivityCompat pattern. Denial handled gracefully with degraded info. Grant triggers info refresh. onRequestPermissionsResult wired correctly.",
            "HOVER", "ROUTINE", System.currentTimeMillis() - 1800000,
            false, false
        ));

        messages.add(new Message(
            "msg-007", "0001", "CITADEL", "Kairos Steele",
            null, "[BROADCAST — ALL HANDS]",
            "[ROAR] FOUR FIXES DELIVERED. Back button with finish(). Runtime BT permission via requestPermissions. Tab bar docked with weight=1 list above. Edge-to-edge layout with decorFitsSystemWindows=false. Header opacity user-controlled via +/-. The Marmalade sharpens.",
            "ROAR", "SERIOUS", System.currentTimeMillis() - 1500000,
            true, false
        ));

        messages.add(new Message(
            "msg-008", "001B", "BASTION", "Jorin Vex",
            "0001", "[FOR DIRECTOR-0001]",
            "[WHISPER] COMMS outbox stable. Heartbeat interval holding at 5s. No slot collisions. Ready for Stage 4 agent roster when CITADEL gives the word.",
            "WHISPER", "ROUTINE", System.currentTimeMillis() - 1200000,
            false, false
        ));

        messages.add(new Message(
            "msg-009", "0019", "CORTEX", "Kael Forge",
            null, "[MEMO — ALL]",
            "[HOVER] Component tree updated for Stage 3b. BtDiagnosticActivity now has back button + permission request + ScrollView containment. MessagesActivity uses LinearLayout weights for proper sizing. MainActivity uses system window insets for edge-to-edge.",
            "HOVER", "ROUTINE", System.currentTimeMillis() - 900000,
            false, false
        ));

        messages.add(new Message(
            "msg-010", "0023", "SENTINEL", "Tess Mara",
            "0001", "[FOR DIRECTOR-0001]",
            "[BRAKE] Regression check: All 3 activities launch without crash. Back navigation works (BT → Main via finish(), Messages → Main via finish()). Overlay brightness persists across activity transitions. No ANR on BT permission dialog. Sign off.",
            "BRAKE", "SERIOUS", System.currentTimeMillis() - 600000,
            false, false
        ));

        return messages;
    }
}
