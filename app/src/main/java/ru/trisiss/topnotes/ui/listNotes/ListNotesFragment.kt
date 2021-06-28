package ru.trisiss.topnotes.ui.listNotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.trisiss.topnotes.R
import ru.trisiss.topnotes.databinding.FragmentNotesListBinding
import ru.trisiss.topnotes.ui.listNotes.ListNotesFragment.Callback

class ListNotesFragment : Fragment() {

    companion object {
        fun newInstance() = ListNotesFragment()
    }

    val viewModel: ListNotesViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        this.lifecycle.addObserver(viewModel)

        val binding = DataBindingUtil.inflate<FragmentNotesListBinding>(
            inflater,
            R.layout.fragment_notes_list,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        val adapter = ListNotesAdapter(viewModel)
        binding.vm = viewModel
        binding.rvListNotes.layoutManager = LinearLayoutManager(activity)
        binding.rvListNotes.adapter = adapter

        viewModel.listNotes.observe(viewLifecycleOwner, { listNotes ->
            adapter.submitList(listNotes)
        })

        binding.callback = Callback {
            val action = ListNotesFragmentDirections.actionListNotesFragmentToDetailNoteFragment(noteId = -1L)
            findNavController().navigate(action)
        }

        return binding.root
    }

    fun interface Callback {
        fun add()
    }
}