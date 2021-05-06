package ru.trisiss.data.local.provider

import kotlinx.coroutines.InternalCoroutinesApi
import ru.trisiss.data.local.dao.NoteDAO

/**
 * Created by trisiss on 5/4/2021.
 */
class DaoProvider(private val database: DatabaseProvider) {

    @InternalCoroutinesApi
    fun getNoteDao(): NoteDAO =
        database.getInstance().noteDao()

}