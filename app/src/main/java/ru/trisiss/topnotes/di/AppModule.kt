package ru.trisiss.topnotes.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.trisiss.topnotes.ui.detailNote.DetailNoteViewModel
import ru.trisiss.topnotes.ui.listNotes.ListNotesViewModel

/**
 * Created by trisiss on 5/6/2021.
 */
val appModule = module {

    viewModel { ListNotesViewModel(get(), get()) }
    viewModel { params -> DetailNoteViewModel(noteId = params.get(), get(), get()) }
}