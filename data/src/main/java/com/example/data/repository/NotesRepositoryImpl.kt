package com.example.data.repository

import com.example.common.domain.models.toNote
import com.example.common.domain.models.toUiNote
import com.example.common_ui.domain.ui_models.UiNote
import com.example.data.storage.notes.NotesDao
import com.example.domain.repositories.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NotesRepositoryImpl(
    private val dao: NotesDao
) : NotesRepository {

    override fun getNotes(): Flow<List<UiNote>> {
        return dao.getNotes().map { notes ->
            notes.map { it.toUiNote() }
        }
    }

    override suspend fun getNoteById(id: Int): UiNote? {
        return dao.getNoteById(id)?.toUiNote()
    }

    override suspend fun insertNote(note: UiNote): Boolean {
        return runCatching {
            dao.noteWithTitle(note.title)
        }.fold(
            onSuccess = {
                if (it != null) {
                    false
                } else {
                    dao.insertNote(note.toNote())
                    true
                }
            },
            onFailure = {
                throw IllegalArgumentException(it)
            }
        )
    }

    override suspend fun deleteNote(note: UiNote) {
        dao.deleteNote(note.toNote())
    }
}