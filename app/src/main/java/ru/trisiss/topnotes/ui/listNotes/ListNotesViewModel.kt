package ru.trisiss.topnotes.ui.listNotes

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.usecases.note.LoadNote
import ru.trisiss.domain.usecases.note.SaveNote

class ListNotesViewModel(
    private val loadNotesUseCase: LoadNote,
    private val saveNoteUseCase: SaveNote
) : ViewModel(), LifecycleObserver {
    private val _listNotes = MutableStateFlow<List<Note>>(emptyList())
    val listNotes: StateFlow<List<Note>>
        get() = _listNotes

    init {
        getData()
    }

    fun getData() {
        viewModelScope.launch {
            loadNotesUseCase.getNotes()
                .collect {
                    _listNotes.value = it
                }
        }
    }

    fun markDeletedNote(notes: List<Note>) {
        viewModelScope.launch {
            markDeletedNoteAsync(notes)
        }
        _listNotes.value = listNotes.value.filter { !notes.contains(it) }
    }

    private suspend fun markDeletedNoteAsync(notes: List<Note>) {
        saveNoteUseCase.saveNotes(notes, true)
    }
}