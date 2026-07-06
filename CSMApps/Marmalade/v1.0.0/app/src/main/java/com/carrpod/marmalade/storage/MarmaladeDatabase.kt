package com.carrpod.marmalade.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.carrpod.marmalade.models.Agent
import com.carrpod.marmalade.models.Message
import com.carrpod.marmalade.models.Directive
import com.carrpod.marmalade.models.Heartbeat
import com.carrpod.marmalade.models.Session
import com.carrpod.marmalade.models.FileAttachment

@Database(
    entities = [Agent::class, Message::class, Directive::class, Heartbeat::class, Session::class, FileAttachment::class],
    version = 1,
    exportSchema = false
)
abstract class MarmaladeDatabase : RoomDatabase() {
    abstract fun agentDao(): AgentDao
    abstract fun messageDao(): MessageDao
    abstract fun directiveDao(): DirectiveDao
    abstract fun heartbeatDao(): HeartbeatDao
    abstract fun sessionDao(): SessionDao
    abstract fun fileAttachmentDao(): FileAttachmentDao

    companion object {
        @Volatile
        private var INSTANCE: MarmaladeDatabase? = null

        fun getInstance(context: Context): MarmaladeDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    MarmaladeDatabase::class.java,
                    "marmalade_hub.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}
