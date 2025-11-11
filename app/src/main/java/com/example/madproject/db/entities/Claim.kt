package com.example.madproject.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a claim in the database.
 *
 * @property id The unique identifier for the claim.
 * @property patientId The ID of the patient who submitted the claim.
 * @property hospitalId The ID of the hospital where the service was provided.
 * @property insurerId The ID of the insurer who will process the claim.
 * @property amount The amount of the claim.
 * @property description A description of the service provided.
 * @property status The current status of the claim (e.g., "Submitted", "Approved", "Rejected").
 */
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
