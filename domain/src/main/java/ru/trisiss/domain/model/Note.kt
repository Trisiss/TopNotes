package ru.trisiss.domain.model

/**
 * Represents Data model
 */
//@Serializable
data class Note (
    val id: Long,
    val title: String,
    val text: String,
    val dateModification: Long
) {
    fun isValidForEdit() = id > 0 && text.trim().length > 3

    fun isValidForAdd() = text.trim().length > 3
}