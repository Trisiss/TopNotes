package ru.trisiss.topnotes.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ru.trisiss.data.models.Note
import ru.trisiss.topnotes.BR
import ru.trisiss.topnotes.databinding.ViewNoteBinding
import ru.trisiss.topnotes.viewmodels.ListNotesViewModel


class ListNotesAdapter() :
    RecyclerView.Adapter<ListNotesAdapter.ListNotesViewHolder>() {
    var notes: List<Note> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListNotesViewHolder {

        return ListNotesViewHolder(ViewNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ListNotesViewHolder, position: Int) {
        val viewModel: ListNotesViewModel = ListNotesViewModel()
        holder.bind(viewModel = viewModel, position = position)
    }

    class ListNotesViewHolder(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(viewModel: ListNotesViewModel, position: Int) {
//            binding.setVariable(BR.viewmodel, viewModel)
//            binding.setVariable(BR.position, position)
//            binding.executePendingBindings()
        }
    }

}