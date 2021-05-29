package ru.trisiss.topnotes.ui.detailNote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.usecases.note.LoadNote

/**
 * Created by trisiss on 5/13/2021.
 */
class DetailNoteViewModel(
    val noteId: Long,
    private val loadNoteUseCase: LoadNote
): ViewModel() {
    private var _note = MutableLiveData<Note?>(null)
    val note: LiveData<Note?>
        get() = _note

    init {
        viewModelScope.launch {
            _note.postValue(getNote(noteId))
        }
    }

    private  suspend fun getNote(noteId: Long): Note? {
        return loadNoteUseCase.getNote(noteId)
    }

}