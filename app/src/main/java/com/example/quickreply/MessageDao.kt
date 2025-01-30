package com.example.quickreply

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.quickreply.data.model.Message

@Dao
interface MessageDao {

    @Insert
    suspend fun insert(message: Message)

    @Update
    suspend fun update(message: Message)

    @Query("SELECT * FROM message")
    fun getAllMessages(): LiveData<List<Message>>
}