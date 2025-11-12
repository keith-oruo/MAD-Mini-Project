package com.example.madproject.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "invoices")
data class Invoice(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val claimId: Int,
    val amount: Double,
    val issueDate: Date,
    val status: String
)
