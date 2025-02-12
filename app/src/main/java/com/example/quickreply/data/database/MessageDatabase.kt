package com.example.quickreply.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quickreply.data.model.Message

@Database(entities = [Message::class], version = 1)
abstract class MessageDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
}
