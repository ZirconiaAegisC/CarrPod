package com.carrpod.marmalade.models;

public class Message {
    public String id;
    public String fromAgentId;
    public String fromCodename;
    public String fromName;
    public String toAgentId;
    public String attentionHeader;
    public String body;
    public String vocalMode;
    public String severity;
    public long timestamp;
    public boolean isDirective;
    public boolean isOverride;

    public Message(String id, String fromAgentId, String fromCodename, String fromName,
                   String toAgentId, String attentionHeader, String body,
                   String vocalMode, String severity, long timestamp,
                   boolean isDirective, boolean isOverride) {
        this.id = id;
        this.fromAgentId = fromAgentId;
        this.fromCodename = fromCodename;
        this.fromName = fromName;
        this.toAgentId = toAgentId;
        this.attentionHeader = attentionHeader;
        this.body = body;
        this.vocalMode = vocalMode;
        this.severity = severity;
        this.timestamp = timestamp;
        this.isDirective = isDirective;
        this.isOverride = isOverride;
    }
}
