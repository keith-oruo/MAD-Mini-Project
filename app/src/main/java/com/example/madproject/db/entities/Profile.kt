package com.example.madproject.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Represents a user profile in the database.
 *
 * @property id The unique identifier for the profile.
 * @property username The username for login.
 * @property name The full name of the user.
 * @property role The role of the user (e.g., "Admin", "Patient", "Hospital", "Insurer").
 * @property email The email address of the user.
 * @property passwordHash The hashed password for the user.
 */
@Entity(tableName = "profiles")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String,
    val name: String,
    val role: String,
    val email: String,
    val passwordHash: String
)
