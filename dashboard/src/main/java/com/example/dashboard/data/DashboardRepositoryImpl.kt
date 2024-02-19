package com.example.dashboard.data

import com.example.common.domain.Note
import com.example.dashboard.domain.DashboardRepository
import kotlinx.coroutines.flow.Flow

class DashboardRepositoryImpl() : DashboardRepository {
    override fun getDashboardInfo(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }
}