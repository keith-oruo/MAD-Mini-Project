package com.example.madproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.madproject.db.AppDatabase
import com.example.madproject.db.entities.Message
import kotlinx.coroutines.launch
import java.util.Date

class MessagesViewModel(application: Application) : AndroidViewModel(application) {

    private val messageDao = AppDatabase.getDatabase(application).messageDao()
    val newMessage = MutableLiveData<String>()

    // TODO: This should be dynamic based on the selected claim
    val messages: LiveData<List<Message>> = messageDao.getMessagesForClaim(1)

    fun sendMessage() {
        viewModelScope.launch {
            val message = Message(
                claimId = 1, // TODO: This should be dynamic
                senderId = 1, // TODO: This should be dynamic
                receiverId = 2, // TODO: This should be dynamic
                content = newMessage.value ?: "",
                timestamp = Date()
            )
            messageDao.insert(message)
            newMessage.value = ""
        }
    }
}
