package ru.trisiss.data.local.mapper

import ru.trisiss.data.local.model.NoteEntity
import ru.trisiss.domain.model.Note

/**
 * Maps between Room database entity and model.
 */
class NoteMapper {
    fun fromEntity(from: NoteEntity) = Note(from.id, from.noteTitle, from.noteText, from.timestamp)
    fun toEntity(from: Note, deleted: Boolean = false) = NoteEntity(from.id, from.title, from.text, from.dateModification, deleted)
    fun toEntityList(from: List<Note>, deleted: Boolean = false) = from.map { from ->
        NoteEntity(from.id, from.title, from.text, from.dateModification, deleted)
    }
}