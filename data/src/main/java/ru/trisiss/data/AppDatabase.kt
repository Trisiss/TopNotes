package ru.trisiss.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.trisiss.data.local.converter.DateConverter
import ru.trisiss.data.local.dao.NoteDAO
import ru.trisiss.data.local.model.NoteEntity

/**
 * The Room database for this app
 */
@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDAO
}