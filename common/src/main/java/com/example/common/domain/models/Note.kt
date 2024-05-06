package com.example.common.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.common_ui.domain.ui_models.UiNote

@Entity
data class Note(
    @PrimaryKey
    val id: Int? = null,
    val title: String,
    val content: String
)

fun Note.toUiNote(): UiNote {
    return UiNote(
        id = id,
        title = title,
        content = content
    )
}

fun UiNote.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content
    )
}