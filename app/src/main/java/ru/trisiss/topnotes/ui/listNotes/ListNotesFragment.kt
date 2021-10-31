package ru.trisiss.topnotes.ui.listNotes

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.view.ActionMode
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.LinearLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.trisiss.topnotes.R
import ru.trisiss.topnotes.databinding.FragmentNotesListBinding
import ru.trisiss.topnotes.ui.MainActivity

class ListNotesFragment : Fragment(), ActionMode.Callback {

    companion object {
        fun newInstance() = ListNotesFragment()
    }

    val viewModel: ListNotesViewModel by viewModel()
    lateinit var binding: FragmentNotesListBinding
    lateinit var tracker: SelectionTracker<Long>
    private var actionMode: ActionMode? = null
    lateinit var adapter: ListNotesAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        this.lifecycle.addObserver(viewModel)

        binding = DataBindingUtil.inflate<FragmentNotesListBinding>(
            inflater,
            R.layout.fragment_notes_list,
            container,
            false
        )
        setHasOptionsMenu(true)

        binding.lifecycleOwner = viewLifecycleOwner
        adapter = ListNotesAdapter(viewModel)
        binding.vm = viewModel
        binding.rvListNotes.layoutManager = LinearLayoutManager(activity)
        binding.rvListNotes.adapter = adapter
        tracker = SelectionTracker.Builder(
            "mySelection",
            binding.rvListNotes,
            NoteItemKeyProvider(binding.rvListNotes),
            NoteLookup(binding.rvListNotes),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()
        adapter.tracker = tracker

        viewModel.listNotes.observe(
            viewLifecycleOwner,
            { listNotes ->
                adapter.submitList(listNotes)
            })

        tracker?.addObserver(
            object : SelectionTracker.SelectionObserver<Long>() {
                override fun onSelectionChanged() {
                    super.onSelectionChanged()

                    Log.e("SelectionTAG", "onSelectionChanged: ${tracker.selection.size()}")

                    if (actionMode == null) {
                        val currentActivity = activity as MainActivity
                        actionMode = currentActivity.startSupportActionMode(this@ListNotesFragment)
                    }

                    val items = tracker.selection.size()
                    if (items > 0) {
                        actionMode?.title = "$items selected"
                    } else {
                        actionMode?.finish()
                    }
                }
            })

        binding.callback = object : Callback {
            override fun add() {
                val action =
                    ListNotesFragmentDirections.actionListNotesFragmentToDetailNoteFragment(noteId = -1L)
                findNavController().navigate(action)
            }
        }

        return binding.root
    }

    interface Callback {
        fun add()
    }

    override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
        mode?.menuInflater?.inflate(R.menu.menu_actions_notes, menu)
        return true
    }

    override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean = true

    override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
        return when (item!!.itemId) {
            R.id.actionDeleteNote -> {
                val selectedNotes = adapter.currentList.filter { tracker.selection.contains(it.id) }
                viewModel.markDeletedNote(selectedNotes)
                mode?.finish()
                true
            }
            else -> {
                false
            }
        }
    }

    override fun onDestroyActionMode(mode: ActionMode?) {
        tracker.clearSelection()
        actionMode = null
    }
}