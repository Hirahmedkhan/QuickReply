package com.example.quickreply.ui.viewmodel

import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
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
            messageRepository.populateDatabaseIfNeeded()
        }
    }

    fun insertMessage(message: Message) {
        viewModelScope.launch {
            messageRepository.insert(message)
        }
    }

    fun updateMessage(message: Message) {
        viewModelScope.launch {
            messageRepository.update(message)
        }
    }

    fun deleteMessage(message: Message) {
        viewModelScope.launch {
            messageRepository.deleteMessage(message)
        }
    }

}