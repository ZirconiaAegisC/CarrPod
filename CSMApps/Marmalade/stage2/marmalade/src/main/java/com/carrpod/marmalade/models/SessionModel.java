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
            case 0: return android.graphics.Color.parseColor("#8888A0");
            case 1: return android.graphics.Color.parseColor("#FF4466");
            case 2: return android.graphics.Color.parseColor("#FFCC00");
            case 3: return android.graphics.Color.parseColor("#00FF88");
            default: return android.graphics.Color.parseColor("#8888A0");
        }
    }

    public String getSlotLabel() {
        return "SLOT " + slotNumber + (codename.isEmpty() ? "" : " | " + codename);
    }
}
