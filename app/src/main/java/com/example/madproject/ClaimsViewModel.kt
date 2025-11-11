package com.example.madproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.madproject.db.AppDatabase
import com.example.madproject.db.entities.Claim

class ClaimsViewModel(application: Application) : AndroidViewModel(application) {

    private val claimDao = AppDatabase.getDatabase(application).claimDao()

    val allClaims: LiveData<List<Claim>> = claimDao.getAllClaims()
}
