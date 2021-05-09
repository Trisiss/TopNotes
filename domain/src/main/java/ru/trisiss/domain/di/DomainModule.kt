package ru.trisiss.domain.di

import org.koin.dsl.module
import ru.trisiss.domain.usecases.note.AddNote
import ru.trisiss.domain.usecases.note.LoadNotes
import ru.trisiss.domain.usecases.note.implementation.AddNoteImpl
import ru.trisiss.domain.usecases.note.implementation.LoadNotesImpl

/**
 * Created by trisiss on 5/9/2021.
 */
val domainModule = module {

    // Note Use Case
    factory<AddNote> { AddNoteImpl(get()) }
    factory<LoadNotes> { LoadNotesImpl(get()) }

}