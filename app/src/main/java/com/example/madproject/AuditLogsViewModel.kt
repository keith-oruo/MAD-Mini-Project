package com.example.madproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.madproject.db.AppDatabase
import com.example.madproject.db.entities.AuditLog

class AuditLogsViewModel(application: Application) : AndroidViewModel(application) {

    private val auditLogDao = AppDatabase.getDatabase(application).auditLogDao()

    val allAuditLogs: LiveData<List<AuditLog>> = auditLogDao.getAllAuditLogs()
}
