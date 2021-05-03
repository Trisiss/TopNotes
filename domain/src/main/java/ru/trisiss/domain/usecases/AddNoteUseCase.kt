package ru.trisiss.domain.usecases

import io.reactivex.rxjava3.core.Completable
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository

class AddNoteUseCase(private val repository: NoteRepository) {
    fun add(note: Note): Completable = validate(note).andThen(repository.insertOrUpdate(note))

    private fun validate(note: Note): Completable {
        return if (!note.isValidForAdd()) {
            Completable.error(IllegalArgumentException("note failed validation before add"))
        } else {
            Completable.complete()
        }
    }
}