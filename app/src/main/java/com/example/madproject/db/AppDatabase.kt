package com.example.madproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.madproject.db.dao.*
import com.example.madproject.db.entities.*

/**
 * The main database class for the application.
 * This class is annotated with @Database and lists all the entities and the database version.
 * It also registers the TypeConverters needed by Room.
 */
@Database(
    entities = [Profile::class, Claim::class, Invoice::class, Message::class, AuditLog::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDao
    abstract fun claimDao(): ClaimDao
    abstract fun invoiceDao(): InvoiceDao
    abstract fun messageDao(): MessageDao
    abstract fun auditLogDao(): AuditLogDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "claims_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
