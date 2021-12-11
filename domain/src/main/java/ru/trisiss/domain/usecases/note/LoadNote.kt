package ru.trisiss.domain.usecases.note

import kotlinx.coroutines.flow.Flow
import ru.trisiss.domain.model.Note

/**
 * Created by trisiss on 5/16/2021.
 */
interface LoadNote {
    suspend fun getNote(noteId: Long): Flow<Note?>
    suspend fun getNotes(): Flow<List<Note>>
}