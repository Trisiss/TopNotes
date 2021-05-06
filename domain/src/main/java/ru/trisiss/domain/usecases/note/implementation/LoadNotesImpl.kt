package ru.trisiss.domain.usecases.note.implementation

import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository
import ru.trisiss.domain.usecases.note.LoadNotes

class LoadNotesImpl(private val repository: NoteRepository) : LoadNotes {
    override suspend fun invoke(): List<Note>? =
        repository.getNotes()
}