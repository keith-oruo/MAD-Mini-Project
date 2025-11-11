package com.example.madproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.madproject.db.dao.*
import com.example.madproject.db.entities.*
import java.util.Date

/**
 * The main database class for the application.
 * This class is annotated with @Database and lists all the entities and the database version.
 * It also registers the TypeConverters needed by Room.
 */
@Database(
    entities = [Profile::class, Claim::class, Invoice::class, Message::class, AuditLog::class],
    version = 9, // Incremented version to force recreation
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
                        // Use execSQL to insert data directly, avoiding the race condition.
                        db.execSQL("INSERT INTO profiles (username, name, role, email, passwordHash) VALUES ('patient', 'John Doe', 'Patient', 'john.doe@example.com', 'password')")
                        db.execSQL("INSERT INTO profiles (username, name, role, email, passwordHash) VALUES ('hospital', 'General Hospital', 'Hospital', 'contact@generalhospital.com', 'password')")
                        db.execSQL("INSERT INTO profiles (username, name, role, email, passwordHash) VALUES ('insurer', 'Health Insurers Inc.', 'Insurer', 'claims@healthinsurers.com', 'password')")

                        // Dummy Claims
                        db.execSQL("INSERT INTO claims (patientId, hospitalId, insurerId, amount, description, status) VALUES (1, 2, 3, 500.0, 'Routine Checkup', 'Approved')")
                        db.execSQL("INSERT INTO claims (patientId, hospitalId, insurerId, amount, description, status) VALUES (1, 2, 3, 1200.0, 'Emergency Room Visit', 'Pending')")

                        // Dummy Invoices
                        val currentTime = System.currentTimeMillis()
                        db.execSQL("INSERT INTO invoices (claimId, amount, issueDate, status) VALUES (1, 500.0, $currentTime, 'Paid')")
                        db.execSQL("INSERT INTO invoices (claimId, amount, issueDate, status) VALUES (2, 1200.0, $currentTime, 'Unpaid')")

                        // Dummy Messages
                        db.execSQL("INSERT INTO messages (claimId, senderId, receiverId, content, timestamp) VALUES (1, 1, 2, 'Hi, please check my claim.', $currentTime)")
                        db.execSQL("INSERT INTO messages (claimId, senderId, receiverId, content, timestamp) VALUES (1, 2, 1, 'We are processing your claim.', $currentTime)")
                    }
                }).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
