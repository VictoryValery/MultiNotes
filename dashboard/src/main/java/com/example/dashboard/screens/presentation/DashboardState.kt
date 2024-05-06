package com.example.dashboard.screens.presentation

import androidx.compose.runtime.Immutable
import com.example.common_ui.domain.ui_models.UiNote


@Immutable
internal data class DashboardState(
    val userName: String? = null,
    val notes: List<UiNote> = emptyList()
)
