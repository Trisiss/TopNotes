package ru.trisiss.topnotes.ui.listNotes

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ru.trisiss.domain.model.Note
import ru.trisiss.domain.usecases.note.LoadNotes

class ListNotesViewModel(
    private val loadNotesUseCase: LoadNotes
) : ViewModel() {
    private val _clickNote = MutableLiveData<Pair<View, Note>>()
    val clickNote: LiveData<Pair<View, Note>>
        get() = _clickNote
    private val _listNotes = MutableLiveData<List<Note>>()
    val listNotes: LiveData<List<Note>>
        get() = _listNotes

    init {
        GlobalScope.launch {
            _listNotes.postValue(getData())
        }
    }

    fun clickNote(v: View, note: Note) {
        _clickNote.value = Pair(v, note)
    }


    private suspend fun getData(): List<Note>? {

        return loadNotesUseCase.getNotes()
        //------------------------
//        return listOf(
//            Note(
//                id = 1,
//                title = "First note",
//                text = "First note",
//                dateModification = System.currentTimeMillis()
//            ),
//            Note(
//                id = 2,
//                title = "Second note",
//                text = "Second note",
//                dateModification = System.currentTimeMillis()
//            ),
//            Note(
//                id = 3,
//                title = "Three note",
//                text = "Three note",
//                dateModification = System.currentTimeMillis()
//            ),
//            Note(
//                id = 4,
//                title = "Four note",
//                text = "Four note",
//                dateModification = System.currentTimeMillis()
//            ),
//            Note(
//                id = 5,
//                title = "Five note",
//                text = "Five note",
//                dateModification = System.currentTimeMillis()
//            )
//        )
    }
}