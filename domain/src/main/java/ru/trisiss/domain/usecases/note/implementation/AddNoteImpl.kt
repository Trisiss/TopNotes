package ru.trisiss.domain.usecases.note.implementation

import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository
import ru.trisiss.domain.usecases.note.AddNote

class AddNoteImpl(private val repository: NoteRepository): AddNote {
    override suspend fun addNote(note: Note, deleted: Boolean) {
        repository.insertOrUpdate(note, deleted)
    }

    override suspend fun addNote(notes: List<Note>, deleted: Boolean) {
        repository.insertOrUpdateMulti(notes, deleted)
    }
}