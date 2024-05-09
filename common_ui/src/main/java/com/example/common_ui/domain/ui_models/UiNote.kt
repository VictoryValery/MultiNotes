package com.example.common_ui.domain.ui_models

import androidx.compose.runtime.Immutable

@Immutable
data class UiNote(
    val id: Int? = null,
    val title: String,
    val content: String
)
