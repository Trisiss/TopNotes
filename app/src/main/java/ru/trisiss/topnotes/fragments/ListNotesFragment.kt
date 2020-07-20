package ru.trisiss.topnotes.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.trisiss.topnotes.viewmodels.ListNotesViewModel
import ru.trisiss.topnotes.R

class ListNotesFragment : Fragment() {

    companion object {
        fun newInstance() = ListNotesFragment()
    }

    private lateinit var viewModel: ListNotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ListNotesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}