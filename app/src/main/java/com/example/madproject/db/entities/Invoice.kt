package com.example.madproject.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Represents an invoice in the database.
 *
 * @property id The unique identifier for the invoice.
 * @property claimId The ID of the claim this invoice is associated with.
 * @property amount The amount of the invoice.
 * @property issueDate The date the invoice was issued.
 * @property status The status of the invoice (e.g., "Issued", "Paid").
 */
@Entity(tableName = "invoices")
data class Invoice(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val claimId: Int,
    val amount: Double,
    val issueDate: Date,
    val status: String
)
