package ru.trisiss.data.repository.datasource

import kotlinx.coroutines.flow.Flow
import ru.trisiss.data.local.model.NoteEntity

/**
 * Created by trisiss on 5/4/2021.
 */
interface NoteDataSource {
    fun getNotes(): Flow<List<NoteEntity>>
    fun getNote(noteId: Long): Flow<NoteEntity?>
    suspend fun insertNote(noteEntity: NoteEntity)
    suspend fun insertNotes(noteEntities: List<NoteEntity>)
}