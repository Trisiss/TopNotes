package ru.trisiss.data.local.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ru.trisiss.data.local.model.NoteEntity

@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes WHERE deleted = 0 ORDER BY timestamp DESC ")
    fun getNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun getNote(noteId: Long): Flow<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(noteEntity: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateMulti(notesEntity: List<NoteEntity>)

    @Delete
    fun delete(noteEntity: NoteEntity)
}