package ru.trisiss.topnotes.ui.listNotes

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by trisiss on 7/7/2021.
 */
class NoteLookup(private val recyclerView: RecyclerView) : ItemDetailsLookup<Long>() {
    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? =
        recyclerView.findChildViewUnder(e.x, e.y)?.let { (recyclerView.getChildViewHolder(it) as? ListNotesAdapter.ListNotesViewHolder)?.getItemDetails() }
}
