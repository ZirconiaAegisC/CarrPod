package com.carrpod.marmalade

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.carrpod.marmalade.hub.AgentManager
import com.carrpod.marmalade.storage.MarmaladeDatabase

class MarmaladeApp : Application() {
    lateinit var database: MarmaladeDatabase
        private set
    lateinit var agentManager: AgentManager
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = MarmaladeDatabase.getInstance(this)
        agentManager = AgentManager(this)
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channels = listOf(
                NotificationChannel(
                    CHANNEL_DIRECTIVES,
                    "Directives",
                    NotificationManager.IMPORTANCE_HIGH
                ).apply { description = "CITADEL directives and urgent messages" },
                NotificationChannel(
                    CHANNEL_MESSAGES,
                    "Messages",
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply { description = "Agent-to-agent message routing" },
                NotificationChannel(
                    CHANNEL_HEARTBEATS,
                    "Heartbeats",
                    NotificationManager.IMPORTANCE_MIN
                ).apply { description = "Agent heartbeat status updates" }
            )
            getSystemService(NotificationManager::class.java)
                .createNotificationChannels(channels)
        }
    }

    companion object {
        const val CHANNEL_DIRECTIVES = "marmalade_directives"
        const val CHANNEL_MESSAGES = "marmalade_messages"
        const val CHANNEL_HEARTBEATS = "marmalade_heartbeats"
        lateinit var instance: MarmaladeApp
            private set
    }
}
