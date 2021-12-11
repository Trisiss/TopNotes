package ru.trisiss.topnotes.ui.listNotes

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.usecases.note.LoadNotes
import ru.trisiss.domain.usecases.note.SaveNote

class ListNotesViewModel(
    private val loadNotesUseCase: LoadNotes,
    private val saveNoteUseCase: SaveNote
) : ViewModel(), LifecycleObserver {
    private val _listNotes = MutableLiveData<List<Note>>()
    val listNotes: LiveData<List<Note>>
        get() = _listNotes

    init {
        loadData()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun loadData() {
        viewModelScope.launch {
            _listNotes.postValue(getData())
        }
    }

    private suspend fun getData(): List<Note>? {
        return loadNotesUseCase.getNotes()
    }

    fun markDeletedNote(notes: List<Note>) {
        viewModelScope.launch {
            markDeletedNoteAsync(notes)
        }
        _listNotes.value = listNotes.value?.filter { !notes.contains(it) }
    }

    private suspend fun markDeletedNoteAsync(notes: List<Note>) {
        saveNoteUseCase.saveNotes(notes, true)
    }
}