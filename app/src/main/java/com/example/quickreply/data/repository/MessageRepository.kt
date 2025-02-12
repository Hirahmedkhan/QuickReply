package com.example.quickreply.data.repository

import androidx.lifecycle.LiveData
import com.example.quickreply.utils.PreferencesHelper
import com.example.quickreply.data.database.MessageDao
import com.example.quickreply.data.model.Message
import javax.inject.Inject

class MessageRepository @Inject constructor(
    private val messageDao: MessageDao, private val preferencesHelper: PreferencesHelper
) {

    val allMessages: LiveData<List<Message>> = messageDao.getAllMessages()

    suspend fun insert(message: Message) {
        messageDao.insert(message)
    }

    suspend fun update(message: Message) {
        messageDao.update(message)
    }

    suspend fun populateDatabaseIfNeeded() {
        if (!preferencesHelper.isDatabasePopulated()) {
            messageDao.insertAll(
                listOf(
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
            )
            preferencesHelper.setDatabasePopulated()
        }
    }
}
