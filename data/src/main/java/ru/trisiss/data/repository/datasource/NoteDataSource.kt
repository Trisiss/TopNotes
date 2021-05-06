package ru.trisiss.data.repository.datasource

import ru.trisiss.data.local.model.NoteEntity

/**
 * Created by trisiss on 5/4/2021.
 */
interface NoteDataSource {
    suspend fun getNotes(): List<NoteEntity>
}