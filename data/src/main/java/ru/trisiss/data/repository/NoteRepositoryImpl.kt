package ru.trisiss.data.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import ru.trisiss.data.local.mapper.NoteMapper
import ru.trisiss.data.repository.datasource.NoteDataSource
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository

/**
 * Created by trisiss on 5/4/2021.
 */
class NoteRepositoryImpl(private val noteDataSource: NoteDataSource, private val noteMapper: NoteMapper): NoteRepository {
    override fun insertOrUpdate(note: Note): Completable {
        TODO("Not yet implemented")
    }

    override fun delete(note: Note): Completable {
        TODO("Not yet implemented")
    }

    override suspend fun getNotes(): List<Note>? =
        noteDataSource.getNotes().map { noteMapper.fromEntity(it) }

    override fun getNote(noteId: Long): Maybe<Note> {
        TODO("Not yet implemented")
    }
}