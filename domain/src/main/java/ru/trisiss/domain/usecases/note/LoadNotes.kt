package ru.trisiss.domain.usecases.note

import ru.trisiss.domain.model.Note

/**
 * Created by trisiss on 5/4/2021.
 */
interface LoadNotes {
    suspend fun getNotes(): List<Note>?
}