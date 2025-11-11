package com.example.madproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.madproject.db.dao.*
import com.example.madproject.db.entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * The main database class for the application.
 * This class is annotated with @Database and lists all the entities and the database version.
 * It also registers the TypeConverters needed by Room.
 */
@Database(
    entities = [Profile::class, Claim::class, Invoice::class, Message::class, AuditLog::class],
    version = 2,
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
                ).fallbackToDestructiveMigration()
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            INSTANCE?.let { database ->
                                val profileDao = database.profileDao()
                                profileDao.insert(
                                    Profile(
                                        username = "patient",
                                        name = "John Doe",
                                        role = "Patient",
                                        email = "john.doe@example.com",
                                        passwordHash = "password"
                                    )
                                )
                                profileDao.insert(
                                    Profile(
                                        username = "hospital",
                                        name = "General Hospital",
                                        role = "Hospital",
                                        email = "contact@generalhospital.com",
                                        passwordHash = "password"
                                    )
                                )
                                profileDao.insert(
                                    Profile(
                                        username = "insurer",
                                        name = "Health Insurers Inc.",
                                        role = "Insurer",
                                        email = "claims@healthinsurers.com",
                                        passwordHash = "password"
                                    )
                                )
                            }
                        }
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
