package ru.trisiss.topnotes.ui.detailNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import ru.trisiss.topnotes.R
import ru.trisiss.topnotes.databinding.FragmentDetailNoteBinding

/**
 * A simple [Fragment] subclass.
 * Use the [DetailNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailNoteFragment : Fragment() {

    private val args: DetailNoteFragmentArgs by navArgs()
    val viewModel: DetailNoteViewModel by viewModel { parametersOf(args.noteId) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            viewModel.saveNote()
            findNavController().popBackStack()
        }
        callback.isEnabled = true

        val binding = DataBindingUtil.inflate<FragmentDetailNoteBinding>(
            inflater,
            R.layout.fragment_detail_note,
            container,
            false
        )

        binding.lifecycleOwner = viewLifecycleOwner
        binding.vm = viewModel

/*        binding.noteTextDetail.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString() != "") viewModel.saveChanges(binding.noteTextDetail.toString())
            }
        })*/

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment DetailNoteFragment.
         */
        fun newInstance() = DetailNoteFragment()
    }
}