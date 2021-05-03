package ru.trisiss.domain.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.trisiss.domain.model.Note

/**
 * Repository interface to be implemented by Data layer.
 */
interface NoteRepository {

    fun insertOrUpdate(note: Note): Completable

    fun delete(note: Note): Completable

    fun getNotes(): Single<List<Note>>

    fun getNote(noteId: Long): Maybe<Note>
}