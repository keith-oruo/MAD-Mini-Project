package com.example.madproject.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Represents an audit log entry in the database.
 * Each entry tracks an action performed on a claim or invoice.
 */
@Entity(tableName = "audit_logs")
data class AuditLog(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val claimId: Long?,
    val invoiceId: Long?,

    val action: String,
    val details: String,
    val timestamp: Date
)
