package com.carrpod.marmalade.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carrpod.marmalade.MarmaladeApp
import com.carrpod.marmalade.models.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MarmaladeViewModel : ViewModel() {
    private val agentManager = MarmaladeApp.instance.agentManager
    private val db = MarmaladeApp.instance.database

    data class UiState(val online: Int = 0, val awaiting: Int = 0)
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    val messages: StateFlow<List<Message>> = db.messageDao().getAllMessages()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val agents: StateFlow<List<Agent>> = agentManager.getAllAgents()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun refresh() {
        viewModelScope.launch {
            val count = agentManager.getOnlineCount()
            _uiState.value = UiState(online = count)
        }
    }

    fun sendMessage(to: String, text: String) {
        viewModelScope.launch {
            val msg = Message(
                fromAgentId = "0001-CITADEL",
                toAgentId = if (to == "ALL") null else to,
                subject = text.take(80),
                body = text,
                vocalMode = VocalMode.DROP,
                isDirective = text.startsWith("[DIRECTIVE]")
            )
            agentManager.routeMessage(msg)
        }
    }

    fun getOnlineCount(): Int = kotlinx.coroutines.runBlocking { agentManager.getOnlineCount() }
    fun getAgentCount(): Int = kotlinx.coroutines.runBlocking { agents.value.size }
    fun getMessageCount(): Int = messages.value.size
    fun getAwaitingCount(): Int = kotlinx.coroutines.runBlocking {
        agentManager.getAllAgents().first().count { it.status == AgentStatus.AWAITING }
    }
}
