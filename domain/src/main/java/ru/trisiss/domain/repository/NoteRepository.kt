package ru.trisiss.domain.repository

import ru.trisiss.domain.model.Note

/**
 * Repository interface to be implemented by Data layer.
 */
interface NoteRepository {

    suspend fun insertOrUpdate(note: Note, deleted: Boolean)

    suspend fun insertOrUpdateMulti(notes: List<Note>, deleted: Boolean)

    suspend fun getNotes(): List<Note>?

    suspend fun getNote(noteId: Long): Note?
}