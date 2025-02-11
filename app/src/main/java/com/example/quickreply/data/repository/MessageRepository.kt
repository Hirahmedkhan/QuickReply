package com.example.quickreply.data.repository

import androidx.lifecycle.LiveData
import com.example.quickreply.data.database.MessageDao
import com.example.quickreply.data.model.Message
import javax.inject.Inject

class MessageRepository @Inject constructor(private val messageDao: MessageDao) {

    val allMessages: LiveData<List<Message>> = messageDao.getAllMessages()

    suspend fun insert(message: Message){
        messageDao.insert(message)
    }

    suspend fun update(message: Message) {
        messageDao.update(message)
    }
}