package ru.trisiss.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.trisiss.data.local.mapper.NoteMapper
import ru.trisiss.data.repository.datasource.NoteDataSource
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository

/**
 * Created by trisiss on 5/4/2021.
 */
class NoteRepositoryImpl(private val noteDataSource: NoteDataSource, private val noteMapper: NoteMapper): NoteRepository {

    override suspend fun getNotes(): Flow<List<Note>> =
        noteDataSource.getNotes().map { entityList -> entityList.map { noteMapper.fromEntity(it) } }

    override suspend fun getNote(noteId: Long): Flow<Note?> =
        noteDataSource.getNote(noteId = noteId).map { entity -> entity?.let { noteMapper.fromEntity(entity) }}

    override suspend fun saveNote(note: Note, deleted: Boolean) {
        noteDataSource.insertNote(noteMapper.toEntity(note, deleted))
    }

    override suspend fun saveNotes(notes: List<Note>, deleted: Boolean) {
        noteDataSource.insertNotes(noteMapper.toEntityList(notes, deleted))
    }
}