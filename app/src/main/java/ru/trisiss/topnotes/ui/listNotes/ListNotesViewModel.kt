package ru.trisiss.topnotes.ui.listNotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.trisiss.domain.model.Note

class ListNotesViewModel : ViewModel() {
    private val _clickNote = MutableLiveData<Note>()
    val clickNote: LiveData<Note>
        get() = _clickNote
    private val _listNotes = MutableLiveData<List<Note>>()
    val listNotes: LiveData<List<Note>>
        get() = _listNotes

    init {
        _listNotes.value = getData()
    }

    fun clickNote(note: Note) {
        _clickNote.value = note
    }



    private fun getData(): List<Note> {
        return listOf(
            Note(
                id = 1,
                title = "First note",
                text = "First note",
                dateModification = System.currentTimeMillis()
            ),
            Note(
                id = 2,
                title = "Second note",
                text = "Second note",
                dateModification = System.currentTimeMillis()
            ),
            Note(
                id = 3,
                title = "Three note",
                text = "Three note",
                dateModification = System.currentTimeMillis()
            ),
            Note(
                id = 4,
                title = "Four note",
                text = "Four note",
                dateModification = System.currentTimeMillis()
            ),
            Note(
                id = 5,
                title = "Five note",
                text = "Five note",
                dateModification = System.currentTimeMillis()
            )
        )
    }
}