package ru.trisiss.topnotes.ui.listNotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.trisiss.domain.model.Note
import ru.trisiss.topnotes.R
import ru.trisiss.topnotes.databinding.ViewNoteBinding

class ListNotesAdapter(private val viewModel: ListNotesViewModel, private val fragment: ListNotesFragment) :
    ListAdapter<Note, ListNotesAdapter.ListNotesViewHolder>(NoteDiffCallback) {

    init {
        setHasStableIds(true)
    }

    var tracker: SelectionTracker<Long>? = null

    inner class ListNotesViewHolder(private val binding: ViewNoteBinding) :
        RecyclerView.ViewHolder(binding.root){
        init {
            binding.setClickListener {
                binding.note?.let { note ->
                    navigateToNote(note, it)
                }
            }
        }
        fun bind(note: Note, viewModel: ListNotesViewModel, selected: Boolean) {
            binding.note = note
            binding.vm = viewModel
            binding.layoutNote.isActivated = selected
            binding.executePendingBindings()
        }

        private fun navigateToNote(note: Note, view: View) {
            val action = ListNotesFragmentDirections.actionListNotesFragmentToDetailNoteFragment(noteId = note.id ?: 0L)
            view.findNavController().navigate(action)
        }

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int = bindingAdapterPosition
                override fun getSelectionKey(): Long = getItemId(bindingAdapterPosition)
            }
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNotesViewHolder {
        return ListNotesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.view_note,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListNotesViewHolder, position: Int) {
        val currentNote = getItem(position)
//        holder.bind(currentNote, viewModel)
        tracker?.let {
            holder.bind(currentNote, viewModel, it.isSelected(position.toLong()))
        }
    }

//    override fun submitList(list: List<Note>?) {
//        super.submitList(list?.let { ArrayList(it) })
//    }
}

object NoteDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.dateModification == newItem.dateModification && oldItem.title == newItem.title && oldItem.text == newItem.text
    }
}