package ru.trisiss.domain.model

import java.util.*

/**
 * Represents Data model
 */
//@Serializable
data class Note (
    val id: Long,
    val title: String,
    val text: String,
    val dateModification: Calendar
)