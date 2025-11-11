package com.example.madproject.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.madproject.db.entities.Claim

/**
 * Data Access Object for the Claim entity.
 */
@Dao
interface ClaimDao {

    /**
     * Inserts a new claim into the database.
     *
     * @param claim The claim to insert.
     */
    @Insert
    suspend fun insert(claim: Claim)

    /**
     * Updates an existing claim in the database.
     *
     * @param claim The claim to update.
     */
    @Update
    suspend fun update(claim: Claim)

    /**
     * Retrieves all claims from the database.
     *
     * @return A LiveData list of all claims.
     */
    @Query("SELECT * FROM claims")
    fun getAllClaims(): LiveData<List<Claim>>

    /**
     * Retrieves a claim by its ID.
     *
     * @param id The ID of the claim to retrieve.
     * @return A LiveData object containing the claim.
     */
    @Query("SELECT * FROM claims WHERE id = :id")
    fun getClaimById(id: Int): LiveData<Claim>
}
