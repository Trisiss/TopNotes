package ru.trisiss.topnotes

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.trisiss.data.local.di.localModule
import ru.trisiss.data.repository.di.repositoryModule
import ru.trisiss.domain.di.domainModule
import ru.trisiss.topnotes.di.appModule

/**
 * Created by trisiss on 5/6/2021.
 */
class TopNotesApp : Application() {
    override fun onCreate() {
        super.onCreate()

       startKoin {
           androidLogger()
           androidContext(this@TopNotesApp)
           modules(
               appModule +
                       localModule +
                       repositoryModule +
                       domainModule
           )
       }
    }

}