package com.example.madproject.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.madproject.db.AppDatabase
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val loginSuccess = MutableLiveData<Boolean>()

    private val profileDao = AppDatabase.getDatabase(application).profileDao()

    fun login(username: String, password_val: String) {
        viewModelScope.launch {
            val user = profileDao.getProfileByUsername(username)
            if (user != null && user.passwordHash == password_val) {
                loginSuccess.postValue(true)
            } else {
                loginSuccess.postValue(false)
            }
        }
    }
}
