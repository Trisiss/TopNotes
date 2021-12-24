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

    @OptIn(InternalCoroutinesApi::class)
    override fun getNotes(): Flow<List<NoteEntity>> =
     noteDao.getNotes()

    @OptIn(InternalCoroutinesApi::class)
    override fun getNote(noteId: Long): Flow<NoteEntity?> {
        return noteDao.getNote(noteId)
    }

    @OptIn(InternalCoroutinesApi::class)
    override suspend fun insertNote(noteEntity: NoteEntity) {
        noteDao.insertOrUpdate(noteEntity)
    }

    @OptIn(InternalCoroutinesApi::class)
    override suspend fun insertNotes(noteEntities: List<NoteEntity>) {
        noteDao.insertOrUpdateMulti(noteEntities)
    }
}