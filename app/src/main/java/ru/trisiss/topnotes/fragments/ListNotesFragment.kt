package ru.trisiss.topnotes.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import ru.trisiss.data.models.Note
import ru.trisiss.topnotes.viewmodels.ListNotesViewModel
import ru.trisiss.topnotes.R
import ru.trisiss.topnotes.adapters.ListNotesAdapter
import ru.trisiss.topnotes.databinding.FragmentNotesListBinding

class ListNotesFragment : Fragment() {

    companion object {
        fun newInstance() = ListNotesFragment()
    }
    private lateinit var binding: FragmentNotesListBinding
    private val viewModel: ListNotesViewModel by lazy { ViewModelProviders.of(this).get(ListNotesViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.rvListNotes.adapter = viewModel.adapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val listNotes = listOf<Note>(Note(id = 1, title = "First note", text = "First note", dateModification = "2020-07-27"),
            Note(id = 1, title = "First note", text = "First note", dateModification = "2020-07-27"),
            Note(id = 1, title = "First note", text = "First note", dateModification = "2020-07-27"),
            Note(id = 1, title = "First note", text = "First note", dateModification = "2020-07-27"),
            Note(id = 1, title = "First note", text = "First note", dateModification = "2020-07-27"))
        viewModel.setNotesInAdapter(listNotes)
        // TODO: Use the ViewModel

    }

}