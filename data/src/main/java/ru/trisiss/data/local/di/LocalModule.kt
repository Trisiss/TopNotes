package ru.trisiss.data.local.di

import org.koin.dsl.module
import ru.trisiss.data.local.datasource.NoteLocalDataSource
import ru.trisiss.data.local.mapper.NoteMapper
import ru.trisiss.data.local.provider.DaoProvider
import ru.trisiss.data.local.provider.DatabaseProvider
import ru.trisiss.data.repository.datasource.NoteDataSource

/**
 * Created by trisiss on 5/9/2021.
 */
val localModule = module {

    // Data Sources
    single<NoteDataSource> { NoteLocalDataSource(get()) }

    // Mappers
    factory { NoteMapper() }

    // Providers
    single { DaoProvider(get()) }
    single { DatabaseProvider(get()) }
}