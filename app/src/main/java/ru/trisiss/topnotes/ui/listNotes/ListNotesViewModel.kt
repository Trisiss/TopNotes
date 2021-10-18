package ru.trisiss.topnotes.ui.listNotes

import androidx.lifecycle.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.usecases.note.AddNote
import ru.trisiss.domain.usecases.note.LoadNotes

class ListNotesViewModel(
    private val loadNotesUseCase: LoadNotes,
    private val addNoteUseCase: AddNote
) : ViewModel(), LifecycleObserver {
    private val _listNotes = MutableLiveData<List<Note>>()
    val listNotes: LiveData<List<Note>>
        get() = _listNotes

    init {
        GlobalScope.launch {
            _listNotes.postValue(getData())
        }
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
    }

    private suspend fun markDeletedNoteAsync(notes: List<Note>) {
        addNoteUseCase.addNote(notes, true)
    }
}