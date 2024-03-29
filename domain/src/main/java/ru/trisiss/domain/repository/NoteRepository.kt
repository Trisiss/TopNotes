package ru.trisiss.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.trisiss.domain.model.Note

/**
 * Repository interface to be implemented by Data layer.
 */
interface NoteRepository {

    suspend fun saveNote(note: Note, deleted: Boolean)

    suspend fun saveNotes(notes: List<Note>, deleted: Boolean)

    suspend fun getNotes(): Flow<List<Note>>

    suspend fun getNote(noteId: Long): Flow<Note?>
}