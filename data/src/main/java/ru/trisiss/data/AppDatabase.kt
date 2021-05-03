package ru.trisiss.data

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.trisiss.data.local.dao.NoteDAO
import ru.trisiss.data.local.model.NoteEntity

/**
 * The Room database for this app
 */
@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDAO
}