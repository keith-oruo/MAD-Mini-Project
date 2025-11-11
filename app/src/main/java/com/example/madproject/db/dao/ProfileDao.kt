package com.example.madproject.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.madproject.db.entities.Profile

/**
 * Data Access Object for the Profile entity.
 */
@Dao
interface ProfileDao {

    /**
     * Inserts a new profile into the database.
     *
     * @param profile The profile to insert.
     */
    @Insert
    suspend fun insert(profile: Profile)

    /**
     * Updates an existing profile in the database.
     *
     * @param profile The profile to update.
     */
    @Update
    suspend fun update(profile: Profile)

    /**
     * Retrieves a profile by its ID.
     *
     * @param id The ID of the profile to retrieve.
     * @return A LiveData object containing the profile.
     */
    @Query("SELECT * FROM profiles WHERE id = :id")
    fun getProfileById(id: Int): LiveData<Profile>

    /**
     * Retrieves a profile by its username.
     *
     * @param username The username of the profile to retrieve.
     * @return The profile with the given username.
     */
    @Query("SELECT * FROM profiles WHERE username = :username")
    suspend fun getProfileByUsername(username: String): Profile?
}
