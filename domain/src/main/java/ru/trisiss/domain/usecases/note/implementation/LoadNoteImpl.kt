package ru.trisiss.domain.usecases.note.implementation

import ru.trisiss.domain.repository.NoteRepository
import ru.trisiss.domain.usecases.note.LoadNote

/**
 * Created by trisiss on 5/16/2021.
 */
class LoadNoteImpl(private val repository: NoteRepository): LoadNote {
    override suspend fun getNote(noteId: Long) =
       repository.getNote(noteId = noteId)

    override suspend fun getNotes() =
        repository.getNotes()
}