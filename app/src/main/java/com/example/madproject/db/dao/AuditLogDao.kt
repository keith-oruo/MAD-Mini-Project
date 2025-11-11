package com.example.madproject.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.madproject.db.entities.AuditLog

@Dao
interface AuditLogDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAuditLog(log: AuditLog)

    @Query("SELECT * FROM audit_logs ORDER BY timestamp DESC")
    fun getAllAuditLogs(): LiveData<List<AuditLog>>
}
