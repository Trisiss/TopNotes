package ru.trisiss.data

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDAOImpl,
                         private val mapper: NoteModelMapperImpl
) : NoteRepository {

    override fun insertOrUpdate(note: Note): Completable = Completable.fromAction { noteDao.insertOrUpdate(mapper.toEntity(note)) }

    override fun delete(note: Note): Completable = Completable.fromAction { noteDao.delete(mapper.toEntity(note)) }

    override fun getNote(noteId: Long): Maybe<Note> {
        return noteDao.getNote(noteId = noteId)
            .map { mapper.fromEntity(it) }
    }

    override fun getNotes(): Single<List<Note>> {
        return noteDao.getNotes()
            .map { it.map(mapper::fromEntity) }
    }

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: NoteRepositoryImpl? = null

        fun getInstance(noteDao: NoteDAOImpl, mapper: NoteModelMapperImpl) =
            instance ?: synchronized(this) {
                instance ?: NoteRepositoryImpl(noteDao, mapper).also { instance = it }
            }
    }
}