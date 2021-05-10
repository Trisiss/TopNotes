package ru.trisiss.topnotes.util

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by trisiss on 5/10/2021.
 */
object DateUtil {

    fun calendarToString(calendar: Calendar): String {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return formatter.format(calendar.time)
    }
}