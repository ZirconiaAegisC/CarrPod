package com.carrpod.marmalade.models

import java.util.UUID

data class Agent(
    val id: String = UUID.randomUUID().toString(),
    val directorId: String,
    val codename: String,
    val name: String,
    val role: String,
    val status: AgentStatus = AgentStatus.OFFLINE,
    val lastHeartbeat: Long = System.currentTimeMillis(),
    val sessionId: String = "",
    val pollInterval: Int = 30,
    val protocolVersion: String = "V5"
)

enum class AgentStatus { ONLINE, OFFLINE, AWAITING, STALE }

data class Message(
    val id: String = UUID.randomUUID().toString(),
    val fromAgentId: String,
    val toAgentId: String? = null,
    val attentionHeader: String? = null,
    val subject: String,
    val body: String,
    val vocalMode: VocalMode = VocalMode.HOVER,
    val severity: Severity = Severity.ROUTINE,
    val timestamp: Long = System.currentTimeMillis(),
    val isDirective: Boolean = false,
    val isOverride: Boolean = false,
    val fileAttachment: FileAttachment? = null,
    var delivered: Boolean = false
)

enum class VocalMode { BURST, BRAKE, HOVER, WHISPER, ROAR, DROP }
enum class Severity { ROUTINE, SERIOUS, CRITICAL, CATASTROPHIC, GRIEF }

data class FileAttachment(
    val id: String = UUID.randomUUID().toString(),
    val fileName: String,
    val mimeType: String,
    val sizeBytes: Long,
    val checksum: String,
    val localPath: String
)

data class Heartbeat(
    val agentId: String,
    val timestamp: Long = System.currentTimeMillis(),
    val status: AgentStatus = AgentStatus.ONLINE,
    val pollCycle: Int = 0,
    val censusOnline: Int = 0,
    val censusAwaiting: Int = 0,
    val cohortOnline: Int = 0
)

data class Session(
    val id: String = UUID.randomUUID().toString(),
    val agentId: String,
    val url: String = "https://app.kilo.ai/cloud",
    val status: SessionStatus = SessionStatus.LOADING,
    val webViewIndex: Int = 0,
    val createdAt: Long = System.currentTimeMillis()
)

enum class SessionStatus { LOADING, ACTIVE, ERROR, CLOSED }

data class Directive(
    val id: String = UUID.randomUUID().toString(),
    val fromAgentId: String,
    val toAgentId: String,
    val command: String,
    val params: Map<String, String> = emptyMap(),
    val timestamp: Long = System.currentTimeMillis(),
    var executed: Boolean = false,
    var result: String = ""
)
