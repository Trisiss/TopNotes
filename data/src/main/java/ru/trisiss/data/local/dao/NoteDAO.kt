package ru.trisiss.data.local.dao

import androidx.room.*
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.trisiss.data.local.model.NoteEntity

@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes ORDER BY timestamp DESC")
    fun getNotes(): Single<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE id = :noteId")
    fun getNote(noteId: Long): Maybe<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)
}