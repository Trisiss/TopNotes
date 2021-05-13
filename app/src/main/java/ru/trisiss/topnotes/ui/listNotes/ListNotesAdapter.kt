package ru.trisiss.topnotes.ui.listNotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.trisiss.domain.model.Note
import ru.trisiss.topnotes.R
import ru.trisiss.topnotes.databinding.ViewNoteBinding

class ListNotesAdapter(private val viewModel: ListNotesViewModel) :
    ListAdapter<Note, ListNotesAdapter.ListNotesViewHolder>(NoteDiffCallback) {

    class ListNotesViewHolder(private val binding: ViewNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener {
                binding.note?.let { note ->
                    navigateToNote(note, it)
                }
            }
        }
        fun bind(note: Note, viewModel: ListNotesViewModel) {
            binding.note = note
            binding.vm = viewModel
            binding.executePendingBindings()
        }

        private fun navigateToNote(note: Note, view: View) {
            val action = ListNotesFragmentDirections.actionListNotesFragmentToDetailNoteFragment()
            view.findNavController().navigate(action)
        }
    }

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
        holder.bind(currentNote, viewModel)
    }
}

object NoteDiffCallback : DiffUtil.ItemCallback<Note>() {
    override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
        return oldItem.id == newItem.id
    }
}