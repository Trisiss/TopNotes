package ru.trisiss.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.trisiss.data.utilities.DATABASE_NAME

/**
 * The Room database for this app
 */
@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDAOImpl

    companion object {
        fun createNoteDao(context: Context): NoteDAOImpl {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .build().noteDao()
        }
    }
}