package ru.trisiss.domain.model

import java.util.*

/**
 * Represents Data model
 */
data class Note (
    var id: Long?,
    var title: String,
    var text: String,
    var dateModification: Calendar
)