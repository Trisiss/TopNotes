package ru.trisiss.data.local.datasource

import kotlinx.coroutines.InternalCoroutinesApi
import ru.trisiss.data.local.mapper.NoteMapper
import ru.trisiss.data.local.model.NoteEntity
import ru.trisiss.data.local.provider.DaoProvider
import ru.trisiss.data.repository.datasource.NoteDataSource

/**
 * Created by trisiss on 5/4/2021.
 */
internal class NoteLocalDataSource(daoProvider: DaoProvider, private val noteMapper: NoteMapper): NoteDataSource {

    @InternalCoroutinesApi
    val noteDao = daoProvider.getNoteDao()

    @InternalCoroutinesApi
    override suspend fun getNotes(): List<NoteEntity>? =
     noteDao.getNotes()

    @InternalCoroutinesApi
    override suspend fun getNote(noteId: Long): NoteEntity? {
        return noteDao.getNote(noteId)
    }

    @InternalCoroutinesApi
    override suspend fun insertNote(noteEntity: NoteEntity) {
        noteDao.insertOrUpdate(noteEntity)
    }

    @InternalCoroutinesApi
    override suspend fun insertNoteMulti(notesEntity: List<NoteEntity>) {
        noteDao.insertOrUpdateMulti(notesEntity)
    }
}