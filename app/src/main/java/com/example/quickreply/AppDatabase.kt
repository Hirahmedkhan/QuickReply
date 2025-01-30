package com.example.quickreply

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quickreply.data.model.Message

@Database(entities = [Message::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
abstract fun MessageDao(): MessageDao
}