package com.example.note.screens

import androidx.compose.runtime.Immutable

@Immutable
internal data class NoteState(
    val id: Int? = null,
    val title: String = "",
    val content: String = "",
    val titleIsUnique: Boolean? = null,
)
