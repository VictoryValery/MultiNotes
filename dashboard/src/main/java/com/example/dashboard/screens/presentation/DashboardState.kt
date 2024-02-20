package com.example.dashboard.screens.presentation

import com.example.common.domain.models.Note

data class DashboardState(
    val userName: String? = null,
    val notes: List<Note> = emptyList()
)
