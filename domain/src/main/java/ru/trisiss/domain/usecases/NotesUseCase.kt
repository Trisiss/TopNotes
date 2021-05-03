package ru.trisiss.domain.usecases

import io.reactivex.rxjava3.core.Single
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository

class NotesUseCase(private val repository: NoteRepository) {
    fun getNotes(): Single<List<Note>> = repository.getNotes()
}