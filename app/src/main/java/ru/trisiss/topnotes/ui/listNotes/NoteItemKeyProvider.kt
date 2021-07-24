package ru.trisiss.topnotes.ui.listNotes

import androidx.recyclerview.selection.ItemKeyProvider
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by trisiss on 7/10/2021.
 */
class NoteItemKeyProvider(private val recyclerView: RecyclerView) :
    ItemKeyProvider<Long>(SCOPE_CACHED) {

    override fun getKey(position: Int): Long? {
        return (recyclerView.adapter as ListNotesAdapter).notes[position].id
    }

    override fun getPosition(key: Long): Int {
        return (recyclerView.adapter as ListNotesAdapter).notes.indexOfFirst { it.id == key }
    }
}