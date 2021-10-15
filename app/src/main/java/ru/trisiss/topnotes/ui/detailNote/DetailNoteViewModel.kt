package ru.trisiss.topnotes.ui.detailNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.usecases.note.AddNote
import ru.trisiss.domain.usecases.note.LoadNote
import java.util.*

/**
 * Created by trisiss on 5/13/2021.
 */
class DetailNoteViewModel(
    val noteId: Long,
    private val loadNoteUseCase: LoadNote,
    private val addNoteUseCase: AddNote
) : ViewModel() {
    private var _note = MutableLiveData<Note?>(null)
    private var tempNote: Note? = null
    val note: LiveData<Note?>
        get() = _note

    init {
        viewModelScope.launch {
            _note.postValue(getNote(noteId))
        }
    }

    private suspend fun getNote(noteId: Long): Note? {
        var note: Note? = null
        val job = viewModelScope.launch {
            note = loadNoteUseCase.getNote(noteId)
        }
        job.join()
        tempNote = note?.copy()
        return note
    }

    fun saveNote(newNote: Note?) {
        if (newNote != null) {
            _note.value = newNote
        }
        if (tempNote?.equals(_note.value) == true) return
        viewModelScope.launch {
            saveNoteAsync()
        }
    }

    private suspend fun saveNoteAsync() {
        _note.value?.dateModification = Calendar.getInstance()
        _note.value?.let { addNoteUseCase.addNote(it) }
    }
}