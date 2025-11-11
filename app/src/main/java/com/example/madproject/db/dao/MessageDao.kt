package com.example.madproject.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.madproject.db.entities.Message

/**
 * Data Access Object for the Message entity.
 */
@Dao
interface MessageDao {

    /**
     * Inserts a new message into the database.
     *
     * @param message The message to insert.
     */
    @Insert
    suspend fun insert(message: Message)

    /**
     * Retrieves all messages for a given claim.
     *
     * @param claimId The ID of the claim to retrieve messages for.
     * @return A LiveData list of all messages for the given claim.
     */
    @Query("SELECT * FROM messages WHERE claimId = :claimId ORDER BY timestamp DESC")
    fun getMessagesForClaim(claimId: Int): LiveData<List<Message>>
}
