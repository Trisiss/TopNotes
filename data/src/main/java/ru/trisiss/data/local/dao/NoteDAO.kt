package ru.trisiss.data.local.dao

import androidx.room.*
import ru.trisiss.data.local.model.NoteEntity

@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes WHERE deleted = 0 ORDER BY timestamp DESC ")
    suspend fun getNotes(): List<NoteEntity>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    suspend fun getNote(noteId: Long): NoteEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(noteEntity: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateMulti(notesEntity: List<NoteEntity>)

    @Delete
    fun delete(noteEntity: NoteEntity)
}