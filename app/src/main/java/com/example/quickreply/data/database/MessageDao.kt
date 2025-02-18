package com.example.quickreply.data.database

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

    @Insert
    suspend fun insertAll( messages: List<Message>)

    @Update
    suspend fun update(message: Message)

    @Query("DELETE FROM message WHERE id = :messageId")
    suspend fun deleteMessage(messageId: Int)

    @Query("SELECT * FROM message")
    fun getAllMessages(): LiveData<List<Message>>
}