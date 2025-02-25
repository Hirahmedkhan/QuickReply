package com.example.quickreply.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickreply.data.model.Message
import com.example.quickreply.data.repository.MessageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(private val messageRepository: MessageRepository) :
    ViewModel() {

    val allMessages: LiveData<List<Message>> = messageRepository.allMessages

    init {
        viewModelScope.launch {
            try {
                println("Checking database population status...")
                messageRepository.populateDatabaseIfNeeded()
                println("Database population function executed")
            } catch (e: Exception) {
                println("Error populating database: ${e.message}")
            }
        }
    }

    fun insertMessage(message: Message) {
        viewModelScope.launch {
            messageRepository.insert(message)
        }
    }

    fun deleteMessageByContent(messageText: String) {
        viewModelScope.launch {
            messageRepository.deleteMessageByContent(messageText)
        }
    }
}