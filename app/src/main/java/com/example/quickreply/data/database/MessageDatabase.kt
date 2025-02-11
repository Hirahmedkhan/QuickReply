package com.example.quickreply.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quickreply.data.model.Message

@Database(entities = [Message::class], version = 1)
abstract class MessageDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao


    /**
    companion object {
    @Volatile
    private  var INSTANCE: MessageDatabase? = null

    private fun getInstance() = INSTANCE

    fun getDatabase(context: Context): MessageDatabase? {
    synchronized(this) {
    INSTANCE = Room.databaseBuilder(
    context.applicationContext, MessageDatabase::class.java, "message_database"
    ).addCallback(object : RoomDatabase.Callback() {
    override fun onCreate(db: SupportSQLiteDatabase) {
    super.onCreate(db)
    populateDatabase()
    }
    }).build()
    }
    return INSTANCE
    }

    fun populateDatabase() {
    val scope = CoroutineScope(Dispatchers.IO)
    scope.launch {
    val dao = getInstance()?.messageDao()


    if (dao != null) {
    dao.insert(
    Message(message = "Hey there! I'm currently unavailable. I'll get back to you soon. 😊"),
    Message(message = "Thanks for reaching out! I'm away right now but will respond as soon as possible."),
    Message(message = "Hello! I'm a bit busy at the moment. I'll reply as soon as I can. 🚀"),
    Message(message = "Hi! I'm not available right now. Leave a message, and I'll get back to you shortly."),
    Message(message = "Hey! I'm currently occupied. I'll message you back when I'm free. Thanks for your patience! 🙏"),
    Message(message = "I'm away from my phone right now. I'll respond as soon as I return. 📱"),
    Message(message = "Hi there! I'm currently in a meeting. I'll get back to you soon."),
    Message(message = "Thanks for your message! I'm out right now but will reply soon. 🕒"),
    Message(message = "Hey! I'm taking a short break. I'll message you back once I'm available."),
    Message(message = "I'm currently offline. I'll reply when I'm back online. 🌐")
    )
    }
    }
    }
    }

     */
}
