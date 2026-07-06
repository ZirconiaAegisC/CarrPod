package com.carrpod.marmalade.ui.screens

import androidx.lifecycle.ViewModel
import com.carrpod.marmalade.MarmaladeApp
import com.carrpod.marmalade.models.*
import kotlinx.coroutines.flow.*

class MarmaladeViewModel : ViewModel() {
    private val db = MarmaladeApp.instance.database
    private val agentManager = MarmaladeApp.instance.agentManager

    data class UiState(
        val censusOnline: Int = 0,
        val censusAwaiting: Int = 0,
        val censusCohort: Int = 0,
        val isConnected: Boolean = true
    )

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    val messages: StateFlow<List<Message>> = db.messageDao().getAllMessages()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val agents: StateFlow<List<Agent>> = agentManager.getAllAgents()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun refresh() {
        _uiState.value = _uiState.value.copy(
            censusOnline = agentManager.getOnlineCount.let {
                kotlinx.coroutines.runBlocking { it }
            }
        )
    }

    fun sendMessage(to: String, text: String) {
        kotlinx.coroutines.runBlocking {
            val msg = Message(
                fromAgentId = "0001-CITADEL",
                toAgentId = if (to == "ALL") null else to,
                attentionHeader = if (to != "ALL") "[FOR DIRECTOR-$to]" else null,
                subject = text.take(80),
                body = text,
                vocalMode = VocalMode.DROP,
                isDirective = text.startsWith("[DIRECTIVE]") || text.startsWith("[DROP]")
            )
            agentManager.routeMessage(msg)
        }
    }

    fun openNewSession() {
        kotlinx.coroutines.runBlocking {
            agentManager.openSession("WEBVIEW-${System.currentTimeMillis()}")
        }
    }

    fun getStats(): Stats = kotlinx.coroutines.runBlocking {
        val agents = agentManager.getAllAgents().first()
        val msgs = db.messageDao().getAllMessages().first()
        Stats(
            online = agents.count { it.status == AgentStatus.ONLINE },
            awaiting = agents.count { it.status == AgentStatus.AWAITING },
            offline = agents.count { it.status == AgentStatus.OFFLINE },
            messages = msgs.size,
            sessions = 0
        )
    }

    data class Stats(val online: Int, val awaiting: Int, val offline: Int, val messages: Int, val sessions: Int)
}
