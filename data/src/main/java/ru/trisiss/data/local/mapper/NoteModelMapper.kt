package ru.trisiss.data.local.mapper

import ru.trisiss.data.local.model.NoteEntity
import ru.trisiss.domain.model.Note

/**
 * Maps between Room database entity and model.
 */
class NoteModelMapper {
    fun fromEntity(from: NoteEntity) = Note(from.id, from.noteTitle, from.noteText, from.timestamp)
    fun toEntity(from: Note) = NoteEntity(from.id, from.title, from.text, from.dateModification)
}