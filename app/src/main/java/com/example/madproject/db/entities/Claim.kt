package com.example.madproject.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "claims")
data class Claim(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val patientId: Int,
    val hospitalId: Int,
    val insurerId: Int,
    val amount: Double,
    val description: String,
    val status: String
)
