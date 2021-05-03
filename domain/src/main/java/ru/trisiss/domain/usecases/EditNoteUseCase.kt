package ru.trisiss.domain.usecases

import io.reactivex.rxjava3.core.Completable
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository

class EditNoteUseCase(private val repository: NoteRepository) {
    fun edit(note: Note): Completable = validate(note).andThen(repository.insertOrUpdate(note = note))

    private fun validate(note: Note): Completable {
        return if (!note.isValidForEdit()) {
            Completable.error(IllegalArgumentException("note failed validation before edit"))
        } else {
            Completable.complete()
        }
    }
}