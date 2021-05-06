package ru.trisiss.domain.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import ru.trisiss.domain.model.Note

/**
 * Repository interface to be implemented by Data layer.
 */
interface NoteRepository {

    fun insertOrUpdate(note: Note): Completable

    fun delete(note: Note): Completable

    suspend fun getNotes(): List<Note>?

    fun getNote(noteId: Long): Maybe<Note>
}