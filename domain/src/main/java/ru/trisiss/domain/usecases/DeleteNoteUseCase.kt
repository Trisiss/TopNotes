package ru.trisiss.domain.usecases

import io.reactivex.rxjava3.core.Completable
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository

class DeleteNoteUseCase(private val repository: NoteRepository) {
    fun delete(note: Note): Completable = repository.delete(note)
}