package ru.trisiss.topnotes.ui.listNotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.trisiss.domain.model.Note
import ru.trisiss.topnotes.R
import ru.trisiss.topnotes.databinding.FragmentNotesListBinding

class ListNotesFragment : Fragment() {

    companion object {
        fun newInstance() = ListNotesFragment()
    }
//    private lateinit var viewModel: ListNotesViewModel
    val viewModel: ListNotesViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentNotesListBinding>(
            inflater,
            R.layout.fragment_notes_list,
            container,
            false
        )
//        viewModel = ViewModelProvider(this).get(ListNotesViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        val adapter = ListNotesAdapter(viewModel)
        binding.vm = viewModel
        binding.rvListNotes.layoutManager = LinearLayoutManager(activity)
        binding.rvListNotes.adapter = adapter

        viewModel.clickNote.observe(viewLifecycleOwner, { note ->
            showMessage(note)
        })

        viewModel.listNotes.observe(viewLifecycleOwner, { listNotes ->
            adapter.submitList(listNotes)
        })

        return binding.root
    }

    private fun showMessage(note: Note) {
        Toast.makeText(activity, "Click on ${note.title}", Toast.LENGTH_SHORT).show()
    }

}