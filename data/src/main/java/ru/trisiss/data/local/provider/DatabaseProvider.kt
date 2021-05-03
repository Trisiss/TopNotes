package ru.trisiss.data.local.provider

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import kotlinx.coroutines.launch
import ru.trisiss.data.AppDatabase
import ru.trisiss.data.local.model.NoteEntity

/**
 * Created by trisiss on 5/3/2021.
 *
 * Repository with on [Room] database.
 */
class DatabaseProvider(private val context: Context) {
    private var database: AppDatabase? = null

    /**
     * Gets an instance of [AppDatabase]
     *
     * @return an instance of [AppDatabase]
     */

    @InternalCoroutinesApi
    fun getInstance(): AppDatabase =
        database ?: synchronized(this) {
            database ?: buildDatabase().also {database = it}
        }

    private fun buildDatabase(): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "notes-db")
            .addCallback(onCreateDatabase())
            .build()

    private fun onCreateDatabase() =
        object: RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                GlobalScope.launch {
                    database?.noteDao()?.insertOrUpdate(getDefaultNote())
                }
            }
        }

    private fun getDefaultNote() =
        NoteEntity(
            id = 1,
            noteTitle = "First note",
            noteText = "It's first note for test work database",
            timestamp = System.currentTimeMillis()
        )
}