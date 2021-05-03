package ru.trisiss.data

import ru.trisiss.domain.model.Note
import ru.trisiss.domain.repository.NoteModelMapper

/**
 * Maps between Room database entity and model.
 */
class NoteModelMapperImpl : NoteModelMapper<NoteEntity, Note> {
    override fun fromEntity(from: NoteEntity) = Note(from.id, from.noteTitle, from.noteText, from.timestamp)
    override fun toEntity(from: Note) = NoteEntity(from.id, from.title, from.text, from.dateModification)
}