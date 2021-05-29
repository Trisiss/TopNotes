package ru.trisiss.data.local.dao

import androidx.room.*
import ru.trisiss.data.local.model.NoteEntity

@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes ORDER BY timestamp DESC")
    suspend fun getNotes(): List<NoteEntity>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNote(noteId: Long): NoteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)
}