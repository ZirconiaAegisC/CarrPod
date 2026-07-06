package com.carrpod.marmalade.storage

import androidx.room.*
import com.carrpod.marmalade.models.*
import kotlinx.coroutines.flow.Flow

@Dao
interface AgentDao {
    @Query("SELECT * FROM agent ORDER BY lastHeartbeat DESC")
    fun getAllAgents(): Flow<List<Agent>>

    @Query("SELECT * FROM agent WHERE status = 'ONLINE' ORDER BY lastHeartbeat DESC")
    fun getOnlineAgents(): Flow<List<Agent>>

    @Query("SELECT * FROM agent WHERE id = :agentId")
    suspend fun getAgent(agentId: String): Agent?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAgent(agent: Agent)

    @Query("UPDATE agent SET status = :status, lastHeartbeat = :timestamp WHERE id = :agentId")
    suspend fun updateStatus(agentId: String, status: AgentStatus, timestamp: Long)

    @Query("SELECT COUNT(*) FROM agent WHERE status = 'ONLINE'")
    suspend fun getOnlineCount(): Int
}

@Dao
interface MessageDao {
    @Query("SELECT * FROM message ORDER BY timestamp DESC LIMIT 200")
    fun getAllMessages(): Flow<List<Message>>

    @Query("SELECT * FROM message WHERE toAgentId = :agentId OR toAgentId IS NULL ORDER BY timestamp DESC")
    fun getMessagesForAgent(agentId: String): Flow<List<Message>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: Message)

    @Query("UPDATE message SET delivered = 1 WHERE id = :messageId")
    suspend fun markDelivered(messageId: String)

    @Query("DELETE FROM message WHERE timestamp < :before")
    suspend fun pruneOldMessages(before: Long)
}

@Dao
interface DirectiveDao {
    @Query("SELECT * FROM directive ORDER BY timestamp DESC")
    fun getAllDirectives(): Flow<List<Directive>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirective(directive: Directive)

    @Query("UPDATE directive SET executed = 1, result = :result WHERE id = :directiveId")
    suspend fun executeDirective(directiveId: String, result: String)
}

@Dao
interface HeartbeatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeartbeat(heartbeat: Heartbeat)

    @Query("SELECT * FROM heartbeat WHERE agentId = :agentId ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLatestHeartbeat(agentId: String): Heartbeat?

    @Query("SELECT * FROM heartbeat WHERE timestamp > :since ORDER BY timestamp DESC")
    fun getRecentHeartbeats(since: Long): Flow<List<Heartbeat>>
}

@Dao
interface SessionDao {
    @Query("SELECT * FROM session WHERE status != 'CLOSED' ORDER BY createdAt")
    fun getActiveSessions(): Flow<List<Session>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertSession(session: Session)

    @Query("UPDATE session SET status = :status WHERE id = :sessionId")
    suspend fun updateStatus(sessionId: String, status: SessionStatus)
}

@Dao
interface FileAttachmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFile(file: FileAttachment)

    @Query("SELECT * FROM fileAttachment WHERE id = :fileId")
    suspend fun getFile(fileId: String): FileAttachment?

    @Query("SELECT * FROM fileAttachment ORDER BY sizeBytes DESC")
    fun getAllFiles(): Flow<List<FileAttachment>>
}
