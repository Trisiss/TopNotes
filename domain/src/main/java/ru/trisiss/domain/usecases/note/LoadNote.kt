package ru.trisiss.domain.usecases.note

import ru.trisiss.domain.model.Note

/**
 * Created by trisiss on 5/16/2021.
 */
interface LoadNote {
    suspend fun getNote(noteId: Long): Note?
    suspend fun getNotes(): List<Note>?
}