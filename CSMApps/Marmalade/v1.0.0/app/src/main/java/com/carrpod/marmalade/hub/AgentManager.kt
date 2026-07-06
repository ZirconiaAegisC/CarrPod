package com.carrpod.marmalade.hub

import android.content.Context
import com.carrpod.marmalade.MarmaladeApp
import com.carrpod.marmalade.models.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AgentManager(private val context: Context) {
    private val db = MarmaladeApp.instance.database
    private val agentDao = db.agentDao()
    private val messageDao = db.messageDao()
    private val directiveDao = db.directiveDao()
    private val heartbeatDao = db.heartbeatDao()
    private val sessionDao = db.sessionDao()

    suspend fun registerAgent(agent: Agent) = agentDao.upsertAgent(agent)
    suspend fun updateHeartbeat(directorId: String, census: Census) {
        agentDao.updateStatus(directorId, AgentStatus.ONLINE, System.currentTimeMillis())
        heartbeatDao.insertHeartbeat(
            Heartbeat(
                agentId = directorId,
                censusOnline = census.online,
                censusAwaiting = census.awaiting,
                cohortOnline = census.cohortOnline
            )
        )
    }

    fun getOnlineAgents(): Flow<List<Agent>> = agentDao.getOnlineAgents()
    fun getAllAgents(): Flow<List<Agent>> = agentDao.getAllAgents()
    suspend fun getOnlineCount(): Int = agentDao.getOnlineCount()

    suspend fun routeMessage(message: Message): Boolean {
        messageDao.insertMessage(message)
        return true
    }

    fun getMessagesForAgent(agentId: String): Flow<List<Message>> =
        messageDao.getMessagesForAgent(agentId)

    suspend fun issueDirective(from: String, to: String, command: String, params: Map<String, String> = emptyMap()): Directive {
        val directive = Directive(fromAgentId = from, toAgentId = to, command = command, params = params)
        directiveDao.insertDirective(directive)
        return directive
    }

    suspend fun executeDirective(directiveId: String, result: String) =
        directiveDao.executeDirective(directiveId, result)

    fun getDirectives(): Flow<List<Directive>> = directiveDao.getAllDirectives()

    suspend fun openSession(agentId: String): Session {
        val session = Session(agentId = agentId)
        sessionDao.upsertSession(session)
        return session
    }

    fun getActiveSessions(): Flow<List<Session>> = sessionDao.getActiveSessions()

    data class Census(val online: Int, val awaiting: Int, val cohortOnline: Int)
}
