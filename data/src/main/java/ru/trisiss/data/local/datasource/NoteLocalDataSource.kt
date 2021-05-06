package ru.trisiss.data.local.datasource

import ru.trisiss.data.local.mapper.NoteMapper
import ru.trisiss.data.local.model.NoteEntity
import ru.trisiss.data.local.provider.DaoProvider
import ru.trisiss.data.repository.datasource.NoteDataSource

/**
 * Created by trisiss on 5/4/2021.
 */
internal class NoteLocalDataSource(daoProvider: DaoProvider, private val noteMapper: NoteMapper): NoteDataSource {
    override suspend fun getNotes(): List<NoteEntity> {
        TODO("Not yet implemented")
    }
}