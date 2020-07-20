package ru.trisiss.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Note (
    val id: Int,
    val title: String,
    val text: String,
    val dateModification: String
)