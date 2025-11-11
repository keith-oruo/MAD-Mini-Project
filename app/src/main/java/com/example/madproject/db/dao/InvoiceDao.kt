package com.example.madproject.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.madproject.db.entities.Invoice

/**
 * Data Access Object for the Invoice entity.
 */
@Dao
interface InvoiceDao {

    /**
     * Inserts a new invoice into the database.
     *
     * @param invoice The invoice to insert.
     */
    @Insert
    suspend fun insert(invoice: Invoice)

    /**
     * Retrieves all invoices for a given claim.
     *
     * @param claimId The ID of the claim to retrieve invoices for.
     * @return A LiveData list of all invoices for the given claim.
     */
    @Query("SELECT * FROM invoices WHERE claimId = :claimId")
    fun getInvoicesForClaim(claimId: Int): LiveData<List<Invoice>>
}
