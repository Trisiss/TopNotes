package ru.trisiss.data.local.datasource

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import ru.trisiss.data.local.model.NoteEntity
import ru.trisiss.data.local.provider.DaoProvider
import ru.trisiss.data.repository.datasource.NoteDataSource

/**
 * Created by trisiss on 5/4/2021.
 */
internal class NoteLocalDataSource(daoProvider: DaoProvider): NoteDataSource {

    @InternalCoroutinesApi
    val noteDao = daoProvider.getNoteDao()

    @InternalCoroutinesApi
    override fun getNotes(): Flow<List<NoteEntity>> =
     noteDao.getNotes()

    @InternalCoroutinesApi
    override fun getNote(noteId: Long): Flow<NoteEntity> {
        return noteDao.getNote(noteId)
    }

    @InternalCoroutinesApi
    override suspend fun insertNote(noteEntity: NoteEntity) {
        noteDao.insertOrUpdate(noteEntity)
    }

    @InternalCoroutinesApi
    override suspend fun insertNotes(noteEntities: List<NoteEntity>) {
        noteDao.insertOrUpdateMulti(noteEntities)
    }
}