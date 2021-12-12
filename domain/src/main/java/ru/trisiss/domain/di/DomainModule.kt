package ru.trisiss.domain.di

import org.koin.dsl.module
import ru.trisiss.domain.usecases.note.LoadNote
import ru.trisiss.domain.usecases.note.SaveNote
import ru.trisiss.domain.usecases.note.implementation.LoadNoteImpl
import ru.trisiss.domain.usecases.note.implementation.SaveNoteImpl

/**
 * Created by trisiss on 5/9/2021.
 */
val domainModule = module {

    // Note Use Case
    factory<SaveNote> { SaveNoteImpl(get()) }
    factory <LoadNote> { LoadNoteImpl(get()) }

}