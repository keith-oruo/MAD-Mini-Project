package com.example.madproject.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Represents a message in the database.
 *
 * @property id The unique identifier for the message.
 * @property claimId The ID of the claim this message is associated with.
 * @property senderId The ID of the user who sent the message.
 * @property receiverId The ID of the user who received the message.
 * @property content The content of the message.
 * @property timestamp The time the message was sent.
 */
@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val claimId: Int,
    val senderId: Int,
    val receiverId: Int,
    val content: String,
    val timestamp: Date
)
