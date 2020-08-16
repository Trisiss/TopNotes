package ru.trisiss.topnotes.viewmodels

import android.annotation.SuppressLint
import android.view.View
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.trisiss.data.models.Note
import ru.trisiss.topnotes.R.*
import ru.trisiss.topnotes.adapters.ListNotesAdapter

class ListNotesViewModel : ViewModel() {
    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes
    val adapter: ListNotesAdapter = ListNotesAdapter()

    fun setNotesInAdapter(notes: List<Note>) {
        this.adapter.notes = notes
        this.adapter.notifyDataSetChanged()
    }


//    fun onItemClick(index: Int) {
//        val note = getNoteAt(index)
//        selected.value = note
//    }
//
//    fun getNoteAt(index: Int): Note? {
//        if (notes.value?.size ?: 0 > index)
//            return notes.value?.get(index)
//        return null
//    }
}