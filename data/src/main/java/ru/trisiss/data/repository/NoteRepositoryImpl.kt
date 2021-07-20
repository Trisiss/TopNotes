package ru.trisiss.data.repository

import ru.trisiss.data.local.mapper.NoteMapper
import ru.trisiss.data.repository.datasource.NoteDataSource
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository

/**
 * Created by trisiss on 5/4/2021.
 */
class NoteRepositoryImpl(private val noteDataSource: NoteDataSource, private val noteMapper: NoteMapper): NoteRepository {

    override suspend fun getNotes(): List<Note>? =
        noteDataSource.getNotes()?.map { noteMapper.fromEntity(it) }

    override suspend fun getNote(noteId: Long): Note? {
        val noteEntity = noteDataSource.getNote(noteId)
            return when (noteEntity != null) {
                true -> noteMapper.fromEntity(noteEntity)
                false -> null
        }
    }

    override suspend fun insertOrUpdate(note: Note, deleted: Boolean) {
        noteDataSource.insertNote(noteMapper.toEntity(note, deleted))
    }

    override suspend fun insertOrUpdateMulti(notes: List<Note>, deleted: Boolean) {
        noteDataSource.insertNoteMulti(noteMapper.toEntityList(notes, deleted))
    }
}