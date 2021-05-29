package ru.trisiss.data.local.mapper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import ru.trisiss.data.local.model.NoteEntity
import ru.trisiss.domain.model.Note

/**
 * Maps between Room database entity and model.
 */
class NoteMapper {
    fun fromEntity(from: NoteEntity) = Note(from.id, from.noteTitle, from.noteText, from.timestamp)
    fun toEntity(from: Note) = NoteEntity(from.id, from.title, from.text, from.dateModification)
    fun convertToNoteLiveData(from: NoteEntity) = MutableLiveData(Note(from.id, from.noteTitle, from.noteText, from.timestamp))
    fun fromEntityLiveData(from: LiveData<NoteEntity>) = Transformations.switchMap(from){convertToNoteLiveData(it)}
}