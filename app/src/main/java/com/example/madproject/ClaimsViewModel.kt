package com.example.madproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.madproject.db.AppDatabase
import com.example.madproject.db.dao.ClaimDao
import com.example.madproject.db.entities.Claim
import kotlinx.coroutines.launch

class ClaimsViewModel(application: Application) : AndroidViewModel(application) {

    private val claimDao: ClaimDao
    val allClaims: LiveData<List<Claim>>

    init {
        val database = AppDatabase.getDatabase(application)
        claimDao = database.claimDao()
        allClaims = claimDao.getAllClaims()
    }

    fun submitClaim(description: String) {
        viewModelScope.launch {
            val newClaim = Claim(
                patientId = 1,
                hospitalId = 2,
                insurerId = 3,
                amount = 100.0,
                description = description,
                status = "Submitted"
            )
            claimDao.insert(newClaim)
        }
    }

    fun updateClaimAmount(claim: Claim, newAmount: Double) {
        viewModelScope.launch {
            val updatedClaim = claim.copy(amount = newAmount)
            claimDao.update(updatedClaim)
        }
    }
}
