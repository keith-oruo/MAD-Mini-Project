package com.example.madproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.madproject.db.AppDatabase
import com.example.madproject.db.entities.Profile

class ProfileViewModel(application: Application) : AndroidViewModel(application) {

    private val profileDao = AppDatabase.getDatabase(application).profileDao()

    // TODO: This should be dynamic based on the logged in user
    val user: LiveData<Profile> = profileDao.getProfileById(1)
}
