package com.example.domain.repositories

import com.example.common_ui.domain.ui_models.UiNote
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    fun getNotes(): Flow<List<UiNote>>
    suspend fun getNoteById(id: Int): UiNote?

    suspend fun insertNote(note: UiNote)

    suspend fun deleteNote(note: UiNote)
}