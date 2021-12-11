package ru.trisiss.domain.usecases.note

import ru.trisiss.domain.model.Note

/**
 * Created by trisiss on 5/4/2021.
 */
interface SaveNote {
    suspend fun saveNote(note: Note, deleted: Boolean = false)
    suspend fun saveNotes(notes: List<Note>, deleted: Boolean = false)
}