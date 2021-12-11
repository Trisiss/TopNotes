package ru.trisiss.topnotes.ui.detailNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.usecases.note.LoadNote
import ru.trisiss.domain.usecases.note.SaveNote
import java.util.*

/**
 * Created by trisiss on 5/13/2021.
 */
class DetailNoteViewModel(
    val noteId: Long,
    private val loadNoteUseCase: LoadNote,
    private val saveNoteUseCase: SaveNote
) : ViewModel() {
    private var tempNote: Note? = null
    private var _note = MutableStateFlow<Note?>(null)
    val note: StateFlow<Note?>
        get() = _note

    init {
        getNote(noteId = noteId)
    }

    private fun getNote(noteId: Long) {
        viewModelScope.launch {
            loadNoteUseCase.getNote(noteId)
                .collect {
                    _note.value = it
                    tempNote = it?.copy()
                }
        }
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
        _note.value?.let { saveNoteUseCase.saveNote(it) }
    }
}