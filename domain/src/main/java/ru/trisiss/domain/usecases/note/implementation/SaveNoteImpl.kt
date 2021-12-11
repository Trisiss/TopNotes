package ru.trisiss.domain.usecases.note.implementation

import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository
import ru.trisiss.domain.usecases.note.SaveNote

class SaveNoteImpl(private val repository: NoteRepository): SaveNote {
    override suspend fun saveNote(note: Note, deleted: Boolean) {
        repository.saveNote(note, deleted)
    }

    override suspend fun saveNotes(notes: List<Note>, deleted: Boolean) {
        repository.saveNotes(notes, deleted)
    }
}