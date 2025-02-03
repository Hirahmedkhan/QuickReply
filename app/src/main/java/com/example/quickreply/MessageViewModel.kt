package com.example.quickreply

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quickreply.data.model.Message
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(private val messageRepository: MessageRepository) : ViewModel() {

    private val allMessages: LiveData<List<Message>> = messageRepository.allMessages

    fun insertMessage(message: Message) {
        viewModelScope.launch {
            messageRepository.insert(message)
        }
    }

    fun upDateMessage(message: Message) {
        viewModelScope.launch {
            messageRepository.update(message)
        }
    }
}