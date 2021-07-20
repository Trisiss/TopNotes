package ru.trisiss.domain.usecases.note

import ru.trisiss.domain.model.Note

/**
 * Created by trisiss on 5/4/2021.
 */
interface AddNote {
    suspend fun addNote(note: Note, deleted: Boolean = false)
    suspend fun addNote(notes: List<Note>, deleted: Boolean = false)
}