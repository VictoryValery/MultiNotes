package com.example.dashboard.domain

import com.example.common.domain.Note
import kotlinx.coroutines.flow.Flow

interface DashboardRepository {
    fun getDashboardInfo(): Flow<List<Note>>
    suspend fun deleteNote(note: Note)
}