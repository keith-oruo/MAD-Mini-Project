package com.example.madproject.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

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
