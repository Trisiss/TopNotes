package ru.trisiss.domain.usecases.note.implementation

import io.reactivex.rxjava3.core.Maybe
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository

class NoteDetailUseCase(private val repository: NoteRepository) {
    fun getNotes(noteId: Long): Maybe<Note> = repository.getNote(noteId = noteId)
}