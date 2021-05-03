package ru.trisiss.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Room-specific Note Entity data type.
 */
@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "note_text") val noteText: String,
    @ColumnInfo(name = "note_title") val noteTitle: String,
    @ColumnInfo(name = "timestamp") val timestamp: Long)