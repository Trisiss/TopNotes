package ru.trisiss.data.repository.di

import org.koin.dsl.module
import ru.trisiss.data.repository.NoteRepositoryImpl
import ru.trisiss.domain.repository.NoteRepository

/**
 * Created by trisiss on 5/9/2021.
 */
val repositoryModule = module {

    // Repositories
    single<NoteRepository> { NoteRepositoryImpl(get(), get()) }
}