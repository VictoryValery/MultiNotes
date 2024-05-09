package com.example.common_ui.domain.ui_models

import androidx.compose.runtime.Immutable

@Immutable
data class UiUser(
    val name: String,
    val password: String
)
