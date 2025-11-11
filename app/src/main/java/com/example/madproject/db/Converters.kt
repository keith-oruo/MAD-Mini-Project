package com.example.madproject.db

import androidx.room.TypeConverter
import java.util.Date

/**
 * Type converters to allow Room to reference complex data types.
 */
class Converters {
    /**
     * Converts a Long timestamp from the database into a Date object.     * Room will use this when reading from the database.
     */
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    /**
     * Converts a Date object into a Long timestamp for storing in the database.
     * Room will use this when writing to the database.
     */
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}