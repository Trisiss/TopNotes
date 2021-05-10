package ru.trisiss.data.local.converter

import androidx.room.TypeConverter
import java.util.*

/**
 * Created by trisiss on 5/10/2021.
 */
internal class DateConverter {

    @TypeConverter
    fun fromTimestamp(timestamp: Long): Calendar {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp
        return calendar
    }

    @TypeConverter
    fun calendarToTimestamp(calendar: Calendar): Long = calendar.timeInMillis
}